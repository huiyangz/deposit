package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST108InputBO;
import com.dcits.depsit.facade.bo.ST108OutputBO;

/**
 * ST108 登记累计限额 步骤接口。
 *
 * <p>本步骤为交易执行步骤中的登记类步骤，正文只有 1 个平铺步骤，无分支跳转、无循环、无组件内步骤调用。
 * 当[限额检查结果]为「未超限」且（[限额累计金额]等于 0 或[限额累计笔数]等于 0）时，把本次交易的限额
 * 累计信息登记到【限额累计信息表（RB_LIMIT_SUM_INFO）】；条件不成立时不登记，仍按正常结果返回。</p>
 *
 * <p>事务：本步骤会向【限额累计信息表（RB_LIMIT_SUM_INFO）】新增记录，实现以 Spring
 * {@code @Transactional} 标注，调用方应在事务中调用 {@link #execute(ST108InputBO)}；本步骤
 * 不产生业务失败结果（无业务错误码），失败仅由技术异常向上传播表达。</p>
 */
public interface IST108 {

    /**
     * 执行「登记累计限额」。
     *
     * @param input 步骤输入，字段契约见 {@link ST108InputBO}
     * @return 步骤结果与业务输出，正常完成时 succeed 为 true、errorCode 与 errorMessage 为 null；
     *         条件不成立而未登记时同样为成功状态
     */
    ST108OutputBO execute(ST108InputBO input);
}
