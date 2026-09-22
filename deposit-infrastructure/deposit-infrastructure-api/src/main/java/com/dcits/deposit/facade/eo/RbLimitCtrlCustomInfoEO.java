package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CtrlItemType;
import com.dcits.deposit.enums.IndividualFlag;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbLimitCtrlCustomInfoEO {
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 限额场景编码 */
    @NotNull
    private String limitSceneNo;
    /** 限额检查对象值 */
    @NotNull
    private String checkObjVal;
    /** 控制项类型 */
    private CtrlItemType ctrlItemType;
    /** 限额控制笔数 */
    private Integer limitCtrlNum;
    /** 限额控制金额 */
    private BigDecimal limitCtrlAmt;
    /** 临时限额标志 */
    private IndividualFlag tempLimitFlag;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 失效日期 */
    private java.util.Date expireDate;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 更新日期 */
    private java.util.Date updateDate;
    /** 创建日期 */
    private java.util.Date createDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getCheckObjVal() {
        return checkObjVal;
    }

    public void setCheckObjVal(String checkObjVal) {
        this.checkObjVal = checkObjVal;
    }

    public CtrlItemType getCtrlItemType() {
        return ctrlItemType;
    }

    public void setCtrlItemType(CtrlItemType ctrlItemType) {
        this.ctrlItemType = ctrlItemType;
    }

    public Integer getLimitCtrlNum() {
        return limitCtrlNum;
    }

    public void setLimitCtrlNum(Integer limitCtrlNum) {
        this.limitCtrlNum = limitCtrlNum;
    }

    public BigDecimal getLimitCtrlAmt() {
        return limitCtrlAmt;
    }

    public void setLimitCtrlAmt(BigDecimal limitCtrlAmt) {
        this.limitCtrlAmt = limitCtrlAmt;
    }

    public IndividualFlag getTempLimitFlag() {
        return tempLimitFlag;
    }

    public void setTempLimitFlag(IndividualFlag tempLimitFlag) {
        this.tempLimitFlag = tempLimitFlag;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public java.util.Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(java.util.Date expireDate) {
        this.expireDate = expireDate;
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

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}