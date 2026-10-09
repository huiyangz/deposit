package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.VoucherLostStatus;

/**
 * ST001 检查对手账户凭证状态 —— 输出 BO。
 *
 * <p>按 Spec「### 输出」表声明 1 个业务字段 {@code voucherLostStatus}（凭证挂失状态），
 * 类型为 {@link VoucherLostStatus}，标记为「非必填」：取值只能是枚举常量
 * {@code USE}（使用）、{@code CAN}（挂失取消）或为空。检查结论由继承自
 * {@link StepResult} 的 {@code succeed} / {@code errorCode} / {@code errorMessage}
 * 承载，不在业务字段中重复声明。</p>
 */
public class ST001OutputBO extends StepResult {

    /** 凭证挂失状态：{@link VoucherLostStatus#USE}（使用）、{@link VoucherLostStatus#CAN}（挂失取消）或为空 */
    private VoucherLostStatus voucherLostStatus;

    public VoucherLostStatus getVoucherLostStatus() {
        return voucherLostStatus;
    }

    public void setVoucherLostStatus(VoucherLostStatus voucherLostStatus) {
        this.voucherLostStatus = voucherLostStatus;
    }
}
