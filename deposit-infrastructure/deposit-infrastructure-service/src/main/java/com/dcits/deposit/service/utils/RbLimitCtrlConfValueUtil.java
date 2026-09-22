package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitCtrlConf;
import com.dcits.deposit.entity.RbLimitCtrlConfExample;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.SumType;
import com.dcits.deposit.enums.CtrlItemType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;

public final class RbLimitCtrlConfValueUtil {
    private RbLimitCtrlConfValueUtil() {
    }

    public static RbLimitCtrlConfEO entityToEo(RbLimitCtrlConf entity) {
        if (entity == null) {
            return null;
        }
        RbLimitCtrlConfEO eo = new RbLimitCtrlConfEO();
        eo.setLimitSceneNo(entity.getLimitSceneNo());
        eo.setLimitBranchId(AcctBranch.byValue(entity.getLimitBranchId()));
        eo.setLimitBranchRange(LimitBranchRange.byValue(entity.getLimitBranchRange()));
        eo.setValidFlag(entity.getValidFlag());
        eo.setSumType(SumType.byValue(entity.getSumType()));
        eo.setCtrlItemType(CtrlItemType.byValue(entity.getCtrlItemType()));
        eo.setPeriodType(TermType.byValue(entity.getPeriodType()));
        eo.setPeriodValue(entity.getPeriodValue());
        eo.setLimitCtrlAmt(entity.getLimitCtrlAmt());
        eo.setLimitCtrlNum(entity.getLimitCtrlNum());
        eo.setAllowCustomFlag(IndividualFlag.byValue(entity.getAllowCustomFlag()));
        eo.setAllowExceedFlag(IndividualFlag.byValue(entity.getAllowExceedFlag()));
        eo.setLimitCtrlBgnDate(entity.getLimitCtrlBgnDate());
        eo.setLimitCtrlEndDate(entity.getLimitCtrlEndDate());
        eo.setLimitCtrlBgnTime(entity.getLimitCtrlBgnTime());
        eo.setLimitCtrlEndTime(entity.getLimitCtrlEndTime());
        eo.setDealFlow(DealFlow.byValue(entity.getDealFlow()));
        eo.setOnlyCustom(IndividualFlag.byValue(entity.getOnlyCustom()));
        eo.setTempLimitFlag(IndividualFlag.byValue(entity.getTempLimitFlag()));
        eo.setTempLimitValidTerm(entity.getTempLimitValidTerm());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        return eo;
    }

    public static RbLimitCtrlConf eoToEntity(RbLimitCtrlConfEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitCtrlConf entity = new RbLimitCtrlConf();
        entity.setLimitSceneNo(eo.getLimitSceneNo());
        entity.setLimitBranchId(eo.getLimitBranchId() == null ? null : eo.getLimitBranchId().getValue());
        entity.setLimitBranchRange(eo.getLimitBranchRange() == null ? null : eo.getLimitBranchRange().getValue());
        entity.setValidFlag(eo.getValidFlag());
        entity.setSumType(eo.getSumType() == null ? null : eo.getSumType().getValue());
        entity.setCtrlItemType(eo.getCtrlItemType() == null ? null : eo.getCtrlItemType().getValue());
        entity.setPeriodType(eo.getPeriodType() == null ? null : eo.getPeriodType().getValue());
        entity.setPeriodValue(eo.getPeriodValue());
        entity.setLimitCtrlAmt(eo.getLimitCtrlAmt());
        entity.setLimitCtrlNum(eo.getLimitCtrlNum());
        entity.setAllowCustomFlag(eo.getAllowCustomFlag() == null ? null : eo.getAllowCustomFlag().getValue());
        entity.setAllowExceedFlag(eo.getAllowExceedFlag() == null ? null : eo.getAllowExceedFlag().getValue());
        entity.setLimitCtrlBgnDate(eo.getLimitCtrlBgnDate());
        entity.setLimitCtrlEndDate(eo.getLimitCtrlEndDate());
        entity.setLimitCtrlBgnTime(eo.getLimitCtrlBgnTime());
        entity.setLimitCtrlEndTime(eo.getLimitCtrlEndTime());
        entity.setDealFlow(eo.getDealFlow() == null ? null : eo.getDealFlow().getValue());
        entity.setOnlyCustom(eo.getOnlyCustom() == null ? null : eo.getOnlyCustom().getValue());
        entity.setTempLimitFlag(eo.getTempLimitFlag() == null ? null : eo.getTempLimitFlag().getValue());
        entity.setTempLimitValidTerm(eo.getTempLimitValidTerm());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        return entity;
    }

    public static RbLimitCtrlConfExample eoToEntityExample(RbLimitCtrlConfEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitCtrlConfExample example = new RbLimitCtrlConfExample();
        RbLimitCtrlConfExample.Criteria criteria = example.createCriteria();
        if (eo.getLimitSceneNo() != null) criteria.andLimitSceneNoEqualTo(eo.getLimitSceneNo());
        if (eo.getLimitBranchId() != null) criteria.andLimitBranchIdEqualTo(eo.getLimitBranchId().getValue());
        if (eo.getLimitBranchRange() != null) criteria.andLimitBranchRangeEqualTo(eo.getLimitBranchRange().getValue());
        if (eo.getValidFlag() != null) criteria.andValidFlagEqualTo(eo.getValidFlag());
        if (eo.getSumType() != null) criteria.andSumTypeEqualTo(eo.getSumType().getValue());
        if (eo.getCtrlItemType() != null) criteria.andCtrlItemTypeEqualTo(eo.getCtrlItemType().getValue());
        if (eo.getPeriodType() != null) criteria.andPeriodTypeEqualTo(eo.getPeriodType().getValue());
        if (eo.getPeriodValue() != null) criteria.andPeriodValueEqualTo(eo.getPeriodValue());
        if (eo.getLimitCtrlAmt() != null) criteria.andLimitCtrlAmtEqualTo(eo.getLimitCtrlAmt());
        if (eo.getLimitCtrlNum() != null) criteria.andLimitCtrlNumEqualTo(eo.getLimitCtrlNum());
        if (eo.getAllowCustomFlag() != null) criteria.andAllowCustomFlagEqualTo(eo.getAllowCustomFlag().getValue());
        if (eo.getAllowExceedFlag() != null) criteria.andAllowExceedFlagEqualTo(eo.getAllowExceedFlag().getValue());
        if (eo.getLimitCtrlBgnDate() != null) criteria.andLimitCtrlBgnDateEqualTo(eo.getLimitCtrlBgnDate());
        if (eo.getLimitCtrlEndDate() != null) criteria.andLimitCtrlEndDateEqualTo(eo.getLimitCtrlEndDate());
        if (eo.getLimitCtrlBgnTime() != null) criteria.andLimitCtrlBgnTimeEqualTo(eo.getLimitCtrlBgnTime());
        if (eo.getLimitCtrlEndTime() != null) criteria.andLimitCtrlEndTimeEqualTo(eo.getLimitCtrlEndTime());
        if (eo.getDealFlow() != null) criteria.andDealFlowEqualTo(eo.getDealFlow().getValue());
        if (eo.getOnlyCustom() != null) criteria.andOnlyCustomEqualTo(eo.getOnlyCustom().getValue());
        if (eo.getTempLimitFlag() != null) criteria.andTempLimitFlagEqualTo(eo.getTempLimitFlag().getValue());
        if (eo.getTempLimitValidTerm() != null) criteria.andTempLimitValidTermEqualTo(eo.getTempLimitValidTerm());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        return example;
    }
}