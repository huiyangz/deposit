package com.dcits.deposit.service.components;

import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbBusinessParameter;
import com.dcits.deposit.entity.RbBusinessParameterExample;
import com.dcits.deposit.facade.components.IRbBusinessParameterBcc;
import com.dcits.deposit.facade.eo.RbBusinessParameterEO;
import com.dcits.deposit.repo.RbBusinessParameterMapper;
import com.dcits.deposit.service.utils.RbBusinessParameterValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusinessParameterBasisCpnt implements IRbBusinessParameterBcc {
    @Autowired
    RbBusinessParameterMapper rbBusinessParameterMapper;

    @Override
    public long countByEo(RbBusinessParameterEO eo) {
        RbBusinessParameterExample example = RbBusinessParameterValueUtil.eoToEntityExample(eo);
        return rbBusinessParameterMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusinessParameterEO eo) {
        RbBusinessParameterExample example = RbBusinessParameterValueUtil.eoToEntityExample(eo);
        return rbBusinessParameterMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String paraKey) {
        return rbBusinessParameterMapper.deleteByPrimaryKey(paraKey);
    }

    @Override
    public int create(RbBusinessParameterEO eo) {
        RbBusinessParameter row = RbBusinessParameterValueUtil.eoToEntity(eo);
        return rbBusinessParameterMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusinessParameterEO eo) {
        RbBusinessParameter row = RbBusinessParameterValueUtil.eoToEntity(eo);
        return rbBusinessParameterMapper.insertSelective(row);
    }

    @Override
    public List<RbBusinessParameterEO> findByEo(RbBusinessParameterEO eo) {
        RbBusinessParameterExample example = RbBusinessParameterValueUtil.eoToEntityExample(eo);
        List<RbBusinessParameterEO> result = new ArrayList<>();
        List<RbBusinessParameter> dbResult = rbBusinessParameterMapper.selectByExample(example);
        for (RbBusinessParameter item : dbResult) {
            result.add(RbBusinessParameterValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusinessParameterEO findByPrimaryKey(String paraKey) {
        return RbBusinessParameterValueUtil.entityToEo(rbBusinessParameterMapper.selectByPrimaryKey(paraKey));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusinessParameterEO eo) {
        RbBusinessParameter row = RbBusinessParameterValueUtil.eoToEntity(eo);
        return rbBusinessParameterMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusinessParameterEO eo) {
        RbBusinessParameter row = RbBusinessParameterValueUtil.eoToEntity(eo);
        return rbBusinessParameterMapper.updateByPrimaryKey(row);
    }
}