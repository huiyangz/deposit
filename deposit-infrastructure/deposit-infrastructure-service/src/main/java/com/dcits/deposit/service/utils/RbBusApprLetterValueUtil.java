package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusApprLetter;
import com.dcits.deposit.entity.RbBusApprLetterExample;
import com.dcits.deposit.facade.eo.RbBusApprLetterEO;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.TranBranch;

public final class RbBusApprLetterValueUtil {
    private RbBusApprLetterValueUtil() {
    }

    public static RbBusApprLetterEO entityToEo(RbBusApprLetter entity) {
        if (entity == null) {
            return null;
        }
        RbBusApprLetterEO eo = new RbBusApprLetterEO();
        eo.setIncomeScope(entity.getIncomeScope());
        eo.setNarrative(entity.getNarrative());
        eo.setApprAcctInd(entity.getApprAcctInd());
        eo.setOpenDate(entity.getOpenDate());
        eo.setFundSource(FundSource.byValue(entity.getFundSource()));
        eo.setExpendScope(entity.getExpendScope());
        eo.setRbAcctType(RbAcctType.byValue(entity.getRbAcctType()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setApprType(ApprType.byValue(entity.getApprType()));
        eo.setApprLetterNo(entity.getApprLetterNo());
        eo.setFundPurpose(entity.getFundPurpose());
        eo.setCapitalAmt(entity.getCapitalAmt());
        eo.setTranBranch(TranBranch.byValue(entity.getTranBranch()));
        eo.setClientNo(entity.getClientNo());
        eo.setMaturityDate(entity.getMaturityDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbBusApprLetter eoToEntity(RbBusApprLetterEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusApprLetter entity = new RbBusApprLetter();
        entity.setIncomeScope(eo.getIncomeScope());
        entity.setNarrative(eo.getNarrative());
        entity.setApprAcctInd(eo.getApprAcctInd());
        entity.setOpenDate(eo.getOpenDate());
        entity.setFundSource(eo.getFundSource() == null ? null : eo.getFundSource().getValue());
        entity.setExpendScope(eo.getExpendScope());
        entity.setRbAcctType(eo.getRbAcctType() == null ? null : eo.getRbAcctType().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setApprType(eo.getApprType() == null ? null : eo.getApprType().getValue());
        entity.setApprLetterNo(eo.getApprLetterNo());
        entity.setFundPurpose(eo.getFundPurpose());
        entity.setCapitalAmt(eo.getCapitalAmt());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setMaturityDate(eo.getMaturityDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbBusApprLetterExample eoToEntityExample(RbBusApprLetterEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusApprLetterExample example = new RbBusApprLetterExample();
        RbBusApprLetterExample.Criteria criteria = example.createCriteria();
        if (eo.getIncomeScope() != null) criteria.andIncomeScopeEqualTo(eo.getIncomeScope());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getApprAcctInd() != null) criteria.andApprAcctIndEqualTo(eo.getApprAcctInd());
        if (eo.getOpenDate() != null) criteria.andOpenDateEqualTo(eo.getOpenDate());
        if (eo.getFundSource() != null) criteria.andFundSourceEqualTo(eo.getFundSource().getValue());
        if (eo.getExpendScope() != null) criteria.andExpendScopeEqualTo(eo.getExpendScope());
        if (eo.getRbAcctType() != null) criteria.andRbAcctTypeEqualTo(eo.getRbAcctType().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getApprType() != null) criteria.andApprTypeEqualTo(eo.getApprType().getValue());
        if (eo.getApprLetterNo() != null) criteria.andApprLetterNoEqualTo(eo.getApprLetterNo());
        if (eo.getFundPurpose() != null) criteria.andFundPurposeEqualTo(eo.getFundPurpose());
        if (eo.getCapitalAmt() != null) criteria.andCapitalAmtEqualTo(eo.getCapitalAmt());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getMaturityDate() != null) criteria.andMaturityDateEqualTo(eo.getMaturityDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}