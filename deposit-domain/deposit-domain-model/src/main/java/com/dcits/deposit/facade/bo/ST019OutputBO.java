package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.WithdrawalType;

/**
 * ST019 检查账户支取方式 输出 BO。
 *
 * <p>继承 {@link StepResult}，业务输出：支取方式 {@code withdrawalType}（非必填），
 * 取值属于 {@link WithdrawalType} 枚举，来源实体为对公客户账户表（RB_BUS_CLIENT_ACCT）。</p>
 */
public class ST019OutputBO extends StepResult {
    /** 支取方式（非必填） */
    private WithdrawalType withdrawalType;

    public WithdrawalType getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(WithdrawalType withdrawalType) {
        this.withdrawalType = withdrawalType;
    }
}
