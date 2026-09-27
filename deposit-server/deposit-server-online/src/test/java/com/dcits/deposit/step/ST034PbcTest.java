package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.facade.bo.ST034InputBO;
import com.dcits.deposit.facade.bo.ST034OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST034 设置免费账户标志 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST034-TC001 ~ ST034-TC004）
 *
 * 工程约束：当前 JDK 26 下 Mockito inline mock maker 的 Byte Buddy 仅支持到 Java 24，
 * 无法 mock 具体类 ExternalTaskClient（接口不受影响）；不改 POM，
 * 该依赖用手写桩子类替代 @Mock，其余接口依赖仍用 @Mock。
 */
@ExtendWith(MockitoExtension.class)
public class ST034PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    /** ExternalTaskClient 手写桩：精确匹配 prodNo+attrKey，未命中返回 null，与 Mockito 精确参数桩语义一致 */
    private static final class StubExternalTaskClient extends ExternalTaskClient {

        private final Map<String, String> queryResults = new HashMap<>();

        /** 记录最近一次 queryProductInfo 入参，供断言核对子步骤2参数映射 */
        String lastProdNo;
        String lastAttrKey;

        StubExternalTaskClient() {
            // restTemplate 仅被 queryProductInfo 使用，本桩已覆写该方法，传入 null 不会被触达
            super(null);
        }

        void stubQueryProductInfo(String prodNo, String attrKey, String result) {
            queryResults.put(prodNo + "|" + attrKey, result);
        }

        @Override
        public String queryProductInfo(String prodNo, String attrKey) {
            this.lastProdNo = prodNo;
            this.lastAttrKey = attrKey;
            return queryResults.get(prodNo + "|" + attrKey);
        }
    }

    private StubExternalTaskClient externalTaskClient;

    private ST034Pbc st034Pbc;

    @BeforeEach
    public void setUp() {
        externalTaskClient = new StubExternalTaskClient();
        st034Pbc = new ST034Pbc(rbBusAcctBcc, externalTaskClient);
    }

    /**
     * 构造步骤输入。
     */
    private ST034InputBO buildInput(String clientNo, RbAcctType rbAcctType, String prodNo) {
        ST034InputBO input = new ST034InputBO();
        input.setClientNo(clientNo);
        input.setRbAcctType(rbAcctType);
        input.setProdNo(prodNo);
        return input;
    }

    /**
     * 构造一条结算账户记录。
     */
    private RbBusAcctEO buildSettleAcct(String baseAcctNo, Integer internalKey) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setClientNo("CUST0001");
        eo.setRbAcctType(RbAcctType.C);
        eo.setBaseAcctNo(baseAcctNo);
        eo.setInternalKey(internalKey);
        return eo;
    }

    // ST034-TC001：客户名下无结算账户且产品账户类型为"C-结算账户"，本账户为首个结算账户，预期 succeed=true、managementFreeFlag="是"
    @Test
    public void testST034T01() {
        List<RbBusAcctEO> queryEos = new ArrayList<>();
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            queryEos.add(invocation.getArgument(0));
            return new ArrayList<RbBusAcctEO>();
        });
        externalTaskClient.stubQueryProductInfo("PROD0001", "账户类型", "C");

        ST034OutputBO output = st034Pbc.execute(buildInput("CUST0001", RbAcctType.C, "PROD0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("是", output.getManagementFreeFlag());
        // 核对子步骤1查询条件为客户号+结算账户类型
        RbBusAcctEO queryEo = queryEos.get(0);
        assertEquals("CUST0001", queryEo.getClientNo());
        assertEquals(RbAcctType.C, queryEo.getRbAcctType());
        // 核对子步骤2入参映射：产品编号+参数KEY值"账户类型"
        assertEquals("PROD0001", externalTaskClient.lastProdNo);
        assertEquals("账户类型", externalTaskClient.lastAttrKey);
    }

    // ST034-TC002：客户名下已有1个结算账户，产品账户类型为"C-结算账户"，预期 succeed=true、managementFreeFlag="否"
    @Test
    public void testST034T02() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(List.of(buildSettleAcct("2000200010001", 1001)));
        externalTaskClient.stubQueryProductInfo("PROD0001", "账户类型", "C");

        ST034OutputBO output = st034Pbc.execute(buildInput("CUST0001", RbAcctType.C, "PROD0001"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getManagementFreeFlag());
    }

    // ST034-TC003：结算账户查询结果为空但产品账户类型为"T-定期账户"（不等于C），预期 succeed=true、managementFreeFlag="否"
    @Test
    public void testST034T03() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(new ArrayList<RbBusAcctEO>());
        externalTaskClient.stubQueryProductInfo("PROD0002", "账户类型", "T");

        ST034OutputBO output = st034Pbc.execute(buildInput("CUST0001", RbAcctType.C, "PROD0002"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getManagementFreeFlag());
    }

    // ST034-TC004：客户名下有2个结算账户（客户全部多记录）且产品账户类型为"T-定期账户"，两条件均不成立，预期 succeed=true、managementFreeFlag="否"
    @Test
    public void testST034T04() {
        lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(List.of(buildSettleAcct("2000200010001", 1001),
                        buildSettleAcct("2000200010002", 1002)));
        externalTaskClient.stubQueryProductInfo("PROD0002", "账户类型", "T");

        ST034OutputBO output = st034Pbc.execute(buildInput("CUST0001", RbAcctType.C, "PROD0002"));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("否", output.getManagementFreeFlag());
    }
}
