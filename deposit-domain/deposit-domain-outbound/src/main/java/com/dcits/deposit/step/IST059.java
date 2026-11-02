package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST059InputBO;
import com.dcits.deposit.facade.bo.ST059OutputBO;

/**
 * ST059 检查账户是否存在不允许销户的限制 步骤接口。
 *
 * <p>遍历[账户限制信息]，逐条按[账户限制类型]查询【限制类型信息】获取[销户标志]；
 * 任一限制的[销户标志]为「N-否」时返回[允许销户标志]「不允许销户」并中断遍历，否则遍历
 * 结束后返回「允许销户」。本步骤仅读取数据，无本地写入，调用方无需承担额外事务。</p>
 */
public interface IST059 {

    /**
     * 执行 ST059 步骤。
     *
     * @param input 步骤输入，[账户限制信息]集合
     * @return 步骤输出，含[允许销户标志]及步骤结果状态
     */
    ST059OutputBO execute(ST059InputBO input);
}
