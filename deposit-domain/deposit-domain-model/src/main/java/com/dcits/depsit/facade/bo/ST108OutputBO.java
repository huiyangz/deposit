package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ST108 登记累计限额 输出参数。
 *
 * <p>继承公共步骤结果 {@link StepResult}（succeed / errorCode / errorMessage），业务字段集合照录正式
 * Spec（docs/specs/ST108.md）REQ-007 与「### 输出」表的 6 个字段，不补写表外业务字段。</p>
 *
 * <p>登记发生时第 1–5 个字段的取值与本次登记写入【限额累计信息表（RB_LIMIT_SUM_INFO）】的对应列一致；
 * 第 6 个字段 {@code expireDate}（失效日期）的推算口径源需求未写明（Spec「验收范围与明确不覆盖的
 * 事项」第 2 项），本步骤不赋值、不作断言。</p>
 */
public class ST108OutputBO extends StepResult {

    /** 限额场景编码（非必填），本次登记写入的限额场景编码，即输入 limitSceneNo */
    private String limitSceneNo;

    /** 限额检查对象值（非必填），本次登记写入的限额检查对象值，即账号或客户号 */
    private String checkObjVal;

    /** 限额累计金额（非必填），本次登记写入的限额累计金额，即输入 tranAmt */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（非必填），本次登记写入的限额累计笔数，规范常量 1；字段名照录源需求输出表 */
    private Integer 否;

    /** 生效日期（非必填），本次登记写入的生效日期，即输入 runDate */
    private Date effectDate;

    /** 失效日期（非必填），推算口径源需求未写明，本步骤不赋值 */
    private Date expireDate;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getCheckObjVal() {
        return checkObjVal;
    }

    public void setCheckObjVal(String checkObjVal) {
        this.checkObjVal = checkObjVal;
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

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
