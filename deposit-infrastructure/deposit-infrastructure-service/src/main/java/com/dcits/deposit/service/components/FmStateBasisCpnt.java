package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.Weekend1;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmState;
import com.dcits.deposit.entity.FmStateExample;
import com.dcits.deposit.facade.components.IFmStateBcc;
import com.dcits.deposit.facade.eo.FmStateEO;
import com.dcits.deposit.repo.FmStateMapper;
import com.dcits.deposit.service.utils.FmStateValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmStateBasisCpnt implements IFmStateBcc {
    @Autowired
    FmStateMapper fmStateMapper;

    @Override
    public long countByEo(FmStateEO eo) {
        FmStateExample example = FmStateValueUtil.eoToEntityExample(eo);
        return fmStateMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmStateEO eo) {
        FmStateExample example = FmStateValueUtil.eoToEntityExample(eo);
        return fmStateMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String country, String state) {
        return fmStateMapper.deleteByPrimaryKey(country, state);
    }

    @Override
    public int create(FmStateEO eo) {
        FmState row = FmStateValueUtil.eoToEntity(eo);
        return fmStateMapper.insert(row);
    }

    @Override
    public int createSelective(FmStateEO eo) {
        FmState row = FmStateValueUtil.eoToEntity(eo);
        return fmStateMapper.insertSelective(row);
    }

    @Override
    public List<FmStateEO> findByEo(FmStateEO eo) {
        FmStateExample example = FmStateValueUtil.eoToEntityExample(eo);
        List<FmStateEO> result = new ArrayList<>();
        List<FmState> dbResult = fmStateMapper.selectByExample(example);
        for (FmState item : dbResult) {
            result.add(FmStateValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmStateEO findByPrimaryKey(String country, String state) {
        return FmStateValueUtil.entityToEo(fmStateMapper.selectByPrimaryKey(country, state));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmStateEO eo) {
        FmState row = FmStateValueUtil.eoToEntity(eo);
        return fmStateMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmStateEO eo) {
        FmState row = FmStateValueUtil.eoToEntity(eo);
        return fmStateMapper.updateByPrimaryKey(row);
    }
}