package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.IaBatchOpenDetail;
import com.dcits.deposit.entity.IaBatchOpenDetailExample;
import com.dcits.deposit.facade.eo.IaBatchOpenDetailEO;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.Company;

public final class IaBatchOpenDetailValueUtil {
    private IaBatchOpenDetailValueUtil() {
    }

    public static IaBatchOpenDetailEO entityToEo(IaBatchOpenDetail entity) {
        if (entity == null) {
            return null;
        }
        IaBatchOpenDetailEO eo = new IaBatchOpenDetailEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setBatchNo(entity.getBatchNo());
        eo.setJobRunId(entity.getJobRunId());
        eo.setSpecAcctFlag(SpecAcctFlag.byValue(entity.getSpecAcctFlag()));
        eo.setSpecSeqNo(entity.getSpecSeqNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctName(entity.getAcctName());
        eo.setAcctBranch(AcctBranch.byValue(entity.getAcctBranch()));
        eo.setClientNo(entity.getClientNo());
        eo.setApprovalNo(entity.getApprovalNo());
        eo.setSubjectCode(entity.getSubjectCode());
        eo.setHangWriteOffFlag(IndividualFlag.byValue(entity.getHangWriteOffFlag()));
        eo.setHangTerm(entity.getHangTerm());
        eo.setOdFacility(IndividualFlag.byValue(entity.getOdFacility()));
        eo.setCounterCroBrchCretFlag(IndividualFlag.byValue(entity.getCounterCroBrchCretFlag()));
        eo.setCounterCroBrchDebtFlag(IndividualFlag.byValue(entity.getCounterCroBrchDebtFlag()));
        eo.setTranStatus(TranStatus.byValue(entity.getTranStatus()));
        eo.setTranDate(entity.getTranDate());
        eo.setErrorCode(entity.getErrorCode());
        eo.setErrorDesc(entity.getErrorDesc());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setBatchSeqNo(entity.getBatchSeqNo());
        eo.setReference(entity.getReference());
        return eo;
    }

    public static IaBatchOpenDetail eoToEntity(IaBatchOpenDetailEO eo) {
        if (eo == null) {
            return null;
        }
        IaBatchOpenDetail entity = new IaBatchOpenDetail();
        entity.setSeqNo(eo.getSeqNo());
        entity.setBatchNo(eo.getBatchNo());
        entity.setJobRunId(eo.getJobRunId());
        entity.setSpecAcctFlag(eo.getSpecAcctFlag() == null ? null : eo.getSpecAcctFlag().getValue());
        entity.setSpecSeqNo(eo.getSpecSeqNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctName(eo.getAcctName());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setApprovalNo(eo.getApprovalNo());
        entity.setSubjectCode(eo.getSubjectCode());
        entity.setHangWriteOffFlag(eo.getHangWriteOffFlag() == null ? null : eo.getHangWriteOffFlag().getValue());
        entity.setHangTerm(eo.getHangTerm());
        entity.setOdFacility(eo.getOdFacility() == null ? null : eo.getOdFacility().getValue());
        entity.setCounterCroBrchCretFlag(eo.getCounterCroBrchCretFlag() == null ? null : eo.getCounterCroBrchCretFlag().getValue());
        entity.setCounterCroBrchDebtFlag(eo.getCounterCroBrchDebtFlag() == null ? null : eo.getCounterCroBrchDebtFlag().getValue());
        entity.setTranStatus(eo.getTranStatus() == null ? null : eo.getTranStatus().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setErrorCode(eo.getErrorCode());
        entity.setErrorDesc(eo.getErrorDesc());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setBatchSeqNo(eo.getBatchSeqNo());
        entity.setReference(eo.getReference());
        return entity;
    }

    public static IaBatchOpenDetailExample eoToEntityExample(IaBatchOpenDetailEO eo) {
        if (eo == null) {
            return null;
        }
        IaBatchOpenDetailExample example = new IaBatchOpenDetailExample();
        IaBatchOpenDetailExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getBatchNo() != null) criteria.andBatchNoEqualTo(eo.getBatchNo());
        if (eo.getJobRunId() != null) criteria.andJobRunIdEqualTo(eo.getJobRunId());
        if (eo.getSpecAcctFlag() != null) criteria.andSpecAcctFlagEqualTo(eo.getSpecAcctFlag().getValue());
        if (eo.getSpecSeqNo() != null) criteria.andSpecSeqNoEqualTo(eo.getSpecSeqNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getApprovalNo() != null) criteria.andApprovalNoEqualTo(eo.getApprovalNo());
        if (eo.getSubjectCode() != null) criteria.andSubjectCodeEqualTo(eo.getSubjectCode());
        if (eo.getHangWriteOffFlag() != null) criteria.andHangWriteOffFlagEqualTo(eo.getHangWriteOffFlag().getValue());
        if (eo.getHangTerm() != null) criteria.andHangTermEqualTo(eo.getHangTerm());
        if (eo.getOdFacility() != null) criteria.andOdFacilityEqualTo(eo.getOdFacility().getValue());
        if (eo.getCounterCroBrchCretFlag() != null) criteria.andCounterCroBrchCretFlagEqualTo(eo.getCounterCroBrchCretFlag().getValue());
        if (eo.getCounterCroBrchDebtFlag() != null) criteria.andCounterCroBrchDebtFlagEqualTo(eo.getCounterCroBrchDebtFlag().getValue());
        if (eo.getTranStatus() != null) criteria.andTranStatusEqualTo(eo.getTranStatus().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getErrorCode() != null) criteria.andErrorCodeEqualTo(eo.getErrorCode());
        if (eo.getErrorDesc() != null) criteria.andErrorDescEqualTo(eo.getErrorDesc());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getBatchSeqNo() != null) criteria.andBatchSeqNoEqualTo(eo.getBatchSeqNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        return example;
    }
}