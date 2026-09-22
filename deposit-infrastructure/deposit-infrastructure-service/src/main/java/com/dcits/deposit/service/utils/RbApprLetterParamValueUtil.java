package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbApprLetterParam;
import com.dcits.deposit.entity.RbApprLetterParamExample;
import com.dcits.deposit.facade.eo.RbApprLetterParamEO;
import com.dcits.deposit.enums.Company;

public final class RbApprLetterParamValueUtil {
    private RbApprLetterParamValueUtil() {
    }

    public static RbApprLetterParamEO entityToEo(RbApprLetterParam entity) {
        if (entity == null) {
            return null;
        }
        RbApprLetterParamEO eo = new RbApprLetterParamEO();
        eo.setParaKey(entity.getParaKey());
        eo.setParaDesc(entity.getParaDesc());
        eo.setParaValue(entity.getParaValue());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbApprLetterParam eoToEntity(RbApprLetterParamEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetterParam entity = new RbApprLetterParam();
        entity.setParaKey(eo.getParaKey());
        entity.setParaDesc(eo.getParaDesc());
        entity.setParaValue(eo.getParaValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbApprLetterParamExample eoToEntityExample(RbApprLetterParamEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetterParamExample example = new RbApprLetterParamExample();
        RbApprLetterParamExample.Criteria criteria = example.createCriteria();
        if (eo.getParaKey() != null) criteria.andParaKeyEqualTo(eo.getParaKey());
        if (eo.getParaDesc() != null) criteria.andParaDescEqualTo(eo.getParaDesc());
        if (eo.getParaValue() != null) criteria.andParaValueEqualTo(eo.getParaValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}