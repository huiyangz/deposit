package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbOdWhiteLimitInfo;
import com.dcits.depsit.entity.RbOdWhiteLimitInfoExample;
import com.dcits.depsit.facade.eo.RbOdWhiteLimitInfoEO;

public final class RbOdWhiteLimitInfoValueUtil {
    private RbOdWhiteLimitInfoValueUtil() {
    }

    public static RbOdWhiteLimitInfoEO entityToEo(RbOdWhiteLimitInfo entity) {
        if (entity == null) {
            return null;
        }
        RbOdWhiteLimitInfoEO eo = new RbOdWhiteLimitInfoEO();
        eo.setOdPtAmt(entity.getOdPtAmt());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(entity.getCompany());
        eo.setSameObjectPdOdCumulative(entity.getSameObjectPdOdCumulative());
        eo.setVbsflag(entity.getVbsflag());
        eo.setIsCrossFlag(entity.getIsCrossFlag());
        return eo;
    }

    public static RbOdWhiteLimitInfo eoToEntity(RbOdWhiteLimitInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbOdWhiteLimitInfo entity = new RbOdWhiteLimitInfo();
        entity.setOdPtAmt(eo.getOdPtAmt());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany());
        entity.setSameObjectPdOdCumulative(eo.getSameObjectPdOdCumulative());
        entity.setVbsflag(eo.getVbsflag());
        entity.setIsCrossFlag(eo.getIsCrossFlag());
        return entity;
    }

    public static RbOdWhiteLimitInfoExample eoToEntityExample(RbOdWhiteLimitInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbOdWhiteLimitInfoExample example = new RbOdWhiteLimitInfoExample();
        RbOdWhiteLimitInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getOdPtAmt() != null) criteria.andOdPtAmtEqualTo(eo.getOdPtAmt());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany());
        if (eo.getSameObjectPdOdCumulative() != null) criteria.andSameObjectPdOdCumulativeEqualTo(eo.getSameObjectPdOdCumulative());
        if (eo.getVbsflag() != null) criteria.andVbsflagEqualTo(eo.getVbsflag());
        if (eo.getIsCrossFlag() != null) criteria.andIsCrossFlagEqualTo(eo.getIsCrossFlag());
        return example;
    }
}