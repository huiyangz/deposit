package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbCorpNatureDef;
import com.dcits.deposit.entity.RbCorpNatureDefExample;
import com.dcits.deposit.facade.eo.RbCorpNatureDefEO;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.AcctOperateType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.NatureProperty;

public final class RbCorpNatureDefValueUtil {
    private RbCorpNatureDefValueUtil() {
    }

    public static RbCorpNatureDefEO entityToEo(RbCorpNatureDef entity) {
        if (entity == null) {
            return null;
        }
        RbCorpNatureDefEO eo = new RbCorpNatureDefEO();
        eo.setSeqNo(entity.getSeqNo());
        eo.setAcctNature(AcctNature.byValue(entity.getAcctNature()));
        eo.setReasonCode(ReasonCode.byValue(entity.getReasonCode()));
        eo.setAcctOperateType(AcctOperateType.byValue(entity.getAcctOperateType()));
        eo.setTerm(entity.getTerm());
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setAcctStatus(AcctStatus.byValue(entity.getAcctStatus()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setInlandOffshore(IndividualFlag.byValue(entity.getInlandOffshore()));
        eo.setCorporation(IndividualFlag.byValue(entity.getCorporation()));
        eo.setNatureProperty(NatureProperty.byValue(entity.getNatureProperty()));
        return eo;
    }

    public static RbCorpNatureDef eoToEntity(RbCorpNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbCorpNatureDef entity = new RbCorpNatureDef();
        entity.setSeqNo(eo.getSeqNo());
        entity.setAcctNature(eo.getAcctNature() == null ? null : eo.getAcctNature().getValue());
        entity.setReasonCode(eo.getReasonCode() == null ? null : eo.getReasonCode().getValue());
        entity.setAcctOperateType(eo.getAcctOperateType() == null ? null : eo.getAcctOperateType().getValue());
        entity.setTerm(eo.getTerm());
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setAcctStatus(eo.getAcctStatus() == null ? null : eo.getAcctStatus().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setInlandOffshore(eo.getInlandOffshore() == null ? null : eo.getInlandOffshore().getValue());
        entity.setCorporation(eo.getCorporation() == null ? null : eo.getCorporation().getValue());
        entity.setNatureProperty(eo.getNatureProperty() == null ? null : eo.getNatureProperty().getValue());
        return entity;
    }

    public static RbCorpNatureDefExample eoToEntityExample(RbCorpNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbCorpNatureDefExample example = new RbCorpNatureDefExample();
        RbCorpNatureDefExample.Criteria criteria = example.createCriteria();
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getAcctNature() != null) criteria.andAcctNatureEqualTo(eo.getAcctNature().getValue());
        if (eo.getReasonCode() != null) criteria.andReasonCodeEqualTo(eo.getReasonCode().getValue());
        if (eo.getAcctOperateType() != null) criteria.andAcctOperateTypeEqualTo(eo.getAcctOperateType().getValue());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getAcctStatus() != null) criteria.andAcctStatusEqualTo(eo.getAcctStatus().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getInlandOffshore() != null) criteria.andInlandOffshoreEqualTo(eo.getInlandOffshore().getValue());
        if (eo.getCorporation() != null) criteria.andCorporationEqualTo(eo.getCorporation().getValue());
        if (eo.getNatureProperty() != null) criteria.andNaturePropertyEqualTo(eo.getNatureProperty().getValue());
        return example;
    }
}