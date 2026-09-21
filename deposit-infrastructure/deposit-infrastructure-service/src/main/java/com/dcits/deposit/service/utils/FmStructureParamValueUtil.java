package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmStructureParam;
import com.dcits.deposit.entity.FmStructureParamExample;
import com.dcits.deposit.facade.eo.FmStructureParamEO;
import com.dcits.deposit.enums.Company;

public final class FmStructureParamValueUtil {
    private FmStructureParamValueUtil() {
    }

    public static FmStructureParamEO entityToEo(FmStructureParam entity) {
        if (entity == null) {
            return null;
        }
        FmStructureParamEO eo = new FmStructureParamEO();
        eo.setStructureType(entity.getStructureType());
        eo.setParamType(entity.getParamType());
        eo.setLength(entity.getLength());
        eo.setStartPos(entity.getStartPos());
        eo.setEndPos(entity.getEndPos());
        eo.setPaddingChar(entity.getPaddingChar());
        eo.setSeqType(entity.getSeqType());
        eo.setStringValue(entity.getStringValue());
        eo.setStartIndex(entity.getStartIndex());
        eo.setEndIndex(entity.getEndIndex());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static FmStructureParam eoToEntity(FmStructureParamEO eo) {
        if (eo == null) {
            return null;
        }
        FmStructureParam entity = new FmStructureParam();
        entity.setStructureType(eo.getStructureType());
        entity.setParamType(eo.getParamType());
        entity.setLength(eo.getLength());
        entity.setStartPos(eo.getStartPos());
        entity.setEndPos(eo.getEndPos());
        entity.setPaddingChar(eo.getPaddingChar());
        entity.setSeqType(eo.getSeqType());
        entity.setStringValue(eo.getStringValue());
        entity.setStartIndex(eo.getStartIndex());
        entity.setEndIndex(eo.getEndIndex());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static FmStructureParamExample eoToEntityExample(FmStructureParamEO eo) {
        if (eo == null) {
            return null;
        }
        FmStructureParamExample example = new FmStructureParamExample();
        FmStructureParamExample.Criteria criteria = example.createCriteria();
        if (eo.getStructureType() != null) criteria.andStructureTypeEqualTo(eo.getStructureType());
        if (eo.getParamType() != null) criteria.andParamTypeEqualTo(eo.getParamType());
        if (eo.getLength() != null) criteria.andLengthEqualTo(eo.getLength());
        if (eo.getStartPos() != null) criteria.andStartPosEqualTo(eo.getStartPos());
        if (eo.getEndPos() != null) criteria.andEndPosEqualTo(eo.getEndPos());
        if (eo.getPaddingChar() != null) criteria.andPaddingCharEqualTo(eo.getPaddingChar());
        if (eo.getSeqType() != null) criteria.andSeqTypeEqualTo(eo.getSeqType());
        if (eo.getStringValue() != null) criteria.andStringValueEqualTo(eo.getStringValue());
        if (eo.getStartIndex() != null) criteria.andStartIndexEqualTo(eo.getStartIndex());
        if (eo.getEndIndex() != null) criteria.andEndIndexEqualTo(eo.getEndIndex());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}