package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbApprLetterTranHist;
import com.dcits.deposit.entity.RbApprLetterTranHistExample;
import com.dcits.deposit.facade.eo.RbApprLetterTranHistEO;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranCategory;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.Company;

public final class RbApprLetterTranHistValueUtil {
    private RbApprLetterTranHistValueUtil() {
    }

    public static RbApprLetterTranHistEO entityToEo(RbApprLetterTranHist entity) {
        if (entity == null) {
            return null;
        }
        RbApprLetterTranHistEO eo = new RbApprLetterTranHistEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setTraceId(entity.getTraceId());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setTranDate(entity.getTranDate());
        eo.setTerminalId(entity.getTerminalId());
        eo.setInternalKey(entity.getInternalKey());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctBranch(AcctBranch.byValue(entity.getAcctBranch()));
        eo.setAcctDesc(entity.getAcctDesc());
        eo.setClientNo(entity.getClientNo());
        eo.setEffectDate(entity.getEffectDate());
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setEventType(entity.getEventType());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setPreviousBalAmt(entity.getPreviousBalAmt());
        eo.setTranAmt(entity.getTranAmt());
        eo.setCrDrInd(CrDrInd.byValue(entity.getCrDrInd()));
        eo.setActualBal(entity.getActualBal());
        eo.setTranStatus(TranStatus.byValue(entity.getTranStatus()));
        eo.setReversalDate(entity.getReversalDate());
        eo.setNarrative(entity.getNarrative());
        eo.setTranCategory(TranCategory.byValue(entity.getTranCategory()));
        eo.setTranDesc(entity.getTranDesc());
        eo.setTranNote(entity.getTranNote());
        eo.setCashItem(CashItem.byValue(entity.getCashItem()));
        eo.setOthInternalKey(entity.getOthInternalKey());
        eo.setOthBaseAcctNo(entity.getOthBaseAcctNo());
        eo.setOthProdType(entity.getOthProdType());
        eo.setOthAcctCcy(AcctCcy.byValue(entity.getOthAcctCcy()));
        eo.setOthAcctSeqNo(entity.getOthAcctSeqNo());
        eo.setOthAcctDesc(entity.getOthAcctDesc());
        eo.setOthBranch(AcctBranch.byValue(entity.getOthBranch()));
        eo.setOthBankName(entity.getOthBankName());
        eo.setOthBankCode(entity.getOthBankCode());
        eo.setApprLetterNo(entity.getApprLetterNo());
        eo.setOthReference(entity.getOthReference());
        eo.setReversalTranType(TranType.byValue(entity.getReversalTranType()));
        eo.setServCharge(IndividualFlag.byValue(entity.getServCharge()));
        eo.setApprType(ApprType.byValue(entity.getApprType()));
        eo.setPriority(entity.getPriority());
        eo.setOthSeqNo(entity.getOthSeqNo());
        eo.setBankSeqNo(entity.getBankSeqNo());
        eo.setGlCode(entity.getGlCode());
        eo.setUserId(entity.getUserId());
        eo.setAuthUserId(entity.getAuthUserId());
        eo.setApprUserId(entity.getApprUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbApprLetterTranHist eoToEntity(RbApprLetterTranHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetterTranHist entity = new RbApprLetterTranHist();
        entity.setSeqNo(eo.getSeqNo());
        entity.setTraceId(eo.getTraceId());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setTerminalId(eo.getTerminalId());
        entity.setInternalKey(eo.getInternalKey());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setAcctDesc(eo.getAcctDesc());
        entity.setClientNo(eo.getClientNo());
        entity.setEffectDate(eo.getEffectDate());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setEventType(eo.getEventType());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setPreviousBalAmt(eo.getPreviousBalAmt());
        entity.setTranAmt(eo.getTranAmt());
        entity.setCrDrInd(eo.getCrDrInd() == null ? null : eo.getCrDrInd().getValue());
        entity.setActualBal(eo.getActualBal());
        entity.setTranStatus(eo.getTranStatus() == null ? null : eo.getTranStatus().getValue());
        entity.setReversalDate(eo.getReversalDate());
        entity.setNarrative(eo.getNarrative());
        entity.setTranCategory(eo.getTranCategory() == null ? null : eo.getTranCategory().getValue());
        entity.setTranDesc(eo.getTranDesc());
        entity.setTranNote(eo.getTranNote());
        entity.setCashItem(eo.getCashItem() == null ? null : eo.getCashItem().getValue());
        entity.setOthInternalKey(eo.getOthInternalKey());
        entity.setOthBaseAcctNo(eo.getOthBaseAcctNo());
        entity.setOthProdType(eo.getOthProdType());
        entity.setOthAcctCcy(eo.getOthAcctCcy() == null ? null : eo.getOthAcctCcy().getValue());
        entity.setOthAcctSeqNo(eo.getOthAcctSeqNo());
        entity.setOthAcctDesc(eo.getOthAcctDesc());
        entity.setOthBranch(eo.getOthBranch() == null ? null : eo.getOthBranch().getValue());
        entity.setOthBankName(eo.getOthBankName());
        entity.setOthBankCode(eo.getOthBankCode());
        entity.setApprLetterNo(eo.getApprLetterNo());
        entity.setOthReference(eo.getOthReference());
        entity.setReversalTranType(eo.getReversalTranType() == null ? null : eo.getReversalTranType().getValue());
        entity.setServCharge(eo.getServCharge() == null ? null : eo.getServCharge().getValue());
        entity.setApprType(eo.getApprType() == null ? null : eo.getApprType().getValue());
        entity.setPriority(eo.getPriority());
        entity.setOthSeqNo(eo.getOthSeqNo());
        entity.setBankSeqNo(eo.getBankSeqNo());
        entity.setGlCode(eo.getGlCode());
        entity.setUserId(eo.getUserId());
        entity.setAuthUserId(eo.getAuthUserId());
        entity.setApprUserId(eo.getApprUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbApprLetterTranHistExample eoToEntityExample(RbApprLetterTranHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetterTranHistExample example = new RbApprLetterTranHistExample();
        RbApprLetterTranHistExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getTraceId() != null) criteria.andTraceIdEqualTo(eo.getTraceId());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTerminalId() != null) criteria.andTerminalIdEqualTo(eo.getTerminalId());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getAcctDesc() != null) criteria.andAcctDescEqualTo(eo.getAcctDesc());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getPreviousBalAmt() != null) criteria.andPreviousBalAmtEqualTo(eo.getPreviousBalAmt());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getCrDrInd() != null) criteria.andCrDrIndEqualTo(eo.getCrDrInd().getValue());
        if (eo.getActualBal() != null) criteria.andActualBalEqualTo(eo.getActualBal());
        if (eo.getTranStatus() != null) criteria.andTranStatusEqualTo(eo.getTranStatus().getValue());
        if (eo.getReversalDate() != null) criteria.andReversalDateEqualTo(eo.getReversalDate());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getTranCategory() != null) criteria.andTranCategoryEqualTo(eo.getTranCategory().getValue());
        if (eo.getTranDesc() != null) criteria.andTranDescEqualTo(eo.getTranDesc());
        if (eo.getTranNote() != null) criteria.andTranNoteEqualTo(eo.getTranNote());
        if (eo.getCashItem() != null) criteria.andCashItemEqualTo(eo.getCashItem().getValue());
        if (eo.getOthInternalKey() != null) criteria.andOthInternalKeyEqualTo(eo.getOthInternalKey());
        if (eo.getOthBaseAcctNo() != null) criteria.andOthBaseAcctNoEqualTo(eo.getOthBaseAcctNo());
        if (eo.getOthProdType() != null) criteria.andOthProdTypeEqualTo(eo.getOthProdType());
        if (eo.getOthAcctCcy() != null) criteria.andOthAcctCcyEqualTo(eo.getOthAcctCcy().getValue());
        if (eo.getOthAcctSeqNo() != null) criteria.andOthAcctSeqNoEqualTo(eo.getOthAcctSeqNo());
        if (eo.getOthAcctDesc() != null) criteria.andOthAcctDescEqualTo(eo.getOthAcctDesc());
        if (eo.getOthBranch() != null) criteria.andOthBranchEqualTo(eo.getOthBranch().getValue());
        if (eo.getOthBankName() != null) criteria.andOthBankNameEqualTo(eo.getOthBankName());
        if (eo.getOthBankCode() != null) criteria.andOthBankCodeEqualTo(eo.getOthBankCode());
        if (eo.getApprLetterNo() != null) criteria.andApprLetterNoEqualTo(eo.getApprLetterNo());
        if (eo.getOthReference() != null) criteria.andOthReferenceEqualTo(eo.getOthReference());
        if (eo.getReversalTranType() != null) criteria.andReversalTranTypeEqualTo(eo.getReversalTranType().getValue());
        if (eo.getServCharge() != null) criteria.andServChargeEqualTo(eo.getServCharge().getValue());
        if (eo.getApprType() != null) criteria.andApprTypeEqualTo(eo.getApprType().getValue());
        if (eo.getPriority() != null) criteria.andPriorityEqualTo(eo.getPriority());
        if (eo.getOthSeqNo() != null) criteria.andOthSeqNoEqualTo(eo.getOthSeqNo());
        if (eo.getBankSeqNo() != null) criteria.andBankSeqNoEqualTo(eo.getBankSeqNo());
        if (eo.getGlCode() != null) criteria.andGlCodeEqualTo(eo.getGlCode());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getAuthUserId() != null) criteria.andAuthUserIdEqualTo(eo.getAuthUserId());
        if (eo.getApprUserId() != null) criteria.andApprUserIdEqualTo(eo.getApprUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}