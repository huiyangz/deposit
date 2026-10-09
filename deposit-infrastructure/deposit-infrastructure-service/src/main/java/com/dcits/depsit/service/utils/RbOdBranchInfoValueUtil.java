package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbOdBranchInfo;
import com.dcits.depsit.entity.RbOdBranchInfoExample;
import com.dcits.depsit.facade.eo.RbOdBranchInfoEO;
import com.dcits.depsit.enums.TranBranch;

public final class RbOdBranchInfoValueUtil {
    private RbOdBranchInfoValueUtil() {
    }

    public static RbOdBranchInfoEO entityToEo(RbOdBranchInfo entity) {
        if (entity == null) {
            return null;
        }
        RbOdBranchInfoEO eo = new RbOdBranchInfoEO();
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setUsedAmt(entity.getUsedAmt());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setBranch(TranBranch.byValue(entity.getBranch()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(entity.getCompany());
        eo.setTotalLimit(entity.getTotalLimit());
        return eo;
    }

    public static RbOdBranchInfo eoToEntity(RbOdBranchInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbOdBranchInfo entity = new RbOdBranchInfo();
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setUsedAmt(eo.getUsedAmt());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany());
        entity.setTotalLimit(eo.getTotalLimit());
        return entity;
    }

    public static RbOdBranchInfoExample eoToEntityExample(RbOdBranchInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbOdBranchInfoExample example = new RbOdBranchInfoExample();
        RbOdBranchInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getUsedAmt() != null) criteria.andUsedAmtEqualTo(eo.getUsedAmt());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany());
        if (eo.getTotalLimit() != null) criteria.andTotalLimitEqualTo(eo.getTotalLimit());
        return example;
    }
}