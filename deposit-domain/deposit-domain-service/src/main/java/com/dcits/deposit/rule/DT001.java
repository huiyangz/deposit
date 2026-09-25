package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * 规则 DT001：根据核准类型设置账户状态。
 *
 * <p>依据账户属性、对公存款账户用途、境内境外标志、企业标志决策账户状态：
 * “新建”对应 {@link AcctStatus#N}，“预开户”对应 {@link AcctStatus#I}，“无”表示不设置、返回空。</p>
 */
public class DT001 {

    /**
     * 根据核准类型设置账户状态。
     *
     * @param rbBusAcctPurpose 对公存款账户用途（非必填，仅专用户分支判断“预算单位专用存款户”）
     * @param acctNatureNo     账户属性（必填：基本户/一般户/专用户/临时户/验资户等）
     * @param corporationFlag  企业标志（必填：“是”/“否”）
     * @param inlandOffshore   境内境外标志（必填：“境内”/“境外”）
     * @return 账户状态：“新建”返回 {@link AcctStatus#N}，“预开户”返回 {@link AcctStatus#I}，“无”返回 null
     */
    public static AcctStatus execute(RbBusAcctPurpose rbBusAcctPurpose, AcctNatureNo acctNatureNo,
                                     String corporationFlag, String inlandOffshore) {
        boolean corporation = "是".equals(corporationFlag);
        boolean inland = "境内".equals(inlandOffshore);

        if (acctNatureNo == AcctNatureNo.VALUE_11001) {
            // 1. 基本户
            if (inland) {
                // 1a. 境内+是 → 新建；1b. 境内+否 → 预开户
                return corporation ? AcctStatus.N : AcctStatus.I;
            }
            // 1c. 境外+是 → 预开户；1d. 境外+否 → 新建
            return corporation ? AcctStatus.I : AcctStatus.N;
        }
        if (acctNatureNo == AcctNatureNo.VALUE_11002) {
            // 2. 一般户 → 新建
            return AcctStatus.N;
        }
        if (acctNatureNo == AcctNatureNo.VALUE_11004) {
            if (rbBusAcctPurpose == RbBusAcctPurpose.VALUE_4) {
                // 3. 专用户 + 3.1 预算单位专用存款户
                if (inland) {
                    // 3.1a. 境内+是 → 无；3.1b. 境内+否 → 预开户
                    return corporation ? null : AcctStatus.I;
                }
                // 3.1c. 境外+是 → 无；3.1d. 境外+否 → 新建
                return corporation ? null : AcctStatus.N;
            }
            // 3.2. 非预算单位专用存款户或其他取值（含为空）→ 新建
            return AcctStatus.N;
        }
        if (acctNatureNo == AcctNatureNo.VALUE_11003) {
            // 4. 临时户
            if (inland) {
                // 4a. 境内+是 → 新建；4b. 境内+否 → 预开户
                return corporation ? AcctStatus.N : AcctStatus.I;
            }
            // 4c. 境外+是 → 无；4d. 境外+否 → 新建
            return corporation ? null : AcctStatus.N;
        }
        if (acctNatureNo == AcctNatureNo.VALUE_17) {
            // 5. 验资户
            if (inland) {
                // 5a. 境内+是 → 新建；5b. 境内+否 → 新建
                return AcctStatus.N;
            }
            // 5c. 境外+是 → 无；5d. 境外+否 → 新建
            return corporation ? null : AcctStatus.N;
        }
        // 6. 否则 → 新建
        return AcctStatus.N;
    }
}
