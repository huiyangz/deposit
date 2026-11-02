package com.dcits.deposit.task.dto;

/** T4S1 检查限额 交易接口输出 DTO */
public class T4S1OutputDTO {

	// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出 限额检查结果 的取值来源（由哪个步骤产生、承接输入直传还是多结论汇总）与取值编码未定义，且「非必填」的正常返回语义（始终返回/返回空值/省略字段）未定义（TBD-2、TBD-8） - 影响:场景无法确定该输出字段的填充来源与返回形态，暂不赋值 - 待确认:输出 限额检查结果 的取值来源、取值编码及「非必填」的具体含义

	/** 限额检查结果（非必填） */
	private String limitCheckResult;

	public String getLimitCheckResult() {
		return limitCheckResult;
	}

	public void setLimitCheckResult(String limitCheckResult) {
		this.limitCheckResult = limitCheckResult;
	}
}
