package com.dcits.depsit.rule;

import com.dcits.depsit.enums.AcctStatus;

/**
 * DT001 检查账户是否能够出账（决策类）。
 *
 * <p>以 [账户状态] 与 [账户转账止付标志]、[账户转账不收不付标志] 的取值组合为判据，返回 [出账标志]，
 * 取值语义为“允许”或“不允许”。判定域内任意组合均由「## 规则描述」a1–g 或兜底 h 给出结果。</p>
 *
 * <p>本规则为纯业务规则：不访问 BCC、Mapper、数据库、外部接口或业务 Service，不产生业务副作用。</p>
 */
public final class DT001 {

    /** [账户转账止付标志]、[账户转账不收不付标志] 的“是”语义取值 */
    private static final String FLAG_YES = "是";

    /** [账户转账止付标志]、[账户转账不收不付标志] 的“否”语义取值 */
    private static final String FLAG_NO = "否";

    /** [出账标志]：允许 */
    private static final String DEBIT_FLAG_ALLOWED = "允许";

    /** [出账标志]：不允许 */
    private static final String DEBIT_FLAG_NOT_ALLOWED = "不允许";

    private DT001() {
    }

    /**
     * 执行出账判定。
     *
     * @param acctStatus                账户状态，取值绑定 {@link AcctStatus}
     * @param acctTranStopPayFlag       账户转账止付标志，语义取值“是”/“否”
     * @param acctTranNoCreditNoDebitFlag 账户转账不收不付标志，语义取值“是”/“否”
     * @return [出账标志]，“允许”或“不允许”
     */
    public static String execute(AcctStatus acctStatus, String acctTranStopPayFlag,
            String acctTranNoCreditNoDebitFlag) {
        boolean stopPay = FLAG_YES.equals(acctTranStopPayFlag);
        boolean stopPayNo = FLAG_NO.equals(acctTranStopPayFlag);
        boolean noCreditNoDebit = FLAG_YES.equals(acctTranNoCreditNoDebitFlag);
        boolean noCreditNoDebitNo = FLAG_NO.equals(acctTranNoCreditNoDebitFlag);

        // 分支 a1：新建 且 止付标志为“否” 且 不收不付标志为“否” → 允许
        if (AcctStatus.N == acctStatus && stopPayNo && noCreditNoDebitNo) {
            return DEBIT_FLAG_ALLOWED;
        }
        // 分支 a2：新建 且 止付标志为“是” → 不允许（不对不收不付标志设条件）
        if (AcctStatus.N == acctStatus && stopPay) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        // 分支 a3：新建 且 不收不付标志为“是” → 不允许
        if (AcctStatus.N == acctStatus && noCreditNoDebit) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        // 分支 c：待激活 且 止付标志为“是” 且 不收不付标志为“否” → 不允许
        if (AcctStatus.H == acctStatus && stopPay && noCreditNoDebitNo) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        //FIXME 规则:检查账户是否能够出账 - 问题大类:业务 - 问题分类:枚举依赖缺失 - 严重程度:错误 - 问题描述:分支 d 的状态取值“正常”在 com.dcits.depsit.enums.AcctStatus 中无同名成员或同名注释成员，映射未定，无法以 acctStatus 表达该条件，本规则在 AcctStatus 取值域内无法实现分支 d - 修改建议（参考）：需求方补充“正常”对应的 AcctStatus 成员后，在此处补出“两个标志均为‘否’ → 允许”的分支
        // 分支 e：久悬 且 不收不付标志为“是” → 不允许（不对止付标志设条件）
        if (AcctStatus.S == acctStatus && noCreditNoDebit) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        // 分支 f：转营业外 且 不收不付标志为“是” → 不允许（不对止付标志设条件）
        if (AcctStatus.O == acctStatus && noCreditNoDebit) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        //FIXME 规则:检查账户是否能够出账 - 问题大类:业务 - 问题分类:枚举依赖缺失 - 严重程度:错误 - 问题描述:分支 g 的状态取值“销户”在 com.dcits.depsit.enums.AcctStatus 中无同名成员或同名注释成员，映射未定，无法以 acctStatus 表达该条件，本规则在 AcctStatus 取值域内无法实现分支 g - 修改建议（参考）：需求方补充“销户”对应的 AcctStatus 成员后，在此处补出“账户状态为‘销户’ → 不允许”的分支
        // 分支 h：未命中 a1、a2、a3、c、d、e、f、g 的账户状态与标志组合一律不允许
        return DEBIT_FLAG_NOT_ALLOWED;
    }
}
