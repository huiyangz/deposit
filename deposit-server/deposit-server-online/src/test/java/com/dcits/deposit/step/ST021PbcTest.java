package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST021InputBO;
import com.dcits.deposit.facade.bo.ST021OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import com.dcits.deposit.enums.RbAcctType;

/**
 * ST021 检查支取账户类型 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01/S02、REQ-003-S01/S02 已确认判定场景
 * （测试用例 ST021-TC001~TC005）。TBD-2（必填缺失）、TBD-3（查询无记录、账户类型为空）
 * 及 baseAcctNo 到查询 EO 的定位字段映射无已确认预期，不作为本套用例断言，见实现中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST021PbcTest {

    @Mock
    private IRbBusAcctBcc irbBusAcctBcc;

    @InjectMocks
    private ST021Pbc st021Pbc;

    // 场景：REQ-001-S01 + REQ-002-S01（ST021-TC001）：按账号 1234567890123 查询，账户类型为 C，既非 T 且非 A，检查通过，输出 rbAcctType=RbAcctType.C
    @Test
    void testST021T01() {
        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setRbAcctType(RbAcctType.C);
        lenient().when(irbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));

        ST021InputBO input = new ST021InputBO();
        input.setBaseAcctNo("1234567890123");

        ST021OutputBO output = st021Pbc.execute(input);
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RbAcctType.C, output.getRbAcctType());
    }

    // 场景：REQ-002-S02（ST021-TC002）：按账号 1234567890124 查询，账户类型为 S，检查通过，输出 rbAcctType=RbAcctType.S
    @Test
    void testST021T02() {
        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setRbAcctType(RbAcctType.S);
        lenient().when(irbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));

        ST021InputBO input = new ST021InputBO();
        input.setBaseAcctNo("1234567890124");

        ST021OutputBO output = st021Pbc.execute(input);
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RbAcctType.S, output.getRbAcctType());
    }

    // 场景：单条结果查询返回多条记录（ST021-TC003）：按账号 1234567890125 查询返回两条（C、T），按统一约定取结果集第一条 C，检查通过
    @Test
    void testST021T03() {
        RbBusAcctEO acctFirst = new RbBusAcctEO();
        acctFirst.setRbAcctType(RbAcctType.C);
        RbBusAcctEO acctSecond = new RbBusAcctEO();
        acctSecond.setRbAcctType(RbAcctType.T);
        lenient().when(irbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acctFirst, acctSecond));

        ST021InputBO input = new ST021InputBO();
        input.setBaseAcctNo("1234567890125");

        ST021OutputBO output = st021Pbc.execute(input);
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RbAcctType.C, output.getRbAcctType());
    }

    // 场景：REQ-003-S01（ST021-TC004）：按账号 1234567890126 查询，账户类型为 T（定期账户），检查失败，返回错误码 ER0052
    @Test
    void testST021T04() {
        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setRbAcctType(RbAcctType.T);
        lenient().when(irbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));

        ST021InputBO input = new ST021InputBO();
        input.setBaseAcctNo("1234567890126");

        ST021OutputBO output = st021Pbc.execute(input);
        assertFalse(output.isSucceed());
        assertEquals("ER0052", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().startsWith("ER0052::"));
    }

    // 场景：REQ-003-S02（ST021-TC005）：按账号 1234567890127 查询，账户类型为 A（AIO账户），检查失败，返回错误码 ER0052
    @Test
    void testST021T05() {
        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setRbAcctType(RbAcctType.A);
        lenient().when(irbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));

        ST021InputBO input = new ST021InputBO();
        input.setBaseAcctNo("1234567890127");

        ST021OutputBO output = st021Pbc.execute(input);
        assertFalse(output.isSucceed());
        assertEquals("ER0052", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().startsWith("ER0052::"));
    }
}
