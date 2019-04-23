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

package com.gridgain.hcdemo.preprocessor;

import com.gridgain.hcdemo.model.Bureau;
import com.gridgain.hcdemo.model.BureauBalance;
import java.util.Iterator;
import java.util.List;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BureauBalancePreprocessor implements Preprocessor<BureauBalance> {

    @Autowired
    private Ignite ignite;

    @Autowired
    private IgniteCache<AffinityKey<Long>, Bureau> bureauCache;

    @Override public BureauBalance preprocess(BureauBalance input) {
        Long skIdBureau = input.getSkIdBureau();
        Long skIdCurr = getSkIdCurrBySkIdBureau(skIdBureau);

        if (skIdCurr != null)
            input.setSkIdCurr(skIdCurr);

        return input;
    }

    private Long getSkIdCurrBySkIdBureau(Long skIdBureau) {
        Iterator<List<?>> iter = bureauCache.query(
            new SqlFieldsQuery("select skIdCurr from Bureau where Bureau.id = ?", true).setArgs(skIdBureau)
        ).iterator();

        if (!iter.hasNext())
            return null;

        return (Long)iter.next().get(0);
    }
}
