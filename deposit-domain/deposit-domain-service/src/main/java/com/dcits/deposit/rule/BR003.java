package com.dcits.deposit.rule;

/**
 * BR003 检查允许转久悬标志（断言类）
 *
 * <p>输入：allowSuspendFlag 允许账户转久悬标志（必填），allowDormantFlag 是否允许转久悬（非必填，空值为 null 或空字符串）。
 * 输出：result 检查结果，true 表示是，false 表示否。
 */
public class BR003 {

    /**
     * 检查是否允许转久悬。
     *
     * @param allowSuspendFlag 允许账户转久悬标志
     * @param allowDormantFlag 是否允许转久悬
     * @return 检查结果：是（true）/ 否（false）
     */
    public static boolean execute(String allowSuspendFlag, String allowDormantFlag) {
        // a.允许账户转久悬标志等于"Y"且是否允许转久悬等于"N"，返回否
        if ("Y".equals(allowSuspendFlag) && "N".equals(allowDormantFlag)) {
            return false;
        }
        // b.允许账户转久悬标志等于"N"且是否允许转久悬为空（null 或空字符串），返回否
        if ("N".equals(allowSuspendFlag) && (allowDormantFlag == null || allowDormantFlag.isEmpty())) {
            return false;
        }
        // c.否则，返回是
        return true;
    }
}
