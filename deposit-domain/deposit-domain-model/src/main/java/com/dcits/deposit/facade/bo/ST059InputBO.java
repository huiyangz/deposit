package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.RestraintLevel;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import java.util.List;

/**
 * ST059 检查账户是否存在不允许销户的限制 输入 BO。
 *
 * <p>以[账户限制信息]集合为输入，每条记录字段来源于对公存款账户限制表
 * （RB_BUS_RESTRAINTS）。步骤描述仅使用 restraintType 参与销户标志判定；
 * resSeqNo、restraintsStatus、restraintLevel 为需求声明的必填输入，需求未描述其在
 * 步骤内的用途（Spec TBD-5）。</p>
 *
 * <p>[账户限制信息]集合为空时，按 Spec REQ-004-S02 无记录可遍历，遍历直接结束并返回
 * 「允许销户」。</p>
 */
public class ST059InputBO {

    /** [账户限制信息]集合 */
    private List<RestraintInfo> restraintList;

    public List<RestraintInfo> getRestraintList() {
        return restraintList;
    }

    public void setRestraintList(List<RestraintInfo> restraintList) {
        this.restraintList = restraintList;
    }

    /**
     * [账户限制信息]集合元素，对应对公存款账户限制表（RB_BUS_RESTRAINTS）单条记录，
     * 字段为 Spec「输入」表确认的必填输入。
     */
    public static class RestraintInfo {

        /** 限制编号 */
        private String resSeqNo;
        /** 账户限制类型 */
        private RestraintType restraintType;
        /** 限制状态 */
        private RestraintsStatus restraintsStatus;
        /** 限制级别 */
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
