package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmServiceDefine;
import com.dcits.deposit.entity.FmServiceDefineExample;
import com.dcits.deposit.facade.eo.FmServiceDefineEO;
import com.dcits.deposit.enums.BusiCategory;
import com.dcits.deposit.enums.BlacklistCheckFlag;
import com.dcits.deposit.enums.BlacklistCheckFlag;
import com.dcits.deposit.enums.MultiCorpCheckFlag;
import com.dcits.deposit.enums.AcrossBranCheckFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AllowReverseFlag;
import com.dcits.deposit.enums.Company;

public final class FmServiceDefineValueUtil {
    private FmServiceDefineValueUtil() {
    }

    public static FmServiceDefineEO entityToEo(FmServiceDefine entity) {
        if (entity == null) {
            return null;
        }
        FmServiceDefineEO eo = new FmServiceDefineEO();
        eo.setServiceCode(entity.getServiceCode());
        eo.setMessageType(entity.getMessageType());
        eo.setMessageCode(entity.getMessageCode());
        eo.setUrl(entity.getUrl());
        eo.setBusiCategory(BusiCategory.byValue(entity.getBusiCategory()));
        eo.setBusiSubClass(entity.getBusiSubClass());
        eo.setBlacklistCheckFlag(BlacklistCheckFlag.byValue(entity.getBlacklistCheckFlag()));
        eo.setWhiteListCheckFlag(BlacklistCheckFlag.byValue(entity.getWhiteListCheckFlag()));
        eo.setMultiCorpCheckFlag(MultiCorpCheckFlag.byValue(entity.getMultiCorpCheckFlag()));
        eo.setAcrossBranCheckFlag(AcrossBranCheckFlag.byValue(entity.getAcrossBranCheckFlag()));
        eo.setClientCheckFlag(IndividualFlag.byValue(entity.getClientCheckFlag()));
        eo.setAllowReverseFlag(AllowReverseFlag.byValue(entity.getAllowReverseFlag()));
        eo.setServiceStatus(entity.getServiceStatus());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static FmServiceDefine eoToEntity(FmServiceDefineEO eo) {
        if (eo == null) {
            return null;
        }
        FmServiceDefine entity = new FmServiceDefine();
        entity.setServiceCode(eo.getServiceCode());
        entity.setMessageType(eo.getMessageType());
        entity.setMessageCode(eo.getMessageCode());
        entity.setUrl(eo.getUrl());
        entity.setBusiCategory(eo.getBusiCategory() == null ? null : eo.getBusiCategory().getValue());
        entity.setBusiSubClass(eo.getBusiSubClass());
        entity.setBlacklistCheckFlag(eo.getBlacklistCheckFlag() == null ? null : eo.getBlacklistCheckFlag().getValue());
        entity.setWhiteListCheckFlag(eo.getWhiteListCheckFlag() == null ? null : eo.getWhiteListCheckFlag().getValue());
        entity.setMultiCorpCheckFlag(eo.getMultiCorpCheckFlag() == null ? null : eo.getMultiCorpCheckFlag().getValue());
        entity.setAcrossBranCheckFlag(eo.getAcrossBranCheckFlag() == null ? null : eo.getAcrossBranCheckFlag().getValue());
        entity.setClientCheckFlag(eo.getClientCheckFlag() == null ? null : eo.getClientCheckFlag().getValue());
        entity.setAllowReverseFlag(eo.getAllowReverseFlag() == null ? null : eo.getAllowReverseFlag().getValue());
        entity.setServiceStatus(eo.getServiceStatus());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static FmServiceDefineExample eoToEntityExample(FmServiceDefineEO eo) {
        if (eo == null) {
            return null;
        }
        FmServiceDefineExample example = new FmServiceDefineExample();
        FmServiceDefineExample.Criteria criteria = example.createCriteria();
        if (eo.getServiceCode() != null) criteria.andServiceCodeEqualTo(eo.getServiceCode());
        if (eo.getMessageType() != null) criteria.andMessageTypeEqualTo(eo.getMessageType());
        if (eo.getMessageCode() != null) criteria.andMessageCodeEqualTo(eo.getMessageCode());
        if (eo.getUrl() != null) criteria.andUrlEqualTo(eo.getUrl());
        if (eo.getBusiCategory() != null) criteria.andBusiCategoryEqualTo(eo.getBusiCategory().getValue());
        if (eo.getBusiSubClass() != null) criteria.andBusiSubClassEqualTo(eo.getBusiSubClass());
        if (eo.getBlacklistCheckFlag() != null) criteria.andBlacklistCheckFlagEqualTo(eo.getBlacklistCheckFlag().getValue());
        if (eo.getWhiteListCheckFlag() != null) criteria.andWhiteListCheckFlagEqualTo(eo.getWhiteListCheckFlag().getValue());
        if (eo.getMultiCorpCheckFlag() != null) criteria.andMultiCorpCheckFlagEqualTo(eo.getMultiCorpCheckFlag().getValue());
        if (eo.getAcrossBranCheckFlag() != null) criteria.andAcrossBranCheckFlagEqualTo(eo.getAcrossBranCheckFlag().getValue());
        if (eo.getClientCheckFlag() != null) criteria.andClientCheckFlagEqualTo(eo.getClientCheckFlag().getValue());
        if (eo.getAllowReverseFlag() != null) criteria.andAllowReverseFlagEqualTo(eo.getAllowReverseFlag().getValue());
        if (eo.getServiceStatus() != null) criteria.andServiceStatusEqualTo(eo.getServiceStatus());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}