package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST102InputBO;
import com.dcits.depsit.facade.bo.ST102OutputBO;

/**
 * ST102 检查账户机构是否可匹配到限额场景配置 步骤接口。
 *
 * <p>步骤以账号为唯一入参，按子步骤 1 → 2 → 3 →（仅当限额场景编码为空时）4 → 5 顺序执行：
 * 按 {账号} 查【账户信息】取账户开立行行号 → 按该行号查【限额控制配置表】取「启用标志＝Y」配置的
 * 限额场景编码 → 编码非空则返回并短路，为空则按该行号查【机构信息表】沿归属上级机构号逐级向上构建
 * [上级机构集合] → 按机构层级从高到低（总行、分行、支行）遍历集合，返回首个命中的限额场景编码。</p>
 *
 * <p>本步骤只读取上述三张表，不产生任何写入，调用方无需事务，接口不传递事务要求。</p>
 *
 * <p>唯一业务失败为子步骤 1 的账号查询查不到记录或查到多条记录，此时短路结束本步骤并返回错误码
 * {@code ER0048}；子步骤 3 命中、上级机构集合为空、遍历全部未命中等均属正常结束，不设错误码。
 * 其余失败仅由技术异常向上传播，本步骤不捕获、不转译为业务错误码。</p>
 */
public interface IST102 {

    /**
     * 执行步骤。
     *
     * @param input 账号（{@code baseAcctNo}，必填，本步骤唯一业务入参）
     * @return 限额场景编码 {@code limitSceneNo}（命中启用配置时为该配置记录的编码，未命中任何启用配置时为
     *         空值）与步骤状态；账号查询查无或多条时为 {@code succeed=false}、{@code errorCode="ER0048"}
     */
    ST102OutputBO execute(ST102InputBO input);
}
