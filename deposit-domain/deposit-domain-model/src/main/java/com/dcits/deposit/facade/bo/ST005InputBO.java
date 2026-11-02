package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ST005 检查支取账户限额 步骤输入。
 *
 * <p>字段来自正式 Spec 输入表，均必填。字段名"因子名称"按需求原样使用。</p>
 */
public class ST005InputBO {

    /** 客户号 */
    private String clientNo;

    /** 账号 */
    private String baseAcctNo;

    /** 因子名称 */
    private String 因子名称;

    /** 交易日期 */
    private Date tranDate;

    /** 交易时间戳 */
    private String tranTimestamp;

    /** 交易金额 */
    private BigDecimal tranAmt;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String get因子名称() {
        return 因子名称;
    }

    public void set因子名称(String 因子名称) {
        this.因子名称 = 因子名称;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }
}
