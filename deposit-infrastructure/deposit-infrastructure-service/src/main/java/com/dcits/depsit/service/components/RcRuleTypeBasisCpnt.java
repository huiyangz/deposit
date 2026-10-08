package com.dcits.depsit.service.components;

import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.LimitRef;
import com.dcits.depsit.enums.OthControlType;
import com.dcits.depsit.enums.ResBranchRange;
import com.dcits.depsit.enums.ResOperateFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.TermType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.depsit.entity.RcRuleType;
import com.dcits.depsit.entity.RcRuleTypeExample;
import com.dcits.depsit.facade.components.IRcRuleTypeBcc;
import com.dcits.depsit.facade.eo.RcRuleTypeEO;
import com.dcits.depsit.repo.RcRuleTypeMapper;
import com.dcits.depsit.service.utils.RcRuleTypeValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RcRuleTypeBasisCpnt implements IRcRuleTypeBcc {
    @Autowired
    RcRuleTypeMapper rcRuleTypeMapper;

    @Override
    public long countByEo(RcRuleTypeEO eo) {
        RcRuleTypeExample example = RcRuleTypeValueUtil.eoToEntityExample(eo);
        return rcRuleTypeMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RcRuleTypeEO eo) {
        RcRuleTypeExample example = RcRuleTypeValueUtil.eoToEntityExample(eo);
        return rcRuleTypeMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String ruleId) {
        return rcRuleTypeMapper.deleteByPrimaryKey(ruleId);
    }

    @Override
    public int create(RcRuleTypeEO eo) {
        RcRuleType row = RcRuleTypeValueUtil.eoToEntity(eo);
        return rcRuleTypeMapper.insert(row);
    }

    @Override
    public int createSelective(RcRuleTypeEO eo) {
        RcRuleType row = RcRuleTypeValueUtil.eoToEntity(eo);
        return rcRuleTypeMapper.insertSelective(row);
    }

    @Override
    public List<RcRuleTypeEO> findByEo(RcRuleTypeEO eo) {
        RcRuleTypeExample example = RcRuleTypeValueUtil.eoToEntityExample(eo);
        List<RcRuleTypeEO> result = new ArrayList<>();
        List<RcRuleType> dbResult = rcRuleTypeMapper.selectByExample(example);
        for (RcRuleType item : dbResult) {
            result.add(RcRuleTypeValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RcRuleTypeEO findByPrimaryKey(String ruleId) {
        return RcRuleTypeValueUtil.entityToEo(rcRuleTypeMapper.selectByPrimaryKey(ruleId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RcRuleTypeEO eo) {
        RcRuleType row = RcRuleTypeValueUtil.eoToEntity(eo);
        return rcRuleTypeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RcRuleTypeEO eo) {
        RcRuleType row = RcRuleTypeValueUtil.eoToEntity(eo);
        return rcRuleTypeMapper.updateByPrimaryKey(row);
    }
}