package com.dcits.deposit.task.dto;

import jakarta.validation.constraints.NotNull;

/**
 * T3S1 检查黑名单 输入 DTO。
 *
 * <p>接口接收需求「输入」表声明的 15 个输入字段，类型均为 {@code java.lang.String}
 * （Spec REQ-001）。ST036 步骤输入契约为 5 个枚举（DocClass/TranBranch/SourceType/
 * TranType/DocumentType），由场景类按 {@code byValue(String)} 转换并传递；接口层字段
 * 类型与 String↔枚举转换口径（含无对应取值时的行为）需求未定义（Spec TBD-1），必填
 * 输入缺失或为空时的行为需求未定义（Spec TBD-2），本 DTO 不定义失败分支。</p>
 */
public class T3S1InputDTO {

    /** 凭证种类（来源对公存款凭证账户关系表 RB_BUS_VOUCHER_ACCT_RELATION） */
    @NotNull
    private String docClass;

    /** 账号（来源对公存款账户主表 RB_BUS_ACCT） */
    @NotNull
    private String baseAcctNo;

    /** 账户开立行行号（来源对公存款账户主表 RB_BUS_ACCT） */
    @NotNull
    private String acctBranch;

    /** 渠道类型（来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE） */
    @NotNull
    private String sourceType;

    /** 交易代码（来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE） */
    @NotNull
    private String programId;

    /** 交易类型（来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE） */
    @NotNull
    private String tranType;

    /** 事件类型（来源名单不检查范围表 RC_LIST_NOT_CHECK_RANGE） */
    @NotNull
    private String eventType;

    /** 服务代码（来源核心服务定义表 FM_SERVICE_DEFINE） */
    @NotNull
    private String serviceCode;

    /** 接口服务类型（来源核心服务定义表 FM_SERVICE_DEFINE） */
    @NotNull
    private String messageType;

    /** 接口服务代码（来源核心服务定义表 FM_SERVICE_DEFINE） */
    @NotNull
    private String messageCode;

    /** 黑名单检查标志（来源核心服务定义表 FM_SERVICE_DEFINE） */
    @NotNull
    private String blacklistCheckFlag;

    /** 服务状态（来源核心服务定义表 FM_SERVICE_DEFINE） */
    @NotNull
    private String serviceStatus;

    /** 客户号（来源客户副本表 FM_CLIENT_COPY） */
    @NotNull
    private String clientNo;

    /** 证件号码（来源客户副本表 FM_CLIENT_COPY） */
    @NotNull
    private String documentId;

    /** 证件类型（来源客户副本表 FM_CLIENT_COPY） */
    @NotNull
    private String documentType;

    public String getDocClass() {
        return docClass;
    }

    public void setDocClass(String docClass) {
        this.docClass = docClass;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(String acctBranch) {
        this.acctBranch = acctBranch;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
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

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
