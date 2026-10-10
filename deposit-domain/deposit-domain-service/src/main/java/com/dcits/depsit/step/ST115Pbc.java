package com.dcits.depsit.step;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.facade.bo.ST115InputBO;
import com.dcits.depsit.facade.bo.ST115OutputBO;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;

/**
 * ST115 检查账户是否存在限制 步骤实现。
 *
 * <p>按正式 Spec 的四条子步骤执行（Spec REQ-009 的执行顺序）：</p>
 * <ol>
 *   <li>子步骤 1a（实体查询类）：按入参 {账号}（{@code baseAcctNo}）为条件，经
 *       {@link IRbBusAcctBcc#findByEo} 查询【账户信息】（{@code RB_BUS_ACCT}）。恰好命中一条时取该记录的
 *       主账户标志（{@code leadAcctFlag}）与上级账户内部键（{@code parentInternalKey}）继续执行；
 *       查不到记录或查到多条记录时统一返回错误码 {@code ER0048}（账户不存在）并短路结束本步骤
 *       （Spec REQ-002、REQ-009-S03）。</li>
 *   <li>子步骤 1b（实体查询类）：仅当 1a 命中记录的主账户标志表明该账号**不是主账户**时，以该记录的
 *       上级账户内部键为条件经 {@link IRbBusAcctBcc#findByPrimaryKey} 回查【账户信息】（按主键
 *       「账户内部键值」取单条），取查得账户的账号作为 {@code $主账户账号$}；是主账户时不执行回查
 *       （Spec REQ-003）。</li>
 *   <li>子步骤 2（参数赋值类）：不是主账户时 [待查账户] = {@code $主账户账号$}；是主账户时
 *       [待查账户] = {账号}（Spec REQ-004）。</li>
 *   <li>子步骤 3 + 4（实体查询类 + 参数赋值类）：以 [待查账户] 为账号、限制状态码值 {@code "A"}
 *       （需求写作「A-生效」，按「码值-含义」取码值判定）为条件，经
 *       {@link IRbBusRestraintsBcc#findByEo} 查询【账户限制信息表】（{@code RB_BUS_RESTRAINTS}）；
 *       零条命中时限制编号、账户限制类型、限制状态均为空值且不返回错误码；多条命中时按限制编号升序
 *       取第一条，并回显该条的限制编号、账户限制类型、限制状态；同时按「## 输出」表说明回显步骤描述
 *       第 1 条**按上送 {账号} 查得**的【账户信息】记录的账号（{@code baseAcctNo}）与主账户标志
 *       （{@code leadAcctFlag}），二者 MUST NOT 取自 1b 回查所得的主账户记录；随后设置
 *       {@code succeed = true} 返回本步骤结果（Spec REQ-005 ~ REQ-008）。</li>
 * </ol>
 *
 * <p>业务失败仅上述「按 {账号} 查【账户信息】查无或多条」一种，其余失败（含子步骤 1b 回查得到空值时的
 * 解引用异常）按技术异常向上传播：本实现不新增 {@code catch}、不吞异常、不把技术异常转译为业务失败、
 * 不以占位值兜底（Spec REQ-010）。本步骤全路径只读，无本地写入，不引入事务。</p>
 *
 * <p>主账户标志的取值域未由源需求给出（Spec「验收范围与明确不覆盖的事项」第 2 项），本实现按本项目
 * 码值书写口径（DT002 对 {@code "Y"}-是、{@code "N"}-否）以 {@code "N"} 判定「不是主账户」，
 * 属**待确认假定**，不改变 Spec REQ-003／REQ-004 的语义分支。</p>
 *
 * <p>输出字段 {@code baseAcctNo}、{@code leadAcctFlag} 按「## 输出」表说明回显步骤描述第 1 条
 * **按上送 {账号} 查得**的那一条【账户信息】记录（即 1a 命中记录）的账号与主账户标志，
 * MUST NOT 取自 1b 回查所得的主账户记录（Spec REQ-008-S03、REQ-008-S04）；二者与三个限制字段
 * 同为「非必填」，仅在 1a 唯一命中后的成功路径上赋值，{@code ER0048} 短路路径无回显来源、
 * 保持空值，不由默认值或占位值补齐（Spec REQ-006、REQ-008、REQ-010）。</p>
 */
@Service
public class ST115Pbc implements IST115 {

    /** 子步骤 1a 主账户判定：主账户标志表明「不是主账户」的取值（待确认假定，Spec 不覆盖项 2）。 */
    private static final String LEAD_ACCT_FLAG_NOT_MAIN_ACCOUNT = "N";

    /** 子步骤 3 查询【账户限制信息表】的限制状态条件：码值 {@code "A"}（需求写作「A-生效」，REQ-005）。 */
    private static final RestraintsStatus RESTRAINTS_STATUS_QUERY = RestraintsStatus.A;

    /** 业务失败错误码：账户不存在（errorcodes.properties 第 48 行：{@code ER0048=账户不存在}）。 */
    private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";

    /** 业务失败错误信息：错误码::业务说明。 */
    private static final String ERROR_MESSAGE_ACCT_NOT_EXIST = "ER0048::账户不存在";

    /** 【账户信息】＝对公存款账户主表（{@code RB_BUS_ACCT}）数据服务接口。 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    /** 【账户限制信息表】＝对公存款账户限制表（{@code RB_BUS_RESTRAINTS}）数据服务接口。 */
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Override
    public ST115OutputBO execute(ST115InputBO input) {
        ST115OutputBO output = new ST115OutputBO();

        // 子步骤 1a：按 {账号} 查询【账户信息】，唯一命中一条记录时取其主账户标志与上级账户内部键（REQ-002）
        RbBusAcctEO acctCondition = new RbBusAcctEO();
        acctCondition.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(acctCondition);
        if (acctList == null || acctList.size() != 1) {
            // 查不到记录或查到多条记录：业务失败 ER0048 并短路结束本步骤；
            // 回查、[待查账户] 赋值、限制查询与输出赋值均不执行（REQ-002、REQ-009-S03、REQ-010-S01）
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_NOT_EXIST);
            return output;
        }
        RbBusAcctEO acct = acctList.get(0);

        // 子步骤 1b + 子步骤 2：主账户判定与 [待查账户] 设置（REQ-003、REQ-004）
        String queryAcctNo;
        if (LEAD_ACCT_FLAG_NOT_MAIN_ACCOUNT.equals(acct.getLeadAcctFlag())) {
            // 不是主账户：按该记录的上级账户内部键回查【账户信息】（主键＝账户内部键值，单条返回），
            // 取查得账户的账号作为 $主账户账号$，并以之作为 [待查账户]（REQ-003-S01、REQ-004-S01）
            RbBusAcctEO mainAcct = rbBusAcctBcc.findByPrimaryKey(acct.getParentInternalKey());
            queryAcctNo = mainAcct.getBaseAcctNo();
        } else {
            // 是主账户：不执行回查，[待查账户] = {账号}（REQ-003-S02、REQ-004-S02）
            queryAcctNo = input.getBaseAcctNo();
        }

        // 子步骤 3：按 [待查账户] + 限制状态 A-生效 查询【账户限制信息表】（REQ-005）
        RbBusRestraintsEO restraintCondition = new RbBusRestraintsEO();
        restraintCondition.setBaseAcctNo(queryAcctNo);
        restraintCondition.setRestraintsStatus(RESTRAINTS_STATUS_QUERY);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(restraintCondition);

        // 零条命中时取首结果为 null（三个回显字段保持空值，REQ-006）；多条命中时按限制编号升序取第一条（REQ-007）
        RbBusRestraintsEO hit = selectFirstByResSeqNo(restraintsList);

        // 子步骤 4：赋值并返回 [账户限制信息]（REQ-008）；零条命中与多条命中均为正常结果，不设错误码（REQ-010-S02）
        // 两个账户输出回显 1a 命中记录（＝按上送 {账号} 查得的那一条），不取 1b 回查所得主账户记录（REQ-008-S03、REQ-008-S04）
        output.setBaseAcctNo(acct.getBaseAcctNo());
        output.setLeadAcctFlag(acct.getLeadAcctFlag());
        if (hit != null) {
            output.setResSeqNo(hit.getResSeqNo());
            output.setRestraintType(hit.getRestraintType());
            output.setRestraintsStatus(hit.getRestraintsStatus());
        }
        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤 3 的取首：结果为空时返回 {@code null}；否则按限制编号升序取第一条（Spec REQ-007）。
     *
     * <p>限制编号在本项目为 {@code java.lang.String}（库列 {@code RES_SEQ_NO VARCHAR}），
     * 按字符串自然升序（字典序）比较；需求未规定更细的比较规则（Spec「验收范围与明确不覆盖的事项」
     * 第 5 项）。取首依据仅为限制编号，与查询返回顺序无关；三个回显字段取自同一条记录。</p>
     */
    private RbBusRestraintsEO selectFirstByResSeqNo(List<RbBusRestraintsEO> records) {
        if (records == null || records.isEmpty()) {
            return null;
        }
        // 取回记录必须包含限制编号；对缺失编号的记录按末位兜底，该情形不属于本轮验收范围
        Comparator<RbBusRestraintsEO> byResSeqNo = Comparator.comparing(
                RbBusRestraintsEO::getResSeqNo,
                Comparator.nullsLast(Comparator.<String>naturalOrder()));
        return Collections.min(records, byResSeqNo);
    }
}
