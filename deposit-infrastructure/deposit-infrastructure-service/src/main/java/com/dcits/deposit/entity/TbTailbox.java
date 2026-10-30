package com.dcits.deposit.entity;

import java.util.Date;

public class TbTailbox {
    /** 现金碰库时间戳 */
    private String cashEqualTimestamp;
    /** 日终现金碰库标志 */
    private String eodCashEqual;
    /** 尾箱编号 */
    private String tailboxId;
    /** 上一柜员号 */
    private String lastUserId;
    /** 尾箱细类 */
    private String tailboxSubType;
    /** 归属机构号 */
    private String branch;
    /** 凭证碰库时间戳 */
    private String voucherEqualTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建日期 */
    private Date createDate;
    /** 法人 */
    private String company;
    /** 尾箱分配柜员号 */
    private String assignUserId;
    /** 尾箱绑定关系类型 */
    private String tellerBindType;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 日始凭证碰库标志 */
    private String sodVoucherEqual;
    /** 日终凭证碰库标志 */
    private String eodVoucherEqual;
    /** 尾箱状态 */
    private String tailboxStatus;
    /** 交易柜员号 */
    private String userId;
    /** 日间凭证碰库标志 */
    private String midVoucherEqual;
    /** 日间现金碰库标志 */
    private String midCashEqual;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 尾箱类型 */
    private String tailboxType;
    /** 更新日期 */
    private Date updateDate;
    /** 日始现金碰库标志 */
    private String sodCashEqual;
    /** 尾箱属性 */
    private String tailboxProperty;

    public String getCashEqualTimestamp() {
        return cashEqualTimestamp;
    }

    public void setCashEqualTimestamp(String cashEqualTimestamp) {
        this.cashEqualTimestamp = cashEqualTimestamp;
    }

    public String getEodCashEqual() {
        return eodCashEqual;
    }

    public void setEodCashEqual(String eodCashEqual) {
        this.eodCashEqual = eodCashEqual;
    }

    public String getTailboxId() {
        return tailboxId;
    }

    public void setTailboxId(String tailboxId) {
        this.tailboxId = tailboxId;
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(String lastUserId) {
        this.lastUserId = lastUserId;
    }

    public String getTailboxSubType() {
        return tailboxSubType;
    }

    public void setTailboxSubType(String tailboxSubType) {
        this.tailboxSubType = tailboxSubType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getVoucherEqualTimestamp() {
        return voucherEqualTimestamp;
    }

    public void setVoucherEqualTimestamp(String voucherEqualTimestamp) {
        this.voucherEqualTimestamp = voucherEqualTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAssignUserId() {
        return assignUserId;
    }

    public void setAssignUserId(String assignUserId) {
        this.assignUserId = assignUserId;
    }

    public String getTellerBindType() {
        return tellerBindType;
    }

    public void setTellerBindType(String tellerBindType) {
        this.tellerBindType = tellerBindType;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getSodVoucherEqual() {
        return sodVoucherEqual;
    }

    public void setSodVoucherEqual(String sodVoucherEqual) {
        this.sodVoucherEqual = sodVoucherEqual;
    }

    public String getEodVoucherEqual() {
        return eodVoucherEqual;
    }

    public void setEodVoucherEqual(String eodVoucherEqual) {
        this.eodVoucherEqual = eodVoucherEqual;
    }

    public String getTailboxStatus() {
        return tailboxStatus;
    }

    public void setTailboxStatus(String tailboxStatus) {
        this.tailboxStatus = tailboxStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMidVoucherEqual() {
        return midVoucherEqual;
    }

    public void setMidVoucherEqual(String midVoucherEqual) {
        this.midVoucherEqual = midVoucherEqual;
    }

    public String getMidCashEqual() {
        return midCashEqual;
    }

    public void setMidCashEqual(String midCashEqual) {
        this.midCashEqual = midCashEqual;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTailboxType() {
        return tailboxType;
    }

    public void setTailboxType(String tailboxType) {
        this.tailboxType = tailboxType;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSodCashEqual() {
        return sodCashEqual;
    }

    public void setSodCashEqual(String sodCashEqual) {
        this.sodCashEqual = sodCashEqual;
    }

    public String getTailboxProperty() {
        return tailboxProperty;
    }

    public void setTailboxProperty(String tailboxProperty) {
        this.tailboxProperty = tailboxProperty;
    }
}