package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.facade.bo.ST129InputBO;
import com.dcits.depsit.facade.bo.ST129OutputBO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST129 检查增加限制起始日期 的单元测试。
 *
 * <p>调用签名：{@code ST129OutputBO execute(ST129InputBO input)}；检查结果由
 * {@link StepResult#isSucceed()} 承载（true＝「通过」、false＝「不通过」），
 * 本步骤不定义错误码，不通过时错误字段同样为 null。</p>
 *
 * <p>本步骤为纯入参判定，无 BCC、规则、组件客户端等依赖，故不设桩；
 * 三个日期入参统一按「本地时区当日零点」构造，使判定结果不依赖 Spec
 * 明确不覆盖的「时间粒度」口径。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST129PbcTest {

    @InjectMocks
    private ST129Pbc pbc;

    // ST129-TC001：REQ-001-S01 startDate 早于 runDate 且不晚于 endDate（2026-09-01/2026-10-09/2026-12-31），返回「不通过」
    @Test
    void testST129T01() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 9, 1));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 12, 31));

        ST129OutputBO output = pbc.execute(input);

        assertFalse(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC002：REQ-001-S02 两个不通过条件同时成立（2026-09-01/2026-10-09/2026-08-20），「或者」关系下结果唯一为「不通过」
    @Test
    void testST129T02() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 9, 1));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 8, 20));

        ST129OutputBO output = pbc.execute(input);

        assertFalse(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC003：REQ-002-S01 startDate 晚于 runDate 且晚于 endDate（2026-11-01/2026-10-09/2026-10-20），返回「不通过」
    @Test
    void testST129T03() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 11, 1));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 10, 20));

        ST129OutputBO output = pbc.execute(input);

        assertFalse(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC004：REQ-002-S02 startDate 等于 runDate 但晚于 endDate（2026-10-09/2026-10-09/2026-09-30），「小于」为严格关系，返回「不通过」
    @Test
    void testST129T04() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 10, 9));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 9, 30));

        ST129OutputBO output = pbc.execute(input);

        assertFalse(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC005：REQ-003-S01 startDate 严格介于 runDate 与 endDate 之间（2026-11-01/2026-10-09/2026-12-31），返回「通过」
    @Test
    void testST129T05() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 11, 1));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 12, 31));

        ST129OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC006：REQ-003-S02 下界边界 startDate 等于 runDate（2026-10-09/2026-10-09/2026-12-31），相等不满足「小于」，返回「通过」
    @Test
    void testST129T06() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 10, 9));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 12, 31));

        ST129OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC007：REQ-003-S03 上界边界 startDate 等于 endDate（2026-12-31/2026-10-09/2026-12-31），相等不满足「大于」，返回「通过」
    @Test
    void testST129T07() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 12, 31));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 12, 31));

        ST129OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC008：REQ-003-S04 三个日期取同一值（2026-10-09），两个不通过条件均不成立，返回「通过」
    @Test
    void testST129T08() {
        ST129InputBO input = new ST129InputBO();
        input.setStartDate(date(2026, 10, 9));
        input.setRunDate(date(2026, 10, 9));
        input.setEndDate(date(2026, 10, 9));

        ST129OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST129-TC009：REQ-004-S01 三个占位符与三个入参一一绑定，以反射核对 BO 契约并以两组判别性数据确认绑定方向
    @Test
    void testST129T09() throws Exception {
        // 反射核对：输入 BO 以 java.util.Date 声明三个判定入参，含成对 getter/setter
        assertEquals(Date.class, ST129InputBO.class.getMethod("getStartDate").getReturnType());
        assertEquals(Date.class, ST129InputBO.class.getMethod("getRunDate").getReturnType());
        assertEquals(Date.class, ST129InputBO.class.getMethod("getEndDate").getReturnType());
        assertEquals(Date.class, ST129InputBO.class.getMethod("setStartDate", Date.class).getParameterTypes()[0]);
        assertEquals(Date.class, ST129InputBO.class.getMethod("setRunDate", Date.class).getParameterTypes()[0]);
        assertEquals(Date.class, ST129InputBO.class.getMethod("setEndDate", Date.class).getParameterTypes()[0]);
        // 输出 BO 继承真实 StepResult，且除基类字段外无业务字段
        assertTrue(StepResult.class.isAssignableFrom(ST129OutputBO.class));
        assertEquals(0, ST129OutputBO.class.getDeclaredFields().length);

        // G1：startDate=2026-09-30 早于 runDate=2026-10-09 → 「不通过」；若 {系统日期} 误绑为 endDate（2026-12-31）则会得「通过」
        ST129InputBO g1Input = new ST129InputBO();
        g1Input.setStartDate(date(2026, 9, 30));
        g1Input.setRunDate(date(2026, 10, 9));
        g1Input.setEndDate(date(2026, 12, 31));
        ST129OutputBO g1Output = pbc.execute(g1Input);
        assertFalse(g1Output.isSucceed());

        // G2：startDate=2026-10-15 介于 runDate=2026-10-09 与 endDate=2026-10-20 之间 → 「通过」；若 {结束日期} 误绑为 runDate 则会得「不通过」
        ST129InputBO g2Input = new ST129InputBO();
        g2Input.setStartDate(date(2026, 10, 15));
        g2Input.setRunDate(date(2026, 10, 9));
        g2Input.setEndDate(date(2026, 10, 20));
        ST129OutputBO g2Output = pbc.execute(g2Input);
        assertTrue(g2Output.isSucceed());
    }

    /**
     * 按「本地时区当日零点」构造 java.util.Date，三个入参时间部分一致。
     */
    private static Date date(int year, int month, int day) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
