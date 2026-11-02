package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.TranStatus;

/**
 * ST013 检查对手客户黑名单 步骤输出。
 *
 * <p>继承 {@link StepResult}，业务输出字段来自正式 Spec「输出」表（8 个字段）：eventType、
 * tranStatus、授权标志、docClass、clientName、documentId、documentType、issCountry。</p>
 */
public class ST013OutputBO extends StepResult {

    /** 事件类型（非必填，第 3 步赋值为「CRET」）。 */
    private String eventType;

    /** 业务处理状态（非必填，赋值逻辑需求未定义，见 TBD-6）。 */
    // FIXME 业务项:ST013 检查对手客户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出字段 tranStatus（业务处理状态）的赋值时机与取值未定义，步骤描述第 1~5 步均未定义其赋值逻辑（TBD-6） - 影响:当前实现不赋值 tranStatus，输出保持为空 - 待确认:tranStatus 赋值时机与取值
    private TranStatus tranStatus;

    /** 授权标志（非必填，第 5 步为「授权」时返回「是」）。 */
    // FIXME 业务项:ST013 检查对手客户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出字段「授权标志」的 Java 字段名未以代码形式给出（Spec「输出」表以中文列示） - 影响:当前以 authFlag 作为字段名，按确认后的正式字段名同步 - 待确认:授权标志输出字段的正式 Java 字段名
    private String authFlag;

    /** 凭证种类（非必填，第 2 步取得，来源凭证类型定义表 TB_VOUCHER_DEF）。 */
    private DocClass docClass;

    /** 客户名称（非必填，第 1 步取得，来源客户副本表 FM_CLIENT_COPY）。 */
    private String clientName;

    /** 证件号码（非必填，第 1 步取得，来源客户副本表 FM_CLIENT_COPY）。 */
    private String documentId;

    /** 证件类型（非必填，第 1 步取得，来源客户副本表 FM_CLIENT_COPY）。 */
    private DocumentType documentType;

    /** 发证国家（非必填，第 1 步取得，来源客户副本表 FM_CLIENT_COPY）。 */
    private IssCountry issCountry;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

    public String getAuthFlag() {
        return authFlag;
    }

    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }

    public DocClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocClass docClass) {
        this.docClass = docClass;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
    }
}
