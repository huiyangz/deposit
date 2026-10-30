package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusClientAcct;
import com.dcits.deposit.entity.RbBusClientAcctExample;
import com.dcits.deposit.facade.eo.RbBusClientAcctEO;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.WithdrawalType;

public final class RbBusClientAcctValueUtil {
    private RbBusClientAcctValueUtil() {
    }

    public static RbBusClientAcctEO entityToEo(RbBusClientAcct entity) {
        if (entity == null) {
            return null;
        }
        RbBusClientAcctEO eo = new RbBusClientAcctEO();
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setIsCorpSettleCard(entity.getIsCorpSettleCard());
        eo.setClientNo(entity.getClientNo());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setAcctDomain(entity.getAcctDomain());
        eo.setAcctOpenDate(entity.getAcctOpenDate());
        eo.setCloseBranch(TranBranch.byValue(entity.getCloseBranch()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setClientAcctStatus(entity.getClientAcctStatus());
        eo.setAcctBranch(TranBranch.byValue(entity.getAcctBranch()));
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setClientVoucherStatus(entity.getClientVoucherStatus());
        eo.setClientType(ClientType.byValue(entity.getClientType()));
        eo.setDocClass(DocClass.byValue(entity.getDocClass()));
        eo.setCardPbUnionFlag(entity.getCardPbUnionFlag());
        eo.setWithdrawalType(WithdrawalType.byValue(entity.getWithdrawalType()));
        return eo;
    }

    public static RbBusClientAcct eoToEntity(RbBusClientAcctEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusClientAcct entity = new RbBusClientAcct();
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setIsCorpSettleCard(eo.getIsCorpSettleCard());
        entity.setClientNo(eo.getClientNo());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setAcctDomain(eo.getAcctDomain());
        entity.setAcctOpenDate(eo.getAcctOpenDate());
        entity.setCloseBranch(eo.getCloseBranch() == null ? null : eo.getCloseBranch().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setClientAcctStatus(eo.getClientAcctStatus());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setClientVoucherStatus(eo.getClientVoucherStatus());
        entity.setClientType(eo.getClientType() == null ? null : eo.getClientType().getValue());
        entity.setDocClass(eo.getDocClass() == null ? null : eo.getDocClass().getValue());
        entity.setCardPbUnionFlag(eo.getCardPbUnionFlag());
        entity.setWithdrawalType(eo.getWithdrawalType() == null ? null : eo.getWithdrawalType().getValue());
        return entity;
    }

    public static RbBusClientAcctExample eoToEntityExample(RbBusClientAcctEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusClientAcctExample example = new RbBusClientAcctExample();
        RbBusClientAcctExample.Criteria criteria = example.createCriteria();
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getIsCorpSettleCard() != null) criteria.andIsCorpSettleCardEqualTo(eo.getIsCorpSettleCard());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getAcctDomain() != null) criteria.andAcctDomainEqualTo(eo.getAcctDomain());
        if (eo.getAcctOpenDate() != null) criteria.andAcctOpenDateEqualTo(eo.getAcctOpenDate());
        if (eo.getCloseBranch() != null) criteria.andCloseBranchEqualTo(eo.getCloseBranch().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getClientAcctStatus() != null) criteria.andClientAcctStatusEqualTo(eo.getClientAcctStatus());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getClientVoucherStatus() != null) criteria.andClientVoucherStatusEqualTo(eo.getClientVoucherStatus());
        if (eo.getClientType() != null) criteria.andClientTypeEqualTo(eo.getClientType().getValue());
        if (eo.getDocClass() != null) criteria.andDocClassEqualTo(eo.getDocClass().getValue());
        if (eo.getCardPbUnionFlag() != null) criteria.andCardPbUnionFlagEqualTo(eo.getCardPbUnionFlag());
        if (eo.getWithdrawalType() != null) criteria.andWithdrawalTypeEqualTo(eo.getWithdrawalType().getValue());
        return example;
    }
}