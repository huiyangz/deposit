package com.dcits.deposit.step;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.facade.bo.ST028InputBO;
import com.dcits.deposit.facade.bo.ST028OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ST028 检查支取账户属性 步骤单元测试。
 *
 * <p>用例来源：测试用例 ST028-TC001（REQ-001-S01 正常路径）、ST028-TC002（REQ-002-S01 跳转路径）、
 * ST028-TC003（REQ-002-S03 返回通过）。</p>
 *
 * <p>查询路径（Spec 待确认事项 TBD-2）确认前，桩仅绑定已确认数据源 {@link IRbBusAcctBcc}（Spec「依赖核对」
 * 确认的账户信息读取入口），返回主表记录（{@link RbBusAcctEO}）；具体桩方法及请求参数待 TBD-2 澄清后按
 * 确认结果调整，业务预期与断言不因此受影响。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST028PbcTest {

    /** 跳转目标步骤名称（Spec「跳转目标」《检查账户到期日》） */
    private static final String GOTO_STEP_CHECK_ACCT_DUE_DATE = "检查账户到期日";

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST028Pbc st028Pbc;

    private ST028InputBO buildInput() {
        ST028InputBO input = new ST028InputBO();
        // baseAcctNo 为 REQ-001-S01 GIVEN 示例值（测试推导用示例数据，非规范常量）
        input.setBaseAcctNo("6000100000012345");
        return input;
    }

    // testST028T01（REQ-001-S01）：账户信息获取返回账户属性为基本存款账户（AcctNatureNo.VALUE_11001），
    // 步骤取得账户属性并作为输出返回，步骤正常完成，不触发跳转
    @Test
    void testST028T01() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctNatureNo(AcctNatureNo.VALUE_11001);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));

        ST028OutputBO result = st028Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(AcctNatureNo.VALUE_11001, result.getAcctNatureNo());
        assertNotEquals(GOTO_STEP_CHECK_ACCT_DUE_DATE, result.getGotoStepName());
    }

    // testST028T02（REQ-002-S01）：账户信息获取返回账户属性为验资户（AcctNatureNo.VALUE_17，取值 "17"），
    // 步骤跳转至《检查账户到期日》正常提前结束（非业务失败），不返回「通过」，输出 acctNatureNo
    @Test
    void testST028T02() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctNatureNo(AcctNatureNo.VALUE_17);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));

        ST028OutputBO result = st028Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(GOTO_STEP_CHECK_ACCT_DUE_DATE, result.getGotoStepName());
        assertEquals(AcctNatureNo.VALUE_17, result.getAcctNatureNo());
    }

    // testST028T03（REQ-002-S03）：账户信息获取返回账户属性为基本存款账户（AcctNatureNo.VALUE_11001，
    // 为「验资户」「临时户」之外取值），返回检查结果「通过」（步骤正常完成），不触发跳转，输出 acctNatureNo
    @Test
    void testST028T03() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctNatureNo(AcctNatureNo.VALUE_11001);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));

        ST028OutputBO result = st028Pbc.execute(buildInput());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNotEquals(GOTO_STEP_CHECK_ACCT_DUE_DATE, result.getGotoStepName());
        assertEquals(AcctNatureNo.VALUE_11001, result.getAcctNatureNo());
    }
}
