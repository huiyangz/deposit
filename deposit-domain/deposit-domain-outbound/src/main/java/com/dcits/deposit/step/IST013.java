package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST013InputBO;
import com.dcits.deposit.facade.bo.ST013OutputBO;

/**
 * ST013 检查对手客户黑名单 步骤接口。
 *
 * <p>交易执行步骤：按{对手客户号}查询【客户证件信息】、按{凭证类型}查询【凭证信息】、
 * 赋值[事件类型]为「CRET」后，以输入及前序步骤取值按组件内步骤调用方式调用本组件内步骤
 * ST036「检查黑名单」获取[执行结果]；按[执行结果]分派：「通过/提醒」返回检查结果「通过」，
 * 「授权」返回授权标志「是」并等待授权结果后再执行后续步骤，「拒绝」返回错误码 ER0003。</p>
 */
public interface IST013 {

    /**
     * 执行检查对手客户黑名单步骤。
     *
     * @param input 步骤输入
     * @return 步骤输出（succeed=true、errorCode/errorMessage 为空为检查结果「通过」；
     *     「授权」输出授权标志「是」，「拒绝」返回 succeed=false 及错误码 ER0003）
     */
    ST013OutputBO execute(ST013InputBO input);
}
