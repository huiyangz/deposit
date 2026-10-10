package com.dcits.depsit.facade.bo;

/**
 * ST105 处理限额 输入 BO。
 *
 * <p>字段名、类型与「必填」标记照录 Spec「### 输入」表：唯一输入 {@code limitSceneNo} 为
 * {@code java.lang.String} 且必填。[限额场景编码] 绑定到 {@code limitSceneNo}，作为子步骤1
 * 查询【限额控制配置(RB_LIMIT_CTRL_CONF)】的定位条件。</p>
 *
 * <p>「来源实体」列按 Spec 照录；`limitSceneNo` 的上游赋值来源与为空／非法时的处理源需求未定义
 * （Spec 不覆盖事项 4），本步骤不作规定，也不在实现中发起额外校验。</p>
 */
public class ST105InputBO {

    /** 限额场景编码（来源实体：限额控制配置 RB_LIMIT_CTRL_CONF）——步骤描述中的 [限额场景编码] */
    private String limitSceneNo;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }
}
