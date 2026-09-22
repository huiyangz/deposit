package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctDossReg;
import com.dcits.deposit.entity.RbAcctDossRegExample;
import com.dcits.deposit.facade.eo.RbAcctDossRegEO;
import com.dcits.deposit.enums.DossOperateType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.DossStatus;
import com.dcits.deposit.enums.DossStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ToAcctType;
import com.dcits.deposit.enums.ToBankInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;

public final class RbAcctDossRegValueUtil {
    private RbAcctDossRegValueUtil() {
    }

    public static RbAcctDossRegEO entityToEo(RbAcctDossReg entity) {
        if (entity == null) {
            return null;
        }
        RbAcctDossRegEO eo = new RbAcctDossRegEO();
        eo.setDossOperateType(DossOperateType.byValue(entity.getDossOperateType()));
        eo.setBatchNo(entity.getBatchNo());
        eo.setHandFlag(IndividualFlag.byValue(entity.getHandFlag()));
        eo.setInternalKey(entity.getInternalKey());
        eo.setClientNo(entity.getClientNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctName(entity.getAcctName());
        eo.setIndividualFlag(IndividualFlag.byValue(entity.getIndividualFlag()));
        eo.setAmtType(AmtType.byValue(entity.getAmtType()));
        eo.setBalance(entity.getBalance());
        eo.setIntAmt(entity.getIntAmt());
        eo.setPorIntTot(entity.getPorIntTot());
        eo.setTranAmt(entity.getTranAmt());
        eo.setRecordAmt(entity.getRecordAmt());
        eo.setTaxSc(entity.getTaxSc());
        eo.setDossStatus(DossStatus.byValue(entity.getDossStatus()));
        eo.setPrevDossStatus(DossStatus.byValue(entity.getPrevDossStatus()));
        eo.setDossDate(entity.getDossDate());
        eo.setDossBranch(AcctBranch.byValue(entity.getDossBranch()));
        eo.setDossUserId(entity.getDossUserId());
        eo.setTodossReason(entity.getTodossReason());
        eo.setActiveDate(entity.getActiveDate());
        eo.setActiveBranch(AcctBranch.byValue(entity.getActiveBranch()));
        eo.setActiveUserId(entity.getActiveUserId());
        eo.setOutBusiDate(entity.getOutBusiDate());
        eo.setOutBusiUserId(entity.getOutBusiUserId());
        eo.setWithdrawalDate(entity.getWithdrawalDate());
        eo.setWithdrawalBranch(AcctBranch.byValue(entity.getWithdrawalBranch()));
        eo.setWithdrawalUserId(entity.getWithdrawalUserId());
        eo.setWithdrawalReason(entity.getWithdrawalReason());
        eo.setToBaseAcctNo(entity.getToBaseAcctNo());
        eo.setToCcy(AcctCcy.byValue(entity.getToCcy()));
        eo.setToAcctSeqNo(entity.getToAcctSeqNo());
        eo.setToAcctName(entity.getToAcctName());
        eo.setToProdType(entity.getToProdType());
        eo.setToAcctType(ToAcctType.byValue(entity.getToAcctType()));
        eo.setToBankInd(ToBankInd.byValue(entity.getToBankInd()));
        eo.setResSeqNo(entity.getResSeqNo());
        eo.setRemark(entity.getRemark());
        eo.setReference(entity.getReference());
        eo.setAuthUserId(entity.getAuthUserId());
        eo.setUserId(entity.getUserId());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setTranDate(entity.getTranDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbAcctDossReg eoToEntity(RbAcctDossRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctDossReg entity = new RbAcctDossReg();
        entity.setDossOperateType(eo.getDossOperateType() == null ? null : eo.getDossOperateType().getValue());
        entity.setBatchNo(eo.getBatchNo());
        entity.setHandFlag(eo.getHandFlag() == null ? null : eo.getHandFlag().getValue());
        entity.setInternalKey(eo.getInternalKey());
        entity.setClientNo(eo.getClientNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctName(eo.getAcctName());
        entity.setIndividualFlag(eo.getIndividualFlag() == null ? null : eo.getIndividualFlag().getValue());
        entity.setAmtType(eo.getAmtType() == null ? null : eo.getAmtType().getValue());
        entity.setBalance(eo.getBalance());
        entity.setIntAmt(eo.getIntAmt());
        entity.setPorIntTot(eo.getPorIntTot());
        entity.setTranAmt(eo.getTranAmt());
        entity.setRecordAmt(eo.getRecordAmt());
        entity.setTaxSc(eo.getTaxSc());
        entity.setDossStatus(eo.getDossStatus() == null ? null : eo.getDossStatus().getValue());
        entity.setPrevDossStatus(eo.getPrevDossStatus() == null ? null : eo.getPrevDossStatus().getValue());
        entity.setDossDate(eo.getDossDate());
        entity.setDossBranch(eo.getDossBranch() == null ? null : eo.getDossBranch().getValue());
        entity.setDossUserId(eo.getDossUserId());
        entity.setTodossReason(eo.getTodossReason());
        entity.setActiveDate(eo.getActiveDate());
        entity.setActiveBranch(eo.getActiveBranch() == null ? null : eo.getActiveBranch().getValue());
        entity.setActiveUserId(eo.getActiveUserId());
        entity.setOutBusiDate(eo.getOutBusiDate());
        entity.setOutBusiUserId(eo.getOutBusiUserId());
        entity.setWithdrawalDate(eo.getWithdrawalDate());
        entity.setWithdrawalBranch(eo.getWithdrawalBranch() == null ? null : eo.getWithdrawalBranch().getValue());
        entity.setWithdrawalUserId(eo.getWithdrawalUserId());
        entity.setWithdrawalReason(eo.getWithdrawalReason());
        entity.setToBaseAcctNo(eo.getToBaseAcctNo());
        entity.setToCcy(eo.getToCcy() == null ? null : eo.getToCcy().getValue());
        entity.setToAcctSeqNo(eo.getToAcctSeqNo());
        entity.setToAcctName(eo.getToAcctName());
        entity.setToProdType(eo.getToProdType());
        entity.setToAcctType(eo.getToAcctType() == null ? null : eo.getToAcctType().getValue());
        entity.setToBankInd(eo.getToBankInd() == null ? null : eo.getToBankInd().getValue());
        entity.setResSeqNo(eo.getResSeqNo());
        entity.setRemark(eo.getRemark());
        entity.setReference(eo.getReference());
        entity.setAuthUserId(eo.getAuthUserId());
        entity.setUserId(eo.getUserId());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbAcctDossRegExample eoToEntityExample(RbAcctDossRegEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctDossRegExample example = new RbAcctDossRegExample();
        RbAcctDossRegExample.Criteria criteria = example.createCriteria();
        if (eo.getDossOperateType() != null) criteria.andDossOperateTypeEqualTo(eo.getDossOperateType().getValue());
        if (eo.getBatchNo() != null) criteria.andBatchNoEqualTo(eo.getBatchNo());
        if (eo.getHandFlag() != null) criteria.andHandFlagEqualTo(eo.getHandFlag().getValue());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getIndividualFlag() != null) criteria.andIndividualFlagEqualTo(eo.getIndividualFlag().getValue());
        if (eo.getAmtType() != null) criteria.andAmtTypeEqualTo(eo.getAmtType().getValue());
        if (eo.getBalance() != null) criteria.andBalanceEqualTo(eo.getBalance());
        if (eo.getIntAmt() != null) criteria.andIntAmtEqualTo(eo.getIntAmt());
        if (eo.getPorIntTot() != null) criteria.andPorIntTotEqualTo(eo.getPorIntTot());
        if (eo.getTranAmt() != null) criteria.andTranAmtEqualTo(eo.getTranAmt());
        if (eo.getRecordAmt() != null) criteria.andRecordAmtEqualTo(eo.getRecordAmt());
        if (eo.getTaxSc() != null) criteria.andTaxScEqualTo(eo.getTaxSc());
        if (eo.getDossStatus() != null) criteria.andDossStatusEqualTo(eo.getDossStatus().getValue());
        if (eo.getPrevDossStatus() != null) criteria.andPrevDossStatusEqualTo(eo.getPrevDossStatus().getValue());
        if (eo.getDossDate() != null) criteria.andDossDateEqualTo(eo.getDossDate());
        if (eo.getDossBranch() != null) criteria.andDossBranchEqualTo(eo.getDossBranch().getValue());
        if (eo.getDossUserId() != null) criteria.andDossUserIdEqualTo(eo.getDossUserId());
        if (eo.getTodossReason() != null) criteria.andTodossReasonEqualTo(eo.getTodossReason());
        if (eo.getActiveDate() != null) criteria.andActiveDateEqualTo(eo.getActiveDate());
        if (eo.getActiveBranch() != null) criteria.andActiveBranchEqualTo(eo.getActiveBranch().getValue());
        if (eo.getActiveUserId() != null) criteria.andActiveUserIdEqualTo(eo.getActiveUserId());
        if (eo.getOutBusiDate() != null) criteria.andOutBusiDateEqualTo(eo.getOutBusiDate());
        if (eo.getOutBusiUserId() != null) criteria.andOutBusiUserIdEqualTo(eo.getOutBusiUserId());
        if (eo.getWithdrawalDate() != null) criteria.andWithdrawalDateEqualTo(eo.getWithdrawalDate());
        if (eo.getWithdrawalBranch() != null) criteria.andWithdrawalBranchEqualTo(eo.getWithdrawalBranch().getValue());
        if (eo.getWithdrawalUserId() != null) criteria.andWithdrawalUserIdEqualTo(eo.getWithdrawalUserId());
        if (eo.getWithdrawalReason() != null) criteria.andWithdrawalReasonEqualTo(eo.getWithdrawalReason());
        if (eo.getToBaseAcctNo() != null) criteria.andToBaseAcctNoEqualTo(eo.getToBaseAcctNo());
        if (eo.getToCcy() != null) criteria.andToCcyEqualTo(eo.getToCcy().getValue());
        if (eo.getToAcctSeqNo() != null) criteria.andToAcctSeqNoEqualTo(eo.getToAcctSeqNo());
        if (eo.getToAcctName() != null) criteria.andToAcctNameEqualTo(eo.getToAcctName());
        if (eo.getToProdType() != null) criteria.andToProdTypeEqualTo(eo.getToProdType());
        if (eo.getToAcctType() != null) criteria.andToAcctTypeEqualTo(eo.getToAcctType().getValue());
        if (eo.getToBankInd() != null) criteria.andToBankIndEqualTo(eo.getToBankInd().getValue());
        if (eo.getResSeqNo() != null) criteria.andResSeqNoEqualTo(eo.getResSeqNo());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getAuthUserId() != null) criteria.andAuthUserIdEqualTo(eo.getAuthUserId());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}