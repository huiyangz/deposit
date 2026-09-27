package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.TailboxProperty;
import com.dcits.deposit.enums.TailboxStatus;
import com.dcits.deposit.enums.TailboxSubType;
import com.dcits.deposit.enums.TailboxType;
import com.dcits.deposit.enums.TellerBindType;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;

public class TbTailboxEO {
    /** 现金碰库时间戳 */
    @NotNull
    private String cashEqualTimestamp;
    /** 日终现金碰库标志 */
    @NotNull
    private String eodCashEqual;
    /** 尾箱编号 */
    @NotNull
    private String tailboxId;
    /** 上一柜员号 */
    @NotNull
    private String lastUserId;
    /** 尾箱细类 */
    @NotNull
    private TailboxSubType tailboxSubType;
    /** 归属机构号 */
    @NotNull
    private TranBranch branch;
    /** 凭证碰库时间戳 */
    @NotNull
    private String voucherEqualTimestamp;
    /** 交易时间戳 */
    @NotNull
    private String tranTimestamp;
    /** 创建日期 */
    @NotNull
    private java.util.Date createDate;
    /** 法人 */
    @NotNull
    private String company;
    /** 尾箱分配柜员号 */
    @NotNull
    private String assignUserId;
    /** 尾箱绑定关系类型 */
    @NotNull
    private TellerBindType tellerBindType;
    /** 最后修改日期 */
    @NotNull
    private java.util.Date lastChangeDate;
    /** 日始凭证碰库标志 */
    @NotNull
    private String sodVoucherEqual;
    /** 日终凭证碰库标志 */
    @NotNull
    private String eodVoucherEqual;
    /** 尾箱状态 */
    @NotNull
    private TailboxStatus tailboxStatus;
    /** 交易柜员号 */
    @NotNull
    private String userId;
    /** 日间凭证碰库标志 */
    @NotNull
    private String midVoucherEqual;
    /** 日间现金碰库标志 */
    @NotNull
    private String midCashEqual;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 尾箱类型 */
    @NotNull
    private TailboxType tailboxType;
    /** 更新日期 */
    @NotNull
    private java.util.Date updateDate;
    /** 日始现金碰库标志 */
    @NotNull
    private String sodCashEqual;
    /** 尾箱属性 */
    @NotNull
    private TailboxProperty tailboxProperty;

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

    public TailboxSubType getTailboxSubType() {
        return tailboxSubType;
    }

    public void setTailboxSubType(TailboxSubType tailboxSubType) {
        this.tailboxSubType = tailboxSubType;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
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

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
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

    public TellerBindType getTellerBindType() {
        return tellerBindType;
    }

    public void setTellerBindType(TellerBindType tellerBindType) {
        this.tellerBindType = tellerBindType;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
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

    public TailboxStatus getTailboxStatus() {
        return tailboxStatus;
    }

    public void setTailboxStatus(TailboxStatus tailboxStatus) {
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

    public TailboxType getTailboxType() {
        return tailboxType;
    }

    public void setTailboxType(TailboxType tailboxType) {
        this.tailboxType = tailboxType;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSodCashEqual() {
        return sodCashEqual;
    }

    public void setSodCashEqual(String sodCashEqual) {
        this.sodCashEqual = sodCashEqual;
    }

    public TailboxProperty getTailboxProperty() {
        return tailboxProperty;
    }

    public void setTailboxProperty(TailboxProperty tailboxProperty) {
        this.tailboxProperty = tailboxProperty;
    }
}