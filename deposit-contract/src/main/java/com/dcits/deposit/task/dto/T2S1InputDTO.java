package com.dcits.deposit.task.dto;

import jakarta.validation.constraints.NotNull;

/**
 * T2S1 检查账户限制 输入 DTO。
 *
 * <p>接口接收账号、交易类型、渠道类型、账户限制类型四个必填输入，类型均为
 * {@code java.lang.String}（Spec REQ-001）。ST048/ST057 等步骤输入契约为枚举
 * （SourceType/TranType/RestraintType），由场景类按 {@code byValue(String)} 转换并
 * 传递（Spec REQ-003）；必填输入缺失或字符串无法映射为枚举取值时接口是否报错、
 * 错误码与错误信息需求未定义（Spec TBD-3），本 DTO 不定义失败分支。</p>
 */
public class T2S1InputDTO {

    /** 账号 */
    @NotNull
    private String baseAcctNo;

    /** 交易类型 */
    @NotNull
    private String tranType;

    /** 渠道类型 */
    @NotNull
    private String sourceType;

    /** 账户限制类型 */
    @NotNull
    private String restraintType;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(String restraintType) {
        this.restraintType = restraintType;
    }
}
