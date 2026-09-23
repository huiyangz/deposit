package com.dcits.deposit.rule;

import com.dcits.deposit.enums.TranBranch;

/**
 * BR004 检查交易机构和基本户开户机构互斥性
 *
 * 若交易机构等于账户开立行行号且账户属性为“11002-一般存款账户”，执行结果为“不通过”；否则执行结果为“通过”。
 */
public class BR004 {

    /** 账户属性编号：11002-一般存款账户 */
    private static final String ACCT_NATURE_NO_GENERAL_DEPOSIT = "11002";

    /**
     * 检查交易机构和基本户开户机构互斥性
     *
     * @param tranBranch 交易机构号
     * @param acctNatureNo 账户属性编号
     * @param acctBranch 账户开立行行号
     * @return true-通过；false-不通过
     */
    public static boolean execute(TranBranch tranBranch, String acctNatureNo, TranBranch acctBranch) {
        boolean sameBranch = tranBranch == acctBranch;
        boolean generalDepositAcct = ACCT_NATURE_NO_GENERAL_DEPOSIT.equals(acctNatureNo);
        return !(sameBranch && generalDepositAcct);
    }
}
