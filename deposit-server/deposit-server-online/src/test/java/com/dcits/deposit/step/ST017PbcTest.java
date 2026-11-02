package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.facade.bo.ST017InputBO;
import com.dcits.deposit.facade.bo.ST017OutputBO;

/**
 * ST017 检查币种一致性 步骤实现单元测试。
 *
 * <p>用例来源：正式 Spec ST017 与测试用例文档（ST017-TC001～ST017-TC004）。本步骤无子步骤、
 * 无 BCC/规则/组件客户端依赖，不需要构造依赖桩。必填输入缺失（Spec 待确认事项 1）与
 * 「通过」结果的字面业务值表达（Spec 待确认事项 2）不作为本套用例断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST017PbcTest {

    @InjectMocks
    private ST017Pbc st017Pbc;

    // 场景：REQ-001-S01（ST017-TC001），交易币种 Ccy.CNY 与账户币种 AcctCcy.CNY 货币代码一致，检查结果「通过」
    @Test
    void testST017T01() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.CNY);
        input.setAcctCcy(AcctCcy.CNY);

        ST017OutputBO result = st017Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景：REQ-002-S01（ST017-TC002），交易币种 Ccy.CNY 与账户币种 AcctCcy.USD 货币代码不一致，返回错误码 ER0051，不返回检查结果「通过」
    @Test
    void testST017T02() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.CNY);
        input.setAcctCcy(AcctCcy.USD);

        ST017OutputBO result = st017Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0051", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0051::"));
        assertTrue(result.getErrorMessage().contains("交易币种与账户币种不一致"));
    }

    // 场景：ST017-TC003 人工补充，交易币种 Ccy.USD 与账户币种 AcctCcy.USD 货币代码一致，检查结果「通过」（验证一致判定与具体币种无关）
    @Test
    void testST017T03() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.USD);
        input.setAcctCcy(AcctCcy.USD);

        ST017OutputBO result = st017Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景：ST017-TC004 人工补充，交易币种 Ccy.USD 与账户币种 AcctCcy.CNY 货币代码不一致，返回错误码 ER0051（反向样本，验证失败判定由代码不等触发）
    @Test
    void testST017T04() {
        ST017InputBO input = new ST017InputBO();
        input.setTranCcy(Ccy.USD);
        input.setAcctCcy(AcctCcy.CNY);

        ST017OutputBO result = st017Pbc.execute(input);

        assertFalse(result.isSucceed());
        assertEquals("ER0051", result.getErrorCode());
        assertNotNull(result.getErrorMessage());
        assertTrue(result.getErrorMessage().startsWith("ER0051::"));
        assertTrue(result.getErrorMessage().contains("交易币种与账户币种不一致"));
    }
}
