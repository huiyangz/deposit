package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.Company;
import jakarta.validation.constraints.NotNull;

public class MbBranchProdEO {
    /** 归属机构号 */
    @NotNull
    private AcctBranch branch;
    /** 产品类型 */
    @NotNull
    private String prodType;
    /** 产品描述 */
    private String prodDesc;
    /** 法人 */
    @NotNull
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
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