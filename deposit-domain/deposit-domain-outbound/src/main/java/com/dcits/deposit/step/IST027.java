package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST027InputBO;
import com.dcits.deposit.facade.bo.ST027OutputBO;

/**
 * ST027 检查账户是否能够出账 步骤接口。
 *
 * <p>依据必填输入账号（baseAcctNo）查询【账户信息】（对公存款账户主表 RB_BUS_ACCT）取得账户状态；
 * 调用组件内步骤 ST052「检查是否存在转账止付限制」、ST056「检查是否存在转账不收不付限制」
 * 分别取得转账止付标志、转账不收不付标志；以账户状态与两个标志执行决策规则「检查账户是否能够出账」
 * （DT001）取得出账标志；出账标志为「允许」时步骤成功结束，否则返回错误码 ER0076。</p>
 */
public interface IST027 {

    /**
     * 执行检查账户是否能够出账步骤。
     *
     * @param input 输入 BO，含账号 baseAcctNo
     * @return 输出 BO，出账标志为「允许」时 succeed=true、errorCode/errorMessage 为 null；
     *         否则 succeed=false、errorCode=ER0076
     */
    ST027OutputBO execute(ST027InputBO input);
}
