package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST028InputBO;
import com.dcits.deposit.facade.bo.ST028OutputBO;

/**
 * ST028 检查支取账户属性 步骤接口。
 */
public interface IST028 {

    /**
     * 执行检查支取账户属性步骤：根据账号获取账户属性，账户属性为「验资户」或「临时户」时
     * 跳转至步骤《检查账户到期日》，否则返回检查结果为「通过」。
     *
     * @param input 步骤输入（账号）
     * @return 步骤输出（账户属性；跳转目标 gotoStepName；成功/失败状态见 {@link ST028OutputBO} 继承的公共结果）
     */
    ST028OutputBO execute(ST028InputBO input);
}
