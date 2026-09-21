package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbTaeAccountCheckSum;
import com.dcits.deposit.entity.RbTaeAccountCheckSumExample;
import com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO;
import com.dcits.deposit.enums.Company;

public final class RbTaeAccountCheckSumValueUtil {
    private RbTaeAccountCheckSumValueUtil() {
    }

    public static RbTaeAccountCheckSumEO entityToEo(RbTaeAccountCheckSum entity) {
        if (entity == null) {
            return null;
        }
        RbTaeAccountCheckSumEO eo = new RbTaeAccountCheckSumEO();
        eo.setSessionId(entity.getSessionId());
        eo.setCretTotalNum(entity.getCretTotalNum());
        eo.setCretTotalAmt(entity.getCretTotalAmt());
        eo.setDebtTotalNum(entity.getDebtTotalNum());
        eo.setDebtTotalAmt(entity.getDebtTotalAmt());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbTaeAccountCheckSum eoToEntity(RbTaeAccountCheckSumEO eo) {
        if (eo == null) {
            return null;
        }
        RbTaeAccountCheckSum entity = new RbTaeAccountCheckSum();
        entity.setSessionId(eo.getSessionId());
        entity.setCretTotalNum(eo.getCretTotalNum());
        entity.setCretTotalAmt(eo.getCretTotalAmt());
        entity.setDebtTotalNum(eo.getDebtTotalNum());
        entity.setDebtTotalAmt(eo.getDebtTotalAmt());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbTaeAccountCheckSumExample eoToEntityExample(RbTaeAccountCheckSumEO eo) {
        if (eo == null) {
            return null;
        }
        RbTaeAccountCheckSumExample example = new RbTaeAccountCheckSumExample();
        RbTaeAccountCheckSumExample.Criteria criteria = example.createCriteria();
        if (eo.getSessionId() != null) criteria.andSessionIdEqualTo(eo.getSessionId());
        if (eo.getCretTotalNum() != null) criteria.andCretTotalNumEqualTo(eo.getCretTotalNum());
        if (eo.getCretTotalAmt() != null) criteria.andCretTotalAmtEqualTo(eo.getCretTotalAmt());
        if (eo.getDebtTotalNum() != null) criteria.andDebtTotalNumEqualTo(eo.getDebtTotalNum());
        if (eo.getDebtTotalAmt() != null) criteria.andDebtTotalAmtEqualTo(eo.getDebtTotalAmt());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}