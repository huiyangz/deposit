package com.dcits.deposit.task.scenario;

import com.dcits.common.task.RespHeader;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST048InputBO;
import com.dcits.deposit.facade.bo.ST048OutputBO;
import com.dcits.deposit.facade.bo.ST049InputBO;
import com.dcits.deposit.facade.bo.ST049OutputBO;
import com.dcits.deposit.facade.bo.ST050InputBO;
import com.dcits.deposit.facade.bo.ST050OutputBO;
import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.bo.ST053InputBO;
import com.dcits.deposit.facade.bo.ST053OutputBO;
import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;
import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057OutputBO;
import com.dcits.deposit.facade.bo.ST058InputBO;
import com.dcits.deposit.facade.bo.ST058OutputBO;
import com.dcits.deposit.facade.bo.ST059InputBO;
import com.dcits.deposit.facade.bo.ST059OutputBO;
import com.dcits.deposit.facade.bo.ST060InputBO;
import com.dcits.deposit.facade.bo.ST060OutputBO;
import com.dcits.deposit.facade.bo.ST061InputBO;
import com.dcits.deposit.facade.bo.ST061OutputBO;
import com.dcits.deposit.facade.bo.ST062InputBO;
import com.dcits.deposit.facade.bo.ST062OutputBO;
import com.dcits.deposit.step.IST048;
import com.dcits.deposit.step.IST049;
import com.dcits.deposit.step.IST050;
import com.dcits.deposit.step.IST051;
import com.dcits.deposit.step.IST052;
import com.dcits.deposit.step.IST053;
import com.dcits.deposit.step.IST054;
import com.dcits.deposit.step.IST055;
import com.dcits.deposit.step.IST056;
import com.dcits.deposit.step.IST057;
import com.dcits.deposit.step.IST058;
import com.dcits.deposit.step.IST059;
import com.dcits.deposit.step.IST060;
import com.dcits.deposit.step.IST061;
import com.dcits.deposit.step.IST062;
import com.dcits.deposit.task.dto.T2S1InputDTO;
import com.dcits.deposit.task.dto.T2S1OutputDTO;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * T2S1 检查账户限制 交易接口场景。
 *
 * <p>按 Spec「执行步骤」表顺序依次执行 ST048–ST062 共 15 步（REQ-002-S01）：接口输入
 * 按 REQ-003 映射传递（baseAcctNo 传递至以账号为必填输入的 12 个步骤，
 * tranType/restraintType 传递至 ST048 与 ST057，sourceType 传递至 ST048）；ST051
 * 取得的[账户限制信息]作为 ST059 的输入集合（REQ-004）。全部步骤正常完成后按 REQ-005
 * 装配输出并以成功响应结束。</p>
 *
 * <p>需求未声明接口级终止与短路条件（Spec TBD-2，见 execute 前的业务 FIXME），本场景
 * 仅按步骤顺序依次执行，任一步骤失败时按步骤结果契约短路；必填输入缺失或枚举映射
 * 失败的接口行为未定义（Spec TBD-3）；ST048 输入缺口（TBD-1）与 ST059 输入缺口
 * （TBD-5）见对应构造位置的业务 FIXME。</p>
 */
@Component
public class T2S1 {

    private final IST048 ist048;
    private final IST049 ist049;
    private final IST050 ist050;
    private final IST051 ist051;
    private final IST052 ist052;
    private final IST053 ist053;
    private final IST054 ist054;
    private final IST055 ist055;
    private final IST056 ist056;
    private final IST057 ist057;
    private final IST058 ist058;
    private final IST059 ist059;
    private final IST060 ist060;
    private final IST061 ist061;
    private final IST062 ist062;

    /**
     * 注入 15 个步骤接口。
     */
    public T2S1(IST048 ist048, IST049 ist049, IST050 ist050, IST051 ist051,
            IST052 ist052, IST053 ist053, IST054 ist054, IST055 ist055, IST056 ist056,
            IST057 ist057, IST058 ist058, IST059 ist059, IST060 ist060, IST061 ist061,
            IST062 ist062) {
        this.ist048 = ist048;
        this.ist049 = ist049;
        this.ist050 = ist050;
        this.ist051 = ist051;
        this.ist052 = ist052;
        this.ist053 = ist053;
        this.ist054 = ist054;
        this.ist055 = ist055;
        this.ist056 = ist056;
        this.ist057 = ist057;
        this.ist058 = ist058;
        this.ist059 = ist059;
        this.ist060 = ist060;
        this.ist061 = ist061;
        this.ist062 = ist062;
    }

    // FIXME 业务项:T2S1 检查账户限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:需求「执行步骤」表仅声明步骤清单，未声明步骤结果（ST048 豁免检查结论、ST057 检查结果、各「是」/「否」判定标志）对后续步骤执行与接口最终返回的影响（Spec TBD-2）。 - 影响:步骤为「不检查限制」/「豁免」时接口是否终止并返回、各判定标志是否影响接口结论未确定，本场景仅按步骤顺序依次执行、不实现任何接口级分支。 - 待确认:接口级分支、终止与短路条件。

    /**
     * 执行 T2S1 检查账户限制。
     *
     * @param header 调用方传入的响应头，全部步骤正常完成时置成功并清除旧错误
     * @param input 四个必填输入（baseAcctNo/tranType/sourceType/restraintType）
     * @return 输出 DTO；任一步骤失败时返回未装配完成的输出并置传入 header 失败
     */
    public T2S1OutputDTO execute(RespHeader header, T2S1InputDTO input) {
        T2S1OutputDTO output = new T2S1OutputDTO();

        // 步骤 1 ST048 检查限制豁免（REQ-003-S02：sourceType/restraintType/tranType 映射为枚举）
        // FIXME 业务项:T2S1 检查账户限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:接口四个输入均标记必填，字符串无法映射为枚举取值（SourceType/TranType/RestraintType 的 byValue 无匹配返回 null）或输入为空时接口是否报错、错误码与错误信息未定义（Spec TBD-3），本场景按 byValue 实际结果原样传递给步骤。 - 影响:枚举映射失败或输入为空时步骤输入含 null 枚举取值，接口失败行为未确定。 - 待确认:必填输入缺失或枚举映射失败时的接口行为与错误码。
        ST048InputBO st048Input = new ST048InputBO();
        st048Input.setSourceType(SourceType.byValue(input.getSourceType()));
        st048Input.setRestraintType(RestraintType.byValue(input.getRestraintType()));
        st048Input.setTranType(TranType.byValue(input.getTranType()));
        // FIXME 业务项:T2S1 检查账户限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST048 输入契约要求 narrativeCode（摘要码）与产品类型两个必填输入，接口「输入」表仅提供 baseAcctNo/tranType/sourceType/restraintType 四项（Spec TBD-1）。 - 影响:ST048InputBO 的 narrativeCode、productType 无提供方式、保持未设置，ST048 豁免检查输入不完整。 - 待确认:该两输入的提供方式及「产品类型」与 prodNo 的映射关系。
        ST048OutputBO st048Output = ist048.execute(st048Input);
        if (!st048Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st048Output.getErrorCode());
            header.setErrorMessage(st048Output.getErrorMessage());
            return output;
        }

        // 步骤 2 ST049 检查转账止收限制
        ST049InputBO st049Input = new ST049InputBO();
        st049Input.setBaseAcctNo(input.getBaseAcctNo());
        ST049OutputBO st049Output = ist049.execute(st049Input);
        if (!st049Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st049Output.getErrorCode());
            header.setErrorMessage(st049Output.getErrorMessage());
            return output;
        }

        // 步骤 3 ST050 检查有权机关冻结限制
        ST050InputBO st050Input = new ST050InputBO();
        st050Input.setBaseAcctNo(input.getBaseAcctNo());
        ST050OutputBO st050Output = ist050.execute(st050Input);
        if (!st050Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st050Output.getErrorCode());
            header.setErrorMessage(st050Output.getErrorMessage());
            return output;
        }

        // 步骤 4 ST051 检查账户是否存在限制
        ST051InputBO st051Input = new ST051InputBO();
        st051Input.setBaseAcctNo(input.getBaseAcctNo());
        ST051OutputBO st051Output = ist051.execute(st051Input);
        if (!st051Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st051Output.getErrorCode());
            header.setErrorMessage(st051Output.getErrorMessage());
            return output;
        }

        // 步骤 5 ST052 检查是否存在转账止付限制
        ST052InputBO st052Input = new ST052InputBO();
        st052Input.setBaseAcctNo(input.getBaseAcctNo());
        ST052OutputBO st052Output = ist052.execute(st052Input);
        if (!st052Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st052Output.getErrorCode());
            header.setErrorMessage(st052Output.getErrorMessage());
            return output;
        }

        // 步骤 6 ST053 检查质押类限制
        ST053InputBO st053Input = new ST053InputBO();
        st053Input.setBaseAcctNo(input.getBaseAcctNo());
        ST053OutputBO st053Output = ist053.execute(st053Input);
        if (!st053Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st053Output.getErrorCode());
            header.setErrorMessage(st053Output.getErrorMessage());
            return output;
        }

        // 步骤 7 ST054 检查是否存在现金止收限制
        ST054InputBO st054Input = new ST054InputBO();
        st054Input.setBaseAcctNo(input.getBaseAcctNo());
        ST054OutputBO st054Output = ist054.execute(st054Input);
        if (!st054Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st054Output.getErrorCode());
            header.setErrorMessage(st054Output.getErrorMessage());
            return output;
        }

        // 步骤 8 ST055 检查是否存在止付限制
        ST055InputBO st055Input = new ST055InputBO();
        st055Input.setBaseAcctNo(input.getBaseAcctNo());
        ST055OutputBO st055Output = ist055.execute(st055Input);
        if (!st055Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st055Output.getErrorCode());
            header.setErrorMessage(st055Output.getErrorMessage());
            return output;
        }

        // 步骤 9 ST056 检查是否存在转账不收不付限制
        ST056InputBO st056Input = new ST056InputBO();
        st056Input.setBaseAcctNo(input.getBaseAcctNo());
        ST056OutputBO st056Output = ist056.execute(st056Input);
        if (!st056Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st056Output.getErrorCode());
            header.setErrorMessage(st056Output.getErrorMessage());
            return output;
        }

        // 步骤 10 ST057 检查限制优先级（REQ-003-S02：tranType/restraintType 映射为枚举）
        ST057InputBO st057Input = new ST057InputBO();
        st057Input.setTranType(TranType.byValue(input.getTranType()));
        st057Input.setRestraintType(RestraintType.byValue(input.getRestraintType()));
        ST057OutputBO st057Output = ist057.execute(st057Input);
        if (!st057Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st057Output.getErrorCode());
            header.setErrorMessage(st057Output.getErrorMessage());
            return output;
        }

        // 步骤 11 ST058 检查是否存在不收不付限制
        ST058InputBO st058Input = new ST058InputBO();
        st058Input.setBaseAcctNo(input.getBaseAcctNo());
        ST058OutputBO st058Output = ist058.execute(st058Input);
        if (!st058Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st058Output.getErrorCode());
            header.setErrorMessage(st058Output.getErrorMessage());
            return output;
        }

        // 步骤 12 ST059 检查账户是否存在不允许销户的限制（REQ-004-S01：ST051 取得的[账户限制信息]作为输入集合）
        ST059InputBO st059Input = new ST059InputBO();
        ST059InputBO.RestraintInfo restraintInfo = new ST059InputBO.RestraintInfo();
        restraintInfo.setResSeqNo(st051Output.getResSeqNo());
        restraintInfo.setRestraintType(st051Output.getRestraintType());
        restraintInfo.setRestraintsStatus(st051Output.getRestraintsStatus());
        // FIXME 业务项:T2S1 检查账户限制 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST059 输入契约要求每条[账户限制信息]记录含必填字段 restraintLevel（限制级别，来源 RB_BUS_RESTRAINTS），ST051 输出契约不含该字段（Spec TBD-5）。 - 影响:ST059InputBO.RestraintInfo.restraintLevel 无取得来源、保持未设置。 - 待确认:ST059 输入中 restraintLevel 的取得来源及 ST051 与 ST059 数据传递关系的显式约定。
        st059Input.setRestraintList(List.of(restraintInfo));
        ST059OutputBO st059Output = ist059.execute(st059Input);
        if (!st059Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st059Output.getErrorCode());
            header.setErrorMessage(st059Output.getErrorMessage());
            return output;
        }

        // 步骤 13 ST060 检查是否存在现金不收不付限制
        ST060InputBO st060Input = new ST060InputBO();
        st060Input.setBaseAcctNo(input.getBaseAcctNo());
        ST060OutputBO st060Output = ist060.execute(st060Input);
        if (!st060Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st060Output.getErrorCode());
            header.setErrorMessage(st060Output.getErrorMessage());
            return output;
        }

        // 步骤 14 ST061 检查是否存在属性限制
        ST061InputBO st061Input = new ST061InputBO();
        st061Input.setBaseAcctNo(input.getBaseAcctNo());
        ST061OutputBO st061Output = ist061.execute(st061Input);
        if (!st061Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st061Output.getErrorCode());
            header.setErrorMessage(st061Output.getErrorMessage());
            return output;
        }

        // 步骤 15 ST062 检查是否存在现金止付限制
        ST062InputBO st062Input = new ST062InputBO();
        st062Input.setBaseAcctNo(input.getBaseAcctNo());
        ST062OutputBO st062Output = ist062.execute(st062Input);
        if (!st062Output.isSucceed()) {
            header.setSucceed(false);
            header.setErrorCode(st062Output.getErrorCode());
            header.setErrorMessage(st062Output.getErrorMessage());
            return output;
        }

        // 全部步骤正常完成，按 REQ-005 装配「输出」表已确认字段（取值与对应步骤输出一致）
        output.set属性限制标志(st061Output.get属性限制标志());
        output.setStopFlag(st055Output.getStopFlag());
        output.set不收不付标志(st058Output.getNoCreditNoDebitFlag());
        output.set现金不收不付限制标志(st060Output.getCashNoReceiveNoPayFlag());
        output.set转账不收不付标志(st056Output.getTransferNoCreditNoDebitFlag());
        output.setBaseAcctNo(st051Output.getBaseAcctNo());
        output.setLeadAcctFlag(st051Output.getLeadAcctFlag());
        output.setProdNo(st048Output.getProdNo());
        output.setTranTypeLink(st048Output.getTranTypeLink());
        output.setChannelMuster(st048Output.getChannelMuster());
        output.setNarrativeCode(st048Output.getNarrativeCode());
        output.setPledgedFlag(st053Output.getPledgedFlag());

        // 成功响应：显式置成功并清除复用响应头中的旧错误
        header.setSucceed(true);
        header.setErrorCode(null);
        header.setErrorMessage(null);
        return output;
    }
}
