package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.facade.bo.ST009InputBO;
import com.dcits.deposit.facade.bo.ST009OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;

/**
 * ST009 检查支取客户黑名单 步骤实现。
 *
 * <p>按正式 Spec REQ-001~REQ-005 实现：步骤 1 按{客户号}查询客户副本表（FM_CLIENT_COPY）
 * 取得客户证件信息并赋值四项输出；步骤 2 按{凭证类型}查询凭证类型定义表（TB_VOUCHER_DEF）
 * 取得凭证种类；步骤 3 赋值[事件类型]="DEBT"；步骤 4 按已确认映射组装 ST036InputBO 调用
 * 组件内步骤 ST036「检查黑名单」获取[执行结果]；步骤 5 按[执行结果]分支返回（「通过/提醒」
 * 正常结束、「授权」设置[授权标志]="是"、「拒绝」业务失败返回错误码"ER0003"）。</p>
 */
@Service
public class ST009Pbc implements IST009 {

    @Autowired
    private IFmClientCopyBcc fmClientCopyBcc;

    @Autowired
    private ITbVoucherDefBcc tbVoucherDefBcc;

    @Autowired
    private IST036 st036;

    @Override
    public ST009OutputBO execute(ST009InputBO input) {
        ST009OutputBO output = new ST009OutputBO();

        // 步骤 1（REQ-001）：按{客户号}查询客户副本表（FM_CLIENT_COPY），赋值[客户名称]/[证件类型]/[证件号码]/[发证国家]
        // 客户副本表 EO 无 clientNo 字段，Spec 未定义步骤 1 的请求侧查询键字段，当前按空 EO 查询
        // FIXME 业务项:ST009/检查支取客户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤 1 按{客户号}（clientNo）查询客户副本表（FM_CLIENT_COPY），而 FmClientCopyEO 无 clientNo 字段，请求侧查询键字段未由 Spec 定义（Spec 待确认事项 TBD-6） - 影响:当前以空 EO 作为查询条件、取结果集首条赋值，无法按客户号限定查询范围 - 待确认:步骤 1 查询客户副本表的定位键字段与查询方式
        List<FmClientCopyEO> clientCopyList = fmClientCopyBcc.findByEo(new FmClientCopyEO());
        if (clientCopyList == null || clientCopyList.isEmpty()) {
            // 查询无记录时的返回行为需求未定义（Spec 待确认事项 TBD-6），当前按工程约定返回成功与空结果
            // FIXME 业务项:ST009/检查支取客户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:按{客户号}查询客户副本表无记录时的返回行为需求未定义（Spec 待确认事项 TBD-6） - 影响:当前按工程约定返回成功与空结果，[客户名称]等证件信息输出保持为空 - 待确认:查询无记录时应返回的结果
            output.setSucceed(true);
            return output;
        }
        FmClientCopyEO clientCopyRec = clientCopyList.get(0);
        output.setClientName(clientCopyRec.getClientName());
        output.setDocumentType(clientCopyRec.getDocumentType());
        output.setDocumentId(clientCopyRec.getDocumentId());
        output.setIssCountry(clientCopyRec.getIssCountry());

        // 步骤 2（REQ-002）：按{凭证类型}查询凭证类型定义表（TB_VOUCHER_DEF），赋值[凭证种类]
        if (input.getDocType() == null) {
            // {凭证类型}为非必填输入，未提供时是否执行本步骤及[凭证种类]取值需求未定义（Spec 待确认事项 TBD-6），当前跳过本步骤查询
            // FIXME 业务项:ST009/检查支取客户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:{凭证类型}（docType）为非必填输入，未提供时是否执行步骤 2、[凭证种类]如何取值需求未定义（Spec 待确认事项 TBD-6） - 影响:当前跳过凭证类型定义表查询，[凭证种类]保持未设置 - 待确认:docType 未提供时步骤 2 的执行方式与[凭证种类]取值
        } else {
            TbVoucherDefEO voucherDefRec = tbVoucherDefBcc.findByDocType(input.getDocType());
            if (voucherDefRec == null) {
                // 按{凭证类型}查询无对应记录时的行为需求未定义（Spec 待确认事项 TBD-6），当前[凭证种类]保持未设置、继续执行后续步骤
                // FIXME 业务项:ST009/检查支取客户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:按{凭证类型}查询凭证类型定义表（TB_VOUCHER_DEF）无对应记录时的行为需求未定义（Spec 待确认事项 TBD-6） - 影响:当前[凭证种类]保持未设置，继续执行后续步骤 - 待确认:查无对应记录时应返回的结果
            } else {
                output.setDocClass(voucherDefRec.getDocClass());
            }
        }

        // 步骤 3（REQ-003）：赋值[事件类型]为"DEBT"
        output.setEventType("DEBT");

        // 步骤 4（REQ-004）：按已确认 11 项映射组装 ST036InputBO，调用组件内步骤 ST036「检查黑名单」，获取[执行结果]
        ST036InputBO st036Input = new ST036InputBO();
        st036Input.setBaseAcctNo(input.getBaseAcctNo());
        st036Input.setClientNo(input.getClientNo());
        st036Input.setDocumentType(output.getDocumentType());
        st036Input.setDocumentId(output.getDocumentId());
        st036Input.setTranType(input.getTranType());
        st036Input.setEventType(output.getEventType());
        st036Input.setServiceCode(input.getServiceCode());
        st036Input.setMessageCode(input.getMessageCode());
        st036Input.setMessageType(input.getMessageType());
        st036Input.setSourceType(input.getSourceType());
        st036Input.setDocClass(output.getDocClass());
        // 调用参数与 ST036 输入契约不一致：ST036InputBO 未声明 clientName/issCountry（需求原文调用参数含两者），
        // 且 acctBranch/programId/blacklistCheckFlag/serviceStatus 未由 ST009 提供（Spec 待确认事项 TBD-1）
        // FIXME 业务项:ST009/检查支取客户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤 4 调用参数与 ST036 输入契约（ST036InputBO）不一致：ST036InputBO 未声明 clientName/issCountry（需求原文调用参数含两者），且 ST009 未提供 ST036 必填的 acctBranch/programId/blacklistCheckFlag/serviceStatus（Spec 待确认事项 TBD-1） - 影响:当前仅按已确认 11 项映射传值，clientName/issCountry 无承接字段，ST036 必填四项未设置 - 待确认:ST036 调用参数的来源与映射，及 ST036 调用接口是否需要调整以承接 clientName/issCountry
        // {交易机构}（tranBranch，交易机构号）与 ST036 输入 acctBranch（账户开立行行号）字段名与业务含义不同，映射未确认（Spec 待确认事项 TBD-2）
        // FIXME 业务项:ST009/检查支取客户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:{交易机构}（tranBranch，交易机构号）与 ST036 输入 acctBranch（账户开立行行号）字段名与业务含义不同，ST009 步骤 4 未将 tranBranch 传入，映射未确认（Spec 待确认事项 TBD-2） - 影响:当前未设置 ST036InputBO.acctBranch，ST036 必填字段缺失 - 待确认:{交易机构}在 ST036 调用中的参数映射与用途
        ST036OutputBO st036Output = st036.execute(st036Input);
        // 组件内步骤调用失败处理：ST036 契约未定义业务失败（其 Spec 声明的「通过/拒绝/授权/提醒」均为步骤正常结束的业务结论），
        // 按调用约定先处理 isSucceed()==false：传播失败状态后返回，不发明码值
        if (!st036Output.isSucceed()) {
            output.setSucceed(false);
            output.setErrorCode(st036Output.getErrorCode());
            output.setErrorMessage(st036Output.getErrorMessage());
            return output;
        }

        // 步骤 5（REQ-005）：按[执行结果]分支返回
        DealFlow dealFlow = st036Output.getDealFlow();
        if (dealFlow == null || dealFlow == DealFlow.D) {
            // REQ-005-S01/S02：[执行结果]为通过（无 dealFlow）或提醒（dealFlow=D）→ 返回检查结果「通过」，步骤正常结束，不设置[授权标志]
            output.setSucceed(true);
        } else if (dealFlow == DealFlow.A) {
            // REQ-005-S03：[执行结果]为授权（dealFlow=A）→ 设置[授权标志]="是"，步骤正常结束；等待授权结果后再执行后续步骤（机制与执行主体见 TBD-4）
            output.setAuthorizationFlag("是");
            output.setSucceed(true);
        } else {
            // REQ-005-S04：[执行结果]为拒绝（dealFlow=B）→ 步骤业务失败，返回错误码"ER0003"；不设置[授权标志]
            // DealFlow 枚举仅 A/B/D 三种取值，与 null 合计已覆盖全部可达值（需求原文「否则」字面见 TBD-3，其余取值在类型层不可达）
            // FIXME 业务项:ST009/检查支取客户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:步骤 5「拒绝」分支错误码"ER0003"已确认，但 errorMessage 业务说明文案未提供（Spec 待确认事项 TBD-5） - 影响:当前 errorMessage 保持 null，不拼接空码或伪造业务说明 - 待确认:errorMessage 业务说明原文（按「ER0003::业务说明」格式填写）
            output.setErrorCode("ER0003");
            output.setSucceed(false);
        }
        return output;
    }
}
