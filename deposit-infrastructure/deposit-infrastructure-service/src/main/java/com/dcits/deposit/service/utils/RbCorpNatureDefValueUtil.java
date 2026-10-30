package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbCorpNatureDef;
import com.dcits.deposit.entity.RbCorpNatureDefExample;
import com.dcits.deposit.facade.eo.RbCorpNatureDefEO;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.NatureProperty;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.AcctOperateType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.AcctStatus;

public final class RbCorpNatureDefValueUtil {
    private RbCorpNatureDefValueUtil() {
    }

    public static RbCorpNatureDefEO entityToEo(RbCorpNatureDef entity) {
        if (entity == null) {
            return null;
        }
        RbCorpNatureDefEO eo = new RbCorpNatureDefEO();
        eo.setAcctNatureNo(AcctNatureNo.byValue(entity.getAcctNatureNo()));
        eo.setTerm(entity.getTerm());
        eo.setNatureProperty(NatureProperty.byValue(entity.getNatureProperty()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setTermType(TermType.byValue(entity.getTermType()));
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setCorporation(entity.getCorporation());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setInlandOffshore(entity.getInlandOffshore());
        eo.setAcctOperateType(AcctOperateType.byValue(entity.getAcctOperateType()));
        eo.setSeqNo(entity.getSeqNo());
        eo.setRbBusAcctPurpose(RbBusAcctPurpose.byValue(entity.getRbBusAcctPurpose()));
        eo.setAcctStatus(AcctStatus.byValue(entity.getAcctStatus()));
        return eo;
    }

    public static RbCorpNatureDef eoToEntity(RbCorpNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbCorpNatureDef entity = new RbCorpNatureDef();
        entity.setAcctNatureNo(eo.getAcctNatureNo() == null ? null : eo.getAcctNatureNo().getValue());
        entity.setTerm(eo.getTerm());
        entity.setNatureProperty(eo.getNatureProperty() == null ? null : eo.getNatureProperty().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setTermType(eo.getTermType() == null ? null : eo.getTermType().getValue());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setCorporation(eo.getCorporation());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setInlandOffshore(eo.getInlandOffshore());
        entity.setAcctOperateType(eo.getAcctOperateType() == null ? null : eo.getAcctOperateType().getValue());
        entity.setSeqNo(eo.getSeqNo());
        entity.setRbBusAcctPurpose(eo.getRbBusAcctPurpose() == null ? null : eo.getRbBusAcctPurpose().getValue());
        entity.setAcctStatus(eo.getAcctStatus() == null ? null : eo.getAcctStatus().getValue());
        return entity;
    }

    public static RbCorpNatureDefExample eoToEntityExample(RbCorpNatureDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbCorpNatureDefExample example = new RbCorpNatureDefExample();
        RbCorpNatureDefExample.Criteria criteria = example.createCriteria();
        if (eo.getAcctNatureNo() != null) criteria.andAcctNatureNoEqualTo(eo.getAcctNatureNo().getValue());
        if (eo.getTerm() != null) criteria.andTermEqualTo(eo.getTerm());
        if (eo.getNatureProperty() != null) criteria.andNaturePropertyEqualTo(eo.getNatureProperty().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getTermType() != null) criteria.andTermTypeEqualTo(eo.getTermType().getValue());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getCorporation() != null) criteria.andCorporationEqualTo(eo.getCorporation());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getInlandOffshore() != null) criteria.andInlandOffshoreEqualTo(eo.getInlandOffshore());
        if (eo.getAcctOperateType() != null) criteria.andAcctOperateTypeEqualTo(eo.getAcctOperateType().getValue());
        if (eo.getSeqNo() != null) criteria.andSeqNoEqualTo(eo.getSeqNo());
        if (eo.getRbBusAcctPurpose() != null) criteria.andRbBusAcctPurposeEqualTo(eo.getRbBusAcctPurpose().getValue());
        if (eo.getAcctStatus() != null) criteria.andAcctStatusEqualTo(eo.getAcctStatus().getValue());
        return example;
    }
}