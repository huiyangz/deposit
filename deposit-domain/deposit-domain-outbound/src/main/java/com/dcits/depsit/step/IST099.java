package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST099InputBO;
import com.dcits.depsit.facade.bo.ST099OutputBO;

/**
 * ST099 检查利息资本化标志 步骤接口。
 */
public interface IST099 {

    /**
     * 检查利息资本化标志。
     *
     * <p>子步骤 1：{@code intCapFlag} 不等于「N-否」（码值 "N"）时返回检查结果为「通过」，
     * 本步骤在子步骤 1 即结束，不执行子步骤 2。子步骤 2：{@code intCapFlag} 等于「N-否」
     * 时判断 {@code settleAcctClass} 是否为「INT-利息入账账户」（{@code SettleAcctClass.INT}），
     * 是则返回检查结果为「通过」，否则返回错误码 {@code ER0034}。</p>
     *
     * <p>本步骤为纯入参判定：无数据查询与写入、无组件内步骤/规则/跨组件调用，
     * 不需要调用方提供事务。</p>
     *
     * @param input 输入 BO，含利息资本化标志与结算账户类型两项必填入参
     * @return 输出 BO；「通过」时 {@code succeed = true}、错误字段为 {@code null}，
     *         失败时 {@code succeed = false}、{@code errorCode = "ER0034"}
     */
    ST099OutputBO execute(ST099InputBO input);
}
