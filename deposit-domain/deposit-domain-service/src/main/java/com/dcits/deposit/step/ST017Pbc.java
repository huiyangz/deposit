package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.facade.bo.ST017InputBO;
import com.dcits.deposit.facade.bo.ST017OutputBO;

/**
 * ST017 设置贷记交易的借贷标志 步骤实现
 *
 * 步骤描述：
 * 1.赋值借贷标志：赋值[借贷标志]为“C-贷方”
 */
@Service
public class ST017Pbc implements IST017 {

	@Override
	public ST017OutputBO execute(ST017InputBO input) {
		ST017OutputBO output = new ST017OutputBO();
		// 子步骤1 赋值借贷标志：赋值[借贷标志]为“C-贷方”（CrDrInd.C）
		output.setCrDrInd(CrDrInd.C);
		// 本步骤无业务失败场景，赋值完成后成功返回
		output.setSucceed(true);
		return output;
	}
}
