package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.facade.bo.ST013InputBO;
import com.dcits.deposit.facade.bo.ST013OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;

/**
 * ST013 检查对手客户黑名单 步骤实现。
 *
 * <p>按正式 Spec 子步骤 REQ-001~REQ-005 依次执行：第 1 步按{对手客户号}查询【客户证件信息】
 * 获取客户名称/证件类型/证件号码/发证国家，第 2 步按{凭证类型}查询【凭证信息】获取凭证种类，
 * 第 3 步赋值[事件类型]为「CRET」，第 4 步以输入及第 1~3 步取值按组件内步骤调用方式调用本组件
 * 内步骤 ST036「检查黑名单」获取[执行结果]，第 5 步按[执行结果]分派：「通过/提醒」返回检查结果
 * 「通过」、「授权」返回授权标志「是」、「拒绝」返回错误码 ER0003。</p>
 */
@Service
public class ST013Pbc implements IST013 {

    @Autowired
    private IFmClientCopyBcc ifmClientCopyBcc;

    @Autowired
    private ITbVoucherDefBcc itbVoucherDefBcc;

    @Autowired
    private IST036 iST036;

    @Override
    public ST013OutputBO execute(ST013InputBO input) {
        // FIXME 业务项:ST013 检查对手客户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:必填输入（othClientNo/tranBranch/tranType/serviceCode/messageCode/messageType/sourceType）缺失时的校验与失败行为未定义 - 影响:当前实现不校验必填输入，输入缺失时仍继续执行后续子步骤 - 待确认:必填输入缺失时应返回何种失败结果与错误码
        ST013OutputBO output = new ST013OutputBO();

        // 第 1 步（REQ-001）：按{对手客户号}查询【客户证件信息】（客户副本表 FM_CLIENT_COPY）
        // FIXME 业务项:ST013 检查对手客户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:按{对手客户号}定位客户副本表记录的实际查询路径未确认，FmClientCopyEO 无客户号字段、IFmClientCopyBcc 无按客户号查询方法（TBD-1） - 影响:当前以空查询条件调用 findByEo 获取客户证件信息，未按对手客户号过滤 - 待确认:按对手客户号定位 FM_CLIENT_COPY 记录的查询键与方法
        FmClientCopyEO client = firstRecord(ifmClientCopyBcc.findByEo(new FmClientCopyEO()));
        if (client != null) {
            output.setClientName(client.getClientName());
            output.setDocumentType(client.getDocumentType());
            output.setDocumentId(client.getDocumentId());
            output.setIssCountry(client.getIssCountry());
        }

        // 第 2 步（REQ-002）：按{凭证类型}查询【凭证信息】（凭证类型定义表 TB_VOUCHER_DEF）
        TbVoucherDefEO voucherDef = itbVoucherDefBcc.findByDocType(input.getDocType());
        // FIXME 业务项:ST013 检查对手客户黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按{对手客户号}查询【客户证件信息】、按{凭证类型}查询【凭证信息】无匹配记录时的行为未定义（TBD-5） - 影响:当前无记录时客户证件信息/凭证种类为空并继续执行后续子步骤 - 待确认:第 1/2 步查询无记录时步骤应返回何种结果（业务失败及错误码，或继续以空值执行）
        if (voucherDef != null) {
            output.setDocClass(voucherDef.getDocClass());
        }

        // 第 3 步（REQ-003）：赋值[事件类型]为常量「CRET」
        output.setEventType("CRET");

        // 第 4 步（REQ-004）：以输入及第 1~3 步取值按组件内步骤调用方式调用 ST036「检查黑名单」
        ST036InputBO st036Input = new ST036InputBO();
        st036Input.setBaseAcctNo(input.getOthBaseAcctNo());
        st036Input.setClientNo(input.getOthClientNo());
        st036Input.setTranType(input.getTranType());
        st036Input.setSourceType(input.getSourceType());
        st036Input.setEventType("CRET");
        st036Input.setServiceCode(input.getServiceCode());
        st036Input.setMessageType(input.getMessageType());
        st036Input.setMessageCode(input.getMessageCode());
        st036Input.setDocClass(output.getDocClass());
        st036Input.setDocumentType(output.getDocumentType());
        st036Input.setDocumentId(output.getDocumentId());
        // FIXME 业务项:ST013 检查对手客户黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST036 调用参数映射未确认（TBD-2）：{交易机构}（tranBranch）与 ST036InputBO.acctBranch（账户开立行行号）语义不一致，[客户名称]/[发证国家] 在 ST036InputBO 无对应字段，ST036InputBO 必填的 programId/blacklistCheckFlag/serviceStatus 不在需求调用参数清单中 - 影响:上述六项当前未传值（保持 null），未按需求十四项参数完整传值 - 待确认:各调用参数到 ST036InputBO 字段的映射及缺项取值来源
        ST036OutputBO st036Output = iST036.execute(st036Input);

        // 第 5 步（REQ-005）：按[执行结果]分派结果
        DealFlow dealFlow = st036Output.getDealFlow();
        if (dealFlow == DealFlow.B) {
            // [执行结果]为「拒绝」：本步骤业务失败，返回错误码 ER0003
            output.setSucceed(false);
            output.setErrorCode("ER0003");
            output.setErrorMessage("ER0003::黑名单客户，拒绝交易");
            return output;
        }
        if (dealFlow == DealFlow.A) {
            // [执行结果]为「授权」：返回授权标志为「是」并等待授权结果后再执行后续步骤
            // FIXME 业务项:ST013 检查对手客户黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:授权分支的步骤结束状态（succeed 取值）、是否设置 tranStatus 及授权等待机制（步骤内表达或交易流程编排）未定义（TBD-3） - 影响:当前以 succeed=true、错误字段为空并输出授权标志「是」表达本分支，授权等待由调用方编排 - 待确认:授权分支 succeed/tranStatus 取值与授权等待机制
            output.setAuthFlag("是");
            output.setSucceed(true);
            return output;
        }
        // [执行结果]为「通过」（dealFlow 为空）或「提醒」（dealFlow=D）：返回检查结果「通过」
        output.setSucceed(true);
        return output;
    }

    /**
     * 面向单条结果查询：无记录返回空、多条取结果集第一条。
     *
     * @param records 查询结果集
     * @return 结果集第一条记录，无记录时返回 null
     */
    private FmClientCopyEO firstRecord(List<FmClientCopyEO> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        return records.get(0);
    }
}
