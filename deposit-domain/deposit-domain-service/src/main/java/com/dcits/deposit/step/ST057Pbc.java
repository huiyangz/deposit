package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057OutputBO;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.components.IRbTranDefBcc;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;
import com.dcits.deposit.facade.eo.RbTranDefEO;

/**
 * ST057 检查限制优先级 实现。
 *
 * <p>按正式 Spec 已确认行为执行：REQ-002-S01 根据输入交易类型查询交易类型定义表
 * （RB_TRAN_DEF），REQ-003-S01 根据输入账户限制类型查询存款限制类型表
 * （RB_RESTRAINT_TYPE）；REQ-004 的比较取值口径（Spec 待确认事项 TBD-1/TBD-3）、
 * 查询无记录行为（TBD-5）与必填输入缺失行为（TBD-6）未定义，见 {@link #execute}
 * 中 FIXME，不编造编码或失败处理。正常完成显式成功且错误字段为 null。</p>
 */
@Service
public class ST057Pbc implements IST057 {

    private final IRbTranDefBcc rbTranDefBcc;
    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST057Pbc(IRbTranDefBcc rbTranDefBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbTranDefBcc = rbTranDefBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST057OutputBO execute(ST057InputBO input) {
                                                                                                                                                                                                          
        // 子步骤1（REQ-002-S01）：根据输入交易类型查询交易类型定义表，取得交易的「限制级别」
                                                           
        RbTranDefEO tranDef = rbTranDefBcc.findByTranType(input.getTranType());
                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                
        // 子步骤2（REQ-003-S01）：根据输入账户限制类型查询存款限制类型表，取得冻结级别 resPriority
                                                           
                                                           
        RbRestraintTypeEO restraintTypeEo = rbRestraintTypeBcc.findByRestraintType(input.getRestraintType());
        // 子步骤3（REQ-004）：比较交易的「限制级别」与账户限制类型的「冻结级别」，高于→「不检查限制」，否则→「继续检查」
                                                                                                                                                                                                                                                                                                                      

                                                           
        ST057OutputBO result = new ST057OutputBO();
        result.setSucceed(true);
        return result;
    }
}
