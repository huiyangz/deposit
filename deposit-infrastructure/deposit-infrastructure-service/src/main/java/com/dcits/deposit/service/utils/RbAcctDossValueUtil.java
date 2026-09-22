package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbAcctDoss;
import com.dcits.deposit.entity.RbAcctDossExample;
import com.dcits.deposit.facade.eo.RbAcctDossEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.DossOperateType;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;

public final class RbAcctDossValueUtil {
    private RbAcctDossValueUtil() {
    }

    public static RbAcctDossEO entityToEo(RbAcctDoss entity) {
        if (entity == null) {
            return null;
        }
        RbAcctDossEO eo = new RbAcctDossEO();
        eo.setInternalKey(entity.getInternalKey());
        eo.setClientNo(entity.getClientNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAcctStatus(AcctStatus.byValue(entity.getAcctStatus()));
        eo.setAcctName(entity.getAcctName());
        eo.setTranDate(entity.getTranDate());
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setDossOperateType(DossOperateType.byValue(entity.getDossOperateType()));
        eo.setAmtType(AmtType.byValue(entity.getAmtType()));
        eo.setBalance(entity.getBalance());
        eo.setDormantDate(entity.getDormantDate());
        eo.setDossDate(entity.getDossDate());
        eo.setOutDate(entity.getOutDate());
        eo.setIntAmt(entity.getIntAmt());
        eo.setPorIntTot(entity.getPorIntTot());
        eo.setTaxSc(entity.getTaxSc());
        eo.setRemark(entity.getRemark());
        eo.setUserId(entity.getUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RbAcctDoss eoToEntity(RbAcctDossEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctDoss entity = new RbAcctDoss();
        entity.setInternalKey(eo.getInternalKey());
        entity.setClientNo(eo.getClientNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAcctStatus(eo.getAcctStatus() == null ? null : eo.getAcctStatus().getValue());
        entity.setAcctName(eo.getAcctName());
        entity.setTranDate(eo.getTranDate());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setDossOperateType(eo.getDossOperateType() == null ? null : eo.getDossOperateType().getValue());
        entity.setAmtType(eo.getAmtType() == null ? null : eo.getAmtType().getValue());
        entity.setBalance(eo.getBalance());
        entity.setDormantDate(eo.getDormantDate());
        entity.setDossDate(eo.getDossDate());
        entity.setOutDate(eo.getOutDate());
        entity.setIntAmt(eo.getIntAmt());
        entity.setPorIntTot(eo.getPorIntTot());
        entity.setTaxSc(eo.getTaxSc());
        entity.setRemark(eo.getRemark());
        entity.setUserId(eo.getUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RbAcctDossExample eoToEntityExample(RbAcctDossEO eo) {
        if (eo == null) {
            return null;
        }
        RbAcctDossExample example = new RbAcctDossExample();
        RbAcctDossExample.Criteria criteria = example.createCriteria();
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAcctStatus() != null) criteria.andAcctStatusEqualTo(eo.getAcctStatus().getValue());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getDossOperateType() != null) criteria.andDossOperateTypeEqualTo(eo.getDossOperateType().getValue());
        if (eo.getAmtType() != null) criteria.andAmtTypeEqualTo(eo.getAmtType().getValue());
        if (eo.getBalance() != null) criteria.andBalanceEqualTo(eo.getBalance());
        if (eo.getDormantDate() != null) criteria.andDormantDateEqualTo(eo.getDormantDate());
        if (eo.getDossDate() != null) criteria.andDossDateEqualTo(eo.getDossDate());
        if (eo.getOutDate() != null) criteria.andOutDateEqualTo(eo.getOutDate());
        if (eo.getIntAmt() != null) criteria.andIntAmtEqualTo(eo.getIntAmt());
        if (eo.getPorIntTot() != null) criteria.andPorIntTotEqualTo(eo.getPorIntTot());
        if (eo.getTaxSc() != null) criteria.andTaxScEqualTo(eo.getTaxSc());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}