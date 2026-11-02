package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST012 检查账户余额 步骤输入。
 *
 * <p>字段来自正式 Spec ST012「输入」表，均必填。</p>
 */
public class ST012InputBO {

    /** 账号 */
    private String baseAcctNo;

    /** 交易金额 */
    private BigDecimal tranAmt;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }
}
