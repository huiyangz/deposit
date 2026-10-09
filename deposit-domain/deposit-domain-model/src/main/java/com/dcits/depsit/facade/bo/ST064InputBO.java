package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.TranType;

/**
 * ST064 检查现金支取交易权限 —— 输入 BO。
 *
 * <p>按 Spec「### 输入」表，本步骤仅有 {@code tranType} 一个入参，标记为「必填」，
 * 类型为 {@link TranType}，取值由该枚举成员构成并按成员代码值定位；
 * 它同时是子步骤 1 查询【交易类型定义】的查询键。</p>
 *
 * <p>源需求输入表「来源实体」列为空，本 BO 不假定该入参的取数出处；
 * 源需求未定义其为空值或取值不在 {@link TranType} 合法成员内时的行为，
 * 故本类不施加额外校验，也不设置默认值（Spec 明确不覆盖事项第 1 项）。</p>
 */
public class ST064InputBO {

    /** 交易类型，必填；用于查询【交易类型定义表(RB_TRAN_DEF)】的键。 */
    private TranType tranType;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }
}
