package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAgreementYht;
import com.dcits.deposit.entity.RbAgreementYhtExample;
import com.dcits.deposit.facade.eo.RbAgreementYhtEO;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.AcctSettleMethod;

public final class RbAgreementYhtValueUtil {
    private RbAgreementYhtValueUtil() {
    }

    public static RbAgreementYhtEO entityToEo(RbAgreementYht entity) {
        if (entity == null) {
            return null;
        }
        RbAgreementYhtEO eo = new RbAgreementYhtEO();
        eo.setAgreementId(entity.getAgreementId());
        eo.setMainAgreementId(entity.getMainAgreementId());
        eo.setAgreementStatus(AgreementStatus.byValue(entity.getAgreementStatus()));
        eo.setInternalKey(entity.getInternalKey());
        eo.setParentInternalKey(entity.getParentInternalKey());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctName(entity.getAcctName());
        eo.setAltAcctName(entity.getAltAcctName());
        eo.setAcctRealFlag(IndividualFlag.byValue(entity.getAcctRealFlag()));
        eo.setNextMaxSeqNo(entity.getNextMaxSeqNo());
        eo.setSelfFlag(IndividualFlag.byValue(entity.getSelfFlag()));
        eo.setIntFlag(IndividualFlag.byValue(entity.getIntFlag()));
        eo.setSettleInd(SettleInd.byValue(entity.getSettleInd()));
        eo.setYhtProdType(entity.getYhtProdType());
        eo.setYhtAcctFlag(YhtAcctFlag.byValue(entity.getYhtAcctFlag()));
        eo.setYhtAcctLevel(entity.getYhtAcctLevel());
        eo.setYhtAcctMainFlag(YhtAcctFlag.byValue(entity.getYhtAcctMainFlag()));
        eo.setYhtAcctOrgSchema(YhtAcctOrgSchema.byValue(entity.getYhtAcctOrgSchema()));
        eo.setIssOdFlag(IndividualFlag.byValue(entity.getIssOdFlag()));
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setClientNo(entity.getClientNo());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setNonTransplantFlag(entity.getNonTransplantFlag());
        eo.setAcctSettleMethod(AcctSettleMethod.byValue(entity.getAcctSettleMethod()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbAgreementYht eoToEntity(RbAgreementYhtEO eo) {
        if (eo == null) {
            return null;
        }
        RbAgreementYht entity = new RbAgreementYht();
        entity.setAgreementId(eo.getAgreementId());
        entity.setMainAgreementId(eo.getMainAgreementId());
        entity.setAgreementStatus(eo.getAgreementStatus() == null ? null : eo.getAgreementStatus().getValue());
        entity.setInternalKey(eo.getInternalKey());
        entity.setParentInternalKey(eo.getParentInternalKey());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctName(eo.getAcctName());
        entity.setAltAcctName(eo.getAltAcctName());
        entity.setAcctRealFlag(eo.getAcctRealFlag() == null ? null : eo.getAcctRealFlag().getValue());
        entity.setNextMaxSeqNo(eo.getNextMaxSeqNo());
        entity.setSelfFlag(eo.getSelfFlag() == null ? null : eo.getSelfFlag().getValue());
        entity.setIntFlag(eo.getIntFlag() == null ? null : eo.getIntFlag().getValue());
        entity.setSettleInd(eo.getSettleInd() == null ? null : eo.getSettleInd().getValue());
        entity.setYhtProdType(eo.getYhtProdType());
        entity.setYhtAcctFlag(eo.getYhtAcctFlag() == null ? null : eo.getYhtAcctFlag().getValue());
        entity.setYhtAcctLevel(eo.getYhtAcctLevel());
        entity.setYhtAcctMainFlag(eo.getYhtAcctMainFlag() == null ? null : eo.getYhtAcctMainFlag().getValue());
        entity.setYhtAcctOrgSchema(eo.getYhtAcctOrgSchema() == null ? null : eo.getYhtAcctOrgSchema().getValue());
        entity.setIssOdFlag(eo.getIssOdFlag() == null ? null : eo.getIssOdFlag().getValue());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setNonTransplantFlag(eo.getNonTransplantFlag());
        entity.setAcctSettleMethod(eo.getAcctSettleMethod() == null ? null : eo.getAcctSettleMethod().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbAgreementYhtExample eoToEntityExample(RbAgreementYhtEO eo) {
        if (eo == null) {
            return null;
        }
        RbAgreementYhtExample example = new RbAgreementYhtExample();
        RbAgreementYhtExample.Criteria criteria = example.createCriteria();
        if (eo.getAgreementId() != null) criteria.andAgreementIdEqualTo(eo.getAgreementId());
        if (eo.getMainAgreementId() != null) criteria.andMainAgreementIdEqualTo(eo.getMainAgreementId());
        if (eo.getAgreementStatus() != null) criteria.andAgreementStatusEqualTo(eo.getAgreementStatus().getValue());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getParentInternalKey() != null) criteria.andParentInternalKeyEqualTo(eo.getParentInternalKey());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getAltAcctName() != null) criteria.andAltAcctNameEqualTo(eo.getAltAcctName());
        if (eo.getAcctRealFlag() != null) criteria.andAcctRealFlagEqualTo(eo.getAcctRealFlag().getValue());
        if (eo.getNextMaxSeqNo() != null) criteria.andNextMaxSeqNoEqualTo(eo.getNextMaxSeqNo());
        if (eo.getSelfFlag() != null) criteria.andSelfFlagEqualTo(eo.getSelfFlag().getValue());
        if (eo.getIntFlag() != null) criteria.andIntFlagEqualTo(eo.getIntFlag().getValue());
        if (eo.getSettleInd() != null) criteria.andSettleIndEqualTo(eo.getSettleInd().getValue());
        if (eo.getYhtProdType() != null) criteria.andYhtProdTypeEqualTo(eo.getYhtProdType());
        if (eo.getYhtAcctFlag() != null) criteria.andYhtAcctFlagEqualTo(eo.getYhtAcctFlag().getValue());
        if (eo.getYhtAcctLevel() != null) criteria.andYhtAcctLevelEqualTo(eo.getYhtAcctLevel());
        if (eo.getYhtAcctMainFlag() != null) criteria.andYhtAcctMainFlagEqualTo(eo.getYhtAcctMainFlag().getValue());
        if (eo.getYhtAcctOrgSchema() != null) criteria.andYhtAcctOrgSchemaEqualTo(eo.getYhtAcctOrgSchema().getValue());
        if (eo.getIssOdFlag() != null) criteria.andIssOdFlagEqualTo(eo.getIssOdFlag().getValue());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getNonTransplantFlag() != null) criteria.andNonTransplantFlagEqualTo(eo.getNonTransplantFlag());
        if (eo.getAcctSettleMethod() != null) criteria.andAcctSettleMethodEqualTo(eo.getAcctSettleMethod().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}