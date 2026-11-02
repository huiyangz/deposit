package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST018InputBO;
import com.dcits.deposit.facade.bo.ST018OutputBO;
import com.dcits.deposit.facade.components.IFmBranchBcc;
import com.dcits.deposit.facade.components.IRbOdBranchInfoBcc;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.facade.eo.RbOdBranchInfoEO;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST018 检查分行法人透支额度 单元测试。
 */
@ExtendWith(MockitoExtension.class)
class ST018PbcTest {

    @Mock
    private IFmBranchBcc fmBranchBcc;

    @Mock
    private IRbOdBranchInfoBcc rbOdBranchInfoBcc;

    @InjectMocks
    private ST018Pbc st018Pbc;

    // 正常路径：已使用额度 80.00 小于总额度 100.00，步骤成功并跳转《检查法透账户支取限制》（REQ-004-S02）
    @Test
    void testST018T01() {
        FmBranchEO fmBranchEO = new FmBranchEO();
        fmBranchEO.setBranch(TranBranch.VALUE_352001);
        Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351156)).thenReturn(fmBranchEO);

        RbOdBranchInfoEO rbOdBranchInfoEO = new RbOdBranchInfoEO();
        rbOdBranchInfoEO.setBranch(TranBranch.VALUE_352001);
        rbOdBranchInfoEO.setUsedAmt(new BigDecimal("80.00"));
        rbOdBranchInfoEO.setTotalLimit(new BigDecimal("100.00"));
        Mockito.lenient().when(rbOdBranchInfoBcc.findByBranch(TranBranch.VALUE_352001)).thenReturn(rbOdBranchInfoEO);

        ST018InputBO input = new ST018InputBO();
        input.setTranBranch(TranBranch.VALUE_351156);

        ST018OutputBO output = st018Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(TranBranch.VALUE_352001, output.getBranch());
        assertEquals(new BigDecimal("100.00"), output.getTotalLimit());
        assertEquals(new BigDecimal("80.00"), output.getUsedAmt());
    }

    // 边界相等路径：已使用额度 100.00 等于总额度 100.00，步骤成功并跳转《检查法透账户支取限制》（REQ-004-S01）
    @Test
    void testST018T02() {
        FmBranchEO fmBranchEO = new FmBranchEO();
        fmBranchEO.setBranch(TranBranch.VALUE_352001);
        Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351156)).thenReturn(fmBranchEO);

        RbOdBranchInfoEO rbOdBranchInfoEO = new RbOdBranchInfoEO();
        rbOdBranchInfoEO.setBranch(TranBranch.VALUE_352001);
        rbOdBranchInfoEO.setUsedAmt(new BigDecimal("100.00"));
        rbOdBranchInfoEO.setTotalLimit(new BigDecimal("100.00"));
        Mockito.lenient().when(rbOdBranchInfoBcc.findByBranch(TranBranch.VALUE_352001)).thenReturn(rbOdBranchInfoEO);

        ST018InputBO input = new ST018InputBO();
        input.setTranBranch(TranBranch.VALUE_351156);

        ST018OutputBO output = st018Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(TranBranch.VALUE_352001, output.getBranch());
        assertEquals(new BigDecimal("100.00"), output.getTotalLimit());
        assertEquals(new BigDecimal("100.00"), output.getUsedAmt());
    }

    // 超限失败路径：已使用额度 120.00 大于总额度 100.00，业务失败返回 ER0062，不跳转《检查法透账户支取限制》（REQ-004-S03）
    @Test
    void testST018T03() {
        FmBranchEO fmBranchEO = new FmBranchEO();
        fmBranchEO.setBranch(TranBranch.VALUE_352001);
        Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351156)).thenReturn(fmBranchEO);

        RbOdBranchInfoEO rbOdBranchInfoEO = new RbOdBranchInfoEO();
        rbOdBranchInfoEO.setBranch(TranBranch.VALUE_352001);
        rbOdBranchInfoEO.setUsedAmt(new BigDecimal("120.00"));
        rbOdBranchInfoEO.setTotalLimit(new BigDecimal("100.00"));
        Mockito.lenient().when(rbOdBranchInfoBcc.findByBranch(TranBranch.VALUE_352001)).thenReturn(rbOdBranchInfoEO);

        ST018InputBO input = new ST018InputBO();
        input.setTranBranch(TranBranch.VALUE_351156);

        ST018OutputBO output = st018Pbc.execute(input);

        assertFalse(output.isSucceed());
        assertEquals("ER0062", output.getErrorCode());
        assertEquals("ER0062::分行法人透支额度超限", output.getErrorMessage());
    }
}
