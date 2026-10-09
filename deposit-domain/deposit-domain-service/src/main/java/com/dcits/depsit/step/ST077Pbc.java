package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST077InputBO;
import com.dcits.depsit.facade.bo.ST077OutputBO;
import org.springframework.stereotype.Service;

/**
 * ST077 检查利率浮动类型 步骤实现。
 *
 * <p>按源需求「步骤描述」第 1 条实现单条互斥分支判定：统计账户固定利率（{@code acctFixedRate}）、
 * 账户利率浮动百分比（{@code acctPercentRate}）、账户利率浮动百分点（{@code acctSpreadRate}）
 * 三个入参中「不为空」的个数——个数等于 1 时返回检查结果「通过」（{@code succeed} 为 true，
 * 错误字段保持 null）；个数为 0、2 或 3 时返回错误码 {@code ER0032}。</p>
 *
 * <p>「空」的唯一判据是入参未上送（值为 {@code null}）；已上送的 {@code 0}、{@code 0.00}、负值等
 * 一律计为「非空」，与数值大小、正负号、标度无关，本步骤不对入参做舍入、截断或精度规整，
 * 也不修改入参取值。判定域内 8 种非空/空组合全部落入上述两条分支，不存在无结果的组合。</p>
 *
 * <p>本步骤为无状态只读检查：不访问 BCC、Mapper、数据库或外部接口，不涉及组件内步骤调用与跨组件调用，
 * 不产生数据变更，故不加 {@code @Transactional}。</p>
 */
@Service
public class ST077Pbc implements IST077 {

    /** 三个利率字段非空个数不为 1 时的错误码，取自 errorcodes.properties 第 32 行 */
    private static final String ERROR_CODE_ER0032 = "ER0032";

    /** 错误码 ER0032 对应的业务说明，格式为「错误码::业务说明」 */
    private static final String ERROR_MESSAGE_ER0032 =
            "ER0032::账户利率浮动百分点，账户利率浮动百分比，账户固定利率只能上送一个";

    @Override
    public ST077OutputBO execute(ST077InputBO input) {
        ST077OutputBO output = new ST077OutputBO();

        // 单条判定：统计三个入参中不为空（非 null）的个数，三个入参作用对等
        int notEmptyCount = 0;
        if (input.getAcctFixedRate() != null) {
            notEmptyCount++;
        }
        if (input.getAcctPercentRate() != null) {
            notEmptyCount++;
        }
        if (input.getAcctSpreadRate() != null) {
            notEmptyCount++;
        }

        if (notEmptyCount == 1) {
            // 「若」分支：三者只有一个不为空 → 检查结果为「通过」，不产出错误码
            output.setSucceed(true);
            return output;
        }

        // 「否则」分支：非空个数为 0、2 或 3 → 产出错误码 ER0032，不产出检查结果「通过」
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_ER0032);
        output.setErrorMessage(ERROR_MESSAGE_ER0032);
        return output;
    }
}
