package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbClientRestraints;
import com.dcits.deposit.entity.RbClientRestraintsExample;
import com.dcits.deposit.facade.eo.RbClientRestraintsEO;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Company;

public final class RbClientRestraintsValueUtil {
    private RbClientRestraintsValueUtil() {
    }

    public static RbClientRestraintsEO entityToEo(RbClientRestraints entity) {
        if (entity == null) {
            return null;
        }
        RbClientRestraintsEO eo = new RbClientRestraintsEO();
        eo.setResSeqNo(entity.getResSeqNo());
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setClientNo(entity.getClientNo());
        eo.setStartDate(entity.getStartDate());
        eo.setTerm(entity.getTerm());
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setEndDate(entity.getEndDate());
        eo.setRestraintsStatus(RestraintsStatus.byValue(entity.getRestraintsStatus()));
        eo.setNarrative(entity.getNarrative());
        eo.setUserId(entity.getUserId());
        eo.setAuthUserId(entity.getAuthUserId());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setResPriority(entity.getResPriority());
        return eo;
    }

    public static RbClientRestraints eoToEntity(RbClientRestraintsEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientRestraints entity = new RbClientRestraints();
        entity.setResSeqNo(eo.getResSeqNo());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setStartDate(eo.getStartDate());
        entity.setTerm(eo.getTerm());
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setEndDate(eo.getEndDate());
        entity.setRestraintsStatus(eo.getRestraintsStatus() == null ? null : eo.getRestraintsStatus().getValue());
        entity.setNarrative(eo.getNarrative());
        entity.setUserId(eo.getUserId());
        entity.setAuthUserId(eo.getAuthUserId());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setResPriority(eo.getResPriority());
        return entity;
    }

    public static RbClientRestraintsExample eoToEntityExample(RbClientRestraintsEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientRestraintsExample example = new RbClientRestraintsExample();
        RbClientRestraintsExample.Criteria criteria = example.createCriteria();
        if (eo.getResSeqNo() != null) criteria.andResSeqNoEqualTo(eo.getResSeqNo());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getRestraintsStatus() != null) criteria.andRestraintsStatusEqualTo(eo.getRestraintsStatus().getValue());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getAuthUserId() != null) criteria.andAuthUserIdEqualTo(eo.getAuthUserId());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getResPriority() != null) criteria.andResPriorityEqualTo(eo.getResPriority());
        return example;
    }
}