package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbLoanFundInfo {
    /** 账户内部键值 */
    private Integer internalKey;
    /** 客户号 */
    private String clientNo;
    /** 贷款放款金额 */
    private BigDecimal loanLendersAmt;
    /** 贷款放款未使用金额 */
    private BigDecimal loanLendersNotUseAmt;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public BigDecimal getLoanLendersAmt() {
        return loanLendersAmt;
    }

    public void setLoanLendersAmt(BigDecimal loanLendersAmt) {
        this.loanLendersAmt = loanLendersAmt;
    }

    public BigDecimal getLoanLendersNotUseAmt() {
        return loanLendersNotUseAmt;
    }

    public void setLoanLendersNotUseAmt(BigDecimal loanLendersNotUseAmt) {
        this.loanLendersNotUseAmt = loanLendersNotUseAmt;
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