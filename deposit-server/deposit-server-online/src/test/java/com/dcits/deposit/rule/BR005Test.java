package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.TermType;

/**
 * BR005 计算到期日期 单元测试。
 *
 * <p>用例来源：outputs/测试用例.md（BR005-TC001 ~ BR005-TC013），
 * 期望结果来自门禁通过版 SPEC《BR005 计算到期日期》。
 * test_14 ~ test_16 为 SPEC 分支 d（周/季/半年属非法输入、直接报错、不计算到期日期）的补充验证，
 * 依据审核反馈 R1 的「补充相应验证」要求新增。</p>
 */
public class BR005Test {

    /** 构造指定年月日 00:00:00 的 java.util.Date（月份按业务习惯传 1-12）。 */
    private static Date dateOf(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }

    /** 用 Calendar 提取返回值的年/月/日字段精确断言，不断言时间部分。 */
    private static void assertDate(Date actual, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(actual);
        assertEquals(year, calendar.get(Calendar.YEAR), "年不符");
        assertEquals(month, calendar.get(Calendar.MONTH) + 1, "月不符");
        assertEquals(day, calendar.get(Calendar.DAY_OF_MONTH), "日不符");
    }

    // BR005-TC001 期限类型=日：正常加天不跨月，2026-01-10 加 5 天，预期到期日期为 2026-01-15
    @Test
    public void test_01() {
        Date maturityDate = BR005.execute(dateOf(2026, 1, 10), "5", TermType.D);
        assertDate(maturityDate, 2026, 1, 15);
    }

    // BR005-TC002 期限类型=日：加天跨月进位，2026-01-30 加 3 天，预期到期日期为 2026-02-02
    @Test
    public void test_02() {
        Date maturityDate = BR005.execute(dateOf(2026, 1, 30), "3", TermType.D);
        assertDate(maturityDate, 2026, 2, 2);
    }

    // BR005-TC003 期限类型=日：加天跨非闰年 2 月月末，2026-02-27 加 3 天，预期到期日期为 2026-03-02
    @Test
    public void test_03() {
        Date maturityDate = BR005.execute(dateOf(2026, 2, 27), "3", TermType.D);
        assertDate(maturityDate, 2026, 3, 2);
    }

    // BR005-TC004 期限类型=日：加天跨闰年 2 月月末，2028-02-27 加 3 天，预期到期日期为 2028-03-01
    @Test
    public void test_04() {
        Date maturityDate = BR005.execute(dateOf(2028, 2, 27), "3", TermType.D);
        assertDate(maturityDate, 2028, 3, 1);
    }

    // BR005-TC005 期限类型=日：存期期限为零的零值边界，2026-07-08 加 0 天，预期到期日期为 2026-07-08 且与输入同日
    @Test
    public void test_05() {
        Date runDate = dateOf(2026, 7, 8);
        Date maturityDate = BR005.execute(runDate, "0", TermType.D);
        assertDate(runDate, 2026, 7, 8);
        assertDate(maturityDate, 2026, 7, 8);
    }

    // BR005-TC006 期限类型=月：正常加月且日有效无需调整，2026-01-15 加 6 月，预期到期日期为 2026-07-15
    @Test
    public void test_06() {
        Date maturityDate = BR005.execute(dateOf(2026, 1, 15), "6", TermType.M);
        assertDate(maturityDate, 2026, 7, 15);
    }

    // BR005-TC007 期限类型=月：31 日加 1 月至非闰年 2 月，加月后日期无效，预期到期日期调整为 2026-02-28
    @Test
    public void test_07() {
        Date maturityDate = BR005.execute(dateOf(2026, 1, 31), "1", TermType.M);
        assertDate(maturityDate, 2026, 2, 28);
    }

    // BR005-TC008 期限类型=月：31 日加 1 月至闰年 2 月，加月后日期无效，预期到期日期调整为 2028-02-29
    @Test
    public void test_08() {
        Date maturityDate = BR005.execute(dateOf(2028, 1, 31), "1", TermType.M);
        assertDate(maturityDate, 2028, 2, 29);
    }

    // BR005-TC009 期限类型=月：31 日加 3 月至 30 天月份（4 月），加月后日期无效，预期到期日期调整为 2026-04-30
    @Test
    public void test_09() {
        Date maturityDate = BR005.execute(dateOf(2026, 1, 31), "3", TermType.M);
        assertDate(maturityDate, 2026, 4, 30);
    }

    // BR005-TC010 期限类型=月：核心运行日期为月末（2026-02-28）加 1 月，触发月末调整，预期到期日期为 2026-03-31
    @Test
    public void test_10() {
        Date maturityDate = BR005.execute(dateOf(2026, 2, 28), "1", TermType.M);
        assertDate(maturityDate, 2026, 3, 31);
    }

    // BR005-TC011 期限类型=年：正常加年，2026-03-15 加 3 年，预期到期日期为 2029-03-15
    @Test
    public void test_11() {
        Date maturityDate = BR005.execute(dateOf(2026, 3, 15), "3", TermType.Y);
        assertDate(maturityDate, 2029, 3, 15);
    }

    // BR005-TC012 期限类型=年：2 月 29 日加 1 年至非闰年 2029，预期到期日期调整为 2029-02-28
    @Test
    public void test_12() {
        Date maturityDate = BR005.execute(dateOf(2028, 2, 29), "1", TermType.Y);
        assertDate(maturityDate, 2029, 2, 28);
    }

    // BR005-TC013 期限类型=年：2 月 29 日加 4 年至闰年 2032，调整条件不成立，预期到期日期保持 2032-02-29
    @Test
    public void test_13() {
        Date maturityDate = BR005.execute(dateOf(2028, 2, 29), "4", TermType.Y);
        assertDate(maturityDate, 2032, 2, 29);
    }

    // SPEC 分支 d 补充验证：期限类型=周 属非法输入，直接报错不计算到期日期，预期抛出 IllegalArgumentException 且报错信息指明该期限类型
    @Test
    public void test_14() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BR005.execute(dateOf(2026, 1, 10), "1", TermType.W));
        assertTrue(exception.getMessage().contains("W"), "报错信息应指明非法期限类型 W");
    }

    // SPEC 分支 d 补充验证：期限类型=季 属非法输入，直接报错不计算到期日期，预期抛出 IllegalArgumentException 且报错信息指明该期限类型
    @Test
    public void test_15() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BR005.execute(dateOf(2026, 1, 10), "1", TermType.Q));
        assertTrue(exception.getMessage().contains("Q"), "报错信息应指明非法期限类型 Q");
    }

    // SPEC 分支 d 补充验证：期限类型=半年 属非法输入，直接报错不计算到期日期，预期抛出 IllegalArgumentException 且报错信息指明该期限类型
    @Test
    public void test_16() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> BR005.execute(dateOf(2026, 1, 10), "1", TermType.H));
        assertTrue(exception.getMessage().contains("H"), "报错信息应指明非法期限类型 H");
    }
}
