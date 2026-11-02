package com.dcits.deposit.facade.bo;

import java.util.Date;

/**
 * ST002 检查账户到期日 输入 BO。
 *
 * <p>字段来自正式 Spec ST002 输入表：账号（baseAcctNo）、交易日期（tranDate），均为必填。</p>
 */
public class ST002InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    /** 交易日期（必填） */
    private Date tranDate;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
}
