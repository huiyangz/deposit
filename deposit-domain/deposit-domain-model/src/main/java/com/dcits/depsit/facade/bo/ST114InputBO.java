package com.dcits.depsit.facade.bo;

/**
 * ST114 检查转账止收限制 输入 BO。
 *
 * <p>输入仅含账号一个字段（REQ-001）：步骤 1 以该账号为条件查询【账户限制信息】，
 * 限制状态条件为步骤内固定常量「A-生效」，不作为入参。</p>
 */
public class ST114InputBO {

    /** 账号；步骤 1 查询【账户限制信息】的账号条件 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
