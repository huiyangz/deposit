package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitCtrlCustomInfo;
import com.dcits.deposit.entity.RbLimitCtrlCustomInfoExample;
import com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO;
import com.dcits.deposit.enums.CtrlItemType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;

public final class RbLimitCtrlCustomInfoValueUtil {
    private RbLimitCtrlCustomInfoValueUtil() {
    }

    public static RbLimitCtrlCustomInfoEO entityToEo(RbLimitCtrlCustomInfo entity) {
        if (entity == null) {
            return null;
        }
        RbLimitCtrlCustomInfoEO eo = new RbLimitCtrlCustomInfoEO();
        eo.setClientNo(entity.getClientNo());
        eo.setLimitSceneNo(entity.getLimitSceneNo());
        eo.setCheckObjVal(entity.getCheckObjVal());
        eo.setCtrlItemType(CtrlItemType.byValue(entity.getCtrlItemType()));
        eo.setLimitCtrlNum(entity.getLimitCtrlNum());
        eo.setLimitCtrlAmt(entity.getLimitCtrlAmt());
        eo.setTempLimitFlag(IndividualFlag.byValue(entity.getTempLimitFlag()));
        eo.setEffectDate(entity.getEffectDate());
        eo.setExpireDate(entity.getExpireDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setCreateDate(entity.getCreateDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbLimitCtrlCustomInfo eoToEntity(RbLimitCtrlCustomInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitCtrlCustomInfo entity = new RbLimitCtrlCustomInfo();
        entity.setClientNo(eo.getClientNo());
        entity.setLimitSceneNo(eo.getLimitSceneNo());
        entity.setCheckObjVal(eo.getCheckObjVal());
        entity.setCtrlItemType(eo.getCtrlItemType() == null ? null : eo.getCtrlItemType().getValue());
        entity.setLimitCtrlNum(eo.getLimitCtrlNum());
        entity.setLimitCtrlAmt(eo.getLimitCtrlAmt());
        entity.setTempLimitFlag(eo.getTempLimitFlag() == null ? null : eo.getTempLimitFlag().getValue());
        entity.setEffectDate(eo.getEffectDate());
        entity.setExpireDate(eo.getExpireDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setCreateDate(eo.getCreateDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbLimitCtrlCustomInfoExample eoToEntityExample(RbLimitCtrlCustomInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitCtrlCustomInfoExample example = new RbLimitCtrlCustomInfoExample();
        RbLimitCtrlCustomInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getLimitSceneNo() != null) criteria.andLimitSceneNoEqualTo(eo.getLimitSceneNo());
        if (eo.getCheckObjVal() != null) criteria.andCheckObjValEqualTo(eo.getCheckObjVal());
        if (eo.getCtrlItemType() != null) criteria.andCtrlItemTypeEqualTo(eo.getCtrlItemType().getValue());
        if (eo.getLimitCtrlNum() != null) criteria.andLimitCtrlNumEqualTo(eo.getLimitCtrlNum());
        if (eo.getLimitCtrlAmt() != null) criteria.andLimitCtrlAmtEqualTo(eo.getLimitCtrlAmt());
        if (eo.getTempLimitFlag() != null) criteria.andTempLimitFlagEqualTo(eo.getTempLimitFlag().getValue());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getExpireDate() != null) criteria.andExpireDateEqualTo(eo.getExpireDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}