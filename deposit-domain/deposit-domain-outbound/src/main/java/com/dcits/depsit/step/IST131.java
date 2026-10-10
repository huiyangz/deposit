package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST131InputBO;
import com.dcits.depsit.facade.bo.ST131OutputBO;

/**
 * ST131 检查账户限制编号是否存在 —— 步骤接口。
 *
 * <p>本步骤为只读检查：限制编号不为空时按其与限制状态查询【限制信息】，再按
 * [限制信息] 是否为空返回检查结果「限制编号存在」或「限制编号不存在」。本步骤
 * 不写库、无业务失败场景、不产出错误码，故 {@code execute} 无需事务。</p>
 */
public interface IST131 {

    /**
     * 执行步骤。
     *
     * @param input 步骤输入，限制编号可为无值（此时不执行查询）
     * @return 步骤输出；成功时 {@code isSucceed()} 为 true、错误字段为 null，
     *         {@code checkResult} 取「限制编号存在」或「限制编号不存在」
     */
    ST131OutputBO execute(ST131InputBO input);
}
