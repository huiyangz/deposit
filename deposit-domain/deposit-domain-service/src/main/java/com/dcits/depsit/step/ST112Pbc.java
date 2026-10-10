package com.dcits.depsit.step;

import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST112InputBO;
import com.dcits.depsit.facade.bo.ST112OutputBO;
import com.dcits.depsit.facade.components.IFmChannelBcc;
import com.dcits.depsit.facade.components.IRbRestraintControlDetailsBcc;
import com.dcits.depsit.facade.eo.FmChannelEO;
import com.dcits.depsit.facade.eo.RbRestraintControlDetailsEO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * ST112 检查限制豁免（检查类）。
 *
 * <p>以 sourceType（渠道类型）、restraintType（账户限制类型）、tranType（交易类型）、
 * narrativeCode（摘要码）、prodType（产品类型）五个必填入参为输入：先按渠道类型从
 * 【渠道类型定义表】取该渠道的柜面标志，再按账户限制类型从【限制控制明细表】取状态为
 * {@code "A"} 的 [限制控制明细信息] 并汇总出账户限制类型对应的柜面标志；两个柜面标志
 * 同时为 {@code "Y"} 时进入子步骤《检查柜面渠道的豁免信息》（子步骤 4），否则进入子步骤
 * 《检查非柜面渠道的豁免信息》（子步骤 5），由 [限制控制明细信息] 中是否存在 tranType、
 * narrativeCode、prodType 三字段同时匹配的记录分别返回检查结果四种规范常量之一。</p>
 *
 * <p>码值口径：状态取 {@code "A"}，两个柜面标志取 {@code "Y"}／{@code "N"}，均按码值
 * 判定。子步骤 1 未匹配到渠道记录时 [渠道的柜面标志] 按 {@code "N"} 处理，不失败。</p>
 *
 * <p>检查结果（「不检查限制」「需检查限制」「豁免」「不豁免」）的承载字段与落库位置源需求
 * 未声明（Spec「验收范围与明确不覆盖的事项」第 2 项），且 REQ-008 要求不产出 7 个回显字段
 * 之外的数据，故本实现只在本步骤内取到该结论并记录日志，不写入输出。</p>
 *
 * <p>本步骤两处查询均为只读操作，不产生任何业务数据变更，无业务失败场景（失败仅由技术异常
 * 传播表达），故不加事务、不设置错误码。</p>
 */
@Service
public class ST112Pbc implements IST112 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ST112Pbc.class);

    /** 柜面标志取值：是。 */
    private static final String COUNTER_FLAG_YES = "Y";

    /** 柜面标志取值：否（渠道查不到记录时亦按该值处理）。 */
    private static final String COUNTER_FLAG_NO = "N";

    /** 检查结果：不检查限制（子步骤 4 命中三字段同时匹配的记录）。 */
    private static final String CHECK_RESULT_NO_CHECK = "不检查限制";

    /** 检查结果：需检查限制（子步骤 4 未命中三字段同时匹配的记录）。 */
    private static final String CHECK_RESULT_NEED_CHECK = "需检查限制";

    /** 检查结果：豁免（子步骤 5 命中三字段同时匹配的记录）。 */
    private static final String CHECK_RESULT_EXEMPT = "豁免";

    /** 检查结果：不豁免（子步骤 5 未命中三字段同时匹配的记录，含集合为空）。 */
    private static final String CHECK_RESULT_NOT_EXEMPT = "不豁免";

    private final IFmChannelBcc fmChannelBcc;

    private final IRbRestraintControlDetailsBcc rbRestraintControlDetailsBcc;

    public ST112Pbc(IFmChannelBcc fmChannelBcc, IRbRestraintControlDetailsBcc rbRestraintControlDetailsBcc) {
        this.fmChannelBcc = fmChannelBcc;
        this.rbRestraintControlDetailsBcc = rbRestraintControlDetailsBcc;
    }

    @Override
    public ST112OutputBO execute(ST112InputBO input) {
        ST112OutputBO output = new ST112OutputBO();

        // 子步骤 1：按渠道类型在【渠道类型定义表】按「渠道」唯一匹配，取该渠道的柜面标志；查不到记录时按 N-否 处理
        String channelCounterFlag = queryChannelCounterFlag(input.getSourceType());

        // 子步骤 2：按账户限制类型查询【限制控制明细表】，取状态为 "A" 的全部记录构成 [限制控制明细信息]
        List<RbRestraintControlDetailsEO> details = queryEffectiveDetails(input.getRestraintType());

        // 子步骤 2：汇总出 [账户限制类型对应的柜面标志]（零条→N；任一条为 Y→Y；全为 N→N）
        String restraintTypeCounterFlag = sumCounterFlag(details);

        // 子步骤 3：两个柜面标志同时为 Y-是 跳子步骤 4，否则跳子步骤 5，二者互斥
        String checkResult;
        if (COUNTER_FLAG_YES.equals(channelCounterFlag) && COUNTER_FLAG_YES.equals(restraintTypeCounterFlag)) {
            // 子步骤 4：检查柜面渠道的豁免信息
            checkResult = checkCounterChannelExemption(details, input);
        } else {
            // 子步骤 5：检查非柜面渠道的豁免信息
            checkResult = checkNonCounterChannelExemption(details, input);
        }
        // 检查结果无承载字段（Spec 不覆盖项 2），只在本步骤内取到并记录
        LOGGER.debug("ST112 检查限制豁免：渠道类型={} 的检查结果为 {}", input.getSourceType(), checkResult);

        // 输出：回显 [限制控制明细信息] 记录的状态、产品编号、多交易类型、渠道集合、摘要码、限制机构范围、柜面标志
        fillOutput(output, details);

        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤 1：按渠道类型在【渠道类型定义表】按「渠道」唯一匹配，取记录的 $柜面标志$。
     *
     * <p>未匹配到记录（BCC 实现返回 null）时按 {@code "N"} 处理，不失败、不中断。</p>
     *
     * @param sourceType 渠道类型
     * @return [渠道的柜面标志]
     */
    private String queryChannelCounterFlag(SourceType sourceType) {
        FmChannelEO channel = fmChannelBcc.findByChannel(sourceType);
        if (channel == null) {
            return COUNTER_FLAG_NO;
        }
        return channel.getCounterFlag();
    }

    /**
     * 子步骤 2：按账户限制类型查询【限制控制明细表】，取 $状态$ 等于码值 {@code "A"} 的记录。
     *
     * <p>集合取全部查询结果：命中一条即含一条，命中多条即含全部命中记录，不截断、不取首条；
     * 状态非 {@code "A"} 的记录不进入集合；无命中记录时为空集合。</p>
     *
     * @param restraintType 账户限制类型
     * @return [限制控制明细信息]
     */
    private List<RbRestraintControlDetailsEO> queryEffectiveDetails(RestraintType restraintType) {
        RbRestraintControlDetailsEO condition = new RbRestraintControlDetailsEO();
        condition.setRestraintType(restraintType);
        List<RbRestraintControlDetailsEO> records = rbRestraintControlDetailsBcc.findByEo(condition);

        List<RbRestraintControlDetailsEO> details = new ArrayList<>();
        if (records == null) {
            return details;
        }
        for (RbRestraintControlDetailsEO record : records) {
            if (record != null && Status.A.equals(record.getStatus())) {
                details.add(record);
            }
        }
        return details;
    }

    /**
     * 子步骤 2：依据 [限制控制明细信息] 汇总 [账户限制类型对应的柜面标志]。
     *
     * <p>集合为空 → {@code "N"}；集合非空且任一条 $柜面标志$ 为 {@code "Y"} → {@code "Y"}；
     * 集合非空且全部为 {@code "N"} → {@code "N"}。不依赖返回顺序，不以首条取值代替汇总。</p>
     *
     * @param details [限制控制明细信息]
     * @return [账户限制类型对应的柜面标志]
     */
    private String sumCounterFlag(List<RbRestraintControlDetailsEO> details) {
        for (RbRestraintControlDetailsEO detail : details) {
            if (COUNTER_FLAG_YES.equals(detail.getCounterFlag())) {
                return COUNTER_FLAG_YES;
            }
        }
        return COUNTER_FLAG_NO;
    }

    /**
     * 子步骤 4：检查柜面渠道的豁免信息（两柜面标志同时为 {@code "Y"} 时执行）。
     *
     * @param details [限制控制明细信息]
     * @param input   步骤入参
     * @return 存在三字段同时匹配的记录返回「不检查限制」，否则返回「需检查限制」
     */
    private String checkCounterChannelExemption(List<RbRestraintControlDetailsEO> details, ST112InputBO input) {
        if (existsSimultaneousMatch(details, input)) {
            return CHECK_RESULT_NO_CHECK;
        }
        return CHECK_RESULT_NEED_CHECK;
    }

    /**
     * 子步骤 5：检查非柜面渠道的豁免信息（两柜面标志未同时为 {@code "Y"} 时执行）。
     *
     * @param details [限制控制明细信息]
     * @param input   步骤入参
     * @return 存在三字段同时匹配的记录返回「豁免」，否则（含集合为空）返回「不豁免」
     */
    private String checkNonCounterChannelExemption(List<RbRestraintControlDetailsEO> details, ST112InputBO input) {
        if (existsSimultaneousMatch(details, input)) {
            return CHECK_RESULT_EXEMPT;
        }
        return CHECK_RESULT_NOT_EXEMPT;
    }

    /**
     * 子步骤 4／5 的「同时匹配」判定：是否存在一条 [限制控制明细信息] 记录，其 $多交易类型$ 与入参
     * tranType 的码值一致、$摘要码$ 与入参 narrativeCode 一致、$产品类型$（产品编号）与入参 prodType 一致。
     *
     * <p>三项条件必须落在同一条记录上；三条条件分别由不同记录满足时视为不存在同时匹配的记录。</p>
     *
     * @param details [限制控制明细信息]
     * @param input   步骤入参
     * @return 存在同时匹配的记录返回 true
     */
    private boolean existsSimultaneousMatch(List<RbRestraintControlDetailsEO> details, ST112InputBO input) {
        TranType tranType = input.getTranType();
        String tranTypeValue = tranType == null ? null : tranType.getValue();
        for (RbRestraintControlDetailsEO detail : details) {
            boolean matched = Objects.equals(tranTypeValue, detail.getTranTypeLink())
                    && Objects.equals(input.getNarrativeCode(), detail.getNarrativeCode())
                    && Objects.equals(input.getProdType(), detail.getProdNo());
            if (matched) {
                return true;
            }
        }
        return false;
    }

    /**
     * REQ-008：产出 7 个输出字段，承载 [限制控制明细信息] 记录对应字段的值；集合为空时保持空值。
     *
     * <p>命中多条时 7 个字段是单值回显、多行还是集合承载源需求未定义（Spec 不覆盖项 3），
     * 本实现按集合首条记录回显这些单值字段，不改变集合完整性。</p>
     *
     * @param output  步骤输出
     * @param details [限制控制明细信息]
     */
    private void fillOutput(ST112OutputBO output, List<RbRestraintControlDetailsEO> details) {
        if (details.isEmpty()) {
            return;
        }
        RbRestraintControlDetailsEO detail = details.get(0);
        output.setStatus(detail.getStatus());
        output.setProdNo(detail.getProdNo());
        output.setTranTypeLink(detail.getTranTypeLink());
        output.setChannelMuster(detail.getChannelMuster());
        output.setNarrativeCode(detail.getNarrativeCode());
        output.setResBranchRange(detail.getResBranchRange());
        output.setCounterFlag(detail.getCounterFlag());
    }
}
