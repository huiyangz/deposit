package com.dcits.deposit.step;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;

/**
 * ST045 设置生效日期
 */
@Service
public class ST045Pbc implements IST045 {

	@Override
	public ST045OutputBO execute(ST045InputBO input) {
		ST045OutputBO output = new ST045OutputBO();

		// 子步骤1 获取系统日期：赋值[系统日期]为{runDate}
		Date systemDate = input.getRunDate();

		// 子步骤2 设置生效日期：{生效日期}不等于空则赋值输出$生效日期$为{生效日期}并返回（2a）；
		// {生效日期}等于空则赋值输出$生效日期$为[系统日期]并返回（2b）
		if (input.getEffectDate() != null) {
			output.setEffectDate(input.getEffectDate());
		} else {
			output.setEffectDate(systemDate);
		}

		output.setSucceed(true);
		return output;
	}
}
