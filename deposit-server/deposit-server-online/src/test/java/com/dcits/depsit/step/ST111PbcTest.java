package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.facade.bo.ST111InputBO;
import com.dcits.depsit.facade.bo.ST111OutputBO;
import com.dcits.depsit.facade.components.IRbClientRestraintsBcc;
import com.dcits.depsit.facade.eo.RbClientRestraintsEO;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST111 检查客户是否存在限制 —— 单元测试。
 *
 * <p>调用签名：{@code ST111OutputBO execute(ST111InputBO input)}。用例依据本轮正式 Spec 与
 * {@code outputs/测试用例.md}／{@code .json} 的 8 个用例设计：命中路径（单条 / 多条取首 / 取首
 * 与返回顺序无关）、查询结果为空路径（无任何记录 / 记录状态均非 {@code "A"}）、空结果仍返回
 * 客户限制信息，以及输出字段集合与类型契约。</p>
 *
 * <p>{@link IRbClientRestraintsBcc#findByEo(RbClientRestraintsEO)} 统一设「按入参 EO 过滤」的
 * 应答式桩：以入参 EO 的 {@code clientNo} 过滤夹具，入参 EO 的 {@code restraintsStatus} 非空时
 * 再按该状态相等过滤。该桩既能验证入参 {@code clientNo} 被真实用于取数，也不对实现是「条件下推」
 * 还是「取回后过滤」作越界约束。按技能约定不使用 {@code verify}／{@code never}／{@code times}／
 * {@code InOrder} 验证交互，不模拟技术异常。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST111PbcTest {

    @Mock
    private IRbClientRestraintsBcc irRbClientRestraintsBcc;

    @InjectMocks
    private ST111Pbc st111Pbc;

    // ST111-TC001：REQ-001-S01、REQ-004-S01、REQ-005-S01 —— 按 clientNo 查到 1 条生效限制记录，
    // 子步骤 1 取该条三字段，子步骤 2 赋值客户限制信息并返回，执行成功
    @Test
    void testST111T01() {
        stubFindByEoFiltered(List.of(restraint("C202610100001", "R202610100001", RestraintType.VALUE_13, RestraintsStatus.A)));

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100001");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("R202610100001", result.getResSeqNo());
        assertSame(RestraintType.VALUE_13, result.getRestraintType());
        assertSame(RestraintsStatus.A, result.getRestraintsStatus());
    }

    // ST111-TC002：REQ-001-S02 —— 2 条状态 A 记录 + 1 条状态 E 记录（E 记录限制编号最小，
    // 若未按状态过滤将回显该条），非 A 记录不进入结果，取 A 集合限制编号升序第一条
    @Test
    void testST111T02() {
        stubFindByEoFiltered(List.of(
                restraint("C202610100001", "R202610100001", RestraintType.VALUE_13, RestraintsStatus.A),
                restraint("C202610100001", "R202610100002", RestraintType.VALUE_22, RestraintsStatus.A),
                restraint("C202610100001", "R202610100000", RestraintType.VALUE_68, RestraintsStatus.E)));

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100001");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertEquals("R202610100001", result.getResSeqNo());
        assertSame(RestraintType.VALUE_13, result.getRestraintType());
        assertSame(RestraintsStatus.A, result.getRestraintsStatus());
    }

    // ST111-TC003：REQ-003-S01 —— 3 条状态 A 记录，返回顺序为 003→001→002，
    // 按限制编号升序取第一条 R202610100001 并回显该条三字段，不回显 003／002
    @Test
    void testST111T03() {
        stubFindByEoFiltered(List.of(
                restraint("C202610100001", "R202610100003", RestraintType.VALUE_68, RestraintsStatus.A),
                restraint("C202610100001", "R202610100001", RestraintType.VALUE_13, RestraintsStatus.A),
                restraint("C202610100001", "R202610100002", RestraintType.VALUE_22, RestraintsStatus.A)));

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100001");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertEquals("R202610100001", result.getResSeqNo());
        assertSame(RestraintType.VALUE_13, result.getRestraintType());
        assertSame(RestraintsStatus.A, result.getRestraintsStatus());
    }

    // ST111-TC004：REQ-003-S02 —— 2 条状态 A 记录且查询返回顺序为降序（010 在前），
    // 取首与返回顺序无关，取限制编号升序首条 R202610100009
    @Test
    void testST111T04() {
        stubFindByEoFiltered(List.of(
                restraint("C202610100001", "R202610100010", RestraintType.VALUE_68, RestraintsStatus.A),
                restraint("C202610100001", "R202610100009", RestraintType.VALUE_13, RestraintsStatus.A)));

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100001");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertEquals("R202610100009", result.getResSeqNo());
        assertSame(RestraintType.VALUE_13, result.getRestraintType());
        assertSame(RestraintsStatus.A, result.getRestraintsStatus());
    }

    // ST111-TC005：REQ-002-S01、REQ-004-S02 —— 该客户无任何限制记录，查询结果为空，
    // 三项输出均为空值且不以 "N"／"无"／"0" 等常量占位，执行仍成功
    @Test
    void testST111T05() {
        stubFindByEoFiltered(Collections.emptyList());

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100999");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST111-TC006：REQ-002-S02 —— 该客户存在 2 条记录但状态分别为 E、F（均非 A），
    // 查询结果为空，三字段为空值且不回显任一非 A 记录的取值
    @Test
    void testST111T06() {
        stubFindByEoFiltered(List.of(
                restraint("C202610100002", "R202610100001", RestraintType.VALUE_13, RestraintsStatus.E),
                restraint("C202610100002", "R202610100002", RestraintType.VALUE_22, RestraintsStatus.F)));

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100002");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    // ST111-TC007：REQ-004-S03、REQ-004-S01 —— 单条命中路径执行后核对输出 BO 自身声明的
    // 字段恰为 resSeqNo／restraintType／restraintsStatus 三项且类型与需求输出表一致，
    // StepResult 基础字段由继承提供，不计入本步骤输出字段
    @Test
    void testST111T07() throws Exception {
        stubFindByEoFiltered(List.of(restraint("C202610100001", "R202610100001", RestraintType.VALUE_13, RestraintsStatus.A)));

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100001");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertInstanceOf(ST111OutputBO.class, result);
        assertEquals(Set.of("resSeqNo", "restraintType", "restraintsStatus"),
                Arrays.stream(ST111OutputBO.class.getDeclaredFields())
                        .filter(field -> !field.isSynthetic() && !Modifier.isStatic(field.getModifiers()))
                        .map(Field::getName)
                        .collect(Collectors.toSet()));
        assertSame(String.class, ST111OutputBO.class.getDeclaredField("resSeqNo").getType());
        assertSame(RestraintType.class, ST111OutputBO.class.getDeclaredField("restraintType").getType());
        assertSame(RestraintsStatus.class, ST111OutputBO.class.getDeclaredField("restraintsStatus").getType());
    }

    // ST111-TC008：REQ-005-S02 —— 查询结果为空时子步骤 2 仍返回 [客户限制信息]（非 null 的
    // ST111OutputBO），三字段保持空值且不产生业务失败结论
    @Test
    void testST111T08() {
        stubFindByEoFiltered(Collections.emptyList());

        ST111InputBO bo = new ST111InputBO();
        bo.setClientNo("C202610100999");

        ST111OutputBO result = st111Pbc.execute(bo);

        assertNotNull(result);
        assertInstanceOf(ST111OutputBO.class, result);
        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getResSeqNo());
        assertNull(result.getRestraintType());
        assertNull(result.getRestraintsStatus());
    }

    /**
     * 按入参 EO 过滤的应答式桩：以入参 EO 的 {@code clientNo} 过滤夹具，入参 EO 的
     * {@code restraintsStatus} 非空时再按该状态相等过滤；入参未携带状态条件时返回该客户的
     * 全部记录。桩不写死返回值，也不对实现是「条件下推」还是「取回后过滤」作越界约束。
     */
    private void stubFindByEoFiltered(List<RbClientRestraintsEO> fixtures) {
        Mockito.lenient().when(irRbClientRestraintsBcc.findByEo(any(RbClientRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    RbClientRestraintsEO condition = invocation.getArgument(0);
                    List<RbClientRestraintsEO> matched = new ArrayList<>();
                    for (RbClientRestraintsEO fixture : fixtures) {
                        if (!Objects.equals(condition.getClientNo(), fixture.getClientNo())) {
                            continue;
                        }
                        if (condition.getRestraintsStatus() != null
                                && condition.getRestraintsStatus() != fixture.getRestraintsStatus()) {
                            continue;
                        }
                        matched.add(fixture);
                    }
                    return matched;
                });
    }

    /**
     * 构造【客户限制表】夹具记录（字段取值均在用例中明确，用作业务断言对象）。
     */
    private RbClientRestraintsEO restraint(String clientNo, String resSeqNo,
            RestraintType restraintType, RestraintsStatus restraintsStatus) {
        RbClientRestraintsEO eo = new RbClientRestraintsEO();
        eo.setClientNo(clientNo);
        eo.setResSeqNo(resSeqNo);
        eo.setRestraintType(restraintType);
        eo.setRestraintsStatus(restraintsStatus);
        return eo;
    }
}
