package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST110InputBO;
import com.dcits.depsit.facade.bo.ST110OutputBO;

/**
 * ST110 更新累计限额的步骤接口。
 *
 * <p>触发条件成立（限额检查结果为「未超限」且限额累计金额大于 0 或限额累计笔数大于 0）时，
 * 以 {账号} 作为限额检查对象值、连同 {限额场景编码} 定位【限额累计信息表（RB_LIMIT_SUM_INFO）】的记录，
 * 并把该记录的 $累计限额$、$限额累计笔数$ 写回为本次入参；匹配不到记录时不更新本表。
 * 本步骤无业务失败场景，失败仅由技术异常传播表达；触发条件不成立与匹配不到记录两种情形均正常结束
 * （{@code succeed = true}、错误字段为 null）。</p>
 *
 * <p>事务要求：本步骤会更新本地数据库表，调用方 MUST 在事务上下文中调用本方法
 * （实现类 {@code execute} 已声明 Spring {@code @Transactional}）；返回 {@code succeed = false}
 * 不自动回滚，本步骤亦不产生业务失败结论。</p>
 */
public interface IST110 {

    /**
     * 执行更新累计限额。
     *
     * @param input 步骤输入，不可为空
     * @return 步骤输出：正常结束时 {@code succeed = true} 且错误字段为 null；
     *         更新路径下输出 {@code limitSumAmt} 为本次写入的限额累计金额
     */
    ST110OutputBO execute(ST110InputBO input);
}
