package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.common.step.GotoStepCondition;
import com.dcits.deposit.enums.IsOverMonthSeasonOd;
import com.dcits.deposit.facade.bo.ST015InputBO;
import com.dcits.deposit.facade.bo.ST015OutputBO;
import com.dcits.deposit.facade.components.IRbBusAgreementOverdraftBcc;
import com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO;

/**
 * ST015 检查靠档标识 步骤实现。
 *
 * <p>子步骤 1（REQ-001）：依据必填输入 baseAcctNo 查询【法透协议信息】（对公透支签约表
 * RB_BUS_AGREEMENT_OVERDRAFT）取得靠档跨月季标识，作为输出 isOverMonthSeasonOd 返回。</p>
 *
 * <p>子步骤 2（REQ-002/REQ-003）：标识为「跨月」（{@code IsOverMonthSeasonOd.M}）或「跨季」
 * （{@code IsOverMonthSeasonOd.Q}）时，使后续流程跳转至步骤《检查法人透支金额》；标识为
 * 「不跨月/季」（{@code IsOverMonthSeasonOd.N}）时，跳转至步骤《检查分行法人透支额度》。
 * 跳转经 {@code GotoStepCondition} 契约的 gotoStepName 机制表达，候选步骤见类注解。</p>
 *
 * <p>本需求未声明任何业务失败场景，步骤正常完成即成功、不产生错误码。</p>
 */
@Service
@GotoStepCondition(candidateSteps = { "检查法人透支金额", "检查分行法人透支额度" })
public class ST015Pbc implements IST015 {

    /** 跳转目标：检查法人透支金额 */
    private static final String GOTO_STEP_CHECK_LEGAL_OD_AMOUNT = "检查法人透支金额";

    /** 跳转目标：检查分行法人透支额度 */
    private static final String GOTO_STEP_CHECK_BRANCH_LEGAL_OD_LIMIT = "检查分行法人透支额度";

    private final IRbBusAgreementOverdraftBcc rbBusAgreementOverdraftBcc;

    public ST015Pbc(IRbBusAgreementOverdraftBcc rbBusAgreementOverdraftBcc) {
        this.rbBusAgreementOverdraftBcc = rbBusAgreementOverdraftBcc;
    }

    @Override
    public ST015OutputBO execute(ST015InputBO input) {
        ST015OutputBO result = new ST015OutputBO();

        // 子步骤 1（REQ-001）：依据 baseAcctNo 查询【法透协议信息】（对公透支签约表 RB_BUS_AGREEMENT_OVERDRAFT）取得靠档跨月季标识
        // FIXME 业务项:ST015/检查靠档标识 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:baseAcctNo 标记必填，但输入为空/缺失时的行为（是否报错及错误码）未定义，本需求未声明业务失败场景、无错误码契约（Spec 待确认事项 4） - 影响:该场景当前按 baseAcctNo=null 条件查询并继续成功返回，必填校验缺失时的失败处理未定 - 待确认:baseAcctNo 为空/缺失时应报错及错误码，还是允许按空条件查询
        RbBusAgreementOverdraftEO queryEo = new RbBusAgreementOverdraftEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusAgreementOverdraftEO> agreements = rbBusAgreementOverdraftBcc.findByEo(queryEo);

        // 同一 baseAcctNo 存在多条记录时以哪条为准未定义（Spec 待确认事项 3），按项目约定多条统一取结果集第一条，先判空再取值
        IsOverMonthSeasonOd isOverMonthSeasonOd = null;
        if (!agreements.isEmpty()) {
            isOverMonthSeasonOd = agreements.get(0).getIsOverMonthSeasonOd();
        }
        result.setIsOverMonthSeasonOd(isOverMonthSeasonOd);

        // 子步骤 2（REQ-002/REQ-003）：依据靠档跨月季标识确定跳转目标
        // 「跨月」（M）或「跨季」（Q）→ 跳转《检查法人透支金额》；「不跨月/季」（N）→ 跳转《检查分行法人透支额度》
        // FIXME 业务项:ST015/检查靠档标识 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:按 baseAcctNo 查询无记录或记录靠档跨月季标识为空/非标准编码（byValue 返回 null）时，isOverMonthSeasonOd 输出及分支流向未定义（Spec 待确认事项 2） - 影响:该场景当前输出 isOverMonthSeasonOd=null、不设置跳转目标并按成功返回，跳转结果未定 - 待确认:该场景应报错还是归入「否则」分支跳转《检查分行法人透支额度》
        if (isOverMonthSeasonOd == IsOverMonthSeasonOd.M || isOverMonthSeasonOd == IsOverMonthSeasonOd.Q) {
            result.setGotoStepName(GOTO_STEP_CHECK_LEGAL_OD_AMOUNT);
        } else if (isOverMonthSeasonOd == IsOverMonthSeasonOd.N) {
            result.setGotoStepName(GOTO_STEP_CHECK_BRANCH_LEGAL_OD_LIMIT);
        }

        result.setSucceed(true);
        return result;
    }
}
