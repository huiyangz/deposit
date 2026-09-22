package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbVoucherAcctRelation;
import com.dcits.deposit.entity.RbVoucherAcctRelationExample;
import com.dcits.deposit.facade.eo.RbVoucherAcctRelationEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CanReasonCode;

public final class RbVoucherAcctRelationValueUtil {
    private RbVoucherAcctRelationValueUtil() {
    }

    public static RbVoucherAcctRelationEO entityToEo(RbVoucherAcctRelation entity) {
        if (entity == null) {
            return null;
        }
        RbVoucherAcctRelationEO eo = new RbVoucherAcctRelationEO();
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setCardNo(entity.getCardNo());
        eo.setPrefix(entity.getPrefix());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setDocClass(DocClass.byValue(entity.getDocClass()));
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setVoucherStatus(VoucherStatus.byValue(entity.getVoucherStatus()));
        eo.setOldStatus(VoucherStatus.byValue(entity.getOldStatus()));
        eo.setReference(entity.getReference());
        eo.setCollatInd(IndividualFlag.byValue(entity.getCollatInd()));
        eo.setCollatNo(entity.getCollatNo());
        eo.setClientNo(entity.getClientNo());
        eo.setNarrative(entity.getNarrative());
        eo.setRemark(entity.getRemark());
        eo.setTranDate(entity.getTranDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCanReasonCode(CanReasonCode.byValue(entity.getCanReasonCode()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbVoucherAcctRelation eoToEntity(RbVoucherAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbVoucherAcctRelation entity = new RbVoucherAcctRelation();
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setCardNo(eo.getCardNo());
        entity.setPrefix(eo.getPrefix());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setDocClass(eo.getDocClass() == null ? null : eo.getDocClass().getValue());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setVoucherStatus(eo.getVoucherStatus() == null ? null : eo.getVoucherStatus().getValue());
        entity.setOldStatus(eo.getOldStatus() == null ? null : eo.getOldStatus().getValue());
        entity.setReference(eo.getReference());
        entity.setCollatInd(eo.getCollatInd() == null ? null : eo.getCollatInd().getValue());
        entity.setCollatNo(eo.getCollatNo());
        entity.setClientNo(eo.getClientNo());
        entity.setNarrative(eo.getNarrative());
        entity.setRemark(eo.getRemark());
        entity.setTranDate(eo.getTranDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCanReasonCode(eo.getCanReasonCode() == null ? null : eo.getCanReasonCode().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbVoucherAcctRelationExample eoToEntityExample(RbVoucherAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbVoucherAcctRelationExample example = new RbVoucherAcctRelationExample();
        RbVoucherAcctRelationExample.Criteria criteria = example.createCriteria();
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getCardNo() != null) criteria.andCardNoEqualTo(eo.getCardNo());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getDocClass() != null) criteria.andDocClassEqualTo(eo.getDocClass().getValue());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getVoucherStatus() != null) criteria.andVoucherStatusEqualTo(eo.getVoucherStatus().getValue());
        if (eo.getOldStatus() != null) criteria.andOldStatusEqualTo(eo.getOldStatus().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getCollatInd() != null) criteria.andCollatIndEqualTo(eo.getCollatInd().getValue());
        if (eo.getCollatNo() != null) criteria.andCollatNoEqualTo(eo.getCollatNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCanReasonCode() != null) criteria.andCanReasonCodeEqualTo(eo.getCanReasonCode().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}