package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.deposit.enums.IntType;

/**
 * ST049 检查账户执行利率 输入BO
 */
public class ST049InputBO {

	/** 执行利率（必填） */
	private BigDecimal realRate;
	/** 产品编号（必填） */
	private String prodNo;
	/** 利率类型（必填） */
	private IntType intType;
	/** 最小执行利率（非必填） */
	private BigDecimal minRate;
	/** 最大执行利率（非必填） */
	private BigDecimal maxRate;

	public BigDecimal getRealRate() {
		return realRate;
	}

	public void setRealRate(BigDecimal realRate) {
		this.realRate = realRate;
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

	public BigDecimal getMinRate() {
		return minRate;
	}

	public void setMinRate(BigDecimal minRate) {
		this.minRate = minRate;
	}

	public BigDecimal getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(BigDecimal maxRate) {
		this.maxRate = maxRate;
	}
}
