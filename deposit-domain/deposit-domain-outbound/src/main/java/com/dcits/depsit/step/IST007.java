package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST007InputBO;
import com.dcits.depsit.facade.bo.ST007OutputBO;

/**
 * ST007 检查对手账户是否存在 —— 步骤接口。
 *
 * <p>步骤为只读检查：根据入参对手账号查询【账户信息】，据其是否存在给出检查结论。
 * 不新增、修改或删除任何数据，无业务副作用，调用方无需事务。</p>
 */
public interface IST007 {

    /**
     * 执行检查对手账户是否存在。
     *
     * @param input 步骤输入，必填业务入参 {@code othBaseAcctNo}（对手账号）
     * @return 步骤输出；检查结果为「通过」时 {@code succeed = true} 且错误字段为空，
     *         [对手账户信息] 为空时 {@code succeed = false} 且 {@code errorCode = "ER0081"}
     */
    ST007OutputBO execute(ST007InputBO input);
}
