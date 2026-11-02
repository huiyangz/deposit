package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;

/**
 * ST050 检查有权机关冻结限制 步骤接口。
 *
 * <p>依据必填输入账号查询账户在「A-生效」限制状态下的账户限制信息，
 * 再依据取得的账户限制类型查询「A-生效」状态下的限制类型定义，
 * 取得有权机关冻结标志赋值并返回。</p>
 */
public interface IST050 {

    /**
     * 执行检查有权机关冻结限制步骤。
     *
     * @param input 步骤输入，必填账号 baseAcctNo
     * @return 步骤输出，正常完成时 succeed=true 且 errorCode、errorMessage 为 null
     */
    ST050OutputBO execute(ST050InputBO input);
}
