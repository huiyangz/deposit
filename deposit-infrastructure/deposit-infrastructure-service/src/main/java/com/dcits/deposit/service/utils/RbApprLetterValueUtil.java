package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbApprLetter;
import com.dcits.deposit.entity.RbApprLetterExample;
import com.dcits.deposit.facade.eo.RbApprLetterEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.Company;

public final class RbApprLetterValueUtil {
    private RbApprLetterValueUtil() {
    }

    public static RbApprLetterEO entityToEo(RbApprLetter entity) {
        if (entity == null) {
            return null;
        }
        RbApprLetterEO eo = new RbApprLetterEO();
        eo.setApprLetterNo(entity.getApprLetterNo());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setClientNo(entity.getClientNo());
        eo.setOpenDate(entity.getOpenDate());
        eo.setMaturityDate(entity.getMaturityDate());
        eo.setApprType(ApprType.byValue(entity.getApprType()));
        eo.setFundPurpose(entity.getFundPurpose());
        eo.setFundSource(FundSource.byValue(entity.getFundSource()));
        eo.setCapitalAmt(entity.getCapitalAmt());
        eo.setApprAcctInd(entity.getApprAcctInd());
        eo.setAcctType(AcctType.byValue(entity.getAcctType()));
        eo.setExpendScope(entity.getExpendScope());
        eo.setIncomeScope(entity.getIncomeScope());
        eo.setNarrative(entity.getNarrative());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setUserId(entity.getUserId());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setRemark(entity.getRemark());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbApprLetter eoToEntity(RbApprLetterEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetter entity = new RbApprLetter();
        entity.setApprLetterNo(eo.getApprLetterNo());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setOpenDate(eo.getOpenDate());
        entity.setMaturityDate(eo.getMaturityDate());
        entity.setApprType(eo.getApprType() == null ? null : eo.getApprType().getValue());
        entity.setFundPurpose(eo.getFundPurpose());
        entity.setFundSource(eo.getFundSource() == null ? null : eo.getFundSource().getValue());
        entity.setCapitalAmt(eo.getCapitalAmt());
        entity.setApprAcctInd(eo.getApprAcctInd());
        entity.setAcctType(eo.getAcctType() == null ? null : eo.getAcctType().getValue());
        entity.setExpendScope(eo.getExpendScope());
        entity.setIncomeScope(eo.getIncomeScope());
        entity.setNarrative(eo.getNarrative());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setUserId(eo.getUserId());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setRemark(eo.getRemark());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbApprLetterExample eoToEntityExample(RbApprLetterEO eo) {
        if (eo == null) {
            return null;
        }
        RbApprLetterExample example = new RbApprLetterExample();
        RbApprLetterExample.Criteria criteria = example.createCriteria();
        if (eo.getApprLetterNo() != null) criteria.andApprLetterNoEqualTo(eo.getApprLetterNo());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getOpenDate() != null) criteria.andOpenDateEqualTo(eo.getOpenDate());
        if (eo.getMaturityDate() != null) criteria.andMaturityDateEqualTo(eo.getMaturityDate());
        if (eo.getApprType() != null) criteria.andApprTypeEqualTo(eo.getApprType().getValue());
        if (eo.getFundPurpose() != null) criteria.andFundPurposeEqualTo(eo.getFundPurpose());
        if (eo.getFundSource() != null) criteria.andFundSourceEqualTo(eo.getFundSource().getValue());
        if (eo.getCapitalAmt() != null) criteria.andCapitalAmtEqualTo(eo.getCapitalAmt());
        if (eo.getApprAcctInd() != null) criteria.andApprAcctIndEqualTo(eo.getApprAcctInd());
        if (eo.getAcctType() != null) criteria.andAcctTypeEqualTo(eo.getAcctType().getValue());
        if (eo.getExpendScope() != null) criteria.andExpendScopeEqualTo(eo.getExpendScope());
        if (eo.getIncomeScope() != null) criteria.andIncomeScopeEqualTo(eo.getIncomeScope());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}