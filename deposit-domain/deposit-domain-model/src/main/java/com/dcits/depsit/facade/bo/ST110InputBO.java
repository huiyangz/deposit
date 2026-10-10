package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

/**
 * ST110 更新累计限额的步骤输入。
 *
 * <p>字段名、类型与「必填」标记照录正式 Spec「### 输入」表（源需求「## 输入」表）：
 * {@code 限额检查结果} 按源需求原文的中文字段名照录（源需求未给出英文名），
 * {@code baseAcctNo}／{@code limitSceneNo}／{@code clientNo} 为 {@link String}，
 * {@code limitSumAmt} 为 {@link BigDecimal}，{@code limitSumNum} 为 {@link Integer}。</p>
 *
 * <p>占位符绑定：源需求步骤描述中的 {账号} 绑定到 {@code baseAcctNo}、
 * {限额场景编码} 绑定到 {@code limitSceneNo}。</p>
 */
public class ST110InputBO {

    /** 限额检查结果（必填，源需求未给出英文名，照录中文字段名） */
    private String 限额检查结果;

    /** 账号（必填，来源实体：对公存款账户限制表（RB_BUS_RESTRAINTS））；源需求步骤描述中的 {账号}，作限额检查对象值参与定位 */
    private String baseAcctNo;

    /** 限额场景编码（必填，来源实体：限额累计信息表（RB_LIMIT_SUM_INFO））；源需求步骤描述中的 {限额场景编码}，连同限额检查对象值定位记录 */
    private String limitSceneNo;

    /** 客户号（必填，来源实体：限额累计信息表（RB_LIMIT_SUM_INFO））；源需求步骤描述未使用该字段，本步骤不为其生成定位、校验或写入行为 */
    private String clientNo;

    /** 限额累计金额（必填，来源实体：限额累计信息表（RB_LIMIT_SUM_INFO））；触发条件判定项之一（大于 0），并作为写回 $累计限额$ 的取值 */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（必填，来源实体：限额累计信息表（RB_LIMIT_SUM_INFO））；触发条件判定项之一（大于 0），并作为写回 $限额累计笔数$ 的取值 */
    private Integer limitSumNum;

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

    public Integer getLimitSumNum() {
        return limitSumNum;
    }

    public void setLimitSumNum(Integer limitSumNum) {
        this.limitSumNum = limitSumNum;
    }
}
