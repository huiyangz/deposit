package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusinessParameter;
import com.dcits.deposit.entity.RbBusinessParameterExample;
import com.dcits.deposit.facade.eo.RbBusinessParameterEO;

public final class RbBusinessParameterValueUtil {
    private RbBusinessParameterValueUtil() {
    }

    public static RbBusinessParameterEO entityToEo(RbBusinessParameter entity) {
        if (entity == null) {
            return null;
        }
        RbBusinessParameterEO eo = new RbBusinessParameterEO();
        eo.setParaKey(entity.getParaKey());
        eo.setParaValue(entity.getParaValue());
        eo.setParaDesc(entity.getParaDesc());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbBusinessParameter eoToEntity(RbBusinessParameterEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusinessParameter entity = new RbBusinessParameter();
        entity.setParaKey(eo.getParaKey());
        entity.setParaValue(eo.getParaValue());
        entity.setParaDesc(eo.getParaDesc());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbBusinessParameterExample eoToEntityExample(RbBusinessParameterEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusinessParameterExample example = new RbBusinessParameterExample();
        RbBusinessParameterExample.Criteria criteria = example.createCriteria();
        if (eo.getParaKey() != null) criteria.andParaKeyEqualTo(eo.getParaKey());
        if (eo.getParaValue() != null) criteria.andParaValueEqualTo(eo.getParaValue());
        if (eo.getParaDesc() != null) criteria.andParaDescEqualTo(eo.getParaDesc());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}