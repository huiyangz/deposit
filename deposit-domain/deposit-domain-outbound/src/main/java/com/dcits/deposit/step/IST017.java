package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST017InputBO;
import com.dcits.deposit.facade.bo.ST017OutputBO;

/**
 * ST017 检查币种一致性 步骤接口。
 */
public interface IST017 {

    /**
     * 执行检查币种一致性步骤：判定交易币种与账户币种是否一致。
     *
     * @param input 步骤输入（交易币种、账户币种）
     * @return 步骤输出（成功/失败状态见 {@link ST017OutputBO} 继承的公共结果）
     */
    ST017OutputBO execute(ST017InputBO input);
}
