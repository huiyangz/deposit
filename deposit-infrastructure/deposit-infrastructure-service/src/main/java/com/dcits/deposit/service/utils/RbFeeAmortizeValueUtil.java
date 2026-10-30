package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbFeeAmortize;
import com.dcits.deposit.entity.RbFeeAmortizeExample;
import com.dcits.deposit.facade.eo.RbFeeAmortizeEO;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.FeeTakenMode;
import com.dcits.deposit.enums.AmortizeStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.AmortizeTimeType;

public final class RbFeeAmortizeValueUtil {
    private RbFeeAmortizeValueUtil() {
    }

    public static RbFeeAmortizeEO entityToEo(RbFeeAmortize entity) {
        if (entity == null) {
            return null;
        }
        RbFeeAmortizeEO eo = new RbFeeAmortizeEO();
        eo.setOsdSeqNo(entity.getOsdSeqNo());
        eo.setEffectDate(entity.getEffectDate());
        eo.setAmortizePeriodType(TermType.byValue(entity.getAmortizePeriodType()));
        eo.setChargeMode(FeeTakenMode.byValue(entity.getChargeMode()));
        eo.setAmortizeMonth(entity.getAmortizeMonth());
        eo.setEndDate(entity.getEndDate());
        eo.setAmortizeName(entity.getAmortizeName());
        eo.setNextAmortizeDate(entity.getNextAmortizeDate());
        eo.setAmortizeStatus(AmortizeStatus.byValue(entity.getAmortizeStatus()));
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setChannelSeqNo(entity.getChannelSeqNo());
        eo.setTranBranch(TranBranch.byValue(entity.getTranBranch()));
        eo.setAmortizeDay(entity.getAmortizeDay());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setBusiNo(entity.getBusiNo());
        eo.setAmortizeTotalCnt(entity.getAmortizeTotalCnt());
        eo.setRemainAmortizeCnt(entity.getRemainAmortizeCnt());
        eo.setAmortizeCcy(Ccy.byValue(entity.getAmortizeCcy()));
        eo.setContractNo(entity.getContractNo());
        eo.setReference(entity.getReference());
        eo.setAmortizeTotalAmt(entity.getAmortizeTotalAmt());
        eo.setFeeType(FeeType.byValue(entity.getFeeType()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setAmortizedCnt(entity.getAmortizedCnt());
        eo.setAmortizedAmt(entity.getAmortizedAmt());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setAmortizeId(entity.getAmortizeId());
        eo.setAmortizeTimeType(AmortizeTimeType.byValue(entity.getAmortizeTimeType()));
        eo.setBankSeqNo(entity.getBankSeqNo());
        eo.setInternalKey(entity.getInternalKey());
        eo.setLastAmortizeDate(entity.getLastAmortizeDate());
        eo.setRemainAmortizeAmt(entity.getRemainAmortizeAmt());
        eo.setTranDate(entity.getTranDate());
        return eo;
    }

    public static RbFeeAmortize eoToEntity(RbFeeAmortizeEO eo) {
        if (eo == null) {
            return null;
        }
        RbFeeAmortize entity = new RbFeeAmortize();
        entity.setOsdSeqNo(eo.getOsdSeqNo());
        entity.setEffectDate(eo.getEffectDate());
        entity.setAmortizePeriodType(eo.getAmortizePeriodType() == null ? null : eo.getAmortizePeriodType().getValue());
        entity.setChargeMode(eo.getChargeMode() == null ? null : eo.getChargeMode().getValue());
        entity.setAmortizeMonth(eo.getAmortizeMonth());
        entity.setEndDate(eo.getEndDate());
        entity.setAmortizeName(eo.getAmortizeName());
        entity.setNextAmortizeDate(eo.getNextAmortizeDate());
        entity.setAmortizeStatus(eo.getAmortizeStatus() == null ? null : eo.getAmortizeStatus().getValue());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setChannelSeqNo(eo.getChannelSeqNo());
        entity.setTranBranch(eo.getTranBranch() == null ? null : eo.getTranBranch().getValue());
        entity.setAmortizeDay(eo.getAmortizeDay());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setBusiNo(eo.getBusiNo());
        entity.setAmortizeTotalCnt(eo.getAmortizeTotalCnt());
        entity.setRemainAmortizeCnt(eo.getRemainAmortizeCnt());
        entity.setAmortizeCcy(eo.getAmortizeCcy() == null ? null : eo.getAmortizeCcy().getValue());
        entity.setContractNo(eo.getContractNo());
        entity.setReference(eo.getReference());
        entity.setAmortizeTotalAmt(eo.getAmortizeTotalAmt());
        entity.setFeeType(eo.getFeeType() == null ? null : eo.getFeeType().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setAmortizedCnt(eo.getAmortizedCnt());
        entity.setAmortizedAmt(eo.getAmortizedAmt());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setAmortizeId(eo.getAmortizeId());
        entity.setAmortizeTimeType(eo.getAmortizeTimeType() == null ? null : eo.getAmortizeTimeType().getValue());
        entity.setBankSeqNo(eo.getBankSeqNo());
        entity.setInternalKey(eo.getInternalKey());
        entity.setLastAmortizeDate(eo.getLastAmortizeDate());
        entity.setRemainAmortizeAmt(eo.getRemainAmortizeAmt());
        entity.setTranDate(eo.getTranDate());
        return entity;
    }

    public static RbFeeAmortizeExample eoToEntityExample(RbFeeAmortizeEO eo) {
        if (eo == null) {
            return null;
        }
        RbFeeAmortizeExample example = new RbFeeAmortizeExample();
        RbFeeAmortizeExample.Criteria criteria = example.createCriteria();
        if (eo.getOsdSeqNo() != null) criteria.andOsdSeqNoEqualTo(eo.getOsdSeqNo());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getAmortizePeriodType() != null) criteria.andAmortizePeriodTypeEqualTo(eo.getAmortizePeriodType().getValue());
        if (eo.getChargeMode() != null) criteria.andChargeModeEqualTo(eo.getChargeMode().getValue());
        if (eo.getAmortizeMonth() != null) criteria.andAmortizeMonthEqualTo(eo.getAmortizeMonth());
        if (eo.getEndDate() != null) criteria.andEndDateEqualTo(eo.getEndDate());
        if (eo.getAmortizeName() != null) criteria.andAmortizeNameEqualTo(eo.getAmortizeName());
        if (eo.getNextAmortizeDate() != null) criteria.andNextAmortizeDateEqualTo(eo.getNextAmortizeDate());
        if (eo.getAmortizeStatus() != null) criteria.andAmortizeStatusEqualTo(eo.getAmortizeStatus().getValue());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getChannelSeqNo() != null) criteria.andChannelSeqNoEqualTo(eo.getChannelSeqNo());
        if (eo.getTranBranch() != null) criteria.andTranBranchEqualTo(eo.getTranBranch().getValue());
        if (eo.getAmortizeDay() != null) criteria.andAmortizeDayEqualTo(eo.getAmortizeDay());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getBusiNo() != null) criteria.andBusiNoEqualTo(eo.getBusiNo());
        if (eo.getAmortizeTotalCnt() != null) criteria.andAmortizeTotalCntEqualTo(eo.getAmortizeTotalCnt());
        if (eo.getRemainAmortizeCnt() != null) criteria.andRemainAmortizeCntEqualTo(eo.getRemainAmortizeCnt());
        if (eo.getAmortizeCcy() != null) criteria.andAmortizeCcyEqualTo(eo.getAmortizeCcy().getValue());
        if (eo.getContractNo() != null) criteria.andContractNoEqualTo(eo.getContractNo());
        if (eo.getReference() != null) criteria.andReferenceEqualTo(eo.getReference());
        if (eo.getAmortizeTotalAmt() != null) criteria.andAmortizeTotalAmtEqualTo(eo.getAmortizeTotalAmt());
        if (eo.getFeeType() != null) criteria.andFeeTypeEqualTo(eo.getFeeType().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getAmortizedCnt() != null) criteria.andAmortizedCntEqualTo(eo.getAmortizedCnt());
        if (eo.getAmortizedAmt() != null) criteria.andAmortizedAmtEqualTo(eo.getAmortizedAmt());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getAmortizeId() != null) criteria.andAmortizeIdEqualTo(eo.getAmortizeId());
        if (eo.getAmortizeTimeType() != null) criteria.andAmortizeTimeTypeEqualTo(eo.getAmortizeTimeType().getValue());
        if (eo.getBankSeqNo() != null) criteria.andBankSeqNoEqualTo(eo.getBankSeqNo());
        if (eo.getInternalKey() != null) criteria.andInternalKeyEqualTo(eo.getInternalKey());
        if (eo.getLastAmortizeDate() != null) criteria.andLastAmortizeDateEqualTo(eo.getLastAmortizeDate());
        if (eo.getRemainAmortizeAmt() != null) criteria.andRemainAmortizeAmtEqualTo(eo.getRemainAmortizeAmt());
        if (eo.getTranDate() != null) criteria.andTranDateEqualTo(eo.getTranDate());
        return example;
    }
}