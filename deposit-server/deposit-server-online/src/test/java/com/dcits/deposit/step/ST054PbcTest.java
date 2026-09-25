package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;

/**
 * ST054 设置账户执行利率 单元测试。
 *
 * <p>用例来源：outputs/测试用例.md（ST054-TC001 ~ ST054-TC003），
 * 期望结果来自门禁通过版 SPEC《ST054 设置账户执行利率》。
 * 本步骤为单一参数赋值，无 BCC、规则、跨组件调用，无需设桩。</p>
 */
@ExtendWith(MockitoExtension.class)
public class ST054PbcTest {

    @InjectMocks
    private ST054Pbc st054Pbc;

    // ST054-TC001 正常路径：输入常规执行利率 0.035000，唯一赋值路径原样输出，预期成功且 realRate 精确相等（含标度）
    @Test
    public void testST054T01() {
        ST054InputBO input = new ST054InputBO();
        input.setRealRate(new BigDecimal("0.035000"));

        ST054OutputBO result = st054Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(new BigDecimal("0.035000"), result.getRealRate());
    }

    // ST054-TC002 边界否定路径：零值利率边界，输入 0，SPEC 未定义取值范围校验，零值属合法输入，预期原样输出
    @Test
    public void testST054T02() {
        ST054InputBO input = new ST054InputBO();
        input.setRealRate(new BigDecimal("0"));

        ST054OutputBO result = st054Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(new BigDecimal("0"), result.getRealRate());
    }

    // ST054-TC003 边界否定路径：高精度利率值边界，输入 6 位小数 0.037515，验证 BigDecimal 标度与精度原样传递、不做舍入转换
    @Test
    public void testST054T03() {
        ST054InputBO input = new ST054InputBO();
        input.setRealRate(new BigDecimal("0.037515"));

        ST054OutputBO result = st054Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(new BigDecimal("0.037515"), result.getRealRate());
    }
}
