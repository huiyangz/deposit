package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.DocumentType;

/**
 * ST084 检查联系人：步骤输入。
 *
 * <p>字段取自正式 Spec「输入、输出及依赖契约（输入）」：documentId（证件号码，必填）、
 * 电话号码（必填，源需求以中文字段名给出，Spec 沿用字面名称，不另行命名）、
 * documentType（证件类型，必填，取值为 {@link DocumentType} 枚举成员）。</p>
 */
public class ST084InputBO {

    /** 证件号码；用于子步骤 4 的长度检查，需恰为 18 位 */
    private String documentId;

    /** 电话号码；用于子步骤 5 的长度检查，需恰为 11 位 */
    private String 电话号码;

    /** 证件类型；参与子步骤 2 的[证件类型列表]判定与子步骤 3 的居民身份证判定 */
    private DocumentType documentType;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String get电话号码() {
        return 电话号码;
    }

    public void set电话号码(String 电话号码) {
        this.电话号码 = 电话号码;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
