package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbCentReg;
import com.dcits.deposit.entity.RbCentRegExample;
import com.dcits.deposit.facade.eo.RbCentRegEO;
import com.dcits.deposit.enums.CloseAcctInd;
import com.dcits.deposit.enums.CentDealType;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WipeAccount;
import com.dcits.deposit.enums.Company;

public final class RbCentRegValueUtil {
    private RbCentRegValueUtil() {
    }

    public static RbCentRegEO entityToEo(RbCentReg entity) {
        if (entity == null) {
            return null;
        }
        RbCentRegEO eo = new RbCentRegEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setReference(entity.getReference());
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setSubSeqNo(entity.getSubSeqNo());
        eo.setOrigChannelSeqNo(entity.getOrigChannelSeqNo());
        eo.setOrigSubSeqNo(entity.getOrigSubSeqNo());
        eo.setCloseAcctInd(CloseAcctInd.byValue(entity.getCloseAcctInd()));
        eo.setCentDealType(CentDealType.byValue(entity.getCentDealType()));
        eo.setCentAmt(entity.getCentAmt());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setAmtType(AmtType.byValue(entity.getAmtType()));
        eo.setClientNo(entity.getClientNo());
        eo.setTranDate(entity.getTranDate());
        eo.setTranStatus(TranStatus.byValue(entity.getTranStatus()));
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setEventType(entity.getEventType());
        eo.setReversalFlag(IndividualFlag.byValue(entity.getReversalFlag()));
        eo.setReversalSeqNo(entity.getReversalSeqNo());
        eo.setReversalTranType(TranType.byValue(entity.getReversalTranType()));
        eo.setReversalTranDate(entity.getReversalTranDate());
        eo.setReversalUserId(entity.getReversalUserId());
        eo.setReversalReason(entity.getReversalReason());
        eo.setWipeAccount(WipeAccount.byValue(entity.getWipeAccount()));
        eo.setUserId(entity.getUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbCentReg eoToEntity(RbCentRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbCentReg entity = new RbCentReg();
        entity.setSeqNo(eo.getSeqNo());
        entity.setReference(eo.getReference());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setSubSeqNo(eo.getSubSeqNo());
        entity.setOrigChannelSeqNo(eo.getOrigChannelSeqNo());
        entity.setOrigSubSeqNo(eo.getOrigSubSeqNo());
        entity.setCloseAcctInd(eo.getCloseAcctInd() == null ? null : eo.getCloseAcctInd().getValue());
        entity.setCentDealType(eo.getCentDealType() == null ? null : eo.getCentDealType().getValue());
        entity.setCentAmt(eo.getCentAmt());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setAmtType(eo.getAmtType() == null ? null : eo.getAmtType().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setTranDate(eo.getTranDate());
        entity.setTranStatus(eo.getTranStatus() == null ? null : eo.getTranStatus().getValue());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setEventType(eo.getEventType());
        entity.setReversalFlag(eo.getReversalFlag() == null ? null : eo.getReversalFlag().getValue());
        entity.setReversalSeqNo(eo.getReversalSeqNo());
        entity.setReversalTranType(eo.getReversalTranType() == null ? null : eo.getReversalTranType().getValue());
        entity.setReversalTranDate(eo.getReversalTranDate());
        entity.setReversalUserId(eo.getReversalUserId());
        entity.setReversalReason(eo.getReversalReason());
        entity.setWipeAccount(eo.getWipeAccount() == null ? null : eo.getWipeAccount().getValue());
        entity.setUserId(eo.getUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbCentRegExample eoToEntityExample(RbCentRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbCentRegExample example = new RbCentRegExample();
        RbCentRegExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getSubSeqNo() != null) criteria.andSubSeqNoEqualTo(eo.getSubSeqNo());
        if (eo.getOrigChannelSeqNo() != null) criteria.andOrigChannelSeqNoEqualTo(eo.getOrigChannelSeqNo());
        if (eo.getOrigSubSeqNo() != null) criteria.andOrigSubSeqNoEqualTo(eo.getOrigSubSeqNo());
        if (eo.getCloseAcctInd() != null) criteria.andCloseAcctIndEqualTo(eo.getCloseAcctInd().getValue());
        if (eo.getCentDealType() != null) criteria.andCentDealTypeEqualTo(eo.getCentDealType().getValue());
        if (eo.getCentAmt() != null) criteria.andCentAmtEqualTo(eo.getCentAmt());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getAmtType() != null) criteria.andAmtTypeEqualTo(eo.getAmtType().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranStatus() != null) criteria.andTranStatusEqualTo(eo.getTranStatus().getValue());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getReversalFlag() != null) criteria.andReversalFlagEqualTo(eo.getReversalFlag().getValue());
        if (eo.getReversalSeqNo() != null) criteria.andReversalSeqNoEqualTo(eo.getReversalSeqNo());
        if (eo.getReversalTranType() != null) criteria.andReversalTranTypeEqualTo(eo.getReversalTranType().getValue());
        if (eo.getReversalTranDate() != null) criteria.andReversalTranDateEqualTo(eo.getReversalTranDate());
        if (eo.getReversalUserId() != null) criteria.andReversalUserIdEqualTo(eo.getReversalUserId());
        if (eo.getReversalReason() != null) criteria.andReversalReasonEqualTo(eo.getReversalReason());
        if (eo.getWipeAccount() != null) criteria.andWipeAccountEqualTo(eo.getWipeAccount().getValue());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}