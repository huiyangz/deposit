package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbPassword;
import com.dcits.deposit.entity.RbPasswordExample;
import com.dcits.deposit.facade.eo.RbPasswordEO;
import com.dcits.deposit.enums.PwdType;
import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.Company;

public final class RbPasswordValueUtil {
    private RbPasswordValueUtil() {
    }

    public static RbPasswordEO entityToEo(RbPassword entity) {
        if (entity == null) {
            return null;
        }
        RbPasswordEO eo = new RbPasswordEO();
        eo.setPwdKey(entity.getPwdKey());
        eo.setPwdType(PwdType.byValue(entity.getPwdType()));
        eo.setClientNo(entity.getClientNo());
        eo.setPassword(entity.getPassword());
        eo.setPasswordEffectDate(entity.getPasswordEffectDate());
        eo.setPasswordStatus(PasswordStatus.byValue(entity.getPasswordStatus()));
        eo.setChangeInd(entity.getChangeInd());
        eo.setFailureTimes(entity.getFailureTimes());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setPrevFailureTimes(entity.getPrevFailureTimes());
        eo.setDayFailureTimes(entity.getDayFailureTimes());
        eo.setDacValue(entity.getDacValue());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbPassword eoToEntity(RbPasswordEO eo) {
        if (eo == null) {
            return null;
        }
        RbPassword entity = new RbPassword();
        entity.setPwdKey(eo.getPwdKey());
        entity.setPwdType(eo.getPwdType() == null ? null : eo.getPwdType().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setPassword(eo.getPassword());
        entity.setPasswordEffectDate(eo.getPasswordEffectDate());
        entity.setPasswordStatus(eo.getPasswordStatus() == null ? null : eo.getPasswordStatus().getValue());
        entity.setChangeInd(eo.getChangeInd());
        entity.setFailureTimes(eo.getFailureTimes());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setPrevFailureTimes(eo.getPrevFailureTimes());
        entity.setDayFailureTimes(eo.getDayFailureTimes());
        entity.setDacValue(eo.getDacValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbPasswordExample eoToEntityExample(RbPasswordEO eo) {
        if (eo == null) {
            return null;
        }
        RbPasswordExample example = new RbPasswordExample();
        RbPasswordExample.Criteria criteria = example.createCriteria();
        if (eo.getPwdKey() != null) criteria.andPwdKeyEqualTo(eo.getPwdKey());
        if (eo.getPwdType() != null) criteria.andPwdTypeEqualTo(eo.getPwdType().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getPassword() != null) criteria.andPasswordEqualTo(eo.getPassword());
        if (eo.getPasswordEffectDate() != null) criteria.andPasswordEffectDateEqualTo(eo.getPasswordEffectDate());
        if (eo.getPasswordStatus() != null) criteria.andPasswordStatusEqualTo(eo.getPasswordStatus().getValue());
        if (eo.getChangeInd() != null) criteria.andChangeIndEqualTo(eo.getChangeInd());
        if (eo.getFailureTimes() != null) criteria.andFailureTimesEqualTo(eo.getFailureTimes());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getPrevFailureTimes() != null) criteria.andPrevFailureTimesEqualTo(eo.getPrevFailureTimes());
        if (eo.getDayFailureTimes() != null) criteria.andDayFailureTimesEqualTo(eo.getDayFailureTimes());
        if (eo.getDacValue() != null) criteria.andDacValueEqualTo(eo.getDacValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}