package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbChannelControl;
import com.dcits.deposit.entity.RbChannelControlExample;
import com.dcits.deposit.facade.eo.RbChannelControlEO;
import com.dcits.deposit.enums.ControlType;
import com.dcits.deposit.enums.ControlStatus;

public final class RbChannelControlValueUtil {
    private RbChannelControlValueUtil() {
    }

    public static RbChannelControlEO entityToEo(RbChannelControl entity) {
        if (entity == null) {
            return null;
        }
        RbChannelControlEO eo = new RbChannelControlEO();
        eo.setControlSeqNo(entity.getControlSeqNo());
        eo.setClientNo(entity.getClientNo());
        eo.setControlType(ControlType.byValue(entity.getControlType()));
        eo.setControlStatus(ControlStatus.byValue(entity.getControlStatus()));
        return eo;
    }

    public static RbChannelControl eoToEntity(RbChannelControlEO eo) {
        if (eo == null) {
            return null;
        }
        RbChannelControl entity = new RbChannelControl();
        entity.setControlSeqNo(eo.getControlSeqNo());
        entity.setClientNo(eo.getClientNo());
        entity.setControlType(eo.getControlType() == null ? null : eo.getControlType().getValue());
        entity.setControlStatus(eo.getControlStatus() == null ? null : eo.getControlStatus().getValue());
        return entity;
    }

    public static RbChannelControlExample eoToEntityExample(RbChannelControlEO eo) {
        if (eo == null) {
            return null;
        }
        RbChannelControlExample example = new RbChannelControlExample();
        RbChannelControlExample.Criteria criteria = example.createCriteria();
        if (eo.getControlSeqNo() != null) criteria.andControlSeqNoEqualTo(eo.getControlSeqNo());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getControlType() != null) criteria.andControlTypeEqualTo(eo.getControlType().getValue());
        if (eo.getControlStatus() != null) criteria.andControlStatusEqualTo(eo.getControlStatus().getValue());
        return example;
    }
}