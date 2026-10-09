package com.dcits.depsit.facade.bo;

/**
 * ST001 检查对手账户凭证状态 —— 输入 BO。
 *
 * <p>按 Spec「### 输入」表，本步骤仅有 1 个业务入参：对手账号。该字段在源需求
 * 「## 输入」表中标为「必填」，但源需求未定义其为空（{@code null} / 空字符串）时的
 * 校验、默认值或异常（Spec「## 验收范围与明确不覆盖的事项」第 2 项），故此处不生成
 * 校验或默认值。</p>
 */
public class ST001InputBO {

    /** 对手账号：本步骤以该值作为查询【凭证挂失信息】的唯一条件 */
    private String othBaseAcctNo;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
