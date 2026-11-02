package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.components.IRbLimitCtrlCustomInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ST037 获取限额场景编码 步骤实现。
 *
 * <p>按正式 Spec REQ-001~REQ-008 实现：步骤 1 按 limitSceneNo 查询【限额控制配置表】
 * 取得配置来源输出字段；步骤 2 当「允许自定义标识」为 "N-否" 时直接返回输入
 * limitSceneNo；步骤 3 查询【限额控制客户自定义配置表】取得生效日期 ≤ 交易日期
 * 的自定义限额；步骤 4 按自定义限额是否存在、临时限额标志与失效日期、
 * 仅检查客户自定义标志判定最终返回。</p>
 */
@Service
public class ST037Pbc implements IST037 {

    @Autowired
    private IRbLimitCtrlConfBcc limitCtrlConfBcc;

    @Autowired
    private IRbLimitCtrlCustomInfoBcc limitCtrlCustomInfoBcc;

    @Override
    public ST037OutputBO execute(ST037InputBO input) {
        ST037OutputBO output = new ST037OutputBO();
        // REQ-008 输入输出契约：baseAcctNo、clientNo 按输入回显
        output.setBaseAcctNo(input.getBaseAcctNo());
        output.setClientNo(input.getClientNo());

        // 步骤 1（REQ-001）：以输入 limitSceneNo 为查询条件查询【限额控制配置表】，输出该表来源字段
        RbLimitCtrlConfEO confQuery = new RbLimitCtrlConfEO();
        confQuery.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confList = limitCtrlConfBcc.findByEo(confQuery);
        if (confList == null || confList.isEmpty()) {
            // 查询无记录时的返回行为需求未定义（Spec 待确认事项 5），当前按工程约定返回成功与空结果
            // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:按 limitSceneNo 查询限额控制配置无记录时的取数/返回行为未定义（Spec 待确认事项 5） - 影响:无记录时无法取得 allowCustomFlag 等配置来源字段，当前按工程约定返回成功及空结果 - 待确认:配置查询无记录时应返回的结果
            output.setSucceed(true);
            return output;
        }
        // 步骤 1（REQ-001）：同一 limitSceneNo 存在多条机构记录时取数规则未定义（Spec 待确认事项 5），按工程约定取结果集第一条
        // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:同一 limitSceneNo 存在多条限额控制配置记录（输入未含配置表主键之一 limitBranchId）时取数规则未定义（Spec 待确认事项 5） - 影响:当前按工程约定取结果集第一条 - 待确认:按 limitSceneNo 单键查询的多记录取数规则
        RbLimitCtrlConfEO confRec = confList.get(0);
        output.setAllowCustomFlag(confRec.getAllowCustomFlag());
        output.setOnlyCustom(confRec.getOnlyCustom());
        output.setTempLimitFlag(confRec.getTempLimitFlag());
        output.setTempLimitValidTerm(confRec.getTempLimitValidTerm());

        // 步骤 2（REQ-002）：允许自定义标识为 "N-否" 时返回输入 limitSceneNo，不执行自定义限额查询
        // "Y-是"/"N-否" 为带中文标注的编码串，实际存储值及比较口径未确认（Spec 待确认事项 6），当前按需求原文整串比较
        // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:需求判定值 "Y-是"/"N-否" 为带中文标注的编码串，实际存储值（如仅 Y/N）及比较方式（整串匹配或取编码前缀）未确认（Spec 待确认事项 6，涉及步骤 2、4 各判定） - 影响:当前按需求原文整串 "N-否"/"Y-是" 比较，存储编码不同时判定失效 - 待确认:判定取值的统一编码及比较口径
        if ("N-否".equals(confRec.getAllowCustomFlag())) {
            output.setLimitSceneNo(input.getLimitSceneNo());
            output.setSucceed(true);
            return output;
        }

        // 步骤 3（REQ-003）：查询【限额控制客户自定义配置表】获取生效日期 ≤ 交易日期的自定义限额
        RbLimitCtrlCustomInfoEO customQuery = new RbLimitCtrlCustomInfoEO();
        customQuery.setLimitSceneNo(input.getLimitSceneNo());
        // 自定义限额查询的定位键组合未定义（Spec 待确认事项 2），当前仅按 limitSceneNo 定位
        // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:自定义限额查询的定位键组合未定义（是否按 limitSceneNo + checkObjVal/clientNo 组合、checkObjVal 是否取输入 baseAcctNo）（Spec 待确认事项 2） - 影响:当前仅以 limitSceneNo 作为查询条件，输入 baseAcctNo、clientNo 未参与定位 - 待确认:自定义限额查询定位键及输入 baseAcctNo、clientNo 的用途
        List<RbLimitCtrlCustomInfoEO> customList = limitCtrlCustomInfoBcc.findByEo(customQuery);

        // 步骤 3（REQ-003）：「生效日期 ≤ 交易日期」现有 findByEo 的 Example 对 effectDate 仅生成 andEffectDateEqualTo 等值条件，
        // 暂按取得记录后内存过滤实现（Spec 待确认事项 3）
        // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:「生效日期 ≤ 交易日期」的查询能力未确认，现有 IRbLimitCtrlCustomInfoBcc.findByEo 对 effectDate 仅支持 andEffectDateEqualTo 等值条件（Spec 待确认事项 3） - 影响:当前在步骤内取得记录后按内存过滤实现该条件 - 待确认:该条件经扩展查询接口/Example 实现，或由步骤取得记录后内存过滤
        List<RbLimitCtrlCustomInfoEO> effectCustomList = new ArrayList<>();
        if (customList != null) {
            for (RbLimitCtrlCustomInfoEO customRec : customList) {
                if (customRec.getEffectDate() != null && !customRec.getEffectDate().after(input.getTranDate())) {
                    effectCustomList.add(customRec);
                }
            }
        }

        // 步骤 4（REQ-004~REQ-007）：检查自定义限额，获取对应限额信息
        if (effectCustomList.isEmpty()) {
            // 步骤 4.3/4.4（REQ-006/REQ-007）：自定义限额不存在，按配置「仅检查客户自定义标志」判定
            if ("Y-是".equals(confRec.getOnlyCustom())) {
                // REQ-006：返回 limitSceneNo 为空（当前实现取 null，空值口径待确认事项 7）
                // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:「返回 limitSceneNo 为空」的表示口径（null 或空字符串）未定义（Spec 待确认事项 7，同 REQ-004） - 影响:当前统一以 null 表示空，空字符串口径下输出不一致 - 待确认:输出 limitSceneNo 的空值口径
                output.setLimitSceneNo(null);
            } else if ("N-否".equals(confRec.getOnlyCustom())) {
                // REQ-007：返回输入 limitSceneNo
                output.setLimitSceneNo(input.getLimitSceneNo());
            } else {
                // 仅检查客户自定义标志取值既非 "Y-是" 亦非 "N-否" 时需求未定义返回结果（Spec 待确认事项 4、6），不补默认行为，保持 limitSceneNo 不设置
                // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:自定义限额不存在时仅检查客户自定义标志取值既非 "Y-是" 亦非 "N-否"（或存储编码不同）时需求未定义返回结果（Spec 待确认事项 4、6） - 影响:当前不设置 limitSceneNo（保持空），无法确定是否符合业务预期 - 待确认:该取值的预期返回结果
                output.setLimitSceneNo(null);
            }
        } else {
            // 自定义限额存在：取结果集第一条（多条取数规则未定义，关联 Spec 待确认事项 5），输出自定义配置来源字段
            RbLimitCtrlCustomInfoEO customRec = effectCustomList.get(0);
            output.setEffectDate(customRec.getEffectDate());
            output.setExpireDate(customRec.getExpireDate());
            // 步骤 4.1/4.2（REQ-004/REQ-005）：按「临时限额标志」判定；自定义配置 EO 无 tempLimitFlag 字段，
            // 当前按配置表 tempLimitFlag 构造（工程唯一真实字段，归属见 Spec 待确认事项 1）
            // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:类型定义矛盾 - 问题描述:需求输出表将 tempLimitFlag 同时标注来源为限额控制配置与限额控制客户自定义配置，而 RbLimitCtrlCustomInfoEO 不含 tempLimitFlag 字段（Spec 待确认事项 1） - 影响:步骤 4.1/4.2 判定取值当前按配置表 tempLimitFlag 构造（工程唯一真实字段），自定义配置来源的 tempLimitFlag 输出不成立 - 待确认:临时限额标志实际取自哪张表及自定义配置来源的 tempLimitFlag 输出是否成立
            if ("Y-是".equals(confRec.getTempLimitFlag())) {
                if (customRec.getExpireDate() != null && input.getTranDate().after(customRec.getExpireDate())) {
                    // REQ-004：交易日期大于失效日期，返回 limitSceneNo 为空（当前实现取 null，空值口径待确认事项 7）
                    output.setLimitSceneNo(null);
                } else {
                    // 临时限额标志="Y-是"但交易日期 ≤ 失效日期（临时限额未失效）时需求未定义返回结果（Spec 待确认事项 4），不补默认行为，保持 limitSceneNo 不设置
                    // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:自定义限额存在且临时限额标志="Y-是"但交易日期 ≤ 失效日期（临时限额未失效）时需求未定义返回结果（Spec 待确认事项 4） - 影响:当前不设置 limitSceneNo（保持空），无法确定是否符合业务预期 - 待确认:该情形的预期返回结果
                    output.setLimitSceneNo(null);
                }
            } else if ("N-否".equals(confRec.getTempLimitFlag())) {
                // REQ-005：返回输入 limitSceneNo
                output.setLimitSceneNo(input.getLimitSceneNo());
            } else {
                // 临时限额标志取值既非 "Y-是" 亦非 "N-否" 时需求未定义返回结果（Spec 待确认事项 4、6），不补默认行为，保持 limitSceneNo 不设置
                // FIXME 业务项:ST037/获取限额场景编码 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:自定义限额存在时临时限额标志取值既非 "Y-是" 亦非 "N-否"（或存储编码不同）时需求未定义返回结果（Spec 待确认事项 4、6） - 影响:当前不设置 limitSceneNo（保持空），无法确定是否符合业务预期 - 待确认:该取值的预期返回结果
                output.setLimitSceneNo(null);
            }
        }
        // 步骤正常完成：显式成功，错误字段保持 null
        output.setSucceed(true);
        return output;
    }
}
