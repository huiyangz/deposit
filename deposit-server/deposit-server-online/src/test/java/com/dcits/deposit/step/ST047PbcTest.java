package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;
import com.dcits.deposit.facade.components.IRbClientRestraintsBcc;
import com.dcits.deposit.facade.eo.RbClientRestraintsEO;

/** ST047 检查客户是否存在限制 步骤实现单元测试 */
@ExtendWith(MockitoExtension.class)
class ST047PbcTest {

	@Mock
	private IRbClientRestraintsBcc bcc;

	@InjectMocks
	private ST047Pbc st047Pbc;

	@Captor
	private ArgumentCaptor<RbClientRestraintsEO> eoCaptor;

	// ST047-TC001（REQ-001-S01）：客户限制表存在 clientNo="C001234"、限制状态 A 的记录（resSeqNo="RS000001"、restraintType=VALUE_70），以该客户号执行步骤，核对查询请求按客户号+限制状态=A 构造并发起只读查询、取回该限制信息并赋值输出，以成功状态结束
	@Test
	void testST047T01() {
		RbClientRestraintsEO record = new RbClientRestraintsEO();
		record.setResSeqNo("RS000001");
		record.setRestraintType(RestraintType.VALUE_70);
		record.setRestraintsStatus(RestraintsStatus.A);
		// 参数捕获移入桩配置：以捕获器作为查询 EO 的匹配条件，执行时填充断言所需的查询请求值（不使用 verify 等交互验证）
		Mockito.lenient().when(bcc.findByEo(eoCaptor.capture()))
				.thenReturn(Collections.singletonList(record));

		ST047InputBO input = new ST047InputBO();
		input.setClientNo("C001234");

		ST047OutputBO output = st047Pbc.execute(input);

		// 捕获查询请求 EO，核对查询按客户号 + 限制状态 A 构造

		assertNotNull(eoCaptor.getValue());
		assertEquals("C001234", eoCaptor.getValue().getClientNo());
		assertEquals(RestraintsStatus.A, eoCaptor.getValue().getRestraintsStatus());
		assertEquals("RS000001", output.getResSeqNo());
		assertEquals(RestraintType.VALUE_70, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}

	// ST047-TC002（REQ-002-S01）：步骤 1 已获取客户限制信息（resSeqNo="RS000001"、restraintType=VALUE_70、restraintsStatus=A），本步骤将其赋值到业务输出并返回，以成功状态结束、错误字段为 null
	@Test
	void testST047T02() {
		RbClientRestraintsEO record = new RbClientRestraintsEO();
		record.setResSeqNo("RS000001");
		record.setRestraintType(RestraintType.VALUE_70);
		record.setRestraintsStatus(RestraintsStatus.A);
		Mockito.lenient().when(bcc.findByEo(any(RbClientRestraintsEO.class)))
				.thenReturn(Collections.singletonList(record));

		ST047InputBO input = new ST047InputBO();
		input.setClientNo("C001234");

		ST047OutputBO output = st047Pbc.execute(input);

		assertEquals("RS000001", output.getResSeqNo());
		assertEquals(RestraintType.VALUE_70, output.getRestraintType());
		assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
	}
}
