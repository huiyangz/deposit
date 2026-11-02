package com.dcits.deposit.step;

import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST051 检查账户是否存在限制 - 步骤实现。
 */
@Service
public class ST051Pbc implements IST051 {

    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Override
    public ST051OutputBO execute(ST051InputBO input) {
        ST051OutputBO output = new ST051OutputBO();

        // FIXME 业务项:ST051 检查账户是否存在限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:子账户判定标准未定义，需求仅以「若上送的{账号}是子账户」作为条件，未声明判定依据（是否依据主账户标志 leadAcctFlag、取何值代表子账户及 leadAcctFlag 物理取值） - 影响:REQ-002 子账户分支无法实现，当前仅实现非子账户路径（REQ-003-S01/REQ-004-S01/REQ-001-S01） - 待确认:子账户判定依据与代表子账户的取值

        // FIXME 业务项:ST051 检查账户是否存在限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:主账户账号获取口径未定义，RbBusAcctEO 仅暴露 leadAcctFlag，未暴露 baseAcctNo 及主账户账号字段 - 影响:子账户时无法按输入账号查询对公存款账户主表取得主账户账号并作为待查账户 - 待确认:按账号定位账户记录及取得主账户账号的字段/关联关系

        // FIXME 业务项:ST051 检查账户是否存在限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:必填输入 baseAcctNo 缺失/为空时的处理行为未定义 - 影响:缺失必填输入时行为不确定，按 step-error-contract 当前不新增失败分支与错误码 - 待确认:必填输入缺失时的处理行为

        // 待查账户确定（REQ-003）：非子账户时不执行主账户账号查询，待查账户 = 输入账号
        String queryAcctNo = input.getBaseAcctNo();

        // 限制表查询（REQ-004）：按待查账户查询对公存款账户限制表，仅筛选限制状态 = A（代码A）的记录
        RbBusRestraintsEO queryEo = new RbBusRestraintsEO();
        queryEo.setBaseAcctNo(queryAcctNo);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(queryEo);

        // FIXME 业务项:ST051 检查账户是否存在限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:多条限制状态=A 命中记录及无命中记录的返回行为未定义，输出表仅声明 resSeqNo/restraintsStatus/restraintType 三个单值字段 - 影响:多条命中时返回单条还是全部、无命中时返回与结束/流转行为无法确定，当前按命中顺序取第一条 A 记录赋值 - 待确认:多条命中与无命中记录的返回行为

        RbBusRestraintsEO hit = null;
        for (RbBusRestraintsEO item : restraintsList) {
            if (RestraintsStatus.A == item.getRestraintsStatus()) {
                hit = item;
                break;
            }
        }

        // 赋值返回（REQ-004/REQ-001）：限制信息取自对公存款账户限制表命中记录
        // FIXME 业务项:ST051 检查账户是否存在限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出 baseAcctNo、leadAcctFlag 取值口径未定义（需求输出表标为来源于对公存款账户主表） - 影响:无法确定二者取自输入账号记录还是主账户账号记录，当前暂不赋值 - 待确认:输出账号与主账户标志的取值来源及非子账户场景下 leadAcctFlag 来源

        if (hit != null) {
            output.setResSeqNo(hit.getResSeqNo());
            output.setRestraintsStatus(hit.getRestraintsStatus());
            output.setRestraintType(hit.getRestraintType());
        }

        // 正常完成：显式成功并保持错误字段为 null（step-error-contract）
        output.setSucceed(true);
        return output;
    }
}
