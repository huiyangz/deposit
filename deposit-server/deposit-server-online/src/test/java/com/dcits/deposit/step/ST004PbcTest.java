package com.dcits.deposit.step;

import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST004InputBO;
import com.dcits.deposit.facade.bo.ST004OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ST004 检查账户通兑信息 步骤实现单元测试。
 *
 * <p>用例来源：正式 Spec ST004 与测试用例文档（ST004-TC001）。账号查询入口（TBD-8）确认前，
 * 桩仅绑定已确认数据源 {@link IRbBusAcctBcc}，返回主表记录；本路径不触达
 * {@link com.dcits.deposit.facade.components.IFmBranchBcc}，不设机构查询桩。步骤 3–10 分支触发值
 * 映射（TBD-1）未确认，其余路径按未覆盖处理，不猜值生成用例。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST004PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST004Pbc st004Pbc;

    /** 正常成功流：按账号查询主表取得开立行行号与通兑标志，开立行等于交易机构，步骤 2 返回「通过」。 */
    @Test
    void testST004T01() {
        RbBusAcctEO record = new RbBusAcctEO();
        record.setAcctBranch(TranBranch.VALUE_351155);
        record.setAllDraInd(AllDraInd.N001);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(Mockito.any(RbBusAcctEO.class)))
                .thenReturn(List.of(record));

        ST004InputBO input = new ST004InputBO();
        input.setBaseAcctNo("100000000001");
        input.setTranBranch(TranBranch.VALUE_351155);

        ST004OutputBO result = st004Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(TranBranch.VALUE_351155, result.getAcctBranch());
        assertEquals(AllDraInd.N001, result.getAllDraInd());
    }
}
