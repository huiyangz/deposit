package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.Status;

/**
 * ST119 检查是否存在止付限制 —— 步骤输出。
 *
 * <p>业务输出为 6 个字段（顺序沿用源需求「## 输出」表）：</p>
 * <ul>
 *   <li>{@code stopFlag}（止付标志）：步骤结论，取中文字面值「是」＝存在止付限制、
 *       「否」＝不存在止付限制；三个已定义分支（子步骤 1 零条生效记录、有记录但无一条命中、
 *       存在命中记录）均有确定取值，不为空、不取「是」「否」之外的取值；</li>
 *   <li>{@code resSeqNo}、{@code restraintType}、{@code restraintsStatus}：命中记录
 *       （借贷方控制标志等于「D-禁止借方」的记录）在【账户限制信息】的取值，三者同取
 *       限制编号最小的一条命中记录；无记录或未命中时为空值；</li>
 *   <li>{@code drCrCtlFlag}、{@code status}：命中记录的限制类型在【限制类型表】中
 *       状态为「A-生效」的配置取值（命中时恒为「D-禁止借方」与「A-生效」）；
 *       该类型无「生效」配置时为空值。</li>
 * </ul>
 *
 * <p>源需求「## 输出」表的「标记」列 6 个字段均记「非必填」，按本项目对输出表的既有口径，
 * 该列记的是登记实体的可空性，不等同于本步骤可缺省任一输出字段。本步骤无业务失败场景
 * （源需求「## 失败处理」），检查结论不以错误码表达：各路径均以 {@code succeed=true} 返回，
 * 错误字段保持 null。</p>
 */
public class ST119OutputBO extends StepResult {

    /** 止付标志（非必填）："是"-存在止付限制，"否"-不存在止付限制 */
    private String stopFlag;

    /** 限制编号（非必填）：命中记录的限制编号，无记录或未命中时为空值 */
    private String resSeqNo;

    /** 账户限制类型（非必填）：命中记录的账户限制类型，无记录或未命中时为空值 */
    private RestraintType restraintType;

    /** 限制状态（非必填）：命中记录的限制状态，无记录或未命中时为空值 */
    private RestraintsStatus restraintsStatus;

    /** 借方贷方控制标志（非必填）：命中记录对应"生效"配置的借贷方控制标志，无生效配置时为空值 */
    private DrCrCtlFlag drCrCtlFlag;

    /** 状态（非必填）：命中记录对应配置的状态，无生效配置时为空值 */
    private Status status;

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }

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

    public DrCrCtlFlag getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(DrCrCtlFlag drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
