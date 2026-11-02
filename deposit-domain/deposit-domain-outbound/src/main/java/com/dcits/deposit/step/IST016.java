package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST016InputBO;
import com.dcits.deposit.facade.bo.ST016OutputBO;

/**
 * ST016 检查账户客户一致性 步骤接口。
 *
 * <p>比较 clientNo 与 othClientNo：取值一致时判定为同名客户转账，返回错误码 ER0078
 * 使本步骤业务失败（REQ-001）；取值不一致时检查通过、步骤正常结束成功（REQ-002）。</p>
 */
public interface IST016 {

    /**
     * 执行检查账户客户一致性。
     *
     * @param input 步骤输入（clientNo、othClientNo）
     * @return 步骤输出：业务失败时 succeed=false 且 errorCode=ER0078；
     *         检查通过时 succeed=true 且错误字段为空
     */
    ST016OutputBO execute(ST016InputBO input);
}
