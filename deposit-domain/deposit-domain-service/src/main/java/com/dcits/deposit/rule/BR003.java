package com.dcits.deposit.rule;

/**
 * BR003 检查允许转久悬标志
 *
 * 规则类型：断言类
 *
 * 规则描述：
 * a.若允许账户转久悬标志等于"Y-是"且是否允许转久悬等于"N-否"，则返回否；
 * b.若允许账户转久悬标志等于"N-否"且是否允许转久悬等于空（null 或空字符串），则返回否；
 * c.否则，返回是。
 */
public class BR003 {

	/**
	 * 检查允许转久悬标志。
	 *
	 * @param allowSuspendFlag 允许账户转久悬标志，取值 Y（是）/N（否），必填
	 * @param allowDormantFlag 是否允许转久悬，取值 Y（是）/N（否），非必填，可为空
	 * @return 是否允许转久悬（是/否）
	 */
	public static boolean execute(String allowSuspendFlag, String allowDormantFlag) {
		// 分支a：允许账户转久悬标志为Y且是否允许转久悬为N，返回否
		if ("Y".equals(allowSuspendFlag) && "N".equals(allowDormantFlag)) {
			return false;
		}
		// 分支b：允许账户转久悬标志为N且是否允许转久悬为空（null或空字符串），返回否
		if ("N".equals(allowSuspendFlag) && (allowDormantFlag == null || allowDormantFlag.isEmpty())) {
			return false;
		}
		// 分支c：否则，返回是
		return true;
	}
}
