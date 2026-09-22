package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CtrlItemType;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.SumType;
import com.dcits.deposit.enums.TermType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbLimitCtrlConfEO {
    /** 限额场景编码 */
    @NotNull
    private String limitSceneNo;
    /** 限额机构编码 */
    @NotNull
    private AcctBranch limitBranchId;
    /** 限额机构范围 */
    private LimitBranchRange limitBranchRange;
    /** 启用标志 */
    private String validFlag;
    /** 累计类型 */
    private SumType sumType;
    /** 控制项类型 */
    private CtrlItemType ctrlItemType;
    /** 期限类型 */
    private TermType periodType;
    /** 周期值 */
    private String periodValue;
    /** 限额控制金额 */
    private BigDecimal limitCtrlAmt;
    /** 限额控制笔数 */
    private Integer limitCtrlNum;
    /** 允许自定义标识 */
    private IndividualFlag allowCustomFlag;
    /** 自定义限额允许超过阈值标志 */
    private IndividualFlag allowExceedFlag;
    /** 限额控制开始日期 */
    private java.util.Date limitCtrlBgnDate;
    /** 限额控制结束日期 */
    private java.util.Date limitCtrlEndDate;
    /** 限额控制开始时间 */
    private String limitCtrlBgnTime;
    /** 限额控制结束时间 */
    private String limitCtrlEndTime;
    /** 处理方式 */
    private DealFlow dealFlow;
    /** 仅检查客户自定义标志 */
    private IndividualFlag onlyCustom;
    /** 临时限额标志 */
    private IndividualFlag tempLimitFlag;
    /** 临时限额有效期 */
    private String tempLimitValidTerm;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 法人 */
    private Company company;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public AcctBranch getLimitBranchId() {
        return limitBranchId;
    }

    public void setLimitBranchId(AcctBranch limitBranchId) {
        this.limitBranchId = limitBranchId;
    }

    public LimitBranchRange getLimitBranchRange() {
        return limitBranchRange;
    }

    public void setLimitBranchRange(LimitBranchRange limitBranchRange) {
        this.limitBranchRange = limitBranchRange;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public SumType getSumType() {
        return sumType;
    }

    public void setSumType(SumType sumType) {
        this.sumType = sumType;
    }

    public CtrlItemType getCtrlItemType() {
        return ctrlItemType;
    }

    public void setCtrlItemType(CtrlItemType ctrlItemType) {
        this.ctrlItemType = ctrlItemType;
    }

    public TermType getPeriodType() {
        return periodType;
    }

    public void setPeriodType(TermType periodType) {
        this.periodType = periodType;
    }

    public String getPeriodValue() {
        return periodValue;
    }

    public void setPeriodValue(String periodValue) {
        this.periodValue = periodValue;
    }

    public BigDecimal getLimitCtrlAmt() {
        return limitCtrlAmt;
    }

    public void setLimitCtrlAmt(BigDecimal limitCtrlAmt) {
        this.limitCtrlAmt = limitCtrlAmt;
    }

    public Integer getLimitCtrlNum() {
        return limitCtrlNum;
    }

    public void setLimitCtrlNum(Integer limitCtrlNum) {
        this.limitCtrlNum = limitCtrlNum;
    }

    public IndividualFlag getAllowCustomFlag() {
        return allowCustomFlag;
    }

    public void setAllowCustomFlag(IndividualFlag allowCustomFlag) {
        this.allowCustomFlag = allowCustomFlag;
    }

    public IndividualFlag getAllowExceedFlag() {
        return allowExceedFlag;
    }

    public void setAllowExceedFlag(IndividualFlag allowExceedFlag) {
        this.allowExceedFlag = allowExceedFlag;
    }

    public java.util.Date getLimitCtrlBgnDate() {
        return limitCtrlBgnDate;
    }

    public void setLimitCtrlBgnDate(java.util.Date limitCtrlBgnDate) {
        this.limitCtrlBgnDate = limitCtrlBgnDate;
    }

    public java.util.Date getLimitCtrlEndDate() {
        return limitCtrlEndDate;
    }

    public void setLimitCtrlEndDate(java.util.Date limitCtrlEndDate) {
        this.limitCtrlEndDate = limitCtrlEndDate;
    }

    public String getLimitCtrlBgnTime() {
        return limitCtrlBgnTime;
    }

    public void setLimitCtrlBgnTime(String limitCtrlBgnTime) {
        this.limitCtrlBgnTime = limitCtrlBgnTime;
    }

    public String getLimitCtrlEndTime() {
        return limitCtrlEndTime;
    }

    public void setLimitCtrlEndTime(String limitCtrlEndTime) {
        this.limitCtrlEndTime = limitCtrlEndTime;
    }

    public DealFlow getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(DealFlow dealFlow) {
        this.dealFlow = dealFlow;
    }

    public IndividualFlag getOnlyCustom() {
        return onlyCustom;
    }

    public void setOnlyCustom(IndividualFlag onlyCustom) {
        this.onlyCustom = onlyCustom;
    }

    public IndividualFlag getTempLimitFlag() {
        return tempLimitFlag;
    }

    public void setTempLimitFlag(IndividualFlag tempLimitFlag) {
        this.tempLimitFlag = tempLimitFlag;
    }

    public String getTempLimitValidTerm() {
        return tempLimitValidTerm;
    }

    public void setTempLimitValidTerm(String tempLimitValidTerm) {
        this.tempLimitValidTerm = tempLimitValidTerm;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
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
}