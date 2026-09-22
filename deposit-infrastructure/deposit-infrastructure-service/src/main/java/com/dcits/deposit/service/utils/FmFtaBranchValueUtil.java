package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.FmFtaBranch;
import com.dcits.deposit.entity.FmFtaBranchExample;
import com.dcits.deposit.facade.eo.FmFtaBranchEO;
import com.dcits.deposit.enums.FtaType;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.FtaNature;
import com.dcits.deposit.enums.Company;

public final class FmFtaBranchValueUtil {
    private FmFtaBranchValueUtil() {
    }

    public static FmFtaBranchEO entityToEo(FmFtaBranch entity) {
        if (entity == null) {
            return null;
        }
        FmFtaBranchEO eo = new FmFtaBranchEO();
        eo.setFtaCode(entity.getFtaCode());
        eo.setFtaDesc(entity.getFtaDesc());
        eo.setFtaType(FtaType.byValue(entity.getFtaType()));
        eo.setFtaRateType(RateType.byValue(entity.getFtaRateType()));
        eo.setFtaNature(FtaNature.byValue(entity.getFtaNature()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static FmFtaBranch eoToEntity(FmFtaBranchEO eo) {
        if (eo == null) {
            return null;
        }
        FmFtaBranch entity = new FmFtaBranch();
        entity.setFtaCode(eo.getFtaCode());
        entity.setFtaDesc(eo.getFtaDesc());
        entity.setFtaType(eo.getFtaType() == null ? null : eo.getFtaType().getValue());
        entity.setFtaRateType(eo.getFtaRateType() == null ? null : eo.getFtaRateType().getValue());
        entity.setFtaNature(eo.getFtaNature() == null ? null : eo.getFtaNature().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static FmFtaBranchExample eoToEntityExample(FmFtaBranchEO eo) {
        if (eo == null) {
            return null;
        }
        FmFtaBranchExample example = new FmFtaBranchExample();
        FmFtaBranchExample.Criteria criteria = example.createCriteria();
        if (eo.getFtaCode() != null) criteria.andFtaCodeEqualTo(eo.getFtaCode());
        if (eo.getFtaDesc() != null) criteria.andFtaDescEqualTo(eo.getFtaDesc());
        if (eo.getFtaType() != null) criteria.andFtaTypeEqualTo(eo.getFtaType().getValue());
        if (eo.getFtaRateType() != null) criteria.andFtaRateTypeEqualTo(eo.getFtaRateType().getValue());
        if (eo.getFtaNature() != null) criteria.andFtaNatureEqualTo(eo.getFtaNature().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}