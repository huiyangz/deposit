package com.dcits.deposit.step;

import java.util.List;

import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST048InputBO;
import com.dcits.deposit.facade.bo.ST048OutputBO;
import com.dcits.deposit.facade.components.IFmChannelBcc;
import com.dcits.deposit.facade.components.IRbRestraintControlDetailsBcc;
import com.dcits.deposit.facade.eo.FmChannelEO;
import com.dcits.deposit.facade.eo.RbRestraintControlDetailsEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST048 检查限制豁免 步骤实现。
 *
 * <p>按正式 Spec 子步骤 1~5 执行：获取渠道的柜面标志、获取限制控制明细、检查柜面标志分支、
 * 检查柜面渠道的豁免信息、检查非柜面渠道的豁免信息，并按「输出」表装配步骤输出。</p>
 *
 * <p>未确定业务行为（TBD-1 检查结论承载字段、TBD-2 输入缺失行为、TBD-3 渠道柜面标志字段缺失、
 * TBD-6 匹配语义、TBD-8 查询无记录行为、TBD-9 两个同名柜面标志命名、TBD-10 柜面标志物理编码）
 * 在对应实现位置以 FIXME 记录，不补默认业务行为。</p>
 */
@Service
public class ST048Pbc implements IST048 {

    /** 渠道类型表(FM_CHANNEL)数据服务 */
    @Autowired
    IFmChannelBcc fmChannelBcc;

    /** 限制控制明细表(RB_RESTRAINT_CONTROL_DETAILS)数据服务 */
    @Autowired
    IRbRestraintControlDetailsBcc rbRestraintControlDetailsBcc;

    /** 柜面标志-是 */
    private static final String COUNTER_FLAG_YES = "Y";

    @Override
    public ST048OutputBO execute(ST048InputBO input) {
        ST048OutputBO output = new ST048OutputBO();

                                                                                                                                                                                             

        // 子步骤1 获取渠道的柜面标志：按渠道类型(sourceType)查询渠道类型定义表(FM_CHANNEL)
                                                           
        FmChannelEO channel = fmChannelBcc.findByChannel(input.getSourceType());
                                                                                                                                                                                                                                                                                                                                   

        // 子步骤2 获取限制控制明细：按账户限制类型(restraintType)与状态=Status.A 查询限制控制明细表(RB_RESTRAINT_CONTROL_DETAILS)
                                                           
        RbRestraintControlDetailsEO queryEo = new RbRestraintControlDetailsEO();
        queryEo.setRestraintType(input.getRestraintType());
        queryEo.setStatus(Status.A);
        List<RbRestraintControlDetailsEO> details = rbRestraintControlDetailsBcc.findByEo(queryEo);
                                                                                                                                                                                                                        

        // 多条生效明细按本项目约定统一取结果集第一条，先判空再取值
                                                           
        RbRestraintControlDetailsEO firstDetail = (details == null || details.isEmpty()) ? null : details.get(0);

        // 子步骤3 检查柜面标志：渠道柜面标志=「Y-是」且 明细柜面标志=「Y-是」→ 跳转《检查柜面渠道的豁免信息》；否则跳转《检查非柜面渠道的豁免信息》
        // 渠道柜面标志因 TBD-3 无法取得（恒为 null，不等于「Y」），当前仅以明细柜面标志参与分支判断
                                                                                                                                                                                                                                          
                                                           
        if (firstDetail != null && COUNTER_FLAG_YES.equals(firstDetail.getCounterFlag())) {
            // 子步骤4 检查柜面渠道的豁免信息：明细中存在交易类型、摘要码、产品类型同时匹配的记录 → 返回「不检查限制」，否则返回「需检查限制」
            // 检查结论承载字段未定义（TBD-1），结论当前仅内部计算，不写入步骤输出
            checkCounterExemption(input, details);
        } else {
            // 子步骤5 检查非柜面渠道的豁免信息：明细中存在交易类型、摘要码、产品类型同时匹配的记录 → 返回「豁免」，否则返回「不豁免」
            // 检查结论承载字段未定义（TBD-1），结论当前仅内部计算，不写入步骤输出
            checkNonCounterExemption(input, details);
        }

        // 步骤输出：按「输出」表装配，取值与查询结果一致（多条明细按本项目约定取结果集第一条）
        if (firstDetail != null) {
            output.setStatus(firstDetail.getStatus());
            output.setProdNo(firstDetail.getProdNo());
            output.setTranTypeLink(firstDetail.getTranTypeLink());
            output.setChannelMuster(firstDetail.getChannelMuster());
            output.setNarrativeCode(firstDetail.getNarrativeCode());
            output.setResBranchRange(firstDetail.getResBranchRange());
            output.setCounterFlag(firstDetail.getCounterFlag());
        }
        // 柜面标志（来源渠道类型表 FM_CHANNEL）：FmChannelEO 无 counterFlag 字段无法取得，字段命名与取值机制见 TBD-3、TBD-9
        // （channelCounterFlag 保持默认 null，不伪造取值）

        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤4 检查柜面渠道的豁免信息。
     *
     * @param input   步骤输入
     * @param details 限制控制明细集合
     * @return 检查结果「不检查限制」或「需检查限制」（承载字段未定义，见 FIXME）
     */
    private String checkCounterExemption(ST048InputBO input, List<RbRestraintControlDetailsEO> details) {
        boolean matched = existsMatchedDetail(input, details);
                                                                                                                                                                                                  
                                                           
        return matched ? "不检查限制" : "需检查限制";
    }

    /**
     * 子步骤5 检查非柜面渠道的豁免信息。
     *
     * @param input   步骤输入
     * @param details 限制控制明细集合
     * @return 检查结果「豁免」或「不豁免」（承载字段未定义，见 FIXME）
     */
    private String checkNonCounterExemption(ST048InputBO input, List<RbRestraintControlDetailsEO> details) {
        boolean matched = existsMatchedDetail(input, details);
                                                                                                                                                                                             
                                                           
        return matched ? "豁免" : "不豁免";
    }

    /**
     * 判断限制控制明细中是否存在交易类型、摘要码、产品类型同时匹配的记录。
     *
     * @param input   步骤输入
     * @param details 限制控制明细集合
     * @return 存在同时匹配记录时返回 {@code true}
     */
    private boolean existsMatchedDetail(ST048InputBO input, List<RbRestraintControlDetailsEO> details) {
                                                                                                                                                                                                                                                                                                                                                  
                                                           
        if (details == null) {
            return false;
        }
        for (RbRestraintControlDetailsEO detail : details) {
            if (input.getTranType().getValue().equals(detail.getTranTypeLink())
                    && input.getNarrativeCode().equals(detail.getNarrativeCode())
                    && input.getProductType().equals(detail.getProdNo())) {
                return true;
            }
        }
        return false;
    }
}
