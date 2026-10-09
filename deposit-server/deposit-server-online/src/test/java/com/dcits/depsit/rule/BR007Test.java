package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dcits.depsit.enums.TermType;

/**
 * BR007 计算到期日期 单元测试
 *
 * <p>断言比较 maturityDate 所表示的自然日（年/月/日）；时分秒口径 Spec 未约束，不作断言。</p>
 */
public class BR007Test {

    // REQ-001-S01 期限类型「日」同月内计算：2026-01-05 加 10 天 = 2026-01-15
    @Test
    void test_01() {
        Date maturityDate = BR007.execute(date(2026, 1, 5), "10", TermType.D);
        assertDay(2026, 1, 15, maturityDate);
    }

    // REQ-001-S02 期限类型「日」跨月进位：2026-01-15 加 30 天 = 2026-02-14
    @Test
    void test_02() {
        Date maturityDate = BR007.execute(date(2026, 1, 15), "30", TermType.D);
        assertDay(2026, 2, 14, maturityDate);
    }

    // 期限类型「日」跨年进位：2026-12-25 加 10 天 = 2027-01-04
    @Test
    void test_03() {
        Date maturityDate = BR007.execute(date(2026, 12, 25), "10", TermType.D);
        assertDay(2027, 1, 4, maturityDate);
    }

    // 期限类型「日」跨入闰年 2 月 29 日，且不触发月末调整：2028-02-28 加 1 天 = 2028-02-29
    @Test
    void test_04() {
        Date maturityDate = BR007.execute(date(2028, 2, 28), "1", TermType.D);
        assertDay(2028, 2, 29, maturityDate);
    }

    // REQ-002-S01 期限类型「月」普通计算：2026-01-15 加 3 个月 = 2026-04-15
    @Test
    void test_05() {
        Date maturityDate = BR007.execute(date(2026, 1, 15), "3", TermType.M);
        assertDay(2026, 4, 15, maturityDate);
    }

    // REQ-002-S02 「月」基准日期为月末且加月后日期有效：2026-02-28 加 1 个月 = 2026-03-31
    @Test
    void test_06() {
        Date maturityDate = BR007.execute(date(2026, 2, 28), "1", TermType.M);
        assertDay(2026, 3, 31, maturityDate);
    }

    // REQ-002-S03 「月」加月后日期无效（非闰年）：2026-08-31 加 6 个月 = 2027-02-28
    @Test
    void test_07() {
        Date maturityDate = BR007.execute(date(2026, 8, 31), "6", TermType.M);
        assertDay(2027, 2, 28, maturityDate);
    }

    // REQ-002-S04 「月」加月后日期无效（闰年 2 月）：2024-01-31 加 1 个月 = 2024-02-29
    @Test
    void test_08() {
        Date maturityDate = BR007.execute(date(2024, 1, 31), "1", TermType.M);
        assertDay(2024, 2, 29, maturityDate);
    }

    // 「月」月末调整且目标月天数多于基准月：2026-04-30 加 1 个月 = 2026-05-31
    @Test
    void test_09() {
        Date maturityDate = BR007.execute(date(2026, 4, 30), "1", TermType.M);
        assertDay(2026, 5, 31, maturityDate);
    }

    // 「月」月末条件与无效日条件同时成立：2026-01-31 加 1 个月 = 2026-02-28
    @Test
    void test_10() {
        Date maturityDate = BR007.execute(date(2026, 1, 31), "1", TermType.M);
        assertDay(2026, 2, 28, maturityDate);
    }

    // 「月」期限跨年进位：2026-01-15 加 13 个月 = 2027-02-15
    @Test
    void test_11() {
        Date maturityDate = BR007.execute(date(2026, 1, 15), "13", TermType.M);
        assertDay(2027, 2, 15, maturityDate);
    }

    // REQ-003-S01 期限类型「年」普通计算：2026-03-15 加 2 年 = 2028-03-15
    @Test
    void test_12() {
        Date maturityDate = BR007.execute(date(2026, 3, 15), "2", TermType.Y);
        assertDay(2028, 3, 15, maturityDate);
    }

    // REQ-003-S02 基准日期为 2 月 29 日且到期年份非闰年：2024-02-29 加 1 年 = 2025-02-28
    @Test
    void test_13() {
        Date maturityDate = BR007.execute(date(2024, 2, 29), "1", TermType.Y);
        assertDay(2025, 2, 28, maturityDate);
    }

    // REQ-003-S03 基准日期为 2 月 29 日且到期年份为闰年，不触发调整：2024-02-29 加 4 年 = 2028-02-29
    @Test
    void test_14() {
        Date maturityDate = BR007.execute(date(2024, 2, 29), "4", TermType.Y);
        assertDay(2028, 2, 29, maturityDate);
    }

    // 「年」基准日期为 2 月 28 日（非 2 月 29 日）不触发调整：2026-02-28 加 1 年 = 2027-02-28
    @Test
    void test_15() {
        Date maturityDate = BR007.execute(date(2026, 2, 28), "1", TermType.Y);
        assertDay(2027, 2, 28, maturityDate);
    }

    // REQ-004-S01 期限类型「周」同月内计算：2026-01-15 加 2×7 天 = 2026-01-29
    @Test
    void test_16() {
        Date maturityDate = BR007.execute(date(2026, 1, 15), "2", TermType.W);
        assertDay(2026, 1, 29, maturityDate);
    }

    // REQ-004-S02 「周」跨年进位：2026-12-28 加 1×7 天 = 2027-01-04
    @Test
    void test_17() {
        Date maturityDate = BR007.execute(date(2026, 12, 28), "1", TermType.W);
        assertDay(2027, 1, 4, maturityDate);
    }

    // 「周」跨月进位：2026-01-28 加 1×7 天 = 2026-02-04
    @Test
    void test_18() {
        Date maturityDate = BR007.execute(date(2026, 1, 28), "1", TermType.W);
        assertDay(2026, 2, 4, maturityDate);
    }

    // REQ-005-S01 期限类型「季」普通计算：2026-01-15 加 1×3 个月 = 2026-04-15
    @Test
    void test_19() {
        Date maturityDate = BR007.execute(date(2026, 1, 15), "1", TermType.Q);
        assertDay(2026, 4, 15, maturityDate);
    }

    // REQ-005-S02 「季」基准日期为月末且加月后日期有效：2026-02-28 加 1×3 个月 = 2026-05-31
    @Test
    void test_20() {
        Date maturityDate = BR007.execute(date(2026, 2, 28), "1", TermType.Q);
        assertDay(2026, 5, 31, maturityDate);
    }

    // REQ-005-S03 「季」加月后日期无效：2026-01-31 加 1×3 个月 = 2026-04-30
    @Test
    void test_21() {
        Date maturityDate = BR007.execute(date(2026, 1, 31), "1", TermType.Q);
        assertDay(2026, 4, 30, maturityDate);
    }

    // 「季」月末条件与无效日条件同时成立：2026-03-31 加 1×3 个月 = 2026-06-30
    @Test
    void test_22() {
        Date maturityDate = BR007.execute(date(2026, 3, 31), "1", TermType.Q);
        assertDay(2026, 6, 30, maturityDate);
    }

    // REQ-006-S01 期限类型「半年」普通计算：2026-01-15 加 1×6 个月 = 2026-07-15
    @Test
    void test_23() {
        Date maturityDate = BR007.execute(date(2026, 1, 15), "1", TermType.H);
        assertDay(2026, 7, 15, maturityDate);
    }

    // REQ-006-S02 「半年」基准日期为月末且加月后日期有效：2026-02-28 加 1×6 个月 = 2026-08-31
    @Test
    void test_24() {
        Date maturityDate = BR007.execute(date(2026, 2, 28), "1", TermType.H);
        assertDay(2026, 8, 31, maturityDate);
    }

    // REQ-006-S03 「半年」加月后日期无效（非闰年）：2026-08-31 加 1×6 个月 = 2027-02-28
    @Test
    void test_25() {
        Date maturityDate = BR007.execute(date(2026, 8, 31), "1", TermType.H);
        assertDay(2027, 2, 28, maturityDate);
    }

    // 「半年」加月后日期无效（闰年 2 月）：2023-08-31 加 1×6 个月 = 2024-02-29
    @Test
    void test_26() {
        Date maturityDate = BR007.execute(date(2023, 8, 31), "1", TermType.H);
        assertDay(2024, 2, 29, maturityDate);
    }

    /**
     * 按当地时区构造指定自然日 00:00:00 的 java.util.Date。
     */
    private static Date date(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day, 0, 0, 0);
        return calendar.getTime();
    }

    /**
     * 断言到期日期非空，且其自然日（年/月/日）与预期一致。
     */
    private static void assertDay(int year, int month, int day, Date maturityDate) {
        assertNotNull(maturityDate, "maturityDate 不应为空");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(maturityDate);
        assertEquals(year, calendar.get(Calendar.YEAR), "到期年份不符");
        assertEquals(month, calendar.get(Calendar.MONTH) + 1, "到期月份不符");
        assertEquals(day, calendar.get(Calendar.DAY_OF_MONTH), "到期日不符");
    }
}
