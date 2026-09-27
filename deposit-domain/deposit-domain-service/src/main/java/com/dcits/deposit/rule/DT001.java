package com.dcits.deposit.rule;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * DT001 根据核准类型设置账户状态
 *
 * <p>规则类型：决策类
 *
 * <p>按账户属性分流，结合境内境外标志、企业标志（专用户还需对公存款账户用途）决定账户状态：
 * 1.基本户：境内+是→新建，境内+否→预开户，境外+是→预开户，境外+否→新建；
 * 2.一般户：新建；
 * 3.专用户（专用存款账户）：
 * 3.1.预算单位专用存款户：境内+是→空值（null），境内+否→预开户，境外+是→空值（null），境外+否→新建；
 * 3.2.非预算单位专用存款户：新建；
 * 3.3.否则（含用途为空值）：新建；
 * 4.临时户：境内+是→新建，境内+否→预开户，境外+是→空值（null），境外+否→新建；
 * 5.验资户：境内+是→新建，境内+否→新建，境外+是→空值（null），境外+否→新建；
 * 6.其他账户属性：新建。
 */
public class DT001 {

    /**
     * 根据核准类型设置账户状态。
     *
     * @param rbBusAcctPurpose 对公存款账户用途，非必填，仅账户属性为专用存款账户时参与判断
     * @param acctNatureNo 账户属性，必填
     * @param corporationFlag 企业标志，取值 是/否，必填
     * @param inlandOffshore 境内境外标志，取值 境内/境外，必填
     * @return 账户状态；预算单位专用存款户（境内或境外）且企业标志为是、临时户/验资户境外且企业标志为是时，返回空值（null）
     */
    public static AcctStatus execute(RbBusAcctPurpose rbBusAcctPurpose, AcctNatureNo acctNatureNo,
            String corporationFlag, String inlandOffshore) {
        // 规则1：账户属性为基本户（基本存款账户）
        if (AcctNatureNo.VALUE_11001 == acctNatureNo) {
            // 1.a 境内+企业标志是 → 新建
            if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return AcctStatus.N;
            }
            // 1.b 境内+企业标志否 → 预开户
            if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return AcctStatus.I;
            }
            // 1.c 境外+企业标志是 → 预开户
            if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return AcctStatus.I;
            }
            // 1.d 境外+企业标志否 → 新建
            if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return AcctStatus.N;
            }
        }
        // 规则2：账户属性为一般户（一般存款账户）→ 新建
        if (AcctNatureNo.VALUE_11002 == acctNatureNo) {
            return AcctStatus.N;
        }
        // 规则3：账户属性为专用户（专用存款账户）
        if (AcctNatureNo.VALUE_11004 == acctNatureNo) {
            // 3.1 对公存款账户用途为预算单位专用存款户
            if (RbBusAcctPurpose.VALUE_4 == rbBusAcctPurpose) {
                // 3.1.a 境内+企业标志是 → 空值（null）
                if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                    return null;
                }
                // 3.1.b 境内+企业标志否 → 预开户
                if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                    return AcctStatus.I;
                }
                // 3.1.c 境外+企业标志是 → 空值（null）
                if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                    return null;
                }
                // 3.1.d 境外+企业标志否 → 新建
                if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                    return AcctStatus.N;
                }
            }
            // 3.2 对公存款账户用途为非预算单位专用存款户 → 新建
            if (RbBusAcctPurpose.VALUE_3 == rbBusAcctPurpose) {
                return AcctStatus.N;
            }
            // 3.3 否则（含用途为空值）→ 新建
            return AcctStatus.N;
        }
        // 规则4：账户属性为临时户（临时存款账户）
        if (AcctNatureNo.VALUE_11003 == acctNatureNo) {
            // 4.a 境内+企业标志是 → 新建
            if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return AcctStatus.N;
            }
            // 4.b 境内+企业标志否 → 预开户
            if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return AcctStatus.I;
            }
            // 4.c 境外+企业标志是 → 空值（null）
            if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return null;
            }
            // 4.d 境外+企业标志否 → 新建
            if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return AcctStatus.N;
            }
        }
        // 规则5：账户属性为验资户
        if (AcctNatureNo.VALUE_17 == acctNatureNo) {
            // 5.a 境内+企业标志是 → 新建
            if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return AcctStatus.N;
            }
            // 5.b 境内+企业标志否 → 新建
            if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return AcctStatus.N;
            }
            // 5.c 境外+企业标志是 → 空值（null）
            if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return null;
            }
            // 5.d 境外+企业标志否 → 新建
            if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return AcctStatus.N;
            }
        }
        // 规则6：其他账户属性 → 新建
        return AcctStatus.N;
    }
}
