package com.dcits.deposit.step;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.facade.bo.ST005InputBO;
import com.dcits.deposit.facade.bo.ST005OutputBO;
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
 * ST005 检查支取账户限额 步骤实现。
 *
 * <p>按正式 Spec ST005「步骤描述」14 条编排，共 10 次组件内步骤调用（ST043、ST038、ST045、
 * ST037、ST042、ST039、ST040、ST041、ST046、ST044）。未匹配、[限额场景编码]为空等检查
 * 不满足时返回检查结果「通过」并正常提前结束；[限额检查结果]为「未超限」时按累计情况
 * 分支更新（ST046）或登记（ST044）累计限额；「超限」时按[检查结果]「拒绝/授权/提示」
 * 分支返回错误码 ER0058、授权标志「需授权」或检查结果「超限，但可继续交易」。</p>
 *
 * <p>检查结果「通过」「超限，但可继续交易」及授权标志「需授权」的承载字段、ST043 执行结果
 * 物理取值、步骤8/12 所用累计值来源、分支条件重叠、输出字段赋值来源等未确认事项见各
 * 步骤 FIXME（正式 Spec 待确认事项 TBD-1~TBD-11）。</p>
 */
@Service
public class ST005Pbc implements IST005 {

    /** [限额检查结果]"未超限"判断字面量：需求业务取值，物理编码待确认（Spec TBD-4 相关口径） */
    private static final String CHECK_RESULT_NOT_EXCEED = "未超限";

    /** 业务失败错误码：交易超出限额控制（errorcodes.properties ER0058） */
    private static final String ERROR_CODE = "ER0058";

    /** 业务失败错误信息：已确认格式「错误码::业务说明」 */
    private static final String ERROR_MESSAGE = "ER0058::交易超出限额控制";

    /** 匹配限额场景步骤 */
    @Autowired
    private IST043 st043;

    /** 检查账户机构是否可匹配到限额场景配置步骤 */
    @Autowired
    private IST038 st038;

    /** 检查限额场景配置是否有效步骤 */
    @Autowired
    private IST045 st045;

    /** 获取限额场景编码步骤 */
    @Autowired
    private IST037 st037;

    /** 获取累计限额步骤 */
    @Autowired
    private IST042 st042;

    /** 计算限额累计金额步骤 */
    @Autowired
    private IST039 st039;

    /** 检查限额步骤 */
    @Autowired
    private IST040 st040;

    /** 处理限额步骤 */
    @Autowired
    private IST041 st041;

    /** 更新累计限额步骤 */
    @Autowired
    private IST046 st046;

    /** 登记累计限额步骤 */
    @Autowired
    private IST044 st044;

    @Override
    @Transactional
    public ST005OutputBO execute(ST005InputBO input) {
        ST005OutputBO output = new ST005OutputBO();

        // 步骤1（REQ-002）：匹配限额场景（ST043），以{限额因子}调用
        // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤1 调用参数与 ST043 输入契约差异：步骤描述原文另列{客户号}{账号}，ST043 已确认输入契约仅含因子名称，客户号/账号是否实际传入 ST043、{限额因子}是否即输入字段因子名称未定义（Spec TBD-2） - 影响:当前仅以因子名称调用 ST043，客户号/账号不传入，调用映射可能不完整 - 待确认:{限额因子}与因子名称的对应及客户号/账号是否传入
        ST043InputBO st043Input = new ST043InputBO();
        st043Input.setFactorName(input.get因子名称());
        ST043OutputBO st043Result = st043.execute(st043Input);

        // 步骤2（REQ-002）：判断[执行结果]，已匹配继续步骤3，否则返回检查结果「通过」正常提前结束
        // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST043[执行结果]「已匹配到限额场景/未匹配到限额场景」的承载字段与物理取值未定义，ST043 输出表未登记执行结果字段（Spec TBD-1） - 影响:当前以 ST043 输出 limitSceneNo 非空代理"已匹配"判断，物理取值确认后可能需改用已确认字段/编码 - 待确认:[执行结果]的承载字段名与物理编码
        if (st043Result.getLimitSceneNo() == null || st043Result.getLimitSceneNo().isEmpty()) {
            return passResult();
        }

        // 步骤3（REQ-003）：检查机构匹配的限额场景配置（ST038），以{账号}调用
        ST038InputBO st038Input = new ST038InputBO();
        st038Input.setBaseAcctNo(input.getBaseAcctNo());
        ST038OutputBO st038Result = st038.execute(st038Input);
        // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:"[限额场景编码]为空"的物理语义未定义：空指 null 还是空字符串（Spec TBD-3，适用于步骤3/4/5 三处判断） - 影响:当前按 null 或空字符串均视为"为空"处理，物理口径确认后可能需收紧 - 待确认:三个判断点的空值语义（null 或空串）
        if (st038Result.getLimitSceneNo() == null || st038Result.getLimitSceneNo().isEmpty()) {
            return passResult();
        }
        // 输出 limitBranchId 来源限额控制配置（RB_LIMIT_CTRL_CONF），对应 ST038 返回的限额机构编码（赋值对应关系待 TBD-11 确认）
        output.setLimitBranchId(st038Result.getLimitBranchId());

        // 步骤4（REQ-004）：检查有效的限额场景配置（ST045），以[限额场景编码]、{交易日期}、{交易时间}调用
        ST045InputBO st045Input = new ST045InputBO();
        st045Input.setLimitSceneNo(st038Result.getLimitSceneNo());
        st045Input.setTranDate(input.getTranDate());
        st045Input.setTranTimestamp(input.getTranTimestamp());
        ST045OutputBO st045Result = st045.execute(st045Input);
        if (st045Result.getLimitSceneNo() == null || st045Result.getLimitSceneNo().isEmpty()) {
            return passResult();
        }

        // 步骤5（REQ-005）：检查限额场景编码（ST037），以[限额场景编码]、{账号}、{客户号}调用
        ST037InputBO st037Input = new ST037InputBO();
        st037Input.setLimitSceneNo(st045Result.getLimitSceneNo());
        st037Input.setBaseAcctNo(input.getBaseAcctNo());
        st037Input.setClientNo(input.getClientNo());
        ST037OutputBO st037Result = st037.execute(st037Input);
        if (st037Result.getLimitSceneNo() == null || st037Result.getLimitSceneNo().isEmpty()) {
            return passResult();
        }
        String sceneNo = st037Result.getLimitSceneNo();

        // 步骤6（REQ-006）：获取累计限额（ST042），取得$限额累计金额$与$限额累计笔数$（既有累计值）
        ST042InputBO st042Input = new ST042InputBO();
        st042Input.setLimitSceneNo(sceneNo);
        st042Input.setBaseAcctNo(input.getBaseAcctNo());
        st042Input.setClientNo(input.getClientNo());
        ST042OutputBO st042Result = st042.execute(st042Input);
        // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:既有累计值（ST042 返回的限额累计金额/笔数）如何进入步骤7 计算环节未定义：ST039 输入契约无既有累计值字段（Spec TBD-4） - 影响:既有累计值仅在 ST039 内部并入计算后值，本步骤不可直接传递，当前按其计算后值供后续使用 - 待确认:既有累计值的传递方式（ST039 内部查询还是本步传入）

        // 步骤7（REQ-007）：计算限额累计金额（ST039），以{交易金额}、[限额场景编码]调用
        // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤7 调用参数与 ST039 输入契约差异：步骤描述原文另列{账号}{客户号}，ST039 已确认输入契约仅含 tranAmt、limitSceneNo（Spec TBD-5） - 影响:当前仅以 tranAmt、limitSceneNo 调用 ST039，账号/客户号是否另有调用参数待确认 - 待确认:ST039 是否存在账号/客户号调用参数
        ST039InputBO st039Input = new ST039InputBO();
        st039Input.setTranAmt(input.getTranAmt());
        st039Input.setLimitSceneNo(sceneNo);
        ST039OutputBO st039Result = st039.execute(st039Input);
        BigDecimal computedAmt = st039Result.getLimitSumAmt();
        Integer computedNum = st039Result.get限额累计笔数();

        // 步骤8（REQ-008）：检查限额（ST040），以[限额场景编码]、[限额累计金额]、[限额累计笔数]调用
        // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤8 检查、步骤12 分支、步骤13/14 更新登记所用[限额累计金额][限额累计笔数]取自 ST042 既有值还是 ST039 计算后值未定义（Spec TBD-4） - 影响:当前按「ST042 取既有值→ST039 计算后值供步骤8 检查及后续使用」整理，口径确认后可能需改用既有值 - 待确认:步骤8/12/13/14 所用累计值来源
        ST040InputBO st040Input = new ST040InputBO();
        st040Input.setLimitSceneNo(sceneNo);
        st040Input.setLimitSumAmt(computedAmt);
        st040Input.setLimitSumNum(computedNum);
        ST040OutputBO st040Result = st040.execute(st040Input);
        String limitCheckResult = st040Result.getLimitCheckResult();

        // 步骤9（REQ-008）：[限额检查结果]为"未超限"跳转步骤12，否则继续步骤10
        if (!CHECK_RESULT_NOT_EXCEED.equals(limitCheckResult)) {
            // 步骤10（REQ-009）：获取超限处理方式（ST041），以[限额场景编码]调用
            ST041InputBO st041Input = new ST041InputBO();
            st041Input.setLimitSceneNo(sceneNo);
            ST041OutputBO st041Result = st041.execute(st041Input);
            DealFlow dealFlow = st041Result.getDealFlow();

            // 步骤11：按[检查结果]互斥分支「拒绝/授权/提示」
            if (dealFlow == DealFlow.B) {
                // 步骤11a（REQ-009-S01）：拒绝 → 返回错误码 ER0058，步骤业务失败
                output.setSucceed(false);
                output.setErrorCode(ERROR_CODE);
                output.setErrorMessage(ERROR_MESSAGE);
                return output;
            }
            if (dealFlow == DealFlow.A) {
                // 步骤11b（REQ-009-S02）：授权 → 返回授权标志「需授权」并等待授权（正常结论）
                // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:授权标志「需授权」的承载字段名、类型与取值编码未定义，输出表未登记授权标志字段（Spec TBD-7） - 影响:当前仅以正常结果（succeed=true、错误字段为空）表达，结论对外不可观测 - 待确认:授权标志的物理字段与取值
                // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:「授权」分支返回「需授权」后的"等待授权"流程语义未定义：如何等待、授权结果如何回填本步骤（Spec TBD-8） - 影响:当前按返回正常结论即结束处理，等待授权行为未实现 - 待确认:等待授权与结果回填流程
                return passResult();
            }
            // 步骤11c（REQ-009-S03）：提示 → 返回检查结果「超限，但可继续交易」（正常结论）
            // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:步骤11 分支「提示」与 ST041[检查结果]「提醒」（处理方式 DealFlow.D 提醒处理）的表述对应关系未定义（Spec TBD-6） - 影响:当前按 DealFlow.D 落入「提示」分支，枚举对应确认后可能需调整 - 待确认:「提示」与「提醒」（DealFlow.D）是否同一取值
            // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:检查结果「超限，但可继续交易」的承载字段名、类型与取值编码未定义，输出表未登记检查结果字段（Spec TBD-7） - 影响:当前仅以正常结果表达，结论对外不可观测 - 待确认:检查结果的物理字段与取值
            // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:步骤11c「提示」返回检查结果后的流转未定义：是否继续步骤12-14（更新/登记累计限额）（Spec TBD-10） - 影响:当前按返回检查结果即结束处理，不执行后续更新/登记 - 待确认:提示分支结束后是否继续更新/登记累计限额
            // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:ST041[检查结果]为其他取值或 null 时的行为未定义（Spec TBD-6 相关） - 影响:当前落入与「提示」相同的正常结论出口返回，是否报错或如何返回待确认 - 待确认:其他取值的处理方式
            return passResult();
        }

        // 步骤12（REQ-010）：根据累计情况判断限额更新分支
        // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:步骤12 分支条件重叠：金额>0 且笔数=0（或金额=0 且笔数>0）时分支a「(金额>0 或笔数>0) 继续执行」与分支b「(金额=0 或笔数=0) 跳转登记」同时成立，优先分支未定义（Spec TBD-9） - 影响:当前按分支a 优先（任一大于0 即更新），重叠情形走向可能与确认结果不符 - 待确认:重叠情形的优先分支
        boolean amountPositive = computedAmt != null && computedAmt.compareTo(BigDecimal.ZERO) > 0;
        boolean countPositive = computedNum != null && computedNum > 0;
        if (amountPositive || countPositive) {
            // 步骤13（REQ-011）：更新累计限额（ST046），以[限额场景编码]、{客户号}、{账号}调用
            ST046InputBO st046Input = new ST046InputBO();
            st046Input.set限额检查结果(limitCheckResult);
            st046Input.setLimitSceneNo(sceneNo);
            st046Input.setClientNo(input.getClientNo());
            st046Input.setBaseAcctNo(input.getBaseAcctNo());
            st046Input.setLimitSumAmt(computedAmt);
            st046Input.set否(computedNum);
            // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST046 输入累计值（limitSumAmt/否）取值来源未定义，按 Spec TBD-4 当前以 ST039 计算后值填充；ST046 输出 limitSumAmt 返回语义未定义，本步骤不消费 - 影响:确认前按计算后值更新累计限额，输出保持 null - 待确认:ST046 入参累计值来源与输出使用
            st046.execute(st046Input);
            // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:更新路径输出 tranStatus/limitSumAmt/否/限额检查结果/limitSceneNo/checkObjVal/effectDate/expireDate 的赋值来源未定义，tranStatus 各路径取值未声明（Spec TBD-11） - 影响:当前仅登记 limitBranchId，其余输出保持 null，确认后补充赋值 - 待确认:各输出字段与组件内步骤产出的对应关系及 tranStatus 取值
        } else {
            // 步骤14（REQ-012）：登记累计限额（ST044），以[限额场景编码]、{客户号}、{账号}调用
            ST044InputBO st044Input = new ST044InputBO();
            st044Input.set限额检查结果(limitCheckResult);
            st044Input.setLimitSceneNo(sceneNo);
            st044Input.setClientNo(input.getClientNo());
            st044Input.setBaseAcctNo(input.getBaseAcctNo());
            st044Input.setTranAmt(input.getTranAmt());
            st044Input.setLimitSumAmt(computedAmt);
            st044Input.set否(computedNum);
            // FIXME 业务项:ST005/检查支取账户限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:ST044 登记入参 runDate（生效日期=系统日期）在本步骤无来源：输入表未登记系统日期字段（Spec TBD-4/TBD-11） - 影响:当前 runDate 保持 null，登记产出 effectDate 为 null - 待确认:runDate（系统日期）的来源
            ST044OutputBO st044Result = st044.execute(st044Input);
            // 输出 limitSceneNo/checkObjVal/limitSumAmt/否/effectDate/expireDate 来源限额累计信息表（RB_LIMIT_SUM_INFO），即 ST044 登记产出（赋值对应关系待 TBD-11 确认）
            output.setLimitSceneNo(st044Result.getLimitSceneNo());
            output.setCheckObjVal(st044Result.getCheckObjVal());
            output.setLimitSumAmt(st044Result.getLimitSumAmt());
            output.set否(st044Result.get否());
            output.setEffectDate(st044Result.getEffectDate());
            output.setExpireDate(st044Result.getExpireDate());
        }
        // 正常完成
        output.setSucceed(true);
        return output;
    }

    /** 返回检查结果「通过」：正常提前结束，不设置业务输出（结论承载见 Spec TBD-7） */
    private ST005OutputBO passResult() {
        ST005OutputBO result = new ST005OutputBO();
        result.setSucceed(true);
        return result;
    }
}
