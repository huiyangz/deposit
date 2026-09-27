package com.dcits.deposit.step;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST020InputBO;
import com.dcits.deposit.facade.bo.ST020OutputBO;

/**
 * ST020 检查交易金额 步骤实现
 *
 * 步骤描述：
 * 1.检查交易金额：若{交易金额}小于等于0，则返回[错误码]“ER0050”，
 * 否则返回检查结果为“通过”。
 */
@Service
public class ST020Pbc implements IST020 {

	@Override
	public ST020OutputBO execute(ST020InputBO input) {
		ST020OutputBO output = new ST020OutputBO();
		// 子步骤1 检查交易金额：{交易金额}必须大于 0
		if (input.getTranAmt().compareTo(BigDecimal.ZERO) <= 0) {
			// 交易金额小于等于 0，返回错误码 ER0050
			output.setSucceed(false);
			output.setErrorCode("ER0050");
			output.setErrorMessage("ER0050::交易金额小于等于0");
			return output;
		}
		// 交易金额大于 0，检查结果为“通过”
		output.setSucceed(true);
		return output;
	}
}
