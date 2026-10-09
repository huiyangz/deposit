package com.dcits.depsit.step;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.facade.bo.ST064InputBO;
import com.dcits.depsit.facade.bo.ST064OutputBO;
import com.dcits.depsit.facade.components.IRbTranDefBcc;
import com.dcits.depsit.facade.eo.RbTranDefEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST064 检查现金支取交易权限 —— 步骤实现。
 *
 * <p>子步骤 1「获取交易类型」：根据 {交易类型}（入参 {@code tranType}）查询【交易类型定义表(RB_TRAN_DEF)】
 * 获取对应的 [借贷标志]、[现金交易标志]、[冲正交易标志]，并分别产出为输出 {@code crDrInd}、
 * {@code cashTranFlag}、{@code reversal}，取值等于查得的对应标志值。</p>
 *
 * <p>子步骤 2「检查交易类型是否为现金支取」：以子步骤 1 同一次查询所得的这三个标志做「与」判定——
 * 借贷标志为「D借方」且现金交易标志为「Y是」且冲正交易标志为「N否」三项同时成立时产出错误码
 * {@code ER0070}；否则产出检查结果为「通过」。两项产出互斥，由同一次判定产出。</p>
 *
 * <p>按 Spec「依赖与执行形态」：本步骤只调用 {@link IRbTranDefBcc#findByTranType} 一次字典查询，
 * 无组件内步骤调用、无规则调用、无跨组件调用；「状态性」为只读，不产生任何写入，故 {@code execute}
 * 不需要事务，接口亦未向调用方提出事务要求。</p>
 *
 * <p>源需求未定义查询无记录、标志取值为空或取 "Y"／"N" 之外取值时的行为（Spec 明确不覆盖事项第 2、3 项），
 * 本实现不为这些情形补默认值或兜底分支。</p>
 */
@Service
public class ST064Pbc implements IST064 {

    /** 借贷标志「D借方」＝「借」，代码值 "D"，见 {@link CrDrInd#D}。 */
    private static final CrDrInd CR_DR_IND_DEBIT = CrDrInd.D;

    /** 现金交易标志「Y是」对应的代码值。 */
    private static final String CASH_TRAN_FLAG_YES = "Y";

    /** 冲正交易标志「N否」对应的代码值。 */
    private static final String REVERSAL_NO = "N";

    /** 三条件同时成立时的错误码，来源：errorcodes.properties 的 {@code ER0070}。 */
    private static final String ERROR_CODE_CASH_WITHDRAW_NOT_ALLOWED = "ER0070";

    /** 错误信息，按「错误码::业务说明」格式取错误码清单中 ER0070 的业务说明。 */
    private static final String ERROR_MESSAGE_CASH_WITHDRAW_NOT_ALLOWED =
            "ER0070::“11002-一般存款账户”不允许现金支取";

    @Autowired
    private IRbTranDefBcc irTranDefBcc;

    @Override
    public ST064OutputBO execute(ST064InputBO input) {
        ST064OutputBO output = new ST064OutputBO();

        // 子步骤 1「获取交易类型」：按主键 tranType 查询【交易类型定义】，取得三个标志。
        RbTranDefEO tranDef = irTranDefBcc.findByTranType(input.getTranType());

        // 子步骤 1 的产出：三个输出字段的取值等于查得的对应标志值，
        // 与子步骤 2 的判定结论无关（Spec REQ-001）。
        output.setCrDrInd(tranDef.getCrDrInd());
        output.setCashTranFlag(tranDef.getCashTranFlag());
        output.setReversal(tranDef.getReversal());

        // 子步骤 2「检查交易类型是否为现金支取」：「与」判定，三项判定值取自子步骤 1 同一次查询
        // 所得并已产出的三个标志，不另行取数（Spec REQ-002）。
        // 「D借方」按 CrDrInd 成员的代码值 "D" 判定，「Y是」「N否」按代码值 "Y"／"N" 判定（Spec REQ-005）。
        if (CR_DR_IND_DEBIT.equals(output.getCrDrInd())
                && CASH_TRAN_FLAG_YES.equals(output.getCashTranFlag())
                && REVERSAL_NO.equals(output.getReversal())) {
            // 三条件同时成立：产出错误码 ER0070，不产出检查结果「通过」（Spec REQ-003）。
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_CASH_WITHDRAW_NOT_ALLOWED);
            output.setErrorMessage(ERROR_MESSAGE_CASH_WITHDRAW_NOT_ALLOWED);
            return output;
        }

        // 「否则」分支：任一条件不成立，产出检查结果「通过」，不产出错误码（Spec REQ-004）。
        output.setSucceed(true);
        return output;
    }
}
