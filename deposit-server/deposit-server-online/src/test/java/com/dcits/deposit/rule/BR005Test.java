package com.dcits.deposit.rule;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * BR005 计算到期日期 单元测试
 *
 * 输入输出中的 java.util.Date 以 yyyy-MM-dd 表示日期部分：构造使用
 * {@link GregorianCalendar} 指定年月日，断言按 yyyy-MM-dd 格式化后精确比较，
 * 避免时间部分与时区差异。
 */
public class BR005Test {

    /** 按年、{@link Calendar} 月份常量、日构造日期（当日零点） */
    private static Date dateOf(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    /** 按 yyyy-MM-dd 格式化日期部分 */
    private static String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    // 日类型正常加天（SPEC a 分支）：2026-01-10 加 90 天跨月不触发调整，预期到期日期 2026-04-10
    @Test
    public void test_01() {
        assertEquals("2026-04-10",
                formatDate(BR005.execute(dateOf(2026, Calendar.JANUARY, 10), "90", "日")));
    }

    // 日类型正常加月（SPEC b 分支基本公式）：2026-01-15 加 6 个月目标日有效不调整，预期到期日期 2026-07-15
    @Test
    public void test_02() {
        assertEquals("2026-07-15",
                formatDate(BR005.execute(dateOf(2026, Calendar.JANUARY, 15), "6", "月")));
    }

    // 年类型正常加年（SPEC c 分支基本公式）：2026-06-15 加 2 年不涉及2月29日调整，预期到期日期 2028-06-15
    @Test
    public void test_03() {
        assertEquals("2028-06-15",
                formatDate(BR005.execute(dateOf(2026, Calendar.JUNE, 15), "2", "年")));
    }

    // 日类型跨闰年2月边界：闰年 2024-02-28 加 2 天经 2月29日 到 3月1日，预期到期日期 2024-03-01
    @Test
    public void test_04() {
        assertEquals("2024-03-01",
                formatDate(BR005.execute(dateOf(2024, Calendar.FEBRUARY, 28), "2", "日")));
    }

    // 日类型期限零值边界：2026-06-15 加 0 天，到期日期等于系统日期，预期 2026-06-15
    @Test
    public void test_05() {
        assertEquals("2026-06-15",
                formatDate(BR005.execute(dateOf(2026, Calendar.JUNE, 15), "0", "日")));
    }

    // 月类型加月后日期无效（非闰年2月）：2026-01-30（非月末）加 1 个月，2月无30日，调整为2月最后一天，预期 2026-02-28
    @Test
    public void test_06() {
        assertEquals("2026-02-28",
                formatDate(BR005.execute(dateOf(2026, Calendar.JANUARY, 30), "1", "月")));
    }

    // 月类型加月后日期无效（闰年2月）：2024-01-30 加 1 个月，闰年2月最后一天为29日，预期 2024-02-29
    @Test
    public void test_07() {
        assertEquals("2024-02-29",
                formatDate(BR005.execute(dateOf(2024, Calendar.JANUARY, 30), "1", "月")));
    }

    // 月类型系统日期为月末且加月后日期无效：2026-01-31 加 1 个月，2月无31日，调整为2月28日，预期 2026-02-28
    @Test
    public void test_08() {
        assertEquals("2026-02-28",
                formatDate(BR005.execute(dateOf(2026, Calendar.JANUARY, 31), "1", "月")));
    }

    // 月类型系统日期为月末、目标月存在同号日：2026-04-30（月末）加 1 个月，按 SPEC b 调整为目标月最后一天，预期 2026-05-31
    @Test
    public void test_09() {
        assertEquals("2026-05-31",
                formatDate(BR005.execute(dateOf(2026, Calendar.APRIL, 30), "1", "月")));
    }

    // 月类型31日加至小月：2026-03-31（月末）加 1 个月，4月仅30天，调整为4月30日，预期 2026-04-30
    @Test
    public void test_10() {
        assertEquals("2026-04-30",
                formatDate(BR005.execute(dateOf(2026, Calendar.MARCH, 31), "1", "月")));
    }

    // 月类型跨年加月调整：2026-11-30（月末）加 3 个月跨年至2027年2月，2月无30日，调整为2027-02-28
    @Test
    public void test_11() {
        assertEquals("2027-02-28",
                formatDate(BR005.execute(dateOf(2026, Calendar.NOVEMBER, 30), "3", "月")));
    }

    // 月类型闰年2月29日（月末）加12个月：2025年非闰年2月无29日，调整为2025-02-28
    @Test
    public void test_12() {
        assertEquals("2025-02-28",
                formatDate(BR005.execute(dateOf(2024, Calendar.FEBRUARY, 29), "12", "月")));
    }

    // 年类型2月29日加1年至非闰年（SPEC c 调整规则）：2024-02-29 加 1 年，2025年非闰年，调整为2025-02-28
    @Test
    public void test_13() {
        assertEquals("2025-02-28",
                formatDate(BR005.execute(dateOf(2024, Calendar.FEBRUARY, 29), "1", "年")));
    }

    // 年类型2月29日加4年至闰年（SPEC c 调整条件不成立）：2024-02-29 加 4 年，2028年为闰年，保持2028-02-29
    @Test
    public void test_14() {
        assertEquals("2028-02-29",
                formatDate(BR005.execute(dateOf(2024, Calendar.FEBRUARY, 29), "4", "年")));
    }
}
