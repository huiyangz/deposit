package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST116InputBO;
import com.dcits.depsit.facade.bo.ST116OutputBO;

/**
 * ST116 检查是否存在转账止付限制 步骤接口。
 */
public interface IST116 {

    /**
     * 执行步骤：以账号为条件查询生效的限制信息，逐条按其账户限制类型取 A-生效 配置，
     * 判定该账户是否存在转账止付限制，并返回检查结论与命中条的回显。
     *
     * @param input 步骤入参（{@code baseAcctNo} 账号）
     * @return 检查结论（{@code transferStopPayFlag}「是」/「否」）与回显、配置字段
     */
    ST116OutputBO execute(ST116InputBO input);
}
