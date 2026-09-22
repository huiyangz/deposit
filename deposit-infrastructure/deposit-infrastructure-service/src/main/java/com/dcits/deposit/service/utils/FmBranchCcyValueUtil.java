package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmBranchCcy;
import com.dcits.deposit.entity.FmBranchCcyExample;
import com.dcits.deposit.facade.eo.FmBranchCcyEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class FmBranchCcyValueUtil {
    private FmBranchCcyValueUtil() {
    }

    public static FmBranchCcyEO entityToEo(FmBranchCcy entity) {
        if (entity == null) {
            return null;
        }
        FmBranchCcyEO eo = new FmBranchCcyEO();
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static FmBranchCcy eoToEntity(FmBranchCcyEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranchCcy entity = new FmBranchCcy();
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static FmBranchCcyExample eoToEntityExample(FmBranchCcyEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranchCcyExample example = new FmBranchCcyExample();
        FmBranchCcyExample.Criteria criteria = example.createCriteria();
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}