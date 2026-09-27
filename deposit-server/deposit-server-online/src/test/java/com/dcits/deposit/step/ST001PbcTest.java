package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST001InputBO;
import com.dcits.deposit.facade.bo.ST001OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

/**
 * ST001 检查账户到期日 单元测试
 * 用例来源：outputs/测试用例.md（ST001-TC001～TC005）
 * 数据流核对：findByEo 桩内记录收到的查询 EO，断言其 baseAcctNo 等于输入账号，不做调用次数断言。
 */
@ExtendWith(MockitoExtension.class)
class ST001PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST001Pbc st001Pbc;

    /** 桩收到的查询 EO，供数据流核对 */
    private RbBusAcctEO receivedCondition;

    // 场景：账户记录存在，账户到期日期(2026-12-31)晚于交易日期(2026-09-28)，到期检查通过；预期 succeed=true、acctDueDate=2026-12-31
    @Test
    void testST001T01() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("200001234560001");
        record.setAcctDueDate(parseDate("2026-12-31"));
        stubFindByEoReturning(Collections.singletonList(record));

        ST001InputBO input = new ST001InputBO();
        input.setBaseAcctNo("200001234560001");
        input.setTranDate(parseDate("2026-09-28"));

        ST001OutputBO output = st001Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(parseDate("2026-12-31"), output.getAcctDueDate());
        assertEquals("200001234560001", receivedCondition.getBaseAcctNo());
    }

    // 场景：账户记录存在但账户到期日期为空，跳过到期检查直接返回通过，日期比较不执行；预期 succeed=true、acctDueDate=null
    @Test
    void testST001T02() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("200001234560001");
        record.setAcctDueDate(null);
        stubFindByEoReturning(Collections.singletonList(record));

        ST001InputBO input = new ST001InputBO();
        input.setBaseAcctNo("200001234560001");
        input.setTranDate(parseDate("2026-09-28"));

        ST001OutputBO output = st001Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getAcctDueDate());
        assertEquals("200001234560001", receivedCondition.getBaseAcctNo());
    }

    // 场景：账户到期日期等于交易日期(同为2026-09-28)，不满足"小于"条件；预期 succeed=true、acctDueDate=2026-09-28
    @Test
    void testST001T03() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("200001234560001");
        record.setAcctDueDate(parseDate("2026-09-28"));
        stubFindByEoReturning(Collections.singletonList(record));

        ST001InputBO input = new ST001InputBO();
        input.setBaseAcctNo("200001234560001");
        input.setTranDate(parseDate("2026-09-28"));

        ST001OutputBO output = st001Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(parseDate("2026-09-28"), output.getAcctDueDate());
        assertEquals("200001234560001", receivedCondition.getBaseAcctNo());
    }

    // 场景：账户到期日期(2026-09-27)早于交易日期(2026-09-28)一日，命中"小于"条件；预期 succeed=false、errorCode=ER0054、acctDueDate=2026-09-27
    @Test
    void testST001T04() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setBaseAcctNo("200001234560001");
        record.setAcctDueDate(parseDate("2026-09-27"));
        stubFindByEoReturning(Collections.singletonList(record));

        ST001InputBO input = new ST001InputBO();
        input.setBaseAcctNo("200001234560001");
        input.setTranDate(parseDate("2026-09-28"));

        ST001OutputBO output = st001Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0054", output.getErrorCode());
        assertTrue(output.getErrorMessage().startsWith("ER0054::"));
        assertEquals(parseDate("2026-09-27"), output.getAcctDueDate());
        assertEquals("200001234560001", receivedCondition.getBaseAcctNo());
    }

    // 场景：账号未查询到【账户信息】记录（BCC 返回空集合），子步骤1 提前返回业务失败，子步骤2 不执行；预期 succeed=false、acctDueDate=null（SPEC 未定义该失败路径错误码，不断言错误字段具体值）
    @Test
    void testST001T05() {
        stubFindByEoReturning(Collections.emptyList());

        ST001InputBO input = new ST001InputBO();
        input.setBaseAcctNo("200001234560001");
        input.setTranDate(parseDate("2026-09-28"));

        ST001OutputBO output = st001Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertNull(output.getAcctDueDate());
        assertEquals("200001234560001", receivedCondition.getBaseAcctNo());
    }

    /** 设定 findByEo 桩返回值，并记录桩收到的查询 EO 供数据流核对 */
    private void stubFindByEoReturning(List<RbBusAcctEO> records) {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            receivedCondition = invocation.getArgument(0);
            return records;
        });
    }

    /** 按 yyyy-MM-dd 构造确定日期值，时间部分 00:00:00.000 */
    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new IllegalStateException("测试日期字面值非法: " + date, e);
        }
    }
}
