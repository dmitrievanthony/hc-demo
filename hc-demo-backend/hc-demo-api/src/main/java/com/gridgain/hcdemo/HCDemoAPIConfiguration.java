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

import com.gridgain.hcdemo.api.BureauAPI;
import com.gridgain.hcdemo.model.Application;
import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import com.gridgain.hcdemo.model.CreditCardBalance;
import com.gridgain.hcdemo.model.InstallmentPayment;
import com.gridgain.hcdemo.model.POSCashBalance;
import com.gridgain.hcdemo.model.PreviousApplication;
import java.util.List;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.DiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.TcpDiscoveryIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.kubernetes.TcpDiscoveryKubernetesIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class HCDemoAPIConfiguration {

    @Bean
    public IgniteCache<Long, Application> applicationCache(Ignite ignite) {
        return ignite.cache("Application");
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, Bureau> bureauCache(Ignite ignite) {
        return ignite.cache("Bureau");
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, BureauBalance> bureauBalanceCache(Ignite ignite) {
        return ignite.cache("BureauBalance");
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, CreditCardBalance> creditCardBalanceCache(Ignite ignite) {
        return ignite.cache("CreditCardBalance");
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, InstallmentPayment> installmentPaymentCache(Ignite ignite) {
        return ignite.cache("InstallmentPayment");
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, POSCashBalance> posCashBalanceCache(Ignite ignite) {
        return ignite.cache("POSCashBalance");
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, PreviousApplication> previousApplicationCache(Ignite ignite) {
        return ignite.cache("PreviousApplication");
    }

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
    public TcpDiscoveryIpFinder ipFinder(@Value("#{'${com.gridgain.hcdemo.local.ignite.hosts}'.split(',')}") List<String> addresses) {
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();

        ipFinder.setAddresses(addresses);

        return ipFinder;
    }
}
