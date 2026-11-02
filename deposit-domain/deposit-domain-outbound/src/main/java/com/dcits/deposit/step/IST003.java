package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST003InputBO;
import com.dcits.deposit.facade.bo.ST003OutputBO;

/**
 * ST003 检查对手账户属性 步骤接口。
 */
public interface IST003 {

    /**
     * 执行检查对手账户属性步骤：根据必填输入 othBaseAcctNo（对手账号）获取对公存款账户主表
     * （RB_BUS_ACCT）记录的账户属性 acctNatureNo，账户属性为「验资户」或「临时户」时跳转至
     * 步骤《检查账户到期日》，否则返回检查结果为「通过」。
     *
     * @param input 步骤输入（对手账号）
     * @return 步骤输出（账户属性；跳转目标 gotoStepName；成功/失败状态见 {@link ST003OutputBO} 继承的公共结果）
     */
    ST003OutputBO execute(ST003InputBO input);
}
