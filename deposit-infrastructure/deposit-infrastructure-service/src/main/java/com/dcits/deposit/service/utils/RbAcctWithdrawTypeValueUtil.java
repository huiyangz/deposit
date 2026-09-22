package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctWithdrawType;
import com.dcits.deposit.entity.RbAcctWithdrawTypeExample;
import com.dcits.deposit.facade.eo.RbAcctWithdrawTypeEO;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.WithdrawalType;
import com.dcits.deposit.enums.Company;

public final class RbAcctWithdrawTypeValueUtil {
    private RbAcctWithdrawTypeValueUtil() {
    }

    public static RbAcctWithdrawTypeEO entityToEo(RbAcctWithdrawType entity) {
        if (entity == null) {
            return null;
        }
        RbAcctWithdrawTypeEO eo = new RbAcctWithdrawTypeEO();
        eo.setWithdrawKey(entity.getWithdrawKey());
        eo.setChannel(SourceType.byValue(entity.getChannel()));
        eo.setWithdrawalType(WithdrawalType.byValue(entity.getWithdrawalType()));
        eo.setClientNo(entity.getClientNo());
        eo.setDacValue(entity.getDacValue());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbAcctWithdrawType eoToEntity(RbAcctWithdrawTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctWithdrawType entity = new RbAcctWithdrawType();
        entity.setWithdrawKey(eo.getWithdrawKey());
        entity.setChannel(eo.getChannel() == null ? null : eo.getChannel().getValue());
        entity.setWithdrawalType(eo.getWithdrawalType() == null ? null : eo.getWithdrawalType().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setDacValue(eo.getDacValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbAcctWithdrawTypeExample eoToEntityExample(RbAcctWithdrawTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctWithdrawTypeExample example = new RbAcctWithdrawTypeExample();
        RbAcctWithdrawTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getWithdrawKey() != null) criteria.andWithdrawKeyEqualTo(eo.getWithdrawKey());
        if (eo.getChannel() != null) criteria.andChannelEqualTo(eo.getChannel().getValue());
        if (eo.getWithdrawalType() != null) criteria.andWithdrawalTypeEqualTo(eo.getWithdrawalType().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getDacValue() != null) criteria.andDacValueEqualTo(eo.getDacValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}