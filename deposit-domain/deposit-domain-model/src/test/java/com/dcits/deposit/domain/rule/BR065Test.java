package com.dcits.deposit.domain.rule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.ClientType;

/**
 * BR065 检查客户类型是否在产品配置范围内 单元测试。
 *
 * <p>规则逻辑：如果产品的{客户类型}（prodClientType，String）包括客户的{客户类型}
 * （clientType，枚举），断言通过（true），否则断言不通过（false）。</p>
 *
 * <p>测试用例中以 X/Y/Z 代表枚举常量及对应的客户类型代码，此处替换为
 * {@link ClientType} 实际声明的常量：X→VALUE_100("100")、Y→VALUE_200("200")、Z→VALUE_300("300")。</p>
 */
public class BR065Test {

    // 测试案例：正常路径——产品客户类型为单一取值且与客户类型一致，条件成立，应返回 true
    @Test
    public void testBR065T01() {
        ClientType clientType = ClientType.VALUE_100;
        String prodClientType = "100";
        boolean executionResult = BR065.execute(clientType, prodClientType);
        assertTrue(executionResult);
    }

    // 测试案例：正常路径——产品客户类型为多值列表且包含客户类型，条件成立，应返回 true
    @Test
    public void testBR065T02() {
        ClientType clientType = ClientType.VALUE_100;
        String prodClientType = "200,100,300";
        boolean executionResult = BR065.execute(clientType, prodClientType);
        assertTrue(executionResult);
    }

    // 测试案例：否定路径——产品客户类型不包含客户类型，条件不成立，应返回 false
    @Test
    public void testBR065T03() {
        ClientType clientType = ClientType.VALUE_100;
        String prodClientType = "200,300";
        boolean executionResult = BR065.execute(clientType, prodClientType);
        assertFalse(executionResult);
    }

    // 测试案例：边界路径——产品客户类型为空字符串，条件不成立，应返回 false
    @Test
    public void testBR065T04() {
        ClientType clientType = ClientType.VALUE_100;
        String prodClientType = "";
        boolean executionResult = BR065.execute(clientType, prodClientType);
        assertFalse(executionResult);
    }
}
