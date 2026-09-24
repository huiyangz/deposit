package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbCommissionRegister;
import com.dcits.deposit.entity.RbCommissionRegisterExample;
import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.CommissionFlag;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;

public final class RbCommissionRegisterValueUtil {
    private RbCommissionRegisterValueUtil() {
    }

    public static RbCommissionRegisterEO entityToEo(RbCommissionRegister entity) {
        if (entity == null) {
            return null;
        }
        RbCommissionRegisterEO eo = new RbCommissionRegisterEO();
        eo.setCommissionClientNo(entity.getCommissionClientNo());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setProdNo(entity.getProdNo());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setCommissionRelation(CommissionRelation.byValue(entity.getCommissionRelation()));
        eo.setInternalKey(entity.getInternalKey());
        eo.setAcctName(entity.getAcctName());
        eo.setTranDate(entity.getTranDate());
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setReference(entity.getReference());
        eo.setProgramId(entity.getProgramId());
        eo.setCommissionDocumentType(DocumentType.byValue(entity.getCommissionDocumentType()));
        eo.setCommissionConfirmUserIdKey2(entity.getCommissionConfirmUserIdKey2());
        eo.setEventType(entity.getEventType());
        eo.setCommissionClientName(entity.getCommissionClientName());
        eo.setCommissionReason(entity.getCommissionReason());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setTranAmt(entity.getTranAmt());
        eo.setCommissionFlag(CommissionFlag.byValue(entity.getCommissionFlag()));
        eo.setCommissionExpireDate(entity.getCommissionExpireDate());
        eo.setCommissionStartDate(entity.getCommissionStartDate());
        eo.setClientNo(entity.getClientNo());
        eo.setCommissionConfirmTime(entity.getCommissionConfirmTime());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setCountry(IssCountry.byValue(entity.getCountry()));
        eo.setIsCommission(entity.getIsCommission());
        eo.setPrefix(entity.getPrefix());
        eo.setCommissionConfirmResult(entity.getCommissionConfirmResult());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setTranBranch(TranBranch.byValue(entity.getTranBranch()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setCommissionDocumentId(entity.getCommissionDocumentId());
        eo.setCommissionClientTel(entity.getCommissionClientTel());
        eo.setCommissionConfirmTel(entity.getCommissionConfirmTel());
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setCommissionConfirmUserIdKey1(entity.getCommissionConfirmUserIdKey1());
        return eo;
    }

    public static RbCommissionRegister eoToEntity(RbCommissionRegisterEO eo) {
        if (eo == null) {
            return null;
        }
        RbCommissionRegister entity = new RbCommissionRegister();
        entity.setCommissionClientNo(eo.getCommissionClientNo());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setProdNo(eo.getProdNo());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setCommissionRelation(eo.getCommissionRelation() == null ? null : eo.getCommissionRelation().getValue());
        entity.setInternalKey(eo.getInternalKey());
        entity.setAcctName(eo.getAcctName());
        entity.setTranDate(eo.getTranDate());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setReference(eo.getReference());
        entity.setProgramId(eo.getProgramId());
        entity.setCommissionDocumentType(eo.getCommissionDocumentType() == null ? null : eo.getCommissionDocumentType().getValue());
        entity.setCommissionConfirmUserIdKey2(eo.getCommissionConfirmUserIdKey2());
        entity.setEventType(eo.getEventType());
        entity.setCommissionClientName(eo.getCommissionClientName());
        entity.setCommissionReason(eo.getCommissionReason());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setTranAmt(eo.getTranAmt());
        entity.setCommissionFlag(eo.getCommissionFlag() == null ? null : eo.getCommissionFlag().getValue());
        entity.setCommissionExpireDate(eo.getCommissionExpireDate());
        entity.setCommissionStartDate(eo.getCommissionStartDate());
        entity.setClientNo(eo.getClientNo());
        entity.setCommissionConfirmTime(eo.getCommissionConfirmTime());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setCountry(eo.getCountry() == null ? null : eo.getCountry().getValue());
        entity.setIsCommission(eo.getIsCommission());
        entity.setPrefix(eo.getPrefix());
        entity.setCommissionConfirmResult(eo.getCommissionConfirmResult());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setCommissionDocumentId(eo.getCommissionDocumentId());
        entity.setCommissionClientTel(eo.getCommissionClientTel());
        entity.setCommissionConfirmTel(eo.getCommissionConfirmTel());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setCommissionConfirmUserIdKey1(eo.getCommissionConfirmUserIdKey1());
        return entity;
    }

    public static RbCommissionRegisterExample eoToEntityExample(RbCommissionRegisterEO eo) {
        if (eo == null) {
            return null;
        }
        RbCommissionRegisterExample example = new RbCommissionRegisterExample();
        RbCommissionRegisterExample.Criteria criteria = example.createCriteria();
        if (eo.getCommissionClientNo() != null) criteria.andCommissionClientNoEqualTo(eo.getCommissionClientNo());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getCommissionRelation() != null) criteria.andCommissionRelationEqualTo(eo.getCommissionRelation().getValue());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getProgramId() != null) criteria.andProgramIdEqualTo(eo.getProgramId());
        if (eo.getCommissionDocumentType() != null) criteria.andCommissionDocumentTypeEqualTo(eo.getCommissionDocumentType().getValue());
        if (eo.getCommissionConfirmUserIdKey2() != null) criteria.andCommissionConfirmUserIdKey2EqualTo(eo.getCommissionConfirmUserIdKey2());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getCommissionClientName() != null) criteria.andCommissionClientNameEqualTo(eo.getCommissionClientName());
        if (eo.getCommissionReason() != null) criteria.andCommissionReasonEqualTo(eo.getCommissionReason());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getCommissionFlag() != null) criteria.andCommissionFlagEqualTo(eo.getCommissionFlag().getValue());
        if (eo.getCommissionExpireDate() != null) criteria.andCommissionExpireDateEqualTo(eo.getCommissionExpireDate());
        if (eo.getCommissionStartDate() != null) criteria.andCommissionStartDateEqualTo(eo.getCommissionStartDate());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getCommissionConfirmTime() != null) criteria.andCommissionConfirmTimeEqualTo(eo.getCommissionConfirmTime());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getCountry() != null) criteria.andCountryEqualTo(eo.getCountry().getValue());
        if (eo.getIsCommission() != null) criteria.andIsCommissionEqualTo(eo.getIsCommission());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getCommissionConfirmResult() != null) criteria.andCommissionConfirmResultEqualTo(eo.getCommissionConfirmResult());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getCommissionDocumentId() != null) criteria.andCommissionDocumentIdEqualTo(eo.getCommissionDocumentId());
        if (eo.getCommissionClientTel() != null) criteria.andCommissionClientTelEqualTo(eo.getCommissionClientTel());
        if (eo.getCommissionConfirmTel() != null) criteria.andCommissionConfirmTelEqualTo(eo.getCommissionConfirmTel());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getCommissionConfirmUserIdKey1() != null) criteria.andCommissionConfirmUserIdKey1EqualTo(eo.getCommissionConfirmUserIdKey1());
        return example;
    }
}