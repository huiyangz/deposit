package com.dcits.deposit.entity;

public class FmServiceDefine {
    /** 服务代码 */
    private String serviceCode;
    /** 接口服务类型 */
    private String messageType;
    /** 接口服务代码 */
    private String messageCode;
    /** 统一资源定位符 */
    private String url;
    /** 业务分类 */
    private String busiCategory;
    /** 业务细类 */
    private String busiSubClass;
    /** 黑名单检查标志 */
    private String blacklistCheckFlag;
    /** 白名单检查标志 */
    private String whiteListCheckFlag;
    /** 多法人检查标志 */
    private String multiCorpCheckFlag;
    /** 跨机构检查标志 */
    private String acrossBranCheckFlag;
    /** 客户检查标志 */
    private String clientCheckFlag;
    /** 允许冲正标志 */
    private String allowReverseFlag;
    /** 服务状态 */
    private String serviceStatus;
    /** 法人 */
    private String company;
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

    public String getBusiCategory() {
        return busiCategory;
    }

    public void setBusiCategory(String busiCategory) {
        this.busiCategory = busiCategory;
    }

    public String getBusiSubClass() {
        return busiSubClass;
    }

    public void setBusiSubClass(String busiSubClass) {
        this.busiSubClass = busiSubClass;
    }

    public String getBlacklistCheckFlag() {
        return blacklistCheckFlag;
    }

    public void setBlacklistCheckFlag(String blacklistCheckFlag) {
        this.blacklistCheckFlag = blacklistCheckFlag;
    }

    public String getWhiteListCheckFlag() {
        return whiteListCheckFlag;
    }

    public void setWhiteListCheckFlag(String whiteListCheckFlag) {
        this.whiteListCheckFlag = whiteListCheckFlag;
    }

    public String getMultiCorpCheckFlag() {
        return multiCorpCheckFlag;
    }

    public void setMultiCorpCheckFlag(String multiCorpCheckFlag) {
        this.multiCorpCheckFlag = multiCorpCheckFlag;
    }

    public String getAcrossBranCheckFlag() {
        return acrossBranCheckFlag;
    }

    public void setAcrossBranCheckFlag(String acrossBranCheckFlag) {
        this.acrossBranCheckFlag = acrossBranCheckFlag;
    }

    public String getClientCheckFlag() {
        return clientCheckFlag;
    }

    public void setClientCheckFlag(String clientCheckFlag) {
        this.clientCheckFlag = clientCheckFlag;
    }

    public String getAllowReverseFlag() {
        return allowReverseFlag;
    }

    public void setAllowReverseFlag(String allowReverseFlag) {
        this.allowReverseFlag = allowReverseFlag;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}