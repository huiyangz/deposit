package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.facade.bo.ST023InputBO;
import com.dcits.deposit.facade.bo.ST023OutputBO;
import com.dcits.deposit.facade.components.IRbCommissionRegisterBcc;
import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST023 登记代办人信息 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01（ST023-TC001，数组非空单条登记全部 16 字段）与
 * REQ-002-S01（ST023-TC002，数组为空不登记正常成功结束）。必填校验失败、数组多元素、
 * 数组元素含空值等行为无已确认预期（Spec 待确认事项 1/2/4），不作为本套用例断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST023PbcTest {

    @Mock
    private IRbCommissionRegisterBcc rbCommissionRegisterBcc;

    @InjectMocks
    private ST023Pbc st023Pbc;

    // 场景：REQ-001-S01（ST023-TC001），代办人信息数组非空（单条），登记 16 个字段并成功返回登记结果
    @Test
    void testST023T01() {
        ST023InputBO input = new ST023InputBO();
        input.setReference("REF20261031001");
        input.setCommissionClientName("张三");
        input.setCommissionClientNo("C0001");
        input.setCommissionDocumentId("110101199001010011");
        input.setCommissionDocumentType(DocumentType.VALUE_110001);
        input.setCountry(IssCountry.CHN);
        input.setCommissionStartDate(date(2020, 1, 1));
        input.setCommissionExpireDate(date(2030, 12, 31));
        input.setCommissionClientTel("13800138000");
        input.setCommissionReason("代亲属办理");
        input.setCommissionRelation(CommissionRelation.VALUE_1);
        input.setCommissionConfirmUserIdKey1("U1001");
        input.setCommissionConfirmUserIdKey2("U1002");
        input.setCommissionConfirmTel("13800138000");
        input.setCommissionConfirmTime("20261031103000");
        input.setCommissionConfirmResult("已核实");

        AtomicReference<RbCommissionRegisterEO> captured = new AtomicReference<>();
        lenient().when(rbCommissionRegisterBcc.create(any(RbCommissionRegisterEO.class)))
                .thenAnswer(invocation -> {
                    captured.set(invocation.getArgument(0));
                    return 1;
                });

        ST023OutputBO output = st023Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());

        RbCommissionRegisterEO eo = captured.get();
        assertEquals("REF20261031001", eo.getReference());
        assertEquals("张三", eo.getCommissionClientName());
        assertEquals("C0001", eo.getCommissionClientNo());
        assertEquals("110101199001010011", eo.getCommissionDocumentId());
        assertEquals(DocumentType.VALUE_110001, eo.getCommissionDocumentType());
        assertEquals(IssCountry.CHN, eo.getCountry());
        assertEquals(input.getCommissionStartDate(), eo.getCommissionStartDate());
        assertEquals(input.getCommissionExpireDate(), eo.getCommissionExpireDate());
        assertEquals("13800138000", eo.getCommissionClientTel());
        assertEquals("代亲属办理", eo.getCommissionReason());
        assertEquals(CommissionRelation.VALUE_1, eo.getCommissionRelation());
        assertEquals("U1001", eo.getCommissionConfirmUserIdKey1());
        assertEquals("U1002", eo.getCommissionConfirmUserIdKey2());
        assertEquals("13800138000", eo.getCommissionConfirmTel());
        assertEquals("20261031103000", eo.getCommissionConfirmTime());
        assertEquals("已核实", eo.getCommissionConfirmResult());

        assertEquals(eo.getReference(), output.getReference());
        assertEquals(eo.getCommissionClientName(), output.getCommissionClientName());
        assertEquals(eo.getCommissionClientNo(), output.getCommissionClientNo());
        assertEquals(eo.getCommissionDocumentId(), output.getCommissionDocumentId());
        assertEquals(eo.getCommissionDocumentType(), output.getCommissionDocumentType());
        assertEquals(eo.getCountry(), output.getCountry());
        assertEquals(eo.getCommissionStartDate(), output.getCommissionStartDate());
        assertEquals(eo.getCommissionExpireDate(), output.getCommissionExpireDate());
        assertEquals(eo.getCommissionClientTel(), output.getCommissionClientTel());
        assertEquals(eo.getCommissionReason(), output.getCommissionReason());
        assertEquals(eo.getCommissionRelation(), output.getCommissionRelation());
        assertEquals(eo.getCommissionConfirmUserIdKey1(), output.getCommissionConfirmUserIdKey1());
        assertEquals(eo.getCommissionConfirmUserIdKey2(), output.getCommissionConfirmUserIdKey2());
        assertEquals(eo.getCommissionConfirmTel(), output.getCommissionConfirmTel());
        assertEquals(eo.getCommissionConfirmTime(), output.getCommissionConfirmTime());
        assertEquals(eo.getCommissionConfirmResult(), output.getCommissionConfirmResult());
    }

    // 场景：REQ-002-S01（ST023-TC002），代办人信息数组为空，不登记、不新增记录，正常成功结束
    @Test
    void testST023T02() {
        ST023InputBO input = new ST023InputBO();

        ST023OutputBO output = st023Pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getReference());
    }

    private Date date(int year, int month, int day) {
        return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
