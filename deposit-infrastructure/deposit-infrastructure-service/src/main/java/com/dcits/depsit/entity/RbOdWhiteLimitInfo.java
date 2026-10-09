package com.dcits.depsit.entity;

import java.math.BigDecimal;

public class RbOdWhiteLimitInfo {
    /** 单笔透支检查金额 */
    private BigDecimal odPtAmt;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 同一支付对象当日累计透支金额 */
    private BigDecimal sameObjectPdOdCumulative;
    /** 凭证行外调拨标志 */
    private String vbsflag;
    /** 靠档计息跨月跨季标志 */
    private String isCrossFlag;

    public BigDecimal getOdPtAmt() {
        return odPtAmt;
    }

    public void setOdPtAmt(BigDecimal odPtAmt) {
        this.odPtAmt = odPtAmt;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getSameObjectPdOdCumulative() {
        return sameObjectPdOdCumulative;
    }

    public void setSameObjectPdOdCumulative(BigDecimal sameObjectPdOdCumulative) {
        this.sameObjectPdOdCumulative = sameObjectPdOdCumulative;
    }

    public String getVbsflag() {
        return vbsflag;
    }

    public void setVbsflag(String vbsflag) {
        this.vbsflag = vbsflag;
    }

    public String getIsCrossFlag() {
        return isCrossFlag;
    }

    public void setIsCrossFlag(String isCrossFlag) {
        this.isCrossFlag = isCrossFlag;
    }
}