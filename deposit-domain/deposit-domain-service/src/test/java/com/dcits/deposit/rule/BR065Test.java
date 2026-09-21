package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.ClientType;

/**
 * BR065 检查客户类型是否在产品配置范围内 单元测试
 *
 * 前置约定：X、Y、Z 分别取 ClientType 中三个互不相同的有效常量
 * VALUE_100（100-个人）、VALUE_200（200-公司）、VALUE_300（300-金融机构），
 * {X.code} 等对应常量的客户类型代码，即 {@link ClientType#getValue()}。
 */
class BR065Test {

    // 测试案例：正常路径-产品配置多个客户类型，客户类型包含其中（居中位置），应返回"是"
    @Test
    void testBR065T01() {
        ClientType clientType = ClientType.VALUE_100;
        String productClientTypes = ClientType.VALUE_200.getValue() + "," + ClientType.VALUE_100.getValue() + "," + ClientType.VALUE_300.getValue();
        String executionResult = BR065.execute(clientType, productClientTypes);
        assertEquals("是", executionResult);
    }

    // 测试案例：边界-产品配置仅包含该客户类型一项（最小命中配置），应返回"是"
    @Test
    void testBR065T02() {
        ClientType clientType = ClientType.VALUE_100;
        String productClientTypes = ClientType.VALUE_100.getValue();
        String executionResult = BR065.execute(clientType, productClientTypes);
        assertEquals("是", executionResult);
    }

    // 测试案例：否定路径-产品配置多个客户类型，客户类型不在其中，应返回"否"
    @Test
    void testBR065T03() {
        ClientType clientType = ClientType.VALUE_100;
        String productClientTypes = ClientType.VALUE_200.getValue() + "," + ClientType.VALUE_300.getValue();
        String executionResult = BR065.execute(clientType, productClientTypes);
        assertEquals("否", executionResult);
    }

    // 测试案例：边界否定-产品配置仅含单一其他客户类型（最小未命中配置），应返回"否"
    @Test
    void testBR065T04() {
        ClientType clientType = ClientType.VALUE_100;
        String productClientTypes = ClientType.VALUE_200.getValue();
        String executionResult = BR065.execute(clientType, productClientTypes);
        assertEquals("否", executionResult);
    }
}
