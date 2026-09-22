package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbIntBasis;
import com.dcits.deposit.entity.MbIntBasisExample;
import com.dcits.deposit.facade.eo.MbIntBasisEO;
import com.dcits.deposit.enums.IntBasis;
import com.dcits.deposit.enums.Company;

public final class MbIntBasisValueUtil {
    private MbIntBasisValueUtil() {
    }

    public static MbIntBasisEO entityToEo(MbIntBasis entity) {
        if (entity == null) {
            return null;
        }
        MbIntBasisEO eo = new MbIntBasisEO();
        eo.setIntBasis(IntBasis.byValue(entity.getIntBasis()));
        eo.setIntBasisDesc(entity.getIntBasisDesc());
        eo.setClientNo(entity.getClientNo());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static MbIntBasis eoToEntity(MbIntBasisEO eo) {
        if (eo == null) {
            return null;
        }
        MbIntBasis entity = new MbIntBasis();
        entity.setIntBasis(eo.getIntBasis() == null ? null : eo.getIntBasis().getValue());
        entity.setIntBasisDesc(eo.getIntBasisDesc());
        entity.setClientNo(eo.getClientNo());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static MbIntBasisExample eoToEntityExample(MbIntBasisEO eo) {
        if (eo == null) {
            return null;
        }
        MbIntBasisExample example = new MbIntBasisExample();
        MbIntBasisExample.Criteria criteria = example.createCriteria();
        if (eo.getIntBasis() != null) criteria.andIntBasisEqualTo(eo.getIntBasis().getValue());
        if (eo.getIntBasisDesc() != null) criteria.andIntBasisDescEqualTo(eo.getIntBasisDesc());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}