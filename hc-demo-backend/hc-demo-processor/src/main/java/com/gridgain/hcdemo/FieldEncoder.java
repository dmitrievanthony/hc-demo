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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FieldEncoder<T> implements Function<T, Map<String, Double>> {

    private final Function<T, String> extractor;

    private final String fieldName;

    private final Map<String, Double> dict = new HashMap<>();

    public FieldEncoder(Function<T, String> extractor, String fieldName) {
        this.extractor = extractor;
        this.fieldName = fieldName;
    }

    public FieldEncoder<T> withEncoding(String val, Double res) {
        dict.put(val, res);
        return this;
    }

    @Override public Map<String, Double> apply(T t) {
        String fieldValue = extractor.apply(t);

        Map<String, Double> res = new HashMap<>();
        Double resVal = dict.get(fieldValue);

        if (resVal == null)
            throw new IllegalArgumentException("Unknown field value [field=" + fieldName + ", value=" + fieldValue + "]");


        res.put(fieldName, resVal);

        return res;
    }
}
