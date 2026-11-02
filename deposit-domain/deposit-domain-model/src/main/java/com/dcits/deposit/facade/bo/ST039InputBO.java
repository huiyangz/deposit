package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST039 计算限额累计金额 步骤输入。
 *
 * <p>字段来源：正式 Spec ST039「输入」表。tranAmt（交易金额）、limitSceneNo（限额场景编码）
 * 均为必填输入，由步骤调用方提供；limitSceneNo 的业务来源实体为限额控制配置
 * （RB_LIMIT_CTRL_CONF）。</p>
 */
public class ST039InputBO {
    /** 交易金额（必填） */
    private BigDecimal tranAmt;
    /** 限额场景编码（必填） */
    private String limitSceneNo;

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }
}
