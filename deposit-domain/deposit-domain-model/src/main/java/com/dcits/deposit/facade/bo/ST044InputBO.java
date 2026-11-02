package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ST044 登记累计限额 步骤输入。
 */
public class ST044InputBO {

    /** 限额检查结果，触发登记条件值"未超限" */
    private String 限额检查结果;

    /** 账号，检查对象类型为"账户"时的限额检查对象值来源 */
    private String baseAcctNo;

    /** 客户号，检查对象类型为"客户"时的限额检查对象值来源 */
    private String clientNo;

    /** 交易金额，登记为限额累计金额 */
    private BigDecimal tranAmt;

    /** 限额场景编码，登记字段取值及周期配置的定位键 */
    private String limitSceneNo;

    /** 限额累计金额（既有累计值），仅用于触发条件判断 */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（字段名"否"，既有累计笔数），仅用于触发条件判断 */
    private Integer 否;

    /** 来源系统日期表（FM_DATE），核心运行日期，用于生效日期与失效日期计算 */
    private Date runDate;

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

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }
}
