package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

import com.dcits.common.step.StepResult;

/**
 * ST024 检查法人透支金额 输出。
 *
 * <p>继承 {@link StepResult}，业务字段来自 Spec 输出表；succeed / errorCode / errorMessage
 * 由基类提供，不重复声明。</p>
 */
public class ST024OutputBO extends StepResult {

	/** 靠档计息跨月跨季标志（非必填，本步骤按靠档跨月季标识赋值） */
	private String isCrossFlag;

	/** 单笔透支检查金额（非必填，法人透支白名单参数表 RB_OD_WHITE_LIMIT_INFO） */
	private BigDecimal odPtAmt;

	/** 同一支付对象当日累计透支金额（非必填，法人透支白名单参数表 RB_OD_WHITE_LIMIT_INFO） */
	private BigDecimal sameObjectPdOdCumulative;

	public String getIsCrossFlag() {
		return isCrossFlag;
	}

	public void setIsCrossFlag(String isCrossFlag) {
		this.isCrossFlag = isCrossFlag;
	}

	public BigDecimal getOdPtAmt() {
		return odPtAmt;
	}

	public void setOdPtAmt(BigDecimal odPtAmt) {
		this.odPtAmt = odPtAmt;
	}

	public BigDecimal getSameObjectPdOdCumulative() {
		return sameObjectPdOdCumulative;
	}

	public void setSameObjectPdOdCumulative(BigDecimal sameObjectPdOdCumulative) {
		this.sameObjectPdOdCumulative = sameObjectPdOdCumulative;
	}
}
