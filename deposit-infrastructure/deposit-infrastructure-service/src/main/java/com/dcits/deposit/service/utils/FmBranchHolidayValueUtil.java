package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmBranchHoliday;
import com.dcits.deposit.entity.FmBranchHolidayExample;
import com.dcits.deposit.facade.eo.FmBranchHolidayEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.WorkingHoliday;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;

public final class FmBranchHolidayValueUtil {
    private FmBranchHolidayValueUtil() {
    }

    public static FmBranchHolidayEO entityToEo(FmBranchHoliday entity) {
        if (entity == null) {
            return null;
        }
        FmBranchHolidayEO eo = new FmBranchHolidayEO();
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setHolidayType(HolidayType.byValue(entity.getHolidayType()));
        eo.setHolidayDesc(entity.getHolidayDesc());
        eo.setHolidayDate(entity.getHolidayDate());
        eo.setWorkingHoliday(WorkingHoliday.byValue(entity.getWorkingHoliday()));
        eo.setApplyInd(ApplyInd.byValue(entity.getApplyInd()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static FmBranchHoliday eoToEntity(FmBranchHolidayEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranchHoliday entity = new FmBranchHoliday();
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setHolidayType(eo.getHolidayType() == null ? null : eo.getHolidayType().getValue());
        entity.setHolidayDesc(eo.getHolidayDesc());
        entity.setHolidayDate(eo.getHolidayDate());
        entity.setWorkingHoliday(eo.getWorkingHoliday() == null ? null : eo.getWorkingHoliday().getValue());
        entity.setApplyInd(eo.getApplyInd() == null ? null : eo.getApplyInd().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static FmBranchHolidayExample eoToEntityExample(FmBranchHolidayEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranchHolidayExample example = new FmBranchHolidayExample();
        FmBranchHolidayExample.Criteria criteria = example.createCriteria();
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getHolidayType() != null) criteria.andHolidayTypeEqualTo(eo.getHolidayType().getValue());
        if (eo.getHolidayDesc() != null) criteria.andHolidayDescEqualTo(eo.getHolidayDesc());
        if (eo.getHolidayDate() != null) criteria.andHolidayDateEqualTo(eo.getHolidayDate());
        if (eo.getWorkingHoliday() != null) criteria.andWorkingHolidayEqualTo(eo.getWorkingHoliday().getValue());
        if (eo.getApplyInd() != null) criteria.andApplyIndEqualTo(eo.getApplyInd().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}