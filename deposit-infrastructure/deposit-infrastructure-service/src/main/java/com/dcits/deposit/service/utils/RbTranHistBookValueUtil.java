package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbTranHistBook;
import com.dcits.deposit.entity.RbTranHistBookExample;
import com.dcits.deposit.facade.eo.RbTranHistBookEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;

public final class RbTranHistBookValueUtil {
    private RbTranHistBookValueUtil() {
    }

    public static RbTranHistBookEO entityToEo(RbTranHistBook entity) {
        if (entity == null) {
            return null;
        }
        RbTranHistBookEO eo = new RbTranHistBookEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setInternalKey(entity.getInternalKey());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setProdType(entity.getProdType());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setClientNo(entity.getClientNo());
        eo.setReference(entity.getReference());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setTranDate(entity.getTranDate());
        eo.setEventType(entity.getEventType());
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setCrDrInd(CrDrInd.byValue(entity.getCrDrInd()));
        eo.setTranAmt(entity.getTranAmt());
        eo.setPreviousBalAmt(entity.getPreviousBalAmt());
        eo.setActualBal(entity.getActualBal());
        eo.setTranStatus(TranStatus.byValue(entity.getTranStatus()));
        eo.setTranDesc(entity.getTranDesc());
        eo.setTranNote(entity.getTranNote());
        eo.setBookPrintFlag(IndividualFlag.byValue(entity.getBookPrintFlag()));
        eo.setBalType(BalType.byValue(entity.getBalType()));
        eo.setReversal(IndividualFlag.byValue(entity.getReversal()));
        eo.setNarrative(entity.getNarrative());
        eo.setEffectDate(entity.getEffectDate());
        eo.setOrigTranTimestamp(entity.getOrigTranTimestamp());
        eo.setUserId(entity.getUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbTranHistBook eoToEntity(RbTranHistBookEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranHistBook entity = new RbTranHistBook();
        entity.setSeqNo(eo.getSeqNo());
        entity.setInternalKey(eo.getInternalKey());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setProdType(eo.getProdType());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setClientNo(eo.getClientNo());
        entity.setReference(eo.getReference());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setEventType(eo.getEventType());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setCrDrInd(eo.getCrDrInd() == null ? null : eo.getCrDrInd().getValue());
        entity.setTranAmt(eo.getTranAmt());
        entity.setPreviousBalAmt(eo.getPreviousBalAmt());
        entity.setActualBal(eo.getActualBal());
        entity.setTranStatus(eo.getTranStatus() == null ? null : eo.getTranStatus().getValue());
        entity.setTranDesc(eo.getTranDesc());
        entity.setTranNote(eo.getTranNote());
        entity.setBookPrintFlag(eo.getBookPrintFlag() == null ? null : eo.getBookPrintFlag().getValue());
        entity.setBalType(eo.getBalType() == null ? null : eo.getBalType().getValue());
        entity.setReversal(eo.getReversal() == null ? null : eo.getReversal().getValue());
        entity.setNarrative(eo.getNarrative());
        entity.setEffectDate(eo.getEffectDate());
        entity.setOrigTranTimestamp(eo.getOrigTranTimestamp());
        entity.setUserId(eo.getUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbTranHistBookExample eoToEntityExample(RbTranHistBookEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranHistBookExample example = new RbTranHistBookExample();
        RbTranHistBookExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getCrDrInd() != null) criteria.andCrDrIndEqualTo(eo.getCrDrInd().getValue());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getPreviousBalAmt() != null) criteria.andPreviousBalAmtEqualTo(eo.getPreviousBalAmt());
        if (eo.getActualBal() != null) criteria.andActualBalEqualTo(eo.getActualBal());
        if (eo.getTranStatus() != null) criteria.andTranStatusEqualTo(eo.getTranStatus().getValue());
        if (eo.getTranDesc() != null) criteria.andTranDescEqualTo(eo.getTranDesc());
        if (eo.getTranNote() != null) criteria.andTranNoteEqualTo(eo.getTranNote());
        if (eo.getBookPrintFlag() != null) criteria.andBookPrintFlagEqualTo(eo.getBookPrintFlag().getValue());
        if (eo.getBalType() != null) criteria.andBalTypeEqualTo(eo.getBalType().getValue());
        if (eo.getReversal() != null) criteria.andReversalEqualTo(eo.getReversal().getValue());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getOrigTranTimestamp() != null) criteria.andOrigTranTimestampEqualTo(eo.getOrigTranTimestamp());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}