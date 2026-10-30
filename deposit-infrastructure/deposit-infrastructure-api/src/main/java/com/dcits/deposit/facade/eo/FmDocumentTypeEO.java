package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AppInd;
import com.dcits.deposit.enums.DocumentType;
import jakarta.validation.constraints.NotNull;

public class FmDocumentTypeEO {
    /** 允许新建客户标志 */
    private String allowNewClient;
    /** 客户内外部标识 */
    @NotNull
    private AppInd appInd;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 证件类型简称 */
    private String documentTypeShort;
    /** 证件类型名称 */
    @NotNull
    private String documentTypeDesc;
    /** 证件类型 */
    @NotNull
    private DocumentType documentType;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;

    public String getAllowNewClient() {
        return allowNewClient;
    }

    public void setAllowNewClient(String allowNewClient) {
        this.allowNewClient = allowNewClient;
    }

    public AppInd getAppInd() {
        return appInd;
    }

    public void setAppInd(AppInd appInd) {
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

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }
}