package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MbProdGroupEO {
    /** 产品类型 */
    @NotNull
    private String prodType;
    /** 产品子类型 */
    @NotNull
    private String prodSubType;
    /** 序号 */
    private String seqNo;
    /** 默认产品标志 */
    private IndividualFlag defaultProdFlag;
    /** 账户类别 */
    private AcctClass acctClass;
    /** 存益贷产品分层金额 */
    private BigDecimal ratio;
    /** 法人 */
    @NotNull
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdSubType() {
        return prodSubType;
    }

    public void setProdSubType(String prodSubType) {
        this.prodSubType = prodSubType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public IndividualFlag getDefaultProdFlag() {
        return defaultProdFlag;
    }

    public void setDefaultProdFlag(IndividualFlag defaultProdFlag) {
        this.defaultProdFlag = defaultProdFlag;
    }

    public AcctClass getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(AcctClass acctClass) {
        this.acctClass = acctClass;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}