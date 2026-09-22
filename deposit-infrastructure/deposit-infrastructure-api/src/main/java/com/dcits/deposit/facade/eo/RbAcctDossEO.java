package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DossOperateType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbAcctDossEO {
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户状态 */
    private AcctStatus acctStatus;
    /** 账户名称 */
    private String acctName;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 转久悬操作类型 */
    private DossOperateType dossOperateType;
    /** 金额类型 */
    private AmtType amtType;
    /** 余额 */
    private BigDecimal balance;
    /** 转不动户日期 */
    private java.util.Date dormantDate;
    /** 转久悬日期 */
    private java.util.Date dossDate;
    /** 出库日期 */
    private java.util.Date outDate;
    /** 利息 */
    private BigDecimal intAmt;
    /** 本息合计金额 */
    private BigDecimal porIntTot;
    /** 账户利息税金额 */
    private BigDecimal taxSc;
    /** 备注 */
    private String remark;
    /** 交易柜员号 */
    private String userId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
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

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public DossOperateType getDossOperateType() {
        return dossOperateType;
    }

    public void setDossOperateType(DossOperateType dossOperateType) {
        this.dossOperateType = dossOperateType;
    }

    public AmtType getAmtType() {
        return amtType;
    }

    public void setAmtType(AmtType amtType) {
        this.amtType = amtType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public java.util.Date getDormantDate() {
        return dormantDate;
    }

    public void setDormantDate(java.util.Date dormantDate) {
        this.dormantDate = dormantDate;
    }

    public java.util.Date getDossDate() {
        return dossDate;
    }

    public void setDossDate(java.util.Date dossDate) {
        this.dossDate = dossDate;
    }

    public java.util.Date getOutDate() {
        return outDate;
    }

    public void setOutDate(java.util.Date outDate) {
        this.outDate = outDate;
    }

    public BigDecimal getIntAmt() {
        return intAmt;
    }

    public void setIntAmt(BigDecimal intAmt) {
        this.intAmt = intAmt;
    }

    public BigDecimal getPorIntTot() {
        return porIntTot;
    }

    public void setPorIntTot(BigDecimal porIntTot) {
        this.porIntTot = porIntTot;
    }

    public BigDecimal getTaxSc() {
        return taxSc;
    }

    public void setTaxSc(BigDecimal taxSc) {
        this.taxSc = taxSc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
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
}