package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbLimitSumHist {
    /** 客户号 */
    private String clientNo;
    /** 限额场景编码 */
    private String limitSceneNo;
    /** 限额检查对象值 */
    private String checkObjVal;
    /** 限额控制信息 */
    private String limitCtrlInfo;
    /** 交易机构号 */
    private String tranBranch;
    /** 交易渠道编号 */
    private String tranChannel;
    /** 交易币种 */
    private String tranCcy;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 限额折算金额 */
    private BigDecimal limitConvertAmt;
    /** 交易参考号 */
    private String reference;
    /** 原交易参考号 */
    private String preReference;
    /** 启用标志 */
    private String validFlag;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 更新日期 */
    private Date updateDate;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建日期 */
    private Date createDate;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;
    /** 序号 */
    private String seqNo;

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

    public String getLimitCtrlInfo() {
        return limitCtrlInfo;
    }

    public void setLimitCtrlInfo(String limitCtrlInfo) {
        this.limitCtrlInfo = limitCtrlInfo;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getTranChannel() {
        return tranChannel;
    }

    public void setTranChannel(String tranChannel) {
        this.tranChannel = tranChannel;
    }

    public String getTranCcy() {
        return tranCcy;
    }

    public void setTranCcy(String tranCcy) {
        this.tranCcy = tranCcy;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public BigDecimal getLimitConvertAmt() {
        return limitConvertAmt;
    }

    public void setLimitConvertAmt(BigDecimal limitConvertAmt) {
        this.limitConvertAmt = limitConvertAmt;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPreReference() {
        return preReference;
    }

    public void setPreReference(String preReference) {
        this.preReference = preReference;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
}