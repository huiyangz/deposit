package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbBusAgreementOverdraft;
import com.dcits.depsit.entity.RbBusAgreementOverdraftExample;
import com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO;
import com.dcits.depsit.enums.RbBusAgreementType;
import com.dcits.depsit.enums.GreementSignStatus;
import com.dcits.depsit.enums.OdMode;
import com.dcits.depsit.enums.TermType;
import com.dcits.depsit.enums.OdMethod;
import com.dcits.depsit.enums.OdMaturityRule;
import com.dcits.depsit.enums.AmortizeTimeType;
import com.dcits.depsit.enums.FeeType;
import com.dcits.depsit.enums.FeeTakenMode;
import com.dcits.depsit.enums.OdPayMethod;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.AgreementSignEffectStatus;
import com.dcits.depsit.enums.FeeTakenMode;
import com.dcits.depsit.enums.IsOverMonthSeasonOd;

public final class RbBusAgreementOverdraftValueUtil {
    private RbBusAgreementOverdraftValueUtil() {
    }

    public static RbBusAgreementOverdraftEO entityToEo(RbBusAgreementOverdraft entity) {
        if (entity == null) {
            return null;
        }
        RbBusAgreementOverdraftEO eo = new RbBusAgreementOverdraftEO();
        eo.setRbBusAgreementType(RbBusAgreementType.byValue(entity.getRbBusAgreementType()));
        eo.setGreementSignStatus(GreementSignStatus.byValue(entity.getGreementSignStatus()));
        eo.setAmortizeDay(entity.getAmortizeDay());
        eo.setLoanInternalKey(entity.getLoanInternalKey());
        eo.setIntBasisRate(entity.getIntBasisRate());
        eo.setOdAmt(entity.getOdAmt());
        eo.setEndDate(entity.getEndDate());
        eo.setOdMode(OdMode.byValue(entity.getOdMode()));
        eo.setStartDate(entity.getStartDate());
        eo.setOdTermType(TermType.byValue(entity.getOdTermType()));
        eo.setAmortizeStartDate(entity.getAmortizeStartDate());
        eo.setProdNo(entity.getProdNo());
        eo.setOdMethod(OdMethod.byValue(entity.getOdMethod()));
        eo.setOdMaturityRule(OdMaturityRule.byValue(entity.getOdMaturityRule()));
        eo.setAmortizeTimeType(AmortizeTimeType.byValue(entity.getAmortizeTimeType()));
        eo.setWhiteClientName(entity.getWhiteClientName());
        eo.setFeeType(FeeType.byValue(entity.getFeeType()));
        eo.setFeeRate(entity.getFeeRate());
        eo.setFeeTakenMode(FeeTakenMode.byValue(entity.getFeeTakenMode()));
        eo.setOdProdNo(entity.getOdProdNo());
        eo.setAmortizeMonth(entity.getAmortizeMonth());
        eo.setAmortizeEndDate(entity.getAmortizeEndDate());
        eo.setCrossPeriodRate(entity.getCrossPeriodRate());
        eo.setOdPayMethod(OdPayMethod.byValue(entity.getOdPayMethod()));
        eo.setOdCcy(Ccy.byValue(entity.getOdCcy()));
        eo.setAcctSeqNo(entity.getAcctSeqNo());
        eo.setAgreementId(entity.getAgreementId());
        eo.setPastDueRate(entity.getPastDueRate());
        eo.setOdTerm(entity.getOdTerm());
        eo.setOdStartAmt(entity.getOdStartAmt());
        eo.setAcctCcy(AcctCcy.byValue(entity.getAcctCcy()));
        eo.setChargePeriodFreq(RollFreq.byValue(entity.getChargePeriodFreq()));
        eo.setAmortizePeriodFreq(RollFreq.byValue(entity.getAmortizePeriodFreq()));
        eo.setBaseAcctNo(entity.getBaseAcctNo());
        eo.setProfitAmortizeFlag(entity.getProfitAmortizeFlag());
        eo.setOdGracePeriod(RollFreq.byValue(entity.getOdGracePeriod()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setAgreementSignEffectStatus(AgreementSignEffectStatus.byValue(entity.getAgreementSignEffectStatus()));
        eo.setFeeChargeType(FeeTakenMode.byValue(entity.getFeeChargeType()));
        eo.setIsOverMonthSeasonOd(IsOverMonthSeasonOd.byValue(entity.getIsOverMonthSeasonOd()));
        eo.setRealRate(entity.getRealRate());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        return eo;
    }

    public static RbBusAgreementOverdraft eoToEntity(RbBusAgreementOverdraftEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAgreementOverdraft entity = new RbBusAgreementOverdraft();
        entity.setRbBusAgreementType(eo.getRbBusAgreementType() == null ? null : eo.getRbBusAgreementType().getValue());
        entity.setGreementSignStatus(eo.getGreementSignStatus() == null ? null : eo.getGreementSignStatus().getValue());
        entity.setAmortizeDay(eo.getAmortizeDay());
        entity.setLoanInternalKey(eo.getLoanInternalKey());
        entity.setIntBasisRate(eo.getIntBasisRate());
        entity.setOdAmt(eo.getOdAmt());
        entity.setEndDate(eo.getEndDate());
        entity.setOdMode(eo.getOdMode() == null ? null : eo.getOdMode().getValue());
        entity.setStartDate(eo.getStartDate());
        entity.setOdTermType(eo.getOdTermType() == null ? null : eo.getOdTermType().getValue());
        entity.setAmortizeStartDate(eo.getAmortizeStartDate());
        entity.setProdNo(eo.getProdNo());
        entity.setOdMethod(eo.getOdMethod() == null ? null : eo.getOdMethod().getValue());
        entity.setOdMaturityRule(eo.getOdMaturityRule() == null ? null : eo.getOdMaturityRule().getValue());
        entity.setAmortizeTimeType(eo.getAmortizeTimeType() == null ? null : eo.getAmortizeTimeType().getValue());
        entity.setWhiteClientName(eo.getWhiteClientName());
        entity.setFeeType(eo.getFeeType() == null ? null : eo.getFeeType().getValue());
        entity.setFeeRate(eo.getFeeRate());
        entity.setFeeTakenMode(eo.getFeeTakenMode() == null ? null : eo.getFeeTakenMode().getValue());
        entity.setOdProdNo(eo.getOdProdNo());
        entity.setAmortizeMonth(eo.getAmortizeMonth());
        entity.setAmortizeEndDate(eo.getAmortizeEndDate());
        entity.setCrossPeriodRate(eo.getCrossPeriodRate());
        entity.setOdPayMethod(eo.getOdPayMethod() == null ? null : eo.getOdPayMethod().getValue());
        entity.setOdCcy(eo.getOdCcy() == null ? null : eo.getOdCcy().getValue());
        entity.setAcctSeqNo(eo.getAcctSeqNo());
        entity.setAgreementId(eo.getAgreementId());
        entity.setPastDueRate(eo.getPastDueRate());
        entity.setOdTerm(eo.getOdTerm());
        entity.setOdStartAmt(eo.getOdStartAmt());
        entity.setAcctCcy(eo.getAcctCcy() == null ? null : eo.getAcctCcy().getValue());
        entity.setChargePeriodFreq(eo.getChargePeriodFreq() == null ? null : eo.getChargePeriodFreq().getValue());
        entity.setAmortizePeriodFreq(eo.getAmortizePeriodFreq() == null ? null : eo.getAmortizePeriodFreq().getValue());
        entity.setBaseAcctNo(eo.getBaseAcctNo());
        entity.setProfitAmortizeFlag(eo.getProfitAmortizeFlag());
        entity.setOdGracePeriod(eo.getOdGracePeriod() == null ? null : eo.getOdGracePeriod().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setAgreementSignEffectStatus(eo.getAgreementSignEffectStatus() == null ? null : eo.getAgreementSignEffectStatus().getValue());
        entity.setFeeChargeType(eo.getFeeChargeType() == null ? null : eo.getFeeChargeType().getValue());
        entity.setIsOverMonthSeasonOd(eo.getIsOverMonthSeasonOd() == null ? null : eo.getIsOverMonthSeasonOd().getValue());
        entity.setRealRate(eo.getRealRate());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        return entity;
    }

    public static RbBusAgreementOverdraftExample eoToEntityExample(RbBusAgreementOverdraftEO eo) {
        if (eo == null) {
            return null;
        }
        RbBusAgreementOverdraftExample example = new RbBusAgreementOverdraftExample();
        RbBusAgreementOverdraftExample.Criteria criteria = example.createCriteria();
        if (eo.getRbBusAgreementType() != null) criteria.andRbBusAgreementTypeEqualTo(eo.getRbBusAgreementType().getValue());
        if (eo.getGreementSignStatus() != null) criteria.andGreementSignStatusEqualTo(eo.getGreementSignStatus().getValue());
        if (eo.getAmortizeDay() != null) criteria.andAmortizeDayEqualTo(eo.getAmortizeDay());
        if (eo.getLoanInternalKey() != null) criteria.andLoanInternalKeyEqualTo(eo.getLoanInternalKey());
        if (eo.getIntBasisRate() != null) criteria.andIntBasisRateEqualTo(eo.getIntBasisRate());
        if (eo.getOdAmt() != null) criteria.andOdAmtEqualTo(eo.getOdAmt());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getOdMode() != null) criteria.andOdModeEqualTo(eo.getOdMode().getValue());
        if (eo.getStartDate() != null) criteria.andStartDateEqualTo(eo.getStartDate());
        if (eo.getOdTermType() != null) criteria.andOdTermTypeEqualTo(eo.getOdTermType().getValue());
        if (eo.getAmortizeStartDate() != null) criteria.andAmortizeStartDateEqualTo(eo.getAmortizeStartDate());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getOdMethod() != null) criteria.andOdMethodEqualTo(eo.getOdMethod().getValue());
        if (eo.getOdMaturityRule() != null) criteria.andOdMaturityRuleEqualTo(eo.getOdMaturityRule().getValue());
        if (eo.getAmortizeTimeType() != null) criteria.andAmortizeTimeTypeEqualTo(eo.getAmortizeTimeType().getValue());
        if (eo.getWhiteClientName() != null) criteria.andWhiteClientNameEqualTo(eo.getWhiteClientName());
        if (eo.getFeeType() != null) criteria.andFeeTypeEqualTo(eo.getFeeType().getValue());
        if (eo.getFeeRate() != null) criteria.andFeeRateEqualTo(eo.getFeeRate());
        if (eo.getFeeTakenMode() != null) criteria.andFeeTakenModeEqualTo(eo.getFeeTakenMode().getValue());
        if (eo.getOdProdNo() != null) criteria.andOdProdNoEqualTo(eo.getOdProdNo());
        if (eo.getAmortizeMonth() != null) criteria.andAmortizeMonthEqualTo(eo.getAmortizeMonth());
        if (eo.getAmortizeEndDate() != null) criteria.andAmortizeEndDateEqualTo(eo.getAmortizeEndDate());
        if (eo.getCrossPeriodRate() != null) criteria.andCrossPeriodRateEqualTo(eo.getCrossPeriodRate());
        if (eo.getOdPayMethod() != null) criteria.andOdPayMethodEqualTo(eo.getOdPayMethod().getValue());
        if (eo.getOdCcy() != null) criteria.andOdCcyEqualTo(eo.getOdCcy().getValue());
        if (eo.getAcctSeqNo() != null) criteria.andAcctSeqNoEqualTo(eo.getAcctSeqNo());
        if (eo.getAgreementId() != null) criteria.andAgreementIdEqualTo(eo.getAgreementId());
        if (eo.getPastDueRate() != null) criteria.andPastDueRateEqualTo(eo.getPastDueRate());
        if (eo.getOdTerm() != null) criteria.andOdTermEqualTo(eo.getOdTerm());
        if (eo.getOdStartAmt() != null) criteria.andOdStartAmtEqualTo(eo.getOdStartAmt());
        if (eo.getAcctCcy() != null) criteria.andAcctCcyEqualTo(eo.getAcctCcy().getValue());
        if (eo.getChargePeriodFreq() != null) criteria.andChargePeriodFreqEqualTo(eo.getChargePeriodFreq().getValue());
        if (eo.getAmortizePeriodFreq() != null) criteria.andAmortizePeriodFreqEqualTo(eo.getAmortizePeriodFreq().getValue());
        if (eo.getBaseAcctNo() != null) criteria.andBaseAcctNoEqualTo(eo.getBaseAcctNo());
        if (eo.getProfitAmortizeFlag() != null) criteria.andProfitAmortizeFlagEqualTo(eo.getProfitAmortizeFlag());
        if (eo.getOdGracePeriod() != null) criteria.andOdGracePeriodEqualTo(eo.getOdGracePeriod().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getAgreementSignEffectStatus() != null) criteria.andAgreementSignEffectStatusEqualTo(eo.getAgreementSignEffectStatus().getValue());
        if (eo.getFeeChargeType() != null) criteria.andFeeChargeTypeEqualTo(eo.getFeeChargeType().getValue());
        if (eo.getIsOverMonthSeasonOd() != null) criteria.andIsOverMonthSeasonOdEqualTo(eo.getIsOverMonthSeasonOd().getValue());
        if (eo.getRealRate() != null) criteria.andRealRateEqualTo(eo.getRealRate());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        return example;
    }
}