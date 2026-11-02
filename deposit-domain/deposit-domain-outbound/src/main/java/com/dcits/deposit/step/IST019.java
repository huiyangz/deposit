package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST019InputBO;
import com.dcits.deposit.facade.bo.ST019OutputBO;

/**
 * ST019 检查账户支取方式。
 *
 * <p>依据必填输入 {@code baseAcctNo}（账号）查询账户信息取得支取方式
 * {@code withdrawalType}；支取方式为「凭密码支取」（{@code WithdrawalType.P}）时
 * 流程跳转至步骤《检查支取密码状态》继续执行，本步骤不判定为检查失败；否则检查通过。</p>
 */
public interface IST019 {
    /**
     * 执行检查账户支取方式。
     *
     * @param input 输入，含必填账号 baseAcctNo
     * @return 输出，含步骤结果状态及支取方式 withdrawalType
     */
    ST019OutputBO execute(ST019InputBO input);
}
