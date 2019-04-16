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

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUREAU")
public class Bureau {

    @Column(name = "SK_ID_CURR")
    @JsonProperty("SK_ID_CURR")
    private Long skIdCurr;

    @Id
    @Column(name = "SK_ID_BUREAU")
    @JsonProperty("SK_ID_BUREAU")
    private Long skIdBureau;

    @Column(name = "CREDIT_ACTIVE")
    @JsonProperty("CREDIT_ACTIVE")
    private String creditActive;

    @Column(name = "CREDIT_CURRENCY")
    @JsonProperty("CREDIT_CURRENCY")
    private String creditCurrency;

    @Column(name = "DAYS_CREDIT")
    @JsonProperty("DAYS_CREDIT")
    private Long daysCredit;

    @Column(name = "CREDIT_DAY_OVERDUE")
    @JsonProperty("CREDIT_DAY_OVERDUE")
    private Long creditDaysOverdue;

    @Column(name = "DAYS_CREDIT_ENDDATE")
    @JsonProperty("DAYS_CREDIT_ENDDATE")
    private Double daysCreditEnddate;

    @Column(name = "DAYS_ENDDATE_FACT")
    @JsonProperty("DAYS_ENDDATE_FACT")
    private Double daysEnddateFact;

    @Column(name = "AMT_CREDIT_MAX_OVERDUE")
    @JsonProperty("AMT_CREDIT_MAX_OVERDUE")
    private Double amtCreditMaxOverdue;

    @Column(name = "CNT_CREDIT_PROLONG")
    @JsonProperty("CNT_CREDIT_PROLONG")
    private Long cntCreditProlongInt;

    @Column(name = "AMT_CREDIT_SUM")
    @JsonProperty("AMT_CREDIT_SUM")
    private Double amtCreditSumDouble;

    @Column(name = "AMT_CREDIT_SUM_DEBT")
    @JsonProperty("AMT_CREDIT_SUM_DEBT")
    private Double amtCreditSumDebt;

    @Column(name = "AMT_CREDIT_SUM_LIMIT")
    @JsonProperty("AMT_CREDIT_SUM_LIMIT")
    private Double amtCreditSumLimit;

    @Column(name = "AMT_CREDIT_SUM_OVERDUE")
    @JsonProperty("AMT_CREDIT_SUM_OVERDUE")
    private Double amtCreditSumOverdue;

    @Column(name = "CREDIT_TYPE")
    @JsonProperty("CREDIT_TYPE")
    private String creditType;

    @Column(name = "DAYS_CREDIT_UPDATE")
    @JsonProperty("DAYS_CREDIT_UPDATE")
    private Long daysCreditUpdate;

    @Column(name = "AMT_ANNUITY")
    @JsonProperty("AMT_ANNUITY")
    private Double amtAnnuity;

    public Long getSkIdCurr() {
        return skIdCurr;
    }

    public void setSkIdCurr(Long skIdCurr) {
        this.skIdCurr = skIdCurr;
    }

    public Long getSkIdBureau() {
        return skIdBureau;
    }

    public void setSkIdBureau(Long skIdBureau) {
        this.skIdBureau = skIdBureau;
    }

    public String getCreditActive() {
        return creditActive;
    }

    public void setCreditActive(String creditActive) {
        this.creditActive = creditActive;
    }

    public String getCreditCurrency() {
        return creditCurrency;
    }

    public void setCreditCurrency(String creditCurrency) {
        this.creditCurrency = creditCurrency;
    }

    public Long getDaysCredit() {
        return daysCredit;
    }

    public void setDaysCredit(Long daysCredit) {
        this.daysCredit = daysCredit;
    }

    public Long getCreditDaysOverdue() {
        return creditDaysOverdue;
    }

    public void setCreditDaysOverdue(Long creditDaysOverdue) {
        this.creditDaysOverdue = creditDaysOverdue;
    }

    public Double getDaysCreditEnddate() {
        return daysCreditEnddate;
    }

    public void setDaysCreditEnddate(Double daysCreditEnddate) {
        this.daysCreditEnddate = daysCreditEnddate;
    }

    public Double getDaysEnddateFact() {
        return daysEnddateFact;
    }

    public void setDaysEnddateFact(Double daysEnddateFact) {
        this.daysEnddateFact = daysEnddateFact;
    }

    public Double getAmtCreditMaxOverdue() {
        return amtCreditMaxOverdue;
    }

    public void setAmtCreditMaxOverdue(Double amtCreditMaxOverdue) {
        this.amtCreditMaxOverdue = amtCreditMaxOverdue;
    }

    public Long getCntCreditProlongInt() {
        return cntCreditProlongInt;
    }

    public void setCntCreditProlongInt(Long cntCreditProlongInt) {
        this.cntCreditProlongInt = cntCreditProlongInt;
    }

    public Double getAmtCreditSumDouble() {
        return amtCreditSumDouble;
    }

    public void setAmtCreditSumDouble(Double amtCreditSumDouble) {
        this.amtCreditSumDouble = amtCreditSumDouble;
    }

    public Double getAmtCreditSumDebt() {
        return amtCreditSumDebt;
    }

    public void setAmtCreditSumDebt(Double amtCreditSumDebt) {
        this.amtCreditSumDebt = amtCreditSumDebt;
    }

    public Double getAmtCreditSumLimit() {
        return amtCreditSumLimit;
    }

    public void setAmtCreditSumLimit(Double amtCreditSumLimit) {
        this.amtCreditSumLimit = amtCreditSumLimit;
    }

    public Double getAmtCreditSumOverdue() {
        return amtCreditSumOverdue;
    }

    public void setAmtCreditSumOverdue(Double amtCreditSumOverdue) {
        this.amtCreditSumOverdue = amtCreditSumOverdue;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public Long getDaysCreditUpdate() {
        return daysCreditUpdate;
    }

    public void setDaysCreditUpdate(Long daysCreditUpdate) {
        this.daysCreditUpdate = daysCreditUpdate;
    }

    public Double getAmtAnnuity() {
        return amtAnnuity;
    }

    public void setAmtAnnuity(Double amtAnnuity) {
        this.amtAnnuity = amtAnnuity;
    }
}
