package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AppInd;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import jakarta.validation.constraints.NotNull;

public class FmDocumentTypeEO {
    /** 证件类型 */
    @NotNull
    private DocumentType documentType;
    /** 证件类型名称 */
    private String documentTypeDesc;
    /** 证件类型简称 */
    private String documentTypeShort;
    /** 允许新建客户标志 */
    private IndividualFlag allowNewClient;
    /** 客户内外部标识 */
    private AppInd appInd;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
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

    public IndividualFlag getAllowNewClient() {
        return allowNewClient;
    }

    public void setAllowNewClient(IndividualFlag allowNewClient) {
        this.allowNewClient = allowNewClient;
    }

    public AppInd getAppInd() {
        return appInd;
    }

    public void setAppInd(AppInd appInd) {
        this.appInd = appInd;
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
}