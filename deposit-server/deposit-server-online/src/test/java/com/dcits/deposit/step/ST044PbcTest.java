package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST044 登记累计限额 交易执行步骤单元测试。
 *
 * <p>覆盖本轮已确认断言：触发条件的 5 种分支（登记/不登记）、登记字段赋值
 * （limitSceneNo 等于输入、limitSumAmt 等于交易金额、否等于 1）、生效日期等于系统日期、
 * 失效日期按已确认周期类型（日/月）计算、登记与不登记两条路径均成功结束。
 * checkObjVal 具体取值（待确认事项 1，检查对象类型配置来源未确认）与"其它字段"生成规则
 * （待确认事项 5）澄清前不作已确认断言，对应断言缺口见类内 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
public class ST044PbcTest {

    @Mock
    private IRbLimitSumInfoBcc limitSumInfoBcc;

    @Mock
    private IRbLimitCtrlConfBcc limitCtrlConfBcc;

    @InjectMocks
    private ST044Pbc st044Pbc;

    /** ST044-TC001（REQ-001-S01/REQ-002-S01/REQ-003-S01/REQ-004-S01/REQ-006-S01）：检查通过且累计金额与累计笔数均为零时登记，登记字段赋值正确，成功结束 */
    @Test
    public void testST044T01() {
        stubPeriodConfig(TermType.D, "30");
        stubWrite();
        ST044InputBO input = buildInput("未超限", "0.00", Integer.valueOf(0));
        ST044OutputBO output = st044Pbc.execute(input);
        assertRegisterOutput(output);
    }

    /** ST044-TC002（REQ-001-S02）：检查通过、累计金额为 0.00、累计笔数为 3 时登记，命中"限额累计金额等于 0"分支 */
    @Test
    public void testST044T02() {
        stubPeriodConfig(TermType.D, "30");
        stubWrite();
        ST044InputBO input = buildInput("未超限", "0.00", Integer.valueOf(3));
        ST044OutputBO output = st044Pbc.execute(input);
        assertRegisterOutput(output);
    }

    /** ST044-TC003（REQ-001-S03）：检查通过、累计金额为 100.00、累计笔数为 0 时登记，命中"限额累计笔数等于 0"分支 */
    @Test
    public void testST044T03() {
        stubPeriodConfig(TermType.D, "30");
        stubWrite();
        ST044InputBO input = buildInput("未超限", "100.00", Integer.valueOf(0));
        ST044OutputBO output = st044Pbc.execute(input);
        assertRegisterOutput(output);
    }

    /** ST044-TC004（REQ-001-S04/REQ-006-S02）：检查通过但累计金额与累计笔数均非零时不登记，不产生输出，成功正常结束，不触达任何依赖 */
    @Test
    public void testST044T04() {
        ST044InputBO input = buildInput("未超限", "100.00", Integer.valueOf(3));
        ST044OutputBO output = st044Pbc.execute(input);
        assertNoRegisterOutput(output);
    }

    /** ST044-TC005（REQ-001-S05/REQ-006-S02）：限额检查结果非"未超限"（示例取值"超限"）时不登记，不产生输出，成功正常结束 */
    @Test
    public void testST044T05() {
        ST044InputBO input = buildInput("超限", "0.00", Integer.valueOf(0));
        ST044OutputBO output = st044Pbc.execute(input);
        assertNoRegisterOutput(output);
    }

    /** ST044-TC006（REQ-003-S02）：检查对象类型为"客户"（CUST）时 checkObjVal 取客户号；配置来源见待确认事项 1，checkObjVal 具体取值不作已确认断言，其余输出同 TC001 */
    @Test
    public void testST044T06() {
        stubPeriodConfig(TermType.D, "30");
        stubWrite();
        ST044InputBO input = buildInput("未超限", "0.00", Integer.valueOf(0));
        ST044OutputBO output = st044Pbc.execute(input);
        assertRegisterOutput(output);
    }

    /** ST044-TC007（REQ-004-S02）：周期类型为"月"（M）、周期值为 "1" 时失效日期为系统日期加 1 个月（2026-11-30） */
    @Test
    public void testST044T07() {
        stubPeriodConfig(TermType.M, "1");
        stubWrite();
        ST044InputBO input = buildInput("未超限", "0.00", Integer.valueOf(0));
        ST044OutputBO output = st044Pbc.execute(input);
        assertRegisterOutput(output);
    }

    /** ST044-TC008（REQ-005-S01）：经 ArgumentCaptor 捕获写入桩收到的 EO，核对已确认字段与 Spec 一致、客户号按输入赋值非空；checkObjVal 与"其它字段"取值断言依赖待确认事项 1/5 */
    @Test
    public void testST044T08() {
        stubPeriodConfig(TermType.D, "30");
        ArgumentCaptor<RbLimitSumInfoEO> captor = ArgumentCaptor.forClass(RbLimitSumInfoEO.class);
        Mockito.lenient().when(limitSumInfoBcc.create(captor.capture())).thenReturn(1);
        ST044InputBO input = buildInput("未超限", "0.00", Integer.valueOf(0));
        ST044OutputBO output = st044Pbc.execute(input);
        assertRegisterOutput(output);
        RbLimitSumInfoEO captured = captor.getValue();
        assertEquals("LMT001", captured.getLimitSceneNo());
        assertEquals(new BigDecimal("100.00"), captured.getLimitSumAmt());
        assertEquals(Integer.valueOf(1), captured.get否());
        assertEquals(new GregorianCalendar(2026, Calendar.OCTOBER, 31).getTime(), captured.getEffectDate());
        assertEquals(new GregorianCalendar(2026, Calendar.NOVEMBER, 30).getTime(), captured.getExpireDate());
        assertNotNull(captured.getClientNo());
        assertEquals("10000001", captured.getClientNo());
        // FIXME 业务项:ST044 登记累计限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:{登记写入 EO 的 checkObjVal（待确认事项 1）与 createTimestamp、reference、lastUpdTimestamp 等"其它字段"（待确认事项 5）断言依赖配置来源与生成规则} - 影响:{本次不作该等字段的已确认断言，真实落库时的非空约束待业务确认} - 待确认:{检查对象类型配置来源及"其它字段"生成规则}
    }

    /** 构造用例输入：固定账号、客户号、交易金额 100.00、场景编码 LMT001、系统日期 2026-10-31，仅触发相关取值按参数给定 */
    private ST044InputBO buildInput(String checkResult, String limitSumAmt, Integer sumCount) {
        ST044InputBO input = new ST044InputBO();
        input.set限额检查结果(checkResult);
        input.setBaseAcctNo("62010000001234");
        input.setClientNo("10000001");
        input.setTranAmt(new BigDecimal("100.00"));
        input.setLimitSceneNo("LMT001");
        input.setLimitSumAmt(new BigDecimal(limitSumAmt));
        input.set否(sumCount);
        input.setRunDate(new GregorianCalendar(2026, Calendar.OCTOBER, 31).getTime());
        return input;
    }

    /** 桩：周期配置查询（RB_LIMIT_CTRL_CONF）按 limitSceneNo 返回单条周期配置 */
    private void stubPeriodConfig(TermType periodType, String periodValue) {
        RbLimitCtrlConfEO conf = new RbLimitCtrlConfEO();
        conf.setPeriodType(periodType);
        conf.setPeriodValue(periodValue);
        Mockito.lenient().when(limitCtrlConfBcc.findByEo(Mockito.any(RbLimitCtrlConfEO.class)))
                .thenReturn(Collections.singletonList(conf));
    }

    /** 桩：登记写入返回成功条数 1 */
    private void stubWrite() {
        Mockito.lenient().when(limitSumInfoBcc.create(Mockito.any(RbLimitSumInfoEO.class))).thenReturn(1);
    }

    /** 登记路径已确认输出断言（TC001/TC002/TC003/TC006/TC007/TC008 共用）；checkObjVal 具体取值不作断言，见待确认事项 1 FIXME */
    private void assertRegisterOutput(ST044OutputBO output) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("LMT001", output.getLimitSceneNo());
        assertEquals(new BigDecimal("100.00"), output.getLimitSumAmt());
        assertEquals(Integer.valueOf(1), output.get否());
        assertEquals(new GregorianCalendar(2026, Calendar.OCTOBER, 31).getTime(), output.getEffectDate());
        assertEquals(new GregorianCalendar(2026, Calendar.NOVEMBER, 30).getTime(), output.getExpireDate());
    }

    /** 不登记路径断言（TC004/TC005 共用）：成功结束、错误字段为空、6 个业务输出均为 null */
    private void assertNoRegisterOutput(ST044OutputBO output) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSceneNo());
        assertNull(output.getCheckObjVal());
        assertNull(output.getLimitSumAmt());
        assertNull(output.get否());
        assertNull(output.getEffectDate());
        assertNull(output.getExpireDate());
    }
}
