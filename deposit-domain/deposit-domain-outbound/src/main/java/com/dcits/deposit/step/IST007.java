package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST007InputBO;
import com.dcits.deposit.facade.bo.ST007OutputBO;

/** ST007 检查对手账户是否存在 步骤接口 */
public interface IST007 {

    /**
     * 执行检查对手账户是否存在步骤。
     *
     * @param input 步骤输入，必填对手账号 {@code othBaseAcctNo}
     * @return 步骤输出，对手账户信息为空时业务失败返回错误码 ER0081，非空时检查通过并返回对手账户信息
     */
    ST007OutputBO execute(ST007InputBO input);
}
