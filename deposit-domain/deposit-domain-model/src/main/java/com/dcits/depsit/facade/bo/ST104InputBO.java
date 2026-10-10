package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

/**
 * ST104 检查限额 输入 BO。
 *
 * <p>字段名、类型与「必填」标记照录 Spec「### 输入」表：{@code limitSceneNo}（{@code java.lang.String}，
 * [限额场景编码]）、{@code limitSumAmt}（{@code java.math.BigDecimal}，[限额累计金额]）、
 * {@code limitSumNum}（{@code java.lang.Integer}，[限额累计笔数]），三项均标「必填」。
 * 声明顺序沿用「### 输入」表行序。</p>
 *
 * <p>{@code limitSceneNo} 为子步骤1 查询【限额控制配置(RB_LIMIT_CTRL_CONF)】的唯一查询条件；
 * {@code limitSumAmt}、{@code limitSumNum} 为子步骤2 的比较左操作数，并分别回显到输出的
 * {@code limitSumAmt} 与「否」。三个输入的「来源实体」列在源需求中均为空，本 BO 仅为承载，
 * 不据此新增数据访问或外部调用。</p>
 *
 * <p>三个输入均标「必填」，其取到空值（{@code null} 或空字符串）时的行为源需求未定义
 * （Spec「验收范围与明确不覆盖的事项」第 3 项），本 BO 与实现均不为其兜底、不新增校验分支。</p>
 */
public class ST104InputBO {

    /** 限额场景编码 —— 步骤描述中的 [限额场景编码]，子步骤1 的查询条件 */
    private String limitSceneNo;

    /** 限额累计金额 —— 步骤描述中的 [限额累计金额]，子步骤2 金额维度比较的左操作数 */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数 —— 步骤描述中的 [限额累计笔数]，子步骤2 笔数维度比较的左操作数 */
    private Integer limitSumNum;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
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
}
