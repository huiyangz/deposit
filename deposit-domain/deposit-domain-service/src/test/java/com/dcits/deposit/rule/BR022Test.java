package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;

/**
 * BR022 检查交易类型是否为现金支取 单元测试
 */
class BR022Test {

    // 测试案例：正常路径-借贷标志为借方、现金交易标志为是、冲正交易标志为否，三个条件全部满足，判定为现金支取，应返回"是"
    @Test
    void testBR022T01() {
        CrDrInd crDrInd = CrDrInd.D;
        IndividualFlag cashTranFlag = IndividualFlag.Y;
        IndividualFlag reversal = IndividualFlag.N;
        String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
        assertEquals("是", executionResult);
    }

    // 测试案例：否定路径-冲正交易标志为"是"，第三个条件不满足（前两个条件满足），判定非现金支取，应返回"否"
    @Test
    void testBR022T02() {
        CrDrInd crDrInd = CrDrInd.D;
        IndividualFlag cashTranFlag = IndividualFlag.Y;
        IndividualFlag reversal = IndividualFlag.Y;
        String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
        assertEquals("否", executionResult);
    }

    // 测试案例：否定路径-现金交易标志为"否"，第二个条件不满足（第一个条件满足），判定非现金支取，应返回"否"
    @Test
    void testBR022T03() {
        CrDrInd crDrInd = CrDrInd.D;
        IndividualFlag cashTranFlag = IndividualFlag.N;
        IndividualFlag reversal = IndividualFlag.N;
        String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
        assertEquals("否", executionResult);
    }

    // 测试案例：否定路径-借贷标志为非"借方"取值（贷方），第一个条件不满足，判定非现金支取，应返回"否"
    @Test
    void testBR022T04() {
        CrDrInd crDrInd = CrDrInd.C;
        IndividualFlag cashTranFlag = IndividualFlag.Y;
        IndividualFlag reversal = IndividualFlag.N;
        String executionResult = BR022.execute(crDrInd, cashTranFlag, reversal);
        assertEquals("否", executionResult);
    }
}
