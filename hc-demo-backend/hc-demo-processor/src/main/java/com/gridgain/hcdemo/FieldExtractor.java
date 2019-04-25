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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import org.apache.ignite.lang.IgniteBiTuple;

public class FieldExtractor {

    private final FieldMapping fieldMapping;

    private final Map<Class, List<Function<Object, Map<String, Double>>>> processors;

    public FieldExtractor(FieldMapping fieldMapping) {
        this.fieldMapping = fieldMapping;
        this.processors = new HashMap<>();
    }

    public Map<String, Double> extract(Object delegate) {
        Map<String, Double> res = new HashMap<>();

        for (Map.Entry<String, FieldTypeWithValue> field : getFields(delegate).entrySet()) {
            String fieldName = field.getKey();
            FieldTypeWithValue fieldValue = field.getValue();

            if (Number.class.isAssignableFrom(fieldValue.clazz)) {
                handleNumberField(fieldName, (Number)fieldValue.value, res);
            }
            else if (String.class.isAssignableFrom(fieldValue.clazz)) {
                handleStringField(fieldName, (String)fieldValue.value, res);
            }
            else {
                throw new IllegalStateException("Field should be Number or String [name=" + fieldName + ", class=" + fieldValue.clazz + ", value=" + fieldValue.value + "]");
            }
        }

        List<Function<Object, Map<String, Double>>> objectProcessors = processors.get(delegate.getClass());
        if (objectProcessors != null) {
            for (Function<Object, Map<String, Double>> processor : objectProcessors) {
                res.putAll(processor.apply(delegate));
            }
        }

        return res;
    }

    public <T> void registerFieldProcessor(Class<T> clazz, Function<T, Map<String, Double>> objectProcessor) {
        if (!processors.containsKey(clazz))
            processors.put(clazz, new ArrayList<>());

        processors.get(clazz).add(e -> objectProcessor.apply((T)e));
    }

    private void handleNumberField(String fieldName, Number fieldValue, Map<String, Double> res) {
        res.put(fieldName, fieldValue == null ? Double.NaN : fieldValue.doubleValue());
    }

    private void handleStringField(String fieldName, String fieldValue, Map<String, Double> res) {
        for (String name : fieldMapping.keys()) {
            if (name.startsWith(fieldName))
                res.put(name, 0.0);
        }

        if (fieldValue != null) {
            fieldName = fieldName + "_" + fieldValue;
            res.put(fieldName, 1.0);
        }
    }

    private Map<String, FieldTypeWithValue> getFields(Object delegate) {
        Map<String, FieldTypeWithValue> res = new HashMap<>();

        Class delegateClass = delegate.getClass();
        for (Field field : delegateClass.getDeclaredFields()) {
            String fieldName = getFieldName(field);

            if (fieldName != null) {
                Object fieldValue = getFieldValue(field, delegate);
                res.put(fieldName, new FieldTypeWithValue(field.getType(), fieldValue));
            }
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

    private static class FieldTypeWithValue {

        private final Class<?> clazz;

        private final Object value;

        public FieldTypeWithValue(Class<?> clazz, Object value) {
            this.clazz = clazz;
            this.value = value;
        }
    }
}
