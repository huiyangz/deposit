package com.dcits.deposit.rule;

/**
 * BR003 检查允许转久悬标志
 *
 * 规则类型：断言类
 *
 * a. 若允许账户转久悬标志等于"Y-是"且产品是否允许转久悬等于"N-否"，返回否；
 * b. 若允许账户转久悬标志等于"N-否"且产品是否允许转久悬等于空，返回否；
 * c. 否则，返回是。
 */
public class BR003 {

    /**
     * 检查是否允许转久悬。
     *
     * @param allowSuspendFlag 允许账户转久悬标志（Y-是 / N-否）
     * @param productAllowDormantFlag 产品是否允许转久悬（Y-是 / N-否 / 空）
     * @return true-是（允许转久悬），false-否（不允许转久悬）
     */
    public static boolean execute(String allowSuspendFlag, String productAllowDormantFlag) {
        // 条件 a：账户允许转久悬，且产品不允许转久悬，返回否
        if ("Y".equals(allowSuspendFlag) && "N".equals(productAllowDormantFlag)) {
            return false;
        }
        // 条件 b：账户不允许转久悬，且产品允许转久悬标志为空，返回否
        if ("N".equals(allowSuspendFlag) && "".equals(productAllowDormantFlag)) {
            return false;
        }
        // 条件 c：其余情况，返回是
        return true;
    }
}
