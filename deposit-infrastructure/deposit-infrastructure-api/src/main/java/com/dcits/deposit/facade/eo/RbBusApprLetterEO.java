package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBusApprLetterEO {
    /** 收入范围 */
    private String incomeScope;
    /** 摘要 */
    private String narrative;
    /** 核准账户要项内容 */
    private String apprAcctInd;
    /** 开立日期 */
    @NotNull
    private java.util.Date openDate;
    /** 资金来源 */
    private FundSource fundSource;
    /** 核准件支出范围 */
    private String expendScope;
    /** 存款账户类型 */
    private RbAcctType rbAcctType;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 核准件类型 */
    private ApprType apprType;
    /** 核准件编号 */
    @NotNull
    private String apprLetterNo;
    /** 资金用途 */
    private String fundPurpose;
    /** 核准件开立金额 */
    private BigDecimal capitalAmt;
    /** 交易机构号 */
    @NotNull
    private TranBranch tranBranch;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 到期日期 */
    @NotNull
    private java.util.Date maturityDate;
    /** 创建时间戳 */
    @NotNull
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

    public java.util.Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(java.util.Date openDate) {
        this.openDate = openDate;
    }

    public FundSource getFundSource() {
        return fundSource;
    }

    public void setFundSource(FundSource fundSource) {
        this.fundSource = fundSource;
    }

    public String getExpendScope() {
        return expendScope;
    }

    public void setExpendScope(String expendScope) {
        this.expendScope = expendScope;
    }

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public ApprType getApprType() {
        return apprType;
    }

    public void setApprType(ApprType apprType) {
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

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public java.util.Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.util.Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}