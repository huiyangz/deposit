package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAutoTranInfo;
import com.dcits.deposit.entity.RbAutoTranInfoExample;
import com.dcits.deposit.facade.eo.RbAutoTranInfoEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;

public final class RbAutoTranInfoValueUtil {
    private RbAutoTranInfoValueUtil() {
    }

    public static RbAutoTranInfoEO entityToEo(RbAutoTranInfo entity) {
        if (entity == null) {
            return null;
        }
        RbAutoTranInfoEO eo = new RbAutoTranInfoEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setInternalKey(entity.getInternalKey());
        eo.setClientNo(entity.getClientNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setPrincipalAmt(entity.getPrincipalAmt());
        eo.setRegisterDate(entity.getRegisterDate());
        eo.setMaturityDate(entity.getMaturityDate());
        eo.setFundFromAcctNo(entity.getFundFromAcctNo());
        eo.setFundFromName(entity.getFundFromName());
        eo.setFundFromBankNo(entity.getFundFromBankNo());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbAutoTranInfo eoToEntity(RbAutoTranInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbAutoTranInfo entity = new RbAutoTranInfo();
        entity.setSeqNo(eo.getSeqNo());
        entity.setInternalKey(eo.getInternalKey());
        entity.setClientNo(eo.getClientNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setPrincipalAmt(eo.getPrincipalAmt());
        entity.setRegisterDate(eo.getRegisterDate());
        entity.setMaturityDate(eo.getMaturityDate());
        entity.setFundFromAcctNo(eo.getFundFromAcctNo());
        entity.setFundFromName(eo.getFundFromName());
        entity.setFundFromBankNo(eo.getFundFromBankNo());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbAutoTranInfoExample eoToEntityExample(RbAutoTranInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbAutoTranInfoExample example = new RbAutoTranInfoExample();
        RbAutoTranInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getPrincipalAmt() != null) criteria.andPrincipalAmtEqualTo(eo.getPrincipalAmt());
        if (eo.getRegisterDate() != null) criteria.andRegisterDateEqualTo(eo.getRegisterDate());
        if (eo.getMaturityDate() != null) criteria.andMaturityDateEqualTo(eo.getMaturityDate());
        if (eo.getFundFromAcctNo() != null) criteria.andFundFromAcctNoEqualTo(eo.getFundFromAcctNo());
        if (eo.getFundFromName() != null) criteria.andFundFromNameEqualTo(eo.getFundFromName());
        if (eo.getFundFromBankNo() != null) criteria.andFundFromBankNoEqualTo(eo.getFundFromBankNo());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}