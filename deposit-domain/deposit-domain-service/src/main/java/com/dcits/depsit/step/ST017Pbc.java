package com.dcits.depsit.step;

import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST017InputBO;
import com.dcits.depsit.facade.bo.ST017OutputBO;

/**
 * ST017 检查币种一致性 步骤实现。
 *
 * <p>以交易币种 {@code tranCcy} 与账户币种 {@code acctCcy} 两个输入，按币种代码
 * （{@code Ccy.getValue()} 与 {@code AcctCcy.getValue()}）比较两者是否一致。两侧为不同的
 * Java 枚举类型，故不以枚举对象同一性判等，只按币种代码取值比较。
 *
 * <p>两个条件互斥且完备：一致时返回检查结果“通过”（{@code succeed = true}，错误码与错误信息为空），
 * 不一致时返回错误码 {@code "ER0051"}（{@code succeed = false}）。本步骤为无状态纯判断，
 * 不读取账户数据、不发起外部调用、不产生任何业务副作用。
 *
 * <p>源需求未规定两个输入为空（null）或缺失时的处理，本实现不为其制造分支。
 */
@Service
public class ST017Pbc implements IST017 {

    /** 币种不一致错误码，取自错误码注册表 errorcodes.properties 第 51 行 */
    private static final String ERROR_CODE_CCY_MISMATCH = "ER0051";

    /** 币种不一致错误信息，业务说明取自错误码注册表登记文本 */
    private static final String ERROR_MESSAGE_CCY_MISMATCH = "ER0051::交易币种与账户币种不一致";

    @Override
    public ST017OutputBO execute(ST017InputBO input) {
        ST017OutputBO output = new ST017OutputBO();

        // REQ-002：按币种代码比较两个输入，跨 Ccy / AcctCcy 两个不同枚举类型成立
        if (input.getTranCcy().getValue().equals(input.getAcctCcy().getValue())) {
            // REQ-003：币种一致，返回检查结果“通过”，错误字段保持为空
            output.setSucceed(true);
            return output;
        }

        // REQ-004：币种不一致，以业务失败状态返回错误码 ER0051
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_CCY_MISMATCH);
        output.setErrorMessage(ERROR_MESSAGE_CCY_MISMATCH);
        return output;
    }
}
