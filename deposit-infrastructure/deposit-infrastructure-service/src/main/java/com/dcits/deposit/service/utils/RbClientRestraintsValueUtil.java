package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbClientRestraints;
import com.dcits.deposit.entity.RbClientRestraintsExample;
import com.dcits.deposit.facade.eo.RbClientRestraintsEO;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;

public final class RbClientRestraintsValueUtil {
    private RbClientRestraintsValueUtil() {
    }

    public static RbClientRestraintsEO entityToEo(RbClientRestraints entity) {
        if (entity == null) {
            return null;
        }
        RbClientRestraintsEO eo = new RbClientRestraintsEO();
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setNarrative(entity.getNarrative());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setStartDate(entity.getStartDate());
        eo.setTranBranch(TranBranch.byValue(entity.getTranBranch()));
        eo.setResPriority(entity.getResPriority());
        eo.setRestraintsStatus(RestraintsStatus.byValue(entity.getRestraintsStatus()));
        eo.setEndDate(entity.getEndDate());
        eo.setResSeqNo(entity.getResSeqNo());
        eo.setUserId(entity.getUserId());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setAuthUserId(entity.getAuthUserId());
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setTerm(entity.getTerm());
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setClientNo(entity.getClientNo());
        eo.setTranDate(entity.getTranDate());
        return eo;
    }

    public static RbClientRestraints eoToEntity(RbClientRestraintsEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientRestraints entity = new RbClientRestraints();
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setNarrative(eo.getNarrative());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setStartDate(eo.getStartDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setResPriority(eo.getResPriority());
        entity.setRestraintsStatus(eo.getRestraintsStatus() == null ? null : eo.getRestraintsStatus().getValue());
        entity.setEndDate(eo.getEndDate());
        entity.setResSeqNo(eo.getResSeqNo());
        entity.setUserId(eo.getUserId());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setAuthUserId(eo.getAuthUserId());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setTerm(eo.getTerm());
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setTranDate(eo.getTranDate());
        return entity;
    }

    public static RbClientRestraintsExample eoToEntityExample(RbClientRestraintsEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientRestraintsExample example = new RbClientRestraintsExample();
        RbClientRestraintsExample.Criteria criteria = example.createCriteria();
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getResPriority() != null) criteria.andResPriorityEqualTo(eo.getResPriority());
        if (eo.getRestraintsStatus() != null) criteria.andRestraintsStatusEqualTo(eo.getRestraintsStatus().getValue());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getResSeqNo() != null) criteria.andResSeqNoEqualTo(eo.getResSeqNo());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getAuthUserId() != null) criteria.andAuthUserIdEqualTo(eo.getAuthUserId());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        return example;
    }
}