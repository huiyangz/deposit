package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CheckObjType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.LimitConvert;
import com.dcits.deposit.enums.LimitMainType;
import jakarta.validation.constraints.NotNull;

public class RbLimitSceneDefEO {
    /** 限额场景编码 */
    @NotNull
    private String limitSceneNo;
    /** 限额场景描述 */
    private String limitSceneDesc;
    /** 限额大类 */
    private LimitMainType limitMainType;
    /** 检查对象类型 */
    private CheckObjType checkObjType;
    /** 限额折算方式 */
    private LimitConvert limitConvert;
    /** 限制币种 */
    private AcctCcy limitCcy;
    /** 启用标志 */
    private String validFlag;
    /** 法人 */
    private Company company;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getLimitSceneDesc() {
        return limitSceneDesc;
    }

    public void setLimitSceneDesc(String limitSceneDesc) {
        this.limitSceneDesc = limitSceneDesc;
    }

    public LimitMainType getLimitMainType() {
        return limitMainType;
    }

    public void setLimitMainType(LimitMainType limitMainType) {
        this.limitMainType = limitMainType;
    }

    public CheckObjType getCheckObjType() {
        return checkObjType;
    }

    public void setCheckObjType(CheckObjType checkObjType) {
        this.checkObjType = checkObjType;
    }

    public LimitConvert getLimitConvert() {
        return limitConvert;
    }

    public void setLimitConvert(LimitConvert limitConvert) {
        this.limitConvert = limitConvert;
    }

    public AcctCcy getLimitCcy() {
        return limitCcy;
    }

    public void setLimitCcy(AcctCcy limitCcy) {
        this.limitCcy = limitCcy;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}