package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST006InputBO;
import com.dcits.deposit.facade.bo.ST006OutputBO;

/**
 * ST006 检查法透标志 步骤接口。
 *
 * <p>先根据输入交易类型查询交易类型定义表（RB_TRAN_DEF）取得借贷标志，再依据借贷标志与
 * 法人透支检查标志判定是否放行：条件满足时本步骤业务成功结束并跳转步骤《检查靠档标识》，
 * 条件不满足时本步骤业务失败并返回错误码 {@code ER0060}。</p>
 */
public interface IST006 {

    /**
     * 执行本步骤。
     *
     * @param input 步骤输入（法人透支检查标志、tranType）
     * @return 步骤结果；业务成功时 succeed=true 且 errorCode/errorMessage 为 null，
     *         业务失败时 succeed=false 且 errorCode=ER0060
     */
    ST006OutputBO execute(ST006InputBO input);
}
