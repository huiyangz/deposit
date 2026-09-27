package com.dcits.deposit.step;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.NatureClass;
import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;
import com.dcits.deposit.facade.components.IRbAcctNatureDefBcc;
import com.dcits.deposit.facade.eo.RbAcctNatureDefEO;

/**
 * ST050 设置账户年检标志 步骤实现
 *
 * 步骤描述：
 * 1.设置开户年：赋值[开户年]为{账户开户日期}的前四位；
 * 2.获取系统日期：赋值[系统日期]为{核心运行日期}；
 * 3.设置系统年：赋值[系统年]为[系统日期]的前四位；
 * 4.获取产品的账户类型：根据{产品编号}、{参数KEY值}访问产品管理《查询产品信息》获取[账户类型]；
 * 5.获取账户属性分类：根据{账户属性}查询【账户属性定义(RB_ACCT_NATURE_DEF)】，
 * 无记录时[账户属性分类]为空；
 * 6.检查账户是否是活期保证金：[账户类型]等于"C"且[账户属性分类]等于"保证金账户"时
 * [活期保证金账户标志]为"是"，否则为"否"；
 * 7.设置年检标志：[开户年]等于[系统年]或[活期保证金账户标志]等于"是"时[年检标志]为"否"，
 * 否则为"是"。
 */
@Service
public class ST050Pbc implements IST050 {

	/** 活期账户类型编码 */
	private static final String ACCT_TYPE_DEMAND = "C";
	/** 保证金账户属性分类 */
	private static final NatureClass NATURE_CLASS_MARGIN = NatureClass.VALUE_3;
	/** 标志取值：是 */
	private static final String FLAG_YES = "是";
	/** 标志取值：否 */
	private static final String FLAG_NO = "否";

	private final ExternalTaskClient externalTaskClient;
	private final IRbAcctNatureDefBcc rbAcctNatureDefBcc;

	public ST050Pbc(ExternalTaskClient externalTaskClient, IRbAcctNatureDefBcc rbAcctNatureDefBcc) {
		this.externalTaskClient = externalTaskClient;
		this.rbAcctNatureDefBcc = rbAcctNatureDefBcc;
	}

	@Override
	public ST050OutputBO execute(ST050InputBO input) {
		// 子步骤1 设置开户年：赋值[开户年]为{账户开户日期}的前四位
		String openYear = getYear(input.getAcctOpenDate());

		// 子步骤2 获取系统日期：赋值[系统日期]为{核心运行日期}
		Date systemDate = input.getRunDate();

		// 子步骤3 设置系统年：赋值[系统年]为[系统日期]的前四位
		String systemYear = getYear(systemDate);

		// 子步骤4 获取产品的账户类型：根据{产品编号}、{参数KEY值}访问产品管理《查询产品信息》
		String acctType = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());

		// 子步骤5 获取账户属性分类：按账户属性主键查询【账户属性定义(RB_ACCT_NATURE_DEF)】，无记录时[账户属性分类]为空
		RbAcctNatureDefEO acctNatureDef = rbAcctNatureDefBcc.findByAcctNatureNo(input.getAcctNatureNo());
		NatureClass natureClass = acctNatureDef == null ? null : acctNatureDef.getNatureClass();

		// 子步骤6 检查账户是否是活期保证金：[账户类型]等于"C"且[账户属性分类]等于"保证金账户"时标志为"是"，否则为"否"
		String demandMarginFlag = FLAG_NO;
		if (ACCT_TYPE_DEMAND.equals(acctType) && NATURE_CLASS_MARGIN == natureClass) {
			demandMarginFlag = FLAG_YES;
		}

		// 子步骤7 设置年检标志：[开户年]等于[系统年]或[活期保证金账户标志]等于"是"时为"否"，否则为"是"
		ST050OutputBO output = new ST050OutputBO();
		if (openYear.equals(systemYear) || FLAG_YES.equals(demandMarginFlag)) {
			output.setAnnualFlag(FLAG_NO);
		} else {
			output.setAnnualFlag(FLAG_YES);
		}
		output.setSucceed(true);
		return output;
	}

	/**
	 * 取日期前四位年份（子步骤1/3：开户年、系统年）
	 */
	private String getYear(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return String.format("%04d", calendar.get(Calendar.YEAR));
	}
}
