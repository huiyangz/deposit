package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbTranDef;
import com.dcits.deposit.entity.RbTranDefExample;
import com.dcits.deposit.facade.eo.RbTranDefEO;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.TranClass;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.BalanceFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.UpdTailboxFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.AvailbalCalcType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;

public final class RbTranDefValueUtil {
    private RbTranDefValueUtil() {
    }

    public static RbTranDefEO entityToEo(RbTranDef entity) {
        if (entity == null) {
            return null;
        }
        RbTranDefEO eo = new RbTranDefEO();
        eo.setTranType(TranType.byValue(entity.getTranType()));
        eo.setTranClass(TranClass.byValue(entity.getTranClass()));
        eo.setTranTypeDesc(entity.getTranTypeDesc());
        eo.setPrintTranDesc(entity.getPrintTranDesc());
        eo.setCrDrInd(CrDrInd.byValue(entity.getCrDrInd()));
        eo.setBalanceFlag(BalanceFlag.byValue(entity.getBalanceFlag()));
        eo.setCashTranFlag(IndividualFlag.byValue(entity.getCashTranFlag()));
        eo.setUpdTailboxFlag(UpdTailboxFlag.byValue(entity.getUpdTailboxFlag()));
        eo.setResPriority(entity.getResPriority());
        eo.setRecalcAcctStopPayFlag(IndividualFlag.byValue(entity.getRecalcAcctStopPayFlag()));
        eo.setRecalcResAmtFlag(IndividualFlag.byValue(entity.getRecalcResAmtFlag()));
        eo.setAvailbalCalcType(AvailbalCalcType.byValue(entity.getAvailbalCalcType()));
        eo.setOthTranType(TranType.byValue(entity.getOthTranType()));
        eo.setReversal(IndividualFlag.byValue(entity.getReversal()));
        eo.setReversalTranType(TranType.byValue(entity.getReversalTranType()));
        eo.setProgramIdGroup(entity.getProgramIdGroup());
        eo.setBalTypePriority(entity.getBalTypePriority());
        eo.setCorrectFlag(IndividualFlag.byValue(entity.getCorrectFlag()));
        eo.setMultiRvsTranTypeFlag(entity.getMultiRvsTranTypeFlag());
        eo.setSourceType(SourceType.byValue(entity.getSourceType()));
        eo.setIsInitParam(entity.getIsInitParam());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setChequeBookFlag(IndividualFlag.byValue(entity.getChequeBookFlag()));
        return eo;
    }

    public static RbTranDef eoToEntity(RbTranDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranDef entity = new RbTranDef();
        entity.setTranType(eo.getTranType() == null ? null : eo.getTranType().getValue());
        entity.setTranClass(eo.getTranClass() == null ? null : eo.getTranClass().getValue());
        entity.setTranTypeDesc(eo.getTranTypeDesc());
        entity.setPrintTranDesc(eo.getPrintTranDesc());
        entity.setCrDrInd(eo.getCrDrInd() == null ? null : eo.getCrDrInd().getValue());
        entity.setBalanceFlag(eo.getBalanceFlag() == null ? null : eo.getBalanceFlag().getValue());
        entity.setCashTranFlag(eo.getCashTranFlag() == null ? null : eo.getCashTranFlag().getValue());
        entity.setUpdTailboxFlag(eo.getUpdTailboxFlag() == null ? null : eo.getUpdTailboxFlag().getValue());
        entity.setResPriority(eo.getResPriority());
        entity.setRecalcAcctStopPayFlag(eo.getRecalcAcctStopPayFlag() == null ? null : eo.getRecalcAcctStopPayFlag().getValue());
        entity.setRecalcResAmtFlag(eo.getRecalcResAmtFlag() == null ? null : eo.getRecalcResAmtFlag().getValue());
        entity.setAvailbalCalcType(eo.getAvailbalCalcType() == null ? null : eo.getAvailbalCalcType().getValue());
        entity.setOthTranType(eo.getOthTranType() == null ? null : eo.getOthTranType().getValue());
        entity.setReversal(eo.getReversal() == null ? null : eo.getReversal().getValue());
        entity.setReversalTranType(eo.getReversalTranType() == null ? null : eo.getReversalTranType().getValue());
        entity.setProgramIdGroup(eo.getProgramIdGroup());
        entity.setBalTypePriority(eo.getBalTypePriority());
        entity.setCorrectFlag(eo.getCorrectFlag() == null ? null : eo.getCorrectFlag().getValue());
        entity.setMultiRvsTranTypeFlag(eo.getMultiRvsTranTypeFlag());
        entity.setSourceType(eo.getSourceType() == null ? null : eo.getSourceType().getValue());
        entity.setIsInitParam(eo.getIsInitParam());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setChequeBookFlag(eo.getChequeBookFlag() == null ? null : eo.getChequeBookFlag().getValue());
        return entity;
    }

    public static RbTranDefExample eoToEntityExample(RbTranDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbTranDefExample example = new RbTranDefExample();
        RbTranDefExample.Criteria criteria = example.createCriteria();
        if (eo.getTranType() != null) criteria.andTranTypeEqualTo(eo.getTranType().getValue());
        if (eo.getTranClass() != null) criteria.andTranClassEqualTo(eo.getTranClass().getValue());
        if (eo.getTranTypeDesc() != null) criteria.andTranTypeDescEqualTo(eo.getTranTypeDesc());
        if (eo.getPrintTranDesc() != null) criteria.andPrintTranDescEqualTo(eo.getPrintTranDesc());
        if (eo.getCrDrInd() != null) criteria.andCrDrIndEqualTo(eo.getCrDrInd().getValue());
        if (eo.getBalanceFlag() != null) criteria.andBalanceFlagEqualTo(eo.getBalanceFlag().getValue());
        if (eo.getCashTranFlag() != null) criteria.andCashTranFlagEqualTo(eo.getCashTranFlag().getValue());
        if (eo.getUpdTailboxFlag() != null) criteria.andUpdTailboxFlagEqualTo(eo.getUpdTailboxFlag().getValue());
        if (eo.getResPriority() != null) criteria.andResPriorityEqualTo(eo.getResPriority());
        if (eo.getRecalcAcctStopPayFlag() != null) criteria.andRecalcAcctStopPayFlagEqualTo(eo.getRecalcAcctStopPayFlag().getValue());
        if (eo.getRecalcResAmtFlag() != null) criteria.andRecalcResAmtFlagEqualTo(eo.getRecalcResAmtFlag().getValue());
        if (eo.getAvailbalCalcType() != null) criteria.andAvailbalCalcTypeEqualTo(eo.getAvailbalCalcType().getValue());
        if (eo.getOthTranType() != null) criteria.andOthTranTypeEqualTo(eo.getOthTranType().getValue());
        if (eo.getReversal() != null) criteria.andReversalEqualTo(eo.getReversal().getValue());
        if (eo.getReversalTranType() != null) criteria.andReversalTranTypeEqualTo(eo.getReversalTranType().getValue());
        if (eo.getProgramIdGroup() != null) criteria.andProgramIdGroupEqualTo(eo.getProgramIdGroup());
        if (eo.getBalTypePriority() != null) criteria.andBalTypePriorityEqualTo(eo.getBalTypePriority());
        if (eo.getCorrectFlag() != null) criteria.andCorrectFlagEqualTo(eo.getCorrectFlag().getValue());
        if (eo.getMultiRvsTranTypeFlag() != null) criteria.andMultiRvsTranTypeFlagEqualTo(eo.getMultiRvsTranTypeFlag());
        if (eo.getSourceType() != null) criteria.andSourceTypeEqualTo(eo.getSourceType().getValue());
        if (eo.getIsInitParam() != null) criteria.andIsInitParamEqualTo(eo.getIsInitParam());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getChequeBookFlag() != null) criteria.andChequeBookFlagEqualTo(eo.getChequeBookFlag().getValue());
        return example;
    }
}