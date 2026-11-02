package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;

/**
 * ST036 检查黑名单 步骤输入。
 *
 * <p>字段来自正式 Spec「输入」表（15 个字段）：docClass、baseAcctNo、acctBranch、
 * sourceType、programId、tranType、eventType、serviceCode、messageType、messageCode、
 * blacklistCheckFlag、serviceStatus、clientNo、documentId、documentType。</p>
 */
public class ST036InputBO {

    /** 凭证种类（非必填，来源对公存款凭证账户关系表 RB_BUS_VOUCHER_ACCT_RELATION）。 */
    private DocClass docClass;

    /** 账号（非必填，来源对公存款账户主表 RB_BUS_ACCT）。 */
    private String baseAcctNo;

    /** 账户开立行行号（必填，来源对公存款账户主表 RB_BUS_ACCT）。 */
    private TranBranch acctBranch;

    /** 渠道类型（必填，来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE）。 */
    private SourceType sourceType;

    /** 交易代码（必填，来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE；{交易码}口径见 TBD-10）。 */
    private String programId;

    /** 交易类型（必填，来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE）。 */
    private TranType tranType;

    /** 事件类型（必填，来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE）。 */
    private String eventType;

    /** 服务代码（必填，来源核心服务定义表 FM_SERVICE_DEFINE）。 */
    private String serviceCode;

    /** 接口服务类型（必填，来源核心服务定义表 FM_SERVICE_DEFINE）。 */
    private String messageType;

    /** 接口服务代码（必填，来源核心服务定义表 FM_SERVICE_DEFINE）。 */
    private String messageCode;

    /** 黑名单检查标志（必填，来源核心服务定义表 FM_SERVICE_DEFINE；物理编码见 TBD-9）。 */
    private String blacklistCheckFlag;

    /** 服务状态（必填，来源核心服务定义表 FM_SERVICE_DEFINE；物理编码见 TBD-9）。 */
    private String serviceStatus;

    /** 客户号（非必填，来源客户副本表 FM_CLIENT_COPY）。 */
    private String clientNo;

    /** 证件号码（必填，来源客户副本表 FM_CLIENT_COPY）。 */
    private String documentId;

    /** 证件类型（必填，来源客户副本表 FM_CLIENT_COPY）。 */
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
