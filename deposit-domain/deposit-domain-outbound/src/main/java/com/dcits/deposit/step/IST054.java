package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;

/**
 * ST054 检查是否存在现金止收限制 步骤接口。
 *
 * <p>依据必填输入账号查询账户在「A-生效」限制状态下的账户限制信息，再依据取得的账户限制类型
 * 查询「A-生效」状态下的限制类型定义，按借贷方控制标志与现金标志判定现金止收限制，
 * 按「输出」表返回两次查询取得的字段。</p>
 */
public interface IST054 {

    /**
     * 执行检查是否存在现金止收限制步骤。
     *
     * @param input 步骤输入，必填账号 baseAcctNo
     * @return 步骤输出，正常完成时 succeed=true 且 errorCode、errorMessage 为 null
     */
    ST054OutputBO execute(ST054InputBO input);
}
