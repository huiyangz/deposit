package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Ccy;

/**
 * ST017 检查币种一致性 输入 BO。
 *
 * <p>字段来自正式 Spec ST017 输入表：交易币种（tranCcy，枚举 {@link Ccy}）、账户币种
 * （acctCcy，枚举 {@link AcctCcy}），均为必填。</p>
 */
public class ST017InputBO {

    /** 交易币种（必填） */
    private Ccy tranCcy;

    /** 账户币种（必填） */
    private AcctCcy acctCcy;

    public Ccy getTranCcy() {
        return tranCcy;
    }

    public void setTranCcy(Ccy tranCcy) {
        this.tranCcy = tranCcy;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }
}
