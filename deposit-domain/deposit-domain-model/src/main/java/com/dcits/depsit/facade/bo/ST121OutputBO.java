package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST121 检查限制优先级 输出 BO。
 *
 * <p>继承 {@link StepResult} 的 {@code succeed}/{@code errorCode}/{@code errorMessage} 状态字段；
 * 业务输出为两个冻结级别与检查结果：{@code tranResPriority}（交易的冻结级别）、
 * {@code restraintResPriority}（限制的冻结级别）、{@code checkResult}（检查结果，
 * 取值恰为「不检查限制」「继续检查」）。</p>
 *
 * <p>两个冻结级别在对应取值取到时回显该取值、取不到值（按主键查询无对应记录，或记录存在但
 * 冻结级别列为空）时为空。本步骤无业务失败场景，各输出分支均不设置错误码。</p>
 */
public class ST121OutputBO extends StepResult {

    /** 交易的冻结级别：取值取自【交易定义信息】（RB_TRAN_DEF）的冻结级别列，取不到值时为 null */
    private String tranResPriority;

    /** 限制的冻结级别：取值取自【限制类型定义信息】（RB_RESTRAINT_TYPE）的冻结级别列，取不到值时为 null */
    private String restraintResPriority;

    /** 检查结果，取值：「不检查限制」、「继续检查」 */
    private String checkResult;

    public String getTranResPriority() {
        return tranResPriority;
    }

    public void setTranResPriority(String tranResPriority) {
        this.tranResPriority = tranResPriority;
    }

    public String getRestraintResPriority() {
        return restraintResPriority;
    }

    public void setRestraintResPriority(String restraintResPriority) {
        this.restraintResPriority = restraintResPriority;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
}
