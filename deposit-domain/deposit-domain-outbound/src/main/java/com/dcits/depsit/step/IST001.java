package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST001InputBO;
import com.dcits.depsit.facade.bo.ST001OutputBO;

/**
 * ST001 检查对手账户凭证状态 —— 步骤接口。
 *
 * <p>步骤为只读检查：根据入参对手账号查询【凭证挂失信息】取得凭证挂失状态，据此给出
 * 检查结论。不新增、修改或删除任何数据，无业务副作用，调用方无需事务。</p>
 */
public interface IST001 {

    /**
     * 执行检查对手账户凭证状态。
     *
     * @param input 步骤输入，必填业务入参 {@code othBaseAcctNo}（对手账号）
     * @return 步骤输出；凭证挂失状态为 {@code USE}（使用）时 {@code succeed = false}
     *         且 {@code errorCode = "ER0068"}，否则检查结果为「通过」，
     *         {@code succeed = true} 且错误字段为空
     */
    ST001OutputBO execute(ST001InputBO input);
}
