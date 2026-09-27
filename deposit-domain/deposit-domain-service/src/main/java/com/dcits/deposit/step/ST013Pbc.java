package com.dcits.deposit.step;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.facade.bo.ST013InputBO;
import com.dcits.deposit.facade.bo.ST013OutputBO;

/**
 * ST013 检查客户限制 步骤实现
 *
 * 步骤描述：
 * 1.执行客户限制检查：根据{客户号}调用检查限制组件《检查客户限制》步骤《检查客户是否存在限制》，获取[客户限制信息]；
 * 2.检查客户限制是否存在：[客户限制信息]等于空时返回检查结果"通过"，否则将限制状态、限制编号、账户限制类型映射至输出字段返回。
 */
@Service
public class ST013Pbc implements IST013 {

	/** [客户限制信息]键：限制状态，与客户限制表（RB_CLIENT_RESTRAINTS）同名字段一致 */
	private static final String KEY_RESTRAINTS_STATUS = "restraintsStatus";
	/** [客户限制信息]键：限制编号 */
	private static final String KEY_RES_SEQ_NO = "resSeqNo";
	/** [客户限制信息]键：账户限制类型 */
	private static final String KEY_RESTRAINT_TYPE = "restraintType";
	/** 请求BO键：客户号 */
	private static final String KEY_CLIENT_NO = "clientNo";

	private final ExternalTaskClient externalTaskClient;

	public ST013Pbc(ExternalTaskClient externalTaskClient) {
		this.externalTaskClient = externalTaskClient;
	}

	@Override
	public ST013OutputBO execute(ST013InputBO input) {
		ST013OutputBO output = new ST013OutputBO();

		// 子步骤1 执行客户限制检查：按{客户号}调用检查限制组件《检查客户是否存在限制》，获取[客户限制信息]
		Map<String, Object> bo = new HashMap<>();
		bo.put(KEY_CLIENT_NO, input.getClientNo());
		Map<String, Object> restraintInfo = externalTaskClient.executeValidationST001(bo);

		// 子步骤2 检查客户限制是否存在：客户无限制时[客户限制信息]不包含限制三键，等于空即检查结果"通过"，输出字段均为空
		if (!restraintInfo.containsKey(KEY_RESTRAINTS_STATUS) && !restraintInfo.containsKey(KEY_RES_SEQ_NO)
				&& !restraintInfo.containsKey(KEY_RESTRAINT_TYPE)) {
			output.setSucceed(true);
			return output;
		}

		// 客户存在限制：将限制状态、限制编号、账户限制类型映射至输出字段，由调用方依据输出字段判断
		output.setRestraintsStatus(RestraintsStatus.byValue((String) restraintInfo.get(KEY_RESTRAINTS_STATUS)));
		output.setResSeqNo((String) restraintInfo.get(KEY_RES_SEQ_NO));
		output.setRestraintType(RestraintType.byValue((String) restraintInfo.get(KEY_RESTRAINT_TYPE)));
		output.setSucceed(true);
		return output;
	}
}
