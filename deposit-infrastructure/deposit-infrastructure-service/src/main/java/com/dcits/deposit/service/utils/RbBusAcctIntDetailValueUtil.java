package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbBusAcctIntDetail;
import com.dcits.deposit.entity.RbBusAcctIntDetailExample;
import com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.FloatType;
import com.dcits.deposit.enums.YearBasisType;
import com.dcits.deposit.enums.IntCalcBal;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.MonthBasisType;
import com.dcits.deposit.enums.IntChangeType;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.IntClass;

public final class RbBusAcctIntDetailValueUtil {
    private RbBusAcctIntDetailValueUtil() {
    }

    public static RbBusAcctIntDetailEO entityToEo(RbBusAcctIntDetail entity) {
        if (entity == null) {
            return null;
        }
        RbBusAcctIntDetailEO eo = new RbBusAcctIntDetailEO();
        eo.setNextCycleDate(entity.getNextCycleDate());
        eo.setIntPastDue(entity.getIntPastDue());
        eo.setIntType(IntType.byValue(entity.getIntType()));
        eo.setIntAdjCtd(entity.getIntAdjCtd());
        eo.setSpreadRate(entity.getSpreadRate());
        eo.setFloatType(FloatType.byValue(entity.getFloatType()));
        eo.setSystemId(entity.getSystemId());
        eo.setDiscntIntPrev(entity.getDiscntIntPrev());
        eo.setYearBasisType(YearBasisType.byValue(entity.getYearBasisType()));
        eo.setSplitRateFlag(entity.getSplitRateFlag());
        eo.setIntAccrued(entity.getIntAccrued());
        eo.setLastIntPastDue(entity.getLastIntPastDue());
        eo.setAcctSpreadRate(entity.getAcctSpreadRate());
        eo.setTaxTypeNo(entity.getTaxTypeNo());
        eo.setCalcBeginDate(entity.getCalcBeginDate());
        eo.setIntAccruedCtd(entity.getIntAccruedCtd());
        eo.setInternalKey(entity.getInternalKey());
        eo.setIntPosted(entity.getIntPosted());
        eo.setIntFlag(entity.getIntFlag());
        eo.setRealRate(entity.getRealRate());
        eo.setLastAccrualDate(entity.getLastAccrualDate());
        eo.setIntCalcBal(IntCalcBal.byValue(entity.getIntCalcBal()));
        eo.setNextAccrDate(entity.getNextAccrDate());
        eo.setCycleFreq(RollFreq.byValue(entity.getCycleFreq()));
        eo.setCycleFlag(entity.getCycleFlag());
        eo.setMonthBasisType(MonthBasisType.byValue(entity.getMonthBasisType()));
        eo.setAgreeAgg(entity.getAgreeAgg());
        eo.setIntCapFlag(entity.getIntCapFlag());
        eo.setTaxRate(entity.getTaxRate());
        eo.setIntAccruedPrev(entity.getIntAccruedPrev());
        eo.setDiscntUiFlag(entity.getDiscntUiFlag());
        eo.setIntAmt(entity.getIntAmt());
        eo.setSpreadPercent(entity.getSpreadPercent());
        eo.setAcctPercentRate(entity.getAcctPercentRate());
        eo.setIntAdjPrev(entity.getIntAdjPrev());
        eo.setIntDay(entity.getIntDay());
        eo.setFloatRate(entity.getFloatRate());
        eo.setActualRate(entity.getActualRate());
        eo.setRetryFlag(entity.getRetryFlag());
        eo.setIntChangeType(IntChangeType.byValue(entity.getIntChangeType()));
        eo.setAcctFixedRate(entity.getAcctFixedRate());
        eo.setAgg(entity.getAgg());
        eo.setPastFadRate(entity.getPastFadRate());
        eo.setLayerAgreement(IntType.byValue(entity.getLayerAgreement()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setCalcEndDate(entity.getCalcEndDate());
        eo.setIntPostedCtd(entity.getIntPostedCtd());
        eo.setDiscntRetainInt(entity.getDiscntRetainInt());
        eo.setDiscntInt(entity.getDiscntInt());
        eo.setIntAdj(entity.getIntAdj());
        eo.setIntClass(IntClass.byValue(entity.getIntClass()));
        eo.setIntAccruedCalcCtd(entity.getIntAccruedCalcCtd());
        eo.setLastCycleDate(entity.getLastCycleDate());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTotalAgg(entity.getTotalAgg());
        eo.setIntAccruedDiff(entity.getIntAccruedDiff());
        return eo;
    }

    public static RbBusAcctIntDetail eoToEntity(RbBusAcctIntDetailEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctIntDetail entity = new RbBusAcctIntDetail();
        entity.setNextCycleDate(eo.getNextCycleDate());
        entity.setIntPastDue(eo.getIntPastDue());
        entity.setIntType(eo.getIntType() == null ? null : eo.getIntType().getValue());
        entity.setIntAdjCtd(eo.getIntAdjCtd());
        entity.setSpreadRate(eo.getSpreadRate());
        entity.setFloatType(eo.getFloatType() == null ? null : eo.getFloatType().getValue());
        entity.setSystemId(eo.getSystemId());
        entity.setDiscntIntPrev(eo.getDiscntIntPrev());
        entity.setYearBasisType(eo.getYearBasisType() == null ? null : eo.getYearBasisType().getValue());
        entity.setSplitRateFlag(eo.getSplitRateFlag());
        entity.setIntAccrued(eo.getIntAccrued());
        entity.setLastIntPastDue(eo.getLastIntPastDue());
        entity.setAcctSpreadRate(eo.getAcctSpreadRate());
        entity.setTaxTypeNo(eo.getTaxTypeNo());
        entity.setCalcBeginDate(eo.getCalcBeginDate());
        entity.setIntAccruedCtd(eo.getIntAccruedCtd());
        entity.setInternalKey(eo.getInternalKey());
        entity.setIntPosted(eo.getIntPosted());
        entity.setIntFlag(eo.getIntFlag());
        entity.setRealRate(eo.getRealRate());
        entity.setLastAccrualDate(eo.getLastAccrualDate());
        entity.setIntCalcBal(eo.getIntCalcBal() == null ? null : eo.getIntCalcBal().getValue());
        entity.setNextAccrDate(eo.getNextAccrDate());
        entity.setCycleFreq(eo.getCycleFreq() == null ? null : eo.getCycleFreq().getValue());
        entity.setCycleFlag(eo.getCycleFlag());
        entity.setMonthBasisType(eo.getMonthBasisType() == null ? null : eo.getMonthBasisType().getValue());
        entity.setAgreeAgg(eo.getAgreeAgg());
        entity.setIntCapFlag(eo.getIntCapFlag());
        entity.setTaxRate(eo.getTaxRate());
        entity.setIntAccruedPrev(eo.getIntAccruedPrev());
        entity.setDiscntUiFlag(eo.getDiscntUiFlag());
        entity.setIntAmt(eo.getIntAmt());
        entity.setSpreadPercent(eo.getSpreadPercent());
        entity.setAcctPercentRate(eo.getAcctPercentRate());
        entity.setIntAdjPrev(eo.getIntAdjPrev());
        entity.setIntDay(eo.getIntDay());
        entity.setFloatRate(eo.getFloatRate());
        entity.setActualRate(eo.getActualRate());
        entity.setRetryFlag(eo.getRetryFlag());
        entity.setIntChangeType(eo.getIntChangeType() == null ? null : eo.getIntChangeType().getValue());
        entity.setAcctFixedRate(eo.getAcctFixedRate());
        entity.setAgg(eo.getAgg());
        entity.setPastFadRate(eo.getPastFadRate());
        entity.setLayerAgreement(eo.getLayerAgreement() == null ? null : eo.getLayerAgreement().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setCalcEndDate(eo.getCalcEndDate());
        entity.setIntPostedCtd(eo.getIntPostedCtd());
        entity.setDiscntRetainInt(eo.getDiscntRetainInt());
        entity.setDiscntInt(eo.getDiscntInt());
        entity.setIntAdj(eo.getIntAdj());
        entity.setIntClass(eo.getIntClass() == null ? null : eo.getIntClass().getValue());
        entity.setIntAccruedCalcCtd(eo.getIntAccruedCalcCtd());
        entity.setLastCycleDate(eo.getLastCycleDate());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTotalAgg(eo.getTotalAgg());
        entity.setIntAccruedDiff(eo.getIntAccruedDiff());
        return entity;
    }

    public static RbBusAcctIntDetailExample eoToEntityExample(RbBusAcctIntDetailEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAcctIntDetailExample example = new RbBusAcctIntDetailExample();
        RbBusAcctIntDetailExample.Criteria criteria = example.createCriteria();
        if (eo.getNextCycleDate() != null) criteria.andNextCycleDateEqualTo(eo.getNextCycleDate());
        if (eo.getIntPastDue() != null) criteria.andIntPastDueEqualTo(eo.getIntPastDue());
        if (eo.getIntType() != null) criteria.andIntTypeEqualTo(eo.getIntType().getValue());
        if (eo.getIntAdjCtd() != null) criteria.andIntAdjCtdEqualTo(eo.getIntAdjCtd());
        if (eo.getSpreadRate() != null) criteria.andSpreadRateEqualTo(eo.getSpreadRate());
        if (eo.getFloatType() != null) criteria.andFloatTypeEqualTo(eo.getFloatType().getValue());
        if (eo.getSystemId() != null) criteria.andSystemIdEqualTo(eo.getSystemId());
        if (eo.getDiscntIntPrev() != null) criteria.andDiscntIntPrevEqualTo(eo.getDiscntIntPrev());
        if (eo.getYearBasisType() != null) criteria.andYearBasisTypeEqualTo(eo.getYearBasisType().getValue());
        if (eo.getSplitRateFlag() != null) criteria.andSplitRateFlagEqualTo(eo.getSplitRateFlag());
        if (eo.getIntAccrued() != null) criteria.andIntAccruedEqualTo(eo.getIntAccrued());
        if (eo.getLastIntPastDue() != null) criteria.andLastIntPastDueEqualTo(eo.getLastIntPastDue());
        if (eo.getAcctSpreadRate() != null) criteria.andAcctSpreadRateEqualTo(eo.getAcctSpreadRate());
        if (eo.getTaxTypeNo() != null) criteria.andTaxTypeNoEqualTo(eo.getTaxTypeNo());
        if (eo.getCalcBeginDate() != null) criteria.andCalcBeginDateEqualTo(eo.getCalcBeginDate());
        if (eo.getIntAccruedCtd() != null) criteria.andIntAccruedCtdEqualTo(eo.getIntAccruedCtd());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getIntPosted() != null) criteria.andIntPostedEqualTo(eo.getIntPosted());
        if (eo.getIntFlag() != null) criteria.andIntFlagEqualTo(eo.getIntFlag());
        if (eo.getRealRate() != null) criteria.andRealRateEqualTo(eo.getRealRate());
        if (eo.getLastAccrualDate() != null) criteria.andLastAccrualDateEqualTo(eo.getLastAccrualDate());
        if (eo.getIntCalcBal() != null) criteria.andIntCalcBalEqualTo(eo.getIntCalcBal().getValue());
        if (eo.getNextAccrDate() != null) criteria.andNextAccrDateEqualTo(eo.getNextAccrDate());
        if (eo.getCycleFreq() != null) criteria.andCycleFreqEqualTo(eo.getCycleFreq().getValue());
        if (eo.getCycleFlag() != null) criteria.andCycleFlagEqualTo(eo.getCycleFlag());
        if (eo.getMonthBasisType() != null) criteria.andMonthBasisTypeEqualTo(eo.getMonthBasisType().getValue());
        if (eo.getAgreeAgg() != null) criteria.andAgreeAggEqualTo(eo.getAgreeAgg());
        if (eo.getIntCapFlag() != null) criteria.andIntCapFlagEqualTo(eo.getIntCapFlag());
        if (eo.getTaxRate() != null) criteria.andTaxRateEqualTo(eo.getTaxRate());
        if (eo.getIntAccruedPrev() != null) criteria.andIntAccruedPrevEqualTo(eo.getIntAccruedPrev());
        if (eo.getDiscntUiFlag() != null) criteria.andDiscntUiFlagEqualTo(eo.getDiscntUiFlag());
        if (eo.getIntAmt() != null) criteria.andIntAmtEqualTo(eo.getIntAmt());
        if (eo.getSpreadPercent() != null) criteria.andSpreadPercentEqualTo(eo.getSpreadPercent());
        if (eo.getAcctPercentRate() != null) criteria.andAcctPercentRateEqualTo(eo.getAcctPercentRate());
        if (eo.getIntAdjPrev() != null) criteria.andIntAdjPrevEqualTo(eo.getIntAdjPrev());
        if (eo.getIntDay() != null) criteria.andIntDayEqualTo(eo.getIntDay());
        if (eo.getFloatRate() != null) criteria.andFloatRateEqualTo(eo.getFloatRate());
        if (eo.getActualRate() != null) criteria.andActualRateEqualTo(eo.getActualRate());
        if (eo.getRetryFlag() != null) criteria.andRetryFlagEqualTo(eo.getRetryFlag());
        if (eo.getIntChangeType() != null) criteria.andIntChangeTypeEqualTo(eo.getIntChangeType().getValue());
        if (eo.getAcctFixedRate() != null) criteria.andAcctFixedRateEqualTo(eo.getAcctFixedRate());
        if (eo.getAgg() != null) criteria.andAggEqualTo(eo.getAgg());
        if (eo.getPastFadRate() != null) criteria.andPastFadRateEqualTo(eo.getPastFadRate());
        if (eo.getLayerAgreement() != null) criteria.andLayerAgreementEqualTo(eo.getLayerAgreement().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getCalcEndDate() != null) criteria.andCalcEndDateEqualTo(eo.getCalcEndDate());
        if (eo.getIntPostedCtd() != null) criteria.andIntPostedCtdEqualTo(eo.getIntPostedCtd());
        if (eo.getDiscntRetainInt() != null) criteria.andDiscntRetainIntEqualTo(eo.getDiscntRetainInt());
        if (eo.getDiscntInt() != null) criteria.andDiscntIntEqualTo(eo.getDiscntInt());
        if (eo.getIntAdj() != null) criteria.andIntAdjEqualTo(eo.getIntAdj());
        if (eo.getIntClass() != null) criteria.andIntClassEqualTo(eo.getIntClass().getValue());
        if (eo.getIntAccruedCalcCtd() != null) criteria.andIntAccruedCalcCtdEqualTo(eo.getIntAccruedCalcCtd());
        if (eo.getLastCycleDate() != null) criteria.andLastCycleDateEqualTo(eo.getLastCycleDate());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTotalAgg() != null) criteria.andTotalAggEqualTo(eo.getTotalAgg());
        if (eo.getIntAccruedDiff() != null) criteria.andIntAccruedDiffEqualTo(eo.getIntAccruedDiff());
        return example;
    }
}