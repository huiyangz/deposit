package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST014InputBO;
import com.dcits.deposit.facade.bo.ST014OutputBO;

/**
 * ST014 检查对手账户类型 步骤接口。
 */
public interface IST014 {
    /**
     * 执行「检查对手账户类型」步骤。
     *
     * <p>以必填输入 对手账号（othBaseAcctNo）查询对公存款账户主表（RB_BUS_ACCT）取得存款账户类型
     * 并作为输出 rbAcctType；账户类型为「T-定期账户」（RbAcctType.T）或「A-AIO账户」（RbAcctType.A）
     * 时步骤失败并返回错误码 ER0052（业务说明「当前账户不为活期账户」），否则检查通过。</p>
     *
     * @param input 步骤输入
     * @return 步骤结果，正常通过时 succeed=true 且错误字段为空；业务失败时 succeed=false 并携带错误码
     */
    ST014OutputBO execute(ST014InputBO input);
}
