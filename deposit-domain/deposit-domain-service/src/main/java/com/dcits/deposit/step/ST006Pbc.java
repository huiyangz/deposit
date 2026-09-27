package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST006InputBO;
import com.dcits.deposit.facade.bo.ST006OutputBO;

/**
 * ST006 检查存入交易类型 步骤实现
 *
 * 步骤描述：
 * 1.检查交易类型：活期现金存入时，若{交易类型}不等于“现金存入”，则返回[错误码]“ER0049”，
 * 否则返回检查结果为“通过”。
 */
@Service
public class ST006Pbc implements IST006 {

	@Override
	public ST006OutputBO execute(ST006InputBO input) {
		ST006OutputBO output = new ST006OutputBO();
		// 子步骤1 检查交易类型：{交易类型}必须等于“现金存入”（TranType.VALUE_1000）
		if (input.getTranType() != TranType.VALUE_1000) {
			// 交易类型不等于“现金存入”，返回错误码 ER0049
			output.setSucceed(false);
			output.setErrorCode("ER0049");
			output.setErrorMessage("ER0049::交易类型不等于现金存入");
			return output;
		}
		// 交易类型等于“现金存入”，检查结果为“通过”
		output.setSucceed(true);
		return output;
	}
}
