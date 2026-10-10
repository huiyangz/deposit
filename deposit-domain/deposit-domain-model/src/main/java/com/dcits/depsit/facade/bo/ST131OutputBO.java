package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST131 检查账户限制编号是否存在 —— 步骤输出。
 *
 * <p>按 [限制信息] 是否为空给出检查结果：不为空（查询命中至少一条记录）时为
 * 「限制编号存在」，为空（查询零条命中，或限制编号为空而未执行查询）时为
 * 「限制编号不存在」，二者互斥且构成完整取值域。</p>
 *
 * <p>本步骤无业务失败场景，不产出错误码，成功时错误字段为 null；不回显 [限制信息]
 * 的记录内容，不产生其它业务输出。</p>
 */
public class ST131OutputBO extends StepResult {

    /** 检查结果，取值：「限制编号存在」、「限制编号不存在」 */
    private String checkResult;

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
}
