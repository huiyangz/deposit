package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbVoucherJournal;
import com.dcits.deposit.entity.RbVoucherJournalExample;
import com.dcits.deposit.facade.eo.RbVoucherJournalEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.AcctBranch;

public final class RbVoucherJournalValueUtil {
    private RbVoucherJournalValueUtil() {
    }

    public static RbVoucherJournalEO entityToEo(RbVoucherJournal entity) {
        if (entity == null) {
            return null;
        }
        RbVoucherJournalEO eo = new RbVoucherJournalEO();
        eo.setCheckUserId(entity.getCheckUserId());
        eo.setVoucherJournalId(entity.getVoucherJournalId());
        eo.setClientNo(entity.getClientNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setCardNo(entity.getCardNo());
        eo.setAmount(entity.getAmount());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setPrefix(entity.getPrefix());
        eo.setVoucherNo(entity.getVoucherNo());
        eo.setVoucherStatus(VoucherStatus.byValue(entity.getVoucherStatus()));
        eo.setOldStatus(VoucherStatus.byValue(entity.getOldStatus()));
        eo.setReference(entity.getReference());
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setTranDesc(entity.getTranDesc());
        eo.setModuleId(SourceModule.byValue(entity.getModuleId()));
        eo.setProgramId(entity.getProgramId());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setUserId(entity.getUserId());
        eo.setTranDate(entity.getTranDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setRemark(entity.getRemark());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCanReasonCode(CanReasonCode.byValue(entity.getCanReasonCode()));
        eo.setBillDate(entity.getBillDate());
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbVoucherJournal eoToEntity(RbVoucherJournalEO eo) {
        if (eo == null) {
            return null;
        }
        RbVoucherJournal entity = new RbVoucherJournal();
        entity.setCheckUserId(eo.getCheckUserId());
        entity.setVoucherJournalId(eo.getVoucherJournalId());
        entity.setClientNo(eo.getClientNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setCardNo(eo.getCardNo());
        entity.setAmount(eo.getAmount());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setPrefix(eo.getPrefix());
        entity.setVoucherNo(eo.getVoucherNo());
        entity.setVoucherStatus(eo.getVoucherStatus() == null ? null : eo.getVoucherStatus().getValue());
        entity.setOldStatus(eo.getOldStatus() == null ? null : eo.getOldStatus().getValue());
        entity.setReference(eo.getReference());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setTranDesc(eo.getTranDesc());
        entity.setModuleId(eo.getModuleId() == null ? null : eo.getModuleId().getValue());
        entity.setProgramId(eo.getProgramId());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setUserId(eo.getUserId());
        entity.setTranDate(eo.getTranDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setRemark(eo.getRemark());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCanReasonCode(eo.getCanReasonCode() == null ? null : eo.getCanReasonCode().getValue());
        entity.setBillDate(eo.getBillDate());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbVoucherJournalExample eoToEntityExample(RbVoucherJournalEO eo) {
        if (eo == null) {
            return null;
        }
        RbVoucherJournalExample example = new RbVoucherJournalExample();
        RbVoucherJournalExample.Criteria criteria = example.createCriteria();
        if (eo.getCheckUserId() != null) criteria.andCheckUserIdEqualTo(eo.getCheckUserId());
        if (eo.getVoucherJournalId() != null) criteria.andVoucherJournalIdEqualTo(eo.getVoucherJournalId());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getCardNo() != null) criteria.andCardNoEqualTo(eo.getCardNo());
        if (eo.getAmount() != null) criteria.andAmountEqualTo(eo.getAmount());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getVoucherNo() != null) criteria.andVoucherNoEqualTo(eo.getVoucherNo());
        if (eo.getVoucherStatus() != null) criteria.andVoucherStatusEqualTo(eo.getVoucherStatus().getValue());
        if (eo.getOldStatus() != null) criteria.andOldStatusEqualTo(eo.getOldStatus().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getTranDesc() != null) criteria.andTranDescEqualTo(eo.getTranDesc());
        if (eo.getModuleId() != null) criteria.andModuleIdEqualTo(eo.getModuleId().getValue());
        if (eo.getProgramId() != null) criteria.andProgramIdEqualTo(eo.getProgramId());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCanReasonCode() != null) criteria.andCanReasonCodeEqualTo(eo.getCanReasonCode().getValue());
        if (eo.getBillDate() != null) criteria.andBillDateEqualTo(eo.getBillDate());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}