package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctSettle;
import com.dcits.deposit.entity.RbAcctSettleExample;
import com.dcits.deposit.facade.eo.RbAcctSettleEO;
import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.enums.SettleMethod;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.SettleBankFlag;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class RbAcctSettleValueUtil {
    private RbAcctSettleValueUtil() {
    }

    public static RbAcctSettleEO entityToEo(RbAcctSettle entity) {
        if (entity == null) {
            return null;
        }
        RbAcctSettleEO eo = new RbAcctSettleEO();
        eo.setInternalKey(entity.getInternalKey());
        eo.setSettleNo(entity.getSettleNo());
        eo.setResSeqNo(entity.getResSeqNo());
        eo.setEventType(entity.getEventType());
        eo.setReference(entity.getReference());
        eo.setSettleAcctClass(SettleAcctClass.byValue(entity.getSettleAcctClass()));
        eo.setSettleMethod(SettleMethod.byValue(entity.getSettleMethod()));
        eo.setPayRecInd(PayRecInd.byValue(entity.getPayRecInd()));
        eo.setAmtType(AmtType.byValue(entity.getAmtType()));
        eo.setSettleClient(entity.getSettleClient());
        eo.setBankInOut(BankInOut.byValue(entity.getBankInOut()));
        eo.setSettleBankFlag(SettleBankFlag.byValue(entity.getSettleBankFlag()));
        eo.setSettleBankName(entity.getSettleBankName());
        eo.setSettleAcctInternalKey(entity.getSettleAcctInternalKey());
        eo.setSettleBaseAcctNo(entity.getSettleBaseAcctNo());
        eo.setSettleProdType(entity.getSettleProdType());
        eo.setSettleAcctCcy(AcctCcy.byValue(entity.getSettleAcctCcy()));
        eo.setSettleAcctSeqNo(entity.getSettleAcctSeqNo());
        eo.setSettleAcctName(entity.getSettleAcctName());
        eo.setSettleMobilePhone(entity.getSettleMobilePhone());
        eo.setSettleBranch(AcctBranch.byValue(entity.getSettleBranch()));
        eo.setSettleWeight(entity.getSettleWeight());
        eo.setSettleCcy(AcctCcy.byValue(entity.getSettleCcy()));
        eo.setSettleAmt(entity.getSettleAmt());
        eo.setClientNo(entity.getClientNo());
        eo.setUserId(entity.getUserId());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setDacValue(entity.getDacValue());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setBindAcctBranch(entity.getBindAcctBranch());
        eo.setCreateDate(entity.getCreateDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbAcctSettle eoToEntity(RbAcctSettleEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctSettle entity = new RbAcctSettle();
        entity.setInternalKey(eo.getInternalKey());
        entity.setSettleNo(eo.getSettleNo());
        entity.setResSeqNo(eo.getResSeqNo());
        entity.setEventType(eo.getEventType());
        entity.setReference(eo.getReference());
        entity.setSettleAcctClass(eo.getSettleAcctClass() == null ? null : eo.getSettleAcctClass().getValue());
        entity.setSettleMethod(eo.getSettleMethod() == null ? null : eo.getSettleMethod().getValue());
        entity.setPayRecInd(eo.getPayRecInd() == null ? null : eo.getPayRecInd().getValue());
        entity.setAmtType(eo.getAmtType() == null ? null : eo.getAmtType().getValue());
        entity.setSettleClient(eo.getSettleClient());
        entity.setBankInOut(eo.getBankInOut() == null ? null : eo.getBankInOut().getValue());
        entity.setSettleBankFlag(eo.getSettleBankFlag() == null ? null : eo.getSettleBankFlag().getValue());
        entity.setSettleBankName(eo.getSettleBankName());
        entity.setSettleAcctInternalKey(eo.getSettleAcctInternalKey());
        entity.setSettleBaseAcctNo(eo.getSettleBaseAcctNo());
        entity.setSettleProdType(eo.getSettleProdType());
        entity.setSettleAcctCcy(eo.getSettleAcctCcy() == null ? null : eo.getSettleAcctCcy().getValue());
        entity.setSettleAcctSeqNo(eo.getSettleAcctSeqNo());
        entity.setSettleAcctName(eo.getSettleAcctName());
        entity.setSettleMobilePhone(eo.getSettleMobilePhone());
        entity.setSettleBranch(eo.getSettleBranch() == null ? null : eo.getSettleBranch().getValue());
        entity.setSettleWeight(eo.getSettleWeight());
        entity.setSettleCcy(eo.getSettleCcy() == null ? null : eo.getSettleCcy().getValue());
        entity.setSettleAmt(eo.getSettleAmt());
        entity.setClientNo(eo.getClientNo());
        entity.setUserId(eo.getUserId());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setDacValue(eo.getDacValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setBindAcctBranch(eo.getBindAcctBranch());
        entity.setCreateDate(eo.getCreateDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbAcctSettleExample eoToEntityExample(RbAcctSettleEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctSettleExample example = new RbAcctSettleExample();
        RbAcctSettleExample.Criteria criteria = example.createCriteria();
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getSettleNo() != null) criteria.andSettleNoEqualTo(eo.getSettleNo());
        if (eo.getResSeqNo() != null) criteria.andResSeqNoEqualTo(eo.getResSeqNo());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getSettleAcctClass() != null) criteria.andSettleAcctClassEqualTo(eo.getSettleAcctClass().getValue());
        if (eo.getSettleMethod() != null) criteria.andSettleMethodEqualTo(eo.getSettleMethod().getValue());
        if (eo.getPayRecInd() != null) criteria.andPayRecIndEqualTo(eo.getPayRecInd().getValue());
        if (eo.getAmtType() != null) criteria.andAmtTypeEqualTo(eo.getAmtType().getValue());
        if (eo.getSettleClient() != null) criteria.andSettleClientEqualTo(eo.getSettleClient());
        if (eo.getBankInOut() != null) criteria.andBankInOutEqualTo(eo.getBankInOut().getValue());
        if (eo.getSettleBankFlag() != null) criteria.andSettleBankFlagEqualTo(eo.getSettleBankFlag().getValue());
        if (eo.getSettleBankName() != null) criteria.andSettleBankNameEqualTo(eo.getSettleBankName());
        if (eo.getSettleAcctInternalKey() != null) criteria.andSettleAcctInternalKeyEqualTo(eo.getSettleAcctInternalKey());
        if (eo.getSettleBaseAcctNo() != null) criteria.andSettleBaseAcctNoEqualTo(eo.getSettleBaseAcctNo());
        if (eo.getSettleProdType() != null) criteria.andSettleProdTypeEqualTo(eo.getSettleProdType());
        if (eo.getSettleAcctCcy() != null) criteria.andSettleAcctCcyEqualTo(eo.getSettleAcctCcy().getValue());
        if (eo.getSettleAcctSeqNo() != null) criteria.andSettleAcctSeqNoEqualTo(eo.getSettleAcctSeqNo());
        if (eo.getSettleAcctName() != null) criteria.andSettleAcctNameEqualTo(eo.getSettleAcctName());
        if (eo.getSettleMobilePhone() != null) criteria.andSettleMobilePhoneEqualTo(eo.getSettleMobilePhone());
        if (eo.getSettleBranch() != null) criteria.andSettleBranchEqualTo(eo.getSettleBranch().getValue());
        if (eo.getSettleWeight() != null) criteria.andSettleWeightEqualTo(eo.getSettleWeight());
        if (eo.getSettleCcy() != null) criteria.andSettleCcyEqualTo(eo.getSettleCcy().getValue());
        if (eo.getSettleAmt() != null) criteria.andSettleAmtEqualTo(eo.getSettleAmt());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getDacValue() != null) criteria.andDacValueEqualTo(eo.getDacValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getBindAcctBranch() != null) criteria.andBindAcctBranchEqualTo(eo.getBindAcctBranch());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}