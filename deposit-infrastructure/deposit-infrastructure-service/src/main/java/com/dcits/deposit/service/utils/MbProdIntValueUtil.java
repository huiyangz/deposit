package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.MbProdInt;
import com.dcits.deposit.entity.MbProdIntExample;
import com.dcits.deposit.facade.eo.MbProdIntEO;
import com.dcits.deposit.enums.YearBasisType;
import com.dcits.deposit.enums.VoucherStatus;
import com.dcits.deposit.enums.IntMatchRule;
import com.dcits.deposit.enums.MonthBasisType;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.IntCalcMethod;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.GearDaysInd;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.GearDaysInd;
import com.dcits.deposit.enums.DaysGearType;
import com.dcits.deposit.enums.IntChangeType;
import com.dcits.deposit.enums.EffectDateCalcMethod;
import com.dcits.deposit.enums.RateLayerRule;
import com.dcits.deposit.enums.GroupRuleType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IntRecalcMethod;
import com.dcits.deposit.enums.GearAmtMethod;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.IntClass;

public final class MbProdIntValueUtil {
    private MbProdIntValueUtil() {
    }

    public static MbProdIntEO entityToEo(MbProdInt entity) {
        if (entity == null) {
            return null;
        }
        MbProdIntEO eo = new MbProdIntEO();
        eo.setVoucherId(entity.getVoucherId());
        eo.setAcctRateFlag(entity.getAcctRateFlag());
        eo.setRoundDownFlag(entity.getRoundDownFlag());
        eo.setVoucherStartNo(entity.getVoucherStartNo());
        eo.setYearBasisType(YearBasisType.byValue(entity.getYearBasisType()));
        eo.setMaxRate(entity.getMaxRate());
        eo.setVoucherStatus(VoucherStatus.byValue(entity.getVoucherStatus()));
        eo.setTailboxId(entity.getTailboxId());
        eo.setEopdVoucherSum(entity.getEopdVoucherSum());
        eo.setSpreadRate(entity.getSpreadRate());
        eo.setIntMatchRule(IntMatchRule.byValue(entity.getIntMatchRule()));
        eo.setMonthBasisType(MonthBasisType.byValue(entity.getMonthBasisType()));
        eo.setStartNoInt(entity.getStartNoInt());
        eo.setMaxRateExp(entity.getMaxRateExp());
        eo.setPrefix(entity.getPrefix());
        eo.setMinRateExp(entity.getMinRateExp());
        eo.setGearAmtMethod(GearAmtMethod.byValue(entity.getGearAmtMethod()));
        eo.setRollDay(entity.getRollDay());
        eo.setProdNo(entity.getProdNo());
        eo.setIntCalcMethod(IntCalcMethod.byValue(entity.getIntCalcMethod()));
        eo.setLastUserId(entity.getLastUserId());
        eo.setBranch(TranBranch.byValue(entity.getBranch()));
        eo.setGearDaysInd(GearDaysInd.byValue(entity.getGearDaysInd()));
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setIntType(IntType.byValue(entity.getIntType()));
        eo.setGearAmtInd(GearDaysInd.byValue(entity.getGearAmtInd()));
        eo.setDaysGearType(DaysGearType.byValue(entity.getDaysGearType()));
        eo.setIntChangeType(IntChangeType.byValue(entity.getIntChangeType()));
        eo.setMinRate(entity.getMinRate());
        eo.setEffectDateCalcMethod(EffectDateCalcMethod.byValue(entity.getEffectDateCalcMethod()));
        eo.setGroupRuleTypeExp(entity.getGroupRuleTypeExp());
        eo.setRateLayerRule(RateLayerRule.byValue(entity.getRateLayerRule()));
        eo.setGroupRuleType(GroupRuleType.byValue(entity.getGroupRuleType()));
        eo.setRollFreq(RollFreq.byValue(entity.getRollFreq()));
        eo.setIntCalcAmtType(IntCalcAmtType.byValue(entity.getIntCalcAmtType()));
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setSopdVoucherSum(entity.getSopdVoucherSum());
        eo.setSpreadPercent(entity.getSpreadPercent());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setIntRecalcMethod(IntRecalcMethod.byValue(entity.getIntRecalcMethod()));
        eo.setTaxTypeNo(entity.getTaxTypeNo());
        eo.setEventType(entity.getEventType());
        eo.setCalcByInt(entity.getCalcByInt());
        eo.setVoucherEndNo(entity.getVoucherEndNo());
        eo.setGearDaysMethod(GearAmtMethod.byValue(entity.getGearDaysMethod()));
        eo.setMonthBasisExp(entity.getMonthBasisExp());
        eo.setRateGearAmtType(IntCalcAmtType.byValue(entity.getRateGearAmtType()));
        eo.setVoucherSum(entity.getVoucherSum());
        eo.setIntClass(IntClass.byValue(entity.getIntClass()));
        eo.setIntCalcAmtTypeExp(entity.getIntCalcAmtTypeExp());
        eo.setIntCalcMethodExp(entity.getIntCalcMethodExp());
        eo.setEndNoInt(entity.getEndNoInt());
        eo.setIntTypeExp(entity.getIntTypeExp());
        return eo;
    }

    public static MbProdInt eoToEntity(MbProdIntEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdInt entity = new MbProdInt();
        entity.setVoucherId(eo.getVoucherId());
        entity.setAcctRateFlag(eo.getAcctRateFlag());
        entity.setRoundDownFlag(eo.getRoundDownFlag());
        entity.setVoucherStartNo(eo.getVoucherStartNo());
        entity.setYearBasisType(eo.getYearBasisType() == null ? null : eo.getYearBasisType().getValue());
        entity.setMaxRate(eo.getMaxRate());
        entity.setVoucherStatus(eo.getVoucherStatus() == null ? null : eo.getVoucherStatus().getValue());
        entity.setTailboxId(eo.getTailboxId());
        entity.setEopdVoucherSum(eo.getEopdVoucherSum());
        entity.setSpreadRate(eo.getSpreadRate());
        entity.setIntMatchRule(eo.getIntMatchRule() == null ? null : eo.getIntMatchRule().getValue());
        entity.setMonthBasisType(eo.getMonthBasisType() == null ? null : eo.getMonthBasisType().getValue());
        entity.setStartNoInt(eo.getStartNoInt());
        entity.setMaxRateExp(eo.getMaxRateExp());
        entity.setPrefix(eo.getPrefix());
        entity.setMinRateExp(eo.getMinRateExp());
        entity.setGearAmtMethod(eo.getGearAmtMethod() == null ? null : eo.getGearAmtMethod().getValue());
        entity.setRollDay(eo.getRollDay());
        entity.setProdNo(eo.getProdNo());
        entity.setIntCalcMethod(eo.getIntCalcMethod() == null ? null : eo.getIntCalcMethod().getValue());
        entity.setLastUserId(eo.getLastUserId());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setGearDaysInd(eo.getGearDaysInd() == null ? null : eo.getGearDaysInd().getValue());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setIntType(eo.getIntType() == null ? null : eo.getIntType().getValue());
        entity.setGearAmtInd(eo.getGearAmtInd() == null ? null : eo.getGearAmtInd().getValue());
        entity.setDaysGearType(eo.getDaysGearType() == null ? null : eo.getDaysGearType().getValue());
        entity.setIntChangeType(eo.getIntChangeType() == null ? null : eo.getIntChangeType().getValue());
        entity.setMinRate(eo.getMinRate());
        entity.setEffectDateCalcMethod(eo.getEffectDateCalcMethod() == null ? null : eo.getEffectDateCalcMethod().getValue());
        entity.setGroupRuleTypeExp(eo.getGroupRuleTypeExp());
        entity.setRateLayerRule(eo.getRateLayerRule() == null ? null : eo.getRateLayerRule().getValue());
        entity.setGroupRuleType(eo.getGroupRuleType() == null ? null : eo.getGroupRuleType().getValue());
        entity.setRollFreq(eo.getRollFreq() == null ? null : eo.getRollFreq().getValue());
        entity.setIntCalcAmtType(eo.getIntCalcAmtType() == null ? null : eo.getIntCalcAmtType().getValue());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setSopdVoucherSum(eo.getSopdVoucherSum());
        entity.setSpreadPercent(eo.getSpreadPercent());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setIntRecalcMethod(eo.getIntRecalcMethod() == null ? null : eo.getIntRecalcMethod().getValue());
        entity.setTaxTypeNo(eo.getTaxTypeNo());
        entity.setEventType(eo.getEventType());
        entity.setCalcByInt(eo.getCalcByInt());
        entity.setVoucherEndNo(eo.getVoucherEndNo());
        entity.setGearDaysMethod(eo.getGearDaysMethod() == null ? null : eo.getGearDaysMethod().getValue());
        entity.setMonthBasisExp(eo.getMonthBasisExp());
        entity.setRateGearAmtType(eo.getRateGearAmtType() == null ? null : eo.getRateGearAmtType().getValue());
        entity.setVoucherSum(eo.getVoucherSum());
        entity.setIntClass(eo.getIntClass() == null ? null : eo.getIntClass().getValue());
        entity.setIntCalcAmtTypeExp(eo.getIntCalcAmtTypeExp());
        entity.setIntCalcMethodExp(eo.getIntCalcMethodExp());
        entity.setEndNoInt(eo.getEndNoInt());
        entity.setIntTypeExp(eo.getIntTypeExp());
        return entity;
    }

    public static MbProdIntExample eoToEntityExample(MbProdIntEO eo) {
        if (eo == null) {
            return null;
        }
        MbProdIntExample example = new MbProdIntExample();
        MbProdIntExample.Criteria criteria = example.createCriteria();
        if (eo.getVoucherId() != null) criteria.andVoucherIdEqualTo(eo.getVoucherId());
        if (eo.getAcctRateFlag() != null) criteria.andAcctRateFlagEqualTo(eo.getAcctRateFlag());
        if (eo.getRoundDownFlag() != null) criteria.andRoundDownFlagEqualTo(eo.getRoundDownFlag());
        if (eo.getVoucherStartNo() != null) criteria.andVoucherStartNoEqualTo(eo.getVoucherStartNo());
        if (eo.getYearBasisType() != null) criteria.andYearBasisTypeEqualTo(eo.getYearBasisType().getValue());
        if (eo.getMaxRate() != null) criteria.andMaxRateEqualTo(eo.getMaxRate());
        if (eo.getVoucherStatus() != null) criteria.andVoucherStatusEqualTo(eo.getVoucherStatus().getValue());
        if (eo.getTailboxId() != null) criteria.andTailboxIdEqualTo(eo.getTailboxId());
        if (eo.getEopdVoucherSum() != null) criteria.andEopdVoucherSumEqualTo(eo.getEopdVoucherSum());
        if (eo.getSpreadRate() != null) criteria.andSpreadRateEqualTo(eo.getSpreadRate());
        if (eo.getIntMatchRule() != null) criteria.andIntMatchRuleEqualTo(eo.getIntMatchRule().getValue());
        if (eo.getMonthBasisType() != null) criteria.andMonthBasisTypeEqualTo(eo.getMonthBasisType().getValue());
        if (eo.getStartNoInt() != null) criteria.andStartNoIntEqualTo(eo.getStartNoInt());
        if (eo.getMaxRateExp() != null) criteria.andMaxRateExpEqualTo(eo.getMaxRateExp());
        if (eo.getPrefix() != null) criteria.andPrefixEqualTo(eo.getPrefix());
        if (eo.getMinRateExp() != null) criteria.andMinRateExpEqualTo(eo.getMinRateExp());
        if (eo.getGearAmtMethod() != null) criteria.andGearAmtMethodEqualTo(eo.getGearAmtMethod().getValue());
        if (eo.getRollDay() != null) criteria.andRollDayEqualTo(eo.getRollDay());
        if (eo.getProdNo() != null) criteria.andProdNoEqualTo(eo.getProdNo());
        if (eo.getIntCalcMethod() != null) criteria.andIntCalcMethodEqualTo(eo.getIntCalcMethod().getValue());
        if (eo.getLastUserId() != null) criteria.andLastUserIdEqualTo(eo.getLastUserId());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getGearDaysInd() != null) criteria.andGearDaysIndEqualTo(eo.getGearDaysInd().getValue());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getIntType() != null) criteria.andIntTypeEqualTo(eo.getIntType().getValue());
        if (eo.getGearAmtInd() != null) criteria.andGearAmtIndEqualTo(eo.getGearAmtInd().getValue());
        if (eo.getDaysGearType() != null) criteria.andDaysGearTypeEqualTo(eo.getDaysGearType().getValue());
        if (eo.getIntChangeType() != null) criteria.andIntChangeTypeEqualTo(eo.getIntChangeType().getValue());
        if (eo.getMinRate() != null) criteria.andMinRateEqualTo(eo.getMinRate());
        if (eo.getEffectDateCalcMethod() != null) criteria.andEffectDateCalcMethodEqualTo(eo.getEffectDateCalcMethod().getValue());
        if (eo.getGroupRuleTypeExp() != null) criteria.andGroupRuleTypeExpEqualTo(eo.getGroupRuleTypeExp());
        if (eo.getRateLayerRule() != null) criteria.andRateLayerRuleEqualTo(eo.getRateLayerRule().getValue());
        if (eo.getGroupRuleType() != null) criteria.andGroupRuleTypeEqualTo(eo.getGroupRuleType().getValue());
        if (eo.getRollFreq() != null) criteria.andRollFreqEqualTo(eo.getRollFreq().getValue());
        if (eo.getIntCalcAmtType() != null) criteria.andIntCalcAmtTypeEqualTo(eo.getIntCalcAmtType().getValue());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getSopdVoucherSum() != null) criteria.andSopdVoucherSumEqualTo(eo.getSopdVoucherSum());
        if (eo.getSpreadPercent() != null) criteria.andSpreadPercentEqualTo(eo.getSpreadPercent());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getIntRecalcMethod() != null) criteria.andIntRecalcMethodEqualTo(eo.getIntRecalcMethod().getValue());
        if (eo.getTaxTypeNo() != null) criteria.andTaxTypeNoEqualTo(eo.getTaxTypeNo());
        if (eo.getEventType() != null) criteria.andEventTypeEqualTo(eo.getEventType());
        if (eo.getCalcByInt() != null) criteria.andCalcByIntEqualTo(eo.getCalcByInt());
        if (eo.getVoucherEndNo() != null) criteria.andVoucherEndNoEqualTo(eo.getVoucherEndNo());
        if (eo.getGearDaysMethod() != null) criteria.andGearDaysMethodEqualTo(eo.getGearDaysMethod().getValue());
        if (eo.getMonthBasisExp() != null) criteria.andMonthBasisExpEqualTo(eo.getMonthBasisExp());
        if (eo.getRateGearAmtType() != null) criteria.andRateGearAmtTypeEqualTo(eo.getRateGearAmtType().getValue());
        if (eo.getVoucherSum() != null) criteria.andVoucherSumEqualTo(eo.getVoucherSum());
        if (eo.getIntClass() != null) criteria.andIntClassEqualTo(eo.getIntClass().getValue());
        if (eo.getIntCalcAmtTypeExp() != null) criteria.andIntCalcAmtTypeExpEqualTo(eo.getIntCalcAmtTypeExp());
        if (eo.getIntCalcMethodExp() != null) criteria.andIntCalcMethodExpEqualTo(eo.getIntCalcMethodExp());
        if (eo.getEndNoInt() != null) criteria.andEndNoIntEqualTo(eo.getEndNoInt());
        if (eo.getIntTypeExp() != null) criteria.andIntTypeExpEqualTo(eo.getIntTypeExp());
        return example;
    }
}