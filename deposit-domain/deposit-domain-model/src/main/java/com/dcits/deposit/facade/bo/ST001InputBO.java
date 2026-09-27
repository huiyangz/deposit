package com.dcits.deposit.facade.bo;

import java.util.Date;

/**
 * ST001 检查账户到期日 输入BO
 */
public class ST001InputBO {

    /** 账号 */
    private String baseAcctNo;

    /** 交易日期 */
    private Date tranDate;

    /** 账号 */
    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    /** 账号 */
    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    /** 交易日期 */
    public Date getTranDate() {
        return tranDate;
    }

    /** 交易日期 */
    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
}
