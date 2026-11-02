package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST032InputBO;
import com.dcits.deposit.facade.bo.ST032OutputBO;

/**
 * ST032 检查交易金额 步骤接口。
 *
 * <p>以必填输入交易金额（tranAmt）执行金额检查：交易金额小于等于 0 时返回业务失败
 * （错误码 ER0050），否则返回检查结果为"通过"、步骤正常完成。本步骤无子步骤与跳转目标。</p>
 */
public interface IST032 {

    /**
     * 执行检查交易金额步骤。
     *
     * @param input 步骤输入，必填交易金额 tranAmt
     * @return 步骤输出，以公共步骤结果表达成功或业务失败
     */
    ST032OutputBO execute(ST032InputBO input);
}
