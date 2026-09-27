package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;

/**
 * ST036 设置允许转久悬标志 步骤实现
 *
 * 步骤描述：
 * 1.获取产品的是否允许转久悬标志：根据{产品编号}、{参数KEY值}访问产品管理《查询产品信息》，
 * 获取 $是否允许转久悬$。
 * 2.设置账户允许账户转久悬标志：按{允许账户转久悬标志}与产品[是否允许转久悬]的空值组合赋值。
 */
@Service
public class ST036Pbc implements IST036 {

	/** 子步骤2.a 默认赋值“Y-是”的编码部分（RB_BUS_ACCT.ALLOW_SUSPEND_FLAG 为 VARCHAR(1)） */
	private static final String DEFAULT_ALLOW_SUSPEND_FLAG = "Y";

	private final ExternalTaskClient externalTaskClient;

	public ST036Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST036OutputBO execute(ST036InputBO input) {
		ST036OutputBO output = new ST036OutputBO();

		// 子步骤1 获取产品的是否允许转久悬标志：根据{产品编号}、{参数KEY值}调用产品管理《查询产品信息》
		String prodAllowSuspendFlag =
				externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());

		// 子步骤2 设置账户允许账户转久悬标志
		String allowSuspendFlag;
		if (isEmpty(input.getAllowSuspendFlag())) {
			if (isEmpty(prodAllowSuspendFlag)) {
				// 子步骤2.a {允许账户转久悬标志}与产品[是否允许转久悬]均等于空，默认赋值“Y-是”（编码部分）
				allowSuspendFlag = DEFAULT_ALLOW_SUSPEND_FLAG;
			} else {
				// 子步骤2.b {允许账户转久悬标志}等于空且产品[是否允许转久悬]不等于空，取产品值
				allowSuspendFlag = prodAllowSuspendFlag;
			}
		} else {
			// 子步骤2.c/2.d {允许账户转久悬标志}不等于空，保留输入值（不论产品值是否为空）
			allowSuspendFlag = input.getAllowSuspendFlag();
		}

		output.setAllowSuspendFlag(allowSuspendFlag);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 统一空值判断：SPEC 未区分 null 与空字符串，均按“空”处理
	 */
	private boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}
}
