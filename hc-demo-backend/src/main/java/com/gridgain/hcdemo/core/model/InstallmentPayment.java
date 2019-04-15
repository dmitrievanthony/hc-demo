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

package com.gridgain.hcdemo.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSTALLMENTS_PAYMENTS")
public class InstallmentPayment {

    @Id
    @Column(name = "ID")
    @JsonProperty("ID")
    private Long id;

    @Column(name = "SK_ID_PREV")
    @JsonProperty("SK_ID_PREV")
    private Long skIdPrev;

    @Column(name = "SK_ID_CURR")
    @JsonProperty("SK_ID_CURR")
    private Long skIdCurr;

    @Column(name = "NUM_INSTALMENT_VERSION")
    @JsonProperty("NUM_INSTALMENT_VERSION")
    private Double numInstalmentVersion;

    @Column(name = "NUM_INSTALMENT_NUMBER")
    @JsonProperty("NUM_INSTALMENT_NUMBER")
    private Integer numInstalmentNumber;

    //    DAYS_INSTALMENT DOUBLE,
    @Column(name = "DAYS_INSTALMENT")
    @JsonProperty("DAYS_INSTALMENT")
    private Double daysInstalment;

    @Column(name = "DAYS_ENTRY_PAYMENT")
    @JsonProperty("DAYS_ENTRY_PAYMENT")
    private Double daysEntryPayment;

    @Column(name = "AMT_INSTALMENT")
    @JsonProperty("AMT_INSTALMENT")
    private Double amtInstalment;

    @Column(name = "AMT_PAYMENT")
    @JsonProperty("AMT_PAYMENT")
    private Double amtPayment;

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
