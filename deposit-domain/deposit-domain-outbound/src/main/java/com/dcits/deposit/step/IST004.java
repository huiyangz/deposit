package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST004InputBO;
import com.dcits.deposit.facade.bo.ST004OutputBO;

/**
 * ST004 检查账户通兑信息 步骤接口。
 *
 * <p>按 Spec「步骤描述」第 1–10 步执行：依据账号（{@code baseAcctNo}）查询对公存款账户主表
 * （RB_BUS_ACCT）取得账户开立行行号与通兑标志，结合交易机构（{@code tranBranch}）判断账户是否
 * 允许在交易机构办理通兑业务。检查结果「通过」为步骤正常结束（{@code succeed=true}、
 * {@code errorCode=null}）；业务失败以 {@code succeed=false} 及错误码 {@code ER0071}/{@code ER0072}/
 * {@code ER0073} 表示。
 */
public interface IST004 {

    /**
     * 执行检查账户通兑信息步骤。
     *
     * @param input 步骤输入，包含账号（baseAcctNo）与交易机构号（tranBranch）
     * @return 步骤输出，继承 {@link com.dcits.common.step.StepResult}，含各业务输出字段
     */
    ST004OutputBO execute(ST004InputBO input);
}
