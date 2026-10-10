package com.dcits.depsit.task.scenario;

import com.dcits.common.task.RespHeader;
import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.enums.DocClass;
import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranType;
import com.dcits.depsit.facade.bo.ST100InputBO;
import com.dcits.depsit.facade.bo.ST100OutputBO;
import com.dcits.depsit.step.IST100;
import com.dcits.depsit.task.dto.T5S1InputDTO;
import com.dcits.depsit.task.dto.T5S1OutputDTO;
import org.springframework.stereotype.Component;

/**
 * T5S1 检查黑名单 —— 交易场景。
 *
 * <p>编排（源需求「## 执行步骤」表，本交易唯一一步）：按声明顺序调用组件内步骤
 * {@code ST100}「检查黑名单」一次，把交易「## 输入」表的 15 个字段按字段名一一传入该步骤的
 * 同名字段（{@code ST100InputBO}），不做变形、不补默认值；随后把步骤唯一业务输出
 * {@code dealFlow}（处理方式）映射为交易唯一业务输出 {@code dealFlow}（REQ-002、REQ-004）。
 * 本交易不调用需求未声明的其它步骤或外部组件，自身不访问任何数据表（REQ-002-S02）。</p>
 *
 * <p>映射口径（REQ-003、REQ-004）：入参 {@code docClass}／{@code acctBranch}／
 * {@code sourceType}／{@code tranType}／{@code documentType} 以业务码值承载，经枚举已声明的
 * {@code byValue(String)} 转换为步骤侧枚举（MUST NOT 以 {@code valueOf}、{@code name()}、
 * {@code toString()} 或常量名代替业务编码）；输出 {@code dealFlow} 取
 * {@link DealFlow#getValue()} 码值字符串（{@code B}／{@code A}／{@code D}），步骤输出无值
 * （检查结果为「通过」）时保持无值，不以业务常量占位（REQ-004-S03）。检查结果的判定由步骤
 * 自身规则给出，交易层不重新判定、不新增映射来源。</p>
 *
 * <p>响应头口径（REQ-006）：步骤正常完成（含检查结果为「通过」以及命中「拒绝」「授权」
 * 「提醒」）时显式置 {@code succeed = true} 并清空 {@code errorCode}／{@code errorMessage}；
 * 三个命中结果均为正常完成的检查结果，MUST NOT 表达为失败。响应头与交易业务输出为两个独立
 * 对象，成功状态不通过业务输出对象承载。</p>
 *
 * <p>无业务失败结论（REQ-007）：本交易唯一被调步骤的正式 Spec 声明无业务失败场景
 * （任何已定义路径均返回 {@code succeed = true}），需求正文亦无「## 失败处理」章节与错误码，
 * 故本场景不设置业务错误码、不引用错误码资源、不新增失败分支；依赖的数据访问或运行环境异常
 * 按技术异常向上传播，本场景不捕获、不包装、不以占位值兜底。</p>
 *
 * <p>事务口径（技术核对，非业务新增）：唯一被调步骤为只读检查，本交易不新增、修改或删除任何
 * 数据（本任务事务边界判定结论：写入集合仅含只读步骤 {@code ST100}，本地事务），
 * {@link IST100} 的 Javadoc 亦声明只读、不产生跨组件调用，故本场景不添加事务注解。</p>
 */
@Component
public class T5S1 {

    /** 唯一被调步骤：ST100 检查黑名单（只读检查，无业务失败场景）。 */
    private final IST100 st100;

    public T5S1(IST100 st100) {
        this.st100 = st100;
    }

    /**
     * 执行「检查黑名单」交易。
     *
     * @param header 调用方传入的响应头，保留同一实例；本次执行正常完成时置
     *               {@code succeed = true} 并清空错误字段
     * @param input  交易对外输入，业务字段为「## 输入」表的 15 项
     * @return 交易对外业务输出 {@code dealFlow}（处理方式码值；检查结果为「通过」时无取值）
     */
    public T5S1OutputDTO execute(RespHeader header, T5S1InputDTO input) {
        T5S1OutputDTO output = new T5S1OutputDTO();

        // 执行步骤 1（唯一一步）：ST100「检查黑名单」。
        // 15 个交易入参按字段名一一传入步骤同名入参，原值直传、不补默认值；
        // 5 个枚举类字段按业务码值经 byValue 转换（REQ-002、REQ-003）
        ST100InputBO st100Input = new ST100InputBO();
        st100Input.setDocClass(DocClass.byValue(input.getDocClass()));
        st100Input.setBaseAcctNo(input.getBaseAcctNo());
        st100Input.setAcctBranch(TranBranch.byValue(input.getAcctBranch()));
        st100Input.setSourceType(SourceType.byValue(input.getSourceType()));
        st100Input.setProgramId(input.getProgramId());
        st100Input.setTranType(TranType.byValue(input.getTranType()));
        st100Input.setEventType(input.getEventType());
        st100Input.setServiceCode(input.getServiceCode());
        st100Input.setMessageType(input.getMessageType());
        st100Input.setMessageCode(input.getMessageCode());
        st100Input.setBlacklistCheckFlag(input.getBlacklistCheckFlag());
        st100Input.setServiceStatus(input.getServiceStatus());
        st100Input.setClientNo(input.getClientNo());
        st100Input.setDocumentId(input.getDocumentId());
        st100Input.setDocumentType(DocumentType.byValue(input.getDocumentType()));

        ST100OutputBO st100Output = st100.execute(st100Input);

        // 步骤唯一业务输出 dealFlow 映射为交易业务输出（REQ-004）：
        // 取枚举码值字符串，检查结果为「通过」时步骤输出无值、交易输出同样无取值，不占位
        output.setDealFlow(codeOf(st100Output.getDealFlow()));

        // 步骤正常完成（含检查结果为「通过」）即为成功响应；显式清理复用响应头中的旧错误（REQ-006）
        header.setSucceed(true);
        header.setErrorCode(null);
        header.setErrorMessage(null);
        return output;
    }

    /**
     * 把步骤输出的 {@link DealFlow} 转换为对外业务编码：取枚举已声明的 {@code getValue()}
     * 码值字符串（已确认码值 {@code A}＝授权、{@code B}＝拒绝、{@code D}＝提醒），
     * 不以常量名或 {@code toString()} 代替（REQ-004、REQ-005）。
     *
     * @param dealFlow 步骤输出的处理方式，检查结果为「通过」时为 {@code null}
     * @return 码值字符串；入参为空值时返回 {@code null}（空值保持空值，不以业务常量占位）
     */
    private static String codeOf(DealFlow dealFlow) {
        return dealFlow == null ? null : dealFlow.getValue();
    }
}
