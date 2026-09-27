package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST046 登记账户信息 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST046-TC001 ~ ST046-TC004）
 *
 * 本步骤唯一路径为登记 RB_BUS_ACCT，依赖 IRbBusAcctBcc 设桩；
 * SPEC 声明无业务失败场景，无错误码可断言。
 */
@ExtendWith(MockitoExtension.class)
public class ST046PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST046Pbc st046Pbc;

    /** 构造 ST046-TC001 基准输入（全量取值），其余用例按差异覆盖 */
    private ST046InputBO buildBaseInput() {
        ST046InputBO input = new ST046InputBO();
        input.setAllowSuspendFlag("Y");
        input.setManageFlag("是");
        input.setManageContent("预售房交易资金纳入监管");
        input.setManageType(ManageType.VALUE_1);
        input.setAnnualFlag("Y");
        input.setSimpleAcct(SimpleAcct.N);
        input.setFarmerFlag(FarmerFlag.VALUE_2);
        input.setIsSellCheque("Y");
        input.setLineOwnerShip("公司金融条线");
        input.setAcctExecName("张三");
        input.setAcctExecCode("E2001234");
        input.setPromoterName("李四");
        input.setPromoterCode("P2005678");
        input.setCheckCertificateAmt(new BigDecimal("500000.00"));
        input.setClientNo("C1002345678");
        input.setBaseAcctNo("1100100020034567");
        input.setAcctCcy(AcctCcy.CNY);
        input.setProdNo("P0010001");
        input.setTranBranch(TranBranch.VALUE_351155);
        input.setAcctOpenDate(new GregorianCalendar(2026, Calendar.SEPTEMBER, 24).getTime());
        input.setEffectDate(new GregorianCalendar(2026, Calendar.SEPTEMBER, 25).getTime());
        input.setRbAcctType(RbAcctType.C);
        input.setAcctStatus(AcctStatus.N);
        input.setAllDepInd(AllDepInd.N001);
        input.setAllDraInd(AllDraInd.N001);
        input.setAcctNatureNo(AcctNatureNo.VALUE_11001);
        input.setIntIndFlag(IntIndFlag.Y);
        input.setAcctLicenseNo("20260001234");
        input.setApprLetterNo("HZ2026000045");
        input.setCheckCertificateType(CheckCertificateType.VALUE_03);
        return input;
    }

    /** 成功三项断言：succeed=true、errorCode/errorMessage=null */
    private void assertSucceed(ST046OutputBO result) {
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    /** 捕获 EO 的子步骤1 无条件登记字段（含查证类型无条件补登记）逐一 equals 输入 */
    private void assertEoUnconditionalFields(RbBusAcctEO eo, ST046InputBO input) {
        assertEquals(input.getAllowSuspendFlag(), eo.getAllowSuspendFlag());
        assertEquals(input.getManageFlag(), eo.getManageFlag());
        assertEquals(input.getAnnualFlag(), eo.getAnnualFlag());
        assertEquals(input.getSimpleAcct(), eo.getSimpleAcct());
        assertEquals(input.getFarmerFlag(), eo.getFarmerFlag());
        assertEquals(input.getIsSellCheque(), eo.getIsSellCheque());
        assertEquals(input.getLineOwnerShip(), eo.getLineOwnerShip());
        assertEquals(input.getAcctExecName(), eo.getAcctExecName());
        assertEquals(input.getAcctExecCode(), eo.getAcctExecCode());
        assertEquals(input.getPromoterName(), eo.getPromoterName());
        assertEquals(input.getPromoterCode(), eo.getPromoterCode());
        assertEquals(input.getCheckCertificateType(), eo.getCheckCertificateType());
    }

    /** 捕获 EO 的子步骤2 基本信息字段：15 项输入映射（tranBranch→acctBranch）逐一 equals，键值与时间戳仅断言非空非空串 */
    private void assertEoBasicInfo(RbBusAcctEO eo, ST046InputBO input) {
        assertNotNull(eo.getInternalKey());
        assertEquals(input.getClientNo(), eo.getClientNo());
        assertEquals(input.getBaseAcctNo(), eo.getBaseAcctNo());
        assertEquals(input.getAcctCcy(), eo.getAcctCcy());
        assertEquals(input.getProdNo(), eo.getProdNo());
        assertEquals(input.getTranBranch(), eo.getAcctBranch());
        assertEquals(input.getAcctOpenDate(), eo.getAcctOpenDate());
        assertEquals(input.getAcctStatus(), eo.getAcctStatus());
        assertEquals(input.getRbAcctType(), eo.getRbAcctType());
        assertEquals(input.getAllDepInd(), eo.getAllDepInd());
        assertEquals(input.getAllDraInd(), eo.getAllDraInd());
        assertEquals(input.getAcctNatureNo(), eo.getAcctNatureNo());
        assertNotNull(eo.getCreateTimestamp());
        assertFalse(eo.getCreateTimestamp().isEmpty());
        assertNotNull(eo.getLastUpdTimestamp());
        assertFalse(eo.getLastUpdTimestamp().isEmpty());
        assertEquals(input.getIntIndFlag(), eo.getIntIndFlag());
        assertEquals(input.getApprLetterNo(), eo.getApprLetterNo());
        assertEquals(input.getEffectDate(), eo.getEffectDate());
        assertEquals(input.getAcctLicenseNo(), eo.getAcctLicenseNo());
    }

    /** 输出 BO 的无条件回显字段（除 manageType/manageContent/checkCertificateAmt 外的 26 项）逐一 equals 输入 */
    private void assertOutputUnconditionalFields(ST046OutputBO result, ST046InputBO input) {
        assertEquals(input.getAllowSuspendFlag(), result.getAllowSuspendFlag());
        assertEquals(input.getManageFlag(), result.getManageFlag());
        assertEquals(input.getAnnualFlag(), result.getAnnualFlag());
        assertEquals(input.getSimpleAcct(), result.getSimpleAcct());
        assertEquals(input.getFarmerFlag(), result.getFarmerFlag());
        assertEquals(input.getIsSellCheque(), result.getIsSellCheque());
        assertEquals(input.getLineOwnerShip(), result.getLineOwnerShip());
        assertEquals(input.getAcctExecName(), result.getAcctExecName());
        assertEquals(input.getAcctExecCode(), result.getAcctExecCode());
        assertEquals(input.getPromoterName(), result.getPromoterName());
        assertEquals(input.getPromoterCode(), result.getPromoterCode());
        assertEquals(input.getCheckCertificateType(), result.getCheckCertificateType());
        assertEquals(input.getClientNo(), result.getClientNo());
        assertEquals(input.getBaseAcctNo(), result.getBaseAcctNo());
        assertEquals(input.getProdNo(), result.getProdNo());
        assertEquals(input.getAcctCcy(), result.getAcctCcy());
        assertEquals(input.getAcctOpenDate(), result.getAcctOpenDate());
        assertEquals(input.getEffectDate(), result.getEffectDate());
        assertEquals(input.getAcctStatus(), result.getAcctStatus());
        assertEquals(input.getRbAcctType(), result.getRbAcctType());
        assertEquals(input.getAcctNatureNo(), result.getAcctNatureNo());
        assertEquals(input.getAllDraInd(), result.getAllDraInd());
        assertEquals(input.getAllDepInd(), result.getAllDepInd());
        assertEquals(input.getAcctLicenseNo(), result.getAcctLicenseNo());
        assertEquals(input.getIntIndFlag(), result.getIntIndFlag());
        assertEquals(input.getApprLetterNo(), result.getApprLetterNo());
    }

    // TC001 场景：开户登记全量成功（P1）：监管账户标志为"是"、查证类型为对资金类业务查证，两处条件登记均执行，全部非必填输入给值
    @Test
    public void testST046T01() {
        final RbBusAcctEO[] capturedEo = new RbBusAcctEO[1];
        Mockito.lenient().when(rbBusAcctBcc.createSelective(Mockito.any(RbBusAcctEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo[0] = invocation.getArgument(0);
                    return 1;
                });
        ST046InputBO input = buildBaseInput();

        ST046OutputBO result = st046Pbc.execute(input);

        assertSucceed(result);
        assertEoUnconditionalFields(capturedEo[0], input);
        assertEoBasicInfo(capturedEo[0], input);
        assertEquals(ManageType.VALUE_1, capturedEo[0].getManageType());
        assertEquals("预售房交易资金纳入监管", capturedEo[0].getManageContent());
        assertEquals(0, capturedEo[0].getCheckCertificateAmt().compareTo(new BigDecimal("500000.00")));
        assertOutputUnconditionalFields(result, input);
        assertEquals(ManageType.VALUE_1, result.getManageType());
        assertEquals("预售房交易资金纳入监管", result.getManageContent());
        assertEquals(0, result.getCheckCertificateAmt().compareTo(new BigDecimal("500000.00")));
    }

    // TC002 场景：双条件均不成立（P2）：监管账户标志为"否"、查证类型为免查证，manageType/manageContent/checkCertificateAmt 提供但不登记
    @Test
    public void testST046T02() {
        final RbBusAcctEO[] capturedEo = new RbBusAcctEO[1];
        Mockito.lenient().when(rbBusAcctBcc.createSelective(Mockito.any(RbBusAcctEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo[0] = invocation.getArgument(0);
                    return 1;
                });
        ST046InputBO input = buildBaseInput();
        input.setManageFlag("否");
        input.setCheckCertificateType(CheckCertificateType.VALUE_04);
        input.setCheckCertificateAmt(new BigDecimal("12345.67"));

        ST046OutputBO result = st046Pbc.execute(input);

        assertSucceed(result);
        assertEoUnconditionalFields(capturedEo[0], input);
        assertEoBasicInfo(capturedEo[0], input);
        assertNull(capturedEo[0].getManageType());
        assertNull(capturedEo[0].getManageContent());
        assertNull(capturedEo[0].getCheckCertificateAmt());
        assertOutputUnconditionalFields(result, input);
        assertNull(result.getManageType());
        assertNull(result.getManageContent());
        assertNull(result.getCheckCertificateAmt());
    }

    // TC003 场景：仅监管条件成立（P3）：查证类型为对非资金类业务查证，查证金额提供但不登记，监管类型与监管原因正常登记
    @Test
    public void testST046T03() {
        final RbBusAcctEO[] capturedEo = new RbBusAcctEO[1];
        Mockito.lenient().when(rbBusAcctBcc.createSelective(Mockito.any(RbBusAcctEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo[0] = invocation.getArgument(0);
                    return 1;
                });
        ST046InputBO input = buildBaseInput();
        input.setCheckCertificateType(CheckCertificateType.VALUE_02);
        input.setCheckCertificateAmt(new BigDecimal("88888.88"));

        ST046OutputBO result = st046Pbc.execute(input);

        assertSucceed(result);
        assertEoUnconditionalFields(capturedEo[0], input);
        assertEoBasicInfo(capturedEo[0], input);
        assertEquals(ManageType.VALUE_1, capturedEo[0].getManageType());
        assertEquals("预售房交易资金纳入监管", capturedEo[0].getManageContent());
        assertNull(capturedEo[0].getCheckCertificateAmt());
        assertOutputUnconditionalFields(result, input);
        assertEquals(ManageType.VALUE_1, result.getManageType());
        assertEquals("预售房交易资金纳入监管", result.getManageContent());
        assertNull(result.getCheckCertificateAmt());
    }

    // TC004 场景：仅查证条件成立且非必填空值（P4）：监管账户标志为"否"不登记监管字段，查证金额零值边界 0.00 正常登记，6 项非必填输入合法为 null
    @Test
    public void testST046T04() {
        final RbBusAcctEO[] capturedEo = new RbBusAcctEO[1];
        Mockito.lenient().when(rbBusAcctBcc.createSelective(Mockito.any(RbBusAcctEO.class)))
                .thenAnswer(invocation -> {
                    capturedEo[0] = invocation.getArgument(0);
                    return 1;
                });
        ST046InputBO input = buildBaseInput();
        input.setManageFlag("否");
        input.setCheckCertificateAmt(new BigDecimal("0.00"));
        input.setLineOwnerShip(null);
        input.setAcctExecName(null);
        input.setAcctExecCode(null);
        input.setPromoterName(null);
        input.setPromoterCode(null);
        input.setApprLetterNo(null);

        ST046OutputBO result = st046Pbc.execute(input);

        assertSucceed(result);
        assertEoUnconditionalFields(capturedEo[0], input);
        assertEoBasicInfo(capturedEo[0], input);
        assertNull(capturedEo[0].getManageType());
        assertNull(capturedEo[0].getManageContent());
        assertEquals(0, capturedEo[0].getCheckCertificateAmt().compareTo(new BigDecimal("0.00")));
        assertNull(capturedEo[0].getLineOwnerShip());
        assertNull(capturedEo[0].getAcctExecName());
        assertNull(capturedEo[0].getAcctExecCode());
        assertNull(capturedEo[0].getPromoterName());
        assertNull(capturedEo[0].getPromoterCode());
        assertNull(capturedEo[0].getApprLetterNo());
        assertOutputUnconditionalFields(result, input);
        assertNull(result.getManageType());
        assertNull(result.getManageContent());
        assertEquals(0, result.getCheckCertificateAmt().compareTo(new BigDecimal("0.00")));
        assertNull(result.getLineOwnerShip());
        assertNull(result.getAcctExecName());
        assertNull(result.getAcctExecCode());
        assertNull(result.getPromoterName());
        assertNull(result.getPromoterCode());
        assertNull(result.getApprLetterNo());
    }
}
