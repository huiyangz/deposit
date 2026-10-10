package com.dcits.depsit.facade.bo;

/**
 * ST132 计算账户解限可用余额 —— 输入 BO。
 *
 * <p>按 Spec「### 输入、输出及依赖契约」的输入表，本步骤只取用 1 个外部入参：
 * {@code baseAcctNo}（账号，必填，来源实体 对公存款账户主表（RB_BUS_ACCT）），
 * 即源需求步骤描述中的 {账号}，是本步骤第一段取数查询【账户信息】的查询条件。</p>
 *
 * <p>输入表中的 {@code internalKey}、{@code totalAmount}、{@code odAmount}、
 * {@code acctAvailBal} 均为本步骤引用或产生的实体字段（键值取自账户查询结果，
 * 汇总金额与透支金额取自余额查询结果），不作为调用方入参，故本 BO 不设这些字段。</p>
 */
public class ST132InputBO {

	/** 账号（必填）；源需求步骤描述中的 {账号} */
	private String baseAcctNo;

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}
}
