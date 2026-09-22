package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbApprLetterParam;
import com.dcits.deposit.entity.RbApprLetterParamExample;
import com.dcits.deposit.facade.components.IRbApprLetterParamBcc;
import com.dcits.deposit.facade.eo.RbApprLetterParamEO;
import com.dcits.deposit.repo.RbApprLetterParamMapper;
import com.dcits.deposit.service.utils.RbApprLetterParamValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbApprLetterParamBasisCpnt implements IRbApprLetterParamBcc {
    @Autowired
    RbApprLetterParamMapper rbApprLetterParamMapper;

    @Override
    public long countByEo(RbApprLetterParamEO eo) {
        RbApprLetterParamExample example = RbApprLetterParamValueUtil.eoToEntityExample(eo);
        return rbApprLetterParamMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbApprLetterParamEO eo) {
        RbApprLetterParamExample example = RbApprLetterParamValueUtil.eoToEntityExample(eo);
        return rbApprLetterParamMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String paraKey) {
        return rbApprLetterParamMapper.deleteByPrimaryKey(paraKey);
    }

    @Override
    public int create(RbApprLetterParamEO eo) {
        RbApprLetterParam row = RbApprLetterParamValueUtil.eoToEntity(eo);
        return rbApprLetterParamMapper.insert(row);
    }

    @Override
    public int createSelective(RbApprLetterParamEO eo) {
        RbApprLetterParam row = RbApprLetterParamValueUtil.eoToEntity(eo);
        return rbApprLetterParamMapper.insertSelective(row);
    }

    @Override
    public List<RbApprLetterParamEO> findByEo(RbApprLetterParamEO eo) {
        RbApprLetterParamExample example = RbApprLetterParamValueUtil.eoToEntityExample(eo);
        List<RbApprLetterParamEO> result = new ArrayList<>();
        List<RbApprLetterParam> dbResult = rbApprLetterParamMapper.selectByExample(example);
        for (RbApprLetterParam item : dbResult) {
            result.add(RbApprLetterParamValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbApprLetterParamEO findByPrimaryKey(String paraKey) {
        return RbApprLetterParamValueUtil.entityToEo(rbApprLetterParamMapper.selectByPrimaryKey(paraKey));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbApprLetterParamEO eo) {
        RbApprLetterParam row = RbApprLetterParamValueUtil.eoToEntity(eo);
        return rbApprLetterParamMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbApprLetterParamEO eo) {
        RbApprLetterParam row = RbApprLetterParamValueUtil.eoToEntity(eo);
        return rbApprLetterParamMapper.updateByPrimaryKey(row);
    }
}