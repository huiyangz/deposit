package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbProdDefine;
import com.dcits.deposit.entity.MbProdDefineExample;
import com.dcits.deposit.facade.eo.MbProdDefineEO;
import com.dcits.deposit.enums.EventDefault;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.Status;

public final class MbProdDefineValueUtil {
    private MbProdDefineValueUtil() {
    }

    public static MbProdDefineEO entityToEo(MbProdDefine entity) {
        if (entity == null) {
            return null;
        }
        MbProdDefineEO eo = new MbProdDefineEO();
        eo.setAreaCode(entity.getAreaCode());
        eo.setPbocFinancingNo(entity.getPbocFinancingNo());
        eo.setEventDefault(EventDefault.byValue(entity.getEventDefault()));
        eo.setCreateDate(entity.getCreateDate());
        eo.setPostalCode(entity.getPostalCode());
        eo.setBranch(TranBranch.byValue(entity.getBranch()));
        eo.setState(State.byValue(entity.getState()));
        eo.setSubBranchCode(TranBranch.byValue(entity.getSubBranchCode()));
        eo.setIpAddr(entity.getIpAddr());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setAssembleId(entity.getAssembleId());
        eo.setCity(City.byValue(entity.getCity()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setBranchName(entity.getBranchName());
        eo.setBranchShort(entity.getBranchShort());
        eo.setAttrKey(entity.getAttrKey());
        eo.setEodFlag(entity.getEodFlag());
        eo.setAttrValue(entity.getAttrValue());
        eo.setSeqNo(entity.getSeqNo());
        eo.setHierarchyCode(HierarchyCode.byValue(entity.getHierarchyCode()));
        eo.setFtaNo(entity.getFtaNo());
        eo.setFtaFlag(entity.getFtaFlag());
        eo.setCityBranchFlag(entity.getCityBranchFlag());
        eo.setAttachedTo(TranBranch.byValue(entity.getAttachedTo()));
        eo.setCountry(IssCountry.byValue(entity.getCountry()));
        eo.setProdNo(entity.getProdNo());
        eo.setDistrict(State.byValue(entity.getDistrict()));
        eo.setFxOrganCode(entity.getFxOrganCode());
        eo.setStartDate(entity.getStartDate());
        eo.setProfitCenter(ProfitCenter.byValue(entity.getProfitCenter()));
        eo.setAssembleType(entity.getAssembleType());
        eo.setInternalClient(entity.getInternalClient());
        eo.setBranchType(BranchType.byValue(entity.getBranchType()));
        eo.setStatus(Status.byValue(entity.getStatus()));
        eo.setEndDate(entity.getEndDate());
        return eo;
    }

    public static MbProdDefine eoToEntity(MbProdDefineEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdDefine entity = new MbProdDefine();
        entity.setAreaCode(eo.getAreaCode());
        entity.setPbocFinancingNo(eo.getPbocFinancingNo());
        entity.setEventDefault(eo.getEventDefault() == null ? null : eo.getEventDefault().getValue());
        entity.setCreateDate(eo.getCreateDate());
        entity.setPostalCode(eo.getPostalCode());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setState(eo.getState() == null ? null : eo.getState().getValue());
        entity.setSubBranchCode(eo.getSubBranchCode() == null ? null : eo.getSubBranchCode().getValue());
        entity.setIpAddr(eo.getIpAddr());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setAssembleId(eo.getAssembleId());
        entity.setCity(eo.getCity() == null ? null : eo.getCity().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setBranchName(eo.getBranchName());
        entity.setBranchShort(eo.getBranchShort());
        entity.setAttrKey(eo.getAttrKey());
        entity.setEodFlag(eo.getEodFlag());
        entity.setAttrValue(eo.getAttrValue());
        entity.setSeqNo(eo.getSeqNo());
        entity.setHierarchyCode(eo.getHierarchyCode() == null ? null : eo.getHierarchyCode().getValue());
        entity.setFtaNo(eo.getFtaNo());
        entity.setFtaFlag(eo.getFtaFlag());
        entity.setCityBranchFlag(eo.getCityBranchFlag());
        entity.setAttachedTo(eo.getAttachedTo() == null ? null : eo.getAttachedTo().getValue());
        entity.setCountry(eo.getCountry() == null ? null : eo.getCountry().getValue());
        entity.setProdNo(eo.getProdNo());
        entity.setDistrict(eo.getDistrict() == null ? null : eo.getDistrict().getValue());
        entity.setFxOrganCode(eo.getFxOrganCode());
        entity.setStartDate(eo.getStartDate());
        entity.setProfitCenter(eo.getProfitCenter() == null ? null : eo.getProfitCenter().getValue());
        entity.setAssembleType(eo.getAssembleType());
        entity.setInternalClient(eo.getInternalClient());
        entity.setBranchType(eo.getBranchType() == null ? null : eo.getBranchType().getValue());
        entity.setStatus(eo.getStatus() == null ? null : eo.getStatus().getValue());
        entity.setEndDate(eo.getEndDate());
        return entity;
    }

    public static MbProdDefineExample eoToEntityExample(MbProdDefineEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdDefineExample example = new MbProdDefineExample();
        MbProdDefineExample.Criteria criteria = example.createCriteria();
        if (eo.getAreaCode() != null) criteria.andAreaCodeEqualTo(eo.getAreaCode());
        if (eo.getPbocFinancingNo() != null) criteria.andPbocFinancingNoEqualTo(eo.getPbocFinancingNo());
        if (eo.getEventDefault() != null) criteria.andEventDefaultEqualTo(eo.getEventDefault().getValue());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getPostalCode() != null) criteria.andPostalCodeEqualTo(eo.getPostalCode());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getState() != null) criteria.andStateEqualTo(eo.getState().getValue());
        if (eo.getSubBranchCode() != null) criteria.andSubBranchCodeEqualTo(eo.getSubBranchCode().getValue());
        if (eo.getIpAddr() != null) criteria.andIpAddrEqualTo(eo.getIpAddr());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getAssembleId() != null) criteria.andAssembleIdEqualTo(eo.getAssembleId());
        if (eo.getCity() != null) criteria.andCityEqualTo(eo.getCity().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getBranchName() != null) criteria.andBranchNameEqualTo(eo.getBranchName());
        if (eo.getBranchShort() != null) criteria.andBranchShortEqualTo(eo.getBranchShort());
        if (eo.getAttrKey() != null) criteria.andAttrKeyEqualTo(eo.getAttrKey());
        if (eo.getEodFlag() != null) criteria.andEodFlagEqualTo(eo.getEodFlag());
        if (eo.getAttrValue() != null) criteria.andAttrValueEqualTo(eo.getAttrValue());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getHierarchyCode() != null) criteria.andHierarchyCodeEqualTo(eo.getHierarchyCode().getValue());
        if (eo.getFtaNo() != null) criteria.andFtaNoEqualTo(eo.getFtaNo());
        if (eo.getFtaFlag() != null) criteria.andFtaFlagEqualTo(eo.getFtaFlag());
        if (eo.getCityBranchFlag() != null) criteria.andCityBranchFlagEqualTo(eo.getCityBranchFlag());
        if (eo.getAttachedTo() != null) criteria.andAttachedToEqualTo(eo.getAttachedTo().getValue());
        if (eo.getCountry() != null) criteria.andCountryEqualTo(eo.getCountry().getValue());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getDistrict() != null) criteria.andDistrictEqualTo(eo.getDistrict().getValue());
        if (eo.getFxOrganCode() != null) criteria.andFxOrganCodeEqualTo(eo.getFxOrganCode());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getProfitCenter() != null) criteria.andProfitCenterEqualTo(eo.getProfitCenter().getValue());
        if (eo.getAssembleType() != null) criteria.andAssembleTypeEqualTo(eo.getAssembleType());
        if (eo.getInternalClient() != null) criteria.andInternalClientEqualTo(eo.getInternalClient());
        if (eo.getBranchType() != null) criteria.andBranchTypeEqualTo(eo.getBranchType().getValue());
        if (eo.getStatus() != null) criteria.andStatusEqualTo(eo.getStatus().getValue());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        return example;
    }
}