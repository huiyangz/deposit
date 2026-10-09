package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST129InputBO;
import com.dcits.depsit.facade.bo.ST129OutputBO;

/**
 * ST129 检查增加限制起始日期 步骤接口。
 *
 * <p>依据上送的开始日期与系统日期、结束日期的先后关系，判定增加限制的起始日期是否可接受：
 * startDate 早于 runDate 或晚于 endDate 时返回检查结果「不通过」，二者均不成立时返回「通过」。</p>
 *
 * <p>本步骤为纯入参判定（只读），无本地数据写入、无组件内步骤／规则／外部服务调用，
 * 不要求调用方提供事务；技术异常由上层统一处理。</p>
 */
public interface IST129 {

    /**
     * 执行检查。
     *
     * @param input 判定入参（startDate、runDate、endDate 均为必填的具体时点值）
     * @return 检查结果由 {@link com.dcits.common.step.StepResult#isSucceed()} 承载：
     *         true＝「通过」、false＝「不通过」；本步骤不设置错误码
     */
    ST129OutputBO execute(ST129InputBO input);
}
