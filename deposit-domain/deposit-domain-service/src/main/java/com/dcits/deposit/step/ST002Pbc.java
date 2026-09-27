package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.facade.bo.ST002InputBO;
import com.dcits.deposit.facade.bo.ST002OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST002 检查交易币种 步骤实现
 *
 * 步骤描述：
 * 1.获取账户币种：根据{账号}查询【账户信息】获取$账户币种$
 * 2.检查币种一致性：若[账户币种]不等于{交易币种}，则返回[错误码]“ER0051”，
 * 否则返回检查结果为“通过”
 */
@Service
public class ST002Pbc implements IST002 {

	private final IRbBusAcctBcc rbBusAcctBcc;

	public ST002Pbc(IRbBusAcctBcc rbBusAcctBcc) {
		this.rbBusAcctBcc = rbBusAcctBcc;
	}

	@Override
	public ST002OutputBO execute(ST002InputBO input) {
		ST002OutputBO output = new ST002OutputBO();

		// 子步骤1 获取账户币种：根据{账号}查询【账户信息】获取$账户币种$
		RbBusAcctEO queryEo = new RbBusAcctEO();
		queryEo.setBaseAcctNo(input.getBaseAcctNo());
		List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(queryEo);
		if (acctList == null || acctList.isEmpty()) {
			// 查询未命中账户：该情形处理结果 SPEC 未定义（无错误码、无通过定义），
			// 不发明默认失败或成功，保持初始状态返回，留待需求方补充
			return output;
		}
		// 账号为账户主表业务键，按{账号}查询至多一条账户记录，取该记录的账户币种
		AcctCcy acctCcy = acctList.get(0).getAcctCcy();
		output.setAcctCcy(acctCcy);

		// 子步骤2 检查币种一致性：[账户币种]与{交易币种}为两个枚举类型，按币种代码值比较
		if (!acctCcy.getValue().equals(input.getTranCcy().getValue())) {
			// 账户币种不等于交易币种，返回错误码 ER0051
			output.setErrorCode("ER0051");
			output.setErrorMessage("ER0051::账户币种不等于交易币种");
			return output;
		}
		// 账户币种等于交易币种，检查结果为“通过”
		output.setSucceed(true);
		return output;
	}
}
