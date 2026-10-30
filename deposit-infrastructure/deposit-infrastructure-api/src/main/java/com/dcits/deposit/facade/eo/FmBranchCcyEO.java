package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;

public class FmBranchCcyEO {
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 归属机构号 */
    @NotNull
    private TranBranch branch;
    /** 币种 */
    @NotNull
    private Ccy ccy;

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }

    public Ccy getCcy() {
        return ccy;
    }

    public void setCcy(Ccy ccy) {
        this.ccy = ccy;
    }
}