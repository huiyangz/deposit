package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;

/**
 * BR022 检查交易类型是否为现金支取 单元测试。
 */
class BR022Test {

	// 测试案例：正常路径：借贷标志为D借方、现金交易标志为Y是、冲正交易标志为N否，三条件全部满足，判定为现金支取
	@Test
	void testBR022T01() {
		CrDrInd crDrInd = CrDrInd.D;
		IndividualFlag cashTranFlag = IndividualFlag.Y;
		IndividualFlag reversal = IndividualFlag.N;
		String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
		assertEquals("是", executionResult);
	}

	// 测试案例：否定路径：借贷标志条件不满足（借贷标志为空，非"D借方"），其余条件满足
	@Test
	void testBR022T02() {
		CrDrInd crDrInd = null;
		IndividualFlag cashTranFlag = IndividualFlag.Y;
		IndividualFlag reversal = IndividualFlag.N;
		String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
		assertEquals("否", executionResult);
	}

	// 测试案例：否定路径：现金交易标志条件不满足（为"N否"，非"Y是"），其余条件满足
	@Test
	void testBR022T03() {
		CrDrInd crDrInd = CrDrInd.D;
		IndividualFlag cashTranFlag = IndividualFlag.N;
		IndividualFlag reversal = IndividualFlag.N;
		String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
		assertEquals("否", executionResult);
	}

	// 测试案例：否定路径：冲正交易标志条件不满足（为"Y是"，非"N否"），其余条件满足
	@Test
	void testBR022T04() {
		CrDrInd crDrInd = CrDrInd.D;
		IndividualFlag cashTranFlag = IndividualFlag.Y;
		IndividualFlag reversal = IndividualFlag.Y;
		String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
		assertEquals("否", executionResult);
	}

	// 测试案例：边界否定路径：三个条件同时不满足（借贷标志为空、现金交易标志为否、冲正交易标志为是）
	@Test
	void testBR022T05() {
		CrDrInd crDrInd = null;
		IndividualFlag cashTranFlag = IndividualFlag.N;
		IndividualFlag reversal = IndividualFlag.Y;
		String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
		assertEquals("否", executionResult);
	}

	// 测试案例：边界否定路径：三个必输输入全部为空
	@Test
	void testBR022T06() {
		CrDrInd crDrInd = null;
		IndividualFlag cashTranFlag = null;
		IndividualFlag reversal = null;
		String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
		assertEquals("否", executionResult);
	}
}
