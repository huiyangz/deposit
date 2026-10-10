package com.dcits.depsit.step;

import com.dcits.depsit.enums.HierarchyCode;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST102InputBO;
import com.dcits.depsit.facade.bo.ST102OutputBO;
import com.dcits.depsit.facade.components.IFmBranchBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.FmBranchEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST102 检查账户机构是否可匹配到限额场景配置 步骤实现。
 *
 * <p>执行顺序（REQ-007）：子步骤 1（按 {账号} 查【账户信息】取账户开立行行号）→ 子步骤 2
 * （按账户开立行行号查【限额控制配置表】取「启用标志＝Y」配置的限额场景编码）→ 子步骤 3
 * （编码非空即返回并短路；为空则跳转子步骤《获取上级机构集合》）→ 子步骤 4（沿归属上级机构号逐级向上
 * 构建 [上级机构集合]，不含账户开立行自身）→ 子步骤 5（按机构层级从高到低遍历集合，首个命中即中断返回）。</p>
 *
 * <p>本步骤对三张表（RB_BUS_ACCT、RB_LIMIT_CTRL_CONF、FM_BRANCH）只做查询，不新增、修改或删除任何记录，
 * 故不加事务。</p>
 *
 * <p>唯一业务失败：子步骤 1 按 {账号} 查询【账户信息】查不到记录或查到多条记录（多条与查无按同一码处理），
 * 返回 {@code ER0048}（账户不存在）并短路结束，子步骤 2～5 的查询一概不执行。子步骤 3 命中、子步骤 4
 * 查不到机构记录或无上级机构、子步骤 5 全部未命中等均属正常结束，返回 {@code succeed=true} 且不置错误码。
 * 其余失败仅由技术异常向上传播，本步骤不捕获、不转译为业务错误码，也不为其新增兜底默认值。</p>
 */
@Service
public class ST102Pbc implements IST102 {

    /** 启用标志的判定取值：Y-启用（{@code RbLimitCtrlConfEO.validFlag} 为 String，全库无对应枚举类）。 */
    private static final String VALID_FLAG_ENABLED = "Y";

    /** 业务失败错误码：账户不存在（errorcodes.properties：ER0048=账户不存在）。 */
    private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";

    /** 业务失败错误信息：错误码::业务说明。 */
    private static final String ERROR_MESSAGE_ACCT_NOT_EXIST = "ER0048::账户不存在";

    /** 【账户信息】＝对公存款账户主表（RB_BUS_ACCT）数据服务接口。 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    /** 【限额控制配置表】（RB_LIMIT_CTRL_CONF）数据服务接口。 */
    @Autowired
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    /** 【机构信息表】（FM_BRANCH）数据服务接口。 */
    @Autowired
    private IFmBranchBcc fmBranchBcc;

    @Override
    public ST102OutputBO execute(ST102InputBO input) {
        ST102OutputBO output = new ST102OutputBO();

        // 子步骤 1（获取账户开立行行号）：按 {账号} 查询【账户信息】。查询条件仅含账号，
        // 不追加其它缩窄条件；{账号} 唯一确定一条账户记录。
        RbBusAcctEO acctCondition = new RbBusAcctEO();
        acctCondition.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(acctCondition);
        if (acctList == null || acctList.size() != 1) {
            // 查不到记录或查到多条记录：业务失败，返回 ER0048 并结束本步骤；
            // 子步骤 2～5 的限额控制配置查询、机构查询与遍历一概不执行。
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_NOT_EXIST);
            return output;
        }
        TranBranch acctBranch = acctList.get(0).getAcctBranch();

        // 子步骤 2（获取场景限额编码）：按 [账户开立行行号] 查询【限额控制配置表】，
        // 取启用标志等于「Y-启用」的配置所承载的限额场景编码。
        String limitSceneNo = queryEnabledLimitSceneNo(acctBranch);

        // 子步骤 3（检查账户开立行是否匹配到限额场景）：编码非空则返回该编码并结束本步骤，
        // 不再查询【机构信息表】、不执行子步骤 4 与子步骤 5。
        if (limitSceneNo != null) {
            output.setLimitSceneNo(limitSceneNo);
            output.setSucceed(true);
            return output;
        }

        // 子步骤 4（获取上级机构集合）：编码为空，跳转至《获取上级机构集合》。
        // 查不到机构记录或没有取到任何上级机构时集合为空。
        List<FmBranchEO> superiorBranches = collectSuperiorBranches(acctBranch);

        // 子步骤 5（检查上级机构匹配的限额场景）：按 [上级机构集合] 中元素的 $机构层级$ 从高到低
        // （总行、分行、支行）遍历；命中即中断本次遍历并返回，全部未命中则结束遍历返回空值。
        superiorBranches.sort(Comparator.comparingInt(
                (FmBranchEO superior) -> hierarchyRank(superior.getHierarchyCode())));
        for (FmBranchEO superior : superiorBranches) {
            // 子步骤 5-1：以当前遍历元素自身的机构号（该元素的 $归属机构号$）为条件查询【限额控制配置表】，
            // 不使用账户开立行行号或其它机构号。
            String superiorSceneNo = queryEnabledLimitSceneNo(superior.getBranch());
            // 子步骤 5-2：编码非空，中断本次遍历并返回该限额场景编码。
            if (superiorSceneNo != null) {
                output.setLimitSceneNo(superiorSceneNo);
                output.setSucceed(true);
                return output;
            }
            // 编码为空则继续遍历下一条。
        }

        // 子步骤 5-3：遍历全部元素均未命中（含集合为空时遍历零次），结束遍历并返回 [限额场景编码] 为空。
        // 本情形不是业务失败，正常结束、不置错误码。
        output.setSucceed(true);
        return output;
    }

    /**
     * 按机构号查询【限额控制配置表】中「启用标志＝Y」的配置，取所承载的限额场景编码（子步骤 2 与 5-1 共用）。
     *
     * <p>查询条件恰为「限额机构编码＝指定机构号」与「启用标志＝Y」两项，不追加其它定位条件；
     * 同一机构查出多条启用配置时，按 [最后修改时间戳]（{@code lastUpdTimestamp}）取最近维护的一条。
     * 零条启用配置命中（无任何配置记录，或记录的启用标志均不为 {@code "Y"}）时返回 {@code null}，
     * 表示未取到限额场景编码。</p>
     *
     * @param limitBranchId 查询键机构号（子步骤 2 为账户开立行行号，子步骤 5-1 为遍历元素的机构号）
     * @return 命中配置记录的限额场景编码；未命中启用配置时为 {@code null}
     */
    private String queryEnabledLimitSceneNo(TranBranch limitBranchId) {
        RbLimitCtrlConfEO confCondition = new RbLimitCtrlConfEO();
        confCondition.setLimitBranchId(limitBranchId);
        confCondition.setValidFlag(VALID_FLAG_ENABLED);
        List<RbLimitCtrlConfEO> confList = rbLimitCtrlConfBcc.findByEo(confCondition);
        if (confList == null || confList.isEmpty()) {
            return null;
        }
        return latestMaintained(confList).getLimitSceneNo();
    }

    /**
     * 从同一机构的多条启用配置中取 [最后修改时间戳] 最近维护的一条。
     *
     * <p>{@code lastUpdTimestamp} 为定长 26 位时间戳字符串，「最近维护」按该字段取值的时间先后判定，
     * 故按字符串自然序比较。该字段并列或取到空值时的取用口径源需求未定义
     * （Spec「验收范围与明确不覆盖的事项」第 6 项），实现不另立取舍规则：比较时忽略取不到时间戳的记录，
     * 并列时保持先出现者。</p>
     *
     * @param confList 同一机构命中的启用配置记录，非空
     * @return 最近维护的一条配置记录
     */
    private static RbLimitCtrlConfEO latestMaintained(List<RbLimitCtrlConfEO> confList) {
        RbLimitCtrlConfEO latest = confList.get(0);
        for (RbLimitCtrlConfEO conf : confList) {
            String current = conf.getLastUpdTimestamp();
            String latestTimestamp = latest.getLastUpdTimestamp();
            if (current != null && (latestTimestamp == null || current.compareTo(latestTimestamp) > 0)) {
                latest = conf;
            }
        }
        return latest;
    }

    /**
     * 沿归属上级机构号逐级向上构建 [上级机构集合]（子步骤 4）。
     *
     * <p>先按 [账户开立行行号] 查询【机构信息表】取得本机构的 $归属上级机构号$，再按该值查询其
     * $归属上级机构号$，如此逐级向上，直到查不到归属上级机构号为止；逐级取得的全部上级机构构成集合，
     * 不包含账户开立行自身。查不到机构记录，或本机构的归属上级机构号为空时，集合为空。</p>
     *
     * <p>某轮取得的归属上级机构号在【机构信息表】查不到对应机构记录（悬空引用）时的处理源需求未定义
     * （Spec「验收范围与明确不覆盖的事项」第 1 项），实现不对此另立规则：因无机构记录可取，逐级向上就此
     * 终止。归属链成环的形态同为源需求未定义事项（第 2 项），实现按正文「直到查不到归属上级机构号为止」
     * 的字面含义执行，不另设长度上限或环检测。每次查询的定位条件均为「归属机构号＝上一轮取得的
     * 归属上级机构号」，只读。</p>
     *
     * @param acctBranch 子步骤 1 取得的账户开立行行号
     * @return 上级机构集合，不含账户开立行自身；查不到机构记录或无上级机构时为空集合
     */
    private List<FmBranchEO> collectSuperiorBranches(TranBranch acctBranch) {
        List<FmBranchEO> superiorBranches = new ArrayList<>();
        FmBranchEO acctOrg = fmBranchBcc.findByBranch(acctBranch);
        if (acctOrg == null) {
            // 账户开立行在【机构信息表】查不到机构记录：[上级机构集合] 为空，非业务失败。
            return superiorBranches;
        }
        TranBranch attachedTo = acctOrg.getAttachedTo();
        while (attachedTo != null) {
            FmBranchEO superior = fmBranchBcc.findByBranch(attachedTo);
            if (superior == null) {
                break;
            }
            superiorBranches.add(superior);
            attachedTo = superior.getAttachedTo();
        }
        return superiorBranches;
    }

    /**
     * 机构层级的遍历序：总行（{@code 0}）→ 分行（{@code 1}）→ 支行（{@code 2}），序号越小越靠前。
     *
     * <p>其余取值（含 {@code -1} 虚拟机构层级）未列入源需求的「总行、分行、支行」层级序列，
     * 其排序位置源需求未定义（Spec「验收范围与明确不覆盖的事项」第 2 项），实现不为其规定层级顺序，
     * 统一排在已定义层级之后。</p>
     *
     * @param hierarchyCode 机构记录的机构层级代码，可为空
     * @return 遍历序号
     */
    private static int hierarchyRank(HierarchyCode hierarchyCode) {
        if (hierarchyCode == HierarchyCode.VALUE_0) {
            return 0;
        }
        if (hierarchyCode == HierarchyCode.VALUE_1) {
            return 1;
        }
        if (hierarchyCode == HierarchyCode.VALUE_2) {
            return 2;
        }
        return Integer.MAX_VALUE;
    }
}
