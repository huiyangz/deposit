package com.dcits.deposit.facade.bo;

import java.util.Date;

/** ST045 设置生效日期 输入BO */
public class ST045InputBO {
	/** 核心运行日期 */
	private Date runDate;
	/** 生效日期 */
	private Date effectDate;

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}
}
