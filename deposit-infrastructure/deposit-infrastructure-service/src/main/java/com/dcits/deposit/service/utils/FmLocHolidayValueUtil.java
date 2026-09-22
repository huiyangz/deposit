package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmLocHoliday;
import com.dcits.deposit.entity.FmLocHolidayExample;
import com.dcits.deposit.facade.eo.FmLocHolidayEO;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.WorkingHoliday;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;

public final class FmLocHolidayValueUtil {
    private FmLocHolidayValueUtil() {
    }

    public static FmLocHolidayEO entityToEo(FmLocHoliday entity) {
        if (entity == null) {
            return null;
        }
        FmLocHolidayEO eo = new FmLocHolidayEO();
        eo.setHolidayType(HolidayType.byValue(entity.getHolidayType()));
        eo.setHolidayDesc(entity.getHolidayDesc());
        eo.setCountry(IssCountry.byValue(entity.getCountry()));
        eo.setState(OthBranchRegionalismCode.byValue(entity.getState()));
        eo.setHolidayDate(entity.getHolidayDate());
        eo.setWorkingHoliday(WorkingHoliday.byValue(entity.getWorkingHoliday()));
        eo.setApplyInd(ApplyInd.byValue(entity.getApplyInd()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static FmLocHoliday eoToEntity(FmLocHolidayEO eo) {
        if (eo == null) {
            return null;
        }
        FmLocHoliday entity = new FmLocHoliday();
        entity.setHolidayType(eo.getHolidayType() == null ? null : eo.getHolidayType().getValue());
        entity.setHolidayDesc(eo.getHolidayDesc());
        entity.setCountry(eo.getCountry() == null ? null : eo.getCountry().getValue());
        entity.setState(eo.getState() == null ? null : eo.getState().getValue());
        entity.setHolidayDate(eo.getHolidayDate());
        entity.setWorkingHoliday(eo.getWorkingHoliday() == null ? null : eo.getWorkingHoliday().getValue());
        entity.setApplyInd(eo.getApplyInd() == null ? null : eo.getApplyInd().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static FmLocHolidayExample eoToEntityExample(FmLocHolidayEO eo) {
        if (eo == null) {
            return null;
        }
        FmLocHolidayExample example = new FmLocHolidayExample();
        FmLocHolidayExample.Criteria criteria = example.createCriteria();
        if (eo.getHolidayType() != null) criteria.andHolidayTypeEqualTo(eo.getHolidayType().getValue());
        if (eo.getHolidayDesc() != null) criteria.andHolidayDescEqualTo(eo.getHolidayDesc());
        if (eo.getCountry() != null) criteria.andCountryEqualTo(eo.getCountry().getValue());
        if (eo.getState() != null) criteria.andStateEqualTo(eo.getState().getValue());
        if (eo.getHolidayDate() != null) criteria.andHolidayDateEqualTo(eo.getHolidayDate());
        if (eo.getWorkingHoliday() != null) criteria.andWorkingHolidayEqualTo(eo.getWorkingHoliday().getValue());
        if (eo.getApplyInd() != null) criteria.andApplyIndEqualTo(eo.getApplyInd().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}