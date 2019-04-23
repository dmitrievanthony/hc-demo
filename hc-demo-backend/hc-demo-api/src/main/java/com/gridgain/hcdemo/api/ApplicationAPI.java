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

package com.gridgain.hcdemo.api;

import com.gridgain.hcdemo.model.Application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.cache.Cache;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.ScanQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class ApplicationAPI {

    private static final Logger log = LoggerFactory.getLogger(ApplicationAPI.class);

    @Autowired
    private IgniteCache<Long, Application> applicationCache;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Application> getAll() {
        log.info("Processing get request.");

        List<Application> res = new ArrayList<>();

        for (Cache.Entry<Long, Application> application : applicationCache.query(new ScanQuery<Long, Application>())) {
            res.add(application.getValue());
        }

        return res;
    }
}
