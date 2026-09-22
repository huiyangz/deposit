package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmDate;
import com.dcits.deposit.entity.FmDateExample;
import com.dcits.deposit.facade.eo.FmDateEO;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;

public final class FmDateValueUtil {
    private FmDateValueUtil() {
    }

    public static FmDateEO entityToEo(FmDate entity) {
        if (entity == null) {
            return null;
        }
        FmDateEO eo = new FmDateEO();
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setSystemPhase(entity.getSystemPhase());
        eo.setAcctEodFlag(entity.getAcctEodFlag());
        eo.setSuspendFlag(IndividualFlag.byValue(entity.getSuspendFlag()));
        eo.setLastRunDate(entity.getLastRunDate());
        eo.setRunDate(entity.getRunDate());
        eo.setNextRunDate(entity.getNextRunDate());
        eo.setMthEndDate(entity.getMthEndDate());
        eo.setQurEndDate(entity.getQurEndDate());
        eo.setHalfEndDate(entity.getHalfEndDate());
        eo.setYrEndDate(entity.getYrEndDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static FmDate eoToEntity(FmDateEO eo) {
        if (eo == null) {
            return null;
        }
        FmDate entity = new FmDate();
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setSystemPhase(eo.getSystemPhase());
        entity.setAcctEodFlag(eo.getAcctEodFlag());
        entity.setSuspendFlag(eo.getSuspendFlag() == null ? null : eo.getSuspendFlag().getValue());
        entity.setLastRunDate(eo.getLastRunDate());
        entity.setRunDate(eo.getRunDate());
        entity.setNextRunDate(eo.getNextRunDate());
        entity.setMthEndDate(eo.getMthEndDate());
        entity.setQurEndDate(eo.getQurEndDate());
        entity.setHalfEndDate(eo.getHalfEndDate());
        entity.setYrEndDate(eo.getYrEndDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static FmDateExample eoToEntityExample(FmDateEO eo) {
        if (eo == null) {
            return null;
        }
        FmDateExample example = new FmDateExample();
        FmDateExample.Criteria criteria = example.createCriteria();
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getSystemPhase() != null) criteria.andSystemPhaseEqualTo(eo.getSystemPhase());
        if (eo.getAcctEodFlag() != null) criteria.andAcctEodFlagEqualTo(eo.getAcctEodFlag());
        if (eo.getSuspendFlag() != null) criteria.andSuspendFlagEqualTo(eo.getSuspendFlag().getValue());
        if (eo.getLastRunDate() != null) criteria.andLastRunDateEqualTo(eo.getLastRunDate());
        if (eo.getRunDate() != null) criteria.andRunDateEqualTo(eo.getRunDate());
        if (eo.getNextRunDate() != null) criteria.andNextRunDateEqualTo(eo.getNextRunDate());
        if (eo.getMthEndDate() != null) criteria.andMthEndDateEqualTo(eo.getMthEndDate());
        if (eo.getQurEndDate() != null) criteria.andQurEndDateEqualTo(eo.getQurEndDate());
        if (eo.getHalfEndDate() != null) criteria.andHalfEndDateEqualTo(eo.getHalfEndDate());
        if (eo.getYrEndDate() != null) criteria.andYrEndDateEqualTo(eo.getYrEndDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}