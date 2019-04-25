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

public class FieldCalculator<T> implements Function<T, Map<String, Double>> {

    private final String fieldName;

    private final Function<T, Double> calculator;

    public FieldCalculator(String fieldName, Function<T, Double> calculator) {
        this.fieldName = fieldName;
        this.calculator = calculator;
    }

    public <E> FieldCalculator(String fieldName, Function<T, E> extractor, Function<E, Double> doublerizer, E value, Double replacement) {
        this.fieldName = fieldName;

        this.calculator = obj -> {
            E fieldValue = extractor.apply(obj);

            if (fieldValue == null)
                return Double.NaN;

            if (fieldValue.equals(value))
                return replacement;

            return doublerizer.apply(fieldValue);
        };
    }

    public <E extends Number> FieldCalculator(String fieldName, Function<T, E> extractor, E value, Double replacement) {
        this(
            fieldName,
            extractor,
            e -> Double.valueOf(e.doubleValue()),
            value,
            replacement
        );
    }

    @Override public Map<String, Double> apply(T t) {
        Map<String, Double> res = new HashMap<>();

        res.put(fieldName, calculator.apply(t));

        return res;
    }
}
