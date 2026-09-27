package com.dcits.deposit.entity;

public class FmDocumentType {
    /** 允许新建客户标志 */
    private String allowNewClient;
    /** 客户内外部标识 */
    private String appInd;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 证件类型简称 */
    private String documentTypeShort;
    /** 证件类型名称 */
    private String documentTypeDesc;
    /** 证件类型 */
    private String documentType;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;

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

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getDocumentTypeShort() {
        return documentTypeShort;
    }

    public void setDocumentTypeShort(String documentTypeShort) {
        this.documentTypeShort = documentTypeShort;
    }

    public String getDocumentTypeDesc() {
        return documentTypeDesc;
    }

    public void setDocumentTypeDesc(String documentTypeDesc) {
        this.documentTypeDesc = documentTypeDesc;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }
}