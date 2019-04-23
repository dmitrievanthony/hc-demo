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

public class CreditCardBalance implements Identifiable<AffinityKey<Long>>, Serializable {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("SK_ID_PREV")
    private Long skIdPrev;

    @QuerySqlField(index = true)
    @AffinityKeyMapped
    @JsonProperty("SK_ID_CURR")
    private Long skIdCurr;

    @JsonProperty("MONTHS_BALANCE")
    private Long monthsBalance;

    @JsonProperty("AMT_BALANCE")
    private Double amtBalance;

    @JsonProperty("AMT_CREDIT_LIMIT_ACTUAL")
    private Long amtCreditLimitActual;

    @JsonProperty("AMT_DRAWINGS_ATM_CURRENT")
    private Double amtDrawingsAtmCurrent;

    @JsonProperty("AMT_DRAWINGS_CURRENT")
    private Double amtDrawingsCurrentDouble;

    @JsonProperty("AMT_DRAWINGS_OTHER_CURRENT")
    private Double amtDrawingsOtherCurrent;

    @JsonProperty("AMT_DRAWINGS_POS_CURRENT")
    private Double amtDrawingsPosCurrent;

    @JsonProperty("AMT_INST_MIN_REGULARITY")
    private Double amtInstMinRegularity;

    @JsonProperty("AMT_PAYMENT_CURRENT")
    private Double amtPaymentCurrent;

    @JsonProperty("AMT_PAYMENT_TOTAL_CURRENT")
    private Double amtPaymentTotalCurrent;

    @JsonProperty("AMT_RECEIVABLE_PRINCIPAL")
    private Double amtReceivablePrincipal;

    @JsonProperty("AMT_RECIVABLE")
    private Double amtRecivable;

    @JsonProperty("AMT_TOTAL_RECEIVABLE")
    private Double amtTotalReceivable;

    @JsonProperty("CNT_DRAWINGS_ATM_CURRENT")
    private Double cntDrawingsAtmCurrent;

    @JsonProperty("CNT_DRAWINGS_CURRENT")
    private Integer cntDrawingsCurrent;

    @JsonProperty("CNT_DRAWINGS_OTHER_CURRENT")
    private Double cntDrawingsOtherCurrent;

    @JsonProperty("CNT_DRAWINGS_POS_CURRENT")
    private Double cntDrawingsPosCurrent;

    @JsonProperty("CNT_INSTALMENT_MATURE_CUM")
    private Double cntInstalmentMatureCum;

    @JsonProperty("NAME_CONTRACT_STATUS")
    private String nameContractStatus;

    @JsonProperty("SK_DPD")
    private Integer skDpd;

    @JsonProperty("SK_DPD_DEF")
    private Integer skPdpDef;

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

    public Long getMonthsBalance() {
        return monthsBalance;
    }

    public void setMonthsBalance(Long monthsBalance) {
        this.monthsBalance = monthsBalance;
    }

    public Double getAmtBalance() {
        return amtBalance;
    }

    public void setAmtBalance(Double amtBalance) {
        this.amtBalance = amtBalance;
    }

    public Long getAmtCreditLimitActual() {
        return amtCreditLimitActual;
    }

    public void setAmtCreditLimitActual(Long amtCreditLimitActual) {
        this.amtCreditLimitActual = amtCreditLimitActual;
    }

    public Double getAmtDrawingsAtmCurrent() {
        return amtDrawingsAtmCurrent;
    }

    public void setAmtDrawingsAtmCurrent(Double amtDrawingsAtmCurrent) {
        this.amtDrawingsAtmCurrent = amtDrawingsAtmCurrent;
    }

    public Double getAmtDrawingsCurrentDouble() {
        return amtDrawingsCurrentDouble;
    }

    public void setAmtDrawingsCurrentDouble(Double amtDrawingsCurrentDouble) {
        this.amtDrawingsCurrentDouble = amtDrawingsCurrentDouble;
    }

    public Double getAmtDrawingsOtherCurrent() {
        return amtDrawingsOtherCurrent;
    }

    public void setAmtDrawingsOtherCurrent(Double amtDrawingsOtherCurrent) {
        this.amtDrawingsOtherCurrent = amtDrawingsOtherCurrent;
    }

    public Double getAmtDrawingsPosCurrent() {
        return amtDrawingsPosCurrent;
    }

    public void setAmtDrawingsPosCurrent(Double amtDrawingsPosCurrent) {
        this.amtDrawingsPosCurrent = amtDrawingsPosCurrent;
    }

    public Double getAmtInstMinRegularity() {
        return amtInstMinRegularity;
    }

    public void setAmtInstMinRegularity(Double amtInstMinRegularity) {
        this.amtInstMinRegularity = amtInstMinRegularity;
    }

    public Double getAmtPaymentCurrent() {
        return amtPaymentCurrent;
    }

    public void setAmtPaymentCurrent(Double amtPaymentCurrent) {
        this.amtPaymentCurrent = amtPaymentCurrent;
    }

    public Double getAmtPaymentTotalCurrent() {
        return amtPaymentTotalCurrent;
    }

    public void setAmtPaymentTotalCurrent(Double amtPaymentTotalCurrent) {
        this.amtPaymentTotalCurrent = amtPaymentTotalCurrent;
    }

    public Double getAmtReceivablePrincipal() {
        return amtReceivablePrincipal;
    }

    public void setAmtReceivablePrincipal(Double amtReceivablePrincipal) {
        this.amtReceivablePrincipal = amtReceivablePrincipal;
    }

    public Double getAmtRecivable() {
        return amtRecivable;
    }

    public void setAmtRecivable(Double amtRecivable) {
        this.amtRecivable = amtRecivable;
    }

    public Double getAmtTotalReceivable() {
        return amtTotalReceivable;
    }

    public void setAmtTotalReceivable(Double amtTotalReceivable) {
        this.amtTotalReceivable = amtTotalReceivable;
    }

    public Double getCntDrawingsAtmCurrent() {
        return cntDrawingsAtmCurrent;
    }

    public void setCntDrawingsAtmCurrent(Double cntDrawingsAtmCurrent) {
        this.cntDrawingsAtmCurrent = cntDrawingsAtmCurrent;
    }

    public Integer getCntDrawingsCurrent() {
        return cntDrawingsCurrent;
    }

    public void setCntDrawingsCurrent(Integer cntDrawingsCurrent) {
        this.cntDrawingsCurrent = cntDrawingsCurrent;
    }

    public Double getCntDrawingsOtherCurrent() {
        return cntDrawingsOtherCurrent;
    }

    public void setCntDrawingsOtherCurrent(Double cntDrawingsOtherCurrent) {
        this.cntDrawingsOtherCurrent = cntDrawingsOtherCurrent;
    }

    public Double getCntDrawingsPosCurrent() {
        return cntDrawingsPosCurrent;
    }

    public void setCntDrawingsPosCurrent(Double cntDrawingsPosCurrent) {
        this.cntDrawingsPosCurrent = cntDrawingsPosCurrent;
    }

    public Double getCntInstalmentMatureCum() {
        return cntInstalmentMatureCum;
    }

    public void setCntInstalmentMatureCum(Double cntInstalmentMatureCum) {
        this.cntInstalmentMatureCum = cntInstalmentMatureCum;
    }

    public String getNameContractStatus() {
        return nameContractStatus;
    }

    public void setNameContractStatus(String nameContractStatus) {
        this.nameContractStatus = nameContractStatus;
    }

    public Integer getSkDpd() {
        return skDpd;
    }

    public void setSkDpd(Integer skDpd) {
        this.skDpd = skDpd;
    }

    public Integer getSkPdpDef() {
        return skPdpDef;
    }

    public void setSkPdpDef(Integer skPdpDef) {
        this.skPdpDef = skPdpDef;
    }
}
