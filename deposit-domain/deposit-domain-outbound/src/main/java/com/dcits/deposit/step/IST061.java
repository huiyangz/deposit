package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST061InputBO;
import com.dcits.deposit.facade.bo.ST061OutputBO;

/**
 * ST061 检查是否存在属性限制 步骤接口。
 */
public interface IST061 {

    ST061OutputBO execute(ST061InputBO input);
}
