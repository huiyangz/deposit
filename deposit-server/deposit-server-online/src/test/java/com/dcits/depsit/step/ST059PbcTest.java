package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.facade.bo.ST059InputBO;
import com.dcits.depsit.facade.bo.ST059OutputBO;

/**
 * ST059 设置借记交易的借贷标志 单元测试。
 *
 * <p>期望结果取自正式 Spec 的 REQ-001～REQ-003 及其场景，不根据实现反推。本步骤无入参、无组件内步骤
 * 调用、无 BCC / 规则 / 客户端 / 数据访问依赖，故三个用例均不设桩，直接执行真实 {@link ST059Pbc}。</p>
 *
 * <p>REQ-003-S01「技术异常按传播方式表达失败」在本步骤无法构造技术异常（无输入、无任何可触达依赖），
 * 属测试设计局限而非 Spec 缺口，本测试类不覆盖该场景，也不以技术异常或空对象冒充失败路径。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST059PbcTest {

    @InjectMocks
    private ST059Pbc pbc;

    // ST059-TC001 正常路径：调用真实步骤执行赋值，核对步骤成功状态与赋值结果为 D-借方（CrDrInd.D，代码值 "D"）。
    @Test
    void testST059T01() {
        ST059OutputBO result = pbc.execute(new ST059InputBO());

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertSame(CrDrInd.D, result.getCrDrInd());
        assertNotNull(result.getCrDrInd());
        assertEquals("D", result.getCrDrInd().getValue());
    }

    // ST059-TC002 边界否定路径：输出以名为 crDrInd、类型 CrDrInd 的字段承载，取值不为贷方，且无第二个借贷标志字段。
    @Test
    void testST059T02() throws Exception {
        ST059OutputBO result = pbc.execute(new ST059InputBO());

        Field crDrIndField = ST059OutputBO.class.getDeclaredField("crDrInd");
        assertSame(CrDrInd.class, crDrIndField.getType());

        assertNotSame(CrDrInd.C, result.getCrDrInd());
        assertNotEquals("C", result.getCrDrInd().getValue());

        // 输出声明字段中除 crDrInd 外不存在其它借贷标志字段。
        int crDrIndFieldCount = 0;
        for (Field field : ST059OutputBO.class.getDeclaredFields()) {
            if (CrDrInd.class.equals(field.getType())) {
                crDrIndFieldCount++;
            }
        }
        assertEquals(1, crDrIndFieldCount);
    }

    // ST059-TC003 边界否定路径：两次独立执行（各自新建步骤实例与空输入）结果恒为同一常量，不随调用历史或上下文变化。
    @Test
    void testST059T03() {
        ST059OutputBO first = new ST059Pbc().execute(new ST059InputBO());
        ST059OutputBO second = new ST059Pbc().execute(new ST059InputBO());

        assertTrue(first.isSucceed());
        assertNull(first.getErrorCode());
        assertTrue(second.isSucceed());
        assertNull(second.getErrorCode());
        assertSame(CrDrInd.D, first.getCrDrInd());
        assertSame(CrDrInd.D, second.getCrDrInd());
        assertEquals(first.getCrDrInd().getValue(), second.getCrDrInd().getValue());
    }
}
