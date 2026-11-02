package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST046 更新累计限额 步骤输出。
 *
 * <p>业务字段 limitSumAmt 来自正式 Spec 输出表（非必填），其返回语义见待确认事项，
 * 见下方 FIXME。</p>
 */
public class ST046OutputBO extends StepResult {

    // FIXME 业务项:ST046/更新累计限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出表声明 limitSumAmt 非必填，但未定义返回行为——成功路径是否回显本次写入的限额累计金额、何种情形为空（Spec 待确认事项 2） - 影响:当前输出 limitSumAmt 保持 null，输出字段返回行为未确定，测试不断言该输出字段 - 待确认:输出值的来源、写入与返回的关系及空值语义
    /** 限额累计金额（非必填，返回语义见待确认事项） */
    private BigDecimal limitSumAmt;

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }
}
