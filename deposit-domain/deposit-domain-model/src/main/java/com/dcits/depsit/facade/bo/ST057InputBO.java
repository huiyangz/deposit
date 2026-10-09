package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.TranType;

/**
 * ST057 检查支取交易类型 —— 输入 BO。
 *
 * <p>按 Spec「### 输入」表，本步骤仅有 {@code tranType} 一个入参，标记为「必填」，类型为
 * {@link TranType}，取值由该枚举成员的代码值构成（示例："1003"＝现金支取）；它同时是步骤1
 * 查询【交易类型定义】的查询键。源需求正文中的「{交易类型}」「[输入数据-交易类型]」与
 * 「[交易类型]」均指向本字段，不构成额外输入（Spec REQ-001-S02）。</p>
 *
 * <p>源需求「## 输入」表「来源实体」列为空，本 BO 不假定该入参在调用方侧的取得方式，
 * 也不据此增加取数动作；源需求未要求校验其是否为 {@link TranType} 的合法枚举取值，
 * 故本类不施加额外校验、不设置默认值（Spec 明确不覆盖事项第 4、5 项）。</p>
 */
public class ST057InputBO {

    /** 交易类型，必填；用于查询【交易类型定义表(RB_TRAN_DEF)】的键。 */
    private TranType tranType;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }
}
