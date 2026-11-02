package com.dcits.deposit.task.scenario;

import org.springframework.stereotype.Component;

import com.dcits.common.task.RespHeader;
import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;
import com.dcits.deposit.step.IST047;
import com.dcits.deposit.task.dto.T5S1InputDTO;
import com.dcits.deposit.task.dto.T5S1OutputDTO;

/** T5S1 检查客户限制 交易接口场景 */
@Component
public class T5S1 {

	/** 组件内步骤 ST047 检查客户是否存在限制 */
	private final IST047 ist047;

	public T5S1(IST047 ist047) {
		this.ist047 = ist047;
	}

	/** 以必填客户号调用 ST047 检查客户是否存在限制，将步骤返回的客户限制信息映射为交易输出；步骤失败时短路返回并透传错误 */
	public T5S1OutputDTO execute(RespHeader header, T5S1InputDTO input) {
		T5S1OutputDTO output = new T5S1OutputDTO();

		ST047InputBO st047Input = new ST047InputBO();
		st047Input.setClientNo(input.getClientNo());

		ST047OutputBO st047Output = ist047.execute(st047Input);
		if (!st047Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st047Output.getErrorCode());
			header.setErrorMessage(st047Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T5S1/检查客户限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST047 无命中返回空业务字段（枚举为 null）时交易输出字段是否为空、枚举 null 在代码值映射下的处理及无生效限制时的成功/失败语义未定义 - 影响:无生效限制时交易输出 resSeqNo、restraintType、restraintsStatus 的取值与交易成功/失败结果未确定 - 待确认:ST047 待确认事项 TBD-1/TBD-2 澄清后补充交易输出取值与无生效限制时的成功/失败语义
		output.setResSeqNo(st047Output.getResSeqNo());
		output.setRestraintType(st047Output.getRestraintType() == null ? null : st047Output.getRestraintType().getValue());
		output.setRestraintsStatus(st047Output.getRestraintsStatus() == null ? null : st047Output.getRestraintsStatus().getValue());

		header.setSucceed(true);
		header.setErrorCode(null);
		header.setErrorMessage(null);
		return output;
	}
}
