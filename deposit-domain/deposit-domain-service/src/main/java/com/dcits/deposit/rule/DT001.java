package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctStatus;

/**
 * DT001 检查账户是否能够出账（决策类）。
 *
 * <p>依据 [账户状态]、[账户转账止付标志]、[账户转账不收不付标志] 判定并返回 [出账标志]（"允许"/"不允许"）。
 * 规则描述条目 a–g 定义"新建、待激活、活动、久悬、转营业外、关闭"六种账户状态下的 7 条判定分支；
 * 条目 a–g 未列出的合法输入组合无已定义的判定结果，本规则不为其编造出账标志。</p>
 *
 * <p>本规则为纯业务规则：不访问 BCC、Mapper、数据库、外部接口或业务 Service，不产生业务副作用。</p>
 */
public final class DT001 {

    /** [账户转账止付标志]、[账户转账不收不付标志] 的"是"语义取值 */
    private static final String FLAG_YES = "是";

    /** [账户转账止付标志]、[账户转账不收不付标志] 的"否"语义取值 */
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
     * @param acctStatus 账户状态，取值绑定 {@link AcctStatus}
     * @param acctTranStopPayFlag 账户转账止付标志，取值为"是"或"否"
     * @param acctTranStopBothFlag 账户转账不收不付标志，取值为"是"或"否"
     * @return [出账标志]，"允许"或"不允许"；条目 a–g 未定义的输入组合返回 null
     */
    public static String execute(AcctStatus acctStatus, String acctTranStopPayFlag,
            String acctTranStopBothFlag) {
        // 条目 a：新建 且 两标志均为"否" → 允许
        if (acctStatus == AcctStatus.N && FLAG_NO.equals(acctTranStopPayFlag)
                && FLAG_NO.equals(acctTranStopBothFlag)) {
            return DEBIT_FLAG_ALLOWED;
        }
        // 条目 b：新建 且 止付标志为"是" 且 不收不付标志为"否" → 不允许
        if (acctStatus == AcctStatus.N && FLAG_YES.equals(acctTranStopPayFlag)
                && FLAG_NO.equals(acctTranStopBothFlag)) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        // 条目 c：待激活 且 止付标志为"是" 且 不收不付标志为"否" → 不允许
        if (acctStatus == AcctStatus.H && FLAG_YES.equals(acctTranStopPayFlag)
                && FLAG_NO.equals(acctTranStopBothFlag)) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        // 条目 d：活动 且 两标志均为"否" → 允许
        if (acctStatus == AcctStatus.A && FLAG_NO.equals(acctTranStopPayFlag)
                && FLAG_NO.equals(acctTranStopBothFlag)) {
            return DEBIT_FLAG_ALLOWED;
        }
        // 条目 e：久悬 且 不收不付标志为"是" → 不允许
        if (acctStatus == AcctStatus.S && FLAG_YES.equals(acctTranStopBothFlag)) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        // 条目 f：转营业外 且 不收不付标志为"是" → 不允许
        if (acctStatus == AcctStatus.O && FLAG_YES.equals(acctTranStopBothFlag)) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
        // 条目 g：关闭 → 不允许
        if (acctStatus == AcctStatus.C) {
            return DEBIT_FLAG_NOT_ALLOWED;
        }
                                                                                                                                                                                                                                                 
        return null;
    }
}
