package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.deposit.enums.IntClass;
import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctIntDetailBcc;
import com.dcits.deposit.facade.eo.RbBusAcctIntDetailEO;

/**
 * ST039 登记账户计息信息 步骤实现
 *
 * 步骤描述：
 * 1.登记利息明细：登记【利息明细信息】，其中，账户内部键值由系统根据{账号}生成，
 * 利息分类等于"INT-正常利息"，利率类型等于{利率类型}，执行利率等于[执行利率]。
 *
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。
 *
 * 工程约定处理（SPEC 未定义取值来源的技术字段，见输出适用例说明）：
 * 账户内部键值的"根据账号生成"规则未定义（SPEC 已接受的需求处理结论第 1 条），
 * 本步骤以必填输入 internalKey 为唯一确定来源；EO 中 NOT NULL 技术字段 agg、
 * createTimestamp、lastUpdTimestamp（DDL 无默认值，createSelective 契约要求必填）
 * 由本步骤按下述约定赋值：新登记明细的积数自零起算，创建与最后修改时间戳取登记
 * 时刻的 14 位字符串时间戳（yyyyMMddHHmmss）。
 */
@Service
public class ST039Pbc implements IST039 {

	/** 14 位字符串时间戳格式 */
	private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	private final IRbBusAcctIntDetailBcc rbBusAcctIntDetailBcc;

	public ST039Pbc(IRbBusAcctIntDetailBcc rbBusAcctIntDetailBcc) {
		this.rbBusAcctIntDetailBcc = rbBusAcctIntDetailBcc;
	}

	@Override
	@Transactional
	public ST039OutputBO execute(ST039InputBO input) {
		ST039OutputBO output = new ST039OutputBO();

		// 子步骤1 登记利息明细：将利息分类、账户内部键值及输入的利率与计息字段写入
		// 【利息明细信息】（RB_BUS_ACCT_INT_DETAIL）
		RbBusAcctIntDetailEO intDetail = new RbBusAcctIntDetailEO();
		// 利息分类等于"INT-正常利息"
		intDetail.setIntClass(IntClass.INT);
		// 账户内部键值：生成规则未定义（已接受结论第 1 条），取必填输入值
		intDetail.setInternalKey(input.getInternalKey());
		// 利率类型等于{利率类型}
		intDetail.setIntType(input.getIntType());
		// 执行利率等于[执行利率]
		intDetail.setRealRate(input.getRealRate());
		intDetail.setTaxRate(input.getTaxRate());
		intDetail.setIntCapFlag(input.getIntCapFlag());
		intDetail.setCalcBeginDate(input.getCalcBeginDate());
		intDetail.setAcctPercentRate(input.getAcctPercentRate());
		intDetail.setAcctSpreadRate(input.getAcctSpreadRate());
		intDetail.setTaxTypeNo(input.getTaxTypeNo());
		// NOT NULL 技术字段（工程约定）：新登记明细积数自零起算；创建与最后修改时间戳取登记时刻
		intDetail.setAgg(BigDecimal.ZERO);
		String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
		intDetail.setCreateTimestamp(timestamp);
		intDetail.setLastUpdTimestamp(timestamp);
		rbBusAcctIntDetailBcc.createSelective(intDetail);

		// 登记完成，回显已登记进 RB_BUS_ACCT_INT_DETAIL 的业务字段；
		// 主表（RB_BUS_ACCT）来源输出因读取操作未定义（已接受结论第 2 条）不赋值，保持 null
		output.setInternalKey(intDetail.getInternalKey());
		output.setIntType(intDetail.getIntType());
		output.setTaxRate(intDetail.getTaxRate());
		output.setIntCapFlag(intDetail.getIntCapFlag());
		output.setCalcBeginDate(intDetail.getCalcBeginDate());
		output.setAcctPercentRate(intDetail.getAcctPercentRate());
		output.setAcctSpreadRate(intDetail.getAcctSpreadRate());
		output.setRealRate(intDetail.getRealRate());
		output.setSucceed(true);
		return output;
	}
}
