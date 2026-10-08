package com.dcits.depsit.rule;

/**
 * BR003 检查允许转久悬标志（断言类规则）。
 *
 * 按「允许账户转久悬标志」与「是否允许转久悬」两个输入的取值组合判定账户是否允许转久悬，
 * 以布尔返回值表达结论：“是”对应 {@code true}，“否”对应 {@code false}。
 *
 * 规则为无状态纯业务逻辑，不访问 BCC、Mapper、数据库、外部接口或业务 Service，不返回错误码、不抛出异常。
 */
public class BR003 {

    /** 取值“Y-是”：含义为“是”。 */
    private static final String YES = "Y-是";

    /** 取值“N-否”：含义为“否”。 */
    private static final String NO = "N-否";

    /**
     * 执行允许转久悬判定。
     *
     * @param allowSuspendFlag 允许账户转久悬标志，必填，取值 "Y-是"、"N-否"
     * @param allowDormantFlag 是否允许转久悬，非必填，取值 "Y-是"、"N-否"、空
     * @return 是否允许转久悬：{@code true}（“是”）、{@code false}（“否”）
     */
    public static boolean execute(String allowSuspendFlag, String allowDormantFlag) {
        // 条件 a：允许账户转久悬标志为“是”且是否允许转久悬为“否”，返回否。
        if (YES.equals(allowSuspendFlag) && NO.equals(allowDormantFlag)) {
            return false;
        }
        // 条件 b：允许账户转久悬标志为“否”且是否允许转久悬为空，返回否。
        if (NO.equals(allowSuspendFlag) && isEmpty(allowDormantFlag)) {
            return false;
        }
        // 条件 c：不满足条件 a、b 的取值组合（含未列入取值域的取值）返回是。
        return true;
    }

    /**
     * 判断是否允许转久悬是否为空。
     *
     * 空值口径按 Spec：未提供（{@code null}）或空字符串；纯空白字符串不在 Spec 列出的取值域内，
     * 不作为“空”处理，按条件 c 的“否则”分支判定。
     */
    private static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
