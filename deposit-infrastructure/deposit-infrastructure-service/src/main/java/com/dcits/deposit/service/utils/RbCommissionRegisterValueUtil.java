package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbCommissionRegister;
import com.dcits.deposit.entity.RbCommissionRegisterExample;
import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CommissionFlag;
import com.dcits.deposit.enums.IndividualFlag;

public final class RbCommissionRegisterValueUtil {
    private RbCommissionRegisterValueUtil() {
    }

    public static RbCommissionRegisterEO entityToEo(RbCommissionRegister entity) {
        if (entity == null) {
            return null;
        }
        RbCommissionRegisterEO eo = new RbCommissionRegisterEO();
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setReference(entity.getReference());
        eo.setProgramId(entity.getProgramId());
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setInternalKey(entity.getInternalKey());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctName(entity.getAcctName());
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setEventType(entity.getEventType());
        eo.setTranAmt(entity.getTranAmt());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setPrefix(entity.getPrefix());
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setClientNo(entity.getClientNo());
        eo.setCommissionClientName(entity.getCommissionClientName());
        eo.setCommissionClientNo(entity.getCommissionClientNo());
        eo.setCommissionDocumentId(entity.getCommissionDocumentId());
        eo.setCommissionDocumentType(DocumentType.byValue(entity.getCommissionDocumentType()));
        eo.setCountry(IssCountry.byValue(entity.getCountry()));
        eo.setCommissionStartDate(entity.getCommissionStartDate());
        eo.setCommissionExpireDate(entity.getCommissionExpireDate());
        eo.setCommissionClientTel(entity.getCommissionClientTel());
        eo.setCommissionReason(entity.getCommissionReason());
        eo.setCommissionRelation(CommissionRelation.byValue(entity.getCommissionRelation()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCommissionConfirmUserIdKey1(entity.getCommissionConfirmUserIdKey1());
        eo.setCommissionConfirmUserIdKey2(entity.getCommissionConfirmUserIdKey2());
        eo.setCommissionConfirmTel(entity.getCommissionConfirmTel());
        eo.setCommissionConfirmTime(entity.getCommissionConfirmTime());
        eo.setCommissionConfirmResult(entity.getCommissionConfirmResult());
        eo.setCommissionFlag(CommissionFlag.byValue(entity.getCommissionFlag()));
        eo.setIsCommission(IndividualFlag.byValue(entity.getIsCommission()));
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbCommissionRegister eoToEntity(RbCommissionRegisterEO eo) {
        if (eo == null) {
            return null;
        }
        RbCommissionRegister entity = new RbCommissionRegister();
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setReference(eo.getReference());
        entity.setProgramId(eo.getProgramId());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setInternalKey(eo.getInternalKey());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctName(eo.getAcctName());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setEventType(eo.getEventType());
        entity.setTranAmt(eo.getTranAmt());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setPrefix(eo.getPrefix());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setClientNo(eo.getClientNo());
        entity.setCommissionClientName(eo.getCommissionClientName());
        entity.setCommissionClientNo(eo.getCommissionClientNo());
        entity.setCommissionDocumentId(eo.getCommissionDocumentId());
        entity.setCommissionDocumentType(eo.getCommissionDocumentType() == null ? null : eo.getCommissionDocumentType().getValue());
        entity.setCountry(eo.getCountry() == null ? null : eo.getCountry().getValue());
        entity.setCommissionStartDate(eo.getCommissionStartDate());
        entity.setCommissionExpireDate(eo.getCommissionExpireDate());
        entity.setCommissionClientTel(eo.getCommissionClientTel());
        entity.setCommissionReason(eo.getCommissionReason());
        entity.setCommissionRelation(eo.getCommissionRelation() == null ? null : eo.getCommissionRelation().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCommissionConfirmUserIdKey1(eo.getCommissionConfirmUserIdKey1());
        entity.setCommissionConfirmUserIdKey2(eo.getCommissionConfirmUserIdKey2());
        entity.setCommissionConfirmTel(eo.getCommissionConfirmTel());
        entity.setCommissionConfirmTime(eo.getCommissionConfirmTime());
        entity.setCommissionConfirmResult(eo.getCommissionConfirmResult());
        entity.setCommissionFlag(eo.getCommissionFlag() == null ? null : eo.getCommissionFlag().getValue());
        entity.setIsCommission(eo.getIsCommission() == null ? null : eo.getIsCommission().getValue());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbCommissionRegisterExample eoToEntityExample(RbCommissionRegisterEO eo) {
        if (eo == null) {
            return null;
        }
        RbCommissionRegisterExample example = new RbCommissionRegisterExample();
        RbCommissionRegisterExample.Criteria criteria = example.createCriteria();
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getProgramId() != null) criteria.andProgramIdEqualTo(eo.getProgramId());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getCommissionClientName() != null) criteria.andCommissionClientNameEqualTo(eo.getCommissionClientName());
        if (eo.getCommissionClientNo() != null) criteria.andCommissionClientNoEqualTo(eo.getCommissionClientNo());
        if (eo.getCommissionDocumentId() != null) criteria.andCommissionDocumentIdEqualTo(eo.getCommissionDocumentId());
        if (eo.getCommissionDocumentType() != null) criteria.andCommissionDocumentTypeEqualTo(eo.getCommissionDocumentType().getValue());
        if (eo.getCountry() != null) criteria.andCountryEqualTo(eo.getCountry().getValue());
        if (eo.getCommissionStartDate() != null) criteria.andCommissionStartDateEqualTo(eo.getCommissionStartDate());
        if (eo.getCommissionExpireDate() != null) criteria.andCommissionExpireDateEqualTo(eo.getCommissionExpireDate());
        if (eo.getCommissionClientTel() != null) criteria.andCommissionClientTelEqualTo(eo.getCommissionClientTel());
        if (eo.getCommissionReason() != null) criteria.andCommissionReasonEqualTo(eo.getCommissionReason());
        if (eo.getCommissionRelation() != null) criteria.andCommissionRelationEqualTo(eo.getCommissionRelation().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCommissionConfirmUserIdKey1() != null) criteria.andCommissionConfirmUserIdKey1EqualTo(eo.getCommissionConfirmUserIdKey1());
        if (eo.getCommissionConfirmUserIdKey2() != null) criteria.andCommissionConfirmUserIdKey2EqualTo(eo.getCommissionConfirmUserIdKey2());
        if (eo.getCommissionConfirmTel() != null) criteria.andCommissionConfirmTelEqualTo(eo.getCommissionConfirmTel());
        if (eo.getCommissionConfirmTime() != null) criteria.andCommissionConfirmTimeEqualTo(eo.getCommissionConfirmTime());
        if (eo.getCommissionConfirmResult() != null) criteria.andCommissionConfirmResultEqualTo(eo.getCommissionConfirmResult());
        if (eo.getCommissionFlag() != null) criteria.andCommissionFlagEqualTo(eo.getCommissionFlag().getValue());
        if (eo.getIsCommission() != null) criteria.andIsCommissionEqualTo(eo.getIsCommission().getValue());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}