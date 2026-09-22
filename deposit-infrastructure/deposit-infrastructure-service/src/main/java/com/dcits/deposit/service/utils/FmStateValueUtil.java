package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmState;
import com.dcits.deposit.entity.FmStateExample;
import com.dcits.deposit.facade.eo.FmStateEO;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.Weekend1;
import com.dcits.deposit.enums.Weekend1;
import com.dcits.deposit.enums.Company;

public final class FmStateValueUtil {
    private FmStateValueUtil() {
    }

    public static FmStateEO entityToEo(FmState entity) {
        if (entity == null) {
            return null;
        }
        FmStateEO eo = new FmStateEO();
        eo.setCountry(IssCountry.byValue(entity.getCountry()));
        eo.setState(OthBranchRegionalismCode.byValue(entity.getState()));
        eo.setStateDesc(entity.getStateDesc());
        eo.setWeekend1(Weekend1.byValue(entity.getWeekend1()));
        eo.setWeekend2(Weekend1.byValue(entity.getWeekend2()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static FmState eoToEntity(FmStateEO eo) {
        if (eo == null) {
            return null;
        }
        FmState entity = new FmState();
        entity.setCountry(eo.getCountry() == null ? null : eo.getCountry().getValue());
        entity.setState(eo.getState() == null ? null : eo.getState().getValue());
        entity.setStateDesc(eo.getStateDesc());
        entity.setWeekend1(eo.getWeekend1() == null ? null : eo.getWeekend1().getValue());
        entity.setWeekend2(eo.getWeekend2() == null ? null : eo.getWeekend2().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static FmStateExample eoToEntityExample(FmStateEO eo) {
        if (eo == null) {
            return null;
        }
        FmStateExample example = new FmStateExample();
        FmStateExample.Criteria criteria = example.createCriteria();
        if (eo.getCountry() != null) criteria.andCountryEqualTo(eo.getCountry().getValue());
        if (eo.getState() != null) criteria.andStateEqualTo(eo.getState().getValue());
        if (eo.getStateDesc() != null) criteria.andStateDescEqualTo(eo.getStateDesc());
        if (eo.getWeekend1() != null) criteria.andWeekend1EqualTo(eo.getWeekend1().getValue());
        if (eo.getWeekend2() != null) criteria.andWeekend2EqualTo(eo.getWeekend2().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}