package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmBranch;
import com.dcits.deposit.entity.FmBranchExample;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.IndividualFlag;

public final class FmBranchValueUtil {
    private FmBranchValueUtil() {
    }

    public static FmBranchEO entityToEo(FmBranch entity) {
        if (entity == null) {
            return null;
        }
        FmBranchEO eo = new FmBranchEO();
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setBranchName(entity.getBranchName());
        eo.setBranchShort(entity.getBranchShort());
        eo.setBranchType(BranchType.byValue(entity.getBranchType()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setInternalClient(entity.getInternalClient());
        eo.setHierarchyCode(HierarchyCode.byValue(entity.getHierarchyCode()));
        eo.setAttachedTo(AcctBranch.byValue(entity.getAttachedTo()));
        eo.setSubBranchCode(AcctBranch.byValue(entity.getSubBranchCode()));
        eo.setFtaFlag(IndividualFlag.byValue(entity.getFtaFlag()));
        eo.setFtaCode(entity.getFtaCode());
        eo.setProfitCenter(ProfitCenter.byValue(entity.getProfitCenter()));
        eo.setIpAddr(entity.getIpAddr());
        eo.setCountry(IssCountry.byValue(entity.getCountry()));
        eo.setState(OthBranchRegionalismCode.byValue(entity.getState()));
        eo.setCity(City.byValue(entity.getCity()));
        eo.setPostalCode(entity.getPostalCode());
        eo.setDistrict(OthBranchRegionalismCode.byValue(entity.getDistrict()));
        eo.setAreaCode(entity.getAreaCode());
        eo.setFxOrganCode(entity.getFxOrganCode());
        eo.setCreateDate(entity.getCreateDate());
        eo.setStartDate(entity.getStartDate());
        eo.setEndDate(entity.getEndDate());
        eo.setEodFlag(entity.getEodFlag());
        eo.setCityBranchFlag(IndividualFlag.byValue(entity.getCityBranchFlag()));
        eo.setPbocFinancingNo(entity.getPbocFinancingNo());
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static FmBranch eoToEntity(FmBranchEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranch entity = new FmBranch();
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setBranchName(eo.getBranchName());
        entity.setBranchShort(eo.getBranchShort());
        entity.setBranchType(eo.getBranchType() == null ? null : eo.getBranchType().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setInternalClient(eo.getInternalClient());
        entity.setHierarchyCode(eo.getHierarchyCode() == null ? null : eo.getHierarchyCode().getValue());
        entity.setAttachedTo(eo.getAttachedTo() == null ? null : eo.getAttachedTo().getValue());
        entity.setSubBranchCode(eo.getSubBranchCode() == null ? null : eo.getSubBranchCode().getValue());
        entity.setFtaFlag(eo.getFtaFlag() == null ? null : eo.getFtaFlag().getValue());
        entity.setFtaCode(eo.getFtaCode());
        entity.setProfitCenter(eo.getProfitCenter() == null ? null : eo.getProfitCenter().getValue());
        entity.setIpAddr(eo.getIpAddr());
        entity.setCountry(eo.getCountry() == null ? null : eo.getCountry().getValue());
        entity.setState(eo.getState() == null ? null : eo.getState().getValue());
        entity.setCity(eo.getCity() == null ? null : eo.getCity().getValue());
        entity.setPostalCode(eo.getPostalCode());
        entity.setDistrict(eo.getDistrict() == null ? null : eo.getDistrict().getValue());
        entity.setAreaCode(eo.getAreaCode());
        entity.setFxOrganCode(eo.getFxOrganCode());
        entity.setCreateDate(eo.getCreateDate());
        entity.setStartDate(eo.getStartDate());
        entity.setEndDate(eo.getEndDate());
        entity.setEodFlag(eo.getEodFlag());
        entity.setCityBranchFlag(eo.getCityBranchFlag() == null ? null : eo.getCityBranchFlag().getValue());
        entity.setPbocFinancingNo(eo.getPbocFinancingNo());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static FmBranchExample eoToEntityExample(FmBranchEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranchExample example = new FmBranchExample();
        FmBranchExample.Criteria criteria = example.createCriteria();
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getBranchName() != null) criteria.andBranchNameEqualTo(eo.getBranchName());
        if (eo.getBranchShort() != null) criteria.andBranchShortEqualTo(eo.getBranchShort());
        if (eo.getBranchType() != null) criteria.andBranchTypeEqualTo(eo.getBranchType().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getInternalClient() != null) criteria.andInternalClientEqualTo(eo.getInternalClient());
        if (eo.getHierarchyCode() != null) criteria.andHierarchyCodeEqualTo(eo.getHierarchyCode().getValue());
        if (eo.getAttachedTo() != null) criteria.andAttachedToEqualTo(eo.getAttachedTo().getValue());
        if (eo.getSubBranchCode() != null) criteria.andSubBranchCodeEqualTo(eo.getSubBranchCode().getValue());
        if (eo.getFtaFlag() != null) criteria.andFtaFlagEqualTo(eo.getFtaFlag().getValue());
        if (eo.getFtaCode() != null) criteria.andFtaCodeEqualTo(eo.getFtaCode());
        if (eo.getProfitCenter() != null) criteria.andProfitCenterEqualTo(eo.getProfitCenter().getValue());
        if (eo.getIpAddr() != null) criteria.andIpAddrEqualTo(eo.getIpAddr());
        if (eo.getCountry() != null) criteria.andCountryEqualTo(eo.getCountry().getValue());
        if (eo.getState() != null) criteria.andStateEqualTo(eo.getState().getValue());
        if (eo.getCity() != null) criteria.andCityEqualTo(eo.getCity().getValue());
        if (eo.getPostalCode() != null) criteria.andPostalCodeEqualTo(eo.getPostalCode());
        if (eo.getDistrict() != null) criteria.andDistrictEqualTo(eo.getDistrict().getValue());
        if (eo.getAreaCode() != null) criteria.andAreaCodeEqualTo(eo.getAreaCode());
        if (eo.getFxOrganCode() != null) criteria.andFxOrganCodeEqualTo(eo.getFxOrganCode());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getEodFlag() != null) criteria.andEodFlagEqualTo(eo.getEodFlag());
        if (eo.getCityBranchFlag() != null) criteria.andCityBranchFlagEqualTo(eo.getCityBranchFlag().getValue());
        if (eo.getPbocFinancingNo() != null) criteria.andPbocFinancingNoEqualTo(eo.getPbocFinancingNo());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}