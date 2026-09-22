package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DepositType;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.SaleFlag;
import com.dcits.deposit.enums.VoucherApproveStatus;
import com.dcits.deposit.enums.VoucherBillInd;
import jakarta.validation.constraints.NotNull;

public class TbVoucherDefEO {
    /** 凭证类型 */
    @NotNull
    private DocType docType;
    /** 凭证类型描述 */
    private String docTypeDesc;
    /** 凭证种类 */
    private DocClass docClass;
    /** 凭证票据标志 */
    private VoucherBillInd voucherBillInd;
    /** 凭证号长度 */
    private String voucherLength;
    /** 凭证前缀必输标志 */
    private IndividualFlag prefixReq;
    /** 现金支票标志 */
    private IndividualFlag isCashCheque;
    /** 支票标志 */
    private IndividualFlag chequeBookFlag;
    /** 凭证有号标志 */
    private IndividualFlag haveNumber;
    /** 总行入库标志 */
    private IndividualFlag inControl;
    /** 凭证限制机构使用标志 */
    private IndividualFlag branchRestraintFlag;
    /** 允许调拨标志 */
    private IndividualFlag allowDistrFlag;
    /** 凭证出售付出标志 */
    private SaleFlag saleFlag;
    /** 口头挂失天数 */
    private Integer vouLostDays;
    /** 挂失补发天数 */
    private Integer vouLostReissueDays;
    /** 代办人口挂天数 */
    private Integer commissionVouLostDays;
    /** 失效日期 */
    private java.util.Date expireDate;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 是否按顺序使用 */
    private String useByOrderFlag;
    /** 存款账户类型 */
    private DepositType depositType;
    /** 他行凭证标志 */
    private IndividualFlag otherBankFlag;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 批准状态 */
    private VoucherApproveStatus voucherApproveStatus;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 现金凭证预约复核柜员号 */
    private String apprUserId;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 法人 */
    private Company company;
    /** 允许开户标志 */
    private IndividualFlag openAcctFlag;
    /** 口头挂失止付标志 */
    private IndividualFlag vouLostStopFlag;
    /** 口头挂失允许渠道 */
    private String vouLostAllowChannel;
    /** 正式挂失止付标志 */
    private IndividualFlag lostStopFlag;
    /** 正式挂失允许渠道编号 */
    private String lostAllowChannel;
    /** 正式挂失期满天数 */
    private Integer lostDays;

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getDocTypeDesc() {
        return docTypeDesc;
    }

    public void setDocTypeDesc(String docTypeDesc) {
        this.docTypeDesc = docTypeDesc;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }

    public VoucherBillInd getVoucherBillInd() {
        return voucherBillInd;
    }

    public void setVoucherBillInd(VoucherBillInd voucherBillInd) {
        this.voucherBillInd = voucherBillInd;
    }

    public String getVoucherLength() {
        return voucherLength;
    }

    public void setVoucherLength(String voucherLength) {
        this.voucherLength = voucherLength;
    }

    public IndividualFlag getPrefixReq() {
        return prefixReq;
    }

    public void setPrefixReq(IndividualFlag prefixReq) {
        this.prefixReq = prefixReq;
    }

    public IndividualFlag getIsCashCheque() {
        return isCashCheque;
    }

    public void setIsCashCheque(IndividualFlag isCashCheque) {
        this.isCashCheque = isCashCheque;
    }

    public IndividualFlag getChequeBookFlag() {
        return chequeBookFlag;
    }

    public void setChequeBookFlag(IndividualFlag chequeBookFlag) {
        this.chequeBookFlag = chequeBookFlag;
    }

    public IndividualFlag getHaveNumber() {
        return haveNumber;
    }

    public void setHaveNumber(IndividualFlag haveNumber) {
        this.haveNumber = haveNumber;
    }

    public IndividualFlag getInControl() {
        return inControl;
    }

    public void setInControl(IndividualFlag inControl) {
        this.inControl = inControl;
    }

    public IndividualFlag getBranchRestraintFlag() {
        return branchRestraintFlag;
    }

    public void setBranchRestraintFlag(IndividualFlag branchRestraintFlag) {
        this.branchRestraintFlag = branchRestraintFlag;
    }

    public IndividualFlag getAllowDistrFlag() {
        return allowDistrFlag;
    }

    public void setAllowDistrFlag(IndividualFlag allowDistrFlag) {
        this.allowDistrFlag = allowDistrFlag;
    }

    public SaleFlag getSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(SaleFlag saleFlag) {
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

    public java.util.Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(java.util.Date expireDate) {
        this.expireDate = expireDate;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getUseByOrderFlag() {
        return useByOrderFlag;
    }

    public void setUseByOrderFlag(String useByOrderFlag) {
        this.useByOrderFlag = useByOrderFlag;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public IndividualFlag getOtherBankFlag() {
        return otherBankFlag;
    }

    public void setOtherBankFlag(IndividualFlag otherBankFlag) {
        this.otherBankFlag = otherBankFlag;
    }

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public VoucherApproveStatus getVoucherApproveStatus() {
        return voucherApproveStatus;
    }

    public void setVoucherApproveStatus(VoucherApproveStatus voucherApproveStatus) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public IndividualFlag getOpenAcctFlag() {
        return openAcctFlag;
    }

    public void setOpenAcctFlag(IndividualFlag openAcctFlag) {
        this.openAcctFlag = openAcctFlag;
    }

    public IndividualFlag getVouLostStopFlag() {
        return vouLostStopFlag;
    }

    public void setVouLostStopFlag(IndividualFlag vouLostStopFlag) {
        this.vouLostStopFlag = vouLostStopFlag;
    }

    public String getVouLostAllowChannel() {
        return vouLostAllowChannel;
    }

    public void setVouLostAllowChannel(String vouLostAllowChannel) {
        this.vouLostAllowChannel = vouLostAllowChannel;
    }

    public IndividualFlag getLostStopFlag() {
        return lostStopFlag;
    }

    public void setLostStopFlag(IndividualFlag lostStopFlag) {
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