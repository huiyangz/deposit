package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST112InputBO;
import com.dcits.depsit.facade.bo.ST112OutputBO;

/**
 * ST112 检查限制豁免 步骤接口。
 *
 * <p>本步骤为只读检查（不新增、修改或删除任何表的记录），无业务失败场景，失败仅由技术异常
 * 传播表达，故调用方无需为本步骤提供事务。</p>
 */
public interface IST112 {

    /**
     * 执行检查限制豁免。
     *
     * @param input 5 个必填入参（渠道类型、账户限制类型、交易类型、摘要码、产品类型）
     * @return 检查结果与 [限制控制明细信息] 的 7 个回显字段；成功时 succeed 为 true、错误字段为 null
     */
    ST112OutputBO execute(ST112InputBO input);
}
