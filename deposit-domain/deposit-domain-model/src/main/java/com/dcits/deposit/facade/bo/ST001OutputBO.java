package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.LostType;
import com.dcits.deposit.enums.VoucherLostStatus;

/**
 * ST001 检查对手账户凭证状态 输出 BO。
 *
 * <p>继承 {@link StepResult}，正常完成时 succeed=true 且错误字段为 null，业务失败时
 * succeed=false 且 errorCode=ER0068。</p>
 *
 * <p>四个业务字段按凭证挂失登记簿字段契约声明（均为非必填），实际赋值与对外返回路径待业务
 * 确认，见 {@code ST001Pbc} 中 FIXME，当前成功与失败路径均不赋值。</p>
 */
public class ST001OutputBO extends StepResult {

    /** 凭证挂失状态 */
    private VoucherLostStatus voucherLostStatus;
    /** 挂失类型 */
    private LostType lostType;
    /** 挂失编号 */
    private String lostNo;
    /** 凭证号 */
    private String voucherNo;

    public VoucherLostStatus getVoucherLostStatus() {
        return voucherLostStatus;
    }

    public void setVoucherLostStatus(VoucherLostStatus voucherLostStatus) {
        this.voucherLostStatus = voucherLostStatus;
    }

    public LostType getLostType() {
        return lostType;
    }

    public void setLostType(LostType lostType) {
        this.lostType = lostType;
    }

    public String getLostNo() {
        return lostNo;
    }

    public void setLostNo(String lostNo) {
        this.lostNo = lostNo;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }
}
