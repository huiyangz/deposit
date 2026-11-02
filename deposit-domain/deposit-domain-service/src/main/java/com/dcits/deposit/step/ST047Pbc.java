package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;
import com.dcits.deposit.facade.components.IRbClientRestraintsBcc;
import com.dcits.deposit.facade.eo.RbClientRestraintsEO;

/** ST047 检查客户是否存在限制 步骤实现 */
@Service
public class ST047Pbc implements IST047 {

	@Autowired
	private IRbClientRestraintsBcc rbClientRestraintsBcc;

	@Override
	public ST047OutputBO execute(ST047InputBO input) {
		ST047OutputBO output = new ST047OutputBO();

		// 子步骤1（获取客户限制）：依据上送客户号与限制状态 A 构造查询 EO，对客户限制表执行只读查询
		RbClientRestraintsEO queryEo = new RbClientRestraintsEO();
		queryEo.setClientNo(input.getClientNo());
		queryEo.setRestraintsStatus(RestraintsStatus.A);
		// FIXME 业务项:ST047/检查客户是否存在限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:子步骤1（获取客户限制）必填输入 clientNo 为空或无效值时的校验及不通过语义未定义，正式 Spec 待确认事项 TBD-3 待确认是否要求前置校验；BCC findByEo 对 EO 空属性不生成等值条件，clientNo 缺失时不会按客户号过滤 - 影响:clientNo 为空时查询可能返回全部限制状态=A 的客户限制记录，该场景行为未确认 - 待确认:是否要求前置校验及校验不通过时的语义
		List<RbClientRestraintsEO> restraints = rbClientRestraintsBcc.findByEo(queryEo);

		// FIXME 业务项:ST047/检查客户是否存在限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:子步骤1（获取客户限制）查询条件仅为 clientNo+限制状态=A，同一客户可能存在多条生效限制记录，正式 Spec 待确认事项 TBD-1 未定义命中多条时返回单条还是全部及单条选取/排序口径 - 影响:当前实现按单条结果取值从结果集取第一条，多条命中时的返回与选取行为未经业务确认 - 待确认:命中多条时返回列表还是按规则取单条，以及对应的选取与排序口径
		// FIXME 业务项:ST047/检查客户是否存在限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:子步骤1（获取客户限制）查询无限制状态=A 记录时正式 Spec 待确认事项 TBD-2 未定义成功/失败语义及返回内容 - 影响:当前实现按需求未声明业务失败处理为空结果正常结束（succeed=true、输出业务字段为 null），该行为未经业务确认 - 待确认:无生效限制记录时本步骤的成功/失败语义及返回内容
		if (!restraints.isEmpty()) {
			// 子步骤2（返回客户限制信息）：将取回的客户限制信息赋值到业务输出
			RbClientRestraintsEO record = restraints.get(0);
			output.setResSeqNo(record.getResSeqNo());
			output.setRestraintType(record.getRestraintType());
			output.setRestraintsStatus(record.getRestraintsStatus());
		}

		// 本步骤以成功状态结束，成功时错误码与错误信息保持 null
		output.setSucceed(true);
		return output;
	}
}
