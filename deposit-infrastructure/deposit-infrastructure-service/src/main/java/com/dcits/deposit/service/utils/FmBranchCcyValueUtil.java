package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmBranchCcy;
import com.dcits.deposit.entity.FmBranchCcyExample;
import com.dcits.deposit.facade.eo.FmBranchCcyEO;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.Ccy;

public final class FmBranchCcyValueUtil {
    private FmBranchCcyValueUtil() {
    }

    public static FmBranchCcyEO entityToEo(FmBranchCcy entity) {
        if (entity == null) {
            return null;
        }
        FmBranchCcyEO eo = new FmBranchCcyEO();
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setBranch(TranBranch.byValue(entity.getBranch()));
        eo.setCcy(Ccy.byValue(entity.getCcy()));
        return eo;
    }

    public static FmBranchCcy eoToEntity(FmBranchCcyEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranchCcy entity = new FmBranchCcy();
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        return entity;
    }

    public static FmBranchCcyExample eoToEntityExample(FmBranchCcyEO eo) {
        if (eo == null) {
            return null;
        }
        FmBranchCcyExample example = new FmBranchCcyExample();
        FmBranchCcyExample.Criteria criteria = example.createCriteria();
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        return example;
    }
}