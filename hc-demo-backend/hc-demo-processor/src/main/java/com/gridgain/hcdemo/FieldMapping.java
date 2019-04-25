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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldMapping {

    private static final Logger log = LoggerFactory.getLogger(FieldMapping.class);

    private final int BASE_INDEX = 0;

    private final Map<String, String> mapping;

    public FieldMapping(String resource) {
        mapping = Collections.unmodifiableMap(readMappingFromCSV(resource));
    }

    private Map<String, String> readMappingFromCSV(String resource) {
        Map<String, String> fieldMapping = new HashMap<>();

        int idx = BASE_INDEX;
        try (InputStream is = ApplicationHandler.class.getClassLoader().getResourceAsStream(resource)) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fieldMapping.put(line, String.valueOf(idx));
                idx++;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fieldMapping;
    }

    public <T> Map<String, T> map(Map<String, T> map) {
        Map<String, T> res = new HashMap<>();

        for (Map.Entry<String, T> e : map.entrySet()) {
            String fieldName = e.getKey();
            T fieldValue = e.getValue();

            if (contains(fieldName)) {
                res.put(map(fieldName), fieldValue);
            }
        }

        return res;
    }

    public String map(String fieldName) {
        return mapping.get(fieldName);
    }

    public boolean contains(String fieldName) {
        return mapping.containsKey(fieldName);
    }

    public Iterable<String> keys() {
        return mapping.keySet();
    }

    public Map<String, Double> emptyVector() {
        Map<String, Double> res = new HashMap<>();

        for (String fieldName : mapping.values())
            res.put(fieldName, Double.NaN);

        return res;
    }
}
