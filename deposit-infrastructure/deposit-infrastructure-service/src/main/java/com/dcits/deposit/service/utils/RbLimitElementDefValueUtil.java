package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitElementDef;
import com.dcits.deposit.entity.RbLimitElementDefExample;
import com.dcits.deposit.facade.eo.RbLimitElementDefEO;
import com.dcits.deposit.enums.Company;

public final class RbLimitElementDefValueUtil {
    private RbLimitElementDefValueUtil() {
    }

    public static RbLimitElementDefEO entityToEo(RbLimitElementDef entity) {
        if (entity == null) {
            return null;
        }
        RbLimitElementDefEO eo = new RbLimitElementDefEO();
        eo.setElementId(entity.getElementId());
        eo.setElementDesc(entity.getElementDesc());
        eo.setElementClass(entity.getElementClass());
        eo.setAttrType(entity.getAttrType());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbLimitElementDef eoToEntity(RbLimitElementDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitElementDef entity = new RbLimitElementDef();
        entity.setElementId(eo.getElementId());
        entity.setElementDesc(eo.getElementDesc());
        entity.setElementClass(eo.getElementClass());
        entity.setAttrType(eo.getAttrType());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbLimitElementDefExample eoToEntityExample(RbLimitElementDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitElementDefExample example = new RbLimitElementDefExample();
        RbLimitElementDefExample.Criteria criteria = example.createCriteria();
        if (eo.getElementId() != null) criteria.andElementIdEqualTo(eo.getElementId());
        if (eo.getElementDesc() != null) criteria.andElementDescEqualTo(eo.getElementDesc());
        if (eo.getElementClass() != null) criteria.andElementClassEqualTo(eo.getElementClass());
        if (eo.getAttrType() != null) criteria.andAttrTypeEqualTo(eo.getAttrType());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}