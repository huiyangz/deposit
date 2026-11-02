package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST029InputBO;
import com.dcits.deposit.facade.bo.ST029OutputBO;
import com.dcits.deposit.facade.components.IRbBusTranJnlBcc;
import com.dcits.deposit.facade.eo.RbBusTranJnlEO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST029 登记转账交易流水 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01、REQ-003-S01 三个正常路径场景（测试用例
 * ST029-TC001~TC003）。登记写入方法按 Spec TBD-6 当前选用 {@code createSelective} 设桩，
 * 桩捕获收到的 {@link RbBusTranJnlEO} 实例供字段断言；不 mock 本步骤，不使用
 * verify/times/InOrder。需求未声明本步骤业务失败条件与错误码，无失败路径用例。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST029PbcTest {

    @Mock
    private IRbBusTranJnlBcc rbBusTranJnlBcc;

    @InjectMocks
    private ST029Pbc pbc;

    // 场景：REQ-001-S01，调用方提供四个必填输入（tranType=VALUE_4186、tranCcy=CNY、tranAmt=100.00、crDrInd=C），登记一条交易流水并正常结束
    @Test
    void testST029T01() {
        ST029InputBO input = new ST029InputBO();
        input.setTranType(TranType.VALUE_4186);
        input.setTranCcy(Ccy.CNY);
        input.setTranAmt(new BigDecimal("100.00"));
        input.setCrDrInd(CrDrInd.C);

        RbBusTranJnlEO[] captured = new RbBusTranJnlEO[1];
        when(rbBusTranJnlBcc.createSelective(any(RbBusTranJnlEO.class))).thenAnswer(invocation -> {
            captured[0] = invocation.getArgument(0);
            return 1;
        });

        ST029OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 登记记录：交易类型=输入 tranType、币种=输入 tranCcy、交易金额=输入 tranAmt（借贷标志按对应子步骤 REQ-002/REQ-003 规定）
        assertEquals(input.getTranType(), captured[0].getTranType());
        assertEquals(input.getTranCcy(), captured[0].getCcy());
        assertEquals(input.getTranAmt(), captured[0].getTranAmt());
        // 借贷标志当前透传输入 crDrInd（输入 crDrInd 用途见 Spec TBD-2）
        assertEquals(CrDrInd.C, captured[0].getCrDrInd());
    }

    // 场景：REQ-002-S01，登记借记交易流水子步骤：交易类型代码值“4186”、币种代码值“CNY”、金额 100.00、借贷标志“C-贷记”，步骤正常结束
    @Test
    void testST029T02() {
        ST029InputBO input = new ST029InputBO();
        input.setTranType(TranType.VALUE_4186);
        input.setTranCcy(Ccy.CNY);
        input.setTranAmt(new BigDecimal("100.00"));
        // REQ-002-S01 GIVEN 仅列三个输入；借贷标志为子步骤固定登记值“C-贷记”（CrDrInd.C=贷，Spec TBD-2 用途待确认），按必填输入补充构造
        input.setCrDrInd(CrDrInd.C);

        RbBusTranJnlEO[] captured = new RbBusTranJnlEO[1];
        when(rbBusTranJnlBcc.createSelective(any(RbBusTranJnlEO.class))).thenAnswer(invocation -> {
            captured[0] = invocation.getArgument(0);
            return 1;
        });

        ST029OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 断言登记记录业务值（需求字面业务含义，编码语义见 Spec TBD-3，不绑定具体存储值/列）
        assertEquals(TranType.VALUE_4186, captured[0].getTranType());
        assertEquals(Ccy.CNY, captured[0].getCcy());
        assertEquals(new BigDecimal("100.00"), captured[0].getTranAmt());
        assertEquals(CrDrInd.C, captured[0].getCrDrInd());
    }

    // 场景：REQ-003-S01，登记贷记交易流水子步骤：交易类型代码值“4189”、币种代码值“CNY”、金额 100.00、借贷标志“D-借记”，步骤正常结束
    @Test
    void testST029T03() {
        ST029InputBO input = new ST029InputBO();
        input.setTranType(TranType.VALUE_4189);
        input.setTranCcy(Ccy.CNY);
        input.setTranAmt(new BigDecimal("100.00"));
        // REQ-003-S01 GIVEN 仅列三个输入；借贷标志为子步骤固定登记值“D-借记”（CrDrInd.D=借，Spec TBD-2 用途待确认），按必填输入补充构造
        input.setCrDrInd(CrDrInd.D);

        RbBusTranJnlEO[] captured = new RbBusTranJnlEO[1];
        when(rbBusTranJnlBcc.createSelective(any(RbBusTranJnlEO.class))).thenAnswer(invocation -> {
            captured[0] = invocation.getArgument(0);
            return 1;
        });

        ST029OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        // 断言登记记录业务值（需求字面业务含义，编码语义见 Spec TBD-3，不绑定具体存储值/列）
        assertEquals(TranType.VALUE_4189, captured[0].getTranType());
        assertEquals(Ccy.CNY, captured[0].getCcy());
        assertEquals(new BigDecimal("100.00"), captured[0].getTranAmt());
        assertEquals(CrDrInd.D, captured[0].getCrDrInd());
    }
}
