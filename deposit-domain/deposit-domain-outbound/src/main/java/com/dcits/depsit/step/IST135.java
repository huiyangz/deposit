package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST135InputBO;
import com.dcits.depsit.facade.bo.ST135OutputBO;

/**
 * ST135 更新账户手工解限限制状态 步骤接口。
 *
 * <p>本步骤只有一次按限制编号的更新写操作（对公存款账户限制表 RB_BUS_RESTRAINTS），
 * 实现方法涉及本地数据库更新，调用方需为其提供事务边界（Spring 事务上下文）。</p>
 */
public interface IST135 {

    /**
     * 执行更新账户手工解限限制状态。
     *
     * @param input 限制编号（{@code resSeqNo}）与客户号（{@code clientNo}）
     * @return 更新结果；成功时 {@code succeed=true}、错误字段为 {@code null}，
     *         且 {@code restraintsStatus} 为本次写入的 {@code RestraintsStatus.E}（"E-失效"）
     */
    ST135OutputBO execute(ST135InputBO input);
}
