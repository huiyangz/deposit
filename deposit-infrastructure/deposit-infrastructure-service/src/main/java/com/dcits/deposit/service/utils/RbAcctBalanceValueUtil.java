package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctBalance;
import com.dcits.deposit.entity.RbAcctBalanceExample;
import com.dcits.deposit.facade.eo.RbAcctBalanceEO;
import com.dcits.deposit.enums.Company;

public final class RbAcctBalanceValueUtil {
    private RbAcctBalanceValueUtil() {
    }

    public static RbAcctBalanceEO entityToEo(RbAcctBalance entity) {
        if (entity == null) {
            return null;
        }
        RbAcctBalanceEO eo = new RbAcctBalanceEO();
        eo.setInternalKey(entity.getInternalKey());
        eo.setTotalAmount(entity.getTotalAmount());
        eo.setTotalAmountPrev(entity.getTotalAmountPrev());
        eo.setTotalAmountLastPrev(entity.getTotalAmountLastPrev());
        eo.setPldAmount(entity.getPldAmount());
        eo.setFinregAmount(entity.getFinregAmount());
        eo.setDosAmount(entity.getDosAmount());
        eo.setOdAmount(entity.getOdAmount());
        eo.setOddAmount(entity.getOddAmount());
        eo.setLastBalUpdDate(entity.getLastBalUpdDate());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setClientNo(entity.getClientNo());
        eo.setDacValue(entity.getDacValue());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbAcctBalance eoToEntity(RbAcctBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctBalance entity = new RbAcctBalance();
        entity.setInternalKey(eo.getInternalKey());
        entity.setTotalAmount(eo.getTotalAmount());
        entity.setTotalAmountPrev(eo.getTotalAmountPrev());
        entity.setTotalAmountLastPrev(eo.getTotalAmountLastPrev());
        entity.setPldAmount(eo.getPldAmount());
        entity.setFinregAmount(eo.getFinregAmount());
        entity.setDosAmount(eo.getDosAmount());
        entity.setOdAmount(eo.getOdAmount());
        entity.setOddAmount(eo.getOddAmount());
        entity.setLastBalUpdDate(eo.getLastBalUpdDate());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setClientNo(eo.getClientNo());
        entity.setDacValue(eo.getDacValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbAcctBalanceExample eoToEntityExample(RbAcctBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctBalanceExample example = new RbAcctBalanceExample();
        RbAcctBalanceExample.Criteria criteria = example.createCriteria();
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getTotalAmount() != null) criteria.andTotalAmountEqualTo(eo.getTotalAmount());
        if (eo.getTotalAmountPrev() != null) criteria.andTotalAmountPrevEqualTo(eo.getTotalAmountPrev());
        if (eo.getTotalAmountLastPrev() != null) criteria.andTotalAmountLastPrevEqualTo(eo.getTotalAmountLastPrev());
        if (eo.getPldAmount() != null) criteria.andPldAmountEqualTo(eo.getPldAmount());
        if (eo.getFinregAmount() != null) criteria.andFinregAmountEqualTo(eo.getFinregAmount());
        if (eo.getDosAmount() != null) criteria.andDosAmountEqualTo(eo.getDosAmount());
        if (eo.getOdAmount() != null) criteria.andOdAmountEqualTo(eo.getOdAmount());
        if (eo.getOddAmount() != null) criteria.andOddAmountEqualTo(eo.getOddAmount());
        if (eo.getLastBalUpdDate() != null) criteria.andLastBalUpdDateEqualTo(eo.getLastBalUpdDate());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getDacValue() != null) criteria.andDacValueEqualTo(eo.getDacValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}