package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.EventDefault;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;

public class MbProdDefineEO {
    /** 地区码 */
    private String areaCode;
    /** 人行金融机构编码 */
    private String pbocFinancingNo;
    /** 基础事件 */
    private EventDefault eventDefault;
    /** 创建日期 */
    private java.util.Date createDate;
    /** 邮政编码 */
    private String postalCode;
    /** 归属机构号 */
    @NotNull
    private TranBranch branch;
    /** 省代码 */
    @NotNull
    private State state;
    /** 机构号 */
    private TranBranch subBranchCode;
    /** 机构IP地址信息 */
    private String ipAddr;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 组件ID */
    @NotNull
    private String assembleId;
    /** 城市 */
    private City city;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 机构名称 */
    @NotNull
    private String branchName;
    /** 机构简称 */
    @NotNull
    private String branchShort;
    /** 参数KEY值 */
    private String attrKey;
    /** 日终标识 */
    private String eodFlag;
    /** 属性值 */
    private String attrValue;
    /** 序号 */
    @NotNull
    private String seqNo;
    /** 机构层级代码 */
    private HierarchyCode hierarchyCode;
    /** 自贸区编号 */
    private String ftaNo;
    /** 自贸区机构标志 */
    private String ftaFlag;
    /** 市区支行标志 */
    @NotNull
    private String cityBranchFlag;
    /** 归属上级机构号 */
    private TranBranch attachedTo;
    /** 国家 */
    @NotNull
    private IssCountry country;
    /** 产品编号 */
    @NotNull
    private String prodNo;
    /** 区号 */
    private State district;
    /** 外汇金融机构代码 */
    private String fxOrganCode;
    /** 开始日期 */
    @NotNull
    private java.util.Date startDate;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 组件类型 */
    @NotNull
    private String assembleType;
    /** 机构对应内部客户号 */
    private String internalClient;
    /** 机构类型 */
    @NotNull
    private BranchType branchType;
    /** 状态 */
    @NotNull
    private Status status;
    /** 结束日期 */
    private java.util.Date endDate;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPbocFinancingNo() {
        return pbocFinancingNo;
    }

    public void setPbocFinancingNo(String pbocFinancingNo) {
        this.pbocFinancingNo = pbocFinancingNo;
    }

    public EventDefault getEventDefault() {
        return eventDefault;
    }

    public void setEventDefault(EventDefault eventDefault) {
        this.eventDefault = eventDefault;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public TranBranch getSubBranchCode() {
        return subBranchCode;
    }

    public void setSubBranchCode(TranBranch subBranchCode) {
        this.subBranchCode = subBranchCode;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getAssembleId() {
        return assembleId;
    }

    public void setAssembleId(String assembleId) {
        this.assembleId = assembleId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchShort() {
        return branchShort;
    }

    public void setBranchShort(String branchShort) {
        this.branchShort = branchShort;
    }

    public String getAttrKey() {
        return attrKey;
    }

    public void setAttrKey(String attrKey) {
        this.attrKey = attrKey;
    }

    public String getEodFlag() {
        return eodFlag;
    }

    public void setEodFlag(String eodFlag) {
        this.eodFlag = eodFlag;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public HierarchyCode getHierarchyCode() {
        return hierarchyCode;
    }

    public void setHierarchyCode(HierarchyCode hierarchyCode) {
        this.hierarchyCode = hierarchyCode;
    }

    public String getFtaNo() {
        return ftaNo;
    }

    public void setFtaNo(String ftaNo) {
        this.ftaNo = ftaNo;
    }

    public String getFtaFlag() {
        return ftaFlag;
    }

    public void setFtaFlag(String ftaFlag) {
        this.ftaFlag = ftaFlag;
    }

    public String getCityBranchFlag() {
        return cityBranchFlag;
    }

    public void setCityBranchFlag(String cityBranchFlag) {
        this.cityBranchFlag = cityBranchFlag;
    }

    public TranBranch getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(TranBranch attachedTo) {
        this.attachedTo = attachedTo;
    }

    public IssCountry getCountry() {
        return country;
    }

    public void setCountry(IssCountry country) {
        this.country = country;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public State getDistrict() {
        return district;
    }

    public void setDistrict(State district) {
        this.district = district;
    }

    public String getFxOrganCode() {
        return fxOrganCode;
    }

    public void setFxOrganCode(String fxOrganCode) {
        this.fxOrganCode = fxOrganCode;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getAssembleType() {
        return assembleType;
    }

    public void setAssembleType(String assembleType) {
        this.assembleType = assembleType;
    }

    public String getInternalClient() {
        return internalClient;
    }

    public void setInternalClient(String internalClient) {
        this.internalClient = internalClient;
    }

    public BranchType getBranchType() {
        return branchType;
    }

    public void setBranchType(BranchType branchType) {
        this.branchType = branchType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }
}