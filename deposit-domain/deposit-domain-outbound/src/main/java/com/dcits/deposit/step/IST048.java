package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST048InputBO;
import com.dcits.deposit.facade.bo.ST048OutputBO;

/**
 * ST048 检查限制豁免 步骤接口。
 */
public interface IST048 {

    /**
     * 执行检查限制豁免步骤。
     *
     * <p>按渠道类型查询渠道柜面标志、按账户限制类型查询生效的限制控制明细，
     * 依据渠道柜面标志与明细柜面标志的分支，在柜面渠道下判定「不检查限制」/「需检查限制」，
     * 在非柜面渠道下判定「豁免」/「不豁免」。</p>
     *
     * @param input 步骤输入
     * @return 步骤输出
     */
    ST048OutputBO execute(ST048InputBO input);
}
