package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbLimitCtrlCustomInfo {
    /** 客户号 */
    private String clientNo;
    /** 限额场景编码 */
    private String limitSceneNo;
    /** 限额检查对象值 */
    private String checkObjVal;
    /** 控制项类型 */
    private String ctrlItemType;
    /** 限额控制笔数 */
    private Integer limitCtrlNum;
    /** 限额控制金额 */
    private BigDecimal limitCtrlAmt;
    /** 临时限额标志 */
    private String tempLimitFlag;
    /** 生效日期 */
    private Date effectDate;
    /** 失效日期 */
    private Date expireDate;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 更新日期 */
    private Date updateDate;
    /** 创建日期 */
    private Date createDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getCheckObjVal() {
        return checkObjVal;
    }

    public void setCheckObjVal(String checkObjVal) {
        this.checkObjVal = checkObjVal;
    }

    public String getCtrlItemType() {
        return ctrlItemType;
    }

    public void setCtrlItemType(String ctrlItemType) {
        this.ctrlItemType = ctrlItemType;
    }

    public Integer getLimitCtrlNum() {
        return limitCtrlNum;
    }

    public void setLimitCtrlNum(Integer limitCtrlNum) {
        this.limitCtrlNum = limitCtrlNum;
    }

    public BigDecimal getLimitCtrlAmt() {
        return limitCtrlAmt;
    }

    public void setLimitCtrlAmt(BigDecimal limitCtrlAmt) {
        this.limitCtrlAmt = limitCtrlAmt;
    }

    public String getTempLimitFlag() {
        return tempLimitFlag;
    }

    public void setTempLimitFlag(String tempLimitFlag) {
        this.tempLimitFlag = tempLimitFlag;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}