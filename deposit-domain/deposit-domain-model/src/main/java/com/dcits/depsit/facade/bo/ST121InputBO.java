package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.TranType;

/**
 * ST121 检查限制优先级 输入 BO。
 *
 * <p>两个输入字段分别作为子步骤 1、子步骤 2 的按主键查询条件：{@code tranType} 对应步骤描述的
 * {交易类型}，{@code restraintType} 对应步骤描述的 {账户限制类型}。</p>
 *
 * <p>源需求将两个字段均标为「必填」，但未定义入参为空或取值不在枚举内时的行为，
 * 故本 BO 不做取值形态校验，也不为这类情形约定结果。</p>
 */
public class ST121InputBO {

    /** 交易类型（必填）：子步骤 1 查询【交易定义信息】的查询键，取值来源于代码[交易类型] */
    private TranType tranType;

    /** 账户限制类型（必填）：子步骤 2 查询【限制类型定义信息】的查询键，取值来源于代码[限制类型] */
    private RestraintType restraintType;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }
}
