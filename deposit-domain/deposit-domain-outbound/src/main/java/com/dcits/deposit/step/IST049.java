package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;

/**
 * ST049 检查转账止收限制 步骤接口。
 */
public interface IST049 {

    /**
     * 执行检查转账止收限制步骤。
     *
     * @param input 输入（必填账号 baseAcctNo）
     * @return 步骤结果，业务输出见 {@link ST049OutputBO}
     */
    ST049OutputBO execute(ST049InputBO input);
}
