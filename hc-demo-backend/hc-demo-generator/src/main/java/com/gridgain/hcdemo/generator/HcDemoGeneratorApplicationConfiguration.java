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

package com.gridgain.hcdemo.generator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteLogger;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.logger.slf4j.Slf4jLogger;
import org.apache.ignite.ml.inference.Model;
import org.apache.ignite.ml.inference.builder.AsyncModelBuilder;
import org.apache.ignite.ml.inference.builder.IgniteDistributedModelBuilder;
import org.apache.ignite.ml.inference.reader.InMemoryModelReader;
import org.apache.ignite.ml.inference.reader.ModelReader;
import org.apache.ignite.ml.inference.reader.ModelStorageModelReader;
import org.apache.ignite.ml.inference.storage.model.ModelStorage;
import org.apache.ignite.ml.inference.storage.model.ModelStorageFactory;
import org.apache.ignite.ml.math.primitives.vector.NamedVector;
import org.apache.ignite.ml.util.plugin.MLPluginConfiguration;
import org.apache.ignite.ml.xgboost.parser.XGBoostModelParser;
import org.apache.ignite.ml.xgboost.parser.XGModelParser;
import org.apache.ignite.spi.discovery.DiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.TcpDiscoveryIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.misc.IOUtils;

@Configuration
public class HcDemoGeneratorApplicationConfiguration {

    private static final Logger log = LoggerFactory.getLogger(HcDemoGeneratorApplicationConfiguration.class);

    @Bean(destroyMethod = "close")
    public Model<NamedVector, Future<Double>> model(AsyncModelBuilder modelBuilder, ModelReader reader, XGModelParser parser) {
        return modelBuilder.build(reader, parser);
    }

    @Bean
    public AsyncModelBuilder asyncModelBuilder(Ignite ignite, @Value("${inference.instances:4}") int instances) {
        return new IgniteDistributedModelBuilder(ignite, instances, instances);
    }

    @Bean
    public ModelReader modelReader(ModelStorage modelStorage, @Value("${inference.model:agaricus-model.txt}") String modelResource) {
        try (InputStream is = HcDemoGeneratorApplicationConfiguration.class.getClassLoader().getResourceAsStream(modelResource)) {
            byte[] model = IOUtils.readFully(is, -1, false);

            String path = "/hc/agaricus-model.txt";

            modelStorage.mkdirs("/hc");
            modelStorage.putFile(path, model);

            log.debug("Model saved into model storage [path=" + path + "]");

            return new ModelStorageModelReader(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public XGModelParser modelParser() {
        return new XGModelParser();
    }

    @Bean
    public ModelStorage modelStorage(Ignite ignite) {
        return new ModelStorageFactory().getModelStorage(ignite);
    }

    @Bean(destroyMethod = "close")
    public Ignite ignite(IgniteConfiguration config) {
        return Ignition.start(config);
    }

    @Bean
    public IgniteConfiguration config(DiscoverySpi discoverySpi, IgniteLogger logger, MLPluginConfiguration mlPluginConfiguration) {
        IgniteConfiguration config = new IgniteConfiguration();

        config.setDiscoverySpi(discoverySpi);
        config.setGridLogger(logger);
        config.setClientMode(true);
        config.setPluginConfigurations(mlPluginConfiguration);

        return config;
    }

    @Bean
    public MLPluginConfiguration mlPluginConfiguration() {
        MLPluginConfiguration configuration = new MLPluginConfiguration();

        configuration.setMdlStorageBackups(2);
        configuration.setWithMdlStorage(true);

        return configuration;
    }

    @Bean
    public DiscoverySpi discoverySpi(TcpDiscoveryIpFinder ipFinder) {
        TcpDiscoverySpi discovery = new TcpDiscoverySpi();

        discovery.setIpFinder(ipFinder);

        return discovery;
    }

    @Bean
    public TcpDiscoveryIpFinder ipFinder(@Value("#{'${ignite.hosts}'.split(',')}") List<String> addresses) {
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();

        ipFinder.setAddresses(addresses);

        return ipFinder;
    }

    @Bean
    public IgniteLogger logger() {
        return new Slf4jLogger(log);
    }
}
