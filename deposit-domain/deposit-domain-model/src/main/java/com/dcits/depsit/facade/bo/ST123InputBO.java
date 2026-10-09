package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.RestraintLevel;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import java.util.List;

/**
 * ST123 检查账户是否存在不允许销户的限制 —— 步骤输入。
 *
 * <p>输入为本次执行提供的 [账户限制信息]，即对公存款账户限制表（RB_BUS_RESTRAINTS）
 * 的限制记录集合（条数由调用方决定，可为空集）。步骤逐条遍历该集合，
 * 以每条记录自身的账户限制类型（{@code $账户限制类型$}）为查询键查询【限制类型信息】，
 * 取得其销户标志（{@code $销户标志$}）后判定 [允许销户标志]。</p>
 *
 * <p>本步骤引用的记录字段为 resSeqNo（限制编号）、restraintType（账户限制类型）、
 * restraintsStatus（限制状态）、restraintLevel（限制级别）四个；其中只有 restraintType
 * 参与遍历中的查询与判定，其余三个字段不参与过滤或判定。</p>
 */
public class ST123InputBO {

    /** [账户限制信息]：本次执行提供的账户限制记录集合，条数由调用方决定，可为空集 */
    private List<RestraintRecord> accountRestraintInfoList;

    public List<RestraintRecord> getAccountRestraintInfoList() {
        return accountRestraintInfoList;
    }

    public void setAccountRestraintInfoList(List<RestraintRecord> accountRestraintInfoList) {
        this.accountRestraintInfoList = accountRestraintInfoList;
    }

    /**
     * [账户限制信息] 中的一条限制记录，承载本步骤引用的四个字段
     * （来源实体：对公存款账户限制表 RB_BUS_RESTRAINTS）。
     */
    public static class RestraintRecord {

        /** 限制编号（必填） */
        private String resSeqNo;

        /** 账户限制类型（必填）：本步骤查询【限制类型信息】的查询键（{@code $账户限制类型$}） */
        private RestraintType restraintType;

        /** 限制状态（必填）：源需求正文未将其用作遍历过滤或判定条件 */
        private RestraintsStatus restraintsStatus;

        /** 限制级别（必填）：源需求正文未将其用作遍历过滤或判定条件 */
        private RestraintLevel restraintLevel;

        public String getResSeqNo() {
            return resSeqNo;
        }

        public void setResSeqNo(String resSeqNo) {
            this.resSeqNo = resSeqNo;
        }

        public RestraintType getRestraintType() {
            return restraintType;
        }

        public void setRestraintType(RestraintType restraintType) {
            this.restraintType = restraintType;
        }

        public RestraintsStatus getRestraintsStatus() {
            return restraintsStatus;
        }

        public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
            this.restraintsStatus = restraintsStatus;
        }

        public RestraintLevel getRestraintLevel() {
            return restraintLevel;
        }

        public void setRestraintLevel(RestraintLevel restraintLevel) {
            this.restraintLevel = restraintLevel;
        }
    }
}
