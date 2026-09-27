package com.dcits.client;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 跨组件客户端：封装本组件（存款业务组件）对平台组件与非平台外部系统的调用。
 *
 * 平台组件步骤接口：POST /steps/{编码}，请求直传 BO，响应为步骤输出；
 * 非平台外部接口：按《外部接口清单》定案的方法名与调用地址生成 GET 方法。
 *
 * 方法名采用 execute{组件英文名}{编码}：步骤编码（如 ST001）在多个组件间重复，
 * 仅用编码无法区分，故加组件前缀消歧。
 *
 * 目标服务地址统一按本地 8980 部署，部署时按环境调整。
 */
@Component
public class ExternalTaskClient {

    /** 黑名单组件（blacklist）服务地址，部署时按环境调整 */
    private static final String BLACKLIST_BASE_URL = "http://localhost:8980";
    /** 检查限制组件（validation）服务地址，部署时按环境调整 */
    private static final String VALIDATION_BASE_URL = "http://localhost:8980";
    /** 检查限额组件（limit）服务地址，部署时按环境调整 */
    private static final String LIMIT_BASE_URL = "http://localhost:8980";
    /** 维护限制组件（restriction）服务地址，部署时按环境调整 */
    private static final String RESTRICTION_BASE_URL = "http://localhost:8980";
    /** 非平台外部系统（产品管理、基础公共等既定外部接口）服务地址，部署时按环境调整 */
    private static final String EXTERNAL_BASE_URL = "http://localhost:8980";

    private static final ParameterizedTypeReference<Map<String, Object>> MAP_TYPE =
            new ParameterizedTypeReference<Map<String, Object>>() {
            };

    private final RestTemplate restTemplate;

    public ExternalTaskClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Map<String, Object> postForMap(String url, Object bo) {
        ResponseEntity<Map<String, Object>> resp =
                restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(bo), MAP_TYPE);
        return resp.getBody();
    }

    // ==================== 黑名单组件 · 检查黑名单 ====================

    /** 黑名单组件《检查黑名单》步骤《检查黑名单》（ST001） */
    public Map<String, Object> executeBlacklistST001(Map<String, Object> bo) {
        return postForMap(BLACKLIST_BASE_URL + "/steps/ST001", bo);
    }

    // ==================== 检查限制组件 · 检查账户限制 ====================

    /** 检查限制组件《检查账户限制》步骤《检查账户是否存在限制》（ST005） */
    public Map<String, Object> executeValidationST005(Map<String, Object> bo) {
        return postForMap(VALIDATION_BASE_URL + "/steps/ST005", bo);
    }

    /** 检查限制组件《检查账户限制》步骤《检查是否存在现金不收不付限制》（ST014） */
    public Map<String, Object> executeValidationST014(Map<String, Object> bo) {
        return postForMap(VALIDATION_BASE_URL + "/steps/ST014", bo);
    }

    /** 检查限制组件《检查账户限制》步骤《检查是否存在现金止收限制》（ST008） */
    public Map<String, Object> executeValidationST008(Map<String, Object> bo) {
        return postForMap(VALIDATION_BASE_URL + "/steps/ST008", bo);
    }

    /** 检查限制组件《检查账户限制》步骤《检查是否存在属性限制》（ST015） */
    public Map<String, Object> executeValidationST015(Map<String, Object> bo) {
        return postForMap(VALIDATION_BASE_URL + "/steps/ST015", bo);
    }

    /** 检查限制组件《检查账户限制》步骤《检查限制优先级》（ST011） */
    public Map<String, Object> executeValidationST011(Map<String, Object> bo) {
        return postForMap(VALIDATION_BASE_URL + "/steps/ST011", bo);
    }

    /** 检查限制组件《检查账户限制》步骤《检查限制豁免》（ST002） */
    public Map<String, Object> executeValidationST002(Map<String, Object> bo) {
        return postForMap(VALIDATION_BASE_URL + "/steps/ST002", bo);
    }

    // ==================== 检查限制组件 · 检查客户限制 ====================

    /** 检查限制组件《检查客户限制》步骤《检查客户是否存在限制》（ST001） */
    public Map<String, Object> executeValidationST001(Map<String, Object> bo) {
        return postForMap(VALIDATION_BASE_URL + "/steps/ST001", bo);
    }

    // ==================== 检查限额组件 · 检查限额 ====================

    /** 检查限额组件《检查限额》步骤《匹配限额场景》（ST007） */
    public Map<String, Object> executeLimitST007(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST007", bo);
    }

    /** 检查限额组件《检查限额》步骤《检查账户机构是否可匹配到限额场景配置》（ST002） */
    public Map<String, Object> executeLimitST002(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST002", bo);
    }

    /** 检查限额组件《检查限额》步骤《检查限额场景配置是否有效》（ST009） */
    public Map<String, Object> executeLimitST009(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST009", bo);
    }

    /** 检查限额组件《检查限额》步骤《获取限额场景编码》（ST001） */
    public Map<String, Object> executeLimitST001(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST001", bo);
    }

    /** 检查限额组件《检查限额》步骤《获取累计限额》（ST006） */
    public Map<String, Object> executeLimitST006(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST006", bo);
    }

    /** 检查限额组件《检查限额》步骤《计算限额累计金额》（ST003） */
    public Map<String, Object> executeLimitST003(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST003", bo);
    }

    /** 检查限额组件《检查限额》步骤《检查限额》（ST004） */
    public Map<String, Object> executeLimitST004(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST004", bo);
    }

    /** 检查限额组件《检查限额》步骤《处理限额》（ST005） */
    public Map<String, Object> executeLimitST005(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST005", bo);
    }

    /** 检查限额组件《检查限额》步骤《更新累计限额》（ST010） */
    public Map<String, Object> executeLimitST010(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST010", bo);
    }

    /** 检查限额组件《检查限额》步骤《登记累计限额》（ST008） */
    public Map<String, Object> executeLimitST008(Map<String, Object> bo) {
        return postForMap(LIMIT_BASE_URL + "/steps/ST008", bo);
    }

    // ==================== 维护限制组件 · 增加账户限制 ====================

    /** 维护限制组件《增加账户限制》步骤《检查限制类型》（ST001） */
    public Map<String, Object> executeRestrictionST001(Map<String, Object> bo) {
        return postForMap(RESTRICTION_BASE_URL + "/steps/ST001", bo);
    }

    /** 维护限制组件《增加账户限制》步骤《检查是否跨法人》（ST002） */
    public Map<String, Object> executeRestrictionST002(Map<String, Object> bo) {
        return postForMap(RESTRICTION_BASE_URL + "/steps/ST002", bo);
    }

    /** 维护限制组件《增加账户限制》步骤《检查增加限制起始日期》（ST003） */
    public Map<String, Object> executeRestrictionST003(Map<String, Object> bo) {
        return postForMap(RESTRICTION_BASE_URL + "/steps/ST003", bo);
    }

    /** 维护限制组件《增加账户限制》步骤《登记账户限制信息》（ST004） */
    public Map<String, Object> executeRestrictionST004(Map<String, Object> bo) {
        return postForMap(RESTRICTION_BASE_URL + "/steps/ST004", bo);
    }

    // ==================== 非平台外部接口（知识《外部接口清单》） ====================

    /**
     * 产品管理·查询产品信息：GET /productManagement/queryProductInfo
     * 按「产品编号 + 参数KEY值」的 KV 结构查询产品定义表，返回该 key 对应的属性值（集合类出参返回原值）。
     */
    public String queryProductInfo(String prodNo, String attrKey) {
        return restTemplate.getForObject(
                EXTERNAL_BASE_URL + "/productManagement/queryProductInfo?prodNo={prodNo}&attrKey={attrKey}",
                String.class, prodNo, attrKey);
    }

    /**
     * 产品管理·查询产品利率信息：GET /productManagement/queryProductInterestRate
     * 按产品编号查产品利率信息表，返回 intTypeList、prodIntRate、minExecRate、maxExecRate。
     */
    public Map<String, Object> queryProductInterestRate(String prodNo) {
        ResponseEntity<Map<String, Object>> resp = restTemplate.exchange(
                EXTERNAL_BASE_URL + "/productManagement/queryProductInterestRate?prodNo={prodNo}",
                HttpMethod.GET, null, MAP_TYPE, prodNo);
        return resp.getBody();
    }

    /**
     * 基础公共·生成账号：GET /basicCommon/genAcctNo
     * 按「账号生成规则类型 + 交易机构 + 产品编号」生成账号。
     */
    public String genAcctNo(String acctGenRuleType, String branch, String prodNo) {
        return restTemplate.getForObject(
                EXTERNAL_BASE_URL + "/basicCommon/genAcctNo?acctGenRuleType={acctGenRuleType}&branch={branch}&prodNo={prodNo}",
                String.class, acctGenRuleType, branch, prodNo);
    }
}
