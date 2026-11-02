package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST043InputBO;
import com.dcits.deposit.facade.bo.ST043OutputBO;

/**
 * ST043 匹配限额场景 步骤接口。
 *
 * <p>按正式 Spec ST043「步骤描述」第 1–3 项编排：因子定位限额规则关系取得关系规则表达式、
 * 按表达式取得限额场景编码列表、遍历检查启用配置数据，返回"已匹配到限额场景"或
 * "未匹配到限额场景"（均为正常业务结论）。</p>
 */
public interface IST043 {

    /**
     * 执行匹配限额场景步骤。
     *
     * @param input 步骤输入，含因子名称（必填）
     * @return 步骤输出，正常完成时 succeed=true 且错误字段为 null
     */
    ST043OutputBO execute(ST043InputBO input);
}
