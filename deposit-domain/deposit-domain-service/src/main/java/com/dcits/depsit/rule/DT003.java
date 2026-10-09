package com.dcits.depsit.rule;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.RbBusAcctPurpose;

/**
 * DT003 根据核准类型设置账户状态（决策类规则）。
 *
 * <p>开户建档场景下，以 [账户属性]、[对公存款账户用途]、[境内境外标志]、[企业标志] 的取值组合为判据，
 * 返回 [账户状态]（落库位 RB_BUS_ACCT.ACCT_STATUS）。判定按账户属性分为基本户、一般户、专用户、临时户、
 * 验资户五组，组间按账户属性互斥，不存在执行先后或优先级；账户属性不属这五类时走兜底分支（REQ-007）。
 * 专用户组内先按 [对公存款账户用途] 是否为"预算单位专用存款户"（{@link RbBusAcctPurpose#VALUE_4}）分流。</p>
 *
 * <p>输出 [账户状态] 非必填：REQ-003 的两个"不设置账户状态"分支以 {@code null} 表达该情形。
 * REQ-005-S03 与 REQ-006-S03 的源需求取值"无"不是 {@link AcctStatus} 的合法成员、取值待业务确认，
 * 这两个分支以 {@code null} 占位并在实现处标注 FIXME，见其注释。</p>
 *
 * <p>本规则为无状态纯业务逻辑，不访问 BCC、Mapper、数据库或外部接口，不注册或注入 Spring Bean，
 * 不查询或写回账户数据，不返回错误码、不声明或抛出异常。</p>
 */
public final class DT003 {

    /** [境内境外标志] 的"境内"语义取值 */
    private static final String INLAND = "境内";

    /** [企业标志] 的"是"语义取值 */
    private static final String CORPORATION_YES = "是";

    private DT003() {
    }

    /**
     * 执行账户状态判定。
     *
     * @param acctNatureNo    账户属性，必填，取 {@link AcctNatureNo} 枚举常量
     * @param rbBusAcctPurpose 对公存款账户用途，非必填，取 {@link RbBusAcctPurpose} 枚举常量，允许为空
     * @param corporationFlag 企业标志，必填，语义取值"是"/"否"
     * @param inlandOffshore  境内境外标志，必填，语义取值"境内"/"境外"
     * @return [账户状态]，取值 {@link AcctStatus#N}（新建）或 {@link AcctStatus#I}（预开户）；
     *         对应分支不设置账户状态时返回 {@code null}
     */
    public static String execute(AcctNatureNo acctNatureNo, RbBusAcctPurpose rbBusAcctPurpose,
            String corporationFlag, String inlandOffshore) {
        boolean inland = INLAND.equals(inlandOffshore);
        boolean corporation = CORPORATION_YES.equals(corporationFlag);

        // REQ-001 账户属性为"基本户"：按境内境外标志与企业标志的组合取值，不受对公存款账户用途影响。
        if (AcctNatureNo.VALUE_11001 == acctNatureNo) {
            if (inland) {
                // 1a 境内且企业标志为"是" → 新建；1b 境内且企业标志为"否" → 预开户。
                return corporation ? AcctStatus.N.getValue() : AcctStatus.I.getValue();
            }
            // 1c 境外且企业标志为"是" → 预开户；1d 境外且企业标志为"否" → 新建。
            return corporation ? AcctStatus.I.getValue() : AcctStatus.N.getValue();
        }

        // REQ-002 账户属性为"一般户"：无条件取"新建"，不受其它三项入参影响。
        if (AcctNatureNo.VALUE_11002 == acctNatureNo) {
            return AcctStatus.N.getValue();
        }

        // REQ-003 / REQ-004 账户属性为"专用户"：先按对公存款账户用途是否为"预算单位专用存款户"分流。
        if (AcctNatureNo.VALUE_11004 == acctNatureNo) {
            if (RbBusAcctPurpose.VALUE_4 == rbBusAcctPurpose) {
                if (inland) {
                    // 3.1a 境内且企业标志为"是" → 不设置账户状态；3.1b 境内且企业标志为"否" → 预开户。
                    return corporation ? null : AcctStatus.I.getValue();
                }
                // 3.1c 境外且企业标志为"是" → 不设置账户状态；3.1d 境外且企业标志为"否" → 新建。
                return corporation ? null : AcctStatus.N.getValue();
            }
            // 3.2 用途不为"预算单位专用存款户"（含其它枚举取值及为空）→ 新建，不受其余入参影响。
            return AcctStatus.N.getValue();
        }

        // REQ-005 账户属性为"临时户"。
        if (AcctNatureNo.VALUE_11003 == acctNatureNo) {
            if (inland) {
                // 4a 境内且企业标志为"是" → 新建；4b 境内且企业标志为"否" → 预开户。
                return corporation ? AcctStatus.N.getValue() : AcctStatus.I.getValue();
            }
            if (corporation) {
                //FIXME 规则:根据核准类型设置账户状态 - 问题大类:业务 - 问题分类:缺少必要输出取值 - 严重程度:错误 - 问题描述:REQ-005-S03（临时户、境外、企业标志为"是"）源需求要求账户状态为"无"，"无"不是 com.dcits.depsit.enums.AcctStatus 的合法成员（合法成员为 A/C/D/H/I/N/O/P/R/S/U），应返回的确切取值无法由正式需求唯一确定，本分支在业务确认取值前不可执行；此处以"不设置账户状态"（null）占位仅为使方法可编译，不代表已采纳需求处理记录中的候选方案 A（留空）或 B（新建） - 修改建议（参考）：需求方确认"无"对应的账户状态取值后，在此处补出该分支的返回值并同步修订 REQ-005
                return null;
            }
            // 4d 境外且企业标志为"否" → 新建。
            return AcctStatus.N.getValue();
        }

        // REQ-006 账户属性为"验资户"。
        if (AcctNatureNo.VALUE_17 == acctNatureNo) {
            if (!inland && corporation) {
                //FIXME 规则:根据核准类型设置账户状态 - 问题大类:业务 - 问题分类:缺少必要输出取值 - 严重程度:错误 - 问题描述:REQ-006-S03（验资户、境外、企业标志为"是"）源需求要求账户状态为"无"，"无"不是 com.dcits.depsit.enums.AcctStatus 的合法成员（合法成员为 A/C/D/H/I/N/O/P/R/S/U），应返回的确切取值无法由正式需求唯一确定，本分支在业务确认取值前不可执行；此处以"不设置账户状态"（null）占位仅为使方法可编译，不代表已采纳需求处理记录中的候选方案 A（留空）或 B（新建） - 修改建议（参考）：需求方确认"无"对应的账户状态取值后，在此处补出该分支的返回值并同步修订 REQ-006
                return null;
            }
            // 5a 境内且企业标志为"是"、5b 境内且企业标志为"否"、5d 境外且企业标志为"否" → 新建。
            return AcctStatus.N.getValue();
        }

        // REQ-007 兜底：账户属性不为上述五类时一律取"新建"，不受其余三项入参影响。
        return AcctStatus.N.getValue();
    }
}
