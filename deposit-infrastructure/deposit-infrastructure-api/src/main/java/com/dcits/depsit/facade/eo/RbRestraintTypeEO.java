package com.dcits.depsit.facade.eo;

import com.dcits.depsit.enums.AllowRepeatFlag;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.RestraintAmtFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.enums.UnMaintBranchRange;
import jakarta.validation.constraints.NotNull;

public class RbRestraintTypeEO {
    /** 状态 */
    private Status status;
    /** 解限或维护机构代码范围 */
    private UnMaintBranchRange unMaintBranchRange;
    /** 有权机关冻结标志 */
    private String ahBuFlag;
    /** 账户限制类型 */
    @NotNull
    private RestraintType restraintType;
    /** 是否系统专用标志 */
    private String systemUseFlag;
    /** 止付标志 */
    private String stopFlag;
    /** 现金标志 */
    private String cashFlag;
    /** 冻结级别 */
    private String resPriority;
    /** 限制机构范围 */
    private LimitBranchRange resBranchRange;
    /** 销户标志 */
    private String closeAcctFlag;
    /** 账户限制类型描述 */
    private String restraintTypeDesc;
    /** 借方贷方控制标志 */
    private DrCrCtlFlag drCrCtlFlag;
    /** 转账标志 */
    private String transferFlag;
    /** 允许重复标志 */
    private AllowRepeatFlag allowRepeatFlag;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 限制金额标志 */
    private RestraintAmtFlag restraintAmtFlag;
    /** 质押标志 */
    private String pledgedFlag;
    /** 手工解冻标志 */
    private String manualUnresFlag;
    /** 理财冻结标志 */
    private String finFrozenFlag;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 手工冻结标志 */
    private String manualResFlag;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UnMaintBranchRange getUnMaintBranchRange() {
        return unMaintBranchRange;
    }

    public void setUnMaintBranchRange(UnMaintBranchRange unMaintBranchRange) {
        this.unMaintBranchRange = unMaintBranchRange;
    }

    public String getAhBuFlag() {
        return ahBuFlag;
    }

    public void setAhBuFlag(String ahBuFlag) {
        this.ahBuFlag = ahBuFlag;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public String getSystemUseFlag() {
        return systemUseFlag;
    }

    public void setSystemUseFlag(String systemUseFlag) {
        this.systemUseFlag = systemUseFlag;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

    public String getCashFlag() {
        return cashFlag;
    }

    public void setCashFlag(String cashFlag) {
        this.cashFlag = cashFlag;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }

    public LimitBranchRange getResBranchRange() {
        return resBranchRange;
    }

    public void setResBranchRange(LimitBranchRange resBranchRange) {
        this.resBranchRange = resBranchRange;
    }

    public String getCloseAcctFlag() {
        return closeAcctFlag;
    }

    public void setCloseAcctFlag(String closeAcctFlag) {
        this.closeAcctFlag = closeAcctFlag;
    }

    public String getRestraintTypeDesc() {
        return restraintTypeDesc;
    }

    public void setRestraintTypeDesc(String restraintTypeDesc) {
        this.restraintTypeDesc = restraintTypeDesc;
    }

    public DrCrCtlFlag getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(DrCrCtlFlag drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public String getTransferFlag() {
        return transferFlag;
    }

    public void setTransferFlag(String transferFlag) {
        this.transferFlag = transferFlag;
    }

    public AllowRepeatFlag getAllowRepeatFlag() {
        return allowRepeatFlag;
    }

    public void setAllowRepeatFlag(AllowRepeatFlag allowRepeatFlag) {
        this.allowRepeatFlag = allowRepeatFlag;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public RestraintAmtFlag getRestraintAmtFlag() {
        return restraintAmtFlag;
    }

    public void setRestraintAmtFlag(RestraintAmtFlag restraintAmtFlag) {
        this.restraintAmtFlag = restraintAmtFlag;
    }

    public String getPledgedFlag() {
        return pledgedFlag;
    }

    public void setPledgedFlag(String pledgedFlag) {
        this.pledgedFlag = pledgedFlag;
    }

    public String getManualUnresFlag() {
        return manualUnresFlag;
    }

    public void setManualUnresFlag(String manualUnresFlag) {
        this.manualUnresFlag = manualUnresFlag;
    }

    public String getFinFrozenFlag() {
        return finFrozenFlag;
    }

    public void setFinFrozenFlag(String finFrozenFlag) {
        this.finFrozenFlag = finFrozenFlag;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getManualResFlag() {
        return manualResFlag;
    }

    public void setManualResFlag(String manualResFlag) {
        this.manualResFlag = manualResFlag;
    }
}