package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST101InputBO;
import com.dcits.depsit.facade.bo.ST101OutputBO;

/**
 * ST101 获取限额场景编码的步骤接口。
 *
 * <p>业务含义：在给定 [限额场景编码]、[客户号] 与 {交易日期} 下，先按 [限额场景编码] 取
 * 【限额控制配置表】的 $允许自定义标识$ 与 $仅检查客户自定义标志$，再按需取
 * 【限额控制客户自定义配置表】中 $生效日期$ 不晚于 {交易日期} 的 [自定义限额]，
 * 最终返回 [限额场景编码] 本身或返回其为空。</p>
 *
 * <p>结果语义：全部返回路径均为正常结束（{@code succeed = true}，错误码为空）；
 * 本步骤无业务失败场景，失败仅由技术异常传播表达（REQ-012）。</p>
 *
 * <p>事务要求：本步骤只读取上述两张表，不新增、修改或删除记录，调用方无需为本步骤开启事务。</p>
 */
public interface IST101 {

    /**
     * 执行获取限额场景编码。
     *
     * @param input 输入 BO，字段契约见 {@link ST101InputBO}
     * @return 输出 BO；limitSceneNo 为返回的 [限额场景编码] 或其空值，其他字段按本次执行分支的来源取值
     */
    ST101OutputBO execute(ST101InputBO input);
}
