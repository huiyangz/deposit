package com.dcits.depsit.rule;

/**
 * BR005 检查允许转久悬标志（断言类）。
 *
 * <p>以「允许账户转久悬标志」（allowSuspendFlag）与「是否允许转久悬」（allowDormantFlag）
 * 两个取值的组合为判据，判定账户是否允许转久悬，返回 checkResult：
 * true-允许转久悬、false-不允许转久悬。</p>
 *
 * <p>取值为码值口径："Y"＝是、"N"＝否；allowDormantFlag 另接受「空」（无值：null 或长度为 0 的空字符串）。
 * 规则无状态、不发起依赖调用、不产生业务副作用，也不对输入取值作合法性校验。</p>
 */
public class BR005 {

    /** 标志取值：是。 */
    private static final String FLAG_YES = "Y";

    /** 标志取值：否。 */
    private static final String FLAG_NO = "N";

    /**
     * 执行判定。
     *
     * @param allowSuspendFlag 允许账户转久悬标志（必填，码值 "Y"＝是、"N"＝否）
     * @param allowDormantFlag 是否允许转久悬（非必填，码值 "Y"＝是、"N"＝否、空＝无值）
     * @return checkResult：true-允许转久悬、false-不允许转久悬，不为 null
     */
    public static Boolean execute(String allowSuspendFlag, String allowDormantFlag) {
        // a. 允许账户转久悬标志＝是 且 是否允许转久悬＝否，返回否
        if (FLAG_YES.equals(allowSuspendFlag) && FLAG_NO.equals(allowDormantFlag)) {
            return Boolean.FALSE;
        }
        // b. 允许账户转久悬标志＝否 且 是否允许转久悬＝空，返回否
        if (FLAG_NO.equals(allowSuspendFlag) && isEmpty(allowDormantFlag)) {
            return Boolean.FALSE;
        }
        // c. 允许账户转久悬标志＝否 且 是否允许转久悬＝否，返回否
        if (FLAG_NO.equals(allowSuspendFlag) && FLAG_NO.equals(allowDormantFlag)) {
            return Boolean.FALSE;
        }
        // d. 否则，返回是
        return Boolean.TRUE;
    }

    /**
     * 判断标志是否为空（无值）：null 或长度为 0 的空字符串，二者同为「空」。
     */
    private static boolean isEmpty(String flag) {
        return flag == null || flag.isEmpty();
    }
}
