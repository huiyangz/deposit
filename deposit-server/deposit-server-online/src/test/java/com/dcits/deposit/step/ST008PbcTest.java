package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.facade.bo.ST008InputBO;
import com.dcits.deposit.facade.bo.ST008OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;

/**
 * ST008 检查客户类型 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST008-TC001 ~ ST008-TC004）
 */
@ExtendWith(MockitoExtension.class)
public class ST008PbcTest {

	@Mock
	private IFmClientCopyBcc fmClientCopyBcc;

	@InjectMocks
	private ST008Pbc st008Pbc;

	private FmClientCopyEO buildClientCopy(String clientNo, ClientType clientType) {
		FmClientCopyEO eo = new FmClientCopyEO();
		eo.setClientNo(clientNo);
		eo.setClientType(clientType);
		return eo;
	}

	private ST008InputBO buildInput(String clientNo) {
		ST008InputBO input = new ST008InputBO();
		input.setClientNo(clientNo);
		return input;
	}

	// TC001 公司客户：查询客户信息返回客户类型"公司"（VALUE_200），子步骤2判定通过，检查结果"通过"
	@Test
	public void testST008T01() {
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C2000001"))
				.thenReturn(buildClientCopy("C2000001", ClientType.VALUE_200));
		ST008OutputBO output = st008Pbc.execute(buildInput("C2000001"));
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(ClientType.VALUE_200, output.getClientType());
	}

	// TC002 个人客户：查询返回客户类型"个人"（VALUE_100），不为"公司"，子步骤2返回错误码 ER0042
	@Test
	public void testST008T02() {
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C1000001"))
				.thenReturn(buildClientCopy("C1000001", ClientType.VALUE_100));
		ST008OutputBO output = st008Pbc.execute(buildInput("C1000001"));
		assertFalse(output.isSucceed());
		assertEquals("ER0042", output.getErrorCode());
		assertEquals(ClientType.VALUE_100, output.getClientType());
	}

	// TC003 金融机构客户：查询返回客户类型"金融机构"（VALUE_300），不为"公司"，子步骤2返回错误码 ER0042
	@Test
	public void testST008T03() {
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C3000001"))
				.thenReturn(buildClientCopy("C3000001", ClientType.VALUE_300));
		ST008OutputBO output = st008Pbc.execute(buildInput("C3000001"));
		assertFalse(output.isSucceed());
		assertEquals("ER0042", output.getErrorCode());
		assertEquals(ClientType.VALUE_300, output.getClientType());
	}

	// TC004 客户号无对应记录：findByPrimaryKey 返回 null，$客户类型$ 为 null，不为"公司"，子步骤2返回错误码 ER0042
	@Test
	public void testST008T04() {
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C4040001"))
				.thenReturn(null);
		ST008OutputBO output = st008Pbc.execute(buildInput("C4040001"));
		assertFalse(output.isSucceed());
		assertEquals("ER0042", output.getErrorCode());
		assertNull(output.getClientType());
	}
}
