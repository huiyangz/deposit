package com.dcits.deposit.facade.bo;

/**
 * ST050 检查有权机关冻结限制 步骤输入。
 *
 * <p>字段来自正式 Spec ST050「输入」表（REQ-001）。baseAcctNo 为必填输入，步骤 1
 * 用于查询账户限制信息的账号条件；其为空或缺失时的校验与失败行为待业务确认
 * （Spec 待确认事项 TBD-5），见 {@link com.dcits.deposit.step.ST050Pbc#execute(ST050InputBO)}。</p>
 */
public class ST050InputBO {

    /** 账号 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
