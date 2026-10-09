package com.dcits.depsit.facade.bo;

/**
 * ST135 更新账户手工解限限制状态 输入 BO。
 *
 * <p>字段照录正式 Spec「## 输入」表：{@code resSeqNo}（限制编号，{@code java.lang.String}，必填，
 * 来源实体 对公存款账户限制表 RB_BUS_RESTRAINTS）与 {@code clientNo}（客户号，{@code java.lang.String}，
 * 必填，来源实体 客户副本表 FM_CLIENT_COPY）。步骤描述中的 {限制编号} 绑定到 {@code resSeqNo}，
 * 也是本步骤更新的定位条件（该表主键 RES_SEQ_NO）。</p>
 *
 * <p>{@code clientNo} 在步骤描述中未被引用，本 BO 只作为入参清单列示，不为其假定用途，
 * 不生成取数、校验或过滤动作（Spec REQ-002 与「验收范围与明确不覆盖的事项」第 3 项）。</p>
 */
public class ST135InputBO {

    /** 限制编号：{限制编号} 的绑定目标，本步骤更新的定位条件（RB_BUS_RESTRAINTS 主键） */
    private String resSeqNo;

    /** 客户号：输入清单列示项，不参与本步骤的更新行为 */
    private String clientNo;

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }
}
