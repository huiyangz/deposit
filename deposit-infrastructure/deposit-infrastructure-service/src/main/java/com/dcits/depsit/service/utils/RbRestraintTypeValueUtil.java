package com.dcits.depsit.service.utils;

import com.dcits.depsit.entity.RbRestraintType;
import com.dcits.depsit.entity.RbRestraintTypeExample;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.enums.UnMaintBranchRange;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.ResBranchRange;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.AllowRepeatFlag;
import com.dcits.depsit.enums.RestraintAmtFlag;

public final class RbRestraintTypeValueUtil {
    private RbRestraintTypeValueUtil() {
    }

    public static RbRestraintTypeEO entityToEo(RbRestraintType entity) {
        if (entity == null) {
            return null;
        }
        RbRestraintTypeEO eo = new RbRestraintTypeEO();
        eo.setStatus(Status.byValue(entity.getStatus()));
        eo.setUnMaintBranchRange(UnMaintBranchRange.byValue(entity.getUnMaintBranchRange()));
        eo.setAhBuFlag(entity.getAhBuFlag());
        eo.setRestraintType(RestraintType.byValue(entity.getRestraintType()));
        eo.setSystemUseFlag(entity.getSystemUseFlag());
        eo.setStopFlag(entity.getStopFlag());
        eo.setCashFlag(entity.getCashFlag());
        eo.setResPriority(entity.getResPriority());
        eo.setResBranchRange(ResBranchRange.byValue(entity.getResBranchRange()));
        eo.setCloseAcctFlag(entity.getCloseAcctFlag());
        eo.setRestraintTypeDesc(entity.getRestraintTypeDesc());
        eo.setDrCrCtlFlag(DrCrCtlFlag.byValue(entity.getDrCrCtlFlag()));
        eo.setTransferFlag(entity.getTransferFlag());
        eo.setAllowRepeatFlag(AllowRepeatFlag.byValue(entity.getAllowRepeatFlag()));
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        eo.setRestraintAmtFlag(RestraintAmtFlag.byValue(entity.getRestraintAmtFlag()));
        eo.setPledgedFlag(entity.getPledgedFlag());
        eo.setManualUnresFlag(entity.getManualUnresFlag());
        eo.setFinFrozenFlag(entity.getFinFrozenFlag());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setManualResFlag(entity.getManualResFlag());
        return eo;
    }

    public static RbRestraintType eoToEntity(RbRestraintTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintType entity = new RbRestraintType();
        entity.setStatus(eo.getStatus() == null ? null : eo.getStatus().getValue());
        entity.setUnMaintBranchRange(eo.getUnMaintBranchRange() == null ? null : eo.getUnMaintBranchRange().getValue());
        entity.setAhBuFlag(eo.getAhBuFlag());
        entity.setRestraintType(eo.getRestraintType() == null ? null : eo.getRestraintType().getValue());
        entity.setSystemUseFlag(eo.getSystemUseFlag());
        entity.setStopFlag(eo.getStopFlag());
        entity.setCashFlag(eo.getCashFlag());
        entity.setResPriority(eo.getResPriority());
        entity.setResBranchRange(eo.getResBranchRange() == null ? null : eo.getResBranchRange().getValue());
        entity.setCloseAcctFlag(eo.getCloseAcctFlag());
        entity.setRestraintTypeDesc(eo.getRestraintTypeDesc());
        entity.setDrCrCtlFlag(eo.getDrCrCtlFlag() == null ? null : eo.getDrCrCtlFlag().getValue());
        entity.setTransferFlag(eo.getTransferFlag());
        entity.setAllowRepeatFlag(eo.getAllowRepeatFlag() == null ? null : eo.getAllowRepeatFlag().getValue());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        entity.setRestraintAmtFlag(eo.getRestraintAmtFlag() == null ? null : eo.getRestraintAmtFlag().getValue());
        entity.setPledgedFlag(eo.getPledgedFlag());
        entity.setManualUnresFlag(eo.getManualUnresFlag());
        entity.setFinFrozenFlag(eo.getFinFrozenFlag());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setManualResFlag(eo.getManualResFlag());
        return entity;
    }

    public static RbRestraintTypeExample eoToEntityExample(RbRestraintTypeEO eo) {
        if (eo == null) {
            return null;
        }
        RbRestraintTypeExample example = new RbRestraintTypeExample();
        RbRestraintTypeExample.Criteria criteria = example.createCriteria();
        if (eo.getStatus() != null) criteria.andStatusEqualTo(eo.getStatus().getValue());
        if (eo.getUnMaintBranchRange() != null) criteria.andUnMaintBranchRangeEqualTo(eo.getUnMaintBranchRange().getValue());
        if (eo.getAhBuFlag() != null) criteria.andAhBuFlagEqualTo(eo.getAhBuFlag());
        if (eo.getRestraintType() != null) criteria.andRestraintTypeEqualTo(eo.getRestraintType().getValue());
        if (eo.getSystemUseFlag() != null) criteria.andSystemUseFlagEqualTo(eo.getSystemUseFlag());
        if (eo.getStopFlag() != null) criteria.andStopFlagEqualTo(eo.getStopFlag());
        if (eo.getCashFlag() != null) criteria.andCashFlagEqualTo(eo.getCashFlag());
        if (eo.getResPriority() != null) criteria.andResPriorityEqualTo(eo.getResPriority());
        if (eo.getResBranchRange() != null) criteria.andResBranchRangeEqualTo(eo.getResBranchRange().getValue());
        if (eo.getCloseAcctFlag() != null) criteria.andCloseAcctFlagEqualTo(eo.getCloseAcctFlag());
        if (eo.getRestraintTypeDesc() != null) criteria.andRestraintTypeDescEqualTo(eo.getRestraintTypeDesc());
        if (eo.getDrCrCtlFlag() != null) criteria.andDrCrCtlFlagEqualTo(eo.getDrCrCtlFlag().getValue());
        if (eo.getTransferFlag() != null) criteria.andTransferFlagEqualTo(eo.getTransferFlag());
        if (eo.getAllowRepeatFlag() != null) criteria.andAllowRepeatFlagEqualTo(eo.getAllowRepeatFlag().getValue());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        if (eo.getRestraintAmtFlag() != null) criteria.andRestraintAmtFlagEqualTo(eo.getRestraintAmtFlag().getValue());
        if (eo.getPledgedFlag() != null) criteria.andPledgedFlagEqualTo(eo.getPledgedFlag());
        if (eo.getManualUnresFlag() != null) criteria.andManualUnresFlagEqualTo(eo.getManualUnresFlag());
        if (eo.getFinFrozenFlag() != null) criteria.andFinFrozenFlagEqualTo(eo.getFinFrozenFlag());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getManualResFlag() != null) criteria.andManualResFlagEqualTo(eo.getManualResFlag());
        return example;
    }
}