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

import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST020InputBO;
import com.dcits.deposit.facade.bo.ST020OutputBO;

/**
 * ST020 检查转账交易类型 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01 与边界否定场景（测试用例
 * ST020-TC001~TC003）。「行内转账（非支票）」精确成员集合（TBD-1）与必填输入缺失
 * 行为（TBD-2）无已确认预期，不作为本套用例断言，见实现中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST020PbcTest {

    @InjectMocks
    private ST020Pbc step;

    // 场景：REQ-001-S01（ST020-TC001），tranType 为「行内转账（非支票）」候选取值 TranType.VALUE_4186（代码值 4186，行内转账支取(非支票)），检查通过，步骤成功结束且错误字段为空
    @Test
    void testST020T01() {
        ST020InputBO input = new ST020InputBO();
        input.setTranType(TranType.VALUE_4186);
        ST020OutputBO result = step.execute(input);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景：REQ-002-S01（ST020-TC002），tranType 为不属于「行内转账（非支票）」的取值 TranType.VALUE_4101（代码值 4101，资产类内部户借记），业务失败返回 ER0067 并短路
    @Test
    void testST020T02() {
        ST020InputBO input = new ST020InputBO();
        input.setTranType(TranType.VALUE_4101);
        ST020OutputBO result = step.execute(input);
        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0067::"));
        assertTrue(result.getErrorMessage().contains("交易类型错误"));
    }

    // 场景：边界否定（ST020-TC003），tranType 为行内转账但属「(支票)」分类的取值 TranType.VALUE_4180（代码值 4180，行内转账支取(支票)），不为「非支票」，返回 ER0067 并短路
    @Test
    void testST020T03() {
        ST020InputBO input = new ST020InputBO();
        input.setTranType(TranType.VALUE_4180);
        ST020OutputBO result = step.execute(input);
        assertFalse(result.isSucceed());
        assertEquals("ER0067", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0067::"));
        assertTrue(result.getErrorMessage().contains("交易类型错误"));
    }
}
