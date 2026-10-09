package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.depsit.enums.DocumentType;
import com.dcits.depsit.facade.bo.ST084InputBO;
import com.dcits.depsit.facade.bo.ST084OutputBO;
import com.dcits.depsit.facade.components.IFmDocumentTypeBcc;
import com.dcits.depsit.facade.eo.FmDocumentTypeEO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST084 检查联系人：步骤实现单元测试。
 *
 * <p>调用签名 {@code ST084OutputBO execute(ST084InputBO input)}；子步骤 1 的
 * {@code IFmDocumentTypeBcc.findByEo(FmDocumentTypeEO)} 以不带业务过滤条件的 EO 设桩返回
 * {@code List<FmDocumentTypeEO>} 作为[证件类型列表]。</p>
 *
 * <p>检查结果的承载字段源需求未定义（正式 Spec「验收范围与明确不覆盖的事项」第 1 项，
 * 不得假定承载字段），故成功路径以 {@code isSucceed()} 为 true 且错误码、错误信息为 null
 * 表达检查结果“通过”，失败路径以 {@code isSucceed()} 为 false 表达“不返回检查结果‘通过’”。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST084PbcTest {

    @Mock
    private IFmDocumentTypeBcc fmDocumentTypeBcc;

    @InjectMocks
    private ST084Pbc st084Pbc;

    // ST084-TC001：居民身份证全路径成功（子步骤1全量查询→2在列表中→3判为居民身份证→4证件号码18位→5电话号码11位），预期检查结果“通过”
    @Test
    void testST084T01() {
        Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
                .thenReturn(documentTypeList(DocumentType.VALUE_110001, DocumentType.VALUE_110023));

        ST084InputBO input = new ST084InputBO();
        input.setDocumentType(DocumentType.VALUE_110001);
        input.setDocumentId("110101199003077758");
        input.set电话号码("13800138000");

        ST084OutputBO output = st084Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST084-TC002：证件类型不在列表中——子步骤2 判定不通过，预期返回 ER0036 并终止，不返回检查结果“通过”
    @Test
    void testST084T02() {
        Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
                .thenReturn(documentTypeList(DocumentType.VALUE_110001, DocumentType.VALUE_110023));

        ST084InputBO input = new ST084InputBO();
        input.setDocumentType(DocumentType.Z00000);
        input.setDocumentId("110101199003077758");
        input.set电话号码("13800138000");

        ST084OutputBO output = st084Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0036", output.getErrorCode());
    }

    // ST084-TC003：非居民身份证跳转路径——子步骤3 跳转子步骤5 跳过子步骤4，预期电话号码11位返回“通过”，不返回 ER0037
    @Test
    void testST084T03() {
        Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
                .thenReturn(documentTypeList(DocumentType.VALUE_110023, DocumentType.VALUE_110001));

        ST084InputBO input = new ST084InputBO();
        input.setDocumentType(DocumentType.VALUE_110023);
        input.setDocumentId("12345");
        input.set电话号码("13800138000");

        ST084OutputBO output = st084Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNotEquals("ER0037", output.getErrorCode());
    }

    // ST084-TC004：居民身份证且证件号码长度不为 18 位——子步骤4 判定不通过，预期返回 ER0037 并终止，不执行子步骤5
    @Test
    void testST084T04() {
        Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
                .thenReturn(documentTypeList(DocumentType.VALUE_110001));

        ST084InputBO input = new ST084InputBO();
        input.setDocumentType(DocumentType.VALUE_110001);
        input.setDocumentId("11010119900307775");
        input.set电话号码("13800138000");

        ST084OutputBO output = st084Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0037", output.getErrorCode());
    }

    // ST084-TC005：居民身份证路径且电话号码长度不为 11 位——子步骤5 判定不通过，预期返回 ER0038，不返回“通过”
    @Test
    void testST084T05() {
        Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
                .thenReturn(documentTypeList(DocumentType.VALUE_110001));

        ST084InputBO input = new ST084InputBO();
        input.setDocumentType(DocumentType.VALUE_110001);
        input.setDocumentId("110101199003077758");
        input.set电话号码("1380013800");

        ST084OutputBO output = st084Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0038", output.getErrorCode());
    }

    // ST084-TC006：非居民身份证跳转路径且电话号码长度不为 11 位——子步骤5 判定不通过，预期返回 ER0038，不返回 ER0037
    @Test
    void testST084T06() {
        Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
                .thenReturn(documentTypeList(DocumentType.VALUE_110023));

        ST084InputBO input = new ST084InputBO();
        input.setDocumentType(DocumentType.VALUE_110023);
        input.setDocumentId("12345");
        input.set电话号码("13800138000X");

        ST084OutputBO output = st084Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0038", output.getErrorCode());
        assertNotEquals("ER0037", output.getErrorCode());
    }

    /** 构造子步骤1 桩返回的证件类型定义信息记录。 */
    private static List<FmDocumentTypeEO> documentTypeList(DocumentType... documentTypes) {
        List<FmDocumentTypeEO> documentTypeRecords = new ArrayList<>();
        for (DocumentType documentType : documentTypes) {
            FmDocumentTypeEO documentTypeRecord = new FmDocumentTypeEO();
            documentTypeRecord.setDocumentType(documentType);
            documentTypeRecords.add(documentTypeRecord);
        }
        return documentTypeRecords;
    }
}
