package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import java.math.BigDecimal;

/**
 * ST106 获取累计限额 输出 BO。
 *
 * <p>继承项目公共步骤结果载体 {@link StepResult}；字段名、类型、业务名称与「非必填」标记照录
 * Spec「### 输出」表，四个字段的来源实体均为 限额累计信息表（RB_LIMIT_SUM_INFO）。不新增
 * 「## 输出」表以外的业务输出字段，也不重复声明 {@code succeed}／{@code errorCode}／{@code errorMessage}。</p>
 *
 * <p>取值映射：命中记录时 {@code limitSumAmt}／{@code limitSumNum} 为该记录的 $限额累计金额$／
 * $限额累计笔数$（REQ-002）；查无记录时均为数值 0（REQ-003）。{@code clientNo}／{@code limitSceneNo}
 * 两个字段的取值口径源需求未定义，本步骤不作规定（Spec 不覆盖第 1 项）。</p>
 */
public class ST106OutputBO extends StepResult {

    /** 客户号（非必填；来源实体：限额累计信息表 RB_LIMIT_SUM_INFO） */
    private String clientNo;

    /** 限额场景编码（非必填；来源实体：限额累计信息表 RB_LIMIT_SUM_INFO） */
    private String limitSceneNo;

    /** 限额累计金额（非必填；命中记录时为该记录的限额累计金额，查无记录时为 0） */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（非必填；命中记录时为该记录的限额累计笔数，查无记录时为 0） */
    private Integer limitSumNum;

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

    public Integer getLimitSumNum() {
        return limitSumNum;
    }

    public void setLimitSumNum(Integer limitSumNum) {
        this.limitSumNum = limitSumNum;
    }
}
