package com.dcits.depsit.step;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST032InputBO;
import com.dcits.depsit.facade.bo.ST032OutputBO;

/**
 * ST032 检查交易金额。
 *
 * <p>步骤描述第 1 条：检查交易金额，若{交易金额}小于等于 0，则返回错误码 {@code ER0050}，
 * 否则返回检查结果为「通过」。</p>
 *
 * <p>判定以入参 tranAmt 的数值大小与 0 比较，采用 {@link BigDecimal#compareTo(BigDecimal)}
 * 的数值比较语义，标度与尾随零不改变判定；本步骤不做任何算术运算，不修改入参。</p>
 */
@Service
public class ST032Pbc implements IST032 {

    /** REQ-001：交易金额小于等于 0 时返回的错误码 */
    private static final String ERROR_CODE_TRAN_AMT = "ER0050";

    /** REQ-001：错误码 ER0050 的业务说明，取自错误码清单 */
    private static final String ERROR_MESSAGE_TRAN_AMT = "ER0050::交易金额不能小于等于0";

    @Override
    public ST032OutputBO execute(ST032InputBO input) {
        ST032OutputBO output = new ST032OutputBO();

        // REQ-001：tranAmt 的数值小于等于 0 时返回错误码 ER0050，不返回检查结果「通过」
        if (input.getTranAmt().compareTo(BigDecimal.ZERO) <= 0) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_TRAN_AMT);
            output.setErrorMessage(ERROR_MESSAGE_TRAN_AMT);
            return output;
        }

        // REQ-002：tranAmt 的数值大于 0 时返回检查结果「通过」，不返回错误码 ER0050
        output.setSucceed(true);
        return output;
    }
}
