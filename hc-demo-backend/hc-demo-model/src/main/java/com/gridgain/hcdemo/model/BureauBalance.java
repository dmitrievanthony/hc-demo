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

package com.gridgain.hcdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import org.apache.ignite.cache.affinity.AffinityKey;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class BureauBalance implements Identifiable<AffinityKey<Long>>, Serializable {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("SK_ID_BUREAU")
    private Long skIdBureau;

    @JsonProperty("MONTHS_BALANCE")
    private Long monthsBalance;

    @JsonProperty("STATUS")
    private String status;

    @QuerySqlField(index = true)
    @AffinityKeyMapped
    @JsonIgnore
    private Long skIdCurr;

    @JsonIgnore
    private transient AffinityKey<Long> key;

    @Override public AffinityKey<Long> key() {
        if (key == null)
            key = new AffinityKey<>(id, skIdCurr);

        return key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkIdBureau() {
        return skIdBureau;
    }

    public void setSkIdBureau(Long skIdBureau) {
        this.skIdBureau = skIdBureau;
    }

    public Long getMonthsBalance() {
        return monthsBalance;
    }

    public void setMonthsBalance(Long monthsBalance) {
        this.monthsBalance = monthsBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSkIdCurr() {
        return skIdCurr;
    }

    public void setSkIdCurr(Long skIdCurr) {
        this.skIdCurr = skIdCurr;
    }
}
