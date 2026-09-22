package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbControlTypeDef;
import com.dcits.deposit.entity.RbControlTypeDefExample;
import com.dcits.deposit.facade.eo.RbControlTypeDefEO;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.Company;

public final class RbControlTypeDefValueUtil {
    private RbControlTypeDefValueUtil() {
    }

    public static RbControlTypeDefEO entityToEo(RbControlTypeDef entity) {
        if (entity == null) {
            return null;
        }
        RbControlTypeDefEO eo = new RbControlTypeDefEO();
        eo.setControlType(ControlType.byValue(entity.getControlType()));
        eo.setControlTypeDesc(entity.getControlTypeDesc());
        eo.setCtlType(entity.getCtlType());
        eo.setChannelMuster(entity.getChannelMuster());
        eo.setControlClass(ControlClass.byValue(entity.getControlClass()));
        eo.setManualCtrlFlag(IndividualFlag.byValue(entity.getManualCtrlFlag()));
        eo.setManualUnCtrlFlag(IndividualFlag.byValue(entity.getManualUnCtrlFlag()));
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        return eo;
    }

    public static RbControlTypeDef eoToEntity(RbControlTypeDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbControlTypeDef entity = new RbControlTypeDef();
        entity.setControlType(eo.getControlType() == null ? null : eo.getControlType().getValue());
        entity.setControlTypeDesc(eo.getControlTypeDesc());
        entity.setCtlType(eo.getCtlType());
        entity.setChannelMuster(eo.getChannelMuster());
        entity.setControlClass(eo.getControlClass() == null ? null : eo.getControlClass().getValue());
        entity.setManualCtrlFlag(eo.getManualCtrlFlag() == null ? null : eo.getManualCtrlFlag().getValue());
        entity.setManualUnCtrlFlag(eo.getManualUnCtrlFlag() == null ? null : eo.getManualUnCtrlFlag().getValue());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        return entity;
    }

    public static RbControlTypeDefExample eoToEntityExample(RbControlTypeDefEO eo) {
        if (eo == null) {
            return null;
        }
        RbControlTypeDefExample example = new RbControlTypeDefExample();
        RbControlTypeDefExample.Criteria criteria = example.createCriteria();
        if (eo.getControlType() != null) criteria.andControlTypeEqualTo(eo.getControlType().getValue());
        if (eo.getControlTypeDesc() != null) criteria.andControlTypeDescEqualTo(eo.getControlTypeDesc());
        if (eo.getCtlType() != null) criteria.andCtlTypeEqualTo(eo.getCtlType());
        if (eo.getChannelMuster() != null) criteria.andChannelMusterEqualTo(eo.getChannelMuster());
        if (eo.getControlClass() != null) criteria.andControlClassEqualTo(eo.getControlClass().getValue());
        if (eo.getManualCtrlFlag() != null) criteria.andManualCtrlFlagEqualTo(eo.getManualCtrlFlag().getValue());
        if (eo.getManualUnCtrlFlag() != null) criteria.andManualUnCtrlFlagEqualTo(eo.getManualUnCtrlFlag().getValue());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        return example;
    }
}