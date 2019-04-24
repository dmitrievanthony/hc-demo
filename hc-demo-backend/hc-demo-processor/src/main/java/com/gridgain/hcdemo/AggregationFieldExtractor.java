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
import java.util.List;
import java.util.Map;

public class AggregationFieldExtractor {

    private final FieldExtractor fieldExtractor;

    public AggregationFieldExtractor(FieldExtractor fieldExtractor) {
        this.fieldExtractor = fieldExtractor;
    }

    public Map<String, Double> extract(List<?> delegates) {
        Map<String, List<Double>> aggregatedFields = new HashMap<>();

        for (Object delegate : delegates) {
            for (Map.Entry<String, Double> field : fieldExtractor.extract(delegate).entrySet()) {
                String fieldName = field.getKey();
                Double fieldValue = field.getValue();

                if (!aggregatedFields.containsKey(fieldName))
                    aggregatedFields.put(fieldName, new ArrayList<>());

                aggregatedFields.get(fieldName).add(fieldValue);
            }
        }

        return aggregate(aggregatedFields);
    }

    private Map<String, Double> aggregate(Map<String, List<Double>> aggregatedFields) {
        Map<String, Double> res = new HashMap<>();

        for (Map.Entry<String, List<Double>> e : aggregatedFields.entrySet()) {
            String fieldName = e.getKey();
            List<Double> fieldValues = e.getValue();

            res.put(fieldName + "_MIN", calculateMin(fieldValues));
            res.put(fieldName + "_MAX", calculateMax(fieldValues));
            res.put(fieldName + "_MEAN", calculateMean(fieldValues));
            res.put(fieldName + "_VAR", calculateVar(fieldValues));
        }

        return res;
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

        return res / values.size();
    }
}
