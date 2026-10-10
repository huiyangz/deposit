package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import java.math.BigDecimal;

/**
 * ST110 更新累计限额的步骤输出。
 *
 * <p>继承项目公共步骤结果载体 {@link StepResult}（{@code succeed}／{@code errorCode}／{@code errorMessage}），
 * 不重复声明这三个保留字段。</p>
 *
 * <p>业务字段照录正式 Spec「### 输出」表：{@code limitSumAmt}（{@link BigDecimal}，非必填，
 * 限额累计金额，来源实体 限额累计信息表（RB_LIMIT_SUM_INFO））。
 * 触发更新并命中记录时，取值为本次写入的限额累计金额；未触发更新或匹配不到记录时的取值源需求未定义。</p>
 */
public class ST110OutputBO extends StepResult {

    /** 限额累计金额（非必填，来源实体：限额累计信息表（RB_LIMIT_SUM_INFO）） */
    private BigDecimal limitSumAmt;

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }
}
