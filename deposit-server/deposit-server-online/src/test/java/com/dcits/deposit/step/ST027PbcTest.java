package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.facade.bo.ST027InputBO;
import com.dcits.deposit.facade.bo.ST027OutputBO;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST027 检查账户是否能够出账 单元测试。
 *
 * <p>覆盖正式 Spec 已确认场景（测试用例 ST027-TC001~TC004）：REQ-001-S01、REQ-002-S01、
 * REQ-003-S01、REQ-004-S01/S02、REQ-005-S01/S02，以及单条结果查询多条取结果集第一条约定
 * （TC004 判别）。组件内步骤 IST052/IST056 按类型 any 匹配设桩（TBD-2 按账号查询工程口径未确认，
 * 不断言查询请求字段），决策规则 DT001 静态方法真实执行（不 mockStatic）。查询无记录（TBD-5）、
 * baseAcctNo 必填缺失（TBD-6）、按账号查询工程口径（TBD-2）、两个标志物理编码（TBD-4）、
 * 出账标志物理取值（TBD-3）无已确认预期，不作为本套用例断言，见 ST027Pbc 中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
public class ST027PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @Mock
    private IST052 ist052;

    @Mock
    private IST056 ist056;

    @InjectMocks
    private ST027Pbc st027Pbc;

    /** 构造桩返回的对公存款账户主表账户记录（指定账户状态） */
    private RbBusAcctEO buildAcctRecord(AcctStatus acctStatus) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setAcctStatus(acctStatus);
        return eo;
    }

    /** 构造桩返回的 ST052 输出：指定转账止付标志，步骤成功结束 */
    private ST052OutputBO buildSt052Output(String stopFlag) {
        ST052OutputBO out = new ST052OutputBO();
        out.setSucceed(true);
        out.setStopFlag(stopFlag);
        return out;
    }

    /** 构造桩返回的 ST056 输出：指定转账不收不付标志，步骤成功结束 */
    private ST056OutputBO buildSt056Output(String transferNoCreditNoDebitFlag) {
        ST056OutputBO out = new ST056OutputBO();
        out.setSucceed(true);
        out.setTransferNoCreditNoDebitFlag(transferNoCreditNoDebitFlag);
        return out;
    }

    /** 构造输入 BO：baseAcctNo="6222000000000001" */
    private ST027InputBO buildInput() {
        ST027InputBO input = new ST027InputBO();
        input.setBaseAcctNo("6222000000000001");
        return input;
    }

    // 场景 ST027-TC001（REQ-001-S01、REQ-004-S01、REQ-005-S01）：账号存在「活动」（A）账户记录，
    // ST052 返回转账止付标志「否」、ST056 返回转账不收不付标志「否」，DT001 规则 d 组合
    // (A, 否, 否) 返回出账标志「允许」，检查结果「通过」、步骤成功结束（错误字段为 null）
    @Test
    void testST027T01() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Collections.singletonList(buildAcctRecord(AcctStatus.A)));
        lenient().when(ist052.execute(any(ST052InputBO.class))).thenReturn(buildSt052Output("否"));
        lenient().when(ist056.execute(any(ST056InputBO.class))).thenReturn(buildSt056Output("否"));

        ST027OutputBO out = st027Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals(AcctStatus.A, out.getAcctStatus());
        assertEquals("否", out.getTransferStopFlag());
        assertEquals("否", out.getTransferNoCreditNoDebitFlag());
        assertEquals("允许", out.getDebitFlag());
    }

    // 场景 ST027-TC002（REQ-004-S02、REQ-005-S02）：账号「关闭」（C），ST052 返回「否」、
    // ST056 返回「否」，DT001 规则 g 组合 (C, 否, 否) 返回出账标志「不允许」，步骤失败返回 ER0076，
    // 不返回「通过」
    @Test
    void testST027T02() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Collections.singletonList(buildAcctRecord(AcctStatus.C)));
        lenient().when(ist052.execute(any(ST052InputBO.class))).thenReturn(buildSt052Output("否"));
        lenient().when(ist056.execute(any(ST056InputBO.class))).thenReturn(buildSt056Output("否"));

        ST027OutputBO out = st027Pbc.execute(buildInput());

        assertFalse(out.isSucceed());
        assertEquals("ER0076", out.getErrorCode());
        assertEquals("ER0076::转出账户不允许出账，交易失败", out.getErrorMessage());
        assertEquals(AcctStatus.C, out.getAcctStatus());
        assertEquals("否", out.getTransferStopFlag());
        assertEquals("否", out.getTransferNoCreditNoDebitFlag());
        assertEquals("不允许", out.getDebitFlag());
    }

    // 场景 ST027-TC003（REQ-004 规则 c 组合，依据 DT001 Spec；REQ-005-S02）：账号「待激活」（H），
    // ST052 返回转账止付标志「是」（REQ-002-S01）、ST056 返回「否」，DT001 组合 (H, 是, 否)
    // 返回出账标志「不允许」，步骤失败返回 ER0076
    @Test
    void testST027T03() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Collections.singletonList(buildAcctRecord(AcctStatus.H)));
        lenient().when(ist052.execute(any(ST052InputBO.class))).thenReturn(buildSt052Output("是"));
        lenient().when(ist056.execute(any(ST056InputBO.class))).thenReturn(buildSt056Output("否"));

        ST027OutputBO out = st027Pbc.execute(buildInput());

        assertFalse(out.isSucceed());
        assertEquals("ER0076", out.getErrorCode());
        assertEquals("ER0076::转出账户不允许出账，交易失败", out.getErrorMessage());
        assertEquals(AcctStatus.H, out.getAcctStatus());
        assertEquals("是", out.getTransferStopFlag());
        assertEquals("否", out.getTransferNoCreditNoDebitFlag());
        assertEquals("不允许", out.getDebitFlag());
    }

    // 场景 ST027-TC004（边界路径）：BCC 按账号查询返回两条账户记录（首条 A、次条 C），按单条结果
    // 查询统一约定取结果集第一条 A 继续，DT001 规则 d 组合 (A, 否, 否) 返回「允许」、步骤成功；
    // 若实现误用次条 C 则出账「不允许」→ER0076，断言可判别只使用第一条
    @Test
    void testST027T04() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Arrays.asList(buildAcctRecord(AcctStatus.A), buildAcctRecord(AcctStatus.C)));
        lenient().when(ist052.execute(any(ST052InputBO.class))).thenReturn(buildSt052Output("否"));
        lenient().when(ist056.execute(any(ST056InputBO.class))).thenReturn(buildSt056Output("否"));

        ST027OutputBO out = st027Pbc.execute(buildInput());

        assertTrue(out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals(AcctStatus.A, out.getAcctStatus());
        assertEquals("否", out.getTransferStopFlag());
        assertEquals("否", out.getTransferNoCreditNoDebitFlag());
        assertEquals("允许", out.getDebitFlag());
    }
}
