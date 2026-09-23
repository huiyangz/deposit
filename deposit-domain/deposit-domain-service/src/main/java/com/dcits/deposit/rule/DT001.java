package com.dcits.deposit.rule;

import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * DT001 根据核准类型设置账户状态
 *
 * <p>规则类型：决策类。根据账户属性、账户用途、境内境外标志、企业标志决定账户状态。</p>
 */
public class DT001 {

    /** 账户属性：基本户 */
    private static final String ACCT_NATURE_BASIC = "基本户";
    /** 账户属性：一般户 */
    private static final String ACCT_NATURE_GENERAL = "一般户";
    /** 账户属性：专用户 */
    private static final String ACCT_NATURE_SPECIAL = "专用户";
    /** 账户属性：临时户 */
    private static final String ACCT_NATURE_TEMPORARY = "临时户";
    /** 账户属性：验资户 */
    private static final String ACCT_NATURE_CAPITAL_VERIFICATION = "验资户";

    /** 境内境外标志：境内 */
    private static final String INLAND = "境内";
    /** 企业标志：是 */
    private static final String CORPORATION_YES = "是";

    /** 账户状态：新建 */
    private static final String STATUS_NEW = "新建";
    /** 账户状态：预开户 */
    private static final String STATUS_PRE_OPEN = "预开户";
    /** 账户状态：无 */
    private static final String STATUS_NONE = "无";

    /**
     * 根据核准类型设置账户状态
     *
     * @param rbBusAcctPurpose 对公存款账户用途
     * @param acctNatureNo     账户属性编号
     * @param corporationFlag  企业标志
     * @param inlandOffshore   境内境外标志
     * @return acctStatus 账户状态
     */
    public static String execute(RbBusAcctPurpose rbBusAcctPurpose, String acctNatureNo,
                                 String corporationFlag, String inlandOffshore) {
        // SPEC 6：否则，返回“新建”（决策表默认行）
        String acctStatus = STATUS_NEW;

        if (ACCT_NATURE_BASIC.equals(acctNatureNo)) {
            if (INLAND.equals(inlandOffshore)) {
                // SPEC 1.a 境内+是→新建；SPEC 1.b 境内+否→预开户
                acctStatus = CORPORATION_YES.equals(corporationFlag) ? STATUS_NEW : STATUS_PRE_OPEN;
            } else {
                // SPEC 1.c 境外+是→预开户；SPEC 1.d 境外+否→新建
                acctStatus = CORPORATION_YES.equals(corporationFlag) ? STATUS_PRE_OPEN : STATUS_NEW;
            }
        } else if (ACCT_NATURE_GENERAL.equals(acctNatureNo)) {
            // SPEC 2：一般户→新建
            acctStatus = STATUS_NEW;
        } else if (ACCT_NATURE_SPECIAL.equals(acctNatureNo)) {
            if (RbBusAcctPurpose.VALUE_4 == rbBusAcctPurpose) {
                // 账户用途为“预算单位专用存款户”
                if (INLAND.equals(inlandOffshore)) {
                    // SPEC 3.1.a 境内+是→无；SPEC 3.1.b 境内+否→预开户
                    acctStatus = CORPORATION_YES.equals(corporationFlag) ? STATUS_NONE : STATUS_PRE_OPEN;
                } else {
                    // SPEC 3.1.c 境外+是→无；SPEC 3.1.d 境外+否→新建
                    acctStatus = CORPORATION_YES.equals(corporationFlag) ? STATUS_NONE : STATUS_NEW;
                }
            } else if (RbBusAcctPurpose.VALUE_3 == rbBusAcctPurpose) {
                // SPEC 3.2：账户用途为“非预算单位专用存款户”→新建
                acctStatus = STATUS_NEW;
            }
            // 账户用途为其他取值时未被 SPEC 3 命名，保持决策表默认行结果（SPEC 6）
        } else if (ACCT_NATURE_TEMPORARY.equals(acctNatureNo)) {
            if (INLAND.equals(inlandOffshore)) {
                // SPEC 4.a 境内+是→新建；SPEC 4.b 境内+否→预开户
                acctStatus = CORPORATION_YES.equals(corporationFlag) ? STATUS_NEW : STATUS_PRE_OPEN;
            } else {
                // SPEC 4.c 境外+是→无；SPEC 4.d 境外+否→新建
                acctStatus = CORPORATION_YES.equals(corporationFlag) ? STATUS_NONE : STATUS_NEW;
            }
        } else if (ACCT_NATURE_CAPITAL_VERIFICATION.equals(acctNatureNo)) {
            if (INLAND.equals(inlandOffshore)) {
                // SPEC 5.a 境内+是→新建；SPEC 5.b 境内+否→新建
                acctStatus = STATUS_NEW;
            } else {
                // SPEC 5.c 境外+是→无；SPEC 5.d 境外+否→新建
                acctStatus = CORPORATION_YES.equals(corporationFlag) ? STATUS_NONE : STATUS_NEW;
            }
        }

        return acctStatus;
    }
}
