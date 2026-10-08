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
     * 产品管理《查询产品信息》（既定外部接口 /productManagement/queryProductInfo）。
     * 入参：prodNo（产品编号）、attrKey（参数KEY值）
     * 出参：acctType 账户类型、withdrawalTypeList 支取方式列表、ccyList 币种列表、allowSuspendFlag 是否允许转久悬、allDepFlag 通存标志、allDraFlag 通兑标志、clientType 客户类型、inlandOffshoreFlag 境内境外标志、branchList 机构列表、acctAttr 账户属性
     */
    public Map<String, Object> queryProductInfo(String prodNo, String attrKey) {
        return this.restTemplate.getForObject(this.baseUrl + "/productManagement/queryProductInfo?prodNo={p0}&attrKey={p1}", Map.class, new Object[] {prodNo, attrKey});
    }

    /**
     * 产品管理《查询产品利率信息》（既定外部接口 /productManagement/queryProductInterestRate）。
     * 入参：prodNo（产品编号）
     * 出参：intTypeList 利率类型列表、prodIntRate 产品利率、maxExecRate 最大执行利率、minExecRate 最小执行利率
     */
    public Map<String, Object> queryProductInterestRate(String prodNo) {
        return this.restTemplate.getForObject(this.baseUrl + "/productManagement/queryProductInterestRate?prodNo={p0}", Map.class, new Object[] {prodNo});
    }

    /**
     * 基础公共《生成账号》（既定外部接口 /basicCommon/genAcctNo）。
     * 入参：acctGenRuleType（账号生成规则类型）、branch（交易机构）、prodNo（产品编号）
     * 出参：acctNo 账号
     */
    public Map<String, Object> genAcctNo(String acctGenRuleType, String branch, String prodNo) {
        return this.restTemplate.getForObject(this.baseUrl + "/basicCommon/genAcctNo?acctGenRuleType={p0}&branch={p1}&prodNo={p2}", Map.class, new Object[] {acctGenRuleType, branch, prodNo});
    }

    /**
     * 贷款《计算账号当日放款金额合计》（既定外部接口 /loan/calcAcctDailyLoanAmt）。
     * 入参：acctNo（账号）
     * 出参：dailyOverdraftAmt 当日累计透支额度
     */
    public Map<String, Object> calcAcctDailyLoanAmt(String acctNo) {
        return this.restTemplate.getForObject(this.baseUrl + "/loan/calcAcctDailyLoanAmt?acctNo={p0}", Map.class, new Object[] {acctNo});
    }

}
