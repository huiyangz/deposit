package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;

/**
 * ST004 登记交易流水 输入BO
 */
public class ST004InputBO {

	/** 借贷标志 */
	private CrDrInd crDrInd;
	/** 币种 */
	private Ccy ccy;
	/** 交易类型 */
	private TranType tranType;
	/** 交易金额 */
	private BigDecimal tranAmt;
	/** 客户号 */
	private String clientNo;
	/** 序号 */
	private String seqNo;
	/** 交易日期 */
	private Date tranDate;
	/** 账户内部键值 */
	private Integer internalKey;
	/** 对手账户内部键 */
	private Integer othInternalKey;
	/** 创建时间戳 */
	private String createTimestamp;
	/** 最后修改时间戳 */
	private String lastUpdTimestamp;

	public CrDrInd getCrDrInd() {
		return crDrInd;
	}

	public void setCrDrInd(CrDrInd crDrInd) {
		this.crDrInd = crDrInd;
	}

	public Ccy getCcy() {
		return ccy;
	}

	public void setCcy(Ccy ccy) {
		this.ccy = ccy;
	}

	public TranType getTranType() {
		return tranType;
	}

	public void setTranType(TranType tranType) {
		this.tranType = tranType;
	}

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Date getTranDate() {
		return tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public Integer getInternalKey() {
		return internalKey;
	}

	public void setInternalKey(Integer internalKey) {
		this.internalKey = internalKey;
	}

	public Integer getOthInternalKey() {
		return othInternalKey;
	}

	public void setOthInternalKey(Integer othInternalKey) {
		this.othInternalKey = othInternalKey;
	}

	public String getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(String createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getLastUpdTimestamp() {
		return lastUpdTimestamp;
	}

	public void setLastUpdTimestamp(String lastUpdTimestamp) {
		this.lastUpdTimestamp = lastUpdTimestamp;
	}
}
