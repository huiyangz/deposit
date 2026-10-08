package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbRestraintControlDetails;
import com.dcits.depsit.entity.RbRestraintControlDetailsExample;
import com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.enums.ResBranchRange;
import com.dcits.depsit.enums.RestraintType;

public final class RbRestraintControlDetailsValueUtil {
    private RbRestraintControlDetailsValueUtil() {
    }

    public static RbRestraintControlDetailsEO entityToEo(RbRestraintControlDetails entity) {
        if (entity == null) {
            return null;
        }
        RbRestraintControlDetailsEO eo = new RbRestraintControlDetailsEO();
        eo.setChannelMuster(entity.getChannelMuster());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setProdNo(entity.getProdNo());
        eo.setNarrativeCode(entity.getNarrativeCode());
        eo.setExpression(entity.getExpression());
        eo.setStatus(Status.byValue(entity.getStatus()));
        eo.setResBranchRange(ResBranchRange.byValue(entity.getResBranchRange()));
        eo.setTranTypeLink(entity.getTranTypeLink());
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setBatchFlag(entity.getBatchFlag());
        eo.setCounterFlag(entity.getCounterFlag());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        return eo;
    }

    public static RbRestraintControlDetails eoToEntity(RbRestraintControlDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintControlDetails entity = new RbRestraintControlDetails();
        entity.setChannelMuster(eo.getChannelMuster());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setProdNo(eo.getProdNo());
        entity.setNarrativeCode(eo.getNarrativeCode());
        entity.setExpression(eo.getExpression());
        entity.setStatus(eo.getStatus() == null ? null : eo.getStatus().getValue());
        entity.setResBranchRange(eo.getResBranchRange() == null ? null : eo.getResBranchRange().getValue());
        entity.setTranTypeLink(eo.getTranTypeLink());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setBatchFlag(eo.getBatchFlag());
        entity.setCounterFlag(eo.getCounterFlag());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        return entity;
    }

    public static RbRestraintControlDetailsExample eoToEntityExample(RbRestraintControlDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintControlDetailsExample example = new RbRestraintControlDetailsExample();
        RbRestraintControlDetailsExample.Criteria criteria = example.createCriteria();
        if (eo.getChannelMuster() != null) criteria.andChannelMusterEqualTo(eo.getChannelMuster());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getNarrativeCode() != null) criteria.andNarrativeCodeEqualTo(eo.getNarrativeCode());
        if (eo.getExpression() != null) criteria.andExpressionEqualTo(eo.getExpression());
        if (eo.getStatus() != null) criteria.andStatusEqualTo(eo.getStatus().getValue());
        if (eo.getResBranchRange() != null) criteria.andResBranchRangeEqualTo(eo.getResBranchRange().getValue());
        if (eo.getTranTypeLink() != null) criteria.andTranTypeLinkEqualTo(eo.getTranTypeLink());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getBatchFlag() != null) criteria.andBatchFlagEqualTo(eo.getBatchFlag());
        if (eo.getCounterFlag() != null) criteria.andCounterFlagEqualTo(eo.getCounterFlag());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        return example;
    }
}