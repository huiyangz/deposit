package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST059InputBO;
import com.dcits.deposit.facade.bo.ST059OutputBO;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST059 检查账户是否存在不允许销户的限制 步骤实现。
 *
 * <p>遍历[账户限制信息]（Spec REQ-002），逐条按[账户限制类型]（restraintType）查询
 * 【限制类型信息】（存款限制类型表 RB_RESTRAINT_TYPE，{@link IRbRestraintTypeBcc
 * #findByRestraintType}）获取[销户标志]；任一记录的[销户标志]为「N-否」时返回
 * [允许销户标志]「不允许销户」并中断遍历（Spec REQ-003），遍历结束未命中时返回
 * 「允许销户」（Spec REQ-004）。</p>
 *
 * <p>需求未声明本步骤业务失败场景，正常完成与正常提前结束（中断遍历）均按成功处理，
 * 不新增失败分支与错误码（Spec「依赖核对」、TBD-6）。</p>
 */
@Service
public class ST059Pbc implements IST059 {

    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST059OutputBO execute(ST059InputBO input) {
        ST059OutputBO output = new ST059OutputBO();
        // REQ-004-S02：[账户限制信息]为空集合时无记录可遍历，遍历直接结束，返回「允许销户」
        if (input == null || input.getRestraintList() == null || input.getRestraintList().isEmpty()) {
            output.setAllowCloseFlag("允许销户");
            output.setSucceed(true);
            return output;
        }
        // 遍历[账户限制信息]，逐条检查销户标志
        for (ST059InputBO.RestraintInfo restraintInfo : input.getRestraintList()) {
            // REQ-002：按[账户限制类型]查询【限制类型信息】获取[销户标志]
            RbRestraintTypeEO restraintType = rbRestraintTypeBcc.findByRestraintType(restraintInfo.getRestraintType());
            // FIXME 业务项:ST059/检查账户是否存在不允许销户的限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:按[账户限制类型]查询【限制类型信息】（findByRestraintType）无记录返回 null 时的处理未定义（Spec TBD-3） - 影响:当前将 null 视为未命中「N-否」继续遍历，查询无结果是否应跳过或另有处理未确认 - 待确认:查询无记录时应继续遍历、跳过还是按其他行为处理
            // FIXME 业务项:ST059/检查账户是否存在不允许销户的限制 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:[销户标志]取值域未完整定义，需求仅确认「N-否」触发「不允许销户」，未定义「Y-是」等其它标准取值及 null/空值时的处理（Spec TBD-1、TBD-4） - 影响:当前将非「N」取值（含 null/空）按「否则继续遍历」处理，null/空值的既定语义未确认 - 待确认:非「N」取值的标准值集合（是否即「Y」）及 null/空值应按「非N 继续遍历」还是其他行为处理
            if (restraintType != null && "N".equals(restraintType.getCloseAcctFlag())) {
                // REQ-003：[销户标志]为「N-否」时返回「不允许销户」并中断遍历
                output.setAllowCloseFlag("不允许销户");
                output.setSucceed(true);
                return output;
            }
        }
        // REQ-004：遍历结束未命中「N-否」，返回「允许销户」
        output.setAllowCloseFlag("允许销户");
        output.setSucceed(true);
        return output;
    }
}
