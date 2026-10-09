package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST077InputBO;
import com.dcits.depsit.facade.bo.ST077OutputBO;

/**
 * ST077 检查利率浮动类型 步骤接口。
 *
 * <p>检查上送的账户固定利率、账户利率浮动百分比、账户利率浮动百分点三者中「不为空」的个数是否为 1：
 * 恰有 1 个不为空时返回检查结果「通过」（{@code succeed} 为 true，错误字段为 null）；
 * 不为空个数为 0、2 或 3 时返回错误码 {@code ER0032}（{@code succeed} 为 false）。</p>
 *
 * <p>本步骤为只读检查，不产生任何数据变更，无 BCC、EO、规则、组件内步骤或跨组件调用，
 * 调用方无需为其提供事务。</p>
 */
public interface IST077 {

    /**
     * 执行利率浮动信息必输性检查。
     *
     * @param input 步骤输入，三个利率字段均非必填，未上送即为 {@code null}
     * @return 步骤执行结果；检查通过时 {@code succeed} 为 true 且错误字段为 null，
     *         否则 {@code succeed} 为 false 且 {@code errorCode} 为 {@code ER0032}
     */
    ST077OutputBO execute(ST077InputBO input);
}
