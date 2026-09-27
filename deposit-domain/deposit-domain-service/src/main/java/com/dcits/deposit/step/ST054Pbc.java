package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;

/**
 * ST054 设置账户执行利率
 */
@Service
public class ST054Pbc implements IST054 {

	@Override
	public ST054OutputBO execute(ST054InputBO input) {
		ST054OutputBO output = new ST054OutputBO();

		// 子步骤1 设置账户执行利率：赋值账户$执行利率$为[执行利率]
		output.setRealRate(input.getRealRate());

		output.setSucceed(true);
		return output;
	}
}
