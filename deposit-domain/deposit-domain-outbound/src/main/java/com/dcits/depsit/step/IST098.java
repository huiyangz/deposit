package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST098InputBO;
import com.dcits.depsit.facade.bo.ST098OutputBO;

/**
 * ST098 检查账户用途 步骤接口。
 *
 * <p>以四个输入（{@code rbBusAcctPurpose} 对公存款账户用途、{@code acctCcy} 账户币种、
 * {@code apprLetterNo} 核准件编号、{@code acctNatureNo} 账户属性）按「子步骤 1 → 子步骤 2 →
 * 子步骤 3 分派 → 子步骤 4／5／6 之一」的次序执行检查：子步骤 1、2 只对「账户币种为人民币且账户用途
 * 为资本项下」的账户生效，分别为核准件编号为空返回 {@code ER0012}、账户属性为空返回 {@code ER0013}；
 * 子步骤 3 按账户属性分派到子步骤 4（基本存款账户／一般户）、子步骤 5（验资户）、子步骤 6
 * （专用存款账户），账户属性为其四类以外的其它取值或为空时直接返回检查结果为「通过」；
 * 子步骤 4／5／6 判定不通过时分别返回 {@code ER0014}／{@code ER0015}／{@code ER0016}。</p>
 *
 * <p>任一子步骤命中错误码即以该码结束本步骤、不执行后续子步骤，同一输入组合只返回一个结果；
 * 「通过」由 {@code succeed = true} 且两个错误字段为空承载，错误码分支由 {@code succeed = false}
 * 且 {@code errorCode} 承载。</p>
 *
 * <p>本步骤为无状态纯判断的只读检查，不读取账户、产品、机构或任何实体数据，不发起 BCC、Mapper、
 * 数据库、规则或跨组件调用，不产生任何副作用，因此不要求调用方提供事务。技术异常按技术异常向上传播，
 * 不转换为上述已定义的业务结果。</p>
 */
public interface IST098 {

    /**
     * 执行「检查账户用途」。
     *
     * @param input 步骤输入，含对公存款账户用途 {@code rbBusAcctPurpose}、账户币种 {@code acctCcy}、
     *              核准件编号 {@code apprLetterNo}、账户属性 {@code acctNatureNo}
     * @return 步骤输出；检查结果为「通过」时 {@code succeed = true} 且两个错误字段为空；
     *         命中错误时为 {@code succeed = false} 且 {@code errorCode} 为 {@code "ER0012"}～{@code "ER0016"}
     *         中对应的一个
     */
    ST098OutputBO execute(ST098InputBO input);
}
