package com.dcits.deposit.facade.bo;

/**
 * ST026 检查对手账户通存标志 输入。
 *
 * <p>按正式 Spec「输入」表声明：必填输入对手账号 {@code othBaseAcctNo}（{@link java.lang.String}）。
 * 必填缺失/为空时的校验与报错行为待确认（Spec 待确认事项 TBD-5，见 {@code ST026Pbc} 中 FIXME）。</p>
 */
public class ST026InputBO {

    /** 对手账号（必填） */
    private String othBaseAcctNo;

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }
}
