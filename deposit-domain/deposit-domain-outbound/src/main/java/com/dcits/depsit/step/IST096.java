package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST096InputBO;
import com.dcits.depsit.facade.bo.ST096OutputBO;

/**
 * ST096 设置账户执行利率 步骤接口。
 *
 * <p>以唯一必填入参 {@code realRate}（执行利率）为取值来源，将账户的「执行利率」属性赋值为
 * {@code realRate}，并以输出字段 {@code realRate} 返回该取值（REQ-001、REQ-002）。
 * 该赋值为单条无条件赋值：无判定条件、无分支、无重复或条件触发，也无子步骤编排与跳转。</p>
 *
 * <p>本步骤不查询实体、不调用 BCC／Mapper／数据库／外部接口／其它组件步骤、不产生本地写入，
 * 因此<b>不要求调用方开启事务</b>；赋值目标的落库实体与字段源需求未声明（Spec 不覆盖事项 1），
 * 本步骤不指定落库位置，取值经输出字段承载。</p>
 *
 * <p>执行成功时返回结果 {@code succeed = true}，{@code errorCode} 与 {@code errorMessage} 均为 {@code null}。
 * 源需求「## 失败处理」声明本步骤无业务失败场景，失败仅由技术异常按工程既有方式向上传播。</p>
 */
public interface IST096 {

    /**
     * 执行「设置账户执行利率」。
     *
     * @param input 步骤输入，唯一字段 {@code realRate}（执行利率，类型 {@code java.math.BigDecimal}，必填），
     *              作为账户执行利率属性的赋值来源
     * @return 步骤输出，正常完成时 {@code succeed = true}、{@code errorCode} 与 {@code errorMessage}
     *         均为 {@code null}，业务字段 {@code realRate} 取值与入参 {@code realRate} 数值相同
     *         （不做取整、舍入或按标度缩放，Spec 不覆盖事项 4）
     */
    ST096OutputBO execute(ST096InputBO input);
}
