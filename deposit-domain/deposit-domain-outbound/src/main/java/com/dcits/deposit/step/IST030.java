package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST030InputBO;
import com.dcits.deposit.facade.bo.ST030OutputBO;

/**
 * ST030 检查对手账户是否能够入账 步骤接口。
 *
 * <p>以对手账号（othBaseAcctNo）为输入，依据对手账号查询对公存款账户主表取得账户状态，
 * 以对手账号为调用账号调用组件内步骤 ST052/ST056 取得转账止付标志与转账不收不付标志，
 * 以三者执行规则《检查账户是否能够入账》（DT002）取得入账标志；入账标志为"允许"时返回
 * 检查结果"通过"（正常完成），否则返回错误码"ER0077"。</p>
 */
public interface IST030 {

    /**
     * 执行检查对手账户是否能够入账步骤。
     *
     * @param input 输入 BO，含对手账号 othBaseAcctNo（必填）
     * @return 输出 BO，正常完成时 succeed=true、errorCode/errorMessage 为 null；
     *         入账标志非"允许"时 succeed=false、errorCode="ER0077"
     */
    ST030OutputBO execute(ST030InputBO input);
}
