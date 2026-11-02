package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.RcBlackStatus;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.IFmServiceDefineBcc;
import com.dcits.deposit.facade.components.IRcAllListBcc;
import com.dcits.deposit.facade.components.IRcListTypeBcc;
import com.dcits.deposit.facade.components.IRcRuleTypeBcc;
import com.dcits.deposit.facade.eo.FmServiceDefineEO;
import com.dcits.deposit.facade.eo.RcAllListEO;
import com.dcits.deposit.facade.eo.RcListTypeEO;
import com.dcits.deposit.facade.eo.RcRuleTypeEO;

/**
 * ST036 检查黑名单 步骤实现。
 *
 * <p>按正式 Spec 依次执行检查阶段（步骤描述 1-16）：REQ-001 服务定义检查、REQ-002
 * 黑名单信息检查、REQ-003 黑名单检查规则编号检查、REQ-004 黑名单限制操作标识检查；
 * 任一检查不满足时提前返回「通过」（succeed=true、错误字段为空、不设置 dealFlow）。
 * 后续 REQ-005~008（名单检查范围与不检查范围检查、介质检查、机构检查、处理方式返回）
 * 因 REQ-004-S01 继续分支的「E-检查类」取值未确认（TBD-2）暂不可达，见 REQ-004 处 FIXME。</p>
 */
@Service
public class ST036Pbc implements IST036 {

    @Autowired
    private IFmServiceDefineBcc fmServiceDefineBcc;

    @Autowired
    private IRcAllListBcc rcAllListBcc;

    @Autowired
    private IRcListTypeBcc rcListTypeBcc;

    @Autowired
    private IRcRuleTypeBcc rcRuleTypeBcc;

    @Override
    public ST036OutputBO execute(ST036InputBO input) {
        // REQ-001 服务定义检查（步骤 1-2）：按接口服务代码/接口服务类型查询核心服务定义表；
        // 当且仅当存在服务状态=「A-生效」且黑名单检查标志=「Y-是」的记录时继续，否则返回「通过」。
        FmServiceDefineEO serviceQuery = new FmServiceDefineEO();
        serviceQuery.setMessageCode(input.getMessageCode());
        serviceQuery.setMessageType(input.getMessageType());
        List<FmServiceDefineEO> serviceList = fmServiceDefineBcc.findByEo(serviceQuery);
        if (!containsEffectiveService(serviceList)) {
            return passResult();
        }

        // REQ-002 黑名单信息检查（步骤 3-4）：按客户号查询名单信息表获取黑名单状态为
        // 「生效」的名单类型代码；[黑名单信息] 非空时继续，否则返回「通过」。
        // FIXME 业务项:ST036/检查黑名单 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:REQ-002 步骤 3 支持按{客户号}或{身份证信息}或{账号}查询名单信息表，{身份证信息}对应输入字段口径未确认（TBD-6），且 RcAllListEO 无证件号码、账号查询字段 - 影响:当前仅按 clientNo 查询，其余查询键不可用，命中范围受限 - 待确认:{身份证信息}对应输入字段（documentId？证件类型+证件号码组合？）及是否需按{账号}查询
        RcAllListEO blackQuery = new RcAllListEO();
        blackQuery.setClientNo(input.getClientNo());
        blackQuery.setRcBlackStatus(RcBlackStatus.A);
        List<RcAllListEO> blackList = rcAllListBcc.findByEo(blackQuery);
        if (blackList == null || blackList.isEmpty()) {
            return passResult();
        }
        // FIXME 业务项:ST036/检查黑名单 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:REQ-002/REQ-003 生效黑名单记录、规则编号多记录处理未定义（TBD-7），不套用「多条取结果集第一条」约定 - 影响:当前实现取生效黑名单结果集第一条的名单类型代码作为 REQ-003 查询键 - 待确认:多记录处理规则（遍历全部、取第一条、优先级）
        String listType = blackList.get(0).getListType();

        // REQ-003 黑名单检查规则编号检查（步骤 5-6）：按名单类型代码查询名单类型表获取
        // 黑名单检查规则编号；[黑名单检查规则编号] 非空时继续，否则返回「通过」。
        RcListTypeEO listTypeInfo = rcListTypeBcc.findByPrimaryKey(listType);
        if (listTypeInfo == null || listTypeInfo.getRuleId() == null || listTypeInfo.getRuleId().isEmpty()) {
            return passResult();
        }
        String ruleId = listTypeInfo.getRuleId();

        // REQ-004 黑名单限制操作标识检查（步骤 7-8）：按黑名单检查规则编号查询名单限制
        // 规则表获取名单限制规则信息；操作标识为「E-检查类」时继续，否则返回「通过」。
        RcRuleTypeEO ruleType = rcRuleTypeBcc.findByPrimaryKey(ruleId);
        if (ruleType == null) {
            // 查无名单限制规则记录，操作标识判定为否 → 返回「通过」（REQ-004-S02）
            return passResult();
        }
        // FIXME 业务项:ST036/检查黑名单 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:REQ-004 步骤 8 要求$黑名单限制操作标识$为「E-检查类」时继续，工程枚举 ResOperateFlag 仅有 C=控制、E=异常，无「检查类」取值（TBD-2），无法以真实常量判定继续分支 - 影响:REQ-004-S01 继续分支及后续 REQ-005~008（名单检查范围/介质/机构/处理方式）全部路径不可实现，REQ-008「拒绝/授权/提醒」（dealFlow=B/A/D）输出未实现 - 待确认:「E-检查类」对应物理编码与业务语义（新增枚举值、是否即 E、或复用其它枚举）
        // 非空规则记录的操作标识当前无法与「检查类」取值比对，统一按非检查类返回「通过」（REQ-004-S02）；
        // 继续分支（后续检查阶段）待 TBD-2 确认后实现。
        return passResult();
    }

    /**
     * 构造「通过」结果：步骤正常结束（succeed=true），错误字段保持为空，不设置 dealFlow。
     */
    private ST036OutputBO passResult() {
        ST036OutputBO result = new ST036OutputBO();
        result.setSucceed(true);
        return result;
    }

    /**
     * REQ-001 判定：服务信息列表中存在服务状态=「A-生效」且黑名单检查标志=「Y-是」的记录。
     */
    private boolean containsEffectiveService(List<FmServiceDefineEO> serviceList) {
        if (serviceList == null) {
            return false;
        }
        // FIXME 业务项:ST036/检查黑名单 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:REQ-001 步骤 2 判定$服务状态$「A-生效」、$黑名单检查标志$「Y-是」为 String 字段，物理存储编码未确认（TBD-9） - 影响:REQ-001 继续/「通过」分支当前按 Spec 场景值全串字面量判定，编码变更时判定取值需同步 - 待确认:服务状态与黑名单检查标志的物理编码（"A"/"Y" 或全串）及判定依据是否以查询结果为准
        for (FmServiceDefineEO service : serviceList) {
            if ("A-生效".equals(service.getServiceStatus()) && "Y-是".equals(service.getBlacklistCheckFlag())) {
                return true;
            }
        }
        return false;
    }
}
