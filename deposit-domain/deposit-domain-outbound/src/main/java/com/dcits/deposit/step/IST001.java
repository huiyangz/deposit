package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST001InputBO;
import com.dcits.deposit.facade.bo.ST001OutputBO;

/**
 * ST001 检查对手账户凭证状态 步骤接口。
 *
 * <p>按输入账号（baseAcctNo）及凭证挂失状态"A-生效"查询凭证挂失登记簿（凭证挂失信息）：
 * 取得集合非空时步骤业务失败并返回错误码 ER0068；集合为空时检查结果为"通过"、步骤正常完成。</p>
 */
public interface IST001 {

    /**
     * 执行检查对手账户凭证状态。
     *
     * @param input 步骤输入，baseAcctNo 为查询凭证挂失登记簿的定位条件
     * @return 步骤输出：正常完成 succeed=true 且错误字段为 null；业务失败 succeed=false，
     *         errorCode=ER0068、errorMessage=ER0068::账户凭证挂失不能支取
     */
    ST001OutputBO execute(ST001InputBO input);
}
