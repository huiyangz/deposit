package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST128InputBO;
import com.dcits.depsit.facade.bo.ST128OutputBO;

/**
 * ST128 检查是否跨法人 步骤接口。
 *
 * <p>步骤子步骤 1 → 2 → 3 按序执行：按账号查【账户信息】取账户开立行行号、按其查【机构信息表】取账户法人、
 * 按{交易机构}查【机构信息表】取交易机构法人，比较两者返回检查结果。</p>
 *
 * <p>本步骤只查询、不写入任何实体，调用方无需事务；子步骤 1 的账号查询触发 ER0048 业务失败时短路结束本步骤。</p>
 */
public interface IST128 {

    /**
     * 执行步骤。
     *
     * @param input 账号（{@code baseAcctNo}）与归属机构号（{@code branch}），两者必填
     * @return 检查结果 {@code checkResult}（"通过"/"不通过"）与步骤状态；
     *         账号查询查无或多条时为 {@code succeed=false}、{@code errorCode="ER0048"}，不产出检查结果
     */
    ST128OutputBO execute(ST128InputBO input);
}
