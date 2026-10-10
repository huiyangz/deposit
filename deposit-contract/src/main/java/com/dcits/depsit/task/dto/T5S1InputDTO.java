package com.dcits.depsit.task.dto;

import jakarta.validation.constraints.NotNull;

/**
 * T5S1 检查黑名单 —— 交易对外输入 DTO。
 *
 * <p>按 Spec「### 输入（交易对外）」表，本交易对外业务输入为 15 个字段，全部标「必填」，
 * 由调用方上送，并按字段名一一传入唯一被调步骤 {@code ST100}「检查黑名单」的同名入参
 * （{@code ST100InputBO}），不做变形、不补默认值（REQ-001、REQ-002）。</p>
 *
 * <ul>
 *   <li>{@code docClass}：凭证种类，经枚举 {@code com.dcits.depsit.enums.DocClass} 承载；</li>
 *   <li>{@code baseAcctNo}：账号；</li>
 *   <li>{@code acctBranch}：账户开立行行号，经枚举
 *       {@code com.dcits.depsit.enums.TranBranch} 承载；</li>
 *   <li>{@code sourceType}：渠道类型，经枚举
 *       {@code com.dcits.depsit.enums.SourceType} 承载；</li>
 *   <li>{@code programId}：交易代码；</li>
 *   <li>{@code tranType}：交易类型，经枚举 {@code com.dcits.depsit.enums.TranType} 承载；</li>
 *   <li>{@code eventType}：事件类型；</li>
 *   <li>{@code serviceCode}：服务代码；</li>
 *   <li>{@code messageType}：接口服务类型；</li>
 *   <li>{@code messageCode}：接口服务代码；</li>
 *   <li>{@code blacklistCheckFlag}：黑名单检查标志；</li>
 *   <li>{@code serviceStatus}：服务状态；</li>
 *   <li>{@code clientNo}：客户号；</li>
 *   <li>{@code documentId}：证件号码；</li>
 *   <li>{@code documentType}：证件类型，经枚举
 *       {@code com.dcits.depsit.enums.DocumentType} 承载。</li>
 * </ul>
 *
 * <p>上述 5 个枚举类字段在对外 DTO 中以 {@link String} 承载业务码值（工程约定），MUST NOT 直接
 * 暴露 Java 枚举类型；调用前按各枚举已声明的 {@code byValue(String)} 以码值转换，MUST NOT 以
 * {@code toString()} 或枚举常量名（如 {@code "VALUE_351155"}）代替业务编码（REQ-003）。</p>
 *
 * <p>本类 MUST NOT 要求调用方上送 Spec「### 输入（交易对外）」表之外的字段（REQ-001-S02）；
 * 响应头 {@code com.dcits.common.task.RespHeader} 的字段属技术报文头，不计入对外业务输入。</p>
 *
 * <p>字段标为「必填」，但需求未定义取值缺失、空字符串或格式非法时的校验与失败行为
 * （Spec「验收范围与明确不覆盖的事项」第 1 项），故此处仅按已确认的必填性标注 {@link NotNull}，
 * 不追加会强化合法值范围的约束，也不生成默认值。</p>
 */
public class T5S1InputDTO {

    /** 凭证种类（DocClass 码值字符串） */
    @NotNull
    private String docClass;

    /** 账号 */
    @NotNull
    private String baseAcctNo;

    /** 账户开立行行号（TranBranch 码值字符串） */
    @NotNull
    private String acctBranch;

    /** 渠道类型（SourceType 码值字符串） */
    @NotNull
    private String sourceType;

    /** 交易代码 */
    @NotNull
    private String programId;

    /** 交易类型（TranType 码值字符串） */
    @NotNull
    private String tranType;

    /** 事件类型 */
    @NotNull
    private String eventType;

    /** 服务代码 */
    @NotNull
    private String serviceCode;

    /** 接口服务类型 */
    @NotNull
    private String messageType;

    /** 接口服务代码 */
    @NotNull
    private String messageCode;

    /** 黑名单检查标志 */
    @NotNull
    private String blacklistCheckFlag;

    /** 服务状态 */
    @NotNull
    private String serviceStatus;

    /** 客户号 */
    @NotNull
    private String clientNo;

    /** 证件号码 */
    @NotNull
    private String documentId;

    /** 证件类型（DocumentType 码值字符串） */
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
