package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST032InputBO;
import com.dcits.depsit.facade.bo.ST032OutputBO;

/**
 * ST032 检查交易金额 步骤接口。
 *
 * <p>检查交易金额：若{交易金额}小于等于 0，则返回错误码 {@code ER0050}，否则返回检查结果为「通过」。
 * 两条分支互斥，由同一分支判定产出。</p>
 *
 * <p>本步骤为纯入参判定，不产生数据写操作，不涉及组件内步骤调用、规则调用、外部服务调用与数据查询，
 * 故调用方无需为本步骤开启事务。</p>
 */
public interface IST032 {

    /**
     * 检查交易金额。
     *
     * @param input 步骤输入，含交易金额 tranAmt
     * @return 步骤执行结果：交易金额小于等于 0 时 {@code succeed} 为 false 且 {@code errorCode} 为 ER0050；
     *         交易金额大于 0 时 {@code succeed} 为 true
     */
    ST032OutputBO execute(ST032InputBO input);
}
