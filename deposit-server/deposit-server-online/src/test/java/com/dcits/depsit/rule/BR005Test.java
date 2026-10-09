package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * BR005 检查允许转久悬标志的单元测试。
 *
 * <p>调用签名：{@code BR005.execute(String allowSuspendFlag, String allowDormantFlag)}，
 * 参数顺序沿用 Spec「### 输入」表行序；返回 checkResult（java.lang.Boolean）：
 * true-允许转久悬、false-不允许转久悬。</p>
 */
class BR005Test {

    // BR005-TC001：REQ-001-S01 两个输入按「## 输入」表契约与顺序传入，规则完成判定（该组示例命中分支 a）
    @Test
    void test_01() {
        Boolean checkResult = BR005.execute("Y", "N");
        assertNotNull(checkResult);
        assertFalse(checkResult);
    }

    // BR005-TC002：REQ-001-S02 输入取值按码值口径判定，不要求携带「-是」「-否」含义后缀
    @Test
    void test_02() {
        Boolean first = BR005.execute("Y", "N");
        assertNotNull(first);
        assertFalse(first);

        Boolean second = BR005.execute("N", "N");
        assertNotNull(second);
        assertFalse(second);
    }

    // BR005-TC003：REQ-001-S03 仅传入两个入参即可完成判定，规则不因「来源实体」列为空要求数据访问
    @Test
    void test_03() {
        assertFalse(BR005.execute("Y", "N"));
    }

    // BR005-TC004：REQ-002-S01 命中分支 a（账户标志为「是」且场景标志为「否」→ 否）
    @Test
    void test_04() {
        assertFalse(BR005.execute("Y", "N"));
    }

    // BR005-TC005：REQ-003-S01 命中分支 b，场景标志未提供（null）
    @Test
    void test_05() {
        assertFalse(BR005.execute("N", null));
    }

    // BR005-TC006：REQ-003-S02 命中分支 b，场景标志为空字符串
    @Test
    void test_06() {
        assertFalse(BR005.execute("N", ""));
    }

    // BR005-TC007：REQ-004-S01 命中分支 c（两个标志均为「否」→ 否）
    @Test
    void test_07() {
        assertFalse(BR005.execute("N", "N"));
    }

    // BR005-TC008：REQ-005-S01 账户标志为「是」、场景标志为「是」→ 兜底 d 返回是
    @Test
    void test_08() {
        assertTrue(BR005.execute("Y", "Y"));
    }

    // BR005-TC009：REQ-005-S02 账户标志为「是」、场景标志为空 → 兜底 d 返回是
    @Test
    void test_09() {
        assertTrue(BR005.execute("Y", null));
    }

    // BR005-TC010：REQ-005-S03 账户标志为「否」、场景标志为「是」→ 兜底 d 返回是
    @Test
    void test_10() {
        assertTrue(BR005.execute("N", "Y"));
    }

    // BR005-TC011：REQ-005-S04 账户标志取到空（必填字段的边界取值）→ 兜底 d 返回是，不抛异常
    @Test
    void test_11() {
        assertTrue(BR005.execute(null, "N"));
    }

    // BR005-TC012：REQ-005-S05 账户标志取值不在「Y」「N」「空」之内（未定义码值）→ 兜底 d 返回是
    @Test
    void test_12() {
        assertTrue(BR005.execute("X", "N"));
    }

    // BR005-TC013：REQ-006-S01 返回值类型与语义映射（false ↔ 否-不允许转久悬）
    @Test
    void test_13() {
        Boolean checkResult = BR005.execute("Y", "N");
        assertInstanceOf(Boolean.class, checkResult);
        assertFalse(checkResult);
    }

    // BR005-TC014：REQ-006-S02 判定域全部 9 种组合穷尽，逐一返回判定表确定的结果
    @Test
    void test_14() {
        // 行 1：分支 a，("Y", "N") → false
        assertFalse(BR005.execute("Y", "N"));
        // 行 2：分支 d，("Y", "Y") → true
        assertTrue(BR005.execute("Y", "Y"));
        // 行 3：分支 d，("Y", 空) → true
        assertTrue(BR005.execute("Y", null));
        // 行 4：分支 b，("N", 空) → false
        assertFalse(BR005.execute("N", null));
        // 行 5：分支 c，("N", "N") → false
        assertFalse(BR005.execute("N", "N"));
        // 行 6：分支 d，("N", "Y") → true
        assertTrue(BR005.execute("N", "Y"));
        // 行 7：分支 d，(空, "Y") → true
        assertTrue(BR005.execute(null, "Y"));
        // 行 8：分支 d，(空, "N") → true
        assertTrue(BR005.execute(null, "N"));
        // 行 9：分支 d，(空, 空) → true
        assertTrue(BR005.execute(null, null));
    }

    // BR005-TC015：REQ-006-S03 判定仅返回 checkResult，不产生业务副作用
    @Test
    void test_15() {
        assertTrue(BR005.execute("N", "Y"));
    }

    // BR005-TC016：解释项边界，账户标志取空字符串（与 null 同为「空」）→ 按 d 兜底返回是
    @Test
    void test_16() {
        assertTrue(BR005.execute("", "N"));
    }
}
