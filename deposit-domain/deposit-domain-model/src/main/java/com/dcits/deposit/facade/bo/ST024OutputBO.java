package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import java.math.BigDecimal;

/**
 * ST024 更新现金存入后现金尾箱 输出BO
 */
public class ST024OutputBO extends StepResult {
    /** 更新后的尾箱现金余额（[尾箱余额]） */
    private BigDecimal tailboxBalance;
    /** 子步骤1查询获得的尾箱编号（[尾箱编号]） */
    private String tailboxId;

    public BigDecimal getTailboxBalance() {
        return tailboxBalance;
    }

    public void setTailboxBalance(BigDecimal tailboxBalance) {
        this.tailboxBalance = tailboxBalance;
    }

    public String getTailboxId() {
        return tailboxId;
    }

    public void setTailboxId(String tailboxId) {
        this.tailboxId = tailboxId;
    }
}
