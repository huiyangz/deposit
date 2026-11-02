package com.dcits.deposit.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.common.task.RespHeader;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.facade.bo.ST047InputBO;
import com.dcits.deposit.facade.bo.ST047OutputBO;
import com.dcits.deposit.step.IST047;
import com.dcits.deposit.task.dto.T5S1InputDTO;
import com.dcits.deposit.task.dto.T5S1OutputDTO;
import com.dcits.deposit.task.scenario.T5S1;

/** T5S1 检查客户限制 交易接口场景单元测试 */
@ExtendWith(MockitoExtension.class)
class T5S1Test {

	@Mock
	private IST047 ist047;

	@InjectMocks
	private T5S1 t5S1;

	@Captor
	private ArgumentCaptor<ST047InputBO> inputCaptor;

	// T5S1-TC001（REQ-001-S01、REQ-002-S01、REQ-003-S01）：正常路径全成功，以输入 clientNo 调用 ST047 一次，ST047 成功返回客户限制信息（resSeqNo="RS000001"、restraintType=VALUE_70 代码值 "70"、restraintsStatus=A 代码值 "A"），resSeqNo 原样映射、restraintType/restraintsStatus 按代码值映射为 String；复用响应头带旧错误时成功路径清理错误字段并置成功
	@Test
	void testT5S1T01() {
		ST047OutputBO st047Output = new ST047OutputBO();
		st047Output.setSucceed(true);
		st047Output.setResSeqNo("RS000001");
		st047Output.setRestraintType(RestraintType.VALUE_70);
		st047Output.setRestraintsStatus(RestraintsStatus.A);
		// 以捕获器作为入参匹配条件，执行后核对收到的 ST047InputBO 业务字段
		Mockito.lenient().when(ist047.execute(inputCaptor.capture())).thenReturn(st047Output);

		// 复用带旧失败状态的响应头，验证全成功时错误字段被清理
		RespHeader header = new RespHeader();
		header.setSucceed(false);
		header.setErrorCode("OLD_ERROR");
		header.setErrorMessage("旧错误");
		T5S1InputDTO input = new T5S1InputDTO();
		input.setClientNo("C001234");

		T5S1OutputDTO output = t5S1.execute(header, input);

		assertEquals("C001234", inputCaptor.getValue().getClientNo());
		assertEquals("RS000001", output.getResSeqNo());
		assertEquals("70", output.getRestraintType());
		assertEquals("A", output.getRestraintsStatus());
		assertTrue(header.isSucceed());
		assertNull(header.getErrorCode());
		assertNull(header.getErrorMessage());
	}

	// T5S1-TC002（REQ-003）：正常路径（代码值映射数据点），ST047 成功返回另一组真实业务值（resSeqNo="RS000999"、restraintType=VALUE_13 代码值 "13"、restraintsStatus=A），验证 restraintType 经 RestraintType.getValue() 按代码值映射而非固化常量名
	@Test
	void testT5S1T02() {
		ST047OutputBO st047Output = new ST047OutputBO();
		st047Output.setSucceed(true);
		st047Output.setResSeqNo("RS000999");
		st047Output.setRestraintType(RestraintType.VALUE_13);
		st047Output.setRestraintsStatus(RestraintsStatus.A);
		Mockito.lenient().when(ist047.execute(inputCaptor.capture())).thenReturn(st047Output);

		RespHeader header = new RespHeader();
		T5S1InputDTO input = new T5S1InputDTO();
		input.setClientNo("C009999");

		T5S1OutputDTO output = t5S1.execute(header, input);

		assertEquals("C009999", inputCaptor.getValue().getClientNo());
		assertEquals("RS000999", output.getResSeqNo());
		assertEquals("13", output.getRestraintType());
		assertEquals("A", output.getRestraintsStatus());
		assertTrue(header.isSucceed());
		assertNull(header.getErrorCode());
		assertNull(header.getErrorMessage());
	}

	// T5S1-TC003（REQ-004-S01）：失败路径，ST047 返回失败时短路返回，错误码与错误信息原样写入响应头，最终输出业务字段不填充
	@Test
	void testT5S1T03() {
		ST047OutputBO st047Output = new ST047OutputBO();
		st047Output.setSucceed(false);
		st047Output.setErrorCode("ERR_ST047_FAIL");
		st047Output.setErrorMessage("检查客户是否存在限制失败");
		Mockito.lenient().when(ist047.execute(any(ST047InputBO.class))).thenReturn(st047Output);

		RespHeader header = new RespHeader();
		T5S1InputDTO input = new T5S1InputDTO();
		input.setClientNo("C001234");

		T5S1OutputDTO output = t5S1.execute(header, input);

		assertFalse(header.isSucceed());
		assertEquals("ERR_ST047_FAIL", header.getErrorCode());
		assertEquals("检查客户是否存在限制失败", header.getErrorMessage());
		assertNull(output.getResSeqNo());
		assertNull(output.getRestraintType());
		assertNull(output.getRestraintsStatus());
	}
}
