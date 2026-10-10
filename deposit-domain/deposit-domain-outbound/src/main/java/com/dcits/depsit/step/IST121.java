package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST121InputBO;
import com.dcits.depsit.facade.bo.ST121OutputBO;

/**
 * ST121 检查限制优先级 步骤接口。
 *
 * <p>子步骤 1 按 {交易类型}（{@code tranType}）查询【交易定义信息】取得交易的冻结级别；
 * 子步骤 2 按 {账户限制类型}（{@code restraintType}）查询【限制类型定义信息】取得限制的冻结级别；
 * 子步骤 3 比较两个冻结级别，返回检查结果「不检查限制」或「继续检查」。</p>
 *
 * <p>本步骤为只读步骤：只执行两次按主键查询与一次取值比较，不新增、修改或删除任何数据，
 * 不调用其它步骤或外部服务，无事务要求。</p>
 */
public interface IST121 {

    /**
     * 执行检查限制优先级。
     *
     * <p>检查结果由返回对象的 {@code checkResult} 承载：交易的冻结级别高于限制类型对应的冻结级别时为
     * 「不检查限制」，否则（含两者相等、交易侧较低，以及任一冻结级别取不到值）为「继续检查」。
     * 两个冻结级别输出字段在取值取到时回显、取不到值时为空。</p>
     *
     * <p>本步骤无业务失败场景，{@code succeed} 恒为 true，错误码与错误信息保持 null；
     * 技术异常按框架向上传播。</p>
     *
     * @param input 步骤输入：{@code tranType}（交易类型，必填）、{@code restraintType}（账户限制类型，必填）
     * @return ST121OutputBO 检查结果（{@code checkResult}、{@code tranResPriority}、{@code restraintResPriority}）
     */
    ST121OutputBO execute(ST121InputBO input);
}
