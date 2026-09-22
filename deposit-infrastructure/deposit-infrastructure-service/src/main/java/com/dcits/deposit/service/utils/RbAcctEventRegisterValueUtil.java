package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctEventRegister;
import com.dcits.deposit.entity.RbAcctEventRegisterExample;
import com.dcits.deposit.facade.eo.RbAcctEventRegisterEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.YearBasis;

public final class RbAcctEventRegisterValueUtil {
    private RbAcctEventRegisterValueUtil() {
    }

    public static RbAcctEventRegisterEO entityToEo(RbAcctEventRegister entity) {
        if (entity == null) {
            return null;
        }
        RbAcctEventRegisterEO eo = new RbAcctEventRegisterEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setInternalKey(entity.getInternalKey());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctBranch(AcctBranch.byValue(entity.getAcctBranch()));
        eo.setAcctOpenDate(entity.getAcctOpenDate());
        eo.setClientNo(entity.getClientNo());
        eo.setClientType(ClientType.byValue(entity.getClientType()));
        eo.setMovtStatus(MovtStatus.byValue(entity.getMovtStatus()));
        eo.setIntClass(IntClass.byValue(entity.getIntClass()));
        eo.setIntType(IntType.byValue(entity.getIntType()));
        eo.setActualRate(entity.getActualRate());
        eo.setFloatRate(entity.getFloatRate());
        eo.setSpreadRate(entity.getSpreadRate());
        eo.setRealRate(entity.getRealRate());
        eo.setIntAdj(entity.getIntAdj());
        eo.setIntAdjCtd(entity.getIntAdjCtd());
        eo.setAcctLevelIntRate(entity.getAcctLevelIntRate());
        eo.setGrossInterestAmt(entity.getGrossInterestAmt());
        eo.setCalcIntAmt(entity.getCalcIntAmt());
        eo.setLastCycleDate(entity.getLastCycleDate());
        eo.setIntCapFlag(IndividualFlag.byValue(entity.getIntCapFlag()));
        eo.setTerm(entity.getTerm());
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setMaturityDate(entity.getMaturityDate());
        eo.setAmtType(AmtType.byValue(entity.getAmtType()));
        eo.setPrincipalAmt(entity.getPrincipalAmt());
        eo.setTranAmt(entity.getTranAmt());
        eo.setDebtIntRate(entity.getDebtIntRate());
        eo.setNetInterestAmt(entity.getNetInterestAmt());
        eo.setCalcDays(entity.getCalcDays());
        eo.setTaxRate(entity.getTaxRate());
        eo.setTaxType(TaxType.byValue(entity.getTaxType()));
        eo.setTaxAmt(entity.getTaxAmt());
        eo.setReference(entity.getReference());
        eo.setGlPostedFlag(IndividualFlag.byValue(entity.getGlPostedFlag()));
        eo.setReversalDate(entity.getReversalDate());
        eo.setNarrative(entity.getNarrative());
        eo.setSourceModule(SourceModule.byValue(entity.getSourceModule()));
        eo.setTranStatus(TranStatus.byValue(entity.getTranStatus()));
        eo.setPrintCnt(entity.getPrintCnt());
        eo.setUserId(entity.getUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setBusSeqNo(entity.getBusSeqNo());
        eo.setCalcBeginDate(entity.getCalcBeginDate());
        eo.setMonthBasis(MonthBasis.byValue(entity.getMonthBasis()));
        eo.setYearBasis(YearBasis.byValue(entity.getYearBasis()));
        eo.setReaccountCd(entity.getReaccountCd());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbAcctEventRegister eoToEntity(RbAcctEventRegisterEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctEventRegister entity = new RbAcctEventRegister();
        entity.setSeqNo(eo.getSeqNo());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setInternalKey(eo.getInternalKey());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setAcctOpenDate(eo.getAcctOpenDate());
        entity.setClientNo(eo.getClientNo());
        entity.setClientType(eo.getClientType() == null ? null : eo.getClientType().getValue());
        entity.setMovtStatus(eo.getMovtStatus() == null ? null : eo.getMovtStatus().getValue());
        entity.setIntClass(eo.getIntClass() == null ? null : eo.getIntClass().getValue());
        entity.setIntType(eo.getIntType() == null ? null : eo.getIntType().getValue());
        entity.setActualRate(eo.getActualRate());
        entity.setFloatRate(eo.getFloatRate());
        entity.setSpreadRate(eo.getSpreadRate());
        entity.setRealRate(eo.getRealRate());
        entity.setIntAdj(eo.getIntAdj());
        entity.setIntAdjCtd(eo.getIntAdjCtd());
        entity.setAcctLevelIntRate(eo.getAcctLevelIntRate());
        entity.setGrossInterestAmt(eo.getGrossInterestAmt());
        entity.setCalcIntAmt(eo.getCalcIntAmt());
        entity.setLastCycleDate(eo.getLastCycleDate());
        entity.setIntCapFlag(eo.getIntCapFlag() == null ? null : eo.getIntCapFlag().getValue());
        entity.setTerm(eo.getTerm());
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setMaturityDate(eo.getMaturityDate());
        entity.setAmtType(eo.getAmtType() == null ? null : eo.getAmtType().getValue());
        entity.setPrincipalAmt(eo.getPrincipalAmt());
        entity.setTranAmt(eo.getTranAmt());
        entity.setDebtIntRate(eo.getDebtIntRate());
        entity.setNetInterestAmt(eo.getNetInterestAmt());
        entity.setCalcDays(eo.getCalcDays());
        entity.setTaxRate(eo.getTaxRate());
        entity.setTaxType(eo.getTaxType() == null ? null : eo.getTaxType().getValue());
        entity.setTaxAmt(eo.getTaxAmt());
        entity.setReference(eo.getReference());
        entity.setGlPostedFlag(eo.getGlPostedFlag() == null ? null : eo.getGlPostedFlag().getValue());
        entity.setReversalDate(eo.getReversalDate());
        entity.setNarrative(eo.getNarrative());
        entity.setSourceModule(eo.getSourceModule() == null ? null : eo.getSourceModule().getValue());
        entity.setTranStatus(eo.getTranStatus() == null ? null : eo.getTranStatus().getValue());
        entity.setPrintCnt(eo.getPrintCnt());
        entity.setUserId(eo.getUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setBusSeqNo(eo.getBusSeqNo());
        entity.setCalcBeginDate(eo.getCalcBeginDate());
        entity.setMonthBasis(eo.getMonthBasis() == null ? null : eo.getMonthBasis().getValue());
        entity.setYearBasis(eo.getYearBasis() == null ? null : eo.getYearBasis().getValue());
        entity.setReaccountCd(eo.getReaccountCd());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbAcctEventRegisterExample eoToEntityExample(RbAcctEventRegisterEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctEventRegisterExample example = new RbAcctEventRegisterExample();
        RbAcctEventRegisterExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getAcctOpenDate() != null) criteria.andAcctOpenDateEqualTo(eo.getAcctOpenDate());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getClientType() != null) criteria.andClientTypeEqualTo(eo.getClientType().getValue());
        if (eo.getMovtStatus() != null) criteria.andMovtStatusEqualTo(eo.getMovtStatus().getValue());
        if (eo.getIntClass() != null) criteria.andIntClassEqualTo(eo.getIntClass().getValue());
        if (eo.getIntType() != null) criteria.andIntTypeEqualTo(eo.getIntType().getValue());
        if (eo.getActualRate() != null) criteria.andActualRateEqualTo(eo.getActualRate());
        if (eo.getFloatRate() != null) criteria.andFloatRateEqualTo(eo.getFloatRate());
        if (eo.getSpreadRate() != null) criteria.andSpreadRateEqualTo(eo.getSpreadRate());
        if (eo.getRealRate() != null) criteria.andRealRateEqualTo(eo.getRealRate());
        if (eo.getIntAdj() != null) criteria.andIntAdjEqualTo(eo.getIntAdj());
        if (eo.getIntAdjCtd() != null) criteria.andIntAdjCtdEqualTo(eo.getIntAdjCtd());
        if (eo.getAcctLevelIntRate() != null) criteria.andAcctLevelIntRateEqualTo(eo.getAcctLevelIntRate());
        if (eo.getGrossInterestAmt() != null) criteria.andGrossInterestAmtEqualTo(eo.getGrossInterestAmt());
        if (eo.getCalcIntAmt() != null) criteria.andCalcIntAmtEqualTo(eo.getCalcIntAmt());
        if (eo.getLastCycleDate() != null) criteria.andLastCycleDateEqualTo(eo.getLastCycleDate());
        if (eo.getIntCapFlag() != null) criteria.andIntCapFlagEqualTo(eo.getIntCapFlag().getValue());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getMaturityDate() != null) criteria.andMaturityDateEqualTo(eo.getMaturityDate());
        if (eo.getAmtType() != null) criteria.andAmtTypeEqualTo(eo.getAmtType().getValue());
        if (eo.getPrincipalAmt() != null) criteria.andPrincipalAmtEqualTo(eo.getPrincipalAmt());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getDebtIntRate() != null) criteria.andDebtIntRateEqualTo(eo.getDebtIntRate());
        if (eo.getNetInterestAmt() != null) criteria.andNetInterestAmtEqualTo(eo.getNetInterestAmt());
        if (eo.getCalcDays() != null) criteria.andCalcDaysEqualTo(eo.getCalcDays());
        if (eo.getTaxRate() != null) criteria.andTaxRateEqualTo(eo.getTaxRate());
        if (eo.getTaxType() != null) criteria.andTaxTypeEqualTo(eo.getTaxType().getValue());
        if (eo.getTaxAmt() != null) criteria.andTaxAmtEqualTo(eo.getTaxAmt());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getGlPostedFlag() != null) criteria.andGlPostedFlagEqualTo(eo.getGlPostedFlag().getValue());
        if (eo.getReversalDate() != null) criteria.andReversalDateEqualTo(eo.getReversalDate());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getSourceModule() != null) criteria.andSourceModuleEqualTo(eo.getSourceModule().getValue());
        if (eo.getTranStatus() != null) criteria.andTranStatusEqualTo(eo.getTranStatus().getValue());
        if (eo.getPrintCnt() != null) criteria.andPrintCntEqualTo(eo.getPrintCnt());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getBusSeqNo() != null) criteria.andBusSeqNoEqualTo(eo.getBusSeqNo());
        if (eo.getCalcBeginDate() != null) criteria.andCalcBeginDateEqualTo(eo.getCalcBeginDate());
        if (eo.getMonthBasis() != null) criteria.andMonthBasisEqualTo(eo.getMonthBasis().getValue());
        if (eo.getYearBasis() != null) criteria.andYearBasisEqualTo(eo.getYearBasis().getValue());
        if (eo.getReaccountCd() != null) criteria.andReaccountCdEqualTo(eo.getReaccountCd());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}