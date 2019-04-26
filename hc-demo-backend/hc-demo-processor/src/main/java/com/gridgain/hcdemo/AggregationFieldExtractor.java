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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AggregationFieldExtractor {

    private static final long SCALE = 1_000_000;

    private final FieldExtractor fieldExtractor;

    public AggregationFieldExtractor(FieldExtractor fieldExtractor) {
        this.fieldExtractor = fieldExtractor;
    }

    public Map<String, Double> extract(String prefix, List<?> delegates) {
        Map<String, List<Double>> aggregatedFields = new HashMap<>();

        for (Object delegate : delegates) {
            for (Map.Entry<String, Double> field : fieldExtractor.extract(prefix, delegate).entrySet()) {
                String fieldName = field.getKey();
                Double fieldValue = field.getValue();

                if (!aggregatedFields.containsKey(fieldName))
                    aggregatedFields.put(fieldName, new ArrayList<>());

                aggregatedFields.get(fieldName).add(fieldValue);
            }
        }

        return aggregate(prefix, aggregatedFields);
    }

    private Map<String, Double> aggregate(String prefix, Map<String, List<Double>> aggregatedFields) {
        Map<String, Double> res = new HashMap<>();

        for (Map.Entry<String, List<Double>> e : aggregatedFields.entrySet()) {
            String fieldName = e.getKey();
            List<Double> fieldValues = e.getValue();

            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "MIN"), calculateMin(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "MAX"), calculateMax(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "MEAN"), calculateMean(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "VAR"), calculateVar(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "MOD"), calculateMod(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "MEDI"), calculateMedi(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "COUNT"), calculateCount(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "SIZE"), calculateCount(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "SUM"), calculateSum(fieldValues));
            res.put(withPrefixAndSuffix(prefix + "_" + fieldName, "NUNIQUE"), calculateNUnique(fieldValues));

        }

        return res;
    }

    private String withPrefixAndSuffix(String fieldName, String suffix) {
        if (fieldName.endsWith(suffix))
            return fieldName;

        return fieldName + "_" + suffix;
    }

    private Double calculateMod(List<Double> values) {
        Map<Long, Integer> hist = new HashMap<>();

        for (Double value : values) {
            Long longValue = (long) (value * SCALE);
            if (!hist.containsKey(longValue))
                hist.put(longValue, 0);

            hist.put(longValue, hist.get(longValue) + 1);
        }

        double res = Double.NaN;
        Integer resCount = 0;

        for (Map.Entry<Long, Integer> e : hist.entrySet()) {
            Integer count = e.getValue();
            if (count > resCount) {
                resCount = count;
                res = e.getKey().doubleValue() / SCALE;
            }
        }

        return res;
    }

    private Double calculateSum(List<Double> values) {
        if (values.isEmpty())
            return Double.NaN;

        double res = 0.0;
        for (Double value : values)
            res += value;

        return res;
    }

    private Double calculateNUnique(List<Double> values) {
        Set<Long> set = new HashSet<>();

        for (Double value : values) {
            set.add((long)(value * SCALE));
        }

        return Double.valueOf(set.size());
    }

    private Double calculateCount(List<Double> values) {
        return Double.valueOf(values.size());
    }

    private Double calculateMedi(List<Double> values) {
        if (values.isEmpty())
            return Double.NaN;

        Collections.sort(values);
        int m = values.size() / 2;

        if (values.size() % 2 == 0) {
            return (values.get(m - 1) + values.get(m)) / 2;
        }
        else {
            return values.get(m);
        }
    }

    private Double calculateMin(List<Double> values) {
        if (values.isEmpty())
            return Double.NaN;

        return Collections.min(values);
    }

    private Double calculateMax(List<Double> values) {
        if (values.isEmpty())
            return Double.NaN;

        return Collections.max(values);
    }

    private Double calculateMean(List<Double> values) {
        if (values.isEmpty())
            return Double.NaN;

        double res = 0.0;

        for (Double value : values)
            res += value;

        return res / values.size();
    }

    private Double calculateVar(List<Double> values) {
        if (values.isEmpty())
            return Double.NaN;

        Double mean = calculateMean(values);
        double res = 0.0;

        for (Double value : values) {
            res += Math.pow(value - mean, 2);
        }



        return res / Math.max(1, values.size() - 1);
    }
}
