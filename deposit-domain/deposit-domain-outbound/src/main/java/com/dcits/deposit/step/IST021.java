package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST021InputBO;
import com.dcits.deposit.facade.bo.ST021OutputBO;

/**
 * ST021 检查支取账户类型 步骤接口。
 */
public interface IST021 {

    /**
     * 执行检查支取账户类型步骤。
     *
     * @param input 输入，必填字段 baseAcctNo（账号）
     * @return 输出：检查通过时 {@code succeed=true} 并输出 rbAcctType；账户类型为
     *         T（定期账户）或 A（AIO账户）时业务失败，errorCode 为 "ER0052"
     */
    ST021OutputBO execute(ST021InputBO input);
}
