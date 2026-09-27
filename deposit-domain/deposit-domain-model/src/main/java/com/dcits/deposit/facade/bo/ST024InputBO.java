package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TailboxProperty;
import java.math.BigDecimal;

/**
 * ST024 更新现金存入后现金尾箱 输入BO
 */
public class ST024InputBO {
    /** 尾箱分配柜员号 */
    private String assignUserId;
    /** 尾箱属性 */
    private TailboxProperty tailboxProperty;
    /** 交易金额 */
    private BigDecimal tranAmt;

    public String getAssignUserId() {
        return assignUserId;
    }

    public void setAssignUserId(String assignUserId) {
        this.assignUserId = assignUserId;
    }

    public TailboxProperty getTailboxProperty() {
        return tailboxProperty;
    }

    public void setTailboxProperty(TailboxProperty tailboxProperty) {
        this.tailboxProperty = tailboxProperty;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }
}
