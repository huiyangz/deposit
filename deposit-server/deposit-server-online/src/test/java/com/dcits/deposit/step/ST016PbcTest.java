package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST016InputBO;
import com.dcits.deposit.facade.bo.ST016OutputBO;

/**
 * ST016 检查账户客户一致性 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01（一致路径，ST016-TC001）与 REQ-002-S01（不一致路径，
 * ST016-TC002）。必填输入缺失行为（Spec TBD-1）与「通过」检查结果的物理输出表达
 * （Spec TBD-2）无已确认预期，不作为本套用例断言，见实现中 FIXME 与 Spec 待确认事项。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST016PbcTest {

    @InjectMocks
    private ST016Pbc step;

    // 场景：ST016-TC001（REQ-001-S01），clientNo 与 othClientNo 取值一致（均为 "100000001"），
    // 判定为同名客户转账，本步骤业务失败并返回错误码 ER0078，短路不产生检查结果「通过」
    @Test
    void testST016T01() {
        ST016InputBO input = new ST016InputBO();
        input.setClientNo("100000001");
        input.setOthClientNo("100000001");

        ST016OutputBO result = step.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0078", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0078::"));
        assertTrue(result.getErrorMessage().contains("资金监管账户不允许同名账户转账"));
    }

    // 场景：ST016-TC002（REQ-002-S01），clientNo 为 "100000001"、othClientNo 为 "200000002"
    // （取值不同），判定检查通过，步骤正常结束且成功、不带错误码
    @Test
    void testST016T02() {
        ST016InputBO input = new ST016InputBO();
        input.setClientNo("100000001");
        input.setOthClientNo("200000002");

        ST016OutputBO result = step.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }
}
