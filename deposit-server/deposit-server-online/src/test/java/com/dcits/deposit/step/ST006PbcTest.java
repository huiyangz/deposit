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

import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST006InputBO;
import com.dcits.deposit.facade.bo.ST006OutputBO;
import com.dcits.deposit.facade.components.IRbTranDefBcc;
import com.dcits.deposit.facade.eo.RbTranDefEO;

/**
 * ST006 检查法透标志 单元测试。
 *
 * <p>覆盖正式 Spec 已确认场景：REQ-001-S01 + REQ-002-S01（正常路径，ST006-TC001）、
 * REQ-003-S01（ST006-TC002）、REQ-003-S02（ST006-TC003，错误码路径）。跳转《检查靠档标识》
 * 为内部跳转，本套用例断言限于成功状态与业务输出；TBD-1~TBD-4 无已确认预期，不作为断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST006PbcTest {

    @Mock
    private IRbTranDefBcc irbTranDefBcc;

    @InjectMocks
    private ST006Pbc st006Pbc;

    // 场景：REQ-001-S01 + REQ-002-S01，查询交易类型定义表返回借贷标志「借」（CrDrInd.D）且法人透支检查标志为「是」（"Y"），业务成功结束（succeed=true、errorCode/errorMessage 为 null）并跳转《检查靠档标识》
    @Test
    void testST006T01() {
        RbTranDefEO rbTranDefEo = new RbTranDefEO();
        rbTranDefEo.setCrDrInd(CrDrInd.D);
        Mockito.lenient().when(irbTranDefBcc.findByTranType(TranType.VALUE_1000)).thenReturn(rbTranDefEo);

        ST006InputBO input = new ST006InputBO();
        input.setTranType(TranType.VALUE_1000);
        input.set法人透支检查标志("Y");

        ST006OutputBO result = st006Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(CrDrInd.D, result.getCrDrInd());
    }

    // 场景：REQ-003-S01，查询交易类型定义表返回借贷标志「贷」（CrDrInd.C）且法人透支检查标志为「是」（"Y"），借贷标志非借不满足放行条件，业务失败，errorCode 为 ER0060
    @Test
    void testST006T02() {
        RbTranDefEO rbTranDefEo = new RbTranDefEO();
        rbTranDefEo.setCrDrInd(CrDrInd.C);
        Mockito.lenient().when(irbTranDefBcc.findByTranType(TranType.VALUE_1000)).thenReturn(rbTranDefEo);

        ST006InputBO input = new ST006InputBO();
        input.setTranType(TranType.VALUE_1000);
        input.set法人透支检查标志("Y");

        ST006OutputBO result = st006Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0060", result.getErrorCode());
    }

    // 场景：REQ-003-S02，查询交易类型定义表返回借贷标志「借」（CrDrInd.D）但法人透支检查标志为「否」（"N"，不等于"Y"），标志不为是不满足放行条件，业务失败，errorCode 为 ER0060
    @Test
    void testST006T03() {
        RbTranDefEO rbTranDefEo = new RbTranDefEO();
        rbTranDefEo.setCrDrInd(CrDrInd.D);
        Mockito.lenient().when(irbTranDefBcc.findByTranType(TranType.VALUE_1000)).thenReturn(rbTranDefEo);

        ST006InputBO input = new ST006InputBO();
        input.setTranType(TranType.VALUE_1000);
        input.set法人透支检查标志("N");

        ST006OutputBO result = st006Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0060", result.getErrorCode());
    }
}
