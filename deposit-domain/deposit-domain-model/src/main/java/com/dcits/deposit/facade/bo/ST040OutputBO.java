package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST040 检查限额 输出。
 */
public class ST040OutputBO extends StepResult {

    /** 限额控制金额（来源：限额控制配置 RB_LIMIT_CTRL_CONF） */
    private BigDecimal limitCtrlAmt;

    /** 限额控制笔数（来源：限额控制配置 RB_LIMIT_CTRL_CONF） */
    private Integer limitCtrlNum;

    /** 限额累计金额（按输入承接） */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（按输入承接） */
    // FIXME 业务项:ST040/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:限额累计笔数字段名未确定（Spec 待确认事项 TBD-1）：需求「输出」表字段名列原文为「否」，工程 RB_LIMIT_SUM_INFO 列名与实体字段名亦为「否」（getter get否()），与业务语义不符，疑似如 limitSumNum 的编码名被破坏 - 影响:本 BO 暂以 limitSumNum 作为占位字段名，实际字段名确认后需同步替换实现与测试中的绑定 - 待确认:限额累计笔数的实际字段名
    private Integer limitSumNum;

    /** 限额检查结果：超限/未超限（业务结论，正常完成时返回） */
    // FIXME 业务项:ST040/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:限额检查结果输出字段未在需求「输出」表登记（Spec 待确认事项 TBD-2）：步骤描述返回「超限」/「未超限」，但字段名、类型及物理取值（中文串还是映射编码）均未定义 - 影响:本 BO 暂以 String 类型 limitCheckResult 占位并直接使用正式文本「超限」「未超限」作为取值，字段名/类型/取值编码确认后需同步调整实现与测试 - 待确认:限额检查结果的字段名、类型及物理取值编码
    private String limitCheckResult;

    public BigDecimal getLimitCtrlAmt() {
        return limitCtrlAmt;
    }

    public void setLimitCtrlAmt(BigDecimal limitCtrlAmt) {
        this.limitCtrlAmt = limitCtrlAmt;
    }

    public Integer getLimitCtrlNum() {
        return limitCtrlNum;
    }

    public void setLimitCtrlNum(Integer limitCtrlNum) {
        this.limitCtrlNum = limitCtrlNum;
    }

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }

    public Integer getLimitSumNum() {
        return limitSumNum;
    }

    public void setLimitSumNum(Integer limitSumNum) {
        this.limitSumNum = limitSumNum;
    }

    public String getLimitCheckResult() {
        return limitCheckResult;
    }

    public void setLimitCheckResult(String limitCheckResult) {
        this.limitCheckResult = limitCheckResult;
    }
}
