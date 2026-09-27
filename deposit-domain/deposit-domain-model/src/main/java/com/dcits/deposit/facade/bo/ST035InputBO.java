package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/** ST035 检查利率浮动类型 输入BO */
public class ST035InputBO {
	/** 账户固定利率 */
	private BigDecimal acctFixedRate;
	/** 账户利率浮动百分比 */
	private BigDecimal acctPercentRate;
	/** 账户利率浮动百分点 */
	private BigDecimal acctSpreadRate;

	public BigDecimal getAcctFixedRate() {
		return acctFixedRate;
	}

	public void setAcctFixedRate(BigDecimal acctFixedRate) {
		this.acctFixedRate = acctFixedRate;
	}

	public BigDecimal getAcctPercentRate() {
		return acctPercentRate;
	}

	public void setAcctPercentRate(BigDecimal acctPercentRate) {
		this.acctPercentRate = acctPercentRate;
	}

	public BigDecimal getAcctSpreadRate() {
		return acctSpreadRate;
	}

	public void setAcctSpreadRate(BigDecimal acctSpreadRate) {
		this.acctSpreadRate = acctSpreadRate;
	}
}
