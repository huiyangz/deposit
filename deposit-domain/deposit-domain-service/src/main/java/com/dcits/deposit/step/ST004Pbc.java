package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST004InputBO;
import com.dcits.deposit.facade.bo.ST004OutputBO;
import com.dcits.deposit.facade.components.IFmBranchBcc;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.TranBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * ST004 检查账户通兑信息 步骤实现。
 *
 * <p>步骤 1（获取账户开立行行号与通兑标志）：根据账号（{@code baseAcctNo}）查询对公存款账户主表
 * （RB_BUS_ACCT），获取账户开立行行号（{@code acctBranch}）与通兑标志（{@code allDraInd}）作为后续
 * 检查依据（Spec REQ-001）。</p>
 * <p>步骤 2（开立行与交易机构一致性检查）：账户开立行行号等于交易机构（{@code tranBranch}）时返回
 * 检查结果为「通过」并结束步骤，不再执行步骤 3–10；否则继续步骤 3（Spec REQ-002）。</p>
 * <p>步骤 3（通兑标志分支）：需求原文分支值「D-指定机构通兑」「F-分行间通兑」「N-不允许通兑」
 * 「Y-全行通兑」与枚举类 {@code AllDraInd} 现有编码（N001~N004）无法唯一对应，无已确认枚举常量可
 * 绑定分支条件（Spec 待确认事项 TBD-1），五分支触发判定无法按已确认定义实现，入口接线待确认后完成；
 * 步骤 4–5（指定机构通兑检查）与步骤 6–10（分行间通兑检查）的已确认逻辑保留在对应私有方法
 * （Spec REQ-003~REQ-010）。</p>
 */
@Service
public class ST004Pbc implements IST004 {

    /** 错误码：通兑标志不在系统定义范围内（errorcodes.properties：ER0071=通兑标志不在系统定义范围内） */
    private static final String ERROR_CODE_DRAB_OTHER = "ER0071";
    /** 错误码：当前账户不允许通兑（errorcodes.properties：ER0072=当前账户不允许通兑） */
    private static final String ERROR_CODE_DRAB_NOT_ALLOWED = "ER0072";
    /** 错误码：交易机构不在账户的通兑范围内（errorcodes.properties：ER0073=交易机构不在账户的通兑范围内） */
    private static final String ERROR_CODE_DRAB_MISMATCH = "ER0073";
    /** 错误信息：错误码::业务说明（Spec 错误码与步骤结果契约） */
    private static final String ERROR_MESSAGE_DRAB_OTHER = "ER0071::通兑标志不在系统定义范围内";
    /** 错误信息：错误码::业务说明（Spec 错误码与步骤结果契约） */
    private static final String ERROR_MESSAGE_DRAB_NOT_ALLOWED = "ER0072::当前账户不允许通兑";
    /** 错误信息：错误码::业务说明（Spec 错误码与步骤结果契约） */
    private static final String ERROR_MESSAGE_DRAB_MISMATCH = "ER0073::交易机构不在账户的通兑范围内";

    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    @Autowired
    private IFmBranchBcc fmBranchBcc;

    @Override
    public ST004OutputBO execute(ST004InputBO input) {
        ST004OutputBO output = new ST004OutputBO();

        // 必填输入缺失（baseAcctNo/tranBranch）时的行为未定义，当前按正常入参路径自然执行（Spec TBD-6）。
        // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入 baseAcctNo、tranBranch 标记必填，缺失时的行为未定义（Spec TBD-6） - 影响:输入缺失分支无已确认失败条件与返回，当前按正常入参路径自然执行，不臆造校验失败返回 - 待确认:必填输入缺失时应返回的失败状态/错误码/异常

        // 步骤 1（获取账户开立行行号与通兑标志）：按账号查询对公存款账户主表（RB_BUS_ACCT），
        // 取得账户开立行行号（acctBranch）与通兑标志（allDraInd），作为后续检查依据。
        RbBusAcctEO rbBusAcct = queryRbBusAcct(input.getBaseAcctNo());
        if (rbBusAcct != null) {
            output.setAcctBranch(rbBusAcct.getAcctBranch());
            output.setAllDraInd(rbBusAcct.getAllDraInd());
        }

        // 步骤 2（开立行与交易机构一致性检查）：acctBranch 等于 tranBranch 时返回「通过」并结束，
        // 不再执行步骤 3–10；否则继续步骤 3。
        if (Objects.equals(output.getAcctBranch(), input.getTranBranch())) {
            output.setSucceed(true);
            return output;
        }

        // 步骤 3（通兑标志分支）：需求原文以「D-指定机构通兑」「F-分行间通兑」「N-不允许通兑」
        // 「Y-全行通兑」表述分支值，与枚举类 AllDraInd 现有编码（N001=允许全行支取、N002=允许分行支取、
        // N003=允许同城跨行支取、N004=不允许跨行支取）无法唯一对应，无已确认枚举常量可绑定分支条件
        // （Spec 待确认事项 TBD-1）。五分支结果本身已确认：D→步骤 4（executeSpecifiedDraCheck）、
        // F→步骤 6（executeBranchFranchiseCheck）、N→返回 ER0072、Y→返回「通过」、其它→返回 ER0071。
        // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:需求步骤3分支值「D-指定机构通兑/F-分行间通兑/N-不允许通兑/Y-全行通兑」与枚举类 AllDraInd 现有编码（N001~N004）无法唯一对应（Spec TBD-1） - 影响:五分支触发判定无已确认枚举常量可绑定，步骤 3 无法按已确认定义选择分支并实现 D→步骤4、F→步骤6、N→ER0072、Y→通过、其它→ER0071；步骤 2 开立行不等于交易机构的继续路径无已确认终态 - 待确认:D/F/N/Y（或其它取值）与 AllDraInd 的映射关系及步骤 3e「其它取值」判定边界
        // 占位返回：分支触发取值未确认前，继续路径（步骤 2 开立行不等于交易机构）无已确认终态。
        // 此处返回显式非成功且不设置错误码，不作为任何已确认分支结果，待 TBD-1 确认后按确认结果
        // 实现五分支与跳转（接入下方 executeSpecifiedDraCheck / executeBranchFranchiseCheck）。
        output.setSucceed(false);
        return output;
    }

    /**
     * 步骤 4–5（指定机构通兑检查）：按账号获取通兑机构（allDraIntBranch）并与交易机构比较。
     *
     * <p>仅在通兑标志为「D-指定机构通兑」时执行（Spec REQ-004/REQ-005）；入口接线待 TBD-1 确认，
     * 当前未被 execute 调用。</p>
     *
     * @param output 步骤输出
     * @param input 步骤输入
     * @param rbBusAcct 步骤 1 取回的对公存款账户主表记录
     * @return 步骤输出（通过或 ER0073）
     */
    private ST004OutputBO executeSpecifiedDraCheck(ST004OutputBO output, ST004InputBO input, RbBusAcctEO rbBusAcct) {
        // 步骤 4（获取指定通兑机构）：按账号查询账户信息获取通兑机构（allDraIntBranch）。
        // 步骤 1 已按同一账号查询同一主表记录，此处复用记录中的通兑机构编号（Spec REQ-004）。
        if (rbBusAcct != null) {
            output.setAllDraIntBranch(rbBusAcct.getAllDraIntBranch());
        }
        // 步骤 5（指定通兑机构检查）：交易机构与通兑机构相等时返回「通过」，否则返回 ER0073（Spec REQ-005）。
        // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:需求原文「交易机构在{通兑机构}范围内」（原文「氛围」按上下文应为「范围」），通兑机构字段为单一机构编号，本 Spec 按交易机构与通兑机构相等理解（Spec TBD-4） - 影响:步骤 5 通过/ER0073 判定边界未确认，当前按相等关系实现 - 待确认:「在{通兑机构}范围内」的实际判定语义（相等/集合/范围）
        if (Objects.equals(input.getTranBranch(), output.getAllDraIntBranch())) {
            output.setSucceed(true);
            return output;
        }
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_DRAB_MISMATCH);
        output.setErrorMessage(ERROR_MESSAGE_DRAB_MISMATCH);
        return output;
    }

    /**
     * 步骤 6–10（分行间通兑检查）：查询开户行与交易行的机构层级和上级机构，赋值双方管辖分行并比较。
     *
     * <p>仅在通兑标志为「F-分行间通兑」时执行（Spec REQ-006~REQ-010）；入口接线待 TBD-1 确认，
     * 当前未被 execute 调用。</p>
     *
     * @param output 步骤输出
     * @param input 步骤输入
     * @return 步骤输出（通过或 ER0073）
     */
    private ST004OutputBO executeBranchFranchiseCheck(ST004OutputBO output, ST004InputBO input) {
        // 步骤 6（获取开立行的机构层级与上级机构）：根据 acctBranch 查询机构信息表（FM_BRANCH）（Spec REQ-006）。
        FmBranchEO acctBranchOrg = output.getAcctBranch() == null ? null : queryFmBranch(output.getAcctBranch());
        // 步骤 7（获取交易行的机构层级与上级机构）：根据 tranBranch 查询机构信息表（FM_BRANCH）（Spec REQ-007）。
        FmBranchEO tranBranchOrg = input.getTranBranch() == null ? null : queryFmBranch(input.getTranBranch());

        // 开户行/交易行两组机构层级与上级机构取值分别承载于局部变量，供步骤 8/9 各自使用；
        // 输出表仅声明一份 hierarchyCode/attachedTo，两组取值的输出承载未确认（Spec TBD-3）。
        HierarchyCode acctHierarchyCode = acctBranchOrg == null ? null : acctBranchOrg.getHierarchyCode();
        TranBranch acctAttachedTo = acctBranchOrg == null ? null : acctBranchOrg.getAttachedTo();
        HierarchyCode tranHierarchyCode = tranBranchOrg == null ? null : tranBranchOrg.getHierarchyCode();
        TranBranch tranAttachedTo = tranBranchOrg == null ? null : tranBranchOrg.getAttachedTo();
        // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出表仅声明一份 hierarchyCode/attachedTo（来源 FM_BRANCH），但步骤 6（开户行）与步骤 7（交易行）各查询一次机构信息且步骤 8/9 分别使用双方层级与上级机构，两组取值如何区分承载未确认（Spec TBD-3） - 影响:当前实现将开户行/交易行两组取值分别承载于局部变量参与步骤 8/9 赋值，输出表 hierarchyCode/attachedTo 仅按开户行查询结果回填，交易行取值未承载于输出 - 待确认:输出表 hierarchyCode/attachedTo 是否仅代表其中一次查询结果或需补充输出字段
        // 输出表 hierarchyCode/attachedTo 按步骤 6（开户行）查询结果回填，交易行取值未承载于输出（TBD-3）。
        output.setHierarchyCode(acctHierarchyCode);
        output.setAttachedTo(acctAttachedTo);

        // 步骤 8（赋值开户机构的管辖分行）：开户行层级=2-支行→赋值归属上级机构号；=1-分行→赋值开立行
        // 行号（Spec REQ-008）。
        // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:「开户机构的管辖分行」「交易机构的管辖分行」输出类型为 java.lang.String，赋值来源为 TranBranch 类型取值，取值按机构编号字符串承载还是存在其他映射约定未确认（Spec TBD-8） - 影响:当前实现按机构编号字符串（TranBranch.getValue()）承载管辖分行取值 - 待确认:管辖分行 String 取值的承载约定（机构编号字符串或其他映射）
        // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:机构层级代码非「2-支行」「1-分行」时（如 -1-虚拟机构、0-总行）步骤 8/9 的管辖分行赋值未定义（Spec REQ-008/REQ-009 仅定义 2 与 1 两档） - 影响:非 1/2 层级时管辖分行保持未赋值（null），步骤 10 比较结果取决于双方取值 - 待确认:非 1/2 层级时管辖分行应如何赋值
        if (HierarchyCode.VALUE_2.equals(acctHierarchyCode)) {
            output.setAcctManageBranch(acctAttachedTo == null ? null : acctAttachedTo.getValue());
        } else if (HierarchyCode.VALUE_1.equals(acctHierarchyCode)) {
            output.setAcctManageBranch(output.getAcctBranch() == null ? null : output.getAcctBranch().getValue());
        }

        // 步骤 9（赋值交易机构的管辖分行）：交易机构层级=2-支行→赋值归属上级机构号；=1-分行→按需求原文
        // 赋值为账户开立行行号（Spec REQ-009）。
        if (HierarchyCode.VALUE_2.equals(tranHierarchyCode)) {
            output.setTranManageBranch(tranAttachedTo == null ? null : tranAttachedTo.getValue());
        } else if (HierarchyCode.VALUE_1.equals(tranHierarchyCode)) {
            // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:步骤 9b 原文「交易机构层级=1-分行时赋值交易机构的管辖分行为账户开立行行号」，与步骤 8b（开户行层级=1-分行赋值为开立行行号，对象为开户行自身）及步骤 9a（层级=2-支行赋值为归属上级机构号）对照疑为原文笔误，应赋值为交易机构（Spec TBD-2） - 影响:交易机构层级=1-分行时交易机构的管辖分行赋值结果未确认，当前按原文赋值为账户开立行行号（acctBranch） - 待确认:交易机构层级=1-分行时交易机构的管辖分行应赋值为交易机构还是原文的账户开立行行号
            output.setTranManageBranch(output.getAcctBranch() == null ? null : output.getAcctBranch().getValue());
        }

        // 步骤 10（管辖机构一致性检查）：开户机构的管辖分行等于交易机构的管辖分行时返回「通过」，
        // 否则返回 ER0073（Spec REQ-010）。
        if (Objects.equals(output.getAcctManageBranch(), output.getTranManageBranch())) {
            output.setSucceed(true);
            return output;
        }
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_DRAB_MISMATCH);
        output.setErrorMessage(ERROR_MESSAGE_DRAB_MISMATCH);
        return output;
    }

    /**
     * 步骤 1/4（获取账户信息）的数据访问：按账号获取对公存款账户主表记录。
     *
     * @param baseAcctNo 账号
     * @return 对公存款账户主表记录；无对应记录时返回 null
     */
    private RbBusAcctEO queryRbBusAcct(String baseAcctNo) {
        // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:由账号 baseAcctNo 定位对公存款账户主表（RB_BUS_ACCT）记录的具体查询路径未确认；RbBusAcctEO 无账号字段，IRbBusAcctBcc 现仅见 findByEo/findByPrimaryKey（客户号、账户内部键值），未见按账号查询接口（Spec TBD-8） - 影响:当前实现对已确认数据源 IRbBusAcctBcc 以空查询条件 EO 调用 findByEo 作占位绑定，入参未携带 baseAcctNo 条件，查询路径与请求字段映射待确认后调整 - 待确认:按账号获取主表记录的具体查询方法/路径及请求字段映射
        RbBusAcctEO query = new RbBusAcctEO();
        List<RbBusAcctEO> accts = rbBusAcctBcc.findByEo(query);
        if (accts == null || accts.isEmpty()) {
            // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:账号 baseAcctNo 在对公存款账户主表无对应记录时的行为未定义（Spec TBD-5，关联 REQ-001/REQ-004） - 影响:无记录分支无已确认失败条件与返回，不推断为查询无记录即业务失败，当前按「未取到开立行行号与通兑标志」（null）继续后续检查 - 待确认:主表无记录时应返回的结果（通过/失败/其他）及失败条件
            return null;
        }
        // 面向单条结果的查询，多条统一取结果集第一条（本项目约定）。
        return accts.get(0);
    }

    /**
     * 步骤 6/7（获取机构信息）的数据访问：按机构号查询机构信息表记录。
     *
     * @param branch 机构号
     * @return 机构信息表记录；无对应记录时返回 null
     */
    private FmBranchEO queryFmBranch(TranBranch branch) {
        // 查询入口 IFmBranchBcc.findByBranch 已确认，可按机构号查询机构信息（Spec 依赖核对）。
        FmBranchEO eo = fmBranchBcc.findByBranch(branch);
        if (eo == null) {
            // FIXME 业务项:ST004/检查账户通兑信息 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:按机构号查询机构信息表（FM_BRANCH）无对应记录时的行为未定义（Spec TBD-5，关联 REQ-006/REQ-007） - 影响:机构表无记录分支无已确认失败条件与返回，不推断为查询无记录即业务失败，当前按「未取到机构层级与上级机构」（null）继续后续检查 - 待确认:机构表无记录时应返回的结果（通过/失败/其他）及失败条件
            return null;
        }
        return eo;
    }
}
