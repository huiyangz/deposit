package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RbAcctType;

/**
 * ST014 检查对手账户类型 输出 BO。
 */
public class ST014OutputBO extends StepResult {
    /** 存款账户类型，非必填，来源实体 对公存款账户主表（RB_BUS_ACCT） */
    private RbAcctType rbAcctType;

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }
}
