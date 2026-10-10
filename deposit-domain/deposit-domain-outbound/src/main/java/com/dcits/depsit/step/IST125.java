package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST125InputBO;
import com.dcits.depsit.facade.bo.ST125OutputBO;

/**
 * ST125 检查是否存在属性限制 步骤接口。
 */
public interface IST125 {

    /**
     * 执行步骤：以 {@code baseAcctNo} 为查询键只读查询【账户限制信息表】（限制状态码值 A 且限制级别码值 NATURE），
     * 未查到记录时四项回显为空值、查得多条时按限制编号升序取第一条回显，随后以 [账户限制信息] 是否为空
     * 返回 [属性限制标志]「否」或「是」。
     *
     * <p>本步骤无业务失败场景，失败仅由技术异常传播表达，不需要调用方提供事务。</p>
     *
     * @param input 步骤输入，仅含 {@code baseAcctNo}（账号，必填）
     * @return 步骤输出，含 {@code natureRestraintFlag} 与四个回显字段
     */
    ST125OutputBO execute(ST125InputBO input);
}
