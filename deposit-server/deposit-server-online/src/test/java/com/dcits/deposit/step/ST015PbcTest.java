package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.IsOverMonthSeasonOd;
import com.dcits.deposit.facade.bo.ST015InputBO;
import com.dcits.deposit.facade.bo.ST015OutputBO;
import com.dcits.deposit.facade.components.IRbBusAgreementOverdraftBcc;
import com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO;

/**
 * ST015 检查靠档标识 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001~REQ-003 已确认场景（测试用例 ST015-TC001~TC006）：
 * 靠档跨月季标识为跨月（M）/跨季（Q）/不跨月/季（N）时的输出，以及「跨月/跨季 →
 * 跳转《检查法人透支金额》」、「不跨月/季 → 跳转《检查分行法人透支额度》」两个互斥
 * 跳转分支。查询无记录、标识空值/非标准编码、多条记录、baseAcctNo 缺失等未确认场景
 * 不作为本套用例断言，见 ST015Pbc 中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST015PbcTest {

    /** 用例示例账号 */
    private static final String BASE_ACCT_NO = "1000000000000001";

    /** 跳转目标：检查法人透支金额 */
    private static final String GOTO_STEP_CHECK_LEGAL_OD_AMOUNT = "检查法人透支金额";

    /** 跳转目标：检查分行法人透支额度 */
    private static final String GOTO_STEP_CHECK_BRANCH_LEGAL_OD_LIMIT = "检查分行法人透支额度";

    @Mock
    private IRbBusAgreementOverdraftBcc rbBusAgreementOverdraftBcc;

    @InjectMocks
    private ST015Pbc st015Pbc;

    /** 构造输入：baseAcctNo 为用例示例账号 */
    private ST015InputBO buildInput() {
        ST015InputBO input = new ST015InputBO();
        input.setBaseAcctNo(BASE_ACCT_NO);
        return input;
    }

    /** 构造查询结果记录：baseAcctNo 为用例示例账号、靠档跨月季标识为指定枚举值 */
    private RbBusAgreementOverdraftEO buildAgreement(IsOverMonthSeasonOd isOverMonthSeasonOd) {
        RbBusAgreementOverdraftEO agreement = new RbBusAgreementOverdraftEO();
        agreement.setBaseAcctNo(BASE_ACCT_NO);
        agreement.setIsOverMonthSeasonOd(isOverMonthSeasonOd);
        return agreement;
    }

    /** 桩：findByEo（查询 EO 的 getBaseAcctNo() 等于示例账号）返回仅含指定标识的单条记录 */
    private void stubFindByEoReturns(IsOverMonthSeasonOd isOverMonthSeasonOd) {
        lenient().when(rbBusAgreementOverdraftBcc.findByEo(argThat(eo ->
                eo != null && BASE_ACCT_NO.equals(eo.getBaseAcctNo()))))
                .thenReturn(List.of(buildAgreement(isOverMonthSeasonOd)));
    }

    // 场景：REQ-001-S01（ST015-TC001），查询记录标识为跨月（M）时输出 isOverMonthSeasonOd=IsOverMonthSeasonOd.M，步骤成功
    @Test
    void testST015T01() {
        stubFindByEoReturns(IsOverMonthSeasonOd.M);
        ST015OutputBO result = st015Pbc.execute(buildInput());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(IsOverMonthSeasonOd.M, result.getIsOverMonthSeasonOd());
    }

    // 场景：REQ-001-S02（ST015-TC002），查询记录标识为跨季（Q）时输出 isOverMonthSeasonOd=IsOverMonthSeasonOd.Q，步骤成功
    @Test
    void testST015T02() {
        stubFindByEoReturns(IsOverMonthSeasonOd.Q);
        ST015OutputBO result = st015Pbc.execute(buildInput());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(IsOverMonthSeasonOd.Q, result.getIsOverMonthSeasonOd());
    }

    // 场景：REQ-001-S03（ST015-TC003），查询记录标识为不跨月/季（N）时输出 isOverMonthSeasonOd=IsOverMonthSeasonOd.N，步骤成功
    @Test
    void testST015T03() {
        stubFindByEoReturns(IsOverMonthSeasonOd.N);
        ST015OutputBO result = st015Pbc.execute(buildInput());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(IsOverMonthSeasonOd.N, result.getIsOverMonthSeasonOd());
    }

    // 场景：REQ-002-S01（ST015-TC004），标识为跨月（M）时跳转目标为《检查法人透支金额》（单一跳转目标值断言即排除《检查分行法人透支额度》）
    @Test
    void testST015T04() {
        stubFindByEoReturns(IsOverMonthSeasonOd.M);
        ST015OutputBO result = st015Pbc.execute(buildInput());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(IsOverMonthSeasonOd.M, result.getIsOverMonthSeasonOd());
        assertEquals(GOTO_STEP_CHECK_LEGAL_OD_AMOUNT, result.getGotoStepName());
    }

    // 场景：REQ-002-S02（ST015-TC005），标识为跨季（Q）时跳转目标为《检查法人透支金额》（单一跳转目标值断言即排除《检查分行法人透支额度》）
    @Test
    void testST015T05() {
        stubFindByEoReturns(IsOverMonthSeasonOd.Q);
        ST015OutputBO result = st015Pbc.execute(buildInput());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(IsOverMonthSeasonOd.Q, result.getIsOverMonthSeasonOd());
        assertEquals(GOTO_STEP_CHECK_LEGAL_OD_AMOUNT, result.getGotoStepName());
    }

    // 场景：REQ-003-S01（ST015-TC006），标识为不跨月/季（N）时跳转目标为《检查分行法人透支额度》（单一跳转目标值断言即排除《检查法人透支金额》）
    @Test
    void testST015T06() {
        stubFindByEoReturns(IsOverMonthSeasonOd.N);
        ST015OutputBO result = st015Pbc.execute(buildInput());
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(IsOverMonthSeasonOd.N, result.getIsOverMonthSeasonOd());
        assertEquals(GOTO_STEP_CHECK_BRANCH_LEGAL_OD_LIMIT, result.getGotoStepName());
    }
}
