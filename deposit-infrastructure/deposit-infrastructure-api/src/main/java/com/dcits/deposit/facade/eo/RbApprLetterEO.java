package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctType;
import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.FundSource;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbApprLetterEO {
    /** 核准件编号 */
    @NotNull
    private String apprLetterNo;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 开立日期 */
    private java.util.Date openDate;
    /** 到期日期 */
    private java.util.Date maturityDate;
    /** 核准件类型 */
    private ApprType apprType;
    /** 资金用途 */
    private String fundPurpose;
    /** 资金来源 */
    private FundSource fundSource;
    /** 核准件开立金额 */
    private BigDecimal capitalAmt;
    /** 核准账户要项内容 */
    private String apprAcctInd;
    /** 账户类型 */
    private AcctType acctType;
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
    private Company company;
    /** 备注 */
    private String remark;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public java.util.Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(java.util.Date openDate) {
        this.openDate = openDate;
    }

    public java.util.Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.util.Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public ApprType getApprType() {
        return apprType;
    }

    public void setApprType(ApprType apprType) {
        this.apprType = apprType;
    }

    public String getFundPurpose() {
        return fundPurpose;
    }

    public void setFundPurpose(String fundPurpose) {
        this.fundPurpose = fundPurpose;
    }

    public FundSource getFundSource() {
        return fundSource;
    }

    public void setFundSource(FundSource fundSource) {
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

    public AcctType getAcctType() {
        return acctType;
    }

    public void setAcctType(AcctType acctType) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}