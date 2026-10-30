package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusAcctBalance;
import com.dcits.deposit.entity.RbBusAcctBalanceExample;
import com.dcits.deposit.facade.eo.RbBusAcctBalanceEO;

public final class RbBusAcctBalanceValueUtil {
    private RbBusAcctBalanceValueUtil() {
    }

    public static RbBusAcctBalanceEO entityToEo(RbBusAcctBalance entity) {
        if (entity == null) {
            return null;
        }
        RbBusAcctBalanceEO eo = new RbBusAcctBalanceEO();
        eo.setAcctAvailBalPrev(entity.getAcctAvailBalPrev());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setOddAmount(entity.getOddAmount());
        eo.setOdAmount(entity.getOdAmount());
        eo.setAcctAvailBal(entity.getAcctAvailBal());
        eo.setFinregAmount(entity.getFinregAmount());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setInternalKey(entity.getInternalKey());
        eo.setPldAmount(entity.getPldAmount());
        eo.setTotalAmount(entity.getTotalAmount());
        eo.setDosAmount(entity.getDosAmount());
        return eo;
    }

    public static RbBusAcctBalance eoToEntity(RbBusAcctBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctBalance entity = new RbBusAcctBalance();
        entity.setAcctAvailBalPrev(eo.getAcctAvailBalPrev());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setOddAmount(eo.getOddAmount());
        entity.setOdAmount(eo.getOdAmount());
        entity.setAcctAvailBal(eo.getAcctAvailBal());
        entity.setFinregAmount(eo.getFinregAmount());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setInternalKey(eo.getInternalKey());
        entity.setPldAmount(eo.getPldAmount());
        entity.setTotalAmount(eo.getTotalAmount());
        entity.setDosAmount(eo.getDosAmount());
        return entity;
    }

    public static RbBusAcctBalanceExample eoToEntityExample(RbBusAcctBalanceEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctBalanceExample example = new RbBusAcctBalanceExample();
        RbBusAcctBalanceExample.Criteria criteria = example.createCriteria();
        if (eo.getAcctAvailBalPrev() != null) criteria.andAcctAvailBalPrevEqualTo(eo.getAcctAvailBalPrev());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getOddAmount() != null) criteria.andOddAmountEqualTo(eo.getOddAmount());
        if (eo.getOdAmount() != null) criteria.andOdAmountEqualTo(eo.getOdAmount());
        if (eo.getAcctAvailBal() != null) criteria.andAcctAvailBalEqualTo(eo.getAcctAvailBal());
        if (eo.getFinregAmount() != null) criteria.andFinregAmountEqualTo(eo.getFinregAmount());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getPldAmount() != null) criteria.andPldAmountEqualTo(eo.getPldAmount());
        if (eo.getTotalAmount() != null) criteria.andTotalAmountEqualTo(eo.getTotalAmount());
        if (eo.getDosAmount() != null) criteria.andDosAmountEqualTo(eo.getDosAmount());
        return example;
    }
}