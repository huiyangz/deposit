package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranType;

/**
 * ST100 检查黑名单 输入 BO。
 *
 * <p>字段与正式 Spec（{@code docs/specs/ST100.md}「### 输入」表）一一对应；「来源实体」列只标明
 * 该字段在本步骤内引用的实体，不代表上游赋值来源。标「非必填」的字段允许无值。</p>
 */
public class ST100InputBO {

    /** 凭证种类（非必填）：子步骤 12 中与 [名单限制规则信息] 的 $介质$ 比较的上送值。 */
    private DocClass docClass;

    /** 账号（非必填）：子步骤 3 查询【名单信息表】的条件之一；子步骤 13 查询【账户信息】的条件。 */
    private String baseAcctNo;

    /** 账户开立行行号（必填）：子步骤 13 取回结果所对应的字段；子步骤 14 中与 {交易机构} 及其下级机构比较的值。 */
    private TranBranch acctBranch;

    /** 渠道类型（必填）：子步骤 9、10 的查询条件。 */
    private SourceType sourceType;

    /** 交易代码（必填）：子步骤 9、10 的查询条件。 */
    private String programId;

    /** 交易类型（必填）：子步骤 9、10 的查询条件。 */
    private TranType tranType;

    /** 事件类型（必填）：子步骤 9 的查询条件与查询结果同名列（口径见 Spec 放行事项 3）。 */
    private String eventType;

    /** 服务代码（必填）：子步骤 9、10 的查询条件。 */
    private String serviceCode;

    /** 接口服务类型（必填）：子步骤 1 查询【核心服务定义表】的条件；子步骤 9、10 的查询条件。 */
    private String messageType;

    /** 接口服务代码（必填）：子步骤 1 查询【核心服务定义表】的条件；子步骤 9、10 的查询条件。 */
    private String messageCode;

    /** 黑名单检查标志（必填）：子步骤 1 取回的 $黑名单检查标志$；子步骤 2 的判定值。 */
    private String blacklistCheckFlag;

    /** 服务状态（必填）：子步骤 1 取回的 $服务状态$；子步骤 2 的判定值。 */
    private String serviceStatus;

    /** 客户号（非必填）：子步骤 3 查询【名单信息表】的条件之一。 */
    private String clientNo;

    /** 证件号码（必填）：子步骤 3 中 {身份证信息} 所对应的值。 */
    private String documentId;

    /** 证件类型（必填）：与 documentId 同属子步骤 3 的证件条件（documentId 的证件类型）。 */
    private DocumentType documentType;

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public TranBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(TranBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getBlacklistCheckFlag() {
        return blacklistCheckFlag;
    }

    public void setBlacklistCheckFlag(String blacklistCheckFlag) {
        this.blacklistCheckFlag = blacklistCheckFlag;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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
}
