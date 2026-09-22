package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IntBasis;
import jakarta.validation.constraints.NotNull;

public class MbIntBasisEO {
    /** 基准利率类型 */
    @NotNull
    private IntBasis intBasis;
    /** 基准利率类型描述 */
    private String intBasisDesc;
    /** 客户号 */
    private String clientNo;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public IntBasis getIntBasis() {
        return intBasis;
    }

    public void setIntBasis(IntBasis intBasis) {
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