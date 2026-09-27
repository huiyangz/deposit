package com.dcits.deposit.step;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.facade.bo.ST034InputBO;
import com.dcits.deposit.facade.bo.ST034OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST034 设置免费账户标志
 *
 * <p>1.获取客户的结算账户：根据{客户号}且账户类型等于"C-结算账户"查询【账户信息】，
 * 获取客户全部的[结算账户信息列表]；
 * 2.获取产品的账户类型：根据{产品编号}、参数KEY值"账户类型"访问业务组件《产品管理》
 * 的业务功能《查询产品信息》，获取$账户类型$；
 * 3.设置免收费标志：[结算账户信息列表]为空且$账户类型$等于"C-结算账户"时设为"是"，
 * 否则设为"否"。
 *
 * <p>本步骤无业务失败场景，失败仅由技术异常传播表达。
 */
@Service
public class ST034Pbc implements IST034 {

    private static final Logger logger = LoggerFactory.getLogger(ST034Pbc.class);

    /** 产品管理《查询产品信息》的参数KEY值：账户类型 */
    private static final String ATTR_KEY_ACCT_TYPE = "账户类型";

    /** 免收费标志取值：是 */
    private static final String FREE_FLAG_YES = "是";

    /** 免收费标志取值：否 */
    private static final String FREE_FLAG_NO = "否";

    private final IRbBusAcctBcc rbBusAcctBcc;

    private final ExternalTaskClient externalTaskClient;

    public ST034Pbc(IRbBusAcctBcc rbBusAcctBcc, ExternalTaskClient externalTaskClient) {
        this.rbBusAcctBcc = rbBusAcctBcc;
        this.externalTaskClient = externalTaskClient;
    }

    @Override
    public ST034OutputBO execute(ST034InputBO input) {
        // 子步骤1 获取客户的结算账户：按{客户号}且账户类型等于"C-结算账户"查询【账户信息】
        RbBusAcctEO queryEo = new RbBusAcctEO();
        queryEo.setClientNo(input.getClientNo());
        queryEo.setRbAcctType(RbAcctType.C);
        List<RbBusAcctEO> settleAcctList = rbBusAcctBcc.findByEo(queryEo);

        // 子步骤2 获取产品的账户类型：按{产品编号}、参数KEY值"账户类型"调用产品管理《查询产品信息》
        String prodAcctType = externalTaskClient.queryProductInfo(input.getProdNo(), ATTR_KEY_ACCT_TYPE);

        // 子步骤3 设置免收费标志：结算账户列表为空且产品账户类型等于"C-结算账户" → 是；否则 → 否
        ST034OutputBO output = new ST034OutputBO();
        boolean noSettleAcct = settleAcctList == null || settleAcctList.isEmpty();
        if (noSettleAcct && RbAcctType.C.getValue().equals(prodAcctType)) {
            output.setManagementFreeFlag(FREE_FLAG_YES);
        } else {
            output.setManagementFreeFlag(FREE_FLAG_NO);
        }
        logger.debug("ST034 clientNo={}, prodNo={}, settleAcctCount={}, prodAcctType={}, managementFreeFlag={}",
                input.getClientNo(), input.getProdNo(),
                settleAcctList == null ? 0 : settleAcctList.size(), prodAcctType, output.getManagementFreeFlag());
        output.setSucceed(true);
        return output;
    }
}
