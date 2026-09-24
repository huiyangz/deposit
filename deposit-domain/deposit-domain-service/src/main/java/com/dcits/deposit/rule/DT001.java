package com.dcits.deposit.rule;

import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * DT001 根据核准类型设置账户状态
 *
 * <p>规则类型：决策类。依据门禁通过版 SPEC（docs/specs/DT001.md）：
 * 根据账户属性、对公存款账户用途、境内境外标志、企业标志，决定开户时的账户状态。</p>
 */
public class DT001 {

    /**
     * 根据核准类型设置账户状态。
     *
     * @param rbBusAcctPurpose 对公存款账户用途（非必填，仅专用户分支参与判断）
     * @param acctNatureNo     账户属性编号（必填）
     * @param corporationFlag  企业标志（必填，取值域：是/否）
     * @param inlandOffshore   境内境外标志（必填，取值域：境内/境外）
     * @return acctStatus 账户状态（新建/预开户/无）
     */
    public static String execute(RbBusAcctPurpose rbBusAcctPurpose, String acctNatureNo,
            String corporationFlag, String inlandOffshore) {
        if ("基本户".equals(acctNatureNo)) {
            // 1a 境内+是
            if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return "新建";
            }
            // 1b 境内+否
            if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return "预开户";
            }
            // 1c 境外+是
            if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return "预开户";
            }
            // 1d 境外+否
            if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return "新建";
            }
        } else if ("一般户".equals(acctNatureNo)) {
            // 2 账户属性为“一般户”
            return "新建";
        } else if ("专用户".equals(acctNatureNo)) {
            if (RbBusAcctPurpose.VALUE_4 == rbBusAcctPurpose) {
                // 3.1 账户用途为“预算单位专用存款户”
                // 3.1a 境内+是
                if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                    return "无";
                }
                // 3.1b 境内+否
                if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                    return "预开户";
                }
                // 3.1c 境外+是
                if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                    return "无";
                }
                // 3.1d 境外+否
                if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                    return "新建";
                }
            } else if (RbBusAcctPurpose.VALUE_3 == rbBusAcctPurpose) {
                // 3.2 账户用途为“非预算单位专用存款户”
                return "新建";
            }
        } else if ("临时户".equals(acctNatureNo)) {
            // 4a 境内+是
            if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return "新建";
            }
            // 4b 境内+否
            if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return "预开户";
            }
            // 4c 境外+是
            if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return "无";
            }
            // 4d 境外+否
            if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return "新建";
            }
        } else if ("验资户".equals(acctNatureNo)) {
            // 5a 境内+是
            if ("境内".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return "新建";
            }
            // 5b 境内+否
            if ("境内".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return "新建";
            }
            // 5c 境外+是
            if ("境外".equals(inlandOffshore) && "是".equals(corporationFlag)) {
                return "无";
            }
            // 5d 境外+否
            if ("境外".equals(inlandOffshore) && "否".equals(corporationFlag)) {
                return "新建";
            }
        } else {
            // 6 账户属性为非五类列举值（默认行）
            return "新建";
        }
        //FIXME 规则:根据核准类型设置账户状态 - 问题大类:业务 - 问题分类:分支结果定义缺失 - 严重程度:错误 - 问题描述:SPEC 规则描述 3 仅定义专用户且账户用途为 VALUE_4（预算单位专用存款户）/VALUE_3（非预算单位专用存款户）时的结果，账户用途其余取值（含非必填 null）无结果定义；境内境外标志/企业标志超出声明取值域{境内,境外}/{是,否}的组合同样无结果定义 - 修改建议（参考）：需求方确认这些组合的[账户状态]结果及默认行 6 是否覆盖该场景后，补充分支定义与用例
        return null;
    }
}
