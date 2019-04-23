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

public class PreviousApplication implements Identifiable<AffinityKey<Long>>, Serializable {

    @JsonProperty("SK_ID_PREV")
    private Long id;

    @QuerySqlField(index = true)
    @AffinityKeyMapped
    @JsonProperty("SK_ID_CURR")
    private Long skIdCurr;

    @JsonProperty("NAME_CONTRACT_TYPE")
    private String nameContractType;

    @JsonProperty("AMT_ANNUITY")
    private Double amtAnnuity;

    @JsonProperty("AMT_APPLICATION")
    private Double amtApplication;

    @JsonProperty("AMT_CREDIT")
    private Double amtCredit;

    @JsonProperty("AMT_DOWN_PAYMENT")
    private Double amtDownPayment;

    @JsonProperty("AMT_GOODS_PRICE")
    private Double amtGoodsPrice;

    @JsonProperty("WEEKDAY_APPR_PROCESS_START")
    private String weekdayApprProcessStart;

    @JsonProperty("HOUR_APPR_PROCESS_START")
    private Long hourApprProcessStart;

    @JsonProperty("FLAG_LAST_APPL_PER_CONTRACT")
    private String flagLastApplPerContract;

    @JsonProperty("NFLAG_LAST_APPL_IN_DAY")
    private Long nflagLastApplInDay;

    @JsonProperty("RATE_DOWN_PAYMENT")
    private Double rateDownPayment;

    @JsonProperty("RATE_INTEREST_PRIMARY")
    private Double rateInterestPrimary;

    @JsonProperty("RATE_INTEREST_PRIVILEGED")
    private Double rateInterestPrivileged;

    @JsonProperty("NAME_CASH_LOAN_PURPOSE")
    private String nameCashLoanPurpose;

    @JsonProperty("NAME_CONTRACT_STATUS")
    private String nameContractStatus;

    @JsonProperty("DAYS_DECISION")
    private Integer daysDecision;

    @JsonProperty("NAME_PAYMENT_TYPE")
    private String namePaymentType;

    @JsonProperty("CODE_REJECT_REASON")
    private String codeRejectReason;

    @JsonProperty("NAME_TYPE_SUITE")
    private String nameTypeSuite;

    @JsonProperty("NAME_CLIENT_TYPE")
    private String nameClientType;

    @JsonProperty("NAME_GOODS_CATEGORY")
    private String nameGoodsCategory;

    @JsonProperty("NAME_PORTFOLIO")
    private String namePortfolio;

    @JsonProperty("NAME_PRODUCT_TYPE")
    private String nameProductType;

    @JsonProperty("CHANNEL_TYPE")
    private String channelType;

    @JsonProperty("SELLERPLACE_AREA")
    private Long sellerplaceArea;

    @JsonProperty("NAME_SELLER_INDUSTRY")
    private String nameSellerIndustry;

    @JsonProperty("CNT_PAYMENT")
    private Double cntPayment;

    @JsonProperty("NAME_YIELD_GROUP")
    private String nameYieldGroup;

    @JsonProperty("PRODUCT_COMBINATION")
    private String productCombination;

    @JsonProperty("DAYS_FIRST_DRAWING")
    private Double daysFirstDrawing;

    @JsonProperty("DAYS_FIRST_DUE")
    private Double daysFirstDue;

    @JsonProperty("DAYS_LAST_DUE_1ST_VERSION")
    private Double daysLastBue1stVersion;

    @JsonProperty("DAYS_LAST_DUE")
    private Double daysLastDue;

    @JsonProperty("DAYS_TERMINATION")
    private Double daysTermination;

    @JsonProperty("NFLAG_INSURED_ON_APPROVAL")
    private Double nflagInsuredOnApproval;

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

    public Long getSkIdCurr() {
        return skIdCurr;
    }

    public void setSkIdCurr(Long skIdCurr) {
        this.skIdCurr = skIdCurr;
    }

    public String getNameContractType() {
        return nameContractType;
    }

    public void setNameContractType(String nameContractType) {
        this.nameContractType = nameContractType;
    }

    public Double getAmtAnnuity() {
        return amtAnnuity;
    }

    public void setAmtAnnuity(Double amtAnnuity) {
        this.amtAnnuity = amtAnnuity;
    }

    public Double getAmtApplication() {
        return amtApplication;
    }

    public void setAmtApplication(Double amtApplication) {
        this.amtApplication = amtApplication;
    }

    public Double getAmtCredit() {
        return amtCredit;
    }

    public void setAmtCredit(Double amtCredit) {
        this.amtCredit = amtCredit;
    }

    public Double getAmtDownPayment() {
        return amtDownPayment;
    }

    public void setAmtDownPayment(Double amtDownPayment) {
        this.amtDownPayment = amtDownPayment;
    }

    public Double getAmtGoodsPrice() {
        return amtGoodsPrice;
    }

    public void setAmtGoodsPrice(Double amtGoodsPrice) {
        this.amtGoodsPrice = amtGoodsPrice;
    }

    public String getWeekdayApprProcessStart() {
        return weekdayApprProcessStart;
    }

    public void setWeekdayApprProcessStart(String weekdayApprProcessStart) {
        this.weekdayApprProcessStart = weekdayApprProcessStart;
    }

    public Long getHourApprProcessStart() {
        return hourApprProcessStart;
    }

    public void setHourApprProcessStart(Long hourApprProcessStart) {
        this.hourApprProcessStart = hourApprProcessStart;
    }

    public String getFlagLastApplPerContract() {
        return flagLastApplPerContract;
    }

    public void setFlagLastApplPerContract(String flagLastApplPerContract) {
        this.flagLastApplPerContract = flagLastApplPerContract;
    }

    public Long getNflagLastApplInDay() {
        return nflagLastApplInDay;
    }

    public void setNflagLastApplInDay(Long nflagLastApplInDay) {
        this.nflagLastApplInDay = nflagLastApplInDay;
    }

    public Double getRateDownPayment() {
        return rateDownPayment;
    }

    public void setRateDownPayment(Double rateDownPayment) {
        this.rateDownPayment = rateDownPayment;
    }

    public Double getRateInterestPrimary() {
        return rateInterestPrimary;
    }

    public void setRateInterestPrimary(Double rateInterestPrimary) {
        this.rateInterestPrimary = rateInterestPrimary;
    }

    public Double getRateInterestPrivileged() {
        return rateInterestPrivileged;
    }

    public void setRateInterestPrivileged(Double rateInterestPrivileged) {
        this.rateInterestPrivileged = rateInterestPrivileged;
    }

    public String getNameCashLoanPurpose() {
        return nameCashLoanPurpose;
    }

    public void setNameCashLoanPurpose(String nameCashLoanPurpose) {
        this.nameCashLoanPurpose = nameCashLoanPurpose;
    }

    public String getNameContractStatus() {
        return nameContractStatus;
    }

    public void setNameContractStatus(String nameContractStatus) {
        this.nameContractStatus = nameContractStatus;
    }

    public Integer getDaysDecision() {
        return daysDecision;
    }

    public void setDaysDecision(Integer daysDecision) {
        this.daysDecision = daysDecision;
    }

    public String getNamePaymentType() {
        return namePaymentType;
    }

    public void setNamePaymentType(String namePaymentType) {
        this.namePaymentType = namePaymentType;
    }

    public String getCodeRejectReason() {
        return codeRejectReason;
    }

    public void setCodeRejectReason(String codeRejectReason) {
        this.codeRejectReason = codeRejectReason;
    }

    public String getNameTypeSuite() {
        return nameTypeSuite;
    }

    public void setNameTypeSuite(String nameTypeSuite) {
        this.nameTypeSuite = nameTypeSuite;
    }

    public String getNameClientType() {
        return nameClientType;
    }

    public void setNameClientType(String nameClientType) {
        this.nameClientType = nameClientType;
    }

    public String getNameGoodsCategory() {
        return nameGoodsCategory;
    }

    public void setNameGoodsCategory(String nameGoodsCategory) {
        this.nameGoodsCategory = nameGoodsCategory;
    }

    public String getNamePortfolio() {
        return namePortfolio;
    }

    public void setNamePortfolio(String namePortfolio) {
        this.namePortfolio = namePortfolio;
    }

    public String getNameProductType() {
        return nameProductType;
    }

    public void setNameProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Long getSellerplaceArea() {
        return sellerplaceArea;
    }

    public void setSellerplaceArea(Long sellerplaceArea) {
        this.sellerplaceArea = sellerplaceArea;
    }

    public String getNameSellerIndustry() {
        return nameSellerIndustry;
    }

    public void setNameSellerIndustry(String nameSellerIndustry) {
        this.nameSellerIndustry = nameSellerIndustry;
    }

    public Double getCntPayment() {
        return cntPayment;
    }

    public void setCntPayment(Double cntPayment) {
        this.cntPayment = cntPayment;
    }

    public String getNameYieldGroup() {
        return nameYieldGroup;
    }

    public void setNameYieldGroup(String nameYieldGroup) {
        this.nameYieldGroup = nameYieldGroup;
    }

    public String getProductCombination() {
        return productCombination;
    }

    public void setProductCombination(String productCombination) {
        this.productCombination = productCombination;
    }

    public Double getDaysFirstDrawing() {
        return daysFirstDrawing;
    }

    public void setDaysFirstDrawing(Double daysFirstDrawing) {
        this.daysFirstDrawing = daysFirstDrawing;
    }

    public Double getDaysFirstDue() {
        return daysFirstDue;
    }

    public void setDaysFirstDue(Double daysFirstDue) {
        this.daysFirstDue = daysFirstDue;
    }

    public Double getDaysLastBue1stVersion() {
        return daysLastBue1stVersion;
    }

    public void setDaysLastBue1stVersion(Double daysLastBue1stVersion) {
        this.daysLastBue1stVersion = daysLastBue1stVersion;
    }

    public Double getDaysLastDue() {
        return daysLastDue;
    }

    public void setDaysLastDue(Double daysLastDue) {
        this.daysLastDue = daysLastDue;
    }

    public Double getDaysTermination() {
        return daysTermination;
    }

    public void setDaysTermination(Double daysTermination) {
        this.daysTermination = daysTermination;
    }

    public Double getNflagInsuredOnApproval() {
        return nflagInsuredOnApproval;
    }

    public void setNflagInsuredOnApproval(Double nflagInsuredOnApproval) {
        this.nflagInsuredOnApproval = nflagInsuredOnApproval;
    }
}
