package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitRuleRelation;
import com.dcits.deposit.entity.RbLimitRuleRelationExample;
import com.dcits.deposit.facade.eo.RbLimitRuleRelationEO;
import com.dcits.deposit.enums.Company;

public final class RbLimitRuleRelationValueUtil {
    private RbLimitRuleRelationValueUtil() {
    }

    public static RbLimitRuleRelationEO entityToEo(RbLimitRuleRelation entity) {
        if (entity == null) {
            return null;
        }
        RbLimitRuleRelationEO eo = new RbLimitRuleRelationEO();
        eo.setRuleId(entity.getRuleId());
        eo.setRuleDesc(entity.getRuleDesc());
        eo.setLimitSceneNo(entity.getLimitSceneNo());
        eo.setRuleRelationExpr(entity.getRuleRelationExpr());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbLimitRuleRelation eoToEntity(RbLimitRuleRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitRuleRelation entity = new RbLimitRuleRelation();
        entity.setRuleId(eo.getRuleId());
        entity.setRuleDesc(eo.getRuleDesc());
        entity.setLimitSceneNo(eo.getLimitSceneNo());
        entity.setRuleRelationExpr(eo.getRuleRelationExpr());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbLimitRuleRelationExample eoToEntityExample(RbLimitRuleRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitRuleRelationExample example = new RbLimitRuleRelationExample();
        RbLimitRuleRelationExample.Criteria criteria = example.createCriteria();
        if (eo.getRuleId() != null) criteria.andRuleIdEqualTo(eo.getRuleId());
        if (eo.getRuleDesc() != null) criteria.andRuleDescEqualTo(eo.getRuleDesc());
        if (eo.getLimitSceneNo() != null) criteria.andLimitSceneNoEqualTo(eo.getLimitSceneNo());
        if (eo.getRuleRelationExpr() != null) criteria.andRuleRelationExprEqualTo(eo.getRuleRelationExpr());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}