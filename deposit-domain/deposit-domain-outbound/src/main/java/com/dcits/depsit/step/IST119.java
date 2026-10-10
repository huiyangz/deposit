package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST119InputBO;
import com.dcits.depsit.facade.bo.ST119OutputBO;

/**
 * ST119 检查是否存在止付限制 —— 步骤接口。
 *
 * <p>以账号（{@code baseAcctNo}）与限制状态码值「A」（源需求「A-生效」）的组合条件查询
 * 【账户限制信息】（对公存款账户限制表 RB_BUS_RESTRAINTS），对取回的每一条记录按其
 * 账户限制类型取【限制类型表】（存款限制类型表 RB_RESTRAINT_TYPE）中状态码值为「A」的配置，
 * 按该配置的借贷方控制标志是否等于「D-禁止借方」逐条判定并聚合：任一条命中即返回
 * {@code stopFlag = "是"}，全部不满足返回 {@code stopFlag = "否"}；存在命中记录时按
 * 限制编号最小的一条回显限制编号、账户限制类型、限制状态及该记录的配置标志与状态，
 * 「最小」按限制编号所表示的数字比较、位数不同时以数字大小为序（如"9"小于"10"）。</p>
 *
 * <p>本步骤为只读检查：不新增、修改或删除任何数据，不调用其它步骤、规则或外部服务，
 * 无业务失败场景、不产出错误码（源需求「## 失败处理」），故 {@code execute} 无需事务。</p>
 */
public interface IST119 {

    /**
     * 执行检查是否存在止付限制。
     *
     * @param input 步骤输入：{@code baseAcctNo}（账号，必填，为子步骤 1 的查询条件之一）
     * @return 步骤输出；各已定义业务路径均成功（{@code isSucceed()} 为 true、错误字段为 null），
     *         {@code stopFlag} 取「是」（存在止付限制）或「否」（不存在止付限制）；
     *         无记录或未命中时 5 个回显字段为空值，命中时回显限制编号最小的一条命中记录
     */
    ST119OutputBO execute(ST119InputBO input);
}
