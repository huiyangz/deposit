package com.dcits.deposit.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BR066 检查境内境外标志是否在产品配置范围内
 *
 * <p>规则类型：断言类</p>
 *
 * <p>规则描述：</p>
 * <ul>
 *     <li>如果产品的{境内境外标志}为“Y”，且客户的{境内境外标志}为“Y”，则返回是；</li>
 *     <li>如果产品的{境内境外标志}为“N”，且客户的{境内境外标志}为“N”，则返回是；</li>
 *     <li>否则返回否。</li>
 * </ul>
 */
public class BR066 {

    private static final Logger LOGGER = LoggerFactory.getLogger(BR066.class);

    /** 执行结果：是 */
    private static final String RESULT_YES = "是";

    /** 执行结果：否 */
    private static final String RESULT_NO = "否";

    /**
     * 检查境内境外标志是否在产品配置范围内
     *
     * @param customerDomesticOverseasFlag 客户的境内境外标志
     * @param productDomesticOverseasFlag  产品的境内境外标志
     * @return executionResult 执行结果：是/否
     */
    public static String execute(String customerDomesticOverseasFlag, String productDomesticOverseasFlag) {
        LOGGER.info("BR066 开始执行，客户的境内境外标志={}，产品的境内境外标志={}",
                customerDomesticOverseasFlag, productDomesticOverseasFlag);

        String executionResult;
        // 分支1：产品的境内境外标志为“Y”，且客户的境内境外标志为“Y”，则返回是
        if ("Y".equals(productDomesticOverseasFlag) && "Y".equals(customerDomesticOverseasFlag)) {
            executionResult = RESULT_YES;
        }
        // 分支2：产品的境内境外标志为“N”，且客户的境内境外标志为“N”，则返回是
        else if ("N".equals(productDomesticOverseasFlag) && "N".equals(customerDomesticOverseasFlag)) {
            executionResult = RESULT_YES;
        }
        // 否则返回否
        else {
            executionResult = RESULT_NO;
        }

        LOGGER.info("BR066 执行结束，executionResult={}", executionResult);
        return executionResult;
    }
}
