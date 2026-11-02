package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.common.step.GotoStepCondition;
import com.dcits.deposit.enums.IsOverMonthSeasonOd;
import com.dcits.deposit.facade.bo.ST024InputBO;
import com.dcits.deposit.facade.bo.ST024OutputBO;
import com.dcits.deposit.facade.components.IRbBusAgreementOverdraftBcc;
import com.dcits.deposit.facade.components.IRbOdWhiteLimitInfoBcc;
import com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO;
import com.dcits.deposit.facade.eo.RbOdWhiteLimitInfoEO;

/**
 * ST024 检查法人透支金额。
 *
 * <p>按需求「步骤描述」1–7 顺序执行：根据{账号}查询《法透协议信息》（对公透支签约表
 * RB_BUS_AGREEMENT_OVERDRAFT）获取靠档跨月季标识并赋值靠档计息跨月跨季标志；根据该标志
 * 查询【法人透支白名单参数表】（RB_OD_WHITE_LIMIT_INFO）获取并检查单笔透支检查金额
 * （交易金额大于单笔透支检查金额返回错误码 ER0061）；根据{账号}调用业务组件《贷款》的业务
 * 功能《计算账号当日放款金额合计》获取当日累计透支额度；根据该标志查询白名单表获取同一支付
 * 对象当日累计透支金额并检查（当日累计透支额度加交易金额大于同一支付对象当日累计透支金额
 * 返回错误码 ER0053）；全部检查通过后跳转至步骤《检查分行法人透支额度》。</p>
 */
@Service
@GotoStepCondition(candidateSteps = {"检查分行法人透支额度"})
public class ST024Pbc implements IST024 {

	/** 靠档计息跨月跨季标志-是（需求业务表述，物理编码待确认 TBD-2） */
	private static final String IS_CROSS_FLAG_YES = "Y-是";

	/** 靠档计息跨月跨季标志-否（需求业务表述，物理编码待确认 TBD-2） */
	private static final String IS_CROSS_FLAG_NO = "否";

	/** 错误码：交易金额超出单笔透支检查金额（errorcodes.properties 已确认） */
	private static final String ERROR_CODE_ER0061 = "ER0061";

	/** 错误码：当日累计透支金额已超过同一支付对象单日累计透支金额（errorcodes.properties 已确认） */
	private static final String ERROR_CODE_ER0053 = "ER0053";

	/** 当日累计透支额度返回键（贷款组件《计算账号当日放款金额合计》） */
	private static final String KEY_DAILY_OVERDRAFT_AMT = "dailyOverdraftAmt";

	@Autowired
	private IRbBusAgreementOverdraftBcc rbBusAgreementOverdraftBcc;

	@Autowired
	private IRbOdWhiteLimitInfoBcc rbOdWhiteLimitInfoBcc;

	@Autowired
	private ExternalTaskClient externalTaskClient;

	@Override
	public ST024OutputBO execute(ST024InputBO input) {
		ST024OutputBO output = new ST024OutputBO();

		                                                                                                                                                                                              

		// 步骤 1：根据{账号}查询《法透协议信息》（对公透支签约表）获取靠档跨月季标识
		                                                   
		RbBusAgreementOverdraftEO agreementQuery = new RbBusAgreementOverdraftEO();
		agreementQuery.setBaseAcctNo(input.getBaseAcctNo());
		List<RbBusAgreementOverdraftEO> agreementList = rbBusAgreementOverdraftBcc.findByEo(agreementQuery);
		                                                                                                                                                                                                             
		                                                   
		if (agreementList == null || agreementList.isEmpty()) {
			output.setSucceed(false);
			return output;
		}
		// 同一账号多条协议按本项目约定取结果集第一条
		RbBusAgreementOverdraftEO agreement = agreementList.get(0);

		// 步骤 2：按靠档跨月季标识赋值靠档计息跨月跨季标志
		IsOverMonthSeasonOd isOverMonthSeasonOd = agreement.getIsOverMonthSeasonOd();
		                                                                                                                                                                                                                                                                         
		                                                   
		String isCrossFlag;
		if (isOverMonthSeasonOd == IsOverMonthSeasonOd.M || isOverMonthSeasonOd == IsOverMonthSeasonOd.Q) {
			isCrossFlag = IS_CROSS_FLAG_YES;
		} else {
			isCrossFlag = IS_CROSS_FLAG_NO;
		}
		                                                                                                                                                                                                                                            
		                                                   
		output.setIsCrossFlag(isCrossFlag);

		// 步骤 3：根据[靠档计息跨月跨季标志]查询【法人透支白名单参数表】获取单笔透支检查金额
		RbOdWhiteLimitInfoEO whiteLimitQuery = new RbOdWhiteLimitInfoEO();
		whiteLimitQuery.setIsCrossFlag(isCrossFlag);
		                                                                                                                                                                                                                                  
		                                                                                                                                                                                                 
		                                                   
		                                                   
		List<RbOdWhiteLimitInfoEO> whiteLimitList = rbOdWhiteLimitInfoBcc.findByEo(whiteLimitQuery);
		if (whiteLimitList == null || whiteLimitList.isEmpty()) {
			output.setSucceed(false);
			return output;
		}
		// 同一靠档计息跨月跨季标志多条记录按本项目约定取结果集第一条
		RbOdWhiteLimitInfoEO whiteLimit = whiteLimitList.get(0);
		BigDecimal odPtAmt = whiteLimit.getOdPtAmt();
		output.setOdPtAmt(odPtAmt);

		// 步骤 4：检查单笔透支检查金额，交易金额大于单笔透支检查金额返回错误码 ER0061
		if (input.getTranAmt().compareTo(odPtAmt) > 0) {
			output.setSucceed(false);
			output.setErrorCode(ERROR_CODE_ER0061);
			                                                   
			output.setErrorMessage(ERROR_CODE_ER0061 + "::" + "交易金额超出单笔透支检查金额");
			                                                                                                                                                                             
			return output;
		}

		// 步骤 5：根据{账号}调用业务组件《贷款》的业务功能《计算账号当日放款金额合计》获取当日累计透支额度
		Map<String, Object> loanAmtResult = externalTaskClient.calcAcctDailyLoanAmt(input.getBaseAcctNo());
		BigDecimal dailyOverdraftAmt = toBigDecimal(loanAmtResult.get(KEY_DAILY_OVERDRAFT_AMT));

		// 步骤 6：根据[靠档计息跨月跨季标志]查询【法人透支白名单参数表】获取同一支付对象当日累计透支金额
		List<RbOdWhiteLimitInfoEO> whiteLimitList6 = rbOdWhiteLimitInfoBcc.findByEo(whiteLimitQuery);
		if (whiteLimitList6 == null || whiteLimitList6.isEmpty()) {
			// 同步骤 3 白名单查询无记录行为未定义（Spec TBD-3，见步骤 3 FIXME）
			output.setSucceed(false);
			return output;
		}
		RbOdWhiteLimitInfoEO whiteLimit6 = whiteLimitList6.get(0);
		BigDecimal sameObjectPdOdCumulative = whiteLimit6.getSameObjectPdOdCumulative();
		output.setSameObjectPdOdCumulative(sameObjectPdOdCumulative);

		// 步骤 7：检查同一支付对象当日累计透支金额，当日累计透支额度加交易金额超限返回错误码 ER0053
		if (dailyOverdraftAmt.add(input.getTranAmt()).compareTo(sameObjectPdOdCumulative) > 0) {
			output.setSucceed(false);
			output.setErrorCode(ERROR_CODE_ER0053);
			                                                   
			output.setErrorMessage(ERROR_CODE_ER0053 + "::" + "当日累计透支金额已超过同一支付对象单日累计透支金额");
			                                                                                                                                                                             
			return output;
		}

		// 全部检查通过，正常完成并跳转至步骤《检查分行法人透支额度》
		output.setSucceed(true);
		return output;
	}

	/**
	 * 将贷款组件返回的当日累计透支额度解析为 {@link BigDecimal}。
	 *
	 * <p>客户端契约为 {@code Map<String,Object>}，返回键 dailyOverdraftAmt 的值类型未固定：
	 * 工程 MockExternalTask 返回字符串（如 "0.00"），调用方也可返回 BigDecimal；按实际返回
	 * 类型适配解析。非上述类型或缺失时返回 null，后续金额运算按技术异常交给现有上层处理。</p>
	 *
	 * @param value 返回键 dailyOverdraftAmt 的值
	 * @return 解析后的金额；无法解析时返回 null
	 */
	private BigDecimal toBigDecimal(Object value) {
		if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		}
		if (value instanceof Number) {
			return new BigDecimal(value.toString());
		}
		if (value instanceof String) {
			return new BigDecimal((String) value);
		}
		return null;
	}
}
