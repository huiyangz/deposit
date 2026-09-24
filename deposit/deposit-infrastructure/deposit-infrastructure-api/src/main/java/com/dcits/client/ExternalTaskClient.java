package com.dcits.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 跨组件外部任务客户端。
 *
 * 目标服务统一按 http://localhost:8980 部署，部署时按环境调整。
 * 平台组件步骤接口：POST /steps/{编码}，请求体直传 BO；
 * 非平台外部接口：GET {组件路径}/{方法名}，出入参照知识《外部接口清单》定案。
 */
public class ExternalTaskClient {

    /** 目标服务地址，部署时按环境调整 */
    private static final String BASE_URL = "http://localhost:8980";

    private final RestTemplate restTemplate;

    public ExternalTaskClient() {
        this.restTemplate = new RestTemplate();
    }

    public ExternalTaskClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 黑名单组件 · 任务《检查黑名单》 · 步骤《检查黑名单》（步骤接口 ST001）。
     * POST /steps/ST001，请求体直传 BO。
     * 出参：dealFlow 处理方式（A-授权/B-拒绝/D-提醒，通过时为空）。
     *
     * @param bo 检查黑名单步骤入参 BO
     * @return 响应体 JSON 字符串
     */
    public String executeST001(BlacklistStepBo bo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BlacklistStepBo> entity = new HttpEntity<>(bo, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                BASE_URL + "/steps/ST001", HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    /**
     * 产品管理 · 业务功能《查询产品信息》。
     * GET /productManagement/queryProductInfo，按「产品编号 + 参数KEY值」查询产品定义。
     * attrKey 取值：CLIENT_TYPE/ACCT_TYPE/INLAND_OFFSHORE/PROD_BRANCH/ACCT_NATURE/
     * ALL_DEP_FLAG/ALL_DRA_FLAG/WITHDRAWAL_TYPE/CCY/ALLOW_SUSPEND_FLAG。
     * 出参：acctType、withdrawalTypeList、ccyList、allowSuspendFlag、allDepFlag、
     * allDraFlag、clientType、inlandOffshoreFlag、branchList、acctAttr。
     *
     * @param prodNo  产品编号（必输，an..20）
     * @param attrKey 参数KEY值（必输，an..30）
     * @return 响应体 JSON 字符串
     */
    public String queryProductInfo(String prodNo, String attrKey) {
        String uri = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/productManagement/queryProductInfo")
                .queryParam("prodNo", prodNo)
                .queryParam("attrKey", attrKey)
                .encode()
                .toUriString();
        return get(uri);
    }

    /**
     * 产品管理 · 业务功能《查询产品利率信息》。
     * GET /productManagement/queryProductInterestRate，按「产品编号」查产品利率信息表。
     * 出参：intTypeList 利率类型列表、prodIntRate 产品利率、maxExecRate 最大执行利率、minExecRate 最小执行利率。
     *
     * @param prodNo 产品编号（必输，an..20）
     * @return 响应体 JSON 字符串
     */
    public String queryProductInterestRate(String prodNo) {
        String uri = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/productManagement/queryProductInterestRate")
                .queryParam("prodNo", prodNo)
                .encode()
                .toUriString();
        return get(uri);
    }

    /**
     * 基础公共 · 业务功能《生成账号》。
     * GET /basicCommon/genAcctNo，按「账号生成规则类型 + 交易机构 + 产品编号」生成账号。
     * 出参：acctNo 账号（an..32）。
     *
     * @param acctGenRuleType 账号生成规则类型（必输）
     * @param branch          交易机构（必输，a..30）
     * @param prodNo          产品编号（an..20）
     * @return 响应体 JSON 字符串
     */
    public String genAcctNo(String acctGenRuleType, String branch, String prodNo) {
        String uri = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/basicCommon/genAcctNo")
                .queryParam("acctGenRuleType", acctGenRuleType)
                .queryParam("branch", branch)
                .queryParam("prodNo", prodNo)
                .encode()
                .toUriString();
        return get(uri);
    }

    private String get(String uri) {
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    /**
     * 黑名单组件步骤《检查黑名单》（ST001）入参 BO。
     * 枚举类字段跨组件按业务值字符串传输，统一声明为 String。
     */
    public static class BlacklistStepBo {
        /** 凭证种类 */
        private String docClass;
        /** 交易机构号 */
        private String tranBranch;
        /** 证件类型 */
        private String documentType;
        /** 证件号码 */
        private String documentId;
        /** 账号 */
        private String baseAcctNo;
        /** 账户开立行行号 */
        private String acctBranch;
        /** 渠道类型 */
        private String sourceType;
        /** 交易代码 */
        private String programId;
        /** 交易类型 */
        private String tranType;
        /** 事件类型 */
        private String eventType;
        /** 卡介质 */
        private String cardMedium;
        /** 限制机构范围 */
        private String resBranchRange;
        /** 服务代码 */
        private String serviceCode;
        /** 接口服务类型 */
        private String messageType;
        /** 接口服务代码 */
        private String messageCode;
        /** 黑名单检查标志 */
        private String blacklistCheckFlag;
        /** 服务状态 */
        private String serviceStatus;
        /** 客户号 */
        private String clientNo;

        public String getDocClass() {
            return docClass;
        }

        public void setDocClass(String docClass) {
            this.docClass = docClass;
        }

        public String getTranBranch() {
            return tranBranch;
        }

        public void setTranBranch(String tranBranch) {
            this.tranBranch = tranBranch;
        }

        public String getDocumentType() {
            return documentType;
        }

        public void setDocumentType(String documentType) {
            this.documentType = documentType;
        }

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getBaseAcctNo() {
            return baseAcctNo;
        }

        public void setBaseAcctNo(String baseAcctNo) {
            this.baseAcctNo = baseAcctNo;
        }

        public String getAcctBranch() {
            return acctBranch;
        }

        public void setAcctBranch(String acctBranch) {
            this.acctBranch = acctBranch;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public String getProgramId() {
            return programId;
        }

        public void setProgramId(String programId) {
            this.programId = programId;
        }

        public String getTranType() {
            return tranType;
        }

        public void setTranType(String tranType) {
            this.tranType = tranType;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String getCardMedium() {
            return cardMedium;
        }

        public void setCardMedium(String cardMedium) {
            this.cardMedium = cardMedium;
        }

        public String getResBranchRange() {
            return resBranchRange;
        }

        public void setResBranchRange(String resBranchRange) {
            this.resBranchRange = resBranchRange;
        }

        public String getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(String serviceCode) {
            this.serviceCode = serviceCode;
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public String getMessageCode() {
            return messageCode;
        }

        public void setMessageCode(String messageCode) {
            this.messageCode = messageCode;
        }

        public String getBlacklistCheckFlag() {
            return blacklistCheckFlag;
        }

        public void setBlacklistCheckFlag(String blacklistCheckFlag) {
            this.blacklistCheckFlag = blacklistCheckFlag;
        }

        public String getServiceStatus() {
            return serviceStatus;
        }

        public void setServiceStatus(String serviceStatus) {
            this.serviceStatus = serviceStatus;
        }

        public String getClientNo() {
            return clientNo;
        }

        public void setClientNo(String clientNo) {
            this.clientNo = clientNo;
        }
    }
}
