package com.dcits.client;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import com.dcits.common.exception.TransException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**跨组件客户端：存款业务组件访问外部业务组件的统一入口**/
public class ExternalTaskClient {

	/**目标服务基础地址，部署时按环境调整**/
	private static final String BASE_URL = "http://localhost:8980";

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private final HttpClient httpClient;

	public ExternalTaskClient() {
		this.httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(10))
				.build();
	}

	/**
	 * 黑名单组件 · 步骤接口 ST001《检查黑名单》
	 * 平台登记步骤接口，POST /steps/ST001 直传 BO：
	 * 入参含 docClass、tranBranch、documentType、documentId、baseAcctNo、acctBranch、sourceType、programId、
	 * tranType、eventType、cardMedium、resBranchRange、serviceCode、messageType、messageCode、
	 * blacklistCheckFlag、serviceStatus、clientNo；出参 dealFlow（处理方式）。
	 **/
	public Map<String, Object> executeST001(Map<String, Object> bo) {
		return postJson("/steps/ST001", bo);
	}

	/**
	 * 产品管理 · 查询产品信息
	 * 外部接口清单定案，GET /productManagement/queryProductInfo：
	 * 按「产品编号 + 参数KEY值」的 KV 结构查询产品定义表，返回该 key 对应的属性值
	 * （acctType、withdrawalTypeList、ccyList、allowSuspendFlag、allDepFlag、allDraFlag、
	 * clientType、inlandOffshoreFlag、branchList、acctAttr）。
	 **/
	public Map<String, Object> queryProductInfo(String prodNo, String attrKey) {
		return getJson("/productManagement/queryProductInfo",
				"prodNo", prodNo, "attrKey", attrKey);
	}

	/**
	 * 产品管理 · 查询产品利率信息
	 * 外部接口清单定案，GET /productManagement/queryProductInterestRate：
	 * 按产品编号查产品利率信息表，返回 intTypeList、prodIntRate、maxExecRate、minExecRate。
	 **/
	public Map<String, Object> queryProductInterestRate(String prodNo) {
		return getJson("/productManagement/queryProductInterestRate", "prodNo", prodNo);
	}

	/**
	 * 基础公共 · 生成账号
	 * 外部接口清单定案，GET /basicCommon/genAcctNo：
	 * 按「账号生成规则类型 + 交易机构 + 产品编号」生成账号，出参 acctNo。
	 **/
	public String genAcctNo(String acctGenRuleType, String branch, String prodNo) {
		Map<String, Object> body = getJson("/basicCommon/genAcctNo",
				"acctGenRuleType", acctGenRuleType, "branch", branch, "prodNo", prodNo);
		Object acctNo = body.get("acctNo");
		return acctNo == null ? null : acctNo.toString();
	}

	/**POST JSON：请求体直传 BO，响应体按 JSON 对象返回**/
	private Map<String, Object> postJson(String path, Map<String, Object> bo) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(BASE_URL + path))
					.header("Content-Type", "application/json")
					.timeout(Duration.ofSeconds(30))
					.POST(HttpRequest.BodyPublishers.ofString(OBJECT_MAPPER.writeValueAsString(bo), StandardCharsets.UTF_8))
					.build();
			return exchange(request);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**GET：查询参数逐个 URL 编码后拼接，响应体按 JSON 对象返回**/
	private Map<String, Object> getJson(String path, String... queryParams) {
		StringBuilder url = new StringBuilder(BASE_URL).append(path);
		for (int i = 0; i + 1 < queryParams.length; i += 2) {
			url.append(i == 0 ? '?' : '&')
					.append(encode(queryParams[i])).append('=')
					.append(encode(queryParams[i + 1]));
		}
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url.toString()))
				.header("Accept", "application/json")
				.timeout(Duration.ofSeconds(30))
				.GET()
				.build();
		return exchange(request);
	}

	private Map<String, Object> exchange(HttpRequest request) {
		String bodyText;
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
			if (response.statusCode() < 200 || response.statusCode() >= 300) {
				throw new TransException("ER-SYSCALL-" + response.statusCode(),
						"外部组件调用失败：" + response.uri() + "，HTTP " + response.statusCode());
			}
			bodyText = response.body();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new TransException("ER-SYSCALL-INT", "外部组件调用被中断：" + request.uri());
		}
		try {
			return OBJECT_MAPPER.readValue(bodyText, new TypeReference<Map<String, Object>>() {
			});
		} catch (IOException e) {
			throw new TransException("ER-SYSCALL-FORMAT", "外部组件响应不是合法JSON对象：" + request.uri());
		}
	}

	private static String encode(String value) {
		return URLEncoder.encode(value, StandardCharsets.UTF_8);
	}
}
