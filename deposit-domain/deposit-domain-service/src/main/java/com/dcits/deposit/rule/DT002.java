package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctStatus;

/** 决策类规则 DT002：检查账户是否能够入账。 */
public class DT002 {

    /** 入账标志：允许 */
    private static final String ALLOW = "允许";
    /** 入账标志：不允许 */
    private static final String NOT_ALLOW = "不允许";
    /** 标志取值：是 */
    private static final String FLAG_YES = "是";
    /** 标志取值：否 */
    private static final String FLAG_NO = "否";

    public static String execute(AcctStatus acctStatus, String tranStopPayFlag, String tranNoDepositNoPayFlag) {
        // 规则 a、b：账户状态为「新建」允许入账，不受两标志取值影响
        if (acctStatus == AcctStatus.N) {
            return ALLOW;
        }
        // 规则 c：账户状态为「待激活」且止付标志=是、不收不付标志=否
        if (acctStatus == AcctStatus.H
                && FLAG_YES.equals(tranStopPayFlag)
                && FLAG_NO.equals(tranNoDepositNoPayFlag)) {
            return ALLOW;
        }
        // 规则 d：账户状态为「活动」且止付标志=否、不收不付标志=否
        if (acctStatus == AcctStatus.A
                && FLAG_NO.equals(tranStopPayFlag)
                && FLAG_NO.equals(tranNoDepositNoPayFlag)) {
            return ALLOW;
        }
        // 规则 e、f、g：其余情形不允许入账
        return NOT_ALLOW;
    }
}
