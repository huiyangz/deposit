package com.dcits.deposit.task.dto;

/**
 * T3S1 检查黑名单 输出 DTO。
 *
 * <p>业务输出 dealFlow（处理方式）为非必填字段，来源名单限制规则参数表
 * （RC_RULE_TYPE）。ST036 步骤返回「通过」时不设置 dealFlow（为空）；返回
 * 「拒绝」「授权」「提醒」时取对应处理方式（DealFlow.B/A/D）。接口层字段类型与
 * String/枚举编码口径需求未定义（Spec TBD-1），本 DTO 按需求「输出」表将
 * dealFlow 声明为 {@code java.lang.String}。</p>
 */
public class T3S1OutputDTO {

    /** 处理方式 */
    private String dealFlow;

    public String getDealFlow() {
        return dealFlow;
    }

    public void setDealFlow(String dealFlow) {
        this.dealFlow = dealFlow;
    }
}
