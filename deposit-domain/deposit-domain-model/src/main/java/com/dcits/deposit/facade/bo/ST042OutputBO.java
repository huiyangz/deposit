package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

import java.math.BigDecimal;

/**
 * ST042 获取累计限额 步骤输出。
 *
 * <p>业务字段对应正式 Spec（ST042）「输出」表（REQ-003）：clientNo（客户号）、limitSceneNo（限额场景编码）、
 * limitSumAmt（限额累计金额）、限额累计笔数（字段名「否」），均为非必填，取值取自命中记录对应列，
 * 记录对应列为空时相应输出为空。继承 {@link StepResult} 表达步骤结果，成功时 succeed=true 且错误字段为空。</p>
 *
 * <p>「限额累计笔数」字段沿用需求与工程现有名称「否」（见 Spec 待确认事项 2），业务含义为限额累计笔数。</p>
 */
public class ST042OutputBO extends StepResult {

    /** 客户号（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO） */
    private String clientNo;
    /** 限额场景编码（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO） */
    private String limitSceneNo;
    /** 限额累计金额（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO） */
    private BigDecimal limitSumAmt;
    /** 限额累计笔数（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO，字段名「否」） */
    private Integer 否;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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
}
