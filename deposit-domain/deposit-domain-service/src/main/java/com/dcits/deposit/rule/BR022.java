package com.dcits.deposit.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;

/**
 * BR022 检查交易类型是否为现金支取
 *
 * 规则类型：断言类
 * 规则描述：如果{借贷标志}为"D借方"，且{现金交易标志}为"Y是"，且{冲正交易标志}为"N否"，则返回是，否则返回否。
 * 输入：crDrInd 借贷标志（必填）；cashTranFlag 现金交易标志（必填）；reversal 冲正交易标志（必填）。
 * 输出：executionResult 执行结果，取值为"是"或"否"。
 */
public class BR022 {

    private static final Logger LOGGER = LoggerFactory.getLogger(BR022.class);

    /**
     * 检查交易类型是否为现金支取
     *
     * @param crDrInd 借贷标志
     * @param cashTranFlag 现金交易标志
     * @param reversal 冲正交易标志
     * @return executionResult 执行结果："是"-借贷标志为借方且现金交易标志为是且冲正交易标志为否；"否"-其他情况
     */
    public static String execute(CrDrInd crDrInd, IndividualFlag cashTranFlag, IndividualFlag reversal) {
        boolean cashWithdrawal = crDrInd == CrDrInd.D
                && cashTranFlag == IndividualFlag.Y
                && reversal == IndividualFlag.N;
        String executionResult = cashWithdrawal ? "是" : "否";
        LOGGER.info("BR022 检查交易类型是否为现金支取: crDrInd={}, cashTranFlag={}, reversal={}, executionResult={}",
                crDrInd, cashTranFlag, reversal, executionResult);
        return executionResult;
    }
}
