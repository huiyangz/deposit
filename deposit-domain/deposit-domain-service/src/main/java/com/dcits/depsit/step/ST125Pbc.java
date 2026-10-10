package com.dcits.depsit.step;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.RestraintLevel;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.facade.bo.ST125InputBO;
import com.dcits.depsit.facade.bo.ST125OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;

/**
 * ST125 检查是否存在属性限制 步骤实现。
 *
 * <p>步骤 1 以入参账号为查询键查询【账户限制信息表】，筛选限制状态码值 {@code A} 且限制级别码值
 * {@code NATURE} 的记录，未查到记录时四项回显为空值，查得多条时按限制编号升序取第一条；
 * 步骤 2 以 [账户限制信息] 是否为空返回 [属性限制标志]「否」或「是」。全路径只读、无业务失败场景。</p>
 */
@Service
public class ST125Pbc implements IST125 {

    /** 限制状态筛选取值：码值 A-生效 */
    private static final RestraintsStatus FILTER_RESTRAINTS_STATUS = RestraintsStatus.A;

    /** 限制级别筛选取值：码值 NATURE-账户属性限制 */
    private static final RestraintLevel FILTER_RESTRAINT_LEVEL = RestraintLevel.NATURE;

    /** [属性限制标志] 规范常量：是 */
    private static final String NATURE_RESTRAINT_FLAG_YES = "是";

    /** [属性限制标志] 规范常量：否 */
    private static final String NATURE_RESTRAINT_FLAG_NO = "否";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    public ST125Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
    }

    @Override
    public ST125OutputBO execute(ST125InputBO input) {
        ST125OutputBO output = new ST125OutputBO();

        // 子步骤1 获取属性级限制：根据{账号}查询【账户限制信息表】获取限制状态等于"A-生效"且限制级别
        // 等于"NATURE-账户属性限制"的 [账户限制信息]（只读查询，不新增、修改或删除记录）
        RbBusRestraintsEO condition = new RbBusRestraintsEO();
        condition.setBaseAcctNo(input.getBaseAcctNo());
        condition.setRestraintsStatus(FILTER_RESTRAINTS_STATUS);
        condition.setRestraintLevel(FILTER_RESTRAINT_LEVEL);
        List<RbBusRestraintsEO> restraints = rbBusRestraintsBcc.findByEo(condition);

        // 未查到记录时 [账户限制信息] 为空；查得多条记录时按$限制编号$升序取第一条；查得一条时取该条
        RbBusRestraintsEO restraint = null;
        if (restraints != null && !restraints.isEmpty()) {
            restraint = restraints.stream()
                    .min(Comparator.comparing(RbBusRestraintsEO::getResSeqNo,
                            Comparator.nullsLast(Comparator.naturalOrder())))
                    .orElse(null);
        }

        // 命中记录时回显该条的限制编号、账户限制类型、限制状态、限制级别；未查到记录时四项保持空值
        if (restraint != null) {
            output.setResSeqNo(restraint.getResSeqNo());
            output.setRestraintType(restraint.getRestraintType());
            output.setRestraintsStatus(restraint.getRestraintsStatus());
            output.setRestraintLevel(restraint.getRestraintLevel());
        }

        // 子步骤2 检查是否存在属性限制：若{账户限制信息}等于空，则返回[属性限制标志]为"否"，否则为"是"
        if (restraint == null) {
            output.setNatureRestraintFlag(NATURE_RESTRAINT_FLAG_NO);
        } else {
            output.setNatureRestraintFlag(NATURE_RESTRAINT_FLAG_YES);
        }

        output.setSucceed(true);
        return output;
    }
}
