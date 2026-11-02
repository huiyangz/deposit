package com.dcits.deposit.step;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.facade.bo.ST034InputBO;
import com.dcits.deposit.facade.bo.ST034OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST034 检查对手账户黑名单 步骤实现。
 *
 * <p>按步骤描述 1–4 执行：第 1 步根据凭证类型查询凭证类型定义表（TB_VOUCHER_DEF）获取凭证种类
 * docClass；第 2 步赋值事件类型为 "CRET"；第 3 步按需求声明的 9 项参数以组件内步骤调用方式访问
 * 本组件内步骤 ST036 检查黑名单取得执行结果；第 4 步按执行结果分支：通过/提醒继续执行（正常结束），
 * 授权输出授权标志为"是"（正常结束），拒绝返回错误码 ER0057（步骤业务失败）。</p>
 */
@Service
public class ST034Pbc implements IST034 {

    @Autowired
    private ITbVoucherDefBcc tbVoucherDefBcc;

    @Autowired
    private IST036 st036;

    @Override
    public ST034OutputBO execute(ST034InputBO input) {
        // FIXME 业务项:ST034 检查对手账户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入表声明 othBaseAcctNo、tranBranch、tranType、serviceCode、messageCode、messageType、sourceType 为必填，需求未定义必填输入为空/缺失时的校验失败行为及错误码 - 影响:当前实现不校验必填输入，输入缺失时仍继续执行后续步骤 - 待确认:必填输入缺失时应返回何种失败结果与错误码
        ST034OutputBO output = new ST034OutputBO();

        // 第 1 步（REQ-001）：根据输入凭证类型查询凭证信息（TB_VOUCHER_DEF）获取凭证种类 docClass
        // FIXME 业务项:ST034 检查对手账户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入 docType 标记非必填，第 1 步按 docType 查询凭证类型定义表（TB_VOUCHER_DEF），docType 未上送或查无记录时的行为未定义 - 影响:docType 缺失/查无记录时凭证种类 docClass 缺位及对第 3 步 ST036 调用（介质检查）的影响未确定 - 待确认:docType 未上送或查无记录时是否继续执行及凭证种类取值
        TbVoucherDefEO voucherDef = tbVoucherDefBcc.findByDocType(input.getDocType());
        DocClass docClass = voucherDef == null ? null : voucherDef.getDocClass();
        output.setDocClass(docClass);

        // 第 2 步（REQ-002）：赋值事件类型为 "CRET"
        output.setEventType("CRET");

        // 第 3 步（REQ-003）：按需求声明的 9 项参数以组件内步骤调用方式访问本组件内步骤 ST036「检查黑名单」
        // FIXME 业务项:ST034 检查对手账户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST036 输入 BO 15 个字段中仅 7 项同名参数（docClass、eventType、tranType、serviceCode、messageCode、messageType、sourceType）有已确认来源；{对手账号}→baseAcctNo、{交易机构}→acctBranch 的映射及 acctBranch/programId/blacklistCheckFlag/serviceStatus/documentId/documentType 等其余字段来源未由需求确认 - 影响:ST036 调用输入部分字段未赋值，实际运行时 ST036 必填校验可能失败 - 待确认:9 项调用参数到 ST036 输入字段的映射及其余字段来源/取值
        ST036InputBO st036Input = new ST036InputBO();
        st036Input.setDocClass(docClass);
        st036Input.setEventType("CRET");
        st036Input.setTranType(input.getTranType());
        st036Input.setServiceCode(input.getServiceCode());
        st036Input.setMessageCode(input.getMessageCode());
        st036Input.setMessageType(input.getMessageType());
        st036Input.setSourceType(input.getSourceType());
        ST036OutputBO st036Output = st036.execute(st036Input);
        // FIXME 业务项:ST034 检查对手账户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:关联 Spec 定义 ST036 正常结束（无业务失败与错误码），ST034 未定义 ST036 返回失败时的处理 - 影响:ST036 失败时本步骤返回结果未确定 - 待确认:ST036 返回失败时本步骤应如何返回（是否失败及错误码与错误信息）
        if (!st036Output.isSucceed()) {
            output.setSucceed(false);
            return output;
        }

        // 输出 dealFlow 承载 ST036 的检查结果（透传关系见 TBD-6）
        // FIXME 业务项:ST034 检查对手账户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:[执行结果]与输出 dealFlow 的承载关系未确认（ST036 以 dealFlow 承载检查结果，ST034 输出表声明 dealFlow 非必填、来源实体为空） - 影响:当前实现透传 ST036 的 dealFlow 输出，「通过/提醒」分支是否同步输出 dealFlow 未确定 - 待确认:ST034 输出 dealFlow 是否透传 ST036 的 dealFlow 及「通过/提醒」分支是否同步输出
        output.setDealFlow(st036Output.getDealFlow());

        // 第 4 步（REQ-004）：按执行结果分支处理
        // FIXME 业务项:ST034 检查对手账户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:需求第 4 步 c 原文「若[执行结果]为"拒绝"，否则返回[错误码]"ER0057"」含异常连接词「否则」，本 Spec 按「执行结果为拒绝时返回 ER0057」整理 - 影响:是否存在非通过/提醒/授权也返回 ER0057 的语义未确认 - 待确认:4c 是否仅覆盖[执行结果]="拒绝"及拒绝分支是否为业务失败
        DealFlow dealFlow = st036Output.getDealFlow();
        if (dealFlow == null || dealFlow == DealFlow.D) {
            // a. 通过 / 提醒 → 继续执行后续步骤，本步骤正常结束
            output.setSucceed(true);
        } else if (dealFlow == DealFlow.A) {
            // b. 授权 → 输出授权标志为 "是"，正常结束；授权等待机制由流程编排负责（TBD-5）
            output.setAuthFlag("是");
            output.setSucceed(true);
        } else {
            // c. 拒绝 → 本步骤业务失败，返回错误码 ER0057
            output.setSucceed(false);
            output.setErrorCode("ER0057");
            output.setErrorMessage("ER0057::黑名单账户，拒绝交易");
        }
        return output;
    }
}
