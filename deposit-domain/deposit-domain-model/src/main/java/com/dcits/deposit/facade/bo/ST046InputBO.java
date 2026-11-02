package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST046 更新累计限额 步骤输入。
 *
 * <p>字段来自正式 Spec 输入表，全部必填。字段名"限额检查结果"与"否"按需求原样使用，
 * 其中"否"即限额累计笔数，与工程实体 {@code RbLimitSumInfoEO} 的"否"字段一致。</p>
 */
public class ST046InputBO {

    /** 限额检查结果；业务取值"未超限" */
    private String 限额检查结果;
    /** 账号 */
    private String baseAcctNo;
    /** 限额场景编码 */
    private String limitSceneNo;
    /** 客户号 */
    private String clientNo;
    /** 限额累计金额 */
    private BigDecimal limitSumAmt;
    /** 限额累计笔数 */
    private Integer 否;

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

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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
