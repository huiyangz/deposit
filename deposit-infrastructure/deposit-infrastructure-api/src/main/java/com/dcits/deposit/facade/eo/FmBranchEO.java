package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.BranchType;
import com.dcits.deposit.enums.City;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.ProfitCenter;
import jakarta.validation.constraints.NotNull;

public class FmBranchEO {
    /** 归属机构号 */
    @NotNull
    private AcctBranch branch;
    /** 机构名称 */
    private String branchName;
    /** 机构简称 */
    private String branchShort;
    /** 机构类型 */
    private BranchType branchType;
    /** 法人 */
    private Company company;
    /** 机构对应内部客户号 */
    private String internalClient;
    /** 机构层级代码 */
    private HierarchyCode hierarchyCode;
    /** 归属上级机构号 */
    private AcctBranch attachedTo;
    /** 机构号 */
    private AcctBranch subBranchCode;
    /** 自贸区机构标志 */
    private IndividualFlag ftaFlag;
    /** 自贸区代码 */
    private String ftaCode;
    /** 利润中心 */
    private ProfitCenter profitCenter;
    /** 机构IP地址信息 */
    private String ipAddr;
    /** 国家 */
    private IssCountry country;
    /** 省代码 */
    private OthBranchRegionalismCode state;
    /** 城市 */
    private City city;
    /** 邮政编码 */
    private String postalCode;
    /** 区号 */
    private OthBranchRegionalismCode district;
    /** 地区码 */
    private String areaCode;
    /** 外汇金融机构代码 */
    private String fxOrganCode;
    /** 创建日期 */
    private java.util.Date createDate;
    /** 开始日期 */
    private java.util.Date startDate;
    /** 结束日期 */
    private java.util.Date endDate;
    /** 日终标识 */
    private String eodFlag;
    /** 市区支行标志 */
    private IndividualFlag cityBranchFlag;
    /** 人行金融机构编码 */
    private String pbocFinancingNo;
    /** 交易时间戳 */
    private String tranTimestamp;

    public AcctBranch getBranch() {
        return branch;
    }

    public void setBranch(AcctBranch branch) {
        this.branch = branch;
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

    public BranchType getBranchType() {
        return branchType;
    }

    public void setBranchType(BranchType branchType) {
        this.branchType = branchType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getInternalClient() {
        return internalClient;
    }

    public void setInternalClient(String internalClient) {
        this.internalClient = internalClient;
    }

    public HierarchyCode getHierarchyCode() {
        return hierarchyCode;
    }

    public void setHierarchyCode(HierarchyCode hierarchyCode) {
        this.hierarchyCode = hierarchyCode;
    }

    public AcctBranch getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(AcctBranch attachedTo) {
        this.attachedTo = attachedTo;
    }

    public AcctBranch getSubBranchCode() {
        return subBranchCode;
    }

    public void setSubBranchCode(AcctBranch subBranchCode) {
        this.subBranchCode = subBranchCode;
    }

    public IndividualFlag getFtaFlag() {
        return ftaFlag;
    }

    public void setFtaFlag(IndividualFlag ftaFlag) {
        this.ftaFlag = ftaFlag;
    }

    public String getFtaCode() {
        return ftaCode;
    }

    public void setFtaCode(String ftaCode) {
        this.ftaCode = ftaCode;
    }

    public ProfitCenter getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(ProfitCenter profitCenter) {
        this.profitCenter = profitCenter;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public IssCountry getCountry() {
        return country;
    }

    public void setCountry(IssCountry country) {
        this.country = country;
    }

    public OthBranchRegionalismCode getState() {
        return state;
    }

    public void setState(OthBranchRegionalismCode state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public OthBranchRegionalismCode getDistrict() {
        return district;
    }

    public void setDistrict(OthBranchRegionalismCode district) {
        this.district = district;
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

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }

    public String getEodFlag() {
        return eodFlag;
    }

    public void setEodFlag(String eodFlag) {
        this.eodFlag = eodFlag;
    }

    public IndividualFlag getCityBranchFlag() {
        return cityBranchFlag;
    }

    public void setCityBranchFlag(IndividualFlag cityBranchFlag) {
        this.cityBranchFlag = cityBranchFlag;
    }

    public String getPbocFinancingNo() {
        return pbocFinancingNo;
    }

    public void setPbocFinancingNo(String pbocFinancingNo) {
        this.pbocFinancingNo = pbocFinancingNo;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}