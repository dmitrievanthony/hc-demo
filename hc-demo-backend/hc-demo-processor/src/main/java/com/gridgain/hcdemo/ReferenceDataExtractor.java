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

import com.gridgain.hcdemo.model.BureauBalance;
import java.util.ArrayList;
import java.util.List;
import javax.cache.Cache;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlQuery;

public class ReferenceDataExtractor {

    public static <T> List<T> extract(IgniteCache<AffinityKey<Long>, T> cache, Class<T> clazz, Long skIdCurr) {
        List<T> result = new ArrayList<>();

        String query = "from " + cache.getName() + " where skIdCurr = ?";
        try (QueryCursor<Cache.Entry<AffinityKey<Long>, T>> cursor = cache.query(
            new SqlQuery<AffinityKey<Long>, T>(clazz, query).setArgs(skIdCurr)
        )) {
            for (Cache.Entry<AffinityKey<Long>, T> entry : cursor) {
                result.add(entry.getValue());
            }
        }

        return result;
    }
}
