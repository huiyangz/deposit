package com.dcits.deposit.task.scenario;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.common.task.RespHeader;
import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;
import com.dcits.deposit.facade.bo.ST038InputBO;
import com.dcits.deposit.facade.bo.ST038OutputBO;
import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;
import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;
import com.dcits.deposit.facade.bo.ST041InputBO;
import com.dcits.deposit.facade.bo.ST041OutputBO;
import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;
import com.dcits.deposit.facade.bo.ST043InputBO;
import com.dcits.deposit.facade.bo.ST043OutputBO;
import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;
import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;
import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;
import com.dcits.deposit.step.IST037;
import com.dcits.deposit.step.IST038;
import com.dcits.deposit.step.IST039;
import com.dcits.deposit.step.IST040;
import com.dcits.deposit.step.IST041;
import com.dcits.deposit.step.IST042;
import com.dcits.deposit.step.IST043;
import com.dcits.deposit.step.IST044;
import com.dcits.deposit.step.IST045;
import com.dcits.deposit.step.IST046;
import com.dcits.deposit.task.dto.T4S1InputDTO;
import com.dcits.deposit.task.dto.T4S1OutputDTO;

/** T4S1 检查限额 交易接口场景 */
@Component
public class T4S1 {

	/** 步骤 ST037 获取限额场景编码 */
	private final IST037 ist037;

	/** 步骤 ST038 检查账户机构是否可匹配到限额场景配置 */
	private final IST038 ist038;

	/** 步骤 ST039 计算限额累计金额 */
	private final IST039 ist039;

	/** 步骤 ST040 检查限额 */
	private final IST040 ist040;

	/** 步骤 ST041 处理限额 */
	private final IST041 ist041;

	/** 步骤 ST042 获取累计限额 */
	private final IST042 ist042;

	/** 步骤 ST043 匹配限额场景 */
	private final IST043 ist043;

	/** 步骤 ST044 登记累计限额 */
	private final IST044 ist044;

	/** 步骤 ST045 检查限额场景配置是否有效 */
	private final IST045 ist045;

	/** 步骤 ST046 更新累计限额 */
	private final IST046 ist046;

	public T4S1(IST037 ist037, IST038 ist038, IST039 ist039, IST040 ist040, IST041 ist041,
			IST042 ist042, IST043 ist043, IST044 ist044, IST045 ist045, IST046 ist046) {
		this.ist037 = ist037;
		this.ist038 = ist038;
		this.ist039 = ist039;
		this.ist040 = ist040;
		this.ist041 = ist041;
		this.ist042 = ist042;
		this.ist043 = ist043;
		this.ist044 = ist044;
		this.ist045 = ist045;
		this.ist046 = ist046;
	}

	/**
	 * 按声明顺序（ST037→ST046）编排执行全部 10 步；任一步骤失败时短路返回并原样透传其 errorCode/errorMessage；全部成功后清理响应头旧错误并置成功。最终输出字段 限额检查结果 的取值来源未定义（TBD-2），暂不填充。
	 *
	 * <p>ST044（登记累计限额）与 ST046（更新累计限额）接口 Javadoc 要求调用方保证在事务上下文中调用，本方法声明 Spring
	 * {@code @Transactional} 提供跨步骤本地写事务边界。</p>
	 */
	@Transactional
	public T4S1OutputDTO execute(RespHeader header, T4S1InputDTO input) {
		T4S1OutputDTO output = new T4S1OutputDTO();

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:需求仅声明 10 个步骤的顺序，未声明是否依据中间步骤业务结果（如 ST037/ST038 未取得场景、ST040 超限、ST043 未匹配、ST045 不在生效窗口）中断、跳过或继续执行后续步骤（TBD-3） - 影响:当前实现按声明顺序执行全部 10 步，不依据业务结论中断或跳过 - 待确认:各步骤业务结论对后续步骤执行与否的影响
		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求及各步骤 Spec 均未声明业务失败与错误码；ST044 登记、ST046 更新对本地 RB_LIMIT_SUM_INFO 的写入在后续步骤失败时是否提交、回滚或部分完成未定义（TBD-6） - 影响:当前实现按步骤失败即短路并原样透传 errorCode/errorMessage，写入步骤的回滚与部分完成语义无法确定 - 待确认:失败传播方式、错误码定义及各写入步骤的回滚边界

		ST037InputBO st037Input = new ST037InputBO();
		st037Input.setBaseAcctNo(input.getBaseAcctNo());
		st037Input.setClientNo(input.getClientNo());
		st037Input.setLimitSceneNo(input.getLimitSceneNo());
		st037Input.setTranDate(input.getTranDate());
		ST037OutputBO st037Output = ist037.execute(st037Input);
		if (!st037Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st037Output.getErrorCode());
			header.setErrorMessage(st037Output.getErrorMessage());
			return output;
		}

		ST038InputBO st038Input = new ST038InputBO();
		st038Input.setBaseAcctNo(st037Output.getBaseAcctNo());
		ST038OutputBO st038Output = ist038.execute(st038Input);
		if (!st038Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st038Output.getErrorCode());
			header.setErrorMessage(st038Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST039 必填输入 limitSceneNo 存在 ST037:limitSceneNo、ST038:limitSceneNo 多前序候选，无明确优先级（TBD-5） - 影响:该步骤入参无法唯一确定，暂不赋值 - 待确认:ST039 限额场景编码的具体来源映射
		ST039InputBO st039Input = new ST039InputBO();
		st039Input.setTranAmt(input.getTranAmt());
		ST039OutputBO st039Output = ist039.execute(st039Input);
		if (!st039Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st039Output.getErrorCode());
			header.setErrorMessage(st039Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST040 必填输入 limitSceneNo 存在 ST037:limitSceneNo、ST038:limitSceneNo 多前序候选，无明确优先级（TBD-5） - 影响:该步骤入参无法唯一确定，暂不赋值 - 待确认:ST040 限额场景编码的具体来源映射
		ST040InputBO st040Input = new ST040InputBO();
		st040Input.setLimitSumAmt(st039Output.getLimitSumAmt());
		st040Input.setLimitSumNum(st039Output.get限额累计笔数());
		ST040OutputBO st040Output = ist040.execute(st040Input);
		if (!st040Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st040Output.getErrorCode());
			header.setErrorMessage(st040Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST041 必填输入 limitSceneNo 存在 ST037:limitSceneNo、ST038:limitSceneNo 多前序候选，无明确优先级（TBD-5） - 影响:该步骤入参无法唯一确定，暂不赋值 - 待确认:ST041 限额场景编码的具体来源映射
		ST041InputBO st041Input = new ST041InputBO();
		ST041OutputBO st041Output = ist041.execute(st041Input);
		if (!st041Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st041Output.getErrorCode());
			header.setErrorMessage(st041Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST042 必填输入 baseAcctNo（ST037/ST038 候选）、limitSceneNo（ST037/ST038 候选）存在多前序候选歧义（TBD-5） - 影响:这两个入参无法唯一确定，暂不赋值（clientNo 按 ST037 前序唯一匹配直传） - 待确认:ST042 账号与限额场景编码的具体来源映射
		ST042InputBO st042Input = new ST042InputBO();
		st042Input.setClientNo(st037Output.getClientNo());
		ST042OutputBO st042Output = ist042.execute(st042Input);
		if (!st042Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st042Output.getErrorCode());
			header.setErrorMessage(st042Output.getErrorMessage());
			return output;
		}

		ST043InputBO st043Input = new ST043InputBO();
		st043Input.setFactorName(input.getFactorName());
		ST043OutputBO st043Output = ist043.execute(st043Input);
		if (!st043Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st043Output.getErrorCode());
			header.setErrorMessage(st043Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST044 必填输入 限额检查结果（接口输入与 ST040:limitCheckResult 候选歧义）、baseAcctNo（ST037/ST038）、clientNo（ST037/ST042）、limitSceneNo（ST037/ST038/ST043）、limitSumAmt（ST039/ST040/ST042）、限额累计笔数（ST039/ST040/ST042）来源歧义；必填输入 runDate 无接口输入来源（TBD-4、TBD-5） - 影响:这些入参无法唯一确定，暂不赋值（tranAmt 按接口输入唯一候选直传） - 待确认:ST044 各入参的具体来源映射及 runDate 的接口层来源（系统日期表查询或以 tranDate 推导）
		ST044InputBO st044Input = new ST044InputBO();
		st044Input.setTranAmt(input.getTranAmt());
		ST044OutputBO st044Output = ist044.execute(st044Input);
		if (!st044Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st044Output.getErrorCode());
			header.setErrorMessage(st044Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST045 必填输入 limitSceneNo 存在 ST037:limitSceneNo、ST038:limitSceneNo、ST043:limitSceneNo 多前序候选，无明确优先级（TBD-5） - 影响:该步骤入参无法唯一确定，暂不赋值 - 待确认:ST045 限额场景编码的具体来源映射
		ST045InputBO st045Input = new ST045InputBO();
		st045Input.setTranDate(input.getTranDate());
		st045Input.setTranTimestamp(input.getTranTimestamp());
		ST045OutputBO st045Output = ist045.execute(st045Input);
		if (!st045Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st045Output.getErrorCode());
			header.setErrorMessage(st045Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST046 必填输入 限额检查结果（接口输入与 ST040:limitCheckResult 候选歧义）、baseAcctNo（ST037/ST038）、limitSceneNo（ST037/ST038/ST043）、clientNo（ST037/ST042）、limitSumAmt（ST039/ST040/ST042）、限额累计笔数（ST039/ST040/ST042）来源歧义（TBD-5） - 影响:ST046 入参无法唯一确定，暂不赋值 - 待确认:ST046 各入参的具体来源映射
		ST046InputBO st046Input = new ST046InputBO();
		ST046OutputBO st046Output = ist046.execute(st046Input);
		if (!st046Output.isSucceed()) {
			header.setSucceed(false);
			header.setErrorCode(st046Output.getErrorCode());
			header.setErrorMessage(st046Output.getErrorMessage());
			return output;
		}

		// FIXME 业务项:T4S1/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:最终输出 限额检查结果 的取值来源（由哪个步骤产生、承接输入直传还是多结论汇总）与「非必填」返回语义未定义（TBD-2、TBD-8） - 影响:场景暂不填充该输出字段 - 待确认:输出字段的取值来源、编码与「非必填」的具体含义

		header.setSucceed(true);
		header.setErrorCode(null);
		header.setErrorMessage(null);
		return output;
	}
}
