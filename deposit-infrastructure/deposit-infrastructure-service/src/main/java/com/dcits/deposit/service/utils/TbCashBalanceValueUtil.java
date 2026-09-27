package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.TbCashBalance;
import com.dcits.deposit.entity.TbCashBalanceExample;
import com.dcits.deposit.facade.eo.TbCashBalanceEO;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.Ccy;

public final class TbCashBalanceValueUtil {
    private TbCashBalanceValueUtil() {
    }

    public static TbCashBalanceEO entityToEo(TbCashBalance entity) {
        if (entity == null) {
            return null;
        }
        TbCashBalanceEO eo = new TbCashBalanceEO();
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setBranch(TranBranch.byValue(entity.getBranch()));
        eo.setEopdAmount(entity.getEopdAmount());
        eo.setTailboxId(entity.getTailboxId());
        eo.setAvailableAmt(entity.getAvailableAmt());
        eo.setSopdAmount(entity.getSopdAmount());
        eo.setLockAmount(entity.getLockAmount());
        eo.setCompany(entity.getCompany());
        eo.setAmount(entity.getAmount());
        eo.setCcy(Ccy.byValue(entity.getCcy()));
        eo.setLockSpallAmt(entity.getLockSpallAmt());
        eo.setCashId(entity.getCashId());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static TbCashBalance eoToEntity(TbCashBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        TbCashBalance entity = new TbCashBalance();
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setEopdAmount(eo.getEopdAmount());
        entity.setTailboxId(eo.getTailboxId());
        entity.setAvailableAmt(eo.getAvailableAmt());
        entity.setSopdAmount(eo.getSopdAmount());
        entity.setLockAmount(eo.getLockAmount());
        entity.setCompany(eo.getCompany());
        entity.setAmount(eo.getAmount());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setLockSpallAmt(eo.getLockSpallAmt());
        entity.setCashId(eo.getCashId());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static TbCashBalanceExample eoToEntityExample(TbCashBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        TbCashBalanceExample example = new TbCashBalanceExample();
        TbCashBalanceExample.Criteria criteria = example.createCriteria();
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getEopdAmount() != null) criteria.andEopdAmountEqualTo(eo.getEopdAmount());
        if (eo.getTailboxId() != null) criteria.andTailboxIdEqualTo(eo.getTailboxId());
        if (eo.getAvailableAmt() != null) criteria.andAvailableAmtEqualTo(eo.getAvailableAmt());
        if (eo.getSopdAmount() != null) criteria.andSopdAmountEqualTo(eo.getSopdAmount());
        if (eo.getLockAmount() != null) criteria.andLockAmountEqualTo(eo.getLockAmount());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany());
        if (eo.getAmount() != null) criteria.andAmountEqualTo(eo.getAmount());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getLockSpallAmt() != null) criteria.andLockSpallAmtEqualTo(eo.getLockSpallAmt());
        if (eo.getCashId() != null) criteria.andCashIdEqualTo(eo.getCashId());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}