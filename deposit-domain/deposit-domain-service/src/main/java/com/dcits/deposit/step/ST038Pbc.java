package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST038InputBO;
import com.dcits.deposit.facade.bo.ST038OutputBO;
import com.dcits.deposit.facade.components.IFmBranchBcc;
import com.dcits.deposit.facade.components.IRbBusClientAcctBcc;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.facade.eo.RbBusClientAcctEO;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST038 检查账户机构是否可匹配到限额场景配置 步骤实现。
 *
 * <p>按正式 Spec ST038「步骤描述」第 1–5 条编排执行：</p>
 * <ol>
 *   <li>按账号查询账户信息，取得账户开立行行号 acctBranch；</li>
 *   <li>按 acctBranch 查询限额控制配置表，取得启用标志等于"Y-启用"的限额场景编码 limitSceneNo；</li>
 *   <li>limitSceneNo 非空则返回并正常结束，为空则转入子步骤《获取上级机构集合》；</li>
 *   <li>按 acctBranch 查询机构信息表，取得上级机构集合；</li>
 *   <li>按机构层级从大到小遍历上级机构集合，按机构号查询限额场景定义表取得启用限额场景编码，
 *       命中即中断遍历返回，遍历结束未命中则返回空。</li>
 * </ol>
 *
 * <p>需求未登记任何失败条件或错误码，本步骤无业务失败场景，正常完成时 succeed=true 且错误字段为 null。
 * 步骤 1/2/5 查询表与字段绑定、启用标志物理取值、多条命中取数规则、上级机构集合构成与排序方向、
 * 必填缺失与查无记录行为等未确认事项见各子步骤 FIXME（正式 Spec 待确认事项 TBD-1~TBD-6）。</p>
 */
@Service
public class ST038Pbc implements IST038 {

    /** 启用标志取值：启用。Spec 条件原文字面量，实际存储/比较值待确认，见子步骤 2/5 FIXME（TBD-3） */
    private static final String VALID_FLAG_ENABLED = "Y-启用";

    /** 对公客户账户（RB_BUS_CLIENT_ACCT）数据服务，按账号取得账户开立行行号（查询表与字段绑定待确认，见子步骤 1 FIXME TBD-2） */
    @Autowired
    private IRbBusClientAcctBcc rbBusClientAcctBcc;

    /** 限额控制配置（RB_LIMIT_CTRL_CONF）数据服务 */
    @Autowired
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    /** 机构信息（FM_BRANCH）数据服务 */
    @Autowired
    private IFmBranchBcc fmBranchBcc;

    @Override
    public ST038OutputBO execute(ST038InputBO input) {
        ST038OutputBO output = new ST038OutputBO();
        // 输出账号按输入回显（Spec「输出」表 baseAcctNo，取值路径待确认，见子步骤 1 FIXME TBD-2）
        output.setBaseAcctNo(input.getBaseAcctNo());

        // 子步骤 1（REQ-002）：按账号查询账户信息，取得账户开立行行号
        // FIXME 业务项:ST038/检查账户机构是否可匹配到限额场景配置 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤 1 按账号查询账户信息的查询表与关联字段未定义，对公存款账户主表 RB_BUS_ACCT 无账号列（Spec TBD-2） - 影响:当前按工程候选绑定以 RB_BUS_CLIENT_ACCT.baseAcctNo 经 IRbBusClientAcctBcc.findByEo 查询取得 acctBranch，输出 baseAcctNo 按输入回显，实际查询表、关联字段与取值路径待确认 - 待确认:账号到账户开立行行号的查询表、关联字段及输出 baseAcctNo/acctBranch 的实际取值路径
        RbBusClientAcctEO acctQuery = new RbBusClientAcctEO();
        acctQuery.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusClientAcctEO> acctList = rbBusClientAcctBcc.findByEo(acctQuery);
        if (acctList.isEmpty()) {
            // FIXME 业务项:ST038/检查账户机构是否可匹配到限额场景配置 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:baseAcctNo 缺失（未提供/为空）或账号查无记录时的行为未定义（Spec TBD-6） - 影响:该路径当前按查询为空正常结束，返回 succeed=true 与空业务结果，是否报错或如何返回待确认 - 待确认:必填缺失与查无记录路径应报错还是正常返回空结果
            output.setSucceed(true);
            return output;
        }
        // 面向单条结果的查询，多条统一取结果集第一条
        TranBranch acctBranch = acctList.get(0).getAcctBranch();
        output.setAcctBranch(acctBranch);

        // 子步骤 2（REQ-003）：按账户开立行行号查询限额控制配置表，取得启用标志等于"Y-启用"的限额场景编码
        RbLimitCtrlConfEO confQuery = new RbLimitCtrlConfEO();
        confQuery.setLimitBranchId(acctBranch);
        // FIXME 业务项:ST038/检查账户机构是否可匹配到限额场景配置 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:启用标志"Y-启用"的物理存储/比较取值未确认，VALID_FLAG 为 VARCHAR(20)（Spec TBD-3） - 影响:当前按需求原文字面量"Y-启用"作为步骤 2 与步骤 5 的查询条件，实际比较值待确认 - 待确认:启用标志的物理取值（如以"Y"表示启用）
        confQuery.setValidFlag(VALID_FLAG_ENABLED);
        List<RbLimitCtrlConfEO> confList = rbLimitCtrlConfBcc.findByEo(confQuery);
        if (!confList.isEmpty()) {
            // FIXME 业务项:ST038/检查账户机构是否可匹配到限额场景配置 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:同一 LIMIT_BRANCH_ID 可能登记多条启用配置，命中多条记录时的取数规则未定义（Spec TBD-4，步骤 5 同机构多命中同理） - 影响:当前按项目数据访问约定取结果集第一条，实际取数规则待确认 - 待确认:命中多条时取一条/取全部/按何顺序取首条
            RbLimitCtrlConfEO conf = confList.get(0);
            output.setLimitSceneNo(conf.getLimitSceneNo());
            output.setLimitBranchId(conf.getLimitBranchId());
            output.setLimitBranchRange(conf.getLimitBranchRange());
            output.setValidFlag(conf.getValidFlag());
        }

        // 子步骤 3（REQ-004）：限额场景编码非空则返回并正常结束，为空则转入子步骤《获取上级机构集合》
        if (output.getLimitSceneNo() != null && !output.getLimitSceneNo().isEmpty()) {
            output.setSucceed(true);
            return output;
        }

        // 子步骤 4（REQ-005）：按账户开立行行号查询机构信息表，取得上级机构集合
        // FIXME 业务项:ST038/检查账户机构是否可匹配到限额场景配置 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:上级机构集合构成（是否含账户开立行自身、是否沿 attachedTo 逐级上取）及"机构层级从大到小"与 HierarchyCode 取值（-1 虚拟、0 总行、1 分行、2 支行）的排序方向未定义（Spec TBD-5） - 影响:当前按查询返回集合直接遍历、不额外排序，branch/attachedTo 输出取命中记录数据，集合构成与遍历顺序待确认 - 待确认:集合构成、获取方式及按机构层级的排序方向
        FmBranchEO branchQuery = new FmBranchEO();
        branchQuery.setBranch(acctBranch);
        List<FmBranchEO> branchList = fmBranchBcc.findByEo(branchQuery);

        // 子步骤 5（REQ-006）：按机构层级从大到小遍历上级机构集合，对每条机构的机构号查询限额场景定义表，
        // 取得启用标志等于"Y-启用"的限额场景编码，命中即中断遍历返回，遍历结束未命中返回空
        for (FmBranchEO branchRecord : branchList) {
            // FIXME 业务项:ST038/检查账户机构是否可匹配到限额场景配置 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:步骤 5 按机构号查询限额场景定义表获取启用限额场景编码，但现工程该表无机构号（branch）列、无限额场景编码（LIMIT_SCENE_NO）列（Spec TBD-1） - 影响:当前按工程可行绑定沿用限额控制配置表按 limitBranchId 匹配（IRbLimitCtrlConfBcc.findByEo）读取 limitSceneNo，实际查询表与字段待确认 - 待确认:第 5 条实际应查询的表与字段（沿用 RB_LIMIT_CTRL_CONF 按 limitBranchId 匹配，或另有含机构号与限额场景编码的限额场景定义表）
            RbLimitCtrlConfEO sceneQuery = new RbLimitCtrlConfEO();
            sceneQuery.setLimitBranchId(branchRecord.getBranch());
            sceneQuery.setValidFlag(VALID_FLAG_ENABLED);
            List<RbLimitCtrlConfEO> sceneList = rbLimitCtrlConfBcc.findByEo(sceneQuery);
            if (!sceneList.isEmpty()) {
                RbLimitCtrlConfEO scene = sceneList.get(0);
                output.setLimitSceneNo(scene.getLimitSceneNo());
                output.setLimitBranchId(scene.getLimitBranchId());
                output.setLimitBranchRange(scene.getLimitBranchRange());
                output.setValidFlag(scene.getValidFlag());
                output.setBranch(branchRecord.getBranch());
                output.setAttachedTo(branchRecord.getAttachedTo());
                break;
            }
        }

        output.setSucceed(true);
        return output;
    }
}
