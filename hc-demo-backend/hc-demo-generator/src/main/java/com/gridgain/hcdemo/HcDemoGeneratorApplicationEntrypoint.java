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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.IgniteQueue;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.lang.IgniteFuture;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HcDemoGeneratorApplicationEntrypoint {

    private static final Logger log = LoggerFactory.getLogger(HcDemoGeneratorApplicationEntrypoint.class);

    private static final String INFERENCE_TABLE_NAME = "inference";

    private static final String THROUGHPUT_FIELD_NAME = "throughput";

    @Autowired
    private Ignite ignite;

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private ApplicationPreprocessor applicationPreprocessor;

    @Autowired
    private InfluxDB influxDB;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws IOException {
        IgniteQueue<String> msgQueue = MessageQueue.get(ignite);
        String msg = msgQueue.take();
        if(!msg.equals(MessageQueue.START_MSG))
            throw new RuntimeException("Illegal message: " + msg);

        while (true) {
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
    }

    private void processBatch(Map<Long, Application> batch) {
        IgniteCompute compute = ignite.compute();

        long start = System.currentTimeMillis();

        List<IgniteFuture<Void>> futures = new ArrayList<>();
        for (Application application : batch.values()) {
            if ("XNA".equals(application.getCodeGender()))
                continue;

            IgniteFuture<Void> future = compute.affinityRunAsync(
                "Application",
                application.key(),
                new ApplicationHandler(application)
            );

            futures.add(future);
        }

        for (IgniteFuture<Void> future : futures)
            future.get();

        long end = System.currentTimeMillis();

        influxDB.write(Point.measurement(INFERENCE_TABLE_NAME)
            .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
            .addField(THROUGHPUT_FIELD_NAME, 1000.0 * batch.size() / (end - start))
            .build());

        log.info("Application batch processed [throughput=" + 1000.0 * batch.size() / (end - start) + "ops/sec]");
    }
}
