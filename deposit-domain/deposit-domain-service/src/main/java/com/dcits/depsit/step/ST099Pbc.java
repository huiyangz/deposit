package com.dcits.depsit.step;

import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.SettleAcctClass;
import com.dcits.depsit.facade.bo.ST099InputBO;
import com.dcits.depsit.facade.bo.ST099OutputBO;

/**
 * ST099 检查利息资本化标志。
 *
 * <p>依入参的利息资本化标志与结算账户类型作两步判定：子步骤 1 判定利息资本化标志是否等于
 * 「N-否」（码值 "N"），不等于则提前返回检查结果为「通过」；等于则继续子步骤 2，判定结算账户
 * 类型是否为「INT-利息入账账户」（{@code SettleAcctClass.INT}，码值 "INT"），是则返回「通过」，
 * 否则返回错误码 {@code ER0034}。</p>
 *
 * <p>本步骤无依赖调用、无数据查询与写入，不产生业务副作用。</p>
 */
@Service
public class ST099Pbc implements IST099 {

    /** 利息资本化标志取值：否（源需求「N-否」记法的码值）。 */
    private static final String INT_CAP_FLAG_NO = "N";

    /** 子步骤 2 未命中「INT-利息入账账户」时的错误码。 */
    private static final String ERROR_CODE_ER0034 = "ER0034";

    /** 子步骤 2 未命中「INT-利息入账账户」时的错误信息（错误码::业务说明）。 */
    private static final String ERROR_MESSAGE_ER0034 = "ER0034::非利息资本化账户必须上送利息入账账户";

    @Override
    public ST099OutputBO execute(ST099InputBO input) {
        ST099OutputBO output = new ST099OutputBO();

        // 子步骤 1（逻辑判断类）：利息资本化标志是否等于「N-否」。
        // 不等于时返回检查结果为「通过」，本步骤在子步骤 1 即结束，不执行子步骤 2。
        if (!INT_CAP_FLAG_NO.equals(input.getIntCapFlag())) {
            output.setSucceed(true);
            return output;
        }

        // 子步骤 2（逻辑判断类）：结算账户类型是否为「INT-利息入账账户」（码值 "INT"）。
        // 命中时返回检查结果为「通过」。
        if (SettleAcctClass.INT.equals(input.getSettleAcctClass())) {
            output.setSucceed(true);
            return output;
        }

        // 子步骤 2「若」分支：不为「INT-利息入账账户」，返回错误码 ER0034。
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_ER0034);
        output.setErrorMessage(ERROR_MESSAGE_ER0034);
        return output;
    }
}
