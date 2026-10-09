package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbVoucherLost;
import com.dcits.depsit.entity.RbVoucherLostExample;
import com.dcits.depsit.facade.eo.RbVoucherLostEO;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.VoucherLostStatus;
import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.RelieveLossType;
import com.dcits.depsit.enums.LostType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.DocType;

public final class RbVoucherLostValueUtil {
    private RbVoucherLostValueUtil() {
    }

    public static RbVoucherLostEO entityToEo(RbVoucherLost entity) {
        if (entity == null) {
            return null;
        }
        RbVoucherLostEO eo = new RbVoucherLostEO();
        eo.setInternalKey(entity.getInternalKey());
        eo.setUnlostDate(entity.getUnlostDate());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setUnchainBranch(TranBranch.byValue(entity.getUnchainBranch()));
        eo.setReportedLostReason(entity.getReportedLostReason());
        eo.setUnlostUserId(entity.getUnlostUserId());
        eo.setReference(entity.getReference());
        eo.setTranBranch(TranBranch.byValue(entity.getTranBranch()));
        eo.setVoucherLostStatus(VoucherLostStatus.byValue(entity.getVoucherLostStatus()));
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setRelieveLossType(RelieveLossType.byValue(entity.getRelieveLossType()));
        eo.setAcctName(entity.getAcctName());
        eo.setDealResult(entity.getDealResult());
        eo.setPrefix(entity.getPrefix());
        eo.setUnchainAuthUserId(entity.getUnchainAuthUserId());
        eo.setLostKey(entity.getLostKey());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setTranDate(entity.getTranDate());
        eo.setLostType(LostType.byValue(entity.getLostType()));
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setLostNo(entity.getLostNo());
        eo.setStartSeqNo(entity.getStartSeqNo());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setResFlag(entity.getResFlag());
        eo.setUserId(entity.getUserId());
        eo.setClientNo(entity.getClientNo());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setProdNo(entity.getProdNo());
        eo.setAuthUserId(entity.getAuthUserId());
        eo.setAutoUnblockDate(entity.getAutoUnblockDate());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        return eo;
    }

    public static RbVoucherLost eoToEntity(RbVoucherLostEO eo) {
        if (eo == null) {
            return null;
        }
        RbVoucherLost entity = new RbVoucherLost();
        entity.setInternalKey(eo.getInternalKey());
        entity.setUnlostDate(eo.getUnlostDate());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setUnchainBranch(eo.getUnchainBranch() == null ? null : eo.getUnchainBranch().getValue());
        entity.setReportedLostReason(eo.getReportedLostReason());
        entity.setUnlostUserId(eo.getUnlostUserId());
        entity.setReference(eo.getReference());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setVoucherLostStatus(eo.getVoucherLostStatus() == null ? null : eo.getVoucherLostStatus().getValue());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setRelieveLossType(eo.getRelieveLossType() == null ? null : eo.getRelieveLossType().getValue());
        entity.setAcctName(eo.getAcctName());
        entity.setDealResult(eo.getDealResult());
        entity.setPrefix(eo.getPrefix());
        entity.setUnchainAuthUserId(eo.getUnchainAuthUserId());
        entity.setLostKey(eo.getLostKey());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setTranDate(eo.getTranDate());
        entity.setLostType(eo.getLostType() == null ? null : eo.getLostType().getValue());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setLostNo(eo.getLostNo());
        entity.setStartSeqNo(eo.getStartSeqNo());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setResFlag(eo.getResFlag());
        entity.setUserId(eo.getUserId());
        entity.setClientNo(eo.getClientNo());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setProdNo(eo.getProdNo());
        entity.setAuthUserId(eo.getAuthUserId());
        entity.setAutoUnblockDate(eo.getAutoUnblockDate());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        return entity;
    }

    public static RbVoucherLostExample eoToEntityExample(RbVoucherLostEO eo) {
        if (eo == null) {
            return null;
        }
        RbVoucherLostExample example = new RbVoucherLostExample();
        RbVoucherLostExample.Criteria criteria = example.createCriteria();
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getUnlostDate() != null) criteria.andUnlostDateEqualTo(eo.getUnlostDate());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getUnchainBranch() != null) criteria.andUnchainBranchEqualTo(eo.getUnchainBranch().getValue());
        if (eo.getReportedLostReason() != null) criteria.andReportedLostReasonEqualTo(eo.getReportedLostReason());
        if (eo.getUnlostUserId() != null) criteria.andUnlostUserIdEqualTo(eo.getUnlostUserId());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getVoucherLostStatus() != null) criteria.andVoucherLostStatusEqualTo(eo.getVoucherLostStatus().getValue());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getRelieveLossType() != null) criteria.andRelieveLossTypeEqualTo(eo.getRelieveLossType().getValue());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getDealResult() != null) criteria.andDealResultEqualTo(eo.getDealResult());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getUnchainAuthUserId() != null) criteria.andUnchainAuthUserIdEqualTo(eo.getUnchainAuthUserId());
        if (eo.getLostKey() != null) criteria.andLostKeyEqualTo(eo.getLostKey());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getLostType() != null) criteria.andLostTypeEqualTo(eo.getLostType().getValue());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getLostNo() != null) criteria.andLostNoEqualTo(eo.getLostNo());
        if (eo.getStartSeqNo() != null) criteria.andStartSeqNoEqualTo(eo.getStartSeqNo());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getResFlag() != null) criteria.andResFlagEqualTo(eo.getResFlag());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getAuthUserId() != null) criteria.andAuthUserIdEqualTo(eo.getAuthUserId());
        if (eo.getAutoUnblockDate() != null) criteria.andAutoUnblockDateEqualTo(eo.getAutoUnblockDate());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        return example;
    }
}