package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.deposit.enums.TailboxProperty;
import com.dcits.deposit.facade.bo.ST024InputBO;
import com.dcits.deposit.facade.bo.ST024OutputBO;
import com.dcits.deposit.facade.components.ITbCashBalanceBcc;
import com.dcits.deposit.facade.components.ITbTailboxBcc;
import com.dcits.deposit.facade.eo.TbCashBalanceEO;
import com.dcits.deposit.facade.eo.TbTailboxEO;
import java.math.BigDecimal;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST024 更新现金存入后现金尾箱 单元测试
 *
 * 依据 docs/specs/ST024.md（任务上下文 fileInputs.spec 绑定的需求门禁通过版）与 outputs/测试用例.md。
 */
@ExtendWith(MockitoExtension.class)
public class ST024PbcTest {

    @Mock
    private ITbTailboxBcc tbTailboxBcc;

    @Mock
    private ITbCashBalanceBcc tbCashBalanceBcc;

    @InjectMocks
    private ST024Pbc st024Pbc;

    /** 桩：子步骤1 尾箱基本信息表查询，入参柜员号+尾箱属性等值命中时返回单条尾箱记录；记录入参查询 EO 供断言 */
    private TbTailboxEO[] stubTailboxFindByEo(String assignUserId, TailboxProperty tailboxProperty,
            TbTailboxEO tailboxRecord) {
        TbTailboxEO[] queryEo = new TbTailboxEO[1];
        Mockito.lenient().when(tbTailboxBcc.findByEo(Mockito.any(TbTailboxEO.class))).thenAnswer(invocation -> {
            TbTailboxEO probe = invocation.getArgument(0);
            queryEo[0] = probe;
            if (assignUserId.equals(probe.getAssignUserId()) && tailboxProperty == probe.getTailboxProperty()) {
                return Collections.singletonList(tailboxRecord);
            }
            return Collections.emptyList();
        });
        return queryEo;
    }

    /** 桩：子步骤2 尾箱现金余额查询，入参尾箱编号命中时返回单条余额记录；记录入参查询 EO 供断言 */
    private TbCashBalanceEO[] stubBalanceFindByEo(String tailboxId, TbCashBalanceEO balanceRecord) {
        TbCashBalanceEO[] queryEo = new TbCashBalanceEO[1];
        Mockito.lenient().when(tbCashBalanceBcc.findByEo(Mockito.any(TbCashBalanceEO.class))).thenAnswer(invocation -> {
            TbCashBalanceEO probe = invocation.getArgument(0);
            queryEo[0] = probe;
            if (tailboxId.equals(probe.getTailboxId())) {
                return Collections.singletonList(balanceRecord);
            }
            return Collections.emptyList();
        });
        return queryEo;
    }

    /** 桩：子步骤4 尾箱现金余额更新，记录入参 EO 供断言，返回 1 表示更新一条记录 */
    private TbCashBalanceEO[] stubBalanceModify() {
        TbCashBalanceEO[] updateEo = new TbCashBalanceEO[1];
        Mockito.lenient().when(tbCashBalanceBcc.modifyByPrimaryKeySelective(Mockito.any(TbCashBalanceEO.class)))
                .thenAnswer(invocation -> {
                    updateEo[0] = invocation.getArgument(0);
                    return 1;
                });
        return updateEo;
    }

    /** 尾箱基本信息表记录：仅设置本路径数据流触达的字段（尾箱编号、尾箱分配柜员号、尾箱属性） */
    private TbTailboxEO tailboxRecord(String tailboxId, String assignUserId, TailboxProperty tailboxProperty) {
        TbTailboxEO record = new TbTailboxEO();
        record.setTailboxId(tailboxId);
        record.setAssignUserId(assignUserId);
        record.setTailboxProperty(tailboxProperty);
        return record;
    }

    /** 尾箱现金余额表记录：仅设置本路径数据流触达的字段（尾箱编号、金额） */
    private TbCashBalanceEO balanceRecord(String tailboxId, String amount) {
        TbCashBalanceEO record = new TbCashBalanceEO();
        record.setTailboxId(tailboxId);
        record.setAmount(new BigDecimal(amount));
        return record;
    }

    // 场景：现金尾箱正常路径：柜员 T001 尾箱属性为现金尾箱存入 1000.00，覆盖子步骤1查询尾箱、2查询现金余额、3计算尾箱余额、4更新金额全流程；预期成功，尾箱编号 TB0001，尾箱余额 5000.00+1000.00=6000.00
    @Test
    public void testST024T01() {
        TbTailboxEO[] tailboxQueryEo = stubTailboxFindByEo("T001", TailboxProperty.C,
                tailboxRecord("TB0001", "T001", TailboxProperty.C));
        TbCashBalanceEO[] balanceQueryEo = stubBalanceFindByEo("TB0001", balanceRecord("TB0001", "5000.00"));
        TbCashBalanceEO[] updateEo = stubBalanceModify();

        ST024InputBO input = new ST024InputBO();
        input.setAssignUserId("T001");
        input.setTailboxProperty(TailboxProperty.C);
        input.setTranAmt(new BigDecimal("1000.00"));

        ST024OutputBO output = st024Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("TB0001", output.getTailboxId());
        assertEquals(0, new BigDecimal("6000.00").compareTo(output.getTailboxBalance()));
        assertEquals("T001", tailboxQueryEo[0].getAssignUserId());
        assertEquals(TailboxProperty.C, tailboxQueryEo[0].getTailboxProperty());
        assertEquals("TB0001", balanceQueryEo[0].getTailboxId());
        assertEquals("TB0001", updateEo[0].getTailboxId());
        assertEquals(0, new BigDecimal("6000.00").compareTo(updateEo[0].getAmount()));
    }

    // 场景：组合尾箱正常路径：柜员 T002 尾箱属性为组合尾箱存入两位小数金额 250.50，覆盖另一合法尾箱属性及小数加法；预期成功，尾箱编号 TB2002，尾箱余额 1249.50+250.50=1500.00
    @Test
    public void testST024T02() {
        TbTailboxEO[] tailboxQueryEo = stubTailboxFindByEo("T002", TailboxProperty.B,
                tailboxRecord("TB2002", "T002", TailboxProperty.B));
        TbCashBalanceEO[] balanceQueryEo = stubBalanceFindByEo("TB2002", balanceRecord("TB2002", "1249.50"));
        TbCashBalanceEO[] updateEo = stubBalanceModify();

        ST024InputBO input = new ST024InputBO();
        input.setAssignUserId("T002");
        input.setTailboxProperty(TailboxProperty.B);
        input.setTranAmt(new BigDecimal("250.50"));

        ST024OutputBO output = st024Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("TB2002", output.getTailboxId());
        assertEquals(0, new BigDecimal("1500.00").compareTo(output.getTailboxBalance()));
        assertEquals("T002", tailboxQueryEo[0].getAssignUserId());
        assertEquals(TailboxProperty.B, tailboxQueryEo[0].getTailboxProperty());
        assertEquals("TB2002", balanceQueryEo[0].getTailboxId());
        assertEquals("TB2002", updateEo[0].getTailboxId());
        assertEquals(0, new BigDecimal("1500.00").compareTo(updateEo[0].getAmount()));
    }

    // 场景：交易金额零值边界：柜员 T003 尾箱属性为现金尾箱存入 0.00，[尾箱余额]=[金额]+0.00 数值不变且仍执行更新；预期成功，尾箱编号 TB3003，尾箱余额 300.00+0.00=300.00
    @Test
    public void testST024T03() {
        TbTailboxEO[] tailboxQueryEo = stubTailboxFindByEo("T003", TailboxProperty.C,
                tailboxRecord("TB3003", "T003", TailboxProperty.C));
        TbCashBalanceEO[] balanceQueryEo = stubBalanceFindByEo("TB3003", balanceRecord("TB3003", "300.00"));
        TbCashBalanceEO[] updateEo = stubBalanceModify();

        ST024InputBO input = new ST024InputBO();
        input.setAssignUserId("T003");
        input.setTailboxProperty(TailboxProperty.C);
        input.setTranAmt(new BigDecimal("0.00"));

        ST024OutputBO output = st024Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("TB3003", output.getTailboxId());
        assertEquals(0, new BigDecimal("300.00").compareTo(output.getTailboxBalance()));
        assertEquals("T003", tailboxQueryEo[0].getAssignUserId());
        assertEquals(TailboxProperty.C, tailboxQueryEo[0].getTailboxProperty());
        assertEquals("TB3003", balanceQueryEo[0].getTailboxId());
        assertEquals("TB3003", updateEo[0].getTailboxId());
        assertEquals(0, new BigDecimal("300.00").compareTo(updateEo[0].getAmount()));
    }

    // 场景：期初余额零值边界：柜员 T004 尾箱属性为组合尾箱的尾箱现金余额金额为 0.00，存入 500.00 后[尾箱余额]=0.00+500.00；预期成功，尾箱编号 TB4004，尾箱余额 500.00
    @Test
    public void testST024T04() {
        TbTailboxEO[] tailboxQueryEo = stubTailboxFindByEo("T004", TailboxProperty.B,
                tailboxRecord("TB4004", "T004", TailboxProperty.B));
        TbCashBalanceEO[] balanceQueryEo = stubBalanceFindByEo("TB4004", balanceRecord("TB4004", "0.00"));
        TbCashBalanceEO[] updateEo = stubBalanceModify();

        ST024InputBO input = new ST024InputBO();
        input.setAssignUserId("T004");
        input.setTailboxProperty(TailboxProperty.B);
        input.setTranAmt(new BigDecimal("500.00"));

        ST024OutputBO output = st024Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("TB4004", output.getTailboxId());
        assertEquals(0, new BigDecimal("500.00").compareTo(output.getTailboxBalance()));
        assertEquals("T004", tailboxQueryEo[0].getAssignUserId());
        assertEquals(TailboxProperty.B, tailboxQueryEo[0].getTailboxProperty());
        assertEquals("TB4004", balanceQueryEo[0].getTailboxId());
        assertEquals("TB4004", updateEo[0].getTailboxId());
        assertEquals(0, new BigDecimal("500.00").compareTo(updateEo[0].getAmount()));
    }
}
