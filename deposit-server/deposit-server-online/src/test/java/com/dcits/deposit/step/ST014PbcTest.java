package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.facade.bo.ST014InputBO;
import com.dcits.deposit.facade.bo.ST014OutputBO;
import com.dcits.deposit.facade.components.IRbCommissionRegisterBcc;
import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST014 登记代办人信息 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST014-TC001 ~ ST014-TC004）
 */
@ExtendWith(MockitoExtension.class)
public class ST014PbcTest {

    @Mock
    private IRbCommissionRegisterBcc rbCommissionRegisterBcc;

    @InjectMocks
    private ST014Pbc st014Pbc;

    // 正常路径：代办人名称非空，携带全部字段（含全部非必填项）登记代办人信息，走完整登记路径，输出16字段回显
    @Test
    public void testST014T01() {
        ST014InputBO input = new ST014InputBO();
        input.setReference("REF20260924-0001");
        input.setCommissionClientName("张伟");
        input.setCommissionClientNo("C20260924-0001");
        input.setCommissionDocumentId("110101199001011234");
        input.setCommissionDocumentType(DocumentType.VALUE_110001);
        input.setCountry(IssCountry.CHN);
        Date startDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 1).getTime();
        Date expireDate = new GregorianCalendar(2036, Calendar.AUGUST, 31).getTime();
        input.setCommissionStartDate(startDate);
        input.setCommissionExpireDate(expireDate);
        input.setCommissionClientTel("13800138000");
        input.setCommissionReason("客户腿部骨折行动不便");
        input.setCommissionRelation(CommissionRelation.VALUE_1);
        input.setCommissionConfirmUserIdKey1("E1001");
        input.setCommissionConfirmUserIdKey2("E1002");
        input.setCommissionConfirmTel("13900139000");
        input.setCommissionConfirmTime("2026-09-24 10:30:00");
        input.setCommissionConfirmResult("核实一致");
        input.setClientNo("C000123456");
        input.setInternalKey(1001);
        input.setChannelSeqNo("SEQ20260924-0001");

        ArgumentCaptor<RbCommissionRegisterEO> eoCaptor = ArgumentCaptor.forClass(RbCommissionRegisterEO.class);
        lenient().when(rbCommissionRegisterBcc.createSelective(eoCaptor.capture())).thenReturn(1);

        ST014OutputBO output = st014Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        RbCommissionRegisterEO eo = eoCaptor.getValue();
        assertEquals("C20260924-0001", eo.getCommissionClientNo());
        assertEquals("张伟", eo.getCommissionClientName());
        assertEquals(DocumentType.VALUE_110001, eo.getCommissionDocumentType());
        assertEquals("110101199001011234", eo.getCommissionDocumentId());
        assertEquals(startDate, eo.getCommissionStartDate());
        assertEquals(expireDate, eo.getCommissionExpireDate());
        assertEquals("13800138000", eo.getCommissionClientTel());
        assertEquals(IssCountry.CHN, eo.getCountry());
        assertEquals(CommissionRelation.VALUE_1, eo.getCommissionRelation());
        assertEquals("核实一致", eo.getCommissionConfirmResult());
        assertEquals("13900139000", eo.getCommissionConfirmTel());
        assertEquals("2026-09-24 10:30:00", eo.getCommissionConfirmTime());
        assertEquals("E1001", eo.getCommissionConfirmUserIdKey1());
        assertEquals("E1002", eo.getCommissionConfirmUserIdKey2());
        assertEquals("SEQ20260924-0001", eo.getChannelSeqNo());
        assertEquals("C000123456", eo.getClientNo());
        assertEquals(Integer.valueOf(1001), eo.getInternalKey());
        assertNotNull(eo.getCreateTimestamp());
        assertNotNull(eo.getLastUpdTimestamp());
        assertEquals("REF20260924-0001", output.getReference());
        assertEquals("张伟", output.getCommissionClientName());
        assertEquals("C20260924-0001", output.getCommissionClientNo());
        assertEquals("110101199001011234", output.getCommissionDocumentId());
        assertEquals(DocumentType.VALUE_110001, output.getCommissionDocumentType());
        assertEquals(IssCountry.CHN, output.getCountry());
        assertEquals(startDate, output.getCommissionStartDate());
        assertEquals(expireDate, output.getCommissionExpireDate());
        assertEquals("13800138000", output.getCommissionClientTel());
        assertEquals("客户腿部骨折行动不便", output.getCommissionReason());
        assertEquals(CommissionRelation.VALUE_1, output.getCommissionRelation());
        assertEquals("E1001", output.getCommissionConfirmUserIdKey1());
        assertEquals("E1002", output.getCommissionConfirmUserIdKey2());
        assertEquals("13900139000", output.getCommissionConfirmTel());
        assertEquals("2026-09-24 10:30:00", output.getCommissionConfirmTime());
        assertEquals("核实一致", output.getCommissionConfirmResult());
    }

    // 正常路径：代办人名称非空、仅提供必填字段（非必填字段合法为 null），登记成功，验证非空属性写入
    @Test
    public void testST014T02() {
        ST014InputBO input = new ST014InputBO();
        input.setReference("REF20260924-0002");
        input.setCommissionClientName("李娜");
        input.setCommissionClientNo(null);
        input.setCommissionDocumentId("810000199001011234");
        input.setCommissionDocumentType(DocumentType.VALUE_120000);
        input.setCountry(IssCountry.HKG);
        Date startDate = new GregorianCalendar(2026, Calendar.SEPTEMBER, 10).getTime();
        Date expireDate = new GregorianCalendar(2029, Calendar.SEPTEMBER, 9).getTime();
        input.setCommissionStartDate(startDate);
        input.setCommissionExpireDate(expireDate);
        input.setCommissionClientTel("13800138001");
        input.setCommissionReason(null);
        input.setCommissionRelation(null);
        input.setCommissionConfirmUserIdKey1(null);
        input.setCommissionConfirmUserIdKey2(null);
        input.setCommissionConfirmTel(null);
        input.setCommissionConfirmTime(null);
        input.setCommissionConfirmResult(null);
        input.setClientNo("C000123457");
        input.setInternalKey(2002);
        input.setChannelSeqNo("SEQ20260924-0002");

        ArgumentCaptor<RbCommissionRegisterEO> eoCaptor = ArgumentCaptor.forClass(RbCommissionRegisterEO.class);
        lenient().when(rbCommissionRegisterBcc.createSelective(eoCaptor.capture())).thenReturn(1);

        ST014OutputBO output = st014Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        RbCommissionRegisterEO eo = eoCaptor.getValue();
        assertEquals("李娜", eo.getCommissionClientName());
        assertNull(eo.getCommissionClientNo());
        assertEquals(DocumentType.VALUE_120000, eo.getCommissionDocumentType());
        assertEquals("810000199001011234", eo.getCommissionDocumentId());
        assertEquals(IssCountry.HKG, eo.getCountry());
        assertEquals(startDate, eo.getCommissionStartDate());
        assertEquals(expireDate, eo.getCommissionExpireDate());
        assertEquals("13800138001", eo.getCommissionClientTel());
        assertNull(eo.getCommissionRelation());
        assertNull(eo.getCommissionConfirmUserIdKey1());
        assertNull(eo.getCommissionConfirmUserIdKey2());
        assertNull(eo.getCommissionConfirmTel());
        assertNull(eo.getCommissionConfirmTime());
        assertNull(eo.getCommissionConfirmResult());
        assertEquals("SEQ20260924-0002", eo.getChannelSeqNo());
        assertEquals("C000123457", eo.getClientNo());
        assertEquals(Integer.valueOf(2002), eo.getInternalKey());
        assertNotNull(eo.getCreateTimestamp());
        assertNotNull(eo.getLastUpdTimestamp());
        assertEquals("REF20260924-0002", output.getReference());
        assertEquals("李娜", output.getCommissionClientName());
        assertNull(output.getCommissionClientNo());
        assertEquals("810000199001011234", output.getCommissionDocumentId());
        assertEquals(DocumentType.VALUE_120000, output.getCommissionDocumentType());
        assertEquals(IssCountry.HKG, output.getCountry());
        assertEquals(startDate, output.getCommissionStartDate());
        assertEquals(expireDate, output.getCommissionExpireDate());
        assertEquals("13800138001", output.getCommissionClientTel());
        assertNull(output.getCommissionReason());
        assertNull(output.getCommissionRelation());
        assertNull(output.getCommissionConfirmUserIdKey1());
        assertNull(output.getCommissionConfirmUserIdKey2());
        assertNull(output.getCommissionConfirmTel());
        assertNull(output.getCommissionConfirmTime());
        assertNull(output.getCommissionConfirmResult());
    }

    // 边界否定路径：代办人名称为 null，条件"不为空"不成立，跳过登记，步骤正常成功返回，输出业务字段均为 null
    @Test
    public void testST014T03() {
        ST014InputBO input = new ST014InputBO();
        input.setReference("REF20260924-0003");
        input.setCommissionClientName(null);
        input.setCommissionClientNo("C20260924-0001");
        input.setCommissionDocumentId("110101199001011234");
        input.setCommissionDocumentType(DocumentType.VALUE_110001);
        input.setCountry(IssCountry.CHN);
        input.setCommissionStartDate(new GregorianCalendar(2026, Calendar.SEPTEMBER, 1).getTime());
        input.setCommissionExpireDate(new GregorianCalendar(2036, Calendar.AUGUST, 31).getTime());
        input.setCommissionClientTel("13800138000");
        input.setCommissionReason("客户腿部骨折行动不便");
        input.setCommissionRelation(CommissionRelation.VALUE_1);
        input.setCommissionConfirmUserIdKey1("E1001");
        input.setCommissionConfirmUserIdKey2("E1002");
        input.setCommissionConfirmTel("13900139000");
        input.setCommissionConfirmTime("2026-09-24 10:30:00");
        input.setCommissionConfirmResult("核实一致");
        input.setClientNo("C000123456");
        input.setInternalKey(1001);
        input.setChannelSeqNo("SEQ20260924-0003");

        ST014OutputBO output = st014Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getReference());
        assertNull(output.getCommissionClientName());
        assertNull(output.getCommissionClientNo());
        assertNull(output.getCommissionDocumentId());
        assertNull(output.getCommissionDocumentType());
        assertNull(output.getCountry());
        assertNull(output.getCommissionStartDate());
        assertNull(output.getCommissionExpireDate());
        assertNull(output.getCommissionClientTel());
        assertNull(output.getCommissionReason());
        assertNull(output.getCommissionRelation());
        assertNull(output.getCommissionConfirmUserIdKey1());
        assertNull(output.getCommissionConfirmUserIdKey2());
        assertNull(output.getCommissionConfirmTel());
        assertNull(output.getCommissionConfirmTime());
        assertNull(output.getCommissionConfirmResult());
    }

    // 边界否定路径：代办人名称为空字符串，空值口径含空串，条件"不为空"不成立，跳过登记，步骤正常成功返回
    @Test
    public void testST014T04() {
        ST014InputBO input = new ST014InputBO();
        input.setReference("REF20260924-0004");
        input.setCommissionClientName("");
        input.setCommissionClientNo("C20260924-0001");
        input.setCommissionDocumentId("110101199001011234");
        input.setCommissionDocumentType(DocumentType.VALUE_110001);
        input.setCountry(IssCountry.CHN);
        input.setCommissionStartDate(new GregorianCalendar(2026, Calendar.SEPTEMBER, 1).getTime());
        input.setCommissionExpireDate(new GregorianCalendar(2036, Calendar.AUGUST, 31).getTime());
        input.setCommissionClientTel("13800138000");
        input.setCommissionReason("客户腿部骨折行动不便");
        input.setCommissionRelation(CommissionRelation.VALUE_1);
        input.setCommissionConfirmUserIdKey1("E1001");
        input.setCommissionConfirmUserIdKey2("E1002");
        input.setCommissionConfirmTel("13900139000");
        input.setCommissionConfirmTime("2026-09-24 10:30:00");
        input.setCommissionConfirmResult("核实一致");
        input.setClientNo("C000123456");
        input.setInternalKey(1001);
        input.setChannelSeqNo("SEQ20260924-0004");

        ST014OutputBO output = st014Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getReference());
        assertNull(output.getCommissionClientName());
        assertNull(output.getCommissionClientNo());
        assertNull(output.getCommissionDocumentId());
        assertNull(output.getCommissionDocumentType());
        assertNull(output.getCountry());
        assertNull(output.getCommissionStartDate());
        assertNull(output.getCommissionExpireDate());
        assertNull(output.getCommissionClientTel());
        assertNull(output.getCommissionReason());
        assertNull(output.getCommissionRelation());
        assertNull(output.getCommissionConfirmUserIdKey1());
        assertNull(output.getCommissionConfirmUserIdKey2());
        assertNull(output.getCommissionConfirmTel());
        assertNull(output.getCommissionConfirmTime());
        assertNull(output.getCommissionConfirmResult());
    }
}
