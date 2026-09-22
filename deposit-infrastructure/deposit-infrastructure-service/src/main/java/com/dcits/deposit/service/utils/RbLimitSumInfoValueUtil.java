package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitSumInfo;
import com.dcits.deposit.entity.RbLimitSumInfoExample;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class RbLimitSumInfoValueUtil {
    private RbLimitSumInfoValueUtil() {
    }

    public static RbLimitSumInfoEO entityToEo(RbLimitSumInfo entity) {
        if (entity == null) {
            return null;
        }
        RbLimitSumInfoEO eo = new RbLimitSumInfoEO();
        eo.setClientNo(entity.getClientNo());
        eo.setLimitSceneNo(entity.getLimitSceneNo());
        eo.setCheckObjVal(entity.getCheckObjVal());
        eo.setLimitSumAmt(entity.getLimitSumAmt());
        eo.setLimitSumContent(entity.getLimitSumContent());
        eo.setLimitSumNum(entity.getLimitSumNum());
        eo.setTranCcy(AcctCcy.byValue(entity.getTranCcy()));
        eo.setReference(entity.getReference());
        eo.setPreReference(entity.getPreReference());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setEffectDate(entity.getEffectDate());
        eo.setExpireDate(entity.getExpireDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setCreateDate(entity.getCreateDate());
        return eo;
    }

    public static RbLimitSumInfo eoToEntity(RbLimitSumInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitSumInfo entity = new RbLimitSumInfo();
        entity.setClientNo(eo.getClientNo());
        entity.setLimitSceneNo(eo.getLimitSceneNo());
        entity.setCheckObjVal(eo.getCheckObjVal());
        entity.setLimitSumAmt(eo.getLimitSumAmt());
        entity.setLimitSumContent(eo.getLimitSumContent());
        entity.setLimitSumNum(eo.getLimitSumNum());
        entity.setTranCcy(eo.getTranCcy() == null ? null : eo.getTranCcy().getValue());
        entity.setReference(eo.getReference());
        entity.setPreReference(eo.getPreReference());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setEffectDate(eo.getEffectDate());
        entity.setExpireDate(eo.getExpireDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setCreateDate(eo.getCreateDate());
        return entity;
    }

    public static RbLimitSumInfoExample eoToEntityExample(RbLimitSumInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitSumInfoExample example = new RbLimitSumInfoExample();
        RbLimitSumInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getLimitSceneNo() != null) criteria.andLimitSceneNoEqualTo(eo.getLimitSceneNo());
        if (eo.getCheckObjVal() != null) criteria.andCheckObjValEqualTo(eo.getCheckObjVal());
        if (eo.getLimitSumAmt() != null) criteria.andLimitSumAmtEqualTo(eo.getLimitSumAmt());
        if (eo.getLimitSumContent() != null) criteria.andLimitSumContentEqualTo(eo.getLimitSumContent());
        if (eo.getLimitSumNum() != null) criteria.andLimitSumNumEqualTo(eo.getLimitSumNum());
        if (eo.getTranCcy() != null) criteria.andTranCcyEqualTo(eo.getTranCcy().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getPreReference() != null) criteria.andPreReferenceEqualTo(eo.getPreReference());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getExpireDate() != null) criteria.andExpireDateEqualTo(eo.getExpireDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        return example;
    }
}