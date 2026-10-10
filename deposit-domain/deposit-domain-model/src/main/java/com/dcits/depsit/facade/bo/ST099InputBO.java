package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.SettleAcctClass;

/**
 * ST099 检查利息资本化标志 输入 BO。
 *
 * <p>两项入参的取数出处未定义，由调用方按步骤接口上送；本步骤不查询任何实体。</p>
 */
public class ST099InputBO {

    /** 利息资本化标志（必填）；子步骤 1 的判定取值，源需求以「N-否」记法给出，判定字面为码值 "N" */
    private String intCapFlag;

    /** 结算账户类型（必填）；子步骤 2 的判定取值，取值来源为枚举类 {@link SettleAcctClass} */
    private SettleAcctClass settleAcctClass;

    public String getIntCapFlag() {
        return intCapFlag;
    }

    public void setIntCapFlag(String intCapFlag) {
        this.intCapFlag = intCapFlag;
    }

    public SettleAcctClass getSettleAcctClass() {
        return settleAcctClass;
    }

    public void setSettleAcctClass(SettleAcctClass settleAcctClass) {
        this.settleAcctClass = settleAcctClass;
    }
}
