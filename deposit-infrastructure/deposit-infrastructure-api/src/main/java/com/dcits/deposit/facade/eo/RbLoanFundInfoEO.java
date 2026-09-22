package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbLoanFundInfoEO {
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 贷款放款金额 */
    private BigDecimal loanLendersAmt;
    /** 贷款放款未使用金额 */
    private BigDecimal loanLendersNotUseAmt;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}