package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbTaeAccountCheckSum {
    /** 场次 */
    private String sessionId;
    /** 贷方总数量 */
    private Integer cretTotalNum;
    /** 贷方总金额 */
    private BigDecimal cretTotalAmt;
    /** 借方总数量 */
    private Integer debtTotalNum;
    /** 借方总金额 */
    private BigDecimal debtTotalAmt;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 法人 */
    private String company;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getCretTotalNum() {
        return cretTotalNum;
    }

    public void setCretTotalNum(Integer cretTotalNum) {
        this.cretTotalNum = cretTotalNum;
    }

    public BigDecimal getCretTotalAmt() {
        return cretTotalAmt;
    }

    public void setCretTotalAmt(BigDecimal cretTotalAmt) {
        this.cretTotalAmt = cretTotalAmt;
    }

    public Integer getDebtTotalNum() {
        return debtTotalNum;
    }

    public void setDebtTotalNum(Integer debtTotalNum) {
        this.debtTotalNum = debtTotalNum;
    }

    public BigDecimal getDebtTotalAmt() {
        return debtTotalAmt;
    }

    public void setDebtTotalAmt(BigDecimal debtTotalAmt) {
        this.debtTotalAmt = debtTotalAmt;
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