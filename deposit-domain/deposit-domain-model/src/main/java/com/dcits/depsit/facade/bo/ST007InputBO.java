package com.dcits.depsit.facade.bo;

/**
 * ST007 检查对手账户是否存在 —— 输入 BO。
 *
 * <p>按 Spec「### 输入」表，本步骤仅有 1 个业务入参：对手账号。该字段在源需求
 * 「## 输入」表中标为「必填」，但源需求未定义其取空（未上送或为空值）时的校验、
 * 默认值或异常（Spec 不覆盖事项第 3 项），故此处不生成校验或默认值。</p>
 */
public class ST007InputBO {

    /** 对手账号 */
    private String othBaseAcctNo;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
