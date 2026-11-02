package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;

/**
 * ST046 更新累计限额 步骤接口。
 *
 * <p>在[限额检查结果]为"未超限"且（[限额累计金额]大于0 或 [限额累计笔数]大于0）时，
 * 根据{账号}将【限额累计信息表】（RB_LIMIT_SUM_INFO）记录的累计限额（LIMIT_SUM_AMT）
 * 更新为[限额累计金额]；任一条件不成立时不执行更新，步骤正常完成、不产生业务失败。</p>
 *
 * <p>事务要求：触发条件成立时本步骤会对本地数据库 RB_LIMIT_SUM_INFO 执行更新，
 * 调用方应在事务上下文中调用；实现类 execute 已标注 Spring {@code @Transactional}。</p>
 */
public interface IST046 {

    /**
     * 更新累计限额。
     *
     * @param input 步骤输入（限额检查结果、账号、限额场景编码、客户号、限额累计金额、限额累计笔数）
     * @return 步骤结果，正常完成或正常提前结束时 succeed=true 且 errorCode、errorMessage 为 null
     */
    ST046OutputBO execute(ST046InputBO input);
}
