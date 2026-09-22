package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.ClAcctNatureDef;
import com.dcits.deposit.entity.ClAcctNatureDefExample;
import com.dcits.deposit.facade.eo.ClAcctNatureDefEO;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.NatureClass;
import com.dcits.deposit.enums.Company;

public final class ClAcctNatureDefValueUtil {
    private ClAcctNatureDefValueUtil() {
    }

    public static ClAcctNatureDefEO entityToEo(ClAcctNatureDef entity) {
        if (entity == null) {
            return null;
        }
        ClAcctNatureDefEO eo = new ClAcctNatureDefEO();
        eo.setAcctNature(AcctNature.byValue(entity.getAcctNature()));
        eo.setAcctNatureDesc(entity.getAcctNatureDesc());
        eo.setNatureClass(NatureClass.byValue(entity.getNatureClass()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setDescription(entity.getDescription());
        return eo;
    }

    public static ClAcctNatureDef eoToEntity(ClAcctNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        ClAcctNatureDef entity = new ClAcctNatureDef();
        entity.setAcctNature(eo.getAcctNature() == null ? null : eo.getAcctNature().getValue());
        entity.setAcctNatureDesc(eo.getAcctNatureDesc());
        entity.setNatureClass(eo.getNatureClass() == null ? null : eo.getNatureClass().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setDescription(eo.getDescription());
        return entity;
    }

    public static ClAcctNatureDefExample eoToEntityExample(ClAcctNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        ClAcctNatureDefExample example = new ClAcctNatureDefExample();
        ClAcctNatureDefExample.Criteria criteria = example.createCriteria();
        if (eo.getAcctNature() != null) criteria.andAcctNatureEqualTo(eo.getAcctNature().getValue());
        if (eo.getAcctNatureDesc() != null) criteria.andAcctNatureDescEqualTo(eo.getAcctNatureDesc());
        if (eo.getNatureClass() != null) criteria.andNatureClassEqualTo(eo.getNatureClass().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getDescription() != null) criteria.andDescriptionEqualTo(eo.getDescription());
        return example;
    }
}