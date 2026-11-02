package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;

/**
 * ST051 检查账户是否存在限制 - 步骤接口。
 */
public interface IST051 {
    /**
     * 执行「检查账户是否存在限制」步骤：确定待查账户（子账户时折算为主账户账号），
     * 按待查账户查询对公存款账户限制表中限制状态为「A-生效」的账户限制信息并返回。
     *
     * @param input 步骤输入（必填：baseAcctNo 账号）
     * @return 步骤输出（正常完成时 succeed=true，错误字段为 null）
     */
    ST051OutputBO execute(ST051InputBO input);
}
