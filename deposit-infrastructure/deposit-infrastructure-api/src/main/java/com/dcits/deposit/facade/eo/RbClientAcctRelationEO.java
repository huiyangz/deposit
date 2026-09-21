package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.RelStatus;
import jakarta.validation.constraints.NotNull;

public class RbClientAcctRelationEO {
    /** 账号/卡号 */
    @NotNull
    private String baseAcctNo;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 账户序号 */
    @NotNull
    private String acctSeqNo;
    /** 账号内部键 */
    private Integer acctInternalKey;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 产品类型 */
    private String prodType;
    /** 默认账户标志 */
    private String defaultAcctFlag;
    /** 关联状态 */
    private RelStatus relStatus;
    /** 客户账户类型 */
    private String clientAcctType;
    /** 创建日期 */
    private java.util.Date createDate;
    /** 更新日期 */
    private java.util.Date updateDate;
    /** 录入柜员号 */
    private String createUserId;
    /** 修改柜员号 */
    private String updateUserId;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 法人 */
    private Company company;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public Integer getAcctInternalKey() {
        return acctInternalKey;
    }

    public void setAcctInternalKey(Integer acctInternalKey) {
        this.acctInternalKey = acctInternalKey;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getDefaultAcctFlag() {
        return defaultAcctFlag;
    }

    public void setDefaultAcctFlag(String defaultAcctFlag) {
        this.defaultAcctFlag = defaultAcctFlag;
    }

    public RelStatus getRelStatus() {
        return relStatus;
    }

    public void setRelStatus(RelStatus relStatus) {
        this.relStatus = relStatus;
    }

    public String getClientAcctType() {
        return clientAcctType;
    }

    public void setClientAcctType(String clientAcctType) {
        this.clientAcctType = clientAcctType;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}