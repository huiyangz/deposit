package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitSumHist;
import com.dcits.deposit.entity.RbLimitSumHistExample;
import com.dcits.deposit.facade.eo.RbLimitSumHistEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class RbLimitSumHistValueUtil {
    private RbLimitSumHistValueUtil() {
    }

    public static RbLimitSumHistEO entityToEo(RbLimitSumHist entity) {
        if (entity == null) {
            return null;
        }
        RbLimitSumHistEO eo = new RbLimitSumHistEO();
        eo.setClientNo(entity.getClientNo());
        eo.setLimitSceneNo(entity.getLimitSceneNo());
        eo.setCheckObjVal(entity.getCheckObjVal());
        eo.setLimitCtrlInfo(entity.getLimitCtrlInfo());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setTranChannel(SourceType.byValue(entity.getTranChannel()));
        eo.setTranCcy(AcctCcy.byValue(entity.getTranCcy()));
        eo.setTranAmt(entity.getTranAmt());
        eo.setLimitConvertAmt(entity.getLimitConvertAmt());
        eo.setReference(entity.getReference());
        eo.setPreReference(entity.getPreReference());
        eo.setValidFlag(entity.getValidFlag());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateDate(entity.getCreateDate());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setSeqNo(entity.getSeqNo());
        return eo;
    }

    public static RbLimitSumHist eoToEntity(RbLimitSumHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitSumHist entity = new RbLimitSumHist();
        entity.setClientNo(eo.getClientNo());
        entity.setLimitSceneNo(eo.getLimitSceneNo());
        entity.setCheckObjVal(eo.getCheckObjVal());
        entity.setLimitCtrlInfo(eo.getLimitCtrlInfo());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setTranChannel(eo.getTranChannel() == null ? null : eo.getTranChannel().getValue());
        entity.setTranCcy(eo.getTranCcy() == null ? null : eo.getTranCcy().getValue());
        entity.setTranAmt(eo.getTranAmt());
        entity.setLimitConvertAmt(eo.getLimitConvertAmt());
        entity.setReference(eo.getReference());
        entity.setPreReference(eo.getPreReference());
        entity.setValidFlag(eo.getValidFlag());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateDate(eo.getCreateDate());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setSeqNo(eo.getSeqNo());
        return entity;
    }

    public static RbLimitSumHistExample eoToEntityExample(RbLimitSumHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitSumHistExample example = new RbLimitSumHistExample();
        RbLimitSumHistExample.Criteria criteria = example.createCriteria();
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getLimitSceneNo() != null) criteria.andLimitSceneNoEqualTo(eo.getLimitSceneNo());
        if (eo.getCheckObjVal() != null) criteria.andCheckObjValEqualTo(eo.getCheckObjVal());
        if (eo.getLimitCtrlInfo() != null) criteria.andLimitCtrlInfoEqualTo(eo.getLimitCtrlInfo());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getTranChannel() != null) criteria.andTranChannelEqualTo(eo.getTranChannel().getValue());
        if (eo.getTranCcy() != null) criteria.andTranCcyEqualTo(eo.getTranCcy().getValue());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getLimitConvertAmt() != null) criteria.andLimitConvertAmtEqualTo(eo.getLimitConvertAmt());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getPreReference() != null) criteria.andPreReferenceEqualTo(eo.getPreReference());
        if (eo.getValidFlag() != null) criteria.andValidFlagEqualTo(eo.getValidFlag());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        return example;
    }
}