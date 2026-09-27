package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusOpenCloseReg;
import com.dcits.deposit.entity.RbBusOpenCloseRegExample;
import com.dcits.deposit.facade.eo.RbBusOpenCloseRegEO;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.IsSelf;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.InformBankFlag;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.SucFlag;
import com.dcits.deposit.enums.OpMethod;

public final class RbBusOpenCloseRegValueUtil {
    private RbBusOpenCloseRegValueUtil() {
    }

    public static RbBusOpenCloseRegEO entityToEo(RbBusOpenCloseReg entity) {
        if (entity == null) {
            return null;
        }
        RbBusOpenCloseRegEO eo = new RbBusOpenCloseRegEO();
        eo.setRbBusAcctPurpose(RbBusAcctPurpose.byValue(entity.getRbBusAcctPurpose()));
        eo.setOpenBranch(entity.getOpenBranch());
        eo.setInternalKey(entity.getInternalKey());
        eo.setAcctNatureNo(AcctNatureNo.byValue(entity.getAcctNatureNo()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setAcctOpenMode(AcctOpenMode.byValue(entity.getAcctOpenMode()));
        eo.setRegType(RegType.byValue(entity.getRegType()));
        eo.setActiveDate(entity.getActiveDate());
        eo.setCardNo(entity.getCardNo());
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setOpenAmount(entity.getOpenAmount());
        eo.setTranDate(entity.getTranDate());
        eo.setRbAcctType(RbAcctType.byValue(entity.getRbAcctType()));
        eo.setIsSelf(IsSelf.byValue(entity.getIsSelf()));
        eo.setNarrative(entity.getNarrative());
        eo.setAcctPurposeDesc(entity.getAcctPurposeDesc());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setAcctBranch(TranBranch.byValue(entity.getAcctBranch()));
        eo.setInformBankFlag(InformBankFlag.byValue(entity.getInformBankFlag()));
        eo.setApprovalNo(entity.getApprovalNo());
        eo.setClientNo(entity.getClientNo());
        eo.setDocumentId(entity.getDocumentId());
        eo.setAcctStatus(AcctStatus.byValue(entity.getAcctStatus()));
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setReference(entity.getReference());
        eo.setNarrativeCode(entity.getNarrativeCode());
        eo.setProdNo(entity.getProdNo());
        eo.setSucFlag(SucFlag.byValue(entity.getSucFlag()));
        eo.setOpMethod(OpMethod.byValue(entity.getOpMethod()));
        eo.setSeqNo(entity.getSeqNo());
        return eo;
    }

    public static RbBusOpenCloseReg eoToEntity(RbBusOpenCloseRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusOpenCloseReg entity = new RbBusOpenCloseReg();
        entity.setRbBusAcctPurpose(eo.getRbBusAcctPurpose() == null ? null : eo.getRbBusAcctPurpose().getValue());
        entity.setOpenBranch(eo.getOpenBranch());
        entity.setInternalKey(eo.getInternalKey());
        entity.setAcctNatureNo(eo.getAcctNatureNo() == null ? null : eo.getAcctNatureNo().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setAcctOpenMode(eo.getAcctOpenMode() == null ? null : eo.getAcctOpenMode().getValue());
        entity.setRegType(eo.getRegType() == null ? null : eo.getRegType().getValue());
        entity.setActiveDate(eo.getActiveDate());
        entity.setCardNo(eo.getCardNo());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setOpenAmount(eo.getOpenAmount());
        entity.setTranDate(eo.getTranDate());
        entity.setRbAcctType(eo.getRbAcctType() == null ? null : eo.getRbAcctType().getValue());
        entity.setIsSelf(eo.getIsSelf() == null ? null : eo.getIsSelf().getValue());
        entity.setNarrative(eo.getNarrative());
        entity.setAcctPurposeDesc(eo.getAcctPurposeDesc());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setInformBankFlag(eo.getInformBankFlag() == null ? null : eo.getInformBankFlag().getValue());
        entity.setApprovalNo(eo.getApprovalNo());
        entity.setClientNo(eo.getClientNo());
        entity.setDocumentId(eo.getDocumentId());
        entity.setAcctStatus(eo.getAcctStatus() == null ? null : eo.getAcctStatus().getValue());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setReference(eo.getReference());
        entity.setNarrativeCode(eo.getNarrativeCode());
        entity.setProdNo(eo.getProdNo());
        entity.setSucFlag(eo.getSucFlag() == null ? null : eo.getSucFlag().getValue());
        entity.setOpMethod(eo.getOpMethod() == null ? null : eo.getOpMethod().getValue());
        entity.setSeqNo(eo.getSeqNo());
        return entity;
    }

    public static RbBusOpenCloseRegExample eoToEntityExample(RbBusOpenCloseRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusOpenCloseRegExample example = new RbBusOpenCloseRegExample();
        RbBusOpenCloseRegExample.Criteria criteria = example.createCriteria();
        if (eo.getRbBusAcctPurpose() != null) criteria.andRbBusAcctPurposeEqualTo(eo.getRbBusAcctPurpose().getValue());
        if (eo.getOpenBranch() != null) criteria.andOpenBranchEqualTo(eo.getOpenBranch());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getAcctNatureNo() != null) criteria.andAcctNatureNoEqualTo(eo.getAcctNatureNo().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getAcctOpenMode() != null) criteria.andAcctOpenModeEqualTo(eo.getAcctOpenMode().getValue());
        if (eo.getRegType() != null) criteria.andRegTypeEqualTo(eo.getRegType().getValue());
        if (eo.getActiveDate() != null) criteria.andActiveDateEqualTo(eo.getActiveDate());
        if (eo.getCardNo() != null) criteria.andCardNoEqualTo(eo.getCardNo());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getOpenAmount() != null) criteria.andOpenAmountEqualTo(eo.getOpenAmount());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getRbAcctType() != null) criteria.andRbAcctTypeEqualTo(eo.getRbAcctType().getValue());
        if (eo.getIsSelf() != null) criteria.andIsSelfEqualTo(eo.getIsSelf().getValue());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getAcctPurposeDesc() != null) criteria.andAcctPurposeDescEqualTo(eo.getAcctPurposeDesc());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getInformBankFlag() != null) criteria.andInformBankFlagEqualTo(eo.getInformBankFlag().getValue());
        if (eo.getApprovalNo() != null) criteria.andApprovalNoEqualTo(eo.getApprovalNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getAcctStatus() != null) criteria.andAcctStatusEqualTo(eo.getAcctStatus().getValue());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getNarrativeCode() != null) criteria.andNarrativeCodeEqualTo(eo.getNarrativeCode());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getSucFlag() != null) criteria.andSucFlagEqualTo(eo.getSucFlag().getValue());
        if (eo.getOpMethod() != null) criteria.andOpMethodEqualTo(eo.getOpMethod().getValue());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        return example;
    }
}