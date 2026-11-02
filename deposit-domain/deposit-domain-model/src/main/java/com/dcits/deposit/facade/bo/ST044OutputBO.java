package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ST044 登记累计限额 步骤输出，仅在登记发生时产生业务输出。
 */
public class ST044OutputBO extends StepResult {

    /** 限额场景编码，等于输入 limitSceneNo */
    private String limitSceneNo;

    /** 限额检查对象值，按配置的检查对象类型取账号或客户号 */
    private String checkObjVal;

    /** 限额累计金额，等于交易金额（tranAmt），非输入 limitSumAmt */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（字段名"否"），固定为 1 */
    private Integer 否;

    /** 生效日期，等于系统日期（runDate） */
    private Date effectDate;

    /** 失效日期，系统日期加配置的周期类型与周期值对应时长 */
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
