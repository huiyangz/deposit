package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST065InputBO;
import com.dcits.depsit.facade.bo.ST065OutputBO;

/**
 * ST065 检查分位金额 步骤接口。
 *
 * <p>本步骤为只读检查：先按预设参数 LIMIT_CENT_AMT 取数取得「分位处理金额分位上限」，
 * 再以其为界判定「分位金额」是否超出；超出返回错误码 ER0069，未超出返回检查结果为「通过」。
 * 除步骤1 的一次只读参数查询外不发起其它调用，不产生数据写入，
 * 故本接口不要求调用方提供事务上下文。</p>
 */
public interface IST065 {

    /**
     * 执行检查分位金额。
     *
     * @param input ST065 输入 BO，含「分位金额」（BigDecimal，必填）与「分位处理金额分位上限」（String，必填）
     * @return ST065 输出 BO：判定通过时 {@code isSucceed()==true} 且错误字段为 null，paraValue 为取数所得参数值；
     *         分位金额大于上限时 {@code isSucceed()==false} 且 errorCode 为 ER0069
     */
    ST065OutputBO execute(ST065InputBO input);
}
