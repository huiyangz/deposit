package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbTranControlHist;
import com.dcits.deposit.entity.RbTranControlHistExample;
import com.dcits.deposit.facade.eo.RbTranControlHistEO;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.OnlineTranStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;

public final class RbTranControlHistValueUtil {
    private RbTranControlHistValueUtil() {
    }

    public static RbTranControlHistEO entityToEo(RbTranControlHist entity) {
        if (entity == null) {
            return null;
        }
        RbTranControlHistEO eo = new RbTranControlHistEO();
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setChannelDate(entity.getChannelDate());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setSubSeqNo(entity.getSubSeqNo());
        eo.setBusiSubClass(entity.getBusiSubClass());
        eo.setClientNo(entity.getClientNo());
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setTranEventType(entity.getTranEventType());
        eo.setTranDesc(entity.getTranDesc());
        eo.setReference(entity.getReference());
        eo.setOnlineTranStatus(OnlineTranStatus.byValue(entity.getOnlineTranStatus()));
        eo.setMessageType(entity.getMessageType());
        eo.setMessageCode(entity.getMessageCode());
        eo.setServiceCode(entity.getServiceCode());
        eo.setSourceModule(SourceModule.byValue(entity.getSourceModule()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCustomerSeqNo(entity.getCustomerSeqNo());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTranCode(entity.getTranCode());
        eo.setTaeTradeMode(entity.getTaeTradeMode());
        eo.setDrCrFlag(CrDrInd.byValue(entity.getDrCrFlag()));
        eo.setTaeFlag(IndividualFlag.byValue(entity.getTaeFlag()));
        return eo;
    }

    public static RbTranControlHist eoToEntity(RbTranControlHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranControlHist entity = new RbTranControlHist();
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setChannelDate(eo.getChannelDate());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setSubSeqNo(eo.getSubSeqNo());
        entity.setBusiSubClass(eo.getBusiSubClass());
        entity.setClientNo(eo.getClientNo());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setTranEventType(eo.getTranEventType());
        entity.setTranDesc(eo.getTranDesc());
        entity.setReference(eo.getReference());
        entity.setOnlineTranStatus(eo.getOnlineTranStatus() == null ? null : eo.getOnlineTranStatus().getValue());
        entity.setMessageType(eo.getMessageType());
        entity.setMessageCode(eo.getMessageCode());
        entity.setServiceCode(eo.getServiceCode());
        entity.setSourceModule(eo.getSourceModule() == null ? null : eo.getSourceModule().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCustomerSeqNo(eo.getCustomerSeqNo());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTranCode(eo.getTranCode());
        entity.setTaeTradeMode(eo.getTaeTradeMode());
        entity.setDrCrFlag(eo.getDrCrFlag() == null ? null : eo.getDrCrFlag().getValue());
        entity.setTaeFlag(eo.getTaeFlag() == null ? null : eo.getTaeFlag().getValue());
        return entity;
    }

    public static RbTranControlHistExample eoToEntityExample(RbTranControlHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranControlHistExample example = new RbTranControlHistExample();
        RbTranControlHistExample.Criteria criteria = example.createCriteria();
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getChannelDate() != null) criteria.andChannelDateEqualTo(eo.getChannelDate());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getSubSeqNo() != null) criteria.andSubSeqNoEqualTo(eo.getSubSeqNo());
        if (eo.getBusiSubClass() != null) criteria.andBusiSubClassEqualTo(eo.getBusiSubClass());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getTranEventType() != null) criteria.andTranEventTypeEqualTo(eo.getTranEventType());
        if (eo.getTranDesc() != null) criteria.andTranDescEqualTo(eo.getTranDesc());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getOnlineTranStatus() != null) criteria.andOnlineTranStatusEqualTo(eo.getOnlineTranStatus().getValue());
        if (eo.getMessageType() != null) criteria.andMessageTypeEqualTo(eo.getMessageType());
        if (eo.getMessageCode() != null) criteria.andMessageCodeEqualTo(eo.getMessageCode());
        if (eo.getServiceCode() != null) criteria.andServiceCodeEqualTo(eo.getServiceCode());
        if (eo.getSourceModule() != null) criteria.andSourceModuleEqualTo(eo.getSourceModule().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCustomerSeqNo() != null) criteria.andCustomerSeqNoEqualTo(eo.getCustomerSeqNo());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTranCode() != null) criteria.andTranCodeEqualTo(eo.getTranCode());
        if (eo.getTaeTradeMode() != null) criteria.andTaeTradeModeEqualTo(eo.getTaeTradeMode());
        if (eo.getDrCrFlag() != null) criteria.andDrCrFlagEqualTo(eo.getDrCrFlag().getValue());
        if (eo.getTaeFlag() != null) criteria.andTaeFlagEqualTo(eo.getTaeFlag().getValue());
        return example;
    }
}