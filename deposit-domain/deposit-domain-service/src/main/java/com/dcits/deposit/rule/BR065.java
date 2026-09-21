package com.dcits.deposit.rule;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcits.deposit.enums.ClientType;

/**
 * BR065 检查客户类型是否在产品配置范围内
 *
 * 规则类型：断言类
 * 规则描述：如果产品的{客户类型}包括客户的{客户类型}，则返回是，否则返回否。
 * 输入：clientType 客户类型（必填）；productClientTypes 产品的客户类型（必填，多个取值以逗号分隔）。
 * 输出：executionResult 执行结果，取值为"是"或"否"。
 */
public class BR065 {

    private static final Logger LOGGER = LoggerFactory.getLogger(BR065.class);

    /** 产品客户类型多值串的分隔符 */
    private static final String SEPARATOR = ",";

    /**
     * 检查客户类型是否在产品配置范围内
     *
     * @param clientType 客户类型
     * @param productClientTypes 产品的客户类型，多个取值以逗号分隔
     * @return executionResult 执行结果："是"-产品配置包含该客户类型；"否"-不包含
     */
    public static String execute(ClientType clientType, String productClientTypes) {
        boolean included = Arrays.stream(productClientTypes.split(SEPARATOR))
                .anyMatch(clientType.getValue()::equals);
        String executionResult = included ? "是" : "否";
        LOGGER.info("BR065 检查客户类型是否在产品配置范围内: clientType={}, productClientTypes={}, executionResult={}",
                clientType.getValue(), productClientTypes, executionResult);
        return executionResult;
    }
}
