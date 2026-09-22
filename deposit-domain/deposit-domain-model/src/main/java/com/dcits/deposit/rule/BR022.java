package com.dcits.deposit.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;

/**
 * BR022 检查交易类型是否为现金支取。
 *
 * 规则描述：如果{借贷标志}为"D借方"，且{现金交易标志}为"Y是"，且{冲正交易标志}为"N否"，
 * 则返回是，否则返回否。
 */
public class BR022 {

	private static final Logger LOGGER = LoggerFactory.getLogger(BR022.class);

	/** 执行结果：是 */
	private static final String RESULT_YES = "是";

	/** 执行结果：否 */
	private static final String RESULT_NO = "否";

	/**
	 * 检查交易类型是否为现金支取。
	 *
	 * @param crDrInd 借贷标志
	 * @param cashTranFlag 现金交易标志
	 * @param reversal 冲正交易标志
	 * @return executionResult 执行结果：满足条件返回"是"，否则返回"否"
	 */
	public static String execute(CrDrInd crDrInd, IndividualFlag cashTranFlag, IndividualFlag reversal) {
		boolean isCashWithdrawal = CrDrInd.D == crDrInd
				&& IndividualFlag.Y == cashTranFlag
				&& IndividualFlag.N == reversal;
		String executionResult = isCashWithdrawal ? RESULT_YES : RESULT_NO;
		LOGGER.info("BR022 检查交易类型是否为现金支取：crDrInd={}, cashTranFlag={}, reversal={}, executionResult={}",
				crDrInd, cashTranFlag, reversal, executionResult);
		return executionResult;
	}
}
