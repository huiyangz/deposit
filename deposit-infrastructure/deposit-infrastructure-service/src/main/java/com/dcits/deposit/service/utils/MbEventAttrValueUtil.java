package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbEventAttr;
import com.dcits.deposit.entity.MbEventAttrExample;
import com.dcits.deposit.facade.eo.MbEventAttrEO;
import com.dcits.deposit.enums.Company;

public final class MbEventAttrValueUtil {
    private MbEventAttrValueUtil() {
    }

    public static MbEventAttrEO entityToEo(MbEventAttr entity) {
        if (entity == null) {
            return null;
        }
        MbEventAttrEO eo = new MbEventAttrEO();
        eo.setEventType(entity.getEventType());
        eo.setSeqNo(entity.getSeqNo());
        eo.setAssembleId(entity.getAssembleId());
        eo.setAssembleType(entity.getAssembleType());
        eo.setAssembleRule(entity.getAssembleRule());
        eo.setAttrValue(entity.getAttrValue());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static MbEventAttr eoToEntity(MbEventAttrEO eo) {
        if (eo == null) {
            return null;
        }
        MbEventAttr entity = new MbEventAttr();
        entity.setEventType(eo.getEventType());
        entity.setSeqNo(eo.getSeqNo());
        entity.setAssembleId(eo.getAssembleId());
        entity.setAssembleType(eo.getAssembleType());
        entity.setAssembleRule(eo.getAssembleRule());
        entity.setAttrValue(eo.getAttrValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static MbEventAttrExample eoToEntityExample(MbEventAttrEO eo) {
        if (eo == null) {
            return null;
        }
        MbEventAttrExample example = new MbEventAttrExample();
        MbEventAttrExample.Criteria criteria = example.createCriteria();
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getAssembleId() != null) criteria.andAssembleIdEqualTo(eo.getAssembleId());
        if (eo.getAssembleType() != null) criteria.andAssembleTypeEqualTo(eo.getAssembleType());
        if (eo.getAssembleRule() != null) criteria.andAssembleRuleEqualTo(eo.getAssembleRule());
        if (eo.getAttrValue() != null) criteria.andAttrValueEqualTo(eo.getAttrValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}