package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ST108 登记累计限额 输入参数。
 *
 * <p>字段集合、类型与必填性照录正式 Spec（docs/specs/ST108.md）REQ-001 与「### 输入」表：
 * 8 个字段全部必填，本步骤的条件判定、查询键与登记内容只来自这 8 个字段；不为「来源实体」列为空的
 * 字段假定其它数据源，也不要求调用方上送表外入参。</p>
 *
 * <p>字段名 {@code 限额检查结果} 照源需求原文承载为中文标识符，未另造英文参数名（REQ-001）。</p>
 */
public class ST108InputBO {

    /** 限额检查结果（必填），判定触发条件的取值，规范判定字面量为「未超限」 */
    private String 限额检查结果;

    /** 账号（必填），检查对象类型为账户级别（ACCT）时限额检查对象值的赋值来源 */
    private String baseAcctNo;

    /** 客户号（必填），检查对象类型为客户级别（CUST）时限额检查对象值的赋值来源 */
    private String clientNo;

    /** 交易金额（必填），登记的限额累计金额取值来源 */
    private BigDecimal tranAmt;

    /** 限额场景编码（必填），登记内容之一，并作为查【限额场景定义表】取检查对象类型的查询键 */
    private String limitSceneNo;

    /** 核心运行日期（必填），来源实体为系统日期表（FM_DATE），登记的生效日期取值来源 */
    private Date runDate;

    /** 限额累计金额（必填），登记触发条件的判定值 */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（必填），登记触发条件的判定值 */
    private Integer limitSumCnt;

    public String get限额检查结果() {
        return 限额检查结果;
    }

    public void set限额检查结果(String 限额检查结果) {
        this.限额检查结果 = 限额检查结果;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }

    public Integer getLimitSumCnt() {
        return limitSumCnt;
    }

    public void setLimitSumCnt(Integer limitSumCnt) {
        this.limitSumCnt = limitSumCnt;
    }
}
