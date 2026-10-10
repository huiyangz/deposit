package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST104InputBO;
import com.dcits.depsit.facade.bo.ST104OutputBO;

/**
 * ST104 检查限额 步骤接口。
 *
 * <p>以 [限额场景编码]（入参 {@code limitSceneNo}）为条件查询【限额控制配置(RB_LIMIT_CTRL_CONF)】，
 * 取得该场景对应的 [限额控制金额]（{@code limitCtrlAmt}）与 [限额控制笔数]（{@code limitCtrlNum}）；
 * 再以 [限额累计金额]（入参 {@code limitSumAmt}）与 [限额累计笔数]（入参 {@code limitSumNum}）
 * 分别与两个控制值作严格「大于」比较，任一维度超出即返回限额检查结果为「超限」，否则为「未超限」；
 * [限额控制金额] 为空时不比较金额维度、[限额控制笔数] 为空时不比较笔数维度，两者都为空时返回「未超限」。</p>
 *
 * <p>本步骤为纯读取步骤，不新增、修改或删除本地数据库记录，因此不要求调用方提供事务；
 * 本步骤无业务失败场景，正常结束时 {@code succeed = true} 且两个错误字段为空，失败仅由技术异常
 * 向外传播表达，调用方按技术异常处理。</p>
 *
 * <p>【限额控制配置】的定位口径（同一[限额场景编码]查到多条时的取值、查无记录时的处理）与
 * 累计值（必填输入）取到空值时的行为均属 Spec「验收范围与明确不覆盖的事项」的放行／未定义事项，
 * 本接口不为其声明业务契约。</p>
 */
public interface IST104 {

    /**
     * 执行「检查限额」。
     *
     * @param input 步骤输入，含限额场景编码 {@code limitSceneNo}、限额累计金额 {@code limitSumAmt}、
     *              限额累计笔数 {@code limitSumNum}
     * @return 步骤输出；正常结束时 {@code succeed = true} 且错误字段为空，检查结论经
     *         {@code limitCheckResult}（字面值「超限」／「未超限」）交付
     */
    ST104OutputBO execute(ST104InputBO input);
}
