package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST026InputBO;
import com.dcits.deposit.facade.bo.ST026OutputBO;

/**
 * ST026 检查对手账户通存标志。
 *
 * <p>步骤按必填输入对手账号 {@code othBaseAcctNo} 查询账户信息（对公存款账户主表 RB_BUS_ACCT）
 * 获取通存标志并输出 {@code allDepInd}；通存标志不等于「Y-是」时业务失败（错误码 ER0055，
 * 不继续执行），等于「Y-是」时正常完成并继续。</p>
 *
 * <p>本步骤只读取本地数据，无事务要求。</p>
 */
public interface IST026 {

    /**
     * 执行检查对手账户通存标志步骤。
     *
     * @param input 输入，含必填对手账号 othBaseAcctNo
     * @return 输出，含通存标志 allDepInd；通存标志不等于「Y-是」时 succeed=false 且
     *         errorCode=ER0055、errorMessage=「ER0055::当前交易机构不是账户的通存机构」
     */
    ST026OutputBO execute(ST026InputBO input);
}
