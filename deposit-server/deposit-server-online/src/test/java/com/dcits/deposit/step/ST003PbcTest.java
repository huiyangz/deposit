package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.facade.bo.ST003InputBO;
import com.dcits.deposit.facade.bo.ST003OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST003 检查对手账户属性 步骤单元测试。
 *
 * <p>用例来源：测试用例 ST003-TC001（REQ-001-S01 正常路径）、ST003-TC002（REQ-002-S01 跳转路径）、
 * ST003-TC004（REQ-002-S03 返回通过）。</p>
 *
 * <p>查询路径（Spec 待确认事项 TBD-2）确认前，桩仅绑定已确认数据源 {@link IRbBusAcctBcc}（Spec
 * 确认的账户信息读取入口），返回主表记录（{@link RbBusAcctEO}）；具体桩方法及请求参数待 TBD-2
 * 澄清后按确认结果调整，业务预期与断言不因此受影响。</p>
 *
 * <p>用例 ST003-TC003（REQ-002-S02 临时户跳转）按 Spec 待确认事项 TBD-1 采用业务称谓「临时户」
 * 表述、不绑定具体枚举常量，「临时户」对应枚举取值确认后补充该用例桩数据与输出 acctNatureNo 断言
 * （跳转预期 gotoStepName=检查账户到期日 不变），当前不交付该用例的桩数据与断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST003PbcTest {

    /** 跳转目标步骤名称（Spec「跳转目标」《检查账户到期日》） */
    private static final String GOTO_STEP_CHECK_ACCT_DUE_DATE = "检查账户到期日";

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST003Pbc st003Pbc;

    /** 构造输入：othBaseAcctNo 为用例示例对手账号 */
    private ST003InputBO buildInput(String othBaseAcctNo) {
        ST003InputBO input = new ST003InputBO();
        input.setOthBaseAcctNo(othBaseAcctNo);
        return input;
    }

    /** 桩：findByEo 返回仅含指定账户属性的一条主表记录（查询方法绑定待 TBD-2 确认，占位绑定 findByEo） */
    private void stubFindByEoReturns(AcctNatureNo acctNatureNo) {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctNatureNo(acctNatureNo);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));
    }

    // 场景：REQ-001-S01（ST003-TC001），主表记录账户属性为基本存款账户（AcctNatureNo.VALUE_11001），
    // 步骤取得并输出账户属性 acctNatureNo，步骤正常完成
    @Test
    void testST003T01() {
        stubFindByEoReturns(AcctNatureNo.VALUE_11001);

        ST003OutputBO result = st003Pbc.execute(buildInput("6222002001234567890"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(AcctNatureNo.VALUE_11001, result.getAcctNatureNo());
    }

    // 场景：REQ-002-S01（ST003-TC002），主表记录账户属性为验资户（AcctNatureNo.VALUE_17，取值 "17"），
    // 步骤跳转至《检查账户到期日》正常提前结束（非业务失败），不返回「通过」
    @Test
    void testST003T02() {
        stubFindByEoReturns(AcctNatureNo.VALUE_17);

        ST003OutputBO result = st003Pbc.execute(buildInput("6222002001234567891"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(GOTO_STEP_CHECK_ACCT_DUE_DATE, result.getGotoStepName());
    }

    // 场景：REQ-002-S03（ST003-TC004），主表记录账户属性为一般存款账户（AcctNatureNo.VALUE_11002，
    // 为「验资户」「临时户」之外取值），步骤返回检查结果「通过」（正常成功结束、不触发跳转），输出 acctNatureNo
    @Test
    void testST003T04() {
        stubFindByEoReturns(AcctNatureNo.VALUE_11002);

        ST003OutputBO result = st003Pbc.execute(buildInput("6222002001234567893"));

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getGotoStepName());
        assertEquals(AcctNatureNo.VALUE_11002, result.getAcctNatureNo());
    }
}
