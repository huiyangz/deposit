package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbClientAcct;
import com.dcits.deposit.entity.RbClientAcctExample;
import com.dcits.deposit.facade.eo.RbClientAcctEO;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.WithdrawalType;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;

public final class RbClientAcctValueUtil {
    private RbClientAcctValueUtil() {
    }

    public static RbClientAcctEO entityToEo(RbClientAcct entity) {
        if (entity == null) {
            return null;
        }
        RbClientAcctEO eo = new RbClientAcctEO();
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setClientNo(entity.getClientNo());
        eo.setCustInternalKey(entity.getCustInternalKey());
        eo.setClientType(ClientType.byValue(entity.getClientType()));
        eo.setAcctDomain(entity.getAcctDomain());
        eo.setIsCorpSettleCard(IndividualFlag.byValue(entity.getIsCorpSettleCard()));
        eo.setCardPbUnionFlag(IndividualFlag.byValue(entity.getCardPbUnionFlag()));
        eo.setDocClass(DocClass.byValue(entity.getDocClass()));
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setClientVoucherStatus(entity.getClientVoucherStatus());
        eo.setWithdrawalType(WithdrawalType.byValue(entity.getWithdrawalType()));
        eo.setClientAcctStatus(entity.getClientAcctStatus());
        eo.setAcctOpenDate(entity.getAcctOpenDate());
        eo.setAcctBranch(AcctBranch.byValue(entity.getAcctBranch()));
        eo.setCloseBranch(AcctBranch.byValue(entity.getCloseBranch()));
        eo.setCreateDate(entity.getCreateDate());
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setCreateUserId(entity.getCreateUserId());
        eo.setUpdateUserId(entity.getUpdateUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbClientAcct eoToEntity(RbClientAcctEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientAcct entity = new RbClientAcct();
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setClientNo(eo.getClientNo());
        entity.setCustInternalKey(eo.getCustInternalKey());
        entity.setClientType(eo.getClientType() == null ? null : eo.getClientType().getValue());
        entity.setAcctDomain(eo.getAcctDomain());
        entity.setIsCorpSettleCard(eo.getIsCorpSettleCard() == null ? null : eo.getIsCorpSettleCard().getValue());
        entity.setCardPbUnionFlag(eo.getCardPbUnionFlag() == null ? null : eo.getCardPbUnionFlag().getValue());
        entity.setDocClass(eo.getDocClass() == null ? null : eo.getDocClass().getValue());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setClientVoucherStatus(eo.getClientVoucherStatus());
        entity.setWithdrawalType(eo.getWithdrawalType() == null ? null : eo.getWithdrawalType().getValue());
        entity.setClientAcctStatus(eo.getClientAcctStatus());
        entity.setAcctOpenDate(eo.getAcctOpenDate());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setCloseBranch(eo.getCloseBranch() == null ? null : eo.getCloseBranch().getValue());
        entity.setCreateDate(eo.getCreateDate());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setCreateUserId(eo.getCreateUserId());
        entity.setUpdateUserId(eo.getUpdateUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbClientAcctExample eoToEntityExample(RbClientAcctEO eo) {
        if (eo == null) {
            return null;
        }
        RbClientAcctExample example = new RbClientAcctExample();
        RbClientAcctExample.Criteria criteria = example.createCriteria();
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getCustInternalKey() != null) criteria.andCustInternalKeyEqualTo(eo.getCustInternalKey());
        if (eo.getClientType() != null) criteria.andClientTypeEqualTo(eo.getClientType().getValue());
        if (eo.getAcctDomain() != null) criteria.andAcctDomainEqualTo(eo.getAcctDomain());
        if (eo.getIsCorpSettleCard() != null) criteria.andIsCorpSettleCardEqualTo(eo.getIsCorpSettleCard().getValue());
        if (eo.getCardPbUnionFlag() != null) criteria.andCardPbUnionFlagEqualTo(eo.getCardPbUnionFlag().getValue());
        if (eo.getDocClass() != null) criteria.andDocClassEqualTo(eo.getDocClass().getValue());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getClientVoucherStatus() != null) criteria.andClientVoucherStatusEqualTo(eo.getClientVoucherStatus());
        if (eo.getWithdrawalType() != null) criteria.andWithdrawalTypeEqualTo(eo.getWithdrawalType().getValue());
        if (eo.getClientAcctStatus() != null) criteria.andClientAcctStatusEqualTo(eo.getClientAcctStatus());
        if (eo.getAcctOpenDate() != null) criteria.andAcctOpenDateEqualTo(eo.getAcctOpenDate());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getCloseBranch() != null) criteria.andCloseBranchEqualTo(eo.getCloseBranch().getValue());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getCreateUserId() != null) criteria.andCreateUserIdEqualTo(eo.getCreateUserId());
        if (eo.getUpdateUserId() != null) criteria.andUpdateUserIdEqualTo(eo.getUpdateUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}