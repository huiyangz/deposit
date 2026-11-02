package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;

/**
 * ST009 检查支取客户黑名单 步骤输出。
 *
 * <p>字段来自正式 Spec「输出」表（7 个字段）：eventType、授权标志、docClass、
 * documentId、issCountry、documentType、clientName。「授权标志」输出字段工程属性
 * 命名未给出（Spec 待确认事项 TBD-4），本类采用 authorizationFlag，属性名待业务确认。</p>
 */
public class ST009OutputBO extends StepResult {

    /** 事件类型（非必填）。 */
    private String eventType;

    /** 授权标志（非必填；属性命名见 TBD-4）。 */
    private String authorizationFlag;

    /** 凭证种类（非必填，来源凭证类型定义表 TB_VOUCHER_DEF）。 */
    private DocClass docClass;

    /** 证件号码（非必填，来源客户副本表 FM_CLIENT_COPY）。 */
    private String documentId;

    /** 发证国家（非必填，来源客户副本表 FM_CLIENT_COPY）。 */
    private IssCountry issCountry;

    /** 证件类型（非必填，来源客户副本表 FM_CLIENT_COPY）。 */
    private DocumentType documentType;

    /** 客户名称（非必填，来源客户副本表 FM_CLIENT_COPY）。 */
    private String clientName;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getAuthorizationFlag() {
        return authorizationFlag;
    }

    public void setAuthorizationFlag(String authorizationFlag) {
        this.authorizationFlag = authorizationFlag;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
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
}
