/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gridgain.hcdemo;

import com.gridgain.hcdemo.model.Application;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteLogger;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.DiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.TcpDiscoveryIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.kubernetes.TcpDiscoveryKubernetesIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sun.misc.IOUtils;

@Configuration
public class HcDemoGeneratorApplicationConfiguration {

    @Bean(destroyMethod = "close")
    public Ignite ignite(IgniteConfiguration config) {
        return Ignition.start(config);
    }

    @Bean
    public IgniteConfiguration config(DiscoverySpi discoverySpi) {
        IgniteConfiguration config = new IgniteConfiguration();

        config.setDiscoverySpi(discoverySpi);
        config.setClientMode(true);

        return config;
    }

    @Bean
    public DiscoverySpi discoverySpi(TcpDiscoveryIpFinder ipFinder) {
        TcpDiscoverySpi discovery = new TcpDiscoverySpi();

        discovery.setIpFinder(ipFinder);

        return discovery;
    }

    @Bean
    @Profile("kubernetes")
    public TcpDiscoveryIpFinder ipFinder() {
        return new TcpDiscoveryKubernetesIpFinder();
    }

    @Bean
    @Profile("!kubernetes")
    public TcpDiscoveryIpFinder ipFinder(
        @Value("#{'${com.gridgain.hcdemo.local.ignite.hosts}'.split(',')}") List<String> addresses) {
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();

        ipFinder.setAddresses(addresses);

        return ipFinder;
    }

    @Bean
    public InfluxDB influxDB(@Value("com.gridgain.hcdemo.influx.url") String influxUrl,
        @Value("com.gridgain.hcdemo.influx.username") String influxUsername,
        @Value("com.gridgain.hcdemo.influx.password") String influxPassword,
        @Value("com.gridgain.hcdemo.influx.database") String influxDatabase) {
        InfluxDB influxDB = InfluxDBFactory.connect(influxUrl, influxUsername, influxPassword);
        influxDB.query(new Query("CREATE DATABASE " + influxDatabase));
        influxDB.setDatabase(influxDatabase);

        String rpName = "aRetentionPolicy";
        influxDB.query(new Query("CREATE RETENTION POLICY " + rpName + " ON " + influxDatabase
            + " DURATION 30h REPLICATION 2 SHARD DURATION 30m DEFAULT"));
        influxDB.setRetentionPolicy(rpName);
        influxDB.enableBatch(BatchOptions.DEFAULTS);

        return influxDB;
    }
}
