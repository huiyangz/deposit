package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.TranBranch;

/**
 * ST018 检查分行法人透支额度 输入 BO。
 */
public class ST018InputBO {
    /** 交易机构号 */
    private TranBranch tranBranch;

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }
}
