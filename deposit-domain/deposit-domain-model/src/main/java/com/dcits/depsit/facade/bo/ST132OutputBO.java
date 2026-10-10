package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST132 计算账户解限可用余额 —— 输出 BO。
 *
 * <p>继承项目既有步骤结果契约 {@link StepResult}，不重复声明
 * {@code succeed}/{@code errorCode}/{@code errorMessage}。</p>
 *
 * <p>按 Spec「### 输入、输出及依赖契约」的输出表，本步骤只有 1 个业务输出：
 * {@code acctAvailBal}（账户可用余额，{@code java.math.BigDecimal}，非必填，
 * 来源实体 对公存款账户余额表（RB_BUS_ACCT_BALANCE）），取值为
 * {@code totalAmount} + {@code odAmount}。输出表的「非必填」标记只表示实体字段本身可空；
 * 取数成功的路径恒产出该输出，取数失败的路径不产出。</p>
 */
public class ST132OutputBO extends StepResult {

	/** 账户可用余额（非必填）；成功路径下为 汇总金额 + 透支金额 */
	private BigDecimal acctAvailBal;

	public BigDecimal getAcctAvailBal() {
		return acctAvailBal;
	}

	public void setAcctAvailBal(BigDecimal acctAvailBal) {
		this.acctAvailBal = acctAvailBal;
	}
}
