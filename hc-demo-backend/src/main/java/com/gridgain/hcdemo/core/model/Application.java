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
@Table(name = "APPLICATION")
public class Application {

    @Id
    @Column(name = "SK_ID_CURR")
    @JsonProperty("SK_ID_CURR")
    private Long id;

    @Column(name = "TARGET")
    @JsonProperty("TARGET")
    private Integer target;

    @Column(name = "NAME_CONTRACT_TYPE")
    @JsonProperty("NAME_CONTRACT_TYPE")
    private String contractType;

    @Column(name = "CODE_GENDER")
    @JsonProperty("CODE_GENDER")
    private String codeGender;

    @Column(name = "FLAG_OWN_CAR")
    @JsonProperty("FLAG_OWN_CAR")
    private String flagOwnCar;

    @Column(name = "FLAG_OWN_REALTY")
    @JsonProperty("FLAG_OWN_REALTY")
    private String flagOwnRealy;

    @Column(name = "CNT_CHILDREN")
    @JsonProperty("CNT_CHILDREN")
    private Integer cntChildren;

    @Column(name = "AMT_INCOME_TOTAL")
    @JsonProperty("AMT_INCOME_TOTAL")
    private Double amtIncomeTotal;

    @Column(name = "AMT_CREDIT")
    @JsonProperty("AMT_CREDIT")
    private Double amtCredit;

    @Column(name = "AMT_ANNUITY")
    @JsonProperty("AMT_ANNUITY")
    private Double amtAnnuity;

    @Column(name = "AMT_GOODS_PRICE")
    @JsonProperty("AMT_GOODS_PRICE")
    private Double amtGoodsPrice;

    @Column(name = "NAME_TYPE_SUITE")
    @JsonProperty("NAME_TYPE_SUITE")
    private String nameTypeSuite;

    @Column(name = "NAME_INCOME_TYPE")
    @JsonProperty("NAME_INCOME_TYPE")
    private String nameIncomeType;

    @Column(name = "NAME_EDUCATION_TYPE")
    @JsonProperty("NAME_EDUCATION_TYPE")
    private String nameEducationType;

    @Column(name = "NAME_FAMILY_STATUS")
    @JsonProperty("NAME_FAMILY_STATUS")
    private String nameFamilyStatus;

    @Column(name = "NAME_HOUSING_TYPE")
    @JsonProperty("NAME_HOUSING_TYPE")
    private String nameHousingType;

    @Column(name = "REGION_POPULATION_RELATIVE")
    @JsonProperty("REGION_POPULATION_RELATIVE")
    private Double regionPopulationRelative;

    @Column(name = "DAYS_BIRTH")
    @JsonProperty("DAYS_BIRTH")
    private Integer daysBirth;

    @Column(name = "DAYS_EMPLOYED")
    @JsonProperty("DAYS_EMPLOYED")
    private Integer daysEmployed;

    @Column(name = "DAYS_REGISTRATION")
    @JsonProperty("DAYS_REGISTRATION")
    private Double daysRegistration;

    @Column(name = "DAYS_ID_PUBLISH")
    @JsonProperty("DAYS_ID_PUBLISH")
    private Integer daysIdPublished;

    @Column(name = "OWN_CAR_AGE")
    @JsonProperty("OWN_CAR_AGE")
    private Double ownCarAge;

    @Column(name = "FLAG_MOBIL")
    @JsonProperty("FLAG_MOBIL")
    private Integer flagMobil;

    @Column(name = "FLAG_EMP_PHONE")
    @JsonProperty("FLAG_EMP_PHONE")
    private Integer flagEmpPhone;

    @Column(name = "FLAG_WORK_PHONE")
    @JsonProperty("FLAG_WORK_PHONE")
    private Integer flagWorkPhone;

    @Column(name = "FLAG_CONT_MOBILE")
    @JsonProperty("FLAG_CONT_MOBILE")
    private Integer flagContMobile;

    @Column(name = "FLAG_PHONE")
    @JsonProperty("FLAG_PHONE")
    private Integer flagPhone;

    @Column(name = "FLAG_EMAIL")
    @JsonProperty("FLAG_EMAIL")
    private Integer flagEmail;

    @Column(name = "OCCUPATION_TYPE")
    @JsonProperty("OCCUPATION_TYPE")
    private String occupationType;

    @Column(name = "CNT_FAM_MEMBERS")
    @JsonProperty("CNT_FAM_MEMBERS")
    private Double cntFamMembers;

    @Column(name = "REGION_RATING_CLIENT")
    @JsonProperty("REGION_RATING_CLIENT")
    private Integer regionRatingClient;

    @Column(name = "REGION_RATING_CLIENT_W_CITY")
    @JsonProperty("REGION_RATING_CLIENT_W_CITY")
    private Integer regionRatingClientWCity;

    @Column(name = "WEEKDAY_APPR_PROCESS_START")
    @JsonProperty("WEEKDAY_APPR_PROCESS_START")
    private String apprProcessStart;

    @Column(name = "HOUR_APPR_PROCESS_START")
    @JsonProperty("HOUR_APPR_PROCESS_START")
    private Integer hourApprProcessStart;

    @Column(name = "REG_REGION_NOT_LIVE_REGION")
    @JsonProperty("REG_REGION_NOT_LIVE_REGION")
    private Integer regRegionNotLiveRegion;

    @Column(name = "REG_REGION_NOT_WORK_REGION")
    @JsonProperty("REG_REGION_NOT_WORK_REGION")
    private Integer regRegionNotWorkRegion;

    @Column(name = "LIVE_REGION_NOT_WORK_REGION")
    @JsonProperty("LIVE_REGION_NOT_WORK_REGION")
    private Integer liveRegionNotWorkRegion;

    @Column(name = "REG_CITY_NOT_LIVE_CITY")
    @JsonProperty("REG_CITY_NOT_LIVE_CITY")
    private Integer regCityNotLiveCity;

    @Column(name = "REG_CITY_NOT_WORK_CITY")
    @JsonProperty("REG_CITY_NOT_WORK_CITY")
    private Integer regCityNotWorkCity;

    @Column(name = "LIVE_CITY_NOT_WORK_CITY")
    @JsonProperty("LIVE_CITY_NOT_WORK_CITY")
    private Integer liveCityNotWorkCity;

    @Column(name = "ORGANIZATION_TYPE")
    @JsonProperty("ORGANIZATION_TYPE")
    private String organizationType;

    @Column(name = "EXT_SOURCE_1")
    @JsonProperty("EXT_SOURCE_1")
    private Double extSource1;

    @Column(name = "EXT_SOURCE_2")
    @JsonProperty("EXT_SOURCE_2")
    private Double extSource2;

    @Column(name = "EXT_SOURCE_3")
    @JsonProperty("EXT_SOURCE_3")
    private Double extSource3;

    @Column(name = "APARTMENTS_AVG")
    @JsonProperty("APARTMENTS_AVG")
    private Double apartmentsAvg;

    @Column(name = "BASEMENTAREA_AVG")
    @JsonProperty("BASEMENTAREA_AVG")
    private Double basementareaAvg;

    @Column(name = "YEARS_BEGINEXPLUATATION_AVG")
    @JsonProperty("YEARS_BEGINEXPLUATATION_AVG")
    private Double yearsBeginexpluatationAvg;

    @Column(name = "YEARS_BUILD_AVG")
    @JsonProperty("YEARS_BUILD_AVG")
    private Double yearsBuildAvg;

    @Column(name = "COMMONAREA_AVG")
    @JsonProperty("COMMONAREA_AVG")
    private Double commonareaAvg;

    @Column(name = "ELEVATORS_AVG")
    @JsonProperty("ELEVATORS_AVG")
    private Double elevatorsAvg;

    @Column(name = "ENTRANCES_AVG")
    @JsonProperty("ENTRANCES_AVG")
    private Double entrancesAvg;

    @Column(name = "FLOORSMAX_AVG")
    @JsonProperty("FLOORSMAX_AVG")
    private Double floorsmaxAvg;

    @Column(name = "FLOORSMIN_AVG")
    @JsonProperty("FLOORSMIN_AVG")
    private Double floorsminAvg;

    @Column(name = "LANDAREA_AVG")
    @JsonProperty("LANDAREA_AVG")
    private Double landareaAvg;

    @Column(name = "LIVINGAPARTMENTS_AVG")
    @JsonProperty("LIVINGAPARTMENTS_AVG")
    private Double livingapartmentsAvg;

    @Column(name = "LIVINGAREA_AVG")
    @JsonProperty("LIVINGAREA_AVG")
    private Double livingareaAvg;

    @Column(name = "NONLIVINGAPARTMENTS_AVG")
    @JsonProperty("NONLIVINGAPARTMENTS_AVG")
    private Double nonlivingapartmentsAvg;

    @Column(name = "NONLIVINGAREA_AVG")
    @JsonProperty("NONLIVINGAREA_AVG")
    private Double nonlivingareaAvg;

    @Column(name = "APARTMENTS_MODE")
    @JsonProperty("APARTMENTS_MODE")
    private Double apartmentsMode;

    @Column(name = "BASEMENTAREA_MODE")
    @JsonProperty("BASEMENTAREA_MODE")
    private Double basementareaMode;

    @Column(name = "YEARS_BEGINEXPLUATATION_MODE")
    @JsonProperty("YEARS_BEGINEXPLUATATION_MODE")
    private Double yearsBeginexpluatationMode;

    @Column(name = "YEARS_BUILD_MODE")
    @JsonProperty("YEARS_BUILD_MODE")
    private Double yearsBuildMode;

    @Column(name = "COMMONAREA_MODE")
    @JsonProperty("COMMONAREA_MODE")
    private Double commonareaMode;

    @Column(name = "ELEVATORS_MODE")
    @JsonProperty("ELEVATORS_MODE")
    private Double elevatorsMode;

    @Column(name = "ENTRANCES_MODE")
    @JsonProperty("ENTRANCES_MODE")
    private Double entracesMode;

    @Column(name = "FLOORSMAX_MODE")
    @JsonProperty("FLOORSMAX_MODE")
    private Double floormaxMode;

    @Column(name = "FLOORSMIN_MODE")
    @JsonProperty("FLOORSMIN_MODE")
    private Double floorminMode;

    @Column(name = "LANDAREA_MODE")
    @JsonProperty("LANDAREA_MODE")
    private Double landareaMode;

    @Column(name = "LIVINGAPARTMENTS_MODE")
    @JsonProperty("LIVINGAPARTMENTS_MODE")
    private Double livingapartmentsMode;

    @Column(name = "LIVINGAREA_MODE")
    @JsonProperty("LIVINGAREA_MODE")
    private Double livingareaMode;

    @Column(name = "NONLIVINGAPARTMENTS_MODE")
    @JsonProperty("NONLIVINGAPARTMENTS_MODE")
    private Double nonlivingapartmentsMode;

    @Column(name = "NONLIVINGAREA_MODE")
    @JsonProperty("NONLIVINGAREA_MODE")
    private Double nonlivingareaMode;

    @Column(name = "APARTMENTS_MEDI")
    @JsonProperty("APARTMENTS_MEDI")
    private Double apartmentsMedi;

    @Column(name = "BASEMENTAREA_MEDI")
    @JsonProperty("BASEMENTAREA_MEDI")
    private Double basementareaMedi;

    @Column(name = "YEARS_BEGINEXPLUATATION_MEDI")
    @JsonProperty("YEARS_BEGINEXPLUATATION_MEDI")
    private Double yearsBeginexpluatationMedi;

    @Column(name = "YEARS_BUILD_MEDI")
    @JsonProperty("YEARS_BUILD_MEDI")
    private Double yearsBuildMedi;

    @Column(name = "COMMONAREA_MEDI")
    @JsonProperty("COMMONAREA_MEDI")
    private Double commonareaMedi;

    @Column(name = "ELEVATORS_MEDI")
    @JsonProperty("ELEVATORS_MEDI")
    private Double elevatorsMedi;

    @Column(name = "ENTRANCES_MEDI")
    @JsonProperty("ENTRANCES_MEDI")
    private Double entrancesMedi;

    @Column(name = "FLOORSMAX_MEDI")
    @JsonProperty("FLOORSMAX_MEDI")
    private Double floorsmaxMedi;

    @Column(name = "FLOORSMIN_MEDI")
    @JsonProperty("FLOORSMIN_MEDI")
    private Double floorsminMedi;

    @Column(name = "LANDAREA_MEDI")
    @JsonProperty("LANDAREA_MEDI")
    private Double landareaMedi;

    @Column(name = "LIVINGAPARTMENTS_MEDI")
    @JsonProperty("LIVINGAPARTMENTS_MEDI")
    private Double livingapartmentsMedi;

    @Column(name = "LIVINGAREA_MEDI")
    @JsonProperty("LIVINGAREA_MEDI")
    private Double livingareaMedi;

    @Column(name = "NONLIVINGAPARTMENTS_MEDI")
    @JsonProperty("NONLIVINGAPARTMENTS_MEDI")
    private Double nonlivingapartmentsMedi;

    @Column(name = "NONLIVINGAREA_MEDI")
    @JsonProperty("NONLIVINGAREA_MEDI")
    private Double nonlivingareaMedi;

    @Column(name = "FONDKAPREMONT_MODE")
    @JsonProperty("FONDKAPREMONT_MODE")
    private String fondkapremontMode;

    @Column(name = "HOUSETYPE_MODE")
    @JsonProperty("HOUSETYPE_MODE")
    private String housetypeMode;

    @Column(name = "TOTALAREA_MODE")
    @JsonProperty("TOTALAREA_MODE")
    private Double totalareaMode;

    @Column(name = "WALLSMATERIAL_MODE")
    @JsonProperty("WALLSMATERIAL_MODE")
    private String wallsmaterialMode;

    @Column(name = "EMERGENCYSTATE_MODE")
    @JsonProperty("EMERGENCYSTATE_MODE")
    private String emergencystateMode;

    @Column(name = "OBS_30_CNT_SOCIAL_CIRCLE")
    @JsonProperty("OBS_30_CNT_SOCIAL_CIRCLE")
    private Double osb30CntSocialCircle;

    @Column(name = "DEF_30_CNT_SOCIAL_CIRCLE")
    @JsonProperty("DEF_30_CNT_SOCIAL_CIRCLE")
    private Double def30CntSocialCircle;

    @Column(name = "OBS_60_CNT_SOCIAL_CIRCLE")
    @JsonProperty("OBS_60_CNT_SOCIAL_CIRCLE")
    private Double osb60CntSocialCircle;

    @Column(name = "DEF_60_CNT_SOCIAL_CIRCLE")
    @JsonProperty("DEF_60_CNT_SOCIAL_CIRCLE")
    private Double def60CntSocialCircle;

    @Column(name = "DAYS_LAST_PHONE_CHANGE")
    @JsonProperty("DAYS_LAST_PHONE_CHANGE")
    private Double daysLastPhoneChange;

    @Column(name = "FLAG_DOCUMENT_2")
    @JsonProperty("FLAG_DOCUMENT_2")
    private Integer flagDocument2;

    @Column(name = "FLAG_DOCUMENT_3")
    @JsonProperty("FLAG_DOCUMENT_3")
    private Integer flagDocument3;

    @Column(name = "FLAG_DOCUMENT_4")
    @JsonProperty("FLAG_DOCUMENT_4")
    private Integer flagDocument4;

    @Column(name = "FLAG_DOCUMENT_5")
    @JsonProperty("FLAG_DOCUMENT_5")
    private Integer flagDocument5;

    @Column(name = "FLAG_DOCUMENT_6")
    @JsonProperty("FLAG_DOCUMENT_6")
    private Integer flagDocument6;

    @Column(name = "FLAG_DOCUMENT_7")
    @JsonProperty("FLAG_DOCUMENT_7")
    private Integer flagDocument7;

    @Column(name = "FLAG_DOCUMENT_8")
    @JsonProperty("FLAG_DOCUMENT_8")
    private Integer flagDocument8;

    @Column(name = "FLAG_DOCUMENT_9")
    @JsonProperty("FLAG_DOCUMENT_9")
    private Integer flagDocument9;

    @Column(name = "FLAG_DOCUMENT_10")
    @JsonProperty("FLAG_DOCUMENT_10")
    private Integer flagDocument10;

    @Column(name = "FLAG_DOCUMENT_11")
    @JsonProperty("FLAG_DOCUMENT_11")
    private Integer flagDocument11;

    @Column(name = "FLAG_DOCUMENT_12")
    @JsonProperty("FLAG_DOCUMENT_12")
    private Integer flagDocument12;

    @Column(name = "FLAG_DOCUMENT_13")
    @JsonProperty("FLAG_DOCUMENT_13")
    private Integer flagDocument13;

    @Column(name = "FLAG_DOCUMENT_14")
    @JsonProperty("FLAG_DOCUMENT_14")
    private Integer flagDocument14;

    @Column(name = "FLAG_DOCUMENT_15")
    @JsonProperty("FLAG_DOCUMENT_15")
    private Integer flagDocument15;

    @Column(name = "FLAG_DOCUMENT_16")
    @JsonProperty("FLAG_DOCUMENT_16")
    private Integer flagDocument16;

    @Column(name = "FLAG_DOCUMENT_17")
    @JsonProperty("FLAG_DOCUMENT_17")
    private Integer flagDocument17;

    @Column(name = "FLAG_DOCUMENT_18")
    @JsonProperty("FLAG_DOCUMENT_18")
    private Integer flagDocument18;

    @Column(name = "FLAG_DOCUMENT_19")
    @JsonProperty("FLAG_DOCUMENT_19")
    private Integer flagDocument19;

    @Column(name = "FLAG_DOCUMENT_20")
    @JsonProperty("FLAG_DOCUMENT_20")
    private Integer flagDocument20;

    @Column(name = "FLAG_DOCUMENT_21")
    @JsonProperty("FLAG_DOCUMENT_21")
    private Integer flagDocument21;

    @Column(name = "AMT_REQ_CREDIT_BUREAU_HOUR")
    @JsonProperty("AMT_REQ_CREDIT_BUREAU_HOUR")
    private Double amtReqCreditBureauHour;

    @Column(name = "AMT_REQ_CREDIT_BUREAU_DAY")
    @JsonProperty("AMT_REQ_CREDIT_BUREAU_DAY")
    private Double amtReqCreditBureauDay;

    @Column(name = "AMT_REQ_CREDIT_BUREAU_WEEK")
    @JsonProperty("AMT_REQ_CREDIT_BUREAU_WEEK")
    private Double amtReqCreditBureauWeek;

    @Column(name = "AMT_REQ_CREDIT_BUREAU_MON")
    @JsonProperty("AMT_REQ_CREDIT_BUREAU_MON")
    private Double amtReqCreditBureauMon;

    @Column(name = "AMT_REQ_CREDIT_BUREAU_QRT")
    @JsonProperty("AMT_REQ_CREDIT_BUREAU_QRT")
    private Double antReqCreditBureaQrt;

    @Column(name = "AMT_REQ_CREDIT_BUREAU_YEAR")
    @JsonProperty("AMT_REQ_CREDIT_BUREAU_YEAR")
    private Double amtReqCreditBureauYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getCodeGender() {
        return codeGender;
    }

    public void setCodeGender(String codeGender) {
        this.codeGender = codeGender;
    }

    public String getFlagOwnCar() {
        return flagOwnCar;
    }

    public void setFlagOwnCar(String flagOwnCar) {
        this.flagOwnCar = flagOwnCar;
    }

    public String getFlagOwnRealy() {
        return flagOwnRealy;
    }

    public void setFlagOwnRealy(String flagOwnRealy) {
        this.flagOwnRealy = flagOwnRealy;
    }

    public Integer getCntChildren() {
        return cntChildren;
    }

    public void setCntChildren(Integer cntChildren) {
        this.cntChildren = cntChildren;
    }

    public Double getAmtIncomeTotal() {
        return amtIncomeTotal;
    }

    public void setAmtIncomeTotal(Double amtIncomeTotal) {
        this.amtIncomeTotal = amtIncomeTotal;
    }

    public Double getAmtCredit() {
        return amtCredit;
    }

    public void setAmtCredit(Double amtCredit) {
        this.amtCredit = amtCredit;
    }

    public Double getAmtAnnuity() {
        return amtAnnuity;
    }

    public void setAmtAnnuity(Double amtAnnuity) {
        this.amtAnnuity = amtAnnuity;
    }

    public Double getAmtGoodsPrice() {
        return amtGoodsPrice;
    }

    public void setAmtGoodsPrice(Double amtGoodsPrice) {
        this.amtGoodsPrice = amtGoodsPrice;
    }

    public String getNameTypeSuite() {
        return nameTypeSuite;
    }

    public void setNameTypeSuite(String nameTypeSuite) {
        this.nameTypeSuite = nameTypeSuite;
    }

    public String getNameIncomeType() {
        return nameIncomeType;
    }

    public void setNameIncomeType(String nameIncomeType) {
        this.nameIncomeType = nameIncomeType;
    }

    public String getNameEducationType() {
        return nameEducationType;
    }

    public void setNameEducationType(String nameEducationType) {
        this.nameEducationType = nameEducationType;
    }

    public String getNameFamilyStatus() {
        return nameFamilyStatus;
    }

    public void setNameFamilyStatus(String nameFamilyStatus) {
        this.nameFamilyStatus = nameFamilyStatus;
    }

    public String getNameHousingType() {
        return nameHousingType;
    }

    public void setNameHousingType(String nameHousingType) {
        this.nameHousingType = nameHousingType;
    }

    public Double getRegionPopulationRelative() {
        return regionPopulationRelative;
    }

    public void setRegionPopulationRelative(Double regionPopulationRelative) {
        this.regionPopulationRelative = regionPopulationRelative;
    }

    public Integer getDaysBirth() {
        return daysBirth;
    }

    public void setDaysBirth(Integer daysBirth) {
        this.daysBirth = daysBirth;
    }

    public Integer getDaysEmployed() {
        return daysEmployed;
    }

    public void setDaysEmployed(Integer daysEmployed) {
        this.daysEmployed = daysEmployed;
    }

    public Double getDaysRegistration() {
        return daysRegistration;
    }

    public void setDaysRegistration(Double daysRegistration) {
        this.daysRegistration = daysRegistration;
    }

    public Integer getDaysIdPublished() {
        return daysIdPublished;
    }

    public void setDaysIdPublished(Integer daysIdPublished) {
        this.daysIdPublished = daysIdPublished;
    }

    public Double getOwnCarAge() {
        return ownCarAge;
    }

    public void setOwnCarAge(Double ownCarAge) {
        this.ownCarAge = ownCarAge;
    }

    public Integer getFlagMobil() {
        return flagMobil;
    }

    public void setFlagMobil(Integer flagMobil) {
        this.flagMobil = flagMobil;
    }

    public Integer getFlagEmpPhone() {
        return flagEmpPhone;
    }

    public void setFlagEmpPhone(Integer flagEmpPhone) {
        this.flagEmpPhone = flagEmpPhone;
    }

    public Integer getFlagWorkPhone() {
        return flagWorkPhone;
    }

    public void setFlagWorkPhone(Integer flagWorkPhone) {
        this.flagWorkPhone = flagWorkPhone;
    }

    public Integer getFlagContMobile() {
        return flagContMobile;
    }

    public void setFlagContMobile(Integer flagContMobile) {
        this.flagContMobile = flagContMobile;
    }

    public Integer getFlagPhone() {
        return flagPhone;
    }

    public void setFlagPhone(Integer flagPhone) {
        this.flagPhone = flagPhone;
    }

    public Integer getFlagEmail() {
        return flagEmail;
    }

    public void setFlagEmail(Integer flagEmail) {
        this.flagEmail = flagEmail;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public Double getCntFamMembers() {
        return cntFamMembers;
    }

    public void setCntFamMembers(Double cntFamMembers) {
        this.cntFamMembers = cntFamMembers;
    }

    public Integer getRegionRatingClient() {
        return regionRatingClient;
    }

    public void setRegionRatingClient(Integer regionRatingClient) {
        this.regionRatingClient = regionRatingClient;
    }

    public Integer getRegionRatingClientWCity() {
        return regionRatingClientWCity;
    }

    public void setRegionRatingClientWCity(Integer regionRatingClientWCity) {
        this.regionRatingClientWCity = regionRatingClientWCity;
    }

    public String getApprProcessStart() {
        return apprProcessStart;
    }

    public void setApprProcessStart(String apprProcessStart) {
        this.apprProcessStart = apprProcessStart;
    }

    public Integer getHourApprProcessStart() {
        return hourApprProcessStart;
    }

    public void setHourApprProcessStart(Integer hourApprProcessStart) {
        this.hourApprProcessStart = hourApprProcessStart;
    }

    public Integer getRegRegionNotLiveRegion() {
        return regRegionNotLiveRegion;
    }

    public void setRegRegionNotLiveRegion(Integer regRegionNotLiveRegion) {
        this.regRegionNotLiveRegion = regRegionNotLiveRegion;
    }

    public Integer getRegRegionNotWorkRegion() {
        return regRegionNotWorkRegion;
    }

    public void setRegRegionNotWorkRegion(Integer regRegionNotWorkRegion) {
        this.regRegionNotWorkRegion = regRegionNotWorkRegion;
    }

    public Integer getLiveRegionNotWorkRegion() {
        return liveRegionNotWorkRegion;
    }

    public void setLiveRegionNotWorkRegion(Integer liveRegionNotWorkRegion) {
        this.liveRegionNotWorkRegion = liveRegionNotWorkRegion;
    }

    public Integer getRegCityNotLiveCity() {
        return regCityNotLiveCity;
    }

    public void setRegCityNotLiveCity(Integer regCityNotLiveCity) {
        this.regCityNotLiveCity = regCityNotLiveCity;
    }

    public Integer getRegCityNotWorkCity() {
        return regCityNotWorkCity;
    }

    public void setRegCityNotWorkCity(Integer regCityNotWorkCity) {
        this.regCityNotWorkCity = regCityNotWorkCity;
    }

    public Integer getLiveCityNotWorkCity() {
        return liveCityNotWorkCity;
    }

    public void setLiveCityNotWorkCity(Integer liveCityNotWorkCity) {
        this.liveCityNotWorkCity = liveCityNotWorkCity;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public Double getExtSource1() {
        return extSource1;
    }

    public void setExtSource1(Double extSource1) {
        this.extSource1 = extSource1;
    }

    public Double getExtSource2() {
        return extSource2;
    }

    public void setExtSource2(Double extSource2) {
        this.extSource2 = extSource2;
    }

    public Double getExtSource3() {
        return extSource3;
    }

    public void setExtSource3(Double extSource3) {
        this.extSource3 = extSource3;
    }

    public Double getApartmentsAvg() {
        return apartmentsAvg;
    }

    public void setApartmentsAvg(Double apartmentsAvg) {
        this.apartmentsAvg = apartmentsAvg;
    }

    public Double getBasementareaAvg() {
        return basementareaAvg;
    }

    public void setBasementareaAvg(Double basementareaAvg) {
        this.basementareaAvg = basementareaAvg;
    }

    public Double getYearsBeginexpluatationAvg() {
        return yearsBeginexpluatationAvg;
    }

    public void setYearsBeginexpluatationAvg(Double yearsBeginexpluatationAvg) {
        this.yearsBeginexpluatationAvg = yearsBeginexpluatationAvg;
    }

    public Double getYearsBuildAvg() {
        return yearsBuildAvg;
    }

    public void setYearsBuildAvg(Double yearsBuildAvg) {
        this.yearsBuildAvg = yearsBuildAvg;
    }

    public Double getCommonareaAvg() {
        return commonareaAvg;
    }

    public void setCommonareaAvg(Double commonareaAvg) {
        this.commonareaAvg = commonareaAvg;
    }

    public Double getElevatorsAvg() {
        return elevatorsAvg;
    }

    public void setElevatorsAvg(Double elevatorsAvg) {
        this.elevatorsAvg = elevatorsAvg;
    }

    public Double getEntrancesAvg() {
        return entrancesAvg;
    }

    public void setEntrancesAvg(Double entrancesAvg) {
        this.entrancesAvg = entrancesAvg;
    }

    public Double getFloorsmaxAvg() {
        return floorsmaxAvg;
    }

    public void setFloorsmaxAvg(Double floorsmaxAvg) {
        this.floorsmaxAvg = floorsmaxAvg;
    }

    public Double getFloorsminAvg() {
        return floorsminAvg;
    }

    public void setFloorsminAvg(Double floorsminAvg) {
        this.floorsminAvg = floorsminAvg;
    }

    public Double getLandareaAvg() {
        return landareaAvg;
    }

    public void setLandareaAvg(Double landareaAvg) {
        this.landareaAvg = landareaAvg;
    }

    public Double getLivingapartmentsAvg() {
        return livingapartmentsAvg;
    }

    public void setLivingapartmentsAvg(Double livingapartmentsAvg) {
        this.livingapartmentsAvg = livingapartmentsAvg;
    }

    public Double getLivingareaAvg() {
        return livingareaAvg;
    }

    public void setLivingareaAvg(Double livingareaAvg) {
        this.livingareaAvg = livingareaAvg;
    }

    public Double getNonlivingapartmentsAvg() {
        return nonlivingapartmentsAvg;
    }

    public void setNonlivingapartmentsAvg(Double nonlivingapartmentsAvg) {
        this.nonlivingapartmentsAvg = nonlivingapartmentsAvg;
    }

    public Double getNonlivingareaAvg() {
        return nonlivingareaAvg;
    }

    public void setNonlivingareaAvg(Double nonlivingareaAvg) {
        this.nonlivingareaAvg = nonlivingareaAvg;
    }

    public Double getApartmentsMode() {
        return apartmentsMode;
    }

    public void setApartmentsMode(Double apartmentsMode) {
        this.apartmentsMode = apartmentsMode;
    }

    public Double getBasementareaMode() {
        return basementareaMode;
    }

    public void setBasementareaMode(Double basementareaMode) {
        this.basementareaMode = basementareaMode;
    }

    public Double getYearsBeginexpluatationMode() {
        return yearsBeginexpluatationMode;
    }

    public void setYearsBeginexpluatationMode(Double yearsBeginexpluatationMode) {
        this.yearsBeginexpluatationMode = yearsBeginexpluatationMode;
    }

    public Double getYearsBuildMode() {
        return yearsBuildMode;
    }

    public void setYearsBuildMode(Double yearsBuildMode) {
        this.yearsBuildMode = yearsBuildMode;
    }

    public Double getCommonareaMode() {
        return commonareaMode;
    }

    public void setCommonareaMode(Double commonareaMode) {
        this.commonareaMode = commonareaMode;
    }

    public Double getElevatorsMode() {
        return elevatorsMode;
    }

    public void setElevatorsMode(Double elevatorsMode) {
        this.elevatorsMode = elevatorsMode;
    }

    public Double getEntracesMode() {
        return entracesMode;
    }

    public void setEntracesMode(Double entracesMode) {
        this.entracesMode = entracesMode;
    }

    public Double getFloormaxMode() {
        return floormaxMode;
    }

    public void setFloormaxMode(Double floormaxMode) {
        this.floormaxMode = floormaxMode;
    }

    public Double getFloorminMode() {
        return floorminMode;
    }

    public void setFloorminMode(Double floorminMode) {
        this.floorminMode = floorminMode;
    }

    public Double getLandareaMode() {
        return landareaMode;
    }

    public void setLandareaMode(Double landareaMode) {
        this.landareaMode = landareaMode;
    }

    public Double getLivingapartmentsMode() {
        return livingapartmentsMode;
    }

    public void setLivingapartmentsMode(Double livingapartmentsMode) {
        this.livingapartmentsMode = livingapartmentsMode;
    }

    public Double getLivingareaMode() {
        return livingareaMode;
    }

    public void setLivingareaMode(Double livingareaMode) {
        this.livingareaMode = livingareaMode;
    }

    public Double getNonlivingapartmentsMode() {
        return nonlivingapartmentsMode;
    }

    public void setNonlivingapartmentsMode(Double nonlivingapartmentsMode) {
        this.nonlivingapartmentsMode = nonlivingapartmentsMode;
    }

    public Double getNonlivingareaMode() {
        return nonlivingareaMode;
    }

    public void setNonlivingareaMode(Double nonlivingareaMode) {
        this.nonlivingareaMode = nonlivingareaMode;
    }

    public Double getApartmentsMedi() {
        return apartmentsMedi;
    }

    public void setApartmentsMedi(Double apartmentsMedi) {
        this.apartmentsMedi = apartmentsMedi;
    }

    public Double getBasementareaMedi() {
        return basementareaMedi;
    }

    public void setBasementareaMedi(Double basementareaMedi) {
        this.basementareaMedi = basementareaMedi;
    }

    public Double getYearsBeginexpluatationMedi() {
        return yearsBeginexpluatationMedi;
    }

    public void setYearsBeginexpluatationMedi(Double yearsBeginexpluatationMedi) {
        this.yearsBeginexpluatationMedi = yearsBeginexpluatationMedi;
    }

    public Double getYearsBuildMedi() {
        return yearsBuildMedi;
    }

    public void setYearsBuildMedi(Double yearsBuildMedi) {
        this.yearsBuildMedi = yearsBuildMedi;
    }

    public Double getCommonareaMedi() {
        return commonareaMedi;
    }

    public void setCommonareaMedi(Double commonareaMedi) {
        this.commonareaMedi = commonareaMedi;
    }

    public Double getElevatorsMedi() {
        return elevatorsMedi;
    }

    public void setElevatorsMedi(Double elevatorsMedi) {
        this.elevatorsMedi = elevatorsMedi;
    }

    public Double getEntrancesMedi() {
        return entrancesMedi;
    }

    public void setEntrancesMedi(Double entrancesMedi) {
        this.entrancesMedi = entrancesMedi;
    }

    public Double getFloorsmaxMedi() {
        return floorsmaxMedi;
    }

    public void setFloorsmaxMedi(Double floorsmaxMedi) {
        this.floorsmaxMedi = floorsmaxMedi;
    }

    public Double getFloorsminMedi() {
        return floorsminMedi;
    }

    public void setFloorsminMedi(Double floorsminMedi) {
        this.floorsminMedi = floorsminMedi;
    }

    public Double getLandareaMedi() {
        return landareaMedi;
    }

    public void setLandareaMedi(Double landareaMedi) {
        this.landareaMedi = landareaMedi;
    }

    public Double getLivingapartmentsMedi() {
        return livingapartmentsMedi;
    }

    public void setLivingapartmentsMedi(Double livingapartmentsMedi) {
        this.livingapartmentsMedi = livingapartmentsMedi;
    }

    public Double getLivingareaMedi() {
        return livingareaMedi;
    }

    public void setLivingareaMedi(Double livingareaMedi) {
        this.livingareaMedi = livingareaMedi;
    }

    public Double getNonlivingapartmentsMedi() {
        return nonlivingapartmentsMedi;
    }

    public void setNonlivingapartmentsMedi(Double nonlivingapartmentsMedi) {
        this.nonlivingapartmentsMedi = nonlivingapartmentsMedi;
    }

    public Double getNonlivingareaMedi() {
        return nonlivingareaMedi;
    }

    public void setNonlivingareaMedi(Double nonlivingareaMedi) {
        this.nonlivingareaMedi = nonlivingareaMedi;
    }

    public String getFondkapremontMode() {
        return fondkapremontMode;
    }

    public void setFondkapremontMode(String fondkapremontMode) {
        this.fondkapremontMode = fondkapremontMode;
    }

    public String getHousetypeMode() {
        return housetypeMode;
    }

    public void setHousetypeMode(String housetypeMode) {
        this.housetypeMode = housetypeMode;
    }

    public Double getTotalareaMode() {
        return totalareaMode;
    }

    public void setTotalareaMode(Double totalareaMode) {
        this.totalareaMode = totalareaMode;
    }

    public String getWallsmaterialMode() {
        return wallsmaterialMode;
    }

    public void setWallsmaterialMode(String wallsmaterialMode) {
        this.wallsmaterialMode = wallsmaterialMode;
    }

    public String getEmergencystateMode() {
        return emergencystateMode;
    }

    public void setEmergencystateMode(String emergencystateMode) {
        this.emergencystateMode = emergencystateMode;
    }

    public Double getOsb30CntSocialCircle() {
        return osb30CntSocialCircle;
    }

    public void setOsb30CntSocialCircle(Double osb30CntSocialCircle) {
        this.osb30CntSocialCircle = osb30CntSocialCircle;
    }

    public Double getDef30CntSocialCircle() {
        return def30CntSocialCircle;
    }

    public void setDef30CntSocialCircle(Double def30CntSocialCircle) {
        this.def30CntSocialCircle = def30CntSocialCircle;
    }

    public Double getOsb60CntSocialCircle() {
        return osb60CntSocialCircle;
    }

    public void setOsb60CntSocialCircle(Double osb60CntSocialCircle) {
        this.osb60CntSocialCircle = osb60CntSocialCircle;
    }

    public Double getDef60CntSocialCircle() {
        return def60CntSocialCircle;
    }

    public void setDef60CntSocialCircle(Double def60CntSocialCircle) {
        this.def60CntSocialCircle = def60CntSocialCircle;
    }

    public Double getDaysLastPhoneChange() {
        return daysLastPhoneChange;
    }

    public void setDaysLastPhoneChange(Double daysLastPhoneChange) {
        this.daysLastPhoneChange = daysLastPhoneChange;
    }

    public Integer getFlagDocument2() {
        return flagDocument2;
    }

    public void setFlagDocument2(Integer flagDocument2) {
        this.flagDocument2 = flagDocument2;
    }

    public Integer getFlagDocument3() {
        return flagDocument3;
    }

    public void setFlagDocument3(Integer flagDocument3) {
        this.flagDocument3 = flagDocument3;
    }

    public Integer getFlagDocument4() {
        return flagDocument4;
    }

    public void setFlagDocument4(Integer flagDocument4) {
        this.flagDocument4 = flagDocument4;
    }

    public Integer getFlagDocument5() {
        return flagDocument5;
    }

    public void setFlagDocument5(Integer flagDocument5) {
        this.flagDocument5 = flagDocument5;
    }

    public Integer getFlagDocument6() {
        return flagDocument6;
    }

    public void setFlagDocument6(Integer flagDocument6) {
        this.flagDocument6 = flagDocument6;
    }

    public Integer getFlagDocument7() {
        return flagDocument7;
    }

    public void setFlagDocument7(Integer flagDocument7) {
        this.flagDocument7 = flagDocument7;
    }

    public Integer getFlagDocument8() {
        return flagDocument8;
    }

    public void setFlagDocument8(Integer flagDocument8) {
        this.flagDocument8 = flagDocument8;
    }

    public Integer getFlagDocument9() {
        return flagDocument9;
    }

    public void setFlagDocument9(Integer flagDocument9) {
        this.flagDocument9 = flagDocument9;
    }

    public Integer getFlagDocument10() {
        return flagDocument10;
    }

    public void setFlagDocument10(Integer flagDocument10) {
        this.flagDocument10 = flagDocument10;
    }

    public Integer getFlagDocument11() {
        return flagDocument11;
    }

    public void setFlagDocument11(Integer flagDocument11) {
        this.flagDocument11 = flagDocument11;
    }

    public Integer getFlagDocument12() {
        return flagDocument12;
    }

    public void setFlagDocument12(Integer flagDocument12) {
        this.flagDocument12 = flagDocument12;
    }

    public Integer getFlagDocument13() {
        return flagDocument13;
    }

    public void setFlagDocument13(Integer flagDocument13) {
        this.flagDocument13 = flagDocument13;
    }

    public Integer getFlagDocument14() {
        return flagDocument14;
    }

    public void setFlagDocument14(Integer flagDocument14) {
        this.flagDocument14 = flagDocument14;
    }

    public Integer getFlagDocument15() {
        return flagDocument15;
    }

    public void setFlagDocument15(Integer flagDocument15) {
        this.flagDocument15 = flagDocument15;
    }

    public Integer getFlagDocument16() {
        return flagDocument16;
    }

    public void setFlagDocument16(Integer flagDocument16) {
        this.flagDocument16 = flagDocument16;
    }

    public Integer getFlagDocument17() {
        return flagDocument17;
    }

    public void setFlagDocument17(Integer flagDocument17) {
        this.flagDocument17 = flagDocument17;
    }

    public Integer getFlagDocument18() {
        return flagDocument18;
    }

    public void setFlagDocument18(Integer flagDocument18) {
        this.flagDocument18 = flagDocument18;
    }

    public Integer getFlagDocument19() {
        return flagDocument19;
    }

    public void setFlagDocument19(Integer flagDocument19) {
        this.flagDocument19 = flagDocument19;
    }

    public Integer getFlagDocument20() {
        return flagDocument20;
    }

    public void setFlagDocument20(Integer flagDocument20) {
        this.flagDocument20 = flagDocument20;
    }

    public Integer getFlagDocument21() {
        return flagDocument21;
    }

    public void setFlagDocument21(Integer flagDocument21) {
        this.flagDocument21 = flagDocument21;
    }

    public Double getAmtReqCreditBureauHour() {
        return amtReqCreditBureauHour;
    }

    public void setAmtReqCreditBureauHour(Double amtReqCreditBureauHour) {
        this.amtReqCreditBureauHour = amtReqCreditBureauHour;
    }

    public Double getAmtReqCreditBureauDay() {
        return amtReqCreditBureauDay;
    }

    public void setAmtReqCreditBureauDay(Double amtReqCreditBureauDay) {
        this.amtReqCreditBureauDay = amtReqCreditBureauDay;
    }

    public Double getAmtReqCreditBureauWeek() {
        return amtReqCreditBureauWeek;
    }

    public void setAmtReqCreditBureauWeek(Double amtReqCreditBureauWeek) {
        this.amtReqCreditBureauWeek = amtReqCreditBureauWeek;
    }

    public Double getAmtReqCreditBureauMon() {
        return amtReqCreditBureauMon;
    }

    public void setAmtReqCreditBureauMon(Double amtReqCreditBureauMon) {
        this.amtReqCreditBureauMon = amtReqCreditBureauMon;
    }

    public Double getAntReqCreditBureaQrt() {
        return antReqCreditBureaQrt;
    }

    public void setAntReqCreditBureaQrt(Double antReqCreditBureaQrt) {
        this.antReqCreditBureaQrt = antReqCreditBureaQrt;
    }

    public Double getAmtReqCreditBureauYear() {
        return amtReqCreditBureauYear;
    }

    public void setAmtReqCreditBureauYear(Double amtReqCreditBureauYear) {
        this.amtReqCreditBureauYear = amtReqCreditBureauYear;
    }
}
