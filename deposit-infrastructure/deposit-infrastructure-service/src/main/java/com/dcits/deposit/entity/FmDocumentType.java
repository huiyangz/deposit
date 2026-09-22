package com.dcits.deposit.entity;

public class FmDocumentType {
    /** 证件类型 */
    private String documentType;
    /** 证件类型名称 */
    private String documentTypeDesc;
    /** 证件类型简称 */
    private String documentTypeShort;
    /** 允许新建客户标志 */
    private String allowNewClient;
    /** 客户内外部标识 */
    private String appInd;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentTypeDesc() {
        return documentTypeDesc;
    }

    public void setDocumentTypeDesc(String documentTypeDesc) {
        this.documentTypeDesc = documentTypeDesc;
    }

    public String getDocumentTypeShort() {
        return documentTypeShort;
    }

    public void setDocumentTypeShort(String documentTypeShort) {
        this.documentTypeShort = documentTypeShort;
    }

    public String getAllowNewClient() {
        return allowNewClient;
    }

    public void setAllowNewClient(String allowNewClient) {
        this.allowNewClient = allowNewClient;
    }

    public String getAppInd() {
        return appInd;
    }

    public void setAppInd(String appInd) {
        this.appInd = appInd;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}