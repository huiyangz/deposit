package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.Ccy;

/**
 * ST055 检查机构币种交易权限 输出 BO。
 *
 * <p>步骤结果承载于工程基类 {@link StepResult}（不重复声明 {@code succeed}/{@code errorCode}/
 * {@code errorMessage} 遮蔽基类字段）：
 * 检查结果“通过”以 {@code succeed = true} 且错误字段为 {@code null} 表达；
 * 不属于 [机构币种列表] 时以 {@code succeed = false}、{@code errorCode = "ER0047"} 表达。
 * “检查结果”不落成独立的业务输出字段。</p>
 *
 * <p>源需求「## 输出」表声明的字段 {@code ccy}（币种，类型 {@link Ccy}）照录于此，
 * 标记为「非必填」（即允许无值）。源需求正文未给出该字段的产生条件、取值与用途，
 * 本 BO 不为其设定赋值口径，通过／不通过的判定也不以该字段是否有值或取值表达。</p>
 */
public class ST055OutputBO extends StepResult {

    /** 币种，类型 {@link Ccy}，标记「非必填」（允许无值）；产生条件与取值源需求未规定 */
    private Ccy ccy;

    public Ccy getCcy() {
        return ccy;
    }

    public void setCcy(Ccy ccy) {
        this.ccy = ccy;
    }
}
