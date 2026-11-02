package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.CheckObjType;
import com.dcits.deposit.enums.CtrlItemType;
import com.dcits.deposit.enums.SumType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.components.IRbLimitSumJnlBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.deposit.facade.eo.RbLimitSceneDefEO;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;
import com.dcits.deposit.facade.eo.RbLimitSumJnlEO;

/**
 * ST039 计算限额累计金额 步骤实现 单元测试。
 *
 * <p>覆盖正式 Spec ST039 测试用例 ST039-TC001~TC006 对应分支：非滑动窗口累加、O-单笔金额
 * 不累计、多条结果取第一条、无累计限额信息、滑动窗口存在与不存在记录。未确认行为
 * （TBD-1~TBD-9）不作断言，见实现中 FIXME。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST039PbcTest {

    @Mock
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @Mock
    private IRbLimitSceneDefBcc rbLimitSceneDefBcc;

    @Mock
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @Mock
    private IRbLimitSumJnlBcc rbLimitSumJnlBcc;

    @InjectMocks
    private ST039Pbc st039Pbc;

    // 场景：ST039-TC001 非滑动窗口累加。限额控制类型 A-累计金额、累计类型 1-自然周期，
    // 按场景定义检查对象类型 CUST 查到生效范围内累计限额信息（限额累计金额 500.00、
    // 笔数 2），交易金额 100.00，累加后限额累计金额 600.00、笔数 3
    @Test
    void testST039T01() {
        RbLimitCtrlConfEO conf = newConf(CtrlItemType.A, SumType.VALUE_1);
        RbLimitSceneDefEO sceneDef = newSceneDef(CheckObjType.CUST);
        RbLimitSumInfoEO sumInfo = newSumInfo("500.00", 2);
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(Mockito.any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf));
        Mockito.lenient().when(rbLimitSceneDefBcc.findByEo(Mockito.any(RbLimitSceneDefEO.class)))
                .thenReturn(List.of(sceneDef));
        Mockito.lenient().when(rbLimitSumInfoBcc.findByEo(Mockito.any(RbLimitSumInfoEO.class)))
                .thenReturn(List.of(sumInfo));

        ST039OutputBO output = st039Pbc.execute(newInput("100.00"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(0, new BigDecimal("600.00").compareTo(output.getLimitSumAmt()));
        assertInstanceOf(BigDecimal.class, output.getLimitSumAmt());
        assertEquals(3, output.get限额累计笔数());
        assertInstanceOf(Integer.class, output.get限额累计笔数());
    }

    // 场景：ST039-TC002 单笔金额限额。限额控制类型 O，不计算累计限额，正常提前结束，
    // 限额累计金额与限额累计笔数保持 null
    @Test
    void testST039T02() {
        RbLimitCtrlConfEO conf = newConf(CtrlItemType.O, SumType.VALUE_1);
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(Mockito.any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf));

        ST039OutputBO output = st039Pbc.execute(newInput("100.00"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getLimitSumAmt());
        assertNull(output.get限额累计笔数());
    }

    // 场景：ST039-TC003 单条结果查询返回多条时取结果集第一条。累计信息表返回两条生效记录，
    // 仅第一条（500.00/2 笔）参与累加，不使用第二条（200.00/9 笔），结果为 600.00/3 笔
    @Test
    void testST039T03() {
        RbLimitCtrlConfEO conf = newConf(CtrlItemType.A, SumType.VALUE_1);
        RbLimitSceneDefEO sceneDef = newSceneDef(CheckObjType.CUST);
        RbLimitSumInfoEO record1 = newSumInfo("500.00", 2);
        RbLimitSumInfoEO record2 = newSumInfo("200.00", 9);
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(Mockito.any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf));
        Mockito.lenient().when(rbLimitSceneDefBcc.findByEo(Mockito.any(RbLimitSceneDefEO.class)))
                .thenReturn(List.of(sceneDef));
        Mockito.lenient().when(rbLimitSumInfoBcc.findByEo(Mockito.any(RbLimitSumInfoEO.class)))
                .thenReturn(List.of(record1, record2));

        ST039OutputBO output = st039Pbc.execute(newInput("100.00"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(0, new BigDecimal("600.00").compareTo(output.getLimitSumAmt()));
        assertEquals(3, output.get限额累计笔数());
    }

    // 场景：ST039-TC004 无生效累计限额信息。累计信息表查询为空（REQ-006），限额累计笔数
    // 返回 1；限额累计金额取值待确认（TBD-3），不断言该字段
    @Test
    void testST039T04() {
        RbLimitCtrlConfEO conf = newConf(CtrlItemType.A, SumType.VALUE_1);
        RbLimitSceneDefEO sceneDef = newSceneDef(CheckObjType.CUST);
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(Mockito.any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf));
        Mockito.lenient().when(rbLimitSceneDefBcc.findByEo(Mockito.any(RbLimitSceneDefEO.class)))
                .thenReturn(List.of(sceneDef));
        Mockito.lenient().when(rbLimitSumInfoBcc.findByEo(Mockito.any(RbLimitSumInfoEO.class)))
                .thenReturn(Collections.emptyList());

        ST039OutputBO output = st039Pbc.execute(newInput("100.00"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(1, output.get限额累计笔数());
    }

    // 场景：ST039-TC005 滑动窗口存在记录。限额控制类型 B、累计类型 2-滑动窗口、周期值 1、
    // 期限类型 D，有效周期内两笔交易（100.00/200.00），限额累计金额为交易金额之和 300.00、
    // 笔数之和 2
    @Test
    void testST039T05() {
        RbLimitCtrlConfEO conf = newConf(CtrlItemType.B, SumType.VALUE_2);
        conf.setPeriodValue("1");
        conf.setPeriodType(TermType.D);
        RbLimitSceneDefEO sceneDef = newSceneDef(CheckObjType.ACCT);
        RbLimitSumJnlEO jnl1 = newJnl("100.00");
        RbLimitSumJnlEO jnl2 = newJnl("200.00");
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(Mockito.any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf));
        Mockito.lenient().when(rbLimitSceneDefBcc.findByEo(Mockito.any(RbLimitSceneDefEO.class)))
                .thenReturn(List.of(sceneDef));
        Mockito.lenient().when(rbLimitSumJnlBcc.findByEo(Mockito.any(RbLimitSumJnlEO.class)))
                .thenReturn(List.of(jnl1, jnl2));

        ST039OutputBO output = st039Pbc.execute(newInput("100.00"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(0, new BigDecimal("300.00").compareTo(output.getLimitSumAmt()));
        assertEquals(2, output.get限额累计笔数());
    }

    // 场景：ST039-TC006 滑动窗口无记录。有效周期内不存在限额（REQ-009），限额累计金额=
    // 交易金额 150.00、限额累计笔数=1
    @Test
    void testST039T06() {
        RbLimitCtrlConfEO conf = newConf(CtrlItemType.B, SumType.VALUE_2);
        conf.setPeriodValue("1");
        conf.setPeriodType(TermType.D);
        RbLimitSceneDefEO sceneDef = newSceneDef(CheckObjType.ACCT);
        Mockito.lenient().when(rbLimitCtrlConfBcc.findByEo(Mockito.any(RbLimitCtrlConfEO.class)))
                .thenReturn(List.of(conf));
        Mockito.lenient().when(rbLimitSceneDefBcc.findByEo(Mockito.any(RbLimitSceneDefEO.class)))
                .thenReturn(List.of(sceneDef));
        Mockito.lenient().when(rbLimitSumJnlBcc.findByEo(Mockito.any(RbLimitSumJnlEO.class)))
                .thenReturn(Collections.emptyList());

        ST039OutputBO output = st039Pbc.execute(newInput("150.00"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(0, new BigDecimal("150.00").compareTo(output.getLimitSumAmt()));
        assertEquals(1, output.get限额累计笔数());
    }

    private ST039InputBO newInput(String tranAmt) {
        ST039InputBO input = new ST039InputBO();
        input.setTranAmt(new BigDecimal(tranAmt));
        input.setLimitSceneNo("C001");
        return input;
    }

    private RbLimitCtrlConfEO newConf(CtrlItemType ctrlItemType, SumType sumType) {
        RbLimitCtrlConfEO conf = new RbLimitCtrlConfEO();
        conf.setLimitSceneNo("C001");
        conf.setCtrlItemType(ctrlItemType);
        conf.setSumType(sumType);
        return conf;
    }

    private RbLimitSceneDefEO newSceneDef(CheckObjType checkObjType) {
        RbLimitSceneDefEO sceneDef = new RbLimitSceneDefEO();
        sceneDef.setCheckObjType(checkObjType);
        return sceneDef;
    }

    private RbLimitSumInfoEO newSumInfo(String limitSumAmt, int 笔数) {
        RbLimitSumInfoEO sumInfo = new RbLimitSumInfoEO();
        sumInfo.setCheckObjVal("62000001");
        sumInfo.setLimitSceneNo("C001");
        sumInfo.setLimitSumAmt(new BigDecimal(limitSumAmt));
        sumInfo.set否(Integer.valueOf(笔数));
        sumInfo.setEffectDate(java.sql.Date.valueOf("2000-01-01"));
        sumInfo.setExpireDate(java.sql.Date.valueOf("9999-12-31"));
        return sumInfo;
    }

    private RbLimitSumJnlEO newJnl(String tranAmt) {
        RbLimitSumJnlEO jnl = new RbLimitSumJnlEO();
        jnl.setCheckObjVal("62000001");
        jnl.setLimitSceneNo("C001");
        jnl.setTranAmt(new BigDecimal(tranAmt));
        jnl.setTranDate(java.sql.Date.valueOf("2026-10-01"));
        return jnl;
    }
}
