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
import com.gridgain.hcdemo.model.Application;
import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import com.gridgain.hcdemo.model.CreditCardBalance;
import com.gridgain.hcdemo.model.Identifiable;
import com.gridgain.hcdemo.model.InstallmentPayment;
import com.gridgain.hcdemo.model.POSCashBalance;
import com.gridgain.hcdemo.model.PreviousApplication;
import com.gridgain.hcdemo.preprocessor.Preprocessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private HcDemoModelConfigurationProperties properties;

    public <K extends Serializable, T extends Identifiable<K>> void loadCSV(String[] resources, Class<T> clazz,
        Preprocessor<T> preprocessor, IgniteCache<K, T> cache) throws IOException {
        loadCSV(resources, clazz, preprocessor, (Map<K, T> batch) -> cache.putAll(batch));
    }

    public <K extends Serializable, T extends Identifiable<K>> void loadCSV(String[] resources, Class<T> clazz,
        Preprocessor<T> preprocessor, Consumer<Map<K, T>> batchConsumer) throws IOException {
        log.info("Start loading data [resource=" + Arrays.toString(resources) + "]");



        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true);

        long row = 0;
        for (String resource : resources) {
            try (InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(resource);
                 ZipInputStream zis = new ZipInputStream(is)) {
                ZipEntry entry = zis.getNextEntry();

                log.info("Processing zip entry [entry=" + entry.getName() + "]");

                MappingIterator<T> objects = mapper
                    .readerWithSchemaFor(clazz)
                    .with(schema)
                    .readValues(zis);

                Map<K, T> batch = new LinkedHashMap<>();
                int batchNumber = 0;
                while (objects.hasNext()) {
                    if (properties.getRowsToBeLoaded() != -1 && properties.getRowsToBeLoaded() == row)
                        break;

                    T object = objects.next();
                    object = preprocessor.preprocess(object);
                    batch.put(object.key(), object);

                    row++;

                    if (batch.size() == properties.getBatchSize()) {

                        batchConsumer.accept(batch);
                        batch.clear();

                        log.info("Data is loading [resource=" + resource + ", batch=" + batchNumber + "]");

                        batchNumber++;
                    }
                }

                if (!batch.isEmpty())
                    batchConsumer.accept(batch);
            }
        }

        log.info("Data has been loaded [resource=" + Arrays.toString(resources) + ", rows=" + row + "]");
    }
}
