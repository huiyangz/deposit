package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST065 检查分位金额 输出 BO。
 *
 * <p>业务字段取自正式 Spec「## 输出」表：仅 1 个字段「参数值」paraValue（java.lang.String，非必填）。
 * 其取值为步骤1 按参数名称 LIMIT_CENT_AMT 取数所得的参数值，与判定所用的「分位处理金额分位上限」为同一取值。
 * 「非必填」为源需求原始标记，本 BO 不将其升格为必填。</p>
 *
 * <p>检查结果（「通过」）与错误码（ER0069）无源需求声明的业务承载字段，由父类
 * {@link StepResult} 的成功标志与错误码承载；本 BO 不重复声明这些保留字段，也不补写其它业务字段。</p>
 */
public class ST065OutputBO extends StepResult {

    /** 参数值（非必填，java.lang.String）：步骤1 按参数名称 LIMIT_CENT_AMT 取数所得的参数值 */
    private String paraValue;

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }
}
