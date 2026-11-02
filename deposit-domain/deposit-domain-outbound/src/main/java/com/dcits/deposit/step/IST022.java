package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST022InputBO;
import com.dcits.deposit.facade.bo.ST022OutputBO;

/**
 * ST022 检查对手账户限额 交易执行步骤接口。
 */
public interface IST022 {

    /**
     * 执行检查对手账户限额步骤。
     *
     * <p>按「步骤描述」第 1–14 项编排：依次调用组件内步骤 ST043（匹配限额场景）、ST038、ST045、
     * ST037（机构匹配、配置有效性、场景编码确认），任一环节返回空限额场景编码时以「通过」成功提前结束；
     * 再调用 ST042、ST039 取得累计值，ST040 检查限额：结果为「未超限」时按累计情况调用 ST046（更新）
     * 或 ST044（登记），结果「超限」时调用 ST041 按处理方式返回（拒绝→错误码 ER0058、授权→授权标志
     * 「需授权」、提示→检查结果「超限，但可继续交易」）。</p>
     *
     * <p>本步骤可能调用 ST046（更新累计限额）与 ST044（登记累计限额），二者会写入限额累计信息表
     * （RB_LIMIT_SUM_INFO），调用方须保证在事务中调用，实现以 {@code @Transactional} 声明本地写事务。</p>
     *
     * @param input 步骤输入
     * @return 步骤结果
     */
    ST022OutputBO execute(ST022InputBO input);
}
