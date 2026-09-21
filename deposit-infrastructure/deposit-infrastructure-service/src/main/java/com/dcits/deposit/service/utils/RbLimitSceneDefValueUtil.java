package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitSceneDef;
import com.dcits.deposit.entity.RbLimitSceneDefExample;
import com.dcits.deposit.facade.eo.RbLimitSceneDefEO;
import com.dcits.deposit.enums.LimitMainType;
import com.dcits.deposit.enums.CheckObjType;
import com.dcits.deposit.enums.LimitConvert;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class RbLimitSceneDefValueUtil {
    private RbLimitSceneDefValueUtil() {
    }

    public static RbLimitSceneDefEO entityToEo(RbLimitSceneDef entity) {
        if (entity == null) {
            return null;
        }
        RbLimitSceneDefEO eo = new RbLimitSceneDefEO();
        eo.setLimitSceneNo(entity.getLimitSceneNo());
        eo.setLimitSceneDesc(entity.getLimitSceneDesc());
        eo.setLimitMainType(LimitMainType.byValue(entity.getLimitMainType()));
        eo.setCheckObjType(CheckObjType.byValue(entity.getCheckObjType()));
        eo.setLimitConvert(LimitConvert.byValue(entity.getLimitConvert()));
        eo.setLimitCcy(AcctCcy.byValue(entity.getLimitCcy()));
        eo.setValidFlag(entity.getValidFlag());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static RbLimitSceneDef eoToEntity(RbLimitSceneDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitSceneDef entity = new RbLimitSceneDef();
        entity.setLimitSceneNo(eo.getLimitSceneNo());
        entity.setLimitSceneDesc(eo.getLimitSceneDesc());
        entity.setLimitMainType(eo.getLimitMainType() == null ? null : eo.getLimitMainType().getValue());
        entity.setCheckObjType(eo.getCheckObjType() == null ? null : eo.getCheckObjType().getValue());
        entity.setLimitConvert(eo.getLimitConvert() == null ? null : eo.getLimitConvert().getValue());
        entity.setLimitCcy(eo.getLimitCcy() == null ? null : eo.getLimitCcy().getValue());
        entity.setValidFlag(eo.getValidFlag());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static RbLimitSceneDefExample eoToEntityExample(RbLimitSceneDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitSceneDefExample example = new RbLimitSceneDefExample();
        RbLimitSceneDefExample.Criteria criteria = example.createCriteria();
        if (eo.getLimitSceneNo() != null) criteria.andLimitSceneNoEqualTo(eo.getLimitSceneNo());
        if (eo.getLimitSceneDesc() != null) criteria.andLimitSceneDescEqualTo(eo.getLimitSceneDesc());
        if (eo.getLimitMainType() != null) criteria.andLimitMainTypeEqualTo(eo.getLimitMainType().getValue());
        if (eo.getCheckObjType() != null) criteria.andCheckObjTypeEqualTo(eo.getCheckObjType().getValue());
        if (eo.getLimitConvert() != null) criteria.andLimitConvertEqualTo(eo.getLimitConvert().getValue());
        if (eo.getLimitCcy() != null) criteria.andLimitCcyEqualTo(eo.getLimitCcy().getValue());
        if (eo.getValidFlag() != null) criteria.andValidFlagEqualTo(eo.getValidFlag());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}