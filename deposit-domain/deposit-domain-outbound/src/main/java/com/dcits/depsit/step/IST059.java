package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST059InputBO;
import com.dcits.depsit.facade.bo.ST059OutputBO;

/**
 * ST059 设置借记交易的借贷标志 步骤接口。
 *
 * <p>步骤行为：执行本步骤时把交易上下文中的借贷标志赋值为常量“D-借方”，供后续步骤按借贷方向使用。
 * 本步骤无入参、无数据查询、无组件内步骤调用与外部服务调用；不定义业务失败场景，失败仅由技术异常
 * 向外传播表达，故本接口无事务要求。</p>
 */
public interface IST059 {

    /**
     * 执行「设置借记交易的借贷标志」步骤。
     *
     * @param input 步骤输入，本步骤无业务入参，按原样传入即可
     * @return 步骤输出，其中 {@code crDrInd} 取值为 D-借方
     */
    ST059OutputBO execute(ST059InputBO input);
}
