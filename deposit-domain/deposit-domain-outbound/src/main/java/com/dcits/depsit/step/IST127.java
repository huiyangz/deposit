package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST127InputBO;
import com.dcits.depsit.facade.bo.ST127OutputBO;

/**
 * ST127 检查限制类型 步骤接口。
 *
 * <p>以 {限制类型}（{@code restraintType}）为查询键查询【限制类型定义表】取得 [限制类型信息]，
 * 随后判定其存在性与 $状态$，返回检查结果「通过」或「不通过」。</p>
 *
 * <p>本步骤为只读步骤：不新增、修改或删除任何数据，不调用其它步骤、规则或外部服务，
 * 无事务要求。</p>
 */
public interface IST127 {

    /**
     * 执行检查限制类型。
     *
     * <p>检查结果由返回对象的 {@code succeed} 表达：true 为「通过」，false 为「不通过」；
     * 两条结论互斥，均不产出错误码，错误字段保持 null。</p>
     *
     * @param input 步骤输入：{@code restraintType}（账户限制类型，必填，查询键）与
     *              {@code status}（状态，必填，判定取值取自查询所得记录的同名字段）
     * @return ST127OutputBO 检查结果
     */
    ST127OutputBO execute(ST127InputBO input);
}
