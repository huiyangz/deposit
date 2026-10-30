package com.dcits.deposit.entity;

import java.util.Date;

public class TbVoucherDef {
    /** 生效日期 */
    private Date effectDate;
    /** 允许调拨标志 */
    private String allowDistrFlag;
    /** 批准状态 */
    private String voucherApproveStatus;
    /** 凭证种类 */
    private String docClass;
    /** 失效日期 */
    private Date expireDate;
    /** 挂失补发天数 */
    private Integer vouLostReissueDays;
    /** 凭证限制机构使用标志 */
    private String branchRestraintFlag;
    /** 现金支票标志 */
    private String isCashCheque;
    /** 凭证类型描述 */
    private String docTypeDesc;
    /** 交易柜员号 */
    private String userId;
    /** 凭证有号标志 */
    private String haveNumber;
    /** 正式挂失期满天数 */
    private Integer lostDays;
    /** 他行凭证标志 */
    private String otherBankFlag;
    /** 是否按顺序使用 */
    private String useByOrderFlag;
    /** 允许开户标志 */
    private String openAcctFlag;
    /** 支票标志 */
    private String chequeBookFlag;
    /** 正式挂失允许渠道编号 */
    private String lostAllowChannel;
    /** 存款类型 */
    private String depositType;
    /** 凭证前缀必输标志 */
    private String prefixReq;
    /** 凭证票据标志 */
    private String voucherBillInd;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 口头挂失止付标志 */
    private String vouLostStopFlag;
    /** 凭证号长度 */
    private Integer voucherLength;
    /** 正式挂失止付标志 */
    private String lostStopFlag;
    /** 凭证出售付出标志 */
    private String saleFlag;
    /** 总行入库标志 */
    private String inControl;
    /** 口头挂失天数 */
    private Integer vouLostDays;
    /** 代办人口挂天数 */
    private Integer commissionVouLostDays;
    /** 利润中心 */
    private String profitCenter;
    /** 口头挂失允许渠道 */
    private String vouLostAllowChannel;
    /** 凭证类型 */
    private String docType;

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getAllowDistrFlag() {
        return allowDistrFlag;
    }

    public void setAllowDistrFlag(String allowDistrFlag) {
        this.allowDistrFlag = allowDistrFlag;
    }

    public String getVoucherApproveStatus() {
        return voucherApproveStatus;
    }

    public void setVoucherApproveStatus(String voucherApproveStatus) {
        this.voucherApproveStatus = voucherApproveStatus;
    }

    public String getDocClass() {
        return docClass;
    }

    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getVouLostReissueDays() {
        return vouLostReissueDays;
    }

    public void setVouLostReissueDays(Integer vouLostReissueDays) {
        this.vouLostReissueDays = vouLostReissueDays;
    }

    public String getBranchRestraintFlag() {
        return branchRestraintFlag;
    }

    public void setBranchRestraintFlag(String branchRestraintFlag) {
        this.branchRestraintFlag = branchRestraintFlag;
    }

    public String getIsCashCheque() {
        return isCashCheque;
    }

    public void setIsCashCheque(String isCashCheque) {
        this.isCashCheque = isCashCheque;
    }

    public String getDocTypeDesc() {
        return docTypeDesc;
    }

    public void setDocTypeDesc(String docTypeDesc) {
        this.docTypeDesc = docTypeDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHaveNumber() {
        return haveNumber;
    }

    public void setHaveNumber(String haveNumber) {
        this.haveNumber = haveNumber;
    }

    public Integer getLostDays() {
        return lostDays;
    }

    public void setLostDays(Integer lostDays) {
        this.lostDays = lostDays;
    }

    public String getOtherBankFlag() {
        return otherBankFlag;
    }

    public void setOtherBankFlag(String otherBankFlag) {
        this.otherBankFlag = otherBankFlag;
    }

    public String getUseByOrderFlag() {
        return useByOrderFlag;
    }

    public void setUseByOrderFlag(String useByOrderFlag) {
        this.useByOrderFlag = useByOrderFlag;
    }

    public String getOpenAcctFlag() {
        return openAcctFlag;
    }

    public void setOpenAcctFlag(String openAcctFlag) {
        this.openAcctFlag = openAcctFlag;
    }

    public String getChequeBookFlag() {
        return chequeBookFlag;
    }

    public void setChequeBookFlag(String chequeBookFlag) {
        this.chequeBookFlag = chequeBookFlag;
    }

    public String getLostAllowChannel() {
        return lostAllowChannel;
    }

    public void setLostAllowChannel(String lostAllowChannel) {
        this.lostAllowChannel = lostAllowChannel;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getPrefixReq() {
        return prefixReq;
    }

    public void setPrefixReq(String prefixReq) {
        this.prefixReq = prefixReq;
    }

    public String getVoucherBillInd() {
        return voucherBillInd;
    }

    public void setVoucherBillInd(String voucherBillInd) {
        this.voucherBillInd = voucherBillInd;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public String getVouLostStopFlag() {
        return vouLostStopFlag;
    }

    public void setVouLostStopFlag(String vouLostStopFlag) {
        this.vouLostStopFlag = vouLostStopFlag;
    }

    public Integer getVoucherLength() {
        return voucherLength;
    }

    public void setVoucherLength(Integer voucherLength) {
        this.voucherLength = voucherLength;
    }

    public String getLostStopFlag() {
        return lostStopFlag;
    }

    public void setLostStopFlag(String lostStopFlag) {
        this.lostStopFlag = lostStopFlag;
    }

    public String getSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(String saleFlag) {
        this.saleFlag = saleFlag;
    }

    public String getInControl() {
        return inControl;
    }

    public void setInControl(String inControl) {
        this.inControl = inControl;
    }

    public Integer getVouLostDays() {
        return vouLostDays;
    }

    public void setVouLostDays(Integer vouLostDays) {
        this.vouLostDays = vouLostDays;
    }

    public Integer getCommissionVouLostDays() {
        return commissionVouLostDays;
    }

    public void setCommissionVouLostDays(Integer commissionVouLostDays) {
        this.commissionVouLostDays = commissionVouLostDays;
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getVouLostAllowChannel() {
        return vouLostAllowChannel;
    }

    public void setVouLostAllowChannel(String vouLostAllowChannel) {
        this.vouLostAllowChannel = vouLostAllowChannel;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
}