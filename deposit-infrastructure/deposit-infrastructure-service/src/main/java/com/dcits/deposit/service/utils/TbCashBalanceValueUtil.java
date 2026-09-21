package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.TbCashBalance;
import com.dcits.deposit.entity.TbCashBalanceExample;
import com.dcits.deposit.facade.eo.TbCashBalanceEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class TbCashBalanceValueUtil {
    private TbCashBalanceValueUtil() {
    }

    public static TbCashBalanceEO entityToEo(TbCashBalance entity) {
        if (entity == null) {
            return null;
        }
        TbCashBalanceEO eo = new TbCashBalanceEO();
        eo.setCashId(entity.getCashId());
        eo.setTailboxId(entity.getTailboxId());
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setAmount(entity.getAmount());
        eo.setAvailableAmt(entity.getAvailableAmt());
        eo.setEopdAmount(entity.getEopdAmount());
        eo.setSopdAmount(entity.getSopdAmount());
        eo.setLockAmount(entity.getLockAmount());
        eo.setLockSpallAmt(entity.getLockSpallAmt());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static TbCashBalance eoToEntity(TbCashBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        TbCashBalance entity = new TbCashBalance();
        entity.setCashId(eo.getCashId());
        entity.setTailboxId(eo.getTailboxId());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setAmount(eo.getAmount());
        entity.setAvailableAmt(eo.getAvailableAmt());
        entity.setEopdAmount(eo.getEopdAmount());
        entity.setSopdAmount(eo.getSopdAmount());
        entity.setLockAmount(eo.getLockAmount());
        entity.setLockSpallAmt(eo.getLockSpallAmt());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static TbCashBalanceExample eoToEntityExample(TbCashBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        TbCashBalanceExample example = new TbCashBalanceExample();
        TbCashBalanceExample.Criteria criteria = example.createCriteria();
        if (eo.getCashId() != null) criteria.andCashIdEqualTo(eo.getCashId());
        if (eo.getTailboxId() != null) criteria.andTailboxIdEqualTo(eo.getTailboxId());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getAmount() != null) criteria.andAmountEqualTo(eo.getAmount());
        if (eo.getAvailableAmt() != null) criteria.andAvailableAmtEqualTo(eo.getAvailableAmt());
        if (eo.getEopdAmount() != null) criteria.andEopdAmountEqualTo(eo.getEopdAmount());
        if (eo.getSopdAmount() != null) criteria.andSopdAmountEqualTo(eo.getSopdAmount());
        if (eo.getLockAmount() != null) criteria.andLockAmountEqualTo(eo.getLockAmount());
        if (eo.getLockSpallAmt() != null) criteria.andLockSpallAmtEqualTo(eo.getLockSpallAmt());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}