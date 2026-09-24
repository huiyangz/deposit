package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctNatureRestraints;
import com.dcits.deposit.entity.RbAcctNatureRestraintsExample;
import com.dcits.deposit.facade.eo.RbAcctNatureRestraintsEO;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.AcctNatureNo;

public final class RbAcctNatureRestraintsValueUtil {
    private RbAcctNatureRestraintsValueUtil() {
    }

    public static RbAcctNatureRestraintsEO entityToEo(RbAcctNatureRestraints entity) {
        if (entity == null) {
            return null;
        }
        RbAcctNatureRestraintsEO eo = new RbAcctNatureRestraintsEO();
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setAcctNatureNo(AcctNatureNo.byValue(entity.getAcctNatureNo()));
        eo.setTerm(entity.getTerm());
        return eo;
    }

    public static RbAcctNatureRestraints eoToEntity(RbAcctNatureRestraintsEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctNatureRestraints entity = new RbAcctNatureRestraints();
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setAcctNatureNo(eo.getAcctNatureNo() == null ? null : eo.getAcctNatureNo().getValue());
        entity.setTerm(eo.getTerm());
        return entity;
    }

    public static RbAcctNatureRestraintsExample eoToEntityExample(RbAcctNatureRestraintsEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctNatureRestraintsExample example = new RbAcctNatureRestraintsExample();
        RbAcctNatureRestraintsExample.Criteria criteria = example.createCriteria();
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getAcctNatureNo() != null) criteria.andAcctNatureNoEqualTo(eo.getAcctNatureNo().getValue());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        return example;
    }
}