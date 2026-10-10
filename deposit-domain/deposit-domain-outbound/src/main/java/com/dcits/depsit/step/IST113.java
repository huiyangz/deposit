package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST113InputBO;
import com.dcits.depsit.facade.bo.ST113OutputBO;

/**
 * ST113 检查有权机关冻结限制 步骤接口（检查类）。
 *
 * <p>以账号（`baseAcctNo`）与限制状态码值 `"A"` 查询【账户限制信息】，逐条按其
 * `$账户限制类型$` 到【限制类型表】取 `$状态$` 为 `"A"` 的 `$有权机关冻结标志$`，
 * 任一条表示该限制属于有权机关冻结即取该值原样赋给 `ahBuFlag` 返回；全部不表示时不赋值。
 * 本步骤无业务失败场景，失败仅由技术异常传播表达（Spec REQ-008），实现只读、不需要调用方事务。</p>
 */
public interface IST113 {

    /**
     * 执行有权机关冻结限制检查。
     *
     * @param input 步骤输入，业务入参 `baseAcctNo`（账号，必填）
     * @return 步骤输出；`ahBuFlag` 命中时取配置取值原样，未命中三条路径时不赋值（null）
     */
    ST113OutputBO execute(ST113InputBO input);
}
