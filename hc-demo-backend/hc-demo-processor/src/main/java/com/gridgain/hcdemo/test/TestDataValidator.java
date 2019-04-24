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

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataValidator {

    private static final Logger log = LoggerFactory.getLogger(TestDataValidator.class);

    private final TestDataIterator testDataIterator;

    public TestDataValidator(String resource) {
        testDataIterator = new TestDataIterator(resource);
    }

    public void validate(Map<String, Double> row) {
        if (!testDataIterator.hasNext())
            return;

        assertEquals(testDataIterator.next(), row);
    }

    private void assertEquals(Map<String, Double> expected, Map<String, Double> actual) {
        for (String key : expected.keySet()) {
            if (!actual.containsKey(key)) {
                log.error("Expected row contains '{}', but actual doesn't.", key);
            }
            else {
                Double expectedValue = expected.get(key);
                Double actualValue = actual.get(key);
                if (Math.abs(expectedValue - actualValue) > 0.001) {
                    log.error("Expected value and actual value are not equal [col='{}', exp='{}', act='{}']", key, expectedValue, actualValue);
                }
            }
        }

        for (String key : actual.keySet()) {
            if (!expected.containsKey(key)) {
                log.error("Expected row doesn't contain '{}', but actual does.", key);
            }
        }
    }
}
