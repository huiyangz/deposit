package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST051 检查账户是否存在限制 - 步骤实现单元测试。
 */
@ExtendWith(MockitoExtension.class)
class ST051PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST051Pbc st051Pbc;

    // ST051-TC001 非子账户输入正常路径（REQ-003-S01＋REQ-004-S01＋REQ-001-S01）：
    // 输入账号「6221000000000001」被判定为非子账户，不执行主账户账号查询，待查账户=输入账号；
    // 仅设桩 IRbBusRestraintsBcc.findByEo，桩按查询 EO 的账号「6221000000000001」定向（argThat 匹配），
    // 实现若以其他账号查询则不命中桩而致断言失败，从而验证 REQ-003-S01「待查账户=输入账号」；
    // 桩返回两条记录，其中状态 E 的记录二在前、状态 A 的记录一在后，
    // 以验证实现按限制状态=A 筛选（REQ-004）而非直接取首条记录；
    // 预期 succeed=true、错误字段为 null，resSeqNo=R0001、restraintsStatus=A、restraintType=13，状态 E 的记录二不被返回
    @Test
    void testST051T01() {
        RbBusRestraintsEO record1 = new RbBusRestraintsEO();
        record1.setBaseAcctNo("6221000000000001");
        record1.setResSeqNo("R0001");
        record1.setRestraintsStatus(RestraintsStatus.A);
        record1.setRestraintType(RestraintType.VALUE_13);

        RbBusRestraintsEO record2 = new RbBusRestraintsEO();
        record2.setBaseAcctNo("6221000000000001");
        record2.setResSeqNo("R0002");
        record2.setRestraintsStatus(RestraintsStatus.E);

        Mockito.lenient().when(rbBusRestraintsBcc.findByEo(Mockito.argThat(
                        eo -> eo != null && "6221000000000001".equals(eo.getBaseAcctNo()))))
                .thenReturn(List.of(record2, record1));

        ST051InputBO input = new ST051InputBO();
        input.setBaseAcctNo("6221000000000001");

        ST051OutputBO output = st051Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("R0001", output.getResSeqNo());
        assertEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertEquals(RestraintType.VALUE_13, output.getRestraintType());
    }
}
