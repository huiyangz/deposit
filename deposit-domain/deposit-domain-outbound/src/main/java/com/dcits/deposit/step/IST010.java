package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST010InputBO;
import com.dcits.deposit.facade.bo.ST010OutputBO;

/**
 * ST010 检查资金管控标识 步骤接口。
 *
 * <p>依据必填输入账号 {@code baseAcctNo} 查询对公存款账户主表（RB_BUS_ACCT）账户信息，
 * 取得该账户的贷款资金管控标志（{@code loanFundFlag}）作为检查标识并检查：为「Y-是」时
 * 本步骤正常结束并跳转至步骤《检查账户客户一致性》（不返回「通过」）；不为「Y-是」时返回
 * 检查结果「通过」且不发生跳转。</p>
 */
public interface IST010 {

    /**
     * 执行检查资金管控标识步骤。
     *
     * @param input 步骤输入（必填账号 {@code baseAcctNo}）
     * @return 步骤输出：业务字段 {@code loanFundFlag}，以及按跳转机制可能携带的
     *         {@code gotoStepName}（检查为「Y-是」时为《检查账户客户一致性》，否则为 null）
     */
    ST010OutputBO execute(ST010InputBO input);
}
