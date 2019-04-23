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

public class Application implements Identifiable<Long>, Serializable {

    @AffinityKeyMapped
    @JsonProperty("SK_ID_CURR")
    private Long id;

    @JsonProperty("TARGET")
    private Long target;

    @JsonProperty("NAME_CONTRACT_TYPE")
    private String contractType;

    @JsonProperty("CODE_GENDER")
    private String codeGender;

    @JsonProperty("FLAG_OWN_CAR")
    private String flagOwnCar;

    @JsonProperty("FLAG_OWN_REALTY")
    private String flagOwnRealy;

    @JsonProperty("CNT_CHILDREN")
    private Long cntChildren;

    @JsonProperty("AMT_INCOME_TOTAL")
    private Double amtIncomeTotal;

    @JsonProperty("AMT_CREDIT")
    private Double amtCredit;

    @JsonProperty("AMT_ANNUITY")
    private Double amtAnnuity;

    @JsonProperty("AMT_GOODS_PRICE")
    private Double amtGoodsPrice;

    @JsonProperty("NAME_TYPE_SUITE")
    private String nameTypeSuite;

    @JsonProperty("NAME_INCOME_TYPE")
    private String nameIncomeType;

    @JsonProperty("NAME_EDUCATION_TYPE")
    private String nameEducationType;

    @JsonProperty("NAME_FAMILY_STATUS")
    private String nameFamilyStatus;

    @JsonProperty("NAME_HOUSING_TYPE")
    private String nameHousingType;

    @JsonProperty("REGION_POPULATION_RELATIVE")
    private Double regionPopulationRelative;

    @JsonProperty("DAYS_BIRTH")
    private Long daysBirth;

    @JsonProperty("DAYS_EMPLOYED")
    private Long daysEmployed;

    @JsonProperty("DAYS_REGISTRATION")
    private Double daysRegistration;

    @JsonProperty("DAYS_ID_PUBLISH")
    private Long daysIdPublished;

    @JsonProperty("OWN_CAR_AGE")
    private Double ownCarAge;

    @JsonProperty("FLAG_MOBIL")
    private Long flagMobil;

    @JsonProperty("FLAG_EMP_PHONE")
    private Long flagEmpPhone;

    @JsonProperty("FLAG_WORK_PHONE")
    private Long flagWorkPhone;

    @JsonProperty("FLAG_CONT_MOBILE")
    private Long flagContMobile;

    @JsonProperty("FLAG_PHONE")
    private Long flagPhone;

    @JsonProperty("FLAG_EMAIL")
    private Long flagEmail;

    @JsonProperty("OCCUPATION_TYPE")
    private String occupationType;

    @JsonProperty("CNT_FAM_MEMBERS")
    private Double cntFamMembers;

    @JsonProperty("REGION_RATING_CLIENT")
    private Long regionRatingClient;

    @JsonProperty("REGION_RATING_CLIENT_W_CITY")
    private Long regionRatingClientWCity;

    @JsonProperty("WEEKDAY_APPR_PROCESS_START")
    private String apprProcessStart;

    @JsonProperty("HOUR_APPR_PROCESS_START")
    private Long hourApprProcessStart;

    @JsonProperty("REG_REGION_NOT_LIVE_REGION")
    private Long regRegionNotLiveRegion;

    @JsonProperty("REG_REGION_NOT_WORK_REGION")
    private Long regRegionNotWorkRegion;

    @JsonProperty("LIVE_REGION_NOT_WORK_REGION")
    private Long liveRegionNotWorkRegion;

    @JsonProperty("REG_CITY_NOT_LIVE_CITY")
    private Long regCityNotLiveCity;

    @JsonProperty("REG_CITY_NOT_WORK_CITY")
    private Long regCityNotWorkCity;

    @JsonProperty("LIVE_CITY_NOT_WORK_CITY")
    private Long liveCityNotWorkCity;

    @JsonProperty("ORGANIZATION_TYPE")
    private String organizationType;

    @JsonProperty("EXT_SOURCE_1")
    private Double extSource1;

    @JsonProperty("EXT_SOURCE_2")
    private Double extSource2;

    @JsonProperty("EXT_SOURCE_3")
    private Double extSource3;

    @JsonProperty("APARTMENTS_AVG")
    private Double apartmentsAvg;

    @JsonProperty("BASEMENTAREA_AVG")
    private Double basementareaAvg;

    @JsonProperty("YEARS_BEGINEXPLUATATION_AVG")
    private Double yearsBeginexpluatationAvg;

    @JsonProperty("YEARS_BUILD_AVG")
    private Double yearsBuildAvg;

    @JsonProperty("COMMONAREA_AVG")
    private Double commonareaAvg;

    @JsonProperty("ELEVATORS_AVG")
    private Double elevatorsAvg;

    @JsonProperty("ENTRANCES_AVG")
    private Double entrancesAvg;

    @JsonProperty("FLOORSMAX_AVG")
    private Double floorsmaxAvg;

    @JsonProperty("FLOORSMIN_AVG")
    private Double floorsminAvg;

    @JsonProperty("LANDAREA_AVG")
    private Double landareaAvg;

    @JsonProperty("LIVINGAPARTMENTS_AVG")
    private Double livingapartmentsAvg;

    @JsonProperty("LIVINGAREA_AVG")
    private Double livingareaAvg;

    @JsonProperty("NONLIVINGAPARTMENTS_AVG")
    private Double nonlivingapartmentsAvg;

    @JsonProperty("NONLIVINGAREA_AVG")
    private Double nonlivingareaAvg;

    @JsonProperty("APARTMENTS_MODE")
    private Double apartmentsMode;

    @JsonProperty("BASEMENTAREA_MODE")
    private Double basementareaMode;

    @JsonProperty("YEARS_BEGINEXPLUATATION_MODE")
    private Double yearsBeginexpluatationMode;

    @JsonProperty("YEARS_BUILD_MODE")
    private Double yearsBuildMode;

    @JsonProperty("COMMONAREA_MODE")
    private Double commonareaMode;

    @JsonProperty("ELEVATORS_MODE")
    private Double elevatorsMode;

    @JsonProperty("ENTRANCES_MODE")
    private Double entracesMode;

    @JsonProperty("FLOORSMAX_MODE")
    private Double floormaxMode;

    @JsonProperty("FLOORSMIN_MODE")
    private Double floorminMode;

    @JsonProperty("LANDAREA_MODE")
    private Double landareaMode;

    @JsonProperty("LIVINGAPARTMENTS_MODE")
    private Double livingapartmentsMode;

    @JsonProperty("LIVINGAREA_MODE")
    private Double livingareaMode;

    @JsonProperty("NONLIVINGAPARTMENTS_MODE")
    private Double nonlivingapartmentsMode;

    @JsonProperty("NONLIVINGAREA_MODE")
    private Double nonlivingareaMode;

    @JsonProperty("APARTMENTS_MEDI")
    private Double apartmentsMedi;

    @JsonProperty("BASEMENTAREA_MEDI")
    private Double basementareaMedi;

    @JsonProperty("YEARS_BEGINEXPLUATATION_MEDI")
    private Double yearsBeginexpluatationMedi;

    @JsonProperty("YEARS_BUILD_MEDI")
    private Double yearsBuildMedi;

    @JsonProperty("COMMONAREA_MEDI")
    private Double commonareaMedi;

    @JsonProperty("ELEVATORS_MEDI")
    private Double elevatorsMedi;

    @JsonProperty("ENTRANCES_MEDI")
    private Double entrancesMedi;

    @JsonProperty("FLOORSMAX_MEDI")
    private Double floorsmaxMedi;

    @JsonProperty("FLOORSMIN_MEDI")
    private Double floorsminMedi;

    @JsonProperty("LANDAREA_MEDI")
    private Double landareaMedi;

    @JsonProperty("LIVINGAPARTMENTS_MEDI")
    private Double livingapartmentsMedi;

    @JsonProperty("LIVINGAREA_MEDI")
    private Double livingareaMedi;

    @JsonProperty("NONLIVINGAPARTMENTS_MEDI")
    private Double nonlivingapartmentsMedi;

    @JsonProperty("NONLIVINGAREA_MEDI")
    private Double nonlivingareaMedi;

    @JsonProperty("FONDKAPREMONT_MODE")
    private String fondkapremontMode;

    @JsonProperty("HOUSETYPE_MODE")
    private String housetypeMode;

    @JsonProperty("TOTALAREA_MODE")
    private Double totalareaMode;

    @JsonProperty("WALLSMATERIAL_MODE")
    private String wallsmaterialMode;

    @JsonProperty("EMERGENCYSTATE_MODE")
    private String emergencystateMode;

    @JsonProperty("OBS_30_CNT_SOCIAL_CIRCLE")
    private Double osb30CntSocialCircle;

    @JsonProperty("DEF_30_CNT_SOCIAL_CIRCLE")
    private Double def30CntSocialCircle;

    @JsonProperty("OBS_60_CNT_SOCIAL_CIRCLE")
    private Double osb60CntSocialCircle;

    @JsonProperty("DEF_60_CNT_SOCIAL_CIRCLE")
    private Double def60CntSocialCircle;

    @JsonProperty("DAYS_LAST_PHONE_CHANGE")
    private Double daysLastPhoneChange;

    @JsonProperty("FLAG_DOCUMENT_2")
    private Long flagDocument2;

    @JsonProperty("FLAG_DOCUMENT_3")
    private Long flagDocument3;

    @JsonProperty("FLAG_DOCUMENT_4")
    private Long flagDocument4;

    @JsonProperty("FLAG_DOCUMENT_5")
    private Long flagDocument5;

    @JsonProperty("FLAG_DOCUMENT_6")
    private Long flagDocument6;

    @JsonProperty("FLAG_DOCUMENT_7")
    private Long flagDocument7;

    @JsonProperty("FLAG_DOCUMENT_8")
    private Long flagDocument8;

    @JsonProperty("FLAG_DOCUMENT_9")
    private Long flagDocument9;

    @JsonProperty("FLAG_DOCUMENT_10")
    private Long flagDocument10;

    @JsonProperty("FLAG_DOCUMENT_11")
    private Long flagDocument11;

    @JsonProperty("FLAG_DOCUMENT_12")
    private Long flagDocument12;

    @JsonProperty("FLAG_DOCUMENT_13")
    private Long flagDocument13;

    @JsonProperty("FLAG_DOCUMENT_14")
    private Long flagDocument14;

    @JsonProperty("FLAG_DOCUMENT_15")
    private Long flagDocument15;

    @JsonProperty("FLAG_DOCUMENT_16")
    private Long flagDocument16;

    @JsonProperty("FLAG_DOCUMENT_17")
    private Long flagDocument17;

    @JsonProperty("FLAG_DOCUMENT_18")
    private Long flagDocument18;

    @JsonProperty("FLAG_DOCUMENT_19")
    private Long flagDocument19;

    @JsonProperty("FLAG_DOCUMENT_20")
    private Long flagDocument20;

    @JsonProperty("FLAG_DOCUMENT_21")
    private Long flagDocument21;

    @JsonProperty("AMT_REQ_CREDIT_BUREAU_HOUR")
    private Double amtReqCreditBureauHour;

    @JsonProperty("AMT_REQ_CREDIT_BUREAU_DAY")
    private Double amtReqCreditBureauDay;

    @JsonProperty("AMT_REQ_CREDIT_BUREAU_WEEK")
    private Double amtReqCreditBureauWeek;

    @JsonProperty("AMT_REQ_CREDIT_BUREAU_MON")
    private Double amtReqCreditBureauMon;

    @JsonProperty("AMT_REQ_CREDIT_BUREAU_QRT")
    private Double antReqCreditBureaQrt;

    @JsonProperty("AMT_REQ_CREDIT_BUREAU_YEAR")
    private Double amtReqCreditBureauYear;

    @Override public Long key() {
        return id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
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

    public Long getCntChildren() {
        return cntChildren;
    }

    public void setCntChildren(Long cntChildren) {
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

    public Long getDaysBirth() {
        return daysBirth;
    }

    public void setDaysBirth(Long daysBirth) {
        this.daysBirth = daysBirth;
    }

    public Long getDaysEmployed() {
        return daysEmployed;
    }

    public void setDaysEmployed(Long daysEmployed) {
        this.daysEmployed = daysEmployed;
    }

    public Double getDaysRegistration() {
        return daysRegistration;
    }

    public void setDaysRegistration(Double daysRegistration) {
        this.daysRegistration = daysRegistration;
    }

    public Long getDaysIdPublished() {
        return daysIdPublished;
    }

    public void setDaysIdPublished(Long daysIdPublished) {
        this.daysIdPublished = daysIdPublished;
    }

    public Double getOwnCarAge() {
        return ownCarAge;
    }

    public void setOwnCarAge(Double ownCarAge) {
        this.ownCarAge = ownCarAge;
    }

    public Long getFlagMobil() {
        return flagMobil;
    }

    public void setFlagMobil(Long flagMobil) {
        this.flagMobil = flagMobil;
    }

    public Long getFlagEmpPhone() {
        return flagEmpPhone;
    }

    public void setFlagEmpPhone(Long flagEmpPhone) {
        this.flagEmpPhone = flagEmpPhone;
    }

    public Long getFlagWorkPhone() {
        return flagWorkPhone;
    }

    public void setFlagWorkPhone(Long flagWorkPhone) {
        this.flagWorkPhone = flagWorkPhone;
    }

    public Long getFlagContMobile() {
        return flagContMobile;
    }

    public void setFlagContMobile(Long flagContMobile) {
        this.flagContMobile = flagContMobile;
    }

    public Long getFlagPhone() {
        return flagPhone;
    }

    public void setFlagPhone(Long flagPhone) {
        this.flagPhone = flagPhone;
    }

    public Long getFlagEmail() {
        return flagEmail;
    }

    public void setFlagEmail(Long flagEmail) {
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

    public Long getRegionRatingClient() {
        return regionRatingClient;
    }

    public void setRegionRatingClient(Long regionRatingClient) {
        this.regionRatingClient = regionRatingClient;
    }

    public Long getRegionRatingClientWCity() {
        return regionRatingClientWCity;
    }

    public void setRegionRatingClientWCity(Long regionRatingClientWCity) {
        this.regionRatingClientWCity = regionRatingClientWCity;
    }

    public String getApprProcessStart() {
        return apprProcessStart;
    }

    public void setApprProcessStart(String apprProcessStart) {
        this.apprProcessStart = apprProcessStart;
    }

    public Long getHourApprProcessStart() {
        return hourApprProcessStart;
    }

    public void setHourApprProcessStart(Long hourApprProcessStart) {
        this.hourApprProcessStart = hourApprProcessStart;
    }

    public Long getRegRegionNotLiveRegion() {
        return regRegionNotLiveRegion;
    }

    public void setRegRegionNotLiveRegion(Long regRegionNotLiveRegion) {
        this.regRegionNotLiveRegion = regRegionNotLiveRegion;
    }

    public Long getRegRegionNotWorkRegion() {
        return regRegionNotWorkRegion;
    }

    public void setRegRegionNotWorkRegion(Long regRegionNotWorkRegion) {
        this.regRegionNotWorkRegion = regRegionNotWorkRegion;
    }

    public Long getLiveRegionNotWorkRegion() {
        return liveRegionNotWorkRegion;
    }

    public void setLiveRegionNotWorkRegion(Long liveRegionNotWorkRegion) {
        this.liveRegionNotWorkRegion = liveRegionNotWorkRegion;
    }

    public Long getRegCityNotLiveCity() {
        return regCityNotLiveCity;
    }

    public void setRegCityNotLiveCity(Long regCityNotLiveCity) {
        this.regCityNotLiveCity = regCityNotLiveCity;
    }

    public Long getRegCityNotWorkCity() {
        return regCityNotWorkCity;
    }

    public void setRegCityNotWorkCity(Long regCityNotWorkCity) {
        this.regCityNotWorkCity = regCityNotWorkCity;
    }

    public Long getLiveCityNotWorkCity() {
        return liveCityNotWorkCity;
    }

    public void setLiveCityNotWorkCity(Long liveCityNotWorkCity) {
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

    public Long getFlagDocument2() {
        return flagDocument2;
    }

    public void setFlagDocument2(Long flagDocument2) {
        this.flagDocument2 = flagDocument2;
    }

    public Long getFlagDocument3() {
        return flagDocument3;
    }

    public void setFlagDocument3(Long flagDocument3) {
        this.flagDocument3 = flagDocument3;
    }

    public Long getFlagDocument4() {
        return flagDocument4;
    }

    public void setFlagDocument4(Long flagDocument4) {
        this.flagDocument4 = flagDocument4;
    }

    public Long getFlagDocument5() {
        return flagDocument5;
    }

    public void setFlagDocument5(Long flagDocument5) {
        this.flagDocument5 = flagDocument5;
    }

    public Long getFlagDocument6() {
        return flagDocument6;
    }

    public void setFlagDocument6(Long flagDocument6) {
        this.flagDocument6 = flagDocument6;
    }

    public Long getFlagDocument7() {
        return flagDocument7;
    }

    public void setFlagDocument7(Long flagDocument7) {
        this.flagDocument7 = flagDocument7;
    }

    public Long getFlagDocument8() {
        return flagDocument8;
    }

    public void setFlagDocument8(Long flagDocument8) {
        this.flagDocument8 = flagDocument8;
    }

    public Long getFlagDocument9() {
        return flagDocument9;
    }

    public void setFlagDocument9(Long flagDocument9) {
        this.flagDocument9 = flagDocument9;
    }

    public Long getFlagDocument10() {
        return flagDocument10;
    }

    public void setFlagDocument10(Long flagDocument10) {
        this.flagDocument10 = flagDocument10;
    }

    public Long getFlagDocument11() {
        return flagDocument11;
    }

    public void setFlagDocument11(Long flagDocument11) {
        this.flagDocument11 = flagDocument11;
    }

    public Long getFlagDocument12() {
        return flagDocument12;
    }

    public void setFlagDocument12(Long flagDocument12) {
        this.flagDocument12 = flagDocument12;
    }

    public Long getFlagDocument13() {
        return flagDocument13;
    }

    public void setFlagDocument13(Long flagDocument13) {
        this.flagDocument13 = flagDocument13;
    }

    public Long getFlagDocument14() {
        return flagDocument14;
    }

    public void setFlagDocument14(Long flagDocument14) {
        this.flagDocument14 = flagDocument14;
    }

    public Long getFlagDocument15() {
        return flagDocument15;
    }

    public void setFlagDocument15(Long flagDocument15) {
        this.flagDocument15 = flagDocument15;
    }

    public Long getFlagDocument16() {
        return flagDocument16;
    }

    public void setFlagDocument16(Long flagDocument16) {
        this.flagDocument16 = flagDocument16;
    }

    public Long getFlagDocument17() {
        return flagDocument17;
    }

    public void setFlagDocument17(Long flagDocument17) {
        this.flagDocument17 = flagDocument17;
    }

    public Long getFlagDocument18() {
        return flagDocument18;
    }

    public void setFlagDocument18(Long flagDocument18) {
        this.flagDocument18 = flagDocument18;
    }

    public Long getFlagDocument19() {
        return flagDocument19;
    }

    public void setFlagDocument19(Long flagDocument19) {
        this.flagDocument19 = flagDocument19;
    }

    public Long getFlagDocument20() {
        return flagDocument20;
    }

    public void setFlagDocument20(Long flagDocument20) {
        this.flagDocument20 = flagDocument20;
    }

    public Long getFlagDocument21() {
        return flagDocument21;
    }

    public void setFlagDocument21(Long flagDocument21) {
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
