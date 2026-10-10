package com.dcits.depsit.facade.bo;

/**
 * ST125 检查是否存在属性限制 输入 BO。
 *
 * <p>本步骤仅接受 1 个外部入参：{@code baseAcctNo}（账号），作为查询【账户限制信息表】的查询键。</p>
 */
public class ST125InputBO {

    /** 账号：步骤描述中 {账号} 的绑定对象，作为查询【账户限制信息表】的查询键 */
    private String baseAcctNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }
}
