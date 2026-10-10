package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST128 检查是否跨法人 输出 BO。
 *
 * <p>继承 {@link StepResult} 的 {@code succeed}/{@code errorCode}/{@code errorMessage} 状态字段；
 * 业务输出仅 {@code checkResult}，取值规范常量 {@code "通过"} / {@code "不通过"}。
 * 账号查询业务失败（ER0048）时不产出检查结果，{@code checkResult} 保持为空。</p>
 */
public class ST128OutputBO extends StepResult {

    /** 检查结果：账户法人与交易机构法人不一致时为「不通过」，一致时为「通过」 */
    private String checkResult;

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
}
