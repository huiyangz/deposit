package com.dcits.depsit.step;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST113InputBO;
import com.dcits.depsit.facade.bo.ST113OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST113 检查有权机关冻结限制（交易执行步骤，检查类）。
 *
 * <p>子步骤 1（REQ-002）：以账号（`baseAcctNo`，对应步骤描述中的 `{账号}`）与限制状态码值 `"A"`
 * （源需求书写「A-生效」，按「码值-含义」口径取码值判定）查询【账户限制信息】
 * （{@link IRbBusRestraintsBcc#findByEo}，集合返回，零条与多条均可达），取回记录含
 * `$账户限制类型$` 与 `$限制编号$`；查询不以这两项之外的字段收窄。未查询到 A-生效 记录
 * （零条，含仅有非 A 限制状态记录）时：`ahBuFlag` 不赋值、不再执行子步骤 2
 * （不查询【限制类型表】）、直接返回（REQ-003）。</p>
 *
 * <p>子步骤 2（REQ-004／REQ-005／REQ-006）：逐条以当前记录自身的 `$账户限制类型$` 查
 * 【限制类型表】（{@link IRbRestraintTypeBcc#findByRestraintType}，按主键取单条），仅取
 * `$状态$` 为 {@link Status#A} 的配置；该限制类型无 A-生效 记录（无记录或状态非 `"A"`）时
 * 视为该限制类型不构成有权机关冻结限制，本步骤不按该类型返回值、不赋值，并继续处理其余记录
 * （REQ-005）。配置的 `$有权机关冻结标志$` 取值为码值 `"Y"`（源需求书写「Y-是」）时表示该限制
 * 属于有权机关冻结，即把该取值**原样**赋给 `ahBuFlag` 并返回、不再对其余记录继续取值（REQ-006）；
 * 取值为码值 `"N"`（源需求书写「N-否」）或空值时不表示，不赋值。判定口径见
 * {@link #AH_BU_FLAG_YES}；取值 MUST 来自按该记录自身限制类型查得的配置，不取用
 * 【账户限制信息】上的同名字段。</p>
 *
 * <p>本步骤只读，不产生状态类数据变更，不加 {@code @Transactional}；无业务失败场景，
 * 技术异常不捕获、不转译，向上层传播（REQ-008）；正常出口（含正常提前返回）在返回前置
 * {@code succeed=true}，错误码与错误信息保持 null。</p>
 */
@Service
public class ST113Pbc implements IST113 {

    /**
     * 【限制类型表】`$有权机关冻结标志$` 中表示该限制属于有权机关冻结的码值。
     *
     * <p>判定口径来自 Spec REQ-004「取值口径」表：码值 {@code "Y"}（源需求书写「Y-是」）表示该限制
     * 属于有权机关冻结（命中），码值 {@code "N"}（源需求书写「N-否」）或空值表示不属于（不命中）。
     * 承载该值的列 {@code RB_RESTRAINT_TYPE.AH_BU_FLAG} 在本项目中为可空 {@code VARCHAR(1)}、
     * {@link RbRestraintTypeEO} 上为 {@code java.lang.String} 且无对应枚举，故按字面码值判定，
     * 不依赖枚举常量；命中时原样透传配置取值，不折算为「是」/「否」。源需求未列举的其它取值
     * 不在已确认取值域内（Spec 不覆盖事项第 3 项），本实现不将其视为「表示」。</p>
     */
    private static final String AH_BU_FLAG_YES = "Y";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST113Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST113OutputBO execute(ST113InputBO input) {
        ST113OutputBO output = new ST113OutputBO();

        // 子步骤 1（REQ-002）：以账号 + 限制状态码值 "A" 查询【账户限制信息】，取回全部命中的记录
        RbBusRestraintsEO restraintsCondition = new RbBusRestraintsEO();
        restraintsCondition.setBaseAcctNo(input.getBaseAcctNo());
        restraintsCondition.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(restraintsCondition);

        // REQ-003：未查询到 A-生效 的账户限制记录（零条，含仅有非 A 记录）时，
        // 有权机关冻结标志不赋值，不再执行子步骤 2，直接返回
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setSucceed(true);
            return output;
        }

        // 子步骤 2（REQ-004 / REQ-005 / REQ-006）：逐条按记录自身的 $账户限制类型$ 取值
        for (RbBusRestraintsEO restraints : restraintsList) {
            RbRestraintTypeEO restraintType = rbRestraintTypeBcc
                    .findByRestraintType(restraints.getRestraintType());

            // REQ-005：该账户限制类型在【限制类型表】中没有 $状态$ 为 "A" 的记录（无记录或状态非 A）时，
            // 视为该限制类型不构成有权机关冻结限制，本步骤不再按该限制类型返回值、不赋值，
            // 并继续处理其余记录
            if (restraintType == null || restraintType.getStatus() != Status.A) {
                continue;
            }

            // REQ-006-S01：任一条记录的 $有权机关冻结标志$ 表示该限制属于有权机关冻结时，
            // 即取该配置取值原样赋给输出并返回，不再对其余记录继续取值
            if (isAhBuFlagHit(restraintType)) {
                output.setAhBuFlag(restraintType.getAhBuFlag());
                break;
            }
        }

        // REQ-007 / REQ-008：全部记录均不表示时 ahBuFlag 保持不赋值；本步骤无业务失败场景
        output.setSucceed(true);
        return output;
    }

    /**
     * 判断【限制类型表】该配置的 `$有权机关冻结标志$` 是否表示该限制属于有权机关冻结。
     *
     * <p>取值口径见类注释与 {@link #AH_BU_FLAG_YES}：仅已确认码值 {@code "Y"} 视为「表示」，
     * 码值 {@code "N"} 与空值按「不表示」处理（REQ-004），不做非空即命中的放宽判定，
     * 也不折算、拼接或截断配置取值。</p>
     *
     * @param restraintType 已确认 `$状态$` 为 A-生效 的【限制类型表】配置
     * @return 表示该限制属于有权机关冻结时为 {@code true}
     */
    private static boolean isAhBuFlagHit(RbRestraintTypeEO restraintType) {
        return AH_BU_FLAG_YES.equals(restraintType.getAhBuFlag());
    }
}
