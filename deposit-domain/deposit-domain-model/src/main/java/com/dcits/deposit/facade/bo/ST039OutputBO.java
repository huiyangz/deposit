package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.IntType;

/**
 * ST039 登记账户计息信息 输出BO
 *
 * internalKey 至 realRate 的 8 个字段来源为对公存款利息明细表（RB_BUS_ACCT_INT_DETAIL），
 * 为已登记利息明细的回显；clientNo、cardNo、baseAcctNo、intIndFlag 来源为对公存款账户主表
 * （RB_BUS_ACCT）。SPEC 输出表中主表来源与明细表来源存在同名 internalKey，因读取操作及同名
 * 区分命名未定义（SPEC 已接受的需求处理结论），本 BO 以单一 internalKey 字段承载明细表来源
 * 的账户内部键值；主表来源的同名输出及 clientNo、cardNo、baseAcctNo、intIndFlag 均不由本
 * 步骤赋值，保持 null。
 */
public class ST039OutputBO extends StepResult {
	/** 账户内部键值（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private Integer internalKey;
	/** 利率类型（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private IntType intType;
	/** 税率（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private BigDecimal taxRate;
	/** 利息资本化标志（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private String intCapFlag;
	/** 计息开始日期（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private Date calcBeginDate;
	/** 账户利率浮动百分比（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private BigDecimal acctPercentRate;
	/** 账户利率浮动百分点（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private BigDecimal acctSpreadRate;
	/** 执行利率（对公存款利息明细表 RB_BUS_ACCT_INT_DETAIL） */
	private BigDecimal realRate;
	/** 客户号（对公存款账户主表 RB_BUS_ACCT，本步骤不赋值） */
	private String clientNo;
	/** 卡号（对公存款账户主表 RB_BUS_ACCT，本步骤不赋值） */
	private String cardNo;
	/** 账号（对公存款账户主表 RB_BUS_ACCT，本步骤不赋值） */
	private String baseAcctNo;
	/** 计息标志（对公存款账户主表 RB_BUS_ACCT，本步骤不赋值） */
	private IntIndFlag intIndFlag;

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

	public BigDecimal getRealRate() {
		return realRate;
	}

	public void setRealRate(BigDecimal realRate) {
		this.realRate = realRate;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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
}
