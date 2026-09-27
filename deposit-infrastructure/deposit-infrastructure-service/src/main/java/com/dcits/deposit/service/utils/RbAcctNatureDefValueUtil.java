package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctNatureDef;
import com.dcits.deposit.entity.RbAcctNatureDefExample;
import com.dcits.deposit.facade.eo.RbAcctNatureDefEO;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.NatureClass;

public final class RbAcctNatureDefValueUtil {
    private RbAcctNatureDefValueUtil() {
    }

    public static RbAcctNatureDefEO entityToEo(RbAcctNatureDef entity) {
        if (entity == null) {
            return null;
        }
        RbAcctNatureDefEO eo = new RbAcctNatureDefEO();
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setAcctNatureDesc(entity.getAcctNatureDesc());
        eo.setAcctNatureNo(AcctNatureNo.byValue(entity.getAcctNatureNo()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setNatureClass(NatureClass.byValue(entity.getNatureClass()));
        return eo;
    }

    public static RbAcctNatureDef eoToEntity(RbAcctNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctNatureDef entity = new RbAcctNatureDef();
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setAcctNatureDesc(eo.getAcctNatureDesc());
        entity.setAcctNatureNo(eo.getAcctNatureNo() == null ? null : eo.getAcctNatureNo().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setNatureClass(eo.getNatureClass() == null ? null : eo.getNatureClass().getValue());
        return entity;
    }

    public static RbAcctNatureDefExample eoToEntityExample(RbAcctNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctNatureDefExample example = new RbAcctNatureDefExample();
        RbAcctNatureDefExample.Criteria criteria = example.createCriteria();
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getAcctNatureDesc() != null) criteria.andAcctNatureDescEqualTo(eo.getAcctNatureDesc());
        if (eo.getAcctNatureNo() != null) criteria.andAcctNatureNoEqualTo(eo.getAcctNatureNo().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getNatureClass() != null) criteria.andNatureClassEqualTo(eo.getNatureClass().getValue());
        return example;
    }
}