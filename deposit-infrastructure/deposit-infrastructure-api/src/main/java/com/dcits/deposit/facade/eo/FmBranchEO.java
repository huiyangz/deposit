package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.TranBranch;
import jakarta.validation.constraints.NotNull;

public class FmBranchEO {
    /** 归属机构号 */
    @NotNull
    private TranBranch branch;
    /** 地区码 */
    private String areaCode;
    /** 外汇金融机构代码 */
    private String fxOrganCode;
    /** 日终标识 */
    private String eodFlag;
    /** 自贸区机构标志 */
    private String ftaFlag;
    /** 城市 */
    private City city;
    /** 机构类型 */
    @NotNull
    private BranchType branchType;
    /** 自贸区代码 */
    private String ftaCode;
    /** 开始日期 */
    @NotNull
    private java.util.Date startDate;
    /** 机构名称 */
    @NotNull
    private String branchName;
    /** 机构IP地址信息 */
    private String ipAddr;
    /** 人行金融机构编码 */
    private String pbocFinancingNo;
    /** 区号 */
    private State district;
    /** 创建日期 */
    private java.util.Date createDate;
    /** 市区支行标志 */
    @NotNull
    private String cityBranchFlag;
    /** 机构层级代码 */
    private HierarchyCode hierarchyCode;
    /** 机构简称 */
    @NotNull
    private String branchShort;
    /** 邮政编码 */
    private String postalCode;
    /** 法人 */
    private String company;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 省代码 */
    @NotNull
    private State state;
    /** 归属上级机构号 */
    private TranBranch attachedTo;
    /** 国家 */
    @NotNull
    private IssCountry country;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 机构号 */
    private TranBranch subBranchCode;
    /** 交易时间戳 */
    @NotNull
    private String tranTimestamp;
    /** 机构对应内部客户号 */
    private String internalClient;

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getFxOrganCode() {
        return fxOrganCode;
    }

    public void setFxOrganCode(String fxOrganCode) {
        this.fxOrganCode = fxOrganCode;
    }

    public String getEodFlag() {
        return eodFlag;
    }

    public void setEodFlag(String eodFlag) {
        this.eodFlag = eodFlag;
    }

    public String getFtaFlag() {
        return ftaFlag;
    }

    public void setFtaFlag(String ftaFlag) {
        this.ftaFlag = ftaFlag;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public BranchType getBranchType() {
        return branchType;
    }

    public void setBranchType(BranchType branchType) {
        this.branchType = branchType;
    }

    public String getFtaCode() {
        return ftaCode;
    }

    public void setFtaCode(String ftaCode) {
        this.ftaCode = ftaCode;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getPbocFinancingNo() {
        return pbocFinancingNo;
    }

    public void setPbocFinancingNo(String pbocFinancingNo) {
        this.pbocFinancingNo = pbocFinancingNo;
    }

    public State getDistrict() {
        return district;
    }

    public void setDistrict(State district) {
        this.district = district;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public String getCityBranchFlag() {
        return cityBranchFlag;
    }

    public void setCityBranchFlag(String cityBranchFlag) {
        this.cityBranchFlag = cityBranchFlag;
    }

    public HierarchyCode getHierarchyCode() {
        return hierarchyCode;
    }

    public void setHierarchyCode(HierarchyCode hierarchyCode) {
        this.hierarchyCode = hierarchyCode;
    }

    public String getBranchShort() {
        return branchShort;
    }

    public void setBranchShort(String branchShort) {
        this.branchShort = branchShort;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public TranBranch getSubBranchCode() {
        return subBranchCode;
    }

    public void setSubBranchCode(TranBranch subBranchCode) {
        this.subBranchCode = subBranchCode;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getInternalClient() {
        return internalClient;
    }

    public void setInternalClient(String internalClient) {
        this.internalClient = internalClient;
    }
}