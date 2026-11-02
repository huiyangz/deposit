package com.dcits.deposit.step;

import com.dcits.common.step.GotoStepCondition;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.facade.bo.ST006InputBO;
import com.dcits.deposit.facade.bo.ST006OutputBO;
import com.dcits.deposit.facade.components.IRbTranDefBcc;
import com.dcits.deposit.facade.eo.RbTranDefEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST006 检查法透标志。
 *
 * <p>交易执行步骤实现。子步骤：
 * <ol>
 *   <li>获取交易借贷标志（REQ-001）：根据 {@code tranType} 查询交易类型定义表（RB_TRAN_DEF），
 *       取记录的借贷标志字段作为输出 {@code crDrInd}；</li>
 *   <li>检查是否可透支（REQ-002/REQ-003）：若借贷标志为「借」（{@code CrDrInd.D}）且
 *       法人透支检查标志为「是」（取值"Y"），则以业务成功结束本步骤并跳转步骤《检查靠档标识》；
 *       否则以业务失败结束，返回错误码 {@code ER0060}。</li>
 * </ol></p>
 *
 * <p>跳转《检查靠档标识》属内部跳转，由 {@link GotoStepCondition} 声明候选步骤，运行时依据
 * 步骤返回结果的 {@code gotoStepName} 决定跳转；本实现不构造对目标步骤的真实调用。</p>
 */
@Service
@GotoStepCondition(candidateSteps = {"检查靠档标识"})
public class ST006Pbc implements IST006 {

    /** 交易类型定义表（RB_TRAN_DEF）数据服务接口 */
    private final IRbTranDefBcc irbTranDefBcc;

    @Autowired
    public ST006Pbc(IRbTranDefBcc irbTranDefBcc) {
        this.irbTranDefBcc = irbTranDefBcc;
    }

    @Override
    public ST006OutputBO execute(ST006InputBO input) {
        ST006OutputBO result = new ST006OutputBO();

        // 子步骤 1（subStepId=获取交易借贷标志，REQ-001）：根据交易类型查询交易类型定义表（RB_TRAN_DEF），取记录的借贷标志字段作为输出 crDrInd
        // FIXME 业务项:ST006/检查法透标志 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:根据tranType查询交易类型定义表（RB_TRAN_DEF）无匹配记录（IRbTranDefBcc.findByTranType 返回 null 或异常）时的行为未定义（Spec 待确认事项 TBD-1） - 影响:当前实现按无借贷标志处理，进入「非借方」的 ER0060 失败分支；若业务应视为查询失败返回错误或其它处理，行为不一致 - 待确认:查询无匹配记录应视为查询失败返回错误、按「非借方」进入 ER0060 分支还是其它处理
        RbTranDefEO rbTranDefEO = irbTranDefBcc.findByTranType(input.getTranType());
        CrDrInd crDrInd = rbTranDefEO == null ? null : rbTranDefEO.getCrDrInd();
        result.setCrDrInd(crDrInd);
        // FIXME 业务项:ST006/检查法透标志 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输出crDrInd标记非必填，业务失败（返回ER0060）路径上该输出是否仍填充未定义（Spec 待确认事项 TBD-4） - 影响:当前实现查询后即填充crDrInd，成功与失败路径均返回该输出；若失败路径不应返回，输出语义不一致 - 待确认:失败返回（ER0060）路径上 crDrInd 输出是否仍填充

        // 子步骤 2（subStepId=检查是否可透支，REQ-002/REQ-003）：借贷标志为「借」且法人透支检查标志为「是」时业务成功并跳转《检查靠档标识》，否则业务失败返回错误码 ER0060
        // FIXME 业务项:ST006/检查法透标志 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:必填输入tranType或法人透支检查标志缺失（null/空）时的行为未定义，需求仅标记必填（Spec 待确认事项 TBD-2） - 影响:当前实现不做显式校验，法人透支检查标志非"Y"（含 null）按不满足进入 ER0060 分支，tranType 为 null 时查询行为依赖查询接口；若业务要求必填校验失败报错，行为不一致 - 待确认:必填输入缺失时应校验失败并返回何种错误结果，还是按当前自然行为处理
        if (crDrInd == CrDrInd.D && "Y".equals(input.get法人透支检查标志())) {
            // REQ-002-S01：借方且法人透支检查标志为是 → 业务成功结束本步骤，流程跳转《检查靠档标识》
            result.setSucceed(true);
            return result;
        }
        // REQ-003-S01/REQ-003-S02：借贷标志非借，或法人透支检查标志不为是 → 业务失败结束，返回错误码 ER0060
        result.setSucceed(false);
        result.setErrorCode("ER0060");
        // FIXME 业务项:ST006/检查法透标志 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:错误码ER0060的业务说明未提供，errorMessage 需按「ER0060::业务说明」格式，内容待确认（Spec 待确认事项 TBD-3） - 影响:当前 errorMessage 保持 null 不返回错误说明；若上层按 errorMessage 展示错误原因，内容缺失 - 待确认:ER0060 的业务说明内容
        return result;
    }
}
