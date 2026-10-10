package com.dcits.depsit.facade.bo;

import java.util.Date;

/**
 * ST002 检查账户到期日 输入 BO。
 *
 * <p>承载本步骤的全部入参：{@code baseAcctNo} 为子步骤 1 的 {@code {账号}}，用于检索【账户信息】；
 * {@code tranDate} 为子步骤 2 的 {@code {交易日期}}，与账户到期日期比较。两个字段均为必填。
 */
public class ST002InputBO {

    /** 账号：存款账户账号，子步骤 1 的 {账号} */
    private String baseAcctNo;

    /** 交易日期：交易日期时刻值，子步骤 2 的 {交易日期} */
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
