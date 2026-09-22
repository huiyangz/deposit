package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.ApplyInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HolidayType;
import com.dcits.deposit.enums.WorkingHoliday;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmBranchHoliday;
import com.dcits.deposit.entity.FmBranchHolidayExample;
import com.dcits.deposit.facade.components.IFmBranchHolidayBcc;
import com.dcits.deposit.facade.eo.FmBranchHolidayEO;
import com.dcits.deposit.repo.FmBranchHolidayMapper;
import com.dcits.deposit.service.utils.FmBranchHolidayValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmBranchHolidayBasisCpnt implements IFmBranchHolidayBcc {
    @Autowired
    FmBranchHolidayMapper fmBranchHolidayMapper;

    @Override
    public long countByEo(FmBranchHolidayEO eo) {
        FmBranchHolidayExample example = FmBranchHolidayValueUtil.eoToEntityExample(eo);
        return fmBranchHolidayMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmBranchHolidayEO eo) {
        FmBranchHolidayExample example = FmBranchHolidayValueUtil.eoToEntityExample(eo);
        return fmBranchHolidayMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String branch, String holidayType, Date holidayDate) {
        return fmBranchHolidayMapper.deleteByPrimaryKey(branch, holidayType, holidayDate);
    }

    @Override
    public int create(FmBranchHolidayEO eo) {
        FmBranchHoliday row = FmBranchHolidayValueUtil.eoToEntity(eo);
        return fmBranchHolidayMapper.insert(row);
    }

    @Override
    public int createSelective(FmBranchHolidayEO eo) {
        FmBranchHoliday row = FmBranchHolidayValueUtil.eoToEntity(eo);
        return fmBranchHolidayMapper.insertSelective(row);
    }

    @Override
    public List<FmBranchHolidayEO> findByEo(FmBranchHolidayEO eo) {
        FmBranchHolidayExample example = FmBranchHolidayValueUtil.eoToEntityExample(eo);
        List<FmBranchHolidayEO> result = new ArrayList<>();
        List<FmBranchHoliday> dbResult = fmBranchHolidayMapper.selectByExample(example);
        for (FmBranchHoliday item : dbResult) {
            result.add(FmBranchHolidayValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmBranchHolidayEO findByPrimaryKey(String branch, String holidayType, Date holidayDate) {
        return FmBranchHolidayValueUtil.entityToEo(fmBranchHolidayMapper.selectByPrimaryKey(branch, holidayType, holidayDate));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmBranchHolidayEO eo) {
        FmBranchHoliday row = FmBranchHolidayValueUtil.eoToEntity(eo);
        return fmBranchHolidayMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmBranchHolidayEO eo) {
        FmBranchHoliday row = FmBranchHolidayValueUtil.eoToEntity(eo);
        return fmBranchHolidayMapper.updateByPrimaryKey(row);
    }
}