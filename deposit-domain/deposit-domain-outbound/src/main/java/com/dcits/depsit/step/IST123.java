package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST123InputBO;
import com.dcits.depsit.facade.bo.ST123OutputBO;

/**
 * ST123 检查账户是否存在不允许销户的限制 —— 步骤接口。
 *
 * <p>本步骤为只读检查：遍历输入的 [账户限制信息]，逐条以记录自身的账户限制类型查询
 * 【限制类型信息】并按其销户标志判定 [允许销户标志]。本步骤不写库、无业务失败场景、
 * 不产出错误码，故 {@code execute} 无需事务。</p>
 */
public interface IST123 {

    /**
     * 执行步骤。
     *
     * @param input 步骤输入，[账户限制信息] 的条数由调用方决定，可为空集
     * @return 步骤输出；成功时 {@code isSucceed()} 为 true、错误字段为 null，
     *         {@code allowCloseAcctFlag} 取「允许销户」或「不允许销户」
     */
    ST123OutputBO execute(ST123InputBO input);
}
