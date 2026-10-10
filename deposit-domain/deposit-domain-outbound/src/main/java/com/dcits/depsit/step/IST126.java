package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST126InputBO;
import com.dcits.depsit.facade.bo.ST126OutputBO;

/**
 * ST126 检查是否存在现金止付限制 —— 步骤接口。
 *
 * <p>以账号（{@code baseAcctNo}）与限制状态码值「A」为条件查询【账户限制信息】，
 * 逐条按其账户限制类型取【限制类型表】中状态码值为「A」的配置，按借贷方控制标志与
 * 现金标志的合取条件判定是否存在现金止付限制，最终返回
 * {@code cashStopPayFlag}（「是」或「否」）。</p>
 *
 * <p>本步骤为只读检查：不新增、修改或删除任何数据，不调用其它步骤、规则或外部服务，
 * 无业务失败场景、不产出错误码，故 {@code execute} 无需事务。</p>
 */
public interface IST126 {

    /**
     * 执行检查是否存在现金止付限制。
     *
     * @param input 步骤输入：{@code baseAcctNo}（账号，必填，为步骤 1 的查询条件之一）
     * @return 步骤输出；各已定义业务路径均成功（{@code isSucceed()} 为 true、错误字段为 null），
     *         {@code cashStopPayFlag} 取「是」（存在现金止付限制）或「否」（不存在现金止付限制）
     */
    ST126OutputBO execute(ST126InputBO input);
}
