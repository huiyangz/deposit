package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusAcctSettle;
import com.dcits.deposit.entity.RbBusAcctSettleExample;
import com.dcits.deposit.facade.eo.RbBusAcctSettleEO;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SettleBankFlag;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.enums.SettleMethod;
import com.dcits.deposit.enums.AcctCcy;

public final class RbBusAcctSettleValueUtil {
    private RbBusAcctSettleValueUtil() {
    }

    public static RbBusAcctSettleEO entityToEo(RbBusAcctSettle entity) {
        if (entity == null) {
            return null;
        }
        RbBusAcctSettleEO eo = new RbBusAcctSettleEO();
        eo.setPayRecInd(PayRecInd.byValue(entity.getPayRecInd()));
        eo.setSettleBankFlag(SettleBankFlag.byValue(entity.getSettleBankFlag()));
        eo.setReference(entity.getReference());
        eo.setSettleCcy(Ccy.byValue(entity.getSettleCcy()));
        eo.setBankInOut(BankInOut.byValue(entity.getBankInOut()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setAmtType(IntCalcAmtType.byValue(entity.getAmtType()));
        eo.setSettleAcctClass(SettleAcctClass.byValue(entity.getSettleAcctClass()));
        eo.setSettleMethod(SettleMethod.byValue(entity.getSettleMethod()));
        eo.setResSeqNo(entity.getResSeqNo());
        eo.setEventType(entity.getEventType());
        eo.setInternalKey(entity.getInternalKey());
        eo.setSettleBaseAcctNo(entity.getSettleBaseAcctNo());
        eo.setSettleAcctCcy(AcctCcy.byValue(entity.getSettleAcctCcy()));
        eo.setSettleAcctName(entity.getSettleAcctName());
        eo.setSettleNo(entity.getSettleNo());
        eo.setSettleClient(entity.getSettleClient());
        eo.setSettleAcctSeqNo(entity.getSettleAcctSeqNo());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        return eo;
    }

    public static RbBusAcctSettle eoToEntity(RbBusAcctSettleEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctSettle entity = new RbBusAcctSettle();
        entity.setPayRecInd(eo.getPayRecInd() == null ? null : eo.getPayRecInd().getValue());
        entity.setSettleBankFlag(eo.getSettleBankFlag() == null ? null : eo.getSettleBankFlag().getValue());
        entity.setReference(eo.getReference());
        entity.setSettleCcy(eo.getSettleCcy() == null ? null : eo.getSettleCcy().getValue());
        entity.setBankInOut(eo.getBankInOut() == null ? null : eo.getBankInOut().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setAmtType(eo.getAmtType() == null ? null : eo.getAmtType().getValue());
        entity.setSettleAcctClass(eo.getSettleAcctClass() == null ? null : eo.getSettleAcctClass().getValue());
        entity.setSettleMethod(eo.getSettleMethod() == null ? null : eo.getSettleMethod().getValue());
        entity.setResSeqNo(eo.getResSeqNo());
        entity.setEventType(eo.getEventType());
        entity.setInternalKey(eo.getInternalKey());
        entity.setSettleBaseAcctNo(eo.getSettleBaseAcctNo());
        entity.setSettleAcctCcy(eo.getSettleAcctCcy() == null ? null : eo.getSettleAcctCcy().getValue());
        entity.setSettleAcctName(eo.getSettleAcctName());
        entity.setSettleNo(eo.getSettleNo());
        entity.setSettleClient(eo.getSettleClient());
        entity.setSettleAcctSeqNo(eo.getSettleAcctSeqNo());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        return entity;
    }

    public static RbBusAcctSettleExample eoToEntityExample(RbBusAcctSettleEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctSettleExample example = new RbBusAcctSettleExample();
        RbBusAcctSettleExample.Criteria criteria = example.createCriteria();
        if (eo.getPayRecInd() != null) criteria.andPayRecIndEqualTo(eo.getPayRecInd().getValue());
        if (eo.getSettleBankFlag() != null) criteria.andSettleBankFlagEqualTo(eo.getSettleBankFlag().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getSettleCcy() != null) criteria.andSettleCcyEqualTo(eo.getSettleCcy().getValue());
        if (eo.getBankInOut() != null) criteria.andBankInOutEqualTo(eo.getBankInOut().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getAmtType() != null) criteria.andAmtTypeEqualTo(eo.getAmtType().getValue());
        if (eo.getSettleAcctClass() != null) criteria.andSettleAcctClassEqualTo(eo.getSettleAcctClass().getValue());
        if (eo.getSettleMethod() != null) criteria.andSettleMethodEqualTo(eo.getSettleMethod().getValue());
        if (eo.getResSeqNo() != null) criteria.andResSeqNoEqualTo(eo.getResSeqNo());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getSettleBaseAcctNo() != null) criteria.andSettleBaseAcctNoEqualTo(eo.getSettleBaseAcctNo());
        if (eo.getSettleAcctCcy() != null) criteria.andSettleAcctCcyEqualTo(eo.getSettleAcctCcy().getValue());
        if (eo.getSettleAcctName() != null) criteria.andSettleAcctNameEqualTo(eo.getSettleAcctName());
        if (eo.getSettleNo() != null) criteria.andSettleNoEqualTo(eo.getSettleNo());
        if (eo.getSettleClient() != null) criteria.andSettleClientEqualTo(eo.getSettleClient());
        if (eo.getSettleAcctSeqNo() != null) criteria.andSettleAcctSeqNoEqualTo(eo.getSettleAcctSeqNo());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        return example;
    }
}