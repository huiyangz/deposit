package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusAgreementYht;
import com.dcits.deposit.entity.RbBusAgreementYhtExample;
import com.dcits.deposit.facade.eo.RbBusAgreementYhtEO;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.AcctSettleMethod;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import com.dcits.deposit.enums.GreementSignStatus;

public final class RbBusAgreementYhtValueUtil {
    private RbBusAgreementYhtValueUtil() {
    }

    public static RbBusAgreementYhtEO entityToEo(RbBusAgreementYht entity) {
        if (entity == null) {
            return null;
        }
        RbBusAgreementYhtEO eo = new RbBusAgreementYhtEO();
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setIntFlag(entity.getIntFlag());
        eo.setSelfFlag(entity.getSelfFlag());
        eo.setInternalKey(entity.getInternalKey());
        eo.setAgreementSignEffectStatus(AgreementSignEffectStatus.byValue(entity.getAgreementSignEffectStatus()));
        eo.setAcctSettleMethod(AcctSettleMethod.byValue(entity.getAcctSettleMethod()));
        eo.setParentInternalKey(entity.getParentInternalKey());
        eo.setAcctName(entity.getAcctName());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setSettleInd(SettleInd.byValue(entity.getSettleInd()));
        eo.setMainAgreementId(entity.getMainAgreementId());
        eo.setAcctRealFlag(entity.getAcctRealFlag());
        eo.setAgreementId(entity.getAgreementId());
        eo.setYhtProdNo(entity.getYhtProdNo());
        eo.setNextMaxSeqNo(entity.getNextMaxSeqNo());
        eo.setYhtAcctLevel(entity.getYhtAcctLevel());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setYhtAcctFlag(YhtAcctFlag.byValue(entity.getYhtAcctFlag()));
        eo.setYhtAcctOrgSchema(YhtAcctOrgSchema.byValue(entity.getYhtAcctOrgSchema()));
        eo.setIssOdFlag(entity.getIssOdFlag());
        eo.setGreementSignStatus(GreementSignStatus.byValue(entity.getGreementSignStatus()));
        return eo;
    }

    public static RbBusAgreementYht eoToEntity(RbBusAgreementYhtEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAgreementYht entity = new RbBusAgreementYht();
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setIntFlag(eo.getIntFlag());
        entity.setSelfFlag(eo.getSelfFlag());
        entity.setInternalKey(eo.getInternalKey());
        entity.setAgreementSignEffectStatus(eo.getAgreementSignEffectStatus() == null ? null : eo.getAgreementSignEffectStatus().getValue());
        entity.setAcctSettleMethod(eo.getAcctSettleMethod() == null ? null : eo.getAcctSettleMethod().getValue());
        entity.setParentInternalKey(eo.getParentInternalKey());
        entity.setAcctName(eo.getAcctName());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setSettleInd(eo.getSettleInd() == null ? null : eo.getSettleInd().getValue());
        entity.setMainAgreementId(eo.getMainAgreementId());
        entity.setAcctRealFlag(eo.getAcctRealFlag());
        entity.setAgreementId(eo.getAgreementId());
        entity.setYhtProdNo(eo.getYhtProdNo());
        entity.setNextMaxSeqNo(eo.getNextMaxSeqNo());
        entity.setYhtAcctLevel(eo.getYhtAcctLevel());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setYhtAcctFlag(eo.getYhtAcctFlag() == null ? null : eo.getYhtAcctFlag().getValue());
        entity.setYhtAcctOrgSchema(eo.getYhtAcctOrgSchema() == null ? null : eo.getYhtAcctOrgSchema().getValue());
        entity.setIssOdFlag(eo.getIssOdFlag());
        entity.setGreementSignStatus(eo.getGreementSignStatus() == null ? null : eo.getGreementSignStatus().getValue());
        return entity;
    }

    public static RbBusAgreementYhtExample eoToEntityExample(RbBusAgreementYhtEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAgreementYhtExample example = new RbBusAgreementYhtExample();
        RbBusAgreementYhtExample.Criteria criteria = example.createCriteria();
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getIntFlag() != null) criteria.andIntFlagEqualTo(eo.getIntFlag());
        if (eo.getSelfFlag() != null) criteria.andSelfFlagEqualTo(eo.getSelfFlag());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getAgreementSignEffectStatus() != null) criteria.andAgreementSignEffectStatusEqualTo(eo.getAgreementSignEffectStatus().getValue());
        if (eo.getAcctSettleMethod() != null) criteria.andAcctSettleMethodEqualTo(eo.getAcctSettleMethod().getValue());
        if (eo.getParentInternalKey() != null) criteria.andParentInternalKeyEqualTo(eo.getParentInternalKey());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getSettleInd() != null) criteria.andSettleIndEqualTo(eo.getSettleInd().getValue());
        if (eo.getMainAgreementId() != null) criteria.andMainAgreementIdEqualTo(eo.getMainAgreementId());
        if (eo.getAcctRealFlag() != null) criteria.andAcctRealFlagEqualTo(eo.getAcctRealFlag());
        if (eo.getAgreementId() != null) criteria.andAgreementIdEqualTo(eo.getAgreementId());
        if (eo.getYhtProdNo() != null) criteria.andYhtProdNoEqualTo(eo.getYhtProdNo());
        if (eo.getNextMaxSeqNo() != null) criteria.andNextMaxSeqNoEqualTo(eo.getNextMaxSeqNo());
        if (eo.getYhtAcctLevel() != null) criteria.andYhtAcctLevelEqualTo(eo.getYhtAcctLevel());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getYhtAcctFlag() != null) criteria.andYhtAcctFlagEqualTo(eo.getYhtAcctFlag().getValue());
        if (eo.getYhtAcctOrgSchema() != null) criteria.andYhtAcctOrgSchemaEqualTo(eo.getYhtAcctOrgSchema().getValue());
        if (eo.getIssOdFlag() != null) criteria.andIssOdFlagEqualTo(eo.getIssOdFlag());
        if (eo.getGreementSignStatus() != null) criteria.andGreementSignStatusEqualTo(eo.getGreementSignStatus().getValue());
        return example;
    }
}