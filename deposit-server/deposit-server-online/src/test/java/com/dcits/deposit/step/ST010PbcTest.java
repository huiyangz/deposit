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

import com.dcits.deposit.facade.bo.ST010InputBO;
import com.dcits.deposit.facade.bo.ST010OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST010 检查账户存在性 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST010-TC001 ~ ST010-TC002）
 */
@ExtendWith(MockitoExtension.class)
public class ST010PbcTest {

	@Mock
	private IRbBusAcctBcc rbBusAcctBcc;

	@InjectMocks
	private ST010Pbc st010Pbc;

	// TC001 正常路径-账户存在：按{账号}查询【账户信息】返回1条记录，检查结果“通过”，输出账号取自查询记录
	@Test
	public void testST010T01() {
		RbBusAcctEO acctEo = new RbBusAcctEO();
		acctEo.setBaseAcctNo("6202020000010001234");
		List<RbBusAcctEO> acctList = new ArrayList<>();
		acctList.add(acctEo);
		Mockito.lenient()
				.when(rbBusAcctBcc.findByEo(Mockito.argThat(
						eo -> eo != null && "6202020000010001234".equals(eo.getBaseAcctNo()))))
				.thenReturn(acctList);

		ST010InputBO input = new ST010InputBO();
		input.setBaseAcctNo("6202020000010001234");
		ST010OutputBO output = st010Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("6202020000010001234", output.getBaseAcctNo());
	}

	// TC002 错误码路径-账户不存在：按{账号}查询【账户信息】返回空列表，返回错误码 ER0048，输出账号为 null
	@Test
	public void testST010T02() {
		Mockito.lenient()
				.when(rbBusAcctBcc.findByEo(Mockito.argThat(
						eo -> eo != null && "6202020000090009999".equals(eo.getBaseAcctNo()))))
				.thenReturn(new ArrayList<>());

		ST010InputBO input = new ST010InputBO();
		input.setBaseAcctNo("6202020000090009999");
		ST010OutputBO output = st010Pbc.execute(input);

		assertFalse(output.isSucceed());
		assertEquals("ER0048", output.getErrorCode());
		assertTrue(output.getErrorMessage().startsWith("ER0048::"));
		assertNull(output.getBaseAcctNo());
	}
}
