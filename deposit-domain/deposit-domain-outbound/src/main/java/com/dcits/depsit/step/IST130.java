package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST130InputBO;
import com.dcits.depsit.facade.bo.ST130OutputBO;

/**
 * ST130 登记账户限制信息 步骤接口。
 *
 * <p>本步骤把调用方给出的 {账号}、{限制类型}、{开始日期}、{结束日期}、{限制期限}、{限制期限类型}
 * 作为一条账户限制信息登记到【对公存款账户限制表（RB_BUS_RESTRAINTS）】（Spec REQ-002）。</p>
 *
 * <p>本步骤只做一次登记写入（对公存款账户限制表 RB_BUS_RESTRAINTS），实现方法涉及本地数据库写入，
 * 调用方需为其提供事务边界（Spring 事务上下文）。</p>
 */
public interface IST130 {

    /**
     * 执行登记账户限制信息。
     *
     * @param input 「## 输入」表的 8 个字段：账号、账户限制类型、开始日期、结束日期、存期期限、
     *              周期类型、交易日期、核心运行日期
     * @return 登记结果；成功时 {@code succeed=true}、{@code errorCode} 与 {@code errorMessage} 均为
     *         {@code null}。本步骤无业务输出字段、无业务失败场景，失败仅由技术异常传播表达
     */
    ST130OutputBO execute(ST130InputBO input);
}
