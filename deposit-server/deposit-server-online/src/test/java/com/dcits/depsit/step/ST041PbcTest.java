package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST041InputBO;
import com.dcits.depsit.facade.bo.ST041OutputBO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST041 检查存入交易类型 单元测试。
 *
 * 期望结果取自正式 Spec 的 REQ-001～REQ-003 与场景 REQ-001-S01、REQ-002-S01／S02、REQ-003-S01～S03，
 * 不根据实现反推。本步骤为纯入参判定，无 BCC、规则、组件内步骤与跨组件依赖，全部用例无桩配置。
 * Spec 未定义输出业务字段，故以 {@code succeed} 与 {@code errorCode} 承载互斥的「检查结果」与「错误码」。
 */
@ExtendWith(MockitoExtension.class)
class ST041PbcTest {

    @InjectMocks
    private ST041Pbc pbc;

    // ST041-TC001 正常路径：tranType 为代码值 "1000" 的成员「现金存入」，判定相等，返回检查结果「通过」且不产出 ER0049。
    @Test
    void testST041T01() {
        ST041InputBO input = new ST041InputBO();
        input.setTranType(TranType.VALUE_1000);

        ST041OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST041-TC002 正常路径：经 TranType.byValue("1000") 定位到唯一成员 VALUE_1000，判定相等，结果与直接取该成员一致。
    @Test
    void testST041T02() {
        assertEquals(TranType.VALUE_1000, TranType.byValue("1000"));

        ST041InputBO input = new ST041InputBO();
        input.setTranType(TranType.byValue("1000"));

        ST041OutputBO result = pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // ST041-TC003 错误码路径：tranType 为 VALUE_1003（代码 "1003"，「现金支取」），代码值不等于 "1000"，返回 ER0049。
    @Test
    void testST041T03() {
        ST041InputBO input = new ST041InputBO();
        input.setTranType(TranType.VALUE_1003);

        ST041OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0049", result.getErrorCode());
    }

    // ST041-TC004 边界否定路径：tranType 为 VALUE_1001（代码 "1001"，「现金存入-冲销」，注释含「现金存入」），判定不因注释文本改变。
    @Test
    void testST041T04() {
        ST041InputBO input = new ST041InputBO();
        input.setTranType(TranType.VALUE_1001);

        ST041OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0049", result.getErrorCode());
    }

    // ST041-TC005 边界否定路径：tranType 为 VALUE_1030（代码 "1030"，「现金存入-移植专用」，注释含「现金存入」），代码值不等于 "1000"。
    @Test
    void testST041T05() {
        ST041InputBO input = new ST041InputBO();
        input.setTranType(TranType.VALUE_1030);

        ST041OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0049", result.getErrorCode());
    }

    // ST041-TC006 边界否定路径：tranType 为 VALUE_4189（代码 "4189"，「行内转账存入(非支票)」），属存入类但非现金存入，判定不等。
    @Test
    void testST041T06() {
        ST041InputBO input = new ST041InputBO();
        input.setTranType(TranType.VALUE_4189);

        ST041OutputBO result = pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0049", result.getErrorCode());
    }
}
