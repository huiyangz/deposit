package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcrossBranCheckFlag;
import com.dcits.deposit.enums.AllowReverseFlag;
import com.dcits.deposit.enums.BlacklistCheckFlag;
import com.dcits.deposit.enums.BusiCategory;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MultiCorpCheckFlag;
import jakarta.validation.constraints.NotNull;

public class FmServiceDefineEO {
    /** 服务代码 */
    @NotNull
    private String serviceCode;
    /** 接口服务类型 */
    @NotNull
    private String messageType;
    /** 接口服务代码 */
    @NotNull
    private String messageCode;
    /** 统一资源定位符 */
    private String url;
    /** 业务分类 */
    private BusiCategory busiCategory;
    /** 业务细类 */
    private String busiSubClass;
    /** 黑名单检查标志 */
    private BlacklistCheckFlag blacklistCheckFlag;
    /** 白名单检查标志 */
    private BlacklistCheckFlag whiteListCheckFlag;
    /** 多法人检查标志 */
    private MultiCorpCheckFlag multiCorpCheckFlag;
    /** 跨机构检查标志 */
    private AcrossBranCheckFlag acrossBranCheckFlag;
    /** 客户检查标志 */
    private IndividualFlag clientCheckFlag;
    /** 允许冲正标志 */
    private AllowReverseFlag allowReverseFlag;
    /** 服务状态 */
    private String serviceStatus;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BusiCategory getBusiCategory() {
        return busiCategory;
    }

    public void setBusiCategory(BusiCategory busiCategory) {
        this.busiCategory = busiCategory;
    }

    public String getBusiSubClass() {
        return busiSubClass;
    }

    public void setBusiSubClass(String busiSubClass) {
        this.busiSubClass = busiSubClass;
    }

    public BlacklistCheckFlag getBlacklistCheckFlag() {
        return blacklistCheckFlag;
    }

    public void setBlacklistCheckFlag(BlacklistCheckFlag blacklistCheckFlag) {
        this.blacklistCheckFlag = blacklistCheckFlag;
    }

    public BlacklistCheckFlag getWhiteListCheckFlag() {
        return whiteListCheckFlag;
    }

    public void setWhiteListCheckFlag(BlacklistCheckFlag whiteListCheckFlag) {
        this.whiteListCheckFlag = whiteListCheckFlag;
    }

    public MultiCorpCheckFlag getMultiCorpCheckFlag() {
        return multiCorpCheckFlag;
    }

    public void setMultiCorpCheckFlag(MultiCorpCheckFlag multiCorpCheckFlag) {
        this.multiCorpCheckFlag = multiCorpCheckFlag;
    }

    public AcrossBranCheckFlag getAcrossBranCheckFlag() {
        return acrossBranCheckFlag;
    }

    public void setAcrossBranCheckFlag(AcrossBranCheckFlag acrossBranCheckFlag) {
        this.acrossBranCheckFlag = acrossBranCheckFlag;
    }

    public IndividualFlag getClientCheckFlag() {
        return clientCheckFlag;
    }

    public void setClientCheckFlag(IndividualFlag clientCheckFlag) {
        this.clientCheckFlag = clientCheckFlag;
    }

    public AllowReverseFlag getAllowReverseFlag() {
        return allowReverseFlag;
    }

    public void setAllowReverseFlag(AllowReverseFlag allowReverseFlag) {
        this.allowReverseFlag = allowReverseFlag;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
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
}