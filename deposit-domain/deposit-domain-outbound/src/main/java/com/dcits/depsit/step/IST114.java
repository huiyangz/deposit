package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST114InputBO;
import com.dcits.depsit.facade.bo.ST114OutputBO;

/**
 * ST114 检查转账止收限制。
 *
 * <p>以账号为入口，查询该账号下处于「A-生效」状态的账户限制记录，逐条结合【限制类型表】的
 * 「A-生效」配置判断是否构成转账止收限制（借贷方控制标志「C-禁止贷方」且转账标志「N-不允许转账」），
 * 任一条构成即返回转账止收标志「是」，全部不构成返回「否」。</p>
 *
 * <p>本步骤为只读查询，无数据写入与状态变更，无组件内步骤调用、无跳转目标、无外部服务调用；
 * 无业务失败场景，失败仅由技术异常传播表达（REQ-010），无需调用方事务。</p>
 */
public interface IST114 {

    /**
     * 执行检查转账止收限制。
     *
     * @param input 输入（账号）
     * @return 输出（转账止收标志及来源实体回显字段）
     */
    ST114OutputBO execute(ST114InputBO input);
}
