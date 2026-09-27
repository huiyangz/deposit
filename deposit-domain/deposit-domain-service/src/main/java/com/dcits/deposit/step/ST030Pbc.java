package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.AppointmentStatus;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.facade.bo.ST030InputBO;
import com.dcits.deposit.facade.bo.ST030OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctAppointmentBcc;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctAppointmentEO;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST030 检查账号
 */
@Service
public class ST030Pbc implements IST030 {

	/** 检查通过结果 */
	private static final String CHECK_RESULT_PASS = "通过";

	private final IRbBusAcctAppointmentBcc rbBusAcctAppointmentBcc;
	private final IRbBusAcctBcc rbBusAcctBcc;

	public ST030Pbc(IRbBusAcctAppointmentBcc rbBusAcctAppointmentBcc, IRbBusAcctBcc rbBusAcctBcc) {
		this.rbBusAcctAppointmentBcc = rbBusAcctAppointmentBcc;
		this.rbBusAcctBcc = rbBusAcctBcc;
	}

	@Override
	public ST030OutputBO execute(ST030InputBO input) {
		ST030OutputBO output = new ST030OutputBO();

		// 子步骤1 检查定制账户标志：{定制账户标志}为"N-非定制账户"跳转至《检查是否上送账号》，否则跳转至《根据定制账号获取账户信息》
		if (input.getSpecAcctFlag() == SpecAcctFlag.N) {
			return checkReservedAcct(input, output);
		}
		return checkCustomAcct(input, output);
	}

	/**
	 * 子步骤2-4 非定制账户路径：检查是否上送账号、获取预留账户信息、检查预留账号
	 */
	private ST030OutputBO checkReservedAcct(ST030InputBO input, ST030OutputBO output) {
		// 子步骤2 检查是否上送账号：已上送{账号}跳转至《获取预留账户信息》，否则返回检查结果"通过"
		if (input.getBaseAcctNo() == null || input.getBaseAcctNo().isEmpty()) {
			return pass(output);
		}

		// 子步骤3 获取预留账户信息：根据{账号}且$预约状态$为"S-预约成功"查询【账号预约信息】获取[预留账户信息]
		RbBusAcctAppointmentEO appointmentQuery = new RbBusAcctAppointmentEO();
		appointmentQuery.setBaseAcctNo(input.getBaseAcctNo());
		appointmentQuery.setAppointmentStatus(AppointmentStatus.S);
		List<RbBusAcctAppointmentEO> reservedAcctInfoList = rbBusAcctAppointmentBcc.findByEo(appointmentQuery);

		// 子步骤4 检查预留账号：[预留账户信息]不为空返回检查结果"通过"，否则返回错误码 ER0025
		if (reservedAcctInfoList.isEmpty()) {
			output.setErrorCode("ER0025");
			output.setErrorMessage("ER0025::预留账户信息为空");
			return output;
		}
		return pass(output);
	}

	/**
	 * 子步骤5-6 定制账户路径：根据定制账号获取账户信息、检查定制账号存在性
	 */
	private ST030OutputBO checkCustomAcct(ST030InputBO input, ST030OutputBO output) {
		// 子步骤5 根据定制账号获取账户信息：{账号}不等于空且{定制账户标志}等于"A-全账户定制"时根据{账号}查询【账户信息】获取[账户信息]，否则返回检查结果"通过"
		if (input.getBaseAcctNo() == null || input.getBaseAcctNo().isEmpty()
				|| input.getSpecAcctFlag() != SpecAcctFlag.A) {
			return pass(output);
		}

		RbBusAcctEO acctQuery = new RbBusAcctEO();
		acctQuery.setBaseAcctNo(input.getBaseAcctNo());
		List<RbBusAcctEO> acctInfoList = rbBusAcctBcc.findByEo(acctQuery);

		// 子步骤6 检查定制账号存在性：[账户信息]存在返回错误码 ER0026，否则返回检查结果"通过"
		if (!acctInfoList.isEmpty()) {
			output.setErrorCode("ER0026");
			output.setErrorMessage("ER0026::定制账号已存在账户信息");
			return output;
		}
		return pass(output);
	}

	/**
	 * 正常通过出口：设置检查结果"通过"并标记成功
	 */
	private ST030OutputBO pass(ST030OutputBO output) {
		output.setCheckResult(CHECK_RESULT_PASS);
		output.setSucceed(true);
		return output;
	}
}
