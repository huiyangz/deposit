package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;

/**
 * ST049 检查转账止收限制 实现。
 *
 * <p>执行顺序：REQ-001 按账号与限制状态 A 查询账户限制信息，REQ-002 按账户限制类型与状态 A 查询限制类型信息，
 * REQ-003/REQ-004 依据借贷方控制标志与转账标志判定转账止收标志。</p>
 */
@Service
public class ST049Pbc implements IST049 {

    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST049OutputBO execute(ST049InputBO input) {
        // FIXME 业务项:ST049/检查转账止收限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入 baseAcctNo 标记必填，但为空或无效值时的行为未定义 - 影响:是否按业务失败处理、失败码与描述未确定，当前不新增校验分支 - 待确认:baseAcctNo 为空/无效时是否按业务失败处理及失败码与描述

        ST049OutputBO output = new ST049OutputBO();

        // 子步骤 REQ-001：按账号与限制状态 A 查询账户限制信息
        RbBusRestraintsEO restraintQuery = new RbBusRestraintsEO();
        restraintQuery.setBaseAcctNo(input.getBaseAcctNo());
        restraintQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(restraintQuery);
        if (restraintsList == null || restraintsList.isEmpty()) {
            // FIXME 业务项:ST049/检查转账止收限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按账号与限制状态 A 查询对公存款账户限制表无匹配记录 - 影响:返回转账止收标志「否」、按业务失败处理还是其它行为未定义，当前返回成功且业务字段为空 - 待确认:查询无记录时的行为
            output.setSucceed(true);
            return output;
        }
        // FIXME 业务项:ST049/检查转账止收限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:需求以单数表述获取账户限制信息，但查询接口按属性组合返回记录集合，同一账号多条 A-生效记录的选取规则未定义 - 影响:多条记录时取哪一条的账户限制类型与限制编号未确定，当前按项目约定取结果集第一条 - 待确认:多条记录的选取规则（如按限制编号/创建时间排序取第一条）
        RbBusRestraintsEO restraint = restraintsList.get(0);

        // 子步骤 REQ-002：按账户限制类型与状态 A 查询限制类型信息
        RbRestraintTypeEO typeQuery = new RbRestraintTypeEO();
        typeQuery.setRestraintType(restraint.getRestraintType());
        typeQuery.setStatus(Status.A);
        List<RbRestraintTypeEO> typeList = rbRestraintTypeBcc.findByEo(typeQuery);
        if (typeList == null || typeList.isEmpty()) {
            // FIXME 业务项:ST049/检查转账止收限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按账户限制类型与状态 A 查询存款限制类型表无匹配记录 - 影响:返回转账止收标志「否」、按业务失败处理还是其它行为未定义，当前返回成功且业务字段为空 - 待确认:查询无记录时的行为
            output.setSucceed(true);
            return output;
        }
        // 多条按项目约定取结果集第一条，先判空再取值，不额外排序或遍历
        RbRestraintTypeEO type = typeList.get(0);

        // 输出映射：输出表 7 个字段
        output.setResSeqNo(restraint.getResSeqNo());
        output.setRestraintType(restraint.getRestraintType());
        output.setRestraintsStatus(restraint.getRestraintsStatus());
        output.setDrCrCtlFlag(type.getDrCrCtlFlag());
        output.setStatus(type.getStatus());
        output.setTransferFlag(type.getTransferFlag());
        output.setStopFlag(type.getStopFlag());

        // 子步骤 REQ-003/REQ-004：借贷方控制标志=C 且转账标志=N →「是」，否则 →「否」
        // FIXME 业务项:ST049/检查转账止收限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:判定结果「转账止收标志」未出现在需求输出表 - 影响:输出字段名、类型及返回载体未确定，当前仅以局部变量保存判定结果，不作为输出字段 - 待确认:判定结果的输出字段名、类型与返回载体及「是/否」的物理编码
        // FIXME 业务项:ST049/检查转账止收限制 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:transferFlag 取值集合未确认，需求仅确认「N-不允许转账」 - 影响:非 N 取值（如测试推导示例值 "Y"）的物理编码未确定，判定已按「否则→否」落实 - 待确认:转账标志允许转账取值及完整取值集合
        boolean transferStopFlag = DrCrCtlFlag.C == type.getDrCrCtlFlag() && "N".equals(type.getTransferFlag());

        output.setSucceed(true);
        return output;
    }
}
