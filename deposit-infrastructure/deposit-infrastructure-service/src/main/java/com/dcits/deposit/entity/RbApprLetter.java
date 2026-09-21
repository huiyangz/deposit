package com.dcits.deposit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RbApprLetter {
    /** 核准件编号 */
    private String apprLetterNo;
    /** 交易机构号 */
    private String tranBranch;
    /** 客户号 */
    private String clientNo;
    /** 开立日期 */
    private Date openDate;
    /** 到期日期 */
    private Date maturityDate;
    /** 核准件类型 */
    private String apprType;
    /** 资金用途 */
    private String fundPurpose;
    /** 资金来源 */
    private String fundSource;
    /** 核准件开立金额 */
    private BigDecimal capitalAmt;
    /** 核准账户要项内容 */
    private String apprAcctInd;
    /** 账户类型 */
    private String acctType;
    /** 核准件支出范围 */
    private String expendScope;
    /** 收入范围 */
    private String incomeScope;
    /** 摘要 */
    private String narrative;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
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

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getApprType() {
        return apprType;
    }

    public void setApprType(String apprType) {
        this.apprType = apprType;
    }

    public String getFundPurpose() {
        return fundPurpose;
    }

    public void setFundPurpose(String fundPurpose) {
        this.fundPurpose = fundPurpose;
    }

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    public BigDecimal getCapitalAmt() {
        return capitalAmt;
    }

    public void setCapitalAmt(BigDecimal capitalAmt) {
        this.capitalAmt = capitalAmt;
    }

    public String getApprAcctInd() {
        return apprAcctInd;
    }

    public void setApprAcctInd(String apprAcctInd) {
        this.apprAcctInd = apprAcctInd;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getExpendScope() {
        return expendScope;
    }

    public void setExpendScope(String expendScope) {
        this.expendScope = expendScope;
    }

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

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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