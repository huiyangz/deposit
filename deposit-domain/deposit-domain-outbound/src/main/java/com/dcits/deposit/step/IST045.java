package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;

/**
 * ST045 检查限额场景配置是否有效 步骤接口。
 *
 * <p>按输入限额场景编码查询限额控制配置，判定交易是否落在控制区间内，并输出控制区间字段。</p>
 */
public interface IST045 {

    ST045OutputBO execute(ST045InputBO input);
}
