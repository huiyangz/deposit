package com.dcits.depsit.step;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST132InputBO;
import com.dcits.depsit.facade.bo.ST132OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBalanceBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.RbBusAcctBalanceEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;

/**
 * ST132 计算账户解限可用余额 —— 步骤实现。
 *
 * <p>编排（源需求「## 步骤描述」1、2）：</p>
 * <ol>
 *   <li>按 {账号}（入参 {@code baseAcctNo}）查询【账户信息】取得账户内部键值；</li>
 *   <li>按该账户内部键值查询【账户余额信息】取得汇总金额与透支金额；</li>
 *   <li>赋值 [账户可用余额] = {汇总金额} 加 {透支金额}，并作为步骤输出返回。</li>
 * </ol>
 *
 * <p>业务失败只有一类：查不到账户或该账户没有余额记录，两者均返回错误码 {@code ER0048}
 * （{@code errorcodes.properties}：ER0048=账户不存在）并结束本步骤，不执行余额查询与计算；
 * 其余失败仅由技术异常传播表达，本实现不捕获、不转换、不重试。</p>
 */
@Service
public class ST132Pbc implements IST132 {

	/** 业务失败错误码：账户不存在（源需求「## 失败处理」）。 */
	private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";

	/** 业务失败错误信息，格式为「错误码::业务说明」。 */
	private static final String ERROR_MSG_ACCT_NOT_EXIST = "ER0048::账户不存在";

	/** 【账户信息】数据服务接口。 */
	@Autowired
	private IRbBusAcctBcc rbBusAcctBcc;

	/** 【账户余额信息】数据服务接口。 */
	@Autowired
	private IRbBusAcctBalanceBcc rbBusAcctBalanceBcc;

	/**
	 * 执行本步骤（只读取数与计算，无本地写入）。
	 */
	@Override
	public ST132OutputBO execute(ST132InputBO input) {
		ST132OutputBO output = new ST132OutputBO();

		// 子步骤 1 前段：按 {账号} 查询【账户信息】取得账户内部键值（REQ-001）
		RbBusAcctEO acctCondition = new RbBusAcctEO();
		acctCondition.setBaseAcctNo(input.getBaseAcctNo());
		List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(acctCondition);
		if (acctList == null || acctList.isEmpty()) {
			// 查不到账户：返回 ER0048 并结束本步骤，不执行余额查询与计算、不产出输出（REQ-001-S02）
			output.setSucceed(false);
			output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
			output.setErrorMessage(ERROR_MSG_ACCT_NOT_EXIST);
			return output;
		}
		// 同一账号对应多条账户记录时的处理源需求未定义（Spec「明确不覆盖」），本实现取查询结果
		// 的第一条记录，该情形不在本轮验收范围内。
		Integer internalKey = acctList.get(0).getInternalKey();

		// 子步骤 1 后段：按账户内部键值查询【账户余额信息】取得汇总金额与透支金额（REQ-002）
		// 注：余额表主键为账户内部键值、无账号列，故查询条件使用上一步取得的键值而非 {账号}
		RbBusAcctBalanceEO balance = rbBusAcctBalanceBcc.findByPrimaryKey(internalKey);
		if (balance == null) {
			// 该账户没有余额记录：与查不到账户同一错误码 ER0048，不执行计算、不产出输出（REQ-002-S02）
			output.setSucceed(false);
			output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
			output.setErrorMessage(ERROR_MSG_ACCT_NOT_EXIST);
			return output;
		}

		// 子步骤 2：赋值 [账户可用余额] = {汇总金额} 加 {透支金额}（REQ-003）
		BigDecimal totalAmount = balance.getTotalAmount();
		BigDecimal odAmount = balance.getOdAmount();
		BigDecimal acctAvailBal = totalAmount.add(odAmount);

		// 输出：成功路径恒产出 acctAvailBal，取值等于计算结果（REQ-004）
		output.setAcctAvailBal(acctAvailBal);
		output.setSucceed(true);
		return output;
	}
}
