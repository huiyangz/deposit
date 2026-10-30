package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.TbTailbox;
import com.dcits.deposit.entity.TbTailboxExample;
import com.dcits.deposit.facade.eo.TbTailboxEO;
import com.dcits.deposit.enums.TailboxSubType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TellerBindType;
import com.dcits.deposit.enums.TailboxStatus;
import com.dcits.deposit.enums.TailboxType;
import com.dcits.deposit.enums.TailboxProperty;

public final class TbTailboxValueUtil {
    private TbTailboxValueUtil() {
    }

    public static TbTailboxEO entityToEo(TbTailbox entity) {
        if (entity == null) {
            return null;
        }
        TbTailboxEO eo = new TbTailboxEO();
        eo.setCashEqualTimestamp(entity.getCashEqualTimestamp());
        eo.setEodCashEqual(entity.getEodCashEqual());
        eo.setTailboxId(entity.getTailboxId());
        eo.setLastUserId(entity.getLastUserId());
        eo.setTailboxSubType(TailboxSubType.byValue(entity.getTailboxSubType()));
        eo.setBranch(TranBranch.byValue(entity.getBranch()));
        eo.setVoucherEqualTimestamp(entity.getVoucherEqualTimestamp());
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setCreateDate(entity.getCreateDate());
        eo.setCompany(entity.getCompany());
        eo.setAssignUserId(entity.getAssignUserId());
        eo.setTellerBindType(TellerBindType.byValue(entity.getTellerBindType()));
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setSodVoucherEqual(entity.getSodVoucherEqual());
        eo.setEodVoucherEqual(entity.getEodVoucherEqual());
        eo.setTailboxStatus(TailboxStatus.byValue(entity.getTailboxStatus()));
        eo.setUserId(entity.getUserId());
        eo.setMidVoucherEqual(entity.getMidVoucherEqual());
        eo.setMidCashEqual(entity.getMidCashEqual());
        eo.setCreateTimestamp(entity.getCreateTimestamp());
        eo.setTailboxType(TailboxType.byValue(entity.getTailboxType()));
        eo.setUpdateDate(entity.getUpdateDate());
        eo.setSodCashEqual(entity.getSodCashEqual());
        eo.setTailboxProperty(TailboxProperty.byValue(entity.getTailboxProperty()));
        return eo;
    }

    public static TbTailbox eoToEntity(TbTailboxEO eo) {
        if (eo == null) {
            return null;
        }
        TbTailbox entity = new TbTailbox();
        entity.setCashEqualTimestamp(eo.getCashEqualTimestamp());
        entity.setEodCashEqual(eo.getEodCashEqual());
        entity.setTailboxId(eo.getTailboxId());
        entity.setLastUserId(eo.getLastUserId());
        entity.setTailboxSubType(eo.getTailboxSubType() == null ? null : eo.getTailboxSubType().getValue());
        entity.setBranch(eo.getBranch() == null ? null : eo.getBranch().getValue());
        entity.setVoucherEqualTimestamp(eo.getVoucherEqualTimestamp());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setCreateDate(eo.getCreateDate());
        entity.setCompany(eo.getCompany());
        entity.setAssignUserId(eo.getAssignUserId());
        entity.setTellerBindType(eo.getTellerBindType() == null ? null : eo.getTellerBindType().getValue());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setSodVoucherEqual(eo.getSodVoucherEqual());
        entity.setEodVoucherEqual(eo.getEodVoucherEqual());
        entity.setTailboxStatus(eo.getTailboxStatus() == null ? null : eo.getTailboxStatus().getValue());
        entity.setUserId(eo.getUserId());
        entity.setMidVoucherEqual(eo.getMidVoucherEqual());
        entity.setMidCashEqual(eo.getMidCashEqual());
        entity.setCreateTimestamp(eo.getCreateTimestamp());
        entity.setTailboxType(eo.getTailboxType() == null ? null : eo.getTailboxType().getValue());
        entity.setUpdateDate(eo.getUpdateDate());
        entity.setSodCashEqual(eo.getSodCashEqual());
        entity.setTailboxProperty(eo.getTailboxProperty() == null ? null : eo.getTailboxProperty().getValue());
        return entity;
    }

    public static TbTailboxExample eoToEntityExample(TbTailboxEO eo) {
        if (eo == null) {
            return null;
        }
        TbTailboxExample example = new TbTailboxExample();
        TbTailboxExample.Criteria criteria = example.createCriteria();
        if (eo.getCashEqualTimestamp() != null) criteria.andCashEqualTimestampEqualTo(eo.getCashEqualTimestamp());
        if (eo.getEodCashEqual() != null) criteria.andEodCashEqualEqualTo(eo.getEodCashEqual());
        if (eo.getTailboxId() != null) criteria.andTailboxIdEqualTo(eo.getTailboxId());
        if (eo.getLastUserId() != null) criteria.andLastUserIdEqualTo(eo.getLastUserId());
        if (eo.getTailboxSubType() != null) criteria.andTailboxSubTypeEqualTo(eo.getTailboxSubType().getValue());
        if (eo.getBranch() != null) criteria.andBranchEqualTo(eo.getBranch().getValue());
        if (eo.getVoucherEqualTimestamp() != null) criteria.andVoucherEqualTimestampEqualTo(eo.getVoucherEqualTimestamp());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getCreateDate() != null) criteria.andCreateDateEqualTo(eo.getCreateDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany());
        if (eo.getAssignUserId() != null) criteria.andAssignUserIdEqualTo(eo.getAssignUserId());
        if (eo.getTellerBindType() != null) criteria.andTellerBindTypeEqualTo(eo.getTellerBindType().getValue());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getSodVoucherEqual() != null) criteria.andSodVoucherEqualEqualTo(eo.getSodVoucherEqual());
        if (eo.getEodVoucherEqual() != null) criteria.andEodVoucherEqualEqualTo(eo.getEodVoucherEqual());
        if (eo.getTailboxStatus() != null) criteria.andTailboxStatusEqualTo(eo.getTailboxStatus().getValue());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getMidVoucherEqual() != null) criteria.andMidVoucherEqualEqualTo(eo.getMidVoucherEqual());
        if (eo.getMidCashEqual() != null) criteria.andMidCashEqualEqualTo(eo.getMidCashEqual());
        if (eo.getCreateTimestamp() != null) criteria.andCreateTimestampEqualTo(eo.getCreateTimestamp());
        if (eo.getTailboxType() != null) criteria.andTailboxTypeEqualTo(eo.getTailboxType().getValue());
        if (eo.getUpdateDate() != null) criteria.andUpdateDateEqualTo(eo.getUpdateDate());
        if (eo.getSodCashEqual() != null) criteria.andSodCashEqualEqualTo(eo.getSodCashEqual());
        if (eo.getTailboxProperty() != null) criteria.andTailboxPropertyEqualTo(eo.getTailboxProperty().getValue());
        return example;
    }
}