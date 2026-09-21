package com.dcits.deposit.service.utils;

import com.dcits.deposit.entity.TbVoucherDef;
import com.dcits.deposit.entity.TbVoucherDefExample;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.VoucherBillInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SaleFlag;
import com.dcits.deposit.enums.DepositType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.VoucherApproveStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IndividualFlag;

public final class TbVoucherDefValueUtil {
    private TbVoucherDefValueUtil() {
    }

    public static TbVoucherDefEO entityToEo(TbVoucherDef entity) {
        if (entity == null) {
            return null;
        }
        TbVoucherDefEO eo = new TbVoucherDefEO();
        eo.setDocType(DocType.byValue(entity.getDocType()));
        eo.setDocTypeDesc(entity.getDocTypeDesc());
        eo.setDocClass(DocClass.byValue(entity.getDocClass()));
        eo.setVoucherBillInd(VoucherBillInd.byValue(entity.getVoucherBillInd()));
        eo.setVoucherLength(entity.getVoucherLength());
        eo.setPrefixReq(IndividualFlag.byValue(entity.getPrefixReq()));
        eo.setIsCashCheque(IndividualFlag.byValue(entity.getIsCashCheque()));
        eo.setChequeBookFlag(IndividualFlag.byValue(entity.getChequeBookFlag()));
        eo.setHaveNumber(IndividualFlag.byValue(entity.getHaveNumber()));
        eo.setInControl(IndividualFlag.byValue(entity.getInControl()));
        eo.setBranchRestraintFlag(IndividualFlag.byValue(entity.getBranchRestraintFlag()));
        eo.setAllowDistrFlag(IndividualFlag.byValue(entity.getAllowDistrFlag()));
        eo.setSaleFlag(SaleFlag.byValue(entity.getSaleFlag()));
        eo.setVouLostDays(entity.getVouLostDays());
        eo.setVouLostReissueDays(entity.getVouLostReissueDays());
        eo.setCommissionVouLostDays(entity.getCommissionVouLostDays());
        eo.setExpireDate(entity.getExpireDate());
        eo.setEffectDate(entity.getEffectDate());
        eo.setUseByOrderFlag(entity.getUseByOrderFlag());
        eo.setDepositType(DepositType.byValue(entity.getDepositType()));
        eo.setOtherBankFlag(IndividualFlag.byValue(entity.getOtherBankFlag()));
        eo.setProfitCenter(ProfitCenter.byValue(entity.getProfitCenter()));
        eo.setVoucherApproveStatus(VoucherApproveStatus.byValue(entity.getVoucherApproveStatus()));
        eo.setTranTimestamp(entity.getTranTimestamp());
        eo.setUserId(entity.getUserId());
        eo.setApprUserId(entity.getApprUserId());
        eo.setLastChangeUserId(entity.getLastChangeUserId());
        eo.setLastChangeDate(entity.getLastChangeDate());
        eo.setCompany(Company.byValue(entity.getCompany()));
        eo.setOpenAcctFlag(IndividualFlag.byValue(entity.getOpenAcctFlag()));
        eo.setVouLostStopFlag(IndividualFlag.byValue(entity.getVouLostStopFlag()));
        eo.setVouLostAllowChannel(entity.getVouLostAllowChannel());
        eo.setLostStopFlag(IndividualFlag.byValue(entity.getLostStopFlag()));
        eo.setLostAllowChannel(entity.getLostAllowChannel());
        eo.setLostDays(entity.getLostDays());
        return eo;
    }

    public static TbVoucherDef eoToEntity(TbVoucherDefEO eo) {
        if (eo == null) {
            return null;
        }
        TbVoucherDef entity = new TbVoucherDef();
        entity.setDocType(eo.getDocType() == null ? null : eo.getDocType().getValue());
        entity.setDocTypeDesc(eo.getDocTypeDesc());
        entity.setDocClass(eo.getDocClass() == null ? null : eo.getDocClass().getValue());
        entity.setVoucherBillInd(eo.getVoucherBillInd() == null ? null : eo.getVoucherBillInd().getValue());
        entity.setVoucherLength(eo.getVoucherLength());
        entity.setPrefixReq(eo.getPrefixReq() == null ? null : eo.getPrefixReq().getValue());
        entity.setIsCashCheque(eo.getIsCashCheque() == null ? null : eo.getIsCashCheque().getValue());
        entity.setChequeBookFlag(eo.getChequeBookFlag() == null ? null : eo.getChequeBookFlag().getValue());
        entity.setHaveNumber(eo.getHaveNumber() == null ? null : eo.getHaveNumber().getValue());
        entity.setInControl(eo.getInControl() == null ? null : eo.getInControl().getValue());
        entity.setBranchRestraintFlag(eo.getBranchRestraintFlag() == null ? null : eo.getBranchRestraintFlag().getValue());
        entity.setAllowDistrFlag(eo.getAllowDistrFlag() == null ? null : eo.getAllowDistrFlag().getValue());
        entity.setSaleFlag(eo.getSaleFlag() == null ? null : eo.getSaleFlag().getValue());
        entity.setVouLostDays(eo.getVouLostDays());
        entity.setVouLostReissueDays(eo.getVouLostReissueDays());
        entity.setCommissionVouLostDays(eo.getCommissionVouLostDays());
        entity.setExpireDate(eo.getExpireDate());
        entity.setEffectDate(eo.getEffectDate());
        entity.setUseByOrderFlag(eo.getUseByOrderFlag());
        entity.setDepositType(eo.getDepositType() == null ? null : eo.getDepositType().getValue());
        entity.setOtherBankFlag(eo.getOtherBankFlag() == null ? null : eo.getOtherBankFlag().getValue());
        entity.setProfitCenter(eo.getProfitCenter() == null ? null : eo.getProfitCenter().getValue());
        entity.setVoucherApproveStatus(eo.getVoucherApproveStatus() == null ? null : eo.getVoucherApproveStatus().getValue());
        entity.setTranTimestamp(eo.getTranTimestamp());
        entity.setUserId(eo.getUserId());
        entity.setApprUserId(eo.getApprUserId());
        entity.setLastChangeUserId(eo.getLastChangeUserId());
        entity.setLastChangeDate(eo.getLastChangeDate());
        entity.setCompany(eo.getCompany() == null ? null : eo.getCompany().getValue());
        entity.setOpenAcctFlag(eo.getOpenAcctFlag() == null ? null : eo.getOpenAcctFlag().getValue());
        entity.setVouLostStopFlag(eo.getVouLostStopFlag() == null ? null : eo.getVouLostStopFlag().getValue());
        entity.setVouLostAllowChannel(eo.getVouLostAllowChannel());
        entity.setLostStopFlag(eo.getLostStopFlag() == null ? null : eo.getLostStopFlag().getValue());
        entity.setLostAllowChannel(eo.getLostAllowChannel());
        entity.setLostDays(eo.getLostDays());
        return entity;
    }

    public static TbVoucherDefExample eoToEntityExample(TbVoucherDefEO eo) {
        if (eo == null) {
            return null;
        }
        TbVoucherDefExample example = new TbVoucherDefExample();
        TbVoucherDefExample.Criteria criteria = example.createCriteria();
        if (eo.getDocType() != null) criteria.andDocTypeEqualTo(eo.getDocType().getValue());
        if (eo.getDocTypeDesc() != null) criteria.andDocTypeDescEqualTo(eo.getDocTypeDesc());
        if (eo.getDocClass() != null) criteria.andDocClassEqualTo(eo.getDocClass().getValue());
        if (eo.getVoucherBillInd() != null) criteria.andVoucherBillIndEqualTo(eo.getVoucherBillInd().getValue());
        if (eo.getVoucherLength() != null) criteria.andVoucherLengthEqualTo(eo.getVoucherLength());
        if (eo.getPrefixReq() != null) criteria.andPrefixReqEqualTo(eo.getPrefixReq().getValue());
        if (eo.getIsCashCheque() != null) criteria.andIsCashChequeEqualTo(eo.getIsCashCheque().getValue());
        if (eo.getChequeBookFlag() != null) criteria.andChequeBookFlagEqualTo(eo.getChequeBookFlag().getValue());
        if (eo.getHaveNumber() != null) criteria.andHaveNumberEqualTo(eo.getHaveNumber().getValue());
        if (eo.getInControl() != null) criteria.andInControlEqualTo(eo.getInControl().getValue());
        if (eo.getBranchRestraintFlag() != null) criteria.andBranchRestraintFlagEqualTo(eo.getBranchRestraintFlag().getValue());
        if (eo.getAllowDistrFlag() != null) criteria.andAllowDistrFlagEqualTo(eo.getAllowDistrFlag().getValue());
        if (eo.getSaleFlag() != null) criteria.andSaleFlagEqualTo(eo.getSaleFlag().getValue());
        if (eo.getVouLostDays() != null) criteria.andVouLostDaysEqualTo(eo.getVouLostDays());
        if (eo.getVouLostReissueDays() != null) criteria.andVouLostReissueDaysEqualTo(eo.getVouLostReissueDays());
        if (eo.getCommissionVouLostDays() != null) criteria.andCommissionVouLostDaysEqualTo(eo.getCommissionVouLostDays());
        if (eo.getExpireDate() != null) criteria.andExpireDateEqualTo(eo.getExpireDate());
        if (eo.getEffectDate() != null) criteria.andEffectDateEqualTo(eo.getEffectDate());
        if (eo.getUseByOrderFlag() != null) criteria.andUseByOrderFlagEqualTo(eo.getUseByOrderFlag());
        if (eo.getDepositType() != null) criteria.andDepositTypeEqualTo(eo.getDepositType().getValue());
        if (eo.getOtherBankFlag() != null) criteria.andOtherBankFlagEqualTo(eo.getOtherBankFlag().getValue());
        if (eo.getProfitCenter() != null) criteria.andProfitCenterEqualTo(eo.getProfitCenter().getValue());
        if (eo.getVoucherApproveStatus() != null) criteria.andVoucherApproveStatusEqualTo(eo.getVoucherApproveStatus().getValue());
        if (eo.getTranTimestamp() != null) criteria.andTranTimestampEqualTo(eo.getTranTimestamp());
        if (eo.getUserId() != null) criteria.andUserIdEqualTo(eo.getUserId());
        if (eo.getApprUserId() != null) criteria.andApprUserIdEqualTo(eo.getApprUserId());
        if (eo.getLastChangeUserId() != null) criteria.andLastChangeUserIdEqualTo(eo.getLastChangeUserId());
        if (eo.getLastChangeDate() != null) criteria.andLastChangeDateEqualTo(eo.getLastChangeDate());
        if (eo.getCompany() != null) criteria.andCompanyEqualTo(eo.getCompany().getValue());
        if (eo.getOpenAcctFlag() != null) criteria.andOpenAcctFlagEqualTo(eo.getOpenAcctFlag().getValue());
        if (eo.getVouLostStopFlag() != null) criteria.andVouLostStopFlagEqualTo(eo.getVouLostStopFlag().getValue());
        if (eo.getVouLostAllowChannel() != null) criteria.andVouLostAllowChannelEqualTo(eo.getVouLostAllowChannel());
        if (eo.getLostStopFlag() != null) criteria.andLostStopFlagEqualTo(eo.getLostStopFlag().getValue());
        if (eo.getLostAllowChannel() != null) criteria.andLostAllowChannelEqualTo(eo.getLostAllowChannel());
        if (eo.getLostDays() != null) criteria.andLostDaysEqualTo(eo.getLostDays());
        return example;
    }
}