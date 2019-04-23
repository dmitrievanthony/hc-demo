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

public class InstallmentPayment implements Identifiable<AffinityKey<Long>>, Serializable {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("SK_ID_PREV")
    private Long skIdPrev;

    @QuerySqlField(index = true)
    @AffinityKeyMapped
    @JsonProperty("SK_ID_CURR")
    private Long skIdCurr;

    @JsonProperty("NUM_INSTALMENT_VERSION")
    private Double numInstalmentVersion;

    @JsonProperty("NUM_INSTALMENT_NUMBER")
    private Integer numInstalmentNumber;

    @JsonProperty("DAYS_INSTALMENT")
    private Double daysInstalment;

    @JsonProperty("DAYS_ENTRY_PAYMENT")
    private Double daysEntryPayment;

    @JsonProperty("AMT_INSTALMENT")
    private Double amtInstalment;

    @JsonProperty("AMT_PAYMENT")
    private Double amtPayment;

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

    public Long getSkIdPrev() {
        return skIdPrev;
    }

    public void setSkIdPrev(Long skIdPrev) {
        this.skIdPrev = skIdPrev;
    }

    public Long getSkIdCurr() {
        return skIdCurr;
    }

    public void setSkIdCurr(Long skIdCurr) {
        this.skIdCurr = skIdCurr;
    }

    public Double getNumInstalmentVersion() {
        return numInstalmentVersion;
    }

    public void setNumInstalmentVersion(Double numInstalmentVersion) {
        this.numInstalmentVersion = numInstalmentVersion;
    }

    public Integer getNumInstalmentNumber() {
        return numInstalmentNumber;
    }

    public void setNumInstalmentNumber(Integer numInstalmentNumber) {
        this.numInstalmentNumber = numInstalmentNumber;
    }

    public Double getDaysInstalment() {
        return daysInstalment;
    }

    public void setDaysInstalment(Double daysInstalment) {
        this.daysInstalment = daysInstalment;
    }

    public Double getDaysEntryPayment() {
        return daysEntryPayment;
    }

    public void setDaysEntryPayment(Double daysEntryPayment) {
        this.daysEntryPayment = daysEntryPayment;
    }

    public Double getAmtInstalment() {
        return amtInstalment;
    }

    public void setAmtInstalment(Double amtInstalment) {
        this.amtInstalment = amtInstalment;
    }

    public Double getAmtPayment() {
        return amtPayment;
    }

    public void setAmtPayment(Double amtPayment) {
        this.amtPayment = amtPayment;
    }
}
