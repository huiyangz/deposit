package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST031InputBO;
import com.dcits.deposit.facade.bo.ST031OutputBO;

/**
 * ST031 验证密码 步骤接口。
 */
public interface IST031 {

    /**
     * 执行验证密码步骤。
     *
     * @param input 步骤输入（baseAcctNo 账号、pwdType 密码类型）
     * @return 步骤输出（公共步骤结果及业务字段「执行结果」）
     */
    ST031OutputBO execute(ST031InputBO input);
}
