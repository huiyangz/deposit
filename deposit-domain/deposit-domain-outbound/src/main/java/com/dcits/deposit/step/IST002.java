package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST002InputBO;
import com.dcits.deposit.facade.bo.ST002OutputBO;

/**
 * ST002 检查账户到期日 步骤接口。
 */
public interface IST002 {

    /**
     * 执行检查账户到期日步骤：根据账号获取账户到期日期，并与交易日期比较，判定账户是否过期。
     *
     * @param input 步骤输入（账号、交易日期）
     * @return 步骤输出（账户到期日期；成功/失败状态见 {@link ST002OutputBO} 继承的公共结果）
     */
    ST002OutputBO execute(ST002InputBO input);
}
