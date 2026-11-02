package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST033InputBO;
import com.dcits.deposit.facade.bo.ST033OutputBO;

/**
 * ST033 检查账户余额类型一致性 步骤接口。
 */
public interface IST033 {
    /**
     * 检查账户余额类型一致性。
     *
     * <p>依次获取转出账户与转入账户的余额类型，比较两者一致性：不一致时步骤失败并返回
     * 错误码 ER0075，一致时检查结果返回「通过」。</p>
     *
     * @param input 输入（baseAcctNo 账号、othBaseAcctNo 对手账号）
     * @return 输出（rbAcctType 存款账户类型，非必填）
     */
    ST033OutputBO execute(ST033InputBO input);
}
