package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RcAllList;
import com.dcits.deposit.entity.RcAllListExample;
import com.dcits.deposit.facade.eo.RcAllListEO;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ListCategory;
import com.dcits.deposit.enums.ListOrg;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AgreementStatus;

public final class RcAllListValueUtil {
    private RcAllListValueUtil() {
    }

    public static RcAllListEO entityToEo(RcAllList entity) {
        if (entity == null) {
            return null;
        }
        RcAllListEO eo = new RcAllListEO();
        eo.setDataType(entity.getDataType());
        eo.setDataValue(entity.getDataValue());
        eo.setListType(ListType.byValue(entity.getListType()));
        eo.setClientNo(entity.getClientNo());
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setClientName(entity.getClientName());
        eo.setIssCountry(IssCountry.byValue(entity.getIssCountry()));
        eo.setAcctName(entity.getAcctName());
        eo.setOurBankFlag(IndividualFlag.byValue(entity.getOurBankFlag()));
        eo.setEffectDate(entity.getEffectDate());
        eo.setMaturityDate(entity.getMaturityDate());
        eo.setTranDate(entity.getTranDate());
        eo.setInputBranch(AcctBranch.byValue(entity.getInputBranch()));
        eo.setTranBranch(AcctBranch.byValue(entity.getTranBranch()));
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setNarrative(entity.getNarrative());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setUserId(entity.getUserId());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setListCategory(ListCategory.byValue(entity.getListCategory()));
        eo.setListOrg(ListOrg.byValue(entity.getListOrg()));
        eo.setResSeqNos(entity.getResSeqNos());
        eo.setControlNos(entity.getControlNos());
        eo.setRelVerifyFlag(IndividualFlag.byValue(entity.getRelVerifyFlag()));
        eo.setRcSeqNo(entity.getRcSeqNo());
        eo.setCurAcctResFlag(IndividualFlag.byValue(entity.getCurAcctResFlag()));
        eo.setOtherAcctResFlag(IndividualFlag.byValue(entity.getOtherAcctResFlag()));
        eo.setRcBlackStatus(AgreementStatus.byValue(entity.getRcBlackStatus()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        return eo;
    }

    public static RcAllList eoToEntity(RcAllListEO eo) {
        if (eo == null) {
            return null;
        }
        RcAllList entity = new RcAllList();
        entity.setDataType(eo.getDataType());
        entity.setDataValue(eo.getDataValue());
        entity.setListType(eo.getListType() == null ? null : eo.getListType().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setClientName(eo.getClientName());
        entity.setIssCountry(eo.getIssCountry() == null ? null : eo.getIssCountry().getValue());
        entity.setAcctName(eo.getAcctName());
        entity.setOurBankFlag(eo.getOurBankFlag() == null ? null : eo.getOurBankFlag().getValue());
        entity.setEffectDate(eo.getEffectDate());
        entity.setMaturityDate(eo.getMaturityDate());
        entity.setTranDate(eo.getTranDate());
        entity.setInputBranch(eo.getInputBranch() == null ? null : eo.getInputBranch().getValue());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setNarrative(eo.getNarrative());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setUserId(eo.getUserId());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setListCategory(eo.getListCategory() == null ? null : eo.getListCategory().getValue());
        entity.setListOrg(eo.getListOrg() == null ? null : eo.getListOrg().getValue());
        entity.setResSeqNos(eo.getResSeqNos());
        entity.setControlNos(eo.getControlNos());
        entity.setRelVerifyFlag(eo.getRelVerifyFlag() == null ? null : eo.getRelVerifyFlag().getValue());
        entity.setRcSeqNo(eo.getRcSeqNo());
        entity.setCurAcctResFlag(eo.getCurAcctResFlag() == null ? null : eo.getCurAcctResFlag().getValue());
        entity.setOtherAcctResFlag(eo.getOtherAcctResFlag() == null ? null : eo.getOtherAcctResFlag().getValue());
        entity.setRcBlackStatus(eo.getRcBlackStatus() == null ? null : eo.getRcBlackStatus().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        return entity;
    }

    public static RcAllListExample eoToEntityExample(RcAllListEO eo) {
        if (eo == null) {
            return null;
        }
        RcAllListExample example = new RcAllListExample();
        RcAllListExample.Criteria criteria = example.createCriteria();
        if (eo.getDataType() != null) criteria.andDataTypeEqualTo(eo.getDataType());
        if (eo.getDataValue() != null) criteria.andDataValueEqualTo(eo.getDataValue());
        if (eo.getListType() != null) criteria.andListTypeEqualTo(eo.getListType().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getClientName() != null) criteria.andClientNameEqualTo(eo.getClientName());
        if (eo.getIssCountry() != null) criteria.andIssCountryEqualTo(eo.getIssCountry().getValue());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getOurBankFlag() != null) criteria.andOurBankFlagEqualTo(eo.getOurBankFlag().getValue());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getMaturityDate() != null) criteria.andMaturityDateEqualTo(eo.getMaturityDate());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getInputBranch() != null) criteria.andInputBranchEqualTo(eo.getInputBranch().getValue());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getNarrative() != null) criteria.andNarrativeEqualTo(eo.getNarrative());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getListCategory() != null) criteria.andListCategoryEqualTo(eo.getListCategory().getValue());
        if (eo.getListOrg() != null) criteria.andListOrgEqualTo(eo.getListOrg().getValue());
        if (eo.getResSeqNos() != null) criteria.andResSeqNosEqualTo(eo.getResSeqNos());
        if (eo.getControlNos() != null) criteria.andControlNosEqualTo(eo.getControlNos());
        if (eo.getRelVerifyFlag() != null) criteria.andRelVerifyFlagEqualTo(eo.getRelVerifyFlag().getValue());
        if (eo.getRcSeqNo() != null) criteria.andRcSeqNoEqualTo(eo.getRcSeqNo());
        if (eo.getCurAcctResFlag() != null) criteria.andCurAcctResFlagEqualTo(eo.getCurAcctResFlag().getValue());
        if (eo.getOtherAcctResFlag() != null) criteria.andOtherAcctResFlagEqualTo(eo.getOtherAcctResFlag().getValue());
        if (eo.getRcBlackStatus() != null) criteria.andRcBlackStatusEqualTo(eo.getRcBlackStatus().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        return example;
    }
}