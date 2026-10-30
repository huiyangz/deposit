package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusVoucherAcctRelation;
import com.dcits.deposit.entity.RbBusVoucherAcctRelationExample;
import com.dcits.deposit.facade.eo.RbBusVoucherAcctRelationEO;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.DocClass;

public final class RbBusVoucherAcctRelationValueUtil {
    private RbBusVoucherAcctRelationValueUtil() {
    }

    public static RbBusVoucherAcctRelationEO entityToEo(RbBusVoucherAcctRelation entity) {
        if (entity == null) {
            return null;
        }
        RbBusVoucherAcctRelationEO eo = new RbBusVoucherAcctRelationEO();
        eo.setCardNo(entity.getCardNo());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setTranDate(entity.getTranDate());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setNarrative(entity.getNarrative());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setOldStatus(VoucherStatus.byValue(entity.getOldStatus()));
        eo.setProdNo(entity.getProdNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setCanReasonCode(CanReasonCode.byValue(entity.getCanReasonCode()));
        eo.setVoucherStatus(VoucherStatus.byValue(entity.getVoucherStatus()));
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setCollatInd(entity.getCollatInd());
        eo.setDocClass(DocClass.byValue(entity.getDocClass()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setCollatNo(entity.getCollatNo());
        eo.setPrefix(entity.getPrefix());
        eo.setReference(entity.getReference());
        return eo;
    }

    public static RbBusVoucherAcctRelation eoToEntity(RbBusVoucherAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusVoucherAcctRelation entity = new RbBusVoucherAcctRelation();
        entity.setCardNo(eo.getCardNo());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setTranDate(eo.getTranDate());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setNarrative(eo.getNarrative());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setOldStatus(eo.getOldStatus() == null ? null : eo.getOldStatus().getValue());
        entity.setProdNo(eo.getProdNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setCanReasonCode(eo.getCanReasonCode() == null ? null : eo.getCanReasonCode().getValue());
        entity.setVoucherStatus(eo.getVoucherStatus() == null ? null : eo.getVoucherStatus().getValue());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setCollatInd(eo.getCollatInd());
        entity.setDocClass(eo.getDocClass() == null ? null : eo.getDocClass().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setCollatNo(eo.getCollatNo());
        entity.setPrefix(eo.getPrefix());
        entity.setReference(eo.getReference());
        return entity;
    }

    public static RbBusVoucherAcctRelationExample eoToEntityExample(RbBusVoucherAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusVoucherAcctRelationExample example = new RbBusVoucherAcctRelationExample();
        RbBusVoucherAcctRelationExample.Criteria criteria = example.createCriteria();
        if (eo.getCardNo() != null) criteria.andCardNoEqualTo(eo.getCardNo());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getOldStatus() != null) criteria.andOldStatusEqualTo(eo.getOldStatus().getValue());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getCanReasonCode() != null) criteria.andCanReasonCodeEqualTo(eo.getCanReasonCode().getValue());
        if (eo.getVoucherStatus() != null) criteria.andVoucherStatusEqualTo(eo.getVoucherStatus().getValue());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getCollatInd() != null) criteria.andCollatIndEqualTo(eo.getCollatInd());
        if (eo.getDocClass() != null) criteria.andDocClassEqualTo(eo.getDocClass().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getCollatNo() != null) criteria.andCollatNoEqualTo(eo.getCollatNo());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        return example;
    }
}