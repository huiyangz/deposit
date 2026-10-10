package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.RestraintsStatus;

/**
 * ST131 检查账户限制编号是否存在 —— 步骤输入。
 *
 * <p>输入为「限制编号」与「限制状态」两个字段（来源实体：对公存款账户限制表
 * RB_BUS_RESTRAINTS），分别绑定步骤描述第 1 条中的 {@code {限制编号}} 与
 * {@code $限制状态$}，二者共同构成查询【限制信息】的过滤条件。</p>
 *
 * <p>本步骤只使用这两个字段，不因「来源实体」列已记载表名而增加其它取数或写入动作。</p>
 */
public class ST131InputBO {

    /** 限制编号（非必填，可为无值：null 或长度为 0 的空字符串）：查询【限制信息】的条件之一 */
    private String resSeqNo;

    /** 限制状态（必填）：查询【限制信息】的条件之一，取 {@link RestraintsStatus} 的码值 */
    private RestraintsStatus restraintsStatus;

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }
}
