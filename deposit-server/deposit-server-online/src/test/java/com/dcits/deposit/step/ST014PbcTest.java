package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.facade.bo.ST014InputBO;
import com.dcits.deposit.facade.bo.ST014OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST014 检查对手账户类型 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01~S03 已确认场景（用例 ST014-TC001~TC005）。
 * 待确认事项涉及的行为（查询无记录、空/未知账户类型、必填输入缺失）无已确认预期，不作为断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST014PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST014Pbc st014Pbc;

    // 场景：ST014-TC001 查询取得单条记录账户类型为 C-结算账户（非 T 且非 A），检查通过并输出查询取得的账户类型（REQ-001-S01、REQ-002-S03）
    @Test
    void testST014T01() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setRbAcctType(RbAcctType.C);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class))).thenReturn(List.of(record));

        ST014OutputBO output = st014Pbc.execute(newInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RbAcctType.C, output.getRbAcctType());
    }

    // 场景：ST014-TC002 查询取得单条记录账户类型为 T-定期账户，检查失败并返回错误码 ER0052（REQ-002-S01）
    @Test
    void testST014T02() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setRbAcctType(RbAcctType.T);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class))).thenReturn(List.of(record));

        ST014OutputBO output = st014Pbc.execute(newInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0052", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().contains("当前账户不为活期账户"));
        assertEquals(RbAcctType.T, output.getRbAcctType());
    }

    // 场景：ST014-TC003 查询取得单条记录账户类型为 A-AIO账户，检查失败并返回错误码 ER0052（REQ-002-S02）
    @Test
    void testST014T03() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setRbAcctType(RbAcctType.A);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class))).thenReturn(List.of(record));

        ST014OutputBO output = st014Pbc.execute(newInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0052", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().contains("当前账户不为活期账户"));
        assertEquals(RbAcctType.A, output.getRbAcctType());
    }

    // 场景：ST014-TC004 查询取得单条记录账户类型为 S-储蓄账户（非 T 且非 A），检查通过（REQ-002 通过分支）
    @Test
    void testST014T04() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setRbAcctType(RbAcctType.S);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class))).thenReturn(List.of(record));

        ST014OutputBO output = st014Pbc.execute(newInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RbAcctType.S, output.getRbAcctType());
    }

    // 场景：ST014-TC005 查询返回多条记录（第一条 C-结算账户、第二条 T-定期账户），按单条结果查询约定取结果集第一条 C，检查通过
    @Test
    void testST014T05() {
        RbBusAcctEO record1 = new RbBusAcctEO();
        record1.setRbAcctType(RbAcctType.C);
        RbBusAcctEO record2 = new RbBusAcctEO();
        record2.setRbAcctType(RbAcctType.T);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class))).thenReturn(List.of(record1, record2));

        ST014OutputBO output = st014Pbc.execute(newInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(RbAcctType.C, output.getRbAcctType());
    }

    private ST014InputBO newInput() {
        ST014InputBO input = new ST014InputBO();
        input.setOthBaseAcctNo("6222020210000000018");
        return input;
    }
}
