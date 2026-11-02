package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST029InputBO;
import com.dcits.deposit.facade.bo.ST029OutputBO;

/**
 * ST029 登记转账交易流水 步骤接口。
 *
 * <p>按正式 Spec REQ-001~REQ-003 在【对公存款账户金融交易流水表（RB_BUS_TRAN_JNL）】登记
 * 转账交易流水，登记交易类型、币种、借贷标志、交易金额。</p>
 *
 * <p>事务要求：本步骤实现通过 {@code IRbBusTranJnlBcc} 在本地新增交易流水记录，{@code execute}
 * 使用 Spring {@code @Transactional} 声明事务；调用方应在事务环境中调用本接口。</p>
 */
public interface IST029 {

    /**
     * 登记转账交易流水。
     *
     * @param input 步骤输入（交易类型、交易币种、交易金额、借贷标志，均必填）
     * @return 步骤输出：登记产生的流水数据字段及步骤结果；正常完成时 succeed=true、错误字段为空
     */
    ST029OutputBO execute(ST029InputBO input);
}
