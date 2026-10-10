package com.dcits.depsit.facade.bo;

/**
 * ST107 匹配限额场景 输入 BO。
 *
 * <p>源需求「## 输入」表仅一行字段，业务名称为「因子名称」，类型 {@link String}，标记「必填」，
 * 「来源实体」列为空。源需求未给出英文标识或 camelCase 名，正式 Spec REQ-001-S02 明确
 * 「字段名 MUST 沿用源需求原文「因子名称」，本 Spec 不代为命名英文标识」，
 * 故本 BO 直接以中文字段名声明字段与访问器，不自造英文名。
 *
 * <p>该字段是子步骤1 查询【限额规则关系表】的依据；字段到查询列的绑定属 Spec
 * 「## 验收范围与明确不覆盖的事项」第 1 项已放行事项，不改变本 BO 的契约。
 */
public class ST107InputBO {

    /** 因子名称（唯一输入，必填） */
    private String 因子名称;

    public String get因子名称() {
        return 因子名称;
    }

    public void set因子名称(String 因子名称) {
        this.因子名称 = 因子名称;
    }
}
