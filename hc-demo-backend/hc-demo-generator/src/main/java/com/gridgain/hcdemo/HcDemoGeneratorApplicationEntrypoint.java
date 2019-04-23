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

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gridgain.hcdemo.DataLoader;
import com.gridgain.hcdemo.model.Application;
import com.gridgain.hcdemo.preprocessor.ApplicationPreprocessor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.configuration.CacheConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HcDemoGeneratorApplicationEntrypoint {

    private static final Logger log = LoggerFactory.getLogger(HcDemoGeneratorApplicationEntrypoint.class);

    @Autowired
    private Ignite ignite;

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private ApplicationPreprocessor applicationPreprocessor;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws IOException {
        dataLoader.loadCSV(
            new String[]{
                "data/application_train00.csv.zip",
                "data/application_train01.csv.zip"
            },
            Application.class,
            applicationPreprocessor,
            this::processBatch
        );
    }

    private void processBatch(Map<Long, Application> batch) {
        IgniteCompute compute = ignite.compute();

        long start = System.currentTimeMillis();

        for (Application application : batch.values()) {
            compute.affinityRun(
                "Application",
                application.key(),
                new ApplicationHandler(application)
            );
        }

        long end = System.currentTimeMillis();

        log.info("Application batch processed [throughput=" + 1000.0 * batch.size() / (end - start) + "ops/sec]");
    }
}
