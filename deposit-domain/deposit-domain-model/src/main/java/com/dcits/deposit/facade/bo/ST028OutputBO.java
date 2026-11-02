package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AcctNatureNo;

/**
 * ST028 检查支取账户属性 输出 BO。
 *
 * <p>继承 {@link StepResult}，成功/失败状态与错误字段由基类提供。业务字段来自正式 Spec
 * ST028 输出表：账户属性（acctNatureNo，非必填，来源实体：对公存款账户主表（RB_BUS_ACCT））。</p>
 * <p>跳转目标 gotoStepName 按 {@code com.dcits.common.step.GotoStepCondition} 框架约定由步骤返回
 * 结果承载：步骤执行过程中跳转到其它步骤时设置该字段为目标步骤名称，运行时据此决定是否跳转。</p>
 */
public class ST028OutputBO extends StepResult {

    /** 账户属性（非必填，来源实体：对公存款账户主表（RB_BUS_ACCT）） */
    private AcctNatureNo acctNatureNo;

    /** 跳转目标步骤名称（GotoStepCondition 框架约定；跳转至《检查账户到期日》时取值为 "检查账户到期日"） */
    private String gotoStepName;

    public AcctNatureNo getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public String getGotoStepName() {
        return gotoStepName;
    }

    public void setGotoStepName(String gotoStepName) {
        this.gotoStepName = gotoStepName;
    }
}
