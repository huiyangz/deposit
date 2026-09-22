package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbApprLetterSub {
    /** 核准件编号 */
    private String apprLetterNo;
    /** 核准件主子标志 */
    private String mainSubInd;
    /** 币种 */
    private String ccy;
    /** 核准件额度 */
    private BigDecimal apprLimitAmt;
    /** 贷方总金额 */
    private BigDecimal crTotalAmt;
    /** 借方交易总金额 */
    private BigDecimal drTotalAmt;
    /** 浮动金额 */
    private BigDecimal graceAmt;
    /** 浮动比例 */
    private BigDecimal graceProportion;
    /** 客户号 */
    private String clientNo;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 备注 */
    private String remark;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public String getMainSubInd() {
        return mainSubInd;
    }

    public void setMainSubInd(String mainSubInd) {
        this.mainSubInd = mainSubInd;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public BigDecimal getApprLimitAmt() {
        return apprLimitAmt;
    }

    public void setApprLimitAmt(BigDecimal apprLimitAmt) {
        this.apprLimitAmt = apprLimitAmt;
    }

    public BigDecimal getCrTotalAmt() {
        return crTotalAmt;
    }

    public void setCrTotalAmt(BigDecimal crTotalAmt) {
        this.crTotalAmt = crTotalAmt;
    }

    public BigDecimal getDrTotalAmt() {
        return drTotalAmt;
    }

    public void setDrTotalAmt(BigDecimal drTotalAmt) {
        this.drTotalAmt = drTotalAmt;
    }

    public BigDecimal getGraceAmt() {
        return graceAmt;
    }

    public void setGraceAmt(BigDecimal graceAmt) {
        this.graceAmt = graceAmt;
    }

    public BigDecimal getGraceProportion() {
        return graceProportion;
    }

    public void setGraceProportion(BigDecimal graceProportion) {
        this.graceProportion = graceProportion;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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