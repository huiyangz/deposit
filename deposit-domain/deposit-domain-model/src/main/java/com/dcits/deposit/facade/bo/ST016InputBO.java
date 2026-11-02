package com.dcits.deposit.facade.bo;

/**
 * ST016 检查账户客户一致性 输入 BO。
 *
 * <p>输入字段 clientNo（客户号）、othClientNo（对手客户号）均标记「必填」，由调用方
 * （交易上下文）直接提供；本步骤仅对二者做取值比较，不发起查询或外部调用
 * （正式 Spec「输入」表及「输入、输出及依赖契约」）。</p>
 */
public class ST016InputBO {

    /** 客户号（必填） */
    private String clientNo;

    /** 对手客户号（必填） */
    private String othClientNo;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getOthClientNo() {
        return othClientNo;
    }

    public void setOthClientNo(String othClientNo) {
        this.othClientNo = othClientNo;
    }
}
