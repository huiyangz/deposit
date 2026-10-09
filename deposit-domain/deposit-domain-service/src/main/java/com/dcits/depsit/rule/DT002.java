package com.dcits.depsit.rule;

import com.dcits.depsit.enums.AcctStatus;

/**
 * DT002 检查账户是否能够入账（决策类规则）。
 *
 * 依据账户状态与两个账户标志，按「规则描述 a–f」给定的条件与优先级判定并返回入账标志：
 * 命中分支 a、b、c 返回「允许」，命中分支 d、e 或不匹配任一分支（默认分支 f）返回「不允许」。
 *
 * 规则为无状态纯业务逻辑，不校验账户是否存在、不查询或加载账户数据、不修改账户状态与标志，
 * 不访问 BCC、Mapper、数据库、外部接口或业务 Service，不返回错误码、不抛出异常。
 */
public class DT002 {

    /** 入账标志取值“允许”。 */
    private static final String PERMITTED = "允许";

    /** 入账标志取值“不允许”。 */
    private static final String NOT_PERMITTED = "不允许";

    /** 标志取值“Y-是”。 */
    private static final String YES = "Y";

    /** 标志取值“N-否”。 */
    private static final String NO = "N";

    /**
     * 执行账户是否能够入账判定。
     *
     * @param acctStatus            账户状态，必填，取 {@link AcctStatus} 枚举常量
     * @param acctTranStopPayFlag   账户转账止付标志，必填，取值 "Y"-是、"N"-否
     * @param acctTranNoRecvNoPayFlag 账户转账不收不付标志，必填，取值 "Y"-是、"N"-否
     * @return 入账标志：{@code "允许"} 或 {@code "不允许"}
     */
    public static String execute(AcctStatus acctStatus,
                                 String acctTranStopPayFlag,
                                 String acctTranNoRecvNoPayFlag) {
        // 分支 a：账户状态为“新建”，返回允许；该分支条件仅由账户状态决定，不受两个标志取值影响。
        if (acctStatus == AcctStatus.N) {
            return PERMITTED;
        }
        // 分支 b：账户状态为“待激活”且止付为“是”且不收不付为“否”，三条件同时成立，返回允许。
        if (acctStatus == AcctStatus.H
                && YES.equals(acctTranStopPayFlag)
                && NO.equals(acctTranNoRecvNoPayFlag)) {
            return PERMITTED;
        }
        // 分支 c：账户状态为“活动”且止付为“否”且不收不付为“否”，三条件同时成立，返回允许。
        if (acctStatus == AcctStatus.A
                && NO.equals(acctTranStopPayFlag)
                && NO.equals(acctTranNoRecvNoPayFlag)) {
            return PERMITTED;
        }
        // 分支 d：账户状态为“久悬”且不收不付为“否”，返回不允许。
        if (acctStatus == AcctStatus.S && NO.equals(acctTranNoRecvNoPayFlag)) {
            return NOT_PERMITTED;
        }
        // 分支 e：账户状态为“转营业外”且不收不付为“否”，返回不允许。
        if (acctStatus == AcctStatus.O && NO.equals(acctTranNoRecvNoPayFlag)) {
            return NOT_PERMITTED;
        }
        // 分支 f：不满足分支 a–e 中任一条件的其余合法取值组合（含久悬/转营业外且不收不付为“是”），返回不允许。
        return NOT_PERMITTED;
    }
}
