package com.dcits.client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 跨组件客户端：本组件对外部业务组件的统一调用入口。
 *
 * 平台组件走登记接口：步骤接口 POST /steps/{编码} 直传 BO。
 * 非平台组件走《外部接口清单》定案的 GET 接口。
 * 目标服务统一按 http://localhost:8980 部署，部署时按环境调整。
 */
@Component
public class ExternalTaskClient {

	/**目标服务地址，部署时按环境调整**/
	private static final String BASE_URL = "http://localhost:8980";

	private final RestTemplate restTemplate;

	public ExternalTaskClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	// ===== 平台组件：黑名单组件 =====

	/**
	 * 黑名单组件·检查黑名单（步骤接口 ST001 检查黑名单）。
	 * POST /steps/ST001，请求体直传 BO。
	 */
	public BlacklistCheckResult executeST001(BlacklistCheckBO bo) {
		return restTemplate.postForObject(BASE_URL + "/steps/ST001", bo, BlacklistCheckResult.class);
	}

	// ===== 非平台组件：产品管理（《外部接口清单》定案） =====

	/**
	 * 产品管理·查询产品信息。
	 * GET /productManagement/queryProductInfo，按「产品编号 + 参数KEY值」查询产品定义属性值。
	 */
	public QueryProductInfoResult queryProductInfo(String prodNo, String attrKey) {
		String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/productManagement/queryProductInfo")
				.queryParam("prodNo", prodNo)
				.queryParam("attrKey", attrKey)
				.toUriString();
		return restTemplate.getForObject(url, QueryProductInfoResult.class);
	}

	/**
	 * 产品管理·查询产品利率信息。
	 * GET /productManagement/queryProductInterestRate，按「产品编号」查产品利率信息表。
	 */
	public QueryProductInterestRateResult queryProductInterestRate(String prodNo) {
		String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/productManagement/queryProductInterestRate")
				.queryParam("prodNo", prodNo)
				.toUriString();
		return restTemplate.getForObject(url, QueryProductInterestRateResult.class);
	}

	// ===== 非平台组件：基础公共（《外部接口清单》定案） =====

	/**
	 * 基础公共·生成账号。
	 * GET /basicCommon/genAcctNo，按「账号生成规则类型 + 交易机构 + 产品编号」生成账号。
	 */
	public GenAcctNoResult genAcctNo(String acctGenRuleType, String branch, String prodNo) {
		String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/basicCommon/genAcctNo")
				.queryParam("acctGenRuleType", acctGenRuleType)
				.queryParam("branch", branch)
				.queryParam("prodNo", prodNo)
				.toUriString();
		return restTemplate.getForObject(url, GenAcctNoResult.class);
	}

	// ===== 报文对象 =====

	/**黑名单组件 ST001 检查黑名单 输入BO（字段按平台登记接口契约，枚举字段按值传递）**/
	public static class BlacklistCheckBO {
		/**凭证种类**/
		private String docClass;
		/**交易机构号**/
		private String tranBranch;
		/**证件类型**/
		private String documentType;
		/**证件号码**/
		private String documentId;
		/**账号**/
		private String baseAcctNo;
		/**账户开立行行号**/
		private String acctBranch;
		/**渠道类型**/
		private String sourceType;
		/**交易代码**/
		private String programId;
		/**交易类型**/
		private String tranType;
		/**事件类型**/
		private String eventType;
		/**卡介质**/
		private String cardMedium;
		/**限制机构范围**/
		private String resBranchRange;
		/**服务代码**/
		private String serviceCode;
		/**接口服务类型**/
		private String messageType;
		/**接口服务代码**/
		private String messageCode;
		/**黑名单检查标志**/
		private String blacklistCheckFlag;
		/**服务状态**/
		private String serviceStatus;
		/**客户号**/
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

	/**黑名单组件 ST001 检查黑名单 输出（处理方式）**/
	public static class BlacklistCheckResult {
		/**处理方式（A-授权/B-拒绝/D-提醒），检查通过时为 null**/
		private String dealFlow;

		public String getDealFlow() {
			return dealFlow;
		}
		public void setDealFlow(String dealFlow) {
			this.dealFlow = dealFlow;
		}
	}

	/**产品管理·查询产品信息 出参**/
	public static class QueryProductInfoResult {
		/**账户类型**/
		private String acctType;
		/**支取方式列表**/
		private List<String> withdrawalTypeList;
		/**币种列表**/
		private List<String> ccyList;
		/**是否允许转久悬**/
		private String allowSuspendFlag;
		/**通存标志**/
		private String allDepFlag;
		/**通兑标志**/
		private String allDraFlag;
		/**客户类型**/
		private String clientType;
		/**境内境外标志**/
		private String inlandOffshoreFlag;
		/**机构列表**/
		private List<String> branchList;
		/**账户属性**/
		private String acctAttr;

		public String getAcctType() {
			return acctType;
		}
		public void setAcctType(String acctType) {
			this.acctType = acctType;
		}
		public List<String> getWithdrawalTypeList() {
			return withdrawalTypeList;
		}
		public void setWithdrawalTypeList(List<String> withdrawalTypeList) {
			this.withdrawalTypeList = withdrawalTypeList;
		}
		public List<String> getCcyList() {
			return ccyList;
		}
		public void setCcyList(List<String> ccyList) {
			this.ccyList = ccyList;
		}
		public String getAllowSuspendFlag() {
			return allowSuspendFlag;
		}
		public void setAllowSuspendFlag(String allowSuspendFlag) {
			this.allowSuspendFlag = allowSuspendFlag;
		}
		public String getAllDepFlag() {
			return allDepFlag;
		}
		public void setAllDepFlag(String allDepFlag) {
			this.allDepFlag = allDepFlag;
		}
		public String getAllDraFlag() {
			return allDraFlag;
		}
		public void setAllDraFlag(String allDraFlag) {
			this.allDraFlag = allDraFlag;
		}
		public String getClientType() {
			return clientType;
		}
		public void setClientType(String clientType) {
			this.clientType = clientType;
		}
		public String getInlandOffshoreFlag() {
			return inlandOffshoreFlag;
		}
		public void setInlandOffshoreFlag(String inlandOffshoreFlag) {
			this.inlandOffshoreFlag = inlandOffshoreFlag;
		}
		public List<String> getBranchList() {
			return branchList;
		}
		public void setBranchList(List<String> branchList) {
			this.branchList = branchList;
		}
		public String getAcctAttr() {
			return acctAttr;
		}
		public void setAcctAttr(String acctAttr) {
			this.acctAttr = acctAttr;
		}
	}

	/**产品管理·查询产品利率信息 出参**/
	public static class QueryProductInterestRateResult {
		/**利率类型列表**/
		private List<String> intTypeList;
		/**产品利率（表内无此字段，取最小执行利率占位）**/
		private String prodIntRate;
		/**最大执行利率**/
		private String maxExecRate;
		/**最小执行利率**/
		private String minExecRate;

		public List<String> getIntTypeList() {
			return intTypeList;
		}
		public void setIntTypeList(List<String> intTypeList) {
			this.intTypeList = intTypeList;
		}
		public String getProdIntRate() {
			return prodIntRate;
		}
		public void setProdIntRate(String prodIntRate) {
			this.prodIntRate = prodIntRate;
		}
		public String getMaxExecRate() {
			return maxExecRate;
		}
		public void setMaxExecRate(String maxExecRate) {
			this.maxExecRate = maxExecRate;
		}
		public String getMinExecRate() {
			return minExecRate;
		}
		public void setMinExecRate(String minExecRate) {
			this.minExecRate = minExecRate;
		}
	}

	/**基础公共·生成账号 出参**/
	public static class GenAcctNoResult {
		/**账号**/
		private String acctNo;

		public String getAcctNo() {
			return acctNo;
		}
		public void setAcctNo(String acctNo) {
			this.acctNo = acctNo;
		}
	}
}
