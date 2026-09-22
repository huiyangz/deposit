package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmDocumentType;
import com.dcits.deposit.entity.FmDocumentTypeExample;
import com.dcits.deposit.facade.eo.FmDocumentTypeEO;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AppInd;
import com.dcits.deposit.enums.Company;

public final class FmDocumentTypeValueUtil {
    private FmDocumentTypeValueUtil() {
    }

    public static FmDocumentTypeEO entityToEo(FmDocumentType entity) {
        if (entity == null) {
            return null;
        }
        FmDocumentTypeEO eo = new FmDocumentTypeEO();
        eo.setDocumentType(DocumentType.byValue(entity.getDocumentType()));
        eo.setDocumentTypeDesc(entity.getDocumentTypeDesc());
        eo.setDocumentTypeShort(entity.getDocumentTypeShort());
        eo.setAllowNewClient(IndividualFlag.byValue(entity.getAllowNewClient()));
        eo.setAppInd(AppInd.byValue(entity.getAppInd()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static FmDocumentType eoToEntity(FmDocumentTypeEO eo) {
        if (eo == null) {
            return null;
        }
        FmDocumentType entity = new FmDocumentType();
        entity.setDocumentType(eo.getDocumentType() == null ? null : eo.getDocumentType().getValue());
        entity.setDocumentTypeDesc(eo.getDocumentTypeDesc());
        entity.setDocumentTypeShort(eo.getDocumentTypeShort());
        entity.setAllowNewClient(eo.getAllowNewClient() == null ? null : eo.getAllowNewClient().getValue());
        entity.setAppInd(eo.getAppInd() == null ? null : eo.getAppInd().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static FmDocumentTypeExample eoToEntityExample(FmDocumentTypeEO eo) {
        if (eo == null) {
            return null;
        }
        FmDocumentTypeExample example = new FmDocumentTypeExample();
        FmDocumentTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getDocumentType() != null) criteria.andDocumentTypeEqualTo(eo.getDocumentType().getValue());
        if (eo.getDocumentTypeDesc() != null) criteria.andDocumentTypeDescEqualTo(eo.getDocumentTypeDesc());
        if (eo.getDocumentTypeShort() != null) criteria.andDocumentTypeShortEqualTo(eo.getDocumentTypeShort());
        if (eo.getAllowNewClient() != null) criteria.andAllowNewClientEqualTo(eo.getAllowNewClient().getValue());
        if (eo.getAppInd() != null) criteria.andAppIndEqualTo(eo.getAppInd().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}