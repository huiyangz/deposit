package com.dcits.deposit.task.dto;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotNull;

/** T4S1 检查限额 交易接口输入 DTO */
public class T4S1InputDTO {

	// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求「输入」表前 4 行「待定：实体#字段-R」（限额累计信息表#限额场景编码-R、对公存款账户限制表#账号-R、限额控制配置#限额场景编码-R、限额累计信息表#客户号-R）的业务含义、取值来源及与 baseAcctNo/limitSceneNo/clientNo 等输入的对应关系未定义（TBD-1） - 影响:4 个 DTO 字段仅按类型约束保留，场景无已定义消费者与映射，无法确定其业务用途 - 待确认:4 行的实际用途、取值来源及与步骤 BO 输入的映射

	/** 待定输入：限额累计信息表#限额场景编码-R（业务含义未定义，见 TBD-1） */
	@NotNull
	private String sumInfoSceneNo;

	/** 待定输入：对公存款账户限制表#账号-R（业务含义未定义，见 TBD-1） */
	@NotNull
	private String restrictAcctNo;

	/** 待定输入：限额控制配置#限额场景编码-R（业务含义未定义，见 TBD-1） */
	@NotNull
	private String ctrlSceneNo;

	/** 待定输入：限额累计信息表#客户号-R（业务含义未定义，见 TBD-1） */
	@NotNull
	private String sumInfoCustNo;

	/** 因子名称（必填） */
	@NotNull
	private String factorName;

	/** 账号（必填） */
	@NotNull
	private String baseAcctNo;

	/** 交易日期（必填） */
	@NotNull
	private Date tranDate;

	/** 交易时间戳（必填） */
	@NotNull
	private String tranTimestamp;

	/** 限额场景编码（必填） */
	@NotNull
	private String limitSceneNo;

	/** 客户号（必填） */
	@NotNull
	private String clientNo;

	/** 交易金额（必填） */
	@NotNull
	private BigDecimal tranAmt;

	/** 限额检查结果（必填） */
	@NotNull
	private String limitCheckResult;

	// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求将 12 项输入均标记为必填，但输入为空或缺失时的行为（是否校验、是否拒绝执行、错误码与返回形态）未定义（TBD-7） - 影响:DTO 以 @NotNull 声明必填，但缺失输入在接口边界的拒绝行为无法确定 - 待确认:必填输入缺失时的校验与错误表达方式

	public String getSumInfoSceneNo() {
		return sumInfoSceneNo;
	}

	public void setSumInfoSceneNo(String sumInfoSceneNo) {
		this.sumInfoSceneNo = sumInfoSceneNo;
	}

	public String getRestrictAcctNo() {
		return restrictAcctNo;
	}

	public void setRestrictAcctNo(String restrictAcctNo) {
		this.restrictAcctNo = restrictAcctNo;
	}

	public String getCtrlSceneNo() {
		return ctrlSceneNo;
	}

	public void setCtrlSceneNo(String ctrlSceneNo) {
		this.ctrlSceneNo = ctrlSceneNo;
	}

	public String getSumInfoCustNo() {
		return sumInfoCustNo;
	}

	public void setSumInfoCustNo(String sumInfoCustNo) {
		this.sumInfoCustNo = sumInfoCustNo;
	}

	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranTimestamp() {
		return tranTimestamp;
	}

	public void setTranTimestamp(String tranTimestamp) {
		this.tranTimestamp = tranTimestamp;
	}

	public String getLimitSceneNo() {
		return limitSceneNo;
	}

	public void setLimitSceneNo(String limitSceneNo) {
		this.limitSceneNo = limitSceneNo;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getLimitCheckResult() {
		return limitCheckResult;
	}

	public void setLimitCheckResult(String limitCheckResult) {
		this.limitCheckResult = limitCheckResult;
	}
}
