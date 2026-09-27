package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.facade.bo.ST045InputBO;
import com.dcits.deposit.facade.bo.ST045OutputBO;

/**
 * ST045 设置生效日期 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST045-TC001 ~ ST045-TC002）
 */
@ExtendWith(MockitoExtension.class)
public class ST045PbcTest {

	@InjectMocks
	private ST045Pbc st045Pbc;

	// TC001 生效日期非空：子步骤2a 将输入{生效日期}直接赋值给输出$生效日期$并返回；两日期取不同值以区分赋值来源
	@Test
	public void testST045T01() {
		Date runDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 28).getTime();
		Date effectDate = new GregorianCalendar(2026, Calendar.OCTOBER, 1).getTime();
		ST045InputBO input = new ST045InputBO();
		input.setRunDate(runDate);
		input.setEffectDate(effectDate);
		ST045OutputBO output = st045Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(effectDate, output.getEffectDate());
	}

	// TC002 生效日期为空（非必填字段的合法空值边界）：子步骤2b 取[系统日期]（即输入 runDate）赋值给输出$生效日期$并返回
	@Test
	public void testST045T02() {
		Date runDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 28).getTime();
		ST045InputBO input = new ST045InputBO();
		input.setRunDate(runDate);
		input.setEffectDate(null);
		ST045OutputBO output = st045Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(runDate, output.getEffectDate());
	}
}
