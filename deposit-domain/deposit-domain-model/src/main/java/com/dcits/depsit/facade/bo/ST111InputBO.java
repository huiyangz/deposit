package com.dcits.depsit.facade.bo;

/**
 * ST111 检查客户是否存在限制 —— 输入 BO。
 *
 * <p>按 Spec「### 输入」表，本步骤仅有 1 个业务入参：客户号（{@code clientNo}），
 * 作为子步骤 1 查询【客户限制表】的条件之一。该字段标为「必填」，但需求未定义其无值、
 * 空字符串或格式非法时的校验与失败行为（Spec「验收范围与明确不覆盖的事项」第 1 项），
 * 故此处不生成校验、默认值或填充。</p>
 */
public class ST111InputBO {

    /** 客户号 */
    private String clientNo;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }
}
