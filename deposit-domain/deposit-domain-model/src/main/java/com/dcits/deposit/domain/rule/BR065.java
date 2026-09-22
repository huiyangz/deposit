package com.dcits.deposit.domain.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcits.deposit.enums.ClientType;

/**
 * BR065 检查客户类型是否在产品配置范围内
 *
 * <p>规则类型：断言类</p>
 *
 * <p>规则描述：如果产品的{客户类型}包括客户的{客户类型}，则返回是，否则返回否。</p>
 *
 * <p>断言类规则：返回"是"对应 {@code true}，返回"否"对应 {@code false}。</p>
 *
 * <p>产品的客户类型为逗号分隔的多值字符串，客户的客户类型为枚举
 * {@link ClientType}，比较依据为枚举对应的客户类型代码。</p>
 */
public class BR065 {

    private static final Logger LOGGER = LoggerFactory.getLogger(BR065.class);

    /** 产品客户类型多值分隔符 */
    private static final String SEPARATOR = ",";

    private BR065() {
    }

    /**
     * 检查客户类型是否在产品配置范围内。
     *
     * @param clientType 客户类型（必输）
     * @param prodClientType 产品的客户类型（必输，逗号分隔的多值字符串）
     * @return 产品的客户类型包括客户的客户类型返回 true，否则返回 false
     */
    public static boolean execute(ClientType clientType, String prodClientType) {
        if (clientType == null || prodClientType == null || prodClientType.isBlank()) {
            LOGGER.warn("BR065 输入为空：clientType={}, prodClientType={}", clientType, prodClientType);
            return false;
        }
        String clientTypeCode = clientType.getValue();
        for (String member : prodClientType.split(SEPARATOR)) {
            if (clientTypeCode.equals(member)) {
                LOGGER.info("BR065 产品客户类型[{}]包括客户类型[{}]", prodClientType, clientTypeCode);
                return true;
            }
        }
        LOGGER.info("BR065 产品客户类型[{}]不包括客户类型[{}]", prodClientType, clientTypeCode);
        return false;
    }
}
