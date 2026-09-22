package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbRestraintType;
import com.dcits.deposit.entity.RbRestraintTypeExample;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.UnMaintBranchRange;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.Company;

public final class RbRestraintTypeValueUtil {
    private RbRestraintTypeValueUtil() {
    }

    public static RbRestraintTypeEO entityToEo(RbRestraintType entity) {
        if (entity == null) {
            return null;
        }
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setRestraintTypeDesc(entity.getRestraintTypeDesc());
        eo.setResPriority(entity.getResPriority());
        eo.setSystemUseFlag(entity.getSystemUseFlag());
        eo.setAhBuFlag(IndividualFlag.byValue(entity.getAhBuFlag()));
        eo.setManualResFlag(IndividualFlag.byValue(entity.getManualResFlag()));
        eo.setManualUnresFlag(IndividualFlag.byValue(entity.getManualUnresFlag()));
        eo.setDrCrCtlFlag(DrCrCtlFlag.byValue(entity.getDrCrCtlFlag()));
        eo.setCashFlag(IndividualFlag.byValue(entity.getCashFlag()));
        eo.setTransferFlag(IndividualFlag.byValue(entity.getTransferFlag()));
        eo.setStopFlag(IndividualFlag.byValue(entity.getStopFlag()));
        eo.setRestraintAmtFlag(IndividualFlag.byValue(entity.getRestraintAmtFlag()));
        eo.setResBranchRange(LimitBranchRange.byValue(entity.getResBranchRange()));
        eo.setUnMaintBranchRange(UnMaintBranchRange.byValue(entity.getUnMaintBranchRange()));
        eo.setAllowRepeatFlag(IndividualFlag.byValue(entity.getAllowRepeatFlag()));
        eo.setCloseAcctFlag(IndividualFlag.byValue(entity.getCloseAcctFlag()));
        eo.setPledgedFlag(IndividualFlag.byValue(entity.getPledgedFlag()));
        eo.setFinFrozenFlag(IndividualFlag.byValue(entity.getFinFrozenFlag()));
        eo.setStatus(Status.byValue(entity.getStatus()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static RbRestraintType eoToEntity(RbRestraintTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintType entity = new RbRestraintType();
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setRestraintTypeDesc(eo.getRestraintTypeDesc());
        entity.setResPriority(eo.getResPriority());
        entity.setSystemUseFlag(eo.getSystemUseFlag());
        entity.setAhBuFlag(eo.getAhBuFlag() == null ? null : eo.getAhBuFlag().getValue());
        entity.setManualResFlag(eo.getManualResFlag() == null ? null : eo.getManualResFlag().getValue());
        entity.setManualUnresFlag(eo.getManualUnresFlag() == null ? null : eo.getManualUnresFlag().getValue());
        entity.setDrCrCtlFlag(eo.getDrCrCtlFlag() == null ? null : eo.getDrCrCtlFlag().getValue());
        entity.setCashFlag(eo.getCashFlag() == null ? null : eo.getCashFlag().getValue());
        entity.setTransferFlag(eo.getTransferFlag() == null ? null : eo.getTransferFlag().getValue());
        entity.setStopFlag(eo.getStopFlag() == null ? null : eo.getStopFlag().getValue());
        entity.setRestraintAmtFlag(eo.getRestraintAmtFlag() == null ? null : eo.getRestraintAmtFlag().getValue());
        entity.setResBranchRange(eo.getResBranchRange() == null ? null : eo.getResBranchRange().getValue());
        entity.setUnMaintBranchRange(eo.getUnMaintBranchRange() == null ? null : eo.getUnMaintBranchRange().getValue());
        entity.setAllowRepeatFlag(eo.getAllowRepeatFlag() == null ? null : eo.getAllowRepeatFlag().getValue());
        entity.setCloseAcctFlag(eo.getCloseAcctFlag() == null ? null : eo.getCloseAcctFlag().getValue());
        entity.setPledgedFlag(eo.getPledgedFlag() == null ? null : eo.getPledgedFlag().getValue());
        entity.setFinFrozenFlag(eo.getFinFrozenFlag() == null ? null : eo.getFinFrozenFlag().getValue());
        entity.setStatus(eo.getStatus() == null ? null : eo.getStatus().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static RbRestraintTypeExample eoToEntityExample(RbRestraintTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintTypeExample example = new RbRestraintTypeExample();
        RbRestraintTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getRestraintTypeDesc() != null) criteria.andRestraintTypeDescEqualTo(eo.getRestraintTypeDesc());
        if (eo.getResPriority() != null) criteria.andResPriorityEqualTo(eo.getResPriority());
        if (eo.getSystemUseFlag() != null) criteria.andSystemUseFlagEqualTo(eo.getSystemUseFlag());
        if (eo.getAhBuFlag() != null) criteria.andAhBuFlagEqualTo(eo.getAhBuFlag().getValue());
        if (eo.getManualResFlag() != null) criteria.andManualResFlagEqualTo(eo.getManualResFlag().getValue());
        if (eo.getManualUnresFlag() != null) criteria.andManualUnresFlagEqualTo(eo.getManualUnresFlag().getValue());
        if (eo.getDrCrCtlFlag() != null) criteria.andDrCrCtlFlagEqualTo(eo.getDrCrCtlFlag().getValue());
        if (eo.getCashFlag() != null) criteria.andCashFlagEqualTo(eo.getCashFlag().getValue());
        if (eo.getTransferFlag() != null) criteria.andTransferFlagEqualTo(eo.getTransferFlag().getValue());
        if (eo.getStopFlag() != null) criteria.andStopFlagEqualTo(eo.getStopFlag().getValue());
        if (eo.getRestraintAmtFlag() != null) criteria.andRestraintAmtFlagEqualTo(eo.getRestraintAmtFlag().getValue());
        if (eo.getResBranchRange() != null) criteria.andResBranchRangeEqualTo(eo.getResBranchRange().getValue());
        if (eo.getUnMaintBranchRange() != null) criteria.andUnMaintBranchRangeEqualTo(eo.getUnMaintBranchRange().getValue());
        if (eo.getAllowRepeatFlag() != null) criteria.andAllowRepeatFlagEqualTo(eo.getAllowRepeatFlag().getValue());
        if (eo.getCloseAcctFlag() != null) criteria.andCloseAcctFlagEqualTo(eo.getCloseAcctFlag().getValue());
        if (eo.getPledgedFlag() != null) criteria.andPledgedFlagEqualTo(eo.getPledgedFlag().getValue());
        if (eo.getFinFrozenFlag() != null) criteria.andFinFrozenFlagEqualTo(eo.getFinFrozenFlag().getValue());
        if (eo.getStatus() != null) criteria.andStatusEqualTo(eo.getStatus().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}