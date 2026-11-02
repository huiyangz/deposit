package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST053InputBO;
import com.dcits.deposit.facade.bo.ST053OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST053 检查质押类限制 步骤实现。
 *
 * <p>交易执行步骤。依据必填输入账号（baseAcctNo）按「账号 + 限制状态 A-生效」查询
 * 【对公存款账户限制表】（RB_BUS_RESTRAINTS）取得账户限制信息，再依据取得的账户限制类型按
 * 「账户限制类型 + 状态 A-生效」查询【存款限制类型表】（RB_RESTRAINT_TYPE），取得质押标志
 * （pledgedFlag）赋值并返回，作为本步骤的业务结果。</p>
 *
 * <p>已确认行为（正式 Spec REQ-001~REQ-004，步骤描述第 1、2 条）：</p>
 * <ul>
 *   <li>步骤 1：以 baseAcctNo 与 {@code RestraintsStatus.A} 为等值条件经
 *       {@link IRbBusRestraintsBcc#findByEo} 查询账户限制信息；</li>
 *   <li>步骤 2：以步骤 1 取得的账户限制类型与 {@code Status.A} 为等值条件经
 *       {@link IRbRestraintTypeBcc#findByEo} 查询限制类型定义，取得质押标志；</li>
 *   <li>正常完成时 succeed=true，errorCode、errorMessage 为 null；需求未声明本步骤的
 *       业务失败与错误码，本实现不补写失败处理或错误码。</li>
 * </ul>
 *
 * <p>查询无记录（TBD-2）、必填输入为空（TBD-1）及输出表同名字段区分（TBD-6）待业务确认，
 * 相关实现位置已标记业务 FIXME，见 {@link #execute(ST053InputBO)}。命中多条记录
 * （TBD-3）按本项目约定取结果集第一条；质押标志取值口径（TBD-4）按输出表 String 类型原样
 * 透传；查询条件 "A-生效" 按 Spec 已绑定枚举常量 {@code RestraintsStatus.A}、
 * {@code Status.A}（TBD-5）。</p>
 */
@Service
public class ST053Pbc implements IST053 {

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;
    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST053Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST053OutputBO execute(ST053InputBO input) {
        ST053OutputBO output = new ST053OutputBO();
        String baseAcctNo = input.getBaseAcctNo();
        // FIXME 业务项:ST053/检查质押类限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入 baseAcctNo 标记必填，但需求未定义其为空或缺失时的校验与失败行为（是否返回错误、使用哪个错误码或直接失败，正式 Spec 待确认事项 TBD-1） - 影响:当前实现不校验必填，空值直接作为步骤1查询账号条件，空值下的查询与结果行为未决 - 待确认:baseAcctNo 为空或缺失时应如何校验、返回错误码或直接失败

        // 步骤 1（步骤描述第1条）：根据{账号}、限制状态等于"A-生效"查询【对公存款账户限制表】获取[账户限制信息]，必须包括账户限制类型、限制编号
        RbBusRestraintsEO restraintQuery = new RbBusRestraintsEO();
        restraintQuery.setBaseAcctNo(baseAcctNo);
        restraintQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintList = rbBusRestraintsBcc.findByEo(restraintQuery);
        if (restraintList.isEmpty()) {
            // FIXME 业务项:ST053/检查质押类限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:步骤1按账号+限制状态A-生效查询【对公存款账户限制表】无记录时，质押标志的取得与返回行为未定义（是否失败、返回空质押标志、或正常完成且不返回质押标志，正式 Spec 待确认事项 TBD-2） - 影响:当前实现跳过步骤1赋值与步骤2查询，按正常完成返回空输出，该行为待确认 - 待确认:步骤1查询无记录时的业务结果与处理方式
        } else {
            // 多条统一取结果集第一条（本项目约定，不因原文未重复该约定而写业务 FIXME；TBD-3 选取规则待确认）
            RbBusRestraintsEO restraint = restraintList.get(0);
            output.setResSeqNo(restraint.getResSeqNo());
            // FIXME 业务项:ST053/检查质押类限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出表声明 restraintType 两次（分别来源 RB_BUS_RESTRAINTS 与 RB_RESTRAINT_TYPE），两同名字段在输出中的区分方式未定义（正式 Spec 待确认事项 TBD-6） - 影响:两来源取值不同时输出无法区分两个账户限制类型，本实现按步骤1来源取值以单一 restraintType 字段对外提供 - 待确认:两个 restraintType 输出字段的区分或命名方式
            output.setRestraintType(restraint.getRestraintType());
            output.setRestraintsStatus(restraint.getRestraintsStatus());

            // 步骤 2（步骤描述第2条）：根据[账户限制信息]中的账户限制类型查询【限制类型表】获取状态等于"A-生效"的质押标志赋值并返回[质押标志]
            RbRestraintTypeEO typeQuery = new RbRestraintTypeEO();
            typeQuery.setRestraintType(restraint.getRestraintType());
            typeQuery.setStatus(Status.A);
            List<RbRestraintTypeEO> typeList = rbRestraintTypeBcc.findByEo(typeQuery);
            if (typeList.isEmpty()) {
                // FIXME 业务项:ST053/检查质押类限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:步骤2按账户限制类型+状态A-生效查询【存款限制类型表】无记录时，质押标志的取得与返回行为未定义（是否失败、返回空质押标志、或正常完成且不返回质押标志，正式 Spec 待确认事项 TBD-2） - 影响:当前实现跳过质押标志赋值，按正常完成返回，该行为待确认 - 待确认:步骤2查询无记录时的业务结果与处理方式
            } else {
                // 多条统一取结果集第一条（本项目约定；TBD-3 选取规则待确认）
                RbRestraintTypeEO type = typeList.get(0);
                output.setPledgedFlag(type.getPledgedFlag());
                output.setStatus(type.getStatus());
            }
        }
        output.setSucceed(true);
        return output;
    }
}
