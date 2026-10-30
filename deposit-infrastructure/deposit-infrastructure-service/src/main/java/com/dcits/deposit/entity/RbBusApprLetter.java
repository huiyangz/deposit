package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbBusApprLetter {
    /** 收入范围 */
    private String incomeScope;
    /** 摘要 */
    private String narrative;
    /** 核准账户要项内容 */
    private String apprAcctInd;
    /** 开立日期 */
    private Date openDate;
    /** 资金来源 */
    private String fundSource;
    /** 核准件支出范围 */
    private String expendScope;
    /** 存款账户类型 */
    private String rbAcctType;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 核准件类型 */
    private String apprType;
    /** 核准件编号 */
    private String apprLetterNo;
    /** 资金用途 */
    private String fundPurpose;
    /** 核准件开立金额 */
    private BigDecimal capitalAmt;
    /** 交易机构号 */
    private String tranBranch;
    /** 客户号 */
    private String clientNo;
    /** 到期日期 */
    private Date maturityDate;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getIncomeScope() {
        return incomeScope;
    }

    public void setIncomeScope(String incomeScope) {
        this.incomeScope = incomeScope;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getApprAcctInd() {
        return apprAcctInd;
    }

    public void setApprAcctInd(String apprAcctInd) {
        this.apprAcctInd = apprAcctInd;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    public String getExpendScope() {
        return expendScope;
    }

    public void setExpendScope(String expendScope) {
        this.expendScope = expendScope;
    }

    public String getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(String rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getApprType() {
        return apprType;
    }

    public void setApprType(String apprType) {
        this.apprType = apprType;
    }

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public String getFundPurpose() {
        return fundPurpose;
    }

    public void setFundPurpose(String fundPurpose) {
        this.fundPurpose = fundPurpose;
    }

    public BigDecimal getCapitalAmt() {
        return capitalAmt;
    }

    public void setCapitalAmt(BigDecimal capitalAmt) {
        this.capitalAmt = capitalAmt;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}