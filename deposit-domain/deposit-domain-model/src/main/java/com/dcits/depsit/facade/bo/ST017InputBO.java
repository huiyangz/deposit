package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.Ccy;

/**
 * ST017 检查币种一致性 输入 BO。
 *
 * <p>承载「## 输入」表的两个必填字段，按表行序为 {@code tranCcy}、{@code acctCcy}；
 * 两个值由调用方在同一次检查中直接提供，本步骤不查询任何实体数据。
 */
public class ST017InputBO {

    /** 交易币种，取值域为 {@link Ccy} 的 12 个成员 */
    private Ccy tranCcy;

    /** 账户币种，取值域为 {@link AcctCcy} 的 12 个成员 */
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
