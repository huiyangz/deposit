package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RbAcctType;

/**
 * ST021 检查支取账户类型 输出。
 *
 * <p>继承 {@link StepResult}：检查通过时 {@code succeed=true} 且错误字段为空并输出
 * rbAcctType；账户类型为 T（定期账户）或 A（AIO账户）时业务失败（{@code succeed=false}），
 * errorCode 为 "ER0052"。</p>
 *
 * <p>业务输出 rbAcctType（存款账户类型）非必填，来源对公存款账户主表（RB_BUS_ACCT）。</p>
 */
public class ST021OutputBO extends StepResult {

    /** 存款账户类型，来源对公存款账户主表（RB_BUS_ACCT），非必填 */
    private RbAcctType rbAcctType;

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }
}
