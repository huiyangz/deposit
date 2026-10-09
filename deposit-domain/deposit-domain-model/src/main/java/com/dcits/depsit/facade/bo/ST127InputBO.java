package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;

/**
 * ST127 检查限制类型 输入BO。
 *
 * <p>本步骤只有两个输入字段：{@code restraintType} 为步骤1 的查询键（对应步骤描述的
 * {限制类型}）；{@code status} 对应步骤描述的 $状态$，其判定取值取自步骤1 查询所得记录的同名
 * 字段，不作为独立于查询结果的第三个入参参与判定。</p>
 */
public class ST127InputBO {

    /** 账户限制类型（必填）：步骤1 查询【限制类型定义表】的查询键，对应步骤描述的 {限制类型} */
    private RestraintType restraintType;

    /** 状态（必填）：步骤3 的判定对象，取值取自步骤1 查询所得记录的「状态」字段 */
    private Status status;

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
