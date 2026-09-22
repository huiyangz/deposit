package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmCcyHoliday;
import com.dcits.deposit.entity.FmCcyHolidayExample;
import com.dcits.deposit.facade.eo.FmCcyHolidayEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;

public final class FmCcyHolidayValueUtil {
    private FmCcyHolidayValueUtil() {
    }

    public static FmCcyHolidayEO entityToEo(FmCcyHoliday entity) {
        if (entity == null) {
            return null;
        }
        FmCcyHolidayEO eo = new FmCcyHolidayEO();
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setHolidayType(HolidayType.byValue(entity.getHolidayType()));
        eo.setHolidayDesc(entity.getHolidayDesc());
        eo.setApplyInd(ApplyInd.byValue(entity.getApplyInd()));
        eo.setHolidayDate(entity.getHolidayDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setHubBatchFlag(entity.getHubBatchFlag());
        return eo;
    }

    public static FmCcyHoliday eoToEntity(FmCcyHolidayEO eo) {
        if (eo == null) {
            return null;
        }
        FmCcyHoliday entity = new FmCcyHoliday();
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setHolidayType(eo.getHolidayType() == null ? null : eo.getHolidayType().getValue());
        entity.setHolidayDesc(eo.getHolidayDesc());
        entity.setApplyInd(eo.getApplyInd() == null ? null : eo.getApplyInd().getValue());
        entity.setHolidayDate(eo.getHolidayDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setHubBatchFlag(eo.getHubBatchFlag());
        return entity;
    }

    public static FmCcyHolidayExample eoToEntityExample(FmCcyHolidayEO eo) {
        if (eo == null) {
            return null;
        }
        FmCcyHolidayExample example = new FmCcyHolidayExample();
        FmCcyHolidayExample.Criteria criteria = example.createCriteria();
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getHolidayType() != null) criteria.andHolidayTypeEqualTo(eo.getHolidayType().getValue());
        if (eo.getHolidayDesc() != null) criteria.andHolidayDescEqualTo(eo.getHolidayDesc());
        if (eo.getApplyInd() != null) criteria.andApplyIndEqualTo(eo.getApplyInd().getValue());
        if (eo.getHolidayDate() != null) criteria.andHolidayDateEqualTo(eo.getHolidayDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getHubBatchFlag() != null) criteria.andHubBatchFlagEqualTo(eo.getHubBatchFlag());
        return example;
    }
}