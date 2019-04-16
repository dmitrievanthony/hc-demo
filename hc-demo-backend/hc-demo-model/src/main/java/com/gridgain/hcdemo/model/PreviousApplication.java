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
@Table(name = "PREVIOUS_APPLICATION")
public class PreviousApplication {

    @Id
    @Column(name = "SK_ID_PREV")
    @JsonProperty("SK_ID_PREV")
    private Long skIdPrev;

    @Column(name = "SK_ID_CURR")
    @JsonProperty("SK_ID_CURR")
    private Long skIdCurr;

    @Column(name = "NAME_CONTRACT_TYPE")
    @JsonProperty("NAME_CONTRACT_TYPE")
    private String nameContractType;

    @Column(name = "AMT_ANNUITY")
    @JsonProperty("AMT_ANNUITY")
    private Double amtAnnuity;

    @Column(name = "AMT_APPLICATION")
    @JsonProperty("AMT_APPLICATION")
    private Double amtApplication;

    @Column(name = "AMT_CREDIT")
    @JsonProperty("AMT_CREDIT")
    private Double amtCredit;

    @Column(name = "AMT_DOWN_PAYMENT")
    @JsonProperty("AMT_DOWN_PAYMENT")
    private Double amtDownPayment;

    @Column(name = "AMT_GOODS_PRICE")
    @JsonProperty("AMT_GOODS_PRICE")
    private Double amtGoodsPrice;

    @Column(name = "WEEKDAY_APPR_PROCESS_START")
    @JsonProperty("WEEKDAY_APPR_PROCESS_START")
    private String weekdayApprProcessStart;

    @Column(name = "HOUR_APPR_PROCESS_START")
    @JsonProperty("HOUR_APPR_PROCESS_START")
    private Long hourApprProcessStart;

    @Column(name = "FLAG_LAST_APPL_PER_CONTRACT")
    @JsonProperty("FLAG_LAST_APPL_PER_CONTRACT")
    private String flagLastApplPerContract;

    @Column(name = "NFLAG_LAST_APPL_IN_DAY")
    @JsonProperty("NFLAG_LAST_APPL_IN_DAY")
    private Long nflagLastApplInDay;

    @Column(name = "RATE_DOWN_PAYMENT")
    @JsonProperty("RATE_DOWN_PAYMENT")
    private Double rateDownPayment;

    @Column(name = "RATE_INTEREST_PRIMARY")
    @JsonProperty("RATE_INTEREST_PRIMARY")
    private Double rateInterestPrimary;

    @Column(name = "RATE_INTEREST_PRIVILEGED")
    @JsonProperty("RATE_INTEREST_PRIVILEGED")
    private Double rateInterestPrivileged;

    @Column(name = "NAME_CASH_LOAN_PURPOSE")
    @JsonProperty("NAME_CASH_LOAN_PURPOSE")
    private String nameCashLoanPurpose;

    @Column(name = "NAME_CONTRACT_STATUS")
    @JsonProperty("NAME_CONTRACT_STATUS")
    private String nameContractStatus;

    @Column(name = "DAYS_DECISION")
    @JsonProperty("DAYS_DECISION")
    private Integer daysDecision;

    @Column(name = "NAME_PAYMENT_TYPE")
    @JsonProperty("NAME_PAYMENT_TYPE")
    private String namePaymentType;

    @Column(name = "CODE_REJECT_REASON")
    @JsonProperty("CODE_REJECT_REASON")
    private String codeRejectReason;

    @Column(name = "NAME_TYPE_SUITE")
    @JsonProperty("NAME_TYPE_SUITE")
    private String nameTypeSuite;

    @Column(name = "NAME_CLIENT_TYPE")
    @JsonProperty("NAME_CLIENT_TYPE")
    private String nameClientType;

    @Column(name = "NAME_GOODS_CATEGORY")
    @JsonProperty("NAME_GOODS_CATEGORY")
    private String nameGoodsCategory;

    @Column(name = "NAME_PORTFOLIO")
    @JsonProperty("NAME_PORTFOLIO")
    private String namePortfolio;

    @Column(name = "NAME_PRODUCT_TYPE")
    @JsonProperty("NAME_PRODUCT_TYPE")
    private String nameProductType;

    //    CHANNEL_TYPE VARCHAR(255),
    @Column(name = "CHANNEL_TYPE")
    @JsonProperty("CHANNEL_TYPE")
    private String channelType;

    @Column(name = "SELLERPLACE_AREA")
    @JsonProperty("SELLERPLACE_AREA")
    private Long sellerplaceArea;

    @Column(name = "NAME_SELLER_INDUSTRY")
    @JsonProperty("NAME_SELLER_INDUSTRY")
    private String nameSellerIndustry;

    @Column(name = "CNT_PAYMENT")
    @JsonProperty("CNT_PAYMENT")
    private Double cntPayment;

    @Column(name = "NAME_YIELD_GROUP")
    @JsonProperty("NAME_YIELD_GROUP")
    private String nameYieldGroup;

    @Column(name = "PRODUCT_COMBINATION")
    @JsonProperty("PRODUCT_COMBINATION")
    private String productCombination;

    @Column(name = "DAYS_FIRST_DRAWING")
    @JsonProperty("DAYS_FIRST_DRAWING")
    private Double daysFirstDrawing;

    @Column(name = "DAYS_FIRST_DUE")
    @JsonProperty("DAYS_FIRST_DUE")
    private Double daysFirstDue;

    @Column(name = "DAYS_LAST_DUE_1ST_VERSION")
    @JsonProperty("DAYS_LAST_DUE_1ST_VERSION")
    private Double daysLastBue1stVersion;

    @Column(name = "DAYS_LAST_DUE")
    @JsonProperty("DAYS_LAST_DUE")
    private Double daysLastDue;

    @Column(name = "DAYS_TERMINATION")
    @JsonProperty("DAYS_TERMINATION")
    private Double daysTermination;

    @Column(name = "NFLAG_INSURED_ON_APPROVAL")
    @JsonProperty("NFLAG_INSURED_ON_APPROVAL")
    private Double nflagInsuredOnApproval;

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
