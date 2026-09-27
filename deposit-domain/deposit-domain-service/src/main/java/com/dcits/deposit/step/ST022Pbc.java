package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST022InputBO;
import com.dcits.deposit.facade.bo.ST022OutputBO;

/**
 * ST022 检查现金项目编号 步骤实现
 *
 * 步骤描述：
 * 1.检查现金项目编号：若{现金项目编号}为空，则返回[错误码]“ER0056”，
 * 否则返回检查结果为“通过”。
 */
@Service
public class ST022Pbc implements IST022 {

	@Override
	public ST022OutputBO execute(ST022InputBO input) {
		ST022OutputBO output = new ST022OutputBO();
		// 子步骤1 检查现金项目编号：{现金项目编号}不能为空（CashItem 枚举无“空”常量，为空即 null 引用）
		if (input.getCashItem() == null) {
			// {现金项目编号}为空，返回错误码 ER0056
			output.setSucceed(false);
			output.setErrorCode("ER0056");
			output.setErrorMessage("ER0056::现金项目编号为空");
			return output;
		}
		// {现金项目编号}非空，检查结果为“通过”
		output.setSucceed(true);
		return output;
	}
}
