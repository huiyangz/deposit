package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbBusVoucherAcctRelation;
import com.dcits.depsit.entity.RbBusVoucherAcctRelationExample;
import com.dcits.depsit.facade.eo.RbBusVoucherAcctRelationEO;
import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.VoucherStatus;
import com.dcits.depsit.enums.CanReasonCode;
import com.dcits.depsit.enums.VoucherStatus;

public final class RbBusVoucherAcctRelationValueUtil {
    private RbBusVoucherAcctRelationValueUtil() {
    }

    public static RbBusVoucherAcctRelationEO entityToEo(RbBusVoucherAcctRelation entity) {
        if (entity == null) {
            return null;
        }
        RbBusVoucherAcctRelationEO eo = new RbBusVoucherAcctRelationEO();
        eo.setCardNo(entity.getCardNo());
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setTranDate(entity.getTranDate());
        eo.setCollatInd(entity.getCollatInd());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setNarrative(entity.getNarrative());
        eo.setDocClass(DocClass.byValue(entity.getDocClass()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setOldStatus(VoucherStatus.byValue(entity.getOldStatus()));
        eo.setCollatNo(entity.getCollatNo());
        eo.setProdNo(entity.getProdNo());
        eo.setPrefix(entity.getPrefix());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setCanReasonCode(CanReasonCode.byValue(entity.getCanReasonCode()));
        eo.setReference(entity.getReference());
        eo.setVoucherStatus(VoucherStatus.byValue(entity.getVoucherStatus()));
        return eo;
    }

    public static RbBusVoucherAcctRelation eoToEntity(RbBusVoucherAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusVoucherAcctRelation entity = new RbBusVoucherAcctRelation();
        entity.setCardNo(eo.getCardNo());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setCollatInd(eo.getCollatInd());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setNarrative(eo.getNarrative());
        entity.setDocClass(eo.getDocClass() == null ? null : eo.getDocClass().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setOldStatus(eo.getOldStatus() == null ? null : eo.getOldStatus().getValue());
        entity.setCollatNo(eo.getCollatNo());
        entity.setProdNo(eo.getProdNo());
        entity.setPrefix(eo.getPrefix());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setCanReasonCode(eo.getCanReasonCode() == null ? null : eo.getCanReasonCode().getValue());
        entity.setReference(eo.getReference());
        entity.setVoucherStatus(eo.getVoucherStatus() == null ? null : eo.getVoucherStatus().getValue());
        return entity;
    }

    public static RbBusVoucherAcctRelationExample eoToEntityExample(RbBusVoucherAcctRelationEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusVoucherAcctRelationExample example = new RbBusVoucherAcctRelationExample();
        RbBusVoucherAcctRelationExample.Criteria criteria = example.createCriteria();
        if (eo.getCardNo() != null) criteria.andCardNoEqualTo(eo.getCardNo());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getCollatInd() != null) criteria.andCollatIndEqualTo(eo.getCollatInd());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getDocClass() != null) criteria.andDocClassEqualTo(eo.getDocClass().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getOldStatus() != null) criteria.andOldStatusEqualTo(eo.getOldStatus().getValue());
        if (eo.getCollatNo() != null) criteria.andCollatNoEqualTo(eo.getCollatNo());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getCanReasonCode() != null) criteria.andCanReasonCodeEqualTo(eo.getCanReasonCode().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getVoucherStatus() != null) criteria.andVoucherStatusEqualTo(eo.getVoucherStatus().getValue());
        return example;
    }
}