package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST044InputBO;
import com.dcits.depsit.facade.bo.ST044OutputBO;

/**
 * ST044 检查账户存在性 步骤接口。
 *
 * <p>业务行为：先按入参账号查询【账户信息】，再据其是否存在给出检查结论——不存在时返回错误码
 * {@code ER0048}，存在时返回检查结果为「通过」。本步骤为只读检查，不新增、修改或删除任何数据，
 * 因此不要求调用方提供事务；调用方无需为本次调用开启或传播事务。</p>
 */
public interface IST044 {

    /**
     * 执行「检查账户存在性」步骤。
     *
     * @param input 步骤输入，其中 {@code baseAcctNo} 为必填账号
     * @return 步骤结果：{@code succeed = true} 表示检查结果为「通过」；
     *         {@code succeed = false} 且 {@code errorCode = "ER0048"} 表示 [账户信息] 不存在
     */
    ST044OutputBO execute(ST044InputBO input);
}
