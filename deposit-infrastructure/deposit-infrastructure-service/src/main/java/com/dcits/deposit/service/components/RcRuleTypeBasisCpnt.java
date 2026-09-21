package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.LimitRef;
import com.dcits.deposit.enums.ResOperateFlag;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RcRuleType;
import com.dcits.deposit.entity.RcRuleTypeExample;
import com.dcits.deposit.facade.components.IRcRuleTypeBcc;
import com.dcits.deposit.facade.eo.RcRuleTypeEO;
import com.dcits.deposit.repo.RcRuleTypeMapper;
import com.dcits.deposit.service.utils.RcRuleTypeValueUtil;
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