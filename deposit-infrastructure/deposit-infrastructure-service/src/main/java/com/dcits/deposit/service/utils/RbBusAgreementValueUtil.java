package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusAgreement;
import com.dcits.deposit.entity.RbBusAgreementExample;
import com.dcits.deposit.facade.eo.RbBusAgreementEO;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.GreementSignStatus;

public final class RbBusAgreementValueUtil {
    private RbBusAgreementValueUtil() {
    }

    public static RbBusAgreementEO entityToEo(RbBusAgreement entity) {
        if (entity == null) {
            return null;
        }
        RbBusAgreementEO eo = new RbBusAgreementEO();
        eo.setRbBusAgreementType(RbBusAgreementType.byValue(entity.getRbBusAgreementType()));
        eo.setAgreementClass(AgreementClass.byValue(entity.getAgreementClass()));
        eo.setProdNo(entity.getProdNo());
        eo.setAgreementKeyType(entity.getAgreementKeyType());
        eo.setAgreementAmt(entity.getAgreementAmt());
        eo.setAgreementKey(entity.getAgreementKey());
        eo.setClientNo(entity.getClientNo());
        eo.setAgreementOpenDate(entity.getAgreementOpenDate());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setEndDate(entity.getEndDate());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setSignDate(entity.getSignDate());
        eo.setOutSignDate(entity.getOutSignDate());
        eo.setAgreementId(entity.getAgreementId());
        eo.setAgreProdNo(entity.getAgreProdNo());
        eo.setClientShort(entity.getClientShort());
        eo.setOutSignUserId(entity.getOutSignUserId());
        eo.setSignChannel(SourceType.byValue(entity.getSignChannel()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setOutSignChannel(SourceType.byValue(entity.getOutSignChannel()));
        eo.setStartDate(entity.getStartDate());
        eo.setSignBranch(TranBranch.byValue(entity.getSignBranch()));
        eo.setOutSignBranch(TranBranch.byValue(entity.getOutSignBranch()));
        eo.setAgreementSignEffectStatus(AgreementSignEffectStatus.byValue(entity.getAgreementSignEffectStatus()));
        eo.setTranBranch(TranBranch.byValue(entity.getTranBranch()));
        eo.setAgreementCloseAcctFlag(entity.getAgreementCloseAcctFlag());
        eo.setGreementSignStatus(GreementSignStatus.byValue(entity.getGreementSignStatus()));
        eo.setAcctName(entity.getAcctName());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setSignUserId(entity.getSignUserId());
        return eo;
    }

    public static RbBusAgreement eoToEntity(RbBusAgreementEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAgreement entity = new RbBusAgreement();
        entity.setRbBusAgreementType(eo.getRbBusAgreementType() == null ? null : eo.getRbBusAgreementType().getValue());
        entity.setAgreementClass(eo.getAgreementClass() == null ? null : eo.getAgreementClass().getValue());
        entity.setProdNo(eo.getProdNo());
        entity.setAgreementKeyType(eo.getAgreementKeyType());
        entity.setAgreementAmt(eo.getAgreementAmt());
        entity.setAgreementKey(eo.getAgreementKey());
        entity.setClientNo(eo.getClientNo());
        entity.setAgreementOpenDate(eo.getAgreementOpenDate());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setEndDate(eo.getEndDate());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setSignDate(eo.getSignDate());
        entity.setOutSignDate(eo.getOutSignDate());
        entity.setAgreementId(eo.getAgreementId());
        entity.setAgreProdNo(eo.getAgreProdNo());
        entity.setClientShort(eo.getClientShort());
        entity.setOutSignUserId(eo.getOutSignUserId());
        entity.setSignChannel(eo.getSignChannel() == null ? null : eo.getSignChannel().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setOutSignChannel(eo.getOutSignChannel() == null ? null : eo.getOutSignChannel().getValue());
        entity.setStartDate(eo.getStartDate());
        entity.setSignBranch(eo.getSignBranch() == null ? null : eo.getSignBranch().getValue());
        entity.setOutSignBranch(eo.getOutSignBranch() == null ? null : eo.getOutSignBranch().getValue());
        entity.setAgreementSignEffectStatus(eo.getAgreementSignEffectStatus() == null ? null : eo.getAgreementSignEffectStatus().getValue());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setAgreementCloseAcctFlag(eo.getAgreementCloseAcctFlag());
        entity.setGreementSignStatus(eo.getGreementSignStatus() == null ? null : eo.getGreementSignStatus().getValue());
        entity.setAcctName(eo.getAcctName());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setSignUserId(eo.getSignUserId());
        return entity;
    }

    public static RbBusAgreementExample eoToEntityExample(RbBusAgreementEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAgreementExample example = new RbBusAgreementExample();
        RbBusAgreementExample.Criteria criteria = example.createCriteria();
        if (eo.getRbBusAgreementType() != null) criteria.andRbBusAgreementTypeEqualTo(eo.getRbBusAgreementType().getValue());
        if (eo.getAgreementClass() != null) criteria.andAgreementClassEqualTo(eo.getAgreementClass().getValue());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getAgreementKeyType() != null) criteria.andAgreementKeyTypeEqualTo(eo.getAgreementKeyType());
        if (eo.getAgreementAmt() != null) criteria.andAgreementAmtEqualTo(eo.getAgreementAmt());
        if (eo.getAgreementKey() != null) criteria.andAgreementKeyEqualTo(eo.getAgreementKey());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getAgreementOpenDate() != null) criteria.andAgreementOpenDateEqualTo(eo.getAgreementOpenDate());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getSignDate() != null) criteria.andSignDateEqualTo(eo.getSignDate());
        if (eo.getOutSignDate() != null) criteria.andOutSignDateEqualTo(eo.getOutSignDate());
        if (eo.getAgreementId() != null) criteria.andAgreementIdEqualTo(eo.getAgreementId());
        if (eo.getAgreProdNo() != null) criteria.andAgreProdNoEqualTo(eo.getAgreProdNo());
        if (eo.getClientShort() != null) criteria.andClientShortEqualTo(eo.getClientShort());
        if (eo.getOutSignUserId() != null) criteria.andOutSignUserIdEqualTo(eo.getOutSignUserId());
        if (eo.getSignChannel() != null) criteria.andSignChannelEqualTo(eo.getSignChannel().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getOutSignChannel() != null) criteria.andOutSignChannelEqualTo(eo.getOutSignChannel().getValue());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getSignBranch() != null) criteria.andSignBranchEqualTo(eo.getSignBranch().getValue());
        if (eo.getOutSignBranch() != null) criteria.andOutSignBranchEqualTo(eo.getOutSignBranch().getValue());
        if (eo.getAgreementSignEffectStatus() != null) criteria.andAgreementSignEffectStatusEqualTo(eo.getAgreementSignEffectStatus().getValue());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getAgreementCloseAcctFlag() != null) criteria.andAgreementCloseAcctFlagEqualTo(eo.getAgreementCloseAcctFlag());
        if (eo.getGreementSignStatus() != null) criteria.andGreementSignStatusEqualTo(eo.getGreementSignStatus().getValue());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getSignUserId() != null) criteria.andSignUserIdEqualTo(eo.getSignUserId());
        return example;
    }
}