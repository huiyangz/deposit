package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbTranDef;
import com.dcits.depsit.entity.RbTranDefExample;
import com.dcits.depsit.facade.eo.RbTranDefEO;
import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.enums.BalanceFlag;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.enums.AvailbalCalcType;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.UpdTailboxFlag;
import com.dcits.depsit.enums.RcrRcdInd;
import com.dcits.depsit.enums.TranClass;

public final class RbTranDefValueUtil {
    private RbTranDefValueUtil() {
    }

    public static RbTranDefEO entityToEo(RbTranDef entity) {
        if (entity == null) {
            return null;
        }
        RbTranDefEO eo = new RbTranDefEO();
        eo.setCrDrInd(CrDrInd.byValue(entity.getCrDrInd()));
        eo.setTranTypeDesc(entity.getTranTypeDesc());
        eo.setMultiRvsTranTypeFlag(entity.getMultiRvsTranTypeFlag());
        eo.setBalTypePriority(entity.getBalTypePriority());
        eo.setBalanceFlag(BalanceFlag.byValue(entity.getBalanceFlag()));
        eo.setOthTranType(TranType.byValue(entity.getOthTranType()));
        eo.setProgramIdGroup(entity.getProgramIdGroup());
        eo.setCashTranFlag(entity.getCashTranFlag());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setIsInitParam(entity.getIsInitParam());
        eo.setResPriority(entity.getResPriority());
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setAvailbalCalcType(AvailbalCalcType.byValue(entity.getAvailbalCalcType()));
        eo.setRecalcAcctStopPayFlag(entity.getRecalcAcctStopPayFlag());
        eo.setReversalTranType(TranType.byValue(entity.getReversalTranType()));
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setRecalcResAmtFlag(entity.getRecalcResAmtFlag());
        eo.setReversal(entity.getReversal());
        eo.setChequeBookFlag(entity.getChequeBookFlag());
        eo.setCorrectFlag(entity.getCorrectFlag());
        eo.setUpdTailboxFlag(UpdTailboxFlag.byValue(entity.getUpdTailboxFlag()));
        eo.setRcrRcdInd(RcrRcdInd.byValue(entity.getRcrRcdInd()));
        eo.setTranClass(TranClass.byValue(entity.getTranClass()));
        eo.setPrintTranDesc(entity.getPrintTranDesc());
        return eo;
    }

    public static RbTranDef eoToEntity(RbTranDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranDef entity = new RbTranDef();
        entity.setCrDrInd(eo.getCrDrInd() == null ? null : eo.getCrDrInd().getValue());
        entity.setTranTypeDesc(eo.getTranTypeDesc());
        entity.setMultiRvsTranTypeFlag(eo.getMultiRvsTranTypeFlag());
        entity.setBalTypePriority(eo.getBalTypePriority());
        entity.setBalanceFlag(eo.getBalanceFlag() == null ? null : eo.getBalanceFlag().getValue());
        entity.setOthTranType(eo.getOthTranType() == null ? null : eo.getOthTranType().getValue());
        entity.setProgramIdGroup(eo.getProgramIdGroup());
        entity.setCashTranFlag(eo.getCashTranFlag());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setIsInitParam(eo.getIsInitParam());
        entity.setResPriority(eo.getResPriority());
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setAvailbalCalcType(eo.getAvailbalCalcType() == null ? null : eo.getAvailbalCalcType().getValue());
        entity.setRecalcAcctStopPayFlag(eo.getRecalcAcctStopPayFlag());
        entity.setReversalTranType(eo.getReversalTranType() == null ? null : eo.getReversalTranType().getValue());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setRecalcResAmtFlag(eo.getRecalcResAmtFlag());
        entity.setReversal(eo.getReversal());
        entity.setChequeBookFlag(eo.getChequeBookFlag());
        entity.setCorrectFlag(eo.getCorrectFlag());
        entity.setUpdTailboxFlag(eo.getUpdTailboxFlag() == null ? null : eo.getUpdTailboxFlag().getValue());
        entity.setRcrRcdInd(eo.getRcrRcdInd() == null ? null : eo.getRcrRcdInd().getValue());
        entity.setTranClass(eo.getTranClass() == null ? null : eo.getTranClass().getValue());
        entity.setPrintTranDesc(eo.getPrintTranDesc());
        return entity;
    }

    public static RbTranDefExample eoToEntityExample(RbTranDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranDefExample example = new RbTranDefExample();
        RbTranDefExample.Criteria criteria = example.createCriteria();
        if (eo.getCrDrInd() != null) criteria.andCrDrIndEqualTo(eo.getCrDrInd().getValue());
        if (eo.getTranTypeDesc() != null) criteria.andTranTypeDescEqualTo(eo.getTranTypeDesc());
        if (eo.getMultiRvsTranTypeFlag() != null) criteria.andMultiRvsTranTypeFlagEqualTo(eo.getMultiRvsTranTypeFlag());
        if (eo.getBalTypePriority() != null) criteria.andBalTypePriorityEqualTo(eo.getBalTypePriority());
        if (eo.getBalanceFlag() != null) criteria.andBalanceFlagEqualTo(eo.getBalanceFlag().getValue());
        if (eo.getOthTranType() != null) criteria.andOthTranTypeEqualTo(eo.getOthTranType().getValue());
        if (eo.getProgramIdGroup() != null) criteria.andProgramIdGroupEqualTo(eo.getProgramIdGroup());
        if (eo.getCashTranFlag() != null) criteria.andCashTranFlagEqualTo(eo.getCashTranFlag());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getIsInitParam() != null) criteria.andIsInitParamEqualTo(eo.getIsInitParam());
        if (eo.getResPriority() != null) criteria.andResPriorityEqualTo(eo.getResPriority());
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getAvailbalCalcType() != null) criteria.andAvailbalCalcTypeEqualTo(eo.getAvailbalCalcType().getValue());
        if (eo.getRecalcAcctStopPayFlag() != null) criteria.andRecalcAcctStopPayFlagEqualTo(eo.getRecalcAcctStopPayFlag());
        if (eo.getReversalTranType() != null) criteria.andReversalTranTypeEqualTo(eo.getReversalTranType().getValue());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getRecalcResAmtFlag() != null) criteria.andRecalcResAmtFlagEqualTo(eo.getRecalcResAmtFlag());
        if (eo.getReversal() != null) criteria.andReversalEqualTo(eo.getReversal());
        if (eo.getChequeBookFlag() != null) criteria.andChequeBookFlagEqualTo(eo.getChequeBookFlag());
        if (eo.getCorrectFlag() != null) criteria.andCorrectFlagEqualTo(eo.getCorrectFlag());
        if (eo.getUpdTailboxFlag() != null) criteria.andUpdTailboxFlagEqualTo(eo.getUpdTailboxFlag().getValue());
        if (eo.getRcrRcdInd() != null) criteria.andRcrRcdIndEqualTo(eo.getRcrRcdInd().getValue());
        if (eo.getTranClass() != null) criteria.andTranClassEqualTo(eo.getTranClass().getValue());
        if (eo.getPrintTranDesc() != null) criteria.andPrintTranDescEqualTo(eo.getPrintTranDesc());
        return example;
    }
}