package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLoanFundInfo;
import com.dcits.deposit.entity.RbLoanFundInfoExample;
import com.dcits.deposit.facade.eo.RbLoanFundInfoEO;
import com.dcits.deposit.enums.Company;

public final class RbLoanFundInfoValueUtil {
    private RbLoanFundInfoValueUtil() {
    }

    public static RbLoanFundInfoEO entityToEo(RbLoanFundInfo entity) {
        if (entity == null) {
            return null;
        }
        RbLoanFundInfoEO eo = new RbLoanFundInfoEO();
        eo.setInternalKey(entity.getInternalKey());
        eo.setClientNo(entity.getClientNo());
        eo.setLoanLendersAmt(entity.getLoanLendersAmt());
        eo.setLoanLendersNotUseAmt(entity.getLoanLendersNotUseAmt());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbLoanFundInfo eoToEntity(RbLoanFundInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLoanFundInfo entity = new RbLoanFundInfo();
        entity.setInternalKey(eo.getInternalKey());
        entity.setClientNo(eo.getClientNo());
        entity.setLoanLendersAmt(eo.getLoanLendersAmt());
        entity.setLoanLendersNotUseAmt(eo.getLoanLendersNotUseAmt());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbLoanFundInfoExample eoToEntityExample(RbLoanFundInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLoanFundInfoExample example = new RbLoanFundInfoExample();
        RbLoanFundInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getLoanLendersAmt() != null) criteria.andLoanLendersAmtEqualTo(eo.getLoanLendersAmt());
        if (eo.getLoanLendersNotUseAmt() != null) criteria.andLoanLendersNotUseAmtEqualTo(eo.getLoanLendersNotUseAmt());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}