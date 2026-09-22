package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbBranchProd;
import com.dcits.deposit.entity.MbBranchProdExample;
import com.dcits.deposit.facade.eo.MbBranchProdEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;

public final class MbBranchProdValueUtil {
    private MbBranchProdValueUtil() {
    }

    public static MbBranchProdEO entityToEo(MbBranchProd entity) {
        if (entity == null) {
            return null;
        }
        MbBranchProdEO eo = new MbBranchProdEO();
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setProdType(entity.getProdType());
        eo.setProdDesc(entity.getProdDesc());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static MbBranchProd eoToEntity(MbBranchProdEO eo) {
        if (eo == null) {
            return null;
        }
        MbBranchProd entity = new MbBranchProd();
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setProdType(eo.getProdType());
        entity.setProdDesc(eo.getProdDesc());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static MbBranchProdExample eoToEntityExample(MbBranchProdEO eo) {
        if (eo == null) {
            return null;
        }
        MbBranchProdExample example = new MbBranchProdExample();
        MbBranchProdExample.Criteria criteria = example.createCriteria();
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getProdDesc() != null) criteria.andProdDescEqualTo(eo.getProdDesc());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}