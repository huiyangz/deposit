package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbTaeAccountCheckSum;
import com.dcits.deposit.entity.RbTaeAccountCheckSumExample;
import com.dcits.deposit.facade.components.IRbTaeAccountCheckSumBcc;
import com.dcits.deposit.facade.eo.RbTaeAccountCheckSumEO;
import com.dcits.deposit.repo.RbTaeAccountCheckSumMapper;
import com.dcits.deposit.service.utils.RbTaeAccountCheckSumValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbTaeAccountCheckSumBasisCpnt implements IRbTaeAccountCheckSumBcc {
    @Autowired
    RbTaeAccountCheckSumMapper rbTaeAccountCheckSumMapper;

    @Override
    public long countByEo(RbTaeAccountCheckSumEO eo) {
        RbTaeAccountCheckSumExample example = RbTaeAccountCheckSumValueUtil.eoToEntityExample(eo);
        return rbTaeAccountCheckSumMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbTaeAccountCheckSumEO eo) {
        RbTaeAccountCheckSumExample example = RbTaeAccountCheckSumValueUtil.eoToEntityExample(eo);
        return rbTaeAccountCheckSumMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String sessionId) {
        return rbTaeAccountCheckSumMapper.deleteByPrimaryKey(sessionId);
    }

    @Override
    public int create(RbTaeAccountCheckSumEO eo) {
        RbTaeAccountCheckSum row = RbTaeAccountCheckSumValueUtil.eoToEntity(eo);
        return rbTaeAccountCheckSumMapper.insert(row);
    }

    @Override
    public int createSelective(RbTaeAccountCheckSumEO eo) {
        RbTaeAccountCheckSum row = RbTaeAccountCheckSumValueUtil.eoToEntity(eo);
        return rbTaeAccountCheckSumMapper.insertSelective(row);
    }

    @Override
    public List<RbTaeAccountCheckSumEO> findByEo(RbTaeAccountCheckSumEO eo) {
        RbTaeAccountCheckSumExample example = RbTaeAccountCheckSumValueUtil.eoToEntityExample(eo);
        List<RbTaeAccountCheckSumEO> result = new ArrayList<>();
        List<RbTaeAccountCheckSum> dbResult = rbTaeAccountCheckSumMapper.selectByExample(example);
        for (RbTaeAccountCheckSum item : dbResult) {
            result.add(RbTaeAccountCheckSumValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbTaeAccountCheckSumEO findByPrimaryKey(String sessionId) {
        return RbTaeAccountCheckSumValueUtil.entityToEo(rbTaeAccountCheckSumMapper.selectByPrimaryKey(sessionId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbTaeAccountCheckSumEO eo) {
        RbTaeAccountCheckSum row = RbTaeAccountCheckSumValueUtil.eoToEntity(eo);
        return rbTaeAccountCheckSumMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbTaeAccountCheckSumEO eo) {
        RbTaeAccountCheckSum row = RbTaeAccountCheckSumValueUtil.eoToEntity(eo);
        return rbTaeAccountCheckSumMapper.updateByPrimaryKey(row);
    }
}