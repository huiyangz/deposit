package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusAcctAppointment;
import com.dcits.deposit.entity.RbBusAcctAppointmentExample;
import com.dcits.deposit.facade.eo.RbBusAcctAppointmentEO;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.AppointmentStatus;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.DocumentType;

public final class RbBusAcctAppointmentValueUtil {
    private RbBusAcctAppointmentValueUtil() {
    }

    public static RbBusAcctAppointmentEO entityToEo(RbBusAcctAppointment entity) {
        if (entity == null) {
            return null;
        }
        RbBusAcctAppointmentEO eo = new RbBusAcctAppointmentEO();
        eo.setProdNo(entity.getProdNo());
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setIssCountry(IssCountry.byValue(entity.getIssCountry()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setOrderNo(entity.getOrderNo());
        eo.setAppointmentStatus(AppointmentStatus.byValue(entity.getAppointmentStatus()));
        eo.setDocumentId(entity.getDocumentId());
        eo.setTranDate(entity.getTranDate());
        eo.setCategoryType(CategoryType.byValue(entity.getCategoryType()));
        eo.setRbAcctType(RbAcctType.byValue(entity.getRbAcctType()));
        eo.setClientType(ClientType.byValue(entity.getClientType()));
        eo.setTranBranch(TranBranch.byValue(entity.getTranBranch()));
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setClientName(entity.getClientName());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setApplyDueDate(entity.getApplyDueDate());
        return eo;
    }

    public static RbBusAcctAppointment eoToEntity(RbBusAcctAppointmentEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctAppointment entity = new RbBusAcctAppointment();
        entity.setProdNo(eo.getProdNo());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setIssCountry(eo.getIssCountry() == null ? null : eo.getIssCountry().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setOrderNo(eo.getOrderNo());
        entity.setAppointmentStatus(eo.getAppointmentStatus() == null ? null : eo.getAppointmentStatus().getValue());
        entity.setDocumentId(eo.getDocumentId());
        entity.setTranDate(eo.getTranDate());
        entity.setCategoryType(eo.getCategoryType() == null ? null : eo.getCategoryType().getValue());
        entity.setRbAcctType(eo.getRbAcctType() == null ? null : eo.getRbAcctType().getValue());
        entity.setClientType(eo.getClientType() == null ? null : eo.getClientType().getValue());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setClientName(eo.getClientName());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setApplyDueDate(eo.getApplyDueDate());
        return entity;
    }

    public static RbBusAcctAppointmentExample eoToEntityExample(RbBusAcctAppointmentEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctAppointmentExample example = new RbBusAcctAppointmentExample();
        RbBusAcctAppointmentExample.Criteria criteria = example.createCriteria();
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getIssCountry() != null) criteria.andIssCountryEqualTo(eo.getIssCountry().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getOrderNo() != null) criteria.andOrderNoEqualTo(eo.getOrderNo());
        if (eo.getAppointmentStatus() != null) criteria.andAppointmentStatusEqualTo(eo.getAppointmentStatus().getValue());
        if (eo.getDocumentId() != null) criteria.andDocumentIdEqualTo(eo.getDocumentId());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        if (eo.getCategoryType() != null) criteria.andCategoryTypeEqualTo(eo.getCategoryType().getValue());
        if (eo.getRbAcctType() != null) criteria.andRbAcctTypeEqualTo(eo.getRbAcctType().getValue());
        if (eo.getClientType() != null) criteria.andClientTypeEqualTo(eo.getClientType().getValue());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getClientName() != null) criteria.andClientNameEqualTo(eo.getClientName());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getApplyDueDate() != null) criteria.andApplyDueDateEqualTo(eo.getApplyDueDate());
        return example;
    }
}