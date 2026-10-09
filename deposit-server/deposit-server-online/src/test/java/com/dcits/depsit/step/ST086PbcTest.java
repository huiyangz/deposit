package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.facade.bo.ST086InputBO;
import com.dcits.depsit.facade.bo.ST086OutputBO;

/**
 * ST086 设置账户开户日期 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST086-TC001 至 ST086-TC010，覆盖 Spec REQ-001 至 REQ-005 的场景：
 * 步骤 1 取 [系统日期] = 入参 {@code runDate}，步骤 2 赋值并返回 {@code acctOpenDate} = [系统日期]，
 * 正常完成时 {@code succeed = true} 且错误码、错误信息为空。本步骤无分支、无循环、无跳转、无业务失败场景。
 *
 * <p>本步骤依赖契约为「不适用」：无 BCC、Mapper、EO、规则、跨组件客户端或数据库可供触达，
 * 故各用例直接构造 {@link ST086Pbc} 真实执行 {@code execute}，不设任何 Mockito 桩，
 * 也不使用 {@code verify} / {@code never} / {@code times} / {@code InOrder} 交互断言。
 *
 * <p>未定义行为不生成用例：{@code runDate} 取空（null）或缺失时的行为、时区与格式口径、
 * 落库写入与后续使用，均无 Spec 依据（「## 验收范围与明确不覆盖的事项」第 2、3、5 项），不作断言。
 */
@ExtendWith(MockitoExtension.class)
class ST086PbcTest {

    /** 按默认时区构造固定日期值，毫秒清零，避免依赖执行时刻。 */
    private static Date fixedDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    /** 按默认时区构造含时、分、秒、毫秒的固定日期值，避免依赖执行时刻。 */
    private static Date fixedDateTime(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month, day, hour, minute, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        return calendar.getTime();
    }

    /** 读取指定日期在同一默认时区下的日历字段。 */
    private static Calendar calendarOf(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /** 取类自身声明的实例字段名（过滤 static 与 synthetic），用于核对输出 BO 未新增其它业务字段。 */
    private static Set<String> declaredInstanceFieldNames(Class<?> type) {
        Set<String> names = new HashSet<>();
        for (Field field : type.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers()) && !field.isSynthetic()) {
                names.add(field.getName());
            }
        }
        return names;
    }

    // ST086-TC001：REQ-001-S01 以 runDate（java.util.Date）接收输入并驱动步骤 1，输出与入参为同一时间点
    @Test
    void testST086T01() throws NoSuchFieldException {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDate(2026, Calendar.OCTOBER, 9));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        assertEquals(Date.class, ST086InputBO.class.getDeclaredField("runDate").getType());
    }

    // ST086-TC002：REQ-001-S02 仅以 runDate 驱动本步骤，无任何依赖实例、无外部连接时仍完成赋值
    @Test
    void testST086T02() {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDate(2026, Calendar.OCTOBER, 9));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        assertNull(output.getErrorCode());
    }

    // ST086-TC003：REQ-002-S01 步骤 1 将 [系统日期] 取为入参 runDate，经唯一消费点 acctOpenDate 观测
    @Test
    void testST086T03() {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDate(2026, Calendar.OCTOBER, 9));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        Calendar observed = calendarOf(output.getAcctOpenDate());
        assertEquals(2026, observed.get(Calendar.YEAR));
        assertEquals(Calendar.OCTOBER, observed.get(Calendar.MONTH));
        assertEquals(9, observed.get(Calendar.DAY_OF_MONTH));
        assertTrue(output.isSucceed());
    }

    // ST086-TC004：REQ-002-S02 [系统日期] 取入参而非执行时刻的机器当前日期，也不查询系统日期表
    @Test
    void testST086T04() {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDate(2026, Calendar.JANUARY, 5));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        Calendar observed = calendarOf(output.getAcctOpenDate());
        assertEquals(2026, observed.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, observed.get(Calendar.MONTH));
        assertEquals(5, observed.get(Calendar.DAY_OF_MONTH));
    }

    // ST086-TC005：REQ-003-S01 含时、分、秒、毫秒逐位相等，不做归一化、截断到日或时区转换
    @Test
    void testST086T05() {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDateTime(2026, Calendar.OCTOBER, 9, 10, 20, 30, 0));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        Calendar observed = calendarOf(output.getAcctOpenDate());
        assertEquals(10, observed.get(Calendar.HOUR_OF_DAY));
        assertEquals(20, observed.get(Calendar.MINUTE));
        assertEquals(30, observed.get(Calendar.SECOND));
        assertEquals(0, observed.get(Calendar.MILLISECOND));
    }

    // ST086-TC006：REQ-003-S02 输出以 acctOpenDate（java.util.Date）给出且成功路径不留空，未新增其它输出字段
    @Test
    void testST086T06() throws NoSuchFieldException {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDate(2026, Calendar.OCTOBER, 9));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertNotNull(output.getAcctOpenDate());
        assertEquals(Date.class, ST086OutputBO.class.getDeclaredField("acctOpenDate").getType());
        assertEquals(Set.of("acctOpenDate"), declaredInstanceFieldNames(ST086OutputBO.class));
        assertTrue(output.isSucceed());
    }

    // ST086-TC007：REQ-004-S01 步骤 2 使用步骤 1 的赋值结果，不重新取数（含远离执行时刻的毫秒值）
    @Test
    void testST086T07() {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDateTime(2025, Calendar.MARCH, 14, 9, 26, 53, 589));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        Calendar observed = calendarOf(output.getAcctOpenDate());
        assertEquals(589, observed.get(Calendar.MILLISECOND));
        assertEquals(9, observed.get(Calendar.HOUR_OF_DAY));
        assertEquals(26, observed.get(Calendar.MINUTE));
        assertEquals(53, observed.get(Calendar.SECOND));
    }

    // ST086-TC008：REQ-004-S02 除返回 acctOpenDate 外无副作用，步骤正常返回且不承载写入结果或状态改写标识
    @Test
    void testST086T08() {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDate(2026, Calendar.OCTOBER, 9));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(Set.of("acctOpenDate"), declaredInstanceFieldNames(ST086OutputBO.class));
    }

    // ST086-TC009：REQ-005-S01 正常执行的结果状态为成功，且不返回任何业务错误码
    @Test
    void testST086T09() {
        ST086InputBO input = new ST086InputBO();
        input.setRunDate(fixedDate(2026, Calendar.OCTOBER, 9));

        ST086OutputBO output = new ST086Pbc().execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST086-TC010：REQ-005-S02 在 java.util.Date 取值域边界（纪元 0、日期上界）上无业务失败出口，也不以默认日期兜底
    @Test
    void testST086T10() {
        List<Date> boundaries = List.of(new Date(0L), new Date(253402300799999L));

        for (Date boundary : boundaries) {
            ST086InputBO input = new ST086InputBO();
            input.setRunDate(boundary);

            ST086OutputBO output = new ST086Pbc().execute(input);

            assertTrue(output.isSucceed());
            assertNull(output.getErrorCode());
            assertNull(output.getErrorMessage());
            assertEquals(input.getRunDate().getTime(), output.getAcctOpenDate().getTime());
        }
    }
}
