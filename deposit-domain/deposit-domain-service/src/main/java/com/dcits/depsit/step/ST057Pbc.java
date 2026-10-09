package com.dcits.depsit.step;

import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.facade.bo.ST057InputBO;
import com.dcits.depsit.facade.bo.ST057OutputBO;
import com.dcits.depsit.facade.components.IRbTranDefBcc;
import com.dcits.depsit.facade.eo.RbTranDefEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST057 检查支取交易类型 —— 步骤实现。
 *
 * <p>子步骤 1「获取支取交易类型」：根据 {交易类型}（入参 {@code tranType}）查询
 * 【交易类型定义表(RB_TRAN_DEF)】获取对应的 [借贷标志]、[现金交易标志]、[冲正交易标志]，
 * 并分别产出为输出 {@code crDrInd}、{@code cashTranFlag}、{@code reversal}，取值等于查得的对应标志值。
 * 三个字段取自同一次按交易类型的查询所得记录的同一记录，不拆分多次查询、不跨记录拼接
 * （Spec REQ-002）。</p>
 *
 * <p>子步骤 2「检查交易类型」：以子步骤 1 同一次查询所得的这三个标志做「与」判定——借贷标志为
 * 「D-借方」且现金交易标志为「Y是」且冲正交易标志为「N否」三项同时成立时继续执行，以通过状态结束；
 * 否则（任一条件不成立）返回错误码 {@code ER0067}。两类结果互斥，由同一次判定产出
 * （Spec REQ-003、REQ-004）。判定取值按码值口径：{@code CrDrInd.D} 的代码值 "D"、"Y"、"N"
 * （Spec REQ-004-S05 判定表、REQ-005）。</p>
 *
 * <p>按 Spec「### 依赖契约」：本步骤只调用 {@link IRbTranDefBcc#findByTranType} 一次字典查询，
 * 无组件内步骤调用、无规则调用、无跨组件客户端调用；本步骤为检查步骤，状态性为只读，不产生任何写入，
 * 故 {@code execute} 不需要事务，接口亦未向调用方提出事务要求。源需求未定义查询无匹配记录、
 * 三字段取到无值时的处理，也未要求校验 {@code tranType} 的取值合法性（Spec 明确不覆盖事项第 1、4 项），
 * 本实现不为这些情形补默认值或兜底分支。</p>
 */
@Service
public class ST057Pbc implements IST057 {

    /** 借贷标志「D-借方」对应的枚举成员，代码值 "D"，见 {@link CrDrInd#D}。 */
    private static final CrDrInd CR_DR_IND_DEBIT = CrDrInd.D;

    /** 现金交易标志「Y是」对应的代码值。 */
    private static final String CASH_TRAN_FLAG_YES = "Y";

    /** 冲正交易标志「N否」对应的代码值。 */
    private static final String REVERSAL_NO = "N";

    /** 判定不通过时的错误码，来源：errorcodes.properties 第 67 行的 {@code ER0067}。 */
    private static final String ERROR_CODE_TRAN_TYPE = "ER0067";

    /** 错误信息，按「错误码::业务说明」格式取错误码清单中 ER0067 的业务说明。 */
    private static final String ERROR_MESSAGE_TRAN_TYPE = "ER0067::交易类型错误";

    @Autowired
    private IRbTranDefBcc irTranDefBcc;

    @Override
    public ST057OutputBO execute(ST057InputBO input) {
        ST057OutputBO output = new ST057OutputBO();

        // 子步骤 1「获取支取交易类型」：按主键 tranType 查询【交易类型定义】，取得三个标志。
        RbTranDefEO tranDef = irTranDefBcc.findByTranType(input.getTranType());

        // 子步骤 1 的产出：三个输出字段分别承载该次查询所得记录的同名业务字段
        // （借贷标志→crDrInd、现金交易标志→cashTranFlag、冲正交易标志→reversal），
        // 三者同源于这一次查询，不另行取数（Spec REQ-002、REQ-005）。
        output.setCrDrInd(tranDef.getCrDrInd());
        output.setCashTranFlag(tranDef.getCashTranFlag());
        output.setReversal(tranDef.getReversal());

        // 子步骤 2「检查交易类型」：「与」判定，三个条件取自子步骤 1 同一次查询所得并已产出的三个标志。
        // 「D-借方」按 CrDrInd 成员的代码值 "D" 判定，「Y是」「N否」按代码值 "Y"／"N" 判定
        // （Spec REQ-003、REQ-004 与「### 取值书写口径」）。
        if (CR_DR_IND_DEBIT.equals(output.getCrDrInd())
                && CASH_TRAN_FLAG_YES.equals(output.getCashTranFlag())
                && REVERSAL_NO.equals(output.getReversal())) {
            // 三条件同时成立：继续执行，本步骤以通过状态结束，不返回错误码，也不产生数据写入（Spec REQ-003）。
            output.setSucceed(true);
            return output;
        }

        // 「否则」分支：任一条件不成立，返回错误码 ER0067，不继续执行；不返回其它错误码、
        // 不返回 null、不以异常代替错误码（Spec REQ-004、REQ-006）。
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_TRAN_TYPE);
        output.setErrorMessage(ERROR_MESSAGE_TRAN_TYPE);
        return output;
    }
}
