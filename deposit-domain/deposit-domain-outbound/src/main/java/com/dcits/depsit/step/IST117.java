package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST117InputBO;
import com.dcits.depsit.facade.bo.ST117OutputBO;

/**
 * ST117 检查质押类限制。
 *
 * <p>以入参账号 + 限制状态码值 "A" 查询【账户限制信息】（{@code RB_BUS_RESTRAINTS}），
 * 逐条按其账户限制类型到【限制类型表】（{@code RB_RESTRAINT_TYPE}）取状态码值为 "A" 的配置，
 * 按该配置的质押标志是否表示存在质押判定（该列的「码值-含义」标志口径：{@code "Y"}＝是 表示存在质押、
 * {@code "N"}＝否 不表示，空值与两项约定码值之外的其它取值按不表示处理）：任一条表示存在质押时把该
 * 配置记录的质押标志取值原样取作 [质押标志]（{@code pledgedFlag}）返回；未查询到生效限制记录、或
 * 全部记录均不表示存在质押（含限制类型无 A-生效 配置）时 [质押标志] 不赋值。</p>
 *
 * <p>本步骤只读，不写库、不修改任何账户或限制数据；无业务失败场景，依赖的数据访问异常按技术异常向上传播。</p>
 */
public interface IST117 {

    /**
     * 执行步骤。
     *
     * @param input 入参，账号（baseAcctNo）必填
     * @return 出参：质押标志及命中记录的回显字段
     */
    ST117OutputBO execute(ST117InputBO input);
}
