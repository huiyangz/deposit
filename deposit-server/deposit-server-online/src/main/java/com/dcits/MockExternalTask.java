package com.dcits;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 既定外部系统接口 mock：GET 路径及参数与 ExternalTaskClient 一致，仅本地调试使用。
 */
@RestController
public class MockExternalTask {

    private static final Logger logger = LoggerFactory.getLogger(MockExternalTask.class);

    /**
     * 贷款《计算账号当日放款金额合计》：贷款组件不提供真实口径，按账号返回固定值 0.00。
     */
    @GetMapping("/loan/calcAcctDailyLoanAmt")
    public Map<String, Object> calcAcctDailyLoanAmt(@RequestParam("acctNo") String acctNo) {
        logger.debug("外部接口 mock 计算账号当日放款金额合计：acctNo={}", acctNo);
        Map<String, Object> result = new HashMap<>();
        result.put("dailyOverdraftAmt", "0.00");
        return result;
    }

}
