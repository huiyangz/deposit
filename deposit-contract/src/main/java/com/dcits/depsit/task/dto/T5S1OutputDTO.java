package com.dcits.depsit.task.dto;

/**
 * T5S1 检查黑名单 —— 交易对外输出 DTO。
 *
 * <p>按 Spec「### 输出（交易对外业务输出）」表，本交易业务输出仅有 1 个字段 {@code dealFlow}
 * （处理方式，{@link String}，标记「非必填」，来源实体为名单限制规则参数表
 * {@code RC_RULE_TYPE}），取值取自唯一被调步骤 {@code ST100}「检查黑名单」输出的同名枚举
 * {@code com.dcits.depsit.enums.DealFlow} 的码值字符串（{@code getValue()}）（REQ-004、REQ-005）：</p>
 * <ul>
 *   <li>步骤输出为 {@code DealFlow.B}（拒绝）／{@code DealFlow.A}（授权）／
 *       {@code DealFlow.D}（提醒）时，本字段为对应码值 {@code "B"}／{@code "A"}／{@code "D"}；</li>
 *   <li>步骤输出无值（检查结果为「通过」）时，本字段同样无取值；MUST NOT 以 {@code "N"}／
 *       {@code "无"}／{@code "0"} 等业务常量占位，也不改写为 {@code "B"}／{@code "A"}／{@code "D"}
 *       中的任一取值（REQ-004-S03）。</li>
 * </ul>
 *
 * <p>枚举相关字段在对外 DTO 中以 {@link String} 承载（工程约定），MUST NOT 直接暴露 Java 枚举
 * 类型，MUST NOT 以 {@code toString()} 或枚举常量名代替业务编码（REQ-005）。</p>
 *
 * <p>本类 MUST NOT 声明 Spec「### 输出（交易对外业务输出）」表之外的业务字段（REQ-005-S02）；
 * 本次调用的成功状态由响应头 {@code com.dcits.common.task.RespHeader} 承载，本类不继承
 * {@code StepResult}，也不声明 {@code succeed}／{@code errorCode}／{@code errorMessage}／
 * {@code header} 字段。</p>
 */
public class T5S1OutputDTO {

    /** 处理方式（DealFlow 码值字符串；检查结果为「通过」时无取值） */
    private String dealFlow;

    public String getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(String dealFlow) {
        this.dealFlow = dealFlow;
    }
}
