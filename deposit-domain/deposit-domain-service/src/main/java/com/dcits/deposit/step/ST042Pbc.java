package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;
import com.dcits.deposit.facade.components.IFmDocumentTypeBcc;
import com.dcits.deposit.facade.eo.FmDocumentTypeEO;

/**
 * ST042 检查联系人
 */
@Service
public class ST042Pbc implements IST042 {

	/** 居民身份证证件号码长度 */
	private static final int ID_DOCUMENT_LENGTH = 18;
	/** 电话号码长度 */
	private static final int PHONE_NUMBER_LENGTH = 11;
	/** 检查通过结果 */
	private static final String CHECK_RESULT_PASS = "通过";

	private final IFmDocumentTypeBcc fmDocumentTypeBcc;

	public ST042Pbc(IFmDocumentTypeBcc fmDocumentTypeBcc) {
		this.fmDocumentTypeBcc = fmDocumentTypeBcc;
	}

	@Override
	public ST042OutputBO execute(ST042InputBO input) {
		ST042OutputBO output = new ST042OutputBO();

		// 子步骤1 获取证件类型列表：查询【证件类型定义信息】获取全量[证件类型列表]
		List<FmDocumentTypeEO> documentTypeList = fmDocumentTypeBcc.findByEo(new FmDocumentTypeEO());

		// 子步骤2 检查证件类型：{证件类型}在[证件类型列表]中则继续执行，否则返回错误码 ER0036
		if (!containsDocumentType(documentTypeList, input.getDocumentType())) {
			output.setErrorCode("ER0036");
			output.setErrorMessage("ER0036::证件类型不在证件类型列表中");
			return output;
		}

		// 子步骤3 确定是否为居民身份证：是则继续执行子步骤4，否则跳转至子步骤《检查电话号码长度》
		if (DocumentType.VALUE_110001 == input.getDocumentType()) {
			// 子步骤4 检查证件号码长度：{证件号码}长度为18位则继续执行，否则返回错误码 ER0037
			if (input.getDocumentId().length() != ID_DOCUMENT_LENGTH) {
				output.setErrorCode("ER0037");
				output.setErrorMessage("ER0037::证件号码长度非18位");
				return output;
			}
		}

		// 子步骤5 检查电话号码长度：{电话号码}长度为11位则返回检查结果"通过"，否则返回错误码 ER0038
		if (input.get电话号码().length() != PHONE_NUMBER_LENGTH) {
			output.setErrorCode("ER0038");
			output.setErrorMessage("ER0038::电话号码长度非11位");
			return output;
		}
		output.setCheckResult(CHECK_RESULT_PASS);
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤2 判定{证件类型}是否存在于[证件类型列表]中
	 */
	private boolean containsDocumentType(List<FmDocumentTypeEO> documentTypeList, DocumentType documentType) {
		for (FmDocumentTypeEO eo : documentTypeList) {
			if (eo.getDocumentType() == documentType) {
				return true;
			}
		}
		return false;
	}
}
