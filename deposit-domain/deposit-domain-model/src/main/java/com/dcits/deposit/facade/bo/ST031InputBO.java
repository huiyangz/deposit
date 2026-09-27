package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.deposit.enums.IntBasis;
import com.dcits.deposit.enums.IntType;

/** ST031 计算账户执行利率 输入BO */
public class ST031InputBO {
	/** 账户利率浮动百分点 */
	private BigDecimal acctSpreadRate;
	/** 账户利率浮动百分比 */
	private BigDecimal acctPercentRate;
	/** 账户固定利率 */
	private BigDecimal acctFixedRate;
	/** 产品编号 */
	private String prodNo;
	/** 利率类型 */
	private IntType intType;
	/** 基准利率类型 */
	private IntBasis intBasis;
	/** 基础汇率 */
	private BigDecimal baseRate;
	/** 行内挂牌利率 */
	private BigDecimal actualRate;

	public BigDecimal getAcctSpreadRate() {
		return acctSpreadRate;
	}

	public void setAcctSpreadRate(BigDecimal acctSpreadRate) {
		this.acctSpreadRate = acctSpreadRate;
	}

	public BigDecimal getAcctPercentRate() {
		return acctPercentRate;
	}

	public void setAcctPercentRate(BigDecimal acctPercentRate) {
		this.acctPercentRate = acctPercentRate;
	}

	public BigDecimal getAcctFixedRate() {
		return acctFixedRate;
	}

	public void setAcctFixedRate(BigDecimal acctFixedRate) {
		this.acctFixedRate = acctFixedRate;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public IntType getIntType() {
		return intType;
	}

	public void setIntType(IntType intType) {
		this.intType = intType;
	}

	public IntBasis getIntBasis() {
		return intBasis;
	}

	public void setIntBasis(IntBasis intBasis) {
		this.intBasis = intBasis;
	}

	public BigDecimal getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(BigDecimal baseRate) {
		this.baseRate = baseRate;
	}

	public BigDecimal getActualRate() {
		return actualRate;
	}

	public void setActualRate(BigDecimal actualRate) {
		this.actualRate = actualRate;
	}
}
