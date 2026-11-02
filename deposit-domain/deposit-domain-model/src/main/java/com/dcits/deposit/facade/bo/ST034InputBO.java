package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;

/**
 * ST034 检查对手账户黑名单 输入 BO。
 */
public class ST034InputBO {
    /** 凭证类型（非必填） */
    private DocType docType;
    /** 对手账号（必填） */
    private String othBaseAcctNo;
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

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
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
