package com.dcits.deposit.rule;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * BR005 计算到期日期 单元测试
 *
 * 用例来源：outputs/测试用例.md（BR005-TC001 ~ BR005-TC015）。
 * 预期值以本任务 fileInputs.spec 绑定的门禁通过版 SPEC 为准：
 * term 为 java.lang.Integer，分支 b 为自然顺延口径（仅加月后无对应日时调整），
 * 与该版 SPEC 不同的用例预期（TC009、TC010、TC012）已按门禁版同步。
 */
class BR005Test {

    /** 构造仅含日期、时分秒毫秒为 0 的 java.util.Date */
    private static Date dateOf(String isoDate) {
        return Date.from(LocalDate.parse(isoDate).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /** 按 yyyy-MM-dd 格式化日期，便于精确断言 */
    private static String formatDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
    }

    // 场景：分支a：期限类型=日，正常天数计算，跨 6/7/8 月共 90 天；预期 2026-09-08
    @Test
    void test_01() {
        Date maturityDate = BR005.execute(dateOf("2026-06-10"), 90, "日");
        assertNotNull(maturityDate);
        assertEquals("2026-09-08", formatDate(maturityDate));
    }

    // 场景：分支a：31 天月末 +1 天跨月进位；预期 2026-02-01
    @Test
    void test_02() {
        Date maturityDate = BR005.execute(dateOf("2026-01-31"), 1, "日");
        assertNotNull(maturityDate);
        assertEquals("2026-02-01", formatDate(maturityDate));
    }

    // 场景：分支a：非闰年 2 月末（2 月 28 日）+1 天进位到 3 月；预期 2026-03-01
    @Test
    void test_03() {
        Date maturityDate = BR005.execute(dateOf("2026-02-28"), 1, "日");
        assertNotNull(maturityDate);
        assertEquals("2026-03-01", formatDate(maturityDate));
    }

    // 场景：分支a：闰年 2 月存在 2 月 29 日，+1 天仍落在 2 月；预期 2028-02-29
    @Test
    void test_04() {
        Date maturityDate = BR005.execute(dateOf("2028-02-28"), 1, "日");
        assertNotNull(maturityDate);
        assertEquals("2028-02-29", formatDate(maturityDate));
    }

    // 场景：分支b：普通加月，runDate 非月末且 15 日在目标月有效，不触发调整；预期 2026-08-15
    @Test
    void test_05() {
        Date maturityDate = BR005.execute(dateOf("2026-02-15"), 6, "月");
        assertNotNull(maturityDate);
        assertEquals("2026-08-15", formatDate(maturityDate));
    }

    // 场景：分支b：加 12 个月跨自然年，目标月有对应日，不触发调整；预期 2027-03-10
    @Test
    void test_06() {
        Date maturityDate = BR005.execute(dateOf("2026-03-10"), 12, "月");
        assertNotNull(maturityDate);
        assertEquals("2027-03-10", formatDate(maturityDate));
    }

    // 场景：分支b：runDate 非月末的 30 日，加 1 月后 2 月 30 日无效，"日"调整为 2 月最后一天；预期 2026-02-28
    @Test
    void test_07() {
        Date maturityDate = BR005.execute(dateOf("2026-01-30"), 1, "月");
        assertNotNull(maturityDate);
        assertEquals("2026-02-28", formatDate(maturityDate));
    }

    // 场景：分支b：29 日加 3 月落到闰年 2028 年 2 月，2 月 29 日有效，不触发调整；预期 2028-02-29
    @Test
    void test_08() {
        Date maturityDate = BR005.execute(dateOf("2027-11-29"), 3, "月");
        assertNotNull(maturityDate);
        assertEquals("2028-02-29", formatDate(maturityDate));
    }

    // 场景：分支b：月末 4 月 30 日加 1 月，自然顺延口径下 5 月有 30 日对应日，不触发调整（SPEC 示例：4 月 30 日存 1 个月到期日为 5 月 30 日）；预期 2026-05-30
    @Test
    void test_09() {
        Date maturityDate = BR005.execute(dateOf("2026-04-30"), 1, "月");
        assertNotNull(maturityDate);
        assertEquals("2026-05-30", formatDate(maturityDate));
    }

    // 场景：分支b：非闰年 2 月 28 日加 3 月，目标月 5 月有 28 日对应日，自然顺延不触发调整；预期 2026-05-28
    @Test
    void test_10() {
        Date maturityDate = BR005.execute(dateOf("2026-02-28"), 3, "月");
        assertNotNull(maturityDate);
        assertEquals("2026-05-28", formatDate(maturityDate));
    }

    // 场景：分支b：31 日加 1 月后 2 月无 31 日，"日"调整为 2 月最后一天；预期 2026-02-28
    @Test
    void test_11() {
        Date maturityDate = BR005.execute(dateOf("2026-01-31"), 1, "月");
        assertNotNull(maturityDate);
        assertEquals("2026-02-28", formatDate(maturityDate));
    }

    // 场景：分支b：闰年 2 月 29 日加 1 月，目标月 3 月有 29 日对应日，自然顺延不触发调整；预期 2028-03-29
    @Test
    void test_12() {
        Date maturityDate = BR005.execute(dateOf("2028-02-29"), 1, "月");
        assertNotNull(maturityDate);
        assertEquals("2028-03-29", formatDate(maturityDate));
    }

    // 场景：分支c：普通加年，runDate 非 2 月 29 日，到期年 2028 为闰年也不触发调整；预期 2028-06-15
    @Test
    void test_13() {
        Date maturityDate = BR005.execute(dateOf("2026-06-15"), 2, "年");
        assertNotNull(maturityDate);
        assertEquals("2028-06-15", formatDate(maturityDate));
    }

    // 场景：分支c：runDate 为 2 月 29 日，加 4 年到期年 2032 为闰年，2 月 29 日有效不调整；预期 2032-02-29
    @Test
    void test_14() {
        Date maturityDate = BR005.execute(dateOf("2028-02-29"), 4, "年");
        assertNotNull(maturityDate);
        assertEquals("2032-02-29", formatDate(maturityDate));
    }

    // 场景：分支c：runDate 为 2 月 29 日，加 1 年到期年 2029 非闰年，到期日调整为 2 月 28 日；预期 2029-02-28
    @Test
    void test_15() {
        Date maturityDate = BR005.execute(dateOf("2028-02-29"), 1, "年");
        assertNotNull(maturityDate);
        assertEquals("2029-02-28", formatDate(maturityDate));
    }
}
