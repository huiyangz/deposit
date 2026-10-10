package com.dcits.depsit.facade.bo;

/**
 * ST109 检查限额场景配置是否有效 的输入 BO。
 *
 * <p>沿用源需求「## 输入」表的行序：tranDate、tranTimestamp、limitSceneNo；三项均为必填。</p>
 */
public class ST109InputBO {

    /** 交易日期（需求正文以 {交易日期} 书写），用于日期侧判定 */
    private java.util.Date tranDate;

    /** 交易时间戳（需求正文以 {交易时间} 书写），用于时间侧判定 */
    private java.lang.String tranTimestamp;

    /** 限额场景编码，用于查询条件与有效时的原值返回 */
    private java.lang.String limitSceneNo;

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public java.lang.String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(java.lang.String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public java.lang.String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(java.lang.String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }
}
