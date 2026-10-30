package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.FmBranchCcy;
import com.dcits.deposit.entity.FmBranchCcyExample;
import com.dcits.deposit.facade.components.IFmBranchCcyBcc;
import com.dcits.deposit.facade.eo.FmBranchCcyEO;
import com.dcits.deposit.repo.FmBranchCcyMapper;
import com.dcits.deposit.service.utils.FmBranchCcyValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FmBranchCcyBasisCpnt implements IFmBranchCcyBcc {
    @Autowired
    FmBranchCcyMapper fmBranchCcyMapper;

    @Override
    public long countByEo(FmBranchCcyEO eo) {
        FmBranchCcyExample example = FmBranchCcyValueUtil.eoToEntityExample(eo);
        return fmBranchCcyMapper.countByExample(example);
    }

    @Override
    public int removeByEo(FmBranchCcyEO eo) {
        FmBranchCcyExample example = FmBranchCcyValueUtil.eoToEntityExample(eo);
        return fmBranchCcyMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String branch, String ccy) {
        return fmBranchCcyMapper.deleteByPrimaryKey(branch, ccy);
    }

    @Override
    public int create(FmBranchCcyEO eo) {
        FmBranchCcy row = FmBranchCcyValueUtil.eoToEntity(eo);
        return fmBranchCcyMapper.insert(row);
    }

    @Override
    public int createSelective(FmBranchCcyEO eo) {
        FmBranchCcy row = FmBranchCcyValueUtil.eoToEntity(eo);
        return fmBranchCcyMapper.insertSelective(row);
    }

    @Override
    public List<FmBranchCcyEO> findByEo(FmBranchCcyEO eo) {
        FmBranchCcyExample example = FmBranchCcyValueUtil.eoToEntityExample(eo);
        List<FmBranchCcyEO> result = new ArrayList<>();
        List<FmBranchCcy> dbResult = fmBranchCcyMapper.selectByExample(example);
        for (FmBranchCcy item : dbResult) {
            result.add(FmBranchCcyValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public FmBranchCcyEO findByPrimaryKey(String branch, String ccy) {
        return FmBranchCcyValueUtil.entityToEo(fmBranchCcyMapper.selectByPrimaryKey(branch, ccy));
    }

    @Override
    public int modifyByPrimaryKeySelective(FmBranchCcyEO eo) {
        FmBranchCcy row = FmBranchCcyValueUtil.eoToEntity(eo);
        return fmBranchCcyMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(FmBranchCcyEO eo) {
        FmBranchCcy row = FmBranchCcyValueUtil.eoToEntity(eo);
        return fmBranchCcyMapper.updateByPrimaryKey(row);
    }
}