package com.dcits.depsit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.DealFlow;
import com.dcits.depsit.facade.bo.ST105InputBO;
import com.dcits.depsit.facade.bo.ST105OutputBO;
import com.dcits.depsit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.depsit.facade.eo.RbLimitCtrlConfEO;

/**
 * ST105 处理限额 步骤实现。
 *
 * <p>整体意图：以 [限额场景编码]（入参 {@code limitSceneNo}）为条件查询
 * 【限额控制配置(RB_LIMIT_CTRL_CONF)】，取得该配置的 [处理方式]（{@code DEAL_FLOW}），
 * 据其取值返回「授权」（A）／「拒绝」（B）／「提醒」（D）三种检查结果之一，
 * 经唯一输出字段 {@code dealFlow} 对外交付。</p>
 *
 * <ul>
 *   <li>子步骤1（实体查询类）：以仅置 {@code limitSceneNo} 的 {@link RbLimitCtrlConfEO}
 *       调用 {@code findByEo} 查询配置记录，并取命中配置行的 {@code DEAL_FLOW} 作为 [处理方式]。</li>
 *   <li>子步骤2（逻辑判断类）：按 [处理方式] 的三个取值分别确定返回的检查结果，
 *       检查结果与 {@code dealFlow} 一一对应（「授权」↔ A、「拒绝」↔ B、「提醒」↔ D）。</li>
 * </ul>
 *
 * <p>本步骤为纯读取动作，无写库，故不加事务；无业务失败场景，正常结束一律 {@code succeed = true}
 * 且不置错误码，技术异常按技术异常向上传播。</p>
 */
@Service
public class ST105Pbc implements IST105 {

    private final IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    public ST105Pbc(IRbLimitCtrlConfBcc rbLimitCtrlConfBcc) {
        this.rbLimitCtrlConfBcc = rbLimitCtrlConfBcc;
    }

    @Override
    public ST105OutputBO execute(ST105InputBO input) {
        ST105OutputBO output = new ST105OutputBO();

        // 子步骤1：按 [限额场景编码] 查询【限额控制配置】，查询条件仅含限额场景编码
        RbLimitCtrlConfEO queryEo = new RbLimitCtrlConfEO();
        queryEo.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confList = rbLimitCtrlConfBcc.findByEo(queryEo);

        // 取命中配置行的 [处理方式]（DEAL_FLOW）。该表主键为「限额机构编码＋限额场景编码」，
        // 本步骤输入不含限额机构编码，多条记录的取舍口径与查无记录的返回结果均属 Spec 已放行的
        // 不覆盖事项（不覆盖事项 1、2），实现在此只按查询结果取用首个配置行的处理方式，
        // 不据此另立取舍规则；无记录时 [处理方式] 取不到值。
        DealFlow dealFlow = null;
        if (confList != null && !confList.isEmpty()) {
            dealFlow = confList.get(0).getDealFlow();
        }

        // 子步骤2：按 [处理方式] 取值确定返回的检查结果，检查结果经唯一输出字段 dealFlow 交付
        if (DealFlow.B == dealFlow) {
            // B-拒绝处理 → 检查结果「拒绝」
            output.setDealFlow(DealFlow.B);
        } else if (DealFlow.D == dealFlow) {
            // D-提醒处理 → 检查结果「提醒」
            output.setDealFlow(DealFlow.D);
        } else if (DealFlow.A == dealFlow) {
            // A-授权处理 → 检查结果「授权」
            output.setDealFlow(DealFlow.A);
        }
        // [处理方式] 为空或取值不在 {A, B, D} 之内时无已定义分支，dealFlow 保持空值（不覆盖事项 3），
        // 不作为业务失败，不置错误码。

        output.setSucceed(true);
        return output;
    }
}
