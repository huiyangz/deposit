package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusPassword;
import com.dcits.deposit.entity.RbBusPasswordExample;
import com.dcits.deposit.facade.eo.RbBusPasswordEO;
import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.PwdType;

public final class RbBusPasswordValueUtil {
    private RbBusPasswordValueUtil() {
    }

    public static RbBusPasswordEO entityToEo(RbBusPassword entity) {
        if (entity == null) {
            return null;
        }
        RbBusPasswordEO eo = new RbBusPasswordEO();
        eo.setPrevFailureTimes(entity.getPrevFailureTimes());
        eo.setInternalKey(entity.getInternalKey());
        eo.setPassword(entity.getPassword());
        eo.setChangeInd(entity.getChangeInd());
        eo.setPasswordStatus(PasswordStatus.byValue(entity.getPasswordStatus()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setPasswordEffectDate(entity.getPasswordEffectDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setDayFailureTimes(entity.getDayFailureTimes());
        eo.setFailureTimes(entity.getFailureTimes());
        eo.setPwdType(PwdType.byValue(entity.getPwdType()));
        eo.setPwdKey(entity.getPwdKey());
        return eo;
    }

    public static RbBusPassword eoToEntity(RbBusPasswordEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusPassword entity = new RbBusPassword();
        entity.setPrevFailureTimes(eo.getPrevFailureTimes());
        entity.setInternalKey(eo.getInternalKey());
        entity.setPassword(eo.getPassword());
        entity.setChangeInd(eo.getChangeInd());
        entity.setPasswordStatus(eo.getPasswordStatus() == null ? null : eo.getPasswordStatus().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setPasswordEffectDate(eo.getPasswordEffectDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setDayFailureTimes(eo.getDayFailureTimes());
        entity.setFailureTimes(eo.getFailureTimes());
        entity.setPwdType(eo.getPwdType() == null ? null : eo.getPwdType().getValue());
        entity.setPwdKey(eo.getPwdKey());
        return entity;
    }

    public static RbBusPasswordExample eoToEntityExample(RbBusPasswordEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusPasswordExample example = new RbBusPasswordExample();
        RbBusPasswordExample.Criteria criteria = example.createCriteria();
        if (eo.getPrevFailureTimes() != null) criteria.andPrevFailureTimesEqualTo(eo.getPrevFailureTimes());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getPassword() != null) criteria.andPasswordEqualTo(eo.getPassword());
        if (eo.getChangeInd() != null) criteria.andChangeIndEqualTo(eo.getChangeInd());
        if (eo.getPasswordStatus() != null) criteria.andPasswordStatusEqualTo(eo.getPasswordStatus().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getPasswordEffectDate() != null) criteria.andPasswordEffectDateEqualTo(eo.getPasswordEffectDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getDayFailureTimes() != null) criteria.andDayFailureTimesEqualTo(eo.getDayFailureTimes());
        if (eo.getFailureTimes() != null) criteria.andFailureTimesEqualTo(eo.getFailureTimes());
        if (eo.getPwdType() != null) criteria.andPwdTypeEqualTo(eo.getPwdType().getValue());
        if (eo.getPwdKey() != null) criteria.andPwdKeyEqualTo(eo.getPwdKey());
        return example;
    }
}