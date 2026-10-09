package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.FloatType;
import com.dcits.depsit.enums.IntCalcBal;
import com.dcits.depsit.enums.IntChangeType;
import com.dcits.depsit.enums.IntClass;
import com.dcits.depsit.enums.IntType;
import com.dcits.depsit.enums.MonthBasisType;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.YearBasisType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RbBusAcctIntDetail;
import com.dcits.depsit.entity.RbBusAcctIntDetailExample;
import com.dcits.depsit.facade.components.IRbBusAcctIntDetailBcc;
import com.dcits.depsit.facade.eo.RbBusAcctIntDetailEO;
import com.dcits.depsit.repo.RbBusAcctIntDetailMapper;
import com.dcits.depsit.service.utils.RbBusAcctIntDetailValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbBusAcctIntDetailBasisCpnt implements IRbBusAcctIntDetailBcc {
    @Autowired
    RbBusAcctIntDetailMapper rbBusAcctIntDetailMapper;

    @Override
    public long countByEo(RbBusAcctIntDetailEO eo) {
        RbBusAcctIntDetailExample example = RbBusAcctIntDetailValueUtil.eoToEntityExample(eo);
        return rbBusAcctIntDetailMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbBusAcctIntDetailEO eo) {
        RbBusAcctIntDetailExample example = RbBusAcctIntDetailValueUtil.eoToEntityExample(eo);
        return rbBusAcctIntDetailMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(Integer internalKey, String intClass) {
        return rbBusAcctIntDetailMapper.deleteByPrimaryKey(internalKey, intClass);
    }

    @Override
    public int create(RbBusAcctIntDetailEO eo) {
        RbBusAcctIntDetail row = RbBusAcctIntDetailValueUtil.eoToEntity(eo);
        return rbBusAcctIntDetailMapper.insert(row);
    }

    @Override
    public int createSelective(RbBusAcctIntDetailEO eo) {
        RbBusAcctIntDetail row = RbBusAcctIntDetailValueUtil.eoToEntity(eo);
        return rbBusAcctIntDetailMapper.insertSelective(row);
    }

    @Override
    public List<RbBusAcctIntDetailEO> findByEo(RbBusAcctIntDetailEO eo) {
        RbBusAcctIntDetailExample example = RbBusAcctIntDetailValueUtil.eoToEntityExample(eo);
        List<RbBusAcctIntDetailEO> result = new ArrayList<>();
        List<RbBusAcctIntDetail> dbResult = rbBusAcctIntDetailMapper.selectByExample(example);
        for (RbBusAcctIntDetail item : dbResult) {
            result.add(RbBusAcctIntDetailValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbBusAcctIntDetailEO findByPrimaryKey(Integer internalKey, String intClass) {
        return RbBusAcctIntDetailValueUtil.entityToEo(rbBusAcctIntDetailMapper.selectByPrimaryKey(internalKey, intClass));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbBusAcctIntDetailEO eo) {
        RbBusAcctIntDetail row = RbBusAcctIntDetailValueUtil.eoToEntity(eo);
        return rbBusAcctIntDetailMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbBusAcctIntDetailEO eo) {
        RbBusAcctIntDetail row = RbBusAcctIntDetailValueUtil.eoToEntity(eo);
        return rbBusAcctIntDetailMapper.updateByPrimaryKey(row);
    }
}