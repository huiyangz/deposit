package com.dcits.deposit.entity;

import java.util.Date;

public class TbVoucherDef {
    /** 凭证类型 */
    private String docType;
    /** 凭证类型描述 */
    private String docTypeDesc;
    /** 凭证种类 */
    private String docClass;
    /** 凭证票据标志 */
    private String voucherBillInd;
    /** 凭证号长度 */
    private String voucherLength;
    /** 凭证前缀必输标志 */
    private String prefixReq;
    /** 现金支票标志 */
    private String isCashCheque;
    /** 支票标志 */
    private String chequeBookFlag;
    /** 凭证有号标志 */
    private String haveNumber;
    /** 总行入库标志 */
    private String inControl;
    /** 凭证限制机构使用标志 */
    private String branchRestraintFlag;
    /** 允许调拨标志 */
    private String allowDistrFlag;
    /** 凭证出售付出标志 */
    private String saleFlag;
    /** 口头挂失天数 */
    private Integer vouLostDays;
    /** 挂失补发天数 */
    private Integer vouLostReissueDays;
    /** 代办人口挂天数 */
    private Integer commissionVouLostDays;
    /** 失效日期 */
    private Date expireDate;
    /** 生效日期 */
    private Date effectDate;
    /** 是否按顺序使用 */
    private String useByOrderFlag;
    /** 存款账户类型 */
    private String depositType;
    /** 他行凭证标志 */
    private String otherBankFlag;
    /** 利润中心 */
    private String profitCenter;
    /** 批准状态 */
    private String voucherApproveStatus;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;
    /** 允许开户标志 */
    private String openAcctFlag;
    /** 口头挂失止付标志 */
    private String vouLostStopFlag;
    /** 口头挂失允许渠道 */
    private String vouLostAllowChannel;
    /** 正式挂失止付标志 */
    private String lostStopFlag;
    /** 正式挂失允许渠道编号 */
    private String lostAllowChannel;
    /** 正式挂失期满天数 */
    private Integer lostDays;

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocTypeDesc() {
        return docTypeDesc;
    }

    public void setDocTypeDesc(String docTypeDesc) {
        this.docTypeDesc = docTypeDesc;
    }

    public String getDocClass() {
        return docClass;
    }

    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }

    public String getVoucherBillInd() {
        return voucherBillInd;
    }

    public void setVoucherBillInd(String voucherBillInd) {
        this.voucherBillInd = voucherBillInd;
    }

    public String getVoucherLength() {
        return voucherLength;
    }

    public void setVoucherLength(String voucherLength) {
        this.voucherLength = voucherLength;
    }

    public String getPrefixReq() {
        return prefixReq;
    }

    public void setPrefixReq(String prefixReq) {
        this.prefixReq = prefixReq;
    }

    public String getIsCashCheque() {
        return isCashCheque;
    }

    public void setIsCashCheque(String isCashCheque) {
        this.isCashCheque = isCashCheque;
    }

    public String getChequeBookFlag() {
        return chequeBookFlag;
    }

    public void setChequeBookFlag(String chequeBookFlag) {
        this.chequeBookFlag = chequeBookFlag;
    }

    public String getHaveNumber() {
        return haveNumber;
    }

    public void setHaveNumber(String haveNumber) {
        this.haveNumber = haveNumber;
    }

    public String getInControl() {
        return inControl;
    }

    public void setInControl(String inControl) {
        this.inControl = inControl;
    }

    public String getBranchRestraintFlag() {
        return branchRestraintFlag;
    }

    public void setBranchRestraintFlag(String branchRestraintFlag) {
        this.branchRestraintFlag = branchRestraintFlag;
    }

    public String getAllowDistrFlag() {
        return allowDistrFlag;
    }

    public void setAllowDistrFlag(String allowDistrFlag) {
        this.allowDistrFlag = allowDistrFlag;
    }

    public String getSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(String saleFlag) {
        this.saleFlag = saleFlag;
    }

    public Integer getVouLostDays() {
        return vouLostDays;
    }

    public void setVouLostDays(Integer vouLostDays) {
        this.vouLostDays = vouLostDays;
    }

    public Integer getVouLostReissueDays() {
        return vouLostReissueDays;
    }

    public void setVouLostReissueDays(Integer vouLostReissueDays) {
        this.vouLostReissueDays = vouLostReissueDays;
    }

    public Integer getCommissionVouLostDays() {
        return commissionVouLostDays;
    }

    public void setCommissionVouLostDays(Integer commissionVouLostDays) {
        this.commissionVouLostDays = commissionVouLostDays;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getUseByOrderFlag() {
        return useByOrderFlag;
    }

    public void setUseByOrderFlag(String useByOrderFlag) {
        this.useByOrderFlag = useByOrderFlag;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getOtherBankFlag() {
        return otherBankFlag;
    }

    public void setOtherBankFlag(String otherBankFlag) {
        this.otherBankFlag = otherBankFlag;
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getVoucherApproveStatus() {
        return voucherApproveStatus;
    }

    public void setVoucherApproveStatus(String voucherApproveStatus) {
        this.voucherApproveStatus = voucherApproveStatus;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprUserId() {
        return apprUserId;
    }

    public void setApprUserId(String apprUserId) {
        this.apprUserId = apprUserId;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOpenAcctFlag() {
        return openAcctFlag;
    }

    public void setOpenAcctFlag(String openAcctFlag) {
        this.openAcctFlag = openAcctFlag;
    }

    public String getVouLostStopFlag() {
        return vouLostStopFlag;
    }

    public void setVouLostStopFlag(String vouLostStopFlag) {
        this.vouLostStopFlag = vouLostStopFlag;
    }

    public String getVouLostAllowChannel() {
        return vouLostAllowChannel;
    }

    public void setVouLostAllowChannel(String vouLostAllowChannel) {
        this.vouLostAllowChannel = vouLostAllowChannel;
    }

    public String getLostStopFlag() {
        return lostStopFlag;
    }

    public void setLostStopFlag(String lostStopFlag) {
        this.lostStopFlag = lostStopFlag;
    }

    public String getLostAllowChannel() {
        return lostAllowChannel;
    }

    public void setLostAllowChannel(String lostAllowChannel) {
        this.lostAllowChannel = lostAllowChannel;
    }

    public Integer getLostDays() {
        return lostDays;
    }

    public void setLostDays(Integer lostDays) {
        this.lostDays = lostDays;
    }
}