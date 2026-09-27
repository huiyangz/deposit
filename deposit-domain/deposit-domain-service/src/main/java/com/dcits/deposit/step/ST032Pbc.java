package com.dcits.deposit.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST032InputBO;
import com.dcits.deposit.facade.bo.ST032OutputBO;

/**
 * ST032 检查账户机构 步骤实现
 *
 * 步骤描述：
 * 1.获取产品的机构：根据{产品编号}、{参数KEY值}访问业务组件《产品管理》的业务功能《查询产品信息》，获取[机构]列表。
 * 2.检查产品配置的机构是否包含交易机构：[机构]列表包括{交易机构}则检查通过，否则返回错误码 ER0005。
 */
@Service
public class ST032Pbc implements IST032 {

	/** 机构列表属性值的元素分隔符（半角逗号） */
	private static final String BRANCH_SEPARATOR = ",";

	private final ExternalTaskClient externalTaskClient;

	public ST032Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST032OutputBO execute(ST032InputBO input) {
		ST032OutputBO output = new ST032OutputBO();

		// 子步骤1 获取产品的机构：根据{产品编号}、{参数KEY值}调用《产品管理》《查询产品信息》，
		// 返回该 key 对应属性值原值（查不到返回空串），按半角逗号分隔解析为[机构]列表
		String attrValue = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());
		List<String> branchList = parseBranchList(attrValue);

		// 子步骤2 检查产品配置的机构是否包含交易机构：{交易机构}的机构编号与[机构]列表元素精确相等则检查通过，
		// 否则返回错误码 ER0005
		if (!branchList.contains(input.getTranBranch().getValue())) {
			output.setErrorCode("ER0005");
			output.setErrorMessage("ER0005::产品配置的机构列表不包含交易机构");
			return output;
		}

		// 检查通过
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤1 解析[机构]列表：属性值原值为以半角逗号分隔的机构编号串，单机构时为不带分隔符的单个编号；
	 * 查询无记录返回空串，即空列表
	 */
	private List<String> parseBranchList(String attrValue) {
		List<String> branchList = new ArrayList<>();
		if (attrValue.isEmpty()) {
			return branchList;
		}
		for (String branch : attrValue.split(BRANCH_SEPARATOR)) {
			branchList.add(branch);
		}
		return branchList;
	}
}
