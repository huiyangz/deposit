package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST034InputBO;
import com.dcits.deposit.facade.bo.ST034OutputBO;

/**
 * ST034 设置免费账户标志 步骤接口
 *
 * <p>获取客户的结算账户与产品的账户类型，客户名下无结算账户且产品账户类型为
 * "C-结算账户"时免收费标志设为"是"，否则设为"否"。
 *
 * <p>本步骤仅含本地实体查询与产品信息外部查询，无本地数据库写操作，不要求事务。
 */
public interface IST034 {

    /**
     * 设置免费账户标志。
     *
     * @param input 步骤输入：客户号、存款账户类型、产品编号
     * @return 免收费标志；本步骤无业务失败场景，失败仅由技术异常传播表达
     */
    ST034OutputBO execute(ST034InputBO input);
}
