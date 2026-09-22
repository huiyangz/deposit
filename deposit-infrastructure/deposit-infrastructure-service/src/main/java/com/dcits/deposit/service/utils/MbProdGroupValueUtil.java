package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbProdGroup;
import com.dcits.deposit.entity.MbProdGroupExample;
import com.dcits.deposit.facade.eo.MbProdGroupEO;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.Company;

public final class MbProdGroupValueUtil {
    private MbProdGroupValueUtil() {
    }

    public static MbProdGroupEO entityToEo(MbProdGroup entity) {
        if (entity == null) {
            return null;
        }
        MbProdGroupEO eo = new MbProdGroupEO();
        eo.setProdType(entity.getProdType());
        eo.setProdSubType(entity.getProdSubType());
        eo.setSeqNo(entity.getSeqNo());
        eo.setDefaultProdFlag(IndividualFlag.byValue(entity.getDefaultProdFlag()));
        eo.setAcctClass(AcctClass.byValue(entity.getAcctClass()));
        eo.setRatio(entity.getRatio());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static MbProdGroup eoToEntity(MbProdGroupEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdGroup entity = new MbProdGroup();
        entity.setProdType(eo.getProdType());
        entity.setProdSubType(eo.getProdSubType());
        entity.setSeqNo(eo.getSeqNo());
        entity.setDefaultProdFlag(eo.getDefaultProdFlag() == null ? null : eo.getDefaultProdFlag().getValue());
        entity.setAcctClass(eo.getAcctClass() == null ? null : eo.getAcctClass().getValue());
        entity.setRatio(eo.getRatio());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static MbProdGroupExample eoToEntityExample(MbProdGroupEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdGroupExample example = new MbProdGroupExample();
        MbProdGroupExample.Criteria criteria = example.createCriteria();
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getProdSubType() != null) criteria.andProdSubTypeEqualTo(eo.getProdSubType());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getDefaultProdFlag() != null) criteria.andDefaultProdFlagEqualTo(eo.getDefaultProdFlag().getValue());
        if (eo.getAcctClass() != null) criteria.andAcctClassEqualTo(eo.getAcctClass().getValue());
        if (eo.getRatio() != null) criteria.andRatioEqualTo(eo.getRatio());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}