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

import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.facade.bo.ST007InputBO;
import com.dcits.deposit.facade.bo.ST007OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST007 检查对手账户是否存在 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01（ST007-TC001）、REQ-002-S01（ST007-TC002）、REQ-003-S01（ST007-TC003）
 * 及单条结果查询统一约定·多条取第一条（ST007-TC004）。查询请求条件（TBD-1）未确认，
 * 桩按返回侧配置，不断言请求字段；baseAcctNo 取值来源（TBD-2）未确认，不作具体值断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST007PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST007Pbc st007Pbc;

    // 场景（ST007-TC001，REQ-001-S01）：依据有效对手账号查询取得单条对手账户信息并输出 internalKey、acctStatus，步骤成功
    @Test
    void testST007T01() {
        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setInternalKey(1001);
        acct.setAcctStatus(AcctStatus.A);
        acct.setClientNo("900000001");
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));

        ST007InputBO input = new ST007InputBO();
        input.setOthBaseAcctNo("6228480012345678");

        ST007OutputBO result = st007Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(1001, result.getInternalKey());
        assertEquals(AcctStatus.A, result.getAcctStatus());
    }

    // 场景（ST007-TC002，REQ-002-S01）：按对手账号查询未取得对手账户信息（对手账户信息为空）时步骤失败返回 ER0081，不继续执行后续步骤，业务输出字段为空
    @Test
    void testST007T02() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of());

        ST007InputBO input = new ST007InputBO();
        input.setOthBaseAcctNo("6228480099999999");

        ST007OutputBO result = st007Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0081", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0081::"));
        assertTrue(result.getErrorMessage().contains("对手账户不存在"));
        assertNull(result.getInternalKey());
        assertNull(result.getBaseAcctNo());
        assertNull(result.getAcctStatus());
    }

    // 场景（ST007-TC003，REQ-003-S01）：对手账户信息非空（账户状态「关闭」C 的记录仍视为账户信息存在）时检查通过并正常完成
    @Test
    void testST007T03() {
        RbBusAcctEO acct = new RbBusAcctEO();
        acct.setInternalKey(1002);
        acct.setAcctStatus(AcctStatus.C);
        acct.setClientNo("900000002");
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));

        ST007InputBO input = new ST007InputBO();
        input.setOthBaseAcctNo("6228480077776666");

        ST007OutputBO result = st007Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(1002, result.getInternalKey());
        assertEquals(AcctStatus.C, result.getAcctStatus());
    }

    // 场景（ST007-TC004，单条结果查询统一约定·多条）：查询返回多条记录时取结果集第一条作为对手账户信息，检查通过并正常完成
    @Test
    void testST007T04() {
        RbBusAcctEO first = new RbBusAcctEO();
        first.setInternalKey(1003);
        first.setAcctStatus(AcctStatus.A);
        first.setClientNo("900000003");
        RbBusAcctEO second = new RbBusAcctEO();
        second.setInternalKey(1004);
        second.setAcctStatus(AcctStatus.C);
        second.setClientNo("900000004");
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(first, second));

        ST007InputBO input = new ST007InputBO();
        input.setOthBaseAcctNo("6228480055554444");

        ST007OutputBO result = st007Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(1003, result.getInternalKey());
        assertEquals(AcctStatus.A, result.getAcctStatus());
    }
}
