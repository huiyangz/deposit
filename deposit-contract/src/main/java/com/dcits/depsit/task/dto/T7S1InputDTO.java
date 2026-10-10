package com.dcits.depsit.task.dto;

import jakarta.validation.constraints.NotNull;

/**
 * T7S1 检查客户限制 —— 交易对外输入 DTO。
 *
 * <p>按 Spec「### 输入（交易对外）」表，本交易对外业务输入仅有 1 个字段：客户号
 * （{@code clientNo}，{@link String}，标记「必填」），由调用方上送，并原值传入唯一被调步骤
 * {@code ST111}「检查客户是否存在限制」的入参 {客户号}（{@code ST111InputBO.clientNo}），
 * 不做变形、不补默认值（REQ-001、REQ-002）。</p>
 *
 * <p>本类 MUST NOT 要求调用方上送需求「## 输入」表之外的字段（REQ-001-S02）；响应头
 * {@code com.dcits.common.task.RespHeader} 的字段属技术报文头，不计入对外业务输入。</p>
 *
 * <p>字段标为「必填」，但需求未定义无值、空字符串或格式非法时的校验与失败行为
 * （Spec「验收范围与明确不覆盖的事项」第 1 项），故此处仅按已确认的必填性标注
 * {@link NotNull}，不追加 {@code @NotBlank} 等会强化合法值范围的约束，也不生成默认值。</p>
 */
public class T7S1InputDTO {

    /** 客户号 */
    @NotNull
    private String clientNo;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }
}
