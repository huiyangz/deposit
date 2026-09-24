package com.dcits.client;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 跨组件客户端：统一访问平台组件登记接口与既定外部系统接口。
 * 目标服务统一按本地 8980 部署，部署时按环境调整。
 */
@Component
public class ExternalTaskClient {

    private static final Logger logger = LoggerFactory.getLogger(ExternalTaskClient.class);

    /** 目标服务地址，部署时按环境调整 */
    public static final String BASE_URL = "http://localhost:8980";

    private final RestTemplate restTemplate;

    public ExternalTaskClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 黑名单组件《检查黑名单》步骤《检查黑名单》（平台登记步骤接口 ST001）。
     * POST /steps/ST001，直传 BO；出参：dealFlow 处理方式，入参出参照平台接口契约。
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> executeST001(Map<String, Object> bo) {
        logger.debug("executeST001 bo={}", bo);
        return restTemplate.postForObject(BASE_URL + "/steps/ST001", bo, Map.class);
    }

    /**
     * 产品管理《查询产品信息》（知识《外部接口清单》）。
     * GET /productManagement/queryProductInfo；入参：prodNo 产品编号、attrKey 参数KEY值；
     * 出参：acctType、withdrawalTypeList、ccyList、allowSuspendFlag、allDepFlag、allDraFlag、
     * clientType、inlandOffshoreFlag、branchList、acctAttr。
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> queryProductInfo(String prodNo, String attrKey) {
        logger.debug("queryProductInfo prodNo={}, attrKey={}", prodNo, attrKey);
        return restTemplate.getForObject(
                BASE_URL + "/productManagement/queryProductInfo?prodNo={prodNo}&attrKey={attrKey}", Map.class,
                prodNo, attrKey);
    }

    /**
     * 产品管理《查询产品利率信息》（知识《外部接口清单》）。
     * GET /productManagement/queryProductInterestRate；入参：prodNo 产品编号；
     * 出参：intTypeList 利率类型列表、prodIntRate 产品利率、maxExecRate 最大执行利率、minExecRate 最小执行利率。
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> queryProductInterestRate(String prodNo) {
        logger.debug("queryProductInterestRate prodNo={}", prodNo);
        return restTemplate.getForObject(BASE_URL + "/productManagement/queryProductInterestRate?prodNo={prodNo}",
                Map.class, prodNo);
    }

    /**
     * 基础公共《生成账号》（知识《外部接口清单》）。
     * GET /basicCommon/genAcctNo；入参：acctGenRuleType 账号生成规则类型、branch 交易机构、prodNo 产品编号；
     * 出参：acctNo 账号。
     */
    @SuppressWarnings("unchecked")
    public String genAcctNo(String acctGenRuleType, String branch, String prodNo) {
        logger.debug("genAcctNo acctGenRuleType={}, branch={}, prodNo={}", acctGenRuleType, branch, prodNo);
        Map<String, Object> resp = restTemplate.getForObject(
                BASE_URL + "/basicCommon/genAcctNo?acctGenRuleType={acctGenRuleType}&branch={branch}&prodNo={prodNo}",
                Map.class, acctGenRuleType, branch, prodNo);
        return resp == null || resp.get("acctNo") == null ? "" : String.valueOf(resp.get("acctNo"));
    }
}
