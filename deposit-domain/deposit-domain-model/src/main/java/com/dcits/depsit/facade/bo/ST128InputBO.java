package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.TranBranch;

/**
 * ST128 检查是否跨法人 输入 BO。
 *
 * <p>两个输入均必填，且均被使用：{@code baseAcctNo} 作为子步骤 1 查询【账户信息】的定位条件，
 * {@code branch} 作为子步骤 2 查询【机构信息表】的定位条件。任输入取值为空的行为源需求未定义，
 * 本步骤不作校验。</p>
 */
public class ST128InputBO {

    /** 账号（必填）；子步骤 1 查询【账户信息】的定位条件，语义上唯一确定一条账户记录 */
    private String baseAcctNo;

    /** 归属机构号（必填，步骤描述中称「交易机构」）；子步骤 2 查询【机构信息表】的定位条件 */
    private TranBranch branch;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }
}
