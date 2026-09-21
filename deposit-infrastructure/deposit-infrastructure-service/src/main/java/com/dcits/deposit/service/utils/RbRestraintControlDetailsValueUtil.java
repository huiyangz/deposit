package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbRestraintControlDetails;
import com.dcits.deposit.entity.RbRestraintControlDetailsExample;
import com.dcits.deposit.facade.eo.RbRestraintControlDetailsEO;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.Company;

public final class RbRestraintControlDetailsValueUtil {
    private RbRestraintControlDetailsValueUtil() {
    }

    public static RbRestraintControlDetailsEO entityToEo(RbRestraintControlDetails entity) {
        if (entity == null) {
            return null;
        }
        RbRestraintControlDetailsEO eo = new RbRestraintControlDetailsEO();
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setProdType(entity.getProdType());
        eo.setChannelMuster(entity.getChannelMuster());
        eo.setTranTypeLink(entity.getTranTypeLink());
        eo.setNarrativeCode(entity.getNarrativeCode());
        eo.setBatchFlag(entity.getBatchFlag());
        eo.setResBranchRange(LimitBranchRange.byValue(entity.getResBranchRange()));
        eo.setCounterFlag(IndividualFlag.byValue(entity.getCounterFlag()));
        eo.setExpression(entity.getExpression());
        eo.setStatus(Status.byValue(entity.getStatus()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static RbRestraintControlDetails eoToEntity(RbRestraintControlDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintControlDetails entity = new RbRestraintControlDetails();
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setProdType(eo.getProdType());
        entity.setChannelMuster(eo.getChannelMuster());
        entity.setTranTypeLink(eo.getTranTypeLink());
        entity.setNarrativeCode(eo.getNarrativeCode());
        entity.setBatchFlag(eo.getBatchFlag());
        entity.setResBranchRange(eo.getResBranchRange() == null ? null : eo.getResBranchRange().getValue());
        entity.setCounterFlag(eo.getCounterFlag() == null ? null : eo.getCounterFlag().getValue());
        entity.setExpression(eo.getExpression());
        entity.setStatus(eo.getStatus() == null ? null : eo.getStatus().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static RbRestraintControlDetailsExample eoToEntityExample(RbRestraintControlDetailsEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintControlDetailsExample example = new RbRestraintControlDetailsExample();
        RbRestraintControlDetailsExample.Criteria criteria = example.createCriteria();
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getChannelMuster() != null) criteria.andChannelMusterEqualTo(eo.getChannelMuster());
        if (eo.getTranTypeLink() != null) criteria.andTranTypeLinkEqualTo(eo.getTranTypeLink());
        if (eo.getNarrativeCode() != null) criteria.andNarrativeCodeEqualTo(eo.getNarrativeCode());
        if (eo.getBatchFlag() != null) criteria.andBatchFlagEqualTo(eo.getBatchFlag());
        if (eo.getResBranchRange() != null) criteria.andResBranchRangeEqualTo(eo.getResBranchRange().getValue());
        if (eo.getCounterFlag() != null) criteria.andCounterFlagEqualTo(eo.getCounterFlag().getValue());
        if (eo.getExpression() != null) criteria.andExpressionEqualTo(eo.getExpression());
        if (eo.getStatus() != null) criteria.andStatusEqualTo(eo.getStatus().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}