package com.dcits.depsit.step;

import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.facade.bo.ST084InputBO;
import com.dcits.depsit.facade.bo.ST084OutputBO;
import com.dcits.depsit.facade.components.IFmDocumentTypeBcc;
import com.dcits.depsit.facade.eo.FmDocumentTypeEO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST084 检查联系人：步骤实现。
 *
 * <p>依次完成子步骤 1 查询【证件类型定义信息】获取全量[证件类型列表]、子步骤 2 证件类型合法性检查、
 * 子步骤 3 是否“居民身份证”的判定、子步骤 4 证件号码长度检查、子步骤 5 电话号码长度检查；
 * 失败即终止本步骤，不再执行后续子步骤。检查结果“通过”以 succeed=true 且错误字段为 null 表达，
 * 检查结果的字段契约源需求未定义，本类不臆造承载字段。</p>
 */
@Service
public class ST084Pbc implements IST084 {

    /** 错误码：证件类型不存在。 */
    private static final String ERROR_CODE_DOCUMENT_TYPE_NOT_EXIST = "ER0036";

    /** 错误码：身份证号码长度不为18位。 */
    private static final String ERROR_CODE_DOCUMENT_ID_LENGTH_INVALID = "ER0037";

    /** 错误码：电话号码长度不为11位。 */
    private static final String ERROR_CODE_PHONE_LENGTH_INVALID = "ER0038";

    /** 证件号码长度要求：18 位。 */
    private static final int DOCUMENT_ID_LENGTH = 18;

    /** 电话号码长度要求：11 位。 */
    private static final int PHONE_LENGTH = 11;

    /** 证件类型定义信息数据服务。 */
    @Autowired
    private IFmDocumentTypeBcc fmDocumentTypeBcc;

    @Override
    public ST084OutputBO execute(ST084InputBO input) {
        ST084OutputBO output = new ST084OutputBO();

        // 子步骤1 获取证件类型列表：查询【证件类型定义信息】获取全量[证件类型列表]
        List<DocumentType> documentTypeList = listDocumentType();

        // 子步骤2 证件类型合法性检查：{证件类型} 不在[证件类型列表]中则返回 ER0036 并终止本步骤
        if (!documentTypeList.contains(input.getDocumentType())) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_DOCUMENT_TYPE_NOT_EXIST);
            output.setErrorMessage(ERROR_CODE_DOCUMENT_TYPE_NOT_EXIST + "::证件类型不存在");
            return output;
        }

        // 子步骤3 “居民身份证”判定：是居民身份证则继续子步骤4，否则跳转子步骤5
        if (DocumentType.VALUE_110001.equals(input.getDocumentType())) {
            // 子步骤4 证件号码长度检查：不为 18 位则返回 ER0037 并终止本步骤，不执行子步骤5
            if (input.getDocumentId().length() != DOCUMENT_ID_LENGTH) {
                output.setSucceed(false);
                output.setErrorCode(ERROR_CODE_DOCUMENT_ID_LENGTH_INVALID);
                output.setErrorMessage(
                        ERROR_CODE_DOCUMENT_ID_LENGTH_INVALID + "::身份证号码长度不为18位");
                return output;
            }
        }

        // 子步骤5 电话号码长度检查：不为 11 位则返回 ER0038，否则返回检查结果“通过”
        if (input.get电话号码().length() != PHONE_LENGTH) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_PHONE_LENGTH_INVALID);
            output.setErrorMessage(ERROR_CODE_PHONE_LENGTH_INVALID + "::电话号码长度不为11位");
            return output;
        }

        output.setSucceed(true);
        return output;
    }

    /**
     * 子步骤1：以不带业务过滤条件的 {@link FmDocumentTypeEO} 查询【证件类型定义信息】
     * （实体表 FM_DOCUMENT_TYPE），取全部记录的证件类型构成[证件类型列表]。
     *
     * @return [证件类型列表]，元素取值域为 {@link DocumentType}
     */
    private List<DocumentType> listDocumentType() {
        List<FmDocumentTypeEO> documentTypeRecords = fmDocumentTypeBcc.findByEo(new FmDocumentTypeEO());
        List<DocumentType> documentTypeList = new ArrayList<>();
        for (FmDocumentTypeEO documentTypeRecord : documentTypeRecords) {
            documentTypeList.add(documentTypeRecord.getDocumentType());
        }
        return documentTypeList;
    }
}
