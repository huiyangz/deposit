package com.dcits.deposit.facade.bo;

/**
 * ST045 检查限额场景配置是否有效 输入。
 *
 * <p>输入字段按正式 Spec（ST045）输入表声明：交易日期、交易时间戳、限额场景编码，三者均标记必填；
 * 必填缺失/无效值时的行为为 Spec 待确认事项，见 {@link com.dcits.deposit.step.ST045Pbc} 中 FIXME。</p>
 */
public class ST045InputBO {

    /** 交易日期（必填） */
    private java.util.Date tranDate;

    /** 交易时间戳（必填）；比较口径与格式见 Spec 待确认事项 3 */
    private String tranTimestamp;

    /** 限额场景编码（必填），用作查询限额控制配置的条件 */
    private String limitSceneNo;

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }
}
