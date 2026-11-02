package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST007InputBO;
import com.dcits.deposit.facade.bo.ST007OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST007 检查对手账户是否存在 步骤实现。
 *
 * <p>根据必填输入对手账号（{@code othBaseAcctNo}）查询对公存款账户主表（RB_BUS_ACCT）获取对手账户信息，
 * 检查其存在性：对手账户信息为空时步骤业务失败并返回错误码 ER0081（「ER0081::对手账户不存在」）；
 * 对手账户信息非空时检查结果为「通过」，步骤正常完成并输出 {@code internalKey}、{@code baseAcctNo}、
 * {@code acctStatus}。</p>
 */
@Service
public class ST007Pbc implements IST007 {

    /** 对公存款账户主表（RB_BUS_ACCT）数据服务接口 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Override
    public ST007OutputBO execute(ST007InputBO input) {
        ST007OutputBO output = new ST007OutputBO();

        // 子步骤（获取对手账户信息，REQ-001）：根据{对手账号}查询【账户信息】获取[对手账户信息]
        // FIXME 业务项:ST007/检查对手账户是否存在 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:对手账号(othBaseAcctNo)→对公存款账户主表(RB_BUS_ACCT)的账号解析路径需求未声明（TBD-1），RbBusAcctEO 与 DDL 均无账号字段，无法确认将对手账号映射为哪个查询条件字段 - 影响:当前查询请求未携带对手账号条件，存在性判定基于未确认口径的查询结果 - 待确认:本步骤实际查询目标实体及账号解析口径（如经对公客户账户表 baseAcctNo 定位）
        // FIXME 业务项:ST007/检查对手账户是否存在 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:必填输入 othBaseAcctNo 缺失或为空时的行为需求未定义（TBD-4），本实现未做必填校验，不臆造错误码 - 影响:对手账号缺失时当前按正常查询路径处理，无确认的报错行为 - 待确认:othBaseAcctNo 缺失/为空时应否校验报错及对应错误码、失败结果
        RbBusAcctEO queryEo = new RbBusAcctEO();
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(queryEo);

        // 子步骤（检查对手账户信息存在性，REQ-002/REQ-003）：对手账户信息为空时业务失败返回 ER0081，非空时检查通过
        // FIXME 业务项:ST007/检查对手账户是否存在 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:「对手账户信息为空」判定口径需求未声明（TBD-3），仅确认查询无匹配记录为空，记录存在但关键字段为空是否算空未定义 - 影响:记录存在但 internalKey/acctStatus 等字段为空的组合当前按存在处理并输出空值 - 待确认:记录存在但关键字段为空是否视为「对手账户信息为空」
        if (acctList == null || acctList.isEmpty()) {
            output.setSucceed(false);
            output.setErrorCode("ER0081");
            output.setErrorMessage("ER0081::对手账户不存在");
            return output;
        }

        // 单条结果查询统一约定：多条记录取结果集第一条作为对手账户信息
        RbBusAcctEO firstAcct = acctList.get(0);
        output.setInternalKey(firstAcct.getInternalKey());
        // FIXME 业务项:ST007/检查对手账户是否存在 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出字段 baseAcctNo（账号）声明来源为对公存款账户主表（RB_BUS_ACCT），但 RbBusAcctEO 与 DDL 均无 baseAcctNo 字段，取值路径未确认（TBD-2） - 影响:baseAcctNo 输出当前未赋值（保持空），成功时该字段不返回具体账号值 - 待确认:baseAcctNo 输出的实际来源实体与取值路径
        output.setAcctStatus(firstAcct.getAcctStatus());
        output.setSucceed(true);
        return output;
    }
}
