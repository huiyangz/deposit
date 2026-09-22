package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbTdaHist;
import com.dcits.deposit.entity.RbTdaHistExample;
import com.dcits.deposit.facade.eo.RbTdaHistEO;
import com.dcits.deposit.enums.MovtStatus;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;

public final class RbTdaHistValueUtil {
    private RbTdaHistValueUtil() {
    }

    public static RbTdaHistEO entityToEo(RbTdaHist entity) {
        if (entity == null) {
            return null;
        }
        RbTdaHistEO eo = new RbTdaHistEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setInternalKey(entity.getInternalKey());
        eo.setClientNo(entity.getClientNo());
        eo.setAcctOpenDate(entity.getAcctOpenDate());
        eo.setMaturityDate(entity.getMaturityDate());
        eo.setAcctMovtDate(entity.getAcctMovtDate());
        eo.setMovtStatus(MovtStatus.byValue(entity.getMovtStatus()));
        eo.setAddTerm(entity.getAddTerm());
        eo.setTerm(entity.getTerm());
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setAutoRenewRollover(AutoRenewRollover.byValue(entity.getAutoRenewRollover()));
        eo.setPartialRenewRoll(IndividualFlag.byValue(entity.getPartialRenewRoll()));
        eo.setPartialRenewAmt(entity.getPartialRenewAmt());
        eo.setAddtlPrincipal(IndividualFlag.byValue(entity.getAddtlPrincipal()));
        eo.setRolloverNo(entity.getRolloverNo());
        eo.setRenewNo(entity.getRenewNo());
        eo.setTdaStatus(entity.getTdaStatus());
        eo.setRenewTimes(entity.getRenewTimes());
        eo.setRevSeqNo(entity.getRevSeqNo());
        eo.setTranSeqNo(entity.getTranSeqNo());
        eo.setTdaCertificateNo(entity.getTdaCertificateNo());
        eo.setAcctLevelIntRate(entity.getAcctLevelIntRate());
        eo.setLostNo(entity.getLostNo());
        eo.setReference(entity.getReference());
        eo.setTaxAmt(entity.getTaxAmt());
        eo.setDebtAmt(entity.getDebtAmt());
        eo.setPrincipalAmt(entity.getPrincipalAmt());
        eo.setPrincipalAmtActual(entity.getPrincipalAmtActual());
        eo.setGrossInterestAmt(entity.getGrossInterestAmt());
        eo.setIntAdj(entity.getIntAdj());
        eo.setIntAdjCtd(entity.getIntAdjCtd());
        eo.setNetInterestAmt(entity.getNetInterestAmt());
        eo.setSpreadRate(entity.getSpreadRate());
        eo.setDebtIntRate(entity.getDebtIntRate());
        eo.setTranScene(entity.getTranScene());
        eo.setUserId(entity.getUserId());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbTdaHist eoToEntity(RbTdaHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbTdaHist entity = new RbTdaHist();
        entity.setSeqNo(eo.getSeqNo());
        entity.setInternalKey(eo.getInternalKey());
        entity.setClientNo(eo.getClientNo());
        entity.setAcctOpenDate(eo.getAcctOpenDate());
        entity.setMaturityDate(eo.getMaturityDate());
        entity.setAcctMovtDate(eo.getAcctMovtDate());
        entity.setMovtStatus(eo.getMovtStatus() == null ? null : eo.getMovtStatus().getValue());
        entity.setAddTerm(eo.getAddTerm());
        entity.setTerm(eo.getTerm());
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setAutoRenewRollover(eo.getAutoRenewRollover() == null ? null : eo.getAutoRenewRollover().getValue());
        entity.setPartialRenewRoll(eo.getPartialRenewRoll() == null ? null : eo.getPartialRenewRoll().getValue());
        entity.setPartialRenewAmt(eo.getPartialRenewAmt());
        entity.setAddtlPrincipal(eo.getAddtlPrincipal() == null ? null : eo.getAddtlPrincipal().getValue());
        entity.setRolloverNo(eo.getRolloverNo());
        entity.setRenewNo(eo.getRenewNo());
        entity.setTdaStatus(eo.getTdaStatus());
        entity.setRenewTimes(eo.getRenewTimes());
        entity.setRevSeqNo(eo.getRevSeqNo());
        entity.setTranSeqNo(eo.getTranSeqNo());
        entity.setTdaCertificateNo(eo.getTdaCertificateNo());
        entity.setAcctLevelIntRate(eo.getAcctLevelIntRate());
        entity.setLostNo(eo.getLostNo());
        entity.setReference(eo.getReference());
        entity.setTaxAmt(eo.getTaxAmt());
        entity.setDebtAmt(eo.getDebtAmt());
        entity.setPrincipalAmt(eo.getPrincipalAmt());
        entity.setPrincipalAmtActual(eo.getPrincipalAmtActual());
        entity.setGrossInterestAmt(eo.getGrossInterestAmt());
        entity.setIntAdj(eo.getIntAdj());
        entity.setIntAdjCtd(eo.getIntAdjCtd());
        entity.setNetInterestAmt(eo.getNetInterestAmt());
        entity.setSpreadRate(eo.getSpreadRate());
        entity.setDebtIntRate(eo.getDebtIntRate());
        entity.setTranScene(eo.getTranScene());
        entity.setUserId(eo.getUserId());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbTdaHistExample eoToEntityExample(RbTdaHistEO eo) {
        if (eo == null) {
            return null;
        }
        RbTdaHistExample example = new RbTdaHistExample();
        RbTdaHistExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getAcctOpenDate() != null) criteria.andAcctOpenDateEqualTo(eo.getAcctOpenDate());
        if (eo.getMaturityDate() != null) criteria.andMaturityDateEqualTo(eo.getMaturityDate());
        if (eo.getAcctMovtDate() != null) criteria.andAcctMovtDateEqualTo(eo.getAcctMovtDate());
        if (eo.getMovtStatus() != null) criteria.andMovtStatusEqualTo(eo.getMovtStatus().getValue());
        if (eo.getAddTerm() != null) criteria.andAddTermEqualTo(eo.getAddTerm());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getAutoRenewRollover() != null) criteria.andAutoRenewRolloverEqualTo(eo.getAutoRenewRollover().getValue());
        if (eo.getPartialRenewRoll() != null) criteria.andPartialRenewRollEqualTo(eo.getPartialRenewRoll().getValue());
        if (eo.getPartialRenewAmt() != null) criteria.andPartialRenewAmtEqualTo(eo.getPartialRenewAmt());
        if (eo.getAddtlPrincipal() != null) criteria.andAddtlPrincipalEqualTo(eo.getAddtlPrincipal().getValue());
        if (eo.getRolloverNo() != null) criteria.andRolloverNoEqualTo(eo.getRolloverNo());
        if (eo.getRenewNo() != null) criteria.andRenewNoEqualTo(eo.getRenewNo());
        if (eo.getTdaStatus() != null) criteria.andTdaStatusEqualTo(eo.getTdaStatus());
        if (eo.getRenewTimes() != null) criteria.andRenewTimesEqualTo(eo.getRenewTimes());
        if (eo.getRevSeqNo() != null) criteria.andRevSeqNoEqualTo(eo.getRevSeqNo());
        if (eo.getTranSeqNo() != null) criteria.andTranSeqNoEqualTo(eo.getTranSeqNo());
        if (eo.getTdaCertificateNo() != null) criteria.andTdaCertificateNoEqualTo(eo.getTdaCertificateNo());
        if (eo.getAcctLevelIntRate() != null) criteria.andAcctLevelIntRateEqualTo(eo.getAcctLevelIntRate());
        if (eo.getLostNo() != null) criteria.andLostNoEqualTo(eo.getLostNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getTaxAmt() != null) criteria.andTaxAmtEqualTo(eo.getTaxAmt());
        if (eo.getDebtAmt() != null) criteria.andDebtAmtEqualTo(eo.getDebtAmt());
        if (eo.getPrincipalAmt() != null) criteria.andPrincipalAmtEqualTo(eo.getPrincipalAmt());
        if (eo.getPrincipalAmtActual() != null) criteria.andPrincipalAmtActualEqualTo(eo.getPrincipalAmtActual());
        if (eo.getGrossInterestAmt() != null) criteria.andGrossInterestAmtEqualTo(eo.getGrossInterestAmt());
        if (eo.getIntAdj() != null) criteria.andIntAdjEqualTo(eo.getIntAdj());
        if (eo.getIntAdjCtd() != null) criteria.andIntAdjCtdEqualTo(eo.getIntAdjCtd());
        if (eo.getNetInterestAmt() != null) criteria.andNetInterestAmtEqualTo(eo.getNetInterestAmt());
        if (eo.getSpreadRate() != null) criteria.andSpreadRateEqualTo(eo.getSpreadRate());
        if (eo.getDebtIntRate() != null) criteria.andDebtIntRateEqualTo(eo.getDebtIntRate());
        if (eo.getTranScene() != null) criteria.andTranSceneEqualTo(eo.getTranScene());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}