package com.dcits.deposit.entity;

public class RbRestraintType {
    /** 账户限制类型 */
    private String restraintType;
    /** 账户限制类型描述 */
    private String restraintTypeDesc;
    /** 冻结级别 */
    private String resPriority;
    /** 是否系统专用标志 */
    private String systemUseFlag;
    /** 有权机关冻结标志 */
    private String ahBuFlag;
    /** 手工冻结标志 */
    private String manualResFlag;
    /** 手工解冻标志 */
    private String manualUnresFlag;
    /** 借方贷方控制标志 */
    private String drCrCtlFlag;
    /** 现金标志 */
    private String cashFlag;
    /** 转账标志 */
    private String transferFlag;
    /** 止付标志 */
    private String stopFlag;
    /** 限制金额标志 */
    private String restraintAmtFlag;
    /** 限制机构范围 */
    private String resBranchRange;
    /** 解限或维护机构代码范围 */
    private String unMaintBranchRange;
    /** 允许重复标志 */
    private String allowRepeatFlag;
    /** 销户标志 */
    private String closeAcctFlag;
    /** 质押标志 */
    private String pledgedFlag;
    /** 理财冻结标志 */
    private String finFrozenFlag;
    /** 状态 */
    private String status;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getRestraintTypeDesc() {
        return restraintTypeDesc;
    }

    public void setRestraintTypeDesc(String restraintTypeDesc) {
        this.restraintTypeDesc = restraintTypeDesc;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }

    public String getSystemUseFlag() {
        return systemUseFlag;
    }

    public void setSystemUseFlag(String systemUseFlag) {
        this.systemUseFlag = systemUseFlag;
    }

    public String getAhBuFlag() {
        return ahBuFlag;
    }

    public void setAhBuFlag(String ahBuFlag) {
        this.ahBuFlag = ahBuFlag;
    }

    public String getManualResFlag() {
        return manualResFlag;
    }

    public void setManualResFlag(String manualResFlag) {
        this.manualResFlag = manualResFlag;
    }

    public String getManualUnresFlag() {
        return manualUnresFlag;
    }

    public void setManualUnresFlag(String manualUnresFlag) {
        this.manualUnresFlag = manualUnresFlag;
    }

    public String getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(String drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public String getCashFlag() {
        return cashFlag;
    }

    public void setCashFlag(String cashFlag) {
        this.cashFlag = cashFlag;
    }

    public String getTransferFlag() {
        return transferFlag;
    }

    public void setTransferFlag(String transferFlag) {
        this.transferFlag = transferFlag;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getRestraintAmtFlag() {
        return restraintAmtFlag;
    }

    public void setRestraintAmtFlag(String restraintAmtFlag) {
        this.restraintAmtFlag = restraintAmtFlag;
    }

    public String getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(String resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public String getUnMaintBranchRange() {
        return unMaintBranchRange;
    }

    public void setUnMaintBranchRange(String unMaintBranchRange) {
        this.unMaintBranchRange = unMaintBranchRange;
    }

    public String getAllowRepeatFlag() {
        return allowRepeatFlag;
    }

    public void setAllowRepeatFlag(String allowRepeatFlag) {
        this.allowRepeatFlag = allowRepeatFlag;
    }

    public String getCloseAcctFlag() {
        return closeAcctFlag;
    }

    public void setCloseAcctFlag(String closeAcctFlag) {
        this.closeAcctFlag = closeAcctFlag;
    }

    public String getPledgedFlag() {
        return pledgedFlag;
    }

    public void setPledgedFlag(String pledgedFlag) {
        this.pledgedFlag = pledgedFlag;
    }

    public String getFinFrozenFlag() {
        return finFrozenFlag;
    }

    public void setFinFrozenFlag(String finFrozenFlag) {
        this.finFrozenFlag = finFrozenFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}