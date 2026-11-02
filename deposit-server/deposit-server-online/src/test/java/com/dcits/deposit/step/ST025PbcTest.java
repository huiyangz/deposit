package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST025InputBO;
import com.dcits.deposit.facade.bo.ST025OutputBO;
import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;
import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;
import com.dcits.deposit.facade.bo.ST058InputBO;
import com.dcits.deposit.facade.bo.ST058OutputBO;

/**
 * ST025 检查法透账户支取限制 单元测试。
 *
 * <p>覆盖本轮已确认用例 ST025-TC001~TC004（REQ-001-S01、REQ-002-S01、
 * REQ-003-S01/S02、REQ-004-S01、REQ-005-S01/S02、REQ-006-S01、REQ-007-S01/S02、
 * REQ-008-S01）。失败路径短路上不执行后续步骤：TC002 仅对 IST058 设桩、
 * TC003 仅对 IST058/IST055 设桩，后续目标步骤不设桩，按技能不采用调用次数/verify 验证，
 * 跳转证明以最终失败状态（succeed=false + 对应 errorCode）与桩覆盖范围为准。
 * 未覆盖事项：TBD-1 标志「是」/「否」物理编码、TBD-2「通过」结论承载方式、
 * TBD-3 baseAcctNo 缺失行为、TBD-4 失败路径输出填充、TBD-5 步骤 1 组件内绑定 ST058，
 * 待业务确认后补充用例。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST025PbcTest {

    @Mock
    private IST058 st058;

    @Mock
    private IST055 st055;

    @Mock
    private IST050 st050;

    @InjectMocks
    private ST025Pbc st025Pbc;

    // 正常路径 ST025-TC001：ST058/ST055/ST050 分别返回不收不付标志、止付标志（stopFlag）、有权机关冻结标志（ahBuFlag）均为「否」，步骤 2/4/6 判定均通过，返回检查结果「通过」并正常完成，三个目标步骤收到的 {账号} 均为输入 baseAcctNo
    @Test
    void testST025T01() {
        // 构造输入：账号
        ST025InputBO input = new ST025InputBO();
        input.setBaseAcctNo("6222020000000000001");

        // 桩：IST058 捕获收到的 {账号}，返回成功（不收不付标志「否」）
        AtomicReference<String> st058Acct = new AtomicReference<>();
        ST058OutputBO st058Result = new ST058OutputBO();
        st058Result.setNoCreditNoDebitFlag("否");
        st058Result.setSucceed(true);
        lenient().when(st058.execute(any(ST058InputBO.class))).thenAnswer(invocation -> {
            st058Acct.set(((ST058InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st058Result;
        });

        // 桩：IST055 捕获收到的 {账号}，返回成功（止付标志「否」）
        AtomicReference<String> st055Acct = new AtomicReference<>();
        ST055OutputBO st055Result = new ST055OutputBO();
        st055Result.setStopFlag("否");
        st055Result.setSucceed(true);
        lenient().when(st055.execute(any(ST055InputBO.class))).thenAnswer(invocation -> {
            st055Acct.set(((ST055InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st055Result;
        });

        // 桩：IST050 捕获收到的 {账号}，返回成功（有权机关冻结标志「否」）
        AtomicReference<String> st050Acct = new AtomicReference<>();
        ST050OutputBO st050Result = new ST050OutputBO();
        st050Result.setAhBuFlag("否");
        st050Result.setSucceed(true);
        lenient().when(st050.execute(any(ST050InputBO.class))).thenAnswer(invocation -> {
            st050Acct.set(((ST050InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st050Result;
        });

        // 执行
        ST025OutputBO output = st025Pbc.execute(input);

        // 断言：检查结果「通过」，成功、错误字段为 null，输出三标志字段，三个目标步骤桩收到的 {账号} 均为输入账号
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getNoCreditNoDebitFlag());
        assertEquals("否", output.getStopFlag());
        assertEquals("否", output.getAhBuFlag());
        assertEquals("6222020000000000001", st058Acct.get());
        assertEquals("6222020000000000001", st055Acct.get());
        assertEquals("6222020000000000001", st050Acct.get());
    }

    // 错误码路径 ST025-TC002：步骤 1 取得不收不付标志「是」，步骤 2 判定失败短路返回 ER0059，不执行获取止付标志及其后步骤（IST055/IST050 不设桩、未触达）
    @Test
    void testST025T02() {
        // 构造输入：账号
        ST025InputBO input = new ST025InputBO();
        input.setBaseAcctNo("6222020000000000001");

        // 桩：仅 IST058 捕获收到的 {账号}，返回成功（不收不付标志「是」）
        AtomicReference<String> st058Acct = new AtomicReference<>();
        ST058OutputBO st058Result = new ST058OutputBO();
        st058Result.setNoCreditNoDebitFlag("是");
        st058Result.setSucceed(true);
        lenient().when(st058.execute(any(ST058InputBO.class))).thenAnswer(invocation -> {
            st058Acct.set(((ST058InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st058Result;
        });

        // 执行
        ST025OutputBO output = st025Pbc.execute(input);

        // 断言：失败、errorCode=ER0059、errorMessage 按 错误码::业务说明 格式（仅核对格式，不做等值断言），IST058 收到 {账号}=输入账号；失败路径输出字段取值未定义（TBD-4），不作断言
        assertEquals(false, output.isSucceed());
        assertEquals("ER0059", output.getErrorCode());
        assertTrue(output.getErrorMessage() != null && output.getErrorMessage().startsWith("ER0059::"));
        assertEquals("6222020000000000001", st058Acct.get());
    }

    // 错误码路径 ST025-TC003：不收不付标志「否」继续执行，步骤 3 取得止付标志「是」，步骤 4 判定失败短路返回 ER0065，不执行获取有权机关冻结标志及其后步骤（IST050 不设桩、未触达）
    @Test
    void testST025T03() {
        // 构造输入：账号
        ST025InputBO input = new ST025InputBO();
        input.setBaseAcctNo("6222020000000000001");

        // 桩：IST058 捕获收到的 {账号}，返回成功（不收不付标志「否」）
        AtomicReference<String> st058Acct = new AtomicReference<>();
        ST058OutputBO st058Result = new ST058OutputBO();
        st058Result.setNoCreditNoDebitFlag("否");
        st058Result.setSucceed(true);
        lenient().when(st058.execute(any(ST058InputBO.class))).thenAnswer(invocation -> {
            st058Acct.set(((ST058InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st058Result;
        });

        // 桩：IST055 捕获收到的 {账号}，返回成功（止付标志「是」）
        AtomicReference<String> st055Acct = new AtomicReference<>();
        ST055OutputBO st055Result = new ST055OutputBO();
        st055Result.setStopFlag("是");
        st055Result.setSucceed(true);
        lenient().when(st055.execute(any(ST055InputBO.class))).thenAnswer(invocation -> {
            st055Acct.set(((ST055InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st055Result;
        });

        // 执行
        ST025OutputBO output = st025Pbc.execute(input);

        // 断言：失败、errorCode=ER0065、errorMessage 按 错误码::业务说明 格式（仅核对格式，不做等值断言），IST058/IST055 收到 {账号}=输入账号；失败路径输出字段取值未定义（TBD-4），不作断言
        assertEquals(false, output.isSucceed());
        assertEquals("ER0065", output.getErrorCode());
        assertTrue(output.getErrorMessage() != null && output.getErrorMessage().startsWith("ER0065::"));
        assertEquals("6222020000000000001", st058Acct.get());
        assertEquals("6222020000000000001", st055Acct.get());
    }

    // 错误码路径 ST025-TC004：三个标志依次「否」「否」「是」，步骤 5 取得 ahBuFlag「是」，步骤 6 判定失败返回 ER0066
    @Test
    void testST025T04() {
        // 构造输入：账号
        ST025InputBO input = new ST025InputBO();
        input.setBaseAcctNo("6222020000000000001");

        // 桩：IST058 捕获收到的 {账号}，返回成功（不收不付标志「否」）
        AtomicReference<String> st058Acct = new AtomicReference<>();
        ST058OutputBO st058Result = new ST058OutputBO();
        st058Result.setNoCreditNoDebitFlag("否");
        st058Result.setSucceed(true);
        lenient().when(st058.execute(any(ST058InputBO.class))).thenAnswer(invocation -> {
            st058Acct.set(((ST058InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st058Result;
        });

        // 桩：IST055 捕获收到的 {账号}，返回成功（止付标志「否」）
        AtomicReference<String> st055Acct = new AtomicReference<>();
        ST055OutputBO st055Result = new ST055OutputBO();
        st055Result.setStopFlag("否");
        st055Result.setSucceed(true);
        lenient().when(st055.execute(any(ST055InputBO.class))).thenAnswer(invocation -> {
            st055Acct.set(((ST055InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st055Result;
        });

        // 桩：IST050 捕获收到的 {账号}，返回成功（有权机关冻结标志「是」）
        AtomicReference<String> st050Acct = new AtomicReference<>();
        ST050OutputBO st050Result = new ST050OutputBO();
        st050Result.setAhBuFlag("是");
        st050Result.setSucceed(true);
        lenient().when(st050.execute(any(ST050InputBO.class))).thenAnswer(invocation -> {
            st050Acct.set(((ST050InputBO) invocation.getArgument(0)).getBaseAcctNo());
            return st050Result;
        });

        // 执行
        ST025OutputBO output = st025Pbc.execute(input);

        // 断言：失败、errorCode=ER0066、errorMessage 按 错误码::业务说明 格式（仅核对格式，不做等值断言），三个目标步骤收到 {账号}=输入账号；失败路径输出字段取值未定义（TBD-4），不作断言
        assertEquals(false, output.isSucceed());
        assertEquals("ER0066", output.getErrorCode());
        assertTrue(output.getErrorMessage() != null && output.getErrorMessage().startsWith("ER0066::"));
        assertEquals("6222020000000000001", st058Acct.get());
        assertEquals("6222020000000000001", st055Acct.get());
        assertEquals("6222020000000000001", st050Acct.get());
    }
}
