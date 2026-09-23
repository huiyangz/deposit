package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbIntMatrix;
import com.dcits.deposit.entity.MbIntMatrixExample;
import com.dcits.deposit.facade.eo.MbIntMatrixEO;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.IntBasis;
import com.dcits.deposit.enums.YearBasisType;

public final class MbIntMatrixValueUtil {
    private MbIntMatrixValueUtil() {
    }

    public static MbIntMatrixEO entityToEo(MbIntMatrix entity) {
        if (entity == null) {
            return null;
        }
        MbIntMatrixEO eo = new MbIntMatrixEO();
        eo.setPeggedIntType(IntType.byValue(entity.getPeggedIntType()));
        eo.setMaxSpreadRate(entity.getMaxSpreadRate());
        eo.setCcy(Ccy.byValue(entity.getCcy()));
        eo.setBranch(TranBranch.byValue(entity.getBranch()));
        eo.setMatrixAmt(entity.getMatrixAmt());
        eo.setCompany(entity.getCompany());
        eo.setMinSpreadPercent(entity.getMinSpreadPercent());
        eo.setSpreadRate(entity.getSpreadRate());
        eo.setMaxSpreadPercent(entity.getMaxSpreadPercent());
        eo.setBaseRate(entity.getBaseRate());
        eo.setMinSpreadRate(entity.getMinSpreadRate());
        eo.setMatrixNo(entity.getMatrixNo());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setMaxPercent(entity.getMaxPercent());
        eo.setPeriodFreq(RollFreq.byValue(entity.getPeriodFreq()));
        eo.setIntType(IntType.byValue(entity.getIntType()));
        eo.setDayNum(entity.getDayNum());
        eo.setActualRate(entity.getActualRate());
        eo.setIntBasis(IntBasis.byValue(entity.getIntBasis()));
        eo.setSpreadPercent(entity.getSpreadPercent());
        eo.setMaxRate(entity.getMaxRate());
        eo.setEffectDate(entity.getEffectDate());
        eo.setMinPercent(entity.getMinPercent());
        eo.setMinRate(entity.getMinRate());
        eo.setYearBasis(YearBasisType.byValue(entity.getYearBasis()));
        eo.setDiscRate(entity.getDiscRate());
        return eo;
    }

    public static MbIntMatrix eoToEntity(MbIntMatrixEO eo) {
        if (eo == null) {
            return null;
        }
        MbIntMatrix entity = new MbIntMatrix();
        entity.setPeggedIntType(eo.getPeggedIntType() == null ? null : eo.getPeggedIntType().getValue());
        entity.setMaxSpreadRate(eo.getMaxSpreadRate());
        entity.setCcy(eo.getCcy() == null ? null : eo.getCcy().getValue());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setMatrixAmt(eo.getMatrixAmt());
        entity.setCompany(eo.getCompany());
        entity.setMinSpreadPercent(eo.getMinSpreadPercent());
        entity.setSpreadRate(eo.getSpreadRate());
        entity.setMaxSpreadPercent(eo.getMaxSpreadPercent());
        entity.setBaseRate(eo.getBaseRate());
        entity.setMinSpreadRate(eo.getMinSpreadRate());
        entity.setMatrixNo(eo.getMatrixNo());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setMaxPercent(eo.getMaxPercent());
        entity.setPeriodFreq(eo.getPeriodFreq() == null ? null : eo.getPeriodFreq().getValue());
        entity.setIntType(eo.getIntType() == null ? null : eo.getIntType().getValue());
        entity.setDayNum(eo.getDayNum());
        entity.setActualRate(eo.getActualRate());
        entity.setIntBasis(eo.getIntBasis() == null ? null : eo.getIntBasis().getValue());
        entity.setSpreadPercent(eo.getSpreadPercent());
        entity.setMaxRate(eo.getMaxRate());
        entity.setEffectDate(eo.getEffectDate());
        entity.setMinPercent(eo.getMinPercent());
        entity.setMinRate(eo.getMinRate());
        entity.setYearBasis(eo.getYearBasis() == null ? null : eo.getYearBasis().getValue());
        entity.setDiscRate(eo.getDiscRate());
        return entity;
    }

    public static MbIntMatrixExample eoToEntityExample(MbIntMatrixEO eo) {
        if (eo == null) {
            return null;
        }
        MbIntMatrixExample example = new MbIntMatrixExample();
        MbIntMatrixExample.Criteria criteria = example.createCriteria();
        if (eo.getPeggedIntType() != null) criteria.andPeggedIntTypeEqualTo(eo.getPeggedIntType().getValue());
        if (eo.getMaxSpreadRate() != null) criteria.andMaxSpreadRateEqualTo(eo.getMaxSpreadRate());
        if (eo.getCcy() != null) criteria.andCcyEqualTo(eo.getCcy().getValue());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getMatrixAmt() != null) criteria.andMatrixAmtEqualTo(eo.getMatrixAmt());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany());
        if (eo.getMinSpreadPercent() != null) criteria.andMinSpreadPercentEqualTo(eo.getMinSpreadPercent());
        if (eo.getSpreadRate() != null) criteria.andSpreadRateEqualTo(eo.getSpreadRate());
        if (eo.getMaxSpreadPercent() != null) criteria.andMaxSpreadPercentEqualTo(eo.getMaxSpreadPercent());
        if (eo.getBaseRate() != null) criteria.andBaseRateEqualTo(eo.getBaseRate());
        if (eo.getMinSpreadRate() != null) criteria.andMinSpreadRateEqualTo(eo.getMinSpreadRate());
        if (eo.getMatrixNo() != null) criteria.andMatrixNoEqualTo(eo.getMatrixNo());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getMaxPercent() != null) criteria.andMaxPercentEqualTo(eo.getMaxPercent());
        if (eo.getPeriodFreq() != null) criteria.andPeriodFreqEqualTo(eo.getPeriodFreq().getValue());
        if (eo.getIntType() != null) criteria.andIntTypeEqualTo(eo.getIntType().getValue());
        if (eo.getDayNum() != null) criteria.andDayNumEqualTo(eo.getDayNum());
        if (eo.getActualRate() != null) criteria.andActualRateEqualTo(eo.getActualRate());
        if (eo.getIntBasis() != null) criteria.andIntBasisEqualTo(eo.getIntBasis().getValue());
        if (eo.getSpreadPercent() != null) criteria.andSpreadPercentEqualTo(eo.getSpreadPercent());
        if (eo.getMaxRate() != null) criteria.andMaxRateEqualTo(eo.getMaxRate());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getMinPercent() != null) criteria.andMinPercentEqualTo(eo.getMinPercent());
        if (eo.getMinRate() != null) criteria.andMinRateEqualTo(eo.getMinRate());
        if (eo.getYearBasis() != null) criteria.andYearBasisEqualTo(eo.getYearBasis().getValue());
        if (eo.getDiscRate() != null) criteria.andDiscRateEqualTo(eo.getDiscRate());
        return example;
    }
}