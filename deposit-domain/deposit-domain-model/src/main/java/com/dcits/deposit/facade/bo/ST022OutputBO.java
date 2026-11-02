package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.TranStatus;

import java.math.BigDecimal;

/**
 * ST022 检查对手账户限额 步骤输出。
 *
 * <p>继承 {@link StepResult}，业务输出字段来自正式 Spec「输出」表（REQ-010）：tranStatus（业务处理状态，
 * {@link TranStatus}）、limitSceneNo（限额场景编码）、limitSumAmt（限额累计金额）、限额累计笔数（字段名「否」）、
 * 限额检查结果、授权标志，均非必填。各字段在何种分支下填充、检查结果（「通过」/「超限，但可继续交易」）的承载字段、
 * tranStatus 取值语义及输出表重复字段，见 Spec 待确认事项 TBD-07、TBD-10、TBD-12。</p>
 */
public class ST022OutputBO extends StepResult {

    // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:输出表登记 tranStatus（业务处理状态，非必填），Spec 未定义本步骤在何种情况下取何值（TranStatus 取值：F 失败/N 正常/P 未处理/R 冲正/S 成功/W 抹账/X 被冲正），TBD-10 - 影响:tranStatus 填充时机与取值无法确定，当前不设置该字段 - 待确认:tranStatus 的填充时机与取值
    /** 业务处理状态（非必填）。 */
    private TranStatus tranStatus;

    /** 限额场景编码（非必填）。 */
    private String limitSceneNo;

    /** 限额累计金额（非必填）。 */
    private BigDecimal limitSumAmt;

    // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出表 limitSumAmt 与「否」各登记两次（一次无来源实体、一次来源实体为限额累计信息表 RB_LIMIT_SUM_INFO），「否」为限额累计笔数字段名但命名不具业务语义，两行重复登记的含义及唯一物理命名未确认，TBD-12 - 影响:输出重复字段的唯一物理命名与取值来源无法确定，当前按输出表首行登记声明单一字段 - 待确认:输出字段的唯一物理命名、两行重复登记的含义及各自取值来源
    /** 限额累计笔数（非必填，字段名「否」）。 */
    private Integer 否;

    // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:本步骤返回的检查结果「通过」/「超限，但可继续交易」未在输出表登记承载字段（输出表仅有「限额检查结果」与「授权标志」），「限额检查结果」输出字段的填充时机与取值未声明，TBD-07 - 影响:正常提前结束（「通过」）与提示分支（「超限，但可继续交易」）的检查结果承载方式无法确定，当前不设置该字段 - 待确认:检查结果的承载字段/方式及「限额检查结果」字段的填充时机与取值
    /** 限额检查结果（非必填）。 */
    private String 限额检查结果;

    /** 授权标志（非必填）。 */
    private String 授权标志;

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

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

    public Integer get否() {
        return 否;
    }

    public void set否(Integer 否) {
        this.否 = 否;
    }

    public String get限额检查结果() {
        return 限额检查结果;
    }

    public void set限额检查结果(String 限额检查结果) {
        this.限额检查结果 = 限额检查结果;
    }

    public String get授权标志() {
        return 授权标志;
    }

    public void set授权标志(String 授权标志) {
        this.授权标志 = 授权标志;
    }
}
