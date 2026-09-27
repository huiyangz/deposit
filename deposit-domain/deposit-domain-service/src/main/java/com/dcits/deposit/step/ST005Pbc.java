package com.dcits.deposit.step;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.deposit.facade.bo.ST005InputBO;
import com.dcits.deposit.facade.bo.ST005OutputBO;
import com.dcits.deposit.facade.components.IRbBusTranJnlBcc;
import com.dcits.deposit.facade.eo.RbBusTranJnlEO;

/**
 * ST005 登记现金交易明细 步骤实现
 *
 * 步骤描述：
 * 1.登记现金交易明细：登记【现金交易明细】，记录交易类型、币种、借贷标志、交易金额。
 *
 * 登记目标实体为对公存款账户金融交易流水表（RB_BUS_TRAN_JNL），SPEC 仅声明
 * tranType/ccy/crDrInd/tranAmt 四个字段的取值来源，其余实体必填字段的取值来源
 * 已按需求处理流程放行，本实现不为它们发明取值。本步骤无业务失败场景。
 */
@Service
public class ST005Pbc implements IST005 {

	private final IRbBusTranJnlBcc rbBusTranJnlBcc;

	public ST005Pbc(IRbBusTranJnlBcc rbBusTranJnlBcc) {
		this.rbBusTranJnlBcc = rbBusTranJnlBcc;
	}

	@Override
	@Transactional
	public ST005OutputBO execute(ST005InputBO input) {
		ST005OutputBO output = new ST005OutputBO();

		// 子步骤1 登记现金交易明细：登记【现金交易明细】，记录交易类型、币种、借贷标志、交易金额
		RbBusTranJnlEO tranJnlEO = new RbBusTranJnlEO();
		tranJnlEO.setTranType(input.getTranType());
		tranJnlEO.setCcy(input.getCcy());
		tranJnlEO.setCrDrInd(input.getCrDrInd());
		tranJnlEO.setTranAmt(input.getTranAmt());
		rbBusTranJnlBcc.createSelective(tranJnlEO);

		// 登记完成，回显登记值
		output.setTranType(input.getTranType());
		output.setCcy(input.getCcy());
		output.setCrDrInd(input.getCrDrInd());
		output.setTranAmt(input.getTranAmt());
		output.setSucceed(true);
		return output;
	}
}
