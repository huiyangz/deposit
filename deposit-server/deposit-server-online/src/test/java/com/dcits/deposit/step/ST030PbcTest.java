package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.facade.bo.ST030InputBO;
import com.dcits.deposit.facade.bo.ST030OutputBO;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import com.dcits.deposit.rule.DT002;

/**
 * ST030 检查对手账户是否能够入账 单元测试。
 *
 * <p>覆盖正式 Spec 已确认场景（测试用例 ST030-TC001~TC004 及代码审核必须修复补充的
 * REQ-003-S01 用例）：REQ-001 取账户状态、REQ-002-S01/S02、REQ-003-S01/S02、
 * REQ-004-S01/S02、REQ-005-S01/S02、REQ-006-S01 及
 * 单条结果查询多条取首条约定。账户查询无记录（TBD-6）、othBaseAcctNo 必填缺失（TBD-5）、
 * ST052/ST056 返回业务失败（TBD-3）、入账标志取值域外（TBD-2）、失败时输出表字段口径
 * （TBD-7）无已确认预期，不作为本套用例断言，见 ST030Pbc 中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
public class ST030PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @Mock
    private IST052 st052;

    @Mock
    private IST056 st056;

    @InjectMocks
    private ST030Pbc st030Pbc;

    /** 构造输入 BO：othBaseAcctNo=指定对手账号 */
    private ST030InputBO buildInput(String othBaseAcctNo) {
        ST030InputBO input = new ST030InputBO();
        input.setOthBaseAcctNo(othBaseAcctNo);
        return input;
    }

    /** 构造账户查询返回的对公存款账户主表记录（指定账户状态） */
    private RbBusAcctEO buildAccountRecord(AcctStatus acctStatus) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setAcctStatus(acctStatus);
        return eo;
    }

    /** 构造 ST052 返回的组件内步骤结果：正常完成且转账止付标志=指定值 */
    private ST052OutputBO buildStopResult(String stopFlag) {
        ST052OutputBO out = new ST052OutputBO();
        out.setSucceed(true);
        out.setStopFlag(stopFlag);
        return out;
    }

    /** 构造 ST056 返回的组件内步骤结果：正常完成且转账不收不付标志=指定值 */
    private ST056OutputBO buildNoCreditResult(String transferNoCreditNoDebitFlag) {
        ST056OutputBO out = new ST056OutputBO();
        out.setSucceed(true);
        out.setTransferNoCreditNoDebitFlag(transferNoCreditNoDebitFlag);
        return out;
    }

    // 场景 ST030-TC001（REQ-001、REQ-002-S01、REQ-003-S02、REQ-004-S01、REQ-005-S01、REQ-006-S01）：
    // 账户状态=待激活 H，ST052 返回转账止付标志"是"、ST056 返回转账不收不付标志"否"，
    // DT002.execute(H,"是","否")="允许"，步骤按检查结果"通过"正常完成并输出四个业务字段
    @Test
    void testST030T01() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Arrays.asList(buildAccountRecord(AcctStatus.H)));
        lenient().when(st052.execute(any(ST052InputBO.class)))
                .thenReturn(buildStopResult("是"));
        lenient().when(st056.execute(any(ST056InputBO.class)))
                .thenReturn(buildNoCreditResult("否"));
        try (MockedStatic<DT002> mocked = mockStatic(DT002.class)) {
            mocked.when(() -> DT002.execute(AcctStatus.H, "是", "否")).thenReturn("允许");

            ST030OutputBO out = st030Pbc.execute(buildInput("622800000001"));

            assertTrue(out.isSucceed());
            assertNull(out.getErrorCode());
            assertNull(out.getErrorMessage());
            assertEquals("允许", out.getEntryFlag());
            assertEquals("是", out.getTransferStopFlag());
            assertEquals("否", out.getTransferNoCreditNoDebitFlag());
            assertEquals(AcctStatus.H, out.getAcctStatus());
        }
    }

    // 场景 ST030-TC002（REQ-002-S02、REQ-004-S02、REQ-005-S02）：账户状态=久悬 S，
    // ST052 返回"否"、ST056 返回"否"，DT002.execute(S,"否","否")="不允许"，
    // 步骤按业务失败结束返回错误码 ER0077（失败时输出表字段口径见 TBD-7，不作断言）
    @Test
    void testST030T02() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Arrays.asList(buildAccountRecord(AcctStatus.S)));
        lenient().when(st052.execute(any(ST052InputBO.class)))
                .thenReturn(buildStopResult("否"));
        lenient().when(st056.execute(any(ST056InputBO.class)))
                .thenReturn(buildNoCreditResult("否"));
        try (MockedStatic<DT002> mocked = mockStatic(DT002.class)) {
            mocked.when(() -> DT002.execute(AcctStatus.S, "否", "否")).thenReturn("不允许");

            ST030OutputBO out = st030Pbc.execute(buildInput("622800000002"));

            assertFalse(out.isSucceed());
            assertEquals("ER0077", out.getErrorCode());
            assertTrue(out.getErrorMessage().startsWith("ER0077::"));
            assertTrue(out.getErrorMessage().contains("转入账户不允许入账，交易失败"));
        }
    }

    // 场景 ST030-TC003（DT002 规则 f 继承、REQ-005 "否则"分支第二个已确认输入组合）：
    // 账户状态=转营业外 O，ST052 返回"是"、ST056 返回"否"，DT002.execute(O,"是","否")="不允许"，
    // 步骤按业务失败结束返回错误码 ER0077（失败时输出表字段口径见 TBD-7，不作断言）
    @Test
    void testST030T03() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Arrays.asList(buildAccountRecord(AcctStatus.O)));
        lenient().when(st052.execute(any(ST052InputBO.class)))
                .thenReturn(buildStopResult("是"));
        lenient().when(st056.execute(any(ST056InputBO.class)))
                .thenReturn(buildNoCreditResult("否"));
        try (MockedStatic<DT002> mocked = mockStatic(DT002.class)) {
            mocked.when(() -> DT002.execute(AcctStatus.O, "是", "否")).thenReturn("不允许");

            ST030OutputBO out = st030Pbc.execute(buildInput("622800000003"));

            assertFalse(out.isSucceed());
            assertEquals("ER0077", out.getErrorCode());
            assertTrue(out.getErrorMessage().startsWith("ER0077::"));
            assertTrue(out.getErrorMessage().contains("转入账户不允许入账，交易失败"));
        }
    }

    // 场景 ST030-TC004（单条结果查询多条取首条约定）：findByEo 返回两条账户状态不同记录
    // （首条 H、次条 O），步骤只取结果集第一条（H）参与后续判定，返回正常完成
    @Test
    void testST030T04() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Arrays.asList(buildAccountRecord(AcctStatus.H), buildAccountRecord(AcctStatus.O)));
        lenient().when(st052.execute(any(ST052InputBO.class)))
                .thenReturn(buildStopResult("是"));
        lenient().when(st056.execute(any(ST056InputBO.class)))
                .thenReturn(buildNoCreditResult("否"));
        try (MockedStatic<DT002> mocked = mockStatic(DT002.class)) {
            mocked.when(() -> DT002.execute(AcctStatus.H, "是", "否")).thenReturn("允许");

            ST030OutputBO out = st030Pbc.execute(buildInput("622800000001"));

            assertTrue(out.isSucceed());
            assertNull(out.getErrorCode());
            assertNull(out.getErrorMessage());
            assertEquals(AcctStatus.H, out.getAcctStatus());
            assertEquals("允许", out.getEntryFlag());
            assertEquals("是", out.getTransferStopFlag());
            assertEquals("否", out.getTransferNoCreditNoDebitFlag());
        }
    }

    // 场景（代码审核必须修复，补充 REQ-003-S01 覆盖）：账户状态=待激活 H，ST052 返回转账止付
    // 标志"否"、ST056 返回转账不收不付标志"是"，DT002.execute(H,"否","是")="允许"，步骤正常完成。
    // 断言 transferStopFlag="否"（来源 ST052 输出 stopFlag）与 transferNoCreditNoDebitFlag="是"
    // （来源 ST056 输出 transferNoCreditNoDebitFlag）："恒置『否』""恒置『是』"或"ST056 输出误读为
    // stopResult.getStopFlag()" 等错误实现均无法通过本用例
    @Test
    void testST030T05() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Arrays.asList(buildAccountRecord(AcctStatus.H)));
        lenient().when(st052.execute(any(ST052InputBO.class)))
                .thenReturn(buildStopResult("否"));
        lenient().when(st056.execute(any(ST056InputBO.class)))
                .thenReturn(buildNoCreditResult("是"));
        try (MockedStatic<DT002> mocked = mockStatic(DT002.class)) {
            mocked.when(() -> DT002.execute(AcctStatus.H, "否", "是")).thenReturn("允许");

            ST030OutputBO out = st030Pbc.execute(buildInput("622800000001"));

            assertTrue(out.isSucceed());
            assertNull(out.getErrorCode());
            assertNull(out.getErrorMessage());
            assertEquals("否", out.getTransferStopFlag());
            assertEquals("是", out.getTransferNoCreditNoDebitFlag());
            assertEquals("允许", out.getEntryFlag());
            assertEquals(AcctStatus.H, out.getAcctStatus());
        }
    }
}
