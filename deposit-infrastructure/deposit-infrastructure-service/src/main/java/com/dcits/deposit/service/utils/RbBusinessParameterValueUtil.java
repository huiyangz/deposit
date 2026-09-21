package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusinessParameter;
import com.dcits.deposit.entity.RbBusinessParameterExample;
import com.dcits.deposit.facade.eo.RbBusinessParameterEO;
import com.dcits.deposit.enums.Company;

public final class RbBusinessParameterValueUtil {
    private RbBusinessParameterValueUtil() {
    }

    public static RbBusinessParameterEO entityToEo(RbBusinessParameter entity) {
        if (entity == null) {
            return null;
        }
        RbBusinessParameterEO eo = new RbBusinessParameterEO();
        eo.setParaKey(entity.getParaKey());
        eo.setParaDesc(entity.getParaDesc());
        eo.setParaValue(entity.getParaValue());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbBusinessParameter eoToEntity(RbBusinessParameterEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusinessParameter entity = new RbBusinessParameter();
        entity.setParaKey(eo.getParaKey());
        entity.setParaDesc(eo.getParaDesc());
        entity.setParaValue(eo.getParaValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbBusinessParameterExample eoToEntityExample(RbBusinessParameterEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusinessParameterExample example = new RbBusinessParameterExample();
        RbBusinessParameterExample.Criteria criteria = example.createCriteria();
        if (eo.getParaKey() != null) criteria.andParaKeyEqualTo(eo.getParaKey());
        if (eo.getParaDesc() != null) criteria.andParaDescEqualTo(eo.getParaDesc());
        if (eo.getParaValue() != null) criteria.andParaValueEqualTo(eo.getParaValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}