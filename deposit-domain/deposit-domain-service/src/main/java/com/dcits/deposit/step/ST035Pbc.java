package com.dcits.deposit.step;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.facade.bo.ST035InputBO;
import com.dcits.deposit.facade.bo.ST035OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;

/**
 * ST035 检查支取账户黑名单 步骤实现。
 *
 * <p>按正式 Spec 步骤描述第 1~4 步执行：REQ-001 按{凭证类型}查询【凭证信息】（凭证类型
 * 定义表，TB_VOUCHER_DEF）获取$凭证种类$并输出 docClass；REQ-002 赋值[事件类型]为
 * 「DEBT」；REQ-003 按九参数调用组件内步骤 ST036「检查黑名单」取得[执行结果]；REQ-004
 * 按[执行结果]分支：通过/提醒→继续执行（正常结束）、授权→正常结束并输出 授权标志="是"、
 * 拒绝→业务失败返回错误码 {@code ER0057}。</p>
 *
 * <p>待确认事项 TBD-1（{交易机构}→ST036 输入字段映射）、TBD-2（ST036 其余输入组装
 * 来源）、TBD-3（授权等待编排）、TBD-4、TBD-5（凭证种类取得边界）、TBD-6（必填输入
 * 缺失校验）及 ST036 步骤失败传播见对应 FIXME，不构成已确认验收行为。</p>
 */
@Service
public class ST035Pbc implements IST035 {

    @Autowired
    private ITbVoucherDefBcc tbVoucherDefBcc;

    @Autowired
    private IST036 ist036;

    @Override
    public ST035OutputBO execute(ST035InputBO input) {
        // FIXME 业务项:ST035/检查支取账户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求「输入」表 8 个字段（clientNo、baseAcctNo、tranBranch、tranType、serviceCode、messageCode、messageType、sourceType）标记必填，输入为空/缺失时的校验行为及错误码未定义（正式 Spec 待确认事项 TBD-6，关联 REQ-001~REQ-004） - 影响:当前实现不校验必填输入，缺失时仍继续执行后续子步骤 - 待确认:必填输入缺失时应如何校验、返回何种失败结果与错误码
        ST035OutputBO output = new ST035OutputBO();

        // 第 1 步（REQ-001）：根据{凭证类型}查询【凭证信息】（凭证类型定义表，TB_VOUCHER_DEF）获取其对应的$凭证种类$
        // FIXME 业务项:ST035/检查支取账户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:docType 标记为非必填，未定义未上送 docType 时第 1 步是否执行、输出 docClass 是否为空（正式 Spec 待确认事项 TBD-4，关联 REQ-001） - 影响:当前实现仅在 docType 非空时执行查询，未上送时 docClass 保持为空、步骤继续执行 - 待确认:未上送 docType 时第 1 步是否执行及输出 docClass 的取值
        DocClass docClass = null;
        if (input.getDocType() != null) {
            TbVoucherDefEO voucherDef = tbVoucherDefBcc.findByDocType(input.getDocType());
            // FIXME 业务项:ST035/检查支取账户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:按凭证类型查询凭证类型定义表无记录时的行为未定义（docClass 是否为空、是否报错及错误码；正式 Spec 待确认事项 TBD-5，关联 REQ-001） - 影响:当前实现无记录时 docClass 保持为空、步骤继续执行 - 待确认:查询无记录时 docClass 的取值与本步骤结果
            if (voucherDef != null) {
                docClass = voucherDef.getDocClass();
            }
        }
        output.setDocClass(docClass);

        // 第 2 步（REQ-002）：赋值[事件类型]为「DEBT」，作为输出 eventType 及第 3 步调用 ST036 的[事件类型]取值
        output.setEventType("DEBT");

        // 第 3 步（REQ-003）：按{账号}、{交易机构}、{交易类型}、[事件类型]、{服务代码}、
        // {接口服务代码}、{接口服务类型}、{渠道类型}、[凭证种类]九个参数调用组件内步骤
        // ST036「检查黑名单」，取得 ST036 步骤结果作为[执行结果]
        ST036InputBO st036Input = new ST036InputBO();
        st036Input.setBaseAcctNo(input.getBaseAcctNo());
        st036Input.setTranType(input.getTranType());
        st036Input.setEventType("DEBT");
        st036Input.setServiceCode(input.getServiceCode());
        st036Input.setMessageCode(input.getMessageCode());
        st036Input.setMessageType(input.getMessageType());
        st036Input.setSourceType(input.getSourceType());
        st036Input.setDocClass(docClass);
        // FIXME 业务项:ST035/检查支取账户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:{交易机构}（tranBranch）作为 ST036 调用参数，映射到 ST036 哪个输入字段未确认：ST036「输入」表无「交易机构」字段，其 acctBranch 为「账户开立行行号」（TranBranch），与「交易机构号」（TranBranch）业务概念不同（正式 Spec 待确认事项 TBD-1，关联 REQ-003） - 影响:当前 ST036 调用输入不组装 tranBranch，仅组装其余八个已确认映射字段 - 待确认:{交易机构}是否映射到 ST036 的 acctBranch，或 ST036 另有交易机构输入
        // FIXME 业务项:ST035/检查支取账户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST036 其余输入字段（必填 acctBranch、programId、blacklistCheckFlag、serviceStatus、documentId、documentType 及非必填 clientNo）在组件内步骤调用中的取值来源未确认，需求未声明（正式 Spec 待确认事项 TBD-2，关联 REQ-003） - 影响:当前 ST036 输入仅组装已确认映射的八个字段，其余字段保持为空，不得以默认值或占位值填充 - 待确认:各字段的取值来源
        ST036OutputBO st036Result = ist036.execute(st036Input);

        // 第 4 步（REQ-004）：按[执行结果]分支：通过/提醒→继续执行、授权→返回授权标志="是"、拒绝→返回错误码 ER0057
        if (!st036Result.isSucceed()) {
            // FIXME 业务项:ST035/检查支取账户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:ST036 步骤结果 succeed=false 时本步骤的处理方式未定义：正式 Spec「结果语义」仅定义 ST036 正常结束（succeed=true）下「通过」「拒绝」「授权」「提醒」四种执行结果，未声明 ST036 失败时本步骤的结果映射 - 影响:当前实现透传 ST036 的失败状态与错误字段，该行为待确认 - 待确认:ST036 失败时本步骤应返回何种结果（透传、指定错误码或其它处理）
            output.setSucceed(false);
            output.setErrorCode(st036Result.getErrorCode());
            output.setErrorMessage(st036Result.getErrorMessage());
            return output;
        }
        DealFlow dealFlow = st036Result.getDealFlow();
        if (dealFlow == DealFlow.B) {
            // [执行结果]为「拒绝」（DealFlow.B）→ 本步骤业务失败，返回错误码 ER0057
            output.setSucceed(false);
            output.setErrorCode("ER0057");
            output.setErrorMessage("ER0057::黑名单账户，拒绝交易");
            return output;
        }
        if (dealFlow == DealFlow.A) {
            // FIXME 业务项:ST035/检查支取账户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:「等待授权结果后再执行后续步骤」的编排机制未定义：由谁等待授权结果、授权结果如何获取、授权结束后是否重复执行本检查或直接继续后续步骤，需求未声明（正式 Spec 待确认事项 TBD-3，关联 REQ-004） - 影响:当前仅实现已确认的可观察行为（正常结束并输出 授权标志="是"），等待/获取授权结果的后续编排未实现 - 待确认:授权结果的等待与后续步骤编排机制
            // [执行结果]为「授权」（DealFlow.A）→ 正常结束并返回授权标志="是"
            output.set授权标志("是");
        }
        // [执行结果]为「通过」（未设置 dealFlow）或「提醒」（DealFlow.D）→ 继续执行；「授权」→ 正常结束并输出授权标志="是"
        output.setSucceed(true);
        return output;
    }
}
