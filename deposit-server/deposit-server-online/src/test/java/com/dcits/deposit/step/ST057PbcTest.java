package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST057InputBO;
import com.dcits.deposit.facade.bo.ST057OutputBO;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.components.IRbTranDefBcc;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;
import com.dcits.deposit.facade.eo.RbTranDefEO;

/**
 * ST057 检查限制优先级 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01、REQ-003-S01 三个正常线性流用例
 * （ST057-TC001~TC003）。REQ-004 分支与输出字段取值依赖待确认事项
 * （TBD-1~TBD-6），按用例文档不作断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST057PbcTest {

    @Mock
    private IRbTranDefBcc rbTranDefBcc;

    @Mock
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @InjectMocks
    private ST057Pbc st057Pbc;

    // 场景：ST057-TC001 / REQ-001-S01，提供合法 tranType/restraintType，两查询均触达后正常结束，succeed=true 且错误字段为 null
    @Test
    void testST057T01() {
        RbTranDefEO tranDef = new RbTranDefEO();
        tranDef.setTranType(TranType.VALUE_1000);
        RbRestraintTypeEO restraintType = new RbRestraintTypeEO();
        restraintType.setRestraintType(RestraintType.VALUE_4);
        restraintType.setResPriority("01");
        lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1000)).thenReturn(tranDef);
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_4)).thenReturn(restraintType);

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1000);
        input.setRestraintType(RestraintType.VALUE_4);

        ST057OutputBO result = st057Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景：ST057-TC002 / REQ-002-S01，交易类型定义表存在与输入 tranType 对应记录，经 findByTranType 按输入交易类型查询并正常结束；捕获查询入参核对输入→查询映射
    @Test
    void testST057T02() {
        RbTranDefEO tranDef = new RbTranDefEO();
        tranDef.setTranType(TranType.VALUE_1001);
        RbRestraintTypeEO restraintType = new RbRestraintTypeEO();
        restraintType.setRestraintType(RestraintType.VALUE_5);
        restraintType.setResPriority("02");
        TranType[] capturedTranType = new TranType[1];
        lenient().when(rbTranDefBcc.findByTranType(any())).thenAnswer(invocation -> {
            capturedTranType[0] = invocation.getArgument(0);
            return tranDef;
        });
        lenient().when(rbRestraintTypeBcc.findByRestraintType(RestraintType.VALUE_5)).thenReturn(restraintType);

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1001);
        input.setRestraintType(RestraintType.VALUE_5);

        ST057OutputBO result = st057Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(TranType.VALUE_1001, capturedTranType[0]);
    }

    // 场景：ST057-TC003 / REQ-003-S01，存款限制类型表存在与输入 restraintType 对应记录，经 findByRestraintType 按输入账户限制类型查询并正常结束；捕获查询入参核对输入→查询映射
    @Test
    void testST057T03() {
        RbTranDefEO tranDef = new RbTranDefEO();
        tranDef.setTranType(TranType.VALUE_1003);
        RbRestraintTypeEO restraintType = new RbRestraintTypeEO();
        restraintType.setRestraintType(RestraintType.VALUE_6);
        restraintType.setResPriority("03");
        RestraintType[] capturedRestraintType = new RestraintType[1];
        lenient().when(rbTranDefBcc.findByTranType(TranType.VALUE_1003)).thenReturn(tranDef);
        lenient().when(rbRestraintTypeBcc.findByRestraintType(any())).thenAnswer(invocation -> {
            capturedRestraintType[0] = invocation.getArgument(0);
            return restraintType;
        });

        ST057InputBO input = new ST057InputBO();
        input.setTranType(TranType.VALUE_1003);
        input.setRestraintType(RestraintType.VALUE_6);

        ST057OutputBO result = st057Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(RestraintType.VALUE_6, capturedRestraintType[0]);
    }
}
