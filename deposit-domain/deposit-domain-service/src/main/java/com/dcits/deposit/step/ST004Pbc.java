package com.dcits.deposit.step;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.deposit.facade.bo.ST004InputBO;
import com.dcits.deposit.facade.bo.ST004OutputBO;
import com.dcits.deposit.facade.components.IRbBusTranJnlBcc;
import com.dcits.deposit.facade.eo.RbBusTranJnlEO;

/**
 * ST004 登记交易流水 步骤实现
 *
 * 步骤描述：
 * 1.登记金融交易流水：登记【交易流水】，记录交易类型、币种、借贷标志、交易金额。
 *
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
@Service
public class ST004Pbc implements IST004 {

	private final IRbBusTranJnlBcc rbBusTranJnlBcc;

	public ST004Pbc(IRbBusTranJnlBcc rbBusTranJnlBcc) {
		this.rbBusTranJnlBcc = rbBusTranJnlBcc;
	}

	@Override
	@Transactional
	public ST004OutputBO execute(ST004InputBO input) {
		ST004OutputBO output = new ST004OutputBO();

		// 子步骤1 登记金融交易流水：将 11 个输入字段写入【交易流水】（RB_BUS_TRAN_JNL），
		// 记录交易类型、币种、借贷标志、交易金额
		RbBusTranJnlEO tranJnl = new RbBusTranJnlEO();
		tranJnl.setCrDrInd(input.getCrDrInd());
		tranJnl.setCcy(input.getCcy());
		tranJnl.setTranType(input.getTranType());
		tranJnl.setTranAmt(input.getTranAmt());
		tranJnl.setClientNo(input.getClientNo());
		tranJnl.setSeqNo(input.getSeqNo());
		tranJnl.setTranDate(input.getTranDate());
		tranJnl.setInternalKey(input.getInternalKey());
		tranJnl.setOthInternalKey(input.getOthInternalKey());
		tranJnl.setCreateTimestamp(input.getCreateTimestamp());
		tranJnl.setLastUpdTimestamp(input.getLastUpdTimestamp());
		rbBusTranJnlBcc.create(tranJnl);

		// 登记完成，回显已登记进 RB_BUS_TRAN_JNL 的四个业务字段
		output.setCrDrInd(tranJnl.getCrDrInd());
		output.setCcy(tranJnl.getCcy());
		output.setTranType(tranJnl.getTranType());
		output.setTranAmt(tranJnl.getTranAmt());
		output.setSucceed(true);
		return output;
	}
}
