package com.dcits.deposit.task.dto;

import jakarta.validation.constraints.NotNull;

/** T5S1 检查客户限制 交易接口输入 DTO */
public class T5S1InputDTO {

	/** 客户号（必填） */
	// FIXME 业务项:T5S1/检查客户限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:clientNo 标记必填，但为空或无效值时的行为（是否要求入参前置校验及校验不通过时的语义）未定义 - 影响:空/无效客户号输入时的交易行为未确定 - 待确认:是否要求入参前置校验及校验不通过时的语义（ST047 待确认事项 TBD-3 同源）
	@NotNull
	private String clientNo;

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}
}
