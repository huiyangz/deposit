package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.RbLimitCtrlCustomInfo;
import com.dcits.deposit.entity.RbLimitCtrlCustomInfoExample;
import com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO;
import com.dcits.deposit.enums.CtrlItemType;

public final class RbLimitCtrlCustomInfoValueUtil {
    private RbLimitCtrlCustomInfoValueUtil() {
    }

    public static RbLimitCtrlCustomInfoEO entityToEo(RbLimitCtrlCustomInfo entity) {
        if (entity == null) {
            return null;
        }
        RbLimitCtrlCustomInfoEO eo = new RbLimitCtrlCustomInfoEO();
        eo.setCheckObjVal(entity.getCheckObjVal());
        eo.setLimitSceneNo(entity.getLimitSceneNo());
        eo.setLimitCtrlNum(entity.getLimitCtrlNum());
        eo.setLimitCtrlAmt(entity.getLimitCtrlAmt());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setEffectDate(entity.getEffectDate());
        eo.setCtrlItemType(CtrlItemType.byValue(entity.getCtrlItemType()));
        eo.setClientNo(entity.getClientNo());
        eo.setExpireDate(entity.getExpireDate());
        eo.setLastUpdTimestamp(entity.getLastUpdTimestamp());
        return eo;
    }

    public static RbLimitCtrlCustomInfo eoToEntity(RbLimitCtrlCustomInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitCtrlCustomInfo entity = new RbLimitCtrlCustomInfo();
        entity.setCheckObjVal(eo.getCheckObjVal());
        entity.setLimitSceneNo(eo.getLimitSceneNo());
        entity.setLimitCtrlNum(eo.getLimitCtrlNum());
        entity.setLimitCtrlAmt(eo.getLimitCtrlAmt());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setEffectDate(eo.getEffectDate());
        entity.setCtrlItemType(eo.getCtrlItemType() == null ? null : eo.getCtrlItemType().getValue());
        entity.setClientNo(eo.getClientNo());
        entity.setExpireDate(eo.getExpireDate());
        entity.setLastUpdTimestamp(eo.getLastUpdTimestamp());
        return entity;
    }

    public static RbLimitCtrlCustomInfoExample eoToEntityExample(RbLimitCtrlCustomInfoEO eo) {
        if (eo == null) {
            return null;
        }
        RbLimitCtrlCustomInfoExample example = new RbLimitCtrlCustomInfoExample();
        RbLimitCtrlCustomInfoExample.Criteria criteria = example.createCriteria();
        if (eo.getCheckObjVal() != null) criteria.andCheckObjValEqualTo(eo.getCheckObjVal());
        if (eo.getLimitSceneNo() != null) criteria.andLimitSceneNoEqualTo(eo.getLimitSceneNo());
        if (eo.getLimitCtrlNum() != null) criteria.andLimitCtrlNumEqualTo(eo.getLimitCtrlNum());
        if (eo.getLimitCtrlAmt() != null) criteria.andLimitCtrlAmtEqualTo(eo.getLimitCtrlAmt());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getCtrlItemType() != null) criteria.andCtrlItemTypeEqualTo(eo.getCtrlItemType().getValue());
        if (eo.getClientNo() != null) criteria.andClientNoEqualTo(eo.getClientNo());
        if (eo.getExpireDate() != null) criteria.andExpireDateEqualTo(eo.getExpireDate());
        if (eo.getLastUpdTimestamp() != null) criteria.andLastUpdTimestampEqualTo(eo.getLastUpdTimestamp());
        return example;
    }
}