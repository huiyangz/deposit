package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.ControlClass;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.TranType;
import jakarta.validation.constraints.NotNull;

public class RbControlTranRelationEO {
    /** 渠道控制分类 */
    @NotNull
    private ControlClass controlClass;
    /** 交易类型 */
    @NotNull
    private TranType tranType;
    /** 服务唯一识别号 */
    @NotNull
    private String serviceNo;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 生效标志 */
    private IndividualFlag effectFlag;

    public ControlClass getControlClass() {
        return controlClass;
    }

    public void setControlClass(ControlClass controlClass) {
        this.controlClass = controlClass;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public IndividualFlag getEffectFlag() {
        return effectFlag;
    }

    public void setEffectFlag(IndividualFlag effectFlag) {
        this.effectFlag = effectFlag;
    }
}