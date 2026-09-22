package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TbVoucherInfo {
    /** 凭证主键 */
    private Integer voucherId;
    /** 归属机构号 */
    private String branch;
    /** 尾箱编号 */
    private String tailboxId;
    /** 凭证类型 */
    private String docType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证起始号码 */
    private String voucherStartNo;
    /** 凭证终止号码 */
    private String voucherEndNo;
    /** 起始号码数值 */
    private Integer startNoInt;
    /** 终止号码数值 */
    private Integer endNoInt;
    /** 凭证合计数 */
    private Integer voucherSum;
    /** 凭证状态 */
    private String voucherStatus;
    /** 上日期末凭证总数 */
    private Integer eopdVoucherSum;
    /** 上日期初凭证总数 */
    private Integer sopdVoucherSum;
    /** 币种 */
    private String ccy;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 备注 */
    private String remark;
    /** 上一柜员号 */
    private String lastUserId;
    /** 更新日期 */
    private Date updateDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getTailboxId() {
        return tailboxId;
    }

    public void setTailboxId(String tailboxId) {
        this.tailboxId = tailboxId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getVoucherStartNo() {
        return voucherStartNo;
    }

    public void setVoucherStartNo(String voucherStartNo) {
        this.voucherStartNo = voucherStartNo;
    }

    public String getVoucherEndNo() {
        return voucherEndNo;
    }

    public void setVoucherEndNo(String voucherEndNo) {
        this.voucherEndNo = voucherEndNo;
    }

    public Integer getStartNoInt() {
        return startNoInt;
    }

    public void setStartNoInt(Integer startNoInt) {
        this.startNoInt = startNoInt;
    }

    public Integer getEndNoInt() {
        return endNoInt;
    }

    public void setEndNoInt(Integer endNoInt) {
        this.endNoInt = endNoInt;
    }

    public Integer getVoucherSum() {
        return voucherSum;
    }

    public void setVoucherSum(Integer voucherSum) {
        this.voucherSum = voucherSum;
    }

    public String getVoucherStatus() {
        return voucherStatus;
    }

    public void setVoucherStatus(String voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    public Integer getEopdVoucherSum() {
        return eopdVoucherSum;
    }

    public void setEopdVoucherSum(Integer eopdVoucherSum) {
        this.eopdVoucherSum = eopdVoucherSum;
    }

    public Integer getSopdVoucherSum() {
        return sopdVoucherSum;
    }

    public void setSopdVoucherSum(Integer sopdVoucherSum) {
        this.sopdVoucherSum = sopdVoucherSum;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLastUserId() {
        return lastUserId;
    }

    public void setLastUserId(String lastUserId) {
        this.lastUserId = lastUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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