package com.dcits.deposit.service.components;

import com.dcits.deposit.enums.Company;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dcits.deposit.entity.RbLimitRuleRelation;
import com.dcits.deposit.entity.RbLimitRuleRelationExample;
import com.dcits.deposit.facade.components.IRbLimitRuleRelationBcc;
import com.dcits.deposit.facade.eo.RbLimitRuleRelationEO;
import com.dcits.deposit.repo.RbLimitRuleRelationMapper;
import com.dcits.deposit.service.utils.RbLimitRuleRelationValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RbLimitRuleRelationBasisCpnt implements IRbLimitRuleRelationBcc {
    @Autowired
    RbLimitRuleRelationMapper rbLimitRuleRelationMapper;

    @Override
    public long countByEo(RbLimitRuleRelationEO eo) {
        RbLimitRuleRelationExample example = RbLimitRuleRelationValueUtil.eoToEntityExample(eo);
        return rbLimitRuleRelationMapper.countByExample(example);
    }

    @Override
    public int removeByEo(RbLimitRuleRelationEO eo) {
        RbLimitRuleRelationExample example = RbLimitRuleRelationValueUtil.eoToEntityExample(eo);
        return rbLimitRuleRelationMapper.deleteByExample(example);
    }

    @Override
    public int removeByPrimaryKey(String ruleId) {
        return rbLimitRuleRelationMapper.deleteByPrimaryKey(ruleId);
    }

    @Override
    public int create(RbLimitRuleRelationEO eo) {
        RbLimitRuleRelation row = RbLimitRuleRelationValueUtil.eoToEntity(eo);
        return rbLimitRuleRelationMapper.insert(row);
    }

    @Override
    public int createSelective(RbLimitRuleRelationEO eo) {
        RbLimitRuleRelation row = RbLimitRuleRelationValueUtil.eoToEntity(eo);
        return rbLimitRuleRelationMapper.insertSelective(row);
    }

    @Override
    public List<RbLimitRuleRelationEO> findByEo(RbLimitRuleRelationEO eo) {
        RbLimitRuleRelationExample example = RbLimitRuleRelationValueUtil.eoToEntityExample(eo);
        List<RbLimitRuleRelationEO> result = new ArrayList<>();
        List<RbLimitRuleRelation> dbResult = rbLimitRuleRelationMapper.selectByExample(example);
        for (RbLimitRuleRelation item : dbResult) {
            result.add(RbLimitRuleRelationValueUtil.entityToEo(item));
        }
        return result;
    }

    @Override
    public RbLimitRuleRelationEO findByPrimaryKey(String ruleId) {
        return RbLimitRuleRelationValueUtil.entityToEo(rbLimitRuleRelationMapper.selectByPrimaryKey(ruleId));
    }

    @Override
    public int modifyByPrimaryKeySelective(RbLimitRuleRelationEO eo) {
        RbLimitRuleRelation row = RbLimitRuleRelationValueUtil.eoToEntity(eo);
        return rbLimitRuleRelationMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int modifyByPrimaryKey(RbLimitRuleRelationEO eo) {
        RbLimitRuleRelation row = RbLimitRuleRelationValueUtil.eoToEntity(eo);
        return rbLimitRuleRelationMapper.updateByPrimaryKey(row);
    }
}