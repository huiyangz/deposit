package com.dcits.depsit.facade.bo;

/**
 * ST106 获取累计限额 输入 BO。
 *
 * <p>字段名、类型与「必填」标记照录 Spec「### 输入」表：三个输入均为 {@code java.lang.String}
 * 且均为必填。{账号} 绑定到 {@code baseAcctNo}、[限额场景编码] 绑定到 {@code limitSceneNo}。</p>
 *
 * <p>「来源实体」列按 Spec 照录，本步骤不因该列示发起对「对公存款账户限制表（RB_BUS_RESTRAINTS）」
 * 的读取或校验。</p>
 */
public class ST106InputBO {

    /** 账号（来源实体：对公存款账户限制表 RB_BUS_RESTRAINTS）——步骤描述中的 {账号}，作为限额检查对象值 */
    private String baseAcctNo;

    /** 客户号（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO）——步骤描述未使用，不参与定位 */
    private String clientNo;

    /** 限额场景编码（来源实体：限额累计信息表 RB_LIMIT_SUM_INFO）——步骤描述中的 [限额场景编码] */
    private String limitSceneNo;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }
}
