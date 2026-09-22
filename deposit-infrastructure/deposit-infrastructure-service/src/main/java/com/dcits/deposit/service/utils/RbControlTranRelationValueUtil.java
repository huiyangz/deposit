package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbControlTranRelation;
import com.dcits.deposit.entity.RbControlTranRelationExample;
import com.dcits.deposit.facade.eo.RbControlTranRelationEO;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;

public final class RbControlTranRelationValueUtil {
    private RbControlTranRelationValueUtil() {
    }

    public static RbControlTranRelationEO entityToEo(RbControlTranRelation entity) {
        if (entity == null) {
            return null;
        }
        RbControlTranRelationEO eo = new RbControlTranRelationEO();
        eo.setControlClass(ControlClass.byValue(entity.getControlClass()));
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setServiceNo(entity.getServiceNo());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setEffectFlag(IndividualFlag.byValue(entity.getEffectFlag()));
        return eo;
    }

    public static RbControlTranRelation eoToEntity(RbControlTranRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbControlTranRelation entity = new RbControlTranRelation();
        entity.setControlClass(eo.getControlClass() == null ? null : eo.getControlClass().getValue());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setServiceNo(eo.getServiceNo());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setEffectFlag(eo.getEffectFlag() == null ? null : eo.getEffectFlag().getValue());
        return entity;
    }

    public static RbControlTranRelationExample eoToEntityExample(RbControlTranRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbControlTranRelationExample example = new RbControlTranRelationExample();
        RbControlTranRelationExample.Criteria criteria = example.createCriteria();
        if (eo.getControlClass() != null) criteria.andControlClassEqualTo(eo.getControlClass().getValue());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getServiceNo() != null) criteria.andServiceNoEqualTo(eo.getServiceNo());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getEffectFlag() != null) criteria.andEffectFlagEqualTo(eo.getEffectFlag().getValue());
        return example;
    }
}