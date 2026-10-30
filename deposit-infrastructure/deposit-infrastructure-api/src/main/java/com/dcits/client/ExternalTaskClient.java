package com.dcits.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 跨组件客户端：本组件的外部依赖统一入口，由基础工程生成按外部依赖清单与平台接口登记生成。
 * 平台组件调用其登记的步骤/交易接口（/steps/{编码}、/tasks/{编码}）；既定外部系统按建模定案的地址调用。
 */
@Component
public class ExternalTaskClient {

    /** 目标服务地址：平台组件与既定外部系统统一本地 8980（部署时按环境调整）。 */
    private final String baseUrl = "http://localhost:8980";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 贷款《计算账号当日放款金额合计》（既定外部接口 /loan/calcAcctDailyLoanAmt）。
     * 入参：acctNo（账号）
     * 出参：dailyOverdraftAmt 当日累计透支额度
     */
    public Map<String, Object> calcAcctDailyLoanAmt(String acctNo) {
        return this.restTemplate.getForObject(this.baseUrl + "/loan/calcAcctDailyLoanAmt?acctNo={p0}", Map.class, new Object[] {acctNo});
    }

}
