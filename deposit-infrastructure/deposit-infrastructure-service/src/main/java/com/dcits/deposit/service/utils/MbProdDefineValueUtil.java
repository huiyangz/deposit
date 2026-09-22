package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbProdDefine;
import com.dcits.deposit.entity.MbProdDefineExample;
import com.dcits.deposit.facade.eo.MbProdDefineEO;
import com.dcits.deposit.enums.EventDefault;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.Company;

public final class MbProdDefineValueUtil {
    private MbProdDefineValueUtil() {
    }

    public static MbProdDefineEO entityToEo(MbProdDefine entity) {
        if (entity == null) {
            return null;
        }
        MbProdDefineEO eo = new MbProdDefineEO();
        eo.setProdType(entity.getProdType());
        eo.setSeqNo(entity.getSeqNo());
        eo.setAssembleType(entity.getAssembleType());
        eo.setAssembleId(entity.getAssembleId());
        eo.setAttrKey(entity.getAttrKey());
        eo.setAttrValue(entity.getAttrValue());
        eo.setEventDefault(EventDefault.byValue(entity.getEventDefault()));
        eo.setStatus(Status.byValue(entity.getStatus()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static MbProdDefine eoToEntity(MbProdDefineEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdDefine entity = new MbProdDefine();
        entity.setProdType(eo.getProdType());
        entity.setSeqNo(eo.getSeqNo());
        entity.setAssembleType(eo.getAssembleType());
        entity.setAssembleId(eo.getAssembleId());
        entity.setAttrKey(eo.getAttrKey());
        entity.setAttrValue(eo.getAttrValue());
        entity.setEventDefault(eo.getEventDefault() == null ? null : eo.getEventDefault().getValue());
        entity.setStatus(eo.getStatus() == null ? null : eo.getStatus().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static MbProdDefineExample eoToEntityExample(MbProdDefineEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdDefineExample example = new MbProdDefineExample();
        MbProdDefineExample.Criteria criteria = example.createCriteria();
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getAssembleType() != null) criteria.andAssembleTypeEqualTo(eo.getAssembleType());
        if (eo.getAssembleId() != null) criteria.andAssembleIdEqualTo(eo.getAssembleId());
        if (eo.getAttrKey() != null) criteria.andAttrKeyEqualTo(eo.getAttrKey());
        if (eo.getAttrValue() != null) criteria.andAttrValueEqualTo(eo.getAttrValue());
        if (eo.getEventDefault() != null) criteria.andEventDefaultEqualTo(eo.getEventDefault().getValue());
        if (eo.getStatus() != null) criteria.andStatusEqualTo(eo.getStatus().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}