package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.TbVoucherDef;
import com.dcits.deposit.entity.TbVoucherDefExample;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;
import com.dcits.deposit.enums.VoucherApproveStatus;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DepositType;
import com.dcits.deposit.enums.VoucherBillInd;
import com.dcits.deposit.enums.SaleFlag;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.DocType;

public final class TbVoucherDefValueUtil {
    private TbVoucherDefValueUtil() {
    }

    public static TbVoucherDefEO entityToEo(TbVoucherDef entity) {
        if (entity == null) {
            return null;
        }
        TbVoucherDefEO eo = new TbVoucherDefEO();
        eo.setEffectDate(entity.getEffectDate());
        eo.setAllowDistrFlag(entity.getAllowDistrFlag());
        eo.setVoucherApproveStatus(VoucherApproveStatus.byValue(entity.getVoucherApproveStatus()));
        eo.setDocClass(DocClass.byValue(entity.getDocClass()));
        eo.setExpireDate(entity.getExpireDate());
        eo.setVouLostReissueDays(entity.getVouLostReissueDays());
        eo.setBranchRestraintFlag(entity.getBranchRestraintFlag());
        eo.setIsCashCheque(entity.getIsCashCheque());
        eo.setDocTypeDesc(entity.getDocTypeDesc());
        eo.setUserId(entity.getUserId());
        eo.setHaveNumber(entity.getHaveNumber());
        eo.setLostDays(entity.getLostDays());
        eo.setOtherBankFlag(entity.getOtherBankFlag());
        eo.setUseByOrderFlag(entity.getUseByOrderFlag());
        eo.setOpenAcctFlag(entity.getOpenAcctFlag());
        eo.setChequeBookFlag(entity.getChequeBookFlag());
        eo.setLostAllowChannel(entity.getLostAllowChannel());
        eo.setDepositType(DepositType.byValue(entity.getDepositType()));
        eo.setPrefixReq(entity.getPrefixReq());
        eo.setVoucherBillInd(VoucherBillInd.byValue(entity.getVoucherBillInd()));
        eo.setApprUserId(entity.getApprUserId());
        eo.setVouLostStopFlag(entity.getVouLostStopFlag());
        eo.setVoucherLength(entity.getVoucherLength());
        eo.setLostStopFlag(entity.getLostStopFlag());
        eo.setSaleFlag(SaleFlag.byValue(entity.getSaleFlag()));
        eo.setInControl(entity.getInControl());
        eo.setVouLostDays(entity.getVouLostDays());
        eo.setCommissionVouLostDays(entity.getCommissionVouLostDays());
        eo.setProfitCenter(ProfitCenter.byValue(entity.getProfitCenter()));
        eo.setVouLostAllowChannel(entity.getVouLostAllowChannel());
        eo.setDocType(DocType.byValue(entity.getDocType()));
        return eo;
    }

    public static TbVoucherDef eoToEntity(TbVoucherDefEO eo) {
        if (eo == null) {
            return null;
        }
        TbVoucherDef entity = new TbVoucherDef();
        entity.setEffectDate(eo.getEffectDate());
        entity.setAllowDistrFlag(eo.getAllowDistrFlag());
        entity.setVoucherApproveStatus(eo.getVoucherApproveStatus() == null ? null : eo.getVoucherApproveStatus().getValue());
        entity.setDocClass(eo.getDocClass() == null ? null : eo.getDocClass().getValue());
        entity.setExpireDate(eo.getExpireDate());
        entity.setVouLostReissueDays(eo.getVouLostReissueDays());
        entity.setBranchRestraintFlag(eo.getBranchRestraintFlag());
        entity.setIsCashCheque(eo.getIsCashCheque());
        entity.setDocTypeDesc(eo.getDocTypeDesc());
        entity.setUserId(eo.getUserId());
        entity.setHaveNumber(eo.getHaveNumber());
        entity.setLostDays(eo.getLostDays());
        entity.setOtherBankFlag(eo.getOtherBankFlag());
        entity.setUseByOrderFlag(eo.getUseByOrderFlag());
        entity.setOpenAcctFlag(eo.getOpenAcctFlag());
        entity.setChequeBookFlag(eo.getChequeBookFlag());
        entity.setLostAllowChannel(eo.getLostAllowChannel());
        entity.setDepositType(eo.getDepositType() == null ? null : eo.getDepositType().getValue());
        entity.setPrefixReq(eo.getPrefixReq());
        entity.setVoucherBillInd(eo.getVoucherBillInd() == null ? null : eo.getVoucherBillInd().getValue());
        entity.setApprUserId(eo.getApprUserId());
        entity.setVouLostStopFlag(eo.getVouLostStopFlag());
        entity.setVoucherLength(eo.getVoucherLength());
        entity.setLostStopFlag(eo.getLostStopFlag());
        entity.setSaleFlag(eo.getSaleFlag() == null ? null : eo.getSaleFlag().getValue());
        entity.setInControl(eo.getInControl());
        entity.setVouLostDays(eo.getVouLostDays());
        entity.setCommissionVouLostDays(eo.getCommissionVouLostDays());
        entity.setProfitCenter(eo.getProfitCenter() == null ? null : eo.getProfitCenter().getValue());
        entity.setVouLostAllowChannel(eo.getVouLostAllowChannel());
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        return entity;
    }

    public static TbVoucherDefExample eoToEntityExample(TbVoucherDefEO eo) {
        if (eo == null) {
            return null;
        }
        TbVoucherDefExample example = new TbVoucherDefExample();
        TbVoucherDefExample.Criteria criteria = example.createCriteria();
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getAllowDistrFlag() != null) criteria.andAllowDistrFlagEqualTo(eo.getAllowDistrFlag());
        if (eo.getVoucherApproveStatus() != null) criteria.andVoucherApproveStatusEqualTo(eo.getVoucherApproveStatus().getValue());
        if (eo.getDocClass() != null) criteria.andDocClassEqualTo(eo.getDocClass().getValue());
        if (eo.getExpireDate() != null) criteria.andExpireDateEqualTo(eo.getExpireDate());
        if (eo.getVouLostReissueDays() != null) criteria.andVouLostReissueDaysEqualTo(eo.getVouLostReissueDays());
        if (eo.getBranchRestraintFlag() != null) criteria.andBranchRestraintFlagEqualTo(eo.getBranchRestraintFlag());
        if (eo.getIsCashCheque() != null) criteria.andIsCashChequeEqualTo(eo.getIsCashCheque());
        if (eo.getDocTypeDesc() != null) criteria.andDocTypeDescEqualTo(eo.getDocTypeDesc());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getHaveNumber() != null) criteria.andHaveNumberEqualTo(eo.getHaveNumber());
        if (eo.getLostDays() != null) criteria.andLostDaysEqualTo(eo.getLostDays());
        if (eo.getOtherBankFlag() != null) criteria.andOtherBankFlagEqualTo(eo.getOtherBankFlag());
        if (eo.getUseByOrderFlag() != null) criteria.andUseByOrderFlagEqualTo(eo.getUseByOrderFlag());
        if (eo.getOpenAcctFlag() != null) criteria.andOpenAcctFlagEqualTo(eo.getOpenAcctFlag());
        if (eo.getChequeBookFlag() != null) criteria.andChequeBookFlagEqualTo(eo.getChequeBookFlag());
        if (eo.getLostAllowChannel() != null) criteria.andLostAllowChannelEqualTo(eo.getLostAllowChannel());
        if (eo.getDepositType() != null) criteria.andDepositTypeEqualTo(eo.getDepositType().getValue());
        if (eo.getPrefixReq() != null) criteria.andPrefixReqEqualTo(eo.getPrefixReq());
        if (eo.getVoucherBillInd() != null) criteria.andVoucherBillIndEqualTo(eo.getVoucherBillInd().getValue());
        if (eo.getApprUserId() != null) criteria.andApprUserIdEqualTo(eo.getApprUserId());
        if (eo.getVouLostStopFlag() != null) criteria.andVouLostStopFlagEqualTo(eo.getVouLostStopFlag());
        if (eo.getVoucherLength() != null) criteria.andVoucherLengthEqualTo(eo.getVoucherLength());
        if (eo.getLostStopFlag() != null) criteria.andLostStopFlagEqualTo(eo.getLostStopFlag());
        if (eo.getSaleFlag() != null) criteria.andSaleFlagEqualTo(eo.getSaleFlag().getValue());
        if (eo.getInControl() != null) criteria.andInControlEqualTo(eo.getInControl());
        if (eo.getVouLostDays() != null) criteria.andVouLostDaysEqualTo(eo.getVouLostDays());
        if (eo.getCommissionVouLostDays() != null) criteria.andCommissionVouLostDaysEqualTo(eo.getCommissionVouLostDays());
        if (eo.getProfitCenter() != null) criteria.andProfitCenterEqualTo(eo.getProfitCenter().getValue());
        if (eo.getVouLostAllowChannel() != null) criteria.andVouLostAllowChannelEqualTo(eo.getVouLostAllowChannel());
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        return example;
    }
}