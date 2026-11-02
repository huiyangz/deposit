package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

/**
 * ST057 检查限制优先级 输出。
 *
 * <p>正常完成时 {@code succeed=true} 且 {@code errorCode}/{@code errorMessage} 为
 * {@code null}；检查结果「不检查限制」/「继续检查」作为业务结论表达，不进入错误字段。
 * 输出字段语义见类内 FIXME（Spec「待确认事项」TBD-2、TBD-4）。</p>
 */
public class ST057OutputBO extends StepResult {
                                                                                                                                                                                                                                                                                              
                                                                                                                                                                                                                  
    /** 冻结级别（非必填；字段语义与赋值见类内 FIXME） */
                                                       
                                                       
    private String resPriority;

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }
}
