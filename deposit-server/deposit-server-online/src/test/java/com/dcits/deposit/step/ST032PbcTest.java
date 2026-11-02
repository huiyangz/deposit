package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST032InputBO;
import com.dcits.deposit.facade.bo.ST032OutputBO;

/**
 * ST032 检查交易金额 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01（接收必填输入 tranAmt 并据此判定，由各金额用例共同验证）、
 * REQ-002-S01（交易金额等于 0 的边界，含小数位表示差异）、REQ-002-S02（负数）、
 * REQ-003-S01（正数）已确认场景，对应测试用例 ST032-TC001~TC004。本步骤无 BCC/规则/跨组件/
 * 数据库依赖，用例无桩。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST032PbcTest {

    @InjectMocks
    private ST032Pbc st032Pbc;

    // 场景：REQ-003-S01 正常路径，交易金额为正数（100.00）时执行金额检查，返回检查结果"通过"，步骤正常完成
    @Test
    void testST032T01() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("100.00"));

        ST032OutputBO result = st032Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景：REQ-002-S01 边界否定路径，交易金额等于 0（"0"）满足"小于等于0"，返回 ER0050 业务失败
    @Test
    void testST032T02() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("0"));

        ST032OutputBO result = st032Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0050", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0050::"));
    }

    // 场景：REQ-002-S01 边界否定路径，交易金额为 0 的另一种小数位表示（"0.00"），数值比较忽略小数位表示差异仍满足"小于等于0"
    @Test
    void testST032T03() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("0.00"));

        ST032OutputBO result = st032Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0050", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0050::"));
    }

    // 场景：REQ-002-S02 错误码路径，交易金额为负数（-100.00）数值小于 0 满足"小于等于0"，返回 ER0050 业务失败
    @Test
    void testST032T04() {
        ST032InputBO input = new ST032InputBO();
        input.setTranAmt(new BigDecimal("-100.00"));

        ST032OutputBO result = st032Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0050", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0050::"));
    }
}
