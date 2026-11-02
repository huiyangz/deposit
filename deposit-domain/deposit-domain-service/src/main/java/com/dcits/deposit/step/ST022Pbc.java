package com.dcits.deposit.step;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.facade.bo.ST022InputBO;
import com.dcits.deposit.facade.bo.ST022OutputBO;
import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;
import com.dcits.deposit.facade.bo.ST038InputBO;
import com.dcits.deposit.facade.bo.ST038OutputBO;
import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;
import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;
import com.dcits.deposit.facade.bo.ST041InputBO;
import com.dcits.deposit.facade.bo.ST041OutputBO;
import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;
import com.dcits.deposit.facade.bo.ST043InputBO;
import com.dcits.deposit.facade.bo.ST043OutputBO;
import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;
import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;
import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;

/**
 * ST022 检查对手账户限额 步骤实现。
 *
 * <p>按正式 Spec「步骤描述」第 1–14 项编排：ST043 匹配限额场景 → ST038/ST045/ST037 机构匹配、
 * 配置有效性与场景编码确认（任一返回空[限额场景编码]即返回「通过」提前结束）→ ST042/ST039 取得
 * 累计值 → ST040 检查限额：未超限跳转步骤 12 按累计情况调 ST046（更新）或 ST044（登记），超限调
 * ST041 按处理方式返回（拒绝→错误码 ER0058、授权→授权标志「需授权」、提示→正常结束）。</p>
 *
 * <p>本步骤调用 ST046/ST044，二者会写入限额累计信息表（RB_LIMIT_SUM_INFO），{@code execute}
 * 以 {@code @Transactional} 声明本地写事务，调用方须在事务中调用（见 {@link IST022}）。</p>
 *
 * <p>业务定义缺口（交易金额来源、ST043/ST039/ST037 调用参数、累计值数据流向、检查结果承载、
 * 「提示」/「提醒」命名、授权等待机制、tranStatus 取值、runDate 来源、输出重复字段）见代码内
 * FIXME（Spec 待确认事项 TBD-01~TBD-12），确认前不补默认行为。</p>
 */
@Service
public class ST022Pbc implements IST022 {

    @Autowired
    private IST043 st043;

    @Autowired
    private IST038 st038;

    @Autowired
    private IST045 st045;

    @Autowired
    private IST037 st037;

    @Autowired
    private IST042 st042;

    @Autowired
    private IST039 st039;

    @Autowired
    private IST040 st040;

    @Autowired
    private IST041 st041;

    @Autowired
    private IST046 st046;

    @Autowired
    private IST044 st044;

    @Override
    @Transactional
    public ST022OutputBO execute(ST022InputBO input) {
        // REQ-002 步骤 1：按{限额因子}调用 ST043 匹配限额场景，取[执行结果]
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-002 步骤 1 按{对手客户号}、{对手账号}、{限额因子}调用 ST043，但 ST043InputBO 仅含 factorName（对手客户号/对手账号未登记），且 ST043OutputBO 未暴露检查结果（"已匹配到限额场景"/"未匹配到限额场景"，ST043 正式 Spec TBD-5），TBD-02 - 影响:当前仅传 factorName（←{因子名称}），ST043 返回成功即继续执行，无法实现 REQ-002-S02「执行结果非已匹配→返回『通过』」短路 - 待确认:ST043 完整调用参数及[执行结果]的承载字段/判断方式
        ST043InputBO st043Input = new ST043InputBO();
        st043Input.setFactorName(input.get因子名称());
        ST043OutputBO st043Result = st043.execute(st043Input);
        if (!st043Result.isSucceed()) {
            return propagateFailure(st043Result);
        }

        // REQ-003 步骤 3：按{对手账号}调用 ST038 检查账户机构是否可匹配到限额场景配置，
        // [限额场景编码] 为空即返回「通过」提前结束
        ST038InputBO st038Input = new ST038InputBO();
        st038Input.setBaseAcctNo(input.getOthBaseAcctNo());
        ST038OutputBO st038Result = st038.execute(st038Input);
        if (!st038Result.isSucceed()) {
            return propagateFailure(st038Result);
        }
        String limitSceneNo = st038Result.getLimitSceneNo();
        if (limitSceneNo == null) {
            return passResult();
        }

        // REQ-003 步骤 4：按[限额场景编码]、{交易日期}、{交易时间}调用 ST045 检查限额场景
        // 配置是否有效，[限额场景编码] 为空即返回「通过」提前结束
        ST045InputBO st045Input = new ST045InputBO();
        st045Input.setLimitSceneNo(limitSceneNo);
        st045Input.setTranDate(input.getTranDate());
        st045Input.setTranTimestamp(input.getTranTimestamp());
        ST045OutputBO st045Result = st045.execute(st045Input);
        if (!st045Result.isSucceed()) {
            return propagateFailure(st045Result);
        }
        limitSceneNo = st045Result.getLimitSceneNo();
        if (limitSceneNo == null) {
            return passResult();
        }

        // REQ-003 步骤 5：按[限额场景编码]、{对手账号}、{对手客户号}调用 ST037 获取限额场景编码，
        // [限额场景编码] 为空即返回「通过」提前结束
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-003 步骤 5 按[限额场景编码]、{对手账号}、{对手客户号}调用 ST037，而 ST037InputBO 必填输入含 tranDate，需求步骤 5 未列出，TBD-03 - 影响:当前不向 ST037 补传 tranDate，调用缺必填参数 - 待确认:是否向 ST037 补传 tranDate={交易日期}（tranDate 输入值）
        ST037InputBO st037Input = new ST037InputBO();
        st037Input.setLimitSceneNo(limitSceneNo);
        st037Input.setBaseAcctNo(input.getOthBaseAcctNo());
        st037Input.setClientNo(input.getOthClientNo());
        ST037OutputBO st037Result = st037.execute(st037Input);
        if (!st037Result.isSucceed()) {
            return propagateFailure(st037Result);
        }
        limitSceneNo = st037Result.getLimitSceneNo();
        if (limitSceneNo == null) {
            return passResult();
        }

        // REQ-004 步骤 6：按[限额场景编码]、{对手账号}、{对手客户号}调用 ST042 获取累计限额，
        // 取得[限额累计金额]（limitSumAmt）与[限额累计笔数]（「否」）
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:REQ-004 步骤 7（ST039）计算结果是否覆盖[限额累计金额]/[限额累计笔数]用于 ST040、步骤 12 与 ST046 未明确，ST042 无匹配记录时累计值取值及 null 值参与比较的口径亦未定义，TBD-05 - 影响:当前累计值按 ST042 输出承接、ST039 结果不消费，null 按 0 参与比较，口径可能不符 - 待确认:各环节实际使用的累计值来源及空值口径
        ST042InputBO st042Input = new ST042InputBO();
        st042Input.setLimitSceneNo(limitSceneNo);
        st042Input.setBaseAcctNo(input.getOthBaseAcctNo());
        st042Input.setClientNo(input.getOthClientNo());
        ST042OutputBO st042Result = st042.execute(st042Input);
        if (!st042Result.isSucceed()) {
            return propagateFailure(st042Result);
        }
        BigDecimal limitSumAmt = st042Result.getLimitSumAmt();
        Integer limitSumNum = st042Result.get否();

        // REQ-004 步骤 7：按[限额场景编码]调用 ST039 计算限额累计金额
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-004 步骤 7 调 ST039 需{交易金额}（ST039InputBO.tranAmt），ST022「输入」表未声明交易金额字段，TBD-01 - 影响:当前不设置 ST039InputBO.tranAmt，累计限额计算缺少交易金额 - 待确认:ST022 从何处取得交易金额并传入 ST039
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-004 步骤 7 按{对手账号}、{对手客户号}、{交易金额}、[限额场景编码]调用 ST039，但 ST039InputBO 仅含 tranAmt/limitSceneNo，无对手账号/客户号字段（ST039 正式 Spec TBD-2 亦在确认检查对象值来源），TBD-04 - 影响:{对手账号}/{对手客户号}在 ST039 调用中的用途与传递方式不可实现 - 待确认:{对手账号}/{对手客户号}在 ST039 调用中的用途与传递方式
        ST039InputBO st039Input = new ST039InputBO();
        st039Input.setLimitSceneNo(limitSceneNo);
        ST039OutputBO st039Result = st039.execute(st039Input);
        if (!st039Result.isSucceed()) {
            return propagateFailure(st039Result);
        }
        // ST039 计算结果用途见步骤 6 处 FIXME（TBD-05）；累计值仍按 ST042 输出承接

        // REQ-005 步骤 8：按[限额场景编码]、[限额累计金额]、[限额累计笔数]调用 ST040 检查限额，
        // 取[限额检查结果]
        ST040InputBO st040Input = new ST040InputBO();
        st040Input.setLimitSceneNo(limitSceneNo);
        st040Input.setLimitSumAmt(limitSumAmt);
        st040Input.setLimitSumNum(limitSumNum);
        ST040OutputBO st040Result = st040.execute(st040Input);
        if (!st040Result.isSucceed()) {
            return propagateFailure(st040Result);
        }
        String limitCheckResult = st040Result.getLimitCheckResult();

        // REQ-005 步骤 9：[限额检查结果]="未超限"时跳转步骤 12（按累计情况判断更新分支），
        // 不调用 ST041；否则继续步骤 10 按处理方式返回
        if ("未超限".equals(limitCheckResult)) {
            return judgeLimitUpdateBranch(input, limitSceneNo, limitSumAmt, limitSumNum, limitCheckResult);
        }

        // REQ-006 步骤 10：按[限额场景编码]调用 ST041 处理限额，取处理方式（dealFlow）
        ST041InputBO st041Input = new ST041InputBO();
        st041Input.setLimitSceneNo(limitSceneNo);
        ST041OutputBO st041Result = st041.execute(st041Input);
        if (!st041Result.isSucceed()) {
            return propagateFailure(st041Result);
        }
        DealFlow dealFlow = st041Result.getDealFlow();
        if (dealFlow == DealFlow.B) {
            // REQ-006 步骤 11a：处理方式为「拒绝」→ 返回[错误码]"ER0058"并以业务失败结束
            ST022OutputBO result = new ST022OutputBO();
            result.setSucceed(false);
            result.setErrorCode("ER0058");
            result.setErrorMessage("ER0058::交易超出限额控制");
            return result;
        }
        if (dealFlow == DealFlow.A) {
            // REQ-006 步骤 11b：处理方式为「授权」→ 返回[授权标志]"需授权"并等待授权
            // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:REQ-006 步骤 11b 返回[授权标志]="需授权"并等待授权，授权等待期间状态、授权结果回传与恢复/结束方式未定义，TBD-09 - 影响:当前仅返回授权标志"需授权"并以成功结束，未实现等待/恢复 - 待确认:授权等待的机制（等待期间状态、授权结果回传、恢复或结束方式）
            ST022OutputBO result = new ST022OutputBO();
            result.set授权标志("需授权");
            result.setSucceed(true);
            return result;
        }
        // REQ-006 步骤 11c：处理方式为「提示」（DealFlow.D 提醒）→ 返回检查结果"超限，但可继续交易"并正常结束
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:REQ-006 步骤 11c 用"提示"，ST041 正式 Spec 用"提醒"（DealFlow.D=提醒处理），需求将检查结果"提示"映射为返回"超限，但可继续交易"，TBD-08 - 影响:当前按 DealFlow.D 非 B/A 兜底为提示分支，分支判定取值可能不符 - 待确认:"提示"与"提醒"是否指同一处理方式（D）及步骤 11c 分支的实际判定取值
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-006 步骤 11c 返回检查结果"超限，但可继续交易"，输出表未登记承载字段（TBD-07） - 影响:提示分支的检查结果无法承载，当前返回成功但业务字段为空 - 待确认:检查结果的承载字段/方式及"限额检查结果"字段的填充
        return passResult();
    }

    /**
     * REQ-007 步骤 12：未超限时按累计情况判断限额更新分支。
     *
     * <p>[限额累计金额]大于 0 或 [限额累计笔数]大于 0 时继续步骤 13 调用 ST046（更新累计限额）；
     * 否则跳转步骤 14 调用 ST044（登记累计限额）。重叠区间取舍与 null 比较口径见方法内 FIXME。</p>
     */
    private ST022OutputBO judgeLimitUpdateBranch(ST022InputBO input, String limitSceneNo,
            BigDecimal limitSumAmt, Integer limitSumNum, String limitCheckResult) {
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:REQ-007 第 12a 项（未超限且金额>0 或 笔数>0 → 继续更新）与第 12b 项（未超限且金额==0 或 笔数==0 → 跳转登记）在"金额>0 且笔数==0""金额==0 且笔数>0"区间重叠，需求未定义取舍，TBD-06 - 影响:当前按 12a 优先（金额>0 或 笔数>0 → ST046 更新，否则 → ST044 登记），重叠区间走向可能不符 - 待确认:重叠区间走哪条分支；null 累计值按 0 参与比较的口径
        boolean amountPositive = limitSumAmt != null && limitSumAmt.compareTo(BigDecimal.ZERO) > 0;
        boolean countPositive = limitSumNum != null && limitSumNum > 0;
        if (amountPositive || countPositive) {
            // REQ-008 步骤 13：按[限额场景编码]、{对手客户号}、{对手账号}调用 ST046 更新累计限额，
            // 同时传入 限额检查结果、limitSumAmt、否
            ST046InputBO st046Input = new ST046InputBO();
            st046Input.set限额检查结果(limitCheckResult);
            st046Input.setBaseAcctNo(input.getOthBaseAcctNo());
            st046Input.setLimitSceneNo(limitSceneNo);
            st046Input.setClientNo(input.getOthClientNo());
            st046Input.setLimitSumAmt(limitSumAmt);
            st046Input.set否(limitSumNum);
            ST046OutputBO st046Result = st046.execute(st046Input);
            if (!st046Result.isSucceed()) {
                return propagateFailure(st046Result);
            }
            return passResult();
        }

        // REQ-009 步骤 14：按[限额场景编码]、{对手客户号}、{对手账号}调用 ST044 登记累计限额，
        // 同时传入 限额检查结果、limitSumAmt、否；tranAmt 与 runDate 来源未确认，不传
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-009 步骤 14 调 ST044 需 tranAmt（{交易金额}），ST022「输入」表未声明交易金额字段，TBD-01 - 影响:当前不设置 ST044InputBO.tranAmt，登记记录缺少交易金额 - 待确认:ST022 从何处取得交易金额并传入 ST044
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST044InputBO 必填输入含 runDate（系统日期，来源系统日期表 FM_DATE），ST022「输入」表未声明，TBD-11 - 影响:当前不设置 ST044InputBO.runDate，登记缺系统日期 - 待确认:本步骤如何取得 runDate 并传入 ST044
        ST044InputBO st044Input = new ST044InputBO();
        st044Input.set限额检查结果(limitCheckResult);
        st044Input.setBaseAcctNo(input.getOthBaseAcctNo());
        st044Input.setClientNo(input.getOthClientNo());
        st044Input.setLimitSceneNo(limitSceneNo);
        st044Input.setLimitSumAmt(limitSumAmt);
        st044Input.set否(limitSumNum);
        ST044OutputBO st044Result = st044.execute(st044Input);
        if (!st044Result.isSucceed()) {
            return propagateFailure(st044Result);
        }
        return passResult();
    }

    /**
     * 传播内部步骤失败：按内部步骤结果的错误码与错误信息构造本步骤失败输出（succeed=false）。
     */
    private ST022OutputBO propagateFailure(StepResult innerResult) {
        ST022OutputBO result = new ST022OutputBO();
        result.setSucceed(false);
        result.setErrorCode(innerResult.getErrorCode());
        result.setErrorMessage(innerResult.getErrorMessage());
        return result;
    }

    /**
     * 构造「通过」/正常结束结果：succeed=true，错误字段保持 null，不设置业务输出字段。
     */
    private ST022OutputBO passResult() {
        // FIXME 业务项:ST022/检查对手账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-002/REQ-003 正常提前结束返回检查结果"通过"，输出表未登记承载字段，TBD-07 - 影响:"通过"检查结果无法承载，当前 passResult 仅 succeed=true、业务字段为空 - 待确认:检查结果"通过"的承载字段/方式
        ST022OutputBO result = new ST022OutputBO();
        result.setSucceed(true);
        return result;
    }
}
