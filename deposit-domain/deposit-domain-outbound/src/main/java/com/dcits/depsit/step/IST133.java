package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST133InputBO;
import com.dcits.depsit.facade.bo.ST133OutputBO;

/**
 * ST133 登记账户限制登记簿 步骤接口。
 *
 * <p>本步骤只有一次登记写入（对公存款账户限制表 RB_BUS_RESTRAINTS），实现方法涉及本地数据库新增，
 * 调用方需为其提供事务边界（Spring 事务上下文）。</p>
 */
public interface IST133 {

    /**
     * 执行登记账户限制登记簿。
     *
     * @param input 「## 输入」表的 14 个登记字段
     * @return 登记结果；成功时 {@code succeed=true}、错误字段为 {@code null}，
     *         且 14 个输出字段承载本次已登记的值
     */
    ST133OutputBO execute(ST133InputBO input);
}
