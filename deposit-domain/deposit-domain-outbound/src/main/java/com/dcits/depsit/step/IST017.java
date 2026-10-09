package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST017InputBO;
import com.dcits.depsit.facade.bo.ST017OutputBO;

/**
 * ST017 检查币种一致性 步骤接口。
 *
 * <p>以交易币种与账户币种两个输入，按币种代码比较两者是否一致：
 * 一致时返回检查结果“通过”（{@code succeed = true}，错误码为空），
 * 不一致时返回错误码 {@code "ER0051"}。
 *
 * <p>本步骤为无状态纯判断，不读取账户数据、不发起外部调用、不产生任何写入，
 * 因此调用方无需为其开启事务。
 */
public interface IST017 {

    /**
     * 执行检查币种一致性。
     *
     * @param input 交易币种（{@code tranCcy}，类型 {@code com.dcits.depsit.enums.Ccy}）与
     *              账户币种（{@code acctCcy}，类型 {@code com.dcits.depsit.enums.AcctCcy}）
     * @return 检查结果：币种一致时 {@code succeed = true} 且 {@code errorCode}、{@code errorMessage} 为空；
     *         币种不一致时 {@code succeed = false} 且 {@code errorCode = "ER0051"}
     */
    ST017OutputBO execute(ST017InputBO input);
}
