package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbSignType;
import com.dcits.deposit.entity.RbSignTypeExample;
import com.dcits.deposit.facade.eo.RbSignTypeEO;
import com.dcits.deposit.enums.SignType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;

public final class RbSignTypeValueUtil {
    private RbSignTypeValueUtil() {
    }

    public static RbSignTypeEO entityToEo(RbSignType entity) {
        if (entity == null) {
            return null;
        }
        RbSignTypeEO eo = new RbSignTypeEO();
        eo.setSignType(SignType.byValue(entity.getSignType()));
        eo.setSignTypeDesc(entity.getSignTypeDesc());
        eo.setAgreementCloseAcctFlag(IndividualFlag.byValue(entity.getAgreementCloseAcctFlag()));
        eo.setExcludeType(entity.getExcludeType());
        eo.setRepackFlag(IndividualFlag.byValue(entity.getRepackFlag()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbSignType eoToEntity(RbSignTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbSignType entity = new RbSignType();
        entity.setSignType(eo.getSignType() == null ? null : eo.getSignType().getValue());
        entity.setSignTypeDesc(eo.getSignTypeDesc());
        entity.setAgreementCloseAcctFlag(eo.getAgreementCloseAcctFlag() == null ? null : eo.getAgreementCloseAcctFlag().getValue());
        entity.setExcludeType(eo.getExcludeType());
        entity.setRepackFlag(eo.getRepackFlag() == null ? null : eo.getRepackFlag().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbSignTypeExample eoToEntityExample(RbSignTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbSignTypeExample example = new RbSignTypeExample();
        RbSignTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getSignType() != null) criteria.andSignTypeEqualTo(eo.getSignType().getValue());
        if (eo.getSignTypeDesc() != null) criteria.andSignTypeDescEqualTo(eo.getSignTypeDesc());
        if (eo.getAgreementCloseAcctFlag() != null) criteria.andAgreementCloseAcctFlagEqualTo(eo.getAgreementCloseAcctFlag().getValue());
        if (eo.getExcludeType() != null) criteria.andExcludeTypeEqualTo(eo.getExcludeType());
        if (eo.getRepackFlag() != null) criteria.andRepackFlagEqualTo(eo.getRepackFlag().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}