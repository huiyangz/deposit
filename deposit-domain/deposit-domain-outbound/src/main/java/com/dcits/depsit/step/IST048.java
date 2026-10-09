package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST048InputBO;
import com.dcits.depsit.facade.bo.ST048OutputBO;

/**
 * ST048 检查存入账户账户属性 步骤接口。
 *
 * <p>本步骤为只读检查，不涉及本地数据的写入，调用方无需以事务包裹本步骤。</p>
 */
public interface IST048 {

    /**
     * 执行步骤：根据账号查询【账户信息】获取账户属性，并据此给出检查结论。
     *
     * @param input 步骤输入（{@code baseAcctNo} 账号，必填）
     * @return 步骤结果；检查结果为「通过」时 {@code succeed = true} 且错误字段为空；
     *         [账户属性] 为「验资户」或「临时户」时进入跳转分支，不表现为「通过」
     */
    ST048OutputBO execute(ST048InputBO input);
}
