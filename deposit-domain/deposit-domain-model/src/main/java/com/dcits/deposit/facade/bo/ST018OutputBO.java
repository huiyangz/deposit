package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;

/**
 * ST018 检查分行法人透支额度 输出 BO。
 */
public class ST018OutputBO extends StepResult {
    /** 归属机构号（分行机构号） */
    private TranBranch branch;
    /** 总额度 */
    private BigDecimal totalLimit;
    /** 已使用额度 */
    private BigDecimal usedAmt;

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }

    public BigDecimal getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(BigDecimal totalLimit) {
        this.totalLimit = totalLimit;
    }

    public BigDecimal getUsedAmt() {
        return usedAmt;
    }

    public void setUsedAmt(BigDecimal usedAmt) {
        this.usedAmt = usedAmt;
    }
}
