package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST013InputBO;
import com.dcits.deposit.facade.bo.ST013OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;

/**
 * ST013 检查对手客户黑名单 步骤单元测试。
 *
 * <p>覆盖正式 Spec 已确认子步骤行为：REQ-001 客户证件信息获取、REQ-002 凭证种类获取、
 * REQ-003 事件类型赋值、REQ-004 组件内步骤调用 ST036、REQ-005 通过/提醒/授权/拒绝四分支。
 * 测试用例 ST013-TC001~TC005。第 1 步查询桩目标为 IFmClientCopyBcc，按 othClientNo 定位
 * 记录的实际查询键与方法见 TBD-1，桩不猜测方法；TC005 通过 thenAnswer 捕获实际传入的
 * ST036InputBO（不统计调用次数/顺序）。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST013PbcTest {

    @Mock
    private IFmClientCopyBcc ifmClientCopyBcc;

    @Mock
    private ITbVoucherDefBcc itbVoucherDefBcc;

    @Mock
    private IST036 ist036;

    @InjectMocks
    private ST013Pbc st013Pbc;

    /** TC005 捕获的实际传入 ST036 的输入对象。 */
    private ST036InputBO capturedSt036Input;

    // 场景：ST013-TC001（REQ-005-S01）：第 1~3 步取得取值后 ST036 返回「通过」（dealFlow 为空），步骤返回检查结果「通过」
    @Test
    void testST013T01() {
        stubFirstTwoSteps();
        lenient().when(ist036.execute(any(ST036InputBO.class)))
                .thenReturn(buildSt036Output(null));

        ST013OutputBO output = st013Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("CRET", output.getEventType());
        assertEquals(DocClass.DCT, output.getDocClass());
        assertEquals("示例客户", output.getClientName());
        assertEquals("110101199001011234", output.getDocumentId());
        assertEquals(DocumentType.VALUE_110001, output.getDocumentType());
        assertEquals(IssCountry.CHN, output.getIssCountry());
    }

    // 场景：ST013-TC002（REQ-005-S02）：ST036 返回「提醒」（dealFlow=D），步骤返回检查结果「通过」
    @Test
    void testST013T02() {
        stubFirstTwoSteps();
        lenient().when(ist036.execute(any(ST036InputBO.class)))
                .thenReturn(buildSt036Output(DealFlow.D));

        ST013OutputBO output = st013Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("CRET", output.getEventType());
        assertEquals(DocClass.DCT, output.getDocClass());
        assertEquals("示例客户", output.getClientName());
        assertEquals("110101199001011234", output.getDocumentId());
        assertEquals(DocumentType.VALUE_110001, output.getDocumentType());
        assertEquals(IssCountry.CHN, output.getIssCountry());
    }

    // 场景：ST013-TC003（REQ-005-S03）：ST036 返回「授权」（dealFlow=A），返回授权标志「是」，不返回 ER0003；
    // succeed 取值与授权等待编排按 TBD-3 未定义，本分支不断言 isSucceed
    @Test
    void testST013T03() {
        stubFirstTwoSteps();
        lenient().when(ist036.execute(any(ST036InputBO.class)))
                .thenReturn(buildSt036Output(DealFlow.A));

        ST013OutputBO output = st013Pbc.execute(buildInput());

        assertEquals("是", output.getAuthFlag());
        assertNull(output.getErrorCode());
    }

    // 场景：ST013-TC004（REQ-005-S04）：ST036 返回「拒绝」（dealFlow=B），步骤业务失败返回错误码 ER0003
    @Test
    void testST013T04() {
        stubFirstTwoSteps();
        lenient().when(ist036.execute(any(ST036InputBO.class)))
                .thenReturn(buildSt036Output(DealFlow.B));

        ST013OutputBO output = st013Pbc.execute(buildInput());

        assertFalse(output.isSucceed());
        assertEquals("ER0003", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().startsWith("ER0003::"));
        assertTrue(output.getErrorMessage().contains("黑名单客户，拒绝交易"));
    }

    // 场景：ST013-TC005（REQ-004-S01）：捕获实际传入 ST036 的输入，逐字段断言 11 项明确映射取值；
    // acctBranch/{交易机构}、clientName/issCountry 无对应字段、programId/blacklistCheckFlag/serviceStatus 取值来源按 TBD-2 未确认，不断言
    @Test
    void testST013T05() {
        stubFirstTwoSteps();
        lenient().when(ist036.execute(any(ST036InputBO.class)))
                .thenAnswer(invocation -> {
                    capturedSt036Input = invocation.getArgument(0);
                    return buildSt036Output(null);
                });

        ST013OutputBO output = st013Pbc.execute(buildInput());

        assertTrue(output.isSucceed());
        assertNotNull(capturedSt036Input);
        assertEquals("1000000002", capturedSt036Input.getBaseAcctNo());
        assertEquals("C000000001", capturedSt036Input.getClientNo());
        assertEquals(TranType.VALUE_31, capturedSt036Input.getTranType());
        assertEquals(SourceType.CC, capturedSt036Input.getSourceType());
        assertEquals("CRET", capturedSt036Input.getEventType());
        assertEquals("SVC0001", capturedSt036Input.getServiceCode());
        assertEquals("TRD", capturedSt036Input.getMessageType());
        assertEquals("CIFDP0001", capturedSt036Input.getMessageCode());
        assertEquals(DocClass.DCT, capturedSt036Input.getDocClass());
        assertEquals(DocumentType.VALUE_110001, capturedSt036Input.getDocumentType());
        assertEquals("110101199001011234", capturedSt036Input.getDocumentId());
    }

    /**
     * 构造 ST013-TC001~TC005 公共输入：按测试用例 inputConstruction 赋值。
     */
    private ST013InputBO buildInput() {
        ST013InputBO input = new ST013InputBO();
        input.setOthClientNo("C000000001");
        input.setDocType(DocType.VALUE_737);
        input.setOthBaseAcctNo("1000000002");
        input.setTranBranch(TranBranch.VALUE_351155);
        input.setTranType(TranType.VALUE_31);
        input.setServiceCode("SVC0001");
        input.setMessageCode("CIFDP0001");
        input.setMessageType("TRD");
        input.setSourceType(SourceType.CC);
        return input;
    }

    /**
     * 第 1、2 步查询桩：客户证件信息返回 clientName/documentType/documentId/issCountry，
     * 凭证类型定义表返回 docClass。按 othClientNo 定位记录的实际查询键与方法见 TBD-1，桩不猜测方法。
     */
    private void stubFirstTwoSteps() {
        FmClientCopyEO clientCopy = new FmClientCopyEO();
        clientCopy.setClientName("示例客户");
        clientCopy.setDocumentType(DocumentType.VALUE_110001);
        clientCopy.setDocumentId("110101199001011234");
        clientCopy.setIssCountry(IssCountry.CHN);
        lenient().when(ifmClientCopyBcc.findByEo(any(FmClientCopyEO.class)))
                .thenReturn(List.of(clientCopy));

        TbVoucherDefEO voucherDef = new TbVoucherDefEO();
        voucherDef.setDocClass(DocClass.DCT);
        lenient().when(itbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(voucherDef);
    }

    /**
     * 构造 ST036 步骤输出桩：succeed=true、错误字段为空、dealFlow 取传入值（「通过」不设置 dealFlow）。
     */
    private ST036OutputBO buildSt036Output(DealFlow dealFlow) {
        ST036OutputBO st036Output = new ST036OutputBO();
        st036Output.setSucceed(true);
        st036Output.setDealFlow(dealFlow);
        return st036Output;
    }
}
