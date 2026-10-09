package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.facade.bo.ST048InputBO;
import com.dcits.depsit.facade.bo.ST048OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST048 检查存入账户账户属性 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST048-TC001 至 ST048-TC009（与 `outputs/测试用例.json` 同源），
 * 覆盖 Spec REQ-001 至 REQ-007 的已定义路径：步骤 1 按账号查询【账户信息】获取 [账户属性]、
 * 查不到记录时属性为空、步骤 2「验资户/临时户 → 跳转」与「否则 → 通过」两条互斥分支。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST048PbcTest {

    /** 步骤 1 的【账户信息】查询载体；Spec 未把数据源绑定到具体表/接口，该桩仅作执行载体。 */
    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST048Pbc st048Pbc;

    /** ST048-TC001：REQ-001-S01、REQ-001-S02 输入契约——业务字段恰为 baseAcctNo（String），仅凭账号驱动并返回「通过」。 */
    @Test
    void testST048T01() throws Exception {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(Collections.emptyList());

        Field baseAcctNo = ST048InputBO.class.getDeclaredField("baseAcctNo");
        assertEquals(String.class, baseAcctNo.getType());
        assertEquals(1, ST048InputBO.class.getDeclaredFields().length);

        ST048InputBO input = new ST048InputBO();
        input.setBaseAcctNo("1100609900000000");
        ST048OutputBO output = st048Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /** ST048-TC002：REQ-002-S01、REQ-005-S02、REQ-007-S01 查得一条记录且属性为「基本户」→ 「否则」分支返回「通过」。 */
    @Test
    void testST048T02() {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record(1001, "1100602187654321", AcctNatureNo.VALUE_11001)));

        ST048OutputBO output = st048Pbc.execute(input("1100602187654321"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /** ST048-TC003：REQ-005-S01 查得记录且属性为「专用户」→ 返回「通过」。 */
    @Test
    void testST048T03() {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record(1003, "1100602187654323", AcctNatureNo.VALUE_11004)));

        ST048OutputBO output = st048Pbc.execute(input("1100602187654323"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /** ST048-TC004：REQ-004-S01、REQ-007-S02 属性为「验资户」→ 跳转分支，不表现为「通过」且无错误码。 */
    @Test
    void testST048T04() {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record(1001, "1100602187654321", AcctNatureNo.VALUE_17)));

        ST048OutputBO output = st048Pbc.execute(input("1100602187654321"));

        assertFalse(output.isSucceed());
        assertNull(output.getErrorCode());
    }

    /** ST048-TC005：REQ-004-S02、REQ-007-S02 属性为「临时户」→ 跳转分支，不表现为「通过」且无错误码。 */
    @Test
    void testST048T05() {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record(1002, "1100602187654322", AcctNatureNo.VALUE_11003)));

        ST048OutputBO output = st048Pbc.execute(input("1100602187654322"));

        assertFalse(output.isSucceed());
        assertNull(output.getErrorCode());
    }

    /** ST048-TC006：REQ-002-S02、REQ-003-S01/S02、REQ-005-S03 查不到记录→属性为空并按「不是验资户、也不是临时户」返回「通过」且输出取空。 */
    @Test
    void testST048T06() {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(Collections.emptyList());

        ST048OutputBO output = st048Pbc.execute(input("1100609900000000"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getAcctNatureNo());
    }

    /** ST048-TC007：REQ-006-S01、REQ-006-S03 输出继承真实 StepResult，自身业务字段恰为 acctNatureNo。 */
    @Test
    void testST048T07() throws Exception {
        assertTrue(StepResult.class.isAssignableFrom(ST048OutputBO.class));

        Field[] fields = ST048OutputBO.class.getDeclaredFields();
        assertEquals(1, fields.length);
        assertEquals("acctNatureNo", fields[0].getName());
        assertEquals(AcctNatureNo.class, fields[0].getType());
        assertNotNull(ST048OutputBO.class.getDeclaredMethod("getAcctNatureNo"));
    }

    /** ST048-TC008：REQ-006-S02 枚举绑定与判定成员——「验资户」＝VALUE_17（"17"）、「临时户」＝VALUE_11003（"11003"），其余成员落「否则」分支。 */
    @Test
    void testST048T08() {
        assertEquals("17", AcctNatureNo.VALUE_17.getValue());
        assertEquals("11003", AcctNatureNo.VALUE_11003.getValue());
        assertSame(AcctNatureNo.VALUE_17, AcctNatureNo.byValue("17"));
        assertSame(AcctNatureNo.VALUE_11003, AcctNatureNo.byValue("11003"));
        assertNotNull(AcctNatureNo.VALUE_11001);
        assertNotNull(AcctNatureNo.VALUE_11002);
        assertNotNull(AcctNatureNo.VALUE_11004);
    }

    /** ST048-TC009：REQ-007-S03 只读检查——验资户、基本户、查不到记录三种状态分别执行并各自给出定义结论。 */
    @Test
    void testST048T09() {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record(1001, "1100602187654321", AcctNatureNo.VALUE_17)));
        ST048OutputBO r1 = st048Pbc.execute(input("1100602187654321"));
        assertFalse(r1.isSucceed());
        assertNull(r1.getErrorCode());

        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record(1013, "1100602187654323", AcctNatureNo.VALUE_11001)));
        ST048OutputBO r2 = st048Pbc.execute(input("1100602187654323"));
        assertTrue(r2.isSucceed());
        assertNull(r2.getErrorCode());
        assertNull(r2.getErrorMessage());

        Mockito.lenient().when(rbBusAcctBcc.findByEo(ArgumentMatchers.any(RbBusAcctEO.class)))
                .thenReturn(Collections.emptyList());
        ST048OutputBO r3 = st048Pbc.execute(input("1100609900000000"));
        assertTrue(r3.isSucceed());
        assertNull(r3.getErrorCode());
        assertNull(r3.getErrorMessage());
        assertNull(r3.getAcctNatureNo());
    }

    private static ST048InputBO input(String baseAcctNo) {
        ST048InputBO input = new ST048InputBO();
        input.setBaseAcctNo(baseAcctNo);
        return input;
    }

    private static RbBusAcctEO record(Integer internalKey, String baseAcctNo, AcctNatureNo acctNatureNo) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setInternalKey(internalKey);
        eo.setBaseAcctNo(baseAcctNo);
        eo.setAcctNatureNo(acctNatureNo);
        return eo;
    }
}
