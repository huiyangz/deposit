package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;

/**
 * ST052 检查是否存在转账止付限制 步骤接口。
 *
 * <p>依据必填输入账号（baseAcctNo）查询对公存款账户限制表与存款限制类型表，
 * 判定转账止付限制是否存在，输出限制记录字段、限制类型记录字段及推导的转账止付标志。</p>
 */
public interface IST052 {

    /**
     * 执行检查是否存在转账止付限制步骤。
     *
     * @param input 输入 BO，含账号 baseAcctNo
     * @return 输出 BO，正常完成时 succeed=true、errorCode/errorMessage 为 null
     */
    ST052OutputBO execute(ST052InputBO input);
}
