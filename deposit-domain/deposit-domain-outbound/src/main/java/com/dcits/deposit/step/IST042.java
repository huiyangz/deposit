package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;

/**
 * ST042 获取累计限额 步骤接口。
 *
 * <p>按必填输入限额场景编码（limitSceneNo）与账号（baseAcctNo）为查询条件查询限额累计信息表
 * （RB_LIMIT_SUM_INFO），获取并输出该记录的限额累计金额（limitSumAmt）与限额累计笔数，
 * 同时输出客户号（clientNo）与限额场景编码（limitSceneNo）。</p>
 *
 * <p>步骤以 {@link ST042OutputBO} 继承的 {@link com.dcits.common.step.StepResult} 状态表达结果；
 * 成功时 succeed 为 true，错误字段为空。本步骤未声明业务失败条件及错误码。</p>
 */
public interface IST042 {

    /**
     * 执行获取累计限额步骤。
     *
     * @param input 步骤输入（baseAcctNo、clientNo、limitSceneNo，均为必填）
     * @return 步骤输出，succeed=true 表示步骤成功完成
     */
    ST042OutputBO execute(ST042InputBO input);
}
