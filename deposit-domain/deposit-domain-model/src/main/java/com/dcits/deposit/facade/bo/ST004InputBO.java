package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TranBranch;

/**
 * ST004 检查账户通兑信息 输入。
 *
 * <p>字段来自 Spec「输入」表：{@code baseAcctNo}（账号，必填）、{@code tranBranch}（交易机构号，必填）。
 */
public class ST004InputBO {

    /** 账号（必填） */
    private String baseAcctNo;

    /** 交易机构号（必填） */
    private TranBranch tranBranch;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }
}
