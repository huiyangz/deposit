package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbIntLayerRate;
import com.dcits.deposit.entity.RbIntLayerRateExample;
import com.dcits.deposit.facade.eo.RbIntLayerRateEO;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.NearPeriodType;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.YearBasis;
import com.dcits.deposit.enums.Company;

public final class RbIntLayerRateValueUtil {
    private RbIntLayerRateValueUtil() {
    }

    public static RbIntLayerRateEO entityToEo(RbIntLayerRate entity) {
        if (entity == null) {
            return null;
        }
        RbIntLayerRateEO eo = new RbIntLayerRateEO();
        eo.setIrlSeqNo(entity.getIrlSeqNo());
        eo.setAgreementId(entity.getAgreementId());
        eo.setInternalKey(entity.getInternalKey());
        eo.setClientNo(entity.getClientNo());
        eo.setAcctFixedRate(entity.getAcctFixedRate());
        eo.setAcctPercentRate(entity.getAcctPercentRate());
        eo.setAcctSpreadRate(entity.getAcctSpreadRate());
        eo.setNearPeriod(CycleFreq.byValue(entity.getNearPeriod()));
        eo.setNearPeriodType(NearPeriodType.byValue(entity.getNearPeriodType()));
        eo.setStartDate(entity.getStartDate());
        eo.setEndDate(entity.getEndDate());
        eo.setAccrDays(entity.getAccrDays());
        eo.setAccrAmt(entity.getAccrAmt());
        eo.setNearAmt(entity.getNearAmt());
        eo.setIntClass(IntClass.byValue(entity.getIntClass()));
        eo.setIntType(IntType.byValue(entity.getIntType()));
        eo.setRealRate(entity.getRealRate());
        eo.setActualRate(entity.getActualRate());
        eo.setFloatRate(entity.getFloatRate());
        eo.setMonthBasis(MonthBasis.byValue(entity.getMonthBasis()));
        eo.setYearBasis(YearBasis.byValue(entity.getYearBasis()));
        eo.setSystemId(entity.getSystemId());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        return eo;
    }

    public static RbIntLayerRate eoToEntity(RbIntLayerRateEO eo) {
        if (eo == null) {
            return null;
        }
        RbIntLayerRate entity = new RbIntLayerRate();
        entity.setIrlSeqNo(eo.getIrlSeqNo());
        entity.setAgreementId(eo.getAgreementId());
        entity.setInternalKey(eo.getInternalKey());
        entity.setClientNo(eo.getClientNo());
        entity.setAcctFixedRate(eo.getAcctFixedRate());
        entity.setAcctPercentRate(eo.getAcctPercentRate());
        entity.setAcctSpreadRate(eo.getAcctSpreadRate());
        entity.setNearPeriod(eo.getNearPeriod() == null ? null : eo.getNearPeriod().getValue());
        entity.setNearPeriodType(eo.getNearPeriodType() == null ? null : eo.getNearPeriodType().getValue());
        entity.setStartDate(eo.getStartDate());
        entity.setEndDate(eo.getEndDate());
        entity.setAccrDays(eo.getAccrDays());
        entity.setAccrAmt(eo.getAccrAmt());
        entity.setNearAmt(eo.getNearAmt());
        entity.setIntClass(eo.getIntClass() == null ? null : eo.getIntClass().getValue());
        entity.setIntType(eo.getIntType() == null ? null : eo.getIntType().getValue());
        entity.setRealRate(eo.getRealRate());
        entity.setActualRate(eo.getActualRate());
        entity.setFloatRate(eo.getFloatRate());
        entity.setMonthBasis(eo.getMonthBasis() == null ? null : eo.getMonthBasis().getValue());
        entity.setYearBasis(eo.getYearBasis() == null ? null : eo.getYearBasis().getValue());
        entity.setSystemId(eo.getSystemId());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        return entity;
    }

    public static RbIntLayerRateExample eoToEntityExample(RbIntLayerRateEO eo) {
        if (eo == null) {
            return null;
        }
        RbIntLayerRateExample example = new RbIntLayerRateExample();
        RbIntLayerRateExample.Criteria criteria = example.createCriteria();
        if (eo.getIrlSeqNo() != null) criteria.andIrlSeqNoEqualTo(eo.getIrlSeqNo());
        if (eo.getAgreementId() != null) criteria.andAgreementIdEqualTo(eo.getAgreementId());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getAcctFixedRate() != null) criteria.andAcctFixedRateEqualTo(eo.getAcctFixedRate());
        if (eo.getAcctPercentRate() != null) criteria.andAcctPercentRateEqualTo(eo.getAcctPercentRate());
        if (eo.getAcctSpreadRate() != null) criteria.andAcctSpreadRateEqualTo(eo.getAcctSpreadRate());
        if (eo.getNearPeriod() != null) criteria.andNearPeriodEqualTo(eo.getNearPeriod().getValue());
        if (eo.getNearPeriodType() != null) criteria.andNearPeriodTypeEqualTo(eo.getNearPeriodType().getValue());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getAccrDays() != null) criteria.andAccrDaysEqualTo(eo.getAccrDays());
        if (eo.getAccrAmt() != null) criteria.andAccrAmtEqualTo(eo.getAccrAmt());
        if (eo.getNearAmt() != null) criteria.andNearAmtEqualTo(eo.getNearAmt());
        if (eo.getIntClass() != null) criteria.andIntClassEqualTo(eo.getIntClass().getValue());
        if (eo.getIntType() != null) criteria.andIntTypeEqualTo(eo.getIntType().getValue());
        if (eo.getRealRate() != null) criteria.andRealRateEqualTo(eo.getRealRate());
        if (eo.getActualRate() != null) criteria.andActualRateEqualTo(eo.getActualRate());
        if (eo.getFloatRate() != null) criteria.andFloatRateEqualTo(eo.getFloatRate());
        if (eo.getMonthBasis() != null) criteria.andMonthBasisEqualTo(eo.getMonthBasis().getValue());
        if (eo.getYearBasis() != null) criteria.andYearBasisEqualTo(eo.getYearBasis().getValue());
        if (eo.getSystemId() != null) criteria.andSystemIdEqualTo(eo.getSystemId());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        return example;
    }
}