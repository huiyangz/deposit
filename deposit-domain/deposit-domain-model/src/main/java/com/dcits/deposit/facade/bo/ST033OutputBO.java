package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.RbAcctType;

/**
 * ST033 检查账户余额类型一致性 输出 BO。
 */
public class ST033OutputBO extends StepResult {
    /** 存款账户类型 */
    private RbAcctType rbAcctType;

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }
}
