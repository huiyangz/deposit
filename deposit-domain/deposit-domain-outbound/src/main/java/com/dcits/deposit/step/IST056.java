package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;

/**
 * ST056 检查是否存在转账不收不付限制。
 *
 * <p>以账号（baseAcctNo）为输入，按账号与限制状态「A-生效」查询【账户限制信息】（对公
 * 存款账户限制表）取得限制编号与账户限制类型；按账户限制类型与状态「A-生效」查询【限制
 * 类型表】（存款限制类型表）取得借贷方控制标志与转账标志；借贷方控制标志等于「A-禁止
 * 借贷方」且转账标志等于「N-禁止转账」时输出转账不收不付标志=「是」，否则输出「否」，
 * 并返回需求输出表登记的八个输出字段。</p>
 */
public interface IST056 {

    /**
     * 执行检查是否存在转账不收不付限制步骤。
     *
     * @param input 步骤输入（baseAcctNo 账号，必填）
     * @return 步骤输出（继承 {@link com.dcits.common.step.StepResult}，正常完成时 succeed=true
     *         且 errorCode、errorMessage 为空）
     */
    ST056OutputBO execute(ST056InputBO input);
}
