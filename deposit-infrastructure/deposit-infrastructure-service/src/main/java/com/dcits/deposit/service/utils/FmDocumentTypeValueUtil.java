package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmDocumentType;
import com.dcits.deposit.entity.FmDocumentTypeExample;
import com.dcits.deposit.facade.eo.FmDocumentTypeEO;
import com.dcits.deposit.enums.AppInd;
import com.dcits.deposit.enums.DocumentType;

public final class FmDocumentTypeValueUtil {
    private FmDocumentTypeValueUtil() {
    }

    public static FmDocumentTypeEO entityToEo(FmDocumentType entity) {
        if (entity == null) {
            return null;
        }
        FmDocumentTypeEO eo = new FmDocumentTypeEO();
        eo.setAllowNewClient(entity.getAllowNewClient());
        eo.setAppInd(AppInd.byValue(entity.getAppInd()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setDocumentTypeShort(entity.getDocumentTypeShort());
        eo.setDocumentTypeDesc(entity.getDocumentTypeDesc());
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        return eo;
    }

    public static FmDocumentType eoToEntity(FmDocumentTypeEO eo) {
        if (eo == null) {
            return null;
        }
        FmDocumentType entity = new FmDocumentType();
        entity.setAllowNewClient(eo.getAllowNewClient());
        entity.setAppInd(eo.getAppInd() == null ? null : eo.getAppInd().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setDocumentTypeShort(eo.getDocumentTypeShort());
        entity.setDocumentTypeDesc(eo.getDocumentTypeDesc());
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        return entity;
    }

    public static FmDocumentTypeExample eoToEntityExample(FmDocumentTypeEO eo) {
        if (eo == null) {
            return null;
        }
        FmDocumentTypeExample example = new FmDocumentTypeExample();
        FmDocumentTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getAllowNewClient() != null) criteria.andAllowNewClientEqualTo(eo.getAllowNewClient());
        if (eo.getAppInd() != null) criteria.andAppIndEqualTo(eo.getAppInd().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getDocumentTypeShort() != null) criteria.andDocumentTypeShortEqualTo(eo.getDocumentTypeShort());
        if (eo.getDocumentTypeDesc() != null) criteria.andDocumentTypeDescEqualTo(eo.getDocumentTypeDesc());
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        return example;
    }
}