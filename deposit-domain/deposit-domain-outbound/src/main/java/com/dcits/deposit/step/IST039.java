package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;

/**
 * ST039 计算限额累计金额 步骤接口。
 */
public interface IST039 {

    /**
     * 执行计算限额累计金额步骤。
     *
     * <p>按限额场景编码获取限额信息后，依据限额控制类型与累计类型代码分支计算
     * 限额累计金额与限额累计笔数。</p>
     *
     * @param input 步骤输入：tranAmt（交易金额）、limitSceneNo（限额场景编码）
     * @return 步骤输出：limitSumAmt、限额累计笔数，并携带步骤执行结果（succeed/errorCode/errorMessage）
     */
    ST039OutputBO execute(ST039InputBO input);
}
