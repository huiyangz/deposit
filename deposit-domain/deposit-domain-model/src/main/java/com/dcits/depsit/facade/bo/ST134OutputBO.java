package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST134 解限更新账户冻结金额 —— 输出 BO。
 *
 * <p>继承项目既有步骤结果契约 {@link StepResult}，不重复声明
 * {@code succeed}/{@code errorCode}/{@code errorMessage}。</p>
 *
 * <p>按 Spec「### 输出」表，本步骤只有 1 个业务输出：{@code pldAmount}
 * （冻结金额，非必填，来源实体 对公存款账户余额表（RB_BUS_ACCT_BALANCE））；
 * 成功路径下其取值为本次写入的冻结金额 0。</p>
 */
public class ST134OutputBO extends StepResult {

    /** 冻结金额（非必填）；成功路径下为本次写入的 0 */
    private BigDecimal pldAmount;

    public BigDecimal getPldAmount() {
        return pldAmount;
    }

    public void setPldAmount(BigDecimal pldAmount) {
        this.pldAmount = pldAmount;
    }
}
