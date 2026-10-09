package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.facade.bo.ST096InputBO;
import com.dcits.depsit.facade.bo.ST096OutputBO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST096 设置账户执行利率 单元测试（交易执行步骤）。
 *
 * <p>用例来源：`outputs/测试用例.md`（`outputs/测试用例.json`）ST096-TC001 至 ST096-TC004，
 * 对应 Spec REQ-001-S01、REQ-001-S02、REQ-002-S01 及 REQ-001 的输入域边界。</p>
 *
 * <p>本步骤为单条无条件赋值，无子步骤、无判定条件、无分支与循环、无依赖调用（Spec「依赖调用：不适用」），
 * 故全部用例共用唯一执行路径，不设任何桩；被测对象为 {@link InjectMocks} 装配的真实实例
 * {@link ST096Pbc}（无依赖需注入）。</p>
 *
 * <p>数值断言一律以 {@link BigDecimal#compareTo} 比较数值大小，不用 {@code equals}：源需求未规定精度、
 * 标度与舍入规则（Spec 不覆盖事项 4），测试不断言特定标度或舍入结果。源需求声明本步骤无业务失败场景，
 * 用例中无失败路径，不构造技术异常充当业务失败。</p>
 *
 * <p>赋值目标「账户执行利率属性」的落库实体与字段源需求未声明（Spec 不覆盖事项 1），步骤亦无查询依赖可设桩，
 * 故「直接赋值覆盖原有取值」只能经输出 {@code realRate} 的赋值后取值间接承载（见用例设计「设计局限」第 1 条），
 * 无法直接断言账户属性对象上的写入结果。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST096PbcTest {

    @InjectMocks
    private ST096Pbc pbc;

    // ST096-TC001：REQ-001-S01 正常赋值并覆盖账户原有执行利率——赋值前为 1.5000，输入 realRate = 3.8500，
    // 执行后经输出断言赋值为 3.8500，且不再保留赋值前的取值 1.5000（直接赋值，非「为空才设置」的条件赋值）
    @Test
    void testST096T01() {
        ST096InputBO input = new ST096InputBO();
        input.setRealRate(new BigDecimal("3.8500"));

        ST096OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotNull(output.getRealRate());
        assertEquals(0, output.getRealRate().compareTo(new BigDecimal("3.8500")));
        assertNotEquals(0, output.getRealRate().compareTo(new BigDecimal("1.5000")));
    }

    // ST096-TC002：REQ-001-S02 赋值为输入数值的原样传递——输入 realRate = 3.12345，步骤为纯赋值，
    // 不引入取整、舍入或按标度缩放，赋值后取值与输入数值相同
    @Test
    void testST096T02() {
        ST096InputBO input = new ST096InputBO();
        input.setRealRate(new BigDecimal("3.12345"));

        ST096OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotNull(output.getRealRate());
        assertEquals(0, output.getRealRate().compareTo(new BigDecimal("3.12345")));
    }

    // ST096-TC003：REQ-002-S01 输出为所设置的执行利率——输入 realRate = 3.8500，
    // 返回后输出参数 realRate 取值为本次设置到账户的执行利率，与输入一致；本步骤无分支，输出不作判定依据
    @Test
    void testST096T03() {
        ST096InputBO input = new ST096InputBO();
        input.setRealRate(new BigDecimal("3.8500"));

        ST096OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotNull(output.getRealRate());
        assertEquals(0, output.getRealRate().compareTo(new BigDecimal("3.8500")));
    }

    // ST096-TC004：REQ-001 无条件赋值的输入域边界——输入 realRate = 0.0000（合法 BigDecimal 边界值），
    // 赋值不依赖任何取值判定，零值原样写入
    @Test
    void testST096T04() {
        ST096InputBO input = new ST096InputBO();
        input.setRealRate(new BigDecimal("0.0000"));

        ST096OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotNull(output.getRealRate());
        assertEquals(0, output.getRealRate().compareTo(BigDecimal.ZERO));
    }
}
