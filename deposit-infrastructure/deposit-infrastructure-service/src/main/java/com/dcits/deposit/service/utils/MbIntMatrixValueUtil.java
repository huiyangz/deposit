package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbIntMatrix;
import com.dcits.deposit.entity.MbIntMatrixExample;
import com.dcits.deposit.facade.eo.MbIntMatrixEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.YearBasis;
import com.dcits.deposit.enums.IntBasis;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IntType;

public final class MbIntMatrixValueUtil {
    private MbIntMatrixValueUtil() {
    }

    public static MbIntMatrixEO entityToEo(MbIntMatrix entity) {
        if (entity == null) {
            return null;
        }
        MbIntMatrixEO eo = new MbIntMatrixEO();
        eo.setMatrixNo(entity.getMatrixNo());
        eo.setBranch(AcctBranch.byValue(entity.getBranch()));
        eo.setCcy(AcctCcy.byValue(entity.getCcy()));
        eo.setIntType(IntType.byValue(entity.getIntType()));
        eo.setYearBasis(YearBasis.byValue(entity.getYearBasis()));
        eo.setEffectDate(entity.getEffectDate());
        eo.setIntBasis(IntBasis.byValue(entity.getIntBasis()));
        eo.setBaseRate(entity.getBaseRate());
        eo.setPeriodFreq(CycleFreq.byValue(entity.getPeriodFreq()));
        eo.setDayNum(entity.getDayNum());
        eo.setMatrixAmt(entity.getMatrixAmt());
        eo.setActualRate(entity.getActualRate());
        eo.setDiscRate(entity.getDiscRate());
        eo.setSpreadPercent(entity.getSpreadPercent());
        eo.setSpreadRate(entity.getSpreadRate());
        eo.setMaxPercent(entity.getMaxPercent());
        eo.setMinPercent(entity.getMinPercent());
        eo.setMinRate(entity.getMinRate());
        eo.setMaxRate(entity.getMaxRate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setMinSpreadRate(entity.getMinSpreadRate());
        eo.setMinSpreadPercent(entity.getMinSpreadPercent());
        eo.setMaxSpreadRate(entity.getMaxSpreadRate());
        eo.setMaxSpreadPercent(entity.getMaxSpreadPercent());
        eo.setPeggedIntType(IntType.byValue(entity.getPeggedIntType()));
        return eo;
    }

    public static MbIntMatrix eoToEntity(MbIntMatrixEO eo) {
        if (eo == null) {
            return null;
        }
        MbIntMatrix entity = new MbIntMatrix();
        entity.setMatrixNo(eo.getMatrixNo());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setIntType(eo.getIntType() == null ? null : eo.getIntType().getValue());
        entity.setYearBasis(eo.getYearBasis() == null ? null : eo.getYearBasis().getValue());
        entity.setEffectDate(eo.getEffectDate());
        entity.setIntBasis(eo.getIntBasis() == null ? null : eo.getIntBasis().getValue());
        entity.setBaseRate(eo.getBaseRate());
        entity.setPeriodFreq(eo.getPeriodFreq() == null ? null : eo.getPeriodFreq().getValue());
        entity.setDayNum(eo.getDayNum());
        entity.setMatrixAmt(eo.getMatrixAmt());
        entity.setActualRate(eo.getActualRate());
        entity.setDiscRate(eo.getDiscRate());
        entity.setSpreadPercent(eo.getSpreadPercent());
        entity.setSpreadRate(eo.getSpreadRate());
        entity.setMaxPercent(eo.getMaxPercent());
        entity.setMinPercent(eo.getMinPercent());
        entity.setMinRate(eo.getMinRate());
        entity.setMaxRate(eo.getMaxRate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setMinSpreadRate(eo.getMinSpreadRate());
        entity.setMinSpreadPercent(eo.getMinSpreadPercent());
        entity.setMaxSpreadRate(eo.getMaxSpreadRate());
        entity.setMaxSpreadPercent(eo.getMaxSpreadPercent());
        entity.setPeggedIntType(eo.getPeggedIntType() == null ? null : eo.getPeggedIntType().getValue());
        return entity;
    }

    public static MbIntMatrixExample eoToEntityExample(MbIntMatrixEO eo) {
        if (eo == null) {
            return null;
        }
        MbIntMatrixExample example = new MbIntMatrixExample();
        MbIntMatrixExample.Criteria criteria = example.createCriteria();
        if (eo.getMatrixNo() != null) criteria.andMatrixNoEqualTo(eo.getMatrixNo());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getIntType() != null) criteria.andIntTypeEqualTo(eo.getIntType().getValue());
        if (eo.getYearBasis() != null) criteria.andYearBasisEqualTo(eo.getYearBasis().getValue());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getIntBasis() != null) criteria.andIntBasisEqualTo(eo.getIntBasis().getValue());
        if (eo.getBaseRate() != null) criteria.andBaseRateEqualTo(eo.getBaseRate());
        if (eo.getPeriodFreq() != null) criteria.andPeriodFreqEqualTo(eo.getPeriodFreq().getValue());
        if (eo.getDayNum() != null) criteria.andDayNumEqualTo(eo.getDayNum());
        if (eo.getMatrixAmt() != null) criteria.andMatrixAmtEqualTo(eo.getMatrixAmt());
        if (eo.getActualRate() != null) criteria.andActualRateEqualTo(eo.getActualRate());
        if (eo.getDiscRate() != null) criteria.andDiscRateEqualTo(eo.getDiscRate());
        if (eo.getSpreadPercent() != null) criteria.andSpreadPercentEqualTo(eo.getSpreadPercent());
        if (eo.getSpreadRate() != null) criteria.andSpreadRateEqualTo(eo.getSpreadRate());
        if (eo.getMaxPercent() != null) criteria.andMaxPercentEqualTo(eo.getMaxPercent());
        if (eo.getMinPercent() != null) criteria.andMinPercentEqualTo(eo.getMinPercent());
        if (eo.getMinRate() != null) criteria.andMinRateEqualTo(eo.getMinRate());
        if (eo.getMaxRate() != null) criteria.andMaxRateEqualTo(eo.getMaxRate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getMinSpreadRate() != null) criteria.andMinSpreadRateEqualTo(eo.getMinSpreadRate());
        if (eo.getMinSpreadPercent() != null) criteria.andMinSpreadPercentEqualTo(eo.getMinSpreadPercent());
        if (eo.getMaxSpreadRate() != null) criteria.andMaxSpreadRateEqualTo(eo.getMaxSpreadRate());
        if (eo.getMaxSpreadPercent() != null) criteria.andMaxSpreadPercentEqualTo(eo.getMaxSpreadPercent());
        if (eo.getPeggedIntType() != null) criteria.andPeggedIntTypeEqualTo(eo.getPeggedIntType().getValue());
        return example;
    }
}