package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST118InputBO;
import com.dcits.depsit.facade.bo.ST118OutputBO;

/**
 * ST118 检查是否存在现金止收限制 步骤接口。
 *
 * <p>以入参账号（{@code baseAcctNo}）为条件查询【账户限制信息】，逐条按其账户限制类型取
 * A-生效 的限制类型配置，判定是否存在现金止收限制（借贷方控制标志 = C-禁止贷方 且
 * 现金标志 = N-不允许现金），并以 {@code cashStopCreditFlag} 字面值「是」/「否」返回结论。</p>
 *
 * <p>本步骤只读取数据、不写库、不修改账户或限制数据，不产生业务失败（Spec REQ-006）；
 * 调用方无需为本步骤提供事务。</p>
 */
public interface IST118 {

    /**
     * 执行「检查是否存在现金止收限制」。
     *
     * @param input 步骤入参：账号（{@code baseAcctNo}）
     * @return 步骤输出：现金止收标志 {@code cashStopCreditFlag}（「是」/「否」），
     *         命中时另回显限制编号、账户限制类型、限制状态与对应的限制类型配置值；
     *         成功时 {@code succeed=true} 且错误码、错误信息为 null
     */
    ST118OutputBO execute(ST118InputBO input);
}
