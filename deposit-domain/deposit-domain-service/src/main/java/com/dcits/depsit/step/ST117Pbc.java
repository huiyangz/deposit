package com.dcits.depsit.step;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST117InputBO;
import com.dcits.depsit.facade.bo.ST117OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST117 检查质押类限制的实现。
 *
 * <p>子步骤 1：以账号 + 限制状态码值 "A" 查询【账户限制信息】（{@code RB_BUS_RESTRAINTS}），
 * 取回该账号全部生效的限制记录；未查询到生效限制记录时 [质押标志] 不赋值、不执行子步骤 2、直接返回。</p>
 *
 * <p>子步骤 2：对每条限制记录，以其账户限制类型为条件查询【限制类型表】（{@code RB_RESTRAINT_TYPE}），
 * 只取状态码值为 "A" 的配置；无该类型记录或记录状态码值不等于 "A" 时该条不参与判定，继续处理其余记录。</p>
 *
 * <p>判定：配置记录的质押标志表示存在质押时该条命中，把该配置记录的质押标志取值原样取作 [质押标志]，
 * 并回显该条限制记录的限制编号、账户限制类型、限制状态及该配置记录的状态；全部记录均不表示存在质押时
 * [质押标志] 不赋值。是否「表示存在质押」按项目对该列（{@code PLEDGED_FLAG}）的「码值-含义」标志口径
 * 判定：{@link #FLAG_YES}（{@code "Y"}＝是）表示存在质押、{@link #FLAG_NO}（{@code "N"}＝否）不表示，
 * 判定取值与依据见 {@link #FLAG_YES}。本步骤无业务失败场景，不产生业务错误码。</p>
 */
@Service
public class ST117Pbc implements IST117 {

    /**
     * 质押标志「表示存在质押」的判定码值：{@code "Y"}＝是。
     *
     * <p>判定口径来源：正式需求（第 6 行「…的限制类型在【限制类型表】中的$质押标志$表示存在质押…」）
     * 与 Spec（「验收范围与明确不覆盖的事项」第 2 项）只以「表示存在质押 / 不表示存在质押」的语义书写
     * 该列取值，未给出码值；本步骤按项目对该列的「码值-含义」标志口径判定——同一张【限制类型表】
     * （{@code RB_RESTRAINT_TYPE}）的其它标志列在项目枚举中均为 {@code "Y"}＝是、{@code "N"}＝否
     * （{@code com.dcits.depsit.enums.RestraintAmtFlag}、{@code com.dcits.depsit.enums.AllowRepeatFlag}），
     * 该列自身为可空 {@code String}（库列 {@code PLEDGED_FLAG VARCHAR(1)}）、无对应枚举；已合并的
     * 同类标志判定亦按该口径书写（{@code BR005}：{@code FLAG_YES = "Y"}、{@code FLAG_NO = "N"}）。</p>
     *
     * <p>{@link #FLAG_YES} 与 {@link #FLAG_NO} 即本步骤的判定选项；空值（该列可空）与两项约定码值之外的
     * 其它取值按「不表示存在质押」处理。本常量只决定是否命中，不参与取值折算：命中时按原样透传该配置
     * 记录的质押标志取值，MUST NOT 折算为「是」/「否」或其它常量（REQ-006）。若业务后续确认该列的实际
     * 取值，只需修改本处码值与用例数据，判定结构不变。</p>
     */
    private static final String FLAG_YES = "Y";

    /**
     * 质押标志「不表示存在质押」的判定码值：{@code "N"}＝否，与 {@link #FLAG_YES} 同源。
     *
     * <p>该码值不命中：不参与赋值，也不以「否」或其它取值替代结论（REQ-006）。</p>
     */
    private static final String FLAG_NO = "N";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST117Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST117OutputBO execute(ST117InputBO input) {
        ST117OutputBO output = new ST117OutputBO();

        // 子步骤 1 获取账户限制信息：账号 + 限制状态等于 "A-生效"
        RbBusRestraintsEO queryEo = new RbBusRestraintsEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        queryEo.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(queryEo);

        // 未查询到生效的限制信息：[质押标志] 不赋值，不再执行子步骤 2，直接返回
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setSucceed(true);
            return output;
        }

        // 逐条判断子步骤 1 取回的限制信息
        for (RbBusRestraintsEO restraints : restraintsList) {
            // 子步骤 2 获取账户限制类型配置：按当前记录的账户限制类型取状态为 "A-生效" 的配置
            RbRestraintTypeEO restraintTypeEo =
                    rbRestraintTypeBcc.findByPrimaryKey(restraints.getRestraintType().getValue());
            if (restraintTypeEo == null || Status.A != restraintTypeEo.getStatus()) {
                // 无该类型的配置记录或配置不生效：该条不参与判定，继续判断其余限制信息
                continue;
            }

            // 判定：质押标志表示存在质押时该条命中，原样取该配置记录的质押标志取值返回
            if (isPledged(restraintTypeEo)) {
                output.setPledgedFlag(restraintTypeEo.getPledgedFlag());
                output.setResSeqNo(restraints.getResSeqNo());
                output.setRestraintType(restraints.getRestraintType());
                output.setRestraintsStatus(restraints.getRestraintsStatus());
                output.setStatus(restraintTypeEo.getStatus());
                output.setSucceed(true);
                return output;
            }
            // 该条不表示存在质押：不命中，继续判断其余限制信息
        }

        // 全部限制信息均不表示存在质押：[质押标志] 不赋值
        output.setSucceed(true);
        return output;
    }

    /**
     * 判定【限制类型表】配置记录的质押标志是否「表示存在质押」。
     *
     * <p>按项目对该列的码值口径判定（见 {@link #FLAG_YES}、{@link #FLAG_NO}）：{@link #FLAG_YES}
     * 表示存在质押，该条命中；{@link #FLAG_NO}、空值（该列可空）及两项约定码值之外的其它取值均按
     * 「不表示存在质押」处理：不命中、不参与赋值，也不以「否」或其它取值替代（REQ-006）。</p>
     *
     * @param restraintTypeEo 子步骤 2 取用的、状态码值为 "A" 的【限制类型表】配置记录
     * @return 该配置记录的质押标志表示存在质押时为 {@code true}
     */
    private boolean isPledged(RbRestraintTypeEO restraintTypeEo) {
        String pledgedFlag = restraintTypeEo.getPledgedFlag();
        if (FLAG_NO.equals(pledgedFlag)) {
            // "N-否"：明确不表示存在质押
            return false;
        }
        // 仅约定码值 "Y-是" 视为表示存在质押；空值与非约定取值同样不命中
        return FLAG_YES.equals(pledgedFlag);
    }
}
