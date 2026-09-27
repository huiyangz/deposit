package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.IntType;

/** ST039 登记账户计息信息 输入BO */
public class ST039InputBO {
	/** 客户号 */
	private String clientNo;
	/** 账号 */
	private String baseAcctNo;
	/** 计息标志 */
	private IntIndFlag intIndFlag;
	/** 账户内部键值 */
	private Integer internalKey;
	/** 利率类型 */
	private IntType intType;
	/** 税率 */
	private BigDecimal taxRate;
	/** 利息资本化标志 */
	private String intCapFlag;
	/** 计息开始日期 */
	private Date calcBeginDate;
	/** 账户利率浮动百分比（非必填） */
	private BigDecimal acctPercentRate;
	/** 账户利率浮动百分点（非必填） */
	private BigDecimal acctSpreadRate;
	/** 税率类型 */
	private String taxTypeNo;
	/** 执行利率 */
	private BigDecimal realRate;

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public String getBaseAcctNo() {
		return baseAcctNo;
	}

	public void setBaseAcctNo(String baseAcctNo) {
		this.baseAcctNo = baseAcctNo;
	}

	public IntIndFlag getIntIndFlag() {
		return intIndFlag;
	}

	public void setIntIndFlag(IntIndFlag intIndFlag) {
		this.intIndFlag = intIndFlag;
	}

	public Integer getInternalKey() {
		return internalKey;
	}

	public void setInternalKey(Integer internalKey) {
		this.internalKey = internalKey;
	}

	public IntType getIntType() {
		return intType;
	}

	public void setIntType(IntType intType) {
		this.intType = intType;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public String getIntCapFlag() {
		return intCapFlag;
	}

	public void setIntCapFlag(String intCapFlag) {
		this.intCapFlag = intCapFlag;
	}

	public Date getCalcBeginDate() {
		return calcBeginDate;
	}

	public void setCalcBeginDate(Date calcBeginDate) {
		this.calcBeginDate = calcBeginDate;
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

	public String getTaxTypeNo() {
		return taxTypeNo;
	}

	public void setTaxTypeNo(String taxTypeNo) {
		this.taxTypeNo = taxTypeNo;
	}

	public BigDecimal getRealRate() {
		return realRate;
	}

	public void setRealRate(BigDecimal realRate) {
		this.realRate = realRate;
	}
}
