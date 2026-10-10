package com.dcits.depsit.task.dto;

/**
 * T7S1 检查客户限制 —— 交易对外输出 DTO。
 *
 * <p>按 Spec「### 输出（交易对外业务输出）」表声明 3 个业务字段，标记均为「非必填」，
 * 来源实体均为客户限制表（{@code RB_CLIENT_RESTRAINTS}），取值取自唯一被调步骤
 * {@code ST111} 输出的同名三项（REQ-003、REQ-004）：</p>
 * <ul>
 *   <li>{@code resSeqNo}：限制编号，取步骤输出的 {@link String} 原值；</li>
 *   <li>{@code restraintType}：账户限制类型，取步骤输出枚举
 *       {@code com.dcits.depsit.enums.RestraintType} 的码值字符串（{@code getValue()}）；</li>
 *   <li>{@code restraintsStatus}：限制状态，取步骤输出枚举
 *       {@code com.dcits.depsit.enums.RestraintsStatus} 的码值字符串（已确认码值
 *       {@code A}／{@code E}／{@code F}）。</li>
 * </ul>
 *
 * <p>枚举相关字段在对外 DTO 中以 {@link String} 承载（工程约定），MUST NOT 直接暴露 Java 枚举
 * 类型，MUST NOT 以 {@code toString()} 或枚举常量名（如 {@code "VALUE_13"}）代替业务编码
 * （REQ-004）。查询结果为空时三字段均为空值，不以 {@code "N"}／{@code "无"}／{@code "0"} 等
 * 业务常量占位（REQ-003-S03）。</p>
 *
 * <p>本类 MUST NOT 声明需求「## 输出」表之外的业务字段（REQ-004-S02）；本次调用的成功状态由
 * 响应头 {@code com.dcits.common.task.RespHeader} 承载，本类不继承 {@code StepResult}，
 * 也不声明 {@code succeed}／{@code errorCode}／{@code errorMessage}／{@code header} 字段。</p>
 */
public class T7S1OutputDTO {

    /** 限制编号 */
    private String resSeqNo;

    /** 账户限制类型（RestraintType 码值字符串） */
    private String restraintType;

    /** 限制状态（RestraintsStatus 码值字符串） */
    private String restraintsStatus;

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }

    public String getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(String restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }
}
