package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ContactClass;
import com.dcits.deposit.enums.ContactType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LinkmanType;
import jakarta.validation.constraints.NotNull;

public class RbContactListEO {
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 证件号码 */
    private String documentId;
    /** 证件类型 */
    private DocumentType documentType;
    /** 账户联系人类型 */
    @NotNull
    private LinkmanType linkmanType;
    /** 账户联系人名称 */
    private String linkmanName;
    /** 联系人电话1 */
    @NotNull
    private String phoneNo1;
    /** 联系人电话2 */
    private String phoneNo2;
    /** 联系人状态 */
    private String contactStatus;
    /** 联系人分类 */
    private ContactClass contactClass;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 最后修改柜员号 */
    private String lastChangeUserId;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 联系人类型描述 */
    private String linkmanDesc;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 查证人标志 */
    private IndividualFlag checkCertificateFlag;
    /** 查证人顺序号 */
    private String checkCertificateOrder;
    /** 联系类型 */
    private ContactType contactType;
    /** 创建时间戳 */
    private String createTimestamp;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public LinkmanType getLinkmanType() {
        return linkmanType;
    }

    public void setLinkmanType(LinkmanType linkmanType) {
        this.linkmanType = linkmanType;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getPhoneNo1() {
        return phoneNo1;
    }

    public void setPhoneNo1(String phoneNo1) {
        this.phoneNo1 = phoneNo1;
    }

    public String getPhoneNo2() {
        return phoneNo2;
    }

    public void setPhoneNo2(String phoneNo2) {
        this.phoneNo2 = phoneNo2;
    }

    public String getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(String contactStatus) {
        this.contactStatus = contactStatus;
    }

    public ContactClass getContactClass() {
        return contactClass;
    }

    public void setContactClass(ContactClass contactClass) {
        this.contactClass = contactClass;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getLastChangeUserId() {
        return lastChangeUserId;
    }

    public void setLastChangeUserId(String lastChangeUserId) {
        this.lastChangeUserId = lastChangeUserId;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getLinkmanDesc() {
        return linkmanDesc;
    }

    public void setLinkmanDesc(String linkmanDesc) {
        this.linkmanDesc = linkmanDesc;
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

    public IndividualFlag getCheckCertificateFlag() {
        return checkCertificateFlag;
    }

    public void setCheckCertificateFlag(IndividualFlag checkCertificateFlag) {
        this.checkCertificateFlag = checkCertificateFlag;
    }

    public String getCheckCertificateOrder() {
        return checkCertificateOrder;
    }

    public void setCheckCertificateOrder(String checkCertificateOrder) {
        this.checkCertificateOrder = checkCertificateOrder;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}