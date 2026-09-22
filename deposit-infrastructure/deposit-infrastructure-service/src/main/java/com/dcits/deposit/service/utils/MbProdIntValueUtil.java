package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbProdInt;
import com.dcits.deposit.entity.MbProdIntExample;
import com.dcits.deposit.facade.eo.MbProdIntEO;
import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.TaxType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntCalcMethod;
import com.dcits.deposit.enums.RateLayerRule;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.GearAmtInd;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.GearAmtInd;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.EffectDateCalcMethod;
import com.dcits.deposit.enums.DaysGearType;
import com.dcits.deposit.enums.IntApplType;
import com.dcits.deposit.enums.MonthBasis;
import com.dcits.deposit.enums.GroupRuleType;
import com.dcits.deposit.enums.IntMatchRule;
import com.dcits.deposit.enums.IntRecalcMethod;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.YearBasis;

public final class MbProdIntValueUtil {
    private MbProdIntValueUtil() {
    }

    public static MbProdIntEO entityToEo(MbProdInt entity) {
        if (entity == null) {
            return null;
        }
        MbProdIntEO eo = new MbProdIntEO();
        eo.setProdType(entity.getProdType());
        eo.setEventType(entity.getEventType());
        eo.setIntClass(IntClass.byValue(entity.getIntClass()));
        eo.setIntType(IntType.byValue(entity.getIntType()));
        eo.setTaxType(TaxType.byValue(entity.getTaxType()));
        eo.setAcctRateFlag(IndividualFlag.byValue(entity.getAcctRateFlag()));
        eo.setIntCalcMethod(IntCalcMethod.byValue(entity.getIntCalcMethod()));
        eo.setRateLayerRule(RateLayerRule.byValue(entity.getRateLayerRule()));
        eo.setRateGearAmtType(AmtType.byValue(entity.getRateGearAmtType()));
        eo.setGearAmtInd(GearAmtInd.byValue(entity.getGearAmtInd()));
        eo.setGearAmtMethod(GearAmtMethod.byValue(entity.getGearAmtMethod()));
        eo.setGearDaysInd(GearAmtInd.byValue(entity.getGearDaysInd()));
        eo.setGearDaysMethod(GearAmtMethod.byValue(entity.getGearDaysMethod()));
        eo.setIntCalcAmtType(AmtType.byValue(entity.getIntCalcAmtType()));
        eo.setEffectDateCalcMethod(EffectDateCalcMethod.byValue(entity.getEffectDateCalcMethod()));
        eo.setDaysGearType(DaysGearType.byValue(entity.getDaysGearType()));
        eo.setIntApplType(IntApplType.byValue(entity.getIntApplType()));
        eo.setMonthBasis(MonthBasis.byValue(entity.getMonthBasis()));
        eo.setGroupRuleType(GroupRuleType.byValue(entity.getGroupRuleType()));
        eo.setIntMatchRule(IntMatchRule.byValue(entity.getIntMatchRule()));
        eo.setIntRecalcMethod(IntRecalcMethod.byValue(entity.getIntRecalcMethod()));
        eo.setMinRate(entity.getMinRate());
        eo.setMaxRate(entity.getMaxRate());
        eo.setRollDay(entity.getRollDay());
        eo.setRollFreq(CycleFreq.byValue(entity.getRollFreq()));
        eo.setRoundDownFlag(entity.getRoundDownFlag());
        eo.setIntTypeExp(entity.getIntTypeExp());
        eo.setMonthBasisExp(entity.getMonthBasisExp());
        eo.setGroupRuleTypeExp(entity.getGroupRuleTypeExp());
        eo.setMinRateExp(entity.getMinRateExp());
        eo.setMaxRateExp(entity.getMaxRateExp());
        eo.setIntCalcMethodExp(entity.getIntCalcMethodExp());
        eo.setIntCalcAmtTypeExp(entity.getIntCalcAmtTypeExp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setSpreadPercent(entity.getSpreadPercent());
        eo.setSpreadRate(entity.getSpreadRate());
        eo.setCalcByInt(IndividualFlag.byValue(entity.getCalcByInt()));
        eo.setYearBasis(YearBasis.byValue(entity.getYearBasis()));
        return eo;
    }

    public static MbProdInt eoToEntity(MbProdIntEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdInt entity = new MbProdInt();
        entity.setProdType(eo.getProdType());
        entity.setEventType(eo.getEventType());
        entity.setIntClass(eo.getIntClass() == null ? null : eo.getIntClass().getValue());
        entity.setIntType(eo.getIntType() == null ? null : eo.getIntType().getValue());
        entity.setTaxType(eo.getTaxType() == null ? null : eo.getTaxType().getValue());
        entity.setAcctRateFlag(eo.getAcctRateFlag() == null ? null : eo.getAcctRateFlag().getValue());
        entity.setIntCalcMethod(eo.getIntCalcMethod() == null ? null : eo.getIntCalcMethod().getValue());
        entity.setRateLayerRule(eo.getRateLayerRule() == null ? null : eo.getRateLayerRule().getValue());
        entity.setRateGearAmtType(eo.getRateGearAmtType() == null ? null : eo.getRateGearAmtType().getValue());
        entity.setGearAmtInd(eo.getGearAmtInd() == null ? null : eo.getGearAmtInd().getValue());
        entity.setGearAmtMethod(eo.getGearAmtMethod() == null ? null : eo.getGearAmtMethod().getValue());
        entity.setGearDaysInd(eo.getGearDaysInd() == null ? null : eo.getGearDaysInd().getValue());
        entity.setGearDaysMethod(eo.getGearDaysMethod() == null ? null : eo.getGearDaysMethod().getValue());
        entity.setIntCalcAmtType(eo.getIntCalcAmtType() == null ? null : eo.getIntCalcAmtType().getValue());
        entity.setEffectDateCalcMethod(eo.getEffectDateCalcMethod() == null ? null : eo.getEffectDateCalcMethod().getValue());
        entity.setDaysGearType(eo.getDaysGearType() == null ? null : eo.getDaysGearType().getValue());
        entity.setIntApplType(eo.getIntApplType() == null ? null : eo.getIntApplType().getValue());
        entity.setMonthBasis(eo.getMonthBasis() == null ? null : eo.getMonthBasis().getValue());
        entity.setGroupRuleType(eo.getGroupRuleType() == null ? null : eo.getGroupRuleType().getValue());
        entity.setIntMatchRule(eo.getIntMatchRule() == null ? null : eo.getIntMatchRule().getValue());
        entity.setIntRecalcMethod(eo.getIntRecalcMethod() == null ? null : eo.getIntRecalcMethod().getValue());
        entity.setMinRate(eo.getMinRate());
        entity.setMaxRate(eo.getMaxRate());
        entity.setRollDay(eo.getRollDay());
        entity.setRollFreq(eo.getRollFreq() == null ? null : eo.getRollFreq().getValue());
        entity.setRoundDownFlag(eo.getRoundDownFlag());
        entity.setIntTypeExp(eo.getIntTypeExp());
        entity.setMonthBasisExp(eo.getMonthBasisExp());
        entity.setGroupRuleTypeExp(eo.getGroupRuleTypeExp());
        entity.setMinRateExp(eo.getMinRateExp());
        entity.setMaxRateExp(eo.getMaxRateExp());
        entity.setIntCalcMethodExp(eo.getIntCalcMethodExp());
        entity.setIntCalcAmtTypeExp(eo.getIntCalcAmtTypeExp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setSpreadPercent(eo.getSpreadPercent());
        entity.setSpreadRate(eo.getSpreadRate());
        entity.setCalcByInt(eo.getCalcByInt() == null ? null : eo.getCalcByInt().getValue());
        entity.setYearBasis(eo.getYearBasis() == null ? null : eo.getYearBasis().getValue());
        return entity;
    }

    public static MbProdIntExample eoToEntityExample(MbProdIntEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdIntExample example = new MbProdIntExample();
        MbProdIntExample.Criteria criteria = example.createCriteria();
        if (eo.getProdType() != null) criteria.andProdTypeEqualTo(eo.getProdType());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getIntClass() != null) criteria.andIntClassEqualTo(eo.getIntClass().getValue());
        if (eo.getIntType() != null) criteria.andIntTypeEqualTo(eo.getIntType().getValue());
        if (eo.getTaxType() != null) criteria.andTaxTypeEqualTo(eo.getTaxType().getValue());
        if (eo.getAcctRateFlag() != null) criteria.andAcctRateFlagEqualTo(eo.getAcctRateFlag().getValue());
        if (eo.getIntCalcMethod() != null) criteria.andIntCalcMethodEqualTo(eo.getIntCalcMethod().getValue());
        if (eo.getRateLayerRule() != null) criteria.andRateLayerRuleEqualTo(eo.getRateLayerRule().getValue());
        if (eo.getRateGearAmtType() != null) criteria.andRateGearAmtTypeEqualTo(eo.getRateGearAmtType().getValue());
        if (eo.getGearAmtInd() != null) criteria.andGearAmtIndEqualTo(eo.getGearAmtInd().getValue());
        if (eo.getGearAmtMethod() != null) criteria.andGearAmtMethodEqualTo(eo.getGearAmtMethod().getValue());
        if (eo.getGearDaysInd() != null) criteria.andGearDaysIndEqualTo(eo.getGearDaysInd().getValue());
        if (eo.getGearDaysMethod() != null) criteria.andGearDaysMethodEqualTo(eo.getGearDaysMethod().getValue());
        if (eo.getIntCalcAmtType() != null) criteria.andIntCalcAmtTypeEqualTo(eo.getIntCalcAmtType().getValue());
        if (eo.getEffectDateCalcMethod() != null) criteria.andEffectDateCalcMethodEqualTo(eo.getEffectDateCalcMethod().getValue());
        if (eo.getDaysGearType() != null) criteria.andDaysGearTypeEqualTo(eo.getDaysGearType().getValue());
        if (eo.getIntApplType() != null) criteria.andIntApplTypeEqualTo(eo.getIntApplType().getValue());
        if (eo.getMonthBasis() != null) criteria.andMonthBasisEqualTo(eo.getMonthBasis().getValue());
        if (eo.getGroupRuleType() != null) criteria.andGroupRuleTypeEqualTo(eo.getGroupRuleType().getValue());
        if (eo.getIntMatchRule() != null) criteria.andIntMatchRuleEqualTo(eo.getIntMatchRule().getValue());
        if (eo.getIntRecalcMethod() != null) criteria.andIntRecalcMethodEqualTo(eo.getIntRecalcMethod().getValue());
        if (eo.getMinRate() != null) criteria.andMinRateEqualTo(eo.getMinRate());
        if (eo.getMaxRate() != null) criteria.andMaxRateEqualTo(eo.getMaxRate());
        if (eo.getRollDay() != null) criteria.andRollDayEqualTo(eo.getRollDay());
        if (eo.getRollFreq() != null) criteria.andRollFreqEqualTo(eo.getRollFreq().getValue());
        if (eo.getRoundDownFlag() != null) criteria.andRoundDownFlagEqualTo(eo.getRoundDownFlag());
        if (eo.getIntTypeExp() != null) criteria.andIntTypeExpEqualTo(eo.getIntTypeExp());
        if (eo.getMonthBasisExp() != null) criteria.andMonthBasisExpEqualTo(eo.getMonthBasisExp());
        if (eo.getGroupRuleTypeExp() != null) criteria.andGroupRuleTypeExpEqualTo(eo.getGroupRuleTypeExp());
        if (eo.getMinRateExp() != null) criteria.andMinRateExpEqualTo(eo.getMinRateExp());
        if (eo.getMaxRateExp() != null) criteria.andMaxRateExpEqualTo(eo.getMaxRateExp());
        if (eo.getIntCalcMethodExp() != null) criteria.andIntCalcMethodExpEqualTo(eo.getIntCalcMethodExp());
        if (eo.getIntCalcAmtTypeExp() != null) criteria.andIntCalcAmtTypeExpEqualTo(eo.getIntCalcAmtTypeExp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getSpreadPercent() != null) criteria.andSpreadPercentEqualTo(eo.getSpreadPercent());
        if (eo.getSpreadRate() != null) criteria.andSpreadRateEqualTo(eo.getSpreadRate());
        if (eo.getCalcByInt() != null) criteria.andCalcByIntEqualTo(eo.getCalcByInt().getValue());
        if (eo.getYearBasis() != null) criteria.andYearBasisEqualTo(eo.getYearBasis().getValue());
        return example;
    }
}