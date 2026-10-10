package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST104 检查限额 输出 BO。
 *
 * <p>继承项目公共步骤结果载体 {@link StepResult}；业务字段的字段名、类型与「非必填」标记照录
 * Spec「### 输出」表，依次为 {@code limitCtrlAmt}（{@code java.math.BigDecimal}，限额控制金额）、
 * {@code limitCtrlNum}（{@code java.lang.Integer}，限额控制笔数）、{@code limitSumAmt}
 * （{@code java.math.BigDecimal}，限额累计金额）、{@code 否}（{@code java.lang.Integer}，限额累计笔数）、
 * {@code limitCheckResult}（{@code java.lang.String}，限额检查结果）。不新增「## 输出」表以外的
 * 业务输出字段，也不重复声明 {@code succeed}／{@code errorCode}／{@code errorMessage}。</p>
 *
 * <p>取值来源（REQ-005）：{@code limitCtrlAmt}、{@code limitCtrlNum} 取子步骤1 查询命中的
 * 【限额控制配置】记录；{@code limitSumAmt} 与 {@code 否} 回显本次输入的 {@code limitSumAmt}、
 * {@code limitSumNum}（源需求「## 输出」表将两者的「来源实体」记为【限额累计信息表】，属建模工具的
 * 列示口径，本步骤不查询该表）；{@code limitCheckResult} 取子步骤2 的判定结论，字面值为
 * 「超限」或「未超限」，全工程无该结果的枚举或码值定义（Spec 不覆盖事项第 4 项），故以
 * {@code java.lang.String} 承载，本 BO 不补码值、不补枚举。</p>
 *
 * <p>字段 {@code 否} 的名称照录源需求「## 输出」表第 24 行，与承载该列的 {@code RbLimitSumInfoEO}
 * 属性名、DDL 列名逐字一致；源需求 5 个输出的「标记」列一律「非必填」，本 BO 照录，不据此收紧
 * 输出必返性。</p>
 */
public class ST104OutputBO extends StepResult {

    /** 限额控制金额（非必填；子步骤1 查询【限额控制配置】取得的限额控制金额） */
    private BigDecimal limitCtrlAmt;

    /** 限额控制笔数（非必填；子步骤1 查询【限额控制配置】取得的限额控制笔数） */
    private Integer limitCtrlNum;

    /** 限额累计金额（非必填；回显本次输入 limitSumAmt，不查询【限额累计信息表】） */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（非必填；名称照录源需求「## 输出」表，回显本次输入 limitSumNum） */
    private Integer 否;

    /** 限额检查结果（非必填；字面值「超限」或「未超限」，无枚举承载） */
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

    public Integer get否() {
        return 否;
    }

    public void set否(Integer 否) {
        this.否 = 否;
    }

    public String getLimitCheckResult() {
        return limitCheckResult;
    }

    public void setLimitCheckResult(String limitCheckResult) {
        this.limitCheckResult = limitCheckResult;
    }
}
