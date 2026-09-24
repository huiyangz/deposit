package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AppointmentStatus;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;

public class RbBusAcctAppointmentEO {
    /** 产品编号 */
    private String prodNo;
    /** 账号 */
    private String baseAcctNo;
    /** 发证国家 */
    private IssCountry issCountry;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 预约编号 */
    @NotNull
    private String orderNo;
    /** 对公账号预约状态 */
    private AppointmentStatus appointmentStatus;
    /** 证件号码 */
    private String documentId;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 客户细分类型 */
    private CategoryType categoryType;
    /** 存款账户类型 */
    private RbAcctType rbAcctType;
    /** 客户类型 */
    private ClientType clientType;
    /** 交易机构号 */
    private TranBranch tranBranch;
    /** 证件类型 */
    private DocumentType documentType;
    /** 客户名称 */
    private String clientName;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 预约到期日期 */
    private java.util.Date applyDueDate;

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public java.util.Date getApplyDueDate() {
        return applyDueDate;
    }

    public void setApplyDueDate(java.util.Date applyDueDate) {
        this.applyDueDate = applyDueDate;
    }
}