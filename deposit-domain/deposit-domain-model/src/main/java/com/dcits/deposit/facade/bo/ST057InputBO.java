package com.dcits.deposit.facade.bo;

import java.util.List;

import com.dcits.deposit.enums.SettleAcctClass;

/** ST057 检查利息资本化标志 输入BO */
public class ST057InputBO {
	/** 利息资本化标志 */
	private String intCapFlag;
	/** 上送的结算账户数组 */
	private List<SettleAcctDTO> settleAccts;

	public String getIntCapFlag() {
		return intCapFlag;
	}

	public void setIntCapFlag(String intCapFlag) {
		this.intCapFlag = intCapFlag;
	}

	public List<SettleAcctDTO> getSettleAccts() {
		return settleAccts;
	}

	public void setSettleAccts(List<SettleAcctDTO> settleAccts) {
		this.settleAccts = settleAccts;
	}

	/**
	 * 结算账户DTO。
	 * 元素完整结构按 SPEC 已接受的需求处理结论待确认，本步骤业务仅依赖
	 * 已确认的{结算账户类型}（com.dcits.deposit.enums.SettleAcctClass）。
	 */
	public static class SettleAcctDTO {
		/** 结算账户类型 */
		private SettleAcctClass settleAcctClass;

		public SettleAcctClass getSettleAcctClass() {
			return settleAcctClass;
		}

		public void setSettleAcctClass(SettleAcctClass settleAcctClass) {
			this.settleAcctClass = settleAcctClass;
		}
	}
}
