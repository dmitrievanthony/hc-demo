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
import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import com.gridgain.hcdemo.model.CreditCardBalance;
import com.gridgain.hcdemo.model.InstallmentPayment;
import com.gridgain.hcdemo.model.POSCashBalance;
import com.gridgain.hcdemo.model.PreviousApplication;
import java.util.Arrays;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataRegionConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HcDemoIgniteServerConfiguration {

    @Bean(destroyMethod = "close")
    public Ignite ignite(IgniteConfiguration configuration) {
        return Ignition.start(configuration);
    }

    @Bean
    public IgniteConfiguration configuration() {
        IgniteConfiguration configuration = new IgniteConfiguration();

        DataStorageConfiguration dsc = new DataStorageConfiguration();
        DataRegionConfiguration drc = new DataRegionConfiguration();
        drc.setMaxSize(8L * 1024 * 1024 * 1024);

        dsc.setDefaultDataRegionConfiguration(drc);
        configuration.setDataStorageConfiguration(dsc);


        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        ipFinder.setAddresses(Arrays.asList("localhost"));

        TcpDiscoverySpi discovery = new TcpDiscoverySpi();
        discovery.setIpFinder(ipFinder);

        configuration.setClientMode(false);
        configuration.setDiscoverySpi(discovery);

        return configuration;
    }

    @Bean
    public IgniteCache<Long, Application> applicationCache(Ignite ignite) {
        CacheConfiguration<Long, Application> cc = new CacheConfiguration<>();
        cc.setName("Application");
        cc.setIndexedTypes(Long.class, Application.class);

        return ignite.createCache(cc);
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, Bureau> bureauCache(Ignite ignite) {
        CacheConfiguration<AffinityKey<Long>, Bureau> cc = new CacheConfiguration<>();
        cc.setName("Bureau");
        cc.setIndexedTypes(AffinityKey.class, Bureau.class);

        return ignite.createCache(cc);
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, BureauBalance> bureauBalanceCache(Ignite ignite) {
        CacheConfiguration<AffinityKey<Long>, BureauBalance> cc = new CacheConfiguration<>();
        cc.setName("BureauBalance");
        cc.setIndexedTypes(AffinityKey.class, BureauBalance.class);

        return ignite.createCache(cc);
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, CreditCardBalance> creditCardBalanceCache(Ignite ignite) {
        CacheConfiguration<AffinityKey<Long>, CreditCardBalance> cc = new CacheConfiguration<>();
        cc.setName("CreditCardBalance");
        cc.setIndexedTypes(AffinityKey.class, CreditCardBalance.class);

        return ignite.createCache(cc);
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, InstallmentPayment> installmentPaymentCache(Ignite ignite) {
        CacheConfiguration<AffinityKey<Long>, InstallmentPayment> cc = new CacheConfiguration<>();
        cc.setName("InstallmentPayment");
        cc.setIndexedTypes(AffinityKey.class, InstallmentPayment.class);

        return ignite.createCache(cc);
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, POSCashBalance> posCashBalanceCache(Ignite ignite) {
        CacheConfiguration<AffinityKey<Long>, POSCashBalance> cc = new CacheConfiguration<>();
        cc.setName("POSCashBalance");
        cc.setIndexedTypes(AffinityKey.class, POSCashBalance.class);

        return ignite.createCache(cc);
    }

    @Bean
    public IgniteCache<AffinityKey<Long>, PreviousApplication> previousApplicationCache(Ignite ignite) {
        CacheConfiguration<AffinityKey<Long>, PreviousApplication> cc = new CacheConfiguration<>();
        cc.setName("PreviousApplication");
        cc.setIndexedTypes(AffinityKey.class, PreviousApplication.class);

        return ignite.createCache(cc);
    }
}