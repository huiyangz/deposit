package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST035InputBO;
import com.dcits.deposit.facade.bo.ST035OutputBO;

/**
 * ST035 检查支取账户黑名单 步骤接口。
 *
 * <p>交易执行步骤：第 1 步按{凭证类型}查询【凭证信息】（凭证类型定义表，TB_VOUCHER_DEF）
 * 获取$凭证种类$；第 2 步赋值[事件类型]为「DEBT」；第 3 步按{账号}、{交易机构}、
 * {交易类型}、[事件类型]、{服务代码}、{接口服务代码}、{接口服务类型}、{渠道类型}、
 * [凭证种类]九个参数调用组件内步骤 ST036「检查黑名单」，取得[执行结果]；第 4 步按
 * [执行结果]分支：通过/提醒→继续执行、授权→返回授权标志为「是」、拒绝→返回错误码
 * {@code ER0057}。</p>
 */
public interface IST035 {

    /**
     * 执行检查支取账户黑名单步骤。
     *
     * @param input 步骤输入（9 个字段：clientNo、docType、baseAcctNo、tranBranch、
     *     tranType、serviceCode、messageCode、messageType、sourceType）
     * @return 步骤输出（succeed=true、errorCode/errorMessage 均为 null 为正常结束；
     *     执行结果为「拒绝」时 succeed=false、errorCode=ER0057、errorMessage 为
     *     {@code ER0057::黑名单账户，拒绝交易}）
     */
    ST035OutputBO execute(ST035InputBO input);
}
