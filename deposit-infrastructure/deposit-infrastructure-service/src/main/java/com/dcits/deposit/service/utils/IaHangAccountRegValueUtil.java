package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.IaHangAccountReg;
import com.dcits.deposit.entity.IaHangAccountRegExample;
import com.dcits.deposit.facade.eo.IaHangAccountRegEO;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.HangDealType;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.Company;

public final class IaHangAccountRegValueUtil {
    private IaHangAccountRegValueUtil() {
    }

    public static IaHangAccountRegEO entityToEo(IaHangAccountReg entity) {
        if (entity == null) {
            return null;
        }
        IaHangAccountRegEO eo = new IaHangAccountRegEO();
        eo.setHangSeqNo(entity.getHangSeqNo());
        eo.setSubHangSeqNo(entity.getSubHangSeqNo());
        eo.setHangAmt(entity.getHangAmt());
        eo.setHangBal(entity.getHangBal());
        eo.setClientNo(entity.getClientNo());
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setHangDealType(HangDealType.byValue(entity.getHangDealType()));
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setHangStatus(HangStatus.byValue(entity.getHangStatus()));
        eo.setHangWriteOffTime(entity.getHangWriteOffTime());
        eo.setHangEndDate(entity.getHangEndDate());
        eo.setCrDrInd(CrDrInd.byValue(entity.getCrDrInd()));
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setTranDate(entity.getTranDate());
        eo.setNarrative(entity.getNarrative());
        eo.setHangReason(entity.getHangReason());
        eo.setOthBaseAcctNo(entity.getOthBaseAcctNo());
        eo.setOthAcctName(entity.getOthAcctName());
        eo.setOthBranch(AcctBranch.byValue(entity.getOthBranch()));
        eo.setOthBankFlag(IndividualFlag.byValue(entity.getOthBankFlag()));
        eo.setReference(entity.getReference());
        eo.setOthRealBankName(entity.getOthRealBankName());
        eo.setOthRealBaseAcctNo(entity.getOthRealBaseAcctNo());
        eo.setOthRealProdType(entity.getOthRealProdType());
        eo.setOthRealDocumentType(DocumentType.byValue(entity.getOthRealDocumentType()));
        eo.setOthRealDocumentId(entity.getOthRealDocumentId());
        eo.setOthRealBankCode(entity.getOthRealBankCode());
        eo.setOthRealTranName(entity.getOthRealTranName());
        eo.setOthRealTranAddr(entity.getOthRealTranAddr());
        eo.setOthRealBranchRegionCode(OthBranchRegionalismCode.byValue(entity.getOthRealBranchRegionCode()));
        eo.setUserId(entity.getUserId());
        eo.setAuthUserId(entity.getAuthUserId());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setLastChangeTime(entity.getLastChangeTime());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static IaHangAccountReg eoToEntity(IaHangAccountRegEO eo) {
        if (eo == null) {
            return null;
        }
        IaHangAccountReg entity = new IaHangAccountReg();
        entity.setHangSeqNo(eo.getHangSeqNo());
        entity.setSubHangSeqNo(eo.getSubHangSeqNo());
        entity.setHangAmt(eo.getHangAmt());
        entity.setHangBal(eo.getHangBal());
        entity.setClientNo(eo.getClientNo());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setHangDealType(eo.getHangDealType() == null ? null : eo.getHangDealType().getValue());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setHangStatus(eo.getHangStatus() == null ? null : eo.getHangStatus().getValue());
        entity.setHangWriteOffTime(eo.getHangWriteOffTime());
        entity.setHangEndDate(eo.getHangEndDate());
        entity.setCrDrInd(eo.getCrDrInd() == null ? null : eo.getCrDrInd().getValue());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setTranDate(eo.getTranDate());
        entity.setNarrative(eo.getNarrative());
        entity.setHangReason(eo.getHangReason());
        entity.setOthBaseAcctNo(eo.getOthBaseAcctNo());
        entity.setOthAcctName(eo.getOthAcctName());
        entity.setOthBranch(eo.getOthBranch() == null ? null : eo.getOthBranch().getValue());
        entity.setOthBankFlag(eo.getOthBankFlag() == null ? null : eo.getOthBankFlag().getValue());
        entity.setReference(eo.getReference());
        entity.setOthRealBankName(eo.getOthRealBankName());
        entity.setOthRealBaseAcctNo(eo.getOthRealBaseAcctNo());
        entity.setOthRealProdType(eo.getOthRealProdType());
        entity.setOthRealDocumentType(eo.getOthRealDocumentType() == null ? null : eo.getOthRealDocumentType().getValue());
        entity.setOthRealDocumentId(eo.getOthRealDocumentId());
        entity.setOthRealBankCode(eo.getOthRealBankCode());
        entity.setOthRealTranName(eo.getOthRealTranName());
        entity.setOthRealTranAddr(eo.getOthRealTranAddr());
        entity.setOthRealBranchRegionCode(eo.getOthRealBranchRegionCode() == null ? null : eo.getOthRealBranchRegionCode().getValue());
        entity.setUserId(eo.getUserId());
        entity.setAuthUserId(eo.getAuthUserId());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setLastChangeTime(eo.getLastChangeTime());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static IaHangAccountRegExample eoToEntityExample(IaHangAccountRegEO eo) {
        if (eo == null) {
            return null;
        }
        IaHangAccountRegExample example = new IaHangAccountRegExample();
        IaHangAccountRegExample.Criteria criteria = example.createCriteria();
        if (eo.getHangSeqNo() != null) criteria.andHangSeqNoEqualTo(eo.getHangSeqNo());
        if (eo.getSubHangSeqNo() != null) criteria.andSubHangSeqNoEqualTo(eo.getSubHangSeqNo());
        if (eo.getHangAmt() != null) criteria.andHangAmtEqualTo(eo.getHangAmt());
        if (eo.getHangBal() != null) criteria.andHangBalEqualTo(eo.getHangBal());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getHangDealType() != null) criteria.andHangDealTypeEqualTo(eo.getHangDealType().getValue());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getHangStatus() != null) criteria.andHangStatusEqualTo(eo.getHangStatus().getValue());
        if (eo.getHangWriteOffTime() != null) criteria.andHangWriteOffTimeEqualTo(eo.getHangWriteOffTime());
        if (eo.getHangEndDate() != null) criteria.andHangEndDateEqualTo(eo.getHangEndDate());
        if (eo.getCrDrInd() != null) criteria.andCrDrIndEqualTo(eo.getCrDrInd().getValue());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getHangReason() != null) criteria.andHangReasonEqualTo(eo.getHangReason());
        if (eo.getOthBaseAcctNo() != null) criteria.andOthBaseAcctNoEqualTo(eo.getOthBaseAcctNo());
        if (eo.getOthAcctName() != null) criteria.andOthAcctNameEqualTo(eo.getOthAcctName());
        if (eo.getOthBranch() != null) criteria.andOthBranchEqualTo(eo.getOthBranch().getValue());
        if (eo.getOthBankFlag() != null) criteria.andOthBankFlagEqualTo(eo.getOthBankFlag().getValue());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getOthRealBankName() != null) criteria.andOthRealBankNameEqualTo(eo.getOthRealBankName());
        if (eo.getOthRealBaseAcctNo() != null) criteria.andOthRealBaseAcctNoEqualTo(eo.getOthRealBaseAcctNo());
        if (eo.getOthRealProdType() != null) criteria.andOthRealProdTypeEqualTo(eo.getOthRealProdType());
        if (eo.getOthRealDocumentType() != null) criteria.andOthRealDocumentTypeEqualTo(eo.getOthRealDocumentType().getValue());
        if (eo.getOthRealDocumentId() != null) criteria.andOthRealDocumentIdEqualTo(eo.getOthRealDocumentId());
        if (eo.getOthRealBankCode() != null) criteria.andOthRealBankCodeEqualTo(eo.getOthRealBankCode());
        if (eo.getOthRealTranName() != null) criteria.andOthRealTranNameEqualTo(eo.getOthRealTranName());
        if (eo.getOthRealTranAddr() != null) criteria.andOthRealTranAddrEqualTo(eo.getOthRealTranAddr());
        if (eo.getOthRealBranchRegionCode() != null) criteria.andOthRealBranchRegionCodeEqualTo(eo.getOthRealBranchRegionCode().getValue());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getAuthUserId() != null) criteria.andAuthUserIdEqualTo(eo.getAuthUserId());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getLastChangeTime() != null) criteria.andLastChangeTimeEqualTo(eo.getLastChangeTime());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}