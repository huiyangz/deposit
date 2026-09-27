package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.facade.bo.ST042InputBO;
import com.dcits.deposit.facade.bo.ST042OutputBO;
import com.dcits.deposit.facade.components.IFmDocumentTypeBcc;
import com.dcits.deposit.facade.eo.FmDocumentTypeEO;

/**
 * ST042 检查联系人 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST042-TC001 ~ ST042-TC009）
 */
@ExtendWith(MockitoExtension.class)
public class ST042PbcTest {

	@Mock
	private IFmDocumentTypeBcc fmDocumentTypeBcc;

	@InjectMocks
	private ST042Pbc st042Pbc;

	// 标准桩列表（TC001–TC008 复用）：全量[证件类型列表]含居民身份证、户口簿、港澳居民居住证、中华人民共和国因私护照
	private void stubStandardDocumentTypeList() {
		List<FmDocumentTypeEO> documentTypeList = new ArrayList<>();
		documentTypeList.add(buildDocumentType(DocumentType.VALUE_110001, "居民身份证"));
		documentTypeList.add(buildDocumentType(DocumentType.VALUE_110005, "户口簿"));
		documentTypeList.add(buildDocumentType(DocumentType.VALUE_120000, "港澳居民居住证"));
		documentTypeList.add(buildDocumentType(DocumentType.VALUE_110023, "中华人民共和国因私护照"));
		Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
				.thenReturn(documentTypeList);
	}

	private FmDocumentTypeEO buildDocumentType(DocumentType documentType, String documentTypeDesc) {
		FmDocumentTypeEO eo = new FmDocumentTypeEO();
		eo.setDocumentType(documentType);
		eo.setDocumentTypeDesc(documentTypeDesc);
		return eo;
	}

	private ST042InputBO buildInput(DocumentType documentType, String documentId, String phoneNumber) {
		ST042InputBO input = new ST042InputBO();
		input.setDocumentType(documentType);
		input.setDocumentId(documentId);
		input.set电话号码(phoneNumber);
		return input;
	}

	// TC001 居民身份证全流程通过：证件类型在列表中、为居民身份证、证件号码18位、电话号码11位，返回检查结果"通过"
	@Test
	public void testST042T01() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_110001, "110101199001011234", "13812345678");
		ST042OutputBO output = st042Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC002 非居民身份证（户口簿）经子步骤3跳转至《检查电话号码长度》：证件号码7位不检查，电话号码11位，返回检查结果"通过"
	@Test
	public void testST042T02() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_110005, "1234567", "13812345678");
		ST042OutputBO output = st042Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("通过", output.getCheckResult());
	}

	// TC003 居民身份证证件号码长度17位（不足18位），子步骤4返回，错误码 ER0037
	@Test
	public void testST042T03() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_110001, "11010119900101123", "13812345678");
		ST042OutputBO output = st042Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0037", output.getErrorCode());
	}

	// TC004 居民身份证证件号码长度19位（超出18位），子步骤4返回，错误码 ER0037
	@Test
	public void testST042T04() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_110001, "1101011990010112345", "13812345678");
		ST042OutputBO output = st042Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0037", output.getErrorCode());
	}

	// TC005 居民身份证证件号码18位、电话号码10位（不足11位），子步骤5返回，错误码 ER0038
	@Test
	public void testST042T05() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_110001, "110101199001011234", "1381234567");
		ST042OutputBO output = st042Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0038", output.getErrorCode());
	}

	// TC006 居民身份证证件号码18位、电话号码12位（超出11位），子步骤5返回，错误码 ER0038
	@Test
	public void testST042T06() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_110001, "110101199001011234", "138123456789");
		ST042OutputBO output = st042Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0038", output.getErrorCode());
	}

	// TC007 非居民身份证（因私护照）跳转至《检查电话号码长度》后电话号码10位，子步骤5返回，错误码 ER0038
	@Test
	public void testST042T07() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_110023, "P1234567", "1381234567");
		ST042OutputBO output = st042Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0038", output.getErrorCode());
	}

	// TC008 证件类型（全国组织机构代码）不在[证件类型列表]中，子步骤2返回，错误码 ER0036
	@Test
	public void testST042T08() {
		stubStandardDocumentTypeList();
		ST042InputBO input = buildInput(DocumentType.VALUE_610001, "110101199001011234", "13812345678");
		ST042OutputBO output = st042Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0036", output.getErrorCode());
	}

	// TC009 查询【证件类型定义信息】返回空列表，任何证件类型均不在列表中，子步骤2返回，错误码 ER0036
	@Test
	public void testST042T09() {
		Mockito.lenient().when(fmDocumentTypeBcc.findByEo(Mockito.any(FmDocumentTypeEO.class)))
				.thenReturn(new ArrayList<>());
		ST042InputBO input = buildInput(DocumentType.VALUE_110001, "110101199001011234", "13812345678");
		ST042OutputBO output = st042Pbc.execute(input);
		assertFalse(output.isSucceed());
		assertEquals("ER0036", output.getErrorCode());
	}
}
