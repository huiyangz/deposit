package com.dcits.deposit.entity;

import java.util.Date;

public class RbClientAcctRelation {
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 客户号 */
    private String clientNo;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账号内部键 */
    private Integer acctInternalKey;
    /** 账户币种 */
    private String acctCcy;
    /** 产品类型 */
    private String prodType;
    /** 默认账户标志 */
    private String defaultAcctFlag;
    /** 关联状态 */
    private String relStatus;
    /** 客户账户类型 */
    private String clientAcctType;
    /** 创建日期 */
    private Date createDate;
    /** 更新日期 */
    private Date updateDate;
    /** 录入柜员号 */
    private String createUserId;
    /** 修改柜员号 */
    private String updateUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 法人 */
    private String company;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public Integer getAcctInternalKey() {
        return acctInternalKey;
    }

    public void setAcctInternalKey(Integer acctInternalKey) {
        this.acctInternalKey = acctInternalKey;
    }

    public String getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(String acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getDefaultAcctFlag() {
        return defaultAcctFlag;
    }

    public void setDefaultAcctFlag(String defaultAcctFlag) {
        this.defaultAcctFlag = defaultAcctFlag;
    }

    public String getRelStatus() {
        return relStatus;
    }

    public void setRelStatus(String relStatus) {
        this.relStatus = relStatus;
    }

    public String getClientAcctType() {
        return clientAcctType;
    }

    public void setClientAcctType(String clientAcctType) {
        this.clientAcctType = clientAcctType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}