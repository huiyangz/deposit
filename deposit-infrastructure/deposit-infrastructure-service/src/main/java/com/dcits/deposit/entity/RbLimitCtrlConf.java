package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbLimitCtrlConf {
    /** 限额场景编码 */
    private String limitSceneNo;
    /** 限额机构编码 */
    private String limitBranchId;
    /** 限额机构范围 */
    private String limitBranchRange;
    /** 启用标志 */
    private String validFlag;
    /** 累计类型 */
    private String sumType;
    /** 控制项类型 */
    private String ctrlItemType;
    /** 期限类型 */
    private String periodType;
    /** 周期值 */
    private String periodValue;
    /** 限额控制金额 */
    private BigDecimal limitCtrlAmt;
    /** 限额控制笔数 */
    private Integer limitCtrlNum;
    /** 允许自定义标识 */
    private String allowCustomFlag;
    /** 自定义限额允许超过阈值标志 */
    private String allowExceedFlag;
    /** 限额控制开始日期 */
    private Date limitCtrlBgnDate;
    /** 限额控制结束日期 */
    private Date limitCtrlEndDate;
    /** 限额控制开始时间 */
    private String limitCtrlBgnTime;
    /** 限额控制结束时间 */
    private String limitCtrlEndTime;
    /** 处理方式 */
    private String dealFlow;
    /** 仅检查客户自定义标志 */
    private String onlyCustom;
    /** 临时限额标志 */
    private String tempLimitFlag;
    /** 临时限额有效期 */
    private String tempLimitValidTerm;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getLimitBranchId() {
        return limitBranchId;
    }

    public void setLimitBranchId(String limitBranchId) {
        this.limitBranchId = limitBranchId;
    }

    public String getLimitBranchRange() {
        return limitBranchRange;
    }

    public void setLimitBranchRange(String limitBranchRange) {
        this.limitBranchRange = limitBranchRange;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getSumType() {
        return sumType;
    }

    public void setSumType(String sumType) {
        this.sumType = sumType;
    }

    public String getCtrlItemType() {
        return ctrlItemType;
    }

    public void setCtrlItemType(String ctrlItemType) {
        this.ctrlItemType = ctrlItemType;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
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

    public String getAllowCustomFlag() {
        return allowCustomFlag;
    }

    public void setAllowCustomFlag(String allowCustomFlag) {
        this.allowCustomFlag = allowCustomFlag;
    }

    public String getAllowExceedFlag() {
        return allowExceedFlag;
    }

    public void setAllowExceedFlag(String allowExceedFlag) {
        this.allowExceedFlag = allowExceedFlag;
    }

    public Date getLimitCtrlBgnDate() {
        return limitCtrlBgnDate;
    }

    public void setLimitCtrlBgnDate(Date limitCtrlBgnDate) {
        this.limitCtrlBgnDate = limitCtrlBgnDate;
    }

    public Date getLimitCtrlEndDate() {
        return limitCtrlEndDate;
    }

    public void setLimitCtrlEndDate(Date limitCtrlEndDate) {
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

    public String getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(String dealFlow) {
        this.dealFlow = dealFlow;
    }

    public String getOnlyCustom() {
        return onlyCustom;
    }

    public void setOnlyCustom(String onlyCustom) {
        this.onlyCustom = onlyCustom;
    }

    public String getTempLimitFlag() {
        return tempLimitFlag;
    }

    public void setTempLimitFlag(String tempLimitFlag) {
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
}