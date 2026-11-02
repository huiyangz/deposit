package com.dcits.deposit.task.scenario;

import com.dcits.common.task.RespHeader;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.step.IST036;
import com.dcits.deposit.task.dto.T3S1InputDTO;
import com.dcits.deposit.task.dto.T3S1OutputDTO;
import org.springframework.stereotype.Component;

/**
 * T3S1 检查黑名单 交易接口场景。
 *
 * <p>接收需求「输入」表声明的 15 个输入字段（均为 {@code java.lang.String}），按业务
 * 含义逐一映射到唯一执行步骤 ST036（检查黑名单）的输入 {@link ST036InputBO} 并调用
 * {@link IST036#execute(ST036InputBO)}（REQ-001，ST036 为唯一执行步骤）。</p>
 *
 * <p>将步骤输出的业务结果 dealFlow（处理方式）原样传递为本交易接口业务输出：步骤返回
 * 「通过」时不设置（为空），返回「拒绝」「授权」「提醒」时分别取 {@code DealFlow.B/A/D}
 * 的编码值（REQ-002）。将步骤输出的公共执行状态（succeed/errorCode/errorMessage）原样
 * 传递为响应执行状态，与业务输出分开表达；步骤失败时短路，以失败状态返回并原样传递
 * errorCode/errorMessage，不设置业务输出 dealFlow（REQ-003）。</p>
 *
 * <p>接口层字段类型与 String↔枚举转换口径（含无对应取值时的行为）需求未定义
 * （Spec TBD-1），必填输入缺失或为空时的行为需求未定义（Spec TBD-2），两处均以业务
 * FIXME 记录待确认。</p>
 */
@Component
public class T3S1 {

    private final IST036 ist036;

    public T3S1(IST036 ist036) {
        this.ist036 = ist036;
    }

    public T3S1OutputDTO execute(RespHeader header, T3S1InputDTO input) {
        T3S1OutputDTO output = new T3S1OutputDTO();

        // FIXME 业务项:T3S1 检查黑名单 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求「输入」表全部 15 字段标记必填，ST036 步骤 BO 将 docClass、baseAcctNo、clientNo 声明为非必填，交易接口收到必填字段缺失或为空时的行为未定义（Spec TBD-2）。 - 影响:必填输入缺失或为空时是否校验拒绝、校验位置与错误码未确定，本场景不实现输入校验、按步骤契约原样传递。 - 待确认:必填输入缺失或为空时的接口行为与错误码。
        ST036InputBO st036Input = new ST036InputBO();
        // FIXME 业务项:T3S1 检查黑名单 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:需求将 15 个输入与 dealFlow 均声明为 java.lang.String，步骤 BO 对 docClass、acctBranch、sourceType、tranType、documentType 使用枚举类型（DocClass/TranBranch/SourceType/TranType/DocumentType），输出 dealFlow 使用 DealFlow，接口层字段类型与 String↔枚举转换口径未定义（Spec TBD-1）。 - 影响:本场景按真实 byValue(String) 转换（无匹配返回 null）与 getValue() 转回，无对应枚举取值时接口行为未确定。 - 待确认:接口层字段类型、String 编码与枚举业务编码对应方式、无对应取值时的行为。
        st036Input.setDocClass(DocClass.byValue(input.getDocClass()));
        st036Input.setBaseAcctNo(input.getBaseAcctNo());
        st036Input.setAcctBranch(TranBranch.byValue(input.getAcctBranch()));
        st036Input.setSourceType(SourceType.byValue(input.getSourceType()));
        st036Input.setProgramId(input.getProgramId());
        st036Input.setTranType(TranType.byValue(input.getTranType()));
        st036Input.setEventType(input.getEventType());
        st036Input.setServiceCode(input.getServiceCode());
        st036Input.setMessageType(input.getMessageType());
        st036Input.setMessageCode(input.getMessageCode());
        st036Input.setBlacklistCheckFlag(input.getBlacklistCheckFlag());
        st036Input.setServiceStatus(input.getServiceStatus());
        st036Input.setClientNo(input.getClientNo());
        st036Input.setDocumentId(input.getDocumentId());
        st036Input.setDocumentType(DocumentType.byValue(input.getDocumentType()));
        ST036OutputBO st036Output = ist036.execute(st036Input);

        if (!st036Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st036Output.getErrorCode());
            header.setErrorMessage(st036Output.getErrorMessage());
            return output;
        }

        // 业务输出：ST036 返回「通过」时 dealFlow 未设置（为空）；「拒绝/授权/提醒」时取对应处理方式编码值
        if (st036Output.getDealFlow() != null) {
            output.setDealFlow(st036Output.getDealFlow().getValue());
        }

        header.setSucceed(true);
        header.setErrorCode(null);
        header.setErrorMessage(null);
        return output;
    }
}
