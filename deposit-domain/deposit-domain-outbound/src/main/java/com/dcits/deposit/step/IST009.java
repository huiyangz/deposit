package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST009InputBO;
import com.dcits.deposit.facade.bo.ST009OutputBO;

/**
 * ST009 检查支取客户黑名单 步骤接口。
 *
 * <p>交易执行步骤：按{客户号}查询客户证件信息、按{凭证类型}查询凭证种类、赋值
 * [事件类型]为"DEBT"、按 14 项参数调用组件内步骤 ST036「检查黑名单」获取[执行结果]、
 * 按[执行结果]分支返回（「通过/提醒」正常结束、「授权」设置[授权标志]="是"、
 * 「拒绝」业务失败返回错误码"ER0003"）。</p>
 */
public interface IST009 {

    /**
     * 执行检查支取客户黑名单步骤。
     *
     * @param input 步骤输入
     * @return 步骤输出（succeed=true、errorCode/errorMessage 为空为正常结束；
     *     「拒绝」时 succeed=false、errorCode="ER0003"）
     */
    ST009OutputBO execute(ST009InputBO input);
}
