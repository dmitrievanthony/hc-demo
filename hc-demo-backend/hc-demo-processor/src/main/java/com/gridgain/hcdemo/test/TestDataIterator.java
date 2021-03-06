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

package com.gridgain.hcdemo.test;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataIterator implements AutoCloseable, Iterator<Map<String, Double>> {

    private static final Logger log = LoggerFactory.getLogger(TestDataIterator.class);

    private final Set<String> fieldToBeExcluded = new HashSet<String>(){{
        add("");
        add("index");
    }};

    private final InputStream inputStream;

    private final MappingIterator<Map<String, String>> iterator;

    public TestDataIterator(String resource) {
        InputStream inputStream = TestDataIterator.class.getClassLoader().getResourceAsStream(resource);
        ZipInputStream zis = new ZipInputStream(inputStream);
        this.inputStream = new ZipInputStream(inputStream);

        try {
            ZipEntry entry = zis.getNextEntry();

            log.info("Processing zip entry [entry=" + entry.getName() + "]");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        try {
            iterator = mapper.readerFor(Map.class).with(schema).readValues(inputStream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override public Map<String, Double> next() {
        Map<String, Double> res = new HashMap<>();

        for (Map.Entry<String, String> e : iterator.next().entrySet()) {
            String fieldName = e.getKey();
            String fieldValue = e.getValue();

            if (fieldToBeExcluded.contains(fieldName))
                continue;

            if (!fieldValue.isEmpty())
                res.put(fieldName, Double.valueOf(fieldValue));
        }

        return res;
    }

    @Override public void close() throws Exception {
        inputStream.close();
    }
}
