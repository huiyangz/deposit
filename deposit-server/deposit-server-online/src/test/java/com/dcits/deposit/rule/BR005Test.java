package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.TermType;

/**
 * BR005 计算到期日期 单元测试
 */
public class BR005Test {

    /** 按默认时区构造指定日期 00:00:00 的 Date，月份入参用自然序 1-12 */
    private static Date dateOf(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    // 分支a：期限类型=日，runDate=2026-01-10、term="3"，预期到期日期=2026-01-13
    @Test
    public void test_01() {
        assertEquals(dateOf(2026, 1, 13), BR005.execute(dateOf(2026, 1, 10), "3", TermType.D));
    }

    // 分支a：期限类型=日，runDate=2026-01-30、term="5"，加5天跨月，预期到期日期=2026-02-04
    @Test
    public void test_02() {
        assertEquals(dateOf(2026, 2, 4), BR005.execute(dateOf(2026, 1, 30), "5", TermType.D));
    }

    // 分支b：期限类型=月，runDate=2026-01-15、term="6"，正常加月不调整，预期到期日期=2026-07-15
    @Test
    public void test_03() {
        assertEquals(dateOf(2026, 7, 15), BR005.execute(dateOf(2026, 1, 15), "6", TermType.M));
    }

    // 分支b：期限类型=月，runDate=2026-01-31、term="1"，31日加1月到平年2月无效，调整为目标月最后一天，预期到期日期=2026-02-28
    @Test
    public void test_04() {
        assertEquals(dateOf(2026, 2, 28), BR005.execute(dateOf(2026, 1, 31), "1", TermType.M));
    }

    // 分支b：期限类型=月，runDate=2024-01-31、term="1"，31日加1月到闰年2月无效，调整为目标月最后一天，预期到期日期=2024-02-29
    @Test
    public void test_05() {
        assertEquals(dateOf(2024, 2, 29), BR005.execute(dateOf(2024, 1, 31), "1", TermType.M));
    }

    // 分支b：期限类型=月，runDate=2026-04-30、term="1"，系统日期是月末（加月后日期本身有效），调整为5月最后一天，预期到期日期=2026-05-31
    @Test
    public void test_06() {
        assertEquals(dateOf(2026, 5, 31), BR005.execute(dateOf(2026, 4, 30), "1", TermType.M));
    }

    // 分支b：期限类型=月，runDate=2026-01-15、term="12"，多位期限加12个月跨年，预期到期日期=2027-01-15
    @Test
    public void test_07() {
        assertEquals(dateOf(2027, 1, 15), BR005.execute(dateOf(2026, 1, 15), "12", TermType.M));
    }

    // 分支b：期限类型=月，runDate=2024-02-29、term="12"，闰年2月29日（2月月末）加12个月，预期到期日期=2025-02-28
    @Test
    public void test_08() {
        assertEquals(dateOf(2025, 2, 28), BR005.execute(dateOf(2024, 2, 29), "12", TermType.M));
    }

    // 分支c：期限类型=年，runDate=2026-03-15、term="2"，正常加年，预期到期日期=2028-03-15
    @Test
    public void test_09() {
        assertEquals(dateOf(2028, 3, 15), BR005.execute(dateOf(2026, 3, 15), "2", TermType.Y));
    }

    // 分支c：期限类型=年，runDate=2024-02-29、term="1"，2月29日加年至非闰年，调整为2月28日，预期到期日期=2025-02-28
    @Test
    public void test_10() {
        assertEquals(dateOf(2025, 2, 28), BR005.execute(dateOf(2024, 2, 29), "1", TermType.Y));
    }

    // 分支c：期限类型=年，runDate=2024-02-29、term="4"，2月29日加年至闰年日期有效不调整，预期到期日期=2028-02-29
    @Test
    public void test_11() {
        assertEquals(dateOf(2028, 2, 29), BR005.execute(dateOf(2024, 2, 29), "4", TermType.Y));
    }

    // 分支d：期限类型=周，runDate=2026-09-07、term="2"，按期限×7天=14天加周，预期到期日期=2026-09-21
    @Test
    public void test_12() {
        assertEquals(dateOf(2026, 9, 21), BR005.execute(dateOf(2026, 9, 7), "2", TermType.W));
    }

    // 分支d：期限类型=周，runDate=2026-12-24、term="2"，2周=14天跨年进位，预期到期日期=2027-01-07
    @Test
    public void test_13() {
        assertEquals(dateOf(2027, 1, 7), BR005.execute(dateOf(2026, 12, 24), "2", TermType.W));
    }

    // 分支e：期限类型=季，runDate=2026-01-15、term="2"，按期限×3个月=6个月正常加季，预期到期日期=2026-07-15
    @Test
    public void test_14() {
        assertEquals(dateOf(2026, 7, 15), BR005.execute(dateOf(2026, 1, 15), "2", TermType.Q));
    }

    // 分支e：期限类型=季，runDate=2026-04-30、term="1"，系统日期是月末加季（加季后日期本身有效），月末调整规则同b，预期到期日期=2026-07-31
    @Test
    public void test_15() {
        assertEquals(dateOf(2026, 7, 31), BR005.execute(dateOf(2026, 4, 30), "1", TermType.Q));
    }

    // 分支e：期限类型=季，runDate=2026-11-30、term="1"，加季（×3个月）后2月无30日，调整为目标月最后一天，预期到期日期=2027-02-28
    @Test
    public void test_16() {
        assertEquals(dateOf(2027, 2, 28), BR005.execute(dateOf(2026, 11, 30), "1", TermType.Q));
    }

    // 分支f：期限类型=半年，runDate=2026-02-15、term="3"，按期限×6个月=18个月跨年正常加半年，预期到期日期=2027-08-15
    @Test
    public void test_17() {
        assertEquals(dateOf(2027, 8, 15), BR005.execute(dateOf(2026, 2, 15), "3", TermType.H));
    }

    // 分支f：期限类型=半年，runDate=2026-04-30、term="1"，系统日期是月末加半年（加半年后日期本身有效），月末调整规则同b，预期到期日期=2026-10-31
    @Test
    public void test_18() {
        assertEquals(dateOf(2026, 10, 31), BR005.execute(dateOf(2026, 4, 30), "1", TermType.H));
    }

    // 计算类零值：runDate=2026-06-15、term="0"、期限类型=月，0月增量为零且6月15日非月末不触发调整，预期到期日期=2026-06-15
    @Test
    public void test_19() {
        assertEquals(dateOf(2026, 6, 15), BR005.execute(dateOf(2026, 6, 15), "0", TermType.M));
    }
}
