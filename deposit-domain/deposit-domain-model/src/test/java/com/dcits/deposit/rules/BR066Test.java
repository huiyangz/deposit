package com.dcits.deposit.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * BR066 检查境内境外标志是否在产品配置范围内 单元测试
 *
 * <p>覆盖分支：</p>
 * <ul>
 *     <li>分支1（产品=Y 且 客户=Y → 是）</li>
 *     <li>分支2（产品=N 且 客户=N → 是）</li>
 *     <li>否则分支（返回否）：Y/N 交叉组合、非法空值边界</li>
 * </ul>
 */
public class BR066Test {

    // 测试案例：正常路径：产品境内境外标志为Y，客户境内境外标志为Y，匹配通过，应返回是
    @Test
    public void testBR066T01() {
        String customerDomesticOverseasFlag = "Y";
        String productDomesticOverseasFlag = "Y";

        String executionResult = BR066.execute(customerDomesticOverseasFlag, productDomesticOverseasFlag);

        Assertions.assertEquals("是", executionResult);
    }

    // 测试案例：正常路径：产品境内境外标志为N，客户境内境外标志为N，匹配通过，应返回是
    @Test
    public void testBR066T02() {
        String customerDomesticOverseasFlag = "N";
        String productDomesticOverseasFlag = "N";

        String executionResult = BR066.execute(customerDomesticOverseasFlag, productDomesticOverseasFlag);

        Assertions.assertEquals("是", executionResult);
    }

    // 测试案例：否定路径：产品为Y、客户为N，两标志不一致，落入否则分支，应返回否
    @Test
    public void testBR066T03() {
        String customerDomesticOverseasFlag = "N";
        String productDomesticOverseasFlag = "Y";

        String executionResult = BR066.execute(customerDomesticOverseasFlag, productDomesticOverseasFlag);

        Assertions.assertEquals("否", executionResult);
    }

    // 测试案例：否定路径：产品为N、客户为Y，两标志不一致，落入否则分支，应返回否
    @Test
    public void testBR066T04() {
        String customerDomesticOverseasFlag = "Y";
        String productDomesticOverseasFlag = "N";

        String executionResult = BR066.execute(customerDomesticOverseasFlag, productDomesticOverseasFlag);

        Assertions.assertEquals("否", executionResult);
    }

    // 测试案例：边界路径：客户境内境外标志为空字符串，不满足任一匹配条件，落入否则分支，应返回否
    @Test
    public void testBR066T05() {
        String customerDomesticOverseasFlag = "";
        String productDomesticOverseasFlag = "Y";

        String executionResult = BR066.execute(customerDomesticOverseasFlag, productDomesticOverseasFlag);

        Assertions.assertEquals("否", executionResult);
    }
}
