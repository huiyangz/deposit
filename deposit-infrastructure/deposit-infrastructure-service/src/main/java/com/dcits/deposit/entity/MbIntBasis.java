package com.dcits.deposit.entity;

public class MbIntBasis {
    /** 基准利率类型 */
    private String intBasis;
    /** 基准利率类型描述 */
    private String intBasisDesc;
    /** 客户号 */
    private String clientNo;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getIntBasis() {
        return intBasis;
    }

    public void setIntBasis(String intBasis) {
        this.intBasis = intBasis;
    }

    public String getIntBasisDesc() {
        return intBasisDesc;
    }

    public void setIntBasisDesc(String intBasisDesc) {
        this.intBasisDesc = intBasisDesc;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}