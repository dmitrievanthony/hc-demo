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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldExtractor {

    private final FieldMapping fieldMapping;

    public FieldExtractor(FieldMapping fieldMapping) {
        this.fieldMapping = fieldMapping;
    }

    public Map<String, Double> extract(Object delegate) {
        Map<String, Double> res = new HashMap<>();

        for (Map.Entry<String, Object> field : getFields(delegate).entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();

            if (fieldValue == null) {
                /* Do nothing. */
            }
            else if (fieldValue instanceof Number) {
                handleNumberField(fieldName, (Number)fieldValue, res);
            }
            else if (fieldValue instanceof String) {
                handleStringField(fieldName, (String)fieldValue, res);
            }
            else {
                throw new IllegalStateException("Field should be Number or String.");
            }
        }

        return res;
    }

    private void handleNumberField(String fieldName, Number fieldValue, Map<String, Double> res) {
        res.put(fieldName, fieldValue.doubleValue());
    }

    private void handleStringField(String fieldName, String fieldValue, Map<String, Double> res) {
        for (String name : fieldMapping.keys()) {
            if (name.startsWith(fieldName))
                res.put(name, 0.0);
        }

        if (fieldValue != null) {
            fieldName = fieldName + "_" + fieldValue.replace(" ", "");
            res.put(fieldName, 1.0);
        }
    }

    private Map<String, Object> getFields(Object delegate) {
        Map<String, Object> res = new HashMap<>();

        Class delegateClass = delegate.getClass();
        for (Field field : delegateClass.getDeclaredFields()) {
            String fieldName = getFieldName(field);
            Object fieldValue = getFieldValue(field, delegate);

            res.put(fieldName, fieldValue);
        }

        return res;
    }

    private Object getFieldValue(Field field, Object obj) {
        field.setAccessible(true);

        try {
            return field.get(obj);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFieldName(Field field) {
        JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);

        return jsonProperty == null ? null : jsonProperty.value();
    }
}
