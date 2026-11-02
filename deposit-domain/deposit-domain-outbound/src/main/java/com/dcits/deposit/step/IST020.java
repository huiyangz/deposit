package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST020InputBO;
import com.dcits.deposit.facade.bo.ST020OutputBO;

/**
 * ST020 检查转账交易类型 步骤接口。
 *
 * <p>依据必填输入交易类型（tranType）判定是否为「行内转账（非支票）」：为「行内转账（非支票）」
 * 时返回检查结果「通过」（成功状态），否则业务失败返回错误码 ER0067 并短路。</p>
 */
public interface IST020 {

    /**
     * 执行「检查转账交易类型」步骤。
     *
     * @param input 输入 BO（必填：交易类型 tranType）
     * @return 输出 BO；检查结果「通过」由 {@code StepResult.succeed} 承载，业务失败时
     *         返回错误码 ER0067、错误信息「ER0067::交易类型错误」
     */
    ST020OutputBO execute(ST020InputBO input);
}
