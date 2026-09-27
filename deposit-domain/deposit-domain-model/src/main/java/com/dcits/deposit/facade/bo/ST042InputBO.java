package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.DocumentType;

/** ST042 检查联系人 输入BO */
public class ST042InputBO {
	/** 证件号码 */
	private String documentId;
	/** 电话号码 */
	private String 电话号码;
	/** 证件类型 */
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
