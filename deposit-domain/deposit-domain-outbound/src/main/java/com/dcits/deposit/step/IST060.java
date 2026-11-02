package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST060InputBO;
import com.dcits.deposit.facade.bo.ST060OutputBO;

/**
 * ST060 检查是否存在现金不收不付限制 步骤接口。
 */
public interface IST060 {

    /**
     * 执行本步骤。
     *
     * @param input 步骤输入，baseAcctNo（账号）必填
     * @return 步骤输出，正常完成时 succeed=true、errorCode/errorMessage 为 null
     */
    ST060OutputBO execute(ST060InputBO input);
}
