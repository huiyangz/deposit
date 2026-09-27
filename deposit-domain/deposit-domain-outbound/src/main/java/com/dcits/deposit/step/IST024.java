package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST024InputBO;
import com.dcits.deposit.facade.bo.ST024OutputBO;

/**
 * ST024 更新现金存入后现金尾箱
 *
 * <p>事务要求：本步骤包含尾箱现金余额表更新，实现方法带 @Transactional，
 * 在本地数据库事务内执行，由调用方在事务边界内调用。
 */
public interface IST024 {

    /**
     * 更新现金存入后现金尾箱。
     *
     * @param input 输入BO，assignUserId、tailboxProperty、tranAmt 均必填
     * @return 输出BO：tailboxId 为子步骤1查询获得的尾箱编号，tailboxBalance 为更新后的尾箱现金余额；
     *         本步骤无业务失败场景，失败仅由技术异常传播表达
     */
    ST024OutputBO execute(ST024InputBO input);
}
