package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbLimitSumInfoEO {
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 限额场景编码 */
    @NotNull
    private String limitSceneNo;
    /** 限额检查对象值 */
    @NotNull
    private String checkObjVal;
    /** 限额累计金额 */
    private BigDecimal limitSumAmt;
    /** 限额累计描述 */
    private String limitSumContent;
    /** 限额累计笔数 */
    private Integer limitSumNum;
    /** 交易币种 */
    private AcctCcy tranCcy;
    /** 交易参考号 */
    private String reference;
    /** 原交易参考号 */
    private String preReference;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 失效日期 */
    private java.util.Date expireDate;
    /** 法人 */
    private Company company;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 更新日期 */
    private java.util.Date updateDate;
    /** 创建日期 */
    private java.util.Date createDate;

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

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }

    public String getLimitSumContent() {
        return limitSumContent;
    }

    public void setLimitSumContent(String limitSumContent) {
        this.limitSumContent = limitSumContent;
    }

    public Integer getLimitSumNum() {
        return limitSumNum;
    }

    public void setLimitSumNum(Integer limitSumNum) {
        this.limitSumNum = limitSumNum;
    }

    public AcctCcy getTranCcy() {
        return tranCcy;
    }

    public void setTranCcy(AcctCcy tranCcy) {
        this.tranCcy = tranCcy;
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

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public java.util.Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(java.util.Date expireDate) {
        this.expireDate = expireDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }
}