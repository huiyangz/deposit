package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBaseAcct;
import com.dcits.deposit.entity.RbBaseAcctExample;
import com.dcits.deposit.facade.eo.RbBaseAcctEO;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceModule;

public final class RbBaseAcctValueUtil {
    private RbBaseAcctValueUtil() {
    }

    public static RbBaseAcctEO entityToEo(RbBaseAcct entity) {
        if (entity == null) {
            return null;
        }
        RbBaseAcctEO eo = new RbBaseAcctEO();
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setClientNo(entity.getClientNo());
        eo.setClientType(ClientType.byValue(entity.getClientType()));
        eo.setDocumentId(entity.getDocumentId());
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setIssCountry(IssCountry.byValue(entity.getIssCountry()));
        eo.setCardNo(entity.getCardNo());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setProdType(entity.getProdType());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setAcctBranch(AcctBranch.byValue(entity.getAcctBranch()));
        eo.setAcctOpenDate(entity.getAcctOpenDate());
        eo.setAcctType(AcctType.byValue(entity.getAcctType()));
        eo.setAcctName(entity.getAcctName());
        eo.setAltAcctName(entity.getAltAcctName());
        eo.setAcctStatus(AcctStatus.byValue(entity.getAcctStatus()));
        eo.setAcctStatusPrev(AcctStatus.byValue(entity.getAcctStatusPrev()));
        eo.setAcctStatusUpdDate(entity.getAcctStatusUpdDate());
        eo.setAcctCloseReason(entity.getAcctCloseReason());
        eo.setAcctCloseUserId(entity.getAcctCloseUserId());
        eo.setAcctDesc(entity.getAcctDesc());
        eo.setAcctResStatus(IndividualFlag.byValue(entity.getAcctResStatus()));
        eo.setOldProdType(entity.getOldProdType());
        eo.setTerminalId(entity.getTerminalId());
        eo.setAcctExec(entity.getAcctExec());
        eo.setUserId(entity.getUserId());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setAllDraInd(AllDraInd.byValue(entity.getAllDraInd()));
        eo.setAllDepInd(IndividualFlag.byValue(entity.getAllDepInd()));
        eo.setAcctCloseDate(entity.getAcctCloseDate());
        eo.setSourceModule(SourceModule.byValue(entity.getSourceModule()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbBaseAcct eoToEntity(RbBaseAcctEO eo) {
        if (eo == null) {
            return null;
        }
        RbBaseAcct entity = new RbBaseAcct();
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setClientNo(eo.getClientNo());
        entity.setClientType(eo.getClientType() == null ? null : eo.getClientType().getValue());
        entity.setDocumentId(eo.getDocumentId());
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setIssCountry(eo.getIssCountry() == null ? null : eo.getIssCountry().getValue());
        entity.setCardNo(eo.getCardNo());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setProdType(eo.getProdType());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setAcctBranch(eo.getAcctBranch() == null ? null : eo.getAcctBranch().getValue());
        entity.setAcctOpenDate(eo.getAcctOpenDate());
        entity.setAcctType(eo.getAcctType() == null ? null : eo.getAcctType().getValue());
        entity.setAcctName(eo.getAcctName());
        entity.setAltAcctName(eo.getAltAcctName());
        entity.setAcctStatus(eo.getAcctStatus() == null ? null : eo.getAcctStatus().getValue());
        entity.setAcctStatusPrev(eo.getAcctStatusPrev() == null ? null : eo.getAcctStatusPrev().getValue());
        entity.setAcctStatusUpdDate(eo.getAcctStatusUpdDate());
        entity.setAcctCloseReason(eo.getAcctCloseReason());
        entity.setAcctCloseUserId(eo.getAcctCloseUserId());
        entity.setAcctDesc(eo.getAcctDesc());
        entity.setAcctResStatus(eo.getAcctResStatus() == null ? null : eo.getAcctResStatus().getValue());
        entity.setOldProdType(eo.getOldProdType());
        entity.setTerminalId(eo.getTerminalId());
        entity.setAcctExec(eo.getAcctExec());
        entity.setUserId(eo.getUserId());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setAllDraInd(eo.getAllDraInd() == null ? null : eo.getAllDraInd().getValue());
        entity.setAllDepInd(eo.getAllDepInd() == null ? null : eo.getAllDepInd().getValue());
        entity.setAcctCloseDate(eo.getAcctCloseDate());
        entity.setSourceModule(eo.getSourceModule() == null ? null : eo.getSourceModule().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbBaseAcctExample eoToEntityExample(RbBaseAcctEO eo) {
        if (eo == null) {
            return null;
        }
        RbBaseAcctExample example = new RbBaseAcctExample();
        RbBaseAcctExample.Criteria criteria = example.createCriteria();
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getClientType() != null) criteria.andClientTypeEqualTo(eo.getClientType().getValue());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getIssCountry() != null) criteria.andIssCountryEqualTo(eo.getIssCountry().getValue());
        if (eo.getCardNo() != null) criteria.andCardNoEqualTo(eo.getCardNo());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getAcctBranch() != null) criteria.andAcctBranchEqualTo(eo.getAcctBranch().getValue());
        if (eo.getAcctOpenDate() != null) criteria.andAcctOpenDateEqualTo(eo.getAcctOpenDate());
        if (eo.getAcctType() != null) criteria.andAcctTypeEqualTo(eo.getAcctType().getValue());
        if (eo.getAcctName() != null) criteria.andAcctNameEqualTo(eo.getAcctName());
        if (eo.getAltAcctName() != null) criteria.andAltAcctNameEqualTo(eo.getAltAcctName());
        if (eo.getAcctStatus() != null) criteria.andAcctStatusEqualTo(eo.getAcctStatus().getValue());
        if (eo.getAcctStatusPrev() != null) criteria.andAcctStatusPrevEqualTo(eo.getAcctStatusPrev().getValue());
        if (eo.getAcctStatusUpdDate() != null) criteria.andAcctStatusUpdDateEqualTo(eo.getAcctStatusUpdDate());
        if (eo.getAcctCloseReason() != null) criteria.andAcctCloseReasonEqualTo(eo.getAcctCloseReason());
        if (eo.getAcctCloseUserId() != null) criteria.andAcctCloseUserIdEqualTo(eo.getAcctCloseUserId());
        if (eo.getAcctDesc() != null) criteria.andAcctDescEqualTo(eo.getAcctDesc());
        if (eo.getAcctResStatus() != null) criteria.andAcctResStatusEqualTo(eo.getAcctResStatus().getValue());
        if (eo.getOldProdType() != null) criteria.andOldProdTypeEqualTo(eo.getOldProdType());
        if (eo.getTerminalId() != null) criteria.andTerminalIdEqualTo(eo.getTerminalId());
        if (eo.getAcctExec() != null) criteria.andAcctExecEqualTo(eo.getAcctExec());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getAllDraInd() != null) criteria.andAllDraIndEqualTo(eo.getAllDraInd().getValue());
        if (eo.getAllDepInd() != null) criteria.andAllDepIndEqualTo(eo.getAllDepInd().getValue());
        if (eo.getAcctCloseDate() != null) criteria.andAcctCloseDateEqualTo(eo.getAcctCloseDate());
        if (eo.getSourceModule() != null) criteria.andSourceModuleEqualTo(eo.getSourceModule().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}