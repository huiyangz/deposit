package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import jakarta.validation.constraints.NotNull;

public class FmStructureParamEO {
    /** 结构类型 */
    @NotNull
    private String structureType;
    /** 参数类型 */
    @NotNull
    private String paramType;
    /** 长度 */
    private String length;
    /** 起始位置 */
    @NotNull
    private String startPos;
    /** 结束位置 */
    private String endPos;
    /** 填充字符 */
    private String paddingChar;
    /** 序列类型代码 */
    private String seqType;
    /** 字符串值 */
    private String stringValue;
    /** 起始索引 */
    private Integer startIndex;
    /** 终止索引 */
    private Integer endIndex;
    /** 法人 */
    private Company company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getStartPos() {
        return startPos;
    }

    public void setStartPos(String startPos) {
        this.startPos = startPos;
    }

    public String getEndPos() {
        return endPos;
    }

    public void setEndPos(String endPos) {
        this.endPos = endPos;
    }

    public String getPaddingChar() {
        return paddingChar;
    }

    public void setPaddingChar(String paddingChar) {
        this.paddingChar = paddingChar;
    }

    public String getSeqType() {
        return seqType;
    }

    public void setSeqType(String seqType) {
        this.seqType = seqType;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
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