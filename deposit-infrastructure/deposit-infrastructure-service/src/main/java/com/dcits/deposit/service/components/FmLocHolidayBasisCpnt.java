package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.WorkingHoliday;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmLocHoliday;
import com.dcits.deposit.entity.FmLocHolidayExample;
import com.dcits.deposit.facade.components.IFmLocHolidayBcc;
import com.dcits.deposit.facade.eo.FmLocHolidayEO;
import com.dcits.deposit.repo.FmLocHolidayMapper;
import com.dcits.deposit.service.utils.FmLocHolidayValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmLocHolidayBasisCpnt implements IFmLocHolidayBcc {
    @Autowired
    FmLocHolidayMapper fmLocHolidayMapper;

    @Override
    public long countByEo(FmLocHolidayEO eo) {
        FmLocHolidayExample example = FmLocHolidayValueUtil.eoToEntityExample(eo);
        return fmLocHolidayMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmLocHolidayEO eo) {
        FmLocHolidayExample example = FmLocHolidayValueUtil.eoToEntityExample(eo);
        return fmLocHolidayMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String country, String state, Date holidayDate) {
        return fmLocHolidayMapper.deleteByPrimaryKey(country, state, holidayDate);
    }

    @Override
    public int create(FmLocHolidayEO eo) {
        FmLocHoliday row = FmLocHolidayValueUtil.eoToEntity(eo);
        return fmLocHolidayMapper.insert(row);
    }

    @Override
    public int createSelective(FmLocHolidayEO eo) {
        FmLocHoliday row = FmLocHolidayValueUtil.eoToEntity(eo);
        return fmLocHolidayMapper.insertSelective(row);
    }

    @Override
    public List<FmLocHolidayEO> findByEo(FmLocHolidayEO eo) {
        FmLocHolidayExample example = FmLocHolidayValueUtil.eoToEntityExample(eo);
        List<FmLocHolidayEO> result = new ArrayList<>();
        List<FmLocHoliday> dbResult = fmLocHolidayMapper.selectByExample(example);
        for (FmLocHoliday item : dbResult) {
            result.add(FmLocHolidayValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmLocHolidayEO findByPrimaryKey(String country, String state, Date holidayDate) {
        return FmLocHolidayValueUtil.entityToEo(fmLocHolidayMapper.selectByPrimaryKey(country, state, holidayDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmLocHolidayEO eo) {
        FmLocHoliday row = FmLocHolidayValueUtil.eoToEntity(eo);
        return fmLocHolidayMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmLocHolidayEO eo) {
        FmLocHoliday row = FmLocHolidayValueUtil.eoToEntity(eo);
        return fmLocHolidayMapper.updateByPrimaryKey(row);
    }
}