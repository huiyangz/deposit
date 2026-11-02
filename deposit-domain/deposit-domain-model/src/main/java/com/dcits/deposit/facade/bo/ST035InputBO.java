package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;

/**
 * ST035 检查支取账户黑名单 步骤输入。
 *
 * <p>字段来自正式 Spec「输入」表（9 个字段）：clientNo、docType、baseAcctNo、
 * tranBranch、tranType、serviceCode、messageCode、messageType、sourceType。</p>
 */
public class ST035InputBO {

    /** 客户号（必填） */
    private String clientNo;

    /** 凭证类型（非必填） */
    private DocType docType;

    /** 账号（必填） */
    private String baseAcctNo;

    /** 交易机构号（必填） */
    private TranBranch tranBranch;

    /** 交易类型（必填） */
    private TranType tranType;

    /** 服务代码（必填） */
    private String serviceCode;

    /** 接口服务代码（必填） */
    private String messageCode;

    /** 接口服务类型（必填） */
    private String messageType;

    /** 渠道类型（必填） */
    private SourceType sourceType;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }
}
