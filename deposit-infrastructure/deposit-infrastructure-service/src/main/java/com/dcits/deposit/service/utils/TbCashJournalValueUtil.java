package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.TbCashJournal;
import com.dcits.deposit.entity.TbCashJournalExample;
import com.dcits.deposit.facade.eo.TbCashJournalEO;
import com.dcits.deposit.enums.MoveType;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AcctBranch;

public final class TbCashJournalValueUtil {
    private TbCashJournalValueUtil() {
    }

    public static TbCashJournalEO entityToEo(TbCashJournal entity) {
        if (entity == null) {
            return null;
        }
        TbCashJournalEO eo = new TbCashJournalEO();
        eo.setJournalId(entity.getJournalId());
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setSubSeqNo(entity.getSubSeqNo());
        eo.setTaeSeqNo(entity.getTaeSeqNo());
        eo.setReference(entity.getReference());
        eo.setMoveId(entity.getMoveId());
        eo.setMoveType(MoveType.byValue(entity.getMoveType()));
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setUserId(entity.getUserId());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setSourceModule(SourceModule.byValue(entity.getSourceModule()));
        eo.setTailboxId(entity.getTailboxId());
        eo.setTailboxUserId(entity.getTailboxUserId());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setCashNum(entity.getCashNum());
        eo.setTranAmt(entity.getTranAmt());
        eo.setActualAmt(entity.getActualAmt());
        eo.setPayRec(PayRecInd.byValue(entity.getPayRec()));
        eo.setProgramId(entity.getProgramId());
        eo.setTranDesc(entity.getTranDesc());
        eo.setRemark(entity.getRemark());
        eo.setApprUserId(entity.getApprUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setReserveFlag(IndividualFlag.byValue(entity.getReserveFlag()));
        eo.setToBranch(AcctBranch.byValue(entity.getToBranch()));
        eo.setToUserId(entity.getToUserId());
        eo.setToTailboxId(entity.getToTailboxId());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static TbCashJournal eoToEntity(TbCashJournalEO eo) {
        if (eo == null) {
            return null;
        }
        TbCashJournal entity = new TbCashJournal();
        entity.setJournalId(eo.getJournalId());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setSubSeqNo(eo.getSubSeqNo());
        entity.setTaeSeqNo(eo.getTaeSeqNo());
        entity.setReference(eo.getReference());
        entity.setMoveId(eo.getMoveId());
        entity.setMoveType(eo.getMoveType() == null ? null : eo.getMoveType().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setUserId(eo.getUserId());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setSourceModule(eo.getSourceModule() == null ? null : eo.getSourceModule().getValue());
        entity.setTailboxId(eo.getTailboxId());
        entity.setTailboxUserId(eo.getTailboxUserId());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setCashNum(eo.getCashNum());
        entity.setTranAmt(eo.getTranAmt());
        entity.setActualAmt(eo.getActualAmt());
        entity.setPayRec(eo.getPayRec() == null ? null : eo.getPayRec().getValue());
        entity.setProgramId(eo.getProgramId());
        entity.setTranDesc(eo.getTranDesc());
        entity.setRemark(eo.getRemark());
        entity.setApprUserId(eo.getApprUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setReserveFlag(eo.getReserveFlag() == null ? null : eo.getReserveFlag().getValue());
        entity.setToBranch(eo.getToBranch() == null ? null : eo.getToBranch().getValue());
        entity.setToUserId(eo.getToUserId());
        entity.setToTailboxId(eo.getToTailboxId());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static TbCashJournalExample eoToEntityExample(TbCashJournalEO eo) {
        if (eo == null) {
            return null;
        }
        TbCashJournalExample example = new TbCashJournalExample();
        TbCashJournalExample.Criteria criteria = example.createCriteria();
        if (eo.getJournalId() != null) criteria.andJournalIdEqualTo(eo.getJournalId());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getSubSeqNo() != null) criteria.andSubSeqNoEqualTo(eo.getSubSeqNo());
        if (eo.getTaeSeqNo() != null) criteria.andTaeSeqNoEqualTo(eo.getTaeSeqNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getMoveId() != null) criteria.andMoveIdEqualTo(eo.getMoveId());
        if (eo.getMoveType() != null) criteria.andMoveTypeEqualTo(eo.getMoveType().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getSourceModule() != null) criteria.andSourceModuleEqualTo(eo.getSourceModule().getValue());
        if (eo.getTailboxId() != null) criteria.andTailboxIdEqualTo(eo.getTailboxId());
        if (eo.getTailboxUserId() != null) criteria.andTailboxUserIdEqualTo(eo.getTailboxUserId());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getCashNum() != null) criteria.andCashNumEqualTo(eo.getCashNum());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getActualAmt() != null) criteria.andActualAmtEqualTo(eo.getActualAmt());
        if (eo.getPayRec() != null) criteria.andPayRecEqualTo(eo.getPayRec().getValue());
        if (eo.getProgramId() != null) criteria.andProgramIdEqualTo(eo.getProgramId());
        if (eo.getTranDesc() != null) criteria.andTranDescEqualTo(eo.getTranDesc());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getApprUserId() != null) criteria.andApprUserIdEqualTo(eo.getApprUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getReserveFlag() != null) criteria.andReserveFlagEqualTo(eo.getReserveFlag().getValue());
        if (eo.getToBranch() != null) criteria.andToBranchEqualTo(eo.getToBranch().getValue());
        if (eo.getToUserId() != null) criteria.andToUserIdEqualTo(eo.getToUserId());
        if (eo.getToTailboxId() != null) criteria.andToTailboxIdEqualTo(eo.getToTailboxId());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}