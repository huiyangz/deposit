package com.dcits.depsit.step;

import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.RbBusAcctPurpose;
import com.dcits.depsit.facade.bo.ST098InputBO;
import com.dcits.depsit.facade.bo.ST098OutputBO;

/**
 * ST098 检查账户用途 步骤实现。
 *
 * <p>整体意图：以四个输入（{@code rbBusAcctPurpose}、{@code acctCcy}、{@code apprLetterNo}、
 * {@code acctNatureNo}）按「子步骤 1 → 子步骤 2 → 子步骤 3 分派 → 子步骤 4／5／6 之一」的次序
 * 执行检查，结果只能是检查结果为「通过」（{@code succeed = true} 且错误字段为空）或
 * {@code "ER0012"}～{@code "ER0016"} 五个错误码之一，命中即短路。</p>
 *
 * <ul>
 *   <li>子步骤 1（逻辑判断类）：{账户币种} 为人民币且 {账户用途} 为资本项下时，{核准件编号} 为空
 *       返回 {@code ER0012} 并以该结果结束。</li>
 *   <li>子步骤 2（逻辑判断类）：同一条件成立时，{账户属性} 为空返回 {@code ER0013} 并结束。</li>
 *   <li>子步骤 3（逻辑判断类，分派）：按 {账户属性} 四路分派——基本存款账户／一般户 → 子步骤 4、
 *       验资户 → 子步骤 5、专用存款账户 → 子步骤 6、其余已定义成员或为空 → 直接返回「通过」。</li>
 *   <li>子步骤 4（逻辑判断类）：{账户用途} 不为空且不为无特殊用途时返回 {@code ER0014}，否则「通过」。</li>
 *   <li>子步骤 5（逻辑判断类）：{账户用途} 不属于｛注册验资、增资验资、无特殊用途｝时返回 {@code ER0015}，
 *       否则「通过」。</li>
 *   <li>子步骤 6（逻辑判断类）：{账户用途} 不属于｛预算单位专用、非预算单位专用｝时返回 {@code ER0016}，
 *       否则「通过」。</li>
 * </ul>
 *
 * <p>本步骤为无状态纯判断的只读检查，不查询任何实体、不发起外部调用、不产生副作用，故不加事务；
 * 判定只依据上述四个输入。源需求未定义技术异常路径。</p>
 */
@Service
public class ST098Pbc implements IST098 {

    /** 错误码：资本项下人民币账户的核准件编号为空（子步骤 1），登记文本见 errorcodes.properties 的 {@code ER0012} */
    private static final String ERROR_CODE_APPR_LETTER_NO = "ER0012";
    private static final String ERROR_MESSAGE_APPR_LETTER_NO = "ER0012::资本项下的人民币账户必须上送核准件编号";

    /** 错误码：资本项下人民币账户的账户属性为空（子步骤 2），登记文本见 errorcodes.properties 的 {@code ER0013} */
    private static final String ERROR_CODE_ACCT_NATURE_NO = "ER0013";
    private static final String ERROR_MESSAGE_ACCT_NATURE_NO = "ER0013::资本项下的人民币账户必须上送账户属性";

    /** 错误码：基本存款账户／一般户的账户用途不为空且不为「无特殊用途」（子步骤 4），登记文本见 {@code ER0014} */
    private static final String ERROR_CODE_BASIC_OR_GENERAL = "ER0014";
    private static final String ERROR_MESSAGE_BASIC_OR_GENERAL = "ER0014::基本户和一般的账户用途可以为空或者“无特殊用途”";

    /** 错误码：验资户的账户用途不属于允许集合（子步骤 5），登记文本见 errorcodes.properties 的 {@code ER0015} */
    private static final String ERROR_CODE_VERIFY = "ER0015";
    private static final String ERROR_MESSAGE_VERIFY = "ER0015::验资户的账户用途可为“注册验资”或“增资验资”或“无特殊用途”";

    /** 错误码：专用存款账户的账户用途不属于允许集合（子步骤 6），登记文本见 errorcodes.properties 的 {@code ER0016} */
    private static final String ERROR_CODE_SPECIAL = "ER0016";
    private static final String ERROR_MESSAGE_SPECIAL = "ER0016::专用户的账户用途可为“预算类单位专用存款户”或“非预算类单位专用存款户”";

    @Override
    public ST098OutputBO execute(ST098InputBO input) {
        ST098OutputBO output = new ST098OutputBO();

        // 子步骤 1、2 的公共前置条件：{币种}为「人民币」且{账户用途}为「资本项下」。
        // 「人民币」唯一对应 AcctCcy.CNY（码值 "CNY"），「资本项下」唯一对应 RbBusAcctPurpose.VALUE_501
        // （码值 "501"）；两个枚举均按枚举成员比较，不按字符串编码判定。
        boolean capitalCnyAccount = AcctCcy.CNY.equals(input.getAcctCcy())
                && RbBusAcctPurpose.VALUE_501.equals(input.getRbBusAcctPurpose());

        // 子步骤 1：检查资本向下人民币账户的核准件编号。
        // 条件成立时{核准件编号}为空即命中，返回 ER0012 并以该结果结束，不再执行子步骤 2 及其后的判定。
        // 「为空」不区分 null 与空字符串（源需求未区分二者），两种形态均按「无值」处理。
        if (capitalCnyAccount && isEmpty(input.getApprLetterNo())) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_APPR_LETTER_NO);
            output.setErrorMessage(ERROR_MESSAGE_APPR_LETTER_NO);
            return output;
        }

        // 子步骤 2：检查资本向下人民币账户的账户属性。
        // 同一条件成立时{账户属性}为空即命中，返回 ER0013 并结束；非空则继续执行子步骤 3。
        if (capitalCnyAccount && input.getAcctNatureNo() == null) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NATURE_NO);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_NATURE_NO);
            return output;
        }

        // 子步骤 3：检查账户属性并分派。分派只依据{账户属性}取值，四路互斥且穷尽；
        // 三处跳转目标均为本稿自身的子步骤，不调用其它任务编号的步骤。
        AcctNatureNo acctNatureNo = input.getAcctNatureNo();
        RbBusAcctPurpose acctPurpose = input.getRbBusAcctPurpose();

        if (AcctNatureNo.VALUE_11001.equals(acctNatureNo) || AcctNatureNo.VALUE_11002.equals(acctNatureNo)) {
            // 子步骤 3a → 子步骤 4（检查基本户和验资户的账户用途）。
            // 判定按条件取值：{账户属性}为基本存款账户（VALUE_11001）或一般户（VALUE_11002）时，
            // {账户用途}不为空且不为「无特殊用途」（VALUE_0）→ ER0014；否则（为空或为无特殊用途）→「通过」。
            // 分派与判定不按子步骤名称收窄范围（名称与判定条件的表述差异已放行）。
            if (acctPurpose != null && !RbBusAcctPurpose.VALUE_0.equals(acctPurpose)) {
                output.setSucceed(false);
                output.setErrorCode(ERROR_CODE_BASIC_OR_GENERAL);
                output.setErrorMessage(ERROR_MESSAGE_BASIC_OR_GENERAL);
                return output;
            }
            return pass(output);
        }

        if (AcctNatureNo.VALUE_17.equals(acctNatureNo)) {
            // 子步骤 3b → 子步骤 5（检查临时户的账户用途）。
            // 判定按条件取值：{账户属性}为验资户（VALUE_17）时，允许集合为｛注册验资（VALUE_1）、
            // 增资验资（VALUE_2）、无特殊用途（VALUE_0）｝；{账户用途}不属于该集合（含为空）→ ER0015，
            // 属于该集合 →「通过」。
            if (!RbBusAcctPurpose.VALUE_1.equals(acctPurpose) && !RbBusAcctPurpose.VALUE_2.equals(acctPurpose)
                    && !RbBusAcctPurpose.VALUE_0.equals(acctPurpose)) {
                output.setSucceed(false);
                output.setErrorCode(ERROR_CODE_VERIFY);
                output.setErrorMessage(ERROR_MESSAGE_VERIFY);
                return output;
            }
            return pass(output);
        }

        if (AcctNatureNo.VALUE_11004.equals(acctNatureNo)) {
            // 子步骤 3c → 子步骤 6（检查专用户的账户用途）。
            // 判定按条件取值：{账户属性}为专用存款账户（VALUE_11004）时，允许集合为｛预算单位专用（VALUE_4）、
            // 非预算单位专用（VALUE_3）｝；{账户用途}不属于该集合（含为空）→ ER0016，属于该集合 →「通过」。
            if (!RbBusAcctPurpose.VALUE_4.equals(acctPurpose) && !RbBusAcctPurpose.VALUE_3.equals(acctPurpose)) {
                output.setSucceed(false);
                output.setErrorCode(ERROR_CODE_SPECIAL);
                output.setErrorMessage(ERROR_MESSAGE_SPECIAL);
                return output;
            }
            return pass(output);
        }

        // 子步骤 3d：{账户属性}为上述四类以外的其它取值（含源需求明文列举的临时存款账户
        // AcctNatureNo.VALUE_11003）或为空时，直接返回检查结果为「通过」，不执行子步骤 4／5／6 的用途判定。
        // 该返回只可能来自本处或被分派子步骤的「否则」分支，不与任何错误码同时出现。
        return pass(output);
    }

    /**
     * 判断字符串是否为「为空（无值）」。
     *
     * <p>源需求未区分 {@code null} 与空字符串，Spec 统一表述为「为空（无值）」，故两种形态均返回
     * {@code true}；本方法只用于子步骤 1 的{核准件编号}为空判定，不引入额外校验分支。</p>
     */
    private boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    /** 设置检查结果为「通过」：{@code succeed = true} 且两个错误字段保持空值。 */
    private ST098OutputBO pass(ST098OutputBO output) {
        output.setSucceed(true);
        return output;
    }
}
