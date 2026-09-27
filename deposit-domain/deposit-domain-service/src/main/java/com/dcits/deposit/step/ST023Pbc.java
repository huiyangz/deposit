package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.facade.bo.ST023InputBO;
import com.dcits.deposit.facade.bo.ST023OutputBO;
import com.dcits.deposit.facade.components.IFmBranchCcyBcc;
import com.dcits.deposit.facade.eo.FmBranchCcyEO;

/**
 * ST023 检查机构币种交易权限
 */
@Service
public class ST023Pbc implements IST023 {

	private final IFmBranchCcyBcc fmBranchCcyBcc;

	public ST023Pbc(IFmBranchCcyBcc fmBranchCcyBcc) {
		this.fmBranchCcyBcc = fmBranchCcyBcc;
	}

	@Override
	public ST023OutputBO execute(ST023InputBO input) {
		ST023OutputBO output = new ST023OutputBO();

		// 子步骤1 获取机构币种列表：根据{交易机构号}查询【机构币种信息】获取[机构币种列表]
		FmBranchCcyEO queryEo = new FmBranchCcyEO();
		queryEo.setBranch(input.getTranBranch());
		List<FmBranchCcyEO> branchCcyList = fmBranchCcyBcc.findByEo(queryEo);

		// 子步骤2 检查账户币种：{交易币种}在[机构币种列表]范围内则检查通过，否则返回错误码 ER0047
		FmBranchCcyEO matched = findBranchCcy(branchCcyList, input.getTranCcy());
		if (matched == null) {
			output.setErrorCode("ER0047");
			output.setErrorMessage("ER0047::交易币种不在机构币种列表范围内");
			return output;
		}
		output.setCcy(matched.getCcy());
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤2 在[机构币种列表]中查找{交易币种}对应的机构币种记录，未命中返回 null
	 */
	private FmBranchCcyEO findBranchCcy(List<FmBranchCcyEO> branchCcyList, Ccy tranCcy) {
		for (FmBranchCcyEO eo : branchCcyList) {
			if (eo.getCcy() == tranCcy) {
				return eo;
			}
		}
		return null;
	}
}
