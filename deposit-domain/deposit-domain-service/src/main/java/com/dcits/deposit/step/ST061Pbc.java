package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.RestraintLevel;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.facade.bo.ST061InputBO;
import com.dcits.deposit.facade.bo.ST061OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;

/**
 * ST061 检查是否存在属性限制。
 *
 * <p>步骤行为（正式 Spec）：</p>
 * <ol>
 *   <li>获取属性级限制：根据输入{账号}，以限制状态="A-生效"（{@code RestraintsStatus.A}）且
 *       限制级别="NATURE-账户属性限制"（{@code RestraintLevel.NATURE}）为查询条件查询
 *       【账户限制信息表】（对公存款账户限制表 RB_BUS_RESTRAINTS），获取[账户限制信息]集合；</li>
 *   <li>检查是否存在属性限制：集合为空返回属性限制标志"否"，非空返回"是"。</li>
 * </ol>
 *
 * <p>两分支均为步骤正常完成，本需求未声明业务失败场景，无错误码。</p>
 */
@Service
public class ST061Pbc implements IST061 {

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    public ST061Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
    }

    @Override
    public ST061OutputBO execute(ST061InputBO input) {
        ST061OutputBO output = new ST061OutputBO();

        // 子步骤1 获取属性级限制：查询条件仅由 账号等值 + 限制状态=RestraintsStatus.A 等值 + 限制级别=RestraintLevel.NATURE 等值 构成，
        // 其余 EO 字段保持 null（eoToEntityExample 仅对非空字段生成等值查询条件）
        RbBusRestraintsEO queryEo = new RbBusRestraintsEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        queryEo.setRestraintsStatus(RestraintsStatus.A);
        queryEo.setRestraintLevel(RestraintLevel.NATURE);
        List<RbBusRestraintsEO> restraints = rbBusRestraintsBcc.findByEo(queryEo);

        // FIXME 业务项:ST061/检查是否存在属性限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:查询结果为[账户限制信息]集合，需求未声明集合到单值输出字段（resSeqNo、restraintType、restraintsStatus、restraintLevel）的映射口径（仅首条/逐条/全量）（Spec 待确认事项 TBD-3） - 影响:当前实现不设置这四个输出字段（保持 null），属性限制标志判断不受影响 - 待确认:集合为空/非空时这四个输出字段的返回口径

        // 子步骤2 检查是否存在属性限制：集合为空返回"否"，非空返回"是"
        // FIXME 业务项:ST061/检查是否存在属性限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:属性限制标志按 Spec REQ-002 已确认字面值"是"/"否"设置，但物理取值口径（"是"/"否"字面值或 Y/N/1/0 等编码）未确认（Spec 待确认事项 TBD-2） - 影响:当前按字面值"是"/"否"返回，若上游确认采用其他编码常量需复核本输出与断言 - 待确认:属性限制标志的物理取值常量
        output.set属性限制标志(restraints.isEmpty() ? "否" : "是");

        // 两分支均为步骤正常完成，显式成功并清空错误字段
        output.setSucceed(true);
        output.setErrorCode(null);
        output.setErrorMessage(null);
        return output;
    }
}
