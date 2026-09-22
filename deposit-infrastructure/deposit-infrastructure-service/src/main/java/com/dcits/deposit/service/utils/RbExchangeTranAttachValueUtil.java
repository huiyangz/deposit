package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbExchangeTranAttach;
import com.dcits.deposit.entity.RbExchangeTranAttachExample;
import com.dcits.deposit.facade.eo.RbExchangeTranAttachEO;
import com.dcits.deposit.enums.ExchangeSupplyReason;
import com.dcits.deposit.enums.ExchangeAmountNature;
import com.dcits.deposit.enums.ExchangeChangeReason;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ExchangeCancelReason;
import com.dcits.deposit.enums.ExchangeAmountType;
import com.dcits.deposit.enums.ExchangeClass;
import com.dcits.deposit.enums.ExchangeReportType;
import com.dcits.deposit.enums.ExchangeType;
import com.dcits.deposit.enums.ExchangeTranStatus;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.IssCountry;

public final class RbExchangeTranAttachValueUtil {
    private RbExchangeTranAttachValueUtil() {
    }

    public static RbExchangeTranAttachEO entityToEo(RbExchangeTranAttach entity) {
        if (entity == null) {
            return null;
        }
        RbExchangeTranAttachEO eo = new RbExchangeTranAttachEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setClientNo(entity.getClientNo());
        eo.setForeAcct(entity.getForeAcct());
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setDocumentId(entity.getDocumentId());
        eo.setExchangeSupplyReason(ExchangeSupplyReason.byValue(entity.getExchangeSupplyReason()));
        eo.setExchangeAmountNature(ExchangeAmountNature.byValue(entity.getExchangeAmountNature()));
        eo.setAgencyCorpName(entity.getAgencyCorpName());
        eo.setCnyAcctNo(entity.getCnyAcctNo());
        eo.setExchangeChangeReason(ExchangeChangeReason.byValue(entity.getExchangeChangeReason()));
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setIssCountry(IssCountry.byValue(entity.getIssCountry()));
        eo.setExchangeCancelReason(ExchangeCancelReason.byValue(entity.getExchangeCancelReason()));
        eo.setSupplyRemark(entity.getSupplyRemark());
        eo.setApprLetterNo(entity.getApprLetterNo());
        eo.setIndividualBusiOrgCode(entity.getIndividualBusiOrgCode());
        eo.setIndividualBusiName(entity.getIndividualBusiName());
        eo.setClientName(entity.getClientName());
        eo.setSupplyDocumentId(entity.getSupplyDocumentId());
        eo.setAgencyCorpOrgCode(entity.getAgencyCorpOrgCode());
        eo.setExchangeAmountType(ExchangeAmountType.byValue(entity.getExchangeAmountType()));
        eo.setExchangeClass(ExchangeClass.byValue(entity.getExchangeClass()));
        eo.setExchangeReportType(ExchangeReportType.byValue(entity.getExchangeReportType()));
        eo.setExchangeReportNo(entity.getExchangeReportNo());
        eo.setExchangeTranCode(entity.getExchangeTranCode());
        eo.setExchangeTranCodet(entity.getExchangeTranCodet());
        eo.setExchangeType(ExchangeType.byValue(entity.getExchangeType()));
        eo.setExchangeTranStatus(ExchangeTranStatus.byValue(entity.getExchangeTranStatus()));
        eo.setExchangePurpose(entity.getExchangePurpose());
        eo.setExchangePurposeDetails(entity.getExchangePurposeDetails());
        eo.setSourceModule(SourceModule.byValue(entity.getSourceModule()));
        eo.setApprUserId(entity.getApprUserId());
        eo.setApprovalDate(entity.getApprovalDate());
        eo.setTranDate(entity.getTranDate());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setDiscountValue(entity.getDiscountValue());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setCashFromCode(entity.getCashFromCode());
        eo.setCashFromCountry(IssCountry.byValue(entity.getCashFromCountry()));
        eo.setCashToCode(entity.getCashToCode());
        eo.setCashToCountry(IssCountry.byValue(entity.getCashToCountry()));
        eo.setRemark(entity.getRemark());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbExchangeTranAttach eoToEntity(RbExchangeTranAttachEO eo) {
        if (eo == null) {
            return null;
        }
        RbExchangeTranAttach entity = new RbExchangeTranAttach();
        entity.setSeqNo(eo.getSeqNo());
        entity.setClientNo(eo.getClientNo());
        entity.setForeAcct(eo.getForeAcct());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setDocumentId(eo.getDocumentId());
        entity.setExchangeSupplyReason(eo.getExchangeSupplyReason() == null ? null : eo.getExchangeSupplyReason().getValue());
        entity.setExchangeAmountNature(eo.getExchangeAmountNature() == null ? null : eo.getExchangeAmountNature().getValue());
        entity.setAgencyCorpName(eo.getAgencyCorpName());
        entity.setCnyAcctNo(eo.getCnyAcctNo());
        entity.setExchangeChangeReason(eo.getExchangeChangeReason() == null ? null : eo.getExchangeChangeReason().getValue());
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setIssCountry(eo.getIssCountry() == null ? null : eo.getIssCountry().getValue());
        entity.setExchangeCancelReason(eo.getExchangeCancelReason() == null ? null : eo.getExchangeCancelReason().getValue());
        entity.setSupplyRemark(eo.getSupplyRemark());
        entity.setApprLetterNo(eo.getApprLetterNo());
        entity.setIndividualBusiOrgCode(eo.getIndividualBusiOrgCode());
        entity.setIndividualBusiName(eo.getIndividualBusiName());
        entity.setClientName(eo.getClientName());
        entity.setSupplyDocumentId(eo.getSupplyDocumentId());
        entity.setAgencyCorpOrgCode(eo.getAgencyCorpOrgCode());
        entity.setExchangeAmountType(eo.getExchangeAmountType() == null ? null : eo.getExchangeAmountType().getValue());
        entity.setExchangeClass(eo.getExchangeClass() == null ? null : eo.getExchangeClass().getValue());
        entity.setExchangeReportType(eo.getExchangeReportType() == null ? null : eo.getExchangeReportType().getValue());
        entity.setExchangeReportNo(eo.getExchangeReportNo());
        entity.setExchangeTranCode(eo.getExchangeTranCode());
        entity.setExchangeTranCodet(eo.getExchangeTranCodet());
        entity.setExchangeType(eo.getExchangeType() == null ? null : eo.getExchangeType().getValue());
        entity.setExchangeTranStatus(eo.getExchangeTranStatus() == null ? null : eo.getExchangeTranStatus().getValue());
        entity.setExchangePurpose(eo.getExchangePurpose());
        entity.setExchangePurposeDetails(eo.getExchangePurposeDetails());
        entity.setSourceModule(eo.getSourceModule() == null ? null : eo.getSourceModule().getValue());
        entity.setApprUserId(eo.getApprUserId());
        entity.setApprovalDate(eo.getApprovalDate());
        entity.setTranDate(eo.getTranDate());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setDiscountValue(eo.getDiscountValue());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setCashFromCode(eo.getCashFromCode());
        entity.setCashFromCountry(eo.getCashFromCountry() == null ? null : eo.getCashFromCountry().getValue());
        entity.setCashToCode(eo.getCashToCode());
        entity.setCashToCountry(eo.getCashToCountry() == null ? null : eo.getCashToCountry().getValue());
        entity.setRemark(eo.getRemark());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbExchangeTranAttachExample eoToEntityExample(RbExchangeTranAttachEO eo) {
        if (eo == null) {
            return null;
        }
        RbExchangeTranAttachExample example = new RbExchangeTranAttachExample();
        RbExchangeTranAttachExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getForeAcct() != null) criteria.andForeAcctEqualTo(eo.getForeAcct());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getExchangeSupplyReason() != null) criteria.andExchangeSupplyReasonEqualTo(eo.getExchangeSupplyReason().getValue());
        if (eo.getExchangeAmountNature() != null) criteria.andExchangeAmountNatureEqualTo(eo.getExchangeAmountNature().getValue());
        if (eo.getAgencyCorpName() != null) criteria.andAgencyCorpNameEqualTo(eo.getAgencyCorpName());
        if (eo.getCnyAcctNo() != null) criteria.andCnyAcctNoEqualTo(eo.getCnyAcctNo());
        if (eo.getExchangeChangeReason() != null) criteria.andExchangeChangeReasonEqualTo(eo.getExchangeChangeReason().getValue());
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getIssCountry() != null) criteria.andIssCountryEqualTo(eo.getIssCountry().getValue());
        if (eo.getExchangeCancelReason() != null) criteria.andExchangeCancelReasonEqualTo(eo.getExchangeCancelReason().getValue());
        if (eo.getSupplyRemark() != null) criteria.andSupplyRemarkEqualTo(eo.getSupplyRemark());
        if (eo.getApprLetterNo() != null) criteria.andApprLetterNoEqualTo(eo.getApprLetterNo());
        if (eo.getIndividualBusiOrgCode() != null) criteria.andIndividualBusiOrgCodeEqualTo(eo.getIndividualBusiOrgCode());
        if (eo.getIndividualBusiName() != null) criteria.andIndividualBusiNameEqualTo(eo.getIndividualBusiName());
        if (eo.getClientName() != null) criteria.andClientNameEqualTo(eo.getClientName());
        if (eo.getSupplyDocumentId() != null) criteria.andSupplyDocumentIdEqualTo(eo.getSupplyDocumentId());
        if (eo.getAgencyCorpOrgCode() != null) criteria.andAgencyCorpOrgCodeEqualTo(eo.getAgencyCorpOrgCode());
        if (eo.getExchangeAmountType() != null) criteria.andExchangeAmountTypeEqualTo(eo.getExchangeAmountType().getValue());
        if (eo.getExchangeClass() != null) criteria.andExchangeClassEqualTo(eo.getExchangeClass().getValue());
        if (eo.getExchangeReportType() != null) criteria.andExchangeReportTypeEqualTo(eo.getExchangeReportType().getValue());
        if (eo.getExchangeReportNo() != null) criteria.andExchangeReportNoEqualTo(eo.getExchangeReportNo());
        if (eo.getExchangeTranCode() != null) criteria.andExchangeTranCodeEqualTo(eo.getExchangeTranCode());
        if (eo.getExchangeTranCodet() != null) criteria.andExchangeTranCodetEqualTo(eo.getExchangeTranCodet());
        if (eo.getExchangeType() != null) criteria.andExchangeTypeEqualTo(eo.getExchangeType().getValue());
        if (eo.getExchangeTranStatus() != null) criteria.andExchangeTranStatusEqualTo(eo.getExchangeTranStatus().getValue());
        if (eo.getExchangePurpose() != null) criteria.andExchangePurposeEqualTo(eo.getExchangePurpose());
        if (eo.getExchangePurposeDetails() != null) criteria.andExchangePurposeDetailsEqualTo(eo.getExchangePurposeDetails());
        if (eo.getSourceModule() != null) criteria.andSourceModuleEqualTo(eo.getSourceModule().getValue());
        if (eo.getApprUserId() != null) criteria.andApprUserIdEqualTo(eo.getApprUserId());
        if (eo.getApprovalDate() != null) criteria.andApprovalDateEqualTo(eo.getApprovalDate());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getDiscountValue() != null) criteria.andDiscountValueEqualTo(eo.getDiscountValue());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getCashFromCode() != null) criteria.andCashFromCodeEqualTo(eo.getCashFromCode());
        if (eo.getCashFromCountry() != null) criteria.andCashFromCountryEqualTo(eo.getCashFromCountry().getValue());
        if (eo.getCashToCode() != null) criteria.andCashToCodeEqualTo(eo.getCashToCode());
        if (eo.getCashToCountry() != null) criteria.andCashToCountryEqualTo(eo.getCashToCountry().getValue());
        if (eo.getRemark() != null) criteria.andRemarkEqualTo(eo.getRemark());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}