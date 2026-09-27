package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST012 更新存入后账户余额 输入BO
 */
public class ST012InputBO {
    /**账号*/
    private String baseAcctNo;
    /**交易金额*/
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
