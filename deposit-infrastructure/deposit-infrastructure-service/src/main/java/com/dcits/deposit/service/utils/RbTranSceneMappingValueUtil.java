package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbTranSceneMapping;
import com.dcits.deposit.entity.RbTranSceneMappingExample;
import com.dcits.deposit.facade.eo.RbTranSceneMappingEO;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.Company;

public final class RbTranSceneMappingValueUtil {
    private RbTranSceneMappingValueUtil() {
    }

    public static RbTranSceneMappingEO entityToEo(RbTranSceneMapping entity) {
        if (entity == null) {
            return null;
        }
        RbTranSceneMappingEO eo = new RbTranSceneMappingEO();
        eo.setAttrValue(entity.getAttrValue());
        eo.setKeyValue(entity.getKeyValue());
        eo.setSceneClass(entity.getSceneClass());
        eo.setAttrType(entity.getAttrType());
        eo.setStatus(Status.byValue(entity.getStatus()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranScene(entity.getTranScene());
        eo.setTranSceneDesc(entity.getTranSceneDesc());
        return eo;
    }

    public static RbTranSceneMapping eoToEntity(RbTranSceneMappingEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranSceneMapping entity = new RbTranSceneMapping();
        entity.setAttrValue(eo.getAttrValue());
        entity.setKeyValue(eo.getKeyValue());
        entity.setSceneClass(eo.getSceneClass());
        entity.setAttrType(eo.getAttrType());
        entity.setStatus(eo.getStatus() == null ? null : eo.getStatus().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranScene(eo.getTranScene());
        entity.setTranSceneDesc(eo.getTranSceneDesc());
        return entity;
    }

    public static RbTranSceneMappingExample eoToEntityExample(RbTranSceneMappingEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranSceneMappingExample example = new RbTranSceneMappingExample();
        RbTranSceneMappingExample.Criteria criteria = example.createCriteria();
        if (eo.getAttrValue() != null) criteria.andAttrValueEqualTo(eo.getAttrValue());
        if (eo.getKeyValue() != null) criteria.andKeyValueEqualTo(eo.getKeyValue());
        if (eo.getSceneClass() != null) criteria.andSceneClassEqualTo(eo.getSceneClass());
        if (eo.getAttrType() != null) criteria.andAttrTypeEqualTo(eo.getAttrType());
        if (eo.getStatus() != null) criteria.andStatusEqualTo(eo.getStatus().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranScene() != null) criteria.andTranSceneEqualTo(eo.getTranScene());
        if (eo.getTranSceneDesc() != null) criteria.andTranSceneDescEqualTo(eo.getTranSceneDesc());
        return example;
    }
}