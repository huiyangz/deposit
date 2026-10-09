package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST086InputBO;
import com.dcits.depsit.facade.bo.ST086OutputBO;

/**
 * ST086 设置账户开户日期 步骤接口。
 *
 * <p>以唯一输入 {@code runDate}（核心运行日期）为 [系统日期] 的取值来源，步骤 1「获取系统日期」
 * 赋值 [系统日期] = {@code runDate}，步骤 2「设置账户开户日期」赋值并返回
 * [账户开户日期] = [系统日期]，即输出字段 {@code acctOpenDate} 与入参 {@code runDate} 表示同一时间点。
 *
 * <p>本步骤为无状态赋值，不查询账户/产品/机构实体与系统日期表、不调用 BCC/Mapper/外部接口/其它组件步骤、
 * 不产生任何写入，因此调用方无需为其开启事务。
 *
 * <p>本步骤无业务失败场景（源需求「## 失败处理」），失败仅由技术异常按工程既有方式向上传播。
 */
public interface IST086 {

    /**
     * 执行设置账户开户日期。
     *
     * @param input 核心运行日期（{@code runDate}，类型 {@code java.util.Date}，必填），
     *              作为步骤描述中 [系统日期] 的取值来源
     * @return 步骤结果：正常完成时 {@code succeed = true}、{@code errorCode} 与 {@code errorMessage}
     *         均为 {@code null}，业务输出 {@code acctOpenDate} 与入参 {@code runDate} 逐位相等
     *         （含时、分、秒、毫秒，不做归一化、截断或时区转换）
     */
    ST086OutputBO execute(ST086InputBO input);
}
