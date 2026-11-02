package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057OutputBO;

/**
 * ST057 检查限制优先级 步骤接口。
 */
public interface IST057 {

    /**
     * 执行「检查限制优先级」步骤。
     *
     * @param input 输入：交易类型（{@code tranType}，必填）、账户限制类型（{@code restraintType}，必填）
     * @return 步骤结果；正常完成时 {@code succeed=true}、错误字段为 null
     */
    ST057OutputBO execute(ST057InputBO input);
}
