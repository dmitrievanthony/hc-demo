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

package com.gridgain.hcdemogenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class HcDemoGeneratorApplicationStartupListener {

    private static final Logger log = LoggerFactory.getLogger(HcDemoGeneratorApplicationStartupListener.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws InterruptedException {
        log.info("Started!");
        while (true) {
            Thread.sleep(1000);
            kafkaTemplate.send("topic", "Hello from Kafka!");
            log.info("Message sent.");
        }
    }
}
