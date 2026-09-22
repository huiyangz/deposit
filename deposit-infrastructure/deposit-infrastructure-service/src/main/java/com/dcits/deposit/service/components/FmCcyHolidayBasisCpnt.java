package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmCcyHoliday;
import com.dcits.deposit.entity.FmCcyHolidayExample;
import com.dcits.deposit.facade.components.IFmCcyHolidayBcc;
import com.dcits.deposit.facade.eo.FmCcyHolidayEO;
import com.dcits.deposit.repo.FmCcyHolidayMapper;
import com.dcits.deposit.service.utils.FmCcyHolidayValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmCcyHolidayBasisCpnt implements IFmCcyHolidayBcc {
    @Autowired
    FmCcyHolidayMapper fmCcyHolidayMapper;

    @Override
    public long countByEo(FmCcyHolidayEO eo) {
        FmCcyHolidayExample example = FmCcyHolidayValueUtil.eoToEntityExample(eo);
        return fmCcyHolidayMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmCcyHolidayEO eo) {
        FmCcyHolidayExample example = FmCcyHolidayValueUtil.eoToEntityExample(eo);
        return fmCcyHolidayMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String ccy, Date holidayDate) {
        return fmCcyHolidayMapper.deleteByPrimaryKey(ccy, holidayDate);
    }

    @Override
    public int create(FmCcyHolidayEO eo) {
        FmCcyHoliday row = FmCcyHolidayValueUtil.eoToEntity(eo);
        return fmCcyHolidayMapper.insert(row);
    }

    @Override
    public int createSelective(FmCcyHolidayEO eo) {
        FmCcyHoliday row = FmCcyHolidayValueUtil.eoToEntity(eo);
        return fmCcyHolidayMapper.insertSelective(row);
    }

    @Override
    public List<FmCcyHolidayEO> findByEo(FmCcyHolidayEO eo) {
        FmCcyHolidayExample example = FmCcyHolidayValueUtil.eoToEntityExample(eo);
        List<FmCcyHolidayEO> result = new ArrayList<>();
        List<FmCcyHoliday> dbResult = fmCcyHolidayMapper.selectByExample(example);
        for (FmCcyHoliday item : dbResult) {
            result.add(FmCcyHolidayValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmCcyHolidayEO findByPrimaryKey(String ccy, Date holidayDate) {
        return FmCcyHolidayValueUtil.entityToEo(fmCcyHolidayMapper.selectByPrimaryKey(ccy, holidayDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmCcyHolidayEO eo) {
        FmCcyHoliday row = FmCcyHolidayValueUtil.eoToEntity(eo);
        return fmCcyHolidayMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmCcyHolidayEO eo) {
        FmCcyHoliday row = FmCcyHolidayValueUtil.eoToEntity(eo);
        return fmCcyHolidayMapper.updateByPrimaryKey(row);
    }
}