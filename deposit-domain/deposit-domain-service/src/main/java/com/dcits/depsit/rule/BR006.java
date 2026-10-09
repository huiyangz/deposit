package com.dcits.depsit.rule;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.TranBranch;

/**
 * BR006 检查交易机构和基本户开户机构互斥性（断言类规则）。
 *
 * <p>交易机构（{@code tranBranch}）与基本存款账户开户行行号（{@code acctBranch}）为同一机构，
 * 且账户属性（{@code acctNatureNo}）为"11002-一般存款账户"时判定为不通过；其余合法取值组合判定为通过。
 * 判定结论以布尔返回值表达：通过返回 {@code true}，不通过返回 {@code false}。</p>
 *
 * <p>本规则为无状态纯业务逻辑，不访问实体、数据库或外部接口。</p>
 */
public class BR006 {

    private BR006() {
    }

    /**
     * 执行 BR006 互斥性判定。
     *
     * @param tranBranch   交易机构号（内部机构编号）
     * @param acctNatureNo 账户属性
     * @param acctBranch   基本存款账户开户行行号（内部机构编号）
     * @return 通过返回 {@code true}，不通过返回 {@code false}
     */
    public static boolean execute(TranBranch tranBranch, AcctNatureNo acctNatureNo, TranBranch acctBranch) {
        // 互斥条件：交易机构与基本存款账户开户行行号为同一机构
        boolean sameBranch = tranBranch == acctBranch;
        // 互斥条件：账户属性为"11002-一般存款账户"
        boolean generalDepositAcct = acctNatureNo == AcctNatureNo.VALUE_11002;
        // 同时命中互斥条件则不通过，否则通过
        return !(sameBranch && generalDepositAcct);
    }
}
