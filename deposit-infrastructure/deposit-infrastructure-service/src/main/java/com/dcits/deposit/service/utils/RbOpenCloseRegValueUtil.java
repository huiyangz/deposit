package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbOpenCloseReg;
import com.dcits.deposit.entity.RbOpenCloseRegExample;
import com.dcits.deposit.facade.eo.RbOpenCloseRegEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OpMethod;
import com.dcits.deposit.enums.RegType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.SourceModule;

public final class RbOpenCloseRegValueUtil {
    private RbOpenCloseRegValueUtil() {
    }

    public static RbOpenCloseRegEO entityToEo(RbOpenCloseReg entity) {
        if (entity == null) {
            return null;
        }
        RbOpenCloseRegEO eo = new RbOpenCloseRegEO();
        eo.setOpenBranch(AcctBranch.byValue(entity.getOpenBranch()));
        eo.setSeqNo(entity.getSeqNo());
        eo.setInternalKey(entity.getInternalKey());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setProdType(entity.getProdType());
        eo.setCardNo(entity.getCardNo());
        eo.setAcctBranch(AcctBranch.byValue(entity.getAcctBranch()));
        eo.setAcctStatus(AcctStatus.byValue(entity.getAcctStatus()));
        eo.setAcctType(AcctType.byValue(entity.getAcctType()));
        eo.setAcctNature(AcctNature.byValue(entity.getAcctNature()));
        eo.setActiveDate(entity.getActiveDate());
        eo.setReference(entity.getReference());
        eo.setInformBankFlag(IndividualFlag.byValue(entity.getInformBankFlag()));
        eo.setOpMethod(OpMethod.byValue(entity.getOpMethod()));
        eo.setRegType(RegType.byValue(entity.getRegType()));
        eo.setSucFlag(IndividualFlag.byValue(entity.getSucFlag()));
        eo.setIsSelf(IndividualFlag.byValue(entity.getIsSelf()));
        eo.setDocumentId(entity.getDocumentId());
        eo.setClientNo(entity.getClientNo());
        eo.setNarrative(entity.getNarrative());
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setUserId(entity.getUserId());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setNarrativeCode(entity.getNarrativeCode());
        eo.setApprovalNo(entity.getApprovalNo());
        eo.setOpenAmount(entity.getOpenAmount());
        eo.setAcctOpenMode(AcctOpenMode.byValue(entity.getAcctOpenMode()));
        eo.setAuthUserId(entity.getAuthUserId());
        eo.setAcctClass(AcctClass.byValue(entity.getAcctClass()));
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setReasonCode(ReasonCode.byValue(entity.getReasonCode()));
        eo.setReasonCodeDesc(entity.getReasonCodeDesc());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setSourceModule(SourceModule.byValue(entity.getSourceModule()));
        return eo;
    }

    public static RbOpenCloseReg eoToEntity(RbOpenCloseRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbOpenCloseReg entity = new RbOpenCloseReg();
        entity.setOpenBranch(eo.getOpenBranch() == null ? null : eo.getOpenBranch().getValue());
        entity.setSeqNo(eo.getSeqNo());
        entity.setInternalKey(eo.getInternalKey());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setProdType(eo.getProdType());
        entity.setCardNo(eo.getCardNo());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setAcctStatus(eo.getAcctStatus() == null ? null : eo.getAcctStatus().getValue());
        entity.setAcctType(eo.getAcctType() == null ? null : eo.getAcctType().getValue());
        entity.setAcctNature(eo.getAcctNature() == null ? null : eo.getAcctNature().getValue());
        entity.setActiveDate(eo.getActiveDate());
        entity.setReference(eo.getReference());
        entity.setInformBankFlag(eo.getInformBankFlag() == null ? null : eo.getInformBankFlag().getValue());
        entity.setOpMethod(eo.getOpMethod() == null ? null : eo.getOpMethod().getValue());
        entity.setRegType(eo.getRegType() == null ? null : eo.getRegType().getValue());
        entity.setSucFlag(eo.getSucFlag() == null ? null : eo.getSucFlag().getValue());
        entity.setIsSelf(eo.getIsSelf() == null ? null : eo.getIsSelf().getValue());
        entity.setDocumentId(eo.getDocumentId());
        entity.setClientNo(eo.getClientNo());
        entity.setNarrative(eo.getNarrative());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setUserId(eo.getUserId());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setNarrativeCode(eo.getNarrativeCode());
        entity.setApprovalNo(eo.getApprovalNo());
        entity.setOpenAmount(eo.getOpenAmount());
        entity.setAcctOpenMode(eo.getAcctOpenMode() == null ? null : eo.getAcctOpenMode().getValue());
        entity.setAuthUserId(eo.getAuthUserId());
        entity.setAcctClass(eo.getAcctClass() == null ? null : eo.getAcctClass().getValue());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setReasonCode(eo.getReasonCode() == null ? null : eo.getReasonCode().getValue());
        entity.setReasonCodeDesc(eo.getReasonCodeDesc());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setSourceModule(eo.getSourceModule() == null ? null : eo.getSourceModule().getValue());
        return entity;
    }

    public static RbOpenCloseRegExample eoToEntityExample(RbOpenCloseRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbOpenCloseRegExample example = new RbOpenCloseRegExample();
        RbOpenCloseRegExample.Criteria criteria = example.createCriteria();
        if (eo.getOpenBranch() != null) criteria.andOpenBranchEqualTo(eo.getOpenBranch().getValue());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getCardNo() != null) criteria.andCardNoEqualTo(eo.getCardNo());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getAcctStatus() != null) criteria.andAcctStatusEqualTo(eo.getAcctStatus().getValue());
        if (eo.getAcctType() != null) criteria.andAcctTypeEqualTo(eo.getAcctType().getValue());
        if (eo.getAcctNature() != null) criteria.andAcctNatureEqualTo(eo.getAcctNature().getValue());
        if (eo.getActiveDate() != null) criteria.andActiveDateEqualTo(eo.getActiveDate());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getInformBankFlag() != null) criteria.andInformBankFlagEqualTo(eo.getInformBankFlag().getValue());
        if (eo.getOpMethod() != null) criteria.andOpMethodEqualTo(eo.getOpMethod().getValue());
        if (eo.getRegType() != null) criteria.andRegTypeEqualTo(eo.getRegType().getValue());
        if (eo.getSucFlag() != null) criteria.andSucFlagEqualTo(eo.getSucFlag().getValue());
        if (eo.getIsSelf() != null) criteria.andIsSelfEqualTo(eo.getIsSelf().getValue());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getNarrativeCode() != null) criteria.andNarrativeCodeEqualTo(eo.getNarrativeCode());
        if (eo.getApprovalNo() != null) criteria.andApprovalNoEqualTo(eo.getApprovalNo());
        if (eo.getOpenAmount() != null) criteria.andOpenAmountEqualTo(eo.getOpenAmount());
        if (eo.getAcctOpenMode() != null) criteria.andAcctOpenModeEqualTo(eo.getAcctOpenMode().getValue());
        if (eo.getAuthUserId() != null) criteria.andAuthUserIdEqualTo(eo.getAuthUserId());
        if (eo.getAcctClass() != null) criteria.andAcctClassEqualTo(eo.getAcctClass().getValue());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getReasonCode() != null) criteria.andReasonCodeEqualTo(eo.getReasonCode().getValue());
        if (eo.getReasonCodeDesc() != null) criteria.andReasonCodeDescEqualTo(eo.getReasonCodeDesc());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getSourceModule() != null) criteria.andSourceModuleEqualTo(eo.getSourceModule().getValue());
        return example;
    }
}