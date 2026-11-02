package com.dcits.deposit.facade.bo;

/**
 * ST062 检查是否存在现金止付限制 输入。
 *
 * <p>字段来源：正式 Spec ST062「输入」表。</p>
 */
public class ST062InputBO {

    /** 账号（必填），用于查询对公存款账户限制表（RB_BUS_RESTRAINTS）的 baseAcctNo 字段 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
