package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST039 计算限额累计金额 步骤输出。
 *
 * <p>继承 {@link StepResult}。业务输出字段来自正式 Spec ST039「输出」表：
 * limitSumAmt（限额累计金额）、限额累计笔数（限额累计笔数）。两输出在需求中均标记为
 * 非必填，仅在累计计算分支按已确认场景产出；O-单笔金额等不计算累计的分支保持未设置。</p>
 */
public class ST039OutputBO extends StepResult {
    /** 限额累计金额（非必填） */
    private BigDecimal limitSumAmt;
    /** 限额累计笔数（非必填） */
    // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:类型定义矛盾 - 问题描述:需求输出表以「否」作为限额累计笔数字段名，与业务语义字段名「限额累计笔数」定义矛盾，物理字段名未确认（TBD-8） - 影响:当前输出 BO 按用例采用业务语义字段名「限额累计笔数」（getter get限额累计笔数()），与限额累计信息表实体 RbLimitSumInfoEO 的「否」字段名不一致 - 待确认:「否」确为物理字段名还是文档转录占位（如应为 limitSumCnt）
    private Integer 限额累计笔数;

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }

    public Integer get限额累计笔数() {
        return 限额累计笔数;
    }

    public void set限额累计笔数(Integer 限额累计笔数) {
        this.限额累计笔数 = 限额累计笔数;
    }
}
