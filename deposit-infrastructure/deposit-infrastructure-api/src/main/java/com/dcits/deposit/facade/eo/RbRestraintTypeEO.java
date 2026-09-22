package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.UnMaintBranchRange;
import jakarta.validation.constraints.NotNull;

public class RbRestraintTypeEO {
    /** 账户限制类型 */
    @NotNull
    private RestraintType restraintType;
    /** 账户限制类型描述 */
    private String restraintTypeDesc;
    /** 冻结级别 */
    private String resPriority;
    /** 是否系统专用标志 */
    private String systemUseFlag;
    /** 有权机关冻结标志 */
    private IndividualFlag ahBuFlag;
    /** 手工冻结标志 */
    private IndividualFlag manualResFlag;
    /** 手工解冻标志 */
    private IndividualFlag manualUnresFlag;
    /** 借方贷方控制标志 */
    private DrCrCtlFlag drCrCtlFlag;
    /** 现金标志 */
    private IndividualFlag cashFlag;
    /** 转账标志 */
    private IndividualFlag transferFlag;
    /** 止付标志 */
    private IndividualFlag stopFlag;
    /** 限制金额标志 */
    private IndividualFlag restraintAmtFlag;
    /** 限制机构范围 */
    private LimitBranchRange resBranchRange;
    /** 解限或维护机构代码范围 */
    private UnMaintBranchRange unMaintBranchRange;
    /** 允许重复标志 */
    private IndividualFlag allowRepeatFlag;
    /** 销户标志 */
    private IndividualFlag closeAcctFlag;
    /** 质押标志 */
    private IndividualFlag pledgedFlag;
    /** 理财冻结标志 */
    private IndividualFlag finFrozenFlag;
    /** 状态 */
    private Status status;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
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

    public IndividualFlag getAhBuFlag() {
        return ahBuFlag;
    }

    public void setAhBuFlag(IndividualFlag ahBuFlag) {
        this.ahBuFlag = ahBuFlag;
    }

    public IndividualFlag getManualResFlag() {
        return manualResFlag;
    }

    public void setManualResFlag(IndividualFlag manualResFlag) {
        this.manualResFlag = manualResFlag;
    }

    public IndividualFlag getManualUnresFlag() {
        return manualUnresFlag;
    }

    public void setManualUnresFlag(IndividualFlag manualUnresFlag) {
        this.manualUnresFlag = manualUnresFlag;
    }

    public DrCrCtlFlag getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(DrCrCtlFlag drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public IndividualFlag getCashFlag() {
        return cashFlag;
    }

    public void setCashFlag(IndividualFlag cashFlag) {
        this.cashFlag = cashFlag;
    }

    public IndividualFlag getTransferFlag() {
        return transferFlag;
    }

    public void setTransferFlag(IndividualFlag transferFlag) {
        this.transferFlag = transferFlag;
    }

    public IndividualFlag getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(IndividualFlag stopFlag) {
        this.stopFlag = stopFlag;
    }

    public IndividualFlag getRestraintAmtFlag() {
        return restraintAmtFlag;
    }

    public void setRestraintAmtFlag(IndividualFlag restraintAmtFlag) {
        this.restraintAmtFlag = restraintAmtFlag;
    }

    public LimitBranchRange getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(LimitBranchRange resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public UnMaintBranchRange getUnMaintBranchRange() {
        return unMaintBranchRange;
    }

    public void setUnMaintBranchRange(UnMaintBranchRange unMaintBranchRange) {
        this.unMaintBranchRange = unMaintBranchRange;
    }

    public IndividualFlag getAllowRepeatFlag() {
        return allowRepeatFlag;
    }

    public void setAllowRepeatFlag(IndividualFlag allowRepeatFlag) {
        this.allowRepeatFlag = allowRepeatFlag;
    }

    public IndividualFlag getCloseAcctFlag() {
        return closeAcctFlag;
    }

    public void setCloseAcctFlag(IndividualFlag closeAcctFlag) {
        this.closeAcctFlag = closeAcctFlag;
    }

    public IndividualFlag getPledgedFlag() {
        return pledgedFlag;
    }

    public void setPledgedFlag(IndividualFlag pledgedFlag) {
        this.pledgedFlag = pledgedFlag;
    }

    public IndividualFlag getFinFrozenFlag() {
        return finFrozenFlag;
    }

    public void setFinFrozenFlag(IndividualFlag finFrozenFlag) {
        this.finFrozenFlag = finFrozenFlag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}