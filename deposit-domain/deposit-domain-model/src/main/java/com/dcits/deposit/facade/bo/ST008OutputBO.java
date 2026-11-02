package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.VoucherLostStatus;

/**
 * ST008 检查支取账户凭证状态 输出 BO。
 */
public class ST008OutputBO extends StepResult {
    /** 凭证挂失状态（非必填） */
    private VoucherLostStatus voucherLostStatus;

    public VoucherLostStatus getVoucherLostStatus() {
        return voucherLostStatus;
    }

    public void setVoucherLostStatus(VoucherLostStatus voucherLostStatus) {
        this.voucherLostStatus = voucherLostStatus;
    }
}
